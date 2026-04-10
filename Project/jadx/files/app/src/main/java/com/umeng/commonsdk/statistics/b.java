package com.umeng.commonsdk.statistics;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.analytics.pro.am;
import com.umeng.analytics.pro.be;
import com.umeng.analytics.pro.d;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.idtracking.Envelope;
import com.umeng.commonsdk.statistics.idtracking.e;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: EnvelopeManager.java */
/* JADX INFO: loaded from: classes3.dex */
public class b {
    public static String a = null;
    public static String b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f20049c = "EnvelopeManager";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f20050d = "debug.umeng.umTaskId";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f20051e = "debug.umeng.umCaseId";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f20052f = "empty";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static String f20053g = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static String f20054h = "";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static String f20055i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static Map<String, String> f20056j = new HashMap();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static boolean f20057l;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f20058k = 0;

    static {
        f20056j.put("header", "#h");
        f20056j.put("sdk_type", "#sdt");
        f20056j.put("access", "#ac");
        f20056j.put("device_model", "#dm");
        f20056j.put("umid", "#umid");
        f20056j.put("os", "os");
        f20056j.put("language", "#lang");
        f20056j.put(am.ai, "#dt");
        f20056j.put("resolution", "#rl");
        f20056j.put(am.H, "#dmf");
        f20056j.put(am.J, "#dn");
        f20056j.put("platform_version", "#pv");
        f20056j.put("font_size_setting", "#fss");
        f20056j.put("os_version", "#ov");
        f20056j.put(am.I, "#did");
        f20056j.put("platform_sdk_version", "#psv");
        f20056j.put("device_brand", "#db");
        f20056j.put("appkey", "#ak");
        f20056j.put(am.Y, "#itr");
        f20056j.put("id_type", "#it");
        f20056j.put("uuid", "#ud");
        f20056j.put("device_id", "#dd");
        f20056j.put(am.X, "#imp");
        f20056j.put("sdk_version", "#sv");
        f20056j.put("st", "#st");
        f20056j.put("analytics", "#a");
        f20056j.put("package_name", "#pkg");
        f20056j.put(am.f19456p, "#sig");
        f20056j.put(am.f19457q, "#sis1");
        f20056j.put(am.f19458r, "#sis");
        f20056j.put("app_version", "#av");
        f20056j.put("version_code", "#vc");
        f20056j.put("idmd5", "#imd");
        f20056j.put(am.B, "#mnc");
        f20056j.put(am.E, "#boa");
        f20056j.put(am.G, "#mant");
        f20056j.put("timezone", "#tz");
        f20056j.put("country", "#ct");
        f20056j.put("carrier", "#car");
        f20056j.put(am.f19459s, "#disn");
        f20056j.put("network_type", "#nt");
        f20056j.put(am.b, "#cv");
        f20056j.put(am.f19444d, "#mv");
        f20056j.put(am.f19443c, "#cot");
        f20056j.put(am.f19445e, "#mod");
        f20056j.put(am.aj, "#al");
        f20056j.put("session_id", "#sid");
        f20056j.put(am.S, "#ip");
        f20056j.put(am.U, "#sre");
        f20056j.put(am.V, "#fre");
        f20056j.put(am.W, "#ret");
        f20056j.put("channel", "#chn");
        f20056j.put("wrapper_type", "#wt");
        f20056j.put("wrapper_version", "#wv");
        f20056j.put(am.aV, "#tsv");
        f20056j.put(am.aW, "#rps");
        f20056j.put(am.aZ, "#mov");
        f20056j.put(d.f19618i, "#vt");
        f20056j.put("secret", "#sec");
        f20056j.put(d.ah, "#prv");
        f20056j.put(d.f19621l, "#$prv");
        f20056j.put(d.f19622m, "#uda");
        f20056j.put("devicetoken", "#tok");
        f20056j.put(am.aN, "#iv");
        f20056j.put("access_subtype", "#ast");
        f20056j.put("backstate", "#bst");
        f20056j.put("zdata_ver", "#zv");
        f20056j.put("zdata_req_ts", "#zrt");
        f20056j.put("app_b_v", "#bv");
        f20056j.put("zdata", "#zta");
        f20056j.put(am.ap, "#mt");
        f20056j.put(am.am, "#zsv");
        f20056j.put(am.ao, "#oos");
    }

    public static String a(String str) {
        return f20056j.containsKey(str) ? f20056j.get(str) : str;
    }

    private static boolean b() {
        f20053g = UMUtils.getSystemProperty(f20050d, "");
        f20054h = UMUtils.getSystemProperty(f20051e, "");
        return (!TextUtils.isEmpty(f20053g) && !f20052f.equals(f20053g)) && (!TextUtils.isEmpty(f20054h) && !f20052f.equals(f20054h));
    }

    public static void a() {
        if (f20055i != null) {
            f20055i = null;
            e.a();
        }
    }

    public JSONObject b(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str) {
        String str2;
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(a("header"), new JSONObject());
            try {
                if (b()) {
                    jSONObject.put("umTaskId", f20053g);
                    jSONObject.put("umCaseId", f20054h);
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
            Envelope envelopeA = null;
            if (jSONObject3 != null && (envelopeA = a(context, jSONObject3.toString().getBytes())) == null) {
                return a(111, jSONObject3);
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
                String str3 = "constructHeader size is " + jSONObject3.toString().getBytes().length;
            }
            return jSONObject3;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            return a(110, new JSONObject());
        }
    }

    public static long a(Context context) {
        long j2 = DataHelper.ENVELOPE_ENTITY_RAW_LENGTH_MAX - DataHelper.ENVELOPE_EXTRA_LENGTH;
        if (ULog.DEBUG) {
            String str = "free size is " + j2;
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

    public JSONObject a(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str, String str2, String str3) {
        String str4;
        String str5;
        boolean z2;
        String strSubstring;
        Envelope envelope;
        String str6;
        JSONObject jSONObjectOptJSONObject;
        if (ULog.DEBUG && jSONObject != null && jSONObject2 != null) {
            String str7 = "headerJSONObject size is " + jSONObject.toString().getBytes().length;
            String str8 = "bodyJSONObject size is " + jSONObject2.toString().getBytes().length;
        }
        JSONObject jSONObject3 = null;
        if (context != null && jSONObject2 != null) {
            try {
                if (jSONObject2.has("analytics") && (jSONObjectOptJSONObject = jSONObject2.optJSONObject("analytics")) != null && jSONObjectOptJSONObject.has(d.f19623n)) {
                    str5 = str2;
                    z2 = true;
                } else {
                    str5 = str2;
                    z2 = false;
                }
                JSONObject jSONObjectA = a(context, str5, z2);
                if (jSONObjectA != null && jSONObject != null) {
                    jSONObjectA = a(jSONObjectA, jSONObject);
                }
                JSONObject jSONObject4 = jSONObjectA;
                if (jSONObject4 != null && jSONObject2 != null) {
                    Iterator<String> itKeys = jSONObject2.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        if (next != null && (next instanceof String) && (str6 = next) != null && jSONObject2.opt(str6) != null) {
                            try {
                                jSONObject4.put(a(str6), jSONObject2.opt(str6));
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
                if (TextUtils.isEmpty(str2)) {
                    str5 = "u";
                }
                String str9 = TextUtils.isEmpty(str3) ? "1.0.0" : str3;
                if (jSONObject4 != null) {
                    String str10 = str5 + "==" + str9 + "&=";
                    if (TextUtils.isEmpty(str10)) {
                        return a(101, jSONObject4);
                    }
                    strSubstring = str10.endsWith("&=") ? str10.substring(0, str10.length() - 2) : str10;
                } else {
                    strSubstring = null;
                }
                if (jSONObject4 != null) {
                    try {
                        e eVarA = e.a(context);
                        if (eVarA != null) {
                            eVarA.b();
                            String strEncodeToString = Base64.encodeToString(new be().a(eVarA.c()), 0);
                            if (!TextUtils.isEmpty(strEncodeToString)) {
                                JSONObject jSONObject5 = jSONObject4.getJSONObject(a("header"));
                                jSONObject5.put(a(am.Y), strEncodeToString);
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
                int iA = a(context, envelope, strSubstring, jSONObject4 != null ? jSONObject4.optJSONObject(a("header")).optString(a("app_version")) : null, str);
                if (iA != 0) {
                    return a(iA, jSONObject4);
                }
                if (ULog.DEBUG) {
                    String str11 = "constructHeader size is " + jSONObject4.toString().getBytes().length;
                }
                if (!strSubstring.startsWith(am.aD) && !strSubstring.startsWith("i") && !strSubstring.startsWith("t") && !strSubstring.startsWith("a") && !com.umeng.commonsdk.stateless.b.a()) {
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
                    }
                }
                if (jSONObject2 != null) {
                    if (jSONObject3 == null) {
                        jSONObject3 = new JSONObject();
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
        return a(110, (JSONObject) null);
    }

    private static int[] b(Context context) {
        int[] iArr = new int[3];
        try {
            SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(com.umeng.commonsdk.internal.c.a, 0);
            if (sharedPreferences != null) {
                iArr[0] = sharedPreferences.getInt(com.umeng.commonsdk.internal.c.b, 0);
                iArr[1] = sharedPreferences.getInt(com.umeng.commonsdk.internal.c.f19996c, 0);
                iArr[2] = sharedPreferences.getInt("policyGrantResult", 0);
            }
        } catch (Throwable unused) {
        }
        return iArr;
    }

    public JSONObject a(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str) {
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
            Envelope envelopeA = null;
            if (jSONObject3 != null && (envelopeA = a(context, jSONObject3.toString().getBytes())) == null) {
                return a(111, jSONObject3);
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
                String str3 = "constructHeader size is " + jSONObject3.toString().getBytes().length;
            }
            return jSONObject3;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(context, th);
            return a(110, new JSONObject());
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:163:0x03ad
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1182)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    private static org.json.JSONObject a(android.content.Context r16, java.lang.String r17, boolean r18) {
        /*
            Method dump skipped, instruction units count: 1442
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.statistics.b.a(android.content.Context, java.lang.String, boolean):org.json.JSONObject");
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
                        if (str.equals(a(d.f19618i)) && (jSONObject2.opt(str) instanceof Integer)) {
                            this.f20058k = ((Integer) jSONObject2.opt(str)).intValue();
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
        if (f20057l) {
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
        sb.append(str);
        sb.append("&&");
        sb.append(str2);
        sb.append("_");
        sb.append(System.currentTimeMillis());
        sb.append("_");
        sb.append(strB);
        sb.append(com.anythink.china.common.a.a.f6394f);
        byte[] binary = envelope.toBinary();
        if (com.umeng.commonsdk.utils.c.a()) {
            if (str.startsWith("h")) {
                return UMFrUtils.saveEnvelopeFile(context, sb.toString(), binary);
            }
            return 122;
        }
        if (str.startsWith("h")) {
            return 122;
        }
        if (!str.startsWith(am.aD) && !str.startsWith("i") && !str.startsWith("a") && !str.startsWith("t")) {
            return com.umeng.commonsdk.stateless.d.a(context, com.umeng.commonsdk.stateless.a.f20031f, sb.toString(), binary);
        }
        return UMFrUtils.saveEnvelopeFile(context, sb.toString(), binary);
    }

    public static void a(boolean z2) {
        f20057l = z2;
    }
}
