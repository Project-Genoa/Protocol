package org.cloudburstmc.protocol.bedrock.codec.v425_genoa.serializer;

import io.netty.buffer.ByteBuf;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.packet.GenoaUpdateBlockPacket;
import org.cloudburstmc.protocol.bedrock.packet.UpdateBlockPacket;
import org.cloudburstmc.protocol.common.util.VarInts;

import java.util.Set;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GenoaUpdateBlockSerializer_v425_Genoa implements BedrockPacketSerializer<GenoaUpdateBlockPacket> {
    public static final GenoaUpdateBlockSerializer_v425_Genoa INSTANCE = new GenoaUpdateBlockSerializer_v425_Genoa();

    @Override
    public void serialize(ByteBuf buffer, BedrockCodecHelper helper, GenoaUpdateBlockPacket packet) {
        helper.writeBlockPosition(buffer, packet.getBlockPosition()); // 32, 36, 44
        VarInts.writeUnsignedInt(buffer, packet.getRuntimeId()); // 64
        int flagValue = 0;
        for (UpdateBlockPacket.Flag flag : packet.getFlags()) {
            flagValue |= (1 << flag.ordinal());
        }
        VarInts.writeUnsignedInt(buffer, flagValue); // 48

        VarInts.writeUnsignedInt(buffer, packet.getDataLayer()); // 44

        if (packet.isCheckForFloat()) {
            buffer.writeFloat(packet.getFloat1()); // 56
            buffer.writeBoolean(true); // 60
        }
    }

    @Override
    public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, GenoaUpdateBlockPacket packet) {
        packet.setBlockPosition(helper.readBlockPosition(buffer));
        packet.setRuntimeId(VarInts.readUnsignedInt(buffer));

        int flagValue = VarInts.readUnsignedInt(buffer);

        Set<UpdateBlockPacket.Flag> flags = packet.getFlags();
        for (UpdateBlockPacket.Flag flag : UpdateBlockPacket.Flag.values()) {
            if ((flagValue & (1 << flag.ordinal())) != 0) {
                flags.add(flag);
            }
        }

        packet.setDataLayer(VarInts.readUnsignedInt(buffer));

        if (buffer.readableBytes() != 0) {
            float ftemp = buffer.readFloatLE();
            boolean temp = buffer.readBoolean();
            packet.setFloat1(ftemp);
            packet.setCheckForFloat(temp);
        } else {
            packet.setCheckForFloat(false);
        }
    }
}
