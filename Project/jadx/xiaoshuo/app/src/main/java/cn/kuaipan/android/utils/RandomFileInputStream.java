package cn.kuaipan.android.utils;

import android.support.v4.media.session.PlaybackStateCompat;
import com.xiaomi.verificationsdk.internal.Constants;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes.dex */
public class RandomFileInputStream extends InputStream {
    private final File file;
    private RandomAccessFile rFile;
    private long pos = 0;
    private long markedPos = 0;
    private boolean closed = false;

    public RandomFileInputStream(File file) throws FileNotFoundException {
        this.file = file;
        this.rFile = new RandomAccessFile(file, Constants.RANDOM_LONG);
    }

    @Override // java.io.InputStream
    public synchronized int available() throws IOException {
        return (int) (this.rFile.length() - this.pos);
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.rFile.close();
        this.closed = true;
    }

    public synchronized long getCurrentPos() {
        return this.pos;
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        if (this.closed) {
            return;
        }
        this.markedPos = this.pos;
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    public synchronized void moveToPos(long j) throws IOException {
        if (j >= this.rFile.length()) {
            throw new IOException("Seek possion is not availabel");
        }
        this.rFile.seek(j);
        this.pos = j;
    }

    @Override // java.io.InputStream
    public synchronized int read() throws IOException {
        int i;
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedIOException();
        }
        i = this.rFile.read();
        if (i >= 0) {
            this.pos++;
        }
        return i;
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        if (this.closed) {
            this.closed = false;
            this.rFile = new RandomAccessFile(this.file, Constants.RANDOM_LONG);
        }
        this.rFile.seek(this.markedPos);
        this.pos = this.markedPos;
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        if (j == 0) {
            return 0L;
        }
        if (j < 0) {
            throw new IOException("Number of bytes to skip cannot be negative");
        }
        int i = j < PlaybackStateCompat.ACTION_PLAY_FROM_URI ? (int) j : 8192;
        synchronized (this) {
            long j2 = i;
            long j3 = 0;
            for (long j4 = j / j2; j4 >= 0; j4--) {
                if (Thread.currentThread().isInterrupted()) {
                    throw new InterruptedIOException();
                }
                long jSkipBytes = this.rFile.skipBytes(i);
                j3 += jSkipBytes;
                this.pos += jSkipBytes;
                if (jSkipBytes < j2) {
                    return j3;
                }
            }
            return j3;
        }
    }

    @Override // java.io.InputStream
    public synchronized int read(byte[] bArr) throws IOException {
        int i;
        if (!Thread.currentThread().isInterrupted()) {
            i = this.rFile.read(bArr);
            if (i > 0) {
                this.pos += (long) i;
            }
        } else {
            throw new InterruptedIOException();
        }
        return i;
    }

    @Override // java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        if (!Thread.currentThread().isInterrupted()) {
            i3 = this.rFile.read(bArr, i, i2);
            if (i3 > 0) {
                this.pos += (long) i3;
            }
        } else {
            throw new InterruptedIOException();
        }
        return i3;
    }
}
