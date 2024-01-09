package org.cloudburstmc.protocol.bedrock.codec.v425_genoa;

import org.cloudburstmc.protocol.bedrock.codec.BedrockCodec;
import org.cloudburstmc.protocol.bedrock.codec.EntityDataTypeMap;
import org.cloudburstmc.protocol.bedrock.codec.v361.Bedrock_v361;
import org.cloudburstmc.protocol.bedrock.codec.v425_genoa.serializer.*;
import org.cloudburstmc.protocol.bedrock.data.entity.EntityDataFormat;
import org.cloudburstmc.protocol.bedrock.data.entity.EntityDataTypes;
import org.cloudburstmc.protocol.bedrock.packet.*;

public class Bedrock_v425_Genoa extends Bedrock_v361 {
    protected static final EntityDataTypeMap ENTITY_DATA = Bedrock_v361.ENTITY_DATA.toBuilder()
            .insert(EntityDataTypes.GENOA_ENTITY_DATA, 82, EntityDataFormat.BYTE) // TODO: Find out what this is
            .build();

    public static final BedrockCodec CODEC = Bedrock_v361.CODEC.toBuilder()
            .protocolVersion(5000425)
            .minecraftVersion("0.33.0")
            .helper(() -> new BedrockCodecHelper_v425_Genoa(ENTITY_DATA, GAME_RULE_TYPES))
            .updateSerializer(StartGamePacket.class, StartGameSerializer_v425_Genoa.INSTANCE)
            .updateSerializer(InventoryTransactionPacket.class, InventoryTransactionSerializer_v425_Genoa.INSTANCE)
            .updateSerializer(LevelChunkPacket.class, LevelChunkSerializer_v425_Genoa.INSTANCE)
            .updateSerializer(PlayerListPacket.class, PlayerListSerializer_v425_Genoa.INSTANCE)
            .deregisterPacket(ClientCacheStatusPacket.class)
            .deregisterPacket(StructureTemplateDataRequestPacket.class)
            .deregisterPacket(StructureTemplateDataResponsePacket.class)
            .deregisterPacket(UpdateBlockPropertiesPacket.class)
            .deregisterPacket(ClientCacheBlobStatusPacket.class)
            .deregisterPacket(ClientCacheMissResponsePacket.class)
            .registerPacket(GenoaInventoryDataPacket::new, GenoaInventoryDataSerializer_v425_Genoa.INSTANCE, 128)
            .registerPacket(GenoaOpenInventoryPacket::new, GenoaOpenInventorySerializer_v425_Genoa.INSTANCE, 129)
            .registerPacket(GenoaItemPickupPacket::new, GenoaItemPickupSerializer_v425_Genoa.INSTANCE, 130)
            .registerPacket(GenoaShareAnchorPacket::new, GenoaShareAnchorSerializer_v425_Genoa.INSTANCE, 131)
            .registerPacket(GenoaWorldManipulationPacket::new, GenoaWorldManipulationSerializer_v425_Genoa.INSTANCE, 132)
            //.registerPacket(GenoaDisconnectIdPacket::new, GenoaDisconnectIdSerializer_v425_Genoa.INSTANCE, 134) // TODO
            .registerPacket(GenoaItemParticlePacket::new, GenoaItemParticleSerializer_v425_Genoa.INSTANCE, 135)
            .registerPacket(GenoaThirdPersonItemParticlePacket::new, GenoaThirdPersonItemParticleSerializer_v425_Genoa.INSTANCE, 136)
            .registerPacket(GenoaNetworkTransformPacket::new, GenoaNetworkTransformSerializer_v425_Genoa.INSTANCE, 137)
            .registerPacket(GenoaUpdateBlockPacket::new, GenoaUpdateBlockSerializer_v425_Genoa.INSTANCE, 138)
            .registerPacket(GenoaPersonaMobRequestPacket::new, GenoaPersonaMobRequestSerializer_v425_Genoa.INSTANCE, 139)
            //.registerPacket(GenoaBannerMessagePacket::new, GenoaBannerMessageSerializer_v425_Genoa.INSTANCE, 140) // TODO
            .registerPacket(GenoaBlockDestroyPacket::new, GenoaBlockDestroySerializer_v425_Genoa.INSTANCE, 141)
            .registerPacket(GenoaNetworkOwnershipRequestPacket::new, GenoaNetworkOwnershipRequestSerializer_v425_Genoa.INSTANCE, 142)
            .registerPacket(GenoaNetworkOwnershipStatusPacket::new, GenoaNetworkOwnershipStatusSerializer_v425_Genoa.INSTANCE, 143)
            .registerPacket(GenoaPlayerHurtPacket::new, GenoaPlayerHurtSerializer_v425_Genoa.INSTANCE, 144)
            .registerPacket(GenoaSetActorMolangVariablesPacket::new, GenoaSetActorMolangVariablesSerializer_v425_Genoa.INSTANCE, 145)
            .registerPacket(GenoaDisconnectRequestPacket::new, GenoaDisconnectRequestSerializer_v425_Genoa.INSTANCE, 146)
            .registerPacket(GenoaDisconnectStartPacket::new, GenoaDisconnectStartSerializer_v425_Genoa.INSTANCE, 147)
            .registerPacket(GenoaGameplaySettingsPacket::new, GenoaGameplaySettingsSerializer_v425_Genoa.INSTANCE, 148)
            .registerPacket(GenoaBlockHitNoDamagePacket::new, GenoaBlockHitNoDamageSerializer_v425_Genoa.INSTANCE, 149)
            .registerPacket(GenoaItemBrokeNotificationPacket::new, GenoaItemBrokeNotificationSerializer_v425_Genoa.INSTANCE, 150)
            .registerPacket(GenoaGuestPlayerJoinRequestPacket::new, GenoaGuestPlayerJoinRequestSerializer_v425_Genoa.INSTANCE, 151)
            .registerPacket(GenoaGuestPlayerJoinResponsePacket::new, GenoaGuestPlayerJoinResponseSerializer_v425_Genoa.INSTANCE, 152)
            .registerPacket(GenoaItemAwardedNotificationPacket::new, GenoaItemAwardedNotificationSerializer_v425_Genoa.INSTANCE, 153)
            .registerPacket(GenoaEventFlatbufferPacket::new, GenoaEventFlatbufferSerializer_v425_Genoa.INSTANCE, 154)
            .build();
}
