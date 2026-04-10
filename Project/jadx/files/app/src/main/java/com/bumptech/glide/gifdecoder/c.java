package com.bumptech.glide.gifdecoder;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* JADX INFO: compiled from: GifHeaderParser.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {
    private ByteBuffer b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b f13336c;
    private final byte[] a = new byte[256];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f13337d = 0;

    private boolean c() {
        return this.f13336c.b != 0;
    }

    private int d() {
        try {
            return this.b.get() & 255;
        } catch (Exception unused) {
            this.f13336c.b = 1;
            return 0;
        }
    }

    private void e() {
        this.f13336c.f13326d.a = l();
        this.f13336c.f13326d.b = l();
        this.f13336c.f13326d.f13316c = l();
        this.f13336c.f13326d.f13317d = l();
        int iD = d();
        boolean z2 = (iD & 128) != 0;
        int iPow = (int) Math.pow(2.0d, (iD & 7) + 1);
        this.f13336c.f13326d.f13318e = (iD & 64) != 0;
        if (z2) {
            this.f13336c.f13326d.f13324k = a(iPow);
        } else {
            this.f13336c.f13326d.f13324k = null;
        }
        this.f13336c.f13326d.f13323j = this.b.position();
        o();
        if (c()) {
            return;
        }
        b bVar = this.f13336c;
        bVar.f13325c++;
        bVar.f13327e.add(bVar.f13326d);
    }

    private void f() {
        this.f13337d = d();
        if (this.f13337d > 0) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.f13337d) {
                try {
                    i3 = this.f13337d - i2;
                    this.b.get(this.a, i2, i3);
                    i2 += i3;
                } catch (Exception unused) {
                    if (Log.isLoggable("GifHeaderParser", 3)) {
                        String str = "Error Reading Block n: " + i2 + " count: " + i3 + " blockSize: " + this.f13337d;
                    }
                    this.f13336c.b = 1;
                    return;
                }
            }
        }
    }

    private void g() {
        b(Integer.MAX_VALUE);
    }

    private void h() {
        d();
        int iD = d();
        a aVar = this.f13336c.f13326d;
        aVar.f13320g = (iD & 28) >> 2;
        if (aVar.f13320g == 0) {
            aVar.f13320g = 1;
        }
        this.f13336c.f13326d.f13319f = (iD & 1) != 0;
        int iL = l();
        if (iL < 2) {
            iL = 10;
        }
        a aVar2 = this.f13336c.f13326d;
        aVar2.f13322i = iL * 10;
        aVar2.f13321h = d();
        d();
    }

    private void i() {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < 6; i2++) {
            sb.append((char) d());
        }
        if (!sb.toString().startsWith("GIF")) {
            this.f13336c.b = 1;
            return;
        }
        j();
        if (!this.f13336c.f13330h || c()) {
            return;
        }
        b bVar = this.f13336c;
        bVar.a = a(bVar.f13331i);
        b bVar2 = this.f13336c;
        bVar2.f13334l = bVar2.a[bVar2.f13332j];
    }

    private void j() {
        this.f13336c.f13328f = l();
        this.f13336c.f13329g = l();
        this.f13336c.f13330h = (d() & 128) != 0;
        this.f13336c.f13331i = (int) Math.pow(2.0d, (r0 & 7) + 1);
        this.f13336c.f13332j = d();
        this.f13336c.f13333k = d();
    }

    private void k() {
        do {
            f();
            byte[] bArr = this.a;
            if (bArr[0] == 1) {
                this.f13336c.f13335m = ((bArr[2] & 255) << 8) | (bArr[1] & 255);
            }
            if (this.f13337d <= 0) {
                return;
            }
        } while (!c());
    }

    private int l() {
        return this.b.getShort();
    }

    private void m() {
        this.b = null;
        Arrays.fill(this.a, (byte) 0);
        this.f13336c = new b();
        this.f13337d = 0;
    }

    private void n() {
        int iD;
        do {
            iD = d();
            this.b.position(Math.min(this.b.position() + iD, this.b.limit()));
        } while (iD > 0);
    }

    private void o() {
        d();
        n();
    }

    public c a(@NonNull ByteBuffer byteBuffer) {
        m();
        this.b = byteBuffer.asReadOnlyBuffer();
        this.b.position(0);
        this.b.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }

    @NonNull
    public b b() {
        if (this.b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        }
        if (c()) {
            return this.f13336c;
        }
        i();
        if (!c()) {
            g();
            b bVar = this.f13336c;
            if (bVar.f13325c < 0) {
                bVar.b = 1;
            }
        }
        return this.f13336c;
    }

    public void a() {
        this.b = null;
        this.f13336c = null;
    }

    @Nullable
    private int[] a(int i2) {
        byte[] bArr = new byte[i2 * 3];
        int[] iArr = null;
        try {
            this.b.get(bArr);
            iArr = new int[256];
            int i3 = 0;
            int i4 = 0;
            while (i3 < i2) {
                int i5 = i4 + 1;
                int i6 = i5 + 1;
                int i7 = i6 + 1;
                int i8 = i3 + 1;
                iArr[i3] = ((bArr[i4] & 255) << 16) | (-16777216) | ((bArr[i5] & 255) << 8) | (bArr[i6] & 255);
                i4 = i7;
                i3 = i8;
            }
        } catch (BufferUnderflowException unused) {
            Log.isLoggable("GifHeaderParser", 3);
            this.f13336c.b = 1;
        }
        return iArr;
    }

    private void b(int i2) {
        boolean z2 = false;
        while (!z2 && !c() && this.f13336c.f13325c <= i2) {
            int iD = d();
            if (iD == 33) {
                int iD2 = d();
                if (iD2 == 1) {
                    n();
                } else if (iD2 == 249) {
                    this.f13336c.f13326d = new a();
                    h();
                } else if (iD2 == 254) {
                    n();
                } else if (iD2 != 255) {
                    n();
                } else {
                    f();
                    StringBuilder sb = new StringBuilder();
                    for (int i3 = 0; i3 < 11; i3++) {
                        sb.append((char) this.a[i3]);
                    }
                    if (sb.toString().equals("NETSCAPE2.0")) {
                        k();
                    } else {
                        n();
                    }
                }
            } else if (iD == 44) {
                b bVar = this.f13336c;
                if (bVar.f13326d == null) {
                    bVar.f13326d = new a();
                }
                e();
            } else if (iD != 59) {
                this.f13336c.b = 1;
            } else {
                z2 = true;
            }
        }
    }
}
