package com.anythink.expressad.video.module.b;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.anythink.core.common.b.n;
import com.anythink.expressad.foundation.d.c;
import com.anythink.expressad.foundation.g.f.h.b;
import com.anythink.expressad.foundation.h.j;
import com.anythink.expressad.foundation.h.o;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static HashMap<String, ArrayList<String>> a = new HashMap<>();
    private static final String b = "VideoViewReport";

    public static void a() {
    }

    public static void a(String str) {
        a.remove(str);
    }

    public static void b(Context context, c cVar) {
        if (cVar == null || cVar.L() == null || cVar.L().j() == null) {
            return;
        }
        com.anythink.expressad.a.a.a(context, cVar, cVar.K(), cVar.L().j(), false);
    }

    public static void c(Context context, c cVar) {
        if (cVar == null || cVar.L() == null || cVar.L().k() == null) {
            return;
        }
        com.anythink.expressad.a.a.a(context, cVar, cVar.K(), cVar.L().k(), false);
    }

    public static void d(Context context, c cVar) {
        if (cVar == null || cVar.L() == null || cVar.L().q() == null) {
            return;
        }
        com.anythink.expressad.a.a.a(context, cVar, cVar.K(), cVar.L().q(), false);
    }

    public static void e(Context context, c cVar) {
        if (cVar == null || cVar.L() == null || cVar.L().m() == null) {
            return;
        }
        com.anythink.expressad.a.a.a(context, cVar, cVar.K(), cVar.L().m(), false);
    }

    private static void f(Context context, c cVar) {
        if (cVar == null || cVar.L() == null || cVar.L().d() == null) {
            return;
        }
        com.anythink.expressad.a.a.a(context, cVar, cVar.K(), cVar.L().d(), true);
    }

    private static void g(Context context, c cVar) {
        if (cVar == null || cVar.L() == null || cVar.L().e() == null) {
            return;
        }
        com.anythink.expressad.a.a.a(context, cVar, cVar.K(), cVar.L().e(), false);
    }

    private static void h(Context context, c cVar) {
        if (cVar == null || cVar.L() == null || cVar.L().f() == null) {
            return;
        }
        com.anythink.expressad.a.a.a(context, cVar, cVar.K(), cVar.L().f(), false);
    }

    private static void i(Context context, c cVar) {
        if (cVar == null || cVar.L() == null || cVar.L().g() == null) {
            return;
        }
        com.anythink.expressad.a.a.a(context, cVar, cVar.K(), cVar.L().g(), false);
    }

    private static void j(Context context, c cVar) {
        if (cVar == null || cVar.L() == null || cVar.L().h() == null) {
            return;
        }
        com.anythink.expressad.a.a.a(context, cVar, cVar.K(), cVar.L().h(), false);
    }

    private static void k(Context context, c cVar) {
        if (cVar == null || cVar.L() == null || cVar.L().l() == null) {
            return;
        }
        String strK = cVar.K();
        ArrayList<String> arrayList = a.get(strK);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            a.put(strK, arrayList);
        }
        if (arrayList.contains(cVar.aZ())) {
            return;
        }
        com.anythink.expressad.a.a.a(context, cVar, cVar.K(), cVar.L().l(), false);
        arrayList.add(cVar.aZ());
    }

    public static void a(Context context, c cVar) {
        if (cVar == null || cVar.L() == null || cVar.L().o() == null) {
            return;
        }
        com.anythink.expressad.a.a.a(context, cVar, cVar.K(), cVar.L().o(), false);
    }

    public static void a(Context context, c cVar, int i2, int i3) {
        try {
            String[] strArrP = cVar.L().p();
            if (cVar == null || cVar.L() == null || strArrP == null) {
                return;
            }
            String[] strArr = new String[strArrP.length];
            for (int i4 = 0; i4 < strArrP.length; i4++) {
                String str = strArrP[i4];
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("endscreen_type", i2);
                String string = jSONObject.toString();
                if (!TextUtils.isEmpty(string)) {
                    string = j.a(string);
                }
                if (!TextUtils.isEmpty(string)) {
                    str = str + "&value=" + URLEncoder.encode(string);
                }
                strArr[i4] = cVar.n() == 1 ? str + "&to=1&cbt=" + cVar.az() + "&tmorl=" + i3 : str + "&to=0&cbt=" + cVar.az() + "&tmorl=" + i3;
            }
            com.anythink.expressad.a.a.a(context, cVar, cVar.K(), strArr, true);
        } catch (Throwable unused) {
            o.d("", "reportEndcardshowData error");
        }
    }

    public static void a(Context context, c cVar, int i2, int i3, int i4) {
        String str;
        if (i3 == 0 || context == null || cVar == null) {
            return;
        }
        try {
            List<Map<Integer, String>> listI = cVar.L().i();
            int i5 = ((i2 + 1) * 100) / i3;
            if (listI != null) {
                int i6 = 0;
                while (i6 < listI.size()) {
                    Map<Integer, String> map = listI.get(i6);
                    if (map != null && map.size() > 0) {
                        Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
                        while (it.hasNext()) {
                            Map.Entry<Integer, String> next = it.next();
                            int iIntValue = next.getKey().intValue();
                            String value = next.getValue();
                            if (cVar.n() == 1) {
                                str = value + "&to=1&cbt=" + cVar.az() + "&tmorl=" + i4;
                            } else {
                                str = value + "&to=0&cbt=" + cVar.az() + "&tmorl=" + i4;
                            }
                            if (iIntValue <= i5 && !TextUtils.isEmpty(str)) {
                                com.anythink.expressad.a.a.a(context, cVar, cVar.K(), new String[]{str}, true);
                                it.remove();
                                listI.remove(i6);
                                i6--;
                            }
                        }
                    }
                    i6++;
                }
            }
        } catch (Throwable unused) {
            o.d("", "reportPlayPercentageData error");
        }
    }

    public static void a(c cVar, Map<Integer, String> map, String str, int i2) {
        if (cVar == null || map == null) {
            return;
        }
        try {
            if (map.size() > 0) {
                Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<Integer, String> next = it.next();
                    Integer key = next.getKey();
                    String value = next.getValue();
                    if (i2 == key.intValue() && !TextUtils.isEmpty(value)) {
                        com.anythink.expressad.a.a.a(n.a().g(), cVar, str, value, false);
                        it.remove();
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void a(c cVar, String str) {
        if (cVar != null) {
            try {
                if (cVar.al() == null || cVar.al().size() <= 0) {
                    return;
                }
                for (String str2 : cVar.al()) {
                    if (!TextUtils.isEmpty(str2)) {
                        com.anythink.expressad.a.a.a(n.a().g(), cVar, str, str2, false);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void a(c cVar, com.anythink.expressad.videocommon.c.c cVar2, String str, String str2, String str3) {
        String str4 = DispatchConstants.SIGN_SPLIT_SYMBOL;
        String str5 = "";
        if (cVar == null || cVar2 == null) {
            return;
        }
        try {
            com.anythink.expressad.video.module.c.a aVar = new com.anythink.expressad.video.module.c.a(n.a().g());
            b bVar = new b();
            bVar.a("user_id", j.a(str2));
            bVar.a(com.anythink.expressad.d.a.b.aM, "1");
            bVar.a("reward_name", cVar2.a());
            StringBuilder sb = new StringBuilder();
            sb.append(cVar2.b());
            bVar.a("reward_amount", sb.toString());
            bVar.a("unit_id", str);
            bVar.a("click_id", cVar.aa());
            if (!TextUtils.isEmpty(str3)) {
                bVar.a("extra", str3);
            }
            aVar.a("", bVar);
            String string = cVar.ak() + "/addReward?";
            String strTrim = bVar.a().trim();
            if (!TextUtils.isEmpty(strTrim)) {
                if (!string.endsWith("?") && !string.endsWith(DispatchConstants.SIGN_SPLIT_SYMBOL)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(string);
                    if (!string.contains("?")) {
                        str4 = "?";
                    }
                    sb2.append(str4);
                    string = sb2.toString();
                }
                str5 = string + strTrim;
            }
            o.d(b, "rewardUrl:".concat(String.valueOf(str5)));
            com.anythink.expressad.a.a.a(n.a().g(), cVar, cVar.K(), str5, false);
        } catch (Throwable th) {
            o.b(b, th.getMessage(), th);
        }
    }

    private static String a(String str, b bVar) {
        String strTrim = bVar.a().trim();
        if (TextUtils.isEmpty(strTrim)) {
            return "";
        }
        if (!str.endsWith("?") && !str.endsWith(DispatchConstants.SIGN_SPLIT_SYMBOL)) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(str.contains("?") ? DispatchConstants.SIGN_SPLIT_SYMBOL : "?");
            str = sb.toString();
        }
        return str + strTrim;
    }
}
