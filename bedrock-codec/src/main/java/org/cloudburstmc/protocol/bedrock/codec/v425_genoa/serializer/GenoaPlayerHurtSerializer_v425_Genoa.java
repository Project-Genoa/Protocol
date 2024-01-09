package org.cloudburstmc.protocol.bedrock.codec.v425_genoa.serializer;

import io.netty.buffer.ByteBuf;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.GenoaPlayerHurtPacket;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GenoaPlayerHurtSerializer_v425_Genoa implements BedrockPacketSerializer<GenoaPlayerHurtPacket> {
    public static final GenoaPlayerHurtSerializer_v425_Genoa INSTANCE = new GenoaPlayerHurtSerializer_v425_Genoa();

    @Override
    public void serialize(ByteBuf buffer, BedrockCodecHelper helper, GenoaPlayerHurtPacket packet) {
        buffer.writeIntLE(packet.getInt1());
        buffer.writeIntLE(packet.getInt2());
        buffer.writeFloatLE(packet.getFloat1());
        buffer.writeFloatLE(packet.getFloat2());
        buffer.writeFloatLE(packet.getFloat3());
        buffer.writeFloatLE(packet.getFloat4());
    }

    @Override
    public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, GenoaPlayerHurtPacket packet) {
        packet.setInt1(buffer.readIntLE());
        packet.setInt2(buffer.readIntLE());
        packet.setFloat1(buffer.readFloatLE());
        packet.setFloat2(buffer.readFloatLE());
        packet.setFloat3(buffer.readFloatLE());
        packet.setFloat4(buffer.readFloatLE());
    }
}
