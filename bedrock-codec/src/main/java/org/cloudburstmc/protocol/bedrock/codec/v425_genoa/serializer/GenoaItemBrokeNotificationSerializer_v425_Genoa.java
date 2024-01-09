package org.cloudburstmc.protocol.bedrock.codec.v425_genoa.serializer;

import io.netty.buffer.ByteBuf;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.GenoaItemBrokeNotificationPacket;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GenoaItemBrokeNotificationSerializer_v425_Genoa implements BedrockPacketSerializer<GenoaItemBrokeNotificationPacket> {
    public static final GenoaItemBrokeNotificationSerializer_v425_Genoa INSTANCE = new GenoaItemBrokeNotificationSerializer_v425_Genoa();

    @Override
    public void serialize(ByteBuf buffer, BedrockCodecHelper helper, GenoaItemBrokeNotificationPacket packet) {
        buffer.writeIntLE(packet.getUnsignedInt());
    }

    @Override
    public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, GenoaItemBrokeNotificationPacket packet) {
        packet.setUnsignedInt(buffer.readIntLE());
    }
}
