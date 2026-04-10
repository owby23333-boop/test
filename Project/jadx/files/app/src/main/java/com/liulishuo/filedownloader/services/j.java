package com.liulishuo.filedownloader.services;

import android.content.Intent;
import android.os.IBinder;

/* JADX INFO: compiled from: IFileDownloadServiceHandler.java */
/* JADX INFO: loaded from: classes3.dex */
interface j {
    IBinder onBind(Intent intent);

    void onStartCommand(Intent intent, int i2, int i3);
}
