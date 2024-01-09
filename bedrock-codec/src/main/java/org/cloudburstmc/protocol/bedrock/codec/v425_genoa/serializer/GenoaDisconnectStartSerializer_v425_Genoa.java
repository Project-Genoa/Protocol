package org.cloudburstmc.protocol.bedrock.codec.v425_genoa.serializer;

import io.netty.buffer.ByteBuf;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.GenoaDisconnectStartPacket;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GenoaDisconnectStartSerializer_v425_Genoa implements BedrockPacketSerializer<GenoaDisconnectStartPacket> {
    public static final GenoaDisconnectStartSerializer_v425_Genoa INSTANCE = new GenoaDisconnectStartSerializer_v425_Genoa();

    @Override
    public void serialize(ByteBuf buffer, BedrockCodecHelper helper, GenoaDisconnectStartPacket packet) {
        buffer.writeByte(packet.getByte1());
    }

    @Override
    public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, GenoaDisconnectStartPacket packet) {
        packet.setByte1(buffer.readByte());
    }
}
