package org.cloudburstmc.protocol.bedrock.codec.v425_genoa.serializer;

import io.netty.buffer.ByteBuf;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.GenoaShareAnchorPacket;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GenoaShareAnchorSerializer_v425_Genoa implements BedrockPacketSerializer<GenoaShareAnchorPacket> {
    public static final GenoaShareAnchorSerializer_v425_Genoa INSTANCE = new GenoaShareAnchorSerializer_v425_Genoa();

    @Override
    public void serialize(ByteBuf buffer, BedrockCodecHelper helper, GenoaShareAnchorPacket packet) {
        helper.writeVector4f(buffer, packet.getBottomLeft());
        helper.writeVector4f(buffer, packet.getBottomRight());
        helper.writeVector4f(buffer, packet.getTopLeft());
        helper.writeVector4f(buffer, packet.getTopRight());
    }

    @Override
    public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, GenoaShareAnchorPacket packet) {
        packet.setBottomLeft(helper.readVector4f(buffer));
        packet.setBottomRight(helper.readVector4f(buffer));
        packet.setTopLeft(helper.readVector4f(buffer));
        packet.setTopRight(helper.readVector4f(buffer));
    }
}
