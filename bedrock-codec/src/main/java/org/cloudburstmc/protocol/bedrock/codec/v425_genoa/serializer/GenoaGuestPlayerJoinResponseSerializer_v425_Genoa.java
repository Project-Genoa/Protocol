package org.cloudburstmc.protocol.bedrock.codec.v425_genoa.serializer;

import io.netty.buffer.ByteBuf;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.GenoaGuestPlayerJoinResponsePacket;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GenoaGuestPlayerJoinResponseSerializer_v425_Genoa implements BedrockPacketSerializer<GenoaGuestPlayerJoinResponsePacket> {
    public static final GenoaGuestPlayerJoinResponseSerializer_v425_Genoa INSTANCE = new GenoaGuestPlayerJoinResponseSerializer_v425_Genoa();

    @Override
    public void serialize(ByteBuf buffer, BedrockCodecHelper helper, GenoaGuestPlayerJoinResponsePacket packet) {
        helper.writeString(buffer, packet.getStringVal());
        buffer.writeBoolean(packet.isBoolVal());
    }

    @Override
    public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, GenoaGuestPlayerJoinResponsePacket packet) {
        packet.setStringVal(helper.readString(buffer));
        packet.setBoolVal(buffer.readBoolean());
    }
}
