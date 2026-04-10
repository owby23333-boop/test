package com.ss.android.socialbase.downloader.downloader;

import android.app.Notification;
import android.content.Intent;
import android.os.IBinder;
import com.ss.android.socialbase.downloader.downloader.CSJDownloadService;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes4.dex */
public interface p<T extends CSJDownloadService> {
    void a();

    void dl();

    void dl(com.ss.android.socialbase.downloader.e.a aVar);

    void g(com.ss.android.socialbase.downloader.e.a aVar);

    boolean g();

    void startService();

    IBinder z(Intent intent);

    void z(int i);

    void z(int i, Notification notification);

    void z(Intent intent, int i, int i2);

    void z(ls lsVar);

    void z(WeakReference<T> weakReference);

    void z(boolean z);

    boolean z();
}
