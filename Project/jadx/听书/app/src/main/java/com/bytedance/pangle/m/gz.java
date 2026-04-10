package com.bytedance.pangle.m;

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
public class gz implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private dl[] f518a;
    private g[] dl;
    private z g;
    private final Map<String, dl> gc = new HashMap();
    private final FileInputStream z;

    public static boolean z(File file) {
        try {
            com.bytedance.pangle.util.e.z(new gz(file));
            return true;
        } catch (IOException unused) {
            com.bytedance.pangle.util.e.z((Closeable) null);
            return false;
        } catch (Throwable th) {
            com.bytedance.pangle.util.e.z((Closeable) null);
            throw th;
        }
    }

    private gz(File file) throws IOException {
        this.g = null;
        this.dl = null;
        this.f518a = null;
        FileInputStream fileInputStream = new FileInputStream(file);
        this.z = fileInputStream;
        FileChannel channel = fileInputStream.getChannel();
        this.g = new z(channel);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(128);
        byteBufferAllocate.limit(this.g.uy);
        byteBufferAllocate.order(this.g.z[5] == 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
        channel.position(this.g.m);
        this.dl = new g[this.g.kb];
        for (int i = 0; i < this.dl.length; i++) {
            g(channel, byteBufferAllocate, "failed to read phdr.");
            this.dl[i] = new g(byteBufferAllocate, this.g.z[4]);
        }
        channel.position(this.g.e);
        byteBufferAllocate.limit(this.g.wp);
        this.f518a = new dl[this.g.i];
        for (int i2 = 0; i2 < this.f518a.length; i2++) {
            g(channel, byteBufferAllocate, "failed to read shdr.");
            this.f518a[i2] = new dl(byteBufferAllocate, this.g.z[4]);
        }
        if (this.g.v > 0) {
            ByteBuffer byteBufferZ = z(this.f518a[this.g.v]);
            for (dl dlVar : this.f518a) {
                byteBufferZ.position(dlVar.z);
                dlVar.kb = z(byteBufferZ);
                this.gc.put(dlVar.kb, dlVar);
            }
        }
    }

    private static String z(ByteBuffer byteBuffer) {
        byte[] bArrArray = byteBuffer.array();
        int iPosition = byteBuffer.position();
        while (byteBuffer.hasRemaining() && bArrArray[byteBuffer.position()] != 0) {
            byteBuffer.position(byteBuffer.position() + 1);
        }
        byteBuffer.position(byteBuffer.position() + 1);
        return new String(bArrArray, iPosition, (byteBuffer.position() - iPosition) - 1, Charset.forName("ASCII"));
    }

    private ByteBuffer z(dl dlVar) throws IOException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((int) dlVar.m);
        this.z.getChannel().position(dlVar.gc);
        g(this.z.getChannel(), byteBufferAllocate, "failed to read section: " + dlVar.kb);
        return byteBufferAllocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(FileChannel fileChannel, ByteBuffer byteBuffer, String str) throws IOException {
        byteBuffer.rewind();
        int i = fileChannel.read(byteBuffer);
        if (i != byteBuffer.limit()) {
            throw new IOException(str + " Rest bytes insufficient, expect to read " + byteBuffer.limit() + " bytes but only " + i + " bytes were read.");
        }
        byteBuffer.flip();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(int i, int i2, int i3, String str) throws IOException {
        if (i < i2 || i > i3) {
            throw new IOException(str);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.z.close();
        this.gc.clear();
        this.dl = null;
        this.f518a = null;
    }

    private static class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f521a;
        public final short dl;
        public final long e;
        public final short fo;
        public final short g;
        public final long gc;
        public final int gz;
        public final short i;
        public final short kb;
        public final long m;
        public final short uy;
        public final short v;
        public final short wp;
        public final byte[] z;

        private z(FileChannel fileChannel) throws IOException {
            byte[] bArr = new byte[16];
            this.z = bArr;
            fileChannel.position(0L);
            fileChannel.read(ByteBuffer.wrap(bArr));
            if (bArr[0] == 127 && bArr[1] == 69 && bArr[2] == 76 && bArr[3] == 70) {
                gz.g(bArr[4], 1, 2, "bad elf class: " + ((int) bArr[4]));
                gz.g(bArr[5], 1, 2, "bad elf data encoding: " + ((int) bArr[5]));
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArr[4] == 1 ? 36 : 48);
                byteBufferAllocate.order(bArr[5] == 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
                gz.g(fileChannel, byteBufferAllocate, "failed to read rest part of ehdr.");
                this.g = byteBufferAllocate.getShort();
                this.dl = byteBufferAllocate.getShort();
                int i = byteBufferAllocate.getInt();
                this.f521a = i;
                gz.g(i, 1, 1, "bad elf version: " + i);
                byte b = bArr[4];
                if (b == 1) {
                    this.gc = byteBufferAllocate.getInt();
                    this.m = byteBufferAllocate.getInt();
                    this.e = byteBufferAllocate.getInt();
                } else if (b == 2) {
                    this.gc = byteBufferAllocate.getLong();
                    this.m = byteBufferAllocate.getLong();
                    this.e = byteBufferAllocate.getLong();
                } else {
                    throw new IOException("Unexpected elf class: " + ((int) bArr[4]));
                }
                this.gz = byteBufferAllocate.getInt();
                this.fo = byteBufferAllocate.getShort();
                this.uy = byteBufferAllocate.getShort();
                this.kb = byteBufferAllocate.getShort();
                this.wp = byteBufferAllocate.getShort();
                this.i = byteBufferAllocate.getShort();
                this.v = byteBufferAllocate.getShort();
                return;
            }
            throw new IOException(String.format("bad elf magic: %x %x %x %x.", Byte.valueOf(bArr[0]), Byte.valueOf(bArr[1]), Byte.valueOf(bArr[2]), Byte.valueOf(bArr[3])));
        }
    }

    private static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f520a;
        public final long dl;
        public final long e;
        public final int g;
        public final long gc;
        public final long gz;
        public final long m;
        public final int z;

        private g(ByteBuffer byteBuffer, int i) throws IOException {
            if (i == 1) {
                this.z = byteBuffer.getInt();
                this.dl = byteBuffer.getInt();
                this.f520a = byteBuffer.getInt();
                this.gc = byteBuffer.getInt();
                this.m = byteBuffer.getInt();
                this.e = byteBuffer.getInt();
                this.g = byteBuffer.getInt();
                this.gz = byteBuffer.getInt();
                return;
            }
            if (i == 2) {
                this.z = byteBuffer.getInt();
                this.g = byteBuffer.getInt();
                this.dl = byteBuffer.getLong();
                this.f520a = byteBuffer.getLong();
                this.gc = byteBuffer.getLong();
                this.m = byteBuffer.getLong();
                this.e = byteBuffer.getLong();
                this.gz = byteBuffer.getLong();
                return;
            }
            throw new IOException("Unexpected elf class: ".concat(String.valueOf(i)));
        }
    }

    private static class dl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f519a;
        public final long dl;
        public final int e;
        public final long fo;
        public final int g;
        public final long gc;
        public final int gz;
        public String kb;
        public final long m;
        public final long uy;
        public final int z;

        private dl(ByteBuffer byteBuffer, int i) throws IOException {
            if (i == 1) {
                this.z = byteBuffer.getInt();
                this.g = byteBuffer.getInt();
                this.dl = byteBuffer.getInt();
                this.f519a = byteBuffer.getInt();
                this.gc = byteBuffer.getInt();
                this.m = byteBuffer.getInt();
                this.e = byteBuffer.getInt();
                this.gz = byteBuffer.getInt();
                this.fo = byteBuffer.getInt();
                this.uy = byteBuffer.getInt();
            } else if (i == 2) {
                this.z = byteBuffer.getInt();
                this.g = byteBuffer.getInt();
                this.dl = byteBuffer.getLong();
                this.f519a = byteBuffer.getLong();
                this.gc = byteBuffer.getLong();
                this.m = byteBuffer.getLong();
                this.e = byteBuffer.getInt();
                this.gz = byteBuffer.getInt();
                this.fo = byteBuffer.getLong();
                this.uy = byteBuffer.getLong();
            } else {
                throw new IOException("Unexpected elf class: ".concat(String.valueOf(i)));
            }
            this.kb = null;
        }
    }
}
