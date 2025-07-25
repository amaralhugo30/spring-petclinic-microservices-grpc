// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: customer/Types.proto
// Protobuf Java Version: 4.29.3

package org.springframework.samples.petclinic.customers.grpc.gen.customer.types;

/**
 * Protobuf type {@code petclinic.customers.CreatePetResponse}
 */
public final class CreatePetResponse extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:petclinic.customers.CreatePetResponse)
    CreatePetResponseOrBuilder {
private static final long serialVersionUID = 0L;
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 29,
      /* patch= */ 3,
      /* suffix= */ "",
      CreatePetResponse.class.getName());
  }
  // Use CreatePetResponse.newBuilder() to construct.
  private CreatePetResponse(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private CreatePetResponse() {
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CustomerTypesProto.internal_static_petclinic_customers_CreatePetResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CustomerTypesProto.internal_static_petclinic_customers_CreatePetResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreatePetResponse.class, org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreatePetResponse.Builder.class);
  }

  private int bitField0_;
  public static final int PET_FIELD_NUMBER = 1;
  private org.springframework.samples.petclinic.customers.grpc.gen.customer.types.Pet pet_;
  /**
   * <code>.petclinic.customers.Pet pet = 1;</code>
   * @return Whether the pet field is set.
   */
  @java.lang.Override
  public boolean hasPet() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <code>.petclinic.customers.Pet pet = 1;</code>
   * @return The pet.
   */
  @java.lang.Override
  public org.springframework.samples.petclinic.customers.grpc.gen.customer.types.Pet getPet() {
    return pet_ == null ? org.springframework.samples.petclinic.customers.grpc.gen.customer.types.Pet.getDefaultInstance() : pet_;
  }
  /**
   * <code>.petclinic.customers.Pet pet = 1;</code>
   */
  @java.lang.Override
  public org.springframework.samples.petclinic.customers.grpc.gen.customer.types.PetOrBuilder getPetOrBuilder() {
    return pet_ == null ? org.springframework.samples.petclinic.customers.grpc.gen.customer.types.Pet.getDefaultInstance() : pet_;
  }

  public static final int CREATED_FIELD_NUMBER = 2;
  private boolean created_ = false;
  /**
   * <code>bool created = 2;</code>
   * @return The created.
   */
  @java.lang.Override
  public boolean getCreated() {
    return created_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (((bitField0_ & 0x00000001) != 0)) {
      output.writeMessage(1, getPet());
    }
    if (created_ != false) {
      output.writeBool(2, created_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getPet());
    }
    if (created_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(2, created_);
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreatePetResponse)) {
      return super.equals(obj);
    }
    org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreatePetResponse other = (org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreatePetResponse) obj;

    if (hasPet() != other.hasPet()) return false;
    if (hasPet()) {
      if (!getPet()
          .equals(other.getPet())) return false;
    }
    if (getCreated()
        != other.getCreated()) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasPet()) {
      hash = (37 * hash) + PET_FIELD_NUMBER;
      hash = (53 * hash) + getPet().hashCode();
    }
    hash = (37 * hash) + CREATED_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getCreated());
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreatePetResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreatePetResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreatePetResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreatePetResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreatePetResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreatePetResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreatePetResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreatePetResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreatePetResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreatePetResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreatePetResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreatePetResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreatePetResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessage.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code petclinic.customers.CreatePetResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:petclinic.customers.CreatePetResponse)
      org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreatePetResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CustomerTypesProto.internal_static_petclinic_customers_CreatePetResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CustomerTypesProto.internal_static_petclinic_customers_CreatePetResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreatePetResponse.class, org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreatePetResponse.Builder.class);
    }

    // Construct using org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreatePetResponse.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessage
              .alwaysUseFieldBuilders) {
        getPetFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      pet_ = null;
      if (petBuilder_ != null) {
        petBuilder_.dispose();
        petBuilder_ = null;
      }
      created_ = false;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CustomerTypesProto.internal_static_petclinic_customers_CreatePetResponse_descriptor;
    }

    @java.lang.Override
    public org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreatePetResponse getDefaultInstanceForType() {
      return org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreatePetResponse.getDefaultInstance();
    }

    @java.lang.Override
    public org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreatePetResponse build() {
      org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreatePetResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreatePetResponse buildPartial() {
      org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreatePetResponse result = new org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreatePetResponse(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreatePetResponse result) {
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.pet_ = petBuilder_ == null
            ? pet_
            : petBuilder_.build();
        to_bitField0_ |= 0x00000001;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.created_ = created_;
      }
      result.bitField0_ |= to_bitField0_;
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreatePetResponse) {
        return mergeFrom((org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreatePetResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreatePetResponse other) {
      if (other == org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreatePetResponse.getDefaultInstance()) return this;
      if (other.hasPet()) {
        mergePet(other.getPet());
      }
      if (other.getCreated() != false) {
        setCreated(other.getCreated());
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              input.readMessage(
                  getPetFieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 16: {
              created_ = input.readBool();
              bitField0_ |= 0x00000002;
              break;
            } // case 16
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private org.springframework.samples.petclinic.customers.grpc.gen.customer.types.Pet pet_;
    private com.google.protobuf.SingleFieldBuilder<
        org.springframework.samples.petclinic.customers.grpc.gen.customer.types.Pet, org.springframework.samples.petclinic.customers.grpc.gen.customer.types.Pet.Builder, org.springframework.samples.petclinic.customers.grpc.gen.customer.types.PetOrBuilder> petBuilder_;
    /**
     * <code>.petclinic.customers.Pet pet = 1;</code>
     * @return Whether the pet field is set.
     */
    public boolean hasPet() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>.petclinic.customers.Pet pet = 1;</code>
     * @return The pet.
     */
    public org.springframework.samples.petclinic.customers.grpc.gen.customer.types.Pet getPet() {
      if (petBuilder_ == null) {
        return pet_ == null ? org.springframework.samples.petclinic.customers.grpc.gen.customer.types.Pet.getDefaultInstance() : pet_;
      } else {
        return petBuilder_.getMessage();
      }
    }
    /**
     * <code>.petclinic.customers.Pet pet = 1;</code>
     */
    public Builder setPet(org.springframework.samples.petclinic.customers.grpc.gen.customer.types.Pet value) {
      if (petBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        pet_ = value;
      } else {
        petBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>.petclinic.customers.Pet pet = 1;</code>
     */
    public Builder setPet(
        org.springframework.samples.petclinic.customers.grpc.gen.customer.types.Pet.Builder builderForValue) {
      if (petBuilder_ == null) {
        pet_ = builderForValue.build();
      } else {
        petBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>.petclinic.customers.Pet pet = 1;</code>
     */
    public Builder mergePet(org.springframework.samples.petclinic.customers.grpc.gen.customer.types.Pet value) {
      if (petBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0) &&
          pet_ != null &&
          pet_ != org.springframework.samples.petclinic.customers.grpc.gen.customer.types.Pet.getDefaultInstance()) {
          getPetBuilder().mergeFrom(value);
        } else {
          pet_ = value;
        }
      } else {
        petBuilder_.mergeFrom(value);
      }
      if (pet_ != null) {
        bitField0_ |= 0x00000001;
        onChanged();
      }
      return this;
    }
    /**
     * <code>.petclinic.customers.Pet pet = 1;</code>
     */
    public Builder clearPet() {
      bitField0_ = (bitField0_ & ~0x00000001);
      pet_ = null;
      if (petBuilder_ != null) {
        petBuilder_.dispose();
        petBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <code>.petclinic.customers.Pet pet = 1;</code>
     */
    public org.springframework.samples.petclinic.customers.grpc.gen.customer.types.Pet.Builder getPetBuilder() {
      bitField0_ |= 0x00000001;
      onChanged();
      return getPetFieldBuilder().getBuilder();
    }
    /**
     * <code>.petclinic.customers.Pet pet = 1;</code>
     */
    public org.springframework.samples.petclinic.customers.grpc.gen.customer.types.PetOrBuilder getPetOrBuilder() {
      if (petBuilder_ != null) {
        return petBuilder_.getMessageOrBuilder();
      } else {
        return pet_ == null ?
            org.springframework.samples.petclinic.customers.grpc.gen.customer.types.Pet.getDefaultInstance() : pet_;
      }
    }
    /**
     * <code>.petclinic.customers.Pet pet = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilder<
        org.springframework.samples.petclinic.customers.grpc.gen.customer.types.Pet, org.springframework.samples.petclinic.customers.grpc.gen.customer.types.Pet.Builder, org.springframework.samples.petclinic.customers.grpc.gen.customer.types.PetOrBuilder> 
        getPetFieldBuilder() {
      if (petBuilder_ == null) {
        petBuilder_ = new com.google.protobuf.SingleFieldBuilder<
            org.springframework.samples.petclinic.customers.grpc.gen.customer.types.Pet, org.springframework.samples.petclinic.customers.grpc.gen.customer.types.Pet.Builder, org.springframework.samples.petclinic.customers.grpc.gen.customer.types.PetOrBuilder>(
                getPet(),
                getParentForChildren(),
                isClean());
        pet_ = null;
      }
      return petBuilder_;
    }

    private boolean created_ ;
    /**
     * <code>bool created = 2;</code>
     * @return The created.
     */
    @java.lang.Override
    public boolean getCreated() {
      return created_;
    }
    /**
     * <code>bool created = 2;</code>
     * @param value The created to set.
     * @return This builder for chaining.
     */
    public Builder setCreated(boolean value) {

      created_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>bool created = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearCreated() {
      bitField0_ = (bitField0_ & ~0x00000002);
      created_ = false;
      onChanged();
      return this;
    }

    // @@protoc_insertion_point(builder_scope:petclinic.customers.CreatePetResponse)
  }

  // @@protoc_insertion_point(class_scope:petclinic.customers.CreatePetResponse)
  private static final org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreatePetResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreatePetResponse();
  }

  public static org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreatePetResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<CreatePetResponse>
      PARSER = new com.google.protobuf.AbstractParser<CreatePetResponse>() {
    @java.lang.Override
    public CreatePetResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<CreatePetResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<CreatePetResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CreatePetResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

