package com.bytedance.sdk.component.g.z.z.z;

import com.bytedance.sdk.component.dl.g.h;
import com.bytedance.sdk.component.g.z.i;
import com.bytedance.sdk.component.g.z.kb;
import com.bytedance.sdk.component.g.z.ls;
import com.bytedance.sdk.component.g.z.p;

/* JADX INFO: loaded from: classes2.dex */
public class fo extends ls {
    public h z;

    public fo(h hVar) {
        this.z = hVar;
    }

    @Override // com.bytedance.sdk.component.g.z.ls
    public long z() {
        return this.z.v();
    }

    @Override // com.bytedance.sdk.component.g.z.ls
    public long g() {
        return this.z.i();
    }

    @Override // com.bytedance.sdk.component.g.z.ls
    public int dl() {
        h hVar = this.z;
        if (hVar != null) {
            return hVar.dl();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.component.g.z.ls
    public boolean a() {
        return this.z.a();
    }

    @Override // com.bytedance.sdk.component.g.z.ls
    public String gc() {
        return this.z.gc();
    }

    @Override // com.bytedance.sdk.component.g.z.ls
    public p m() {
        return new uy(this.z.gz());
    }

    @Override // com.bytedance.sdk.component.g.z.ls
    public com.bytedance.sdk.component.g.z.m e() {
        return new com.bytedance.sdk.component.g.z.m(this.z.e().z);
    }

    @Override // com.bytedance.sdk.component.g.z.ls
    public String z(String str) {
        return this.z.z(str);
    }

    @Override // com.bytedance.sdk.component.g.z.ls
    public String z(String str, String str2) {
        return this.z.z(str, str2);
    }

    @Override // com.bytedance.sdk.component.g.z.ls, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.z.close();
    }

    public String toString() {
        return this.z.toString();
    }

    @Override // com.bytedance.sdk.component.g.z.ls
    public i gz() {
        try {
            return i.z(this.z.g().toString());
        } catch (Exception unused) {
            return i.HTTP_1_1;
        }
    }

    @Override // com.bytedance.sdk.component.g.z.ls
    public kb fo() {
        if (this.z == null) {
            return null;
        }
        return new kb(this.z.pf());
    }
}
