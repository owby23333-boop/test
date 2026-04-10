package com.bytedance.sdk.component.g.z.z.z;

import com.bytedance.sdk.component.dl.g.gk;
import com.bytedance.sdk.component.dl.g.q;
import com.bytedance.sdk.component.g.z.p;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class uy extends p {
    gk z;

    uy(gk gkVar) {
        this.z = gkVar;
    }

    @Override // com.bytedance.sdk.component.g.z.p
    public long z() {
        gk gkVar = this.z;
        if (gkVar != null) {
            return gkVar.g();
        }
        return -1L;
    }

    @Override // com.bytedance.sdk.component.g.z.p
    public String g() {
        try {
            return this.z.m();
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.bytedance.sdk.component.g.z.p, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        gk gkVar = this.z;
        if (gkVar != null) {
            gkVar.close();
        }
    }

    @Override // com.bytedance.sdk.component.g.z.p
    public InputStream dl() {
        gk gkVar = this.z;
        if (gkVar != null) {
            return gkVar.a();
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.g.z.p
    public byte[] a() {
        try {
            return this.z.gc();
        } catch (Exception unused) {
            return new byte[0];
        }
    }

    @Override // com.bytedance.sdk.component.g.z.p
    public com.bytedance.sdk.component.g.z.uy gc() {
        q qVarZ;
        gk gkVar = this.z;
        if (gkVar == null || (qVarZ = gkVar.z()) == null) {
            return null;
        }
        return new com.bytedance.sdk.component.g.z.uy(qVarZ.toString(), qVarZ.z(), qVarZ.g(), qVarZ.dl() != null ? qVarZ.dl().name() : null);
    }
}
