package cn.bmob.v3.util;

import android.R;
import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;
import cn.bmob.v3.update.res.UpdateConfig;
import com.anythink.china.common.a.a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes.dex */
public class DownloadApk {
    String appName;
    String downUrl;

    @SuppressLint({"HandlerLeak"})
    Handler handler = new Handler() { // from class: cn.bmob.v3.util.DownloadApk.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (Thread.currentThread().isInterrupted()) {
                return;
            }
            int i2 = message.what;
            if (i2 == -1) {
                Toast.makeText(DownloadApk.this.mContext, message.getData().getString("error"), 0).show();
                BmobNotificationManager.getInstance(DownloadApk.this.mContext).cancelNotification();
                return;
            }
            if (i2 == 1) {
                DownloadApk downloadApk = DownloadApk.this;
                downloadApk.displayNotificationMessage(downloadApk.mContext, message.arg1);
                return;
            }
            if (i2 != 2) {
                return;
            }
            if (!UpdateConfig.isSilentDownload()) {
                BmobNotificationManager.getInstance(DownloadApk.this.mContext).cancelNotification();
                InstallUtil.startInstall(DownloadApk.this.mContext, new File(InstallUtil.getAppDir(), EncryptMD5.setMD5(DownloadApk.this.downUrl) + a.f6395g));
                return;
            }
            Intent intentStartInstall = InstallUtil.startInstall(DownloadApk.this.mContext, new File(InstallUtil.getAppDir(), EncryptMD5.setMD5(DownloadApk.this.downUrl) + a.f6395g));
            DownloadApk downloadApk2 = DownloadApk.this;
            downloadApk2.pendingIntent = PendingIntent.getActivity(downloadApk2.mContext, 0, intentStartInstall, 0);
            String string = DownloadApk.this.mContext.getString(BmobResource.getInstance(DownloadApk.this.mContext).getString("bmob_common_silent_download_finish"));
            DownloadApk downloadApk3 = DownloadApk.this;
            BmobNotificationManager.showNotification(DownloadApk.this.mContext, R.drawable.stat_sys_download_done, downloadApk3.appName, downloadApk3.mContext.getString(BmobResource.getInstance(DownloadApk.this.mContext).getString("bmob_common_silent_download_finish")), string, DownloadApk.this.pendingIntent);
        }
    };
    private Context mContext;
    PendingIntent pendingIntent;

    public DownloadApk(Context context, String str) {
        this.mContext = context.getApplicationContext();
        this.downUrl = str;
        this.appName = this.mContext.getApplicationInfo().loadLabel(this.mContext.getPackageManager()).toString();
    }

    private void beginning(final String str, String str2) {
        new Thread() { // from class: cn.bmob.v3.util.DownloadApk.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                DownloadApk.this.loadFileOkHttp(str);
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void displayNotificationMessage(Context context, int i2) {
        StringBuilder sb = new StringBuilder();
        Context context2 = this.mContext;
        sb.append(context2.getString(BmobResource.getInstance(context2).getString("bmob_common_download_notification_prefix")));
        sb.append(this.appName);
        String string = sb.toString();
        String str = i2 + "%";
        Context context3 = this.mContext;
        BmobNotificationManager.showNotification(context, R.drawable.stat_sys_download, string, str, context3.getString(BmobResource.getInstance(context3).getString("bmob_common_start_download_notification")), this.pendingIntent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendMsg(int i2, int i3) {
        Message message = new Message();
        message.what = i2;
        message.arg1 = i3;
        this.handler.sendMessage(message);
    }

    public void loadFileOkHttp(String str) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request.Builder builder = new Request.Builder();
        builder.url(str);
        builder.get();
        okHttpClient.newCall(builder.build()).enqueue(new Callback() { // from class: cn.bmob.v3.util.DownloadApk.3
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                Message message = new Message();
                message.what = -1;
                message.arg1 = 0;
                Bundle bundle = new Bundle();
                bundle.putString("error", "下载出错，请检查您的网络" + iOException.getMessage());
                message.setData(bundle);
                DownloadApk.this.handler.sendMessage(message);
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                FileOutputStream fileOutputStream;
                long jContentLength = response.body().getContentLength();
                InputStream inputStreamByteStream = response.body().byteStream();
                if (inputStreamByteStream != null) {
                    fileOutputStream = new FileOutputStream(new File(InstallUtil.getAppDir(), EncryptMD5.setMD5(DownloadApk.this.downUrl) + a.f6395g));
                    byte[] bArr = new byte[1024];
                    float f2 = 0.0f;
                    int i2 = 0;
                    while (true) {
                        int i3 = inputStreamByteStream.read(bArr);
                        if (i3 == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, i3);
                        f2 += i3;
                        if (i2 == 0 || ((int) ((f2 * 100.0f) / jContentLength)) - 10 > i2) {
                            i2 += 10;
                            if (!UpdateConfig.isSilentDownload()) {
                                DownloadApk.this.sendMsg(1, (int) ((100.0f * f2) / jContentLength));
                            }
                        }
                    }
                } else {
                    fileOutputStream = null;
                }
                DownloadApk.this.sendMsg(2, 0);
                if (fileOutputStream != null) {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                }
            }
        });
    }

    public void startDownload() {
        if (!UpdateConfig.isSilentDownload() && !TextUtils.isEmpty(this.downUrl)) {
            Intent intent = new Intent();
            intent.addFlags(536870912);
            this.pendingIntent = PendingIntent.getActivity(this.mContext, 0, intent, 0);
            Context context = this.mContext;
            String string = context.getString(BmobResource.getInstance(context).getString("bmob_common_start_download_notification"));
            StringBuilder sb = new StringBuilder();
            Context context2 = this.mContext;
            sb.append(context2.getString(BmobResource.getInstance(context2).getString("bmob_common_download_notification_prefix")));
            sb.append(this.appName);
            BmobNotificationManager.showNotification(this.mContext, R.drawable.stat_sys_download, sb.toString(), "0%", string, this.pendingIntent);
        } else if (TextUtils.isEmpty(this.downUrl)) {
            Context context3 = this.mContext;
            Toast.makeText(context3, BmobResource.getInstance(context3).getString("bmob_common_download_failed"), 0).show();
            return;
        }
        beginning(this.downUrl, this.mContext.getApplicationInfo().loadLabel(this.mContext.getPackageManager()).toString());
    }
}
