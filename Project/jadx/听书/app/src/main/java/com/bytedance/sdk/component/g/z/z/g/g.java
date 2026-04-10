package com.bytedance.sdk.component.g.z.z.g;

import com.bytedance.sdk.component.g.z.fo;
import com.bytedance.sdk.component.g.z.ls;
import com.bytedance.sdk.component.g.z.v;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class g implements fo.z {
    int dl = 0;
    v g;
    List<fo> z;

    g(List<fo> list, v vVar) {
        this.z = list;
        this.g = vVar;
    }

    @Override // com.bytedance.sdk.component.g.z.fo.z
    public v z() {
        return this.g;
    }

    @Override // com.bytedance.sdk.component.g.z.fo.z
    public ls z(v vVar) throws IOException {
        this.g = vVar;
        int i = this.dl + 1;
        this.dl = i;
        return this.z.get(i).z(this);
    }
}
