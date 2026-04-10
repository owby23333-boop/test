package com.kwad.sdk.c;

import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class b implements a {
    private static volatile b asD;
    private static c asE;

    private b() {
    }

    public static synchronized b AI() {
        if (asD == null) {
            synchronized (b.class) {
                if (asD == null) {
                    asD = new b();
                }
            }
        }
        return asD;
    }

    private static String AJ() {
        return a(false, "", 2);
    }

    public static String a(boolean z2, Object obj, int i2) {
        HashMap map = new HashMap();
        map.put("userSet", String.valueOf(z2));
        map.put("value", obj);
        map.put("errorCode", String.valueOf(i2));
        return new JSONObject(map).toString();
    }

    public static void a(c cVar) {
        asE = cVar;
    }

    @Override // com.kwad.sdk.c.a
    public final String AA() {
        c cVar = asE;
        return cVar != null ? cVar.AA() : AJ();
    }

    @Override // com.kwad.sdk.c.a
    public final String AB() {
        c cVar = asE;
        return cVar != null ? cVar.AB() : AJ();
    }

    @Override // com.kwad.sdk.c.a
    public final String AC() {
        c cVar = asE;
        return cVar != null ? cVar.AC() : AJ();
    }

    @Override // com.kwad.sdk.c.a
    public final String AD() {
        c cVar = asE;
        return cVar != null ? cVar.AD() : AJ();
    }

    @Override // com.kwad.sdk.c.a
    public final String AE() {
        c cVar = asE;
        return cVar != null ? cVar.AE() : AJ();
    }

    @Override // com.kwad.sdk.c.a
    public final String AF() {
        c cVar = asE;
        return cVar != null ? cVar.AF() : AJ();
    }

    @Override // com.kwad.sdk.c.a
    public final String AG() {
        c cVar = asE;
        return cVar != null ? cVar.AG() : AJ();
    }

    @Override // com.kwad.sdk.c.a
    public final String AH() {
        c cVar = asE;
        return cVar != null ? cVar.AH() : AJ();
    }

    @Override // com.kwad.sdk.c.a
    public final String Aw() {
        c cVar = asE;
        return cVar != null ? cVar.Aw() : AJ();
    }

    @Override // com.kwad.sdk.c.a
    public final String Ax() {
        c cVar = asE;
        return cVar != null ? cVar.Ax() : AJ();
    }

    @Override // com.kwad.sdk.c.a
    public final String Ay() {
        c cVar = asE;
        return cVar != null ? cVar.Ay() : AJ();
    }

    @Override // com.kwad.sdk.c.a
    public final String Az() {
        c cVar = asE;
        return cVar != null ? cVar.Az() : AJ();
    }

    @Override // com.kwad.sdk.c.a
    public final String getAppId() {
        c cVar = asE;
        return cVar != null ? cVar.getAppId() : AJ();
    }

    @Override // com.kwad.sdk.c.a
    public final String getDeviceId() {
        c cVar = asE;
        return cVar != null ? cVar.getDeviceId() : AJ();
    }

    @Override // com.kwad.sdk.c.a
    public final String getIccId() {
        c cVar = asE;
        return cVar != null ? cVar.getIccId() : AJ();
    }

    @Override // com.kwad.sdk.c.a
    public final String getIp() {
        c cVar = asE;
        return cVar != null ? cVar.getIp() : AJ();
    }

    @Override // com.kwad.sdk.c.a
    public final String getLocation() {
        c cVar = asE;
        return cVar != null ? cVar.getLocation() : AJ();
    }

    @Override // com.kwad.sdk.c.a
    public final String getOaid() {
        c cVar = asE;
        return cVar != null ? cVar.getOaid() : AJ();
    }

    @Override // com.kwad.sdk.c.a
    public final String getSdkVersion() {
        c cVar = asE;
        return cVar != null ? cVar.getSdkVersion() : AJ();
    }
}
