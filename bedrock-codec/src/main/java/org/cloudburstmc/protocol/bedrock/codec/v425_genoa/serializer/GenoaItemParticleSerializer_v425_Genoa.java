package org.cloudburstmc.protocol.bedrock.codec.v425_genoa.serializer;

import io.netty.buffer.ByteBuf;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.GenoaItemParticlePacket;
import org.cloudburstmc.protocol.common.util.VarInts;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GenoaItemParticleSerializer_v425_Genoa implements BedrockPacketSerializer<GenoaItemParticlePacket> {
    public static final GenoaItemParticleSerializer_v425_Genoa INSTANCE = new GenoaItemParticleSerializer_v425_Genoa();

    @Override
    public void serialize(ByteBuf buffer, BedrockCodecHelper helper, GenoaItemParticlePacket packet) {
        buffer.writeIntLE(packet.getParticleId());
        buffer.writeIntLE(packet.getDimensionId());
        helper.writeVector3f(buffer, packet.getPosition());
        VarInts.writeUnsignedLong(buffer, packet.getUniqueEntityId());
    }

    @Override
    public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, GenoaItemParticlePacket packet) {
        packet.setParticleId(buffer.readIntLE());
        packet.setDimensionId(buffer.readIntLE());
        packet.setPosition(helper.readVector3f(buffer));
        packet.setUniqueEntityId((VarInts.readUnsignedLong(buffer)));
    }
}
