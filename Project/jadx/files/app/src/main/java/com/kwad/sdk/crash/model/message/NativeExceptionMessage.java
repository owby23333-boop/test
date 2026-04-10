package com.kwad.sdk.crash.model.message;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.s;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeExceptionMessage extends ExceptionMessage {
    private static final long serialVersionUID = -7790706181005700630L;
    public String mFingerprint = "Unknown";
    public String mRevision = "Unknown";
    public String mRegister = "Unknown";
    public String mSignal = "Unknown";
    public String mCode = "Unknown";
    public String mManuallyKill = "Unknown";
    public String mFaultAddr = "Unknown";
    public String mAbortMsg = "";

    public NativeExceptionMessage() {
        this.mExceptionType = 4;
    }

    @Override // com.kwad.sdk.crash.model.message.ExceptionMessage
    protected final String getTypePrefix() {
        return "NATIVE_";
    }

    @Override // com.kwad.sdk.crash.model.message.ExceptionMessage, com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        this.mFingerprint = jSONObject.optString("mFingerprint");
        this.mRevision = jSONObject.optString("mRevision");
        this.mRegister = jSONObject.optString("mRegister");
        this.mSignal = jSONObject.optString("mSignal");
        this.mCode = jSONObject.optString("mCode");
        this.mManuallyKill = jSONObject.optString("mManuallyKill");
        this.mFaultAddr = jSONObject.optString("mFaultAddr");
        this.mAbortMsg = jSONObject.optString("mAbortMsg");
    }

    @Override // com.kwad.sdk.crash.model.message.ExceptionMessage, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject json = super.toJson();
        s.putValue(json, "mFingerprint", this.mFingerprint);
        s.putValue(json, "mRevision", this.mRevision);
        s.putValue(json, "mRegister", this.mRegister);
        s.putValue(json, "mSignal", this.mSignal);
        s.putValue(json, "mCode", this.mCode);
        s.putValue(json, "mManuallyKill", this.mManuallyKill);
        s.putValue(json, "mFaultAddr", this.mFaultAddr);
        s.putValue(json, "mAbortMsg", this.mAbortMsg);
        return json;
    }
}
