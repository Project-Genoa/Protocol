package org.cloudburstmc.protocol.bedrock.packet;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.cloudburstmc.math.vector.Vector4f;
import org.cloudburstmc.protocol.common.PacketSignal;

@Data
@EqualsAndHashCode(doNotUseGetters = true)
@ToString(doNotUseGetters = true)
public class GenoaShareAnchorPacket implements BedrockPacket {
    //No clue what any of these are yet

    /*public float f1;
    public float f2;
    public float f3;
    public float f4;
    public float f5;
    public float f6;
    public float f7;
    public float f8;
    public float f9;
    public float f10;
    public float f11;
    public float f12;
    public float f13;
    public float f14;
    public float f15;
    public float f16;*/
    Vector4f bottomLeft;
    Vector4f bottomRight;
    Vector4f topLeft;
    Vector4f topRight;

    @Override
    public final PacketSignal handle(BedrockPacketHandler handler) {
        return handler.handle(this);
    }

    public BedrockPacketType getPacketType() {
        return BedrockPacketType.GENOA_SHARE_ANCHOR;
    }
}
