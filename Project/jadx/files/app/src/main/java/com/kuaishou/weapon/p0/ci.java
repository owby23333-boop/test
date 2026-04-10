package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import androidx.room.RoomMasterTable;
import com.anythink.core.api.ATAdConst;
import com.kuaishou.weapon.p0.jni.Engine;
import org.android.agoo.common.AgooConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ci {
    private Context a;

    public ci(Context context) {
        this.a = context;
    }

    public String a(String str) {
        JSONObject jSONObjectA;
        try {
            JSONObject jSONObjectA2 = new cl(str, cj.f16635j).a(this.a);
            if (jSONObjectA2 == null || (jSONObjectA = a()) == null) {
                return null;
            }
            jSONObjectA2.put("module_section", jSONObjectA);
            return jSONObjectA2.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    public JSONObject a() {
        int i2;
        JSONObject jSONObjectG;
        int i3;
        try {
            JSONObject jSONObject = new JSONObject();
            h hVarA = h.a(this.a, "re_po_rt");
            boolean zE = hVarA.e("a1_p_s_p_s");
            boolean zE2 = hVarA.e("a1_p_s_p_s_c_b");
            if (hVarA.b(de.E, 1) != 1) {
                return null;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (hVarA.b(de.I, 1) == 1 && Engine.loadSuccess) {
                ap apVar = new ap(this.a);
                jSONObject.put("0", apVar.b("0"));
                jSONObject.put("1", apVar.b("1"));
                jSONObject.put("2", apVar.b("2"));
                jSONObject.put("3", apVar.b("3"));
                jSONObject.put("4", apVar.b("4"));
                jSONObject.put("5", apVar.b("5"));
                jSONObject.put("6", apVar.b("6"));
                jSONObject.put("7", apVar.b("7"));
                jSONObject.put("8", apVar.b("8"));
                jSONObject.put("9", apVar.b("9"));
                jSONObject.put(AgooConstants.ACK_REMOVE_PACKAGE, apVar.b(AgooConstants.ACK_REMOVE_PACKAGE));
                jSONObject.put(AgooConstants.ACK_BODY_NULL, apVar.b(AgooConstants.ACK_BODY_NULL));
                jSONObject.put(AgooConstants.ACK_PACK_NULL, apVar.b(AgooConstants.ACK_PACK_NULL));
                jSONObject.put(AgooConstants.ACK_FLAG_NULL, apVar.b(AgooConstants.ACK_FLAG_NULL));
                jSONObject.put(AgooConstants.ACK_PACK_NOBIND, apVar.b(AgooConstants.ACK_PACK_NOBIND));
                jSONObject.put(AgooConstants.ACK_PACK_ERROR, apVar.b(AgooConstants.ACK_PACK_ERROR));
                jSONObject.put("16", apVar.b("16"));
                jSONObject.put("17", apVar.b("17"));
                jSONObject.put("18", apVar.b("18"));
                jSONObject.put("19", apVar.b("19"));
                jSONObject.put("20", apVar.b("20"));
                jSONObject.put(AgooConstants.REPORT_MESSAGE_NULL, apVar.b(AgooConstants.REPORT_MESSAGE_NULL));
                jSONObject.put(AgooConstants.REPORT_ENCRYPT_FAIL, apVar.b(AgooConstants.REPORT_ENCRYPT_FAIL));
                jSONObject.put(AgooConstants.REPORT_DUPLICATE_FAIL, apVar.b(AgooConstants.REPORT_DUPLICATE_FAIL));
                jSONObject.put(AgooConstants.REPORT_NOT_ENCRYPT, apVar.b(AgooConstants.REPORT_NOT_ENCRYPT));
                jSONObject.put("25", apVar.b("25"));
                jSONObject.put("26", apVar.b("26"));
                jSONObject.put("27", apVar.b("27"));
                jSONObject.put("28", apVar.b("28"));
                jSONObject.put("29", apVar.b("29"));
                jSONObject.put("30", apVar.b("30"));
                jSONObject.put("31", apVar.b("31"));
                jSONObject.put("32", apVar.b("32"));
                jSONObject.put("33", apVar.b("33"));
                jSONObject.put("34", apVar.b("34"));
                jSONObject.put("35", apVar.b("35"));
                jSONObject.put("36", apVar.b("36"));
                jSONObject.put("37", apVar.b("37"));
                jSONObject.put("38", apVar.b("38"));
                jSONObject.put("39", apVar.b("39"));
                jSONObject.put("40", apVar.b("40"));
                jSONObject.put("41", apVar.b("41"));
                jSONObject.put(RoomMasterTable.DEFAULT_ID, apVar.b(RoomMasterTable.DEFAULT_ID));
                jSONObject.put("43", apVar.a("43"));
                jSONObject.put("44", apVar.a("44"));
                jSONObject.put("101", apVar.b("101"));
                jSONObject.put(ATAdConst.BIDDING_TYPE.BIDDING_LOSS_WITH_LOW_PRICE_IN_HB, apVar.b(ATAdConst.BIDDING_TYPE.BIDDING_LOSS_WITH_LOW_PRICE_IN_HB));
                jSONObject.put("105", apVar.b("105"));
                jSONObject.put("106", apVar.b("106"));
                jSONObject.put("49", dk.b(this.a));
                jSONObject.put("50", dk.a(this.a));
            }
            if (hVarA.b(de.H, 1) == 1 && Engine.loadSuccess) {
                at atVar = new at(this.a);
                jSONObject.put("45", atVar.d("45"));
                if (atVar.a()) {
                    i3 = 1;
                    jSONObject.put("93", 1);
                } else {
                    i3 = 1;
                }
                if (atVar.b()) {
                    jSONObject.put("94", i3);
                }
                jSONObject.put("46", atVar.d("46"));
                jSONObject.put("48", atVar.a("48"));
                jSONObject.put("51", atVar.b("51"));
                jSONObject.put("52", atVar.a(this.a, "52", 0));
                jSONObject.put("55", atVar.c("55"));
                jSONObject.put("66", atVar.a("66"));
                jSONObject.put("67", dh.d());
                jSONObject.put("78", atVar.a("78"));
                jSONObject.put("79", atVar.a("79"));
                ay ayVar = new ay(this.a, 200);
                jSONObject.put("70", ayVar.a("70"));
                jSONObject.put("71", ayVar.a("71"));
                jSONObject.put("72", ayVar.a("72"));
                jSONObject.put("73", ayVar.a("73"));
                jSONObject.put("74", ayVar.a("74"));
            }
            if (hVarA.b(de.K, 1) == 1) {
                aw awVar = new aw(this.a);
                jSONObject.put("53", awVar.a(this.a, "53", 1));
                jSONObject.put("56", awVar.a("56"));
                jSONObject.put("57", awVar.a("57"));
                if (zE || zE2) {
                    aj ajVar = new aj();
                    jSONObject.put("47", ajVar.a(this.a));
                    jSONObject.put("59", ajVar.d(this.a));
                    jSONObject.put("60", ajVar.c(this.a));
                    jSONObject.put("61", ajVar.b(this.a));
                    jSONObject.put("62", ajVar.e(this.a));
                    jSONObject.put("65", ajVar.f(this.a));
                    jSONObject.put("69", ajVar.g(this.a));
                    jSONObject.put("75", ajVar.h(this.a));
                    jSONObject.put("80", aj.a());
                    jSONObject.put("85", ajVar.i(this.a));
                    jSONObject.put("87", ajVar.j(this.a));
                    jSONObject.put("91", ajVar.k(this.a));
                    jSONObject.put("92", ajVar.l(this.a));
                }
                jSONObject.put("64", dh.a());
            }
            if (hVarA.b(de.L, 1) == 1) {
                cr crVar = new cr();
                jSONObject.put("98", crVar.a());
                jSONObject.put("107", crVar.b());
                String strD = am.d();
                if (!TextUtils.isEmpty(strD)) {
                    jSONObject.put("77", strD);
                }
                jSONObject.put("104", am.c());
                jSONObject.put("109", dk.e(this.a));
                ai aiVar = new ai(this.a);
                jSONObject.put("82", aiVar.h());
                String strI = aiVar.i();
                if (!TextUtils.isEmpty(strI)) {
                    jSONObject.put("83", strI);
                }
                String strJ = aiVar.j();
                if (!TextUtils.isEmpty(strJ)) {
                    jSONObject.put("84", strJ);
                }
                String strK = aiVar.k();
                if (!TextUtils.isEmpty(strK)) {
                    jSONObject.put("86", strK);
                }
            }
            if (hVarA.b(de.J, 1) == 1) {
                au auVar = new au(this.a);
                jSONObject.put("95", auVar.b("95"));
                jSONObject.put("96", auVar.a() ? 1 : 0);
                jSONObject.put("97", dh.e());
                try {
                    jSONObject.put("11301", bg.c(com.kwad.sdk.c.b.AI().AH()));
                    jSONObject.put("11302", bg.c(com.kwad.sdk.c.b.AI().getSdkVersion()));
                    jSONObject.put("11303", bg.c(com.kwad.sdk.c.b.AI().getAppId()));
                } catch (Throwable unused) {
                }
            }
            if (h.a(this.a, "re_po_rt").b(de.aB, 1) == 1) {
                JSONObject jSONObjectC = new ba(this.a, 100, Environment.getExternalStorageDirectory().getAbsolutePath(), ba.a(this.a)).c();
                if (jSONObjectC == null || jSONObjectC.length() <= 10) {
                    i2 = 1;
                    try {
                        jSONObject.put("16102", new ba(this.a, 200, "", true).a("16102"));
                    } catch (Throwable unused2) {
                    }
                } else {
                    jSONObject.put("16002", jSONObjectC);
                    i2 = 1;
                }
                if ((zE || zE2) && (jSONObjectG = bf.g(this.a)) != null && jSONObjectG.length() > 0) {
                    jSONObject.put("16116", jSONObjectG);
                }
            } else {
                i2 = 1;
            }
            jSONObject.put("11006", zE ? 1 : 0);
            if (!zE2) {
                i2 = 0;
            }
            jSONObject.put("11029", i2);
            jSONObject.put("11002", Engine.soVersion);
            jSONObject.put("11007", System.currentTimeMillis() - jCurrentTimeMillis);
            jSONObject.put("11017", jSONObject.toString().length());
            return jSONObject;
        } catch (Throwable unused3) {
            return null;
        }
    }
}
