package com.bytedance.sdk.component.bf.e.e.bf;

import com.bytedance.sdk.component.bf.e.bh;
import com.bytedance.sdk.component.bf.e.s;
import com.bytedance.sdk.component.bf.e.zk;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class bf implements zk.e {
    bh bf;
    int d = 0;
    List<zk> e;

    public bf(List<zk> list, bh bhVar) {
        this.e = list;
        this.bf = bhVar;
    }

    @Override // com.bytedance.sdk.component.bf.e.zk.e
    public bh e() {
        return this.bf;
    }

    @Override // com.bytedance.sdk.component.bf.e.zk.e
    public s e(bh bhVar) throws IOException {
        this.bf = bhVar;
        int i = this.d + 1;
        this.d = i;
        return this.e.get(i).e(this);
    }
}
