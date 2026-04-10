package cn.kuaipan.android.kss.download;

import cn.kuaipan.android.utils.Encode;
import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes.dex */
public class KssAccessor {
    private RandomAccessFile mFileAccessor;
    private FileLock mFilelocker;
    private boolean mClosed = false;
    private final ReentrantLock mLocker = new ReentrantLock();

    public KssAccessor(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rws");
        this.mFileAccessor = randomAccessFile;
        FileLock fileLockTryLock = randomAccessFile.getChannel().tryLock();
        this.mFilelocker = fileLockTryLock;
        if (fileLockTryLock != null) {
            return;
        }
        throw new IOException("Failed Lock the target file: " + file);
    }

    public void close() throws IOException {
        if (this.mClosed) {
            return;
        }
        this.mClosed = true;
        try {
            FileLock fileLock = this.mFilelocker;
            if (fileLock != null) {
                fileLock.release();
                this.mFilelocker = null;
            }
        } finally {
            RandomAccessFile randomAccessFile = this.mFileAccessor;
            if (randomAccessFile != null) {
                randomAccessFile.close();
                this.mFileAccessor = null;
            }
        }
    }

    public void finalize() throws Throwable {
        try {
            close();
        } finally {
            super.finalize();
        }
    }

    public void inflate(long j) throws IOException {
        if (this.mClosed) {
            throw new IOException();
        }
        lock();
        try {
            this.mFileAccessor.seek(j - 1);
            this.mFileAccessor.write(0);
        } finally {
            unlock();
        }
    }

    public void lock() {
        this.mLocker.lock();
    }

    public String sha1(long j, long j2) throws IOException {
        if (this.mClosed) {
            throw new IOException();
        }
        lock();
        try {
            return Encode.SHA1Encode(this.mFileAccessor, j, j2);
        } finally {
            unlock();
        }
    }

    public void unlock() {
        this.mLocker.unlock();
    }

    public int write(byte[] bArr, int i, int i2, LoadRecorder loadRecorder) throws IOException {
        if (this.mClosed) {
            throw new IOException();
        }
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedIOException();
        }
        lock();
        if (loadRecorder != null) {
            try {
                this.mFileAccessor.seek(loadRecorder.getStart());
                i2 = (int) Math.min(i2, loadRecorder.size());
            } finally {
                unlock();
            }
        }
        this.mFileAccessor.write(bArr, i, i2);
        if (loadRecorder != null) {
            loadRecorder.add(i2);
        }
        return i2;
    }
}
