package org.cloudburstmc.protocol.bedrock.codec.v425_genoa.serializer;

import io.netty.buffer.ByteBuf;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.GenoaWorldManipulationPacket;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GenoaWorldManipulationSerializer_v425_Genoa implements BedrockPacketSerializer<GenoaWorldManipulationPacket> {
    public static final GenoaWorldManipulationSerializer_v425_Genoa INSTANCE = new GenoaWorldManipulationSerializer_v425_Genoa();

    @Override
    public void serialize(ByteBuf buffer, BedrockCodecHelper helper, GenoaWorldManipulationPacket packet) {
        buffer.writeByte(packet.getIsWorldTicking());
    }

    @Override
    public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, GenoaWorldManipulationPacket packet) {
        packet.setIsWorldTicking(buffer.readByte());
    }
}
