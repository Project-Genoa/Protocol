package org.cloudburstmc.protocol.bedrock.codec.v425_genoa.serializer;

import io.netty.buffer.ByteBuf;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.data.GenoaNetworkOwnershipStatus;
import org.cloudburstmc.protocol.bedrock.packet.GenoaNetworkOwnershipStatusPacket;
import org.cloudburstmc.protocol.common.util.VarInts;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GenoaNetworkOwnershipStatusSerializer_v425_Genoa implements BedrockPacketSerializer<GenoaNetworkOwnershipStatusPacket> {
    public static final GenoaNetworkOwnershipStatusSerializer_v425_Genoa INSTANCE = new GenoaNetworkOwnershipStatusSerializer_v425_Genoa();

    @Override
    public void serialize(ByteBuf buffer, BedrockCodecHelper helper, GenoaNetworkOwnershipStatusPacket packet) {
        helper.writeArray(buffer, packet.getArr(), (buf, help, pac) -> {
            buf.writeByte(pac.getByte1());
            VarInts.writeUnsignedLong(buf, pac.getUnsignedLong1());
        });
    }

    @Override
    public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, GenoaNetworkOwnershipStatusPacket packet) {
        helper.readArray(buffer, packet.getArr(), (byteBuf, bedrockPacketHelper) -> {
            byte Byte1 = buffer.readByte();
            long UnsignedLong1 = VarInts.readUnsignedLong(buffer);
            return new GenoaNetworkOwnershipStatus(Byte1, UnsignedLong1);
        });
    }
}
