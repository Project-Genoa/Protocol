package org.cloudburstmc.protocol.bedrock.codec.v425_genoa.serializer;

import io.netty.buffer.ByteBuf;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.GenoaBlockHitNoDamagePacket;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GenoaBlockHitNoDamageSerializer_v425_Genoa implements BedrockPacketSerializer<GenoaBlockHitNoDamagePacket> {
    public static final GenoaBlockHitNoDamageSerializer_v425_Genoa INSTANCE = new GenoaBlockHitNoDamageSerializer_v425_Genoa();

    @Override
    public void serialize(ByteBuf buffer, BedrockCodecHelper helper, GenoaBlockHitNoDamagePacket packet) {
        helper.writeBlockPosition(buffer, packet.getPosition());
    }

    @Override
    public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, GenoaBlockHitNoDamagePacket packet) {
        packet.setPosition(helper.readBlockPosition(buffer));
    }
}
