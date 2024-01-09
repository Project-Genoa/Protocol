package org.cloudburstmc.protocol.bedrock.codec.v425_genoa.serializer;

import io.netty.buffer.ByteBuf;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.GenoaItemPickupPacket;
import org.cloudburstmc.protocol.common.util.VarInts;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GenoaItemPickupSerializer_v425_Genoa implements BedrockPacketSerializer<GenoaItemPickupPacket> {
    public static final GenoaItemPickupSerializer_v425_Genoa INSTANCE = new GenoaItemPickupSerializer_v425_Genoa();

    @Override
    public void serialize(ByteBuf buffer, BedrockCodecHelper helper, GenoaItemPickupPacket packet) {
        VarInts.writeUnsignedLong(buffer, packet.getItemId());
        VarInts.writeUnsignedLong(buffer, packet.getRuntimeEntityId());
    }

    @Override
    public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, GenoaItemPickupPacket packet) {
        packet.setItemId(VarInts.readUnsignedLong(buffer));
        packet.setRuntimeEntityId(VarInts.readUnsignedLong(buffer));
    }
}
