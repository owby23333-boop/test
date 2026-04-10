package com.yuewen;

import android.text.TextUtils;
import com.duokan.core.diagnostic.LogLevel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public class id {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f12455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f12456b;
    public String c;
    public String d;
    public String e;

    public id(String str, String str2, String str3, String str4, String str5) {
        this.f12455a = str;
        this.f12456b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
    }

    public final boolean a(String... strArr) {
        for (String str : strArr) {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean b() {
        return a(this.f12455a, this.f12456b, this.c, this.d);
    }

    public String toString() {
        return "AppInfo{versionName='" + this.f12455a + "', developer='" + this.f12456b + "', permissionUrl='" + this.c + "', privacyUrl='" + this.d + "', introductionUrl='" + this.e + "'}";
    }

    public id() {
    }

    public id(JSONObject jSONObject) {
        try {
            this.f12455a = jSONObject.getString(xa3.f19840b);
            this.f12456b = jSONObject.getString("appDeveloper");
            this.c = jSONObject.getString("appPermission");
            this.d = jSONObject.getString("appPrivacy");
            this.e = jSONObject.getString("appIntroduction");
            if (b()) {
                ia0.w().f(LogLevel.ERROR, "appInfo", "illegal data:" + jSONObject.optString("brand") + toString());
            }
        } catch (Throwable th) {
            ia0.w().f(LogLevel.ERROR, "appInfo", "illegal data:" + jSONObject.optString("brand") + "--" + th.getMessage());
        }
    }
}
