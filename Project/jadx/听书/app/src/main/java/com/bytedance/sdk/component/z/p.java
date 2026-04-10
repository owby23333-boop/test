package com.bytedance.sdk.component.z;

import com.bytedance.sdk.component.z.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class p {
    static iq z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final uy f862a;
    private final com.bytedance.sdk.component.i.dl dl;
    private final z g;
    private final List<v> gc;
    private volatile boolean m;

    public static uy z(com.bytedance.sdk.component.i.dl dlVar) {
        return new uy(dlVar);
    }

    public <T> void z(String str, T t) {
        g();
        this.g.z(str, t);
    }

    public p z(String str, gc<?, ?> gcVar) {
        return z(str, (String) null, gcVar);
    }

    public p z(String str, String str2, gc<?, ?> gcVar) {
        g();
        this.g.e.z(str, gcVar);
        return this;
    }

    public p z(String str, a.g gVar) {
        return z(str, (String) null, gVar);
    }

    public p z(String str, String str2, a.g gVar) {
        g();
        this.g.e.z(str, gVar);
        return this;
    }

    public void z() {
        if (this.m) {
            return;
        }
        this.g.g();
        this.m = true;
        Iterator<v> it = this.gc.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    p(uy uyVar) {
        iq iqVar;
        ArrayList arrayList = new ArrayList();
        this.gc = arrayList;
        this.m = false;
        this.f862a = uyVar;
        q qVarZ = (!uyVar.gz || (iqVar = z) == null) ? null : iqVar.z(uyVar.kb);
        if (uyVar.z != null && uyVar.g == null) {
            this.g = new uf();
        } else {
            this.g = uyVar.g;
        }
        this.g.z(uyVar, qVarZ);
        this.dl = uyVar.z;
        arrayList.add(uyVar.uy);
        fo.z(uyVar.m);
        io.z(uyVar.e);
    }

    private void g() {
        if (this.m) {
            fo.z(new IllegalStateException("JsBridge2 is already released!!!"));
        }
    }
}
