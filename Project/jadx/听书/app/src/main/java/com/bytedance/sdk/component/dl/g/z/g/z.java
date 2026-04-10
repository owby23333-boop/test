package com.bytedance.sdk.component.dl.g.z.g;

import com.bytedance.sdk.component.dl.g.h;
import com.bytedance.sdk.component.dl.g.sy;
import com.bytedance.sdk.component.dl.g.tb;
import com.bytedance.sdk.component.dl.g.zw;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class z implements tb {
    public final zw z;

    public z(zw zwVar) {
        this.z = zwVar;
    }

    @Override // com.bytedance.sdk.component.dl.g.tb
    public h z(tb.z zVar) throws IOException {
        com.bytedance.sdk.component.dl.g.z.dl.e eVar = (com.bytedance.sdk.component.dl.g.z.dl.e) zVar;
        sy syVarZ = eVar.z();
        if (syVarZ != null && syVarZ.m != null) {
            syVarZ.m.g();
        }
        e eVarM = eVar.m();
        com.bytedance.sdk.component.dl.g.z.dl.dl dlVarZ = eVarM.z(this.z, zVar, !syVarZ.g().equals("GET"));
        dl dlVarG = eVarM.g();
        if (syVarZ != null && syVarZ.m != null) {
            syVarZ.m.dl();
        }
        return eVar.z(syVarZ, eVarM, dlVarZ, dlVarG);
    }
}
