package com.arialyy.aria.util;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class BufferedRandomAccessFile extends RandomAccessFile {
    static final long BuffMask_ = -65536;
    public static final int BuffSz_ = 65536;
    static final int LogBuffSz_ = 16;
    private byte[] buff_;
    private boolean closed_;
    private long curr_;
    private boolean dirty_;
    private long diskPos_;
    private long hi_;
    private boolean hitEOF_;
    private long lo_;
    private long maxHi_;

    public BufferedRandomAccessFile(File file, String str) throws IOException {
        super(file, str);
        init(0);
    }

    private int fillBuffer() throws IOException {
        int length = this.buff_.length;
        int i2 = 0;
        while (length > 0) {
            int i3 = super.read(this.buff_, i2, length);
            if (i3 < 0) {
                break;
            }
            i2 += i3;
            length -= i3;
        }
        if (i2 < 0) {
            boolean z2 = i2 < this.buff_.length;
            this.hitEOF_ = z2;
            if (z2) {
                byte[] bArr = this.buff_;
                Arrays.fill(bArr, i2, bArr.length, (byte) -1);
            }
        }
        this.diskPos_ += (long) i2;
        return i2;
    }

    private void flushBuffer() throws IOException {
        if (this.dirty_) {
            long j2 = this.diskPos_;
            long j3 = this.lo_;
            if (j2 != j3) {
                super.seek(j3);
            }
            super.write(this.buff_, 0, (int) (this.curr_ - this.lo_));
            this.diskPos_ = this.curr_;
            this.dirty_ = false;
        }
    }

    private void init(int i2) {
        this.closed_ = false;
        this.dirty_ = false;
        this.hi_ = 0L;
        this.curr_ = 0L;
        this.lo_ = 0L;
        this.buff_ = i2 > 65536 ? new byte[i2] : new byte[65536];
        this.maxHi_ = PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
        this.hitEOF_ = false;
        this.diskPos_ = 0L;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int writeAtMost(byte[] r6, int r7, int r8) throws java.io.IOException {
        /*
            r5 = this;
            long r0 = r5.curr_
            long r2 = r5.hi_
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 < 0) goto L26
            boolean r0 = r5.hitEOF_
            if (r0 == 0) goto L15
            long r0 = r5.maxHi_
            int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r4 >= 0) goto L15
            r5.hi_ = r0
            goto L26
        L15:
            long r0 = r5.curr_
            r5.seek(r0)
            long r0 = r5.curr_
            long r2 = r5.hi_
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L26
            long r0 = r5.maxHi_
            r5.hi_ = r0
        L26:
            long r0 = r5.hi_
            long r2 = r5.curr_
            long r0 = r0 - r2
            int r1 = (int) r0
            int r8 = java.lang.Math.min(r8, r1)
            long r0 = r5.curr_
            long r2 = r5.lo_
            long r0 = r0 - r2
            int r1 = (int) r0
            byte[] r0 = r5.buff_
            java.lang.System.arraycopy(r6, r7, r0, r1, r8)
            long r6 = r5.curr_
            long r0 = (long) r8
            long r6 = r6 + r0
            r5.curr_ = r6
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arialyy.aria.util.BufferedRandomAccessFile.writeAtMost(byte[], int, int):int");
    }

    @Override // java.io.RandomAccessFile, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        flush();
        this.closed_ = true;
        super.close();
    }

    public void flush() throws IOException {
        flushBuffer();
    }

    @Override // java.io.RandomAccessFile
    public long getFilePointer() {
        return this.curr_;
    }

    @Override // java.io.RandomAccessFile
    public long length() throws IOException {
        return Math.max(this.curr_, super.length());
    }

    @Override // java.io.RandomAccessFile
    public int read() throws IOException {
        long j2 = this.curr_;
        if (j2 >= this.hi_) {
            if (this.hitEOF_) {
                return -1;
            }
            seek(j2);
            if (this.curr_ == this.hi_) {
                return -1;
            }
        }
        byte[] bArr = this.buff_;
        long j3 = this.curr_;
        byte b = bArr[(int) (j3 - this.lo_)];
        this.curr_ = j3 + 1;
        return b & 255;
    }

    @Override // java.io.RandomAccessFile
    public void seek(long j2) throws IOException {
        if (j2 >= this.hi_ || j2 < this.lo_) {
            flushBuffer();
            this.lo_ = BuffMask_ & j2;
            long j3 = this.lo_;
            this.maxHi_ = ((long) this.buff_.length) + j3;
            if (this.diskPos_ != j3) {
                super.seek(j3);
                this.diskPos_ = this.lo_;
            }
            this.hi_ = this.lo_ + ((long) fillBuffer());
        } else if (j2 < this.curr_) {
            flushBuffer();
        }
        this.curr_ = j2;
    }

    @Override // java.io.RandomAccessFile, java.io.DataOutput
    public void write(int i2) throws IOException {
        long j2 = this.curr_;
        long j3 = this.hi_;
        if (j2 >= j3) {
            if (!this.hitEOF_ || j3 >= this.maxHi_) {
                seek(this.curr_);
                long j4 = this.curr_;
                long j5 = this.hi_;
                if (j4 == j5) {
                    this.hi_ = j5 + 1;
                }
            } else {
                this.hi_ = j3 + 1;
            }
        }
        byte[] bArr = this.buff_;
        long j6 = this.curr_;
        bArr[(int) (j6 - this.lo_)] = (byte) i2;
        this.curr_ = j6 + 1;
        this.dirty_ = true;
    }

    public BufferedRandomAccessFile(File file, String str, int i2) throws IOException {
        super(file, str);
        init(i2);
    }

    public BufferedRandomAccessFile(String str, String str2) throws IOException {
        super(str, str2);
        init(0);
    }

    public BufferedRandomAccessFile(String str, String str2, int i2) throws FileNotFoundException {
        super(str, str2);
        init(i2);
    }

    @Override // java.io.RandomAccessFile
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.RandomAccessFile
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        long j2 = this.curr_;
        if (j2 >= this.hi_) {
            if (this.hitEOF_) {
                return -1;
            }
            seek(j2);
            if (this.curr_ == this.hi_) {
                return -1;
            }
        }
        int iMin = Math.min(i3, (int) (this.hi_ - this.curr_));
        System.arraycopy(this.buff_, (int) (this.curr_ - this.lo_), bArr, i2, iMin);
        this.curr_ += (long) iMin;
        return iMin;
    }

    @Override // java.io.RandomAccessFile, java.io.DataOutput
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.RandomAccessFile, java.io.DataOutput
    public void write(byte[] bArr, int i2, int i3) throws IOException {
        while (i3 > 0) {
            int iWriteAtMost = writeAtMost(bArr, i2, i3);
            i2 += iWriteAtMost;
            i3 -= iWriteAtMost;
            this.dirty_ = true;
        }
    }
}
