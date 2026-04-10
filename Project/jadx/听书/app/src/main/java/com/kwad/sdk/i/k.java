package com.kwad.sdk.i;

import com.umeng.umcrash.UMCrash;
import java.util.Iterator;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
final class k implements b {
    public JSONObject aTd = new JSONObject();
    public String actionId = UUID.randomUUID().toString();

    public k(String str, String str2, i iVar) {
        JSONObject jSONObjectMZ = h.Nd().Nh().MZ();
        Iterator<String> itKeys = jSONObjectMZ.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            c.a(jSONObjectMZ, next, jSONObjectMZ.opt(next));
        }
        c.putValue(this.aTd, "customKey", str);
        c.putValue(this.aTd, "customValue", str2);
        c.putValue(this.aTd, UMCrash.SP_KEY_TIMESTAMP, iVar.aTa);
        c.putValue(this.aTd, "actionId", this.actionId);
    }

    @Override // com.kwad.sdk.i.b
    public final JSONObject toJson() {
        return this.aTd;
    }

    public final String toString() {
        return this.aTd.toString();
    }
}
