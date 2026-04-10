package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.room.RoomMasterTable;
import com.anythink.core.api.ATAdConst;
import com.kuaishou.weapon.p0.jni.A;
import com.kuaishou.weapon.p0.jni.Engine;
import com.tencent.smtt.sdk.TbsListener;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.android.agoo.common.AgooConstants;
import org.android.agoo.message.MessageService;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ck {
    private Context a;
    private int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f16652c;

    public ck(Context context, int i2, int i3) {
        this.a = context;
        this.b = i2;
        this.f16652c = i3;
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
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            h hVarA = h.a(this.a, "re_po_rt");
            boolean zE = hVarA.e("a1_p_s_p_s");
            boolean zE2 = hVarA.e("a1_p_s_p_s_c_b");
            ai aiVar = new ai(this.a);
            jSONObject.put("0", aiVar.d());
            jSONObject.put("1", aiVar.a());
            jSONObject.put("2", aiVar.c());
            jSONObject.put("3", aiVar.f());
            jSONObject.put(AgooConstants.REPORT_NOT_ENCRYPT, aiVar.e());
            jSONObject.put("35", ab.b() ? 1 : 0);
            jSONObject.put("36", ab.a(this.a) ? 1 : 0);
            JSONObject jSONObjectA = ah.a(this.a);
            if (jSONObjectA != null) {
                jSONObject.put("4", jSONObjectA);
            }
            z zVar = new z();
            JSONArray jSONArrayA = zVar.a(this.a);
            jSONObject.put("49", jSONArrayA);
            jSONObject.put("146", zVar.e());
            jSONObject.put("154", zVar.a());
            jSONObject.put("168", di.b(jSONArrayA));
            jSONObject.put("169", di.a(jSONArrayA));
            jSONObject.put("185", zVar.d());
            jSONObject.put("191", zVar.c());
            if (zVar.b() != null) {
                jSONObject.put("161", zVar.b());
            }
            jSONObject.put(AgooConstants.REPORT_ENCRYPT_FAIL, ab.a());
            ac acVar = new ac();
            jSONObject.put("7", acVar.a() ? 1 : 0);
            boolean zA = acVar.a(this.a);
            jSONObject.put("8", zA ? 1 : 0);
            if (zA) {
                jSONObject.put("61", acVar.b(this.a));
            }
            jSONObject.put("181", acVar.f(this.a) ? 1 : 0);
            jSONObject.put("9", acVar.d(this.a));
            jSONObject.put(AgooConstants.ACK_REMOVE_PACKAGE, acVar.e(this.a));
            jSONObject.put(AgooConstants.ACK_BODY_NULL, acVar.c(this.a));
            ae aeVar = new ae();
            jSONObject.put("26", aeVar.a("cpuinfo") ? 1 : 0);
            jSONObject.put("27", aeVar.a("meminfo") ? 1 : 0);
            jSONObject.put("28", aeVar.b("/proc/cpuinfo") ? 1 : 0);
            jSONObject.put("29", aeVar.b("/proc/meminfo") ? 1 : 0);
            jSONObject.put("96", aeVar.a());
            jSONObject.put("134", aeVar.b());
            an anVar = new an();
            Set<String> setB = anVar.b();
            Set<String> setC = anVar.c();
            if (setC != null) {
                jSONObject.put("30", 1);
                jSONObject.put("32", new JSONArray((Collection) setC));
            } else {
                jSONObject.put("30", 0);
            }
            if (setB != null) {
                jSONObject.put("31", 1);
                jSONObject.put("33", new JSONArray((Collection) setB));
            } else {
                jSONObject.put("31", 0);
            }
            Set<String> setA = anVar.a();
            if (setA != null) {
                jSONObject.put("34", setA);
                if (setB != null || setC != null) {
                    HashSet hashSet = new HashSet();
                    if (setB != null) {
                        hashSet.add(setB);
                    }
                    if (setC != null) {
                        hashSet.add(setC);
                    }
                    jSONObject.put(AgooConstants.ACK_FLAG_NULL, anVar.a(this.a, 13, hashSet));
                    jSONObject.put(AgooConstants.ACK_PACK_NOBIND, anVar.a(this.a, 14, hashSet));
                    jSONObject.put(AgooConstants.ACK_PACK_ERROR, anVar.a(this.a, 15, hashSet));
                    jSONObject.put("16", anVar.a(this.a, 16, hashSet));
                    jSONObject.put("17", anVar.a(this.a, 17, hashSet));
                    jSONObject.put("18", anVar.a(this.a, 18, hashSet));
                    jSONObject.put("19", anVar.a(this.a, 19, hashSet));
                    jSONObject.put("20", anVar.a(this.a, 20, hashSet));
                    jSONObject.put(AgooConstants.REPORT_MESSAGE_NULL, anVar.a(this.a, 21, hashSet));
                    jSONObject.put("130", anVar.b(hashSet));
                }
            }
            ao aoVar = new ao();
            jSONObject.put("65", aoVar.d() ? 1 : 0);
            boolean zB = aoVar.b();
            jSONObject.put("66", zB ? 1 : 0);
            if (zB) {
                jSONObject.put("67", aoVar.a() ? 1 : 0);
            }
            jSONObject.put("68", aoVar.f() ? 1 : 0);
            jSONObject.put("69", aoVar.e());
            jSONObject.put("101", aoVar.c() ? 1 : 0);
            jSONObject.put(ATAdConst.BIDDING_TYPE.BIDDING_LOSS_WITH_LOW_PRICE_IN_HB, aoVar.g() ? 1 : 0);
            jSONObject.put("99", new af().a());
            jSONObject.put(ATAdConst.BIDDING_TYPE.BIDDING_LOSS_WITH_LOW_PRICE_IN_NORMAL, new ad().a() ? 1 : 0);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("03007", bu.a(this.a));
            jSONObject2.put("03014", bg.g(this.a));
            jSONObject2.put("03020", bu.b(this.a));
            jSONObject2.put("03030", bf.d(this.a));
            jSONObject.put("51", jSONObject2);
            an anVar2 = new an();
            jSONObject.put("107", anVar2.d());
            jSONObject.put("155", anVar2.e());
            jSONObject.put("170", anVar2.g());
            jSONObject.put("190", anVar2.f());
            ag agVar = new ag();
            jSONObject.put("131", agVar.a());
            jSONObject.put("145", agVar.a(this.a));
            jSONObject.put("132", dj.a());
            jSONObject.put("133", new ai(this.a).g());
            if (hVarA.b(de.af, 1) == 1) {
                jSONObject.put("139", dk.c(this.a));
                jSONObject.put("140", dk.d(this.a));
                jSONObject.put("147", dk.a());
                jSONObject.put("148", dh.b());
                jSONObject.put("149", dh.c());
                jSONObject.put("151", dj.b());
            }
            if (hVarA.b(de.aa, 0) == 1) {
                if (zE || zE2) {
                    jSONObject.put("25", al.a(this.a) ? 1 : 0);
                }
                jSONObject.put("128", ad.b() ? 1 : 0);
            }
            if (Engine.loadSuccess) {
                as asVar = new as(this.a, 100);
                jSONObject.put("6", asVar.a("6"));
                JSONArray jSONArrayA2 = asVar.a(asVar.a(), "41");
                if (jSONArrayA2 != null && jSONArrayA2.length() > 0) {
                    JSONArray jSONArrayC = asVar.c(asVar.a(), "41");
                    JSONArray jSONArrayB = asVar.b(asVar.a(), "41");
                    jSONObject.put(RoomMasterTable.DEFAULT_ID, jSONArrayC);
                    jSONObject.put("43", jSONArrayB);
                    jSONObject.put("41", asVar.a(asVar.a(jSONArrayA2, jSONArrayC), jSONArrayB));
                }
                jSONObject.put("47", asVar.a("47"));
                jSONObject.put("48", asVar.a("48"));
                jSONObject.put(AgooConstants.REPORT_DUPLICATE_FAIL, asVar.a(AgooConstants.REPORT_DUPLICATE_FAIL));
                jSONObject.put("37", asVar.a("37"));
                jSONObject.put("38", asVar.a("38"));
                jSONObject.put("40", asVar.b("40"));
                jSONObject.put("45", asVar.b("45"));
                jSONObject.put("46", asVar.e("46"));
                jSONObject.put("91", asVar.a("91"));
                jSONObject.put("62", asVar.c("62"));
                jSONObject.put("63", asVar.c("63"));
                jSONObject.put("64", asVar.c("64"));
                jSONObject.put("85", asVar.d("85"));
                jSONObject.put("50", asVar.a("50"));
                jSONObject.put("70", asVar.c("70"));
                jSONObject.put("39", asVar.a("39"));
                jSONObject.put("52", asVar.a("52"));
                jSONObject.put("53", asVar.a("53"));
                jSONObject.put("54", asVar.a("54"));
                jSONObject.put("55", asVar.a("55"));
                jSONObject.put("73", asVar.a("73"));
                jSONObject.put("74", asVar.a("74"));
                jSONObject.put("104", asVar.a("104"));
                if (hVarA.b(de.V, 1) == 1 && Build.VERSION.SDK_INT < 23) {
                    ar arVar = new ar(this.a);
                    String strA = arVar.a("57");
                    if (!TextUtils.isEmpty(strA)) {
                        jSONObject.put("57", strA);
                        jSONObject.put("56", arVar.a("56"));
                    }
                }
                jSONObject.put("77", asVar.a("77"));
                jSONObject.put("78", asVar.a("78"));
                jSONObject.put("79", asVar.a("79"));
                jSONObject.put("84", asVar.a("84"));
                jSONObject.put("80", asVar.a("80"));
                jSONObject.put("81", asVar.a("81"));
                jSONObject.put("82", asVar.a("82"));
                jSONObject.put("83", asVar.a("83"));
                jSONObject.put("87", asVar.a("87"));
                jSONObject.put("89", asVar.a("89"));
                jSONObject.put("90", asVar.d("90"));
                jSONObject.put("75", asVar.a("75"));
                jSONObject.put("88", asVar.a("88"));
                jSONObject.put("92", asVar.a("92"));
                jSONObject.put("93", asVar.a("93"));
                jSONObject.put("94", asVar.a("94"));
                jSONObject.put("95", asVar.a("95"));
                jSONObject.put("98", asVar.a("98"));
                jSONObject.put(MessageService.MSG_DB_COMPLETE, asVar.a(MessageService.MSG_DB_COMPLETE));
                jSONObject.put("105", asVar.a("105"));
                if (hVarA.b(de.X, 1) == 1) {
                    aq aqVar = new aq(this.a, 0);
                    jSONObject.put("108", aqVar.a("108"));
                    jSONObject.put("109", aqVar.a("109"));
                    jSONObject.put("111", aqVar.a("111"));
                }
                if (hVarA.b(de.Z, 1) == 1) {
                    aq aqVar2 = new aq(this.a, 1);
                    jSONObject.put("112", aqVar2.b("112"));
                    jSONObject.put("113", aqVar2.a("113"));
                    jSONObject.put("114", aqVar2.a("114"));
                    jSONObject.put("115", aqVar2.a("115"));
                    jSONObject.put("116", aqVar2.a("116"));
                    jSONObject.put("117", aqVar2.a("117"));
                    jSONObject.put("120", aqVar2.a("120"));
                    aq aqVar3 = new aq(this.a, 4);
                    jSONObject.put("124", aqVar3.a("124"));
                    jSONObject.put("125", aqVar3.a("125"));
                    jSONObject.put("126", aqVar3.a("126"));
                    jSONObject.put("127", aqVar3.a("127"));
                }
                if (hVarA.b(de.ab, 0) == 1) {
                    av avVar = new av(this.a, 100);
                    jSONObject.put("97", avVar.a("97"));
                    jSONObject.put("118", avVar.a("118"));
                    jSONObject.put("119", avVar.a("119"));
                    jSONObject.put("135", avVar.a("135"));
                    jSONObject.put("174", avVar.a("174"));
                    av avVar2 = new av(this.a, 200);
                    jSONObject.put("173", avVar2.a("173"));
                    jSONObject.put("182", avVar2.a("182"));
                }
                if (hVarA.b(de.W, 1) == 1) {
                    jSONObject.put("129", new bd(this.a, 4).a("129"));
                    bd bdVar = new bd(this.a, 1);
                    jSONObject.put("121", bdVar.a(bdVar.a(), "121"));
                    bd bdVar2 = new bd(this.a, 2);
                    jSONObject.put("137", bdVar2.a("137"));
                    jSONObject.put("138", bdVar2.a("138"));
                    jSONObject.put("141", bdVar2.a("141"));
                    jSONObject.put("142", bdVar2.a("142"));
                    be beVar = new be(this.a, 3);
                    JSONArray jSONArrayB2 = beVar.b("150");
                    jSONObject.put("150", jSONArrayB2);
                    if (jSONArrayB2 != null) {
                        jSONObject.put("188", beVar.a(jSONArrayB2));
                    }
                }
                if (hVarA.b(de.S, 1) == 1) {
                    az azVar = new az(this.a, 100);
                    jSONObject.put("152", azVar.a("152"));
                    jSONObject.put("153", azVar.a("153"));
                    jSONObject.put("156", azVar.a("156"));
                    jSONObject.put("157", azVar.a("157"));
                    jSONObject.put("163", azVar.a("163"));
                    jSONObject.put("171", azVar.a("171", true));
                    jSONObject.put("172", azVar.b("172"));
                    jSONObject.put("177", new az(this.a, 500).d("177"));
                }
                if ((zE || zE2) && hVarA.b(de.U, 0) == 1) {
                    jSONObject.put("158", new az(this.a, 300).b("158"));
                }
                if (hVarA.b(de.ae, 0) == 1) {
                    bc bcVar = new bc(this.a);
                    jSONObject.put("162", bcVar.a("162"));
                    jSONObject.put("160", bcVar.a(bcVar.a(), "160"));
                    az azVar2 = new az(this.a, TbsListener.ErrorCode.INFO_CODE_BASE);
                    jSONObject.put("164", azVar2.a("164"));
                    jSONObject.put("165", azVar2.a("165"));
                    jSONObject.put("166", azVar2.c("166"));
                    jSONObject.put("167", azVar2.a("167"));
                }
                if (hVarA.b(de.ac, 1) == 1) {
                    ax axVar = new ax(this.a, 600);
                    jSONObject.put("179", axVar.a("179"));
                    jSONObject.put("186", axVar.a("186"));
                    jSONObject.put("189", axVar.a("189"));
                }
            }
            jSONObject.put("58", ae.a(this.a));
            jSONObject.put("60", ab.b(this.a) ? 1 : 0);
            jSONObject.put("11000", Engine.loadSuccess ? 1 : 0);
            jSONObject.put("11002", Engine.soVersion);
            jSONObject.put("11008", hVarA.b(de.f16686g, bp.f16591e));
            jSONObject.put("11009", br.a(this.a.getApplicationContext()));
            try {
                jSONObject.put("11301", bg.c(com.kwad.sdk.c.b.AI().AH()));
                jSONObject.put("11302", bg.c(com.kwad.sdk.c.b.AI().getSdkVersion()));
                jSONObject.put("11303", bg.c(com.kwad.sdk.c.b.AI().getAppId()));
            } catch (Throwable unused) {
            }
            int i2 = 1;
            String strB = hVarA.b(de.f16690k, "", true);
            if (!TextUtils.isEmpty(strB)) {
                jSONObject.put("183", strB);
                hVarA.c(de.f16690k, "");
            }
            jSONObject.put("187", ak.a(this.a) ? 1 : 0);
            jSONObject.put("11006", zE ? 1 : 0);
            if (!zE2) {
                i2 = 0;
            }
            jSONObject.put("11029", i2);
            jSONObject.put("11028", WeaponHI.sKSSdkver);
            jSONObject.put("20000", this.b);
            jSONObject.put("20001", this.f16652c);
            try {
                jSONObject.put("02078", A.getE("W_S_V"));
                jSONObject.put("02079", A.getE("W_S_S_V"));
            } catch (Throwable unused2) {
            }
            jSONObject.put("11007", System.currentTimeMillis() - jCurrentTimeMillis);
            jSONObject.put("11017", jSONObject.toString().length());
            return jSONObject;
        } catch (Throwable unused3) {
            return null;
        }
    }
}
