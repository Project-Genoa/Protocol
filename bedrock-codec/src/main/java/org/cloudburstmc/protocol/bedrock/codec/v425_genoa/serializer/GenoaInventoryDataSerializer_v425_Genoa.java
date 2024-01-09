package org.cloudburstmc.protocol.bedrock.codec.v425_genoa.serializer;

import io.netty.buffer.ByteBuf;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.GenoaInventoryDataPacket;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GenoaInventoryDataSerializer_v425_Genoa implements BedrockPacketSerializer<GenoaInventoryDataPacket> {
    public static final GenoaInventoryDataSerializer_v425_Genoa INSTANCE = new GenoaInventoryDataSerializer_v425_Genoa();

    @Override
    public void serialize(ByteBuf buffer, BedrockCodecHelper helper, GenoaInventoryDataPacket packet) {
        helper.writeString(buffer, packet.getJson());
    }

    @Override
    public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, GenoaInventoryDataPacket packet) {
        packet.setJson(helper.readString(buffer));
    }
}
