package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class co {
    public static void a(Context context, String str) {
        try {
            a(context, str, null, false, true);
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context, String str, final String str2, final boolean z2, boolean z3) {
        JSONObject jSONObject;
        StringBuilder sb;
        try {
            String string = ct.a + ct.f16670e;
            String strA = cu.a(context);
            if (!TextUtils.isEmpty(strA)) {
                if (!ct.a() || str2 == null) {
                    sb = new StringBuilder();
                    sb.append(string);
                    sb.append("?");
                } else {
                    sb = new StringBuilder();
                    sb.append(string);
                    sb.append("?logId=");
                    sb.append(str2);
                    sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
                }
                sb.append(strA);
                string = sb.toString();
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (z3) {
                jSONObject = new JSONObject();
                String strC = new bm(context).c(str);
                if (!TextUtils.isEmpty(strC)) {
                    jSONObject.put("data", strC);
                }
            } else {
                jSONObject = new JSONObject(str);
            }
            l lVarA = l.a(context);
            m mVar = new m(string, jSONObject);
            mVar.a(WeaponHI.cookieData);
            mVar.b(WeaponHI.encryENV);
            lVarA.b(mVar, new j() { // from class: com.kuaishou.weapon.p0.co.1
                @Override // com.kuaishou.weapon.p0.j
                public final void a(String str3) {
                }

                @Override // com.kuaishou.weapon.p0.j
                public final void b(String str3) {
                    if (z2) {
                        TextUtils.isEmpty(str2);
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }
}
