package com.bytedance.pangle.res.a;

import androidx.core.view.InputDeviceCompat;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Logger f14629f = Logger.getLogger(a.class.getName());
    private final byte[] a;
    private final h b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final g f14630c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final e f14631d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private C0305a f14632e;

    /* JADX INFO: renamed from: com.bytedance.pangle.res.a.a$a, reason: collision with other inner class name */
    public static class C0305a {
        public final short a;
        public final int b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f14633c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f14634d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f14635e;

        private C0305a(short s2, int i2, int i3, int i4) {
            this.a = s2;
            this.b = i2;
            this.f14633c = i3;
            this.f14634d = i4;
            this.f14635e = i4 + i3;
        }

        public static C0305a a(g gVar, e eVar) {
            int iA = eVar.a();
            try {
                return new C0305a(gVar.readShort(), gVar.readShort(), gVar.readInt(), iA);
            } catch (EOFException unused) {
                return new C0305a((short) -1, 0, 0, eVar.a());
            }
        }
    }

    public a(byte[] bArr, h hVar) {
        e eVar = new e(new ByteArrayInputStream(bArr));
        this.f14631d = eVar;
        this.f14630c = new g(new i(eVar));
        this.a = bArr;
        this.b = hVar;
    }

    private String a(int i2) {
        int i3;
        short s2;
        StringBuilder sb = new StringBuilder(16);
        while (true) {
            i3 = i2 - 1;
            if (i2 == 0 || this.f14630c.readByte() == 0) {
                break;
            }
            sb.append((char) s2);
            i2 = i3;
        }
        this.f14630c.skipBytes(i3);
        return sb.toString();
    }

    private void b() throws IOException {
        b(515);
        int i2 = this.f14630c.readInt();
        for (int i3 = 0; i3 < i2; i3++) {
            this.f14630c.readInt();
            this.f14630c.skipBytes(256);
        }
        while (j().a == 513) {
            c();
        }
    }

    private void c() throws IOException {
        d();
        short s2 = j().a;
        while (s2 == 514) {
            d();
            s2 = j().a;
        }
        while (s2 == 513) {
            e();
            if (this.f14631d.a() < this.f14632e.f14635e) {
                f14629f.warning("Unknown data detected. Skipping: " + (this.f14632e.f14635e - this.f14631d.a()) + " byte(s)");
                e eVar = this.f14631d;
                eVar.skip((long) (this.f14632e.f14635e - eVar.a()));
            }
            s2 = j().a;
        }
    }

    private void d() {
        b(514);
        this.f14630c.readUnsignedByte();
        this.f14630c.skipBytes(3);
        this.f14630c.skipBytes(this.f14630c.readInt() * 4);
    }

    private void e() throws IOException {
        b(InputDeviceCompat.SOURCE_DPAD);
        this.f14630c.readUnsignedByte();
        this.f14630c.readByte();
        this.f14630c.skipBytes(2);
        int i2 = this.f14630c.readInt();
        int i3 = this.f14630c.readInt();
        i();
        int i4 = (this.f14632e.f14634d + i3) - (i2 * 4);
        if (i4 != this.f14631d.a()) {
            f14629f.warning("Invalid data detected. Skipping: " + (i4 - this.f14631d.a()) + " byte(s)");
            this.f14630c.skipBytes(i4 - this.f14631d.a());
        }
        int[] iArrA = this.f14630c.a(i2);
        HashSet hashSet = new HashSet();
        for (int i5 : iArrA) {
            if (i5 != -1 && !hashSet.contains(Integer.valueOf(i5))) {
                f();
                hashSet.add(Integer.valueOf(i5));
            }
        }
    }

    private void f() throws IOException {
        if (this.f14630c.readShort() < 0) {
            throw new RuntimeException("Entry size is under 0 bytes.");
        }
        short s2 = this.f14630c.readShort();
        this.f14630c.readInt();
        if ((s2 & 1) == 0) {
            h();
        } else {
            g();
        }
    }

    private void g() throws IOException {
        int iA = k.a(this.f14630c);
        k.a(this.a, this.f14630c.readInt(), iA, this.b);
        int i2 = this.f14630c.readInt();
        for (int i3 = 0; i3 < i2; i3++) {
            int iA2 = k.a(this.f14630c);
            k.a(this.a, this.f14630c.readInt(), iA2, this.b);
            h();
        }
    }

    private void h() throws IOException {
        this.f14630c.a();
        this.f14630c.b();
        byte b = this.f14630c.readByte();
        int iA = k.a(this.f14630c);
        int i2 = this.f14630c.readInt();
        if (b == 1) {
            k.a(this.a, i2, iA, this.b);
        }
        if (b == 2) {
            k.a(this.a, i2, iA, this.b);
        }
    }

    private void i() throws IOException {
        int i2 = this.f14630c.readInt();
        int i3 = 28;
        if (i2 < 28) {
            throw new RuntimeException("Config size < 28");
        }
        this.f14630c.readShort();
        this.f14630c.readShort();
        this.f14630c.readByte();
        this.f14630c.readByte();
        this.f14630c.readByte();
        this.f14630c.readByte();
        this.f14630c.readByte();
        this.f14630c.readByte();
        this.f14630c.readUnsignedShort();
        this.f14630c.readByte();
        this.f14630c.readByte();
        this.f14630c.readByte();
        this.f14630c.skipBytes(1);
        this.f14630c.readShort();
        this.f14630c.readShort();
        this.f14630c.readShort();
        this.f14630c.skipBytes(2);
        if (i2 >= 32) {
            this.f14630c.readByte();
            this.f14630c.readByte();
            this.f14630c.readShort();
            i3 = 32;
        }
        if (i2 >= 36) {
            this.f14630c.readShort();
            this.f14630c.readShort();
            i3 = 36;
        }
        if (i2 >= 48) {
            a(4).toCharArray();
            a(8).toCharArray();
            i3 = 48;
        }
        if (i2 >= 52) {
            this.f14630c.readByte();
            this.f14630c.readByte();
            this.f14630c.skipBytes(2);
            i3 = 52;
        }
        if (i2 >= 56) {
            this.f14630c.skipBytes(4);
            i3 = 56;
        }
        int i4 = i2 - 56;
        if (i4 > 0) {
            byte[] bArr = new byte[i4];
            i3 += i4;
            this.f14630c.readFully(bArr);
            BigInteger bigInteger = new BigInteger(1, bArr);
            if (bigInteger.equals(BigInteger.ZERO)) {
                f14629f.fine(String.format("Config flags size > %d, but exceeding bytes are all zero, so it should be ok.", 56));
            } else {
                f14629f.warning(String.format("Config flags size > %d. Size = %d. Exceeding bytes: 0x%X.", 56, Integer.valueOf(i2), bigInteger));
            }
        }
        int i5 = i2 - i3;
        if (i5 > 0) {
            this.f14630c.skipBytes(i5);
        }
    }

    private C0305a j() {
        C0305a c0305aA = C0305a.a(this.f14630c, this.f14631d);
        this.f14632e = c0305aA;
        return c0305aA;
    }

    public final void a() throws IOException {
        j();
        b(2);
        int i2 = this.f14630c.readInt();
        l.a(this.f14630c);
        j();
        for (int i3 = 0; i3 < i2; i3++) {
            b(512);
            this.f14630c.readInt();
            this.f14630c.skipBytes(256);
            this.f14630c.skipBytes(4);
            this.f14630c.skipBytes(4);
            this.f14630c.skipBytes(4);
            this.f14630c.skipBytes(4);
            if (this.f14632e.b == 288 && this.f14630c.readInt() > 0) {
                throw new RuntimeException("don't support");
            }
            l.a(this.f14630c);
            l.a(this.f14630c);
            j();
            boolean z2 = true;
            while (z2) {
                short s2 = this.f14632e.a;
                if (s2 == 514) {
                    c();
                } else if (s2 != 515) {
                    z2 = false;
                } else {
                    b();
                }
            }
        }
    }

    private void b(int i2) {
        if (this.f14632e.a != i2) {
            throw new RuntimeException(String.format("Invalid chunk type: expected=0x%08x, got=0x%08x", Integer.valueOf(i2), Short.valueOf(this.f14632e.a)));
        }
    }
}
