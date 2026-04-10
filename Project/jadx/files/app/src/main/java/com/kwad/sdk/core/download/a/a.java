package com.kwad.sdk.core.download.a;

import android.annotation.SuppressLint;
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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.download.DownloadTask;
import com.ksad.download.d;
import com.kwad.sdk.api.push.KsNotificationCompat;
import com.kwad.sdk.core.download.DownloadParams;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.e;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.bo;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.umeng.message.entity.UMessage;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements d {
    private static c aeS;
    private static HashMap<String, WeakReference<Bitmap>> aeR = new HashMap<>();
    private static final Handler aeT = new HandlerC0438a();

    /* JADX INFO: renamed from: com.kwad.sdk.core.download.a.a$a, reason: collision with other inner class name */
    static class HandlerC0438a extends Handler {
        private final SparseArray<Long> aeU;

        HandlerC0438a() {
            super(Looper.getMainLooper());
            this.aeU = new SparseArray<>();
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            boolean z2 = message.arg1 == 1;
            boolean z3 = message.arg2 == 1;
            boolean z4 = message.arg2 == 2;
            Long l2 = this.aeU.get(message.what);
            NotificationManager notificationManager = (NotificationManager) com.ksad.download.c.M().getContext().getSystemService(UMessage.DISPLAY_TYPE_NOTIFICATION);
            if (notificationManager == null) {
                return;
            }
            if (com.ksad.download.c.M().s(message.what) == null && !z4) {
                removeMessages(message.what);
                notificationManager.cancel(message.what);
            } else {
                if (!z2 && l2 != null && System.currentTimeMillis() - l2.longValue() < 110) {
                    sendMessageDelayed(Message.obtain(message), (l2.longValue() + 110) - System.currentTimeMillis());
                    return;
                }
                if (z3) {
                    notificationManager.cancel(message.what);
                }
                a.a(message.what, (Notification) message.obj);
                this.aeU.put(message.what, Long.valueOf(System.currentTimeMillis()));
            }
        }
    }

    static class b {
        private static String aeV = "ksad_notification_default_icon";
        private String Vg;
        private String aeW;
        private String aeX;
        private String aeZ;
        private String name;
        private int progress;
        private File aeY = null;
        private boolean afa = false;

        private b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b a(DownloadTask downloadTask, String str, String str2) {
            b bVar = new b();
            Object tag = downloadTask.getTag();
            if (tag instanceof DownloadParams) {
                DownloadParams downloadParams = (DownloadParams) tag;
                File fileAN = ((com.kwad.sdk.service.kwai.c) ServiceProvider.get(com.kwad.sdk.service.kwai.c.class)).aN(downloadParams.mAppIcon);
                if (fileAN != null && fileAN.exists()) {
                    bVar.aeY = fileAN;
                }
                bVar.name = downloadParams.mAppName;
            }
            bVar.afa = downloadTask.isPaused();
            bVar.Vg = str;
            bVar.aeZ = str2;
            bVar.aeW = a.I(downloadTask.getSmallFileSoFarBytes()) + " / " + a.I(downloadTask.getSmallFileTotalBytes());
            bVar.aeX = a.I((long) downloadTask.getSmallFileTotalBytes());
            bVar.progress = (int) ((((float) downloadTask.getSmallFileSoFarBytes()) * 100.0f) / ((float) downloadTask.getSmallFileTotalBytes()));
            return bVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b a(DownloadParams downloadParams, String str, String str2) {
            File fileAN;
            b bVar = new b();
            bVar.name = downloadParams.mAppName;
            if (!TextUtils.isEmpty(downloadParams.mAppIcon) && (fileAN = ((com.kwad.sdk.service.kwai.c) ServiceProvider.get(com.kwad.sdk.service.kwai.c.class)).aN(downloadParams.mAppIcon)) != null && fileAN.exists()) {
                bVar.aeY = fileAN;
            }
            bVar.Vg = str;
            bVar.aeX = a.I(downloadParams.mAppSize);
            bVar.aeZ = str2;
            return bVar;
        }

        public static String vL() {
            return aeV;
        }

        public final String getName() {
            String str = this.name;
            return str == null ? "" : str;
        }

        public final int getProgress() {
            return this.progress;
        }

        public final boolean isPaused() {
            return this.afa;
        }

        public final String vM() {
            return this.aeW;
        }

        public final String vN() {
            return this.aeX;
        }

        public final String vO() {
            return this.Vg;
        }

        public final File vP() {
            return this.aeY;
        }

        public final String vQ() {
            return "正在下载 " + this.progress + "%";
        }

        public final String vR() {
            return this.aeZ;
        }
    }

    static class c extends BroadcastReceiver {
        private static void g(@NonNull Intent intent) {
            DownloadTask downloadTaskI = i(intent);
            if (downloadTaskI == null) {
                return;
            }
            com.ksad.download.c.M().u(downloadTaskI.getId());
        }

        private static void h(@NonNull Intent intent) {
            DownloadTask downloadTaskI = i(intent);
            if (downloadTaskI == null) {
                return;
            }
            downloadTaskI.setNotificationRemoved(true);
        }

        @Nullable
        private static DownloadTask i(Intent intent) {
            int i2 = intent.getExtras().getInt(DBDefinition.TASK_ID, 0);
            if (i2 == 0) {
                return null;
            }
            return com.ksad.download.c.M().s(i2);
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            if (intent == null || intent.getExtras() == null) {
                return;
            }
            String action = intent.getAction();
            if ("com.ksad.action.ACTION_NOTIFICATION_CLICK_CONTROL_BTN".equals(action)) {
                g(intent);
            } else if ("com.ksad.action.ACTION_NOTIFICATION_REMOVED".equals(action)) {
                h(intent);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"DefaultLocale"})
    public static String I(long j2) {
        return String.format("%.2fMB", Float.valueOf((j2 / 1000.0f) / 1000.0f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(int i2, Notification notification) {
        Context context = com.ksad.download.c.M().getContext();
        if (context == null) {
            return;
        }
        aY(bo.dt(context));
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(UMessage.DISPLAY_TYPE_NOTIFICATION);
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                NotificationChannel notificationChannel = new NotificationChannel("download_channel", "ksad", 3);
                notificationChannel.enableLights(false);
                notificationChannel.enableVibration(false);
                notificationChannel.setSound(null, null);
                notificationChannel.setShowBadge(false);
                notificationManager.createNotificationChannel(notificationChannel);
            }
            notificationManager.notify(i2, notification);
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
        }
    }

    private static void a(Context context, RemoteViews remoteViews, boolean z2, boolean z3, @Nullable PendingIntent pendingIntent, int i2, int i3, int i4) {
        KsNotificationCompat.Builder builder = new KsNotificationCompat.Builder(context, "download_channel");
        builder.setContent(remoteViews).setWhen(System.currentTimeMillis()).setOngoing(false).setAutoCancel(false).setOnlyAlertOnce(true).setPriority(-1).setContentIntent(pendingIntent).setSmallIcon(aq.ao(context, "ksad_notification_small_icon"));
        if (z3) {
            builder.setDeleteIntent(b(context, "com.ksad.action.ACTION_NOTIFICATION_REMOVED", i2));
        }
        aeT.removeMessages(i2);
        aeT.obtainMessage(i2, i3, i4, builder.build()).sendToTarget();
    }

    private void a(Context context, com.kwad.sdk.core.download.a.b bVar, b bVar2) {
        bVar.setName(bVar2.getName());
        File fileVP = bVar2.vP();
        if (!((fileVP == null || !fileVP.exists()) ? false : a(bVar, fileVP))) {
            a(context, bVar, b.vL());
        }
        bVar.setStatus(bVar2.vO());
        bVar.setSize(bVar2.vN());
        bVar.setInstallText(bVar2.vR());
    }

    private void a(Context context, com.kwad.sdk.core.download.a.c cVar, b bVar) {
        cVar.setName(bVar.getName());
        File fileVP = bVar.vP();
        if (!((fileVP == null || !fileVP.exists()) ? false : a(cVar, fileVP))) {
            a(context, cVar, b.vL());
        }
        cVar.setStatus(bVar.vO());
        cVar.setSize(bVar.vM());
        cVar.setPercentNum(bVar.vQ());
        cVar.setProgress(100, bVar.getProgress(), false);
        cVar.setControlBtnPaused(bVar.isPaused());
    }

    private boolean a(Context context, com.kwad.sdk.core.download.a.b bVar, String str) {
        try {
            bVar.setIcon(u(context, str));
            return true;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
            com.kwad.sdk.service.b.gatherException(e2);
            return false;
        }
    }

    private boolean a(Context context, com.kwad.sdk.core.download.a.c cVar, String str) {
        try {
            cVar.setIcon(u(context, str));
            return true;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
            com.kwad.sdk.service.b.gatherException(e2);
            return false;
        }
    }

    private boolean a(com.kwad.sdk.core.download.a.b bVar, File file) {
        try {
            bVar.setIcon(l(file));
            return true;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
            com.kwad.sdk.service.b.gatherException(e2);
            return false;
        }
    }

    private boolean a(com.kwad.sdk.core.download.a.c cVar, File file) {
        try {
            cVar.setIcon(l(file));
            return true;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
            com.kwad.sdk.service.b.gatherException(e2);
            return false;
        }
    }

    private static void aY(Context context) {
        if (aeS != null || context == null) {
            return;
        }
        aeS = new c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.ksad.action.ACTION_NOTIFICATION_CLICK_CONTROL_BTN");
        intentFilter.addAction("com.ksad.action.ACTION_NOTIFICATION_REMOVED");
        context.registerReceiver(aeS, intentFilter);
    }

    private static PendingIntent b(Context context, String str, int i2) {
        Intent intent = new Intent(str);
        intent.putExtra(DBDefinition.TASK_ID, i2);
        return PendingIntent.getBroadcast(context, i2, intent, 0);
    }

    private static Bitmap l(File file) {
        String absolutePath = file.getAbsolutePath();
        WeakReference<Bitmap> weakReference = aeR.get(absolutePath);
        Bitmap bitmap = weakReference != null ? weakReference.get() : null;
        if (bitmap != null && !bitmap.isRecycled()) {
            return bitmap;
        }
        Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(absolutePath);
        aeR.put(absolutePath, new WeakReference<>(bitmapDecodeFile));
        return bitmapDecodeFile;
    }

    private static DownloadParams n(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return null;
        }
        Object tag = downloadTask.getTag();
        DownloadParams downloadParams = tag instanceof DownloadParams ? (DownloadParams) tag : new DownloadParams();
        downloadParams.mAppSize = downloadTask.getSmallFileTotalBytes();
        downloadParams.mTaskId = downloadTask.getId();
        downloadParams.filePath = downloadTask.getTargetFilePath();
        return downloadParams;
    }

    private static Bitmap u(Context context, String str) {
        WeakReference<Bitmap> weakReference = aeR.get(str);
        Bitmap bitmap = weakReference != null ? weakReference.get() : null;
        if (bitmap != null && !bitmap.isRecycled()) {
            return bitmap;
        }
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(aq.cA(context), aq.ao(context, str));
        aeR.put(str, new WeakReference<>(bitmapDecodeResource));
        return bitmapDecodeResource;
    }

    @Override // com.ksad.download.d
    public final void a(DownloadTask downloadTask, boolean z2) {
        com.kwad.sdk.core.download.a.c cVarA;
        Context context = ((e) ServiceProvider.get(e.class)).getContext();
        if (context == null || downloadTask.isNotificationRemoved() || (cVarA = com.kwad.sdk.core.download.a.c.a(context, downloadTask.getId(), downloadTask.downloadEnablePause)) == null) {
            return;
        }
        a(context, cVarA, b.a(downloadTask, "正在下载", (String) null));
        a(context, cVarA.build(), false, true, null, downloadTask.getId(), z2 ? 1 : 0, downloadTask.isCompleted() ? 1 : 0);
    }

    @Override // com.ksad.download.d
    public final void b(File file) {
        Context context = ((e) ServiceProvider.get(e.class)).getContext();
        DownloadParams downloadParamsBf = com.kwad.sdk.core.a.ud().bf(file.getAbsolutePath());
        com.kwad.sdk.core.a.ud().bg(file.getAbsolutePath());
        if (context == null || downloadParamsBf == null) {
            return;
        }
        AdTemplate adTemplateBh = com.kwad.sdk.core.a.ud().bh(downloadParamsBf.mDownloadid);
        if (adTemplateBh != null) {
            adTemplateBh.installFrom = "recall";
            com.kwad.sdk.core.download.c.vG().an(adTemplateBh);
        }
        b bVarA = b.a(downloadParamsBf, "下载完成", "立即安装");
        com.kwad.sdk.core.download.a.b bVarAZ = com.kwad.sdk.core.download.a.b.aZ(context);
        if (bVarAZ == null) {
            return;
        }
        a(context, bVarAZ, bVarA);
        a(context, bVarAZ.build(), false, false, com.ksad.download.e.a(file, downloadParamsBf.mTaskId, downloadParamsBf.requestInstallPermission), downloadParamsBf.mTaskId, 1, 2);
    }

    @Override // com.ksad.download.d
    public final void i(DownloadTask downloadTask) {
        Object tag = downloadTask.getTag();
        if (tag instanceof DownloadParams) {
            String str = ((DownloadParams) tag).mAppIcon;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            File fileAN = ((com.kwad.sdk.service.kwai.c) ServiceProvider.get(com.kwad.sdk.service.kwai.c.class)).aN(str);
            if (fileAN == null || !fileAN.exists()) {
                ((com.kwad.sdk.service.kwai.c) ServiceProvider.get(com.kwad.sdk.service.kwai.c.class)).a(true, str, "", "");
            }
        }
    }

    @Override // com.ksad.download.d
    public final void j(DownloadTask downloadTask) {
        Context context = ((e) ServiceProvider.get(e.class)).getContext();
        if (context == null || downloadTask.isNotificationRemoved()) {
            return;
        }
        b bVarA = b.a(downloadTask, downloadTask.getSmallFileSoFarBytes() > 0 && downloadTask.getSmallFileTotalBytes() > 0 ? "正在下载" : "准备下载", (String) null);
        com.kwad.sdk.core.download.a.c cVarA = com.kwad.sdk.core.download.a.c.a(context, downloadTask.getId(), downloadTask.downloadEnablePause);
        if (cVarA == null) {
            return;
        }
        a(context, cVarA, bVarA);
        a(context, cVarA.build(), false, true, null, downloadTask.getId(), 1, downloadTask.isCompleted() ? 1 : 0);
    }

    @Override // com.ksad.download.d
    public final void k(DownloadTask downloadTask) {
        Context context = ((e) ServiceProvider.get(e.class)).getContext();
        if (context == null) {
            return;
        }
        DownloadParams downloadParamsN = n(downloadTask);
        com.kwad.sdk.core.download.a.b bVarAZ = com.kwad.sdk.core.download.a.b.aZ(context);
        if (bVarAZ == null) {
            return;
        }
        a(context, bVarAZ, b.a(downloadTask, "下载完成", "立即安装"));
        com.kwad.sdk.core.a.ud().a(downloadTask.getTargetFilePath(), downloadParamsN);
        com.kwad.sdk.core.a.ud().a(downloadParamsN.mPkgname, downloadParamsN);
        a(context, bVarAZ.build(), false, false, com.ksad.download.e.l(downloadTask), downloadTask.getId(), 1, 1);
    }

    @Override // com.ksad.download.d
    public final void n(String str) {
        Context context = ((e) ServiceProvider.get(e.class)).getContext();
        DownloadParams downloadParamsBf = com.kwad.sdk.core.a.ud().bf(str);
        com.kwad.sdk.core.a.ud().bg(str);
        if (context == null || downloadParamsBf == null) {
            return;
        }
        com.kwad.sdk.core.a.ud().bg(downloadParamsBf.filePath);
        b bVarA = b.a(downloadParamsBf, "安装完成", "立刻打开");
        com.kwad.sdk.core.download.a.b bVarAZ = com.kwad.sdk.core.download.a.b.aZ(context);
        if (bVarAZ == null) {
            return;
        }
        a(context, bVarAZ, bVarA);
        a(context, bVarAZ.build(), false, false, com.ksad.download.e.e(downloadParamsBf.mPkgname, downloadParamsBf.mTaskId), downloadParamsBf.mTaskId, 1, 2);
    }

    @Override // com.ksad.download.d
    public final void v(int i2) {
        Context context = ((e) ServiceProvider.get(e.class)).getContext();
        if (context == null) {
            return;
        }
        ((NotificationManager) context.getSystemService(UMessage.DISPLAY_TYPE_NOTIFICATION)).cancel(i2);
    }
}
