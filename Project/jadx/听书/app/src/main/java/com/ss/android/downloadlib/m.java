package com.ss.android.downloadlib;

import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.wp;
import com.ss.android.socialbase.appdownloader.DownloadHandlerService;
import com.ss.android.socialbase.downloader.a.un;
import com.ss.android.socialbase.downloader.z.z;
import com.ss.android.z.z.g.io;
import com.ss.android.z.z.g.kb;
import com.ss.android.z.z.g.tb;
import com.ss.android.z.z.g.v;

/* JADX INFO: loaded from: classes4.dex */
class m implements com.ss.android.z.z.z {
    m() {
    }

    @Override // com.ss.android.z.z.z
    public com.ss.android.z.z.z z(com.ss.android.z.z.g.uy uyVar) {
        wp.z(uyVar);
        return this;
    }

    @Override // com.ss.android.z.z.z
    public com.ss.android.z.z.z z(com.ss.android.z.z.g.e eVar) {
        wp.z(eVar);
        return this;
    }

    @Override // com.ss.android.z.z.z
    public com.ss.android.z.z.z z(v vVar) {
        wp.z(vVar);
        return this;
    }

    @Override // com.ss.android.z.z.z
    public com.ss.android.z.z.z z(com.ss.android.z.z.g.fo foVar) {
        wp.z(foVar);
        return this;
    }

    @Override // com.ss.android.z.z.z
    public com.ss.android.z.z.z z(com.ss.android.z.z.g.wp wpVar) {
        wp.z(wpVar);
        return this;
    }

    @Override // com.ss.android.z.z.z
    public com.ss.android.z.z.z z(com.ss.android.z.z.gc.z zVar) {
        wp.z(zVar);
        return this;
    }

    @Override // com.ss.android.z.z.z
    public com.ss.android.z.z.z z(String str) {
        wp.z(str);
        return this;
    }

    @Override // com.ss.android.z.z.z
    public com.ss.android.z.z.z z(com.ss.android.socialbase.appdownloader.dl.dl dlVar) {
        wp.z(dlVar);
        return this;
    }

    @Override // com.ss.android.z.z.z
    public com.ss.android.z.z.z z(final com.ss.android.z.z.g.g gVar) {
        wp.z(gVar);
        com.ss.android.socialbase.downloader.z.z.z().z(new z.dl() { // from class: com.ss.android.downloadlib.m.1
        });
        return this;
    }

    @Override // com.ss.android.z.z.z
    public com.ss.android.z.z.z z(com.ss.android.socialbase.downloader.downloader.gz gzVar) {
        if (gzVar.io() == null) {
            gzVar.z(new un() { // from class: com.ss.android.downloadlib.m.2
                @Override // com.ss.android.socialbase.downloader.a.un
                public boolean g(com.ss.android.socialbase.downloader.e.dl dlVar) {
                    return false;
                }

                @Override // com.ss.android.socialbase.downloader.a.un
                public boolean z(com.ss.android.socialbase.downloader.e.dl dlVar) {
                    com.ss.android.socialbase.downloader.i.z zVarZ = com.ss.android.socialbase.downloader.i.z.z(dlVar.e());
                    if (zVarZ.g("notification_opt_2") == 1) {
                        if (dlVar.p() == -2) {
                            DownloadHandlerService.z(wp.getContext(), dlVar, com.ss.android.socialbase.appdownloader.a.kb().dl(), com.ss.android.socialbase.downloader.downloader.e.g(wp.getContext()).fo(dlVar.e()));
                        }
                        return true;
                    }
                    boolean zA = a(dlVar);
                    if (zVarZ.z("disable_delete_dialog", 0) == 1) {
                        return true;
                    }
                    return zA;
                }

                private boolean a(com.ss.android.socialbase.downloader.e.dl dlVar) {
                    String strZ;
                    io ioVarJs = wp.js();
                    if (ioVarJs == null) {
                        return false;
                    }
                    com.ss.android.g.z.g.g gVarZ = com.ss.android.downloadlib.addownload.g.m.z().z(dlVar);
                    if (gVarZ != null && gVarZ.dl()) {
                        strZ = com.ss.android.socialbase.downloader.i.z.z(dlVar.e()).z("ad_notification_jump_url", (String) null);
                    } else {
                        strZ = com.ss.android.downloadlib.addownload.fo.z(dlVar);
                    }
                    if (TextUtils.isEmpty(strZ)) {
                        return false;
                    }
                    return ioVarJs.z(wp.getContext(), strZ);
                }

                @Override // com.ss.android.socialbase.downloader.a.un
                public boolean dl(com.ss.android.socialbase.downloader.e.dl dlVar) {
                    if (dlVar == null) {
                        return false;
                    }
                    com.ss.android.g.z.g.g gVarZ = com.ss.android.downloadlib.addownload.g.m.z().z(dlVar);
                    if (gVarZ != null) {
                        com.ss.android.downloadlib.g.z.z(gVarZ);
                    } else {
                        com.ss.android.downloadlib.e.fo.g(wp.getContext(), dlVar.x());
                    }
                    com.ss.android.socialbase.downloader.notification.g.z().m(dlVar.e());
                    return true;
                }
            });
        }
        gzVar.z(new com.ss.android.downloadlib.dl.dl());
        com.ss.android.socialbase.downloader.downloader.e.z(gzVar, true);
        return this;
    }

    @Override // com.ss.android.z.z.z
    public com.ss.android.z.z.z z(com.ss.android.socialbase.appdownloader.dl.e eVar) {
        com.ss.android.socialbase.appdownloader.a.kb().z(eVar);
        return this;
    }

    @Override // com.ss.android.z.z.z
    public com.ss.android.z.z.z z(tb tbVar) {
        wp.z(tbVar);
        return this;
    }

    @Override // com.ss.android.z.z.z
    public com.ss.android.z.z.z z(kb kbVar) {
        wp.z(kbVar);
        return this;
    }

    @Override // com.ss.android.z.z.z
    public void z() {
        if (!wp.io()) {
            com.ss.android.downloadlib.gc.dl.z().z("ttdownloader init error");
        }
        wp.z(com.ss.android.downloadlib.gc.dl.z());
        try {
            com.ss.android.socialbase.appdownloader.a.kb().g(wp.zw());
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        com.ss.android.socialbase.appdownloader.a.kb().z(z.z());
        gc.z().g(new Runnable() { // from class: com.ss.android.downloadlib.m.3
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.appdownloader.m.gc.z("");
                if (com.ss.android.socialbase.appdownloader.m.gc.pf()) {
                    com.ss.android.socialbase.downloader.downloader.dl.z(true);
                }
                if (com.ss.android.socialbase.downloader.i.z.dl().z("disable_security_init", 1) == 1) {
                    com.ss.android.socialbase.appdownloader.m.m.z(wp.getContext());
                }
            }
        });
    }
}
