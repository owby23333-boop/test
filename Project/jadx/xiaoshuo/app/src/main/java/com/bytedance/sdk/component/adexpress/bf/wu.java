package com.bytedance.sdk.component.adexpress.bf;

import com.bytedance.sdk.component.adexpress.bf.zk;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class wu implements zk.e {
    private List<zk> bf;
    private v d;
    t e;
    private AtomicBoolean tg = new AtomicBoolean(false);

    public wu(List<zk> list, v vVar) {
        this.bf = list;
        this.d = vVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.bf.zk.e
    public boolean bf(zk zkVar) {
        int iIndexOf = this.bf.indexOf(zkVar);
        return iIndexOf < this.bf.size() - 1 && iIndexOf >= 0;
    }

    @Override // com.bytedance.sdk.component.adexpress.bf.zk.e
    public boolean d() {
        return this.tg.get();
    }

    @Override // com.bytedance.sdk.component.adexpress.bf.zk.e
    public void e() {
        this.d.tg();
        Iterator<zk> it = this.bf.iterator();
        while (it.hasNext() && !it.next().e(this)) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.bf.zk.e
    public t bf() {
        return this.e;
    }

    @Override // com.bytedance.sdk.component.adexpress.bf.zk.e
    public void e(zk zkVar) {
        int iIndexOf = this.bf.indexOf(zkVar);
        if (iIndexOf < 0) {
            return;
        }
        do {
            iIndexOf++;
            if (iIndexOf >= this.bf.size()) {
                return;
            }
        } while (!this.bf.get(iIndexOf).e(this));
    }

    @Override // com.bytedance.sdk.component.adexpress.bf.zk.e
    public void e(t tVar) {
        this.e = tVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.bf.zk.e
    public void e(boolean z) {
        this.tg.getAndSet(z);
    }
}
