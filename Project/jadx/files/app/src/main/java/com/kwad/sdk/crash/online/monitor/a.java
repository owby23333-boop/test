package com.kwad.sdk.crash.online.monitor;

import android.text.TextUtils;
import com.kwad.sdk.core.d.b;
import com.kwad.sdk.crash.online.monitor.block.d;
import com.kwad.sdk.crash.online.monitor.kwai.c;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.g;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static volatile boolean hasInit = false;

    private static c Ac() {
        c cVar = new c();
        cVar.arO = new com.kwad.sdk.crash.online.monitor.kwai.a();
        cVar.arO.arF = 5;
        return cVar;
    }

    static /* synthetic */ boolean access$002(boolean z2) {
        hasInit = true;
        return true;
    }

    public static void cs(final String str) {
        g.execute(new av() { // from class: com.kwad.sdk.crash.online.monitor.a.1
            @Override // com.kwad.sdk.utils.av
            public final void doTask() {
                if (a.hasInit) {
                    return;
                }
                b.d("perfMonitor.MonitorManager", "configStr:" + str);
                c cVarDm = a.dm(str);
                b.d("perfMonitor.MonitorManager", cVarDm.toJson().toString());
                d.d(cVarDm.arO);
                a.access$002(true);
            }
        });
    }

    public static c dm(String str) {
        if (TextUtils.isEmpty(str)) {
            return Ac();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            c cVar = new c();
            cVar.parseJson(jSONObject);
            return cVar;
        } catch (Exception e2) {
            b.w("perfMonitor.MonitorManager", e2);
            return Ac();
        }
    }
}
