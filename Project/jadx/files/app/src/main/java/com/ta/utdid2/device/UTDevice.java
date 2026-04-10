package com.ta.utdid2.device;

import android.content.Context;
import com.ta.utdid2.a.a.f;

/* JADX INFO: loaded from: classes3.dex */
public class UTDevice {
    private static String c(Context context) {
        a aVarB = b.b(context);
        return (aVarB == null || f.m175a(aVarB.e())) ? "ffffffffffffffffffffffff" : aVarB.e();
    }

    private static String d(Context context) {
        String strG = c.a(context).g();
        return (strG == null || f.m175a(strG)) ? "ffffffffffffffffffffffff" : strG;
    }

    @Deprecated
    public static String getUtdid(Context context) {
        return c(context);
    }

    @Deprecated
    public static String getUtdidForUpdate(Context context) {
        return d(context);
    }
}
