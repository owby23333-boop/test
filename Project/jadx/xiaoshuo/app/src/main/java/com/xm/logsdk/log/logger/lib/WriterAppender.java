package com.xm.logsdk.log.logger.lib;

import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes8.dex */
public class WriterAppender extends AppenderSkeleton {
    protected File file;
    protected boolean immediateFlush = true;
    protected OutputStream qw;

    public WriterAppender() {
    }

    @Override // com.xm.logsdk.log.logger.lib.AppenderSkeleton
    public void appendIO(String str) {
        if (str == null) {
            return;
        }
        if (this.qw != null) {
            write(str);
        }
        if (shouldFlush()) {
            flush();
        }
    }

    @Override // com.xm.logsdk.log.logger.lib.Logger
    public synchronized void close() {
        writeFooter();
        closeWriter();
    }

    public void closeWriter() {
        OutputStream outputStream = this.qw;
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                if (e instanceof InterruptedIOException) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        this.qw = null;
    }

    public DataOutputStream createWriter(OutputStream outputStream) {
        return new DataOutputStream(outputStream);
    }

    @Override // com.xm.logsdk.log.logger.lib.Logger
    public void flush() {
        OutputStream outputStream = this.qw;
        if (outputStream != null) {
            try {
                outputStream.flush();
            } catch (Exception e) {
                loge(e.getMessage(), e);
            }
        }
    }

    @Override // com.xm.logsdk.log.logger.lib.Logger
    public boolean isFileExist(boolean z) {
        File file = this.file;
        if (file != null) {
            return file.exists();
        }
        return false;
    }

    public void reset() {
        close();
    }

    public void setImmediateFlush(boolean z) {
        this.immediateFlush = z;
    }

    public synchronized void setWriter(OutputStream outputStream) {
        reset();
        this.qw = outputStream;
        writeHeader();
    }

    public boolean shouldFlush() {
        return this.immediateFlush;
    }

    public void write(String str) {
        OutputStream outputStream = this.qw;
        if (outputStream == null || str == null) {
            return;
        }
        try {
            outputStream.write(str.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.xm.logsdk.log.logger.lib.Logger
    public void writeFooter() {
        byte[] strFooter = getStrFooter();
        if (strFooter == null || this.qw == null) {
            return;
        }
        write(strFooter, 0, strFooter.length);
    }

    @Override // com.xm.logsdk.log.logger.lib.Logger
    public void writeHeader() {
        byte[] strHeader = getStrHeader();
        if (strHeader == null || this.qw == null) {
            return;
        }
        write(strHeader, 0, strHeader.length);
    }

    public WriterAppender(OutputStream outputStream) {
        setWriter(outputStream);
    }

    public void write(byte[] bArr, int i, int i2) {
        OutputStream outputStream = this.qw;
        if (outputStream == null || bArr == null) {
            return;
        }
        try {
            outputStream.write(bArr, i, i2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.xm.logsdk.log.logger.lib.AppenderSkeleton
    public void appendIO(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            return;
        }
        if (this.qw != null) {
            write(bArr, i, i2);
        }
        if (shouldFlush()) {
            flush();
        }
    }
}
