package com.kwad.sdk.utils;

import android.content.Context;
import android.location.Location;
import android.os.Build;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.InstalledAppInfoManager;
import com.kwad.sdk.utils.bn;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class at {
    public static String azg = "";

    public static com.kwad.sdk.g.kwai.b Ct() {
        return com.kwad.sdk.g.kwai.b.Ct();
    }

    public static com.kwad.sdk.g.kwai.f Cu() {
        return com.kwad.sdk.g.kwai.f.Cu();
    }

    private static String Ee() {
        com.kwad.sdk.g.kwai.f fVarCu = com.kwad.sdk.g.kwai.f.Cu();
        int i2 = fVarCu != null ? fVarCu.axf : -1;
        if (i2 >= 0) {
            return com.kwad.sdk.c.b.a(false, String.valueOf(i2), 0);
        }
        boolean zSM = ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).sM();
        String strValueOf = String.valueOf(i2);
        return !zSM ? com.kwad.sdk.c.b.a(false, strValueOf, 1) : com.kwad.sdk.c.b.a(false, strValueOf, 2);
    }

    private static String Ef() {
        com.kwad.sdk.g.kwai.b bVarCt = com.kwad.sdk.g.kwai.b.Ct();
        return bVarCt != null ? com.kwad.sdk.c.b.a(false, bVarCt.toJson(), 0) : !((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).sO() ? com.kwad.sdk.c.b.a(false, "", 1) : com.kwad.sdk.c.b.a(false, "", 2);
    }

    public static List<com.kwad.sdk.g.kwai.e> Eg() {
        return aw.Eg();
    }

    private static String Eh() {
        return com.kwad.sdk.c.b.a(false, "1", 0);
    }

    private static String Ei() {
        return com.kwad.sdk.c.b.a(false, String.valueOf(getSdkVersion()), 0);
    }

    private static String Ej() {
        return com.kwad.sdk.c.b.a(false, String.valueOf(getAppId()), 0);
    }

    static /* synthetic */ String bA(boolean z2) {
        return Eh();
    }

    static /* synthetic */ String bB(boolean z2) {
        return Ei();
    }

    static /* synthetic */ String bC(boolean z2) {
        return Ej();
    }

    public static Location bX(Context context) {
        return q.bX(context);
    }

    private static String bs(boolean z2) {
        String strBD = bc.bD(z2);
        if (!z2) {
            return TextUtils.isEmpty(strBD) ? "" : strBD;
        }
        if (TextUtils.isEmpty(strBD)) {
            return (as.DY() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).D(PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH)) ? com.kwad.sdk.c.b.a(false, strBD, 1) : com.kwad.sdk.c.b.a(false, strBD, 5);
        }
        return com.kwad.sdk.c.b.a(as.DY() && !TextUtils.isEmpty(as.DZ()), strBD, 0);
    }

    private static String bt(boolean z2) {
        if (com.kwad.b.kwai.a.bI.booleanValue() && !TextUtils.isEmpty(bd.getDeviceId())) {
            return bd.getDeviceId();
        }
        String deviceId = bc.getDeviceId();
        if (!z2) {
            return TextUtils.isEmpty(deviceId) ? "" : deviceId;
        }
        if (TextUtils.isEmpty(deviceId)) {
            return (as.DS() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).D(2L)) ? com.kwad.sdk.c.b.a(false, deviceId, 1) : com.kwad.sdk.c.b.a(false, deviceId, 5);
        }
        return com.kwad.sdk.c.b.a(as.DS() && !TextUtils.isEmpty(as.DV()), deviceId, 0);
    }

    private static String bu(boolean z2) {
        String strEO = bc.EO();
        return !z2 ? TextUtils.isEmpty(strEO) ? "" : strEO : !TextUtils.isEmpty(strEO) ? com.kwad.sdk.c.b.a(as.Ea(), strEO, 0) : (as.Ea() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).D(8L)) ? com.kwad.sdk.c.b.a(false, strEO, 1) : com.kwad.sdk.c.b.a(false, strEO, 2);
    }

    static /* synthetic */ String bv(boolean z2) {
        return bs(true);
    }

    static /* synthetic */ String bw(boolean z2) {
        return Ee();
    }

    static /* synthetic */ String bx(boolean z2) {
        return Ef();
    }

    static /* synthetic */ String by(boolean z2) {
        return bt(true);
    }

    static /* synthetic */ String bz(boolean z2) {
        return bu(true);
    }

    private static String c(Context context, boolean z2) {
        String strU = bc.u(context, z2);
        if (!z2) {
            return TextUtils.isEmpty(strU) ? "" : strU;
        }
        if (!TextUtils.isEmpty(strU)) {
            return com.kwad.sdk.c.b.a(as.DS() && !TextUtils.isEmpty(as.DT()), strU, 0);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return com.kwad.sdk.c.b.a(false, strU, 4);
        }
        if (as.DS() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).D(1L)) {
            return com.kwad.sdk.c.b.a(false, strU, 1);
        }
        return com.kwad.sdk.c.b.a(false, strU, SystemUtil.dd(context) ? 3 : 1);
    }

    public static String cB(Context context) {
        return c(context, false);
    }

    public static String cC(Context context) {
        return d(context, false);
    }

    public static String cD(Context context) {
        return e(context, false);
    }

    public static String cE(Context context) {
        return f(context, false);
    }

    public static String cF(Context context) {
        return g(context, false);
    }

    public static String cG(Context context) {
        return h(context, false);
    }

    public static String cH(Context context) {
        return i(context, false);
    }

    public static int cI(Context context) {
        return bc.dk(context);
    }

    private static String cJ(Context context) {
        int iDk = bc.dk(context);
        if (iDk > 0) {
            return com.kwad.sdk.c.b.a(false, String.valueOf(iDk), 0);
        }
        int i2 = Build.VERSION.SDK_INT;
        String strValueOf = String.valueOf(iDk);
        return i2 < 23 ? com.kwad.sdk.c.b.a(false, strValueOf, 1) : com.kwad.sdk.c.b.a(false, strValueOf, 3);
    }

    public static int cK(Context context) {
        return bc.dl(context);
    }

    private static String cL(Context context) {
        List<bn.a> listM = m(context, 15);
        if (listM != null && listM.size() > 0) {
            return com.kwad.sdk.c.b.a(as.Ea(), s.E(listM), 0);
        }
        if (as.Ea() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).D(32L)) {
            return com.kwad.sdk.c.b.a(false, "", 1);
        }
        return com.kwad.sdk.c.b.a(false, "", bn.ds(context) ? 1 : 3);
    }

    private static String cM(Context context) {
        Map<String, InstalledAppInfoManager.AppPackageInfo> mapBZ = InstalledAppInfoManager.bZ(context);
        if (mapBZ.size() > 0) {
            return com.kwad.sdk.c.b.a(as.Ec() && as.Ed() != null, InstalledAppInfoManager.e(mapBZ), 0);
        }
        if (as.Ec() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).D(16L)) {
            return com.kwad.sdk.c.b.a(false, "", 1);
        }
        return com.kwad.sdk.c.b.a(false, "", bc.dr(context) ? 3 : 1);
    }

    private static String cN(Context context) {
        Location locationBX = q.bX(context);
        if (locationBX != null) {
            HashMap map = new HashMap();
            map.put("latitude", String.valueOf(locationBX.getLatitude()));
            map.put("longitude", String.valueOf(locationBX.getLongitude()));
            return com.kwad.sdk.c.b.a(as.DQ() && as.DR() != null, s.parseMap2JSON(map), 0);
        }
        if (as.DQ() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).D(64L)) {
            return com.kwad.sdk.c.b.a(false, "", 1);
        }
        return com.kwad.sdk.c.b.a(false, "", ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.f16727g) == 0 ? 3 : 1);
    }

    @NonNull
    private static com.kwad.sdk.c.c cO(final Context context) {
        return new com.kwad.sdk.c.c() { // from class: com.kwad.sdk.utils.at.1
            @Override // com.kwad.sdk.c.a
            public final String AA() {
                String strN = at.n(context, true);
                com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getIMEI2:" + strN);
                return strN;
            }

            @Override // com.kwad.sdk.c.a
            public final String AB() {
                com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getIMSI:" + at.o(context, true));
                return at.o(context, true);
            }

            @Override // com.kwad.sdk.c.a
            public final String AC() {
                com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getSimCardPhoneCount:" + at.q(context, true));
                return at.q(context, true);
            }

            @Override // com.kwad.sdk.c.a
            public final String AD() {
                String strBw = at.bw(true);
                com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getSimCardActivePhoneCount:" + strBw);
                return strBw;
            }

            @Override // com.kwad.sdk.c.a
            public final String AE() {
                String strBx = at.bx(true);
                com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getBaseStationInfo:" + strBx);
                return strBx;
            }

            @Override // com.kwad.sdk.c.a
            public final String AF() {
                String strR = at.r(context, true);
                com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getWifiList:" + strR);
                return strR;
            }

            @Override // com.kwad.sdk.c.a
            public final String AG() {
                String strT = at.t(context, true);
                com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getAppList:" + strT);
                return strT;
            }

            @Override // com.kwad.sdk.c.a
            public final String AH() {
                String strBA = at.bA(true);
                com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getSdkType:" + strBA);
                return strBA;
            }

            @Override // com.kwad.sdk.c.a
            public final String Aw() {
                com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getIMEI:" + at.j(context, true));
                return at.j(context, true);
            }

            @Override // com.kwad.sdk.c.a
            public final String Ax() {
                com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getAndroidID:" + at.k(context, true));
                return at.k(context, true);
            }

            @Override // com.kwad.sdk.c.a
            public final String Ay() {
                com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getMac:" + at.l(context, true));
                return at.l(context, true);
            }

            @Override // com.kwad.sdk.c.a
            public final String Az() {
                com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getIMEI2:" + at.m(context, true));
                return at.m(context, true);
            }

            @Override // com.kwad.sdk.c.a
            public final String getAppId() {
                String strBC = at.bC(true);
                com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getAppId:" + strBC);
                return strBC;
            }

            @Override // com.kwad.sdk.c.a
            public final String getDeviceId() {
                String strBy = at.by(true);
                com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getDeviceId:" + strBy);
                return strBy;
            }

            @Override // com.kwad.sdk.c.a
            public final String getIccId() {
                com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getIccId:" + at.p(context, true));
                return at.p(context, true);
            }

            @Override // com.kwad.sdk.c.a
            public final String getIp() {
                String strBz = at.bz(true);
                com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getIp:" + strBz);
                return strBz;
            }

            @Override // com.kwad.sdk.c.a
            public final String getLocation() {
                String strS = at.s(context, true);
                com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getLocation:" + strS);
                return strS;
            }

            @Override // com.kwad.sdk.c.a
            public final String getOaid() {
                com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getOaid:" + at.bv(true));
                return at.bv(true);
            }

            @Override // com.kwad.sdk.c.a
            public final String getSdkVersion() {
                String strBB = at.bB(true);
                com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getSdkVersion:" + strBB);
                return strBB;
            }
        };
    }

    private static String d(Context context, boolean z2) {
        String strCC = bc.cC(context);
        if (!z2) {
            return TextUtils.isEmpty(strCC) ? "" : strCC;
        }
        if (TextUtils.isEmpty(strCC)) {
            return (as.DS() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).D(2L)) ? com.kwad.sdk.c.b.a(false, strCC, 1) : com.kwad.sdk.c.b.a(false, strCC, 5);
        }
        return com.kwad.sdk.c.b.a(as.DS() && !TextUtils.isEmpty(as.DV()), strCC, 0);
    }

    private static String e(Context context, boolean z2) {
        String strDp = bc.dp(context);
        if (!z2) {
            return TextUtils.isEmpty(strDp) ? "" : strDp;
        }
        if (!TextUtils.isEmpty(strDp)) {
            return com.kwad.sdk.c.b.a(as.DW() && !TextUtils.isEmpty(as.DX()), strDp.toLowerCase(), 0);
        }
        if (as.DW() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).D(4L)) {
            return com.kwad.sdk.c.b.a(false, strDp, 0);
        }
        return com.kwad.sdk.c.b.a(false, strDp, ak.al(context, "android.permission.ACCESS_WIFI_STATE") == 0 ? 3 : 1);
    }

    private static String f(Context context, boolean z2) {
        String[] strArrDj = bc.dj(context);
        String str = (strArrDj == null || strArrDj.length <= 0) ? null : strArrDj[0];
        if (!z2) {
            return TextUtils.isEmpty(str) ? "" : str;
        }
        if (!TextUtils.isEmpty(str)) {
            return com.kwad.sdk.c.b.a(as.DS() && !TextUtils.isEmpty(as.DT()), str, 0);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return com.kwad.sdk.c.b.a(false, str, 4);
        }
        if (as.DS() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).D(1L)) {
            return com.kwad.sdk.c.b.a(false, str, 1);
        }
        return com.kwad.sdk.c.b.a(false, str, SystemUtil.dd(context) ? 3 : 1);
    }

    private static String g(Context context, boolean z2) {
        String[] strArrDj = bc.dj(context);
        String str = (strArrDj == null || strArrDj.length <= 1) ? null : strArrDj[1];
        if (!z2) {
            return TextUtils.isEmpty(str) ? "" : str;
        }
        if (!TextUtils.isEmpty(str)) {
            return com.kwad.sdk.c.b.a(as.DS() && !TextUtils.isEmpty(as.DT()), str, 0);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return com.kwad.sdk.c.b.a(false, str, 4);
        }
        if (as.DS() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).D(1L)) {
            return com.kwad.sdk.c.b.a(false, str, 1);
        }
        return com.kwad.sdk.c.b.a(false, str, SystemUtil.dd(context) ? 3 : 1);
    }

    private static String getAppId() {
        return ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).getAppId();
    }

    public static String getDeviceId() {
        return bt(false);
    }

    public static String getOaid() {
        return bs(false);
    }

    private static String getSdkVersion() {
        return "3.3.38";
    }

    private static String h(Context context, boolean z2) {
        String strCG = bc.cG(context);
        if (!z2) {
            return TextUtils.isEmpty(strCG) ? "" : strCG;
        }
        if (!TextUtils.isEmpty(strCG)) {
            return com.kwad.sdk.c.b.a(as.DS(), strCG, 0);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return com.kwad.sdk.c.b.a(false, strCG, 4);
        }
        if (as.DS() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).D(128L)) {
            return com.kwad.sdk.c.b.a(false, strCG, 1);
        }
        return com.kwad.sdk.c.b.a(false, strCG, SystemUtil.dd(context) ? 3 : 1);
    }

    private static String i(Context context, boolean z2) {
        String strDm = bc.dm(context);
        if (!z2) {
            return TextUtils.isEmpty(strDm) ? "" : strDm;
        }
        if (!TextUtils.isEmpty(strDm)) {
            return com.kwad.sdk.c.b.a(as.DS(), strDm, 0);
        }
        if (as.DS() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).D(128L)) {
            return com.kwad.sdk.c.b.a(false, strDm, 1);
        }
        return com.kwad.sdk.c.b.a(false, strDm, SystemUtil.dd(context) ? 3 : 1);
    }

    public static void init(Context context) {
        com.kwad.sdk.c.b.a(cO(context));
    }

    static /* synthetic */ String j(Context context, boolean z2) {
        return c(context, true);
    }

    static /* synthetic */ String k(Context context, boolean z2) {
        return d(context, true);
    }

    static /* synthetic */ String l(Context context, boolean z2) {
        return e(context, true);
    }

    static /* synthetic */ String m(Context context, boolean z2) {
        return f(context, true);
    }

    public static List<bn.a> m(Context context, int i2) {
        return bn.m(context, 15);
    }

    static /* synthetic */ String n(Context context, boolean z2) {
        return g(context, true);
    }

    static /* synthetic */ String o(Context context, boolean z2) {
        return h(context, true);
    }

    static /* synthetic */ String p(Context context, boolean z2) {
        return i(context, true);
    }

    static /* synthetic */ String q(Context context, boolean z2) {
        return cJ(context);
    }

    static /* synthetic */ String r(Context context, boolean z2) {
        return cL(context);
    }

    static /* synthetic */ String s(Context context, boolean z2) {
        return cN(context);
    }

    static /* synthetic */ String t(Context context, boolean z2) {
        return cM(context);
    }
}
