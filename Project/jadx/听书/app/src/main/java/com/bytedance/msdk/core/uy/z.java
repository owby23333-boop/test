package com.bytedance.msdk.core.uy;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.msdk.api.a.z.g.dl.g f413a;
    private String dl;
    private String g;
    private String z;

    public z(String str, String str2, String str3) {
        this.z = str;
        this.g = str2;
        this.dl = str3;
        this.f413a = new com.bytedance.msdk.api.a.z.g.dl.g();
    }

    public z(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        this.z = str;
        this.g = str2;
        this.dl = str3;
        this.f413a = new com.bytedance.msdk.api.a.z.g.dl.g(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12);
    }

    public String z() {
        return this.z;
    }

    public String g() {
        return this.g;
    }

    public String dl() {
        return this.dl;
    }

    public com.bytedance.msdk.api.a.z.g.dl.g a() {
        return this.f413a;
    }

    public boolean gc() {
        com.bytedance.msdk.api.a.z.g.dl.g gVar = this.f413a;
        return gVar != null && gVar.a();
    }

    public String m() {
        com.bytedance.msdk.api.a.z.g.dl.g gVar = this.f413a;
        if (gVar != null) {
            return gVar.g();
        }
        return null;
    }

    public static z z(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String strOptString = jSONObject.optString(PluginConstants.KEY_APP_ID);
        String strOptString2 = jSONObject.optString("app_key");
        String strOptString3 = jSONObject.optString("custom_type");
        if (!TextUtils.equals(strOptString3, "1")) {
            return new z(str, strOptString, strOptString2);
        }
        return new z(str, strOptString, strOptString2, jSONObject.optString("init_class_name"), jSONObject.optString("banner_class_name"), jSONObject.optString("interstitial_class_name"), jSONObject.optString("reward_class_name"), jSONObject.optString("full_video_class_name"), jSONObject.optString("splash_class_name"), jSONObject.optString("feed_class_name"), jSONObject.optString("draw_class_name"), strOptString3);
    }

    public String toString() {
        return "AdNetworkConfValue{mAdnName='" + this.z + "'mAppId='" + this.g + "', mAppKey='" + this.dl + "', mGMCustomConfig=" + this.f413a + '}';
    }
}
