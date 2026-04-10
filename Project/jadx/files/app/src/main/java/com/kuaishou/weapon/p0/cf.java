package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class cf {
    public static void a(Context context, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("result", 0) == 1) {
                JSONObject jSONObject2 = new JSONObject(new bm(context).a(jSONObject.getString("dataRsp")));
                String string = jSONObject2.getString("conjure");
                if (jSONObject2.getInt("status") == 1) {
                    bw.a(context, string);
                    bw.b(context, string);
                }
            }
        } catch (Exception unused) {
        }
    }

    public static void a(final Context context, String str, String str2, boolean z2) {
        JSONObject jSONObject;
        try {
            String str3 = ct.a + ct.f16671f;
            String strA = cu.a(context);
            if (!TextUtils.isEmpty(strA)) {
                if (!ct.a() || str2 == null) {
                    str3 = str3 + "?" + strA;
                } else {
                    str3 = str3 + "?logId=" + str2 + DispatchConstants.SIGN_SPLIT_SYMBOL + strA;
                }
            }
            String str4 = str3;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (z2) {
                jSONObject = new JSONObject();
                String strC = new bm(context).c(str);
                if (!TextUtils.isEmpty(strC)) {
                    jSONObject.put("data", strC);
                }
            } else {
                jSONObject = new JSONObject(str);
            }
            n.a().a(new k(context, WeaponHI.cookieData, WeaponHI.encryENV, str4, jSONObject, new j() { // from class: com.kuaishou.weapon.p0.cf.1
                @Override // com.kuaishou.weapon.p0.j
                public final void a(String str5) {
                    cf.a(context, str5);
                }

                @Override // com.kuaishou.weapon.p0.j
                public final void b(String str5) {
                }
            }));
        } catch (Exception unused) {
        }
    }
}
