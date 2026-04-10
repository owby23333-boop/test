package com.kwad.sdk.crash.online.monitor.kwai;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class a extends com.kwad.sdk.core.response.kwai.a {
    public double ahM;
    public int arF;
    public int arG;
    public int arH;
    public List<String> arz = new ArrayList();
    public List<String> arA = new ArrayList();
    public List<String> arB = new ArrayList();
    public List<String> arC = new ArrayList();
    public List<b> arD = new ArrayList();
    public Map<String, b> arE = new HashMap();

    public final boolean Aj() {
        return (this.arH & 4) != 0;
    }

    public final boolean Ak() {
        return (this.arH & 1) != 0;
    }

    public final boolean Al() {
        return (this.arH & 2) != 0;
    }

    public final boolean Am() {
        return this.arH == 0;
    }

    @Override // com.kwad.sdk.core.response.kwai.a
    public void afterParseJson(JSONObject jSONObject) {
        super.afterParseJson(jSONObject);
        List<b> list = this.arD;
        if (list != null) {
            for (b bVar : list) {
                this.arE.put(bVar.appId, bVar);
            }
            this.arD.clear();
        }
    }

    @Nullable
    public final b dx(String str) {
        if (this.arE == null) {
            return null;
        }
        b bVar = TextUtils.isEmpty(str) ? null : this.arE.get(str);
        return bVar == null ? this.arE.get("000000000") : bVar;
    }
}
