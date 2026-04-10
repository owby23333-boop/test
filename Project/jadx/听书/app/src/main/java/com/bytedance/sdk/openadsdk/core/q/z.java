package com.bytedance.sdk.openadsdk.core.q;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.bytedance.embedapplog.util.TTEncryptUtils;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.gk;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.tb;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.io;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.un.sy;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.umeng.analytics.pro.an;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z implements com.bytedance.sdk.component.gz.z.gz {
    public static final z z = new z();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f1321a;
    private int dl;
    private long g;

    public static String z(int i) {
        return i != 120 ? i != 160 ? i != 240 ? i != 320 ? i != 480 ? i != 640 ? "mdpi" : "xxxhdpi" : "xxhdpi" : "xhdpi" : "hdpi" : "mdpi" : "ldpi";
    }

    private z() {
    }

    public String z(Context context) {
        try {
            return com.bytedance.sdk.openadsdk.core.un.kb.dl(context) ? "tv" : com.bytedance.sdk.openadsdk.core.un.kb.g(context) ? "android_pad" : "android";
        } catch (Throwable unused) {
            return "android";
        }
    }

    private JSONObject z(List<com.bytedance.sdk.component.gz.z.g> list, boolean z2, boolean z3) {
        JSONObject jSONObject = new JSONObject();
        Context context = zw.getContext();
        int i = 0;
        if (z2) {
            try {
                jSONObject.put("sdk_version", gk.f1105a);
                jSONObject.put(an.s, com.bytedance.sdk.openadsdk.core.gz.z.gc());
                jSONObject.put("app_version", com.bytedance.sdk.openadsdk.core.gz.z.a());
                jSONObject.put("package", eo.fo());
                jSONObject.put(TtmlNode.TAG_REGION, Locale.getDefault().getCountry());
                jSONObject.put("tz_name", Calendar.getInstance().getTimeZone().getID());
                jSONObject.put("tz_offset", Calendar.getInstance().getTimeZone().getOffset(System.currentTimeMillis()) / 1000);
                ArrayList<String> arrayListZ = com.bytedance.sdk.component.utils.dl.z(context, "MD5");
                if (arrayListZ != null && !arrayListZ.isEmpty()) {
                    jSONObject.put("sig_hash", arrayListZ.get(0));
                }
                jSONObject.put("version_code", eo.uy());
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.wp.a("log_net", th.getMessage());
            }
        }
        jSONObject.put(com.umeng.analytics.pro.z.d, com.bytedance.sdk.openadsdk.core.un.uy.i());
        com.bytedance.sdk.openadsdk.pf.g.dl(context, jSONObject);
        jSONObject.put("openudid", com.bytedance.sdk.openadsdk.core.un.uy.z());
        jSONObject.put("oaid", com.bytedance.sdk.openadsdk.core.un.uy.dl(false));
        jSONObject.put("ad_sdk_version", gk.f1105a);
        jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, "7.1.0.5");
        jSONObject.put("is_plugin", gk.z());
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("client_ipv4", com.bytedance.sdk.openadsdk.core.un.kb.z((String) null));
        jSONObject2.put("client_ipv6", com.bytedance.sdk.openadsdk.core.un.uy.pf());
        jSONObject.put(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM, jSONObject2);
        jSONObject.put("sim_op", tb.kb());
        jSONObject.put("root", z3 ? 1 : 0);
        jSONObject.put(an.M, com.bytedance.sdk.openadsdk.core.un.uy.js());
        jSONObject.put(an.Q, com.bytedance.sdk.component.utils.v.e(context));
        jSONObject.put(an.x, "Android");
        jSONObject.put(an.y, Build.VERSION.RELEASE);
        jSONObject.put("os_api", Build.VERSION.SDK_INT);
        if (TextUtils.isEmpty(this.f1321a)) {
            this.f1321a = z(context);
        }
        jSONObject.put(an.ai, this.f1321a);
        jSONObject.put("device_model", com.bytedance.sdk.openadsdk.core.un.uy.g());
        jSONObject.put(an.F, Build.BRAND);
        jSONObject.put(an.H, Build.MANUFACTURER);
        jSONObject.put("language", Locale.getDefault().getLanguage());
        jSONObject.put(an.z, oq.gc(context) + "x" + oq.a(context));
        jSONObject.put("display_density", z(oq.gz(context)));
        jSONObject.put("density_dpi", oq.gz(context));
        jSONObject.put("device_id", tb.dl());
        int iDl = com.bytedance.sdk.component.gz.g.dl.z.dl(list, com.bytedance.sdk.component.gz.g.z.gc("csj"));
        if (iDl != 0) {
            jSONObject.put("aid", String.valueOf(iDl));
        } else {
            jSONObject.put("aid", "1371");
        }
        jSONObject.put("rom", com.bytedance.sdk.openadsdk.core.un.uy.tb());
        jSONObject.put("cpu_abi", Build.CPU_ABI);
        jSONObject.put("build_serial", com.bytedance.sdk.openadsdk.core.un.uy.kb());
        jSONObject.put("ut", this.dl);
        jSONObject.put("uid", this.g);
        jSONObject.put("locale_language", com.bytedance.sdk.openadsdk.core.un.uy.dl());
        jSONObject.put("screen_bright", Math.ceil(com.bytedance.sdk.openadsdk.core.un.kb.wp() * 10.0f) / 10.0d);
        if (!com.bytedance.sdk.openadsdk.core.un.kb.z()) {
            i = 1;
        }
        jSONObject.put("is_screen_off", i);
        if (context != null) {
            jSONObject.put("download_channel", com.bytedance.sdk.openadsdk.core.gz.z.z(context));
        }
        if (h.dl() > 0) {
            jSONObject.put("screenshot_time", String.valueOf(h.dl()));
        }
        jSONObject.put("mnc", com.bytedance.sdk.openadsdk.core.un.uy.gc());
        jSONObject.put("mcc", com.bytedance.sdk.openadsdk.core.un.uy.a());
        jSONObject.put("pan_code_serial", "1000");
        return jSONObject;
    }

    public static String kb() {
        StringBuilder sb = new StringBuilder();
        try {
            if (sy.ls()) {
                sb.append("MIUI-");
            } else if (sy.tb()) {
                sb.append("FLYME-");
            } else {
                String strQ = sy.q();
                if (sy.z(strQ)) {
                    sb.append("EMUI-");
                }
                if (!TextUtils.isEmpty(strQ)) {
                    sb.append(strQ).append("-");
                }
            }
            sb.append(Build.VERSION.INCREMENTAL);
        } catch (Throwable unused) {
        }
        return sb.toString();
    }

    @Override // com.bytedance.sdk.component.gz.z.gz
    public JSONObject z(List<com.bytedance.sdk.component.gz.z.g> list, boolean z2) {
        if (list != null && !list.isEmpty()) {
            JSONObject jSONObject = new JSONObject();
            boolean z3 = false;
            try {
                z(list.get(0));
                JSONArray jSONArray = new JSONArray();
                Iterator<com.bytedance.sdk.component.gz.z.g> it = list.iterator();
                while (it.hasNext()) {
                    JSONObject jSONObjectE = it.next().e();
                    if (TextUtils.equals("pangle_live_sdk_monitor", jSONObjectE.optString(NotificationCompat.CATEGORY_EVENT))) {
                        if (!z3) {
                            z3 = true;
                        }
                        jSONObjectE.putOpt("nt", Integer.valueOf(com.bytedance.sdk.component.utils.v.dl(zw.getContext())));
                    }
                    jSONArray.put(jSONObjectE);
                }
                jSONObject.put("header", z(list, z3, z2));
                jSONObject.put("event_v3", jSONArray);
                jSONObject.put("magic_tag", "ss_app_log");
                jSONObject.put("_gen_time", System.currentTimeMillis());
                return jSONObject;
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.wp.dl(e.getMessage());
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.gz.z.gz
    public byte[] z(JSONObject jSONObject, int i) throws Throwable {
        byte[] bArrG = g(jSONObject);
        if (bArrG == null) {
            return null;
        }
        com.bytedance.sdk.component.a.z zVarG = io.g();
        if (i > 3 && zVarG != null) {
            byte[] bArrEncrypt = zVarG.encrypt(bArrG);
            if (bArrEncrypt != null) {
                return bArrEncrypt;
            }
            v.z().z(3, -1L, "applog");
            return bArrEncrypt;
        }
        return TTEncryptUtils.a(bArrG, bArrG.length);
    }

    @Override // com.bytedance.sdk.component.gz.z.gz
    public byte[] g(JSONObject jSONObject, int i) throws Throwable {
        byte[] bArrG = g(jSONObject);
        com.bytedance.sdk.component.a.z zVarG = io.g();
        if (bArrG == null || zVarG == null || !zVarG.getArmorLoadStatus() || i <= 3) {
            return null;
        }
        byte[] bArrEncrypt = zVarG.encrypt(bArrG);
        if (bArrEncrypt != null) {
            return bArrEncrypt;
        }
        v.z().z(3, -1L, "stats");
        return bArrEncrypt;
    }

    private byte[] g(JSONObject jSONObject) throws Throwable {
        GZIPOutputStream gZIPOutputStream = null;
        if (jSONObject == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        try {
        } catch (IOException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        try {
            try {
                GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream2.write(jSONObject.toString().getBytes());
                    gZIPOutputStream2.close();
                } catch (Exception e2) {
                    e = e2;
                    gZIPOutputStream = gZIPOutputStream2;
                    com.bytedance.sdk.component.utils.wp.z(e);
                    if (gZIPOutputStream != null) {
                        gZIPOutputStream.close();
                    }
                    return byteArrayOutputStream.toByteArray();
                } catch (Throwable th) {
                    th = th;
                    gZIPOutputStream = gZIPOutputStream2;
                    if (gZIPOutputStream != null) {
                        try {
                            gZIPOutputStream.close();
                        } catch (IOException e3) {
                            com.bytedance.sdk.component.utils.wp.z(e3);
                        }
                    }
                    throw th;
                }
            } catch (Exception e4) {
                e = e4;
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.bytedance.sdk.component.gz.z.gz
    public boolean z() {
        return com.bytedance.sdk.openadsdk.core.uy.ls().vm();
    }

    @Override // com.bytedance.sdk.component.gz.z.gz
    public String g() {
        return eo.uf();
    }

    @Override // com.bytedance.sdk.component.gz.z.gz
    public long dl() {
        long jIq = zw.g().iq();
        if (jIq < 0 || jIq == 2147483647L) {
            return 5000L;
        }
        return jIq;
    }

    @Override // com.bytedance.sdk.component.gz.z.gz
    public int a() {
        int iIo = zw.g().io();
        if (iIo < 0 || iIo == Integer.MAX_VALUE) {
            return 10;
        }
        return iIo;
    }

    @Override // com.bytedance.sdk.component.gz.z.gz
    public com.bytedance.sdk.component.gz.z.z.m gc() {
        return new wp(com.bytedance.sdk.openadsdk.core.io.gc.z().g().g());
    }

    @Override // com.bytedance.sdk.component.gz.z.gz
    public String m() {
        return eo.io();
    }

    @Override // com.bytedance.sdk.component.gz.z.gz
    public String e() {
        return eo.fo("/api/ad/union/sdk/stats/batch/");
    }

    @Override // com.bytedance.sdk.component.gz.z.gz
    public boolean gz() {
        return gk.z();
    }

    @Override // com.bytedance.sdk.component.gz.z.gz
    public JSONObject z(JSONObject jSONObject) {
        return com.bytedance.sdk.component.utils.z.z(jSONObject);
    }

    @Override // com.bytedance.sdk.component.gz.z.gz
    public JSONObject fo() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("device_id", tb.dl());
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    private void z(com.bytedance.sdk.component.gz.z.g gVar) {
        String strOptString;
        if (gVar == null) {
            return;
        }
        JSONObject jSONObjectE = gVar.e();
        JSONObject jSONObjectOptJSONObject = jSONObjectE.optJSONObject("params");
        if (jSONObjectOptJSONObject != null) {
            strOptString = jSONObjectOptJSONObject.optString(MediationConstant.EXTRA_LOG_EXTRA, "");
        } else {
            strOptString = jSONObjectE.optString(MediationConstant.EXTRA_LOG_EXTRA, "");
        }
        long jA = eo.a(strOptString);
        int iGc = eo.gc(strOptString);
        if (jA == 0) {
            jA = this.g;
        }
        this.g = jA;
        if (iGc == 0) {
            iGc = this.dl;
        }
        this.dl = iGc;
    }

    public static int wp() {
        int rawOffset = TimeZone.getDefault().getRawOffset() / 3600000;
        if (rawOffset < -12) {
            rawOffset = -12;
        }
        if (rawOffset > 12) {
            return 12;
        }
        return rawOffset;
    }

    @Override // com.bytedance.sdk.component.gz.z.gz
    public int uy() {
        return zw.g().yw() ? 4 : 3;
    }
}
