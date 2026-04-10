package com.bytedance.sdk.component.dl.z;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes2.dex */
final class v implements gc {
    boolean dl;
    public final js g;
    public final dl z = new dl();

    v(js jsVar) {
        if (jsVar == null) {
            throw new NullPointerException("source == null");
        }
        this.g = jsVar;
    }

    @Override // com.bytedance.sdk.component.dl.z.gc
    public dl dl() {
        return this.z;
    }

    @Override // com.bytedance.sdk.component.dl.z.js
    public long z(dl dlVar, long j) throws IOException {
        if (dlVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        }
        if (this.dl) {
            throw new IllegalStateException("closed");
        }
        if (this.z.g == 0 && this.g.z(this.z, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1L;
        }
        return this.z.z(dlVar, Math.min(j, this.z.g));
    }

    @Override // com.bytedance.sdk.component.dl.z.gc
    public boolean gc() throws IOException {
        if (this.dl) {
            throw new IllegalStateException("closed");
        }
        return this.z.gc() && this.g.z(this.z, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1;
    }

    @Override // com.bytedance.sdk.component.dl.z.gc
    public void z(long j) throws IOException {
        if (!g(j)) {
            throw new EOFException();
        }
    }

    public boolean g(long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: ".concat(String.valueOf(j)));
        }
        if (this.dl) {
            throw new IllegalStateException("closed");
        }
        while (this.z.g < j) {
            if (this.g.z(this.z, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                return false;
            }
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.dl.z.gc
    public byte gz() throws IOException {
        z(1L);
        return this.z.gz();
    }

    @Override // com.bytedance.sdk.component.dl.z.gc
    public m dl(long j) throws IOException {
        z(j);
        return this.z.dl(j);
    }

    @Override // com.bytedance.sdk.component.dl.z.gc
    public byte[] p() throws IOException {
        this.z.z(this.g);
        return this.z.p();
    }

    @Override // com.bytedance.sdk.component.dl.z.gc
    public byte[] e(long j) throws IOException {
        z(j);
        return this.z.e(j);
    }

    @Override // com.bytedance.sdk.component.dl.z.gc
    public void z(byte[] bArr) throws IOException {
        try {
            z(bArr.length);
            this.z.z(bArr);
        } catch (EOFException e) {
            int i = 0;
            while (this.z.g > 0) {
                dl dlVar = this.z;
                int iZ = dlVar.z(bArr, i, (int) dlVar.g);
                if (iZ == -1) {
                    throw new AssertionError();
                }
                i += iZ;
            }
            throw e;
        }
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        if (this.z.g == 0 && this.g.z(this.z, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1;
        }
        return this.z.read(byteBuffer);
    }

    @Override // com.bytedance.sdk.component.dl.z.gc
    public String z(Charset charset) throws IOException {
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        this.z.z(this.g);
        return this.z.z(charset);
    }

    @Override // com.bytedance.sdk.component.dl.z.gc
    public String ls() throws IOException {
        return gc(Long.MAX_VALUE);
    }

    @Override // com.bytedance.sdk.component.dl.z.gc
    public String gc(long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("limit < 0: ".concat(String.valueOf(j)));
        }
        long j2 = j == Long.MAX_VALUE ? Long.MAX_VALUE : j + 1;
        long jZ = z((byte) 10, 0L, j2);
        if (jZ != -1) {
            return this.z.m(jZ);
        }
        if (j2 < Long.MAX_VALUE && g(j2) && this.z.g(j2 - 1) == 13 && g(1 + j2) && this.z.g(j2) == 10) {
            return this.z.m(j2);
        }
        dl dlVar = new dl();
        dl dlVar2 = this.z;
        dlVar2.z(dlVar, 0L, Math.min(32L, dlVar2.g()));
        throw new EOFException("\\n not found: limit=" + Math.min(this.z.g(), j) + " content=" + dlVar.v().gc() + Typography.ellipsis);
    }

    @Override // com.bytedance.sdk.component.dl.z.gc
    public short fo() throws IOException {
        z(2L);
        return this.z.fo();
    }

    @Override // com.bytedance.sdk.component.dl.z.gc
    public short kb() throws IOException {
        z(2L);
        return this.z.kb();
    }

    @Override // com.bytedance.sdk.component.dl.z.gc
    public int uy() throws IOException {
        z(4L);
        return this.z.uy();
    }

    @Override // com.bytedance.sdk.component.dl.z.gc
    public int wp() throws IOException {
        z(4L);
        return this.z.wp();
    }

    @Override // com.bytedance.sdk.component.dl.z.gc
    public long i() throws IOException {
        byte bG;
        z(1L);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!g(i2)) {
                break;
            }
            bG = this.z.g(i);
            if ((bG < 48 || bG > 57) && ((bG < 97 || bG > 102) && (bG < 65 || bG > 70))) {
                break;
            }
            i = i2;
        }
        if (i == 0) {
            throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", Byte.valueOf(bG)));
        }
        return this.z.i();
    }

    @Override // com.bytedance.sdk.component.dl.z.gc
    public void gz(long j) throws IOException {
        if (this.dl) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            if (this.z.g == 0 && this.g.z(this.z, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j, this.z.g());
            this.z.gz(jMin);
            j -= jMin;
        }
    }

    @Override // com.bytedance.sdk.component.dl.z.gc
    public long z(byte b) throws IOException {
        return z(b, 0L, Long.MAX_VALUE);
    }

    public long z(byte b, long j, long j2) throws IOException {
        if (this.dl) {
            throw new IllegalStateException("closed");
        }
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", Long.valueOf(j), Long.valueOf(j2)));
        }
        while (j < j2) {
            long jZ = this.z.z(b, j, j2);
            if (jZ != -1) {
                return jZ;
            }
            long j3 = this.z.g;
            if (j3 >= j2 || this.g.z(this.z, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                break;
            }
            j = Math.max(j, j3);
        }
        return -1L;
    }

    @Override // com.bytedance.sdk.component.dl.z.gc
    public boolean z(long j, m mVar) throws IOException {
        return z(j, mVar, 0, mVar.e());
    }

    public boolean z(long j, m mVar, int i, int i2) throws IOException {
        if (this.dl) {
            throw new IllegalStateException("closed");
        }
        if (j < 0 || i < 0 || i2 < 0 || mVar.e() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            long j2 = ((long) i3) + j;
            if (!g(1 + j2) || this.z.g(j2) != mVar.z(i + i3)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.dl.z.gc
    public InputStream m() {
        return new InputStream() { // from class: com.bytedance.sdk.component.dl.z.v.1
            @Override // java.io.InputStream
            public int read() throws IOException {
                if (v.this.dl) {
                    throw new IOException("closed");
                }
                if (v.this.z.g == 0 && v.this.g.z(v.this.z, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    return -1;
                }
                return v.this.z.gz() & 255;
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) throws IOException {
                if (v.this.dl) {
                    throw new IOException("closed");
                }
                q.z(bArr.length, i, i2);
                if (v.this.z.g == 0 && v.this.g.z(v.this.z, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    return -1;
                }
                return v.this.z.z(bArr, i, i2);
            }

            @Override // java.io.InputStream
            public int available() throws IOException {
                if (v.this.dl) {
                    throw new IOException("closed");
                }
                return (int) Math.min(v.this.z.g, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                v.this.close();
            }

            public String toString() {
                return v.this + ".inputStream()";
            }
        };
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.dl;
    }

    @Override // com.bytedance.sdk.component.dl.z.js, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.dl) {
            return;
        }
        this.dl = true;
        this.g.close();
        this.z.fv();
    }

    @Override // com.bytedance.sdk.component.dl.z.js
    public tb z() {
        return this.g.z();
    }

    public String toString() {
        return "buffer(" + this.g + ")";
    }
}
