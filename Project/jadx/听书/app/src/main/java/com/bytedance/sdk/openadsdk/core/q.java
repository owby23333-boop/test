package com.bytedance.sdk.openadsdk.core;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class q {
    private static volatile Handler m;
    public static volatile boolean z;
    public static AtomicBoolean g = new AtomicBoolean(false);
    public static AtomicBoolean dl = new AtomicBoolean(false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static AtomicBoolean f1298a = new AtomicBoolean(false);
    public static final long gc = SystemClock.elapsedRealtime();

    public static void z() {
        Context context;
        if (f1298a.get() || !zw.g().eo() || (context = zw.getContext()) == null) {
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.core.io.gc.z().g().z(context, true, new com.bytedance.sdk.openadsdk.core.io.a(context));
        } catch (Exception unused) {
        }
        f1298a.set(true);
    }

    public static void g() {
        zw.g().z(1);
        if (!f1298a.get()) {
            z();
        }
        Context context = zw.getContext();
        if (context == null) {
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.core.io.gc.z().g().z(context, com.bytedance.sdk.openadsdk.core.multipro.g.dl());
        } catch (Exception unused) {
        }
    }

    public static void dl() {
        com.bytedance.sdk.component.a.g.dl dlVarZ = g.z();
        long jCurrentTimeMillis = dlVarZ.get("sdk_first_init_timestamp", 0L);
        if (jCurrentTimeMillis == 0) {
            jCurrentTimeMillis = System.currentTimeMillis();
            dlVarZ.put("sdk_first_init_timestamp", jCurrentTimeMillis);
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        String strG = com.bytedance.sdk.openadsdk.core.un.eo.g(jCurrentTimeMillis, jCurrentTimeMillis2);
        long j = dlVarZ.get("sdk_init_timestamp", 0L);
        com.bytedance.sdk.openadsdk.core.q.v.z().z(strG, new StringBuilder().append(j != 0 ? (jCurrentTimeMillis2 - j) / 1000 : 0L).toString());
        dlVarZ.put("sdk_init_timestamp", System.currentTimeMillis());
    }

    private static void e() {
        if (Build.VERSION.SDK_INT < 28) {
            return;
        }
        try {
            Class.forName("android.content.pm.PackageParser$Package").getDeclaredConstructor(String.class).setAccessible(true);
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mHiddenApiWarningShown");
            declaredField.setAccessible(true);
            declaredField.setBoolean(objInvoke, true);
        } catch (Throwable unused) {
        }
    }

    public static void z(Context context) {
        g.set(true);
        dl.set(true);
        e();
        com.bytedance.sdk.openadsdk.core.un.oq.z(context);
        gz();
        String strDl = tb.dl();
        com.bytedance.sdk.component.utils.wp.z("appLogID", strDl);
        if (!TextUtils.isEmpty(strDl)) {
            com.bytedance.sdk.openadsdk.core.q.g.z(strDl);
        }
        if (com.bytedance.sdk.openadsdk.z.z.z.z() != null) {
            com.bytedance.sdk.openadsdk.z.z.z.z().z(strDl);
        }
        com.bytedance.sdk.component.adexpress.z.g.g.z();
        new com.bytedance.sdk.openadsdk.core.a.g("playable_engine_init").g(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.q.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.z.g.g.g();
            }
        });
    }

    public static void a() {
        com.bytedance.sdk.component.adexpress.z.z.z.z().z(new com.bytedance.sdk.component.adexpress.z.z.dl() { // from class: com.bytedance.sdk.openadsdk.core.q.2
            @Override // com.bytedance.sdk.component.adexpress.z.z.dl
            public int e() {
                return 0;
            }

            @Override // com.bytedance.sdk.component.adexpress.z.z.dl
            public ExecutorService i() {
                return null;
            }

            @Override // com.bytedance.sdk.component.adexpress.z.z.dl
            public ExecutorService v() {
                return null;
            }

            @Override // com.bytedance.sdk.component.adexpress.z.z.dl
            public int z() {
                if (zw.g() == null) {
                    return 0;
                }
                return zw.g().fp();
            }

            @Override // com.bytedance.sdk.component.adexpress.z.z.dl
            public Context getContext() {
                return zw.getContext();
            }

            @Override // com.bytedance.sdk.component.adexpress.z.z.dl
            public Handler g() {
                return q.m();
            }

            @Override // com.bytedance.sdk.component.adexpress.z.z.dl
            public com.bytedance.sdk.component.adexpress.z.dl.z dl() {
                return zw.z().z(1);
            }

            @Override // com.bytedance.sdk.component.adexpress.z.z.dl
            public com.bytedance.sdk.component.fo.g.g a() {
                return com.bytedance.sdk.openadsdk.core.io.gc.z().g().a();
            }

            @Override // com.bytedance.sdk.component.adexpress.z.z.dl
            public com.bytedance.sdk.component.fo.g.dl gc() {
                return com.bytedance.sdk.openadsdk.core.io.gc.z().g().dl();
            }

            @Override // com.bytedance.sdk.component.adexpress.z.z.dl
            public String m() {
                return uy.ls().q();
            }

            @Override // com.bytedance.sdk.component.adexpress.z.z.dl
            public int gz() {
                return zw.g().no();
            }

            @Override // com.bytedance.sdk.component.adexpress.z.z.dl
            public int fo() {
                return zw.g().mj();
            }

            @Override // com.bytedance.sdk.component.adexpress.z.z.dl
            public int uy() {
                return uy.ls().bv();
            }

            @Override // com.bytedance.sdk.component.adexpress.z.z.dl
            public int kb() {
                return zw.g().zd();
            }

            @Override // com.bytedance.sdk.component.adexpress.z.z.dl
            public boolean wp() {
                return com.bytedance.sdk.openadsdk.core.multipro.g.dl();
            }

            @Override // com.bytedance.sdk.component.adexpress.z.z.dl
            public int pf() {
                return com.bytedance.sdk.openadsdk.core.un.oq.a(zw.getContext());
            }
        });
    }

    public static void gc() {
        com.bytedance.sdk.component.adexpress.z.z.z.z().z(new com.bytedance.sdk.component.adexpress.z.z.g() { // from class: com.bytedance.sdk.openadsdk.core.q.3
            @Override // com.bytedance.sdk.component.adexpress.z.z.g
            public int update(String str, ContentValues contentValues, String str2, String[] strArr) {
                return com.bytedance.sdk.openadsdk.core.multipro.z.z.update(zw.getContext(), str, contentValues, str2, strArr);
            }

            @Override // com.bytedance.sdk.component.adexpress.z.z.g
            public Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
                return com.bytedance.sdk.openadsdk.core.multipro.z.z.query(zw.getContext(), str, strArr, str2, strArr2, str3, str4, str5);
            }

            @Override // com.bytedance.sdk.component.adexpress.z.z.g
            public int delete(String str, String str2, String[] strArr) {
                return com.bytedance.sdk.openadsdk.core.multipro.z.z.delete(zw.getContext(), str, str2, strArr);
            }

            @Override // com.bytedance.sdk.component.adexpress.z.z.g
            public void insert(String str, ContentValues contentValues) {
                com.bytedance.sdk.openadsdk.core.multipro.z.z.insert(zw.getContext(), str, contentValues);
            }
        });
        com.bytedance.sdk.component.adexpress.z.z.z.z().z(new com.bytedance.sdk.component.adexpress.z.z.a() { // from class: com.bytedance.sdk.openadsdk.core.q.4
            @Override // com.bytedance.sdk.component.adexpress.z.z.a
            public void z(final int i) {
                com.bytedance.sdk.openadsdk.core.q.v.z().gc(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.q.4.1
                    @Override // com.bytedance.sdk.openadsdk.kb.z.z
                    public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                        return com.bytedance.sdk.openadsdk.core.q.z.g.g().g(i).e(fo.z(i));
                    }
                });
            }
        });
        com.bytedance.sdk.component.adexpress.z.z.z.z().z(new z());
        com.bytedance.sdk.component.adexpress.z.z.z.z().z(new com.bytedance.sdk.component.adexpress.z.z.gc() { // from class: com.bytedance.sdk.openadsdk.core.q.5
            @Override // com.bytedance.sdk.component.adexpress.z.z.gc
            public void delete(String str, String str2) {
                com.bytedance.sdk.openadsdk.core.dl.g.z().z(str, str2);
            }

            @Override // com.bytedance.sdk.component.adexpress.z.z.gc
            public void update(String str, com.bytedance.sdk.component.adexpress.z.dl.dl dlVar) {
                com.bytedance.sdk.openadsdk.core.dl.g.z().z(str, dlVar);
            }
        });
    }

    private static final class z implements com.bytedance.sdk.component.m.iq {
        private z() {
        }

        @Override // com.bytedance.sdk.component.m.iq
        public com.bytedance.sdk.component.m.v from(String str) {
            return com.bytedance.sdk.openadsdk.gz.g.z().from(str);
        }

        @Override // com.bytedance.sdk.component.m.iq
        public void clearMemoryCache(double d) {
            com.bytedance.sdk.openadsdk.gz.g.z().clearMemoryCache(d);
        }

        @Override // com.bytedance.sdk.component.m.iq
        public InputStream getCacheStream(String str, String str2) {
            return com.bytedance.sdk.openadsdk.gz.g.z().getCacheStream(str, str2);
        }
    }

    private static void gz() {
        com.bytedance.sdk.openadsdk.core.dl.a.z().a(UUID.randomUUID().toString());
    }

    public static Handler m() {
        if (m == null) {
            synchronized (q.class) {
                if (m == null) {
                    m = new Handler(Looper.getMainLooper());
                }
            }
        }
        return m;
    }
}
