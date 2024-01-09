package org.cloudburstmc.protocol.bedrock.codec.v425_genoa.serializer;

import io.netty.buffer.ByteBuf;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.GenoaNetworkOwnershipRequestPacket;
import org.cloudburstmc.protocol.common.util.VarInts;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GenoaNetworkOwnershipRequestSerializer_v425_Genoa implements BedrockPacketSerializer<GenoaNetworkOwnershipRequestPacket> {
    public static final GenoaNetworkOwnershipRequestSerializer_v425_Genoa INSTANCE = new GenoaNetworkOwnershipRequestSerializer_v425_Genoa();

    @Override
    public void serialize(ByteBuf buffer, BedrockCodecHelper helper, GenoaNetworkOwnershipRequestPacket packet) {
        buffer.writeByte(packet.getByte1());
        VarInts.writeUnsignedLong(buffer, packet.getUnsignedVarLong());
        buffer.writeBoolean(packet.isB1());
    }

    @Override
    public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, GenoaNetworkOwnershipRequestPacket packet) {
        packet.setByte1(buffer.readByte());
        packet.setUnsignedVarLong(VarInts.readUnsignedLong(buffer));
        packet.setB1(buffer.readBoolean());
    }
}
