package com.kwad.sdk.core.request.model;

import android.content.Context;
import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.af;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.s;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements com.kwad.sdk.core.b {
    private String ala;
    private int alb;
    private int alc;

    public static d xE() {
        Context context = ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext();
        d dVar = new d();
        dVar.ala = at.cD(context);
        dVar.alb = af.cp(context);
        dVar.alc = af.d(context, at.cG(context), as.Ea());
        return dVar;
    }

    public static d xF() {
        d dVar = new d();
        dVar.alb = af.cp(((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext());
        return dVar;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        s.putValue(jSONObject, "mac", this.ala);
        s.putValue(jSONObject, "connectionType", this.alb);
        s.putValue(jSONObject, "operatorType", this.alc);
        return jSONObject;
    }
}
