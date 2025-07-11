// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: customer/Types.proto
// Protobuf Java Version: 4.29.3

package org.springframework.samples.petclinic.customers.grpc.gen.customer.types;

/**
 * Protobuf type {@code petclinic.customers.GetOwnersResponse}
 */
public final class GetOwnersResponse extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:petclinic.customers.GetOwnersResponse)
    GetOwnersResponseOrBuilder {
private static final long serialVersionUID = 0L;
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 29,
      /* patch= */ 3,
      /* suffix= */ "",
      GetOwnersResponse.class.getName());
  }
  // Use GetOwnersResponse.newBuilder() to construct.
  private GetOwnersResponse(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private GetOwnersResponse() {
    owners_ = java.util.Collections.emptyList();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CustomerTypesProto.internal_static_petclinic_customers_GetOwnersResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CustomerTypesProto.internal_static_petclinic_customers_GetOwnersResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetOwnersResponse.class, org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetOwnersResponse.Builder.class);
  }

  public static final int OWNERS_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private java.util.List<org.springframework.samples.petclinic.customers.grpc.gen.customer.types.Owner> owners_;
  /**
   * <code>repeated .petclinic.customers.Owner owners = 1;</code>
   */
  @java.lang.Override
  public java.util.List<org.springframework.samples.petclinic.customers.grpc.gen.customer.types.Owner> getOwnersList() {
    return owners_;
  }
  /**
   * <code>repeated .petclinic.customers.Owner owners = 1;</code>
   */
  @java.lang.Override
  public java.util.List<? extends org.springframework.samples.petclinic.customers.grpc.gen.customer.types.OwnerOrBuilder> 
      getOwnersOrBuilderList() {
    return owners_;
  }
  /**
   * <code>repeated .petclinic.customers.Owner owners = 1;</code>
   */
  @java.lang.Override
  public int getOwnersCount() {
    return owners_.size();
  }
  /**
   * <code>repeated .petclinic.customers.Owner owners = 1;</code>
   */
  @java.lang.Override
  public org.springframework.samples.petclinic.customers.grpc.gen.customer.types.Owner getOwners(int index) {
    return owners_.get(index);
  }
  /**
   * <code>repeated .petclinic.customers.Owner owners = 1;</code>
   */
  @java.lang.Override
  public org.springframework.samples.petclinic.customers.grpc.gen.customer.types.OwnerOrBuilder getOwnersOrBuilder(
      int index) {
    return owners_.get(index);
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
    for (int i = 0; i < owners_.size(); i++) {
      output.writeMessage(1, owners_.get(i));
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < owners_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, owners_.get(i));
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
    if (!(obj instanceof org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetOwnersResponse)) {
      return super.equals(obj);
    }
    org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetOwnersResponse other = (org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetOwnersResponse) obj;

    if (!getOwnersList()
        .equals(other.getOwnersList())) return false;
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
    if (getOwnersCount() > 0) {
      hash = (37 * hash) + OWNERS_FIELD_NUMBER;
      hash = (53 * hash) + getOwnersList().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetOwnersResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetOwnersResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetOwnersResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetOwnersResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetOwnersResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetOwnersResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetOwnersResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetOwnersResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetOwnersResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetOwnersResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetOwnersResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetOwnersResponse parseFrom(
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
  public static Builder newBuilder(org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetOwnersResponse prototype) {
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
   * Protobuf type {@code petclinic.customers.GetOwnersResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:petclinic.customers.GetOwnersResponse)
      org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetOwnersResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CustomerTypesProto.internal_static_petclinic_customers_GetOwnersResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CustomerTypesProto.internal_static_petclinic_customers_GetOwnersResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetOwnersResponse.class, org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetOwnersResponse.Builder.class);
    }

    // Construct using org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetOwnersResponse.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      if (ownersBuilder_ == null) {
        owners_ = java.util.Collections.emptyList();
      } else {
        owners_ = null;
        ownersBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return org.springframework.samples.petclinic.customers.grpc.gen.customer.types.CustomerTypesProto.internal_static_petclinic_customers_GetOwnersResponse_descriptor;
    }

    @java.lang.Override
    public org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetOwnersResponse getDefaultInstanceForType() {
      return org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetOwnersResponse.getDefaultInstance();
    }

    @java.lang.Override
    public org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetOwnersResponse build() {
      org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetOwnersResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetOwnersResponse buildPartial() {
      org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetOwnersResponse result = new org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetOwnersResponse(this);
      buildPartialRepeatedFields(result);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartialRepeatedFields(org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetOwnersResponse result) {
      if (ownersBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          owners_ = java.util.Collections.unmodifiableList(owners_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.owners_ = owners_;
      } else {
        result.owners_ = ownersBuilder_.build();
      }
    }

    private void buildPartial0(org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetOwnersResponse result) {
      int from_bitField0_ = bitField0_;
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetOwnersResponse) {
        return mergeFrom((org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetOwnersResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetOwnersResponse other) {
      if (other == org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetOwnersResponse.getDefaultInstance()) return this;
      if (ownersBuilder_ == null) {
        if (!other.owners_.isEmpty()) {
          if (owners_.isEmpty()) {
            owners_ = other.owners_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureOwnersIsMutable();
            owners_.addAll(other.owners_);
          }
          onChanged();
        }
      } else {
        if (!other.owners_.isEmpty()) {
          if (ownersBuilder_.isEmpty()) {
            ownersBuilder_.dispose();
            ownersBuilder_ = null;
            owners_ = other.owners_;
            bitField0_ = (bitField0_ & ~0x00000001);
            ownersBuilder_ = 
              com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders ?
                 getOwnersFieldBuilder() : null;
          } else {
            ownersBuilder_.addAllMessages(other.owners_);
          }
        }
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
              org.springframework.samples.petclinic.customers.grpc.gen.customer.types.Owner m =
                  input.readMessage(
                      org.springframework.samples.petclinic.customers.grpc.gen.customer.types.Owner.parser(),
                      extensionRegistry);
              if (ownersBuilder_ == null) {
                ensureOwnersIsMutable();
                owners_.add(m);
              } else {
                ownersBuilder_.addMessage(m);
              }
              break;
            } // case 10
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

    private java.util.List<org.springframework.samples.petclinic.customers.grpc.gen.customer.types.Owner> owners_ =
      java.util.Collections.emptyList();
    private void ensureOwnersIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        owners_ = new java.util.ArrayList<org.springframework.samples.petclinic.customers.grpc.gen.customer.types.Owner>(owners_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilder<
        org.springframework.samples.petclinic.customers.grpc.gen.customer.types.Owner, org.springframework.samples.petclinic.customers.grpc.gen.customer.types.Owner.Builder, org.springframework.samples.petclinic.customers.grpc.gen.customer.types.OwnerOrBuilder> ownersBuilder_;

    /**
     * <code>repeated .petclinic.customers.Owner owners = 1;</code>
     */
    public java.util.List<org.springframework.samples.petclinic.customers.grpc.gen.customer.types.Owner> getOwnersList() {
      if (ownersBuilder_ == null) {
        return java.util.Collections.unmodifiableList(owners_);
      } else {
        return ownersBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .petclinic.customers.Owner owners = 1;</code>
     */
    public int getOwnersCount() {
      if (ownersBuilder_ == null) {
        return owners_.size();
      } else {
        return ownersBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .petclinic.customers.Owner owners = 1;</code>
     */
    public org.springframework.samples.petclinic.customers.grpc.gen.customer.types.Owner getOwners(int index) {
      if (ownersBuilder_ == null) {
        return owners_.get(index);
      } else {
        return ownersBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .petclinic.customers.Owner owners = 1;</code>
     */
    public Builder setOwners(
        int index, org.springframework.samples.petclinic.customers.grpc.gen.customer.types.Owner value) {
      if (ownersBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureOwnersIsMutable();
        owners_.set(index, value);
        onChanged();
      } else {
        ownersBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .petclinic.customers.Owner owners = 1;</code>
     */
    public Builder setOwners(
        int index, org.springframework.samples.petclinic.customers.grpc.gen.customer.types.Owner.Builder builderForValue) {
      if (ownersBuilder_ == null) {
        ensureOwnersIsMutable();
        owners_.set(index, builderForValue.build());
        onChanged();
      } else {
        ownersBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .petclinic.customers.Owner owners = 1;</code>
     */
    public Builder addOwners(org.springframework.samples.petclinic.customers.grpc.gen.customer.types.Owner value) {
      if (ownersBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureOwnersIsMutable();
        owners_.add(value);
        onChanged();
      } else {
        ownersBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .petclinic.customers.Owner owners = 1;</code>
     */
    public Builder addOwners(
        int index, org.springframework.samples.petclinic.customers.grpc.gen.customer.types.Owner value) {
      if (ownersBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureOwnersIsMutable();
        owners_.add(index, value);
        onChanged();
      } else {
        ownersBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .petclinic.customers.Owner owners = 1;</code>
     */
    public Builder addOwners(
        org.springframework.samples.petclinic.customers.grpc.gen.customer.types.Owner.Builder builderForValue) {
      if (ownersBuilder_ == null) {
        ensureOwnersIsMutable();
        owners_.add(builderForValue.build());
        onChanged();
      } else {
        ownersBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .petclinic.customers.Owner owners = 1;</code>
     */
    public Builder addOwners(
        int index, org.springframework.samples.petclinic.customers.grpc.gen.customer.types.Owner.Builder builderForValue) {
      if (ownersBuilder_ == null) {
        ensureOwnersIsMutable();
        owners_.add(index, builderForValue.build());
        onChanged();
      } else {
        ownersBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .petclinic.customers.Owner owners = 1;</code>
     */
    public Builder addAllOwners(
        java.lang.Iterable<? extends org.springframework.samples.petclinic.customers.grpc.gen.customer.types.Owner> values) {
      if (ownersBuilder_ == null) {
        ensureOwnersIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, owners_);
        onChanged();
      } else {
        ownersBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .petclinic.customers.Owner owners = 1;</code>
     */
    public Builder clearOwners() {
      if (ownersBuilder_ == null) {
        owners_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        ownersBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .petclinic.customers.Owner owners = 1;</code>
     */
    public Builder removeOwners(int index) {
      if (ownersBuilder_ == null) {
        ensureOwnersIsMutable();
        owners_.remove(index);
        onChanged();
      } else {
        ownersBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .petclinic.customers.Owner owners = 1;</code>
     */
    public org.springframework.samples.petclinic.customers.grpc.gen.customer.types.Owner.Builder getOwnersBuilder(
        int index) {
      return getOwnersFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .petclinic.customers.Owner owners = 1;</code>
     */
    public org.springframework.samples.petclinic.customers.grpc.gen.customer.types.OwnerOrBuilder getOwnersOrBuilder(
        int index) {
      if (ownersBuilder_ == null) {
        return owners_.get(index);  } else {
        return ownersBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .petclinic.customers.Owner owners = 1;</code>
     */
    public java.util.List<? extends org.springframework.samples.petclinic.customers.grpc.gen.customer.types.OwnerOrBuilder> 
         getOwnersOrBuilderList() {
      if (ownersBuilder_ != null) {
        return ownersBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(owners_);
      }
    }
    /**
     * <code>repeated .petclinic.customers.Owner owners = 1;</code>
     */
    public org.springframework.samples.petclinic.customers.grpc.gen.customer.types.Owner.Builder addOwnersBuilder() {
      return getOwnersFieldBuilder().addBuilder(
          org.springframework.samples.petclinic.customers.grpc.gen.customer.types.Owner.getDefaultInstance());
    }
    /**
     * <code>repeated .petclinic.customers.Owner owners = 1;</code>
     */
    public org.springframework.samples.petclinic.customers.grpc.gen.customer.types.Owner.Builder addOwnersBuilder(
        int index) {
      return getOwnersFieldBuilder().addBuilder(
          index, org.springframework.samples.petclinic.customers.grpc.gen.customer.types.Owner.getDefaultInstance());
    }
    /**
     * <code>repeated .petclinic.customers.Owner owners = 1;</code>
     */
    public java.util.List<org.springframework.samples.petclinic.customers.grpc.gen.customer.types.Owner.Builder> 
         getOwnersBuilderList() {
      return getOwnersFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilder<
        org.springframework.samples.petclinic.customers.grpc.gen.customer.types.Owner, org.springframework.samples.petclinic.customers.grpc.gen.customer.types.Owner.Builder, org.springframework.samples.petclinic.customers.grpc.gen.customer.types.OwnerOrBuilder> 
        getOwnersFieldBuilder() {
      if (ownersBuilder_ == null) {
        ownersBuilder_ = new com.google.protobuf.RepeatedFieldBuilder<
            org.springframework.samples.petclinic.customers.grpc.gen.customer.types.Owner, org.springframework.samples.petclinic.customers.grpc.gen.customer.types.Owner.Builder, org.springframework.samples.petclinic.customers.grpc.gen.customer.types.OwnerOrBuilder>(
                owners_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        owners_ = null;
      }
      return ownersBuilder_;
    }

    // @@protoc_insertion_point(builder_scope:petclinic.customers.GetOwnersResponse)
  }

  // @@protoc_insertion_point(class_scope:petclinic.customers.GetOwnersResponse)
  private static final org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetOwnersResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetOwnersResponse();
  }

  public static org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetOwnersResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GetOwnersResponse>
      PARSER = new com.google.protobuf.AbstractParser<GetOwnersResponse>() {
    @java.lang.Override
    public GetOwnersResponse parsePartialFrom(
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

  public static com.google.protobuf.Parser<GetOwnersResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GetOwnersResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public org.springframework.samples.petclinic.customers.grpc.gen.customer.types.GetOwnersResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

