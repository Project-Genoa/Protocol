package org.cloudburstmc.protocol.bedrock.packet;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.cloudburstmc.math.vector.Vector3i;
import org.cloudburstmc.protocol.common.PacketSignal;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

@Data
@EqualsAndHashCode(doNotUseGetters = true)
@ToString(doNotUseGetters = true)
public class GenoaUpdateBlockPacket implements BedrockPacket {
    public static final Set<UpdateBlockPacket.Flag> FLAG_ALL = Collections.unmodifiableSet(EnumSet.of(UpdateBlockPacket.Flag.NEIGHBORS, UpdateBlockPacket.Flag.NETWORK));
    public static final Set<UpdateBlockPacket.Flag> FLAG_ALL_PRIORITY = Collections.unmodifiableSet(
            EnumSet.of(UpdateBlockPacket.Flag.NEIGHBORS, UpdateBlockPacket.Flag.NETWORK, UpdateBlockPacket.Flag.PRIORITY));

    final Set<UpdateBlockPacket.Flag> flags = EnumSet.noneOf(UpdateBlockPacket.Flag.class);
    Vector3i blockPosition;
    int runtimeId;
    int dataLayer;

    public float Float1;
    public boolean CheckForFloat;

    @Override
    public final PacketSignal handle(BedrockPacketHandler handler) {
        return handler.handle(this);
    }

    public BedrockPacketType getPacketType() {
        return BedrockPacketType.GENOA_UPDATE_BLOCK;
    }
}
