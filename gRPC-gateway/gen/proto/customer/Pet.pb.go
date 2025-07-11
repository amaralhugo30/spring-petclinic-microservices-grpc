// Code generated by protoc-gen-go. DO NOT EDIT.
// versions:
// 	protoc-gen-go v1.36.6
// 	protoc        v5.29.3
// source: customer/Pet.proto

package customer

import (
	_ "google.golang.org/genproto/googleapis/api/annotations"
	protoreflect "google.golang.org/protobuf/reflect/protoreflect"
	protoimpl "google.golang.org/protobuf/runtime/protoimpl"
	emptypb "google.golang.org/protobuf/types/known/emptypb"
	reflect "reflect"
	unsafe "unsafe"
)

const (
	// Verify that this generated code is sufficiently up-to-date.
	_ = protoimpl.EnforceVersion(20 - protoimpl.MinVersion)
	// Verify that runtime/protoimpl is sufficiently up-to-date.
	_ = protoimpl.EnforceVersion(protoimpl.MaxVersion - 20)
)

var File_customer_Pet_proto protoreflect.FileDescriptor

const file_customer_Pet_proto_rawDesc = "" +
	"\n" +
	"\x12customer/Pet.proto\x12\x13petclinic.customers\x1a\x1bgoogle/protobuf/empty.proto\x1a\x1cgoogle/api/annotations.proto\x1a\x14customer/Types.proto2\xe4\x03\n" +
	"\n" +
	"PetService\x12b\n" +
	"\vGetPetTypes\x12\x16.google.protobuf.Empty\x1a(.petclinic.customers.GetPetTypesResponse\"\x11\x82\xd3\xe4\x93\x02\v\x12\t/petTypes\x12~\n" +
	"\tCreatePet\x12%.petclinic.customers.CreatePetRequest\x1a&.petclinic.customers.CreatePetResponse\"\"\x82\xd3\xe4\x93\x02\x1c:\x01*\"\x17/owners/{owner_id}/pets\x12~\n" +
	"\tUpdatePet\x12%.petclinic.customers.UpdatePetRequest\x1a&.petclinic.customers.UpdatePetResponse\"\"\x82\xd3\xe4\x93\x02\x1c:\x01*\x1a\x17/owners/*/pets/{pet_id}\x12r\n" +
	"\x06GetPet\x12\".petclinic.customers.GetPetRequest\x1a#.petclinic.customers.GetPetResponse\"\x1f\x82\xd3\xe4\x93\x02\x19\x12\x17/owners/*/pets/{pet_id}B\x80\x01\n" +
	"Aorg.springframework.samples.petclinic.customers.grpc.gen.customerB\x0fPetServiceProtoP\x01Z(petclinic/grpcgateway/gen/proto/customerb\x06proto3"

var file_customer_Pet_proto_goTypes = []any{
	(*emptypb.Empty)(nil),       // 0: google.protobuf.Empty
	(*CreatePetRequest)(nil),    // 1: petclinic.customers.CreatePetRequest
	(*UpdatePetRequest)(nil),    // 2: petclinic.customers.UpdatePetRequest
	(*GetPetRequest)(nil),       // 3: petclinic.customers.GetPetRequest
	(*GetPetTypesResponse)(nil), // 4: petclinic.customers.GetPetTypesResponse
	(*CreatePetResponse)(nil),   // 5: petclinic.customers.CreatePetResponse
	(*UpdatePetResponse)(nil),   // 6: petclinic.customers.UpdatePetResponse
	(*GetPetResponse)(nil),      // 7: petclinic.customers.GetPetResponse
}
var file_customer_Pet_proto_depIdxs = []int32{
	0, // 0: petclinic.customers.PetService.GetPetTypes:input_type -> google.protobuf.Empty
	1, // 1: petclinic.customers.PetService.CreatePet:input_type -> petclinic.customers.CreatePetRequest
	2, // 2: petclinic.customers.PetService.UpdatePet:input_type -> petclinic.customers.UpdatePetRequest
	3, // 3: petclinic.customers.PetService.GetPet:input_type -> petclinic.customers.GetPetRequest
	4, // 4: petclinic.customers.PetService.GetPetTypes:output_type -> petclinic.customers.GetPetTypesResponse
	5, // 5: petclinic.customers.PetService.CreatePet:output_type -> petclinic.customers.CreatePetResponse
	6, // 6: petclinic.customers.PetService.UpdatePet:output_type -> petclinic.customers.UpdatePetResponse
	7, // 7: petclinic.customers.PetService.GetPet:output_type -> petclinic.customers.GetPetResponse
	4, // [4:8] is the sub-list for method output_type
	0, // [0:4] is the sub-list for method input_type
	0, // [0:0] is the sub-list for extension type_name
	0, // [0:0] is the sub-list for extension extendee
	0, // [0:0] is the sub-list for field type_name
}

func init() { file_customer_Pet_proto_init() }
func file_customer_Pet_proto_init() {
	if File_customer_Pet_proto != nil {
		return
	}
	file_customer_Types_proto_init()
	type x struct{}
	out := protoimpl.TypeBuilder{
		File: protoimpl.DescBuilder{
			GoPackagePath: reflect.TypeOf(x{}).PkgPath(),
			RawDescriptor: unsafe.Slice(unsafe.StringData(file_customer_Pet_proto_rawDesc), len(file_customer_Pet_proto_rawDesc)),
			NumEnums:      0,
			NumMessages:   0,
			NumExtensions: 0,
			NumServices:   1,
		},
		GoTypes:           file_customer_Pet_proto_goTypes,
		DependencyIndexes: file_customer_Pet_proto_depIdxs,
	}.Build()
	File_customer_Pet_proto = out.File
	file_customer_Pet_proto_goTypes = nil
	file_customer_Pet_proto_depIdxs = nil
}
