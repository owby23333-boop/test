package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.app.AppPackageInfo;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.cd;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class bd {
    public static String bam = "";

    private static String getSdkVersion() {
        return BuildConfig.VERSION_NAME;
    }

    static /* synthetic */ String cf(boolean z) {
        return cc(true);
    }

    static /* synthetic */ String cg(boolean z) {
        return Rq();
    }

    static /* synthetic */ String ch(boolean z) {
        return Rr();
    }

    static /* synthetic */ String ci(boolean z) {
        return cd(true);
    }

    static /* synthetic */ String cj(boolean z) {
        return ce(true);
    }

    static /* synthetic */ String ck(boolean z) {
        return Rs();
    }

    static /* synthetic */ String cl(boolean z) {
        return Rt();
    }

    static /* synthetic */ String cm(boolean z) {
        return Ru();
    }

    static /* synthetic */ String l(Context context, boolean z) {
        return e(context, true);
    }

    static /* synthetic */ String m(Context context, boolean z) {
        return f(context, true);
    }

    static /* synthetic */ String n(Context context, boolean z) {
        return g(context, true);
    }

    static /* synthetic */ String o(Context context, boolean z) {
        return h(context, true);
    }

    static /* synthetic */ String p(Context context, boolean z) {
        return i(context, true);
    }

    static /* synthetic */ String q(Context context, boolean z) {
        return j(context, true);
    }

    static /* synthetic */ String r(Context context, boolean z) {
        return k(context, true);
    }

    static /* synthetic */ String s(Context context, boolean z) {
        return dw(context);
    }

    static /* synthetic */ String t(Context context, boolean z) {
        return dy(context);
    }

    static /* synthetic */ String u(Context context, boolean z) {
        return dB(context);
    }

    static /* synthetic */ String v(Context context, boolean z) {
        return dA(context);
    }

    public static void init(Context context) {
        com.kwad.sdk.e.b.a(dC(context));
    }

    /* JADX INFO: renamed from: do, reason: not valid java name */
    public static String m618do(Context context) {
        return e(context, false);
    }

    private static String e(Context context, boolean z) {
        String strW = br.w(context, z);
        if (!z) {
            return TextUtils.isEmpty(strW) ? "" : strW;
        }
        if (!TextUtils.isEmpty(strW)) {
            return com.kwad.sdk.e.b.a(bc.usePhoneStateDisable() && !TextUtils.isEmpty(bc.getDevImei()), strW, 0);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return com.kwad.sdk.e.b.a(false, strW, 4);
        }
        if (bc.usePhoneStateDisable() || !s.PY()) {
            return com.kwad.sdk.e.b.a(false, strW, 1);
        }
        return com.kwad.sdk.e.b.a(false, strW, SystemUtil.dN(context) ? 3 : 1);
    }

    public static String getOaid() {
        return cc(false);
    }

    private static String cc(boolean z) {
        String strCn = br.cn(z);
        if (!z) {
            return TextUtils.isEmpty(strCn) ? "" : strCn;
        }
        if (!TextUtils.isEmpty(strCn)) {
            return com.kwad.sdk.e.b.a(bc.useOaidDisable() && !TextUtils.isEmpty(bc.getDevOaid()), strCn, 0);
        }
        if (bc.useOaidDisable() || !s.PU()) {
            return com.kwad.sdk.e.b.a(false, strCn, 1);
        }
        return com.kwad.sdk.e.b.a(false, strCn, 5);
    }

    public static String dp(Context context) {
        return f(context, false);
    }

    private static String f(Context context, boolean z) {
        String strDp = br.dp(context);
        if (!z) {
            return TextUtils.isEmpty(strDp) ? "" : strDp;
        }
        if (!TextUtils.isEmpty(strDp)) {
            return com.kwad.sdk.e.b.a(bc.usePhoneStateDisable() && !TextUtils.isEmpty(bc.getDevAndroidId()), strDp, 0);
        }
        if (bc.usePhoneStateDisable() || !s.PS()) {
            return com.kwad.sdk.e.b.a(false, strDp, 1);
        }
        return com.kwad.sdk.e.b.a(false, strDp, 5);
    }

    public static String dq(Context context) {
        return g(context, false);
    }

    private static String g(Context context, boolean z) {
        String strEb = br.eb(context);
        if (!z) {
            return TextUtils.isEmpty(strEb) ? "" : strEb;
        }
        if (!TextUtils.isEmpty(strEb)) {
            return com.kwad.sdk.e.b.a(bc.useMacAddressDisable() && !TextUtils.isEmpty(bc.getDevMacAddress()), strEb.toLowerCase(), 0);
        }
        if (bc.useMacAddressDisable() || !s.PT()) {
            return com.kwad.sdk.e.b.a(false, strEb, 0);
        }
        return com.kwad.sdk.e.b.a(false, strEb, au.at(context, com.kuaishou.weapon.p0.g.d) == 0 ? 3 : 1);
    }

    public static String dr(Context context) {
        return h(context, false);
    }

    private static String h(Context context, boolean z) {
        String[] strArrDV = br.dV(context);
        String str = (strArrDV == null || strArrDV.length <= 0) ? null : strArrDV[0];
        if (!z) {
            return TextUtils.isEmpty(str) ? "" : str;
        }
        if (!TextUtils.isEmpty(str)) {
            return com.kwad.sdk.e.b.a(bc.usePhoneStateDisable() && !TextUtils.isEmpty(bc.getDevImei()), str, 0);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return com.kwad.sdk.e.b.a(false, str, 4);
        }
        if (bc.usePhoneStateDisable() || !s.PY()) {
            return com.kwad.sdk.e.b.a(false, str, 1);
        }
        return com.kwad.sdk.e.b.a(false, str, SystemUtil.dN(context) ? 3 : 1);
    }

    public static String ds(Context context) {
        return i(context, false);
    }

    private static String i(Context context, boolean z) {
        String[] strArrDV = br.dV(context);
        String str = (strArrDV == null || strArrDV.length <= 1) ? null : strArrDV[1];
        if (!z) {
            return TextUtils.isEmpty(str) ? "" : str;
        }
        if (!TextUtils.isEmpty(str)) {
            return com.kwad.sdk.e.b.a(bc.usePhoneStateDisable() && !TextUtils.isEmpty(bc.getDevImei()), str, 0);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return com.kwad.sdk.e.b.a(false, str, 4);
        }
        if (bc.usePhoneStateDisable() || !s.PY()) {
            return com.kwad.sdk.e.b.a(false, str, 1);
        }
        return com.kwad.sdk.e.b.a(false, str, SystemUtil.dN(context) ? 3 : 1);
    }

    public static String dt(Context context) {
        return j(context, false);
    }

    private static String j(Context context, boolean z) {
        String strDt = br.dt(context);
        if (!z) {
            return TextUtils.isEmpty(strDt) ? "" : strDt;
        }
        if (!TextUtils.isEmpty(strDt)) {
            return com.kwad.sdk.e.b.a(bc.usePhoneStateDisable(), strDt, 0);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return com.kwad.sdk.e.b.a(false, strDt, 4);
        }
        if (bc.usePhoneStateDisable() || !s.PZ()) {
            return com.kwad.sdk.e.b.a(false, strDt, 1);
        }
        return com.kwad.sdk.e.b.a(false, strDt, SystemUtil.dN(context) ? 3 : 1);
    }

    public static String du(Context context) {
        return k(context, false);
    }

    private static String k(Context context, boolean z) {
        String strDY = br.dY(context);
        if (!z) {
            return TextUtils.isEmpty(strDY) ? "" : strDY;
        }
        if (!TextUtils.isEmpty(strDY)) {
            return com.kwad.sdk.e.b.a(bc.usePhoneStateDisable(), strDY, 0);
        }
        if (bc.usePhoneStateDisable() || !s.Qa()) {
            return com.kwad.sdk.e.b.a(false, strDY, 1);
        }
        return com.kwad.sdk.e.b.a(false, strDY, SystemUtil.dN(context) ? 3 : 1);
    }

    public static int dv(Context context) {
        return br.dW(context);
    }

    private static String dw(Context context) {
        int iDW = br.dW(context);
        if (iDW > 0) {
            return com.kwad.sdk.e.b.a(false, String.valueOf(iDW), 0);
        }
        return com.kwad.sdk.e.b.a(false, String.valueOf(iDW), 3);
    }

    public static com.kwad.sdk.l.a.f OP() {
        return com.kwad.sdk.l.a.f.OP();
    }

    public static int dx(Context context) {
        return br.dX(context);
    }

    private static String Rq() {
        com.kwad.sdk.l.a.f fVarOP = com.kwad.sdk.l.a.f.OP();
        int i = fVarOP != null ? fVarOP.aWR : -1;
        if (i >= 0) {
            return com.kwad.sdk.e.b.a(false, String.valueOf(i), 0);
        }
        if (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).Bv()) {
            return com.kwad.sdk.e.b.a(false, String.valueOf(i), 1);
        }
        return com.kwad.sdk.e.b.a(false, String.valueOf(i), 2);
    }

    public static com.kwad.sdk.l.a.b OO() {
        return com.kwad.sdk.l.a.b.OO();
    }

    private static String Rr() {
        com.kwad.sdk.l.a.b bVarOO = com.kwad.sdk.l.a.b.OO();
        if (bVarOO != null) {
            return com.kwad.sdk.e.b.a(false, bVarOO.toJson(), 0);
        }
        if (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).Bx()) {
            return com.kwad.sdk.e.b.a(false, "", 1);
        }
        return com.kwad.sdk.e.b.a(false, "", 2);
    }

    public static String getDeviceId() {
        return cd(false);
    }

    private static String cd(boolean z) {
        if (com.kwad.framework.a.a.oz.booleanValue() && !TextUtils.isEmpty(bs.getDeviceId())) {
            return bs.getDeviceId();
        }
        String deviceId = br.getDeviceId();
        if (!z) {
            return TextUtils.isEmpty(deviceId) ? "" : deviceId;
        }
        if (!TextUtils.isEmpty(deviceId)) {
            return com.kwad.sdk.e.b.a(bc.usePhoneStateDisable() && !TextUtils.isEmpty(bc.getDevAndroidId()), deviceId, 0);
        }
        if (bc.usePhoneStateDisable() || !s.PS()) {
            return com.kwad.sdk.e.b.a(false, deviceId, 1);
        }
        return com.kwad.sdk.e.b.a(false, deviceId, 5);
    }

    private static String ce(boolean z) {
        String strSh = br.Sh();
        if (!z) {
            return TextUtils.isEmpty(strSh) ? "" : strSh;
        }
        if (!TextUtils.isEmpty(strSh)) {
            return com.kwad.sdk.e.b.a(bc.useNetworkStateDisable(), strSh, 0);
        }
        if (bc.useNetworkStateDisable() || ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ai(8L)) {
            return com.kwad.sdk.e.b.a(false, strSh, 1);
        }
        return com.kwad.sdk.e.b.a(false, strSh, 2);
    }

    public static List<cd.a> o(Context context, int i) {
        return cd.o(context, 15);
    }

    private static String dy(Context context) {
        List<cd.a> listO = o(context, 15);
        if (listO != null && listO.size() > 0) {
            return com.kwad.sdk.e.b.a(bc.useNetworkStateDisable(), aa.S(listO), 0);
        }
        if (bc.useNetworkStateDisable() || ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ai(32L)) {
            return com.kwad.sdk.e.b.a(false, "", 1);
        }
        return com.kwad.sdk.e.b.a(false, "", cd.ef(context) ? 1 : 3);
    }

    private static Map<String, AppPackageInfo> dz(Context context) {
        com.kwad.sdk.components.p pVar = (com.kwad.sdk.components.p) com.kwad.sdk.components.d.f(com.kwad.sdk.components.p.class);
        if (pVar != null && s.PW()) {
            return pVar.P(context);
        }
        return new HashMap();
    }

    private static String dA(Context context) {
        com.kwad.sdk.core.c.b.Ho();
        if (!com.kwad.sdk.core.c.b.isAppOnForeground()) {
            return com.kwad.sdk.e.b.a(false, "", 5);
        }
        Map<String, AppPackageInfo> mapDz = dz(context);
        if (mapDz.size() > 0) {
            boolean z = bc.readInstalledPackagesDisable() && bc.getDevInstalledPackages() != null;
            com.kwad.sdk.components.p pVar = (com.kwad.sdk.components.p) com.kwad.sdk.components.d.f(com.kwad.sdk.components.p.class);
            if (pVar != null && s.PW()) {
                return com.kwad.sdk.e.b.a(z, pVar.c(mapDz), 0);
            }
        }
        if (bc.readInstalledPackagesDisable() || !s.PW()) {
            return com.kwad.sdk.e.b.a(false, "", 1);
        }
        return com.kwad.sdk.e.b.a(false, "", br.ed(context) ? 3 : 1);
    }

    public static com.kwad.sdk.utils.c.a cL(Context context) {
        return x.cL(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static String dB(Context context) {
        com.kwad.sdk.utils.c.a aVarCL = x.cL(context);
        if (aVarCL != null && aVarCL.bcT != null) {
            HashMap map = new HashMap();
            map.put("latitude", String.valueOf(aVarCL.bcT.getLatitude()));
            map.put("longitude", String.valueOf(aVarCL.bcT.getLongitude()));
            return com.kwad.sdk.e.b.a(bc.readLocationDisable() && bc.Ro() != null, aa.parseMap2JSON(map), 0);
        }
        if (bc.readLocationDisable() || ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ai(64L)) {
            return com.kwad.sdk.e.b.a(false, "", 1);
        }
        return com.kwad.sdk.e.b.a(false, "", (ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.g) == 0) == true ? 3 : 1);
    }

    private static String Rs() {
        return com.kwad.sdk.e.b.a(false, "1", 0);
    }

    private static String Rt() {
        return com.kwad.sdk.e.b.a(false, String.valueOf(getSdkVersion()), 0);
    }

    private static String getAppId() {
        return ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).getAppId();
    }

    private static String Ru() {
        return com.kwad.sdk.e.b.a(false, String.valueOf(getAppId()), 0);
    }

    private static com.kwad.sdk.e.c dC(final Context context) {
        return new com.kwad.sdk.e.c() { // from class: com.kwad.sdk.utils.bd.1
            @Override // com.kwad.sdk.e.a
            public final String Mc() {
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getIMEI:" + bd.l(context, true));
                return bd.l(context, true);
            }

            @Override // com.kwad.sdk.e.a
            public final String getOaid() {
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getOaid:" + bd.cf(true));
                return bd.cf(true);
            }

            @Override // com.kwad.sdk.e.a
            public final String Md() {
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getAndroidID:" + bd.m(context, true));
                return bd.m(context, true);
            }

            @Override // com.kwad.sdk.e.a
            public final String Me() {
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getMac:" + bd.n(context, true));
                return bd.n(context, true);
            }

            @Override // com.kwad.sdk.e.a
            public final String Mf() {
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getIMEI2:" + bd.o(context, true));
                return bd.o(context, true);
            }

            @Override // com.kwad.sdk.e.a
            public final String Mg() {
                String strP = bd.p(context, true);
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getIMEI2:" + strP);
                return strP;
            }

            @Override // com.kwad.sdk.e.a
            public final String Mh() {
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getIMSI:" + bd.q(context, true));
                return bd.q(context, true);
            }

            @Override // com.kwad.sdk.e.a
            public final String getIccId() {
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getIccId:" + bd.r(context, true));
                return bd.r(context, true);
            }

            @Override // com.kwad.sdk.e.a
            public final String Mi() {
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getSimCardPhoneCount:" + bd.s(context, true));
                return bd.s(context, true);
            }

            @Override // com.kwad.sdk.e.a
            public final String Mj() {
                String strCg = bd.cg(true);
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getSimCardActivePhoneCount:" + strCg);
                return strCg;
            }

            @Override // com.kwad.sdk.e.a
            public final String Mk() {
                String strCh = bd.ch(true);
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getBaseStationInfo:" + strCh);
                return strCh;
            }

            @Override // com.kwad.sdk.e.a
            public final String getDeviceId() {
                String strCi = bd.ci(true);
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getDeviceId:" + strCi);
                return strCi;
            }

            @Override // com.kwad.sdk.e.a
            public final String getIp() {
                String strCj = bd.cj(true);
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getIp:" + strCj);
                return strCj;
            }

            @Override // com.kwad.sdk.e.a
            public final String Ml() {
                String strT = bd.t(context, true);
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getWifiList:" + strT);
                return strT;
            }

            @Override // com.kwad.sdk.e.a
            public final String getLocation() {
                String strU = bd.u(context, true);
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getLocation:" + strU);
                return strU;
            }

            @Override // com.kwad.sdk.e.a
            public final String Mm() {
                String strV = bd.v(context, true);
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getAppList:" + strV);
                return strV;
            }

            @Override // com.kwad.sdk.e.a
            public final String Mn() {
                String strCk = bd.ck(true);
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getSdkType:" + strCk);
                return strCk;
            }

            @Override // com.kwad.sdk.e.a
            public final String getSdkVersion() {
                String strCl = bd.cl(true);
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getSdkVersion:" + strCl);
                return strCl;
            }

            @Override // com.kwad.sdk.e.a
            public final String getAppId() {
                String strCm = bd.cm(true);
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getAppId:" + strCm);
                return strCm;
            }
        };
    }
}
