package com.kwad.sdk.e;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class b implements a {
    private static volatile b aRc;
    private static c aRd;

    private b() {
    }

    public static synchronized b Mo() {
        if (aRc == null) {
            synchronized (b.class) {
                if (aRc == null) {
                    aRc = new b();
                }
            }
        }
        return aRc;
    }

    public static void a(c cVar) {
        aRd = cVar;
    }

    @Override // com.kwad.sdk.e.a
    public final String Mc() {
        c cVar = aRd;
        if (cVar != null) {
            return cVar.Mc();
        }
        return Mp();
    }

    @Override // com.kwad.sdk.e.a
    public final String getOaid() {
        c cVar = aRd;
        if (cVar != null) {
            return cVar.getOaid();
        }
        return Mp();
    }

    @Override // com.kwad.sdk.e.a
    public final String Md() {
        c cVar = aRd;
        if (cVar != null) {
            return cVar.Md();
        }
        return Mp();
    }

    @Override // com.kwad.sdk.e.a
    public final String Me() {
        c cVar = aRd;
        if (cVar != null) {
            return cVar.Me();
        }
        return Mp();
    }

    @Override // com.kwad.sdk.e.a
    public final String Mf() {
        c cVar = aRd;
        if (cVar != null) {
            return cVar.Mf();
        }
        return Mp();
    }

    @Override // com.kwad.sdk.e.a
    public final String Mg() {
        c cVar = aRd;
        if (cVar != null) {
            return cVar.Mg();
        }
        return Mp();
    }

    @Override // com.kwad.sdk.e.a
    public final String Mh() {
        c cVar = aRd;
        if (cVar != null) {
            return cVar.Mh();
        }
        return Mp();
    }

    @Override // com.kwad.sdk.e.a
    public final String getIccId() {
        c cVar = aRd;
        if (cVar != null) {
            return cVar.getIccId();
        }
        return Mp();
    }

    @Override // com.kwad.sdk.e.a
    public final String Mi() {
        c cVar = aRd;
        if (cVar != null) {
            return cVar.Mi();
        }
        return Mp();
    }

    @Override // com.kwad.sdk.e.a
    public final String Mj() {
        c cVar = aRd;
        if (cVar != null) {
            return cVar.Mj();
        }
        return Mp();
    }

    @Override // com.kwad.sdk.e.a
    public final String Mk() {
        c cVar = aRd;
        if (cVar != null) {
            return cVar.Mk();
        }
        return Mp();
    }

    @Override // com.kwad.sdk.e.a
    public final String getDeviceId() {
        c cVar = aRd;
        if (cVar != null) {
            return cVar.getDeviceId();
        }
        return Mp();
    }

    @Override // com.kwad.sdk.e.a
    public final String getIp() {
        c cVar = aRd;
        if (cVar != null) {
            return cVar.getIp();
        }
        return Mp();
    }

    @Override // com.kwad.sdk.e.a
    public final String Ml() {
        c cVar = aRd;
        if (cVar != null) {
            return cVar.Ml();
        }
        return Mp();
    }

    @Override // com.kwad.sdk.e.a
    public final String getLocation() {
        c cVar = aRd;
        if (cVar != null) {
            return cVar.getLocation();
        }
        return Mp();
    }

    @Override // com.kwad.sdk.e.a
    public final String Mm() {
        c cVar = aRd;
        if (cVar != null) {
            return cVar.Mm();
        }
        return Mp();
    }

    @Override // com.kwad.sdk.e.a
    public final String Mn() {
        c cVar = aRd;
        if (cVar != null) {
            return cVar.Mn();
        }
        return Mp();
    }

    @Override // com.kwad.sdk.e.a
    public final String getSdkVersion() {
        c cVar = aRd;
        if (cVar != null) {
            return cVar.getSdkVersion();
        }
        return Mp();
    }

    @Override // com.kwad.sdk.e.a
    public final String getAppId() {
        c cVar = aRd;
        if (cVar != null) {
            return cVar.getAppId();
        }
        return Mp();
    }

    private static String Mp() {
        return a(false, "", 2);
    }

    public static String a(boolean z, Object obj, int i) {
        HashMap map = new HashMap();
        map.put("userSet", String.valueOf(z));
        map.put("value", obj);
        map.put(MediationConstant.KEY_ERROR_CODE, String.valueOf(i));
        return new JSONObject(map).toString();
    }
}
