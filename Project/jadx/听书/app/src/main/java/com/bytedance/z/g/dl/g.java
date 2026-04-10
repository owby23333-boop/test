package com.bytedance.z.g.dl;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.z.g.gz;
import com.bytedance.z.g.gz.fo;
import com.bytedance.z.g.gz.i;
import com.bytedance.z.g.gz.uy;
import com.funny.audio.core.utils.FileUtils;
import com.umeng.analytics.pro.an;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class g {
    private static final String[] z = {"version_code", "manifest_version_code", "aid", "update_version_code"};
    private JSONObject dl = new JSONObject();
    private Context g;

    public g(Context context) {
        this.g = context;
    }

    public static g z(Context context) {
        g gVar = new g(context);
        JSONObject jSONObjectZ = gVar.z();
        gVar.z(jSONObjectZ);
        gVar.dl(jSONObjectZ);
        gVar.a(jSONObjectZ);
        gVar.gc(jSONObjectZ);
        gVar.m(jSONObjectZ);
        gVar.e(jSONObjectZ);
        gVar.g(jSONObjectZ);
        return gVar;
    }

    private void z(JSONObject jSONObject) {
        int i;
        try {
            PackageInfo packageInfo = this.g.getPackageManager().getPackageInfo(this.g.getPackageName(), 0);
            if (packageInfo.applicationInfo != null && (i = packageInfo.applicationInfo.labelRes) > 0) {
                jSONObject.put(an.s, this.g.getString(i));
            }
            jSONObject.put("sdk_version", MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME);
            jSONObject.put("sdk_version_name", "0.0.1-alpha.17-cloud");
            jSONObject.put(an.x, "Android");
            jSONObject.put(an.y, dl());
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            jSONObject.put("device_model", Build.MODEL);
            jSONObject.put(an.F, Build.BRAND);
            jSONObject.put(an.H, Build.MANUFACTURER);
            jSONObject.put("cpu_abi", g());
        } catch (Exception unused) {
        }
    }

    private String g() {
        try {
            StringBuilder sb = new StringBuilder();
            if (Build.SUPPORTED_ABIS.length > 0) {
                for (int i = 0; i < Build.SUPPORTED_ABIS.length; i++) {
                    sb.append(Build.SUPPORTED_ABIS[i]);
                    if (i != Build.SUPPORTED_ABIS.length - 1) {
                        sb.append(", ");
                    }
                }
            } else {
                sb = new StringBuilder(Build.CPU_ABI);
            }
            return TextUtils.isEmpty(sb.toString()) ? "unknown" : sb.toString();
        } catch (Exception e) {
            uy.g(e);
            return "unknown";
        }
    }

    private void g(JSONObject jSONObject) {
        Map<String, Object> mapG;
        Object obj;
        com.bytedance.z.g.gc.z zVarZ = gz.z();
        if (zVarZ == null || jSONObject == null || (mapG = zVarZ.g()) == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            for (String str : mapG.keySet()) {
                if (!TextUtils.isEmpty(str) && (obj = mapG.get(str)) != null) {
                    jSONObject2.put(str, obj);
                }
            }
            jSONObject.put(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM, jSONObject2);
        } catch (Exception e) {
            uy.g(e);
        }
    }

    private String dl() {
        String str = Build.VERSION.RELEASE;
        return str.contains(FileUtils.FILE_EXTENSION_SEPARATOR) ? str : str + ".0";
    }

    private void dl(JSONObject jSONObject) {
        try {
            DisplayMetrics displayMetrics = this.g.getResources().getDisplayMetrics();
            int i = displayMetrics.densityDpi;
            String str = i != 120 ? i != 240 ? i != 320 ? "mdpi" : "xhdpi" : "hdpi" : "ldpi";
            jSONObject.put("density_dpi", i);
            jSONObject.put("display_density", str);
            jSONObject.put(an.z, displayMetrics.heightPixels + "x" + displayMetrics.widthPixels);
        } catch (Exception unused) {
        }
    }

    private void a(JSONObject jSONObject) {
        try {
            String language = this.g.getResources().getConfiguration().locale.getLanguage();
            if (!TextUtils.isEmpty(language)) {
                jSONObject.put("language", language);
            }
            String country = Locale.getDefault().getCountry();
            if (!TextUtils.isEmpty(country)) {
                jSONObject.put(TtmlNode.TAG_REGION, country);
            }
            int rawOffset = TimeZone.getDefault().getRawOffset() / 3600000;
            if (rawOffset < -12) {
                rawOffset = -12;
            }
            if (rawOffset > 12) {
                rawOffset = 12;
            }
            jSONObject.put(an.M, rawOffset);
        } catch (Exception unused) {
        }
    }

    private void gc(JSONObject jSONObject) {
        StringBuilder sb = new StringBuilder();
        try {
            if (com.bytedance.z.g.gz.dl.dl()) {
                sb.append("MIUI-");
            } else if (com.bytedance.z.g.gz.dl.a()) {
                sb.append("FLYME-");
            } else {
                String strZ = com.bytedance.z.g.gz.dl.z();
                if (com.bytedance.z.g.gz.dl.z(strZ)) {
                    sb.append("EMUI-");
                }
                if (!TextUtils.isEmpty(strZ)) {
                    sb.append(strZ).append("-");
                }
            }
            sb.append(Build.VERSION.INCREMENTAL);
            if (sb.length() > 0) {
                jSONObject.put("rom", sb.toString());
            }
            jSONObject.put("rom_version", i.z());
        } catch (Throwable unused) {
        }
    }

    private void m(JSONObject jSONObject) {
        try {
            jSONObject.put(an.Q, fo.z(this.g));
        } catch (JSONException e) {
            wp.z(e);
        }
    }

    private void e(JSONObject jSONObject) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) this.g.getSystemService("phone");
            if (telephonyManager != null) {
                String networkOperatorName = telephonyManager.getNetworkOperatorName();
                if (!TextUtils.isEmpty(networkOperatorName)) {
                    jSONObject.put(an.P, networkOperatorName);
                }
                String networkOperator = telephonyManager.getNetworkOperator();
                if (TextUtils.isEmpty(networkOperator)) {
                    return;
                }
                jSONObject.put("mcc_mnc", networkOperator);
            }
        } catch (Exception e) {
            wp.z(e);
        }
    }

    public JSONObject z(Map<String, Object> map) {
        if (map == null) {
            return this.dl;
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (!this.dl.has(entry.getKey())) {
                this.dl.put(entry.getKey(), entry.getValue());
            }
        }
        for (String str : z) {
            if (map.containsKey(str)) {
                try {
                    this.dl.put(str, Integer.parseInt((String) map.get(str)));
                } catch (Exception unused) {
                    this.dl.put(str, map.get(str));
                }
            }
        }
        if (map.containsKey("version_code") && !map.containsKey("manifest_version_code")) {
            this.dl.put("manifest_version_code", Integer.parseInt((String) map.get("version_code")));
        }
        if (map.containsKey("iid")) {
            this.dl.put("udid", map.get("iid"));
            this.dl.remove("iid");
        }
        return this.dl;
    }

    public JSONObject z(String str) {
        try {
            this.dl.put("device_id", str);
        } catch (JSONException e) {
            wp.z(e);
        }
        return this.dl;
    }

    public JSONObject g(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                this.dl.put("user_id", str);
            }
        } catch (JSONException e) {
            wp.z(e);
        }
        return this.dl;
    }

    public JSONObject z() {
        return this.dl;
    }
}
