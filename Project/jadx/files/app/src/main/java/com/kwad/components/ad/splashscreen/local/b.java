package com.kwad.components.ad.splashscreen.local;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.x;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static void H(Context context) {
        a aVarS = S(context);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (aVarS == null) {
            aVarS = new a(jCurrentTimeMillis, 1);
        } else if (aVarS.e(jCurrentTimeMillis)) {
            aVarS.gq++;
        } else {
            aVarS.gp = jCurrentTimeMillis;
            aVarS.gq = 1;
        }
        a(context, aVarS);
    }

    @Nullable
    private static a S(Context context) {
        if (context == null) {
            return null;
        }
        try {
            String strDt = x.Dt();
            if (TextUtils.isEmpty(strDt)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(strDt);
            a aVar = new a();
            aVar.parseJson(jSONObject);
            return aVar;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            return null;
        }
    }

    @Nullable
    private static a T(Context context) {
        if (context == null) {
            return null;
        }
        try {
            String strDv = x.Dv();
            if (TextUtils.isEmpty(strDv)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(strDv);
            a aVar = new a();
            aVar.parseJson(jSONObject);
            return aVar;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            return null;
        }
    }

    public static void U(Context context) {
        a aVarT = T(context);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (aVarT == null) {
            aVarT = new a(jCurrentTimeMillis, 1);
        } else if (aVarT.e(jCurrentTimeMillis)) {
            aVarT.gq++;
        } else {
            aVarT.gp = jCurrentTimeMillis;
            aVarT.gq = 1;
        }
        if (context == null || aVarT == null) {
            return;
        }
        x.ad(context, aVarT.toJson().toString());
    }

    public static void V(Context context) {
        a aVarW = W(context);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (aVarW == null) {
            aVarW = new a(jCurrentTimeMillis, 1);
        } else if (aVarW.e(jCurrentTimeMillis)) {
            aVarW.gq++;
        } else {
            aVarW.gp = jCurrentTimeMillis;
            aVarW.gq = 1;
        }
        if (context == null || aVarW == null) {
            return;
        }
        x.ab(context, aVarW.toJson().toString());
    }

    @Nullable
    private static a W(Context context) {
        if (context == null) {
            return null;
        }
        try {
            String strCl = x.cl(context);
            if (TextUtils.isEmpty(strCl)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(strCl);
            a aVar = new a();
            aVar.parseJson(jSONObject);
            return aVar;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            return null;
        }
    }

    @Nullable
    private static a X(Context context) {
        if (context == null) {
            return null;
        }
        try {
            String strCm = x.cm(context);
            if (TextUtils.isEmpty(strCm)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(strCm);
            a aVar = new a();
            aVar.parseJson(jSONObject);
            return aVar;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            return null;
        }
    }

    public static void Y(Context context) {
        a aVarX = X(context);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (aVarX == null) {
            aVarX = new a(jCurrentTimeMillis, 1);
        } else if (aVarX.e(jCurrentTimeMillis)) {
            aVarX.gq++;
        } else {
            aVarX.gp = jCurrentTimeMillis;
            aVarX.gq = 1;
        }
        if (context == null || aVarX == null) {
            return;
        }
        x.ac(context, aVarX.toJson().toString());
    }

    private static void a(Context context, a aVar) {
        if (context == null || aVar == null) {
            com.kwad.sdk.core.d.b.d("SplashLocalHelper", "saveSplashLocalInfo illegal arguments.");
        } else {
            x.ej(aVar.toJson().toString());
        }
    }

    public static boolean e(Context context, AdInfo adInfo) {
        a aVarT = T(context);
        return !(aVarT == null || !aVarT.z(adInfo.adMatrixInfo.adDataV2.splashEndCardTKInfo.endCardCountDaily));
    }
}
