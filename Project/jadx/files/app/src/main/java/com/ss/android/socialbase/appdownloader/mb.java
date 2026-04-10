package com.ss.android.socialbase.appdownloader;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class mb {
    public String b;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f18067h;
    public String hj;
    public String mb;
    public int ox = -1;

    public String mb() {
        return ox().toString();
    }

    public JSONObject ox() {
        JSONObject jSONObject = new JSONObject();
        mb(jSONObject);
        return jSONObject;
    }

    public void mb(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("ah_plan_type", this.mb);
            jSONObject.put("error_code", String.valueOf(this.ox));
            jSONObject.put("error_msg", this.b);
            jSONObject.put("real_device_plan", this.hj);
            jSONObject.put(DownloadSettingKeys.AhPlans.KEY_AH_DEVICE_PLANS, this.f18067h);
        } catch (Throwable unused) {
        }
    }

    public static mb mb(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        mb mbVar = new mb();
        try {
            JSONObject jSONObject = new JSONObject(str);
            mbVar.f18067h = jSONObject.optString(DownloadSettingKeys.AhPlans.KEY_AH_DEVICE_PLANS, null);
            mbVar.hj = jSONObject.optString("real_device_plan", null);
            mbVar.b = jSONObject.optString("error_msg", null);
            mbVar.mb = jSONObject.optString("ah_plan_type", null);
            String strOptString = jSONObject.optString("error_code");
            if (TextUtils.isEmpty(strOptString)) {
                mbVar.ox = -1;
            } else {
                mbVar.ox = Integer.parseInt(strOptString);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return mbVar;
    }
}
