package com.liulishuo.filedownloader.services;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import com.liulishuo.filedownloader.b0;
import com.umeng.message.entity.UMessage;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"Registered"})
public class FileDownloadService extends Service {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private j f17279s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private b0 f17280t;

    public static class SeparateProcessService extends FileDownloadService {
    }

    public static class SharedMainProcessService extends FileDownloadService {
    }

    private void a(Intent intent) {
        if (intent != null && intent.getBooleanExtra("is_foreground", false)) {
            i iVarB = com.liulishuo.filedownloader.download.c.i().b();
            if (iVarB.d() && Build.VERSION.SDK_INT >= 26) {
                NotificationChannel notificationChannel = new NotificationChannel(iVarB.a(), iVarB.b(), 2);
                NotificationManager notificationManager = (NotificationManager) getSystemService(UMessage.DISPLAY_TYPE_NOTIFICATION);
                if (notificationManager == null) {
                    return;
                } else {
                    notificationManager.createNotificationChannel(notificationChannel);
                }
            }
            startForeground(iVarB.c(), iVarB.a(this));
            if (com.liulishuo.filedownloader.h0.d.a) {
                com.liulishuo.filedownloader.h0.d.a(this, "run service foreground with config: %s", iVarB);
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f17279s.onBind(intent);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        com.liulishuo.filedownloader.h0.c.a(this);
        try {
            com.liulishuo.filedownloader.h0.f.a(com.liulishuo.filedownloader.h0.e.a().a);
            com.liulishuo.filedownloader.h0.f.a(com.liulishuo.filedownloader.h0.e.a().b);
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
        g gVar = new g();
        if (com.liulishuo.filedownloader.h0.e.a().f17208d) {
            this.f17279s = new e(new WeakReference(this), gVar);
        } else {
            this.f17279s = new d(new WeakReference(this), gVar);
        }
        b0.c();
        this.f17280t = new b0((com.liulishuo.filedownloader.f0.b) this.f17279s);
        this.f17280t.a();
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.f17280t.b();
        stopForeground(true);
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        this.f17279s.onStartCommand(intent, i2, i3);
        a(intent);
        return 1;
    }
}
