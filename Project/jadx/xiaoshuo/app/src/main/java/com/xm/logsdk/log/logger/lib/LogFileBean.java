package com.xm.logsdk.log.logger.lib;

/* JADX INFO: loaded from: classes8.dex */
public class LogFileBean {
    private boolean enableMmap;
    private String fileName;
    private int ioBufferSize;
    private boolean ioBufferedIO;
    private boolean ioFileAppend;
    private int mmapBufferSize;

    public LogFileBean() {
        this.fileName = null;
        this.ioFileAppend = true;
        this.ioBufferedIO = false;
        this.ioBufferSize = 1024;
        this.enableMmap = true;
        this.mmapBufferSize = MmapWriter.DEFAULT_MAX_CACHE_SIZE;
    }

    public String getFileName() {
        return this.fileName;
    }

    public int getIoBufferSize() {
        return this.ioBufferSize;
    }

    public int getMmapBufferSize() {
        return this.mmapBufferSize;
    }

    public boolean isEnableMmap() {
        return this.enableMmap;
    }

    public boolean isIoBufferedIO() {
        return this.ioBufferedIO;
    }

    public boolean isIoFileAppend() {
        return this.ioFileAppend;
    }

    public void setEnableMmap(boolean z) {
        this.enableMmap = z;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setIoBufferSize(int i) {
        this.ioBufferSize = i;
    }

    public void setIoBufferedIO(boolean z) {
        this.ioBufferedIO = z;
    }

    public void setIoFileAppend(boolean z) {
        this.ioFileAppend = z;
    }

    public void setMmapBufferSize(int i) {
        this.mmapBufferSize = i;
    }

    public LogFileBean(String str, boolean z, boolean z2, int i) {
        this.mmapBufferSize = MmapWriter.DEFAULT_MAX_CACHE_SIZE;
        this.fileName = str;
        this.ioFileAppend = z;
        this.ioBufferedIO = z2;
        this.ioBufferSize = i;
        this.enableMmap = false;
    }

    public LogFileBean(String str, int i) {
        this.ioFileAppend = true;
        this.ioBufferedIO = false;
        this.ioBufferSize = 1024;
        this.fileName = str;
        this.enableMmap = true;
        this.mmapBufferSize = i;
    }

    public LogFileBean(String str) {
        this.ioFileAppend = true;
        this.ioBufferedIO = false;
        this.ioBufferSize = 1024;
        this.fileName = str;
        this.enableMmap = true;
        this.mmapBufferSize = MmapWriter.DEFAULT_MAX_CACHE_SIZE;
    }
}
