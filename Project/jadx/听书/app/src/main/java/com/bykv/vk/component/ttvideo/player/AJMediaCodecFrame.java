package com.bykv.vk.component.ttvideo.player;

import com.bytedance.sdk.component.utils.wp;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public class AJMediaCodecFrame implements Cloneable {
    public ByteBuffer data;
    public int flags;
    public int index;
    public long pts = -269488145;
    public int size;

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public AJMediaCodecFrame m483clone() {
        try {
            return (AJMediaCodecFrame) super.clone();
        } catch (Throwable th) {
            wp.z(th);
            return null;
        }
    }
}
