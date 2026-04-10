package com.kwai.filedownloader.download;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    final long aFw;
    final long aFx;
    final long aFy;
    final long contentLength;

    a(long j2, long j3, long j4, long j5) {
        this.aFw = j2;
        this.aFx = j3;
        this.aFy = j4;
        this.contentLength = j5;
    }

    public final String toString() {
        return com.kwai.filedownloader.e.f.j("range[%d, %d) current offset[%d]", Long.valueOf(this.aFw), Long.valueOf(this.aFy), Long.valueOf(this.aFx));
    }
}
