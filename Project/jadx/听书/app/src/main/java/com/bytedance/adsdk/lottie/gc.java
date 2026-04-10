package com.bytedance.adsdk.lottie;

import android.content.Context;
import android.os.Trace;
import com.funny.audio.core.utils.FileUtils;
import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public class gc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f148a = true;
    private static boolean dl = true;
    private static int e;
    private static com.bytedance.adsdk.lottie.dl.m fo;
    private static boolean g;
    private static String[] gc;
    private static int gz;
    private static volatile com.bytedance.adsdk.lottie.dl.gz kb;
    private static long[] m;
    private static com.bytedance.adsdk.lottie.dl.gc uy;
    private static volatile com.bytedance.adsdk.lottie.dl.e wp;
    public static boolean z;

    public static void z(String str) {
        if (g) {
            int i = e;
            if (i == 20) {
                gz++;
                return;
            }
            gc[i] = str;
            m[i] = System.nanoTime();
            Trace.beginSection(str);
            e++;
        }
    }

    public static float g(String str) {
        int i = gz;
        if (i > 0) {
            gz = i - 1;
            return 0.0f;
        }
        if (!g) {
            return 0.0f;
        }
        int i2 = e - 1;
        e = i2;
        if (i2 == -1) {
            throw new IllegalStateException("Can't end trace section. There are none.");
        }
        if (!str.equals(gc[i2])) {
            throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + gc[e] + FileUtils.FILE_EXTENSION_SEPARATOR);
        }
        Trace.endSection();
        return (System.nanoTime() - m[e]) / 1000000.0f;
    }

    public static com.bytedance.adsdk.lottie.dl.gz z(Context context) {
        com.bytedance.adsdk.lottie.dl.gz gzVar = kb;
        if (gzVar == null) {
            synchronized (com.bytedance.adsdk.lottie.dl.gz.class) {
                gzVar = kb;
                if (gzVar == null) {
                    com.bytedance.adsdk.lottie.dl.e eVarG = g(context);
                    com.bytedance.adsdk.lottie.dl.m gVar = fo;
                    if (gVar == null) {
                        gVar = new com.bytedance.adsdk.lottie.dl.g();
                    }
                    gzVar = new com.bytedance.adsdk.lottie.dl.gz(eVarG, gVar);
                    kb = gzVar;
                }
            }
        }
        return gzVar;
    }

    public static com.bytedance.adsdk.lottie.dl.e g(Context context) {
        if (!dl) {
            return null;
        }
        final Context applicationContext = context.getApplicationContext();
        com.bytedance.adsdk.lottie.dl.e eVar = wp;
        if (eVar == null) {
            synchronized (com.bytedance.adsdk.lottie.dl.e.class) {
                eVar = wp;
                if (eVar == null) {
                    com.bytedance.adsdk.lottie.dl.gc gcVar = uy;
                    if (gcVar == null) {
                        gcVar = new com.bytedance.adsdk.lottie.dl.gc() { // from class: com.bytedance.adsdk.lottie.gc.1
                            @Override // com.bytedance.adsdk.lottie.dl.gc
                            public File z() {
                                return new File(com.bytedance.sdk.openadsdk.api.plugin.g.g(applicationContext), "lottie_network_cache");
                            }
                        };
                    }
                    eVar = new com.bytedance.adsdk.lottie.dl.e(gcVar);
                    wp = eVar;
                }
            }
        }
        return eVar;
    }

    public static boolean z() {
        return f148a;
    }
}
