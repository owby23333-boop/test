package com.ss.android.downloadlib;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.wp;
import com.ss.android.downloadlib.e.i;
import com.ss.android.downloadlib.e.kb;
import com.ss.android.downloadlib.gc.g;
import com.ss.android.g.z.z.g;
import com.ss.android.g.z.z.z;
import com.ss.android.z.z.g.p;
import com.ss.android.z.z.gc.dl;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class g implements com.ss.android.g.z.g {
    private static volatile g g = null;
    private static String z = "g";
    private uy dl = uy.z(wp.getContext());

    private g() {
    }

    public static g z() {
        if (g == null) {
            synchronized (g.class) {
                if (g == null) {
                    g = new g();
                }
            }
        }
        return g;
    }

    @Override // com.ss.android.g.z.g
    public Dialog z(Context context, String str, boolean z2, com.ss.android.z.z.dl.dl dlVar, com.ss.android.z.z.dl.g gVar, com.ss.android.z.z.dl.z zVar, com.ss.android.z.z.dl.a aVar, int i) {
        return z(context, str, z2, dlVar, gVar, zVar, aVar, i, false);
    }

    @Override // com.ss.android.g.z.g
    public Dialog z(Context context, String str, boolean z2, com.ss.android.z.z.dl.dl dlVar, com.ss.android.z.z.dl.g gVar, com.ss.android.z.z.dl.z zVar, com.ss.android.z.z.dl.a aVar, int i, p pVar) {
        return z(context, str, z2, dlVar, gVar, zVar, aVar, i, false, pVar);
    }

    public Dialog z(Context context, String str, boolean z2, com.ss.android.z.z.dl.dl dlVar, com.ss.android.z.z.dl.g gVar, com.ss.android.z.z.dl.z zVar, com.ss.android.z.z.dl.a aVar, int i, boolean z3) {
        return z(context, str, z2, dlVar, gVar, zVar, aVar, i, z3, null);
    }

    public Dialog z(final Context context, final String str, final boolean z2, final com.ss.android.z.z.dl.dl dlVar, final com.ss.android.z.z.dl.g gVar, final com.ss.android.z.z.dl.z zVar, final com.ss.android.z.z.dl.a aVar, final int i, final boolean z3, final p pVar) {
        return (Dialog) com.ss.android.downloadlib.gc.g.z(new g.z<Dialog>() { // from class: com.ss.android.downloadlib.g.1
            @Override // com.ss.android.downloadlib.gc.g.z
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public Dialog g() {
                return g.this.g(context, str, z2, dlVar, gVar, zVar, aVar, i, z3, pVar);
            }
        });
    }

    public Dialog g(Context context, String str, boolean z2, final com.ss.android.z.z.dl.dl dlVar, com.ss.android.z.z.dl.g gVar, com.ss.android.z.z.dl.z zVar, com.ss.android.z.z.dl.a aVar, int i, boolean z3, p pVar) {
        if (z(dlVar.a())) {
            if (z3) {
                z(dlVar.a(), gVar, zVar);
            } else {
                g(dlVar.a());
            }
            return null;
        }
        if (context == null || TextUtils.isEmpty(dlVar.z())) {
            return null;
        }
        this.dl.z(context, i, aVar, dlVar);
        final com.ss.android.z.z.dl.g gVar2 = (com.ss.android.z.z.dl.g) i.z(gVar, dl());
        final com.ss.android.z.z.dl.z zVar2 = (com.ss.android.z.z.dl.z) i.z(zVar, g());
        gVar2.z(1);
        if ((zVar2.wp() && com.ss.android.downloadlib.addownload.compliance.g.z().z(dlVar)) ? true : (wp.fo().optInt("disable_lp_dialog", 0) == 1) | z2) {
            this.dl.z(dlVar.z(), dlVar.a(), 2, gVar2, zVar2, pVar);
            return null;
        }
        kb.z(z, "tryStartDownload show dialog appName:" + dlVar.z(), null);
        Dialog dialogG = wp.dl().g(new dl.z(context).z(dlVar.gz()).g("确认要下载此应用吗？").dl("确认").a("取消").z(new dl.g() { // from class: com.ss.android.downloadlib.g.2
            @Override // com.ss.android.z.z.gc.dl.g
            public void z(DialogInterface dialogInterface) {
                g.this.dl.z(dlVar.z(), dlVar.a(), 2, gVar2, zVar2);
                com.ss.android.downloadlib.a.z.z().z("landing_download_dialog_confirm", dlVar, gVar2, zVar2);
                dialogInterface.dismiss();
            }

            @Override // com.ss.android.z.z.gc.dl.g
            public void g(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.a.z.z().z("landing_download_dialog_cancel", dlVar, gVar2, zVar2);
                dialogInterface.dismiss();
            }

            @Override // com.ss.android.z.z.gc.dl.g
            public void dl(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.a.z.z().z("landing_download_dialog_cancel", dlVar, gVar2, zVar2);
            }
        }).z(0).z());
        com.ss.android.downloadlib.a.z.z().z("landing_download_dialog_show", dlVar, gVar2, zVar2);
        return dialogG;
    }

    @Override // com.ss.android.g.z.g
    public boolean z(Context context, long j, String str, com.ss.android.z.z.dl.a aVar, int i) {
        com.ss.android.g.z.g.g gVarA = com.ss.android.downloadlib.addownload.g.m.z().a(j);
        if (gVarA != null) {
            this.dl.z(context, i, aVar, gVarA.r());
            return true;
        }
        com.ss.android.z.z.dl.dl dlVarZ = com.ss.android.downloadlib.addownload.g.m.z().z(j);
        if (dlVarZ == null) {
            return false;
        }
        this.dl.z(context, i, aVar, dlVarZ);
        return true;
    }

    @Override // com.ss.android.g.z.g
    public boolean z(long j, int i) {
        com.ss.android.z.z.dl.dl dlVarZ = com.ss.android.downloadlib.addownload.g.m.z().z(j);
        if (dlVarZ == null) {
            return false;
        }
        this.dl.z(dlVarZ.z(), i);
        return true;
    }

    public void z(long j, com.ss.android.z.z.dl.g gVar, com.ss.android.z.z.dl.z zVar) {
        com.ss.android.z.z.dl.dl dlVarZ = com.ss.android.downloadlib.addownload.g.m.z().z(j);
        com.ss.android.g.z.g.g gVarA = com.ss.android.downloadlib.addownload.g.m.z().a(j);
        if (dlVarZ == null && gVarA != null) {
            dlVarZ = gVarA.r();
        }
        if (dlVarZ == null) {
            return;
        }
        if (gVar == null || zVar == null || (gVar instanceof com.ss.android.z.z.dl.e) || (zVar instanceof com.ss.android.z.z.dl.m)) {
            g(j);
        } else {
            gVar.z(1);
            this.dl.z(dlVarZ.z(), j, 2, gVar, zVar);
        }
    }

    public void g(long j) {
        com.ss.android.z.z.dl.dl dlVarZ = com.ss.android.downloadlib.addownload.g.m.z().z(j);
        com.ss.android.g.z.g.g gVarA = com.ss.android.downloadlib.addownload.g.m.z().a(j);
        if (dlVarZ == null && gVarA != null) {
            dlVarZ = gVarA.r();
        }
        if (dlVarZ == null) {
            return;
        }
        com.ss.android.z.z.dl.g gVarG = com.ss.android.downloadlib.addownload.g.m.z().g(j);
        com.ss.android.z.z.dl.z zVarDl = com.ss.android.downloadlib.addownload.g.m.z().dl(j);
        if (gVarG instanceof com.ss.android.z.z.dl.e) {
            gVarG = null;
        }
        if (zVarDl instanceof com.ss.android.z.z.dl.m) {
            zVarDl = null;
        }
        if (gVarA == null) {
            if (gVarG == null) {
                gVarG = dl();
            }
            if (zVarDl == null) {
                zVarDl = g();
            }
        } else {
            if (gVarG == null) {
                gVarG = new g.z().z(gVarA.uy()).uy(gVarA.fo()).dl(gVarA.i()).z(false).a("click_start_detail").gc("click_pause_detail").m("click_continue_detail").e("click_install_detail").fo("storage_deny_detail").z();
            }
            if (zVarDl == null) {
                zVarDl = gVarA.bm();
            }
        }
        com.ss.android.z.z.dl.g gVar = gVarG;
        gVar.z(1);
        this.dl.z(dlVarZ.z(), j, 2, gVar, zVarDl);
    }

    @Override // com.ss.android.g.z.g
    public boolean z(long j) {
        return (com.ss.android.downloadlib.addownload.g.m.z().z(j) == null && com.ss.android.downloadlib.addownload.g.m.z().a(j) == null) ? false : true;
    }

    @Override // com.ss.android.g.z.g
    public boolean z(Context context, Uri uri, com.ss.android.z.z.dl.dl dlVar, com.ss.android.z.z.dl.g gVar, com.ss.android.z.z.dl.z zVar) {
        return z(context, uri, dlVar, gVar, zVar, null);
    }

    @Override // com.ss.android.g.z.g
    public boolean z(final Context context, final Uri uri, final com.ss.android.z.z.dl.dl dlVar, final com.ss.android.z.z.dl.g gVar, final com.ss.android.z.z.dl.z zVar, final p pVar) {
        return ((Boolean) com.ss.android.downloadlib.gc.g.z(new g.z<Boolean>() { // from class: com.ss.android.downloadlib.g.3
            @Override // com.ss.android.downloadlib.gc.g.z
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public Boolean g() {
                return Boolean.valueOf(g.this.g(context, uri, dlVar, gVar, zVar, pVar));
            }
        })).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(Context context, Uri uri, com.ss.android.z.z.dl.dl dlVar, com.ss.android.z.z.dl.g gVar, com.ss.android.z.z.dl.z zVar, p pVar) {
        com.ss.android.z.z.dl.z zVarG = zVar;
        if (!com.ss.android.z.z.m.z.z(uri) || wp.fo().optInt("disable_market") == 1) {
            return false;
        }
        Context context2 = context == null ? wp.getContext() : context;
        String strG = com.ss.android.z.z.m.z.g(uri);
        if (dlVar == null) {
            return com.ss.android.downloadlib.e.fo.z(context2, strG).getType() == 5;
        }
        if (!TextUtils.isEmpty(strG) && (dlVar instanceof com.ss.android.g.z.z.dl)) {
            ((com.ss.android.g.z.z.dl) dlVar).gz(strG);
        }
        if (zVarG != null) {
            zVarG.z(2);
        } else if ((dlVar instanceof com.ss.android.g.z.z.dl) && TextUtils.isEmpty(dlVar.z())) {
            ((com.ss.android.g.z.z.dl) dlVar).uy(uri.toString());
            zVarG = z(true);
        } else if (dlVar.z().startsWith("market")) {
            zVarG = z(true);
        } else {
            zVarG = g();
        }
        com.ss.android.downloadlib.addownload.g.gc gcVar = new com.ss.android.downloadlib.addownload.g.gc(dlVar.a(), dlVar, (com.ss.android.z.z.dl.g) i.z(gVar, dl()), zVarG);
        com.ss.android.downloadlib.addownload.g.m.z().z(gcVar.g);
        com.ss.android.downloadlib.addownload.g.m.z().z(gcVar.z, gcVar.dl);
        com.ss.android.downloadlib.addownload.g.m.z().z(gcVar.z, gcVar.f1987a);
        if (i.z(dlVar) && com.ss.android.socialbase.downloader.i.z.dl().g("app_link_opt") == 1 && com.ss.android.downloadlib.g.z.z(gcVar)) {
            return true;
        }
        JSONObject jSONObject = new JSONObject();
        i.z(jSONObject, "market_url", uri.toString());
        i.z(jSONObject, "download_scene", (Object) 1);
        com.ss.android.downloadlib.a.z.z().g("market_click_open", jSONObject, gcVar);
        com.ss.android.downloadlib.addownload.g.e eVarZ = com.ss.android.downloadlib.e.fo.z(context2, gcVar, strG);
        String strZ = i.z(eVarZ.g(), "open_market");
        if (eVarZ.getType() == 5) {
            com.ss.android.downloadlib.g.z.z(strZ, jSONObject, gcVar, true);
            return true;
        }
        if (eVarZ.getType() != 6) {
            return true;
        }
        i.z(jSONObject, "error_code", Integer.valueOf(eVarZ.z()));
        com.ss.android.downloadlib.a.z.z().g("market_open_failed", jSONObject, gcVar);
        if (com.ss.android.downloadlib.addownload.fo.z(dlVar, pVar)) {
            pVar.z();
        }
        return false;
    }

    public static com.ss.android.z.z.dl.z g() {
        return z(false);
    }

    public static com.ss.android.z.z.dl.z z(boolean z2) {
        z.C0450z c0450zA = new z.C0450z().z(0).z(true).dl(false).a(false);
        if (z2) {
            c0450zA.g(2);
        } else {
            c0450zA.g(0);
        }
        return c0450zA.z();
    }

    public static com.ss.android.z.z.dl.g dl() {
        return new g.z().z("landing_h5_download_ad_button").g("landing_h5_download_ad_button").a("click_start_detail").gc("click_pause_detail").m("click_continue_detail").e("click_install_detail").gz("click_open_detail").fo("storage_deny_detail").z(1).z(false).g(true).dl(false).z();
    }
}
