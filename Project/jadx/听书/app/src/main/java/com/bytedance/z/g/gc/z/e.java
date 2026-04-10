package com.bytedance.z.g.gc.z;

import android.content.Context;
import com.bytedance.z.g.gz;
import com.bytedance.z.g.gz.kb;

/* JADX INFO: loaded from: classes2.dex */
class e extends dl {
    e(Context context, g gVar, a aVar) {
        super(com.bytedance.z.g.dl.JAVA, context, gVar, aVar);
    }

    @Override // com.bytedance.z.g.gc.z.dl
    public com.bytedance.z.g.dl.z z(com.bytedance.z.g.dl.z zVar) {
        com.bytedance.z.g.dl.z zVarZ = super.z(zVar);
        zVarZ.z("app_count", (Object) 1);
        zVarZ.z("magic_tag", "ss_app_log");
        dl(zVarZ);
        com.bytedance.z.g.dl.g gVarZ = com.bytedance.z.g.dl.g.z(this.g);
        gVarZ.z(gz.z().z());
        gVarZ.z(gz.dl().z());
        gVarZ.g(this.dl.dl());
        zVarZ.z(gVarZ);
        kb.z(zVarZ, gVarZ, this.z);
        return zVarZ;
    }
}
