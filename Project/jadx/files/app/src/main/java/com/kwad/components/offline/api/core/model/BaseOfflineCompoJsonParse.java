package com.kwad.components.offline.api.core.model;

import androidx.annotation.Nullable;
import com.kwad.components.offline.api.core.model.IOfflineCompoJsonParse;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseOfflineCompoJsonParse<T extends IOfflineCompoJsonParse> implements IOfflineCompoJsonParse {
    public abstract void parseJson(T t2, JSONObject jSONObject);

    @Override // com.kwad.components.offline.api.core.model.IOfflineCompoJsonParse
    public void parseJson(@Nullable JSONObject jSONObject) {
        parseJson(this, jSONObject);
    }

    @Override // com.kwad.components.offline.api.core.model.IOfflineCompoJsonParse
    public JSONObject toJson() {
        return toJson(this);
    }

    public abstract JSONObject toJson(T t2);

    public abstract JSONObject toJson(T t2, JSONObject jSONObject);
}
