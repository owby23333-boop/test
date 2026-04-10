package com.amgcyo.cuttadon.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.content.FileProvider;
import com.amgcyo.cuttadon.api.entity.other.NewApiAd;
import com.amgcyo.cuttadon.f.o;
import com.amgcyo.cuttadon.receiver.MkNotiClickReceiver;
import com.amgcyo.cuttadon.utils.otherutils.g;
import com.amgcyo.cuttadon.utils.otherutils.h;
import com.amgcyo.cuttadon.utils.otherutils.z;
import com.amgcyo.cuttadon.view.webview.b;
import com.arialyy.annotations.Download;
import com.arialyy.aria.core.Aria;
import com.arialyy.aria.core.download.DownloadEntity;
import com.arialyy.aria.core.download.DownloadReceiver;
import com.arialyy.aria.core.download.target.HttpBuilderTarget;
import com.arialyy.aria.core.task.DownloadTask;
import com.fatcatfat.io.R;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import com.umeng.message.entity.UMessage;
import java.io.File;
import org.simple.eventbus.EventBus;

/* JADX INFO: loaded from: classes.dex */
public class MkDownloadApkService extends Service {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private NotificationManager f4345s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private Notification f4346t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private NotificationCompat.Builder f4347u;

    @Download.onNoSupportBreakPoint
    public void a(DownloadTask downloadTask) {
    }

    @Download.onTaskFail
    public void a(DownloadTask downloadTask, Exception exc) {
        DownloadEntity entity;
        if (downloadTask == null || (entity = downloadTask.getEntity()) == null) {
            return;
        }
        String message = exc != null ? exc.getMessage() : "下载失败";
        String realUrl = entity.getRealUrl();
        if (TextUtils.isEmpty(realUrl)) {
            o.b("下载失败，请重试!");
        } else {
            o.b("下载失败，正在使用系统浏览器下载!");
            b.startActivity(this, realUrl);
        }
        a(downloadTask.getExtendField() + message, (int) entity.getId());
    }

    @Download.onTaskCancel
    public void b(DownloadTask downloadTask) {
        o.b("下载任务已取消!");
    }

    @Download.onTaskComplete
    public void c(DownloadTask downloadTask) {
        if (downloadTask != null) {
            String str = downloadTask.getExtendField() + "，下载完成";
            o.b("下载完成!");
            DownloadEntity entity = downloadTask.getEntity();
            if (entity != null) {
                a(100, downloadTask.getFilePath(), (int) entity.getId(), downloadTask.getExtendField());
            }
        }
    }

    @Download.onTaskRunning
    public void d(DownloadTask downloadTask) {
        DownloadEntity entity;
        if (downloadTask == null || (entity = downloadTask.getEntity()) == null) {
            return;
        }
        a((int) ((entity.getCurrentProgress() * 100) / entity.getFileSize()), downloadTask.getFilePath(), (int) entity.getId(), downloadTask.getExtendField());
    }

    @Download.onTaskStart
    public void e(DownloadTask downloadTask) {
        DownloadEntity entity = downloadTask.getEntity();
        if (entity != null) {
            o.b("开始下载");
            a(entity);
        }
    }

    @Download.onTaskStop
    public void f(DownloadTask downloadTask) {
        o.b("下载任务已停止!");
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Aria.download(this).register();
        EventBus.getDefault().register(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        Aria.download(this).unRegister();
        EventBus.getDefault().unregister(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        NewApiAd newApiAd;
        if (intent != null && (newApiAd = (NewApiAd) intent.getSerializableExtra("new_api_ad")) != null) {
            String down_url = newApiAd.getDown_url();
            if (!TextUtils.isEmpty(down_url)) {
                String str = z.g() + down_url.substring(down_url.lastIndexOf("/"));
                String str2 = "storageApkPath:" + str;
                File file = new File(str);
                if (file.exists()) {
                    g.a(this, file);
                } else {
                    DownloadReceiver downloadReceiverDownload = Aria.download(this);
                    DownloadEntity firstDownloadEntity = downloadReceiverDownload.getFirstDownloadEntity(down_url);
                    if (firstDownloadEntity == null || firstDownloadEntity.getState() != 4) {
                        ((HttpBuilderTarget) downloadReceiverDownload.load(down_url).ignoreFilePathOccupy().ignoreCheckPermissions().setExtendField(newApiAd.getDown_package_name())).setFilePath(str).create();
                    } else {
                        o.b("该任务正在下载中...请等待");
                    }
                }
            }
        }
        return super.onStartCommand(intent, i2, i3);
    }

    private void a(int i2, String str, int i3, String str2) {
        if (this.f4347u == null || i2 <= 0) {
            return;
        }
        String str3 = "当前进度:" + i2 + "%";
        if (i2 >= 100) {
            str3 = "下载完成，点击安装";
        }
        this.f4347u.setContentTitle("正在下载「" + str2 + "」");
        this.f4347u.setContentText(str3);
        this.f4346t = this.f4347u.build();
        if (i2 >= 100) {
            File file = new File(str);
            g.a(this, file);
            Intent intent = new Intent("android.intent.action.VIEW");
            if (Build.VERSION.SDK_INT >= 24) {
                intent.setDataAndType(FileProvider.getUriForFile(this, h.t() + ".MkTsFileProvider", file), AdBaseConstants.MIME_APK);
                intent.addFlags(1);
            } else {
                intent.setDataAndType(Uri.parse("file://" + file.toString()), AdBaseConstants.MIME_APK);
            }
            intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
            this.f4346t.contentIntent = PendingIntent.getActivity(this, 0, intent, 0);
        }
        this.f4345s.notify(i3, this.f4346t);
    }

    private void a(DownloadEntity downloadEntity) {
        this.f4345s = (NotificationManager) getSystemService(UMessage.DISPLAY_TYPE_NOTIFICATION);
        String str = downloadEntity.getId() + "";
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel(str, "下载通知", 2);
            notificationChannel.setDescription("下载安装包文件");
            this.f4345s.createNotificationChannel(notificationChannel);
        }
        this.f4347u = new NotificationCompat.Builder(this, str);
        this.f4347u.setContentTitle("正在下载").setSmallIcon(R.mipmap.app_logo).setDefaults(4).setPriority(2).setAutoCancel(true).setOngoing(true).setContentText("准备开始下载...").setChannelId(str);
        this.f4346t = this.f4347u.build();
    }

    private void a(String str, int i2) {
        NotificationCompat.Builder builder = this.f4347u;
        if (builder != null) {
            builder.setContentTitle("下载失败");
            this.f4347u.setContentText(str);
            this.f4346t = this.f4347u.build();
            Intent intent = new Intent(this, (Class<?>) MkNotiClickReceiver.class);
            intent.setAction("notification_clicked");
            intent.putExtra("type", 1);
            this.f4346t.contentIntent = PendingIntent.getBroadcast(this, 0, intent, 1073741824);
            this.f4345s.notify(i2, this.f4346t);
        }
    }
}
