package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do;

import com.umeng.message.proguard.ad;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public abstract class h implements s {
    private final s a;

    public h(s sVar) {
        if (sVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.a = sVar;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
    public t b() {
        return this.a.b();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.a.close();
    }

    public final s h() {
        return this.a;
    }

    public String toString() {
        return getClass().getSimpleName() + ad.f20405r + this.a.toString() + ad.f20406s;
    }
}
