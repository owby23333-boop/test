package com.kwad.components.core.n.kwai;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.scene.URLPackage;
import com.kwad.sdk.utils.s;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements com.kwad.sdk.core.b {
    public long OX;
    public long photoId;

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        s.putValue(jSONObject, "photoId", this.photoId);
        s.putValue(jSONObject, URLPackage.KEY_AUTHOR_ID, this.OX);
        return jSONObject;
    }
}
