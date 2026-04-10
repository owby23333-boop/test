package com.bytedance.pangle.res.z;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private static final Logger m = Logger.getLogger(z.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final gc f530a;
    private final e dl;
    private final gz g;
    private C0112z gc;
    private final byte[] z;

    public z(byte[] bArr, gz gzVar) {
        gc gcVar = new gc(new ByteArrayInputStream(bArr));
        this.f530a = gcVar;
        this.dl = new e(new fo(gcVar));
        this.z = bArr;
        this.g = gzVar;
    }

    public void z() throws IOException {
        dl(2);
        int i = this.dl.readInt();
        wp.z(this.dl);
        kb();
        for (int i2 = 0; i2 < i; i2++) {
            g();
        }
    }

    private void g() throws IOException {
        g(512);
        this.dl.readInt();
        this.dl.skipBytes(256);
        this.dl.z();
        this.dl.z();
        this.dl.z();
        this.dl.z();
        if (this.gc.g == 288 && this.dl.readInt() > 0) {
            throw new RuntimeException("don't support");
        }
        wp.z(this.dl);
        wp.z(this.dl);
        kb();
        boolean z = true;
        while (z) {
            short s = this.gc.z;
            if (s == 514) {
                a();
            } else if (s != 515) {
                z = false;
            } else {
                dl();
            }
        }
    }

    private void dl() throws IOException {
        g(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_EXACT);
        int i = this.dl.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            this.dl.readInt();
            this.dl.skipBytes(256);
        }
        while (kb().z == 513) {
            a();
        }
    }

    private void a() throws IOException {
        gc();
        short s = kb().z;
        while (s == 514) {
            gc();
            s = kb().z;
        }
        while (s == 513) {
            m();
            if (this.f530a.z() < this.gc.gc) {
                m.warning("Unknown data detected. Skipping: " + (this.gc.gc - this.f530a.z()) + " byte(s)");
                this.f530a.skip(this.gc.gc - this.f530a.z());
            }
            s = kb().z;
        }
    }

    private void gc() throws IOException {
        g(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_EXPIRED_LICENSE);
        this.dl.readUnsignedByte();
        this.dl.skipBytes(3);
        this.dl.skipBytes(this.dl.readInt() * 4);
    }

    private void m() throws IOException {
        g(513);
        this.dl.readUnsignedByte();
        this.dl.readByte();
        this.dl.skipBytes(2);
        int i = this.dl.readInt();
        int i2 = this.dl.readInt();
        uy();
        int i3 = (this.gc.f531a + i2) - (i * 4);
        if (i3 != this.f530a.z()) {
            m.warning("Invalid data detected. Skipping: " + (i3 - this.f530a.z()) + " byte(s)");
            this.dl.skipBytes(i3 - this.f530a.z());
        }
        int[] iArrZ = this.dl.z(i);
        HashSet hashSet = new HashSet();
        for (int i4 : iArrZ) {
            if (i4 != -1 && !hashSet.contains(Integer.valueOf(i4))) {
                e();
                hashSet.add(Integer.valueOf(i4));
            }
        }
    }

    private void e() throws IOException {
        if (this.dl.readShort() < 0) {
            throw new RuntimeException("Entry size is under 0 bytes.");
        }
        short s = this.dl.readShort();
        this.dl.readInt();
        if ((s & 1) == 0) {
            fo();
        } else {
            gz();
        }
    }

    private void gz() throws IOException {
        int iZ = kb.z(this.dl);
        kb.z(this.z, this.dl.readInt(), iZ, this.g);
        int i = this.dl.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            int iZ2 = kb.z(this.dl);
            kb.z(this.z, this.dl.readInt(), iZ2, this.g);
            fo();
        }
    }

    private void fo() throws IOException {
        this.dl.z((short) 8);
        this.dl.z((byte) 0);
        byte b = this.dl.readByte();
        int iZ = kb.z(this.dl);
        int i = this.dl.readInt();
        if (b == 1) {
            kb.z(this.z, i, iZ, this.g);
        }
        if (b == 2) {
            kb.z(this.z, i, iZ, this.g);
        }
    }

    private void uy() throws IOException {
        int i = this.dl.readInt();
        int i2 = 28;
        if (i < 28) {
            throw new RuntimeException("Config size < 28");
        }
        this.dl.readShort();
        this.dl.readShort();
        this.dl.readByte();
        this.dl.readByte();
        this.dl.readByte();
        this.dl.readByte();
        this.dl.readByte();
        this.dl.readByte();
        this.dl.readUnsignedShort();
        this.dl.readByte();
        this.dl.readByte();
        this.dl.readByte();
        this.dl.skipBytes(1);
        this.dl.readShort();
        this.dl.readShort();
        this.dl.readShort();
        this.dl.skipBytes(2);
        if (i >= 32) {
            this.dl.readByte();
            this.dl.readByte();
            this.dl.readShort();
            i2 = 32;
        }
        if (i >= 36) {
            this.dl.readShort();
            this.dl.readShort();
            i2 = 36;
        }
        if (i >= 48) {
            z(4).toCharArray();
            z(8).toCharArray();
            i2 = 48;
        }
        if (i >= 52) {
            this.dl.readByte();
            this.dl.readByte();
            this.dl.skipBytes(2);
            i2 = 52;
        }
        if (i >= 56) {
            this.dl.skipBytes(4);
            i2 = 56;
        }
        int i3 = i - 56;
        if (i3 > 0) {
            byte[] bArr = new byte[i3];
            i2 += i3;
            this.dl.readFully(bArr);
            BigInteger bigInteger = new BigInteger(1, bArr);
            if (bigInteger.equals(BigInteger.ZERO)) {
                m.fine(String.format("Config flags size > %d, but exceeding bytes are all zero, so it should be ok.", 56));
            } else {
                m.warning(String.format("Config flags size > %d. Size = %d. Exceeding bytes: 0x%X.", 56, Integer.valueOf(i), bigInteger));
            }
        }
        int i4 = i - i2;
        if (i4 > 0) {
            this.dl.skipBytes(i4);
        }
    }

    private String z(int i) throws IOException {
        int i2;
        short s;
        StringBuilder sb = new StringBuilder(16);
        while (true) {
            i2 = i - 1;
            if (i == 0 || this.dl.readByte() == 0) {
                break;
            }
            sb.append((char) s);
            i = i2;
        }
        this.dl.skipBytes(i2);
        return sb.toString();
    }

    private C0112z kb() throws IOException {
        C0112z c0112zZ = C0112z.z(this.dl, this.f530a);
        this.gc = c0112zZ;
        return c0112zZ;
    }

    private void g(int i) {
        if (this.gc.z != i) {
            throw new RuntimeException(String.format("Invalid chunk type: expected=0x%08x, got=0x%08x", Integer.valueOf(i), Short.valueOf(this.gc.z)));
        }
    }

    private void dl(int i) throws IOException {
        kb();
        g(i);
    }

    /* JADX INFO: renamed from: com.bytedance.pangle.res.z.z$z, reason: collision with other inner class name */
    public static class C0112z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f531a;
        public final int dl;
        public final int g;
        public final int gc;
        public final short z;

        public C0112z(short s, int i, int i2, int i3) {
            this.z = s;
            this.g = i;
            this.dl = i2;
            this.f531a = i3;
            this.gc = i3 + i2;
        }

        public static C0112z z(e eVar, gc gcVar) throws IOException {
            int iZ = gcVar.z();
            try {
                return new C0112z(eVar.readShort(), eVar.readShort(), eVar.readInt(), iZ);
            } catch (EOFException unused) {
                return new C0112z((short) -1, 0, 0, gcVar.z());
            }
        }
    }
}
