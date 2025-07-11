package org.springframework.samples.petclinic.customers.grpc.gen.owner;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Owner service definition
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.73.0)",
    comments = "Source: customer/Owner.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class OwnerServiceGrpc {

  private OwnerServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "petclinic.customers.OwnerService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<OwnerRequest,
          OwnerResponse> getCreateOwnerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateOwner",
      requestType = OwnerRequest.class,
      responseType = OwnerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<OwnerRequest,
          OwnerResponse> getCreateOwnerMethod() {
    io.grpc.MethodDescriptor<OwnerRequest, OwnerResponse> getCreateOwnerMethod;
    if ((getCreateOwnerMethod = OwnerServiceGrpc.getCreateOwnerMethod) == null) {
      synchronized (OwnerServiceGrpc.class) {
        if ((getCreateOwnerMethod = OwnerServiceGrpc.getCreateOwnerMethod) == null) {
          OwnerServiceGrpc.getCreateOwnerMethod = getCreateOwnerMethod =
              io.grpc.MethodDescriptor.<OwnerRequest, OwnerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateOwner"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  OwnerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  OwnerResponse.getDefaultInstance()))
              .setSchemaDescriptor(new OwnerServiceMethodDescriptorSupplier("CreateOwner"))
              .build();
        }
      }
    }
    return getCreateOwnerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<GetOwnerRequest,
          OwnerResponse> getGetOwnerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetOwner",
      requestType = GetOwnerRequest.class,
      responseType = OwnerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<GetOwnerRequest,
          OwnerResponse> getGetOwnerMethod() {
    io.grpc.MethodDescriptor<GetOwnerRequest, OwnerResponse> getGetOwnerMethod;
    if ((getGetOwnerMethod = OwnerServiceGrpc.getGetOwnerMethod) == null) {
      synchronized (OwnerServiceGrpc.class) {
        if ((getGetOwnerMethod = OwnerServiceGrpc.getGetOwnerMethod) == null) {
          OwnerServiceGrpc.getGetOwnerMethod = getGetOwnerMethod =
              io.grpc.MethodDescriptor.<GetOwnerRequest, OwnerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetOwner"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  GetOwnerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  OwnerResponse.getDefaultInstance()))
              .setSchemaDescriptor(new OwnerServiceMethodDescriptorSupplier("GetOwner"))
              .build();
        }
      }
    }
    return getGetOwnerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
          OwnersListResponse> getListOwnersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListOwners",
      requestType = com.google.protobuf.Empty.class,
      responseType = OwnersListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
          OwnersListResponse> getListOwnersMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, OwnersListResponse> getListOwnersMethod;
    if ((getListOwnersMethod = OwnerServiceGrpc.getListOwnersMethod) == null) {
      synchronized (OwnerServiceGrpc.class) {
        if ((getListOwnersMethod = OwnerServiceGrpc.getListOwnersMethod) == null) {
          OwnerServiceGrpc.getListOwnersMethod = getListOwnersMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, OwnersListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListOwners"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  OwnersListResponse.getDefaultInstance()))
              .setSchemaDescriptor(new OwnerServiceMethodDescriptorSupplier("ListOwners"))
              .build();
        }
      }
    }
    return getListOwnersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<UpdateOwnerRequest,
          UpdateOwnerResponse> getUpdateOwnerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateOwner",
      requestType = UpdateOwnerRequest.class,
      responseType = UpdateOwnerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<UpdateOwnerRequest,
          UpdateOwnerResponse> getUpdateOwnerMethod() {
    io.grpc.MethodDescriptor<UpdateOwnerRequest, UpdateOwnerResponse> getUpdateOwnerMethod;
    if ((getUpdateOwnerMethod = OwnerServiceGrpc.getUpdateOwnerMethod) == null) {
      synchronized (OwnerServiceGrpc.class) {
        if ((getUpdateOwnerMethod = OwnerServiceGrpc.getUpdateOwnerMethod) == null) {
          OwnerServiceGrpc.getUpdateOwnerMethod = getUpdateOwnerMethod =
              io.grpc.MethodDescriptor.<UpdateOwnerRequest, UpdateOwnerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateOwner"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  UpdateOwnerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  UpdateOwnerResponse.getDefaultInstance()))
              .setSchemaDescriptor(new OwnerServiceMethodDescriptorSupplier("UpdateOwner"))
              .build();
        }
      }
    }
    return getUpdateOwnerMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static OwnerServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OwnerServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<OwnerServiceStub>() {
        @java.lang.Override
        public OwnerServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new OwnerServiceStub(channel, callOptions);
        }
      };
    return OwnerServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports all types of calls on the service
   */
  public static OwnerServiceBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OwnerServiceBlockingV2Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<OwnerServiceBlockingV2Stub>() {
        @java.lang.Override
        public OwnerServiceBlockingV2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new OwnerServiceBlockingV2Stub(channel, callOptions);
        }
      };
    return OwnerServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static OwnerServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OwnerServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<OwnerServiceBlockingStub>() {
        @java.lang.Override
        public OwnerServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new OwnerServiceBlockingStub(channel, callOptions);
        }
      };
    return OwnerServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static OwnerServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<OwnerServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<OwnerServiceFutureStub>() {
        @java.lang.Override
        public OwnerServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new OwnerServiceFutureStub(channel, callOptions);
        }
      };
    return OwnerServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Owner service definition
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * Create Owner
     * Maps to: POST /owners
     * </pre>
     */
    default void createOwner(OwnerRequest request,
                             io.grpc.stub.StreamObserver<OwnerResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateOwnerMethod(), responseObserver);
    }

    /**
     * <pre>
     * Get Owner by ID
     * Maps to: GET /owners/{ownerId}
     * </pre>
     */
    default void getOwner(GetOwnerRequest request,
                          io.grpc.stub.StreamObserver<OwnerResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetOwnerMethod(), responseObserver);
    }

    /**
     * <pre>
     * List all Owners
     * Maps to: GET /owners
     * </pre>
     */
    default void listOwners(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<OwnersListResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListOwnersMethod(), responseObserver);
    }

    /**
     * <pre>
     * Update Owner
     * Maps to: PUT /owners/{ownerId}
     * </pre>
     */
    default void updateOwner(UpdateOwnerRequest request,
                             io.grpc.stub.StreamObserver<UpdateOwnerResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateOwnerMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service OwnerService.
   * <pre>
   * Owner service definition
   * </pre>
   */
  public static abstract class OwnerServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return OwnerServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service OwnerService.
   * <pre>
   * Owner service definition
   * </pre>
   */
  public static final class OwnerServiceStub
      extends io.grpc.stub.AbstractAsyncStub<OwnerServiceStub> {
    private OwnerServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OwnerServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OwnerServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Create Owner
     * Maps to: POST /owners
     * </pre>
     */
    public void createOwner(OwnerRequest request,
                            io.grpc.stub.StreamObserver<OwnerResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateOwnerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get Owner by ID
     * Maps to: GET /owners/{ownerId}
     * </pre>
     */
    public void getOwner(GetOwnerRequest request,
                         io.grpc.stub.StreamObserver<OwnerResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetOwnerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * List all Owners
     * Maps to: GET /owners
     * </pre>
     */
    public void listOwners(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<OwnersListResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListOwnersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Update Owner
     * Maps to: PUT /owners/{ownerId}
     * </pre>
     */
    public void updateOwner(UpdateOwnerRequest request,
                            io.grpc.stub.StreamObserver<UpdateOwnerResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateOwnerMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service OwnerService.
   * <pre>
   * Owner service definition
   * </pre>
   */
  public static final class OwnerServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<OwnerServiceBlockingV2Stub> {
    private OwnerServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OwnerServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OwnerServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     * <pre>
     * Create Owner
     * Maps to: POST /owners
     * </pre>
     */
    public OwnerResponse createOwner(OwnerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateOwnerMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get Owner by ID
     * Maps to: GET /owners/{ownerId}
     * </pre>
     */
    public OwnerResponse getOwner(GetOwnerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetOwnerMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * List all Owners
     * Maps to: GET /owners
     * </pre>
     */
    public OwnersListResponse listOwners(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListOwnersMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Update Owner
     * Maps to: PUT /owners/{ownerId}
     * </pre>
     */
    public UpdateOwnerResponse updateOwner(UpdateOwnerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateOwnerMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service OwnerService.
   * <pre>
   * Owner service definition
   * </pre>
   */
  public static final class OwnerServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<OwnerServiceBlockingStub> {
    private OwnerServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OwnerServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OwnerServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Create Owner
     * Maps to: POST /owners
     * </pre>
     */
    public OwnerResponse createOwner(OwnerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateOwnerMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get Owner by ID
     * Maps to: GET /owners/{ownerId}
     * </pre>
     */
    public OwnerResponse getOwner(GetOwnerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetOwnerMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * List all Owners
     * Maps to: GET /owners
     * </pre>
     */
    public OwnersListResponse listOwners(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListOwnersMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Update Owner
     * Maps to: PUT /owners/{ownerId}
     * </pre>
     */
    public UpdateOwnerResponse updateOwner(UpdateOwnerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateOwnerMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service OwnerService.
   * <pre>
   * Owner service definition
   * </pre>
   */
  public static final class OwnerServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<OwnerServiceFutureStub> {
    private OwnerServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OwnerServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new OwnerServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Create Owner
     * Maps to: POST /owners
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<OwnerResponse> createOwner(
        OwnerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateOwnerMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Get Owner by ID
     * Maps to: GET /owners/{ownerId}
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<OwnerResponse> getOwner(
        GetOwnerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetOwnerMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * List all Owners
     * Maps to: GET /owners
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<OwnersListResponse> listOwners(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListOwnersMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Update Owner
     * Maps to: PUT /owners/{ownerId}
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<UpdateOwnerResponse> updateOwner(
        UpdateOwnerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateOwnerMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_OWNER = 0;
  private static final int METHODID_GET_OWNER = 1;
  private static final int METHODID_LIST_OWNERS = 2;
  private static final int METHODID_UPDATE_OWNER = 3;

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
        case METHODID_CREATE_OWNER:
          serviceImpl.createOwner((OwnerRequest) request,
              (io.grpc.stub.StreamObserver<OwnerResponse>) responseObserver);
          break;
        case METHODID_GET_OWNER:
          serviceImpl.getOwner((GetOwnerRequest) request,
              (io.grpc.stub.StreamObserver<OwnerResponse>) responseObserver);
          break;
        case METHODID_LIST_OWNERS:
          serviceImpl.listOwners((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<OwnersListResponse>) responseObserver);
          break;
        case METHODID_UPDATE_OWNER:
          serviceImpl.updateOwner((UpdateOwnerRequest) request,
              (io.grpc.stub.StreamObserver<UpdateOwnerResponse>) responseObserver);
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
          getCreateOwnerMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
                    OwnerRequest,
                    OwnerResponse>(
                service, METHODID_CREATE_OWNER)))
        .addMethod(
          getGetOwnerMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
                    GetOwnerRequest,
                    OwnerResponse>(
                service, METHODID_GET_OWNER)))
        .addMethod(
          getListOwnersMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.google.protobuf.Empty,
                    OwnersListResponse>(
                service, METHODID_LIST_OWNERS)))
        .addMethod(
          getUpdateOwnerMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
                    UpdateOwnerRequest,
                    UpdateOwnerResponse>(
                service, METHODID_UPDATE_OWNER)))
        .build();
  }

  private static abstract class OwnerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    OwnerServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return OwnerServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("OwnerService");
    }
  }

  private static final class OwnerServiceFileDescriptorSupplier
      extends OwnerServiceBaseDescriptorSupplier {
    OwnerServiceFileDescriptorSupplier() {}
  }

  private static final class OwnerServiceMethodDescriptorSupplier
      extends OwnerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    OwnerServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (OwnerServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new OwnerServiceFileDescriptorSupplier())
              .addMethod(getCreateOwnerMethod())
              .addMethod(getGetOwnerMethod())
              .addMethod(getListOwnersMethod())
              .addMethod(getUpdateOwnerMethod())
              .build();
        }
      }
    }
    return result;
  }
}
