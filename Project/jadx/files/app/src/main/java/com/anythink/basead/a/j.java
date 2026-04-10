package com.anythink.basead.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.anythink.core.common.e.aa;
import com.anythink.core.common.e.ac;
import java.net.URLEncoder;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class j {
    protected static void a(int i2, aa aaVar, @NonNull com.anythink.basead.c.i iVar) {
        String strC;
        String[] strArrG;
        ac acVarX = aaVar.X();
        if (acVarX == null) {
            return;
        }
        Map<String, Object> mapC = com.anythink.core.common.k.h.c(acVarX.c());
        try {
            switch (i2) {
                case 1:
                    strArrG = acVarX.g();
                    break;
                case 2:
                    strArrG = acVarX.h();
                    break;
                case 3:
                    strArrG = acVarX.i();
                    break;
                case 4:
                    strArrG = acVarX.j();
                    break;
                case 5:
                    strArrG = acVarX.k();
                    break;
                case 6:
                    strArrG = acVarX.p();
                    break;
                case 7:
                    strArrG = acVarX.q();
                    break;
                case 8:
                    strArrG = acVarX.e();
                    break;
                case 9:
                    strArrG = acVarX.f();
                    break;
                case 10:
                    strArrG = acVarX.d();
                    break;
                case 11:
                    strArrG = acVarX.l();
                    break;
                case 12:
                    strArrG = acVarX.n();
                    break;
                case 13:
                    strArrG = acVarX.o();
                    break;
                case 14:
                    strArrG = acVarX.m();
                    break;
                case 15:
                    strArrG = acVarX.Q();
                    break;
                case 16:
                    strArrG = acVarX.R();
                    break;
                case 17:
                    strArrG = acVarX.S();
                    break;
                case 18:
                    strArrG = acVarX.r();
                    break;
                case 19:
                    strArrG = acVarX.s();
                    break;
                case 20:
                    strArrG = acVarX.T();
                    break;
                case 21:
                    strArrG = acVarX.t();
                    break;
                case 22:
                default:
                    strArrG = null;
                    break;
                case 23:
                    strArrG = acVarX.U();
                    break;
                case 24:
                    strArrG = acVarX.V();
                    break;
                case 25:
                    strArrG = acVarX.W();
                    break;
                case 26:
                    strArrG = acVarX.X();
                    break;
                case 27:
                    strArrG = acVarX.Y();
                    break;
                case 28:
                    strArrG = acVarX.v();
                    break;
                case 29:
                    strArrG = acVarX.u();
                    break;
                case 30:
                    strArrG = acVarX.w();
                    break;
                case 31:
                    strArrG = acVarX.x();
                    break;
                case 32:
                    com.anythink.basead.c.j jVar = iVar.f5936h;
                    Map<Integer, String[]> mapY = acVarX.y();
                    strArrG = (jVar != null && mapY != null) ? mapY.get(Integer.valueOf(jVar.f5953i)) : null;
                    break;
                case 33:
                    strArrG = acVarX.a();
                    break;
                case 34:
                    strArrG = acVarX.b();
                    break;
                case 35:
                    strArrG = acVarX.ao();
                    break;
            }
            if (strArrG != null) {
                boolean zW = (i2 == 8 || i2 == 9) ? aaVar.k().W() : false;
                long jCurrentTimeMillis = System.currentTimeMillis();
                for (String str : strArrG) {
                    com.anythink.basead.g.e eVar = new com.anythink.basead.g.e(i2, a(str, iVar, jCurrentTimeMillis), aaVar, mapC);
                    eVar.a(zW);
                    eVar.a(0, (com.anythink.core.common.g.i) null);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        switch (i2) {
            case 1:
                strC = acVarX.C();
                break;
            case 2:
                strC = acVarX.D();
                break;
            case 3:
                strC = acVarX.E();
                break;
            case 4:
                strC = acVarX.F();
                break;
            case 5:
                strC = acVarX.G();
                break;
            case 6:
                strC = acVarX.L();
                break;
            case 7:
                strC = acVarX.M();
                break;
            case 8:
                strC = acVarX.A();
                break;
            case 9:
                strC = acVarX.B();
                break;
            case 10:
                strC = acVarX.z();
                break;
            case 11:
                strC = acVarX.H();
                break;
            case 12:
                strC = acVarX.J();
                break;
            case 13:
                strC = acVarX.K();
                break;
            case 14:
                strC = acVarX.I();
                break;
            case 15:
                strC = acVarX.Z();
                break;
            case 16:
                strC = acVarX.aa();
                break;
            case 17:
                strC = acVarX.ab();
                break;
            case 18:
                strC = acVarX.N();
                break;
            case 19:
                strC = acVarX.O();
                break;
            case 20:
                strC = acVarX.ac();
                break;
            case 21:
                strC = acVarX.P();
                break;
            case 22:
            case 32:
            default:
                strC = "";
                break;
            case 23:
                strC = acVarX.ad();
                break;
            case 24:
                strC = acVarX.ae();
                break;
            case 25:
                strC = acVarX.af();
                break;
            case 26:
                strC = acVarX.ag();
                break;
            case 27:
                strC = acVarX.ah();
                break;
            case 28:
                strC = acVarX.aj();
                break;
            case 29:
                strC = acVarX.ai();
                break;
            case 30:
                strC = acVarX.ak();
                break;
            case 31:
                strC = acVarX.al();
                break;
            case 33:
                strC = acVarX.am();
                break;
            case 34:
                strC = acVarX.an();
                break;
            case 35:
                strC = acVarX.ap();
                break;
        }
        if (a(strC)) {
            return;
        }
        com.anythink.basead.g.f fVar = new com.anythink.basead.g.f(i2, aaVar, strC, mapC);
        fVar.b(iVar.b);
        fVar.a(0, (com.anythink.core.common.g.i) null);
    }

    private static void a(int i2, aa aaVar, ac acVar, Map<String, Object> map, @NonNull com.anythink.basead.c.i iVar) {
        String[] strArrG;
        try {
            switch (i2) {
                case 1:
                    strArrG = acVar.g();
                    break;
                case 2:
                    strArrG = acVar.h();
                    break;
                case 3:
                    strArrG = acVar.i();
                    break;
                case 4:
                    strArrG = acVar.j();
                    break;
                case 5:
                    strArrG = acVar.k();
                    break;
                case 6:
                    strArrG = acVar.p();
                    break;
                case 7:
                    strArrG = acVar.q();
                    break;
                case 8:
                    strArrG = acVar.e();
                    break;
                case 9:
                    strArrG = acVar.f();
                    break;
                case 10:
                    strArrG = acVar.d();
                    break;
                case 11:
                    strArrG = acVar.l();
                    break;
                case 12:
                    strArrG = acVar.n();
                    break;
                case 13:
                    strArrG = acVar.o();
                    break;
                case 14:
                    strArrG = acVar.m();
                    break;
                case 15:
                    strArrG = acVar.Q();
                    break;
                case 16:
                    strArrG = acVar.R();
                    break;
                case 17:
                    strArrG = acVar.S();
                    break;
                case 18:
                    strArrG = acVar.r();
                    break;
                case 19:
                    strArrG = acVar.s();
                    break;
                case 20:
                    strArrG = acVar.T();
                    break;
                case 21:
                    strArrG = acVar.t();
                    break;
                case 22:
                default:
                    strArrG = null;
                    break;
                case 23:
                    strArrG = acVar.U();
                    break;
                case 24:
                    strArrG = acVar.V();
                    break;
                case 25:
                    strArrG = acVar.W();
                    break;
                case 26:
                    strArrG = acVar.X();
                    break;
                case 27:
                    strArrG = acVar.Y();
                    break;
                case 28:
                    strArrG = acVar.v();
                    break;
                case 29:
                    strArrG = acVar.u();
                    break;
                case 30:
                    strArrG = acVar.w();
                    break;
                case 31:
                    strArrG = acVar.x();
                    break;
                case 32:
                    com.anythink.basead.c.j jVar = iVar.f5936h;
                    Map<Integer, String[]> mapY = acVar.y();
                    strArrG = (jVar != null && mapY != null) ? mapY.get(Integer.valueOf(jVar.f5953i)) : null;
                    break;
                case 33:
                    strArrG = acVar.a();
                    break;
                case 34:
                    strArrG = acVar.b();
                    break;
                case 35:
                    strArrG = acVar.ao();
                    break;
            }
            if (strArrG != null) {
                boolean zW = (i2 == 8 || i2 == 9) ? aaVar.k().W() : false;
                long jCurrentTimeMillis = System.currentTimeMillis();
                for (String str : strArrG) {
                    com.anythink.basead.g.e eVar = new com.anythink.basead.g.e(i2, a(str, iVar, jCurrentTimeMillis), aaVar, map);
                    eVar.a(zW);
                    eVar.a(0, (com.anythink.core.common.g.i) null);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static void a(int i2, @NonNull com.anythink.basead.c.i iVar, aa aaVar, ac acVar, Map<String, Object> map) {
        String strC;
        switch (i2) {
            case 1:
                strC = acVar.C();
                break;
            case 2:
                strC = acVar.D();
                break;
            case 3:
                strC = acVar.E();
                break;
            case 4:
                strC = acVar.F();
                break;
            case 5:
                strC = acVar.G();
                break;
            case 6:
                strC = acVar.L();
                break;
            case 7:
                strC = acVar.M();
                break;
            case 8:
                strC = acVar.A();
                break;
            case 9:
                strC = acVar.B();
                break;
            case 10:
                strC = acVar.z();
                break;
            case 11:
                strC = acVar.H();
                break;
            case 12:
                strC = acVar.J();
                break;
            case 13:
                strC = acVar.K();
                break;
            case 14:
                strC = acVar.I();
                break;
            case 15:
                strC = acVar.Z();
                break;
            case 16:
                strC = acVar.aa();
                break;
            case 17:
                strC = acVar.ab();
                break;
            case 18:
                strC = acVar.N();
                break;
            case 19:
                strC = acVar.O();
                break;
            case 20:
                strC = acVar.ac();
                break;
            case 21:
                strC = acVar.P();
                break;
            case 22:
            case 32:
            default:
                strC = "";
                break;
            case 23:
                strC = acVar.ad();
                break;
            case 24:
                strC = acVar.ae();
                break;
            case 25:
                strC = acVar.af();
                break;
            case 26:
                strC = acVar.ag();
                break;
            case 27:
                strC = acVar.ah();
                break;
            case 28:
                strC = acVar.aj();
                break;
            case 29:
                strC = acVar.ai();
                break;
            case 30:
                strC = acVar.ak();
                break;
            case 31:
                strC = acVar.al();
                break;
            case 33:
                strC = acVar.am();
                break;
            case 34:
                strC = acVar.an();
                break;
            case 35:
                strC = acVar.ap();
                break;
        }
        if (a(strC)) {
            return;
        }
        com.anythink.basead.g.f fVar = new com.anythink.basead.g.f(i2, aaVar, strC, map);
        fVar.b(iVar.b);
        fVar.a(0, (com.anythink.core.common.g.i) null);
    }

    protected static String a(String str, com.anythink.basead.c.i iVar, long j2) {
        String string;
        String string2;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (iVar.f5935g != null) {
            str = a(str, iVar);
        }
        com.anythink.basead.c.j jVar = iVar.f5936h;
        if (jVar != null) {
            str = a(str, jVar);
        }
        com.anythink.basead.c.b bVar = iVar.f5937i;
        if (bVar != null) {
            str = a(str, bVar);
        }
        long j3 = j2 / 1000;
        if (iVar.f5931c == 0) {
            string = "__REQ_WIDTH__";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(iVar.f5931c);
            string = sb.toString();
        }
        String strReplaceAll = str.replaceAll("\\{__REQ_WIDTH__\\}", string);
        if (iVar.f5932d == 0) {
            string2 = "__REQ_HEIGHT__";
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(iVar.f5932d);
            string2 = sb2.toString();
        }
        String strReplaceAll2 = strReplaceAll.replaceAll("\\{__REQ_HEIGHT__\\}", string2);
        StringBuilder sb3 = new StringBuilder();
        sb3.append(iVar.f5933e);
        String strReplaceAll3 = strReplaceAll2.replaceAll("\\{__WIDTH__\\}", sb3.toString());
        StringBuilder sb4 = new StringBuilder();
        sb4.append(iVar.f5934f);
        return strReplaceAll3.replaceAll("\\{__HEIGHT__\\}", sb4.toString()).replaceAll("\\{__TS__\\}", String.valueOf(j3)).replaceAll("\\{__TS_MSEC__\\}", String.valueOf(j2)).replaceAll("\\{__END_TS__\\}", String.valueOf(j3)).replaceAll("\\{__END_TS_MSEC__\\}", String.valueOf(j2)).replaceAll("\\{__PLAY_SEC__\\}", "0").replaceAll("\\{", "").replaceAll("\\}", "");
    }

    private static String a(String str, com.anythink.basead.c.j jVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(jVar.a);
        String strReplaceAll = str.replaceAll("\\{__VIDEO_TIME__\\}", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(jVar.b);
        String strReplaceAll2 = strReplaceAll.replaceAll("\\{__BEGIN_TIME__\\}", sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append(jVar.f5947c);
        String strReplaceAll3 = strReplaceAll2.replaceAll("\\{__END_TIME__\\}", sb3.toString());
        StringBuilder sb4 = new StringBuilder();
        sb4.append(jVar.f5948d);
        String strReplaceAll4 = strReplaceAll3.replaceAll("\\{__PLAY_FIRST_FRAME__\\}", sb4.toString());
        StringBuilder sb5 = new StringBuilder();
        sb5.append(jVar.f5949e);
        String strReplaceAll5 = strReplaceAll4.replaceAll("\\{__PLAY_LAST_FRAME__\\}", sb5.toString());
        StringBuilder sb6 = new StringBuilder();
        sb6.append(jVar.f5954l);
        String strReplaceAll6 = strReplaceAll5.replaceAll("\\{__SCENE__\\}", sb6.toString());
        StringBuilder sb7 = new StringBuilder();
        sb7.append(jVar.f5955o);
        String strReplaceAll7 = strReplaceAll6.replaceAll("\\{__TYPE__\\}", sb7.toString());
        StringBuilder sb8 = new StringBuilder();
        sb8.append(jVar.f5956r);
        String strReplaceAll8 = strReplaceAll7.replaceAll("\\{__BEHAVIOR__\\}", sb8.toString());
        StringBuilder sb9 = new StringBuilder();
        sb9.append(jVar.f5957u);
        String strReplaceAll9 = strReplaceAll8.replaceAll("\\{__STATUS__\\}", sb9.toString());
        StringBuilder sb10 = new StringBuilder();
        sb10.append(jVar.f5952h);
        String strReplaceAll10 = strReplaceAll9.replaceAll("\\{__PLAY_SEC__\\}", sb10.toString());
        StringBuilder sb11 = new StringBuilder();
        sb11.append(jVar.f5950f / 1000);
        String strReplaceAll11 = strReplaceAll10.replaceAll("\\{__TS__\\}", sb11.toString());
        StringBuilder sb12 = new StringBuilder();
        sb12.append(jVar.f5950f);
        String strReplaceAll12 = strReplaceAll11.replaceAll("\\{__TS_MSEC__\\}", sb12.toString());
        StringBuilder sb13 = new StringBuilder();
        sb13.append(jVar.f5951g / 1000);
        String strReplaceAll13 = strReplaceAll12.replaceAll("\\{__END_TS__\\}", sb13.toString());
        StringBuilder sb14 = new StringBuilder();
        sb14.append(jVar.f5951g);
        String strReplaceAll14 = strReplaceAll13.replaceAll("\\{__END_TS_MSEC__\\}", sb14.toString());
        StringBuilder sb15 = new StringBuilder();
        sb15.append(jVar.f5952h / 1000);
        String strReplaceAll15 = strReplaceAll14.replaceAll("\\{__PLAY_SEC__\\}", sb15.toString());
        StringBuilder sb16 = new StringBuilder();
        sb16.append(jVar.f5952h);
        return strReplaceAll15.replaceAll("\\{__PLAY_MSEC__\\}", sb16.toString());
    }

    private static String a(String str, com.anythink.basead.c.b bVar) {
        String str2 = bVar.a;
        if (str2 == null) {
            str2 = "";
        }
        return str.replaceAll("\\{__CLICK_ID__\\}", str2);
    }

    private static String a(String str, com.anythink.basead.c.i iVar) {
        String strEncode;
        String strReplaceAll;
        String strEncode2 = "{}";
        com.anythink.basead.c.a aVar = iVar.f5935g;
        int i2 = iVar.f5933e;
        int i3 = iVar.f5934f;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("down_x", aVar.f5888e);
            jSONObject.put("down_y", aVar.f5889f);
            jSONObject.put("up_x", aVar.f5890g);
            jSONObject.put("up_y", aVar.f5891h);
        } catch (JSONException unused) {
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            float f2 = i2;
            jSONObject2.put("down_x", (int) ((aVar.f5888e / f2) * 1000.0f));
            float f3 = i3;
            jSONObject2.put("down_y", (int) ((aVar.f5888e / f3) * 1000.0f));
            jSONObject2.put("up_x", (int) ((aVar.f5890g / f2) * 1000.0f));
            jSONObject2.put("up_y", (int) ((aVar.f5891h / f3) * 1000.0f));
        } catch (JSONException unused2) {
        }
        try {
            strEncode = URLEncoder.encode(jSONObject.toString(), com.anythink.expressad.foundation.g.a.bN);
        } catch (Throwable th) {
            th.printStackTrace();
            strEncode = "{}";
        }
        try {
            strEncode2 = URLEncoder.encode(jSONObject2.toString(), com.anythink.expressad.foundation.g.a.bN);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        int i4 = aVar.f5892i ? 1 : 2;
        StringBuilder sb = new StringBuilder();
        sb.append(aVar.a);
        String strReplaceAll2 = str.replaceAll("\\{__DOWN_X__\\}", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(aVar.b);
        String strReplaceAll3 = strReplaceAll2.replaceAll("\\{__DOWN_Y__\\}", sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append(aVar.f5886c);
        String strReplaceAll4 = strReplaceAll3.replaceAll("\\{__UP_X__\\}", sb3.toString());
        StringBuilder sb4 = new StringBuilder();
        sb4.append(aVar.f5887d);
        String strReplaceAll5 = strReplaceAll4.replaceAll("\\{__UP_Y__\\}", sb4.toString());
        StringBuilder sb5 = new StringBuilder();
        sb5.append(aVar.f5888e);
        String strReplaceAll6 = strReplaceAll5.replaceAll("\\{__RE_DOWN_X__\\}", sb5.toString());
        StringBuilder sb6 = new StringBuilder();
        sb6.append(aVar.f5889f);
        String strReplaceAll7 = strReplaceAll6.replaceAll("\\{__RE_DOWN_Y__\\}", sb6.toString());
        StringBuilder sb7 = new StringBuilder();
        sb7.append(aVar.f5890g);
        String strReplaceAll8 = strReplaceAll7.replaceAll("\\{__RE_UP_X__\\}", sb7.toString());
        StringBuilder sb8 = new StringBuilder();
        sb8.append(aVar.f5891h);
        String strReplaceAll9 = strReplaceAll8.replaceAll("\\{__RE_UP_Y__\\}", sb8.toString()).replaceAll("\\{ABSOLUTE_COORD\\}", strEncode).replaceAll("\\{RELATIVE_COORD\\}", strEncode2).replaceAll("\\{__DPLINK_TYPE__\\}", String.valueOf(i4));
        if (aVar.f5892i) {
            strReplaceAll9 = strReplaceAll9.replaceAll("&apk_ptype=\\{apk_ptype\\}", "");
        }
        int i5 = aVar.f5893j;
        if (i5 == -1) {
            strReplaceAll = strReplaceAll9.replaceAll("&apk_ptype=\\{apk_ptype\\}", "");
        } else {
            strReplaceAll = strReplaceAll9.replaceAll("\\{apk_ptype\\}", String.valueOf(i5));
        }
        return strReplaceAll.replaceAll("\\{opdptype\\}", aVar.f5892i ? "1" : "0");
    }

    private static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        return new JSONObject(str).length() <= 0;
    }
}
