package com.bytedance.z.z;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.z.g.e.gc;
import com.bytedance.z.g.gz;
import com.bytedance.z.g.gz.uy;
import com.funny.audio.core.utils.FileUtils;
import com.umeng.analytics.pro.an;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    static volatile JSONObject z;

    public static void z(g gVar) {
        Map<String, Object> mapZ = gz.z().z();
        if (mapZ == null && mapZ.get("aid") == null) {
            return;
        }
        try {
            byte[] bytes = z(mapZ).toString().getBytes("UTF-8");
            StringBuilder sb = new StringBuilder(com.bytedance.z.g.e.g.g(mapZ));
            sb.append("?device_platform=android&version_code=137&iid=iid&aid=").append(mapZ.get("aid"));
            com.bytedance.z.g.e.g.z(new gc.z().z(sb.toString()).z(true).z(bytes).z());
        } catch (Throwable unused) {
        }
    }

    private static String z() {
        String str = Build.VERSION.RELEASE;
        return str.contains(FileUtils.FILE_EXTENSION_SEPARATOR) ? str : str + ".0";
    }

    private static JSONObject z(Map map) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("magic_tag", "ss_app_log");
        if (z == null) {
            Context contextA = gz.a();
            try {
                JSONObject jSONObject2 = new JSONObject();
                z = jSONObject2;
                jSONObject2.put(an.x, "Android");
                z.put("platform", "Android");
                z.put("sdk_lib", "Android");
                z.put(an.y, z());
                z.put("os_api", Build.VERSION.SDK_INT);
                z.put("use_apm_sdk", "1");
                z.put("sdk_version", MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME);
                z.put("sdk_version_code", MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME);
                z.put("sdk_version_name", "0.0.1-alpha.17-cloud");
                String str = Build.MODEL;
                String str2 = Build.BRAND;
                if (str == null) {
                    str = str2;
                } else if (str2 != null && !str.contains(str2)) {
                    str = str2 + ' ' + str;
                }
                z.put("device_model", str);
                z.put(an.F, Build.BRAND);
                z.put(an.H, Build.MANUFACTURER);
                if (map != null) {
                    z.put("aid", String.valueOf(map.get("aid")));
                    z.put("app_version", map.get("app_version"));
                    z.put("version_code", map.get("version_code"));
                    z.put("update_version_code", map.get("update_version_code"));
                    z.put("manifest_version_code", map.get("version_code"));
                    z.put("channel", map.get("channel"));
                }
                z.put("bd_did", gz.dl().z());
                z.put("package", contextA.getPackageName());
                z.put(an.s, contextA.getApplicationInfo().name);
                z(z);
            } catch (Exception unused) {
            }
        }
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        jSONObject.put("header", z);
        jSONObject.put("local_time", jCurrentTimeMillis);
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject3 = new JSONObject();
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        jSONObject3.put("local_time_ms", jCurrentTimeMillis2);
        jSONObject3.put("tea_event_index", 10001);
        jSONObject3.put("session_id", UUID.randomUUID().toString());
        jSONObject3.put("datetime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date(jCurrentTimeMillis2)));
        jSONArray.put(jSONObject3);
        jSONObject.put("launch", jSONArray);
        return jSONObject;
    }

    private static void z(JSONObject jSONObject) {
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
}
