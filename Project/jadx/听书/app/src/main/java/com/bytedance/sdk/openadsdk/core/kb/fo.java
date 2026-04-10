package com.bytedance.sdk.openadsdk.core.kb;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.component.utils.hh;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.iq.ls;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.tb;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.m;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.un.z;
import com.bytedance.sdk.openadsdk.core.uy;
import com.bytedance.sdk.openadsdk.core.zw;
import com.kuaishou.weapon.p0.bq;
import java.io.File;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class fo {
    public static void z(String str, na naVar) {
        boolean zE;
        try {
            if (zw.getContext() == null || TextUtils.isEmpty(str) || !(zE = tb.e(naVar))) {
                return;
            }
            ls lsVarVy = naVar.vy();
            if (lsVarVy != null && !TextUtils.isEmpty(lsVarVy.g())) {
                wp.a("TTDownload-Util", "含有deepLink");
                if (tb.a(naVar) != 0) {
                    wp.a("TTDownload-Util", "deepLink过滤 DownConfig.getDownConfigAutoOpen(materialMeta) " + tb.a(naVar));
                    return;
                }
            }
            if (zE) {
                if (com.bytedance.sdk.openadsdk.pf.g.z(str)) {
                    wp.a("TTDownload-Util", "该app已被激活 pkgName ".concat(String.valueOf(str)));
                } else if (!tb.gz(naVar)) {
                    g(naVar, str);
                } else {
                    z(zw.getContext(), naVar, str);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static String z() {
        String strA = com.bytedance.sdk.openadsdk.pf.g.a();
        com.bytedance.sdk.openadsdk.ls.dl.dl.a aVarP = uy.ls().p();
        if (aVarP == null || aVarP.gc()) {
            return strA;
        }
        try {
            return m();
        } catch (Throwable unused) {
            return strA;
        }
    }

    private static String m() {
        File fileZ = com.bytedance.sdk.openadsdk.api.plugin.g.z(zw.getContext(), Environment.DIRECTORY_DOWNLOADS);
        if (fileZ == null) {
            return null;
        }
        if (!fileZ.exists()) {
            fileZ.mkdirs();
        }
        if (fileZ.exists()) {
            return fileZ.getAbsolutePath();
        }
        return null;
    }

    private static void g(final na naVar, final String str) {
        final com.bytedance.sdk.openadsdk.core.un.z zVarA;
        if (z(naVar) || (zVarA = uy.ls().a()) == null) {
            return;
        }
        final long jCurrentTimeMillis = System.currentTimeMillis();
        zVarA.z(new z.InterfaceC0206z() { // from class: com.bytedance.sdk.openadsdk.core.kb.fo.1
            @Override // com.bytedance.sdk.openadsdk.core.un.z.InterfaceC0206z
            public void z() {
                if (!oq.z()) {
                    com.bytedance.sdk.openadsdk.core.un.z zVar = zVarA;
                    if (zVar != null) {
                        zVar.dl();
                        return;
                    }
                    return;
                }
                if (!com.bytedance.sdk.openadsdk.pf.g.z(str)) {
                    fo.g(naVar, jCurrentTimeMillis, zVarA, str);
                }
                com.bytedance.sdk.openadsdk.core.un.z zVar2 = zVarA;
                if (zVar2 != null) {
                    zVar2.dl();
                }
            }
        });
    }

    private static void z(Context context, final na naVar, final String str) {
        if (context == null || naVar == null || z(naVar)) {
            return;
        }
        final String strDl = naVar.c() != null ? naVar.c().dl() : "";
        final String str2 = TextUtils.isEmpty(strDl) ? "应用安装完成，是否立即打开 ？" : "安装完成，是否立即打开 ？";
        final com.bytedance.sdk.openadsdk.core.un.z zVarA = uy.ls().a();
        if (zVarA == null) {
            return;
        }
        zVarA.z(new z.InterfaceC0206z() { // from class: com.bytedance.sdk.openadsdk.core.kb.fo.2
            @Override // com.bytedance.sdk.openadsdk.core.un.z.InterfaceC0206z
            public void z() {
                try {
                    if (!oq.z()) {
                        com.bytedance.sdk.openadsdk.core.un.z zVar = zVarA;
                        if (zVar != null) {
                            zVar.dl();
                            return;
                        }
                        return;
                    }
                    if (!com.bytedance.sdk.openadsdk.pf.g.z(str)) {
                        fo.g(zVarA, naVar, strDl, str2, str);
                    }
                    com.bytedance.sdk.openadsdk.core.un.z zVar2 = zVarA;
                    if (zVar2 != null) {
                        zVar2.dl();
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    private static boolean z(na naVar) {
        if (naVar == null || !z(g())) {
            return false;
        }
        int iLt = naVar.lt();
        String strPo = naVar.po();
        com.bytedance.sdk.component.a.g.dl dlVarZ = com.bytedance.sdk.openadsdk.core.g.z();
        if ((TextUtils.isEmpty(strPo) || iLt != 4) && !dlVarZ.get("is_landing_page_open_market", false)) {
            return false;
        }
        dlVarZ.put("is_landing_page_open_market", false);
        return true;
    }

    public static JSONObject g() {
        com.bytedance.sdk.openadsdk.core.gk.uy uyVarG = zw.g();
        if (uyVarG != null && uyVarG.yx() != null) {
            return uyVarG.yx();
        }
        return new JSONObject();
    }

    private static boolean z(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        return jSONObject.optInt("enable_open_app_dialog") == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(final com.bytedance.sdk.openadsdk.core.un.z zVar, final na naVar, String str, String str2, final String str3) {
        if (zVar != null && eo.dl(zw.getContext(), str3)) {
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            String strMj = naVar.mj();
            com.bytedance.sdk.openadsdk.core.un.m.z(zw.getContext(), strMj, str, str2, "立即打开", "退出", new m.z() { // from class: com.bytedance.sdk.openadsdk.core.kb.fo.3
                @Override // com.bytedance.sdk.openadsdk.core.un.m.z
                public void onDialogBtnYes() {
                    fo.dl(naVar, str3);
                    com.bytedance.sdk.openadsdk.core.un.z zVar2 = zVar;
                    if (zVar2 != null) {
                        zVar2.dl();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.un.m.z
                public void onDialogBtnNo() {
                    com.bytedance.sdk.openadsdk.core.un.z zVar2 = zVar;
                    if (zVar2 != null) {
                        zVar2.dl();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.un.m.z
                public void onDialogCancel() {
                    com.bytedance.sdk.openadsdk.core.un.z zVar2 = zVar;
                    if (zVar2 != null) {
                        zVar2.dl();
                    }
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String z(boolean r3) {
        /*
            r0 = 0
            if (r3 == 0) goto L20
            boolean r3 = dl()     // Catch: java.lang.Throwable -> L69
            if (r3 != 0) goto L20
            java.io.File r3 = new java.io.File     // Catch: java.lang.Throwable -> L69
            android.content.Context r1 = com.bytedance.sdk.openadsdk.core.zw.getContext()     // Catch: java.lang.Throwable -> L69
            java.io.File r1 = com.bytedance.sdk.openadsdk.api.plugin.g.g(r1)     // Catch: java.lang.Throwable -> L69
            java.lang.String r2 = android.os.Environment.DIRECTORY_DOWNLOADS     // Catch: java.lang.Throwable -> L69
            r3.<init>(r1, r2)     // Catch: java.lang.Throwable -> L69
            r3.mkdirs()     // Catch: java.lang.Throwable -> L69
            java.lang.String r3 = r3.getPath()     // Catch: java.lang.Throwable -> L69
            goto L21
        L20:
            r3 = r0
        L21:
            boolean r1 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L69
            if (r1 == 0) goto L5f
            java.lang.String r1 = com.bytedance.sdk.openadsdk.hh.dl.z()     // Catch: java.lang.Throwable -> L69
            java.lang.String r2 = "mounted"
            boolean r1 = r2.equals(r1)     // Catch: java.lang.Throwable -> L69
            if (r1 == 0) goto L43
            android.content.Context r1 = com.bytedance.sdk.openadsdk.core.zw.getContext()     // Catch: java.lang.Throwable -> L69
            java.lang.String r2 = android.os.Environment.DIRECTORY_DOWNLOADS     // Catch: java.lang.Throwable -> L69
            java.io.File r1 = com.bytedance.sdk.openadsdk.api.plugin.g.z(r1, r2)     // Catch: java.lang.Throwable -> L69
            if (r1 == 0) goto L43
            java.lang.String r3 = r1.getPath()     // Catch: java.lang.Throwable -> L69
        L43:
            boolean r1 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L69
            if (r1 == 0) goto L5f
            android.content.Context r3 = com.bytedance.sdk.openadsdk.core.zw.getContext()     // Catch: java.lang.Throwable -> L69
            java.io.File r3 = com.bytedance.sdk.openadsdk.api.plugin.g.z(r3)     // Catch: java.lang.Throwable -> L69
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L69
            java.lang.String r2 = android.os.Environment.DIRECTORY_DOWNLOADS     // Catch: java.lang.Throwable -> L69
            r1.<init>(r3, r2)     // Catch: java.lang.Throwable -> L69
            r1.mkdirs()     // Catch: java.lang.Throwable -> L69
            java.lang.String r3 = r1.getPath()     // Catch: java.lang.Throwable -> L69
        L5f:
            boolean r1 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L69
            if (r1 != 0) goto L69
            com.bytedance.sdk.openadsdk.core.un.wp.z()     // Catch: java.lang.Throwable -> L69
            r0 = r3
        L69:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.kb.fo.z(boolean):java.lang.String");
    }

    public static boolean dl() {
        return com.bytedance.sdk.openadsdk.core.uf.gc.z().z(zw.getContext(), com.kuaishou.weapon.p0.g.j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void dl(na naVar, String str) {
        if (naVar == null) {
            return;
        }
        eo.z(zw.getContext(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(na naVar, long j, com.bytedance.sdk.openadsdk.core.un.z zVar, String str) {
        if (naVar == null) {
            return;
        }
        if (System.currentTimeMillis() - j >= ((long) tb.fo(naVar)) * 1000) {
            String strDl = naVar.c() != null ? naVar.c().dl() : "";
            g(zVar, naVar, strDl, TextUtils.isEmpty(strDl) ? "应用安装完成，是否立即打开 ？" : "安装完成，是否立即打开 ？", str);
        } else {
            dl(naVar, str);
        }
    }

    public static void z(Runnable runnable, na naVar) {
        if (naVar == null || runnable == null) {
            return;
        }
        if (tb.p(naVar)) {
            com.bytedance.sdk.openadsdk.hh.e.z((Runnable) new com.bytedance.sdk.component.uy.fo("tt_download_toast") { // from class: com.bytedance.sdk.openadsdk.core.kb.fo.4
                @Override // java.lang.Runnable
                public void run() {
                    hh.z(zw.getContext(), "即将跳转到应用商店...", 1);
                }
            });
            q.m().postDelayed(runnable, 500L);
        } else {
            com.bytedance.sdk.openadsdk.hh.e.z(runnable);
        }
    }

    public static String a() {
        try {
            Function<SparseArray<Object>, Object> functionOq = uy.ls().oq();
            if (functionOq == null) {
                return bq.e;
            }
            functionOq.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(1).z(String.class).g());
            return bq.e;
        } catch (Exception unused) {
            return bq.e;
        }
    }

    public static void gc() {
        if (uy.ls().oq() != null) {
            uy.ls().oq().apply(com.bytedance.sdk.openadsdk.ls.a.z().z(20).z(Void.class).g());
        } else {
            wp.a("TTDownload-Util", "下载SDK 初始化失败 ， bridge = null ！！！");
        }
    }
}
