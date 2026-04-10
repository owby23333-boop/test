package com.bytedance.adsdk.z.z;

import com.bytedance.adsdk.z.z.z.fo;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public class z extends dl<com.bytedance.adsdk.z.z.z.g> {
    public z(com.bytedance.adsdk.z.z.dl.g gVar) {
        super(gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.adsdk.z.z.dl
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.z.z.z.g g(com.bytedance.adsdk.z.z.dl.g gVar, fo.z zVar) {
        return new com.bytedance.adsdk.z.z.z.g(gVar, zVar);
    }

    public static z z(final ByteBuffer byteBuffer) {
        return new z(new com.bytedance.adsdk.z.z.dl.z() { // from class: com.bytedance.adsdk.z.z.z.1
            @Override // com.bytedance.adsdk.z.z.dl.z
            public ByteBuffer z() {
                byteBuffer.position(0);
                return byteBuffer;
            }
        });
    }
}
