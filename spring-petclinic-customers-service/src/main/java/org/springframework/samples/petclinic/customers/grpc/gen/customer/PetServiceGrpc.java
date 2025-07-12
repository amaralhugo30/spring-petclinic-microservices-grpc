package org.springframework.samples.petclinic.customers.grpc.gen.customer;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.73.0)",
    comments = "Source: customer/Pet.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class PetServiceGrpc {

  private PetServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "petclinic.customers.PetService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetPetTypesResponse> getGetPetTypesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPetTypes",
      requestType = com.google.protobuf.Empty.class,
      responseType = org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetPetTypesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetPetTypesResponse> getGetPetTypesMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetPetTypesResponse> getGetPetTypesMethod;
    if ((getGetPetTypesMethod = PetServiceGrpc.getGetPetTypesMethod) == null) {
      synchronized (PetServiceGrpc.class) {
        if ((getGetPetTypesMethod = PetServiceGrpc.getGetPetTypesMethod) == null) {
          PetServiceGrpc.getGetPetTypesMethod = getGetPetTypesMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetPetTypesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetPetTypes"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetPetTypesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PetServiceMethodDescriptorSupplier("GetPetTypes"))
              .build();
        }
      }
    }
    return getGetPetTypesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreatePetRequest,
      org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreatePetResponse> getCreatePetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreatePet",
      requestType = org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreatePetRequest.class,
      responseType = org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreatePetResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreatePetRequest,
      org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreatePetResponse> getCreatePetMethod() {
    io.grpc.MethodDescriptor<org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreatePetRequest, org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreatePetResponse> getCreatePetMethod;
    if ((getCreatePetMethod = PetServiceGrpc.getCreatePetMethod) == null) {
      synchronized (PetServiceGrpc.class) {
        if ((getCreatePetMethod = PetServiceGrpc.getCreatePetMethod) == null) {
          PetServiceGrpc.getCreatePetMethod = getCreatePetMethod =
              io.grpc.MethodDescriptor.<org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreatePetRequest, org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreatePetResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreatePet"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreatePetRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreatePetResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PetServiceMethodDescriptorSupplier("CreatePet"))
              .build();
        }
      }
    }
    return getCreatePetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.springframework.samples.petclinic.customers.grpc.gen.customer.types.UpdatePetRequest,
      org.springframework.samples.petclinic.customers.grpc.gen.customer.types.UpdatePetResponse> getUpdatePetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdatePet",
      requestType = org.springframework.samples.petclinic.customers.grpc.gen.customer.types.UpdatePetRequest.class,
      responseType = org.springframework.samples.petclinic.customers.grpc.gen.customer.types.UpdatePetResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.springframework.samples.petclinic.customers.grpc.gen.customer.types.UpdatePetRequest,
      org.springframework.samples.petclinic.customers.grpc.gen.customer.types.UpdatePetResponse> getUpdatePetMethod() {
    io.grpc.MethodDescriptor<org.springframework.samples.petclinic.customers.grpc.gen.customer.types.UpdatePetRequest, org.springframework.samples.petclinic.customers.grpc.gen.customer.types.UpdatePetResponse> getUpdatePetMethod;
    if ((getUpdatePetMethod = PetServiceGrpc.getUpdatePetMethod) == null) {
      synchronized (PetServiceGrpc.class) {
        if ((getUpdatePetMethod = PetServiceGrpc.getUpdatePetMethod) == null) {
          PetServiceGrpc.getUpdatePetMethod = getUpdatePetMethod =
              io.grpc.MethodDescriptor.<org.springframework.samples.petclinic.customers.grpc.gen.customer.types.UpdatePetRequest, org.springframework.samples.petclinic.customers.grpc.gen.customer.types.UpdatePetResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdatePet"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.springframework.samples.petclinic.customers.grpc.gen.customer.types.UpdatePetRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.springframework.samples.petclinic.customers.grpc.gen.customer.types.UpdatePetResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PetServiceMethodDescriptorSupplier("UpdatePet"))
              .build();
        }
      }
    }
    return getUpdatePetMethod;
  }

  private static volatile io.grpc.MethodDescriptor<org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetPetRequest,
      org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetPetResponse> getGetPetMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPet",
      requestType = org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetPetRequest.class,
      responseType = org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetPetResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetPetRequest,
      org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetPetResponse> getGetPetMethod() {
    io.grpc.MethodDescriptor<org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetPetRequest, org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetPetResponse> getGetPetMethod;
    if ((getGetPetMethod = PetServiceGrpc.getGetPetMethod) == null) {
      synchronized (PetServiceGrpc.class) {
        if ((getGetPetMethod = PetServiceGrpc.getGetPetMethod) == null) {
          PetServiceGrpc.getGetPetMethod = getGetPetMethod =
              io.grpc.MethodDescriptor.<org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetPetRequest, org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetPetResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetPet"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetPetRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetPetResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PetServiceMethodDescriptorSupplier("GetPet"))
              .build();
        }
      }
    }
    return getGetPetMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PetServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PetServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PetServiceStub>() {
        @java.lang.Override
        public PetServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PetServiceStub(channel, callOptions);
        }
      };
    return PetServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports all types of calls on the service
   */
  public static PetServiceBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PetServiceBlockingV2Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PetServiceBlockingV2Stub>() {
        @java.lang.Override
        public PetServiceBlockingV2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PetServiceBlockingV2Stub(channel, callOptions);
        }
      };
    return PetServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PetServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PetServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PetServiceBlockingStub>() {
        @java.lang.Override
        public PetServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PetServiceBlockingStub(channel, callOptions);
        }
      };
    return PetServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PetServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PetServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PetServiceFutureStub>() {
        @java.lang.Override
        public PetServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PetServiceFutureStub(channel, callOptions);
        }
      };
    return PetServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void getPetTypes(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetPetTypesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetPetTypesMethod(), responseObserver);
    }

    /**
     */
    default void createPet(org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreatePetRequest request,
        io.grpc.stub.StreamObserver<org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreatePetResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreatePetMethod(), responseObserver);
    }

    /**
     */
    default void updatePet(org.springframework.samples.petclinic.customers.grpc.gen.customer.types.UpdatePetRequest request,
        io.grpc.stub.StreamObserver<org.springframework.samples.petclinic.customers.grpc.gen.customer.types.UpdatePetResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdatePetMethod(), responseObserver);
    }

    /**
     */
    default void getPet(org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetPetRequest request,
        io.grpc.stub.StreamObserver<org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetPetResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetPetMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service PetService.
   */
  public static abstract class PetServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return PetServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service PetService.
   */
  public static final class PetServiceStub
      extends io.grpc.stub.AbstractAsyncStub<PetServiceStub> {
    private PetServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PetServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PetServiceStub(channel, callOptions);
    }

    /**
     */
    public void getPetTypes(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetPetTypesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPetTypesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void createPet(org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreatePetRequest request,
        io.grpc.stub.StreamObserver<org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreatePetResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreatePetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updatePet(org.springframework.samples.petclinic.customers.grpc.gen.customer.types.UpdatePetRequest request,
        io.grpc.stub.StreamObserver<org.springframework.samples.petclinic.customers.grpc.gen.customer.types.UpdatePetResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdatePetMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getPet(org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetPetRequest request,
        io.grpc.stub.StreamObserver<org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetPetResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPetMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service PetService.
   */
  public static final class PetServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<PetServiceBlockingV2Stub> {
    private PetServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PetServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PetServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     */
    public org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetPetTypesResponse getPetTypes(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPetTypesMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreatePetResponse createPet(org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreatePetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreatePetMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.springframework.samples.petclinic.customers.grpc.gen.customer.types.UpdatePetResponse updatePet(org.springframework.samples.petclinic.customers.grpc.gen.customer.types.UpdatePetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdatePetMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetPetResponse getPet(org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetPetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPetMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service PetService.
   */
  public static final class PetServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<PetServiceBlockingStub> {
    private PetServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PetServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PetServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetPetTypesResponse getPetTypes(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPetTypesMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreatePetResponse createPet(org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreatePetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreatePetMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.springframework.samples.petclinic.customers.grpc.gen.customer.types.UpdatePetResponse updatePet(org.springframework.samples.petclinic.customers.grpc.gen.customer.types.UpdatePetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdatePetMethod(), getCallOptions(), request);
    }

    /**
     */
    public org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetPetResponse getPet(org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetPetRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPetMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service PetService.
   */
  public static final class PetServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<PetServiceFutureStub> {
    private PetServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PetServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PetServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetPetTypesResponse> getPetTypes(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPetTypesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreatePetResponse> createPet(
        org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreatePetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreatePetMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.springframework.samples.petclinic.customers.grpc.gen.customer.types.UpdatePetResponse> updatePet(
        org.springframework.samples.petclinic.customers.grpc.gen.customer.types.UpdatePetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdatePetMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetPetResponse> getPet(
        org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetPetRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPetMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_PET_TYPES = 0;
  private static final int METHODID_CREATE_PET = 1;
  private static final int METHODID_UPDATE_PET = 2;
  private static final int METHODID_GET_PET = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_PET_TYPES:
          serviceImpl.getPetTypes((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetPetTypesResponse>) responseObserver);
          break;
        case METHODID_CREATE_PET:
          serviceImpl.createPet((org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreatePetRequest) request,
              (io.grpc.stub.StreamObserver<org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreatePetResponse>) responseObserver);
          break;
        case METHODID_UPDATE_PET:
          serviceImpl.updatePet((org.springframework.samples.petclinic.customers.grpc.gen.customer.types.UpdatePetRequest) request,
              (io.grpc.stub.StreamObserver<org.springframework.samples.petclinic.customers.grpc.gen.customer.types.UpdatePetResponse>) responseObserver);
          break;
        case METHODID_GET_PET:
          serviceImpl.getPet((org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetPetRequest) request,
              (io.grpc.stub.StreamObserver<org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetPetResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getGetPetTypesMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.protobuf.Empty,
              org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetPetTypesResponse>(
                service, METHODID_GET_PET_TYPES)))
        .addMethod(
          getCreatePetMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreatePetRequest,
              org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreatePetResponse>(
                service, METHODID_CREATE_PET)))
        .addMethod(
          getUpdatePetMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              org.springframework.samples.petclinic.customers.grpc.gen.customer.types.UpdatePetRequest,
              org.springframework.samples.petclinic.customers.grpc.gen.customer.types.UpdatePetResponse>(
                service, METHODID_UPDATE_PET)))
        .addMethod(
          getGetPetMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetPetRequest,
              org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetPetResponse>(
                service, METHODID_GET_PET)))
        .build();
  }

  private static abstract class PetServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PetServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.springframework.samples.petclinic.customers.grpc.gen.customer.PetServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PetService");
    }
  }

  private static final class PetServiceFileDescriptorSupplier
      extends PetServiceBaseDescriptorSupplier {
    PetServiceFileDescriptorSupplier() {}
  }

  private static final class PetServiceMethodDescriptorSupplier
      extends PetServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    PetServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (PetServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PetServiceFileDescriptorSupplier())
              .addMethod(getGetPetTypesMethod())
              .addMethod(getCreatePetMethod())
              .addMethod(getUpdatePetMethod())
              .addMethod(getGetPetMethod())
              .build();
        }
      }
    }
    return result;
  }
}
