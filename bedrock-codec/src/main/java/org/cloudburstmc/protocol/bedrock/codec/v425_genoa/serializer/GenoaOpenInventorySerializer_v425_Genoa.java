package org.cloudburstmc.protocol.bedrock.codec.v425_genoa.serializer;

import io.netty.buffer.ByteBuf;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.GenoaOpenInventoryPacket;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GenoaOpenInventorySerializer_v425_Genoa implements BedrockPacketSerializer<GenoaOpenInventoryPacket> {
    public static final GenoaOpenInventorySerializer_v425_Genoa INSTANCE = new GenoaOpenInventorySerializer_v425_Genoa();

    @Override
    public void serialize(ByteBuf buffer, BedrockCodecHelper helper, GenoaOpenInventoryPacket packet) {
    }

    @Override
    public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, GenoaOpenInventoryPacket packet) {
    }
}
