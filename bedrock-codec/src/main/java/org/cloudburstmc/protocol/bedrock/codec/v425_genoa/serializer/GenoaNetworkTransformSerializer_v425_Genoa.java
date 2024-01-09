package org.cloudburstmc.protocol.bedrock.codec.v425_genoa.serializer;

import io.netty.buffer.ByteBuf;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.GenoaNetworkTransformPacket;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GenoaNetworkTransformSerializer_v425_Genoa implements BedrockPacketSerializer<GenoaNetworkTransformPacket> {
    public static final GenoaNetworkTransformSerializer_v425_Genoa INSTANCE = new GenoaNetworkTransformSerializer_v425_Genoa();

    @Override
    public void serialize(ByteBuf buffer, BedrockCodecHelper helper, GenoaNetworkTransformPacket packet) {
        buffer.writeByte(packet.getByte1());
        helper.writeVector4f(buffer, packet.getBottomLeft());
        helper.writeVector4f(buffer, packet.getBottomRight());
        helper.writeVector4f(buffer, packet.getTopLeft());
        helper.writeVector4f(buffer, packet.getTopRight());
    }

    @Override
    public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, GenoaNetworkTransformPacket packet) {
        packet.setByte1(buffer.readByte());
        packet.setBottomLeft(helper.readVector4f(buffer));
        packet.setBottomRight(helper.readVector4f(buffer));
        packet.setTopLeft(helper.readVector4f(buffer));
        packet.setTopRight(helper.readVector4f(buffer));
    }
}
