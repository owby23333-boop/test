package com.bytedance.sdk.component.adexpress.g;

import com.bytedance.sdk.component.adexpress.g.uy;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class wp implements uy.z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AtomicBoolean f582a = new AtomicBoolean(false);
    private fo dl;
    private List<uy> g;
    pf z;

    public wp(List<uy> list, fo foVar) {
        this.g = list;
        this.dl = foVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.g.uy.z
    public void z() {
        this.dl.m();
        Iterator<uy> it = this.g.iterator();
        while (it.hasNext() && !it.next().z(this)) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.g.uy.z
    public void z(uy uyVar) {
        int iIndexOf = this.g.indexOf(uyVar);
        if (iIndexOf < 0) {
            return;
        }
        do {
            iIndexOf++;
            if (iIndexOf >= this.g.size()) {
                return;
            }
        } while (!this.g.get(iIndexOf).z(this));
    }

    @Override // com.bytedance.sdk.component.adexpress.g.uy.z
    public boolean g(uy uyVar) {
        int iIndexOf = this.g.indexOf(uyVar);
        return iIndexOf < this.g.size() - 1 && iIndexOf >= 0;
    }

    @Override // com.bytedance.sdk.component.adexpress.g.uy.z
    public pf g() {
        return this.z;
    }

    @Override // com.bytedance.sdk.component.adexpress.g.uy.z
    public void z(pf pfVar) {
        this.z = pfVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.g.uy.z
    public void z(boolean z) {
        this.f582a.getAndSet(z);
    }

    @Override // com.bytedance.sdk.component.adexpress.g.uy.z
    public boolean dl() {
        return this.f582a.get();
    }
}
