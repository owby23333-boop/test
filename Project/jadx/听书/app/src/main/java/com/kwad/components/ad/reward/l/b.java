package com.kwad.components.ad.reward.l;

import com.kwad.sdk.utils.aa;
import java.util.Observable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b extends Observable implements c, com.kwad.sdk.core.b {
    private boolean AY = false;
    protected String AZ;
    protected String Ba;

    public final void kC() {
        if (this.AY) {
            return;
        }
        this.AY = true;
        kH();
    }

    public final void kD() {
        if (this.AY) {
            this.AY = false;
            kH();
        }
    }

    @Override // com.kwad.components.ad.reward.l.c
    public final String kE() {
        return this.AZ;
    }

    @Override // com.kwad.components.ad.reward.l.c
    public final String kF() {
        return this.Ba;
    }

    public boolean isCompleted() {
        return kG();
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        aa.putValue(jSONObject, "selfCompleted", this.AY);
        return jSONObject;
    }

    public void parseJson(JSONObject jSONObject) {
        try {
            this.AY = jSONObject.optBoolean("selfCompleted");
        } catch (Throwable unused) {
        }
    }

    private boolean kG() {
        return this.AY;
    }

    private void kH() {
        setChanged();
        notifyObservers(Boolean.valueOf(this.AY));
    }
}
