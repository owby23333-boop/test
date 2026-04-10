package com.kwad.sdk.core.download.b;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import com.kwad.sdk.DownloadTask;
import com.kwad.sdk.api.push.KsNotificationCompat;
import com.kwad.sdk.core.download.DownloadParams;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.d;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.ba;
import com.kwad.sdk.utils.t;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements d {
    private static c aDy;
    private boolean aDA = false;
    private boolean aDB = false;
    private int aDC = 0;
    private static HashMap<String, WeakReference<Bitmap>> aDx = new HashMap<>();
    private static final Handler aDz = new HandlerC0400a();

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(int i, Notification notification) {
        GW();
        NotificationManager notificationManager = (NotificationManager) ServiceProvider.Pp().getSystemService("notification");
        try {
            NotificationChannel notificationChannel = new NotificationChannel("download_channel", "ksad", 3);
            notificationChannel.enableLights(false);
            notificationChannel.enableVibration(false);
            notificationChannel.setSound(null, null);
            notificationChannel.setShowBadge(false);
            notificationManager.createNotificationChannel(notificationChannel);
            notificationManager.notify(i, notification);
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }

    private static void GW() {
        if (aDy != null) {
            return;
        }
        aDy = new c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.ksad.action.ACTION_NOTIFICATION_CLICK_CONTROL_BTN");
        intentFilter.addAction("com.ksad.action.ACTION_NOTIFICATION_REMOVED");
        if (Build.VERSION.SDK_INT >= 33) {
            ServiceProvider.Pp().registerReceiver(aDy, intentFilter, 2);
        } else {
            ServiceProvider.Pp().registerReceiver(aDy, intentFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String ax(long j) {
        return String.format("%.2fMB", Float.valueOf((j / 1000.0f) / 1000.0f));
    }

    @Override // com.kwad.sdk.d
    public final void i(DownloadTask downloadTask) {
        Object tag = downloadTask.getTag();
        if (tag instanceof DownloadParams) {
            String str = ((DownloadParams) tag).mAppIcon;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            File fileCf = ((com.kwad.sdk.service.a.d) ServiceProvider.get(com.kwad.sdk.service.a.d.class)).cf(str);
            if (fileCf == null || !fileCf.exists()) {
                ((com.kwad.sdk.service.a.d) ServiceProvider.get(com.kwad.sdk.service.a.d.class)).a(true, str, "", "");
            }
        }
    }

    @Override // com.kwad.sdk.d
    public final void a(DownloadTask downloadTask, boolean z) {
        com.kwad.sdk.core.download.b.c cVarA;
        Context contextPp = ServiceProvider.Pp();
        if (contextPp == null || downloadTask.isNotificationRemoved() || (cVarA = com.kwad.sdk.core.download.b.c.a(contextPp, downloadTask.getId(), downloadTask.downloadEnablePause)) == null) {
            return;
        }
        if (!this.aDA) {
            this.aDA = true;
            this.aDB = ((h) ServiceProvider.get(h.class)).BX();
            this.aDC = ((h) ServiceProvider.get(h.class)).BY();
        }
        com.kwad.sdk.core.d.c.d("AdDownloadNotificationPerformer", "DownloadProgressTransformUtil in notifyDownloadProgress");
        a(contextPp, cVarA, b.a(downloadTask, "正在下载", null, this.aDB, this.aDC));
        a(contextPp, cVarA.build(), false, true, null, downloadTask.getId(), z ? 1 : 0, downloadTask.isCompleted() ? 1 : 0);
    }

    @Override // com.kwad.sdk.d
    public final void j(DownloadTask downloadTask) {
        Context contextPp = ServiceProvider.Pp();
        if (contextPp == null || downloadTask.isNotificationRemoved()) {
            return;
        }
        String str = downloadTask.getSmallFileSoFarBytes() > 0 && downloadTask.getSmallFileTotalBytes() > 0 ? "正在下载" : "准备下载";
        if (!this.aDA) {
            this.aDA = true;
            this.aDB = ((h) ServiceProvider.get(h.class)).BX();
            this.aDC = ((h) ServiceProvider.get(h.class)).BY();
        }
        com.kwad.sdk.core.d.c.d("AdDownloadNotificationPerformer", "DownloadProgressTransformUtil in notifyDownloadError");
        b bVarA = b.a(downloadTask, str, null, this.aDB, this.aDC);
        com.kwad.sdk.core.download.b.c cVarA = com.kwad.sdk.core.download.b.c.a(contextPp, downloadTask.getId(), downloadTask.downloadEnablePause);
        if (cVarA == null) {
            return;
        }
        a(contextPp, cVarA, bVarA);
        a(contextPp, cVarA.build(), false, true, null, downloadTask.getId(), 1, downloadTask.isCompleted() ? 1 : 0);
    }

    @Override // com.kwad.sdk.d
    public final void k(DownloadTask downloadTask) {
        DownloadParams downloadParamsM;
        com.kwad.sdk.core.download.b.b bVarBy;
        Context contextPp = ServiceProvider.Pp();
        if (contextPp == null || (downloadParamsM = m(downloadTask)) == null || (bVarBy = com.kwad.sdk.core.download.b.b.by(contextPp)) == null) {
            return;
        }
        if (!this.aDA) {
            this.aDA = true;
            this.aDB = ((h) ServiceProvider.get(h.class)).BX();
            this.aDC = ((h) ServiceProvider.get(h.class)).BY();
        }
        com.kwad.sdk.core.d.c.d("AdDownloadNotificationPerformer", "DownloadProgressTransformUtil in notifyDownloadCompleted");
        a(contextPp, bVarBy, b.a(downloadTask, "下载完成", "立即安装", this.aDB, this.aDC));
        com.kwad.sdk.core.a.Em().a(downloadTask.getTargetFilePath(), downloadParamsM);
        com.kwad.sdk.core.a.Em().a(downloadParamsM.mPkgname, downloadParamsM);
        a(contextPp, bVarBy.build(), false, false, at.a(contextPp, new File(downloadTask.getTargetFilePath()), downloadParamsM.mTaskId, downloadParamsM.requestInstallPermission), downloadTask.getId(), 1, 1);
    }

    @Override // com.kwad.sdk.d
    public final void g(File file) {
        Context contextPp = ServiceProvider.Pp();
        if (contextPp == null) {
            return;
        }
        DownloadParams downloadParamsDi = com.kwad.sdk.core.a.Em().di(file.getAbsolutePath());
        com.kwad.sdk.core.a.Em().dj(file.getAbsolutePath());
        if (downloadParamsDi == null) {
            return;
        }
        AdTemplate adTemplateDk = com.kwad.sdk.core.a.Em().dk(downloadParamsDi.mDownloadid);
        if (adTemplateDk != null) {
            adTemplateDk.installFrom = "recall";
        }
        b bVarA = b.a(downloadParamsDi, "下载完成", "立即安装");
        com.kwad.sdk.core.download.b.b bVarBy = com.kwad.sdk.core.download.b.b.by(contextPp);
        if (bVarBy == null) {
            return;
        }
        a(contextPp, bVarBy, bVarA);
        a(contextPp, bVarBy.build(), false, false, at.a(contextPp, file, downloadParamsDi.mTaskId, downloadParamsDi.requestInstallPermission), downloadParamsDi.mTaskId, 1, 2);
    }

    @Override // com.kwad.sdk.d
    public final void cd(String str) {
        Context contextPp = ServiceProvider.Pp();
        DownloadParams downloadParamsDi = com.kwad.sdk.core.a.Em().di(str);
        com.kwad.sdk.core.a.Em().dj(str);
        if (contextPp == null || downloadParamsDi == null) {
            return;
        }
        com.kwad.sdk.core.a.Em().dj(downloadParamsDi.filePath);
        b bVarA = b.a(downloadParamsDi, "安装完成", "立刻打开");
        com.kwad.sdk.core.download.b.b bVarBy = com.kwad.sdk.core.download.b.b.by(contextPp);
        if (bVarBy == null) {
            return;
        }
        a(contextPp, bVarBy, bVarA);
        a(contextPp, bVarBy.build(), false, false, at.d(contextPp, downloadParamsDi.mPkgname, downloadParamsDi.mTaskId), downloadParamsDi.mTaskId, 1, 2);
    }

    private static DownloadParams m(DownloadTask downloadTask) {
        DownloadParams downloadParams;
        if (downloadTask == null) {
            return null;
        }
        Object tag = downloadTask.getTag();
        if (tag instanceof DownloadParams) {
            downloadParams = (DownloadParams) tag;
        } else {
            downloadParams = new DownloadParams();
        }
        downloadParams.mAppSize = downloadTask.getSmallFileTotalBytes();
        downloadParams.mTaskId = downloadTask.getId();
        downloadParams.filePath = downloadTask.getTargetFilePath();
        return downloadParams;
    }

    private boolean a(com.kwad.sdk.core.download.b.c cVar, File file) {
        try {
            cVar.setIcon(q(file));
            return true;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            com.kwad.sdk.service.d.gatherException(e);
            return false;
        }
    }

    private boolean a(Context context, com.kwad.sdk.core.download.b.c cVar, String str) {
        try {
            cVar.setIcon(G(context, str));
            return true;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            com.kwad.sdk.service.d.gatherException(e);
            return false;
        }
    }

    private boolean a(com.kwad.sdk.core.download.b.b bVar, File file) {
        try {
            bVar.setIcon(q(file));
            return true;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            com.kwad.sdk.service.d.gatherException(e);
            return false;
        }
    }

    private boolean a(Context context, com.kwad.sdk.core.download.b.b bVar, String str) {
        try {
            bVar.setIcon(G(context, str));
            return true;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
            com.kwad.sdk.service.d.gatherException(e);
            return false;
        }
    }

    private static Bitmap q(File file) {
        String absolutePath = file.getAbsolutePath();
        WeakReference<Bitmap> weakReference = aDx.get(absolutePath);
        Bitmap bitmap = weakReference != null ? weakReference.get() : null;
        if (bitmap != null && !bitmap.isRecycled()) {
            return bitmap;
        }
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(absolutePath);
        aDx.put(absolutePath, new WeakReference<>(bitmapDecodeFile));
        return bitmapDecodeFile;
    }

    private static Bitmap G(Context context, String str) {
        WeakReference<Bitmap> weakReference = aDx.get(str);
        Bitmap bitmap = weakReference != null ? weakReference.get() : null;
        if (bitmap != null && !bitmap.isRecycled()) {
            return bitmap;
        }
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(ba.dn(context), ba.aw(context, str));
        aDx.put(str, new WeakReference<>(bitmapDecodeResource));
        return bitmapDecodeResource;
    }

    @Override // com.kwad.sdk.d
    public final void co(int i) {
        Context contextPp = ServiceProvider.Pp();
        if (contextPp == null) {
            return;
        }
        ((NotificationManager) contextPp.getSystemService("notification")).cancel(i);
    }

    private void a(Context context, RemoteViews remoteViews, boolean z, boolean z2, PendingIntent pendingIntent, int i, int i2, int i3) {
        KsNotificationCompat.Builder builder = new KsNotificationCompat.Builder(context, "download_channel");
        builder.setWhen(System.currentTimeMillis()).setOngoing(false).setAutoCancel(false).setOnlyAlertOnce(true).setPriority(-1).setContentIntent(pendingIntent).setSmallIcon(ba.getAppIconId(context));
        a(builder, remoteViews);
        if (z2) {
            Intent intent = new Intent("com.ksad.action.ACTION_NOTIFICATION_REMOVED");
            intent.putExtra("taskId", i);
            builder.setDeleteIntent(at.a(context, i, intent));
        }
        Handler handler = aDz;
        handler.removeMessages(i);
        handler.obtainMessage(i, i2, i3, builder.build()).sendToTarget();
    }

    private static void a(KsNotificationCompat.Builder builder, RemoteViews remoteViews) {
        try {
            builder.setDecoratedCustomStyle().setCustomBigContentView(remoteViews).setCustomContentView(remoteViews);
        } catch (Throwable unused) {
            builder.setContent(remoteViews);
        }
    }

    /* JADX INFO: renamed from: com.kwad.sdk.core.download.b.a$a, reason: collision with other inner class name */
    static class HandlerC0400a extends Handler {
        private final SparseArray<Long> aDD;

        HandlerC0400a() {
            super(Looper.getMainLooper());
            this.aDD = new SparseArray<>();
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            boolean z = message.arg1 == 1;
            boolean z2 = message.arg2 == 1;
            boolean z3 = message.arg2 == 2;
            Long l = this.aDD.get(message.what);
            NotificationManager notificationManager = (NotificationManager) com.kwad.sdk.c.AA().getContext().getSystemService("notification");
            if (notificationManager == null) {
                return;
            }
            if (com.kwad.sdk.c.AA().cl(message.what) == null && !z3) {
                removeMessages(message.what);
                notificationManager.cancel(message.what);
            } else {
                if (z || l == null || System.currentTimeMillis() - l.longValue() >= 110) {
                    if (z2) {
                        notificationManager.cancel(message.what);
                    }
                    a.a(message.what, (Notification) message.obj);
                    this.aDD.put(message.what, Long.valueOf(System.currentTimeMillis()));
                    return;
                }
                sendMessageDelayed(Message.obtain(message), (l.longValue() + 110) - System.currentTimeMillis());
            }
        }
    }

    private void a(Context context, com.kwad.sdk.core.download.b.c cVar, b bVar) {
        cVar.setName(bVar.getName());
        File fileHb = bVar.Hb();
        if (!((fileHb == null || !fileHb.exists()) ? false : a(cVar, fileHb))) {
            a(context, cVar, b.GX());
        }
        cVar.setStatus(bVar.Ha());
        cVar.setSize(bVar.GY());
        cVar.setPercentNum(bVar.Hc());
        cVar.setProgress(100, bVar.getProgress(), false);
        cVar.setControlBtnPaused(bVar.isPaused());
    }

    private void a(Context context, com.kwad.sdk.core.download.b.b bVar, b bVar2) {
        bVar.setName(bVar2.getName());
        File fileHb = bVar2.Hb();
        if (!((fileHb == null || !fileHb.exists()) ? false : a(bVar, fileHb))) {
            a(context, bVar, b.GX());
        }
        bVar.setStatus(bVar2.Ha());
        bVar.setSize(bVar2.GZ());
        bVar.setInstallText(bVar2.Hd());
    }

    static class b {
        private static String aDE = "ksad_notification_default_icon";
        private String aDF;
        private String aDG;
        private String aDI;
        private String ahn;
        private String name;
        private int progress;
        private File aDH = null;
        private boolean aDJ = false;

        private b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b a(DownloadTask downloadTask, String str, String str2, boolean z, int i) {
            b bVar = new b();
            Object tag = downloadTask.getTag();
            if (tag instanceof DownloadParams) {
                DownloadParams downloadParams = (DownloadParams) tag;
                File fileCf = ((com.kwad.sdk.service.a.d) ServiceProvider.get(com.kwad.sdk.service.a.d.class)).cf(downloadParams.mAppIcon);
                if (fileCf != null && fileCf.exists()) {
                    bVar.aDH = fileCf;
                }
                bVar.name = downloadParams.mAppName;
            }
            bVar.aDJ = downloadTask.isPaused();
            bVar.ahn = str;
            bVar.aDI = str2;
            bVar.aDG = a.ax(downloadTask.getSmallFileTotalBytes());
            int iA = t.a(downloadTask.getSmallFileSoFarBytes(), downloadTask.getSmallFileTotalBytes(), z, i);
            bVar.progress = iA;
            bVar.aDF = a.ax((long) (((double) downloadTask.getSmallFileTotalBytes()) * ((((double) iA) * 1.0d) / 100.0d))) + " / " + a.ax(downloadTask.getSmallFileTotalBytes());
            return bVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b a(DownloadParams downloadParams, String str, String str2) {
            File fileCf;
            b bVar = new b();
            bVar.name = downloadParams.mAppName;
            if (!TextUtils.isEmpty(downloadParams.mAppIcon) && (fileCf = ((com.kwad.sdk.service.a.d) ServiceProvider.get(com.kwad.sdk.service.a.d.class)).cf(downloadParams.mAppIcon)) != null && fileCf.exists()) {
                bVar.aDH = fileCf;
            }
            bVar.ahn = str;
            bVar.aDG = a.ax(downloadParams.mAppSize);
            bVar.aDI = str2;
            return bVar;
        }

        public static String GX() {
            return aDE;
        }

        public final String getName() {
            String str = this.name;
            return str == null ? "" : str;
        }

        public final String GY() {
            return this.aDF;
        }

        public final String GZ() {
            return this.aDG;
        }

        public final String Ha() {
            return this.ahn;
        }

        public final File Hb() {
            return this.aDH;
        }

        public final String Hc() {
            return "正在下载 " + this.progress + "%";
        }

        public final int getProgress() {
            return this.progress;
        }

        public final String Hd() {
            return this.aDI;
        }

        public final boolean isPaused() {
            return this.aDJ;
        }
    }

    static class c extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if (intent == null || intent.getExtras() == null) {
                return;
            }
            String action = intent.getAction();
            if ("com.ksad.action.ACTION_NOTIFICATION_CLICK_CONTROL_BTN".equals(action)) {
                e(intent);
            } else if ("com.ksad.action.ACTION_NOTIFICATION_REMOVED".equals(action)) {
                f(intent);
            }
        }

        private static void e(Intent intent) {
            DownloadTask downloadTaskG = g(intent);
            if (downloadTaskG == null) {
                return;
            }
            com.kwad.sdk.c.AA().cn(downloadTaskG.getId());
        }

        private static void f(Intent intent) {
            DownloadTask downloadTaskG = g(intent);
            if (downloadTaskG == null) {
                return;
            }
            downloadTaskG.setNotificationRemoved(true);
        }

        private static DownloadTask g(Intent intent) {
            int i = intent.getExtras().getInt("taskId", 0);
            if (i == 0) {
                return null;
            }
            return com.kwad.sdk.c.AA().cl(i);
        }
    }
}
