package com.kwad.sdk.crash.report;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.s;
import java.io.Serializable;
import org.android.agoo.common.AgooConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ReportEvent implements com.kwad.sdk.core.b, Serializable {
    private static final long serialVersionUID = 8652448382850235426L;
    public long clientIncrementId;
    public long clientTimeStamp;
    public String sessionId;
    public StatPackage statPackage;
    public String timeZone;

    public static class CustomStatEvent implements com.kwad.sdk.core.b, Serializable {
        private static final long serialVersionUID = 5177557263564436342L;
        public String key;
        public String value;

        @Override // com.kwad.sdk.core.b
        public void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.key = jSONObject.optString("key");
            this.value = jSONObject.optString("value");
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            s.putValue(jSONObject, "key", this.key);
            s.putValue(jSONObject, "value", this.value);
            return jSONObject;
        }
    }

    public static class ExceptionEvent implements com.kwad.sdk.core.b, Serializable {
        private static final long serialVersionUID = 5177557263564436344L;
        public String flag;
        public String message;
        public int type;
        public UrlPackage urlPackage;

        @Override // com.kwad.sdk.core.b
        public void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.type = jSONObject.optInt("type");
            this.message = jSONObject.optString("message");
            this.urlPackage.parseJson(jSONObject.optJSONObject("urlPackage"));
            this.flag = jSONObject.optString(AgooConstants.MESSAGE_FLAG);
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            s.putValue(jSONObject, "type", this.type);
            s.putValue(jSONObject, "message", this.message);
            s.a(jSONObject, "urlPackage", this.urlPackage);
            s.putValue(jSONObject, AgooConstants.MESSAGE_FLAG, this.flag);
            return jSONObject;
        }
    }

    public static class StatPackage implements com.kwad.sdk.core.b, Serializable {
        private static final long serialVersionUID = -6225392281821567840L;
        public CustomStatEvent customStatEvent;
        public ExceptionEvent exceptionEvent;

        @Override // com.kwad.sdk.core.b
        public void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.exceptionEvent.parseJson(jSONObject.optJSONObject("exceptionEvent"));
            this.customStatEvent.parseJson(jSONObject.optJSONObject("customStatEvent"));
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            s.a(jSONObject, "exceptionEvent", this.exceptionEvent);
            s.a(jSONObject, "customStatEvent", this.customStatEvent);
            return jSONObject;
        }
    }

    public static class UrlPackage implements com.kwad.sdk.core.b, Serializable {
        private static final long serialVersionUID = 2535768638193007414L;
        public String identity;
        public String page;
        public int pageType;
        public String params;

        @Override // com.kwad.sdk.core.b
        public void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.page = jSONObject.optString("page");
            this.params = jSONObject.optString("params");
            this.identity = jSONObject.optString("identity");
            this.pageType = jSONObject.optInt("pageType");
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            s.putValue(jSONObject, "page", this.page);
            s.putValue(jSONObject, "params", this.params);
            s.putValue(jSONObject, "identity", this.identity);
            s.putValue(jSONObject, "pageType", this.pageType);
            return jSONObject;
        }
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.clientTimeStamp = jSONObject.optLong("clientTimeStamp");
        this.clientIncrementId = jSONObject.optLong("clientIncrementId");
        this.sessionId = jSONObject.optString("sessionId");
        this.statPackage.parseJson(jSONObject.optJSONObject("statPackage"));
        this.timeZone = jSONObject.optString("timeZone");
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        s.putValue(jSONObject, "clientTimeStamp", this.clientTimeStamp);
        s.putValue(jSONObject, "clientIncrementId", this.clientIncrementId);
        s.putValue(jSONObject, "sessionId", this.sessionId);
        s.a(jSONObject, "statPackage", this.statPackage);
        s.putValue(jSONObject, "timeZone", this.timeZone);
        return jSONObject;
    }
}
