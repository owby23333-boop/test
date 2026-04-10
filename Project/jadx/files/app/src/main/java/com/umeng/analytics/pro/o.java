package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.process.UMProcessDBHelper;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.common.ReportPolicy;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.statistics.internal.StatTracer;
import com.umeng.commonsdk.statistics.noise.ABTest;
import com.umeng.commonsdk.statistics.noise.Defcon;
import com.umeng.commonsdk.utils.JSONArraySortUtil;
import com.umeng.commonsdk.utils.UMUtils;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: CoreProtocolImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class o {
    private static Context a = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f19742l = "first_activate_time";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String f19743m = "ana_is_f";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String f19744n = "thtstart";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final String f19745o = "dstk_last_time";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final String f19746p = "dstk_cnt";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final String f19747q = "gkvc";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final String f19748r = "ekvc";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final String f19749t = "-1";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final String f19750x = "com.umeng.umcrash.UMCrashUtils";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static Class<?> f19751y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static Method f19752z;
    private c b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private SharedPreferences f19753c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f19754d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f19755e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f19756f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private JSONArray f19757g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f19758h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f19759i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f19760j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f19761k;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final long f19762s;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f19763u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f19764v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private Object f19765w;

    /* JADX INFO: compiled from: CoreProtocolImpl.java */
    public static class a {
        public static final int A = 8210;
        public static final int B = 8211;
        public static final int C = 8212;
        public static final int D = 8213;
        public static final int E = 8214;
        public static final int F = 8215;
        public static final int a = 4097;
        public static final int b = 4098;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f19766c = 4099;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f19767d = 4100;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f19768e = 4101;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f19769f = 4102;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f19770g = 4103;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int f19771h = 4104;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f19772i = 4105;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final int f19773j = 4106;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final int f19774k = 4352;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final int f19775l = 4353;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final int f19776m = 4354;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final int f19777n = 4355;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final int f19778o = 4356;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final int f19779p = 4357;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final int f19780q = 8193;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final int f19781r = 8194;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final int f19782s = 8195;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public static final int f19783t = 8196;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public static final int f19784u = 8197;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public static final int f19785v = 8199;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public static final int f19786w = 8200;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public static final int f19787x = 8201;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public static final int f19788y = 8208;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public static final int f19789z = 8209;
    }

    /* JADX INFO: compiled from: CoreProtocolImpl.java */
    private static class b {
        private static final o a = new o();

        private b() {
        }
    }

    static {
        h();
    }

    public static o a(Context context) {
        if (a == null && context != null) {
            a = context.getApplicationContext();
        }
        return b.a;
    }

    private void b(JSONObject jSONObject) {
        JSONObject jSONObjectF;
        if (i.a(UMGlobalContext.getAppContext(a)).c() || (jSONObjectF = i.a(UMGlobalContext.getAppContext(a)).f()) == null) {
            return;
        }
        String strOptString = jSONObjectF.optString("__av");
        String strOptString2 = jSONObjectF.optString("__vc");
        try {
            if (TextUtils.isEmpty(strOptString)) {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("app_version"), UMUtils.getAppVersionName(a));
            } else {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("app_version"), strOptString);
            }
            if (TextUtils.isEmpty(strOptString2)) {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("version_code"), UMUtils.getAppVersionCode(a));
            } else {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("version_code"), strOptString2);
            }
        } catch (Throwable unused) {
        }
    }

    private void e(Object obj) {
        try {
            JSONObject jSONObject = (JSONObject) obj;
            if (2050 == jSONObject.getInt("__t")) {
                if (!a(this.f19761k, this.f19759i)) {
                    return;
                } else {
                    this.f19759i++;
                }
            } else if (2049 == jSONObject.getInt("__t")) {
                if (!a(this.f19761k, this.f19760j)) {
                    return;
                } else {
                    this.f19760j++;
                }
            }
            if (AnalyticsConfig.isRealTimeDebugMode()) {
                if (this.f19757g == null) {
                    this.f19757g = new JSONArray();
                }
                this.f19757g.put(jSONObject);
                i.a(a).a(this.f19757g);
                this.f19757g = new JSONArray();
                return;
            }
            if (this.f19757g.length() >= this.f19756f) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>*** 超过10个事件，事件落库。");
                i.a(a).a(this.f19757g);
                this.f19757g = new JSONArray();
            }
            if (this.f19761k == 0) {
                this.f19761k = System.currentTimeMillis();
            }
            this.f19757g.put(jSONObject);
        } catch (Throwable th) {
            MLog.e(th);
        }
    }

    private void f(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        try {
            if (!jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("header")).has(com.umeng.analytics.pro.d.aB)) {
                if (jSONObject.has("content")) {
                    jSONObject = jSONObject.getJSONObject("content");
                }
                if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("analytics")) && (jSONObjectOptJSONObject = jSONObject.optJSONObject(com.umeng.commonsdk.statistics.b.a("analytics"))) != null && jSONObjectOptJSONObject.length() > 0 && jSONObjectOptJSONObject.has(com.umeng.analytics.pro.d.f19623n)) {
                    i.a(a).a(true, false);
                }
                i.a(a).b();
                return;
            }
            if (jSONObject.has("content")) {
                jSONObject = jSONObject.getJSONObject("content");
            }
            if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("analytics"))) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("analytics"));
                if (jSONObject2.has(com.umeng.analytics.pro.d.f19623n) && (jSONObjectOptJSONObject2 = jSONObject2.getJSONArray(com.umeng.analytics.pro.d.f19623n).optJSONObject(0)) != null) {
                    String strOptString = jSONObjectOptJSONObject2.optString("id");
                    if (!TextUtils.isEmpty(strOptString)) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> removeAllInstantData: really delete instant session data");
                        i.a(a).b(strOptString);
                    }
                }
            }
            i.a(a).b();
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> removeAllInstantData: send INSTANT_SESSION_START_CONTINUE event because OVERSIZE.");
            UMWorkDispatch.sendEvent(a, a.f19775l, CoreProtocol.getInstance(a), null);
        } catch (Exception unused) {
        }
    }

    private static void h() {
        try {
            Class<?> cls = Class.forName(f19750x);
            if (cls != null) {
                f19751y = cls;
                Method declaredMethod = f19751y.getDeclaredMethod("setPuidAndProvider", String.class, String.class);
                if (declaredMethod != null) {
                    f19752z = declaredMethod;
                }
            }
        } catch (Throwable unused) {
        }
    }

    private void i() {
        JSONObject jSONObjectB = b(UMEnvelopeBuild.maxDataSpace(a));
        if (jSONObjectB == null || jSONObjectB.length() < 1) {
            return;
        }
        JSONObject jSONObject = (JSONObject) jSONObjectB.opt("header");
        JSONObject jSONObject2 = (JSONObject) jSONObjectB.opt("content");
        if (a == null || jSONObject == null || jSONObject2 == null) {
            return;
        }
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> constructInstantMessage: request build envelope.");
        JSONObject jSONObjectBuildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(a, jSONObject, jSONObject2);
        if (jSONObjectBuildEnvelopeWithExtHeader != null) {
            try {
                if (jSONObjectBuildEnvelopeWithExtHeader.has("exception")) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "Build envelope error code: " + jSONObjectBuildEnvelopeWithExtHeader.getInt("exception"));
                }
            } catch (Throwable unused) {
            }
            if (UMConfigure.isDebugLog()) {
                e(jSONObjectBuildEnvelopeWithExtHeader);
            }
            b((Object) jSONObjectBuildEnvelopeWithExtHeader);
        }
    }

    private void j() {
        JSONObject jSONObjectBuildEnvelopeWithExtHeader;
        JSONObject jSONObjectA = a(UMEnvelopeBuild.maxDataSpace(a));
        if (jSONObjectA == null || jSONObjectA.length() < 1) {
            return;
        }
        JSONObject jSONObject = (JSONObject) jSONObjectA.opt("header");
        JSONObject jSONObject2 = (JSONObject) jSONObjectA.opt("content");
        Context context = a;
        if (context == null || jSONObject == null || jSONObject2 == null || (jSONObjectBuildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(context, jSONObject, jSONObject2)) == null) {
            return;
        }
        try {
            if (jSONObjectBuildEnvelopeWithExtHeader.has("exception")) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "Build envelope error code: " + jSONObjectBuildEnvelopeWithExtHeader.getInt("exception"));
            }
        } catch (Throwable unused) {
        }
        if (UMConfigure.isDebugLog()) {
            d(jSONObjectBuildEnvelopeWithExtHeader);
        }
        a((Object) jSONObjectBuildEnvelopeWithExtHeader);
    }

    private JSONObject k() {
        JSONObject jSONObjectL = l();
        if (jSONObjectL != null) {
            try {
                jSONObjectL.put("st", "1");
            } catch (Throwable unused) {
            }
        }
        return jSONObjectL;
    }

    private JSONObject l() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (AnalyticsConfig.mWrapperType != null && AnalyticsConfig.mWrapperVersion != null) {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("wrapper_version"), AnalyticsConfig.mWrapperVersion);
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("wrapper_type"), AnalyticsConfig.mWrapperType);
            }
            int verticalType = AnalyticsConfig.getVerticalType(a);
            jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.d.f19618i), verticalType);
            if (verticalType == 1) {
                String gameSdkVersion = AnalyticsConfig.getGameSdkVersion(a);
                if (TextUtils.isEmpty(gameSdkVersion)) {
                    gameSdkVersion = "9.5.2";
                }
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("sdk_version"), gameSdkVersion);
            } else {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("sdk_version"), "9.5.2");
            }
            String strMD5 = HelperUtils.MD5(AnalyticsConfig.getSecretKey(a));
            if (!TextUtils.isEmpty(strMD5)) {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("secret"), strMD5);
            }
            String strImprintProperty = UMEnvelopeBuild.imprintProperty(a, "pr_ve", null);
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(a);
            String strImprintProperty2 = UMEnvelopeBuild.imprintProperty(a, com.umeng.analytics.pro.d.an, "");
            if (!TextUtils.isEmpty(strImprintProperty2)) {
                if (AnalyticsConfig.CLEAR_EKV_BL) {
                    jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.d.ap), "");
                } else {
                    jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.d.ap), strImprintProperty2);
                }
            }
            String strImprintProperty3 = UMEnvelopeBuild.imprintProperty(a, com.umeng.analytics.pro.d.ao, "");
            if (!TextUtils.isEmpty(strImprintProperty3)) {
                if (AnalyticsConfig.CLEAR_EKV_WL) {
                    jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.d.aq), "");
                } else {
                    jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.d.aq), strImprintProperty3);
                }
            }
            jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.d.ah), "1.0.0");
            if (s()) {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.d.aj), "1");
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putLong(f19743m, 0L).commit();
                }
            }
            jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.d.f19621l), m());
            jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.d.f19622m), n());
            if (sharedPreferences != null) {
                String string = sharedPreferences.getString("vers_name", "");
                if (!TextUtils.isEmpty(string)) {
                    String str = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
                    if (TextUtils.isEmpty(strImprintProperty)) {
                        jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.d.f19621l), sharedPreferences.getString("vers_pre_version", "0"));
                        jSONObject.put(com.umeng.commonsdk.statistics.b.a(com.umeng.analytics.pro.d.f19622m), sharedPreferences.getString("vers_date", str));
                    }
                    sharedPreferences.edit().putString("pre_version", string).putString("cur_version", DeviceConfig.getAppVersionName(a)).putString("pre_date", str).remove("vers_name").remove("vers_code").remove("vers_date").remove("vers_pre_version").commit();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    private String m() {
        String string;
        String strImprintProperty = null;
        try {
            strImprintProperty = UMEnvelopeBuild.imprintProperty(a, "pr_ve", null);
        } catch (Throwable unused) {
        }
        if (!TextUtils.isEmpty(strImprintProperty)) {
            string = strImprintProperty;
        } else {
            if (!TextUtils.isEmpty(this.f19754d)) {
                return this.f19754d;
            }
            if (this.f19753c == null) {
                this.f19753c = PreferenceWrapper.getDefault(a);
            }
            String string2 = this.f19753c.getString("pre_version", "");
            String appVersionName = DeviceConfig.getAppVersionName(a);
            if (TextUtils.isEmpty(string2)) {
                this.f19753c.edit().putString("pre_version", "0").putString("cur_version", appVersionName).commit();
                string = "0";
            } else {
                string = this.f19753c.getString("cur_version", "");
                if (appVersionName.equals(string)) {
                    string = string2;
                } else {
                    this.f19753c.edit().putString("pre_version", string).putString("cur_version", appVersionName).commit();
                }
            }
        }
        this.f19754d = string;
        return string;
    }

    private String n() {
        String string;
        String strImprintProperty = null;
        try {
            strImprintProperty = UMEnvelopeBuild.imprintProperty(a, "ud_da", null);
        } catch (Throwable unused) {
        }
        if (!TextUtils.isEmpty(strImprintProperty)) {
            string = strImprintProperty;
        } else {
            if (!TextUtils.isEmpty(this.f19755e)) {
                return this.f19755e;
            }
            if (this.f19753c == null) {
                this.f19753c = PreferenceWrapper.getDefault(a);
            }
            string = this.f19753c.getString("pre_date", "");
            if (TextUtils.isEmpty(string)) {
                string = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
                this.f19753c.edit().putString("pre_date", string).commit();
            } else {
                String str = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
                if (!string.equals(str)) {
                    this.f19753c.edit().putString("pre_date", str).commit();
                    string = str;
                }
            }
        }
        this.f19755e = string;
        return string;
    }

    private void o() {
        try {
            this.f19759i = 0;
            this.f19760j = 0;
            this.f19761k = System.currentTimeMillis();
            PreferenceWrapper.getDefault(a).edit().putLong(f19745o, System.currentTimeMillis()).putInt(f19746p, 0).commit();
        } catch (Throwable unused) {
        }
    }

    private boolean p() {
        try {
            if (!TextUtils.isEmpty(u.a().b())) {
                b(a);
            }
            if (this.f19757g.length() <= 0) {
                return false;
            }
            for (int i2 = 0; i2 < this.f19757g.length(); i2++) {
                JSONObject jSONObjectOptJSONObject = this.f19757g.optJSONObject(i2);
                if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.length() > 0) {
                    String strOptString = jSONObjectOptJSONObject.optString("__i");
                    if (TextUtils.isEmpty(strOptString) || "-1".equals(strOptString)) {
                        return false;
                    }
                }
            }
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }

    private void q() {
        if (this.f19757g.length() > 0) {
            JSONArray jSONArray = new JSONArray();
            for (int i2 = 0; i2 < this.f19757g.length(); i2++) {
                try {
                    JSONObject jSONObject = this.f19757g.getJSONObject(i2);
                    if (jSONObject == null || jSONObject.length() <= 0) {
                        jSONArray.put(jSONObject);
                    } else {
                        String strOptString = jSONObject.optString("__i");
                        if (TextUtils.isEmpty(strOptString) || "-1".equals(strOptString)) {
                            String strB = u.a().b();
                            if (TextUtils.isEmpty(strB)) {
                                strB = "-1";
                            }
                            jSONObject.put("__i", strB);
                        }
                        jSONArray.put(jSONObject);
                    }
                } catch (Throwable unused) {
                }
            }
            this.f19757g = jSONArray;
        }
    }

    private void r() {
        SharedPreferences sharedPreferences;
        try {
            if (!s() || a == null || (sharedPreferences = PreferenceWrapper.getDefault(a)) == null || sharedPreferences.getLong(f19742l, 0L) != 0) {
                return;
            }
            sharedPreferences.edit().putLong(f19742l, System.currentTimeMillis()).commit();
        } catch (Throwable unused) {
        }
    }

    private boolean s() {
        SharedPreferences sharedPreferences;
        try {
            if (a == null || (sharedPreferences = PreferenceWrapper.getDefault(a)) == null) {
                return false;
            }
            return sharedPreferences.getLong(f19743m, -1L) != 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    public void b() {
    }

    public void c() {
        b(a);
        d();
        a(true);
    }

    public void d() {
        try {
            if (this.f19757g.length() > 0) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>*** flushMemoryData: 事件落库。");
                i.a(a).a(this.f19757g);
                this.f19757g = new JSONArray();
            }
            PreferenceWrapper.getDefault(a).edit().putLong(f19744n, this.f19761k).putInt(f19747q, this.f19759i).putInt(f19748r, this.f19760j).commit();
        } catch (Throwable unused) {
        }
    }

    private o() {
        this.b = null;
        this.f19753c = null;
        this.f19754d = null;
        this.f19755e = null;
        this.f19756f = 10;
        this.f19757g = new JSONArray();
        this.f19758h = 5000;
        this.f19759i = 0;
        this.f19760j = 0;
        this.f19761k = 0L;
        this.f19762s = 28800000L;
        this.f19763u = false;
        this.f19764v = false;
        this.f19765w = new Object();
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(a);
            this.f19761k = sharedPreferences.getLong(f19744n, 0L);
            this.f19759i = sharedPreferences.getInt(f19747q, 0);
            this.f19760j = sharedPreferences.getInt(f19748r, 0);
            this.b = new c();
        } catch (Throwable unused) {
        }
    }

    private void g(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        try {
            if (jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("header")).has(com.umeng.analytics.pro.d.aB)) {
                if (jSONObject.has("content")) {
                    jSONObject = jSONObject.getJSONObject("content");
                }
                if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("analytics"))) {
                    if (!jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("analytics")).has(com.umeng.analytics.pro.d.f19623n)) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> Error, Should not go to this branch.");
                        return;
                    }
                    i.a(a).i();
                    i.a(a).h();
                    i.a(a).b(true, false);
                    i.a(a).a();
                    return;
                }
                return;
            }
            if (jSONObject.has("content")) {
                jSONObject = jSONObject.getJSONObject("content");
            }
            if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("analytics")) && (jSONObjectOptJSONObject = jSONObject.optJSONObject(com.umeng.commonsdk.statistics.b.a("analytics"))) != null && jSONObjectOptJSONObject.length() > 0) {
                if (jSONObjectOptJSONObject.has(com.umeng.analytics.pro.d.f19623n)) {
                    i.a(a).b(true, false);
                }
                if (jSONObjectOptJSONObject.has("ekv") || jSONObjectOptJSONObject.has(com.umeng.analytics.pro.d.T)) {
                    i.a(a).h();
                }
                if (jSONObjectOptJSONObject.has("error")) {
                    i.a(a).i();
                }
            }
            i.a(a).a();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: compiled from: CoreProtocolImpl.java */
    public static class c {
        private ReportPolicy.ReportStrategy a = null;
        private int b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f19790c = -1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f19791d = -1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f19792e = -1;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private ABTest f19793f;

        public c() {
            this.f19793f = null;
            this.f19793f = ABTest.getService(o.a);
        }

        public void a() {
            try {
                int[] iArrA = a(-1, -1);
                this.b = iArrA[0];
                this.f19790c = iArrA[1];
            } catch (Throwable unused) {
            }
        }

        protected void b() {
            int iA;
            Defcon service = Defcon.getService(o.a);
            if (service.isOpen()) {
                ReportPolicy.ReportStrategy reportStrategy = this.a;
                this.a = (reportStrategy instanceof ReportPolicy.DefconPolicy) && reportStrategy.isValid() ? this.a : new ReportPolicy.DefconPolicy(StatTracer.getInstance(o.a), service);
            } else {
                boolean z2 = Integer.valueOf(UMEnvelopeBuild.imprintProperty(o.a, "integrated_test", "-1")).intValue() == 1;
                if (UMConfigure.isDebugLog() && z2 && !MLog.DEBUG) {
                    UMLog.mutlInfo(j.K, 3, "\\|", null, null);
                }
                if (MLog.DEBUG && z2) {
                    this.a = new ReportPolicy.DebugPolicy(StatTracer.getInstance(o.a));
                } else if (this.f19793f.isInTest() && "RPT".equals(this.f19793f.getTestName())) {
                    if (this.f19793f.getTestPolicy() == 6) {
                        if (Integer.valueOf(UMEnvelopeBuild.imprintProperty(o.a, "test_report_interval", "-1")).intValue() != -1) {
                            iA = a(com.anythink.expressad.foundation.g.a.bM);
                        } else {
                            iA = this.f19790c;
                            if (iA <= 0) {
                                iA = this.f19792e;
                            }
                        }
                    } else {
                        iA = 0;
                    }
                    this.a = b(this.f19793f.getTestPolicy(), iA);
                } else {
                    int i2 = this.f19791d;
                    int i3 = this.f19792e;
                    int i4 = this.b;
                    if (i4 != -1) {
                        i3 = this.f19790c;
                        i2 = i4;
                    }
                    this.a = b(i2, i3);
                }
            }
            if (UMConfigure.isDebugLog()) {
                try {
                    if (this.a instanceof ReportPolicy.ReportAtLaunch) {
                        UMLog.mutlInfo(j.I, 3, "", null, null);
                    } else if (this.a instanceof ReportPolicy.ReportByInterval) {
                        UMLog.mutlInfo(j.J, 3, "", new String[]{"@"}, new String[]{String.valueOf(((ReportPolicy.ReportByInterval) this.a).getReportInterval() / 1000)});
                    } else if (this.a instanceof ReportPolicy.DebugPolicy) {
                        UMLog.mutlInfo(j.L, 3, "", null, null);
                    } else if (this.a instanceof ReportPolicy.ReportQuasiRealtime) {
                        String[] strArr = {String.valueOf(((ReportPolicy.ReportQuasiRealtime) this.a).getReportInterval() / 1000)};
                        UMLog uMLog = UMConfigure.umDebugLog;
                        UMLog.mutlInfo(j.M, 3, "", new String[]{"@"}, strArr);
                    } else {
                        boolean z3 = this.a instanceof ReportPolicy.DefconPolicy;
                    }
                } catch (Throwable unused) {
                }
            }
        }

        public ReportPolicy.ReportStrategy c() {
            b();
            return this.a;
        }

        public int[] a(int i2, int i3) {
            int iIntValue = Integer.valueOf(UMEnvelopeBuild.imprintProperty(o.a, "report_policy", "-1")).intValue();
            int iIntValue2 = Integer.valueOf(UMEnvelopeBuild.imprintProperty(o.a, "report_interval", "-1")).intValue();
            if (iIntValue == -1 || !ReportPolicy.isValid(iIntValue)) {
                return new int[]{i2, i3};
            }
            if (6 == iIntValue) {
                int i4 = 90;
                if (iIntValue2 != -1 && iIntValue2 >= 90 && iIntValue2 <= 86400) {
                    i4 = iIntValue2;
                }
                return new int[]{iIntValue, i4 * 1000};
            }
            if (11 != iIntValue) {
                return new int[]{i2, i3};
            }
            int i5 = 15;
            if (iIntValue2 != -1 && iIntValue2 >= 15 && iIntValue2 <= 3600) {
                i5 = iIntValue2;
            }
            return new int[]{iIntValue, i5 * 1000};
        }

        public int a(int i2) {
            int iIntValue = Integer.valueOf(UMEnvelopeBuild.imprintProperty(o.a, "test_report_interval", "-1")).intValue();
            return (iIntValue == -1 || iIntValue < 90 || iIntValue > 86400) ? i2 : iIntValue * 1000;
        }

        private ReportPolicy.ReportStrategy b(int i2, int i3) {
            if (i2 == 0) {
                ReportPolicy.ReportStrategy reportStrategy = this.a;
                return reportStrategy instanceof ReportPolicy.ReportRealtime ? reportStrategy : new ReportPolicy.ReportRealtime();
            }
            if (i2 == 1) {
                ReportPolicy.ReportStrategy reportStrategy2 = this.a;
                return reportStrategy2 instanceof ReportPolicy.ReportAtLaunch ? reportStrategy2 : new ReportPolicy.ReportAtLaunch();
            }
            if (i2 == 4) {
                ReportPolicy.ReportStrategy reportStrategy3 = this.a;
                return reportStrategy3 instanceof ReportPolicy.ReportDaily ? reportStrategy3 : new ReportPolicy.ReportDaily(StatTracer.getInstance(o.a));
            }
            if (i2 == 5) {
                ReportPolicy.ReportStrategy reportStrategy4 = this.a;
                return reportStrategy4 instanceof ReportPolicy.ReportWifiOnly ? reportStrategy4 : new ReportPolicy.ReportWifiOnly(o.a);
            }
            if (i2 == 6) {
                ReportPolicy.ReportStrategy reportStrategy5 = this.a;
                if (reportStrategy5 instanceof ReportPolicy.ReportByInterval) {
                    ((ReportPolicy.ReportByInterval) reportStrategy5).setReportInterval(i3);
                    return reportStrategy5;
                }
                return new ReportPolicy.ReportByInterval(StatTracer.getInstance(o.a), i3);
            }
            if (i2 == 8) {
                ReportPolicy.ReportStrategy reportStrategy6 = this.a;
                return reportStrategy6 instanceof ReportPolicy.SmartPolicy ? reportStrategy6 : new ReportPolicy.SmartPolicy(StatTracer.getInstance(o.a));
            }
            if (i2 != 11) {
                ReportPolicy.ReportStrategy reportStrategy7 = this.a;
                return reportStrategy7 instanceof ReportPolicy.ReportAtLaunch ? reportStrategy7 : new ReportPolicy.ReportAtLaunch();
            }
            ReportPolicy.ReportStrategy reportStrategy8 = this.a;
            if (reportStrategy8 instanceof ReportPolicy.ReportQuasiRealtime) {
                ((ReportPolicy.ReportQuasiRealtime) reportStrategy8).setReportInterval(i3);
                return reportStrategy8;
            }
            ReportPolicy.ReportQuasiRealtime reportQuasiRealtime = new ReportPolicy.ReportQuasiRealtime();
            reportQuasiRealtime.setReportInterval(i3);
            return reportQuasiRealtime;
        }
    }

    private void c(JSONObject jSONObject) {
        try {
            if (!i.a(a).e()) {
                JSONObject jSONObjectG = i.a(a).g();
                if (jSONObjectG != null) {
                    String strOptString = jSONObjectG.optString("__av");
                    String strOptString2 = jSONObjectG.optString("__vc");
                    if (TextUtils.isEmpty(strOptString)) {
                        jSONObject.put(com.umeng.commonsdk.statistics.b.a("app_version"), UMUtils.getAppVersionName(a));
                    } else {
                        jSONObject.put(com.umeng.commonsdk.statistics.b.a("app_version"), strOptString);
                    }
                    if (TextUtils.isEmpty(strOptString2)) {
                        jSONObject.put(com.umeng.commonsdk.statistics.b.a("version_code"), UMUtils.getAppVersionCode(a));
                        return;
                    } else {
                        jSONObject.put(com.umeng.commonsdk.statistics.b.a("version_code"), strOptString2);
                        return;
                    }
                }
                return;
            }
            jSONObject.put(com.umeng.commonsdk.statistics.b.a("app_version"), UMUtils.getAppVersionName(a));
            jSONObject.put(com.umeng.commonsdk.statistics.b.a("version_code"), UMUtils.getAppVersionCode(a));
        } catch (Throwable unused) {
        }
    }

    public void a() {
        if (a != null) {
            synchronized (this.f19765w) {
                if (this.f19763u) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> network is now available, rebuild instant session data packet.");
                    UMWorkDispatch.sendEvent(a, a.f19775l, CoreProtocol.getInstance(a), null);
                }
            }
            synchronized (this.f19765w) {
                if (this.f19764v) {
                    UMWorkDispatch.sendEvent(a, a.f19776m, CoreProtocol.getInstance(a), null);
                }
            }
        }
    }

    /* JADX INFO: compiled from: CoreProtocolImpl.java */
    public static class d {
        private Map<String, Object> a;
        private String b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f19794c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f19795d;

        private d() {
            this.a = null;
            this.b = null;
            this.f19794c = null;
            this.f19795d = 0L;
        }

        public Map<String, Object> a() {
            return this.a;
        }

        public String b() {
            return this.f19794c;
        }

        public String c() {
            return this.b;
        }

        public long d() {
            return this.f19795d;
        }

        public d(String str, Map<String, Object> map, String str2, long j2) {
            this.a = null;
            this.b = null;
            this.f19794c = null;
            this.f19795d = 0L;
            this.a = map;
            this.b = str;
            this.f19795d = j2;
            this.f19794c = str2;
        }
    }

    private void h(Object obj) {
        try {
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject == null || jSONObject.length() <= 0 || !jSONObject.has("__ii")) {
                return;
            }
            String strOptString = jSONObject.optString("__ii");
            jSONObject.remove("__ii");
            if (TextUtils.isEmpty(strOptString)) {
                return;
            }
            i.a(a).a(strOptString, obj.toString(), 2);
        } catch (Throwable unused) {
        }
    }

    private void d(JSONObject jSONObject) {
        JSONObject jSONObject2;
        JSONArray jSONArray;
        if (jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.length() <= 0) {
                return;
            }
            JSONObject jSONObject3 = new JSONObject();
            if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("analytics"))) {
                JSONObject jSONObject4 = jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("analytics"));
                if (jSONObject4.has("ekv")) {
                    jSONObject3.put("ekv", jSONObject4.getJSONArray("ekv"));
                    if (jSONObject3.length() > 0) {
                        if (AnalyticsConfig.isRealTimeDebugMode()) {
                            MLog.d("[埋点验证模式]事件:" + jSONObject3.toString());
                        } else {
                            MLog.d("事件:" + jSONObject3.toString());
                        }
                        jSONObject3 = new JSONObject();
                    }
                }
                if (jSONObject4.has(com.umeng.analytics.pro.d.T)) {
                    jSONObject3.put(com.umeng.analytics.pro.d.T, jSONObject4.getJSONArray(com.umeng.analytics.pro.d.T));
                    if (jSONObject3.length() > 0) {
                        if (AnalyticsConfig.isRealTimeDebugMode()) {
                            MLog.d("[埋点验证模式]游戏事件:" + jSONObject3.toString());
                        } else {
                            MLog.d("游戏事件:" + jSONObject3.toString());
                        }
                        jSONObject3 = new JSONObject();
                    }
                }
                if (jSONObject4.has("error")) {
                    jSONObject3.put("error", jSONObject4.getJSONArray("error"));
                    if (jSONObject3.length() > 0) {
                        if (AnalyticsConfig.isRealTimeDebugMode()) {
                            MLog.d("[埋点验证模式]错误:" + jSONObject3.toString());
                        } else {
                            MLog.d("错误:" + jSONObject3.toString());
                        }
                        jSONObject3 = new JSONObject();
                    }
                }
                if (jSONObject4.has(com.umeng.analytics.pro.d.f19623n)) {
                    JSONArray jSONArray2 = jSONObject4.getJSONArray(com.umeng.analytics.pro.d.f19623n);
                    JSONArray jSONArray3 = new JSONArray();
                    int i2 = 0;
                    while (i2 < jSONArray2.length()) {
                        JSONObject jSONObject5 = jSONArray2.getJSONObject(i2);
                        if (jSONObject5 == null || jSONObject5.length() <= 0) {
                            jSONArray = jSONArray2;
                        } else {
                            jSONArray = jSONArray2;
                            if (jSONObject5.has(com.umeng.analytics.pro.d.f19630u)) {
                                jSONObject5.remove(com.umeng.analytics.pro.d.f19630u);
                            }
                            jSONArray3.put(jSONObject5);
                        }
                        i2++;
                        jSONArray2 = jSONArray;
                    }
                    jSONObject3.put(com.umeng.analytics.pro.d.f19623n, jSONArray3);
                    if (jSONObject3.length() > 0) {
                        if (AnalyticsConfig.isRealTimeDebugMode()) {
                            MLog.d("[埋点验证模式]会话:" + jSONObject3.toString());
                        } else {
                            MLog.d("会话:" + jSONObject3.toString());
                        }
                        jSONObject3 = new JSONObject();
                    }
                }
                if (jSONObject4.has(com.umeng.analytics.pro.d.I)) {
                    jSONObject3.put(com.umeng.analytics.pro.d.I, jSONObject4.getJSONObject(com.umeng.analytics.pro.d.I));
                }
                if (jSONObject4.has(com.umeng.analytics.pro.d.L)) {
                    jSONObject3.put(com.umeng.analytics.pro.d.L, jSONObject4.getJSONObject(com.umeng.analytics.pro.d.L));
                    if (jSONObject3.length() > 0) {
                        if (AnalyticsConfig.isRealTimeDebugMode()) {
                            MLog.d("[埋点验证模式]账号:" + jSONObject3.toString());
                        } else {
                            MLog.d("账号:" + jSONObject3.toString());
                        }
                        jSONObject3 = new JSONObject();
                    }
                }
            }
            if (jSONObject.has("dplus")) {
                jSONObject3.put("dplus", jSONObject.getJSONObject("dplus"));
            }
            if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("header")) && (jSONObject2 = jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("header"))) != null && jSONObject2.length() > 0) {
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("sdk_version"))) {
                    jSONObject3.put("sdk_version", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("sdk_version")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("device_id"))) {
                    jSONObject3.put("device_id", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("device_id")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("device_model"))) {
                    jSONObject3.put("device_model", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("device_model")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("version_code"))) {
                    jSONObject3.put("version", jSONObject2.getInt(com.umeng.commonsdk.statistics.b.a("version_code")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("appkey"))) {
                    jSONObject3.put("appkey", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("appkey")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("channel"))) {
                    jSONObject3.put("channel", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("channel")));
                }
                if (jSONObject3.length() > 0) {
                    MLog.d("基础信息:" + jSONObject3.toString());
                    jSONObject3 = new JSONObject();
                }
            }
            jSONObject3.length();
        } catch (Throwable th) {
            MLog.e(th);
        }
    }

    public JSONObject b(long j2) {
        if (TextUtils.isEmpty(y.a().d(UMGlobalContext.getAppContext(a)))) {
            return null;
        }
        JSONObject jSONObjectB = i.a(UMGlobalContext.getAppContext(a)).b(false);
        String[] strArrA = com.umeng.analytics.c.a(a);
        if (strArrA != null && !TextUtils.isEmpty(strArrA[0]) && !TextUtils.isEmpty(strArrA[1])) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(com.umeng.analytics.pro.d.M, strArrA[0]);
                jSONObject.put(com.umeng.analytics.pro.d.N, strArrA[1]);
                if (jSONObject.length() > 0) {
                    jSONObjectB.put(com.umeng.analytics.pro.d.L, jSONObject);
                }
            } catch (Throwable unused) {
            }
        }
        int iA = r.a().a(a);
        if (jSONObjectB.length() == 1 && jSONObjectB.optJSONObject(com.umeng.analytics.pro.d.L) != null && iA != 3) {
            return null;
        }
        r.a().b(jSONObjectB, a);
        if (jSONObjectB.length() <= 0 && iA != 3) {
            return null;
        }
        JSONObject jSONObjectK = k();
        if (jSONObjectK != null) {
            b(jSONObjectK);
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            if (iA == 3) {
                jSONObject3.put("analytics", new JSONObject());
            } else if (jSONObjectB != null && jSONObjectB.length() > 0) {
                jSONObject3.put("analytics", jSONObjectB);
            }
            if (jSONObjectK != null && jSONObjectK.length() > 0) {
                jSONObject2.put("header", jSONObjectK);
            }
            if (jSONObject3.length() > 0) {
                jSONObject2.put("content", jSONObject3);
            }
            return b(jSONObject2, j2);
        } catch (Throwable unused2) {
            return jSONObject2;
        }
    }

    private boolean c(boolean z2) {
        if (s() || AnalyticsConfig.isRealTimeDebugMode()) {
            return true;
        }
        if (this.b == null) {
            this.b = new c();
        }
        this.b.a();
        ReportPolicy.ReportStrategy reportStrategyC = this.b.c();
        boolean zShouldSendMessage = reportStrategyC.shouldSendMessage(z2);
        if (zShouldSendMessage) {
            if (((reportStrategyC instanceof ReportPolicy.ReportByInterval) || (reportStrategyC instanceof ReportPolicy.DebugPolicy) || (reportStrategyC instanceof ReportPolicy.ReportQuasiRealtime)) && p()) {
                d();
            }
            if ((reportStrategyC instanceof ReportPolicy.DefconPolicy) && p()) {
                d();
            }
            if (UMConfigure.isDebugLog()) {
                MLog.d("数据发送策略 : " + reportStrategyC.getClass().getSimpleName());
            }
        }
        return zShouldSendMessage;
    }

    private void a(String str, String str2) {
        Method method;
        Class<?> cls = f19751y;
        if (cls == null || (method = f19752z) == null) {
            return;
        }
        try {
            method.invoke(cls, str, str2);
        } catch (Throwable unused) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> reflect call setPuidAndProvider method of crash lib failed.");
        }
    }

    private void e(JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.length() <= 0) {
                return;
            }
            JSONObject jSONObject3 = new JSONObject();
            if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("analytics"))) {
                JSONObject jSONObject4 = jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("analytics"));
                if (jSONObject4.has(com.umeng.analytics.pro.d.f19623n)) {
                    JSONArray jSONArray = jSONObject4.getJSONArray(com.umeng.analytics.pro.d.f19623n);
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject jSONObject5 = jSONArray.getJSONObject(i2);
                        if (jSONObject5 != null && jSONObject5.length() > 0) {
                            jSONArray2.put(jSONObject5);
                        }
                    }
                    jSONObject3.put(com.umeng.analytics.pro.d.f19623n, jSONArray2);
                    if (jSONObject3.length() > 0) {
                        MLog.d("本次启动会话:" + jSONObject3.toString());
                        jSONObject3 = new JSONObject();
                    }
                }
                if (jSONObject4.has(com.umeng.analytics.pro.d.L)) {
                    jSONObject3.put(com.umeng.analytics.pro.d.L, jSONObject4.getJSONObject(com.umeng.analytics.pro.d.L));
                    if (jSONObject3.length() > 0) {
                        MLog.d("本次启动账号:" + jSONObject3.toString());
                        jSONObject3 = new JSONObject();
                    }
                }
            }
            if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("header")) && jSONObject.has(com.umeng.commonsdk.statistics.b.a("header")) && (jSONObject2 = jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("header"))) != null && jSONObject2.length() > 0) {
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("sdk_version"))) {
                    jSONObject3.put("sdk_version", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("sdk_version")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("device_id"))) {
                    jSONObject3.put("device_id", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("device_id")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("device_model"))) {
                    jSONObject3.put("device_model", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("device_model")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("version_code"))) {
                    jSONObject3.put("version", jSONObject2.getInt(com.umeng.commonsdk.statistics.b.a("version_code")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("appkey"))) {
                    jSONObject3.put("appkey", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("appkey")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("channel"))) {
                    jSONObject3.put("channel", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("channel")));
                }
                if (jSONObject3.length() > 0) {
                    MLog.d("本次启动基础信息:" + jSONObject3.toString());
                    jSONObject3 = new JSONObject();
                }
            }
            jSONObject3.length();
        } catch (Throwable th) {
            MLog.e(th);
        }
    }

    public void a(Object obj, int i2) {
        if (com.umeng.commonsdk.utils.c.a()) {
            if (i2 != 4357) {
                return;
            }
            try {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> clean db in silent mode.");
                h.a(a);
                com.umeng.commonsdk.utils.c.c(a);
            } catch (Throwable unused) {
            }
        }
        if (AnalyticsConfig.enable) {
            try {
                switch (i2) {
                    case 4097:
                        if (UMUtils.isMainProgress(a)) {
                            if (obj != null) {
                                e(obj);
                            }
                            if ("-1".equals(((JSONObject) obj).optString("__i"))) {
                                return;
                            }
                            a(false);
                            return;
                        }
                        UMProcessDBHelper.getInstance(a).insertEventsInSubProcess(UMFrUtils.getSubProcessName(a), new JSONArray().put(obj));
                        return;
                    case 4098:
                        if (obj != null) {
                            e(obj);
                        }
                        if ("-1".equals(((JSONObject) obj).optString("__i"))) {
                            return;
                        }
                        a(false);
                        return;
                    case 4099:
                        v.a(a);
                        return;
                    case a.f19767d /* 4100 */:
                        l.c(a);
                        return;
                    case a.f19768e /* 4101 */:
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> PROFILE_SIGNIN");
                        a((Object) null, true);
                        g(obj);
                        return;
                    case a.f19769f /* 4102 */:
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> PROFILE_SIGNOFF");
                        a((Object) null, true);
                        f(obj);
                        return;
                    case a.f19770g /* 4103 */:
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> START_SESSION");
                        u.a().a(a, obj);
                        synchronized (this.f19765w) {
                            this.f19764v = true;
                            break;
                        }
                        return;
                    case a.f19771h /* 4104 */:
                        u.a().c(a, obj);
                        return;
                    case a.f19772i /* 4105 */:
                        d();
                        return;
                    case a.f19773j /* 4106 */:
                        h(obj);
                        return;
                    default:
                        switch (i2) {
                            case a.f19774k /* 4352 */:
                                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> INSTANT_SESSION_START");
                                u.a().b(a, obj);
                                synchronized (this.f19765w) {
                                    this.f19763u = true;
                                    break;
                                }
                                return;
                            case a.f19775l /* 4353 */:
                                a(obj, true);
                                return;
                            case a.f19776m /* 4354 */:
                                c();
                                return;
                            case a.f19777n /* 4355 */:
                                if (!UMUtils.isMainProgress(a)) {
                                    UMProcessDBHelper.getInstance(a).insertEventsInSubProcess(UMFrUtils.getSubProcessName(a), new JSONArray().put(obj));
                                    return;
                                } else {
                                    if (obj != null) {
                                        e(obj);
                                        d();
                                        return;
                                    }
                                    return;
                                }
                            case a.f19778o /* 4356 */:
                                if (obj == null || f19751y == null || f19752z == null) {
                                    return;
                                }
                                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> PROFILE_CHANGE_NOTIFY");
                                String string = "";
                                String string2 = "";
                                if (obj instanceof JSONObject) {
                                    JSONObject jSONObject = (JSONObject) obj;
                                    if (jSONObject.has("uid") && jSONObject.has(com.umeng.analytics.pro.d.M)) {
                                        string = jSONObject.getString(com.umeng.analytics.pro.d.M);
                                        string2 = jSONObject.getString("uid");
                                    }
                                    a(string2, string);
                                    return;
                                }
                                return;
                            default:
                                switch (i2) {
                                    case a.f19782s /* 8195 */:
                                        com.umeng.analytics.b.a().a(obj);
                                        return;
                                    case a.f19783t /* 8196 */:
                                        com.umeng.analytics.b.a().m();
                                        return;
                                    case a.f19784u /* 8197 */:
                                        com.umeng.analytics.b.a().k();
                                        return;
                                    default:
                                        switch (i2) {
                                            case a.f19785v /* 8199 */:
                                            case a.f19786w /* 8200 */:
                                                com.umeng.analytics.b.a().b(obj);
                                                return;
                                            case a.f19787x /* 8201 */:
                                                com.umeng.analytics.b.a().b((Object) null);
                                                return;
                                            default:
                                                switch (i2) {
                                                    case a.f19788y /* 8208 */:
                                                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> receive DELAY_BUILD_ENVELOPE event.");
                                                        Context context = a;
                                                        UMWorkDispatch.sendEvent(context, a.f19789z, CoreProtocol.getInstance(context), null);
                                                        Context context2 = a;
                                                        UMWorkDispatch.sendEvent(context2, a.f19776m, CoreProtocol.getInstance(context2), null);
                                                        return;
                                                    case a.f19789z /* 8209 */:
                                                        a(obj, false);
                                                        return;
                                                    case a.A /* 8210 */:
                                                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> recv BUILD_ENVELOPE_IMMEDIATELY.");
                                                        if (!UMUtils.isMainProgress(a) || (this.b.c() instanceof ReportPolicy.ReportQuasiRealtime)) {
                                                            return;
                                                        }
                                                        a(true);
                                                        return;
                                                    default:
                                                        switch (i2) {
                                                            case a.D /* 8213 */:
                                                                if (FieldManager.allow(com.umeng.commonsdk.utils.d.E)) {
                                                                    if (DeviceConfig.getGlobleActivity(a) != null) {
                                                                        u.b(a);
                                                                    }
                                                                    Context context3 = a;
                                                                    UMWorkDispatch.sendEventEx(context3, a.D, CoreProtocol.getInstance(context3), null, 5000L);
                                                                    return;
                                                                }
                                                                return;
                                                            case a.E /* 8214 */:
                                                                if (obj != null && (obj instanceof JSONObject)) {
                                                                    String strOptString = ((JSONObject) obj).optString(AnalyticsConfig.RTD_START_TIME);
                                                                    String strOptString2 = ((JSONObject) obj).optString(AnalyticsConfig.RTD_PERIOD);
                                                                    String strOptString3 = ((JSONObject) obj).optString(AnalyticsConfig.DEBUG_KEY);
                                                                    if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2) || TextUtils.isEmpty(strOptString3)) {
                                                                        return;
                                                                    }
                                                                    com.umeng.common.b.a(a, AnalyticsConfig.RTD_SP_FILE, AnalyticsConfig.RTD_START_TIME, strOptString);
                                                                    com.umeng.common.b.a(a, AnalyticsConfig.RTD_SP_FILE, AnalyticsConfig.RTD_PERIOD, strOptString2);
                                                                    com.umeng.common.b.a(a, AnalyticsConfig.RTD_SP_FILE, AnalyticsConfig.DEBUG_KEY, strOptString3);
                                                                    return;
                                                                }
                                                                return;
                                                            case a.F /* 8215 */:
                                                                com.umeng.common.b.a(a, AnalyticsConfig.RTD_SP_FILE);
                                                                return;
                                                            default:
                                                                return;
                                                        }
                                                }
                                        }
                                }
                        }
                }
            } catch (Throwable unused2) {
            }
        }
    }

    private void g(Object obj) {
        try {
            b(a);
            d();
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject != null && jSONObject.length() > 0) {
                String string = jSONObject.getString(com.umeng.analytics.pro.d.M);
                String string2 = jSONObject.getString("uid");
                long j2 = jSONObject.getLong("ts");
                String[] strArrA = com.umeng.analytics.c.a(a);
                if (strArrA != null && string.equals(strArrA[0]) && string2.equals(strArrA[1])) {
                    return;
                }
                u.a().a(a, j2);
                String strC = y.a().c(a);
                boolean zB = u.a().b(a, j2, false);
                com.umeng.analytics.c.a(a, string, string2);
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onProfileSignIn: force generate new session: session id = " + strC);
                u.a().a(a, j2, true);
                if (zB) {
                    u.a().b(a, j2);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public long f() {
        SharedPreferences sharedPreferences;
        long jCurrentTimeMillis = 0;
        try {
            if (a == null || (sharedPreferences = PreferenceWrapper.getDefault(a)) == null) {
                return 0L;
            }
            long j2 = sharedPreferences.getLong(f19742l, 0L);
            if (j2 == 0) {
                try {
                    jCurrentTimeMillis = System.currentTimeMillis();
                    sharedPreferences.edit().putLong(f19742l, jCurrentTimeMillis).commit();
                    return jCurrentTimeMillis;
                } catch (Throwable unused) {
                }
            }
            return j2;
        } catch (Throwable unused2) {
            return jCurrentTimeMillis;
        }
    }

    public void c(Object obj) {
        b(a);
        d();
        if (d(false)) {
            j();
        }
    }

    private void f(Object obj) {
        try {
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject != null && jSONObject.length() > 0) {
                long j2 = jSONObject.getLong("ts");
                b(a);
                d();
                String[] strArrA = com.umeng.analytics.c.a(a);
                if (strArrA == null || TextUtils.isEmpty(strArrA[0]) || TextUtils.isEmpty(strArrA[1])) {
                    return;
                }
                u.a().a(a, j2);
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onProfileSignIn: force generate new session: session id = " + y.a().c(a));
                boolean zB = u.a().b(a, j2, false);
                com.umeng.analytics.c.b(a);
                u.a().a(a, j2, true);
                if (zB) {
                    u.a().b(a, j2);
                }
            }
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(" Excepthon  in  onProfileSignOff", th);
            }
        }
    }

    private JSONObject b(JSONObject jSONObject, long j2) {
        try {
            if (q.a(jSONObject) <= j2) {
                return jSONObject;
            }
            jSONObject = null;
            i.a(a).a(true, false);
            i.a(a).b();
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> Instant session packet overload !!! ");
            return null;
        } catch (Throwable unused) {
            return jSONObject;
        }
    }

    public JSONObject b(boolean z2) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        JSONObject jSONObjectA = null;
        try {
            jSONObjectA = i.a(a).a(z2);
            if (jSONObjectA == null) {
                jSONObjectA = new JSONObject();
            } else {
                try {
                    boolean zHas = jSONObjectA.has(com.umeng.analytics.pro.d.f19623n);
                    jSONObjectA = jSONObjectA;
                    if (zHas) {
                        JSONArray jSONArray3 = jSONObjectA.getJSONArray(com.umeng.analytics.pro.d.f19623n);
                        JSONArray jSONArray4 = new JSONArray();
                        int i2 = 0;
                        while (i2 < jSONArray3.length()) {
                            JSONObject jSONObject = (JSONObject) jSONArray3.get(i2);
                            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(com.umeng.analytics.pro.d.f19629t);
                            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray(com.umeng.analytics.pro.d.f19630u);
                            if (jSONArrayOptJSONArray == null && jSONArrayOptJSONArray2 != null) {
                                jSONObject.put(com.umeng.analytics.pro.d.f19629t, jSONArrayOptJSONArray2);
                                jSONObject.remove(com.umeng.analytics.pro.d.f19630u);
                            }
                            if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray2 != null) {
                                ArrayList arrayList = new ArrayList();
                                for (int i3 = 0; i3 < jSONArrayOptJSONArray.length(); i3++) {
                                    arrayList.add((JSONObject) jSONArrayOptJSONArray.get(i3));
                                }
                                for (int i4 = 0; i4 < jSONArrayOptJSONArray2.length(); i4++) {
                                    arrayList.add((JSONObject) jSONArrayOptJSONArray2.get(i4));
                                }
                                JSONArraySortUtil jSONArraySortUtil = new JSONArraySortUtil();
                                jSONArraySortUtil.setCompareKey(com.umeng.analytics.pro.d.f19633x);
                                Collections.sort(arrayList, jSONArraySortUtil);
                                JSONArray jSONArray5 = new JSONArray();
                                Iterator it = arrayList.iterator();
                                while (it.hasNext()) {
                                    jSONArray5.put((JSONObject) it.next());
                                }
                                jSONObject.put(com.umeng.analytics.pro.d.f19629t, jSONArray5);
                                jSONObject.remove(com.umeng.analytics.pro.d.f19630u);
                            }
                            if (jSONObject.has(com.umeng.analytics.pro.d.f19629t)) {
                                JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray(com.umeng.analytics.pro.d.f19629t);
                                int i5 = 0;
                                while (i5 < jSONArrayOptJSONArray3.length()) {
                                    JSONObject jSONObject2 = jSONArrayOptJSONArray3.getJSONObject(i5);
                                    if (jSONObject2.has(com.umeng.analytics.pro.d.f19633x)) {
                                        jSONArray2 = jSONArray3;
                                        jSONObject2.put("ts", jSONObject2.getLong(com.umeng.analytics.pro.d.f19633x));
                                        jSONObject2.remove(com.umeng.analytics.pro.d.f19633x);
                                    } else {
                                        jSONArray2 = jSONArray3;
                                    }
                                    i5++;
                                    jSONArray3 = jSONArray2;
                                }
                                jSONArray = jSONArray3;
                                jSONObject.put(com.umeng.analytics.pro.d.f19629t, jSONArrayOptJSONArray3);
                                jSONObject.put(com.umeng.analytics.pro.d.f19635z, jSONArrayOptJSONArray3.length());
                            } else {
                                jSONArray = jSONArray3;
                                jSONObject.put(com.umeng.analytics.pro.d.f19635z, 0);
                            }
                            jSONArray4.put(jSONObject);
                            i2++;
                            jSONArray3 = jSONArray;
                        }
                        jSONObjectA.put(com.umeng.analytics.pro.d.f19623n, jSONArray4);
                        jSONObjectA = jSONObjectA;
                    }
                } catch (Exception e2) {
                    MLog.e("merge pages error");
                    e2.printStackTrace();
                    jSONObjectA = jSONObjectA;
                }
            }
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(a);
            if (sharedPreferences != null) {
                String string = sharedPreferences.getString("userlevel", "");
                if (!TextUtils.isEmpty(string)) {
                    jSONObjectA.put("userlevel", string);
                }
            }
            String[] strArrA = com.umeng.analytics.c.a(a);
            if (strArrA != null && !TextUtils.isEmpty(strArrA[0]) && !TextUtils.isEmpty(strArrA[1])) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(com.umeng.analytics.pro.d.M, strArrA[0]);
                jSONObject3.put(com.umeng.analytics.pro.d.N, strArrA[1]);
                if (jSONObject3.length() > 0) {
                    jSONObjectA.put(com.umeng.analytics.pro.d.L, jSONObject3);
                }
            }
            if (ABTest.getService(a).isInTest()) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put(ABTest.getService(a).getTestName(), ABTest.getService(a).getGroupInfo());
                jSONObjectA.put(com.umeng.analytics.pro.d.K, jSONObject4);
            }
            r.a().a(jSONObjectA, a);
        } catch (Throwable unused) {
        }
        return jSONObjectA;
    }

    public void e() {
        if (d(false)) {
            j();
        }
    }

    public void d(Object obj) {
        r();
        m();
        n();
        a(true);
    }

    private boolean d(boolean z2) {
        if (this.b == null) {
            this.b = new c();
        }
        ReportPolicy.ReportStrategy reportStrategyC = this.b.c();
        if (!(reportStrategyC instanceof ReportPolicy.DefconPolicy)) {
            return true;
        }
        if (z2) {
            return ((ReportPolicy.DefconPolicy) reportStrategyC).shouldSendMessageByInstant();
        }
        return reportStrategyC.shouldSendMessage(false);
    }

    public void b(Object obj) {
        if (obj != null) {
            try {
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject.length() > 0 && (!jSONObject.has("exception") || 101 != jSONObject.getInt("exception"))) {
                    f(jSONObject);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void b(Context context) {
        try {
            i.a(context).d();
            q();
        } catch (Throwable unused) {
        }
    }

    public void a(boolean z2) {
        if (c(z2)) {
            if (!(this.b.c() instanceof ReportPolicy.ReportQuasiRealtime)) {
                if (UMEnvelopeBuild.isReadyBuild(a, UMLogDataProtocol.UMBusinessType.U_APP)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> constructMessage()");
                    j();
                    return;
                }
                return;
            }
            if (z2) {
                if (UMEnvelopeBuild.isOnline(a)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> send session start in policy ReportQuasiRealtime.");
                    j();
                    return;
                }
                return;
            }
            if (UMEnvelopeBuild.isReadyBuild(a, UMLogDataProtocol.UMBusinessType.U_APP)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> send normal data in policy ReportQuasiRealtime.");
                j();
            }
        }
    }

    private boolean a(JSONArray jSONArray) {
        int length = jSONArray.length();
        List listAsList = Arrays.asList("$$_onUMengEnterForeground", "$$_onUMengEnterBackground", "$$_onUMengEnterForegroundInitError");
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            try {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i3);
                if (jSONObjectOptJSONObject != null && listAsList.contains(jSONObjectOptJSONObject.optString("id"))) {
                    i2++;
                }
            } catch (Throwable unused) {
            }
        }
        return i2 >= length;
    }

    private boolean a(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("ekv");
        int length = jSONArrayOptJSONArray.length();
        if (jSONArrayOptJSONArray != null) {
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                try {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i3);
                    Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                    while (itKeys.hasNext()) {
                        JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray(itKeys.next());
                        if (jSONArrayOptJSONArray2 != null && a(jSONArrayOptJSONArray2)) {
                            i2++;
                        }
                    }
                } catch (Throwable unused) {
                }
            }
            if (i2 >= length) {
                return true;
            }
        }
        return false;
    }

    public JSONObject a(long j2) {
        if (TextUtils.isEmpty(y.a().d(a))) {
            return null;
        }
        JSONObject jSONObjectB = b(false);
        int iA = r.a().a(a);
        if (jSONObjectB.length() > 0) {
            if (jSONObjectB.length() == 1) {
                if (jSONObjectB.optJSONObject(com.umeng.analytics.pro.d.L) != null && iA != 3) {
                    return null;
                }
                if (!TextUtils.isEmpty(jSONObjectB.optString("userlevel")) && iA != 3) {
                    return null;
                }
            } else if (jSONObjectB.length() == 2 && jSONObjectB.optJSONObject(com.umeng.analytics.pro.d.L) != null && !TextUtils.isEmpty(jSONObjectB.optString("userlevel")) && iA != 3) {
                return null;
            }
            String strOptString = jSONObjectB.optString(com.umeng.analytics.pro.d.f19623n);
            String strOptString2 = jSONObjectB.optString(com.umeng.analytics.pro.d.T);
            String strOptString3 = jSONObjectB.optString("ekv");
            if (TextUtils.isEmpty(strOptString) && TextUtils.isEmpty(strOptString2) && !TextUtils.isEmpty(strOptString3) && a(jSONObjectB)) {
                return null;
            }
        } else if (iA != 3) {
            return null;
        }
        JSONObject jSONObjectL = l();
        if (jSONObjectL != null) {
            c(jSONObjectL);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (iA == 3) {
                jSONObject2.put("analytics", new JSONObject());
            } else if (jSONObjectB != null && jSONObjectB.length() > 0) {
                jSONObject2.put("analytics", jSONObjectB);
            }
            if (jSONObjectL != null && jSONObjectL.length() > 0) {
                jSONObject.put("header", jSONObjectL);
            }
            if (jSONObject2.length() > 0) {
                jSONObject.put("content", jSONObject2);
            }
            return a(jSONObject, j2);
        } catch (Throwable unused) {
            return jSONObject;
        }
    }

    private JSONObject a(JSONObject jSONObject, long j2) {
        try {
            if (q.a(jSONObject) <= j2) {
                return jSONObject;
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("header");
            jSONObject2.put(com.umeng.analytics.pro.d.aB, q.a(jSONObject));
            jSONObject.put("header", jSONObject2);
            return q.a(a, j2, jSONObject);
        } catch (Throwable unused) {
            return jSONObject;
        }
    }

    private boolean a(long j2, int i2) {
        if (j2 == 0) {
            return true;
        }
        if (System.currentTimeMillis() - j2 <= 28800000) {
            return i2 < 5000;
        }
        o();
        return true;
    }

    public void a(Object obj) {
        if (obj != null) {
            try {
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject.length() > 0 && (!jSONObject.has("exception") || 101 != jSONObject.getInt("exception"))) {
                    g(jSONObject);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void a(Object obj, boolean z2) {
        if (z2) {
            if (d(true)) {
                i();
            }
        } else if (UMEnvelopeBuild.isOnline(a) && d(true)) {
            i();
        }
    }
}
