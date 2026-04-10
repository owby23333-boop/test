package com.umeng.analytics;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.pro.i;
import com.umeng.analytics.pro.j;
import com.umeng.analytics.pro.k;
import com.umeng.analytics.pro.l;
import com.umeng.analytics.pro.m;
import com.umeng.analytics.pro.n;
import com.umeng.analytics.pro.o;
import com.umeng.analytics.pro.p;
import com.umeng.analytics.pro.s;
import com.umeng.analytics.pro.t;
import com.umeng.analytics.pro.u;
import com.umeng.analytics.pro.v;
import com.umeng.analytics.pro.y;
import com.umeng.common.ISysListener;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.commonsdk.utils.d;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.microedition.khronos.opengles.GL10;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: InternalAgent.java */
/* JADX INFO: loaded from: classes3.dex */
public class b implements n, t {
    private static final String A = "umsp_2";
    private static final String B = "umsp_3";
    private static final String C = "umsp_4";
    private static final String D = "umsp_5";
    private static Context a = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f19401h = "sp_uapp";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f19402i = "prepp_uapp";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int f19403o = 128;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final int f19404p = 256;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static String f19405q = "";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static String f19406r = "";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final String f19407s = "ekv_bl";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final String f19408t = "ekv_bl_ver";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final String f19409v = "ekv_wl";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final String f19410w = "ekv_wl_ver";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final String f19411z = "umsp_1";
    private ISysListener b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private p f19412c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private v f19413d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private k f19414e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private u f19415f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private l f19416g;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f19417j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private volatile JSONObject f19418k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private volatile JSONObject f19419l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private volatile JSONObject f19420m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f19421n;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private com.umeng.analytics.filter.a f19422u;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private com.umeng.analytics.filter.b f19423x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private m f19424y;

    /* JADX INFO: compiled from: InternalAgent.java */
    private static class a {
        private static final b a = new b();

        private a() {
        }
    }

    static {
        Context appContext = UMGlobalContext.getAppContext();
        if (appContext != null) {
            a = appContext.getApplicationContext();
        }
    }

    public static b a() {
        return a.a;
    }

    private void i(Context context) {
        try {
            if (context == null) {
                MLog.e("unexpected null context in getNativeSuperProperties");
                return;
            }
            if (a == null) {
                a = context.getApplicationContext();
            }
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            if (this.f19418k == null) {
                this.f19418k = new JSONObject();
            }
            if (this.f19419l == null) {
                this.f19419l = new JSONObject();
            }
            String string = sharedPreferences.getString(f19402i, null);
            if (!TextUtils.isEmpty(string)) {
                try {
                    this.f19420m = new JSONObject(string);
                } catch (JSONException unused) {
                }
            }
            if (this.f19420m == null) {
                this.f19420m = new JSONObject();
            }
        } catch (Throwable unused2) {
        }
    }

    public JSONObject b() {
        return this.f19418k;
    }

    public JSONObject c() {
        return this.f19420m;
    }

    public JSONObject d() {
        return this.f19419l;
    }

    public void e() {
        this.f19419l = null;
    }

    public String f() {
        if (UMUtils.isMainProgress(a)) {
            return f19405q;
        }
        MLog.e("getOnResumedActivityName can not be called in child process");
        return null;
    }

    public String g() {
        if (UMUtils.isMainProgress(a)) {
            return f19406r;
        }
        MLog.e("getOnPausedActivityName can not be called in child process");
        return null;
    }

    public void h() {
        try {
            if (a != null) {
                if (!UMUtils.isMainProgress(a)) {
                    MLog.e("onStartSessionInternal can not be called in child process");
                    return;
                } else {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    UMWorkDispatch.sendEvent(a, o.a.f19774k, CoreProtocol.getInstance(a), Long.valueOf(jCurrentTimeMillis));
                    UMWorkDispatch.sendEvent(a, o.a.f19770g, CoreProtocol.getInstance(a), Long.valueOf(jCurrentTimeMillis));
                }
            }
            if (this.b != null) {
                this.b.onAppResume();
            }
        } catch (Throwable unused) {
        }
    }

    void j() {
        try {
            if (a == null) {
                return;
            }
            if (!UMUtils.isMainProgress(a)) {
                MLog.e("onProfileSignOff can not be called in child process");
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ts", jCurrentTimeMillis);
            UMWorkDispatch.sendEvent(a, o.a.f19769f, CoreProtocol.getInstance(a), jSONObject);
            UMWorkDispatch.sendEvent(a, o.a.f19778o, CoreProtocol.getInstance(a), jSONObject);
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(" Excepthon  in  onProfileSignOff", th);
            }
        }
    }

    public synchronized void k() {
        if (a == null) {
            return;
        }
        if (!UMUtils.isMainProgress(a)) {
            MLog.e("unregisterSuperPropertyByCoreProtocol can not be called in child process");
            return;
        }
        if (this.f19418k != null) {
            SharedPreferences.Editor editorEdit = PreferenceWrapper.getDefault(a).edit();
            editorEdit.putString(f19401h, this.f19418k.toString());
            editorEdit.commit();
        } else {
            this.f19418k = new JSONObject();
        }
    }

    public synchronized JSONObject l() {
        if (a == null) {
            return null;
        }
        if (!UMUtils.isMainProgress(a)) {
            MLog.e("getSuperPropertiesJSONObject can not be called in child process");
            return null;
        }
        if (this.f19418k == null) {
            this.f19418k = new JSONObject();
        }
        return this.f19418k;
    }

    public synchronized void m() {
        try {
            if (a != null) {
                if (!UMUtils.isMainProgress(a)) {
                    MLog.e("clearSuperPropertiesByCoreProtocol can not be called in child process");
                } else {
                    SharedPreferences.Editor editorEdit = PreferenceWrapper.getDefault(a).edit();
                    editorEdit.remove(f19401h);
                    editorEdit.commit();
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.umeng.analytics.pro.n
    public void n() {
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onIntoBackground triggered.");
        if (AnalyticsConfig.enable && FieldManager.b()) {
            if (!FieldManager.allow(d.D)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> 退出发送策略: 云控控制字关闭。功能不生效");
            } else {
                if (UMWorkDispatch.eventHasExist(o.a.A)) {
                    return;
                }
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> 退出时发送策略 被触发！");
                Context context = a;
                UMWorkDispatch.sendEvent(context, o.a.A, CoreProtocol.getInstance(context), null);
            }
        }
    }

    private b() {
        this.f19412c = new p();
        this.f19413d = new v();
        this.f19414e = new k();
        this.f19415f = u.a();
        this.f19416g = null;
        this.f19417j = false;
        this.f19418k = null;
        this.f19419l = null;
        this.f19420m = null;
        this.f19421n = false;
        this.f19422u = null;
        this.f19423x = null;
        this.f19424y = null;
        this.f19412c.a(this);
    }

    public void a(Context context) {
        if (context == null) {
            return;
        }
        try {
            if (a == null) {
                a = context.getApplicationContext();
            }
            if (this.f19422u == null) {
                this.f19422u = new com.umeng.analytics.filter.a("ekv_bl", "ekv_bl_ver");
                this.f19422u.register(a);
            }
            if (this.f19423x == null) {
                this.f19423x = new com.umeng.analytics.filter.b("ekv_wl", "ekv_wl_ver");
                this.f19423x.register(a);
            }
            if (UMUtils.isMainProgress(a)) {
                if (!this.f19417j) {
                    this.f19417j = true;
                    i(a);
                }
                if (Build.VERSION.SDK_INT > 13) {
                    synchronized (this) {
                        if (!this.f19421n) {
                            this.f19416g = l.a(context);
                            if (this.f19416g.a()) {
                                this.f19421n = true;
                            }
                            this.f19424y = m.a();
                            try {
                                m.a(context);
                                this.f19424y.a(this);
                            } catch (Throwable unused) {
                            }
                        }
                    }
                } else {
                    this.f19421n = true;
                }
                if (UMConfigure.isDebugLog()) {
                    UMLog.mutlInfo(j.B, 3, "", null, null);
                }
                UMWorkDispatch.registerConnStateObserver(CoreProtocol.getInstance(a));
            }
        } catch (Throwable unused2) {
        }
    }

    void b(String str) {
        if (!UMUtils.isMainProgress(a)) {
            MLog.e("onPageEnd can not be called in child process");
            return;
        }
        try {
            if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.LEGACY_AUTO) {
                this.f19413d.b(str);
            }
        } catch (Throwable unused) {
        }
    }

    void c(Context context) {
        if (context == null) {
            UMLog.aq(j.f19711p, 0, "\\|");
            return;
        }
        if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.AUTO) {
            return;
        }
        if (a == null) {
            a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(a)) {
            MLog.e("onPause can not be called in child process");
            return;
        }
        if (UMConfigure.isDebugLog() && !(context instanceof Activity)) {
            UMLog.aq(j.f19712q, 2, "\\|");
        }
        try {
            if (!this.f19417j || !this.f19421n) {
                a(context);
            }
            if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.LEGACY_MANUAL) {
                this.f19414e.b(context.getClass().getName());
            }
            i();
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e("Exception occurred in Mobclick.onRause(). ", th);
            }
        }
        if (UMConfigure.isDebugLog() && (context instanceof Activity)) {
            f19406r = context.getClass().getName();
        }
    }

    void d(Context context) {
        if (context == null) {
            return;
        }
        try {
            if (a == null) {
                a = context.getApplicationContext();
            }
            if (!UMUtils.isMainProgress(a)) {
                MLog.e("onKillProcess can not be called in child process");
                return;
            }
            if (this.f19416g != null) {
                this.f19416g.c();
            }
            l.a(context, "onKillProcess");
            if (this.f19414e != null) {
                this.f19414e.b();
            }
            if (this.f19413d != null) {
                this.f19413d.b();
            }
            if (a != null) {
                if (this.f19415f != null) {
                    this.f19415f.c(a, Long.valueOf(System.currentTimeMillis()));
                }
                o.a(a).d();
                v.a(a);
                if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.AUTO) {
                    l.c(a);
                }
                PreferenceWrapper.getDefault(a).edit().commit();
            }
        } catch (Throwable unused) {
        }
    }

    public synchronized Object e(Context context, String str) {
        if (context == null) {
            UMLog.aq(j.ai, 0, "\\|");
            return null;
        }
        if (a == null) {
            a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(a)) {
            MLog.e("getSuperProperty can not be called in child process");
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            UMLog.aq(j.ag, 0, "\\|");
            return null;
        }
        if (!str.equals(f19411z) && !str.equals(A) && !str.equals(B) && !str.equals(C) && !str.equals(D)) {
            MLog.e("please check key or value, must be correct!");
            return null;
        }
        if (this.f19418k == null) {
            this.f19418k = new JSONObject();
        } else if (this.f19418k.has(str)) {
            return this.f19418k.opt(str);
        }
        return null;
    }

    public synchronized void f(Context context) {
        if (context == null) {
            UMLog.aq(j.ah, 0, "\\|");
            return;
        }
        if (a == null) {
            a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(a)) {
            MLog.e("clearSuperProperties can not be called in child process");
            return;
        }
        if (!this.f19417j || !this.f19421n) {
            a(a);
        }
        this.f19418k = new JSONObject();
        UMWorkDispatch.sendEvent(a, o.a.f19783t, CoreProtocol.getInstance(a), null);
    }

    public synchronized void g(Context context) {
        if (context == null) {
            UMLog.aq(j.ap, 0, "\\|");
            return;
        }
        if (a == null) {
            a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(a)) {
            MLog.e("clearPreProperties can not be called in child process");
            return;
        }
        if (!this.f19417j || !this.f19421n) {
            a(a);
        }
        if (this.f19420m.length() > 0) {
            UMWorkDispatch.sendEvent(a, o.a.f19787x, CoreProtocol.getInstance(a), null);
        }
        this.f19420m = new JSONObject();
    }

    void b(Context context) {
        if (context == null) {
            MLog.e("unexpected null context in onResume");
            return;
        }
        if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.AUTO) {
            return;
        }
        if (a == null) {
            a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(a)) {
            MLog.e("onResume can not be called in child process");
            return;
        }
        if (UMConfigure.isDebugLog() && !(context instanceof Activity)) {
            UMLog.aq(j.f19710o, 2, "\\|");
        }
        try {
            if (!this.f19417j || !this.f19421n) {
                a(context);
            }
            if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.LEGACY_MANUAL) {
                this.f19414e.a(context.getClass().getName());
            }
            h();
            if (UMConfigure.isDebugLog() && (context instanceof Activity)) {
                f19405q = context.getClass().getName();
            }
        } catch (Throwable th) {
            MLog.e("Exception occurred in Mobclick.onResume(). ", th);
        }
    }

    public synchronized JSONObject h(Context context) {
        if (context == null) {
            UMLog.aq(j.aq, 0, "\\|");
            return null;
        }
        if (a == null) {
            a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(a)) {
            MLog.e("getPreProperties can not be called in child process");
            return null;
        }
        if (!this.f19417j || !this.f19421n) {
            a(a);
        }
        if (this.f19420m == null) {
            this.f19420m = new JSONObject();
        }
        JSONObject jSONObject = new JSONObject();
        if (this.f19420m.length() > 0) {
            try {
                jSONObject = new JSONObject(this.f19420m.toString());
            } catch (JSONException unused) {
            }
        }
        return jSONObject;
    }

    public void i() {
        try {
            if (a != null) {
                if (!UMUtils.isMainProgress(a)) {
                    MLog.e("onEndSessionInternal can not be called in child process");
                    return;
                }
                UMWorkDispatch.sendEvent(a, o.a.f19771h, CoreProtocol.getInstance(a), Long.valueOf(System.currentTimeMillis()));
                UMWorkDispatch.sendEvent(a, o.a.f19767d, CoreProtocol.getInstance(a), null);
                UMWorkDispatch.sendEvent(a, 4099, CoreProtocol.getInstance(a), null);
                UMWorkDispatch.sendEvent(a, o.a.f19772i, CoreProtocol.getInstance(a), null);
            }
        } catch (Throwable unused) {
        }
        ISysListener iSysListener = this.b;
        if (iSysListener != null) {
            iSysListener.onAppPause();
        }
    }

    public synchronized void f(Context context, String str) {
        if (context == null) {
            UMLog.aq(j.an, 0, "\\|");
            return;
        }
        if (a == null) {
            a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(a)) {
            MLog.e("unregisterPreProperty can not be called in child process");
            return;
        }
        if (!this.f19417j || !this.f19421n) {
            a(a);
        }
        if (this.f19420m == null) {
            this.f19420m = new JSONObject();
        }
        if (str != null && str.length() > 0) {
            if (this.f19420m.has(str)) {
                this.f19420m.remove(str);
                UMWorkDispatch.sendEvent(a, o.a.f19786w, CoreProtocol.getInstance(a), this.f19420m.toString());
            } else if (UMConfigure.isDebugLog()) {
                UMLog.aq(j.ao, 0, "\\|");
            }
            return;
        }
        MLog.e("please check propertics, property is null!");
    }

    private boolean c(String str) {
        if (this.f19422u.enabled() && this.f19422u.matchHit(str)) {
            return true;
        }
        if (!this.f19423x.enabled()) {
            return false;
        }
        if (!this.f19423x.matchHit(str)) {
            return true;
        }
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> white list match! id = " + str);
        return false;
    }

    public synchronized void d(Context context, String str) {
        try {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (context == null) {
            UMLog.aq(j.ah, 0, "\\|");
            return;
        }
        if (a == null) {
            a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(a)) {
            MLog.e("unregisterSuperProperty can not be called in child process");
            return;
        }
        if (!this.f19417j || !this.f19421n) {
            a(a);
        }
        if (TextUtils.isEmpty(str)) {
            UMLog.aq(j.ag, 0, "\\|");
            return;
        }
        if (!str.equals(f19411z) && !str.equals(A) && !str.equals(B) && !str.equals(C) && !str.equals(D)) {
            MLog.e("please check key or value, must be correct!");
            return;
        }
        if (this.f19418k == null) {
            this.f19418k = new JSONObject();
        }
        if (this.f19418k.has(str)) {
            this.f19418k.remove(str);
            UMWorkDispatch.sendEvent(a, o.a.f19784u, CoreProtocol.getInstance(a), str);
        }
    }

    public void b(Context context, String str) {
        try {
            if (context == null) {
                UMLog.aq(j.N, 0, "\\|");
                return;
            }
            if (a == null) {
                a = context.getApplicationContext();
            }
            if (!UMUtils.isMainProgress(a)) {
                MLog.e("onDeepLinkReceived can not be called in child process");
                return;
            }
            if (!this.f19417j || !this.f19421n) {
                a(a);
            }
            if (!TextUtils.isEmpty(str)) {
                HashMap map = new HashMap();
                map.put(com.umeng.analytics.pro.d.aE, str);
                a(a, com.umeng.analytics.pro.d.aD, (Map<String, Object>) map, -1L, false);
                return;
            }
            UMLog.aq(j.O, 0, "\\|");
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(th);
            }
        }
    }

    public synchronized String e(Context context) {
        if (context == null) {
            UMLog.aq(j.ai, 0, "\\|");
            return null;
        }
        if (a == null) {
            a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(a)) {
            MLog.e("getSuperProperties can not be called in child process");
            return null;
        }
        if (this.f19418k != null) {
            return this.f19418k.toString();
        }
        this.f19418k = new JSONObject();
        return null;
    }

    void c(Context context, String str) {
        if (context == null) {
            UMLog.aq(j.f19721z, 0, "\\|");
            return;
        }
        if (a == null) {
            a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(a)) {
            MLog.e("setSecret can not be called in child process");
            return;
        }
        if (!this.f19417j || !this.f19421n) {
            a(a);
        }
        AnalyticsConfig.a(a, str);
    }

    void a(String str) {
        if (!UMUtils.isMainProgress(a)) {
            MLog.e("onPageStart can not be called in child process");
            return;
        }
        try {
            if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.LEGACY_AUTO) {
                this.f19413d.a(str);
            }
        } catch (Throwable unused) {
        }
    }

    public void a(ISysListener iSysListener) {
        if (!UMUtils.isMainProgress(a)) {
            MLog.e("setSysListener can not be called in child process");
        } else {
            this.b = iSysListener;
        }
    }

    public void a(Context context, int i2) {
        if (context == null) {
            MLog.e("unexpected null context in setVerticalType");
            return;
        }
        if (a == null) {
            a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(a)) {
            MLog.e("setVerticalType can not be called in child process");
            return;
        }
        if (!this.f19417j || !this.f19421n) {
            a(a);
        }
        AnalyticsConfig.a(a, i2);
    }

    public synchronized void b(Object obj) {
        if (a == null) {
            return;
        }
        if (!UMUtils.isMainProgress(a)) {
            MLog.e("updateNativePrePropertiesByCoreProtocol can not be called in child process");
            return;
        }
        SharedPreferences.Editor editorEdit = PreferenceWrapper.getDefault(a).edit();
        if (obj != null) {
            String str = (String) obj;
            if (editorEdit != null && !TextUtils.isEmpty(str)) {
                editorEdit.putString(f19402i, str).commit();
            }
        } else if (editorEdit != null) {
            editorEdit.remove(f19402i).commit();
        }
    }

    public void a(Context context, String str, HashMap<String, Object> map) {
        if (context == null) {
            return;
        }
        try {
            if (a == null) {
                a = context.getApplicationContext();
            }
            if (!UMUtils.isMainProgress(a)) {
                MLog.e("onGKVEvent can not be called in child process");
                return;
            }
            if (!this.f19417j || !this.f19421n) {
                a(a);
            }
            String string = "";
            if (this.f19418k == null) {
                this.f19418k = new JSONObject();
            } else {
                string = this.f19418k.toString();
            }
            s.a(a).a(str, map, string);
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(th);
            }
        }
    }

    private boolean b(String str, Object obj) {
        int length;
        if (TextUtils.isEmpty(str)) {
            MLog.e("key is " + str + ", please check key, illegal");
            return false;
        }
        try {
            length = str.getBytes("UTF-8").length;
        } catch (UnsupportedEncodingException unused) {
            length = 0;
        }
        if (length > 128) {
            MLog.e("key length is " + length + ", please check key, illegal");
            return false;
        }
        if (obj instanceof String) {
            if (((String) obj).getBytes("UTF-8").length <= 256) {
                return true;
            }
            MLog.e("value length is " + ((String) obj).getBytes("UTF-8").length + ", please check value, illegal");
            return false;
        }
        if ((obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Double) || (obj instanceof Float)) {
            return true;
        }
        MLog.e("value is " + obj + ", please check value, type illegal");
        return false;
    }

    void a(Context context, String str) {
        if (context == null) {
            UMLog.aq(j.f19718w, 0, "\\|");
            return;
        }
        if (a == null) {
            a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(a)) {
            MLog.e("reportError can not be called in child process");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            if (UMConfigure.isDebugLog()) {
                UMLog.aq(j.f19719x, 0, "\\|");
                return;
            }
            return;
        }
        try {
            if (!this.f19417j || !this.f19421n) {
                a(a);
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ts", System.currentTimeMillis());
            jSONObject.put(com.umeng.analytics.pro.d.Q, 2);
            jSONObject.put("context", str);
            jSONObject.put("__ii", this.f19415f.c());
            UMWorkDispatch.sendEvent(a, o.a.f19773j, CoreProtocol.getInstance(a), jSONObject);
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(th);
            }
        }
    }

    void a(Context context, Throwable th) {
        if (context != null && th != null) {
            if (a == null) {
                a = context.getApplicationContext();
            }
            if (!UMUtils.isMainProgress(a)) {
                MLog.e("reportError can not be called in child process");
                return;
            }
            try {
                if (!this.f19417j || !this.f19421n) {
                    a(a);
                }
                a(a, DataHelper.convertExceptionToString(th));
                return;
            } catch (Exception e2) {
                if (MLog.DEBUG) {
                    MLog.e(e2);
                    return;
                }
                return;
            }
        }
        UMLog.aq(j.f19720y, 0, "\\|");
    }

    public void a(Context context, String str, String str2, long j2, int i2) {
        if (context == null) {
            return;
        }
        try {
            if (a == null) {
                a = context.getApplicationContext();
            }
            if (!this.f19417j || !this.f19421n) {
                a(a);
            }
            if (c(str)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> filter ekv [" + str + "].");
                return;
            }
            String string = "";
            if (this.f19418k == null) {
                this.f19418k = new JSONObject();
            } else {
                string = this.f19418k.toString();
            }
            s.a(a).a(str, str2, j2, i2, string);
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(th);
            }
        }
    }

    void a(Context context, String str, Map<String, Object> map, long j2) {
        try {
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(th);
            }
        }
        if (!TextUtils.isEmpty(str)) {
            if (Arrays.asList(com.umeng.analytics.pro.d.aF).contains(str)) {
                UMLog.aq(j.b, 0, "\\|");
                return;
            }
            if (map.isEmpty()) {
                UMLog.aq(j.f19699d, 0, "\\|");
                return;
            }
            Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                if (Arrays.asList(com.umeng.analytics.pro.d.aF).contains(it.next().getKey())) {
                    UMLog.aq(j.f19700e, 0, "\\|");
                    return;
                }
            }
            a(context, str, map, j2, false);
            return;
        }
        UMLog.aq(j.f19698c, 0, "\\|");
    }

    public void a(Context context, String str, Map<String, Object> map) {
        a(context, str, map, -1L, true);
    }

    private void a(Context context, String str, Map<String, Object> map, long j2, boolean z2) {
        try {
            if (context == null) {
                MLog.e("context is null in onEventNoCheck, please check!");
                return;
            }
            if (a == null) {
                a = context.getApplicationContext();
            }
            if (!this.f19417j || !this.f19421n) {
                a(a);
            }
            if (c(str)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> filter ekv [" + str + "].");
                return;
            }
            String string = "";
            if (this.f19418k == null) {
                this.f19418k = new JSONObject();
            } else {
                string = this.f19418k.toString();
            }
            s.a(a).a(str, map, j2, string, z2);
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(th);
            }
        }
    }

    @Override // com.umeng.analytics.pro.t
    public void a(Throwable th) {
        try {
            if (a == null) {
                return;
            }
            if (!UMUtils.isMainProgress(a)) {
                MLog.e("onAppCrash can not be called in child process");
                return;
            }
            if (AnalyticsConfig.enable) {
                if (this.f19413d != null) {
                    this.f19413d.b();
                }
                l.a(a, "onAppCrash");
                if (this.f19414e != null) {
                    this.f19414e.b();
                }
                if (this.f19416g != null) {
                    this.f19416g.c();
                }
                if (this.f19415f != null) {
                    this.f19415f.c(a, Long.valueOf(System.currentTimeMillis()));
                }
                if (th != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("ts", System.currentTimeMillis());
                    jSONObject.put(com.umeng.analytics.pro.d.Q, 1);
                    jSONObject.put("context", DataHelper.convertExceptionToString(th));
                    i.a(a).a(this.f19415f.c(), jSONObject.toString(), 1);
                }
                o.a(a).d();
                v.a(a);
                if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.AUTO) {
                    l.c(a);
                }
                PreferenceWrapper.getDefault(a).edit().commit();
            }
        } catch (Exception e2) {
            if (MLog.DEBUG) {
                MLog.e("Exception in onAppCrash", e2);
            }
        }
    }

    void a(String str, String str2) {
        try {
            if (a == null) {
                return;
            }
            if (!UMUtils.isMainProgress(a)) {
                MLog.e("onProfileSignIn can not be called in child process");
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.umeng.analytics.pro.d.M, str);
            jSONObject.put("uid", str2);
            jSONObject.put("ts", jCurrentTimeMillis);
            UMWorkDispatch.sendEvent(a, o.a.f19768e, CoreProtocol.getInstance(a), jSONObject);
            UMWorkDispatch.sendEvent(a, o.a.f19778o, CoreProtocol.getInstance(a), jSONObject);
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(" Excepthon  in  onProfileSignIn", th);
            }
        }
    }

    void a(boolean z2) {
        Context context = a;
        if (context == null) {
            return;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.e("setCatchUncaughtExceptions can not be called in child process");
        } else {
            if (AnalyticsConfig.CHANGE_CATCH_EXCEPTION_NOTALLOW) {
                return;
            }
            AnalyticsConfig.CATCH_EXCEPTION = z2;
        }
    }

    void a(GL10 gl10) {
        String[] gpu = UMUtils.getGPU(gl10);
        if (gpu.length == 2) {
            AnalyticsConfig.GPU_VENDER = gpu[0];
            AnalyticsConfig.GPU_RENDERER = gpu[1];
        }
    }

    void a(double d2, double d3) {
        Context context = a;
        if (context == null) {
            return;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.e("setLocation can not be called in child process");
            return;
        }
        if (AnalyticsConfig.a == null) {
            AnalyticsConfig.a = new double[2];
        }
        double[] dArr = AnalyticsConfig.a;
        dArr[0] = d2;
        dArr[1] = d3;
    }

    void a(Context context, MobclickAgent.EScenarioType eScenarioType) {
        if (context == null) {
            MLog.e("unexpected null context in setScenarioType");
            return;
        }
        if (a == null) {
            a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(a)) {
            MLog.e("setScenarioType can not be called in child process");
            return;
        }
        if (eScenarioType != null) {
            a(a, eScenarioType.toValue());
        }
        if (this.f19417j && this.f19421n) {
            return;
        }
        a(a);
    }

    void a(long j2) {
        Context context = a;
        if (context == null) {
            return;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.e("setSessionContinueMillis can not be called in child process");
        } else {
            AnalyticsConfig.kContinueSessionMillis = j2;
            y.a().a(AnalyticsConfig.kContinueSessionMillis);
        }
    }

    public synchronized void a(Context context, String str, Object obj) {
        int i2 = 0;
        if (context == null) {
            UMLog.aq(j.af, 0, "\\|");
            return;
        }
        if (a == null) {
            a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(a)) {
            MLog.e("registerSuperProperty can not be called in child process");
            return;
        }
        if (!this.f19417j || !this.f19421n) {
            a(a);
        }
        if (!TextUtils.isEmpty(str) && obj != null) {
            if (!str.equals(f19411z) && !str.equals(A) && !str.equals(B) && !str.equals(C) && !str.equals(D)) {
                MLog.e("property name is " + str + ", please check key, must be correct!");
                return;
            }
            if ((obj instanceof String) && !HelperUtils.checkStrLen(obj.toString(), 256)) {
                MLog.e("property value is " + obj + ", please check value, lawless!");
                return;
            }
            try {
                if (this.f19418k == null) {
                    this.f19418k = new JSONObject();
                }
                if (obj.getClass().isArray()) {
                    if (obj instanceof String[]) {
                        String[] strArr = (String[]) obj;
                        if (strArr.length > 10) {
                            MLog.e("please check value, size is " + strArr.length + ", overstep 10!");
                            return;
                        }
                        JSONArray jSONArray = new JSONArray();
                        while (i2 < strArr.length) {
                            if (strArr[i2] != null && HelperUtils.checkStrLen(strArr[i2], 256)) {
                                jSONArray.put(strArr[i2]);
                                i2++;
                            }
                            MLog.e("please check value, length is " + strArr[i2].length() + ", overlength 256!");
                            return;
                        }
                        this.f19418k.put(str, jSONArray);
                    } else if (obj instanceof long[]) {
                        long[] jArr = (long[]) obj;
                        if (jArr.length > 10) {
                            MLog.e("please check value, size is " + jArr.length + ", overstep 10!");
                            return;
                        }
                        JSONArray jSONArray2 = new JSONArray();
                        while (i2 < jArr.length) {
                            jSONArray2.put(jArr[i2]);
                            i2++;
                        }
                        this.f19418k.put(str, jSONArray2);
                    } else if (obj instanceof int[]) {
                        int[] iArr = (int[]) obj;
                        if (iArr.length > 10) {
                            MLog.e("please check value, size is " + iArr.length + ", overstep 10!");
                            return;
                        }
                        JSONArray jSONArray3 = new JSONArray();
                        while (i2 < iArr.length) {
                            jSONArray3.put(iArr[i2]);
                            i2++;
                        }
                        this.f19418k.put(str, jSONArray3);
                    } else if (obj instanceof float[]) {
                        float[] fArr = (float[]) obj;
                        if (fArr.length > 10) {
                            MLog.e("please check value, size is " + fArr.length + ", overstep 10!");
                            return;
                        }
                        JSONArray jSONArray4 = new JSONArray();
                        while (i2 < fArr.length) {
                            jSONArray4.put(fArr[i2]);
                            i2++;
                        }
                        this.f19418k.put(str, jSONArray4);
                    } else if (obj instanceof double[]) {
                        double[] dArr = (double[]) obj;
                        if (dArr.length > 10) {
                            MLog.e("please check value, size is " + dArr.length + ", overstep 10!");
                            return;
                        }
                        JSONArray jSONArray5 = new JSONArray();
                        while (i2 < dArr.length) {
                            jSONArray5.put(dArr[i2]);
                            i2++;
                        }
                        this.f19418k.put(str, jSONArray5);
                    } else if (obj instanceof short[]) {
                        short[] sArr = (short[]) obj;
                        if (sArr.length > 10) {
                            MLog.e("please check value, size is " + sArr.length + ", overstep 10!");
                            return;
                        }
                        JSONArray jSONArray6 = new JSONArray();
                        while (i2 < sArr.length) {
                            jSONArray6.put((int) sArr[i2]);
                            i2++;
                        }
                        this.f19418k.put(str, jSONArray6);
                    } else {
                        MLog.e("please check value, illegal type!");
                        return;
                    }
                } else {
                    if (!(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Integer) && !(obj instanceof Float) && !(obj instanceof Double) && !(obj instanceof Short)) {
                        MLog.e("please check value, illegal type!");
                        return;
                    }
                    this.f19418k.put(str, obj);
                }
            } catch (Throwable unused) {
            }
            UMWorkDispatch.sendEvent(a, o.a.f19782s, CoreProtocol.getInstance(a), this.f19418k.toString());
            return;
        }
        UMLog.aq(j.ag, 0, "\\|");
    }

    private void a(String str, Object obj) {
        try {
            if (this.f19418k == null) {
                this.f19418k = new JSONObject();
            }
            int i2 = 0;
            if (obj.getClass().isArray()) {
                if (obj instanceof String[]) {
                    String[] strArr = (String[]) obj;
                    if (strArr.length > 10) {
                        return;
                    }
                    JSONArray jSONArray = new JSONArray();
                    while (i2 < strArr.length) {
                        if (strArr[i2] != null && !HelperUtils.checkStrLen(strArr[i2], 256)) {
                            jSONArray.put(strArr[i2]);
                        }
                        i2++;
                    }
                    this.f19418k.put(str, jSONArray);
                    return;
                }
                if (obj instanceof long[]) {
                    long[] jArr = (long[]) obj;
                    JSONArray jSONArray2 = new JSONArray();
                    while (i2 < jArr.length) {
                        jSONArray2.put(jArr[i2]);
                        i2++;
                    }
                    this.f19418k.put(str, jSONArray2);
                    return;
                }
                if (obj instanceof int[]) {
                    int[] iArr = (int[]) obj;
                    JSONArray jSONArray3 = new JSONArray();
                    while (i2 < iArr.length) {
                        jSONArray3.put(iArr[i2]);
                        i2++;
                    }
                    this.f19418k.put(str, jSONArray3);
                    return;
                }
                if (obj instanceof float[]) {
                    float[] fArr = (float[]) obj;
                    JSONArray jSONArray4 = new JSONArray();
                    while (i2 < fArr.length) {
                        jSONArray4.put(fArr[i2]);
                        i2++;
                    }
                    this.f19418k.put(str, jSONArray4);
                    return;
                }
                if (obj instanceof double[]) {
                    double[] dArr = (double[]) obj;
                    JSONArray jSONArray5 = new JSONArray();
                    while (i2 < dArr.length) {
                        jSONArray5.put(dArr[i2]);
                        i2++;
                    }
                    this.f19418k.put(str, jSONArray5);
                    return;
                }
                if (obj instanceof short[]) {
                    short[] sArr = (short[]) obj;
                    JSONArray jSONArray6 = new JSONArray();
                    while (i2 < sArr.length) {
                        jSONArray6.put((int) sArr[i2]);
                        i2++;
                    }
                    this.f19418k.put(str, jSONArray6);
                    return;
                }
                return;
            }
            if (obj instanceof List) {
                List list = (List) obj;
                JSONArray jSONArray7 = new JSONArray();
                while (i2 < list.size()) {
                    Object obj2 = list.get(i2);
                    if ((obj2 instanceof String) || (obj2 instanceof Long) || (obj2 instanceof Integer) || (obj2 instanceof Float) || (obj2 instanceof Double) || (obj2 instanceof Short)) {
                        jSONArray7.put(list.get(i2));
                    }
                    i2++;
                }
                this.f19418k.put(str, jSONArray7);
                return;
            }
            if ((obj instanceof String) || (obj instanceof Long) || (obj instanceof Integer) || (obj instanceof Float) || (obj instanceof Double) || (obj instanceof Short)) {
                this.f19418k.put(str, obj);
            }
        } catch (Throwable unused) {
        }
    }

    public synchronized void a(Object obj) {
        if (a == null) {
            return;
        }
        if (!UMUtils.isMainProgress(a)) {
            MLog.e("registerSuperPropertyByCoreProtocol can not be called in child process");
            return;
        }
        if (obj != null) {
            String str = (String) obj;
            SharedPreferences.Editor editorEdit = PreferenceWrapper.getDefault(a).edit();
            if (editorEdit != null && !TextUtils.isEmpty(str)) {
                editorEdit.putString(f19401h, this.f19418k.toString()).commit();
            }
        }
    }

    public synchronized void a(Context context, List<String> list) {
        try {
        } catch (Throwable th) {
            MLog.e(th);
        }
        if (context == null) {
            UMLog.aq(j.aj, 0, "\\|");
            return;
        }
        if (a == null) {
            a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(a)) {
            MLog.e("setFirstLaunchEvent can not be called in child process");
            return;
        }
        if (!this.f19417j || !this.f19421n) {
            a(a);
        }
        s.a(a).a(list);
    }

    public synchronized void a(Context context, JSONObject jSONObject) {
        if (context == null) {
            UMLog.aq(j.al, 0, "\\|");
            return;
        }
        if (a == null) {
            a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(a)) {
            MLog.e("registerPreProperties can not be called in child process");
            return;
        }
        if (!this.f19417j || !this.f19421n) {
            a(a);
        }
        if (this.f19420m == null) {
            this.f19420m = new JSONObject();
        }
        if (jSONObject != null && jSONObject.length() > 0) {
            JSONObject jSONObject2 = null;
            try {
                jSONObject2 = new JSONObject(this.f19420m.toString());
            } catch (Exception unused) {
            }
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            Iterator<String> itKeys = jSONObject.keys();
            if (itKeys != null) {
                while (itKeys.hasNext()) {
                    try {
                        String string = itKeys.next().toString();
                        Object obj = jSONObject.get(string);
                        if (b(string, obj)) {
                            jSONObject2.put(string, obj);
                            if (jSONObject2.length() > 10) {
                                MLog.e("please check propertics, size overlength!");
                                return;
                            }
                            continue;
                        } else {
                            return;
                        }
                    } catch (Exception unused2) {
                    }
                }
            }
            this.f19420m = jSONObject2;
            if (this.f19420m.length() > 0) {
                UMWorkDispatch.sendEvent(a, o.a.f19785v, CoreProtocol.getInstance(a), this.f19420m.toString());
            }
            return;
        }
        UMLog.aq(j.am, 0, "\\|");
    }
}
