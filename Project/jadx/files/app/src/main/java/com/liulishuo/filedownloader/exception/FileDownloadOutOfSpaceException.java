package com.liulishuo.filedownloader.exception;

import android.annotation.TargetApi;
import com.liulishuo.filedownloader.h0.f;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class FileDownloadOutOfSpaceException extends IOException {
    @TargetApi(9)
    public FileDownloadOutOfSpaceException(long j2, long j3, long j4, Throwable th) {
        super(f.a("The file is too large to store, breakpoint in bytes:  %d, required space in bytes: %d, but free space in bytes: %d", Long.valueOf(j4), Long.valueOf(j3), Long.valueOf(j2)), th);
        a(j2, j3, j4);
    }

    private void a(long j2, long j3, long j4) {
    }

    public FileDownloadOutOfSpaceException(long j2, long j3, long j4) {
        super(f.a("The file is too large to store, breakpoint in bytes:  %d, required space in bytes: %d, but free space in bytes: %d", Long.valueOf(j4), Long.valueOf(j3), Long.valueOf(j2)));
        a(j2, j3, j4);
    }
}
