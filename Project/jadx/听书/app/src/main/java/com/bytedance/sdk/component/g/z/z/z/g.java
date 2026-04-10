package com.bytedance.sdk.component.g.z.z.z;

import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.g.z.i;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g implements z {
    @Override // com.bytedance.sdk.component.g.z.z.z.z
    public void z(com.bytedance.sdk.component.g.z.g gVar, InetSocketAddress inetSocketAddress, Proxy proxy, i iVar, IOException iOException) {
        try {
            ((com.bytedance.sdk.component.a.e) com.bytedance.sdk.openadsdk.ats.dl.z(NotificationCompat.CATEGORY_EVENT)).onExceptionEvent("okhttp_connectFailed", z(gVar), iOException);
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.g.z.z.z.z
    public void z(com.bytedance.sdk.component.g.z.g gVar, IOException iOException) {
        try {
            ((com.bytedance.sdk.component.a.e) com.bytedance.sdk.openadsdk.ats.dl.z(NotificationCompat.CATEGORY_EVENT)).onExceptionEvent("okhttp_callFailed", z(gVar), iOException);
        } catch (Exception unused) {
        }
    }

    private JSONObject z(com.bytedance.sdk.component.g.z.g gVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("url", g(gVar));
        return jSONObject;
    }

    private String g(com.bytedance.sdk.component.g.z.g gVar) throws NullPointerException {
        return gVar.z().g().toString();
    }
}
