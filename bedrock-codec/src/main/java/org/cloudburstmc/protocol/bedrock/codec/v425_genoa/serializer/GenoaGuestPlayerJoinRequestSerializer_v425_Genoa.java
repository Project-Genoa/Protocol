package org.cloudburstmc.protocol.bedrock.codec.v425_genoa.serializer;

import io.netty.buffer.ByteBuf;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.GenoaGuestPlayerJoinRequestPacket;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GenoaGuestPlayerJoinRequestSerializer_v425_Genoa implements BedrockPacketSerializer<GenoaGuestPlayerJoinRequestPacket> {
    public static final GenoaGuestPlayerJoinRequestSerializer_v425_Genoa INSTANCE = new GenoaGuestPlayerJoinRequestSerializer_v425_Genoa();

    @Override
    public void serialize(ByteBuf buffer, BedrockCodecHelper helper, GenoaGuestPlayerJoinRequestPacket packet) {
        helper.writeString(buffer, packet.getS1());
        buffer.writeBoolean(packet.isB1());
        if (packet.isB1()) {
            helper.writeString(buffer, packet.getS2());
        }
    }

    @Override
    public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, GenoaGuestPlayerJoinRequestPacket packet) {
        packet.setS1(helper.readString(buffer));
        packet.setB1(buffer.readBoolean());
        if (packet.isB1()) {
            packet.setS2(helper.readString(buffer));
        }
    }
}
