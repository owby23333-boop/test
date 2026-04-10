package com.tencent.smtt.utils;

import android.os.Handler;
import android.os.HandlerThread;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class m implements Runnable {
    public static String a = "TBSFileLock";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Object f19273f = new Object();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Object f19274g = new Object();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static HashMap<m, Object> f19275h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static Handler f19276i;
    File b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    RandomAccessFile f19277c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    FileLock f19278d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    long f19279e = 0;

    public m(File file, String str) {
        this.b = null;
        this.b = new File(file, "." + str + ".lock");
    }

    Handler a() {
        if (f19276i == null) {
            synchronized (m.class) {
                if (f19276i == null) {
                    HandlerThread handlerThread = new HandlerThread("QBFileLock.Thread");
                    handlerThread.start();
                    f19276i = new Handler(handlerThread.getLooper());
                }
            }
        }
        return f19276i;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0038 A[Catch: all -> 0x0050, TryCatch #0 {, blocks: (B:3:0x0001, B:6:0x001c, B:10:0x0026, B:11:0x0028, B:13:0x002c, B:17:0x0036, B:18:0x0038, B:20:0x003c, B:22:0x0044, B:24:0x004b, B:16:0x0033, B:9:0x0023), top: B:30:0x0001, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004b A[Catch: all -> 0x0050, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:6:0x001c, B:10:0x0026, B:11:0x0028, B:13:0x002c, B:17:0x0036, B:18:0x0038, B:20:0x003c, B:22:0x0044, B:24:0x004b, B:16:0x0033, B:9:0x0023), top: B:30:0x0001, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x002c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void a(boolean r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L50
            r0.<init>()     // Catch: java.lang.Throwable -> L50
            java.lang.String r1 = ">>> release lock: "
            r0.append(r1)     // Catch: java.lang.Throwable -> L50
            java.io.File r1 = r5.b     // Catch: java.lang.Throwable -> L50
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> L50
            r0.append(r1)     // Catch: java.lang.Throwable -> L50
            r0.toString()     // Catch: java.lang.Throwable -> L50
            java.nio.channels.FileLock r0 = r5.f19278d     // Catch: java.lang.Throwable -> L50
            r1 = 0
            if (r0 == 0) goto L28
            java.nio.channels.FileLock r0 = r5.f19278d     // Catch: java.lang.Exception -> L22 java.lang.Throwable -> L50
            r0.release()     // Catch: java.lang.Exception -> L22 java.lang.Throwable -> L50
            goto L26
        L22:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L50
        L26:
            r5.f19278d = r1     // Catch: java.lang.Throwable -> L50
        L28:
            java.io.RandomAccessFile r0 = r5.f19277c     // Catch: java.lang.Throwable -> L50
            if (r0 == 0) goto L38
            java.io.RandomAccessFile r0 = r5.f19277c     // Catch: java.lang.Exception -> L32 java.lang.Throwable -> L50
            r0.close()     // Catch: java.lang.Exception -> L32 java.lang.Throwable -> L50
            goto L36
        L32:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L50
        L36:
            r5.f19277c = r1     // Catch: java.lang.Throwable -> L50
        L38:
            android.os.Handler r0 = com.tencent.smtt.utils.m.f19276i     // Catch: java.lang.Throwable -> L50
            if (r0 == 0) goto L49
            long r0 = r5.f19279e     // Catch: java.lang.Throwable -> L50
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto L49
            android.os.Handler r0 = com.tencent.smtt.utils.m.f19276i     // Catch: java.lang.Throwable -> L50
            r0.removeCallbacks(r5)     // Catch: java.lang.Throwable -> L50
        L49:
            if (r6 == 0) goto L4e
            r5.d()     // Catch: java.lang.Throwable -> L50
        L4e:
            monitor-exit(r5)
            return
        L50:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.utils.m.a(boolean):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0083 A[Catch: all -> 0x000d, TRY_LEAVE, TryCatch #2 {, blocks: (B:3:0x0001, B:9:0x0014, B:11:0x0018, B:13:0x0020, B:15:0x0028, B:16:0x0031, B:17:0x0036, B:23:0x0043, B:27:0x004b, B:26:0x0048, B:29:0x005a, B:21:0x003e, B:30:0x007f, B:32:0x0083, B:8:0x0011), top: B:39:0x0001, inners: #0, #1, #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void b() {
        /*
            r9 = this;
            monitor-enter(r9)
            java.io.RandomAccessFile r0 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> Ld java.lang.Exception -> L10
            java.io.File r1 = r9.b     // Catch: java.lang.Throwable -> Ld java.lang.Exception -> L10
            java.lang.String r2 = "rw"
            r0.<init>(r1, r2)     // Catch: java.lang.Throwable -> Ld java.lang.Exception -> L10
            r9.f19277c = r0     // Catch: java.lang.Throwable -> Ld java.lang.Exception -> L10
            goto L14
        Ld:
            r0 = move-exception
            goto L88
        L10:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.lang.Throwable -> Ld
        L14:
            java.io.RandomAccessFile r0 = r9.f19277c     // Catch: java.lang.Throwable -> Ld
            if (r0 == 0) goto L7f
            java.io.RandomAccessFile r0 = r9.f19277c     // Catch: java.lang.Throwable -> Ld
            java.nio.channels.FileChannel r0 = r0.getChannel()     // Catch: java.lang.Throwable -> Ld
            if (r0 == 0) goto L7f
            long r1 = r9.f19279e     // Catch: java.lang.Throwable -> Ld
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L31
            android.os.Handler r1 = r9.a()     // Catch: java.lang.Throwable -> Ld
            long r2 = r9.f19279e     // Catch: java.lang.Throwable -> Ld
            r1.postDelayed(r9, r2)     // Catch: java.lang.Throwable -> Ld
        L31:
            r1 = 0
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> Ld
        L36:
            java.nio.channels.FileLock r1 = r0.lock()     // Catch: java.lang.Throwable -> Ld java.lang.Exception -> L3d
            if (r1 == 0) goto L41
            goto L5a
        L3d:
            r4 = move-exception
            r4.printStackTrace()     // Catch: java.lang.Throwable -> Ld
        L41:
            r4 = 50
            java.lang.Thread.sleep(r4)     // Catch: java.lang.Throwable -> Ld java.lang.InterruptedException -> L47
            goto L4b
        L47:
            r4 = move-exception
            r4.printStackTrace()     // Catch: java.lang.Throwable -> Ld
        L4b:
            long r4 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> Ld
            long r4 = r4 - r2
            long r4 = java.lang.Math.abs(r4)     // Catch: java.lang.Throwable -> Ld
            r6 = 1000(0x3e8, double:4.94E-321)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 < 0) goto L36
        L5a:
            r9.f19278d = r1     // Catch: java.lang.Throwable -> Ld
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Ld
            r0.<init>()     // Catch: java.lang.Throwable -> Ld
            java.lang.String r1 = ">>> lock ["
            r0.append(r1)     // Catch: java.lang.Throwable -> Ld
            java.io.File r1 = r9.b     // Catch: java.lang.Throwable -> Ld
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> Ld
            r0.append(r1)     // Catch: java.lang.Throwable -> Ld
            java.lang.String r1 = "] cost: "
            r0.append(r1)     // Catch: java.lang.Throwable -> Ld
            long r4 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> Ld
            long r4 = r4 - r2
            r0.append(r4)     // Catch: java.lang.Throwable -> Ld
            r0.toString()     // Catch: java.lang.Throwable -> Ld
        L7f:
            java.nio.channels.FileLock r0 = r9.f19278d     // Catch: java.lang.Throwable -> Ld
            if (r0 == 0) goto L86
            r9.c()     // Catch: java.lang.Throwable -> Ld
        L86:
            monitor-exit(r9)
            return
        L88:
            monitor-exit(r9)
            goto L8b
        L8a:
            throw r0
        L8b:
            goto L8a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.utils.m.b():void");
    }

    void c() {
        synchronized (f19274g) {
            if (f19275h == null) {
                f19275h = new HashMap<>();
            }
            f19275h.put(this, f19273f);
        }
    }

    void d() {
        synchronized (f19274g) {
            if (f19275h == null) {
                return;
            }
            f19275h.remove(this);
        }
    }

    public void e() {
        a(true);
    }

    @Override // java.lang.Runnable
    public void run() {
        e();
    }
}
