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
        buffer.writeIntLE(packet.getItemId());
        buffer.writeIntLE(packet.getItemDataValue());
        helper.writeVector3f(buffer, packet.getPosition());
        VarInts.writeUnsignedLong(buffer, packet.getRuntimeEntityId());
    }

    @Override
    public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, GenoaItemParticlePacket packet) {
        packet.setItemId(buffer.readIntLE());
        packet.setItemDataValue(buffer.readIntLE());
        packet.setPosition(helper.readVector3f(buffer));
        packet.setRuntimeEntityId((VarInts.readUnsignedLong(buffer)));
    }
}
