package com.kwad.sdk.contentalliance.a.a;

import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.n;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    public long adStyle;
    public long clickTime;
    public int contentType;
    public long photoId;

    public a() {
        this.clickTime = -1L;
    }

    public a(AdTemplate adTemplate, long j) {
        this.clickTime = -1L;
        this.photoId = e.er(adTemplate);
        this.clickTime = j;
        this.adStyle = e.eg(adTemplate);
        this.contentType = e.eh(adTemplate);
    }

    public static a bQ(AdTemplate adTemplate) {
        return new a(adTemplate, n.eN(adTemplate));
    }

    public final String Ek() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("contentType", this.contentType);
            jSONObject.put("adStyle", this.adStyle);
        } catch (JSONException e) {
            c.printStackTrace(e);
        }
        return jSONObject.toString();
    }
}
