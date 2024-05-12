package org.cloudburstmc.protocol.bedrock.packet;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.cloudburstmc.protocol.bedrock.data.GenoaDisconnectItem1;
import org.cloudburstmc.protocol.bedrock.data.GenoaDisconnectItem2;
import org.cloudburstmc.protocol.bedrock.data.GenoaDisconnectItem3;
import org.cloudburstmc.protocol.common.PacketSignal;

import java.util.List;
import java.util.UUID;

@Data
@EqualsAndHashCode(doNotUseGetters = true)
@ToString(doNotUseGetters = true)
public class GenoaDisconnectIdPacket implements BedrockPacket {
    private long boostStreamVersion;
    private long buildplatesStreamVersion;
    private long challengesStreamVersion;
    private long profilesStreamVersion;
    private long craftingStreamVersion;
    private long inventoryStreamVersion;
    private long smeltingStreamVersion;
    private long tokensStreamVersion;

    private List<GenoaDisconnectItem1> killedMobs = new ObjectArrayList<>(); // Not sure
    private List<GenoaDisconnectItem2> rewardedItems = new ObjectArrayList<>(); // Not sure

    private long playerRuntimeId; // Not sure
    private List<UUID> rewardedTokens = new ObjectArrayList<>(); // Not sure
    private List<String> brokenBlocks = new ObjectArrayList<>(); // Not sure
    private long uInt2;
    private List<GenoaDisconnectItem3> disconnectItems3 = new ObjectArrayList<>();
    private int sInt1;
    private boolean hasDied; // Not sure

    @Override
    public final PacketSignal handle(BedrockPacketHandler handler) {
        return handler.handle(this);
    }

    public BedrockPacketType getPacketType() {
        return BedrockPacketType.GENOA_DISCONNECT_ID;
    }
}
