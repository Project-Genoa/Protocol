package org.cloudburstmc.protocol.bedrock.codec.v425_genoa;

import io.netty.buffer.ByteBuf;
import org.cloudburstmc.math.vector.Vector3i;
import org.cloudburstmc.protocol.bedrock.codec.EntityDataTypeMap;
import org.cloudburstmc.protocol.bedrock.codec.v361.BedrockCodecHelper_v361;
import org.cloudburstmc.protocol.bedrock.codec.v388.BedrockCodecHelper_v388;
import org.cloudburstmc.protocol.bedrock.data.skin.SerializedSkin;
import org.cloudburstmc.protocol.bedrock.packet.InventoryTransactionPacket;
import org.cloudburstmc.protocol.common.util.TypeMap;
import org.cloudburstmc.protocol.common.util.VarInts;

import static org.cloudburstmc.protocol.common.util.Preconditions.checkNotNull;

public class BedrockCodecHelper_v425_Genoa extends BedrockCodecHelper_v361 {
    private final BedrockCodecHelper_v388 bedrockCodecHelper_v388;

    public BedrockCodecHelper_v425_Genoa(EntityDataTypeMap entityData, TypeMap<Class<?>> gameRulesTypes) {
        super(entityData, gameRulesTypes);
        bedrockCodecHelper_v388 = new BedrockCodecHelper_v388(entityData, gameRulesTypes);
    }

    @Override
    public SerializedSkin readSkin(ByteBuf buffer) {
        return bedrockCodecHelper_v388.readSkin(buffer);
    }

    @Override
    public void writeSkin(ByteBuf buffer, SerializedSkin skin) {
        bedrockCodecHelper_v388.writeSkin(buffer, skin);
    }

    @Override
    public void readItemUse(ByteBuf buffer, InventoryTransactionPacket packet) {
        packet.setActionType(VarInts.readUnsignedInt(buffer));
        packet.setBlockPosition(this.readGenoaBlockPosition(buffer));
        packet.setBlockFace(VarInts.readInt(buffer));
        packet.setHotbarSlot(VarInts.readInt(buffer));
        packet.setItemInHand(this.readItem(buffer));
        packet.setPlayerPosition(this.readVector3f(buffer));
        packet.setClickPosition(this.readVector3f(buffer));

        packet.setBlockDefinition(this.blockDefinitions.getDefinition(VarInts.readUnsignedInt(buffer)));
    }

    @Override
    public void writeItemUse(ByteBuf buffer, InventoryTransactionPacket packet) {
        VarInts.writeUnsignedInt(buffer, packet.getActionType());
        this.writeGenoaBlockPosition(buffer, packet.getBlockPosition());
        VarInts.writeInt(buffer, packet.getBlockFace());
        VarInts.writeInt(buffer, packet.getHotbarSlot());
        this.writeItem(buffer, packet.getItemInHand());
        this.writeVector3f(buffer, packet.getPlayerPosition());
        this.writeVector3f(buffer, packet.getClickPosition());

        VarInts.writeUnsignedInt(buffer, packet.getBlockDefinition().getRuntimeId());
    }

    public Vector3i readGenoaBlockPosition(ByteBuf buffer) {
        int w = VarInts.readInt(buffer);
        int x = VarInts.readInt(buffer);
        int y = VarInts.readUnsignedInt(buffer);
        int z = VarInts.readInt(buffer);

        return Vector3i.from(x, y, z);
    }

    public void writeGenoaBlockPosition(ByteBuf buffer, Vector3i blockPosition) {
        checkNotNull(blockPosition, "blockPosition");
        VarInts.writeInt(buffer, -63);
        VarInts.writeInt(buffer, blockPosition.getX());
        VarInts.writeUnsignedInt(buffer, blockPosition.getY());
        VarInts.writeInt(buffer, blockPosition.getZ());
    }
}