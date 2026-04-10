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
import org.android.agoo.common.AgooConstants;

/* JADX INFO: compiled from: UMNetWorkSender.java */
/* JADX INFO: loaded from: classes3.dex */
public class a implements UMImprintChangeCallback {
    private static HandlerThread a = null;
    private static Handler b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Handler f19949c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f19950d = 200;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f19951e = 273;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f19952f = 274;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f19953g = 512;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f19954h = 769;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static FileObserverC0551a f19955i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static ConnectivityManager f19956j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static IntentFilter f19957k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static volatile boolean f19958l = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static ArrayList<UMSenderStateNotify> f19959m = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final String f19962p = "report_policy";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final String f19963q = "report_interval";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final int f19965s = 15;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final int f19966t = 3;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final int f19967u = 90;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static BroadcastReceiver f19970x;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static Object f19960n = new Object();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static ReentrantLock f19961o = new ReentrantLock();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static boolean f19964r = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static int f19968v = 15;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static Object f19969w = new Object();

    /* JADX INFO: renamed from: com.umeng.commonsdk.framework.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: UMNetWorkSender.java */
    static class FileObserverC0551a extends FileObserver {
        public FileObserverC0551a(String str) {
            super(str);
        }

        @Override // android.os.FileObserver
        public void onEvent(int i2, String str) {
            if ((i2 & 8) != 8) {
                return;
            }
            ULog.d("--->>> envelope file created >>> " + str);
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> envelope file created >>> " + str);
            a.c(273);
        }
    }

    static {
        Context appContext = UMGlobalContext.getAppContext();
        if (appContext != null) {
            f19956j = (ConnectivityManager) appContext.getSystemService("connectivity");
        }
        f19970x = new BroadcastReceiver() { // from class: com.umeng.commonsdk.framework.a.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                    UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.E, b.a(context).a(), null);
                }
            }
        };
    }

    public a(Context context, Handler handler) {
        if (f19956j == null) {
            Context appContext = UMGlobalContext.getAppContext();
            if (f19956j != null) {
                f19956j = (ConnectivityManager) appContext.getSystemService("connectivity");
            }
        }
        f19949c = handler;
        try {
            if (a == null) {
                a = new HandlerThread("NetWorkSender");
                a.start();
                if (f19955i == null) {
                    f19955i = new FileObserverC0551a(UMFrUtils.getEnvelopeDirPath(context));
                    f19955i.startWatching();
                    ULog.d("--->>> FileMonitor has already started!");
                }
                j();
                if (b == null) {
                    b = new Handler(a.getLooper()) { // from class: com.umeng.commonsdk.framework.a.2
                        @Override // android.os.Handler
                        public void handleMessage(Message message) {
                            int i2 = message.what;
                            if (i2 == 273) {
                                ULog.d("--->>> handleMessage: recv MSG_PROCESS_NEXT msg.");
                                try {
                                    a.f19961o.tryLock(1L, TimeUnit.SECONDS);
                                    try {
                                        a.n();
                                    } catch (Throwable unused) {
                                    }
                                    a.f19961o.unlock();
                                    return;
                                } catch (Throwable unused2) {
                                    return;
                                }
                            }
                            if (i2 == a.f19952f) {
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
                ImprintHandler.getImprintService(context).registImprintCallback(f19962p, this);
                ImprintHandler.getImprintService(context).registImprintCallback(f19963q, this);
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
    }

    public static int b() {
        int i2;
        synchronized (f19969w) {
            i2 = f19968v;
        }
        return i2;
    }

    public static void c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(int i2) {
        Handler handler;
        if (!f19958l || (handler = b) == null) {
            return;
        }
        Message messageObtainMessage = handler.obtainMessage();
        messageObtainMessage.what = i2;
        b.sendMessage(messageObtainMessage);
    }

    public static void d() {
        if (f19961o.tryLock()) {
            try {
                b(273);
            } finally {
                f19961o.unlock();
            }
        }
    }

    public static void e() {
        a(f19952f, 3000);
    }

    private void j() {
        synchronized (f19969w) {
            if (AgooConstants.ACK_BODY_NULL.equals(UMEnvelopeBuild.imprintProperty(UMModuleRegister.getAppContext(), f19962p, ""))) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> switch to report_policy 11");
                f19964r = true;
                f19968v = 15;
                int iIntValue = Integer.valueOf(UMEnvelopeBuild.imprintProperty(UMModuleRegister.getAppContext(), f19963q, AgooConstants.ACK_PACK_ERROR)).intValue();
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> set report_interval value to: " + iIntValue);
                if (iIntValue < 3 || iIntValue > 90) {
                    f19968v = 15;
                } else {
                    f19968v = iIntValue * 1000;
                }
            } else {
                f19964r = false;
            }
        }
    }

    private static void k() {
        if (a != null) {
            a = null;
        }
        if (b != null) {
            b = null;
        }
        if (f19949c != null) {
            f19949c = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l() {
        int size;
        synchronized (f19960n) {
            if (f19959m != null && (size = f19959m.size()) > 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    f19959m.get(i2).onSenderIdle();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void m() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void n() {
        ULog.d("--->>> handleProcessNext: Enter...");
        if (f19958l) {
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
                        if (!new c(appContext).a(envelopeFile)) {
                            ULog.d("--->>> Send envelope file failed, abandon and wait next trigger!");
                            return;
                        }
                        ULog.d("--->>> Send envelope file success, delete it.");
                        if (!UMFrUtils.removeEnvelopeFile(envelopeFile)) {
                            ULog.d("--->>> Failed to delete already processed file. We try again after delete failed.");
                            UMFrUtils.removeEnvelopeFile(envelopeFile);
                        }
                        c(273);
                        return;
                    }
                }
                e();
            } catch (Throwable th) {
                UMCrashManager.reportCrash(appContext, th);
            }
        }
    }

    @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
    public void onImprintValueChanged(String str, String str2) {
        synchronized (f19969w) {
            if (f19962p.equals(str)) {
                if (AgooConstants.ACK_BODY_NULL.equals(str2)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> switch to report_policy 11");
                    f19964r = true;
                } else {
                    f19964r = false;
                }
            }
            if (f19963q.equals(str)) {
                int iIntValue = Integer.valueOf(str2).intValue();
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> set report_interval value to: " + iIntValue);
                if (iIntValue < 3 || iIntValue > 90) {
                    f19968v = 15000;
                } else {
                    f19968v = iIntValue * 1000;
                }
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> really set report_interval value to: " + f19968v);
            }
        }
    }

    public static void a(Context context) {
        if (f19956j != null || context == null) {
            return;
        }
        f19956j = (ConnectivityManager) context.getSystemService("connectivity");
        if (f19956j != null) {
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> createCMIfNeeded:注册网络状态监听器。");
            b(context);
        }
    }

    public static void b(Context context) {
        if (DeviceConfig.checkPermission(context, "android.permission.ACCESS_NETWORK_STATE") && f19956j != null && f19957k == null) {
            f19957k = new IntentFilter();
            f19957k.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            if (f19970x != null) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> 注册网络状态监听器。");
                context.registerReceiver(f19970x, f19957k);
            }
        }
    }

    public static void a(UMSenderStateNotify uMSenderStateNotify) {
        synchronized (f19960n) {
            try {
                if (f19959m == null) {
                    f19959m = new ArrayList<>();
                }
                if (uMSenderStateNotify != null) {
                    for (int i2 = 0; i2 < f19959m.size(); i2++) {
                        if (uMSenderStateNotify == f19959m.get(i2)) {
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> addConnStateObserver: input item has exist.");
                            return;
                        }
                    }
                    f19959m.add(uMSenderStateNotify);
                }
            } catch (Throwable th) {
                UMCrashManager.reportCrash(UMModuleRegister.getAppContext(), th);
            }
        }
    }

    private static void b(int i2) {
        Handler handler;
        if (!f19958l || (handler = b) == null || handler.hasMessages(i2)) {
            return;
        }
        Message messageObtainMessage = b.obtainMessage();
        messageObtainMessage.what = i2;
        b.sendMessage(messageObtainMessage);
    }

    public static boolean a() {
        boolean z2;
        synchronized (f19969w) {
            z2 = f19964r;
        }
        return z2;
    }

    public static void a(boolean z2) {
        int size;
        f19958l = z2;
        if (z2) {
            synchronized (f19960n) {
                if (f19959m != null && (size = f19959m.size()) > 0) {
                    for (int i2 = 0; i2 < size; i2++) {
                        f19959m.get(i2).onConnectionAvailable();
                    }
                }
            }
            UMRTLog.e(UMRTLog.RTLOG_TAG, "网络状态通知：尝试发送 MSG_PROCESS_NEXT");
            d();
            return;
        }
        ULog.i("--->>> network disconnected.");
        f19958l = false;
    }

    private static void a(int i2, long j2) {
        Handler handler;
        if (!f19958l || (handler = b) == null) {
            return;
        }
        Message messageObtainMessage = handler.obtainMessage();
        messageObtainMessage.what = i2;
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> sendMsgDelayed: " + j2);
        b.sendMessageDelayed(messageObtainMessage, j2);
    }

    private static void a(int i2, int i3) {
        Handler handler;
        if (!f19958l || (handler = b) == null) {
            return;
        }
        handler.removeMessages(i2);
        Message messageObtainMessage = b.obtainMessage();
        messageObtainMessage.what = i2;
        b.sendMessageDelayed(messageObtainMessage, i3);
    }
}
