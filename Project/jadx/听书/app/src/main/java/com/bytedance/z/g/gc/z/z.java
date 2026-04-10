package com.bytedance.z.g.gc.z;

import android.content.Context;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.z.g.gz;
import com.bytedance.z.g.gz.kb;

/* JADX INFO: loaded from: classes2.dex */
class z extends dl {
    z(Context context, g gVar, a aVar) {
        super(com.bytedance.z.g.dl.ANR, context, gVar, aVar);
    }

    @Override // com.bytedance.z.g.gc.z.dl
    public com.bytedance.z.g.dl.z z(com.bytedance.z.g.dl.z zVar) {
        com.bytedance.z.g.dl.z zVarZ = super.z(zVar);
        com.bytedance.z.g.dl.g gVarZ = com.bytedance.z.g.dl.g.z(this.g);
        gVarZ.z(gz.z().z());
        gVarZ.z(gz.dl().z());
        gVarZ.g(this.dl.dl());
        zVarZ.z(gVarZ);
        zVarZ.z(ContentProviderManager.PLUGIN_PROCESS_NAME, com.bytedance.z.g.gz.z.a(this.g));
        kb.z(zVarZ, gVarZ, this.z);
        return zVarZ;
    }
}
