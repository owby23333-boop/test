package com.bytedance.pangle.e;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements Closeable {
    private final FileInputStream a;
    private a b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b[] f14542c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private c[] f14543d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map<String, c> f14544e = new HashMap();

    static class a {
        public final byte[] a;
        public final short b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final short f14545c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f14546d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f14547e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f14548f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final long f14549g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f14550h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final short f14551i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final short f14552j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final short f14553k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final short f14554l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final short f14555m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final short f14556n;

        /* synthetic */ a(FileChannel fileChannel, byte b) {
            this(fileChannel);
        }

        private a(FileChannel fileChannel) throws IOException {
            this.a = new byte[16];
            fileChannel.position(0L);
            fileChannel.read(ByteBuffer.wrap(this.a));
            byte[] bArr = this.a;
            if (bArr[0] != 127 || bArr[1] != 69 || bArr[2] != 76 || bArr[3] != 70) {
                throw new IOException(String.format("bad elf magic: %x %x %x %x.", Byte.valueOf(this.a[0]), Byte.valueOf(this.a[1]), Byte.valueOf(this.a[2]), Byte.valueOf(this.a[3])));
            }
            h.a(bArr[4], 2, "bad elf class: " + ((int) this.a[4]));
            h.a(this.a[5], 2, "bad elf data encoding: " + ((int) this.a[5]));
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(this.a[4] == 1 ? 36 : 48);
            byteBufferAllocate.order(this.a[5] == 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
            h.b(fileChannel, byteBufferAllocate, "failed to read rest part of ehdr.");
            this.b = byteBufferAllocate.getShort();
            this.f14545c = byteBufferAllocate.getShort();
            this.f14546d = byteBufferAllocate.getInt();
            h.a(this.f14546d, 1, "bad elf version: " + this.f14546d);
            byte b = this.a[4];
            if (b == 1) {
                this.f14547e = byteBufferAllocate.getInt();
                this.f14548f = byteBufferAllocate.getInt();
                this.f14549g = byteBufferAllocate.getInt();
            } else {
                if (b != 2) {
                    throw new IOException("Unexpected elf class: " + ((int) this.a[4]));
                }
                this.f14547e = byteBufferAllocate.getLong();
                this.f14548f = byteBufferAllocate.getLong();
                this.f14549g = byteBufferAllocate.getLong();
            }
            this.f14550h = byteBufferAllocate.getInt();
            this.f14551i = byteBufferAllocate.getShort();
            this.f14552j = byteBufferAllocate.getShort();
            this.f14553k = byteBufferAllocate.getShort();
            this.f14554l = byteBufferAllocate.getShort();
            this.f14555m = byteBufferAllocate.getShort();
            this.f14556n = byteBufferAllocate.getShort();
        }
    }

    static class b {
        public final int a;
        public final int b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f14557c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f14558d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f14559e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f14560f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final long f14561g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final long f14562h;

        /* synthetic */ b(ByteBuffer byteBuffer, int i2, byte b) {
            this(byteBuffer, i2);
        }

        private b(ByteBuffer byteBuffer, int i2) throws IOException {
            if (i2 == 1) {
                this.a = byteBuffer.getInt();
                this.f14557c = byteBuffer.getInt();
                this.f14558d = byteBuffer.getInt();
                this.f14559e = byteBuffer.getInt();
                this.f14560f = byteBuffer.getInt();
                this.f14561g = byteBuffer.getInt();
                this.b = byteBuffer.getInt();
                this.f14562h = byteBuffer.getInt();
                return;
            }
            if (i2 != 2) {
                throw new IOException("Unexpected elf class: ".concat(String.valueOf(i2)));
            }
            this.a = byteBuffer.getInt();
            this.b = byteBuffer.getInt();
            this.f14557c = byteBuffer.getLong();
            this.f14558d = byteBuffer.getLong();
            this.f14559e = byteBuffer.getLong();
            this.f14560f = byteBuffer.getLong();
            this.f14561g = byteBuffer.getLong();
            this.f14562h = byteBuffer.getLong();
        }
    }

    static class c {
        public final int a;
        public final int b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f14563c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f14564d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f14565e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f14566f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f14567g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f14568h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final long f14569i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final long f14570j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public String f14571k;

        /* synthetic */ c(ByteBuffer byteBuffer, int i2, byte b) {
            this(byteBuffer, i2);
        }

        private c(ByteBuffer byteBuffer, int i2) throws IOException {
            if (i2 == 1) {
                this.a = byteBuffer.getInt();
                this.b = byteBuffer.getInt();
                this.f14563c = byteBuffer.getInt();
                this.f14564d = byteBuffer.getInt();
                this.f14565e = byteBuffer.getInt();
                this.f14566f = byteBuffer.getInt();
                this.f14567g = byteBuffer.getInt();
                this.f14568h = byteBuffer.getInt();
                this.f14569i = byteBuffer.getInt();
                this.f14570j = byteBuffer.getInt();
            } else {
                if (i2 != 2) {
                    throw new IOException("Unexpected elf class: ".concat(String.valueOf(i2)));
                }
                this.a = byteBuffer.getInt();
                this.b = byteBuffer.getInt();
                this.f14563c = byteBuffer.getLong();
                this.f14564d = byteBuffer.getLong();
                this.f14565e = byteBuffer.getLong();
                this.f14566f = byteBuffer.getLong();
                this.f14567g = byteBuffer.getInt();
                this.f14568h = byteBuffer.getInt();
                this.f14569i = byteBuffer.getLong();
                this.f14570j = byteBuffer.getLong();
            }
            this.f14571k = null;
        }
    }

    private h(File file) throws IOException {
        c[] cVarArr;
        this.b = null;
        this.f14542c = null;
        this.f14543d = null;
        this.a = new FileInputStream(file);
        FileChannel channel = this.a.getChannel();
        byte b2 = 0;
        byte b3 = 0;
        this.b = new a(channel, 0 == true ? 1 : 0);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(128);
        byteBufferAllocate.limit(this.b.f14552j);
        byteBufferAllocate.order(this.b.a[5] == 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
        channel.position(this.b.f14548f);
        this.f14542c = new b[this.b.f14553k];
        for (int i2 = 0; i2 < this.f14542c.length; i2++) {
            b(channel, byteBufferAllocate, "failed to read phdr.");
            this.f14542c[i2] = new b(byteBufferAllocate, this.b.a[4], b3 == true ? 1 : 0);
        }
        channel.position(this.b.f14549g);
        byteBufferAllocate.limit(this.b.f14554l);
        this.f14543d = new c[this.b.f14555m];
        int i3 = 0;
        while (true) {
            cVarArr = this.f14543d;
            if (i3 >= cVarArr.length) {
                break;
            }
            b(channel, byteBufferAllocate, "failed to read shdr.");
            this.f14543d[i3] = new c(byteBufferAllocate, this.b.a[4], b2 == true ? 1 : 0);
            i3++;
        }
        short s2 = this.b.f14556n;
        if (s2 > 0) {
            c cVar = cVarArr[s2];
            ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate((int) cVar.f14566f);
            this.a.getChannel().position(cVar.f14565e);
            b(this.a.getChannel(), byteBufferAllocate2, "failed to read section: " + cVar.f14571k);
            for (c cVar2 : this.f14543d) {
                byteBufferAllocate2.position(cVar2.a);
                cVar2.f14571k = a(byteBufferAllocate2);
                this.f14544e.put(cVar2.f14571k, cVar2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(FileChannel fileChannel, ByteBuffer byteBuffer, String str) throws IOException {
        byteBuffer.rewind();
        int i2 = fileChannel.read(byteBuffer);
        if (i2 == byteBuffer.limit()) {
            byteBuffer.flip();
            return;
        }
        throw new IOException(str + " Rest bytes insufficient, expect to read " + byteBuffer.limit() + " bytes but only " + i2 + " bytes were read.");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.a.close();
        this.f14544e.clear();
        this.f14542c = null;
        this.f14543d = null;
    }

    public static boolean a(File file) {
        try {
            com.bytedance.pangle.util.g.a(new h(file));
            return true;
        } catch (IOException unused) {
            com.bytedance.pangle.util.g.a((Closeable) null);
            return false;
        } catch (Throwable th) {
            com.bytedance.pangle.util.g.a((Closeable) null);
            throw th;
        }
    }

    private static String a(ByteBuffer byteBuffer) {
        byte[] bArrArray = byteBuffer.array();
        int iPosition = byteBuffer.position();
        while (byteBuffer.hasRemaining() && bArrArray[byteBuffer.position()] != 0) {
            byteBuffer.position(byteBuffer.position() + 1);
        }
        byteBuffer.position(byteBuffer.position() + 1);
        return new String(bArrArray, iPosition, (byteBuffer.position() - iPosition) - 1, Charset.forName("ASCII"));
    }

    static /* synthetic */ void a(int i2, int i3, String str) throws IOException {
        if (i2 <= 0 || i2 > i3) {
            throw new IOException(str);
        }
    }
}
