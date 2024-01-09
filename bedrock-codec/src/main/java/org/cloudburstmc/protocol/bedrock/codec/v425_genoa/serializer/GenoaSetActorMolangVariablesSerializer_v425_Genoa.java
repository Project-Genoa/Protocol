package org.cloudburstmc.protocol.bedrock.codec.v425_genoa.serializer;

import io.netty.buffer.ByteBuf;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.GenoaSetActorMolangVariablesPacket;
import org.cloudburstmc.protocol.common.util.VarInts;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GenoaSetActorMolangVariablesSerializer_v425_Genoa implements BedrockPacketSerializer<GenoaSetActorMolangVariablesPacket> {
    public static final GenoaSetActorMolangVariablesSerializer_v425_Genoa INSTANCE = new GenoaSetActorMolangVariablesSerializer_v425_Genoa();

    @Override
    public void serialize(ByteBuf buffer, BedrockCodecHelper helper, GenoaSetActorMolangVariablesPacket packet) {
        buffer.writeLongLE(packet.getUint64());
        VarInts.writeUnsignedInt(buffer, packet.getU_varint());
    }

    @Override
    public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, GenoaSetActorMolangVariablesPacket packet) {
        packet.setUint64(buffer.readLongLE());
        packet.setU_varint(VarInts.readUnsignedInt(buffer));
    }
}
