package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.e0;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.w;
import com.bytedance.msdk.adapter.util.Logger;

/* JADX INFO: loaded from: classes.dex */
public class e {
    private static Context a;
    private static a b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static a f1743c;

    private static class a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f1744c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f1745d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f1746e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f1747f;
        private volatile boolean b = false;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f1749h = 0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final long f1748g = System.currentTimeMillis();
        private final Handler a = new Handler(Looper.getMainLooper());

        /* JADX INFO: renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.e$a$a, reason: collision with other inner class name */
        class RunnableC0054a implements Runnable {
            RunnableC0054a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e.b(w.d(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()));
                a.d(a.this);
                if (a.this.f1749h >= 5 || e.d()) {
                    a.this.a(1);
                    return;
                }
                Logger.d("TMe", "--==-- 重试一次 eventType:" + a.this.f1744c + ", 重试次数：" + a.this.f1749h);
                a.this.a();
            }
        }

        public a(String str, long j2, int i2, int i3) {
            this.f1744c = str;
            this.f1745d = j2;
            this.f1746e = i2;
            this.f1747f = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            this.a.postDelayed(new RunnableC0054a(), 500L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0072  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0082 A[Catch: all -> 0x00a4, TryCatch #0 {, blocks: (B:3:0x0001, B:6:0x000d, B:8:0x0012, B:9:0x003d, B:13:0x0066, B:27:0x0091, B:28:0x009d, B:18:0x0078, B:21:0x0082, B:12:0x0044), top: B:36:0x0001 }] */
        /* JADX WARN: Removed duplicated region for block: B:24:0x008c  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x008f  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x009d A[Catch: all -> 0x00a4, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:6:0x000d, B:8:0x0012, B:9:0x003d, B:13:0x0066, B:27:0x0091, B:28:0x009d, B:18:0x0078, B:21:0x0082, B:12:0x0044), top: B:36:0x0001 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a(int r8) {
            /*
                r7 = this;
                monitor-enter(r7)
                android.os.Handler r0 = r7.a     // Catch: java.lang.Throwable -> La4
                r1 = 0
                r0.removeCallbacksAndMessages(r1)     // Catch: java.lang.Throwable -> La4
                boolean r0 = r7.b     // Catch: java.lang.Throwable -> La4
                if (r0 == 0) goto Ld
                goto La2
            Ld:
                r0 = 1
                r7.b = r0     // Catch: java.lang.Throwable -> La4
                if (r8 != r0) goto L41
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La4
                r8.<init>()     // Catch: java.lang.Throwable -> La4
                java.lang.String r1 = "TMe"
                java.lang.String r2 = "--==-- 最终上报：eventType:"
                r8.append(r2)     // Catch: java.lang.Throwable -> La4
                java.lang.String r2 = r7.f1744c     // Catch: java.lang.Throwable -> La4
                r8.append(r2)     // Catch: java.lang.Throwable -> La4
                java.lang.String r2 = ", 重试次数："
                r8.append(r2)     // Catch: java.lang.Throwable -> La4
                int r2 = r7.f1749h     // Catch: java.lang.Throwable -> La4
                r8.append(r2)     // Catch: java.lang.Throwable -> La4
                java.lang.String r2 = ", did: "
                r8.append(r2)     // Catch: java.lang.Throwable -> La4
                java.lang.String r2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.e.a()     // Catch: java.lang.Throwable -> La4
                r8.append(r2)     // Catch: java.lang.Throwable -> La4
                java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> La4
            L3d:
                com.bytedance.msdk.adapter.util.Logger.d(r1, r8)     // Catch: java.lang.Throwable -> La4
                goto L66
            L41:
                r1 = 2
                if (r8 != r1) goto L66
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La4
                r8.<init>()     // Catch: java.lang.Throwable -> La4
                java.lang.String r1 = "TMe"
                java.lang.String r2 = "--==-- 最终上报：eventType:"
                r8.append(r2)     // Catch: java.lang.Throwable -> La4
                java.lang.String r2 = r7.f1744c     // Catch: java.lang.Throwable -> La4
                r8.append(r2)     // Catch: java.lang.Throwable -> La4
                java.lang.String r2 = ", 从applog回调中上报, did: "
                r8.append(r2)     // Catch: java.lang.Throwable -> La4
                java.lang.String r2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.e.a()     // Catch: java.lang.Throwable -> La4
                r8.append(r2)     // Catch: java.lang.Throwable -> La4
                java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> La4
                goto L3d
            L66:
                java.lang.String r8 = r7.f1744c     // Catch: java.lang.Throwable -> La4
                r1 = -1
                int r2 = r8.hashCode()     // Catch: java.lang.Throwable -> La4
                r3 = -834688111(0xffffffffce3fab91, float:-8.03923E8)
                if (r2 == r3) goto L82
                r3 = 270071285(0x1018f5f5, float:3.0166193E-29)
                if (r2 == r3) goto L78
                goto L8c
            L78:
                java.lang.String r2 = "sdk_init"
                boolean r8 = r8.equals(r2)     // Catch: java.lang.Throwable -> La4
                if (r8 == 0) goto L8c
                r8 = 0
                goto L8d
            L82:
                java.lang.String r2 = "sdk_init_end"
                boolean r8 = r8.equals(r2)     // Catch: java.lang.Throwable -> La4
                if (r8 == 0) goto L8c
                r8 = 1
                goto L8d
            L8c:
                r8 = -1
            L8d:
                if (r8 == 0) goto L9d
                if (r8 != r0) goto La2
                long r1 = r7.f1745d     // Catch: java.lang.Throwable -> La4
                int r3 = r7.f1746e     // Catch: java.lang.Throwable -> La4
                int r4 = r7.f1747f     // Catch: java.lang.Throwable -> La4
                long r5 = r7.f1748g     // Catch: java.lang.Throwable -> La4
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(r1, r3, r4, r5)     // Catch: java.lang.Throwable -> La4
                goto La2
            L9d:
                long r0 = r7.f1748g     // Catch: java.lang.Throwable -> La4
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.b(r0)     // Catch: java.lang.Throwable -> La4
            La2:
                monitor-exit(r7)
                return
            La4:
                r8 = move-exception
                monitor-exit(r7)
                goto La8
            La7:
                throw r8
            La8:
                goto La7
            */
            throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.e.a.a(int):void");
        }

        static /* synthetic */ int d(a aVar) {
            int i2 = aVar.f1749h;
            aVar.f1749h = i2 + 1;
            return i2;
        }
    }

    public static void a(long j2, int i2, int i3) {
        f1743c = new a("sdk_init_end", j2, i2, i3);
        f1743c.a();
    }

    public static void a(Context context) {
        a = context;
    }

    private static Context b() {
        Context context = a;
        return context != null ? context : bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        e0.a("tt_device_info", b()).b("did", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String c() {
        return e0.a("tt_device_info", b()).a("did", (String) null);
    }

    public static boolean d() {
        return !TextUtils.isEmpty(e0.a("tt_device_info", b()).a("did", (String) null));
    }

    public static void e() {
        b = new a("sdk_init", 0L, 0, 0);
        b.a();
    }

    public static void f() {
        a aVar = b;
        if (aVar == null) {
            Logger.d("TMe", "--==-- sdkInit埋点还未产生，applog回调已触发，直接return");
            return;
        }
        if (aVar.b) {
            Logger.d("TMe", "--==-- applog回调触发时，sdkInit埋点已经上报，直接return");
        } else {
            b.a(2);
        }
        b = null;
    }

    public static void g() {
        a aVar = f1743c;
        if (aVar == null) {
            Logger.d("TMe", "--==-- sdkInitEnd埋点还未产生，applog回调已触发，直接return");
            return;
        }
        if (aVar.b) {
            Logger.d("TMe", "--==-- applog回调触发时，sdkInitEnd埋点已经上报，直接return");
        } else {
            f1743c.a(2);
        }
        f1743c = null;
    }
}
