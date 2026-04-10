package com.kwad.sdk.crash.online.monitor.a;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class a extends com.kwad.sdk.core.response.a.a {
    public List<String> aPW = new ArrayList();
    public List<String> aPX = new ArrayList();
    public List<String> aPY = new ArrayList();
    public List<String> aPZ = new ArrayList();
    public List<b> aQa = new ArrayList();
    public Map<String, b> aQb = new HashMap();
    public int aQc;
    public int aQd;
    public int aQe;
    public double avY;

    @Override // com.kwad.sdk.core.response.a.a
    public void afterParseJson(JSONObject jSONObject) {
        super.afterParseJson(jSONObject);
        List<b> list = this.aQa;
        if (list != null) {
            for (b bVar : list) {
                this.aQb.put(bVar.appId, bVar);
            }
            this.aQa.clear();
        }
    }

    public final boolean LQ() {
        return (this.aQe & 4) != 0;
    }

    public final boolean LR() {
        return (this.aQe & 1) != 0;
    }

    public final boolean LS() {
        return (this.aQe & 2) != 0;
    }

    public final boolean LT() {
        return this.aQe == 0;
    }

    public final b fN(String str) {
        if (this.aQb == null) {
            return null;
        }
        b bVar = TextUtils.isEmpty(str) ? null : this.aQb.get(str);
        return bVar == null ? this.aQb.get("000000000") : bVar;
    }
}
