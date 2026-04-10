package com.kwad.sdk.api.loader;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.umeng.analytics.pro.an;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
final class a {

    /* JADX INFO: renamed from: com.kwad.sdk.api.loader.a$a, reason: collision with other inner class name */
    static class C0385a {
        int atB;
        String atC;
        transient File atD;
        long interval;
        String md5;
        String sdkVersion;

        C0385a() {
        }

        public final String toString() {
            return "Data{dynamicType=" + this.atB + ", dynamicUrl='" + this.atC + "', md5='" + this.md5 + "', interval=" + this.interval + ", sdkVersion='" + this.sdkVersion + "', downloadFile=" + this.atD + '}';
        }

        public final void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.atB = jSONObject.optInt("dynamicType");
            this.atC = jSONObject.optString("dynamicUrl");
            this.md5 = jSONObject.optString(TKDownloadReason.KSAD_TK_MD5);
            this.interval = jSONObject.optLong(an.aU);
            this.sdkVersion = jSONObject.optString("sdkVersion");
        }

        public final boolean Di() {
            return this.atB == 1;
        }

        public final boolean Dj() {
            return this.atB == -1;
        }
    }

    static class b {
        C0385a atE;
        String errorMsg;
        long result;

        b() {
        }

        public final void parseJson(JSONObject jSONObject) {
            this.result = jSONObject.optLong("result");
            this.errorMsg = jSONObject.optString(MediationConstant.KEY_ERROR_MSG);
            C0385a c0385a = new C0385a();
            this.atE = c0385a;
            c0385a.parseJson(jSONObject.optJSONObject("data"));
        }

        public final String toString() {
            return "UpdateData{result=" + this.result + ", errorMsg='" + this.errorMsg + "', data=" + this.atE + '}';
        }

        final boolean isLegal() {
            return this.result == 1 && this.atE != null;
        }
    }
}
