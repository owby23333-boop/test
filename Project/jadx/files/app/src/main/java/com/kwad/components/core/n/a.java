package com.kwad.components.core.n;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.r;
import com.kwad.sdk.utils.s;
import com.kwad.sdk.utils.x;
import com.taobao.accs.common.Constants;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class a extends com.kwad.sdk.core.network.d {
    private static boolean Oj = true;
    com.kwad.components.core.n.kwai.b Kj;
    private int Oi;

    public a(com.kwad.components.core.n.kwai.a aVar) {
        this(aVar.Kj, aVar.Op, aVar.Oq, aVar.Os);
        this.Oi = aVar.Or ? 1 : 0;
    }

    public a(com.kwad.components.core.n.kwai.b bVar) {
        this(bVar, null);
    }

    private a(com.kwad.components.core.n.kwai.b bVar, com.kwad.components.core.n.kwai.d dVar) {
        this(bVar, null, false, null);
    }

    public a(com.kwad.components.core.n.kwai.b bVar, @Nullable List<String> list, boolean z2, com.kwad.components.core.n.kwai.d dVar) {
        super(c(bVar), bVar.Ot);
        putBody("timestamp", System.currentTimeMillis());
        this.Kj = bVar;
        com.kwad.sdk.internal.api.a aVarPA = bVar.pA();
        if (aVarPA != null && !aVarPA.AM()) {
            a(com.kwad.sdk.core.request.model.a.xA(), aVarPA);
        }
        JSONArray jSONArray = new JSONArray();
        s.putValue(jSONArray, bVar.toJson());
        putBody("impInfo", jSONArray);
        putBody("universePhotoInfo", dVar);
        int i2 = this.Oi;
        if (i2 > 0) {
            putBody("calledUnionType", i2);
        }
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        String strTZ = TextUtils.isEmpty("") ? ((DevelopMangerComponents) com.kwad.sdk.components.c.f(DevelopMangerComponents.class)).tZ() : "";
        if (!TextUtils.isEmpty(strTZ)) {
            putBody("universeDebugParam", strTZ);
        }
        String strD = d(bVar);
        if (!TextUtils.isEmpty(strD)) {
            putBody("sdkDebugReqInfo", strD);
        }
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        if (list != null) {
            putBody("preloadIdList", new JSONArray((Collection) list));
            putBody("preloadCheck", z2);
        }
        putBody("appTag", x.Dr());
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        String strAw = this.Kj.aw("thirdUserId");
        com.kwad.sdk.core.request.model.g gVarXH = com.kwad.sdk.core.request.model.g.xH();
        if (strAw != null) {
            gVarXH.co(strAw);
        }
        if (aVarPA != null && !aVarPA.AL()) {
            a(gVarXH, aVarPA);
        }
        putBody(Constants.KEY_USER_ID, gVarXH);
    }

    private static void a(com.kwad.sdk.core.request.model.g gVar, com.kwad.sdk.internal.api.a aVar) {
        int i2 = aVar.aaB;
        if (i2 != 0) {
            gVar.aaB = i2;
        }
        int i3 = aVar.aaC;
        if (i3 != 0) {
            gVar.aaC = i3;
        }
        if (TextUtils.isEmpty(aVar.aaD)) {
            return;
        }
        gVar.aaD = aVar.aaD;
    }

    private void a(JSONObject jSONObject, com.kwad.sdk.internal.api.a aVar) {
        JSONObject jSONObject2 = new JSONObject();
        if (!TextUtils.isEmpty(aVar.aaE)) {
            s.putValue(jSONObject2, "prevTitle", aVar.aaE);
        }
        if (!TextUtils.isEmpty(aVar.aaF)) {
            s.putValue(jSONObject2, "postTitle", aVar.aaF);
        }
        if (!TextUtils.isEmpty(aVar.aaG)) {
            s.putValue(jSONObject2, "historyTitle", aVar.aaG);
        }
        if (!TextUtils.isEmpty(aVar.aaH)) {
            s.putValue(jSONObject2, "channel", aVar.aaH);
        }
        s.putValue(jSONObject, "content", jSONObject2);
        putBody("appInfo", jSONObject);
    }

    private static int c(com.kwad.components.core.n.kwai.b bVar) {
        try {
            return bVar.Ot.getScreenOrientation();
        } catch (Throwable unused) {
            return 0;
        }
    }

    private static String d(com.kwad.components.core.n.kwai.b bVar) {
        com.kwad.sdk.service.kwai.e eVar;
        if (Oj && (eVar = (com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)) != null) {
            try {
                return (String) r.c(Class.forName("com.kwad.devTools.PosConfigFetcher").newInstance(), "getConfigParamByPosId", Long.valueOf(bVar.Ot.getPosId()), eVar.getContext());
            } catch (Exception unused) {
                Oj = false;
            }
        }
        return "";
    }

    public final void aB(int i2) {
        this.Oi = i2;
    }

    public final int getAdNum() {
        return this.Kj.Ot.getAdNum();
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public SceneImpl getScene() {
        com.kwad.components.core.n.kwai.b bVar = this.Kj;
        if (bVar != null) {
            return bVar.Ot;
        }
        return null;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public String getUrl() {
        return com.kwad.sdk.c.st();
    }
}
