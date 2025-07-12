package main

import (
	"context"
	"encoding/json"
	"log"
	"net/http"
	"os"

	"github.com/grpc-ecosystem/grpc-gateway/v2/runtime"
	"google.golang.org/grpc"

	customerGw "petclinic/grpcgateway/gen/proto/customer"
)

type Config struct {
	Gateway struct {
		Port string `json:"port"`
	} `json:"gateway"`
	GrpcServices struct {
		Customer string `json:"customer"`
	} `json:"grpcServices"`
}

func loadConfig(filename string) (*Config, error) {
	data, err := os.ReadFile(filename)
	if err != nil {
		return nil, err
	}

	var config Config
	err = json.Unmarshal(data, &config)
	if err != nil {
		return nil, err
	}

	return &config, nil
}

func main() {
	// Load configuration
	config, err := loadConfig("config.json")
	if err != nil {
		log.Fatalf("Failed to load config: %v", err)
	}

	ctx := context.Background()
	ctx, cancel := context.WithCancel(ctx)
	defer cancel()

	mux := runtime.NewServeMux()

	// Register Services
	err = customerGw.RegisterOwnerServiceHandlerFromEndpoint(ctx, mux, config.GrpcServices.Customer, []grpc.DialOption{grpc.WithInsecure()})
	if err != nil {
		log.Fatalf("Failed to register Owner service: %v", err)
	}

	err = customerGw.RegisterPetServiceHandlerFromEndpoint(ctx, mux, config.GrpcServices.Customer, []grpc.DialOption{grpc.WithInsecure()})
	if err != nil {
		log.Fatalf("Failed to register Pet service: %v", err)
	}

	log.Printf("HTTP Gateway listening on %s, forwarding to Spring Customer gRPC service on %s", config.Gateway.Port, config.GrpcServices.Customer)
	log.Fatal(http.ListenAndServe(config.Gateway.Port, mux))
}
