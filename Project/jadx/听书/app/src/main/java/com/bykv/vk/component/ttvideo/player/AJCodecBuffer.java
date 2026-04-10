package com.bykv.vk.component.ttvideo.player;

import com.bytedance.sdk.component.utils.wp;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public class AJCodecBuffer implements Cloneable {
    public ByteBuffer data;
    public int index;
    public long pts;
    public int size;

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public AJCodecBuffer m482clone() {
        AJCodecBuffer aJCodecBuffer;
        try {
            aJCodecBuffer = (AJCodecBuffer) super.clone();
        } catch (Throwable th) {
            wp.z(th);
            aJCodecBuffer = null;
        }
        aJCodecBuffer.size = this.size;
        aJCodecBuffer.pts = this.pts;
        aJCodecBuffer.index = this.index;
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(this.size);
        byteBufferAllocateDirect.put(this.data);
        aJCodecBuffer.data = byteBufferAllocateDirect;
        return aJCodecBuffer;
    }
}
