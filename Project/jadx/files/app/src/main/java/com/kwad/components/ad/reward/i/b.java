package com.kwad.components.ad.reward.i;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.s;
import java.util.Observable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b extends Observable implements c, com.kwad.sdk.core.b {
    private boolean xH = false;
    protected String xI;
    protected String xJ;

    private boolean jJ() {
        return this.xH;
    }

    private void jK() {
        setChanged();
        notifyObservers(Boolean.valueOf(this.xH));
    }

    public boolean isCompleted() {
        return jJ();
    }

    public final void jF() {
        if (this.xH) {
            return;
        }
        this.xH = true;
        jK();
    }

    public final void jG() {
        if (this.xH) {
            this.xH = false;
            jK();
        }
    }

    @Override // com.kwad.components.ad.reward.i.c
    public final String jH() {
        return this.xI;
    }

    @Override // com.kwad.components.ad.reward.i.c
    public final String jI() {
        return this.xJ;
    }

    public void parseJson(@Nullable JSONObject jSONObject) {
        try {
            this.xH = jSONObject.optBoolean("selfCompleted");
        } catch (Throwable unused) {
        }
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        s.putValue(jSONObject, "selfCompleted", this.xH);
        return jSONObject;
    }
}
