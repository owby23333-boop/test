package com.yuewen;

import android.content.Context;
import com.xiaomi.accountsdk.account.data.ExtendedAuthToken;

/* JADX INFO: loaded from: classes2.dex */
public class n22 {
    public static void a() {
        com.duokan.reader.common.misdk.d dVarB = com.duokan.reader.common.misdk.d.B();
        if (e()) {
            dVarB.f();
        } else {
            dVarB.k();
        }
    }

    public static ExtendedAuthToken b(Context context, String str) {
        String strH = com.duokan.reader.common.misdk.d.B().h(context, str);
        if (strH == null) {
            return null;
        }
        return ExtendedAuthToken.parse(strH);
    }

    public static com.duokan.reader.common.misdk.d c(Context context) {
        return d(context, false);
    }

    public static com.duokan.reader.common.misdk.d d(Context context, boolean z) {
        if (!z) {
            a();
        }
        return com.duokan.reader.common.misdk.d.B();
    }

    public static boolean e() {
        com.duokan.reader.common.misdk.d dVarB = com.duokan.reader.common.misdk.d.B();
        if (dVarB.r() == null) {
            return false;
        }
        dVarB.k();
        return !dVarB.c();
    }
}
