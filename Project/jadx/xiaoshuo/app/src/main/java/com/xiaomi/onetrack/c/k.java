package com.xiaomi.onetrack.c;

import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.xiaomi.onetrack.api.j f7637a;

    public k(com.xiaomi.onetrack.api.j jVar) {
        this.f7637a = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            List<JSONObject> listC = i.c();
            if (listC != null && listC.size() > 0) {
                for (JSONObject jSONObject : listC) {
                    this.f7637a.a(jSONObject.optString("eventName"), jSONObject.optString("data"));
                }
            }
            i.c(true);
        } catch (Exception e) {
            com.xiaomi.onetrack.util.p.b("NetworkAccessManager", "cta event error: " + e.toString());
        }
        boolean unused = i.l = false;
    }
}
