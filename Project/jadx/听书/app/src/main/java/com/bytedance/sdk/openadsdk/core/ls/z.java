package com.bytedance.sdk.openadsdk.core.ls;

import android.text.TextUtils;
import com.bytedance.sdk.component.fo.g;
import com.bytedance.sdk.component.fo.g.a;
import com.bytedance.sdk.component.fo.g.dl;
import com.bytedance.sdk.component.utils.gc;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.component.uy.e;
import com.bytedance.sdk.component.uy.fo;
import com.bytedance.sdk.openadsdk.core.iq.un;
import com.bytedance.sdk.openadsdk.core.un.x;
import com.bytedance.sdk.openadsdk.core.zw;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    public static String g = "";
    public static String z = "";

    public static void z(final RunnableC0187z runnableC0187z) {
        un unVarSv = zw.g().sv();
        final String strZ = unVarSv == null ? null : unVarSv.z();
        if (TextUtils.isEmpty(strZ)) {
            return;
        }
        if (TextUtils.isEmpty(g)) {
            g = strZ;
        }
        e.g(new fo("loadPfJs") { // from class: com.bytedance.sdk.openadsdk.core.ls.z.1
            @Override // java.lang.Runnable
            public void run() {
                RunnableC0187z runnableC0187z2;
                String str = strZ;
                if (str != null && str.equalsIgnoreCase(z.g)) {
                    if (TextUtils.isEmpty(z.z)) {
                        z.z = x.z("js_pform").get(gc.g(strZ), "");
                    }
                    if (!TextUtils.isEmpty(z.z) && (runnableC0187z2 = runnableC0187z) != null) {
                        runnableC0187z2.run();
                        return;
                    }
                }
                dl dlVarDl = com.bytedance.sdk.openadsdk.core.io.gc.z().g().dl();
                dlVarDl.z(strZ);
                HashMap map = new HashMap();
                map.put("content-type", "application/json; charset=utf-8");
                dlVarDl.a(map);
                dlVarDl.z(new com.bytedance.sdk.component.fo.z.z() { // from class: com.bytedance.sdk.openadsdk.core.ls.z.1.1
                    @Override // com.bytedance.sdk.component.fo.z.z
                    public void z(a aVar, IOException iOException) {
                    }

                    @Override // com.bytedance.sdk.component.fo.z.z
                    public void z(a aVar, g gVar) {
                        try {
                            z.z = gVar.a();
                            z.g = strZ;
                            if (runnableC0187z != null) {
                                runnableC0187z.run();
                            }
                            x.z("js_pform").clear();
                            x.z("js_pform").put(gc.g(strZ), z.z);
                        } catch (Throwable th) {
                            wp.dl("performanceH5", "TTWebViewClient : onPageFinished", th);
                        }
                    }
                });
            }
        });
    }

    public static void z(StringBuilder sb, String str, String str2) {
        int iIndexOf;
        if (sb == null || TextUtils.isEmpty(str) || (iIndexOf = sb.indexOf(str)) <= 0) {
            return;
        }
        sb.replace(iIndexOf, str.length() + iIndexOf, str2);
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.ls.z$z, reason: collision with other inner class name */
    public static class RunnableC0187z implements Runnable {
        private WeakReference<Runnable> z;

        public RunnableC0187z(Runnable runnable) {
            if (runnable != null) {
                this.z = new WeakReference<>(runnable);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            WeakReference<Runnable> weakReference = this.z;
            Runnable runnable = weakReference != null ? weakReference.get() : null;
            if (runnable != null) {
                runnable.run();
            }
        }
    }
}
