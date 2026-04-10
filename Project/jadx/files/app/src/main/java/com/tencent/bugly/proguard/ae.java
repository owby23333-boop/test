package com.tencent.bugly.proguard;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.biz.UserInfoBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes3.dex */
public final class ae {
    public static bu a(UserInfoBean userInfoBean) {
        if (userInfoBean == null) {
            return null;
        }
        bu buVar = new bu();
        buVar.a = userInfoBean.f18392e;
        buVar.f18744e = userInfoBean.f18397j;
        buVar.f18743d = userInfoBean.f18390c;
        buVar.f18742c = userInfoBean.f18391d;
        buVar.f18747h = userInfoBean.f18402o == 1;
        int i2 = userInfoBean.b;
        if (i2 == 1) {
            buVar.b = (byte) 1;
        } else if (i2 == 2) {
            buVar.b = (byte) 4;
        } else if (i2 == 3) {
            buVar.b = (byte) 2;
        } else if (i2 == 4) {
            buVar.b = (byte) 3;
        } else if (i2 == 8) {
            buVar.b = (byte) 8;
        } else {
            if (i2 < 10 || i2 >= 20) {
                al.e("unknown uinfo type %d ", Integer.valueOf(userInfoBean.b));
                return null;
            }
            buVar.b = (byte) i2;
        }
        buVar.f18745f = new HashMap();
        if (userInfoBean.f18403p >= 0) {
            Map<String, String> map = buVar.f18745f;
            StringBuilder sb = new StringBuilder();
            sb.append(userInfoBean.f18403p);
            map.put("C01", sb.toString());
        }
        if (userInfoBean.f18404q >= 0) {
            Map<String, String> map2 = buVar.f18745f;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(userInfoBean.f18404q);
            map2.put("C02", sb2.toString());
        }
        Map<String, String> map3 = userInfoBean.f18405r;
        if (map3 != null && map3.size() > 0) {
            for (Map.Entry<String, String> entry : userInfoBean.f18405r.entrySet()) {
                buVar.f18745f.put("C03_" + entry.getKey(), entry.getValue());
            }
        }
        Map<String, String> map4 = userInfoBean.f18406s;
        if (map4 != null && map4.size() > 0) {
            for (Map.Entry<String, String> entry2 : userInfoBean.f18406s.entrySet()) {
                buVar.f18745f.put("C04_" + entry2.getKey(), entry2.getValue());
            }
        }
        Map<String, String> map5 = buVar.f18745f;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(!userInfoBean.f18399l);
        map5.put("A36", sb3.toString());
        Map<String, String> map6 = buVar.f18745f;
        StringBuilder sb4 = new StringBuilder();
        sb4.append(userInfoBean.f18394g);
        map6.put("F02", sb4.toString());
        Map<String, String> map7 = buVar.f18745f;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(userInfoBean.f18395h);
        map7.put("F03", sb5.toString());
        buVar.f18745f.put("F04", userInfoBean.f18397j);
        Map<String, String> map8 = buVar.f18745f;
        StringBuilder sb6 = new StringBuilder();
        sb6.append(userInfoBean.f18396i);
        map8.put("F05", sb6.toString());
        buVar.f18745f.put("F06", userInfoBean.f18400m);
        Map<String, String> map9 = buVar.f18745f;
        StringBuilder sb7 = new StringBuilder();
        sb7.append(userInfoBean.f18398k);
        map9.put("F10", sb7.toString());
        al.c("summary type %d vm:%d", Byte.valueOf(buVar.b), Integer.valueOf(buVar.f18745f.size()));
        return buVar;
    }

    public static <T extends m> T a(byte[] bArr, Class<T> cls) {
        if (bArr != null && bArr.length > 0) {
            try {
                T tNewInstance = cls.newInstance();
                k kVar = new k(bArr);
                kVar.a(com.anythink.expressad.foundation.g.a.bN);
                tNewInstance.a(kVar);
                return tNewInstance;
            } catch (Throwable th) {
                if (!al.b(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public static bq a(Context context, int i2, byte[] bArr) {
        aa aaVarB = aa.b();
        StrategyBean strategyBeanC = ac.a().c();
        if (aaVarB != null && strategyBeanC != null) {
            try {
                bq bqVar = new bq();
                synchronized (aaVarB) {
                    bqVar.a = aaVarB.b;
                    bqVar.b = aaVarB.e();
                    bqVar.f18698c = aaVarB.f18471c;
                    bqVar.f18699d = aaVarB.f18483o;
                    bqVar.f18700e = aaVarB.f18487s;
                    bqVar.f18701f = aaVarB.f18476h;
                    bqVar.f18702g = i2;
                    if (bArr == null) {
                        bArr = "".getBytes();
                    }
                    bqVar.f18703h = bArr;
                    bqVar.f18704i = aaVarB.h();
                    bqVar.f18705j = aaVarB.f18479k;
                    bqVar.f18706k = new HashMap();
                    bqVar.f18707l = aaVarB.d();
                    bqVar.f18708m = strategyBeanC.f18420o;
                    bqVar.f18710o = aaVarB.g();
                    bqVar.f18711p = ab.c(context);
                    bqVar.f18712q = System.currentTimeMillis();
                    bqVar.f18714s = aaVarB.i();
                    bqVar.f18717v = aaVarB.g();
                    bqVar.f18718w = bqVar.f18711p;
                    aaVarB.getClass();
                    bqVar.f18709n = "com.tencent.bugly";
                    bqVar.f18706k.put("A26", aaVarB.s());
                    Map<String, String> map = bqVar.f18706k;
                    StringBuilder sb = new StringBuilder();
                    sb.append(aa.C());
                    map.put("A62", sb.toString());
                    Map<String, String> map2 = bqVar.f18706k;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(aa.D());
                    map2.put("A63", sb2.toString());
                    Map<String, String> map3 = bqVar.f18706k;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(aaVarB.J);
                    map3.put("F11", sb3.toString());
                    Map<String, String> map4 = bqVar.f18706k;
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(aaVarB.I);
                    map4.put("F12", sb4.toString());
                    bqVar.f18706k.put("D3", aaVarB.f18485q);
                    if (p.b != null) {
                        for (o oVar : p.b) {
                            if (oVar.versionKey != null && oVar.version != null) {
                                bqVar.f18706k.put(oVar.versionKey, oVar.version);
                            }
                        }
                    }
                    bqVar.f18706k.put("G15", ap.d("G15", ""));
                    bqVar.f18706k.put("G10", ap.d("G10", ""));
                    bqVar.f18706k.put("D4", ap.d("D4", "0"));
                }
                Map<String, String> mapX = aaVarB.x();
                if (mapX != null) {
                    for (Map.Entry<String, String> entry : mapX.entrySet()) {
                        if (!TextUtils.isEmpty(entry.getValue())) {
                            bqVar.f18706k.put(entry.getKey(), entry.getValue());
                        }
                    }
                }
                return bqVar;
            } catch (Throwable th) {
                if (!al.b(th)) {
                    th.printStackTrace();
                }
                return null;
            }
        }
        al.e("Can not create request pkg for parameters is invalid.", new Object[0]);
        return null;
    }

    public static byte[] a(Object obj) {
        try {
            e eVar = new e();
            eVar.b();
            eVar.a(com.anythink.expressad.foundation.g.a.bN);
            eVar.c();
            eVar.b("RqdServer");
            eVar.c("sync");
            eVar.a("detail", obj);
            return eVar.a();
        } catch (Throwable th) {
            if (al.b(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public static br a(byte[] bArr) {
        if (bArr != null) {
            try {
                e eVar = new e();
                eVar.b();
                eVar.a(com.anythink.expressad.foundation.g.a.bN);
                eVar.a(bArr);
                Object objB = eVar.b("detail", new br());
                if (br.class.isInstance(objB)) {
                    return (br) br.class.cast(objB);
                }
                return null;
            } catch (Throwable th) {
                if (!al.b(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public static byte[] a(m mVar) {
        try {
            l lVar = new l();
            lVar.a(com.anythink.expressad.foundation.g.a.bN);
            mVar.a(lVar);
            byte[] bArr = new byte[lVar.a.position()];
            System.arraycopy(lVar.a.array(), 0, bArr, 0, lVar.a.position());
            return bArr;
        } catch (Throwable th) {
            if (al.b(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }
}
