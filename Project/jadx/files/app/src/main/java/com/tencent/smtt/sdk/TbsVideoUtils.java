package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.export.external.DexLoader;

/* JADX INFO: loaded from: classes3.dex */
public class TbsVideoUtils {
    private static s a;

    private static void a(Context context) {
        synchronized (TbsVideoUtils.class) {
            if (a == null) {
                g.a(true).a(context, false, false);
                u uVarA = g.a(true).a();
                DexLoader dexLoaderC = uVarA != null ? uVarA.c() : null;
                if (dexLoaderC != null) {
                    a = new s(dexLoaderC);
                }
            }
        }
    }

    public static void deleteVideoCache(Context context, String str) {
        a(context);
        s sVar = a;
        if (sVar != null) {
            sVar.a(context, str);
        }
    }

    public static String getCurWDPDecodeType(Context context) {
        a(context);
        s sVar = a;
        return sVar != null ? sVar.a(context) : "";
    }
}
