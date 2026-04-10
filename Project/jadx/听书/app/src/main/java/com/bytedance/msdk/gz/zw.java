package com.bytedance.msdk.gz;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.umeng.analytics.pro.an;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class zw {
    public static JSONObject z() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(an.x, io.i());
            jSONObject.put("imei", io.q());
            jSONObject.put("imei_md5", iq.z(io.q()));
            jSONObject.put("gaid", gz.z().g());
            jSONObject.put("oaid", io.g());
            jSONObject.put("applog_did", io.z());
            jSONObject.put("device_model", io.e());
            jSONObject.put("vendor", io.p());
            jSONObject.put(com.umeng.analytics.pro.z.d, io.gk());
            jSONObject.put("ip", io.iq());
            jSONObject.put(an.o, mc.z());
            jSONObject.put("publisher_did", com.bytedance.msdk.core.z.kb().p());
            jSONObject.put("android_id", io.a());
            jSONObject.put(an.y, io.v());
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public static JSONObject z(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("imei", io.q());
            jSONObject.put("android_id", io.a());
            jSONObject.put("uuid", io.zw());
            jSONObject.put("ssid", io.uf());
            jSONObject.put("wifi_mac", io.sy());
            jSONObject.put("imsi", io.io());
            jSONObject.put("power_on_time", new StringBuilder().append(SystemClock.elapsedRealtime()).toString());
            jSONObject.put("rom_version", hh.z());
            jSONObject.put("sys_compiling_time", io.dl());
            jSONObject.put("type", io.h());
            jSONObject.put(an.x, io.i());
            jSONObject.put(an.y, io.v());
            jSONObject.put("vendor", io.p());
            jSONObject.put("device_model", io.e());
            jSONObject.put("language", io.fo());
            jSONObject.put("conn_type", io.gc());
            jSONObject.put("mac", io.l());
            jSONObject.put("screen_width", com.bytedance.msdk.z.gc.e.g(context));
            jSONObject.put("screen_height", com.bytedance.msdk.z.gc.e.dl(context));
            jSONObject.put("oaid", io.g());
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public static JSONObject g() {
        JSONObject jSONObject = new JSONObject();
        Context context = com.bytedance.msdk.core.g.getContext();
        try {
            jSONObject.put("device_id", io.z());
            jSONObject.put("user_unique_id", !TextUtils.isEmpty(io.z()) ? io.z() : UUID.randomUUID().toString());
            jSONObject.put("sdk_version", com.bytedance.msdk.g.g.g());
            jSONObject.put(PluginConstants.KEY_PLUGIN_VERSION, com.bytedance.msdk.g.g.a());
            jSONObject.put(an.x, "Android");
            jSONObject.put(an.y, io.v());
            jSONObject.put("device_model", io.e());
            jSONObject.put(an.z, com.bytedance.msdk.z.gc.e.dl(com.bytedance.msdk.core.g.getContext()) + "x" + com.bytedance.msdk.z.gc.e.g(com.bytedance.msdk.core.g.getContext()));
            jSONObject.put("language", io.fo());
            jSONObject.put(an.M, io.lq());
            jSONObject.put(an.Q, io.m());
            jSONObject.put("openudid", io.a());
            jSONObject.put("aid", "5685");
            jSONObject.put(an.s, fo.g());
            jSONObject.put("app_version", fo.z());
            jSONObject.put("package", mc.z());
            jSONObject.put(TtmlNode.TAG_REGION, Locale.getDefault().getCountry());
            jSONObject.put("tz_name", Calendar.getInstance().getTimeZone().getID());
            jSONObject.put("tz_offset", Calendar.getInstance().getTimeZone().getOffset(System.currentTimeMillis()) / 1000);
            jSONObject.put("rom", io.x());
            jSONObject.put(an.H, Build.MANUFACTURER);
            z(context, jSONObject);
            jSONObject.put("display_density", io.mc());
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("density_dpi", com.bytedance.msdk.z.gc.e.gc(context));
            jSONObject.put(an.F, Build.BRAND);
            jSONObject.put("cpu_abi", Build.CPU_ABI);
            jSONObject.put("build_serial", io.hh());
            jSONObject.put("version_code", mc.g());
            jSONObject.put("udid", io.q());
            jSONObject.put(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM, dl());
            String strIq = io.iq();
            if (TextUtils.isEmpty(strIq)) {
                strIq = "127.0.0.1";
            } else if (strIq.contains(",")) {
                strIq = z(strIq);
            }
            jSONObject.put("ip", strIq);
        } catch (Exception e) {
            com.bytedance.msdk.gc.g.g.z("getUploadEventV3Header", "exception: " + e.toString());
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        return jSONObject;
    }

    private static void z(Context context, JSONObject jSONObject) {
        ArrayList<String> arrayListZ;
        if (context == null || jSONObject == null || (arrayListZ = uy.z(context, "MD5")) == null || arrayListZ.isEmpty()) {
            return;
        }
        try {
            jSONObject.put("sig_hash", Build.MANUFACTURER);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private static JSONObject dl() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("imei", io.q());
            jSONObject.put("imei_md5", iq.z(io.q()));
            jSONObject.put("gaid", gz.z().g());
            jSONObject.put("applog_did", io.z());
            jSONObject.put("publisher_did", com.bytedance.msdk.core.z.kb().p());
            jSONObject.put("android_id", io.a());
            jSONObject.put("oaid", io.g());
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private static String z(String str) {
        String[] strArrSplit = str.split(",");
        return (strArrSplit == null || strArrSplit.length <= 0 || TextUtils.isEmpty(strArrSplit[0])) ? "127.0.0.1" : strArrSplit[0].trim();
    }
}
