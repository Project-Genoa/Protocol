package com.nukkitx.protocol.bedrock.exception;

public class PacketSerializeException extends RuntimeException {

    public PacketSerializeException(Throwable e) {
        super(e);
    }

    public PacketSerializeException(String message, Throwable e) {
        super(message, e);
    }
}
