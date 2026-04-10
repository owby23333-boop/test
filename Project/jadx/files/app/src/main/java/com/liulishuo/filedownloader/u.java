package com.liulishuo.filedownloader;

import android.content.Context;
import com.liulishuo.filedownloader.model.FileDownloadHeader;

/* JADX INFO: compiled from: IFileDownloadServiceProxy.java */
/* JADX INFO: loaded from: classes3.dex */
public interface u {
    void a(Context context);

    void a(Context context, Runnable runnable);

    boolean a();

    boolean a(String str, String str2, boolean z2, int i2, int i3, int i4, boolean z3, FileDownloadHeader fileDownloadHeader, boolean z4);

    byte getStatus(int i2);

    boolean isConnected();

    boolean pause(int i2);

    void stopForeground(boolean z2);
}
