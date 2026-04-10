package com.umeng.commonsdk.statistics;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.kuaishou.weapon.p0.g;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.pro.an;
import com.umeng.analytics.pro.bf;
import com.umeng.analytics.pro.d;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.idtracking.Envelope;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.idtracking.e;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: EnvelopeManager.java */
/* JADX INFO: loaded from: classes4.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f2327a = null;
    public static String b = "";
    private static final String c = "EnvelopeManager";
    private static final String d = "debug.umeng.umTaskId";
    private static final String e = "debug.umeng.umCaseId";
    private static final String f = "empty";
    private static String g = "";
    private static String h = "";
    private static String i;
    private static Map<String, String> j;
    private static boolean l;
    private int k = 0;

    static {
        HashMap map = new HashMap();
        j = map;
        map.put("header", "#h");
        j.put(an.u, "#sdt");
        j.put(an.Q, "#ac");
        j.put("device_model", "#dm");
        j.put(an.g, "#umid");
        j.put(an.x, an.x);
        j.put("language", "#lang");
        j.put(an.ai, "#dt");
        j.put(an.z, "#rl");
        j.put(an.H, "#dmf");
        j.put(an.J, "#dn");
        j.put("platform_version", "#pv");
        j.put("font_size_setting", "#fss");
        j.put(an.y, "#ov");
        j.put(an.I, "#did");
        j.put("platform_sdk_version", "#psv");
        j.put(an.F, "#db");
        j.put("appkey", "#ak");
        j.put(an.Y, "#itr");
        j.put("id_type", "#it");
        j.put("uuid", "#ud");
        j.put("device_id", "#dd");
        j.put(an.X, "#imp");
        j.put("sdk_version", "#sv");
        j.put("st", "#st");
        j.put("analytics", "#a");
        j.put(an.o, "#pkg");
        j.put(an.p, "#sig");
        j.put(an.q, "#sis1");
        j.put(an.r, "#sis");
        j.put("app_version", "#av");
        j.put("version_code", "#vc");
        j.put(an.v, "#imd");
        j.put(an.B, "#mnc");
        j.put(an.E, "#boa");
        j.put(an.G, "#mant");
        j.put(an.M, "#tz");
        j.put(an.O, "#ct");
        j.put(an.P, "#car");
        j.put(an.s, "#disn");
        j.put(an.T, "#nt");
        j.put(an.b, "#cv");
        j.put(an.d, "#mv");
        j.put(an.c, "#cot");
        j.put(an.e, "#mod");
        j.put(an.aj, "#al");
        j.put("session_id", "#sid");
        j.put(an.S, "#ip");
        j.put(an.U, "#sre");
        j.put(an.V, "#fre");
        j.put(an.W, "#ret");
        j.put("channel", "#chn");
        j.put("wrapper_type", "#wt");
        j.put("wrapper_version", "#wv");
        j.put(an.aV, "#tsv");
        j.put(an.aW, "#rps");
        j.put(an.aZ, "#mov");
        j.put(d.i, "#vt");
        j.put("secret", "#sec");
        j.put(d.ah, "#prv");
        j.put(d.l, "#$prv");
        j.put(d.m, "#uda");
        j.put(an.f2174a, "#tok");
        j.put(an.aN, "#iv");
        j.put(an.R, "#ast");
        j.put("backstate", "#bst");
        j.put("zdata_ver", "#zv");
        j.put("zdata_req_ts", "#zrt");
        j.put("app_b_v", "#bv");
        j.put("zdata", "#zta");
        j.put(an.ap, "#mt");
        j.put(an.am, "#zsv");
        j.put("others_OS", "#oos");
    }

    public static String a(String str) {
        return j.containsKey(str) ? j.get(str) : str;
    }

    public static void a() {
        if (i != null) {
            i = null;
            e.a();
        }
    }

    public static long a(Context context) {
        long j2 = DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX - DataHelper.ENVELOPE_EXTRA_LENGTH;
        if (ULog.DEBUG) {
            Log.i(c, "free size is " + j2);
        }
        return j2;
    }

    private JSONObject a(int i2, JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                jSONObject.put("exception", i2);
            } catch (Exception unused) {
            }
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("exception", i2);
        } catch (Exception unused2) {
        }
        return jSONObject2;
    }

    private static boolean b() {
        g = UMUtils.getSystemProperty(d, "");
        h = UMUtils.getSystemProperty(e, "");
        return (!TextUtils.isEmpty(g) && !f.equals(g)) && (!TextUtils.isEmpty(h) && !f.equals(h));
    }

    public JSONObject a(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str, String str2, String str3) {
        JSONObject jSONObject3;
        String str4;
        String str5;
        boolean z;
        String str6;
        Envelope envelope;
        String str7;
        JSONObject jSONObjectOptJSONObject;
        if (ULog.DEBUG && jSONObject != null && jSONObject2 != null) {
            Log.i(c, "headerJSONObject size is " + jSONObject.toString().getBytes().length);
            Log.i(c, "bodyJSONObject size is " + jSONObject2.toString().getBytes().length);
        }
        if (context == null || jSONObject2 == null) {
            return a(110, (JSONObject) null);
        }
        try {
            if (jSONObject2.has("analytics") && (jSONObjectOptJSONObject = jSONObject2.optJSONObject("analytics")) != null && jSONObjectOptJSONObject.has(d.n)) {
                str5 = str2;
                z = true;
            } else {
                str5 = str2;
                z = false;
            }
            JSONObject jSONObjectA = a(context, str5, z);
            if (jSONObjectA != null && jSONObject != null) {
                jSONObjectA = a(jSONObjectA, jSONObject);
            }
            JSONObject jSONObject4 = jSONObjectA;
            if (jSONObject4 != null && jSONObject2 != null) {
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (next != null && (next instanceof String) && (str7 = next) != null && jSONObject2.opt(str7) != null) {
                        try {
                            jSONObject4.put(a(str7), jSONObject2.opt(str7));
                        } catch (Exception unused) {
                        }
                    }
                }
            }
            if (TextUtils.isEmpty(str2)) {
                str5 = "u";
            }
            String str8 = TextUtils.isEmpty(str3) ? "1.0.0" : str3;
            if (jSONObject4 != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(str5).append("==").append(str8).append("&=");
                String string = sb.toString();
                if (TextUtils.isEmpty(string)) {
                    return a(101, jSONObject4);
                }
                if (string.endsWith("&=")) {
                    string = string.substring(0, string.length() - 2);
                }
                str6 = string;
            } else {
                str6 = null;
            }
            if (jSONObject4 != null) {
                try {
                    e eVarA = e.a(context);
                    if (eVarA != null) {
                        eVarA.b();
                        String strEncodeToString = Base64.encodeToString(new bf().a(eVarA.c()), 0);
                        if (!TextUtils.isEmpty(strEncodeToString)) {
                            JSONObject jSONObject5 = jSONObject4.getJSONObject(a("header"));
                            jSONObject5.put(a(an.Y), strEncodeToString);
                            jSONObject4.put(a("header"), jSONObject5);
                        }
                    }
                } catch (Exception unused2) {
                }
            }
            if (jSONObject4 != null && DataHelper.largeThanMaxSize(jSONObject4.toString().getBytes().length, DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX)) {
                SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putInt("serial", sharedPreferences.getInt("serial", 1) + 1).commit();
                }
                return a(113, jSONObject4);
            }
            if (jSONObject4 != null) {
                Envelope envelopeA = a(context, jSONObject4.toString().getBytes());
                if (envelopeA == null) {
                    return a(111, jSONObject4);
                }
                envelope = envelopeA;
            } else {
                envelope = null;
            }
            if (envelope != null && DataHelper.largeThanMaxSize(envelope.toBinary().length, DataHelper.ENVELOPE_LENGTH_MAX)) {
                return a(114, jSONObject4);
            }
            int iA = a(context, envelope, str6, jSONObject4 != null ? jSONObject4.optJSONObject(a("header")).optString(a("app_version")) : null, str);
            if (iA != 0) {
                return a(iA, jSONObject4);
            }
            if (ULog.DEBUG) {
                Log.i(c, "constructHeader size is " + jSONObject4.toString().getBytes().length);
            }
            if (!str6.startsWith(an.aD) && !str6.startsWith("i") && !str6.startsWith(an.aI) && !str6.startsWith("a") && !com.umeng.commonsdk.stateless.b.a()) {
                new com.umeng.commonsdk.stateless.b(context);
                com.umeng.commonsdk.stateless.b.b();
            }
            return jSONObject4;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            if (jSONObject != null) {
                try {
                    JSONObject jSONObject6 = new JSONObject();
                    try {
                        jSONObject6.put("header", jSONObject);
                    } catch (JSONException unused3) {
                    } catch (Exception e2) {
                        e = e2;
                        jSONObject3 = jSONObject6;
                        UMCrashManager.reportCrash(context, e);
                        return a(110, jSONObject3);
                    }
                    jSONObject3 = jSONObject6;
                } catch (Exception e3) {
                    e = e3;
                    jSONObject3 = null;
                }
            } else {
                jSONObject3 = null;
            }
            if (jSONObject2 != null) {
                if (jSONObject3 == null) {
                    try {
                        jSONObject3 = new JSONObject();
                    } catch (Exception e4) {
                        e = e4;
                        UMCrashManager.reportCrash(context, e);
                        return a(110, jSONObject3);
                    }
                }
                if (jSONObject2 != null) {
                    Iterator<String> itKeys2 = jSONObject2.keys();
                    while (itKeys2.hasNext()) {
                        String next2 = itKeys2.next();
                        if (next2 != null && (next2 instanceof String) && (str4 = next2) != null && jSONObject2.opt(str4) != null) {
                            try {
                                jSONObject3.put(str4, jSONObject2.opt(str4));
                            } catch (Exception unused4) {
                            }
                        }
                    }
                }
            }
            return a(110, jSONObject3);
        }
    }

    public JSONObject a(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str) {
        Envelope envelopeA;
        String str2;
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(a("header"), new JSONObject());
            if (jSONObject != null) {
                jSONObject3 = a(jSONObject3, jSONObject);
            }
            if (jSONObject3 != null && jSONObject2 != null) {
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (next != null && (next instanceof String) && (str2 = next) != null && jSONObject2.opt(str2) != null) {
                        try {
                            jSONObject3.put(str2, jSONObject2.opt(str2));
                        } catch (Exception unused) {
                        }
                    }
                }
            }
            if (jSONObject3 != null && DataHelper.largeThanMaxSize(jSONObject3.toString().getBytes().length, DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX)) {
                SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putInt("serial", sharedPreferences.getInt("serial", 1) + 1).commit();
                }
                return a(113, jSONObject3);
            }
            if (jSONObject3 != null) {
                envelopeA = a(context, jSONObject3.toString().getBytes());
                if (envelopeA == null) {
                    return a(111, jSONObject3);
                }
            } else {
                envelopeA = null;
            }
            Envelope envelope = envelopeA;
            if (envelope != null && DataHelper.largeThanMaxSize(envelope.toBinary().length, DataHelper.ENVELOPE_LENGTH_MAX)) {
                return a(114, jSONObject3);
            }
            int iA = a(context, envelope, "h==1.2.0", "", str);
            if (iA != 0) {
                return a(iA, jSONObject3);
            }
            if (ULog.DEBUG) {
                Log.i(c, "constructHeader size is " + jSONObject3.toString().getBytes().length);
            }
            return jSONObject3;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            return a(110, new JSONObject());
        }
    }

    public JSONObject b(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str) {
        Envelope envelopeA;
        String str2;
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(a("header"), new JSONObject());
            try {
                if (b()) {
                    jSONObject.put("umTaskId", g);
                    jSONObject.put("umCaseId", h);
                }
            } catch (Throwable unused) {
            }
            if (jSONObject != null) {
                jSONObject3 = a(jSONObject3, jSONObject);
            }
            if (jSONObject3 != null && jSONObject2 != null) {
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (next != null && (next instanceof String) && (str2 = next) != null && jSONObject2.opt(str2) != null) {
                        try {
                            jSONObject3.put(str2, jSONObject2.opt(str2));
                        } catch (Exception unused2) {
                        }
                    }
                }
            }
            if (jSONObject3 != null && DataHelper.largeThanMaxSize(jSONObject3.toString().getBytes().length, DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX)) {
                SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putInt("serial", sharedPreferences.getInt("serial", 1) + 1).commit();
                }
                return a(113, jSONObject3);
            }
            if (jSONObject3 != null) {
                envelopeA = a(context, jSONObject3.toString().getBytes());
                if (envelopeA == null) {
                    return a(111, jSONObject3);
                }
            } else {
                envelopeA = null;
            }
            Envelope envelope = envelopeA;
            if (envelope != null && DataHelper.largeThanMaxSize(envelope.toBinary().length, DataHelper.ENVELOPE_LENGTH_MAX)) {
                return a(114, jSONObject3);
            }
            int iA = a(context, envelope, "z==1.2.0", DeviceConfig.getAppVersionName(context), str);
            if (iA != 0) {
                return a(iA, jSONObject3);
            }
            if (ULog.DEBUG) {
                Log.i(c, "constructHeader size is " + jSONObject3.toString().getBytes().length);
            }
            return jSONObject3;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            return a(110, new JSONObject());
        }
    }

    private static int[] b(Context context) {
        int[] iArr = new int[3];
        try {
            SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(com.umeng.commonsdk.internal.c.f2301a, 0);
            if (sharedPreferences != null) {
                iArr[0] = sharedPreferences.getInt(com.umeng.commonsdk.internal.c.b, 0);
                iArr[1] = sharedPreferences.getInt(com.umeng.commonsdk.internal.c.c, 0);
                iArr[2] = sharedPreferences.getInt("policyGrantResult", 0);
            }
        } catch (Throwable unused) {
        }
        return iArr;
    }

    private static JSONObject a(Context context, String str, boolean z) {
        JSONObject jSONObject;
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            if (!TextUtils.isEmpty(i)) {
                try {
                    jSONObject = new JSONObject(i);
                } catch (Exception unused) {
                    jSONObject = null;
                }
            } else {
                UMUtils.saveSDKComponent();
                jSONObject = new JSONObject();
                jSONObject.put(a(an.p), DeviceConfig.getAppMD5Signature(context));
                jSONObject.put(a(an.q), DeviceConfig.getAppSHA1Key(context));
                jSONObject.put(a(an.r), DeviceConfig.getAppHashKey(context));
                jSONObject.put(a("app_version"), DeviceConfig.getAppVersionName(context));
                jSONObject.put(a("version_code"), Integer.parseInt(DeviceConfig.getAppVersionCode(context)));
                jSONObject.put(a(an.v), DeviceConfig.getDeviceIdUmengMD5(context));
                jSONObject.put(a(an.w), DeviceConfig.getCPU());
                String mccmnc = DeviceConfig.getMCCMNC(context);
                if (!TextUtils.isEmpty(mccmnc)) {
                    jSONObject.put(a(an.B), mccmnc);
                    b = mccmnc;
                } else {
                    jSONObject.put(a(an.B), "");
                }
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.I)) {
                    String subOSName = DeviceConfig.getSubOSName(context);
                    if (!TextUtils.isEmpty(subOSName)) {
                        jSONObject.put(a(an.K), subOSName);
                    }
                    String subOSVersion = DeviceConfig.getSubOSVersion(context);
                    if (!TextUtils.isEmpty(subOSVersion)) {
                        jSONObject.put(a(an.L), subOSVersion);
                    }
                }
                String deviceType = DeviceConfig.getDeviceType(context);
                if (!TextUtils.isEmpty(deviceType)) {
                    jSONObject.put(a(an.ai), deviceType);
                }
                jSONObject.put(a(an.o), DeviceConfig.getPackageName(context));
                jSONObject.put(a(an.u), "Android");
                jSONObject.put(a("device_id"), DeviceConfig.getDeviceId(context));
                jSONObject.put(a("device_model"), Build.MODEL);
                jSONObject.put(a(an.E), Build.BOARD);
                jSONObject.put(a(an.F), Build.BRAND);
                jSONObject.put(a(an.G), Build.TIME);
                jSONObject.put(a(an.H), Build.MANUFACTURER);
                jSONObject.put(a(an.I), Build.ID);
                jSONObject.put(a(an.J), Build.DEVICE);
                jSONObject.put(a(an.y), Build.VERSION.RELEASE);
                jSONObject.put(a(an.x), "Android");
                int[] resolutionArray = DeviceConfig.getResolutionArray(context);
                if (resolutionArray != null) {
                    jSONObject.put(a(an.z), resolutionArray[1] + "*" + resolutionArray[0]);
                }
                jSONObject.put(a(an.A), DeviceConfig.getMac(context));
                jSONObject.put(a(an.M), DeviceConfig.getTimeZone(context));
                String[] localeInfo = DeviceConfig.getLocaleInfo(context);
                jSONObject.put(a(an.O), localeInfo[0]);
                jSONObject.put(a("language"), localeInfo[1]);
                jSONObject.put(a(an.P), DeviceConfig.getNetworkOperatorName(context));
                jSONObject.put(a(an.s), DeviceConfig.getAppName(context));
                String[] networkAccessMode = DeviceConfig.getNetworkAccessMode(context);
                if ("Wi-Fi".equals(networkAccessMode[0])) {
                    jSONObject.put(a(an.Q), "wifi");
                } else if ("2G/3G".equals(networkAccessMode[0])) {
                    jSONObject.put(a(an.Q), "2G/3G");
                } else {
                    jSONObject.put(a(an.Q), "unknow");
                }
                if (!"".equals(networkAccessMode[1])) {
                    jSONObject.put(a(an.R), networkAccessMode[1]);
                }
                if (DeviceConfig.isHarmony(context)) {
                    jSONObject.put(a("others_OS"), "harmony");
                } else {
                    jSONObject.put(a("others_OS"), "Android");
                }
                jSONObject.put(a(an.T), DeviceConfig.getNetworkType(context));
                jSONObject.put(a(an.b), "9.5.4");
                jSONObject.put(a(an.c), SdkVersion.SDK_TYPE);
                jSONObject.put(a(an.d), "1");
                if (!TextUtils.isEmpty(f2327a)) {
                    jSONObject.put(a(an.e), f2327a);
                }
                jSONObject.put(a(an.aj), Build.VERSION.SDK_INT);
                if (!TextUtils.isEmpty(UMUtils.VALUE_REC_VERSION_NAME)) {
                    jSONObject.put(a(an.af), UMUtils.VALUE_REC_VERSION_NAME);
                }
                try {
                    String uUIDForZid = UMUtils.getUUIDForZid(context);
                    if (TextUtils.isEmpty(uUIDForZid)) {
                        UMUtils.setUUIDForZid(context);
                        uUIDForZid = UMUtils.getUUIDForZid(context);
                    }
                    jSONObject.put(a("session_id"), uUIDForZid);
                } catch (Throwable unused2) {
                }
                i = jSONObject.toString();
            }
            if (jSONObject == null) {
                return null;
            }
            try {
                jSONObject.put(a(an.ak), UMUtils.getOaidRequiredTime(context));
            } catch (Exception unused3) {
            }
            try {
                jSONObject.put(a(an.U), sharedPreferences.getInt("successful_request", 0));
                jSONObject.put(a(an.V), sharedPreferences.getInt(an.V, 0));
                jSONObject.put(a(an.W), sharedPreferences.getInt("last_request_spent_ms", 0));
                String zid = UMUtils.getZid(context);
                if (!TextUtils.isEmpty(zid)) {
                    jSONObject.put(a(an.al), zid);
                }
                if (!TextUtils.isEmpty(UMUtils.VALUE_ASMS_VERSION)) {
                    jSONObject.put(a(an.am), UMUtils.VALUE_ASMS_VERSION);
                }
            } catch (Exception unused4) {
            }
            jSONObject.put(a("channel"), UMUtils.getChannel(context));
            jSONObject.put(a("appkey"), UMUtils.getAppkey(context));
            try {
                String deviceToken = UMUtils.getDeviceToken(context);
                if (!TextUtils.isEmpty(deviceToken)) {
                    jSONObject.put(a(an.f2174a), deviceToken);
                }
            } catch (Exception e2) {
                UMCrashManager.reportCrash(context, e2);
            }
            try {
                String strImprintProperty = UMEnvelopeBuild.imprintProperty(context, an.g, null);
                if (!TextUtils.isEmpty(strImprintProperty)) {
                    jSONObject.put(a(an.g), strImprintProperty);
                }
            } catch (Exception e3) {
                UMCrashManager.reportCrash(context, e3);
            }
            try {
                jSONObject.put(a("wrapper_type"), a.f2326a);
                jSONObject.put(a("wrapper_version"), a.b);
            } catch (Exception unused5) {
            }
            try {
                int targetSdkVersion = UMUtils.getTargetSdkVersion(context);
                boolean zCheckPermission = UMUtils.checkPermission(context, g.c);
                jSONObject.put(a(an.aV), targetSdkVersion);
                if (zCheckPermission) {
                    jSONObject.put(a(an.aW), "yes");
                } else {
                    jSONObject.put(a(an.aW), "no");
                }
            } catch (Throwable unused6) {
            }
            try {
                if (b()) {
                    jSONObject.put("umTaskId", g);
                    jSONObject.put("umCaseId", h);
                }
            } catch (Throwable unused7) {
            }
            if ((an.aI.equals(str) || "a".equals(str)) && z) {
                try {
                    int[] iArrB = b(context);
                    jSONObject.put(a(an.bp), String.valueOf(iArrB[0]) + String.valueOf(iArrB[1]) + String.valueOf(iArrB[2]));
                } catch (Throwable unused8) {
                }
            }
            try {
                Map<String, String> moduleTags = TagHelper.getModuleTags();
                if (moduleTags != null && moduleTags.size() > 0) {
                    JSONObject jSONObject2 = new JSONObject();
                    for (Map.Entry<String, String> entry : moduleTags.entrySet()) {
                        jSONObject2.put(entry.getKey(), entry.getValue());
                    }
                    jSONObject.put(a(an.ap), jSONObject2);
                }
            } catch (Throwable unused9) {
            }
            try {
                String realTimeDebugKey = AnalyticsConfig.getRealTimeDebugKey();
                if (!TextUtils.isEmpty(realTimeDebugKey)) {
                    jSONObject.put(a(an.bo), realTimeDebugKey);
                }
            } catch (Throwable unused10) {
            }
            try {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(a(an.ba), com.umeng.commonsdk.internal.a.e);
                if (!TextUtils.isEmpty(UMUtils.VALUE_ANALYTICS_VERSION)) {
                    jSONObject3.put(a(an.bb), UMUtils.VALUE_ANALYTICS_VERSION);
                }
                if (!TextUtils.isEmpty(UMUtils.VALUE_GAME_VERSION)) {
                    jSONObject3.put(a(an.bc), UMUtils.VALUE_GAME_VERSION);
                }
                if (!TextUtils.isEmpty(UMUtils.VALUE_PUSH_VERSION)) {
                    jSONObject3.put(a(an.bd), UMUtils.VALUE_PUSH_VERSION);
                }
                if (!TextUtils.isEmpty(UMUtils.VALUE_SHARE_VERSION)) {
                    jSONObject3.put(a(an.be), UMUtils.VALUE_SHARE_VERSION);
                }
                if (!TextUtils.isEmpty(UMUtils.VALUE_APM_VERSION)) {
                    jSONObject3.put(a(an.bf), UMUtils.VALUE_APM_VERSION);
                }
                if (!TextUtils.isEmpty(UMUtils.VALUE_VERIFY_VERSION)) {
                    jSONObject3.put(a(an.bg), UMUtils.VALUE_VERIFY_VERSION);
                }
                if (!TextUtils.isEmpty(UMUtils.VALUE_SMS_VERSION)) {
                    jSONObject3.put(a(an.bh), UMUtils.VALUE_SMS_VERSION);
                }
                if (!TextUtils.isEmpty(UMUtils.VALUE_REC_VERSION_NAME)) {
                    jSONObject3.put(a(an.bi), UMUtils.VALUE_REC_VERSION_NAME);
                }
                if (!TextUtils.isEmpty(UMUtils.VALUE_VISUAL_VERSION)) {
                    jSONObject3.put(a(an.bj), UMUtils.VALUE_VISUAL_VERSION);
                }
                if (!TextUtils.isEmpty(UMUtils.VALUE_ASMS_VERSION)) {
                    jSONObject3.put(a(an.bk), UMUtils.VALUE_ASMS_VERSION);
                }
                if (!TextUtils.isEmpty(UMUtils.VALUE_LINK_VERSION)) {
                    jSONObject3.put(a(an.bl), UMUtils.VALUE_LINK_VERSION);
                }
                if (!TextUtils.isEmpty(UMUtils.VALUE_ABTEST_VERSION)) {
                    jSONObject3.put(a(an.bm), UMUtils.VALUE_ABTEST_VERSION);
                }
                jSONObject.put(a(an.aZ), jSONObject3);
            } catch (Throwable unused11) {
            }
            try {
                String apmFlag = UMUtils.getApmFlag();
                if (!TextUtils.isEmpty(apmFlag)) {
                    jSONObject.put(a(an.bn), apmFlag);
                }
            } catch (Throwable unused12) {
            }
            byte[] bArrA = ImprintHandler.getImprintService(context).a();
            if (bArrA != null && bArrA.length > 0) {
                try {
                    jSONObject.put(a(an.X), Base64.encodeToString(bArrA, 0));
                } catch (JSONException e4) {
                    UMCrashManager.reportCrash(context, e4);
                }
            }
            if (jSONObject != null && jSONObject.length() > 0) {
                return new JSONObject().put(a("header"), jSONObject);
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
        }
        return null;
    }

    private JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        String str;
        if (jSONObject != null && jSONObject2 != null && jSONObject.opt(a("header")) != null && (jSONObject.opt(a("header")) instanceof JSONObject)) {
            JSONObject jSONObject3 = (JSONObject) jSONObject.opt(a("header"));
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (next != null && (next instanceof String) && (str = next) != null && jSONObject2.opt(str) != null) {
                    try {
                        jSONObject3.put(str, jSONObject2.opt(str));
                        if (str.equals(a(d.i)) && (jSONObject2.opt(str) instanceof Integer)) {
                            this.k = ((Integer) jSONObject2.opt(str)).intValue();
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
        return jSONObject;
    }

    private Envelope a(Context context, byte[] bArr) {
        String strImprintProperty = UMEnvelopeBuild.imprintProperty(context, "codex", null);
        int iIntValue = -1;
        try {
            if (!TextUtils.isEmpty(strImprintProperty)) {
                iIntValue = Integer.valueOf(strImprintProperty).intValue();
            }
        } catch (NumberFormatException e2) {
            UMCrashManager.reportCrash(context, e2);
        }
        if (iIntValue == 0) {
            return Envelope.genEnvelope(context, UMUtils.getAppkey(context), bArr);
        }
        if (iIntValue == 1) {
            return Envelope.genEncryptEnvelope(context, UMUtils.getAppkey(context), bArr);
        }
        if (l) {
            return Envelope.genEncryptEnvelope(context, UMUtils.getAppkey(context), bArr);
        }
        return Envelope.genEnvelope(context, UMUtils.getAppkey(context), bArr);
    }

    private int a(Context context, Envelope envelope, String str, String str2, String str3) {
        if (context == null || envelope == null || TextUtils.isEmpty(str)) {
            return 101;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = DeviceConfig.getAppVersionName(context);
        }
        String strB = com.umeng.commonsdk.stateless.d.b(str3);
        StringBuilder sb = new StringBuilder();
        sb.append(str).append("&&").append(str2).append("_").append(System.currentTimeMillis()).append("_").append(strB).append(".log");
        byte[] binary = envelope.toBinary();
        if (com.umeng.commonsdk.utils.c.a()) {
            return str.startsWith("h") ? UMFrUtils.saveEnvelopeFile(context, sb.toString(), binary) : UMErrorCode.E_UM_BE_ERROR_WORK_MODE;
        }
        if (str.startsWith("h")) {
            return UMErrorCode.E_UM_BE_ERROR_WORK_MODE;
        }
        if (str.startsWith(an.aD) || str.startsWith("i") || str.startsWith("a") || str.startsWith(an.aI)) {
            return UMFrUtils.saveEnvelopeFile(context, sb.toString(), binary);
        }
        return com.umeng.commonsdk.stateless.d.a(context, com.umeng.commonsdk.stateless.a.f, sb.toString(), binary);
    }

    public static void a(boolean z) {
        l = z;
    }
}
