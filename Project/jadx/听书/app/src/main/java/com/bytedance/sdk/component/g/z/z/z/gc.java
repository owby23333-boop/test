package com.bytedance.sdk.component.g.z.z.z;

import com.bytedance.sdk.component.dl.g.tb;
import com.bytedance.sdk.component.g.z.fo;
import com.bytedance.sdk.component.g.z.ls;
import com.bytedance.sdk.component.g.z.v;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class gc implements fo.z {
    tb.z z;

    public gc(tb.z zVar) {
        this.z = zVar;
    }

    @Override // com.bytedance.sdk.component.g.z.fo.z
    public v z() {
        return new gz(this.z.z());
    }

    @Override // com.bytedance.sdk.component.g.z.fo.z
    public ls z(v vVar) throws IOException {
        return new fo(this.z.z(this.z.z().m().z(vVar.g().z()).z()));
    }
}
