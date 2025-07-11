package main

import (
	"context"
	"log"
	"net/http"

	"github.com/grpc-ecosystem/grpc-gateway/v2/runtime"
	"google.golang.org/grpc"

	ownerGw "petclinic/grpcgateway/gen/proto/customer"
)

func main() {
	ctx := context.Background()
	ctx, cancel := context.WithCancel(ctx)
	defer cancel()

	mux := runtime.NewServeMux()

	err := ownerGw.RegisterOwnerServiceHandlerFromEndpoint(ctx, mux, "localhost:1001", []grpc.DialOption{grpc.WithInsecure()})
	if err != nil {
		log.Fatalf("Failed to start gateway: %v", err)
	}
	log.Println("HTTP Gateway listening on :1000, forwarding to Spring gRPC service on :1001")
	log.Fatal(http.ListenAndServe(":1000", mux))
}
