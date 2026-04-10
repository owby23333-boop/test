package com.kwad.sdk.core.request.model;

import android.location.Location;
import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.s;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements com.kwad.sdk.core.b {
    private static c akX;
    private double akY;
    private double akZ;

    public static c xD() {
        c cVar = akX;
        if (cVar != null) {
            return cVar;
        }
        Location locationBX = at.bX(((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext());
        if (locationBX != null) {
            c cVar2 = new c();
            akX = cVar2;
            cVar2.akY = locationBX.getLatitude();
            akX.akZ = locationBX.getLongitude();
        }
        return akX;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        s.putValue(jSONObject, "latitude", this.akY);
        s.putValue(jSONObject, "longitude", this.akZ);
        return jSONObject;
    }
}
