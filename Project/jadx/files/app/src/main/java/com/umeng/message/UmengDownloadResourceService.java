package com.umeng.message;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import com.umeng.message.api.UPushMessageHandler;
import com.umeng.message.common.UPLog;
import com.umeng.message.entity.UMessage;
import com.umeng.message.proguard.c;
import com.umeng.message.proguard.l;
import com.umeng.message.proguard.r;
import com.umeng.message.service.UMJobIntentService;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Stack;
import org.android.agoo.common.AgooConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class UmengDownloadResourceService extends UMJobIntentService {
    public static final String TAG = "DownloadResourceService";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f20255j = ".tmp";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f20256k = "retry";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f20257l = "operation";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f20258m = 1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f20259n = 2;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final long f20260o = 1048576;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final long f20261p = 86400000;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final int f20262q = 300000;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final int f20263r = 3;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final ArrayList<String> f20264s = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(File file, long j2) {
        if (file != null && file.exists() && file.canWrite() && file.isDirectory()) {
            Stack stack = new Stack();
            stack.push(file);
            while (!stack.isEmpty()) {
                File file2 = (File) stack.pop();
                File[] fileArrListFiles = file2.listFiles();
                if (fileArrListFiles == null || fileArrListFiles.length <= 0) {
                    file2.delete();
                } else {
                    for (File file3 : fileArrListFiles) {
                        if (file3.isDirectory()) {
                            if (file3.isDirectory()) {
                                stack.push(file3);
                            }
                        } else if (System.currentTimeMillis() - file3.lastModified() > j2) {
                            file3.delete();
                        }
                    }
                }
            }
        }
    }

    private void d() {
        try {
            a(new File(getMessageResourceFolder(r.b(), null)), 1048576L, 86400000L);
        } catch (Throwable unused) {
        }
    }

    public static long dirSize(File file) {
        long length = 0;
        if (file != null && file.exists() && file.isDirectory()) {
            Stack stack = new Stack();
            stack.push(file);
            while (!stack.isEmpty()) {
                File[] fileArrListFiles = ((File) stack.pop()).listFiles();
                if (fileArrListFiles != null) {
                    for (File file2 : fileArrListFiles) {
                        if (!file2.isDirectory()) {
                            length += file2.length();
                        } else if (file2.isDirectory()) {
                            stack.push(file2);
                        }
                    }
                }
            }
        }
        return length;
    }

    public static String getMessageResourceFolder(Context context, UMessage uMessage) {
        String str = context.getCacheDir() + "/umeng_push/";
        if (uMessage == null || uMessage.msg_id == null) {
            return str;
        }
        return str + uMessage.msg_id + "/";
    }

    public void deleteAlarm(UMessage uMessage, int i2) {
        UPLog.i(TAG, "deleteAlarm");
        ((AlarmManager) getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(a(uMessage, i2));
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public void downloadResource(UMessage uMessage, int i2) {
        a aVar = new a(uMessage, i2);
        if (Build.VERSION.SDK_INT >= 11) {
            c.a(aVar, new Void[0]);
        } else {
            aVar.execute(new Void[0]);
        }
    }

    public void notification(UMessage uMessage) {
        Context contextB = r.b();
        UPushMessageHandler messageHandler = PushAgent.getInstance(contextB).getMessageHandler();
        if (messageHandler != null) {
            messageHandler.handleMessage(contextB, uMessage);
        }
    }

    public void setAlarm(UMessage uMessage, int i2) {
        UPLog.i(TAG, "setAlarm");
        ((AlarmManager) getSystemService(NotificationCompat.CATEGORY_ALARM)).set(1, System.currentTimeMillis() + 300000, a(uMessage, i2));
    }

    @Override // com.umeng.message.service.UMJobIntentService, com.umeng.message.service.JobIntentService
    public void a(Intent intent) {
        UPLog.i(TAG, "--->>> onHandleWork");
        if (intent == null) {
            return;
        }
        int intExtra = intent.getIntExtra(f20257l, 2);
        int intExtra2 = intent.getIntExtra(f20256k, 3);
        try {
            UMessage uMessage = new UMessage(new JSONObject(intent.getStringExtra(AgooConstants.MESSAGE_BODY)));
            if (this.f20264s.contains(uMessage.msg_id)) {
                return;
            }
            this.f20264s.add(uMessage.msg_id);
            if (intExtra == 1) {
                deleteAlarm(uMessage, intExtra2);
                UPLog.i(TAG, "after download and show notification");
                notification(uMessage);
                this.f20264s.remove(uMessage.msg_id);
                if (this.f20264s.size() == 0) {
                    stopSelf();
                }
            } else if (intExtra == 2) {
                UPLog.i(TAG, "start download resource");
                int i2 = intExtra2 - 1;
                setAlarm(uMessage, i2);
                d();
                downloadResource(uMessage, i2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @SuppressLint({"StaticFieldLeak"})
    class a extends AsyncTask<Void, Void, Boolean> {
        UMessage a;
        ArrayList<String> b = new ArrayList<>();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f20265c;

        public a(UMessage uMessage, int i2) {
            this.a = uMessage;
            if (uMessage.isLargeIconFromInternet()) {
                this.b.add(uMessage.img);
            }
            if (uMessage.isSoundFromInternet()) {
                this.b.add(uMessage.sound);
            }
            if (!TextUtils.isEmpty(uMessage.bar_image)) {
                this.b.add(uMessage.bar_image);
            }
            if (!TextUtils.isEmpty(uMessage.expand_image)) {
                this.b.add(uMessage.expand_image);
            }
            this.f20265c = i2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(Void... voidArr) throws Throwable {
            boolean z2 = true;
            for (String str : this.b) {
                boolean zA = a(str);
                if (!zA) {
                    UPLog.d(UmengDownloadResourceService.TAG, "download fail:", str);
                }
                z2 &= zA;
            }
            if (z2 || this.f20265c <= 0) {
                MessageSharedPrefs.getInstance(r.b()).setResourceDownloaded(this.a.msg_id);
            }
            return Boolean.valueOf(z2);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            UmengDownloadResourceService.this.f20264s.remove(this.a.msg_id);
            if (!bool.booleanValue() && this.f20265c > 0) {
                UPLog.d(UmengDownloadResourceService.TAG, "download failed:", this.a.msg_id);
                if (UmengDownloadResourceService.this.f20264s.size() == 0) {
                    try {
                        UmengDownloadResourceService.this.stopSelf();
                        return;
                    } catch (Throwable unused) {
                        return;
                    }
                }
                return;
            }
            Context contextB = r.b();
            String string = this.a.getRaw().toString();
            Intent intent = new Intent(contextB, (Class<?>) UmengDownloadResourceService.class);
            intent.putExtra(AgooConstants.MESSAGE_BODY, string);
            intent.putExtra(UmengDownloadResourceService.f20257l, 1);
            intent.putExtra(UmengDownloadResourceService.f20256k, this.f20265c);
            UMJobIntentService.enqueueWork(contextB, (Class<? extends UMJobIntentService>) UmengDownloadResourceService.class, intent);
        }

        public boolean a(String str) throws Throwable {
            FileOutputStream fileOutputStream;
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            InputStream inputStream = null;
            try {
                Context contextB = r.b();
                String str2 = str.hashCode() + "";
                String messageResourceFolder = UmengDownloadResourceService.getMessageResourceFolder(contextB, this.a);
                File file = new File(messageResourceFolder, str2 + ".tmp");
                File file2 = new File(messageResourceFolder, str2);
                if (file2.exists()) {
                    UmengDownloadResourceService.this.a((Closeable) null);
                    UmengDownloadResourceService.this.a((Closeable) null);
                    return true;
                }
                File file3 = new File(messageResourceFolder);
                if (!file3.exists()) {
                    file3.mkdirs();
                }
                if (file.exists()) {
                    file.delete();
                }
                InputStream inputStreamOpenStream = new URL(new URI(str).toASCIIString()).openStream();
                try {
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        byte[] bArr = new byte[10240];
                        while (true) {
                            int i2 = inputStreamOpenStream.read(bArr);
                            if (i2 > 0) {
                                fileOutputStream.write(bArr, 0, i2);
                            } else {
                                file.renameTo(file2);
                                UmengDownloadResourceService.this.a(inputStreamOpenStream);
                                UmengDownloadResourceService.this.a(fileOutputStream);
                                return true;
                            }
                        }
                    } catch (Exception e2) {
                        inputStream = inputStreamOpenStream;
                        e = e2;
                    } catch (Throwable th) {
                        inputStream = inputStreamOpenStream;
                        th = th;
                        UmengDownloadResourceService.this.a(inputStream);
                        UmengDownloadResourceService.this.a(fileOutputStream);
                        throw th;
                    }
                } catch (Exception e3) {
                    inputStream = inputStreamOpenStream;
                    e = e3;
                    fileOutputStream = null;
                } catch (Throwable th2) {
                    fileOutputStream = null;
                    inputStream = inputStreamOpenStream;
                    th = th2;
                }
            } catch (Exception e4) {
                e = e4;
                fileOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
            try {
                UPLog.e(UmengDownloadResourceService.TAG, "download err:", e.getMessage());
                UmengDownloadResourceService.this.a(inputStream);
                UmengDownloadResourceService.this.a(fileOutputStream);
                return false;
            } catch (Throwable th4) {
                th = th4;
                UmengDownloadResourceService.this.a(inputStream);
                UmengDownloadResourceService.this.a(fileOutputStream);
                throw th;
            }
        }
    }

    private PendingIntent a(UMessage uMessage, int i2) {
        Context contextB = r.b();
        String string = uMessage.getRaw().toString();
        int iHashCode = uMessage.msg_id.hashCode();
        Intent intent = new Intent(contextB, (Class<?>) UmengDownloadResourceService.class);
        intent.putExtra(AgooConstants.MESSAGE_BODY, string);
        intent.putExtra(f20257l, 2);
        intent.putExtra(f20256k, i2);
        PendingIntent service = PendingIntent.getService(contextB, iHashCode, intent, Build.VERSION.SDK_INT >= 23 ? 335544320 : DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        UPLog.i(TAG, "PendingIntent: msgId:" + uMessage.msg_id + ",requestCode:" + iHashCode + ",retryTime:" + i2);
        return service;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Closeable closeable) {
        l.a(closeable);
    }

    private static void a(final File file, long j2, final long j3) throws IOException {
        if (!file.exists() || dirSize(file.getCanonicalFile()) <= j2) {
            return;
        }
        c.a(new Runnable() { // from class: com.umeng.message.UmengDownloadResourceService.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    UmengDownloadResourceService.b(file, j3);
                } catch (Throwable unused) {
                }
            }
        });
    }
}
