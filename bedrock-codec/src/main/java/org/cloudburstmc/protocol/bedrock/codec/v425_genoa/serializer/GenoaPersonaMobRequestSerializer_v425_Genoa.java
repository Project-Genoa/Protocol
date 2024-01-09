package org.cloudburstmc.protocol.bedrock.codec.v425_genoa.serializer;

import io.netty.buffer.ByteBuf;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.GenoaPersonaMobRequestPacket;
import org.cloudburstmc.protocol.common.util.VarInts;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GenoaPersonaMobRequestSerializer_v425_Genoa implements BedrockPacketSerializer<GenoaPersonaMobRequestPacket> {
    public static final GenoaPersonaMobRequestSerializer_v425_Genoa INSTANCE = new GenoaPersonaMobRequestSerializer_v425_Genoa();

    @Override
    public void serialize(ByteBuf buffer, BedrockCodecHelper helper, GenoaPersonaMobRequestPacket packet) {
        VarInts.writeUnsignedLong(buffer, packet.getUnsignedLong1());
        helper.writeString(buffer, packet.getS1());
        helper.writeString(buffer, packet.getS2());
    }

    @Override
    public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, GenoaPersonaMobRequestPacket packet) {
        packet.setUnsignedLong1(VarInts.readUnsignedLong(buffer));
        packet.setS1(helper.readString(buffer));
        packet.setS2(helper.readString(buffer));
    }
}
