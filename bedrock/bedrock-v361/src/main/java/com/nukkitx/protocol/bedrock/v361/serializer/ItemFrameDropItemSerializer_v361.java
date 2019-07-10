package com.nukkitx.protocol.bedrock.v361.serializer;

import com.nukkitx.protocol.bedrock.packet.ItemFrameDropItemPacket;
import com.nukkitx.protocol.bedrock.v361.BedrockUtils;
import com.nukkitx.protocol.serializer.PacketSerializer;
import io.netty.buffer.ByteBuf;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ItemFrameDropItemSerializer_v361 implements PacketSerializer<ItemFrameDropItemPacket> {
    public static final ItemFrameDropItemSerializer_v361 INSTANCE = new ItemFrameDropItemSerializer_v361();


    @Override
    public void serialize(ByteBuf buffer, ItemFrameDropItemPacket packet) {
        BedrockUtils.writeVector3i(buffer, packet.getBlockPosition());
    }

    @Override
    public void deserialize(ByteBuf buffer, ItemFrameDropItemPacket packet) {
        packet.setBlockPosition(BedrockUtils.readVector3i(buffer));
    }
}
