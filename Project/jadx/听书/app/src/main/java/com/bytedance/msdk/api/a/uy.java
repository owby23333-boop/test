package com.bytedance.msdk.api.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.msdk.api.activity.TTDelegateActivity;
import com.bytedance.msdk.gz.io;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class uy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f352a = -1;
    private static long dl = -1;
    private static z g;
    private static Context z;

    public static void z(final Activity activity, final List<i> list, final int i, final int i2) {
        z(new ls() { // from class: com.bytedance.msdk.api.a.uy.1
            @Override // com.bytedance.msdk.api.a.ls
            public void z() {
                com.bytedance.msdk.core.gc.g.a.z().z(activity, list, i, i2);
            }
        });
    }

    public static void z(ls lsVar) {
        com.bytedance.msdk.core.g.g().z(lsVar);
    }

    public static boolean z() {
        if (TextUtils.isEmpty(com.bytedance.msdk.core.z.kb().wp())) {
            return false;
        }
        return com.bytedance.msdk.core.g.g().h();
    }

    public static void z(Context context, z zVar) {
        if (dl == -1) {
            dl = System.currentTimeMillis();
            if (zVar != null && zVar.dl()) {
                com.bytedance.msdk.z.gc.dl.z();
                com.bytedance.sdk.component.fo.z.z();
            }
            com.bytedance.msdk.z.gc.dl.g("TMe", "call init time " + dl);
            z = context;
            g = zVar;
        }
    }

    public static long g() {
        return dl;
    }

    public static long dl() {
        return f352a;
    }

    public static void a() {
        if (z == null || g == null) {
            return;
        }
        if (f352a == -1) {
            f352a = System.currentTimeMillis();
            com.bytedance.msdk.z.gc.dl.g("TMe", "call start up time " + f352a);
        }
        g(z, g);
        com.bytedance.msdk.m.a.g();
    }

    private static void g(Context context, z zVar) {
        com.bytedance.msdk.core.z.kb().dl(zVar.z());
        com.bytedance.msdk.core.z.kb().dl(zVar.pf());
        com.bytedance.msdk.e.g.z.z().m();
        com.bytedance.msdk.m.dl.z(zVar, context.getApplicationContext());
        com.bytedance.msdk.e.g.z.z().e();
    }

    public static void z(m mVar) {
        com.bytedance.msdk.core.z.kb().z(mVar, false);
    }

    public static void z(String str) {
        com.bytedance.msdk.z.gc.dl.z("TTMediationSDK", "app运行中setPulisherDid: ".concat(String.valueOf(str)));
        com.bytedance.msdk.core.z.kb().a(str);
    }

    public static void z(com.bytedance.sdk.openadsdk.ls.dl.dl.a aVar) {
        com.bytedance.msdk.core.z.kb().g().g(com.bytedance.msdk.m.g.gc.z(aVar));
        com.bytedance.msdk.core.z.kb().io();
        com.bytedance.msdk.m.dl.z(com.bytedance.msdk.m.g.gc.z(aVar));
    }

    public static void z(Context context) {
        if (context == null) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 3);
        if (context != null) {
            com.bytedance.msdk.gz.a.z(context, intent, null);
        }
    }

    public static void z(Context context, int[] iArr) {
        Intent intent = new Intent(context, (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 1);
        intent.putExtra("permissions", iArr);
        if (context != null) {
            com.bytedance.msdk.gz.a.z(context, intent, null);
        }
    }

    public static String gc() {
        return com.bytedance.msdk.g.g.g();
    }

    public static void z(int i) {
        HashMap map = new HashMap();
        map.put(com.bytedance.msdk.z.z.z.gc, Integer.valueOf(i));
        Map<String, com.bytedance.msdk.z.z.a> mapG = com.bytedance.msdk.m.g.g.z().g();
        if (mapG == null || mapG.size() == 0) {
            return;
        }
        for (com.bytedance.msdk.z.z.a aVar : com.bytedance.msdk.m.g.g.z().dl()) {
            if (aVar != null) {
                aVar.z(map);
            }
        }
    }

    public static int z(dl dlVar) {
        com.bytedance.msdk.z.z.a aVarZ = com.bytedance.msdk.m.g.g.z().z(MediationConstant.ADN_GDT);
        if (aVarZ == null) {
            return 0;
        }
        return aVarZ.z(dlVar);
    }

    public static boolean m() {
        return com.bytedance.msdk.core.z.kb().v();
    }

    public static void g(String str) {
        com.bytedance.msdk.core.z.kb().gc(str);
    }

    public static String e() {
        return com.bytedance.msdk.core.z.kb().pf();
    }

    public static Map<String, String> gz() {
        return com.bytedance.msdk.core.z.kb().ls();
    }

    public static boolean fo() {
        return com.bytedance.msdk.core.z.kb().tb();
    }

    public static String dl(String str) {
        str.hashCode();
        switch (str) {
            case "tt_pangle_preview_ext":
                return com.bytedance.msdk.gz.a.a.dl();
            case "tt_pangle_preview_creative_id":
                return com.bytedance.msdk.gz.a.a.g();
            case "tt_pangle_preview_ad_id":
                return com.bytedance.msdk.gz.a.a.z();
            default:
                return null;
        }
    }

    public static String uy() {
        return com.bytedance.msdk.core.z.kb().fv();
    }

    public static String kb() {
        return com.bytedance.msdk.core.z.kb().wp();
    }

    public static String g(Context context) {
        return io.g();
    }

    public static boolean z(String str, String str2) {
        return com.bytedance.msdk.m.z.z(str, str2);
    }

    public static boolean g(String str, String str2) {
        return com.bytedance.msdk.m.z.g(str, str2);
    }

    @Deprecated
    public static boolean a(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(com.bytedance.msdk.core.z.kb().wp())) {
            return false;
        }
        return com.bytedance.msdk.core.g.g().dl(str);
    }

    @Deprecated
    public static com.bytedance.msdk.api.a.z.g.m.z gc(String str) {
        return com.bytedance.msdk.m.g.z.z(str);
    }

    @Deprecated
    public static com.bytedance.msdk.z.z.a m(String str) {
        return com.bytedance.msdk.m.g.g.z().z(str);
    }

    @Deprecated
    public static void g(int i) {
        com.bytedance.msdk.core.g.g().dl(i);
    }

    @Deprecated
    public static void wp() {
        com.bytedance.msdk.core.g.g().dl(com.bytedance.msdk.e.z.z().dl("if_test"));
    }

    public static Map<String, Object> i() {
        return com.bytedance.msdk.core.z.kb().un();
    }

    public static void z(com.bytedance.msdk.api.a.z.fo.z zVar) {
        if (!com.bytedance.msdk.m.dl.g()) {
            com.bytedance.msdk.core.z.kb().z(zVar);
        } else if (zVar != null) {
            zVar.z();
        }
    }
}
