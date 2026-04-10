package com.bytedance.adsdk.lottie;

import android.content.Context;
import android.os.Trace;
import com.alibaba.android.arouter.utils.Consts;
import com.bytedance.component.sdk.annotation.RestrictTo;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class ga {
    private static boolean bf = false;
    private static boolean d = true;
    public static boolean e = false;
    private static String[] ga = null;
    private static com.bytedance.adsdk.lottie.tg.ga m = null;
    private static int p = 0;
    private static boolean tg = true;
    private static int v;
    private static long[] vn;
    private static volatile com.bytedance.adsdk.lottie.tg.v wu;
    private static volatile com.bytedance.adsdk.lottie.tg.p xu;
    private static com.bytedance.adsdk.lottie.tg.vn zk;

    public static float bf(String str) {
        int i = v;
        if (i > 0) {
            v = i - 1;
            return 0.0f;
        }
        if (!bf) {
            return 0.0f;
        }
        int i2 = p - 1;
        p = i2;
        if (i2 == -1) {
            throw new IllegalStateException("Can't end trace section. There are none.");
        }
        if (str.equals(ga[i2])) {
            Trace.endSection();
            return (System.nanoTime() - vn[p]) / 1000000.0f;
        }
        throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + ga[p] + Consts.DOT);
    }

    public static void e(String str) {
        if (bf) {
            int i = p;
            if (i == 20) {
                v++;
                return;
            }
            ga[i] = str;
            vn[i] = System.nanoTime();
            Trace.beginSection(str);
            p++;
        }
    }

    public static com.bytedance.adsdk.lottie.tg.v e(Context context) {
        com.bytedance.adsdk.lottie.tg.v vVar = wu;
        if (vVar == null) {
            synchronized (com.bytedance.adsdk.lottie.tg.v.class) {
                vVar = wu;
                if (vVar == null) {
                    com.bytedance.adsdk.lottie.tg.p pVarBf = bf(context);
                    com.bytedance.adsdk.lottie.tg.vn bfVar = zk;
                    if (bfVar == null) {
                        bfVar = new com.bytedance.adsdk.lottie.tg.bf();
                    }
                    vVar = new com.bytedance.adsdk.lottie.tg.v(pVarBf, bfVar);
                    wu = vVar;
                }
            }
        }
        return vVar;
    }

    public static com.bytedance.adsdk.lottie.tg.p bf(Context context) {
        if (!d) {
            return null;
        }
        final Context applicationContext = context.getApplicationContext();
        com.bytedance.adsdk.lottie.tg.p pVar = xu;
        if (pVar == null) {
            synchronized (com.bytedance.adsdk.lottie.tg.p.class) {
                pVar = xu;
                if (pVar == null) {
                    com.bytedance.adsdk.lottie.tg.ga gaVar = m;
                    if (gaVar == null) {
                        gaVar = new com.bytedance.adsdk.lottie.tg.ga() { // from class: com.bytedance.adsdk.lottie.ga.1
                            @Override // com.bytedance.adsdk.lottie.tg.ga
                            public File e() {
                                return new File(applicationContext.getCacheDir(), "lottie_network_cache");
                            }
                        };
                    }
                    pVar = new com.bytedance.adsdk.lottie.tg.p(gaVar);
                    xu = pVar;
                }
            }
        }
        return pVar;
    }

    public static boolean e() {
        return tg;
    }
}
