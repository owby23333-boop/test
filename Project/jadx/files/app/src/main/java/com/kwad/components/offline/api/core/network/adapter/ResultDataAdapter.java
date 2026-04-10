package com.kwad.components.offline.api.core.network.adapter;

import androidx.annotation.Nullable;
import com.kwad.components.offline.api.core.network.model.CommonOfflineCompoResultData;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.utils.s;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ResultDataAdapter<T extends CommonOfflineCompoResultData> extends BaseResultData {
    private static final long serialVersionUID = -6920968714292152136L;
    private final T mOfflineCompoResultData;

    public ResultDataAdapter(T t2) {
        this.mOfflineCompoResultData = t2;
    }

    public T getOfflineCompoResultData() {
        return this.mOfflineCompoResultData;
    }

    @Override // com.kwad.sdk.core.network.BaseResultData
    public boolean hasData() {
        return this.mOfflineCompoResultData.hasData();
    }

    @Override // com.kwad.sdk.core.network.BaseResultData
    public boolean isDataEmpty() {
        return this.mOfflineCompoResultData.isDataEmpty();
    }

    @Override // com.kwad.sdk.core.network.BaseResultData
    public boolean isResultOk() {
        return this.mOfflineCompoResultData.isResultOk();
    }

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        this.mOfflineCompoResultData.parseJson(jSONObject);
    }

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        s.merge(json, this.mOfflineCompoResultData.toJson());
        return json;
    }
}
