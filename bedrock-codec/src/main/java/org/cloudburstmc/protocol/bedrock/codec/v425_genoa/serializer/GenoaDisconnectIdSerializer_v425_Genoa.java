package org.cloudburstmc.protocol.bedrock.codec.v425_genoa.serializer;

import io.netty.buffer.ByteBuf;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.BedrockPacketSerializer;
import org.cloudburstmc.protocol.bedrock.data.GenoaDisconnectItem1;
import org.cloudburstmc.protocol.bedrock.data.GenoaDisconnectItem2;
import org.cloudburstmc.protocol.bedrock.data.GenoaDisconnectItem3;
import org.cloudburstmc.protocol.bedrock.packet.GenoaDisconnectIdPacket;

import java.util.LinkedList;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GenoaDisconnectIdSerializer_v425_Genoa implements BedrockPacketSerializer<GenoaDisconnectIdPacket> {
    public static final GenoaDisconnectIdSerializer_v425_Genoa INSTANCE = new GenoaDisconnectIdSerializer_v425_Genoa();

    // TODO: This packet is garbage, but this structure should parse it at least somewhat correctly.

    @Override
    public void serialize(ByteBuf buffer, BedrockCodecHelper helper, GenoaDisconnectIdPacket packet) {
        this.writeStreamIds(buffer, packet);

        helper.writeArray(buffer, packet.getKilledMobs(), ByteBuf::writeIntLE, this::writeDisconnectItem1);
        helper.writeArray(buffer, packet.getRewardedItems(), this::writeDisconnectItem2);

        buffer.writeIntLE((int) packet.getPlayerRuntimeId());
        helper.writeArray(buffer, packet.getRewardedTokens(), helper::writeUuid);
        helper.writeArray(buffer, packet.getBrokenBlocks(), helper::writeString);

        buffer.writeIntLE((int) packet.getUInt2());
        helper.writeArray(buffer, packet.getDisconnectItems3(), this::writeDisconnectItem3);

        buffer.writeIntLE(packet.getSInt1());
        buffer.writeBoolean(packet.isHasDied());
    }

    @Override
    public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, GenoaDisconnectIdPacket packet) {
        this.readStreamIds(buffer, packet);

        LinkedList<GenoaDisconnectItem1> killedMobs = new LinkedList<>();
        helper.readArray(buffer, packet.getKilledMobs(), ByteBuf::readIntLE, this::readDisconnectItem1);
        helper.readArray(buffer, packet.getRewardedItems(), this::readDisconnectItem2);

        packet.setPlayerRuntimeId(buffer.readUnsignedIntLE());
        helper.readArray(buffer, packet.getRewardedTokens(), helper::readUuid);
        helper.readArray(buffer, packet.getBrokenBlocks(), helper::readString);

        packet.setUInt2(buffer.readUnsignedIntLE());
        helper.readArray(buffer, packet.getDisconnectItems3(), this::readDisconnectItem3);

        packet.setSInt1(buffer.readIntLE());
        packet.setHasDied(buffer.readBoolean());
    }

    protected GenoaDisconnectItem1 readDisconnectItem1(ByteBuf buffer, BedrockCodecHelper helper) {
        return new GenoaDisconnectItem1(buffer.readUnsignedIntLE(), buffer.readIntLE(), helper.readUuid(buffer));
    }

    protected void writeDisconnectItem1(ByteBuf buffer, BedrockCodecHelper helper, GenoaDisconnectItem1 item) {
        buffer.writeIntLE((int) item.getUint1());
        buffer.writeIntLE(item.getSint1());
        helper.writeUuid(buffer, item.getUuid1());
    }

    protected GenoaDisconnectItem2 readDisconnectItem2(ByteBuf buffer, BedrockCodecHelper helper) {
        return new GenoaDisconnectItem2(helper.readUuid(buffer), buffer.readUnsignedIntLE());
    }

    protected void writeDisconnectItem2(ByteBuf buffer, BedrockCodecHelper helper, GenoaDisconnectItem2 item) {
        helper.writeUuid(buffer, item.getUuid1());
        buffer.writeIntLE((int) item.getUint1());
    }

    protected GenoaDisconnectItem3 readDisconnectItem3(ByteBuf buffer, BedrockCodecHelper helper) {
        return new GenoaDisconnectItem3(helper.readUuid(buffer), buffer.readIntLE());
    }

    protected void writeDisconnectItem3(ByteBuf buffer, BedrockCodecHelper helper, GenoaDisconnectItem3 item) {
        helper.writeUuid(buffer, item.getUuid1());
        buffer.writeIntLE(item.getInt1());
    }

    protected void readStreamIds(ByteBuf buffer, GenoaDisconnectIdPacket packet) {
        if (buffer.readBoolean()) {
            packet.setBoostStreamVersion(buffer.readLongLE());
        }

        if (buffer.readBoolean()) {
            packet.setBuildplatesStreamVersion(buffer.readLongLE());
        }

        if (buffer.readBoolean()) {
            packet.setChallengesStreamVersion(buffer.readLongLE());
        }

        if (buffer.readBoolean()) {
            packet.setProfilesStreamVersion(buffer.readLongLE());
        }

        if (buffer.readBoolean()) {
            packet.setCraftingStreamVersion(buffer.readLongLE());
        }

        if (buffer.readBoolean()) {
            packet.setInventoryStreamVersion(buffer.readLongLE());
        }

        if (buffer.readBoolean()) {
            packet.setSmeltingStreamVersion(buffer.readLongLE());
        }

        if (buffer.readBoolean()) {
            packet.setTokensStreamVersion(buffer.readLongLE());
        }
    }

    protected void writeStreamIds(ByteBuf buffer, GenoaDisconnectIdPacket packet) {
        buffer.writeBoolean(packet.getBoostStreamVersion() != 0);
        if (packet.getBoostStreamVersion() != 0) {
            buffer.writeLongLE(packet.getBoostStreamVersion());
        }

        buffer.writeBoolean(packet.getBuildplatesStreamVersion() != 0);
        if (packet.getBuildplatesStreamVersion() != 0) {
            buffer.writeLongLE(packet.getBuildplatesStreamVersion());
        }

        buffer.writeBoolean(packet.getChallengesStreamVersion() != 0);
        if (packet.getChallengesStreamVersion() != 0) {
            buffer.writeLongLE(packet.getChallengesStreamVersion());
        }

        buffer.writeBoolean(packet.getProfilesStreamVersion() != 0);
        if (packet.getProfilesStreamVersion() != 0) {
            buffer.writeLongLE(packet.getProfilesStreamVersion());
        }

        buffer.writeBoolean(packet.getCraftingStreamVersion() != 0);
        if (packet.getCraftingStreamVersion() != 0) {
            buffer.writeLongLE(packet.getCraftingStreamVersion());
        }

        buffer.writeBoolean(packet.getInventoryStreamVersion() != 0);
        if (packet.getInventoryStreamVersion() != 0) {
            buffer.writeLongLE(packet.getInventoryStreamVersion());
        }

        buffer.writeBoolean(packet.getSmeltingStreamVersion() != 0);
        if (packet.getSmeltingStreamVersion() != 0) {
            buffer.writeLongLE(packet.getSmeltingStreamVersion());
        }

        buffer.writeBoolean(packet.getTokensStreamVersion() != 0);
        if (packet.getTokensStreamVersion() != 0) {
            buffer.writeLongLE(packet.getTokensStreamVersion());
        }
    }
}
