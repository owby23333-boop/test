package com.kwad.framework.filedownloader.download;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    final long anh;
    final long ani;
    final long anj;
    final long contentLength;

    a(long j, long j2, long j3, long j4) {
        this.anh = j;
        this.ani = j2;
        this.anj = j3;
        this.contentLength = j4;
    }

    public final String toString() {
        return com.kwad.framework.filedownloader.f.f.c("range[%d, %d) current offset[%d]", Long.valueOf(this.anh), Long.valueOf(this.anj), Long.valueOf(this.ani));
    }
}
