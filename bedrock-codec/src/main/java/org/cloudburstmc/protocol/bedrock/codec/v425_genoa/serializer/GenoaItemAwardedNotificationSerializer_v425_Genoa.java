package org.cloudburstmc.protocol.bedrock.codec.v425_genoa.serializer;

import io.netty.buffer.ByteBuf;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.data.GenoaItemAwardedNotification;
import org.cloudburstmc.protocol.bedrock.packet.GenoaItemAwardedNotificationPacket;

import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GenoaItemAwardedNotificationSerializer_v425_Genoa implements BedrockPacketSerializer<GenoaItemAwardedNotificationPacket> {
    public static final GenoaItemAwardedNotificationSerializer_v425_Genoa INSTANCE = new GenoaItemAwardedNotificationSerializer_v425_Genoa();

    @Override
    public void serialize(ByteBuf buffer, BedrockCodecHelper helper, GenoaItemAwardedNotificationPacket packet) {
        helper.writeString(buffer, packet.getString1());
        helper.writeString(buffer, packet.getString2());
        helper.writeString(buffer, packet.getString3());
        helper.writeArray(buffer, packet.getArr(), (buf, help, pac) -> {
            buffer.writeIntLE(pac.getRuntimeEntityId());
            buffer.writeIntLE(pac.getAmount());
            helper.writeUuid(buffer, pac.getCatalogItemUuid());
        });
    }

    @Override
    public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, GenoaItemAwardedNotificationPacket packet) {
        packet.setString1(helper.readString(buffer));
        packet.setString2(helper.readString(buffer));
        packet.setString3(helper.readString(buffer));
        helper.readArray(buffer, packet.getArr(), (buf, help) -> {
            int UnsignedInt = buffer.readIntLE();
            int SignedInt = buffer.readIntLE();
            UUID Uuid = helper.readUuid(buffer);
            return new GenoaItemAwardedNotification(UnsignedInt, SignedInt, Uuid);
        });
    }
}
