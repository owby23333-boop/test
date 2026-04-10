package com.bytedance.sdk.component.adexpress.dynamic.bf;

import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.dynamic.d.p;

/* JADX INFO: loaded from: classes.dex */
public class e {
    public static int e(p pVar) {
        if (pVar == null) {
            return 0;
        }
        String strR = pVar.r();
        String strWl = pVar.wl();
        if (TextUtils.isEmpty(strWl) || TextUtils.isEmpty(strR) || !strWl.equals("creative")) {
            return 0;
        }
        if (strR.equals("shake")) {
            return 2;
        }
        if (strR.equals("twist")) {
            return 3;
        }
        if (strR.equals("slide")) {
            String strZa = pVar.za();
            long jLc = pVar.lc();
            if (!TextUtils.isEmpty(strZa) && jLc >= 0) {
                return 1;
            }
        }
        return 0;
    }
}
