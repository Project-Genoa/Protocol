package org.cloudburstmc.protocol.bedrock.codec.v425_genoa.serializer;

import io.netty.buffer.ByteBuf;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.GenoaEventFlatbufferPacket;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GenoaEventFlatbufferSerializer_v425_Genoa implements BedrockPacketSerializer<GenoaEventFlatbufferPacket> {
    public static final GenoaEventFlatbufferSerializer_v425_Genoa INSTANCE = new GenoaEventFlatbufferSerializer_v425_Genoa();

    @Override
    public void serialize(ByteBuf buffer, BedrockCodecHelper helper, GenoaEventFlatbufferPacket packet) {
        // TODO: Array

        //helper.writeByteArray(buffer,packet.getByteArr());
    }

    @Override
    public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, GenoaEventFlatbufferPacket packet) {
        //packet.setByteArr(helper.readByteArray(buffer));
    }
}
