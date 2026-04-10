package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public abstract class z {

    static final class a extends z {
        final /* synthetic */ u a;
        final /* synthetic */ int b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ byte[] f1313c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f1314d;

        a(u uVar, int i2, byte[] bArr, int i3) {
            this.a = uVar;
            this.b = i2;
            this.f1313c = bArr;
            this.f1314d = i3;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.z
        public long a() {
            return this.b;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.z
        public void a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d dVar) throws IOException {
            dVar.write(this.f1313c, this.f1314d, this.b);
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.z
        public u b() {
            return this.a;
        }
    }

    public static z a(u uVar, String str) {
        Charset charsetA = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.f1149i;
        if (uVar != null && (charsetA = uVar.a()) == null) {
            charsetA = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.f1149i;
            uVar = u.a(uVar + "; charset=utf-8");
        }
        return a(uVar, str.getBytes(charsetA));
    }

    public static z a(u uVar, byte[] bArr) {
        return a(uVar, bArr, 0, bArr.length);
    }

    public static z a(u uVar, byte[] bArr, int i2, int i3) {
        if (bArr == null) {
            throw new NullPointerException("content == null");
        }
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(bArr.length, i2, i3);
        return new a(uVar, i3, bArr, i2);
    }

    public abstract long a() throws IOException;

    public abstract void a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d dVar) throws IOException;

    public abstract u b();
}
