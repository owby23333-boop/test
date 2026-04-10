package com.umeng.commonsdk.stateless;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.FileObserver;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.common.ULog;
import java.io.File;
import java.util.LinkedList;

/* JADX INFO: compiled from: UMSLNetWorkSender.java */
/* JADX INFO: loaded from: classes3.dex */
public class b {
    public static final int a = 273;
    private static Context b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static HandlerThread f20037c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Handler f20038d = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f20040f = 274;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f20041g = 275;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f20042h = 512;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static a f20043i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static IntentFilter f20044j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static volatile boolean f20045k = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Object f20039e = new Object();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static LinkedList<String> f20046l = new LinkedList<>();

    /* JADX INFO: compiled from: UMSLNetWorkSender.java */
    static class a extends FileObserver {
        public a(String str) {
            super(str);
        }

        @Override // android.os.FileObserver
        public void onEvent(int i2, String str) {
            if ((i2 & 8) != 8) {
                return;
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> envelope file created >>> " + str);
            b.a(b.f20040f);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0082 A[Catch: all -> 0x0084, DONT_GENERATE, TryCatch #0 {, blocks: (B:21:0x0082, B:20:0x007f, B:5:0x0008, B:7:0x0012, B:9:0x0016, B:11:0x0028, B:13:0x004f, B:14:0x0059, B:15:0x006c, B:17:0x0070), top: B:26:0x0006, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public b(android.content.Context r6) {
        /*
            r5 = this;
            r5.<init>()
            java.lang.Object r0 = com.umeng.commonsdk.stateless.b.f20039e
            monitor-enter(r0)
            if (r6 == 0) goto L82
            android.content.Context r1 = r6.getApplicationContext()     // Catch: java.lang.Throwable -> L7e
            com.umeng.commonsdk.stateless.b.b = r1     // Catch: java.lang.Throwable -> L7e
            android.content.Context r1 = com.umeng.commonsdk.stateless.b.b     // Catch: java.lang.Throwable -> L7e
            if (r1 == 0) goto L82
            android.os.HandlerThread r1 = com.umeng.commonsdk.stateless.b.f20037c     // Catch: java.lang.Throwable -> L7e
            if (r1 != 0) goto L82
            android.os.HandlerThread r1 = new android.os.HandlerThread     // Catch: java.lang.Throwable -> L7e
            java.lang.String r2 = "SL-NetWorkSender"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L7e
            com.umeng.commonsdk.stateless.b.f20037c = r1     // Catch: java.lang.Throwable -> L7e
            android.os.HandlerThread r1 = com.umeng.commonsdk.stateless.b.f20037c     // Catch: java.lang.Throwable -> L7e
            r1.start()     // Catch: java.lang.Throwable -> L7e
            com.umeng.commonsdk.stateless.b$a r1 = com.umeng.commonsdk.stateless.b.f20043i     // Catch: java.lang.Throwable -> L7e
            if (r1 != 0) goto L6c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7e
            r1.<init>()     // Catch: java.lang.Throwable -> L7e
            android.content.Context r2 = com.umeng.commonsdk.stateless.b.b     // Catch: java.lang.Throwable -> L7e
            java.io.File r2 = r2.getFilesDir()     // Catch: java.lang.Throwable -> L7e
            r1.append(r2)     // Catch: java.lang.Throwable -> L7e
            java.lang.String r2 = java.io.File.separator     // Catch: java.lang.Throwable -> L7e
            r1.append(r2)     // Catch: java.lang.Throwable -> L7e
            java.lang.String r2 = ".emitter"
            r1.append(r2)     // Catch: java.lang.Throwable -> L7e
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L7e
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L7e
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L7e
            boolean r3 = r2.exists()     // Catch: java.lang.Throwable -> L7e
            if (r3 != 0) goto L59
            java.lang.String r3 = "MobclickRT"
            java.lang.String r4 = "--->>> 2号数据仓目录不存在，创建之。"
            com.umeng.commonsdk.debug.UMRTLog.e(r3, r4)     // Catch: java.lang.Throwable -> L7e
            r2.mkdir()     // Catch: java.lang.Throwable -> L7e
        L59:
            com.umeng.commonsdk.stateless.b$a r2 = new com.umeng.commonsdk.stateless.b$a     // Catch: java.lang.Throwable -> L7e
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L7e
            com.umeng.commonsdk.stateless.b.f20043i = r2     // Catch: java.lang.Throwable -> L7e
            com.umeng.commonsdk.stateless.b$a r1 = com.umeng.commonsdk.stateless.b.f20043i     // Catch: java.lang.Throwable -> L7e
            r1.startWatching()     // Catch: java.lang.Throwable -> L7e
            java.lang.String r1 = "MobclickRT"
            java.lang.String r2 = "--->>> 2号数据仓File Monitor启动."
            com.umeng.commonsdk.debug.UMRTLog.e(r1, r2)     // Catch: java.lang.Throwable -> L7e
        L6c:
            android.os.Handler r1 = com.umeng.commonsdk.stateless.b.f20038d     // Catch: java.lang.Throwable -> L7e
            if (r1 != 0) goto L82
            com.umeng.commonsdk.stateless.b$1 r1 = new com.umeng.commonsdk.stateless.b$1     // Catch: java.lang.Throwable -> L7e
            android.os.HandlerThread r2 = com.umeng.commonsdk.stateless.b.f20037c     // Catch: java.lang.Throwable -> L7e
            android.os.Looper r2 = r2.getLooper()     // Catch: java.lang.Throwable -> L7e
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L7e
            com.umeng.commonsdk.stateless.b.f20038d = r1     // Catch: java.lang.Throwable -> L7e
            goto L82
        L7e:
            r1 = move-exception
            com.umeng.commonsdk.internal.crash.UMCrashManager.reportCrash(r6, r1)     // Catch: java.lang.Throwable -> L84
        L82:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L84
            return
        L84:
            r6 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L84
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.stateless.b.<init>(android.content.Context):void");
    }

    public static void a(boolean z2) {
        f20045k = z2;
        if (!z2) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>网络断连： 2号数据仓");
        } else {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>网络可用： 触发2号数据仓信封消费动作。");
            b(f20040f);
        }
    }

    public static void b(int i2) {
        try {
            if (!f20045k || f20038d == null || f20038d.hasMessages(i2)) {
                return;
            }
            Message messageObtainMessage = f20038d.obtainMessage();
            messageObtainMessage.what = i2;
            f20038d.sendMessage(messageObtainMessage);
        } catch (Throwable th) {
            UMCrashManager.reportCrash(b, th);
        }
    }

    public static void c() {
        b(f20041g);
    }

    public static void d() {
        b(512);
    }

    private static void i() {
        File[] fileArrC = d.c(b);
        if (fileArrC != null) {
            if (f20046l.size() > 0) {
                f20046l.clear();
            }
            for (File file : fileArrC) {
                f20046l.add(file.getAbsolutePath());
            }
        }
    }

    private static String j() {
        try {
            String strPeek = f20046l.peek();
            if (strPeek == null) {
                return strPeek;
            }
            try {
                f20046l.removeFirst();
                return strPeek;
            } catch (Throwable unused) {
                return strPeek;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    private static void k() {
        String strPollFirst;
        if (f20046l.size() <= 0) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> todoList无内容，无需处理。");
            return;
        }
        do {
            strPollFirst = Build.VERSION.SDK_INT >= 9 ? f20046l.pollFirst() : j();
            if (!TextUtils.isEmpty(strPollFirst)) {
                File file = new File(strPollFirst);
                if (file.exists()) {
                    c cVar = new c(b);
                    byte[] bArrA = null;
                    try {
                        bArrA = d.a(strPollFirst);
                    } catch (Exception unused) {
                    }
                    String name = file.getName();
                    String strSubstring = !TextUtils.isEmpty(name) ? name.substring(0, 1) : "u";
                    String strC = d.c(d.d(name));
                    if (cVar.a(bArrA, strC, com.umeng.commonsdk.vchannel.a.f20239c.equalsIgnoreCase(strC) ? com.umeng.commonsdk.vchannel.a.a : "", strSubstring) && !file.delete()) {
                        file.delete();
                    }
                } else {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 信封文件不存在，处理下一个文件。");
                }
            }
        } while (strPollFirst != null);
        f20046l.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void l() {
        File fileA;
        if (!f20045k || b == null) {
            return;
        }
        do {
            try {
                fileA = d.a(b);
            } catch (Throwable th) {
                UMCrashManager.reportCrash(b, th);
            }
            if (fileA != null && fileA.getParentFile() != null && !TextUtils.isEmpty(fileA.getParentFile().getName())) {
                c cVar = new c(b);
                String str = new String(Base64.decode(fileA.getParentFile().getName(), 0));
                if (!com.umeng.commonsdk.internal.a.a.equalsIgnoreCase(str) && !com.umeng.commonsdk.internal.a.b.equalsIgnoreCase(str) && !com.umeng.commonsdk.internal.a.G.equalsIgnoreCase(str)) {
                    ULog.i("walle", "[stateless] handleProcessNext, pathUrl is " + str);
                    byte[] bArrA = null;
                    try {
                        bArrA = d.a(fileA.getAbsolutePath());
                    } catch (Exception unused) {
                    }
                    String str2 = com.umeng.commonsdk.vchannel.a.f20239c.equalsIgnoreCase(str) ? com.umeng.commonsdk.vchannel.a.a : "";
                    String str3 = UMServerURL.PATH_SHARE.equalsIgnoreCase(str) ? "s" : "u";
                    if (UMServerURL.PATH_PUSH_LAUNCH.equalsIgnoreCase(str) || UMServerURL.PATH_PUSH_REGIST.equalsIgnoreCase(str) || UMServerURL.PATH_PUSH_LOG.equalsIgnoreCase(str)) {
                        str3 = "p";
                    }
                    if (!cVar.a(bArrA, str, str2, str3)) {
                        ULog.i("walle", "[stateless] Send envelope file failed, abandon and wait next trigger!");
                        return;
                    }
                    ULog.i("walle", "[stateless] Send envelope file success, delete it.");
                    File file = new File(fileA.getAbsolutePath());
                    if (!file.delete()) {
                        ULog.i("walle", "[stateless] Failed to delete already processed file. We try again after delete failed.");
                        file.delete();
                    }
                    m();
                }
                new File(fileA.getAbsolutePath()).delete();
            }
        } while (fileA != null);
        m();
    }

    private static void m() {
        try {
            File file = new File(b.getFilesDir() + File.separator + com.umeng.commonsdk.stateless.a.f20030e);
            if (file.exists() && file.isDirectory()) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 2号数据仓：删除stateless目录。");
                d.a(file);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void n() {
        if (!f20045k || b == null) {
            return;
        }
        i();
        k();
        c();
    }

    private static void o() {
        try {
            File file = new File(b.getFilesDir() + File.separator + com.umeng.commonsdk.stateless.a.f20030e);
            if (file.exists() && file.isDirectory()) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>2号数据仓：检测到stateless目录。");
                b(a);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void p() {
        o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q() {
    }

    public static boolean a() {
        synchronized (f20039e) {
            return f20043i != null;
        }
    }

    public static void b() {
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>信封构建成功： 触发2号数据仓信封消费动作。");
        b(f20040f);
    }

    public static void a(int i2) {
        Handler handler;
        if (!f20045k || (handler = f20038d) == null) {
            return;
        }
        Message messageObtainMessage = handler.obtainMessage();
        messageObtainMessage.what = i2;
        f20038d.sendMessage(messageObtainMessage);
    }
}
