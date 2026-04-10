package com.kwad.components.core.n.kwai;

import androidx.annotation.Nullable;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.s;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements com.kwad.sdk.core.b {
    public SceneImpl Ot;
    public long Ou = 0;
    public long Ov = 0;
    public String sdkExtraData;

    public b(SceneImpl sceneImpl) {
        this.Ot = sceneImpl;
        if (bd.getPosId() != 0) {
            this.Ot.setPosId(bd.getPosId());
        }
        if (bd.ES() != 0) {
            this.Ot.setAdNum((int) bd.ES());
        }
    }

    @Nullable
    public final String aw(String str) {
        Map<String, String> rewardCallbackExtraData;
        SceneImpl sceneImpl = this.Ot;
        if (sceneImpl == null || (rewardCallbackExtraData = sceneImpl.getRewardCallbackExtraData()) == null || !rewardCallbackExtraData.containsKey(str)) {
            return null;
        }
        return rewardCallbackExtraData.get(str);
    }

    @Nullable
    public final com.kwad.sdk.internal.api.a pA() {
        SceneImpl sceneImpl = this.Ot;
        if (sceneImpl == null) {
            return null;
        }
        return sceneImpl.mKsAdLabel;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject json = this.Ot.toJson();
        s.putValue(json, "pageScene", this.Ou);
        s.putValue(json, "subPageScene", this.Ov);
        s.putValue(json, "sdkExtraData", this.sdkExtraData);
        String strAw = aw("extraData");
        if (strAw != null) {
            s.putValue(json, "extraData", strAw);
        }
        return json;
    }
}
