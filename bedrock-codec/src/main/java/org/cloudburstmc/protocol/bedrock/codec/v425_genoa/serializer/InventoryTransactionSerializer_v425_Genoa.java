package org.cloudburstmc.protocol.bedrock.codec.v425_genoa.serializer;

import io.netty.buffer.ByteBuf;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.cloudburstmc.protocol.bedrock.codec.BedrockCodecHelper;
import org.cloudburstmc.protocol.bedrock.codec.v291.serializer.InventoryTransactionSerializer_v291;
import org.cloudburstmc.protocol.bedrock.data.inventory.transaction.InventoryTransactionType;
import org.cloudburstmc.protocol.bedrock.packet.InventoryTransactionPacket;
import org.cloudburstmc.protocol.common.util.VarInts;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class InventoryTransactionSerializer_v425_Genoa extends InventoryTransactionSerializer_v291 {
    public static final InventoryTransactionSerializer_v425_Genoa INSTANCE = new InventoryTransactionSerializer_v425_Genoa();

    @Override
    public void serialize(ByteBuf buffer, BedrockCodecHelper helper, InventoryTransactionPacket packet) {
        // TODO: Still not working, needs proper fixing

        InventoryTransactionType transactionType = packet.getTransactionType();
        VarInts.writeUnsignedInt(buffer, transactionType.ordinal());

        helper.writeInventoryActions(buffer, packet.getActions(), false);

        switch (transactionType) {
            case ITEM_USE:
                helper.writeItemUse(buffer, packet);
                break;
            case ITEM_USE_ON_ENTITY:
                this.writeItemUseOnEntity(buffer, helper, packet);
                break;
            case ITEM_RELEASE:
                this.writeItemRelease(buffer, helper, packet);
                break;
        }
    }

    @Override
    public void deserialize(ByteBuf buffer, BedrockCodecHelper helper, InventoryTransactionPacket packet) {
        InventoryTransactionType transactionType = InventoryTransactionType.values()[VarInts.readUnsignedInt(buffer)];
        packet.setTransactionType(transactionType);

        //boolean hasNetworkIds = buffer.readBoolean();
        //packet.setHasNetworkIds(hasNetworkIds);

        helper.readInventoryActions(buffer, packet.getActions());

        switch (transactionType) {
            case ITEM_USE:
                helper.readItemUse(buffer, packet);
                break;
            case ITEM_USE_ON_ENTITY:
                this.readItemUseOnEntity(buffer, helper, packet);
                break;
            case ITEM_RELEASE:
                this.readItemRelease(buffer, helper, packet);
                break;
        }
    }
}
