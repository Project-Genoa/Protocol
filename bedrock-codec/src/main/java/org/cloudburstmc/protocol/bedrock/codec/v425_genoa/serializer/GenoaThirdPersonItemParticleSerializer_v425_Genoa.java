package org.cloudburstmc.protocol.bedrock.codec.v425_genoa.serializer;

import io.netty.buffer.ByteBuf;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.GenoaThirdPersonItemParticlePacket;
import org.cloudburstmc.protocol.common.util.VarInts;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GenoaThirdPersonItemParticleSerializer_v425_Genoa implements BedrockPacketSerializer<GenoaThirdPersonItemParticlePacket> {
    public static final GenoaThirdPersonItemParticleSerializer_v425_Genoa INSTANCE = new GenoaThirdPersonItemParticleSerializer_v425_Genoa();

    @Override
    public void serialize(ByteBuf buffer, BedrockCodecHelper helper, GenoaThirdPersonItemParticlePacket packet) {
        buffer.writeIntLE(packet.getParticleId());
        buffer.writeIntLE(packet.getDimensionId());
        helper.writeVector3f(buffer, packet.getPosition());
        helper.writeVector3f(buffer, packet.getViewDirection());
        VarInts.writeUnsignedLong(buffer, packet.getUniqueEntityId());
    }

    @Override
    public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, GenoaThirdPersonItemParticlePacket packet) {
        packet.setParticleId(buffer.readIntLE());
        packet.setDimensionId(buffer.readIntLE());
        packet.setPosition(helper.readVector3f(buffer));
        packet.setViewDirection(helper.readVector3f(buffer));
        packet.setUniqueEntityId((VarInts.readUnsignedLong(buffer)));
    }
}
