package org.cloudburstmc.protocol.bedrock.data;

import lombok.Value;

import java.util.UUID;

@Value
public class GenoaItemAwardedNotification {
    public int runtimeEntityId;
    public int amount;
    public UUID catalogItemUuid;
}
