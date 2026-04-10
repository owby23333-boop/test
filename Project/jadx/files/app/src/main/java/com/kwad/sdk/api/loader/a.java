package com.kwad.sdk.api.loader;

import com.bytedance.msdk.api.reward.RewardItem;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.pro.am;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
final class a {

    /* JADX INFO: renamed from: com.kwad.sdk.api.loader.a$a, reason: collision with other inner class name */
    static class C0427a {
        String Tb;
        int Za;
        String Zb;
        transient File Zc;
        long interval;
        String sdkVersion;

        C0427a() {
        }

        public final void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.Za = jSONObject.optInt("dynamicType");
            this.Zb = jSONObject.optString("dynamicUrl");
            this.Tb = jSONObject.optString("md5");
            this.interval = jSONObject.optLong(am.aU);
            this.sdkVersion = jSONObject.optString(Constants.KEY_SDK_VERSION);
        }

        public final String toString() {
            return "Data{dynamicType=" + this.Za + ", dynamicUrl='" + this.Zb + "', md5='" + this.Tb + "', interval=" + this.interval + ", sdkVersion='" + this.sdkVersion + "', downloadFile=" + this.Zc + '}';
        }

        public final boolean ty() {
            return this.Za == 1;
        }

        public final boolean tz() {
            return this.Za == -1;
        }
    }

    static class b {
        long Zd;
        C0427a Ze;
        String errorMsg;

        b() {
        }

        public final void parseJson(JSONObject jSONObject) {
            this.Zd = jSONObject.optLong("result");
            this.errorMsg = jSONObject.optString(RewardItem.KEY_ERROR_MSG);
            this.Ze = new C0427a();
            this.Ze.parseJson(jSONObject.optJSONObject("data"));
        }

        final boolean tA() {
            return this.Zd == 1 && this.Ze != null;
        }

        public final String toString() {
            return "UpdateData{result=" + this.Zd + ", errorMsg='" + this.errorMsg + "', data=" + this.Ze + '}';
        }
    }
}
