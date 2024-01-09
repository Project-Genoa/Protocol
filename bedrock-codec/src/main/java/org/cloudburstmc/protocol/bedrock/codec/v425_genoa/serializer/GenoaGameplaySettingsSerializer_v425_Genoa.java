package org.cloudburstmc.protocol.bedrock.codec.v425_genoa.serializer;

import io.netty.buffer.ByteBuf;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.GenoaGameplaySettingsPacket;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GenoaGameplaySettingsSerializer_v425_Genoa implements BedrockPacketSerializer<GenoaGameplaySettingsPacket> {
    public static final GenoaGameplaySettingsSerializer_v425_Genoa INSTANCE = new GenoaGameplaySettingsSerializer_v425_Genoa();

    @Override
    public void serialize(ByteBuf buffer, BedrockCodecHelper helper, GenoaGameplaySettingsPacket packet) {
        buffer.writeBoolean(packet.isMultiplePlayersOnline());
        if (packet.isMultiplePlayersOnline()) {
            buffer.writeLong(packet.getOwnerRuntimeId());
        }
    }

    @Override
    public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, GenoaGameplaySettingsPacket packet) {
        packet.setMultiplePlayersOnline(buffer.readBoolean());
        if (packet.isMultiplePlayersOnline()) {
            packet.setOwnerRuntimeId(buffer.readLong());
        }
    }
}
