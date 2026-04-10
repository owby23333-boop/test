package com.umeng.analytics.pro;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.pro.e;
import com.umeng.analytics.pro.i;
import com.umeng.analytics.vshelper.PageNameMonitor;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: AutoViewPageTracker.java */
/* JADX INFO: loaded from: classes3.dex */
public class l {
    public static String a;
    boolean b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f19730c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    com.umeng.analytics.vshelper.a f19731f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Application.ActivityLifecycleCallbacks f19732g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Map<String, Long> f19733h;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f19734l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f19735m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f19736n;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static JSONArray f19724i = new JSONArray();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static Object f19725j = new Object();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static Application f19726k = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static String f19722d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static int f19723e = -1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static boolean f19727o = true;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static Object f19728p = new Object();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static ar f19729q = new com.umeng.analytics.vshelper.b();

    /* JADX INFO: compiled from: AutoViewPageTracker.java */
    private static class a {
        private static final l a = new l();

        private a() {
        }
    }

    static /* synthetic */ int a(l lVar) {
        int i2 = lVar.f19736n;
        lVar.f19736n = i2 - 1;
        return i2;
    }

    static /* synthetic */ int b(l lVar) {
        int i2 = lVar.f19735m;
        lVar.f19735m = i2 - 1;
        return i2;
    }

    static /* synthetic */ int e(l lVar) {
        int i2 = lVar.f19736n;
        lVar.f19736n = i2 + 1;
        return i2;
    }

    static /* synthetic */ int f(l lVar) {
        int i2 = lVar.f19735m;
        lVar.f19735m = i2 + 1;
        return i2;
    }

    private void g() {
        if (this.f19734l) {
            return;
        }
        this.f19734l = true;
        if (f19726k == null || Build.VERSION.SDK_INT < 14) {
            return;
        }
        f19726k.registerActivityLifecycleCallbacks(this.f19732g);
    }

    private l() {
        this.f19733h = new HashMap();
        this.f19734l = false;
        this.b = false;
        this.f19730c = false;
        this.f19735m = 0;
        this.f19736n = 0;
        this.f19731f = PageNameMonitor.getInstance();
        this.f19732g = new Application.ActivityLifecycleCallbacks() { // from class: com.umeng.analytics.pro.l.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                l.f19729q.a(activity, bundle);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.F)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onActivityPaused: FirstResumeTrigger enabled.");
                    synchronized (l.f19728p) {
                        if (l.f19727o) {
                            return;
                        }
                    }
                } else {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onActivityPaused: FirstResumeTrigger disabled.");
                }
                if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.AUTO) {
                    if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.MANUAL) {
                        com.umeng.analytics.b.a().i();
                    }
                } else {
                    l.this.c(activity);
                    com.umeng.analytics.b.a().i();
                    l.this.b = false;
                    l.f19729q.d(activity);
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.F)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onActivityResumed: FirstResumeTrigger enabled.");
                    synchronized (l.f19728p) {
                        if (l.f19727o) {
                            boolean unused = l.f19727o = false;
                        }
                    }
                    l.this.a(activity);
                } else {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onActivityResumed: FirstResumeTrigger disabled.");
                    l.this.a(activity);
                }
                l.f19729q.c(activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                if (activity != null) {
                    if (l.this.f19735m <= 0) {
                        if (l.f19722d == null) {
                            l.f19722d = UUID.randomUUID().toString();
                        }
                        if (l.f19723e == -1) {
                            l.f19723e = activity.isTaskRoot() ? 1 : 0;
                        }
                        if (l.f19723e == 0 && UMUtils.isMainProgress(activity)) {
                            HashMap map = new HashMap();
                            map.put("activityName", activity.toString());
                            map.put(com.anythink.expressad.d.a.b.aB, Integer.valueOf(Process.myPid()));
                            map.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(activity) ? 1 : 0));
                            com.umeng.analytics.b bVarA = com.umeng.analytics.b.a();
                            if (bVarA != null) {
                                bVarA.a((Context) activity, "$$_onUMengEnterForegroundInitError", (Map<String, Object>) map);
                            }
                            l.f19723e = -2;
                            if (UMConfigure.isDebugLog()) {
                                UMLog.mutlInfo(2, j.ar);
                            }
                        } else if (l.f19723e == 1 || !UMUtils.isMainProgress(activity)) {
                            HashMap map2 = new HashMap();
                            map2.put("pairUUID", l.f19722d);
                            map2.put(com.anythink.expressad.d.a.b.aB, Integer.valueOf(Process.myPid()));
                            map2.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(activity) ? 1 : 0));
                            map2.put("activityName", activity.toString());
                            if (com.umeng.analytics.b.a() != null) {
                                com.umeng.analytics.b.a().a((Context) activity, "$$_onUMengEnterForeground", (Map<String, Object>) map2);
                            }
                        }
                    }
                    if (l.this.f19736n < 0) {
                        l.e(l.this);
                    } else {
                        l.f(l.this);
                    }
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                MobclickAgent.PageMode pageMode = UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION;
                MobclickAgent.PageMode pageMode2 = MobclickAgent.PageMode.AUTO;
                if (activity != null) {
                    if (activity.isChangingConfigurations()) {
                        l.a(l.this);
                        return;
                    }
                    l.b(l.this);
                    if (l.this.f19735m <= 0) {
                        if (l.f19723e == 0 && UMUtils.isMainProgress(activity)) {
                            return;
                        }
                        int i2 = l.f19723e;
                        if ((i2 == 1 || (i2 == 0 && !UMUtils.isMainProgress(activity))) && activity != null) {
                            HashMap map = new HashMap();
                            map.put("pairUUID", l.f19722d);
                            map.put("reason", "Normal");
                            map.put(com.anythink.expressad.d.a.b.aB, Integer.valueOf(Process.myPid()));
                            map.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(activity) ? 1 : 0));
                            map.put("activityName", activity.toString());
                            com.umeng.analytics.b bVarA = com.umeng.analytics.b.a();
                            if (bVarA != null) {
                                bVarA.a((Context) activity, "$$_onUMengEnterBackground", (Map<String, Object>) map);
                            }
                            if (l.f19722d != null) {
                                l.f19722d = null;
                            }
                        }
                    }
                }
            }
        };
        synchronized (this) {
            if (f19726k != null) {
                g();
            }
        }
    }

    public void c() {
        c((Activity) null);
        b();
    }

    public void b(Context context) {
        synchronized (f19728p) {
            if (f19727o) {
                f19727o = false;
                Activity globleActivity = DeviceConfig.getGlobleActivity(context);
                if (globleActivity == null) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> init触发onResume: 无前台Activity，直接退出。");
                    return;
                }
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> init触发onResume: 补救成功，前台Activity名：" + globleActivity.getLocalClassName());
                a(globleActivity);
                return;
            }
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> init触发onResume: firstResumeCall = false，直接返回。");
        }
    }

    public static void c(Context context) {
        String string;
        if (context != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                synchronized (f19725j) {
                    string = f19724i.toString();
                    f19724i = new JSONArray();
                }
                if (string.length() > 0) {
                    jSONObject.put(e.d.a.f19661c, new JSONArray(string));
                    i.a(context).a(u.a().c(), jSONObject, i.a.AUTOPAGE);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public boolean a() {
        return this.f19734l;
    }

    public static synchronized l a(Context context) {
        if (f19726k == null && context != null) {
            if (context instanceof Activity) {
                f19726k = ((Activity) context).getApplication();
            } else if (context instanceof Application) {
                f19726k = (Application) context;
            }
        }
        return a.a;
    }

    public static void a(Context context, String str) {
        if (f19723e == 1 && UMUtils.isMainProgress(context)) {
            HashMap map = new HashMap();
            map.put("pairUUID", f19722d);
            map.put("reason", str);
            if (f19722d != null) {
                f19722d = null;
            }
            if (context != null) {
                map.put(com.anythink.expressad.d.a.b.aB, Integer.valueOf(Process.myPid()));
                map.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(context) ? 1 : 0));
                map.put("Context", context.toString());
                com.umeng.analytics.b.a().a(context, "$$_onUMengEnterBackground", (Map<String, Object>) map);
            }
        }
    }

    public void b() {
        this.f19734l = false;
        if (f19726k != null) {
            if (Build.VERSION.SDK_INT >= 14) {
                f19726k.unregisterActivityLifecycleCallbacks(this.f19732g);
            }
            f19726k = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Activity activity) {
        long j2;
        long j3;
        try {
            synchronized (this.f19733h) {
                if (a == null && activity != null) {
                    a = activity.getPackageName() + "." + activity.getLocalClassName();
                }
                j2 = 0;
                if (TextUtils.isEmpty(a) || !this.f19733h.containsKey(a)) {
                    j3 = 0;
                } else {
                    long jLongValue = this.f19733h.get(a).longValue();
                    long jCurrentTimeMillis = System.currentTimeMillis() - jLongValue;
                    this.f19733h.remove(a);
                    j2 = jCurrentTimeMillis;
                    j3 = jLongValue;
                }
            }
            synchronized (f19725j) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(d.f19631v, a);
                    jSONObject.put("duration", j2);
                    jSONObject.put(d.f19633x, j3);
                    jSONObject.put("type", 0);
                    f19724i.put(jSONObject);
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable unused2) {
        }
    }

    private void b(Activity activity) {
        a = activity.getPackageName() + "." + activity.getLocalClassName();
        synchronized (this.f19733h) {
            this.f19733h.put(a, Long.valueOf(System.currentTimeMillis()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity) {
        if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.AUTO) {
            if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.MANUAL) {
                synchronized (f19728p) {
                    com.umeng.analytics.b.a().h();
                }
                return;
            }
            return;
        }
        if (activity != null) {
            String str = activity.getPackageName() + "." + activity.getLocalClassName();
            this.f19731f.activityResume(str);
            if (this.b) {
                this.b = false;
                if (!TextUtils.isEmpty(a)) {
                    if (a.equals(str)) {
                        return;
                    }
                    b(activity);
                    synchronized (f19728p) {
                        com.umeng.analytics.b.a().h();
                    }
                    return;
                }
                a = str;
                return;
            }
            b(activity);
            synchronized (f19728p) {
                com.umeng.analytics.b.a().h();
            }
        }
    }
}
