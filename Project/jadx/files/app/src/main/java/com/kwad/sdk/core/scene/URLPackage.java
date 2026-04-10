package com.kwad.sdk.core.scene;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.d.b;
import com.kwad.sdk.core.response.kwai.a;
import com.kwad.sdk.utils.t;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class URLPackage extends a implements Serializable {
    public static final String KEY_AUTHOR_ID = "authorId";
    public static final String KEY_CHANNEL_ID = "channelId";
    public static final String KEY_TUBE_ID = "tubeId";
    private static final long serialVersionUID = -7365796297335816787L;
    public String identity;
    public transient JSONObject mJsonObjectParams;
    public int page;

    public URLPackage() {
    }

    public URLPackage(@NonNull String str, int i2) {
        this.page = i2;
        this.identity = str;
    }

    @Override // com.kwad.sdk.core.response.kwai.a
    public void afterParseJson(@Nullable JSONObject jSONObject) {
        super.afterParseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        String strOptString = jSONObject.optString("params");
        if (TextUtils.isEmpty(strOptString)) {
            return;
        }
        try {
            this.mJsonObjectParams = new JSONObject(strOptString);
        } catch (JSONException e2) {
            b.printStackTrace(e2);
        }
    }

    @Override // com.kwad.sdk.core.response.kwai.a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        JSONObject jSONObject2 = this.mJsonObjectParams;
        if (jSONObject2 != null) {
            t.putValue(jSONObject, "params", jSONObject2.toString());
        }
    }

    public void putParams(String str, long j2) {
        if (this.mJsonObjectParams == null) {
            this.mJsonObjectParams = new JSONObject();
        }
        t.putValue(this.mJsonObjectParams, str, j2);
    }
}
