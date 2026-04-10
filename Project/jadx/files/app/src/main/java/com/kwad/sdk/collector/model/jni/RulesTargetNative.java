package com.kwad.sdk.collector.model.jni;

import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.kwad.sdk.collector.AppStatusNative;
import com.kwad.sdk.collector.model.d;
import com.kwad.sdk.service.b;
import com.kwad.sdk.utils.s;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Keep
public class RulesTargetNative extends NativeObject implements d {
    private static final long serialVersionUID = -4726982809581153390L;

    public RulesTargetNative() {
        this.mPtr = AppStatusNative.nativeCreateRulesTarget();
    }

    public RulesTargetNative(long j2) {
        this.mPtr = j2;
    }

    @Override // com.kwad.sdk.collector.model.jni.NativeObject
    public void destroy() {
        long j2 = this.mPtr;
        if (j2 != 0) {
            AppStatusNative.nativeDeleteRulesTarget(j2);
            this.mPtr = 0L;
        }
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            AppStatusNative.rulesTargetSetPackageName(this, jSONObject.optString("packageName"));
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("paths");
            if (jSONArrayOptJSONArray != null) {
                int length = jSONArrayOptJSONArray.length();
                String[] strArr = new String[length];
                for (int i2 = 0; i2 < length; i2++) {
                    strArr[i2] = jSONArrayOptJSONArray.getString(i2);
                }
                AppStatusNative.rulesTargetSetPaths(this, strArr);
            }
        } catch (Exception e2) {
            b.gatherException(e2);
            com.kwad.sdk.core.d.b.printStackTrace(e2);
        }
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        s.putValue(jSONObject, "packageName", AppStatusNative.rulesTargetGetPackageName(this));
        s.putValue(jSONObject, "paths", (List<?>) Arrays.asList(AppStatusNative.rulesTargetGetPaths(this)));
        return jSONObject;
    }
}
