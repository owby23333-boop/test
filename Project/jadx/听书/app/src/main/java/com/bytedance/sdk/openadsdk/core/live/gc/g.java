package com.bytedance.sdk.openadsdk.core.live.gc;

import android.util.SparseArray;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.un.x;
import com.bytedance.sdk.openadsdk.core.uy;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private static com.bytedance.sdk.component.a.g.dl z;

    private static void g() {
        if (z == null) {
            z = x.z("csj_live");
        }
    }

    public static void z(String str) {
        g();
        try {
            com.bytedance.sdk.component.a.g.dl dlVar = z;
            if (dlVar != null) {
                z.put("live_init_".concat(String.valueOf(str)), dlVar.get("live_init_".concat(String.valueOf(str)), 0) + 1);
            }
        } catch (Throwable th) {
            wp.z(th);
        }
    }

    public static void g(String str) {
        g();
        try {
            com.bytedance.sdk.component.a.g.dl dlVar = z;
            if (dlVar != null) {
                dlVar.put("live_init_".concat(String.valueOf(str)), 0);
            }
        } catch (Throwable th) {
            wp.z(th);
        }
    }

    public static boolean dl(String str) {
        g();
        com.bytedance.sdk.component.a.g.dl dlVar = z;
        return (dlVar != null ? dlVar.get("live_init_".concat(String.valueOf(str)), 0) : 0) < 5;
    }

    public static void a(String str) {
        z();
        g(str);
    }

    public static void z() {
        try {
            Function<SparseArray<Object>, Object> functionM = uy.ls().m(4);
            if (functionM != null) {
                functionM.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(100).z(Void.class).z(0, "com.byted.live.lite").g());
            }
        } catch (Throwable th) {
            wp.z(th);
        }
    }
}
