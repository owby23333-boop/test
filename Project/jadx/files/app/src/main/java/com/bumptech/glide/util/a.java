package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ByteBufferUtil.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static final AtomicReference<byte[]> a = new AtomicReference<>();

    /* JADX INFO: compiled from: ByteBufferUtil.java */
    static final class b {
        final int a;
        final int b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final byte[] f13891c;

        b(@NonNull byte[] bArr, int i2, int i3) {
            this.f13891c = bArr;
            this.a = i2;
            this.b = i3;
        }
    }

    @NonNull
    public static ByteBuffer a(@NonNull File file) throws Throwable {
        RandomAccessFile randomAccessFile;
        FileChannel channel;
        FileChannel fileChannel = null;
        try {
            long length = file.length();
            if (length > 2147483647L) {
                throw new IOException("File too large to map into memory");
            }
            if (length == 0) {
                throw new IOException("File unsuitable for memory mapping");
            }
            randomAccessFile = new RandomAccessFile(file, "r");
            try {
                channel = randomAccessFile.getChannel();
            } catch (Throwable th) {
                th = th;
            }
            try {
                MappedByteBuffer mappedByteBufferLoad = channel.map(FileChannel.MapMode.READ_ONLY, 0L, length).load();
                if (channel != null) {
                    try {
                        channel.close();
                    } catch (IOException unused) {
                    }
                }
                try {
                    randomAccessFile.close();
                } catch (IOException unused2) {
                }
                return mappedByteBufferLoad;
            } catch (Throwable th2) {
                fileChannel = channel;
                th = th2;
                if (fileChannel != null) {
                    try {
                        fileChannel.close();
                    } catch (IOException unused3) {
                    }
                }
                if (randomAccessFile == null) {
                    throw th;
                }
                try {
                    randomAccessFile.close();
                    throw th;
                } catch (IOException unused4) {
                    throw th;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile = null;
        }
    }

    public static ByteBuffer b(ByteBuffer byteBuffer) {
        return (ByteBuffer) byteBuffer.position(0);
    }

    @NonNull
    public static byte[] c(@NonNull ByteBuffer byteBuffer) {
        b bVarA = a(byteBuffer);
        if (bVarA != null && bVarA.a == 0 && bVarA.b == bVarA.f13891c.length) {
            return byteBuffer.array();
        }
        ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        byte[] bArr = new byte[byteBufferAsReadOnlyBuffer.limit()];
        b(byteBufferAsReadOnlyBuffer);
        byteBufferAsReadOnlyBuffer.get(bArr);
        return bArr;
    }

    @NonNull
    public static InputStream d(@NonNull ByteBuffer byteBuffer) {
        return new C0280a(byteBuffer);
    }

    /* JADX INFO: renamed from: com.bumptech.glide.util.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ByteBufferUtil.java */
    private static class C0280a extends InputStream {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        @NonNull
        private final ByteBuffer f13889s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private int f13890t = -1;

        C0280a(@NonNull ByteBuffer byteBuffer) {
            this.f13889s = byteBuffer;
        }

        @Override // java.io.InputStream
        public int available() {
            return this.f13889s.remaining();
        }

        @Override // java.io.InputStream
        public synchronized void mark(int i2) {
            this.f13890t = this.f13889s.position();
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.f13889s.hasRemaining()) {
                return this.f13889s.get() & 255;
            }
            return -1;
        }

        @Override // java.io.InputStream
        public synchronized void reset() throws IOException {
            if (this.f13890t == -1) {
                throw new IOException("Cannot reset to unset mark position");
            }
            this.f13889s.position(this.f13890t);
        }

        @Override // java.io.InputStream
        public long skip(long j2) {
            if (!this.f13889s.hasRemaining()) {
                return -1L;
            }
            long jMin = Math.min(j2, available());
            ByteBuffer byteBuffer = this.f13889s;
            byteBuffer.position((int) (((long) byteBuffer.position()) + jMin));
            return jMin;
        }

        @Override // java.io.InputStream
        public int read(@NonNull byte[] bArr, int i2, int i3) {
            if (!this.f13889s.hasRemaining()) {
                return -1;
            }
            int iMin = Math.min(i3, available());
            this.f13889s.get(bArr, i2, iMin);
            return iMin;
        }
    }

    public static void a(@NonNull ByteBuffer byteBuffer, @NonNull File file) throws Throwable {
        RandomAccessFile randomAccessFile;
        b(byteBuffer);
        FileChannel channel = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
        } catch (Throwable th) {
            th = th;
            randomAccessFile = null;
        }
        try {
            channel = randomAccessFile.getChannel();
            channel.write(byteBuffer);
            channel.force(false);
            channel.close();
            randomAccessFile.close();
            if (channel != null) {
                try {
                    channel.close();
                } catch (IOException unused) {
                }
            }
            try {
                randomAccessFile.close();
            } catch (IOException unused2) {
            }
        } catch (Throwable th2) {
            th = th2;
            if (channel != null) {
                try {
                    channel.close();
                } catch (IOException unused3) {
                }
            }
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                    throw th;
                } catch (IOException unused4) {
                    throw th;
                }
            }
            throw th;
        }
    }

    @NonNull
    public static ByteBuffer a(@NonNull InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        byte[] andSet = a.getAndSet(null);
        if (andSet == null) {
            andSet = new byte[16384];
        }
        while (true) {
            int i2 = inputStream.read(andSet);
            if (i2 >= 0) {
                byteArrayOutputStream.write(andSet, 0, i2);
            } else {
                a.set(andSet);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                return b(ByteBuffer.allocateDirect(byteArray.length).put(byteArray));
            }
        }
    }

    @Nullable
    private static b a(@NonNull ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly() || !byteBuffer.hasArray()) {
            return null;
        }
        return new b(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit());
    }
}
