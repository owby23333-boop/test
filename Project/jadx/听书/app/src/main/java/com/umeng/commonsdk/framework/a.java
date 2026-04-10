package com.umeng.commonsdk.framework;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.FileObserver;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.kuaishou.weapon.p0.g;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.internal.b;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.c;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback;
import java.io.File;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: UMNetWorkSender.java */
/* JADX INFO: loaded from: classes4.dex */
public class a implements UMImprintChangeCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static HandlerThread f2297a = null;
    private static Handler b = null;
    private static Handler c = null;
    private static final int d = 200;
    private static final int e = 273;
    private static final int f = 274;
    private static final int g = 512;
    private static final int h = 769;
    private static FileObserverC0494a i = null;
    private static ConnectivityManager j = null;
    private static IntentFilter k = null;
    private static volatile boolean l = false;
    private static ArrayList<UMSenderStateNotify> m = null;
    private static final String p = "report_policy";
    private static final String q = "report_interval";
    private static final int s = 15;
    private static final int t = 3;
    private static final int u = 90;
    private static BroadcastReceiver x;
    private static Object n = new Object();
    private static ReentrantLock o = new ReentrantLock();
    private static boolean r = false;
    private static int v = 15;
    private static Object w = new Object();

    public static void c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void m() {
    }

    static {
        Context appContext = UMGlobalContext.getAppContext();
        if (appContext != null) {
            j = (ConnectivityManager) appContext.getSystemService("connectivity");
        }
        x = new BroadcastReceiver() { // from class: com.umeng.commonsdk.framework.a.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                    UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.E, b.a(context).a(), null);
                }
            }
        };
    }

    public static void a(Context context) {
        if (j != null || context == null) {
            return;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        j = connectivityManager;
        if (connectivityManager != null) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> createCMIfNeeded:注册网络状态监听器。");
            b(context);
        }
    }

    public static void a(UMSenderStateNotify uMSenderStateNotify) {
        synchronized (n) {
            try {
                if (m == null) {
                    m = new ArrayList<>();
                }
                if (uMSenderStateNotify != null) {
                    for (int i2 = 0; i2 < m.size(); i2++) {
                        if (uMSenderStateNotify == m.get(i2)) {
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> addConnStateObserver: input item has exist.");
                            return;
                        }
                    }
                    m.add(uMSenderStateNotify);
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(UMModuleRegister.getAppContext(), th);
            }
        }
    }

    public static boolean a() {
        boolean z;
        synchronized (w) {
            z = r;
        }
        return z;
    }

    public static int b() {
        int i2;
        synchronized (w) {
            i2 = v;
        }
        return i2;
    }

    private void j() {
        synchronized (w) {
            if ("11".equals(UMEnvelopeBuild.imprintProperty(UMModuleRegister.getAppContext(), p, ""))) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> switch to report_policy 11");
                r = true;
                v = 15;
                int iIntValue = Integer.valueOf(UMEnvelopeBuild.imprintProperty(UMModuleRegister.getAppContext(), q, "15")).intValue();
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> set report_interval value to: " + iIntValue);
                if (iIntValue < 3 || iIntValue > 90) {
                    v = 15;
                } else {
                    v = iIntValue * 1000;
                }
            } else {
                r = false;
            }
        }
    }

    @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
    public void onImprintValueChanged(String str, String str2) {
        synchronized (w) {
            if (p.equals(str)) {
                if ("11".equals(str2)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> switch to report_policy 11");
                    r = true;
                } else {
                    r = false;
                }
            }
            if (q.equals(str)) {
                int iIntValue = Integer.valueOf(str2).intValue();
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> set report_interval value to: " + iIntValue);
                if (iIntValue < 3 || iIntValue > 90) {
                    v = 15000;
                } else {
                    v = iIntValue * 1000;
                }
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> really set report_interval value to: " + v);
            }
        }
    }

    public static void b(Context context) {
        if (DeviceConfig.checkPermission(context, g.b) && j != null && k == null) {
            IntentFilter intentFilter = new IntentFilter();
            k = intentFilter;
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            if (x != null) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> 注册网络状态监听器。");
                context.registerReceiver(x, k);
            }
        }
    }

    public static void a(boolean z) {
        int size;
        l = z;
        if (z) {
            synchronized (n) {
                ArrayList<UMSenderStateNotify> arrayList = m;
                if (arrayList != null && (size = arrayList.size()) > 0) {
                    for (int i2 = 0; i2 < size; i2++) {
                        m.get(i2).onConnectionAvailable();
                    }
                }
            }
            UMRTLog.e(UMRTLog.RTLOG_TAG, "网络状态通知：尝试发送 MSG_PROCESS_NEXT");
            d();
            return;
        }
        ULog.i("--->>> network disconnected.");
        l = false;
    }

    public a(Context context, Handler handler) {
        if (j == null) {
            Context appContext = UMGlobalContext.getAppContext();
            if (j != null) {
                j = (ConnectivityManager) appContext.getSystemService("connectivity");
            }
        }
        c = handler;
        try {
            if (f2297a == null) {
                HandlerThread handlerThread = new HandlerThread("NetWorkSender");
                f2297a = handlerThread;
                handlerThread.start();
                if (i == null) {
                    FileObserverC0494a fileObserverC0494a = new FileObserverC0494a(UMFrUtils.getEnvelopeDirPath(context));
                    i = fileObserverC0494a;
                    fileObserverC0494a.startWatching();
                    ULog.d("--->>> FileMonitor has already started!");
                }
                j();
                if (b == null) {
                    b = new Handler(f2297a.getLooper()) { // from class: com.umeng.commonsdk.framework.a.2
                        @Override // android.os.Handler
                        public void handleMessage(Message message) {
                            int i2 = message.what;
                            if (i2 == 273) {
                                ULog.d("--->>> handleMessage: recv MSG_PROCESS_NEXT msg.");
                                try {
                                    a.o.tryLock(1L, TimeUnit.SECONDS);
                                    try {
                                        a.n();
                                    } catch (Throwable unused) {
                                    }
                                    a.o.unlock();
                                    return;
                                } catch (Throwable unused2) {
                                    return;
                                }
                            }
                            if (i2 == 274) {
                                a.l();
                            } else {
                                if (i2 != 512) {
                                    return;
                                }
                                a.m();
                            }
                        }
                    };
                }
                ImprintHandler.getImprintService(context).registImprintCallback(p, this);
                ImprintHandler.getImprintService(context).registImprintCallback(q, this);
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
    }

    private static void k() {
        if (f2297a != null) {
            f2297a = null;
        }
        if (b != null) {
            b = null;
        }
        if (c != null) {
            c = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l() {
        int size;
        synchronized (n) {
            ArrayList<UMSenderStateNotify> arrayList = m;
            if (arrayList != null && (size = arrayList.size()) > 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    m.get(i2).onSenderIdle();
                }
            }
        }
    }

    private static void b(int i2) {
        Handler handler;
        if (!l || (handler = b) == null || handler.hasMessages(i2)) {
            return;
        }
        Message messageObtainMessage = b.obtainMessage();
        messageObtainMessage.what = i2;
        b.sendMessage(messageObtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(int i2) {
        Handler handler;
        if (!l || (handler = b) == null) {
            return;
        }
        Message messageObtainMessage = handler.obtainMessage();
        messageObtainMessage.what = i2;
        b.sendMessage(messageObtainMessage);
    }

    private static void a(int i2, long j2) {
        Handler handler;
        if (!l || (handler = b) == null) {
            return;
        }
        Message messageObtainMessage = handler.obtainMessage();
        messageObtainMessage.what = i2;
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> sendMsgDelayed: " + j2);
        b.sendMessageDelayed(messageObtainMessage, j2);
    }

    public static void d() {
        if (o.tryLock()) {
            try {
                b(273);
            } finally {
                o.unlock();
            }
        }
    }

    private static void a(int i2, int i3) {
        Handler handler;
        if (!l || (handler = b) == null) {
            return;
        }
        handler.removeMessages(i2);
        Message messageObtainMessage = b.obtainMessage();
        messageObtainMessage.what = i2;
        b.sendMessageDelayed(messageObtainMessage, i3);
    }

    public static void e() {
        a(274, 3000);
    }

    /* JADX INFO: renamed from: com.umeng.commonsdk.framework.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: UMNetWorkSender.java */
    static class FileObserverC0494a extends FileObserver {
        public FileObserverC0494a(String str) {
            super(str);
        }

        @Override // android.os.FileObserver
        public void onEvent(int i, String str) {
            if ((i & 8) != 8) {
                return;
            }
            ULog.d("--->>> envelope file created >>> " + str);
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> envelope file created >>> " + str);
            a.c(273);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void n() {
        ULog.d("--->>> handleProcessNext: Enter...");
        if (l) {
            Context appContext = UMModuleRegister.getAppContext();
            try {
                if (UMFrUtils.envelopeFileNumber(appContext) > 0) {
                    ULog.d("--->>> The envelope file exists.");
                    if (UMFrUtils.envelopeFileNumber(appContext) > 200) {
                        ULog.d("--->>> Number of envelope files is greater than 200, remove old files first.");
                        UMFrUtils.removeRedundantEnvelopeFiles(appContext, 200);
                    }
                    File envelopeFile = UMFrUtils.getEnvelopeFile(appContext);
                    if (envelopeFile != null) {
                        String path = envelopeFile.getPath();
                        ULog.d("--->>> Ready to send envelope file [" + path + "].");
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> send envelope file [ " + path + "].");
                        if (new c(appContext).a(envelopeFile)) {
                            ULog.d("--->>> Send envelope file success, delete it.");
                            if (!UMFrUtils.removeEnvelopeFile(envelopeFile)) {
                                ULog.d("--->>> Failed to delete already processed file. We try again after delete failed.");
                                UMFrUtils.removeEnvelopeFile(envelopeFile);
                            }
                            c(273);
                            return;
                        }
                        ULog.d("--->>> Send envelope file failed, abandon and wait next trigger!");
                        return;
                    }
                }
                e();
            } catch (Throwable th) {
                UMCrashManager.reportCrash(appContext, th);
            }
        }
    }
}
