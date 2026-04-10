package com.bytedance.z.g.gc.z;

import android.content.Context;
import com.bytedance.z.g.gz;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
class m extends dl {
    m(Context context, g gVar, a aVar) {
        super(com.bytedance.z.g.dl.CUSTOM_JAVA, context, gVar, aVar);
    }

    @Override // com.bytedance.z.g.gc.z.dl
    public com.bytedance.z.g.dl.z z(com.bytedance.z.g.dl.z zVar) {
        com.bytedance.z.g.dl.z zVarZ = super.z(zVar);
        com.bytedance.z.g.dl.g gVarZ = com.bytedance.z.g.dl.g.z(this.g);
        gVarZ.z(gz.z().z());
        gVarZ.z(gz.dl().z());
        gVarZ.g(this.dl.dl());
        zVarZ.z(gVarZ);
        return zVarZ;
    }
}
