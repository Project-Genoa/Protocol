package org.cloudburstmc.protocol.bedrock.codec.v425_genoa.serializer;

import io.netty.buffer.ByteBuf;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.GenoaDisconnectRequestPacket;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GenoaDisconnectRequestSerializer_v425_Genoa implements BedrockPacketSerializer<GenoaDisconnectRequestPacket> {
    public static final GenoaDisconnectRequestSerializer_v425_Genoa INSTANCE = new GenoaDisconnectRequestSerializer_v425_Genoa();

    @Override
    public void serialize(ByteBuf buffer, BedrockCodecHelper helper, GenoaDisconnectRequestPacket packet) {
    }

    @Override
    public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, GenoaDisconnectRequestPacket packet) {
    }
}
