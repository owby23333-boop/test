package com.bytedance.sdk.component.bf.e.e.e;

import com.bytedance.sdk.component.bf.e.w;
import com.bytedance.sdk.component.d.bf.fy;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class p extends w {
    fy e;

    public p(fy fyVar) {
        this.e = fyVar;
    }

    @Override // com.bytedance.sdk.component.bf.e.w
    public String bf() {
        try {
            return this.e.vn();
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.bytedance.sdk.component.bf.e.w, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        fy fyVar = this.e;
        if (fyVar != null) {
            fyVar.close();
        }
    }

    @Override // com.bytedance.sdk.component.bf.e.w
    public InputStream d() {
        fy fyVar = this.e;
        if (fyVar != null) {
            return fyVar.tg();
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.bf.e.w
    public long e() {
        fy fyVar = this.e;
        if (fyVar != null) {
            return fyVar.bf();
        }
        return -1L;
    }

    @Override // com.bytedance.sdk.component.bf.e.w
    public byte[] tg() {
        try {
            return this.e.ga();
        } catch (Exception unused) {
            return new byte[0];
        }
    }
}
