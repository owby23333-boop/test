package com.bytedance.msdk.m;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.msdk.gc.m;
import com.bytedance.msdk.gz.io;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    private static volatile z dl;
    private static volatile z g;
    private static Context z;

    public static void z(Context context) {
        z = context;
    }

    public static void z(long j) {
        z zVar = new z("sdk_init", j, 0L, 0, 0, null, null);
        g = zVar;
        zVar.z();
    }

    public static void z(long j, int i, int i2, JSONObject jSONObject, Map<String, Object> map) {
        z zVar = new z("sdk_init_end", -1L, j, i, i2, jSONObject, map);
        dl = zVar;
        zVar.z();
    }

    public static boolean z() {
        return !TextUtils.isEmpty(io.z());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String gc() {
        return io.z();
    }

    private static class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f495a;
        private final String dl;
        private final JSONObject e;
        private final int gc;
        private final long gz;
        private final int m;
        private Map<String, Object> uy;
        private final Handler z;
        private volatile boolean g = false;
        private int fo = 0;

        static /* synthetic */ int g(z zVar) {
            int i = zVar.fo;
            zVar.fo = i + 1;
            return i;
        }

        public z(String str, long j, long j2, int i, int i2, JSONObject jSONObject, Map<String, Object> map) {
            this.gz = j == -1 ? System.currentTimeMillis() : j;
            this.dl = str;
            this.f495a = j2;
            this.gc = i;
            this.m = i2;
            this.e = jSONObject;
            this.uy = map;
            this.z = new Handler(Looper.getMainLooper());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void z() {
            this.z.postDelayed(new Runnable() { // from class: com.bytedance.msdk.m.a.z.1
                @Override // java.lang.Runnable
                public void run() {
                    z.g(z.this);
                    if (z.this.fo >= 5 || a.z()) {
                        z.this.z(1);
                    } else {
                        com.bytedance.msdk.z.gc.dl.z("TMe", "--==-- 重试一次 eventType:" + z.this.dl + ", 重试次数：" + z.this.fo);
                        z.this.z();
                    }
                }
            }, 500L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:25:0x008f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public synchronized void z(int r10) {
            /*
                r9 = this;
                monitor-enter(r9)
                android.os.Handler r0 = r9.z     // Catch: java.lang.Throwable -> Lad
                r1 = 0
                r0.removeCallbacksAndMessages(r1)     // Catch: java.lang.Throwable -> Lad
                boolean r0 = r9.g     // Catch: java.lang.Throwable -> Lad
                if (r0 == 0) goto Ld
                monitor-exit(r9)
                return
            Ld:
                r0 = 1
                r9.g = r0     // Catch: java.lang.Throwable -> Lad
                if (r10 != r0) goto L43
                java.lang.String r10 = "TMe"
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lad
                java.lang.String r2 = "--==-- 最终上报：eventType:"
                r1.<init>(r2)     // Catch: java.lang.Throwable -> Lad
                java.lang.String r2 = r9.dl     // Catch: java.lang.Throwable -> Lad
                java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> Lad
                java.lang.String r2 = ", 重试次数："
                java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> Lad
                int r2 = r9.fo     // Catch: java.lang.Throwable -> Lad
                java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> Lad
                java.lang.String r2 = ", did: "
                java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> Lad
                java.lang.String r2 = com.bytedance.msdk.m.a.a()     // Catch: java.lang.Throwable -> Lad
                java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> Lad
                java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Lad
                com.bytedance.msdk.z.gc.dl.z(r10, r1)     // Catch: java.lang.Throwable -> Lad
                goto L6a
            L43:
                r1 = 2
                if (r10 != r1) goto L6a
                java.lang.String r10 = "TMe"
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lad
                java.lang.String r2 = "--==-- 最终上报：eventType:"
                r1.<init>(r2)     // Catch: java.lang.Throwable -> Lad
                java.lang.String r2 = r9.dl     // Catch: java.lang.Throwable -> Lad
                java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> Lad
                java.lang.String r2 = ", 从applog回调中上报, did: "
                java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> Lad
                java.lang.String r2 = com.bytedance.msdk.m.a.a()     // Catch: java.lang.Throwable -> Lad
                java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> Lad
                java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Lad
                com.bytedance.msdk.z.gc.dl.z(r10, r1)     // Catch: java.lang.Throwable -> Lad
            L6a:
                java.lang.String r10 = r9.dl     // Catch: java.lang.Throwable -> Lad
                int r1 = r10.hashCode()     // Catch: java.lang.Throwable -> Lad
                r2 = -834688111(0xffffffffce3fab91, float:-8.03923E8)
                if (r1 == r2) goto L85
                r2 = 270071285(0x1018f5f5, float:3.0166193E-29)
                if (r1 == r2) goto L7b
                goto L8f
            L7b:
                java.lang.String r1 = "sdk_init"
                boolean r10 = r10.equals(r1)     // Catch: java.lang.Throwable -> Lad
                if (r10 == 0) goto L8f
                r10 = 0
                goto L90
            L85:
                java.lang.String r1 = "sdk_init_end"
                boolean r10 = r10.equals(r1)     // Catch: java.lang.Throwable -> Lad
                if (r10 == 0) goto L8f
                r10 = r0
                goto L90
            L8f:
                r10 = -1
            L90:
                if (r10 == 0) goto La6
                if (r10 == r0) goto L95
                goto La4
            L95:
                long r1 = r9.f495a     // Catch: java.lang.Throwable -> Lad
                int r3 = r9.gc     // Catch: java.lang.Throwable -> Lad
                int r4 = r9.m     // Catch: java.lang.Throwable -> Lad
                long r5 = r9.gz     // Catch: java.lang.Throwable -> Lad
                org.json.JSONObject r7 = r9.e     // Catch: java.lang.Throwable -> Lad
                java.util.Map<java.lang.String, java.lang.Object> r8 = r9.uy     // Catch: java.lang.Throwable -> Lad
                com.bytedance.msdk.m.a.z(r1, r3, r4, r5, r7, r8)     // Catch: java.lang.Throwable -> Lad
            La4:
                monitor-exit(r9)
                return
            La6:
                long r0 = r9.gz     // Catch: java.lang.Throwable -> Lad
                com.bytedance.msdk.m.a.g(r0)     // Catch: java.lang.Throwable -> Lad
                monitor-exit(r9)
                return
            Lad:
                r10 = move-exception
                monitor-exit(r9)
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.m.a.z.z(int):void");
        }
    }

    public static void g() {
        new com.bytedance.sdk.openadsdk.core.a.g("track_start_up").g(new Runnable() { // from class: com.bytedance.msdk.m.a.1
            @Override // java.lang.Runnable
            public void run() {
                m.g();
            }
        });
    }

    public static void dl() {
        new com.bytedance.sdk.openadsdk.core.a.g("track_mediation_sdk_init").g(new Runnable() { // from class: com.bytedance.msdk.m.a.2
            @Override // java.lang.Runnable
            public void run() {
                m.z();
            }
        });
    }

    public static void g(final long j) {
        new com.bytedance.sdk.openadsdk.core.a.g("track_sdk_init").g(new Runnable() { // from class: com.bytedance.msdk.m.a.3
            @Override // java.lang.Runnable
            public void run() {
                m.z(j);
            }
        });
    }

    public static void z(final long j, final int i, final int i2, final long j2, final JSONObject jSONObject, final Map<String, Object> map) {
        new com.bytedance.sdk.openadsdk.core.a.g("track_sdk_init_end").g(new Runnable() { // from class: com.bytedance.msdk.m.a.4
            @Override // java.lang.Runnable
            public void run() {
                m.z(j, i, i2, j2, jSONObject, (Map<String, Object>) map);
            }
        });
    }

    public static void z(final boolean z2) {
        new com.bytedance.sdk.openadsdk.core.a.g("track_get_config_start").g(new Runnable() { // from class: com.bytedance.msdk.m.a.5
            @Override // java.lang.Runnable
            public void run() {
                m.z(z2);
            }
        });
    }

    public static void z(final int i, final int i2, final long j, final boolean z2, final boolean z3, final JSONObject jSONObject, final long j2, final JSONObject jSONObject2) {
        new com.bytedance.sdk.openadsdk.core.a.g("track_get_config_final").g(new Runnable() { // from class: com.bytedance.msdk.m.a.6
            @Override // java.lang.Runnable
            public void run() {
                m.z(i, i2, j, z2, z3, jSONObject, j2, jSONObject2);
            }
        });
    }
}
