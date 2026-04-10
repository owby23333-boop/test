package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.gz;
import com.ss.android.downloadlib.e.v;
import com.ss.android.socialbase.appdownloader.DownloadHandlerService;
import com.ss.android.socialbase.downloader.a.hh;
import com.ss.android.socialbase.downloader.e.dl;
import com.ss.android.z.z.dl.e;
import com.ss.android.z.z.g.p;
import com.ss.android.z.z.g.uf;
import com.ss.android.z.z.g.zw;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class gc implements e, v.z {
    private static final String z = "gc";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f1990a;
    private gz dl;
    private com.ss.android.z.z.gc.gc e;
    private dl fo;
    private SoftReference<uf> fv;
    private final com.ss.android.downloadlib.e.v g;
    private WeakReference<Context> gc;
    private com.ss.android.socialbase.downloader.e.dl gz;
    private String i;
    private boolean js;
    private boolean kb;
    private com.ss.android.z.z.dl.g ls;
    private final Map<Integer, Object> m;
    private com.ss.android.z.z.dl.z p;
    private com.ss.android.z.z.dl.dl pf;
    private SoftReference<p> q;
    private final boolean tb;
    private final hh uy;
    private long v;
    private long wp;

    interface g {
        void z(long j);
    }

    interface z {
        void z();
    }

    public gc() {
        com.ss.android.downloadlib.e.v vVar = new com.ss.android.downloadlib.e.v(Looper.getMainLooper(), this);
        this.g = vVar;
        this.m = new ConcurrentHashMap();
        this.uy = new gz.z(vVar);
        this.v = -1L;
        this.pf = null;
        this.ls = null;
        this.p = null;
        this.dl = new gz(this);
        this.f1990a = new a(vVar);
        this.tb = com.ss.android.socialbase.downloader.i.z.dl().z("ttdownloader_callback_twice");
    }

    @Override // com.ss.android.downloadlib.addownload.e
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public gc g(Context context) {
        if (context != null) {
            this.gc = new WeakReference<>(context);
        }
        wp.g(context);
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.e
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public gc g(int i, com.ss.android.z.z.dl.a aVar) {
        if (aVar != null) {
            if (wp.fo().optInt("back_use_softref_listener") == 1) {
                this.m.put(Integer.valueOf(i), aVar);
            } else if (wp.fo().optInt("use_weakref_listener") == 1) {
                this.m.put(Integer.valueOf(i), new WeakReference(aVar));
            } else {
                this.m.put(Integer.valueOf(i), new SoftReference(aVar));
            }
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.e
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public gc g(com.ss.android.z.z.dl.dl dlVar) {
        if (dlVar != null) {
            if (dlVar.io()) {
                if (dlVar.a() <= 0 || TextUtils.isEmpty(dlVar.uf())) {
                    com.ss.android.downloadlib.gc.dl.z().z("setDownloadModel ad error");
                }
            } else if (dlVar.a() == 0 && (dlVar instanceof com.ss.android.g.z.z.dl)) {
                com.ss.android.downloadlib.gc.dl.z().z(false, "setDownloadModel id=0");
                if (com.ss.android.socialbase.downloader.i.z.dl().z("fix_model_id")) {
                    ((com.ss.android.g.z.z.dl) dlVar).dl(dlVar.z().hashCode());
                }
            }
            com.ss.android.downloadlib.addownload.g.m.z().z(dlVar);
            this.v = dlVar.a();
            this.pf = dlVar;
            if (fo.z(dlVar)) {
                ((com.ss.android.g.z.z.dl) dlVar).g(3L);
                com.ss.android.g.z.g.g gVarA = com.ss.android.downloadlib.addownload.g.m.z().a(this.v);
                if (gVarA != null && gVarA.wp() != 3) {
                    gVarA.gc(3L);
                    com.ss.android.downloadlib.addownload.g.fo.z().z(gVarA);
                }
            }
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.e
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public gc g(com.ss.android.z.z.dl.z zVar) {
        JSONObject jSONObjectGk;
        this.p = zVar;
        if (com.ss.android.downloadlib.e.gc.g(this.pf).g("force_auto_open") == 1) {
            i().g(1);
        }
        if (com.ss.android.socialbase.downloader.i.z.dl().z("fix_show_dialog") && (jSONObjectGk = this.pf.gk()) != null && jSONObjectGk.optInt("subprocess") > 0) {
            i().g(false);
        }
        com.ss.android.downloadlib.addownload.g.m.z().z(this.v, i());
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.e
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public gc g(com.ss.android.z.z.dl.g gVar) {
        this.ls = gVar;
        this.js = wp().kb() == 0;
        com.ss.android.downloadlib.addownload.g.m.z().z(this.v, wp());
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.e
    public e z(uf ufVar) {
        if (ufVar == null) {
            this.fv = null;
        } else {
            this.fv = new SoftReference<>(ufVar);
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.e
    public void z() {
        this.kb = true;
        com.ss.android.downloadlib.addownload.g.m.z().z(this.v, wp());
        com.ss.android.downloadlib.addownload.g.m.z().z(this.v, i());
        this.dl.z(this.v);
        ls();
        if (wp.fo().optInt("enable_empty_listener", 1) == 1 && this.m.get(Integer.MIN_VALUE) == null) {
            g(Integer.MIN_VALUE, new com.ss.android.z.z.g.z());
        }
    }

    @Override // com.ss.android.downloadlib.addownload.e
    public boolean z(int i) {
        if (i == 0) {
            this.m.clear();
        } else {
            this.m.remove(Integer.valueOf(i));
        }
        if (this.m.isEmpty()) {
            this.kb = false;
            this.wp = System.currentTimeMillis();
            if (this.gz != null) {
                com.ss.android.socialbase.downloader.downloader.e.g(wp.getContext()).kb(this.gz.e());
            }
            dl dlVar = this.fo;
            if (dlVar != null && dlVar.getStatus() != AsyncTask.Status.FINISHED) {
                this.fo.cancel(true);
            }
            this.dl.z(this.gz);
            String str = z;
            StringBuilder sb = new StringBuilder("onUnbind removeCallbacksAndMessages, downloadUrl:");
            com.ss.android.socialbase.downloader.e.dl dlVar2 = this.gz;
            com.ss.android.downloadlib.e.kb.z(str, sb.append(dlVar2 == null ? "" : dlVar2.uy()).toString(), null);
            this.g.removeCallbacksAndMessages(null);
            this.e = null;
            this.gz = null;
            return true;
        }
        if (this.m.size() == 1 && this.m.containsKey(Integer.MIN_VALUE)) {
            this.dl.g(this.gz);
        }
        return false;
    }

    @Override // com.ss.android.downloadlib.addownload.e
    public void z(boolean z2) {
        if (this.gz != null) {
            if (z2) {
                com.ss.android.socialbase.appdownloader.dl.gc gcVarDl = com.ss.android.socialbase.appdownloader.a.kb().dl();
                if (gcVarDl != null) {
                    gcVarDl.z(this.gz);
                }
                com.ss.android.socialbase.downloader.downloader.e.g(com.ss.android.socialbase.downloader.downloader.dl.xl()).z(this.gz.e(), true);
                return;
            }
            Intent intent = new Intent(wp.getContext(), (Class<?>) DownloadHandlerService.class);
            intent.setAction("android.ss.intent.action.DOWNLOAD_DELETE");
            intent.putExtra("extra_click_download_ids", this.gz.e());
            wp.getContext().startService(intent);
        }
    }

    @Override // com.ss.android.downloadlib.addownload.e
    public boolean g() {
        return this.kb;
    }

    public boolean dl() {
        com.ss.android.socialbase.downloader.e.dl dlVar = this.gz;
        return (dlVar == null || dlVar.p() == 0) ? false : true;
    }

    @Override // com.ss.android.downloadlib.addownload.e
    public long a() {
        return this.wp;
    }

    @Override // com.ss.android.downloadlib.addownload.e
    public e z(long j) {
        if (j != 0) {
            com.ss.android.z.z.dl.dl dlVarZ = com.ss.android.downloadlib.addownload.g.m.z().z(j);
            if (dlVarZ != null) {
                this.pf = dlVarZ;
                this.v = j;
                this.dl.z(j);
            }
        } else {
            com.ss.android.downloadlib.gc.dl.z().z(false, "setModelId");
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.e
    public void g(final int i) {
        if (i != 1 && i != 2) {
            throw new IllegalArgumentException("error actionType");
        }
        this.dl.z(this.v);
        if (!com.ss.android.downloadlib.addownload.g.m.z().gc(this.v).uf()) {
            com.ss.android.downloadlib.gc.dl.z().z("handleDownload ModelBox !isStrictValid");
        }
        if (this.dl.z(i, this.pf)) {
            com.ss.android.downloadlib.addownload.compliance.m.z().z(this.dl.z, new com.ss.android.downloadlib.addownload.compliance.gz() { // from class: com.ss.android.downloadlib.addownload.gc.1
                @Override // com.ss.android.downloadlib.addownload.compliance.gz
                public void z(String str) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt("download_miui_new_market", 1);
                        jSONObject.putOpt("download_miui_market_deeplink", str);
                        if (!com.ss.android.downloadlib.e.gz.z(gc.this.getContext(), gc.this.dl.z, str, jSONObject, true, i)) {
                            jSONObject.putOpt("download_miui_jump_market_success", 0);
                            com.ss.android.downloadlib.addownload.compliance.m.z().z(1, gc.this.dl.z, jSONObject);
                            int i2 = i;
                            if (i2 == 1) {
                                com.ss.android.socialbase.downloader.m.z.z(gc.z, "miui new rollback fail: handleDownload id:" + gc.this.v + ",tryPerformButtonClick:", null);
                                gc.this.dl(true);
                                return;
                            } else {
                                if (i2 != 2) {
                                    return;
                                }
                                com.ss.android.socialbase.downloader.m.z.z(gc.z, "miui new rollback fail: handleDownload id:" + gc.this.v + ",tryPerformButtonClick:", null);
                                gc.this.g(true);
                                return;
                            }
                        }
                        jSONObject.putOpt("download_miui_jump_market_success", 1);
                        com.ss.android.downloadlib.addownload.compliance.m.z().z(0, gc.this.dl.z, jSONObject);
                    } catch (Exception e) {
                        com.ss.android.downloadlib.gc.dl.z().z(e, "generate miui new market param error");
                    }
                }

                @Override // com.ss.android.downloadlib.addownload.compliance.gz
                public void z() {
                    int i2 = i;
                    if (i2 == 1) {
                        com.ss.android.socialbase.downloader.m.z.z(gc.z, "miui new get miui deeplink fail: handleDownload id:" + gc.this.v + ",tryPerformButtonClick:", null);
                        gc.this.dl(true);
                    } else {
                        if (i2 != 2) {
                            return;
                        }
                        com.ss.android.socialbase.downloader.m.z.z(gc.z, "miui new get miui deeplink fail: handleDownload id:" + gc.this.v + ",tryPerformButtonClick:", null);
                        gc.this.g(true);
                    }
                }
            });
            return;
        }
        if (this.dl.z(getContext(), i, this.js)) {
            return;
        }
        boolean zDl = dl(i);
        if (i == 1) {
            if (zDl) {
                return;
            }
            com.ss.android.downloadlib.e.kb.z(z, "handleDownload id:" + this.v + ",pIC:", null);
            dl(true);
            return;
        }
        if (i == 2 && !zDl) {
            com.ss.android.downloadlib.e.kb.z(z, "handleDownload id:" + this.v + ",pBC:", null);
            g(true);
        }
    }

    public boolean gc() {
        return wp.fo().optInt("quick_app_enable_switch", 0) == 0 && this.pf.lq() != null && !TextUtils.isEmpty(this.pf.lq().z()) && com.ss.android.downloadlib.addownload.dl.z(this.gz) && com.ss.android.downloadlib.e.i.z(getContext(), new Intent("android.intent.action.VIEW", Uri.parse(this.pf.lq().z())));
    }

    private boolean dl(int i) {
        if (!gc()) {
            return false;
        }
        String strZ = this.pf.lq().z();
        int i2 = i != 1 ? i != 2 ? -1 : 4 : 5;
        com.ss.android.z.z.dl.dl dlVar = this.pf;
        if (dlVar instanceof com.ss.android.g.z.z.dl) {
            ((com.ss.android.g.z.z.dl) dlVar).dl(3);
        }
        boolean zDl = com.ss.android.downloadlib.e.fo.dl(wp.getContext(), strZ);
        if (zDl) {
            com.ss.android.downloadlib.a.z.z().z(this.v, i);
            Message messageObtain = Message.obtain();
            messageObtain.what = i2;
            messageObtain.obj = Long.valueOf(this.pf.a());
            com.ss.android.downloadlib.addownload.dl.z().z(this, i2, this.pf);
        } else {
            com.ss.android.downloadlib.a.z.z().z(this.v, false, 0);
        }
        return zDl;
    }

    public void g(boolean z2) {
        gc(z2);
    }

    private void kb() {
        SoftReference<uf> softReference = this.fv;
        if (softReference != null && softReference.get() != null) {
            this.fv.get().onItemClick(this.pf, wp(), i());
            this.fv = null;
        } else {
            wp.g();
            getContext();
            i();
        }
    }

    public void dl(boolean z2) {
        if (z2) {
            com.ss.android.downloadlib.a.z.z().z(this.v, 1);
        }
        v();
    }

    private void gc(boolean z2) {
        if (com.ss.android.downloadlib.e.gc.g(this.pf).g("notification_opt_2") == 1 && this.gz != null) {
            com.ss.android.socialbase.downloader.notification.g.z().m(this.gz.e());
        }
        m(z2);
    }

    public void m() {
        this.g.post(new Runnable() { // from class: com.ss.android.downloadlib.addownload.gc.2
            @Override // java.lang.Runnable
            public void run() {
                Iterator<com.ss.android.z.z.dl.a> it = gz.z((Map<Integer, Object>) gc.this.m).iterator();
                while (it.hasNext()) {
                    it.next().onInstalled(gc.this.p());
                }
            }
        });
    }

    @Override // com.ss.android.downloadlib.e.v.z
    public void z(Message message) {
        if (message != null && this.kb && message.what == 3) {
            this.gz = (com.ss.android.socialbase.downloader.e.dl) message.obj;
            this.dl.z(message, p(), this.m);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context getContext() {
        WeakReference<Context> weakReference = this.gc;
        if (weakReference != null && weakReference.get() != null) {
            return this.gc.get();
        }
        return wp.getContext();
    }

    private com.ss.android.z.z.dl.g wp() {
        com.ss.android.z.z.dl.g gVar = this.ls;
        return gVar == null ? new e.z().z() : gVar;
    }

    private com.ss.android.z.z.dl.z i() {
        if (this.p == null) {
            this.p = new com.ss.android.z.z.dl.m();
        }
        return this.p;
    }

    private void v() {
        String str = z;
        com.ss.android.downloadlib.e.kb.z(str, "pICD", null);
        if (this.dl.a(this.gz)) {
            com.ss.android.downloadlib.e.kb.z(str, "pICD BC", null);
            m(false);
        } else {
            com.ss.android.downloadlib.e.kb.z(str, "pICD IC", null);
            kb();
        }
    }

    private void m(final boolean z2) {
        com.ss.android.z.z.dl.dl dlVar;
        String str = z;
        com.ss.android.downloadlib.e.kb.z(str, "pBCD", null);
        if (pf()) {
            com.ss.android.downloadlib.addownload.g.gc gcVarGc = com.ss.android.downloadlib.addownload.g.m.z().gc(this.v);
            if (this.js) {
                if (fo()) {
                    if (a(false) && gcVarGc.f1987a != null && gcVarGc.f1987a.i()) {
                        z(z2, true);
                        return;
                    }
                    return;
                }
                z(z2, true);
                return;
            }
            if (this.pf.io() && gcVarGc.f1987a != null && gcVarGc.f1987a.wp() && gcVarGc.g != null && com.ss.android.downloadlib.addownload.compliance.g.z().z(gcVarGc.g) && com.ss.android.downloadlib.addownload.compliance.g.z().z(gcVarGc)) {
                return;
            }
            z(z2, true);
            return;
        }
        com.ss.android.downloadlib.e.kb.z(str, "pBCD continue download, status:" + this.gz.p(), null);
        com.ss.android.socialbase.downloader.e.dl dlVar2 = this.gz;
        if (dlVar2 != null && (dlVar = this.pf) != null) {
            dlVar2.a(dlVar.i());
        }
        final int iP = this.gz.p();
        final int iE = this.gz.e();
        final com.ss.android.g.z.g.g gVarZ = com.ss.android.downloadlib.addownload.g.m.z().z(this.gz);
        if (iP == -2 || iP == -1) {
            this.dl.z(this.gz, z2);
            if (gVarZ != null) {
                gVarZ.gz(System.currentTimeMillis());
                gVarZ.fo(this.gz.sf());
            }
            this.gz.gc(false);
            this.f1990a.z(new com.ss.android.downloadlib.addownload.g.gc(this.v, this.pf, wp(), i()));
            this.f1990a.z(iE, this.gz.sf(), this.gz.s(), new z() { // from class: com.ss.android.downloadlib.addownload.gc.3
                @Override // com.ss.android.downloadlib.addownload.gc.z
                public void z() {
                    if (gc.this.f1990a.z()) {
                        return;
                    }
                    gc gcVar = gc.this;
                    gcVar.z(iE, iP, gcVar.gz);
                }
            });
            if (iP == -2 && com.ss.android.downloadlib.e.gc.z((com.ss.android.g.z.g.z) gVarZ).z("show_pause_continue_toast", 0) == 1) {
                com.ss.android.downloadlib.gz.z().g().postDelayed(new Runnable() { // from class: com.ss.android.downloadlib.addownload.gc.4
                    @Override // java.lang.Runnable
                    public void run() {
                        wp.dl().z(13, wp.getContext(), gc.this.pf, "已恢复下载", null, 0);
                    }
                }, 500L);
                return;
            }
            return;
        }
        if (pf.z(iP)) {
            if (this.pf.gp()) {
                this.f1990a.z(true);
                com.ss.android.downloadlib.dl.gz.z().g(com.ss.android.downloadlib.addownload.g.m.z().a(this.v));
                if (com.ss.android.downloadlib.e.gc.z((com.ss.android.g.z.g.z) gVarZ).z("cancel_pause_optimise_switch", 0) == 1) {
                    com.ss.android.downloadlib.addownload.a.a.z().z(gVarZ, iP, new com.ss.android.downloadlib.addownload.a.gz() { // from class: com.ss.android.downloadlib.addownload.gc.6
                        @Override // com.ss.android.downloadlib.addownload.a.gz
                        public void z(com.ss.android.g.z.g.g gVar) {
                            if (gc.this.gz == null && com.ss.android.socialbase.downloader.i.z.dl().z("fix_handle_pause")) {
                                gc.this.gz = com.ss.android.socialbase.downloader.downloader.e.g(wp.getContext()).gz(iE);
                            }
                            gc.this.dl.z(gc.this.gz, z2);
                            if (gc.this.gz == null || !com.ss.android.socialbase.downloader.pf.m.g(wp.getContext()) || !gc.this.gz.jq()) {
                                kb.z().z(gc.this.pf, gc.this.gz);
                                gVar.kb(System.currentTimeMillis());
                                gc gcVar = gc.this;
                                gcVar.z(iE, iP, gcVar.gz);
                                return;
                            }
                            gc.this.gz.qd();
                            com.ss.android.downloadlib.a.z.z().z("cancel_pause_reserve_wifi_cancel_on_wifi", gVarZ);
                        }
                    }, new com.ss.android.downloadlib.addownload.z.dl() { // from class: com.ss.android.downloadlib.addownload.gc.5
                        @Override // com.ss.android.downloadlib.addownload.z.dl
                        public void delete() {
                            gc.this.z(true);
                        }
                    });
                    return;
                } else {
                    com.ss.android.downloadlib.addownload.a.kb.z().z(gVarZ, iP, new com.ss.android.downloadlib.addownload.a.gz() { // from class: com.ss.android.downloadlib.addownload.gc.7
                        @Override // com.ss.android.downloadlib.addownload.a.gz
                        public void z(com.ss.android.g.z.g.g gVar) {
                            if (gc.this.gz == null && com.ss.android.socialbase.downloader.i.z.dl().z("fix_handle_pause")) {
                                gc.this.gz = com.ss.android.socialbase.downloader.downloader.e.g(wp.getContext()).gz(iE);
                            }
                            gc.this.dl.z(gc.this.gz, z2);
                            if (gc.this.gz == null || !com.ss.android.socialbase.downloader.pf.m.g(wp.getContext()) || !gc.this.gz.jq()) {
                                kb.z().z(gc.this.pf, gc.this.gz);
                                gVar.kb(System.currentTimeMillis());
                                gc gcVar = gc.this;
                                gcVar.z(iE, iP, gcVar.gz);
                                return;
                            }
                            gc.this.gz.qd();
                            com.ss.android.downloadlib.a.z.z().g("pause_reserve_wifi_cancel_on_wifi", gVarZ);
                        }
                    });
                    return;
                }
            }
            return;
        }
        this.dl.z(this.gz, z2);
        z(iE, iP, this.gz);
    }

    public void z(boolean z2, final boolean z3) {
        if (z2) {
            com.ss.android.downloadlib.a.z.z().z(this.v, 2);
        }
        if (!com.ss.android.downloadlib.e.i.z()) {
            if (!com.ss.android.downloadlib.e.uy.g(com.kuaishou.weapon.p0.g.j) && !i().v()) {
                this.pf.z(this.dl.g());
            }
        } else if (!com.ss.android.downloadlib.e.uy.g("android.permission.READ_MEDIA_IMAGES") && !com.ss.android.downloadlib.e.uy.g("android.permission.READ_MEDIA_AUDIO") && !com.ss.android.downloadlib.e.uy.g("android.permission.READ_MEDIA_VIDEO") && !i().v()) {
            this.pf.z(this.dl.g());
        }
        if (com.ss.android.downloadlib.e.gc.dl(this.pf) == 0) {
            com.ss.android.downloadlib.e.kb.z(z, "pBCD not start", null);
            this.dl.z(new zw() { // from class: com.ss.android.downloadlib.addownload.gc.8
                @Override // com.ss.android.z.z.g.zw
                public void z() {
                    com.ss.android.downloadlib.e.kb.z(gc.z, "pBCD start download", null);
                    gc.this.e(z3);
                }

                @Override // com.ss.android.z.z.g.zw
                public void z(String str) {
                    com.ss.android.downloadlib.e.kb.z(gc.z, "pBCD onDenied", null);
                }
            });
        } else {
            e(z3);
        }
    }

    private boolean pf() {
        if (com.ss.android.socialbase.downloader.i.z.dl().z("fix_click_start")) {
            com.ss.android.socialbase.downloader.e.dl dlVar = this.gz;
            if (dlVar == null) {
                return true;
            }
            if ((dlVar.p() == -3 && this.gz.sf() <= 0) || this.gz.p() == 0 || this.gz.p() == -4) {
                return true;
            }
            return com.ss.android.socialbase.downloader.pf.m.z(this.gz.p(), this.gz.kb(), this.gz.gz());
        }
        com.ss.android.socialbase.downloader.e.dl dlVar2 = this.gz;
        if (dlVar2 == null) {
            return true;
        }
        return !(dlVar2.p() == -3 || com.ss.android.socialbase.downloader.downloader.e.g(wp.getContext()).a(this.gz.e())) || this.gz.p() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(int i, int i2, com.ss.android.socialbase.downloader.e.dl dlVar) {
        if (com.ss.android.socialbase.downloader.i.z.dl().z("fix_click_start")) {
            if (i2 != -3 && !com.ss.android.socialbase.downloader.downloader.a.z().gc(i)) {
                z(false, false);
                return;
            } else {
                com.ss.android.socialbase.appdownloader.a.kb().z(wp.getContext(), i, i2);
                return;
            }
        }
        com.ss.android.socialbase.appdownloader.a.kb().z(wp.getContext(), i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(final boolean z2) {
        this.f1990a.z(new com.ss.android.downloadlib.addownload.g.gc(this.v, this.pf, wp(), i()));
        this.f1990a.z(0, 0L, 0L, new z() { // from class: com.ss.android.downloadlib.addownload.gc.9
            @Override // com.ss.android.downloadlib.addownload.gc.z
            public void z() {
                if (gc.this.f1990a.z()) {
                    return;
                }
                gc.this.gz(z2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gz(boolean z2) {
        Iterator<com.ss.android.z.z.dl.a> it = gz.z(this.m).iterator();
        while (it.hasNext()) {
            it.next().onDownloadStart(this.pf, i());
        }
        int iZ = this.dl.z(wp.getContext(), this.uy);
        String str = z;
        com.ss.android.downloadlib.e.kb.z(str, "beginDown id:" + iZ, null);
        if (iZ != 0) {
            if (this.gz != null && !com.ss.android.socialbase.downloader.i.z.dl().z("fix_click_start")) {
                this.dl.z(this.gz, false);
            } else if (z2) {
                this.dl.z();
            }
        } else {
            com.ss.android.socialbase.downloader.e.dl dlVarZ = new dl.z(this.pf.z()).z();
            dlVarZ.a(-1);
            z(dlVarZ);
            com.ss.android.downloadlib.a.z.z().z(this.v, new com.ss.android.socialbase.downloader.gc.z(2, "start download failed, id=0"));
            com.ss.android.downloadlib.gc.dl.z().g("beginDown");
        }
        if (this.dl.z(dl())) {
            com.ss.android.downloadlib.e.kb.z(str, "beginDown IC id:" + iZ, null);
            kb();
        }
    }

    public void e() {
        if (this.m.size() == 0) {
            return;
        }
        Iterator<com.ss.android.z.z.dl.a> it = gz.z(this.m).iterator();
        while (it.hasNext()) {
            it.next().z();
        }
        com.ss.android.socialbase.downloader.e.dl dlVar = this.gz;
        if (dlVar != null) {
            dlVar.a(-4);
        }
    }

    private class dl extends com.bytedance.sdk.component.uy.a.g<String, Void, com.ss.android.socialbase.downloader.e.dl> {
        private dl() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
        public com.ss.android.socialbase.downloader.e.dl doInBackground(String... strArr) {
            com.ss.android.socialbase.downloader.e.dl dlVarG = null;
            if (strArr == null) {
                return null;
            }
            if (strArr.length > 0 && TextUtils.isEmpty(strArr[0])) {
                return null;
            }
            String str = (strArr.length < 3 || TextUtils.isEmpty(strArr[2])) ? "" : strArr[2];
            String str2 = strArr[0];
            if (gc.this.pf != null && !TextUtils.isEmpty(gc.this.pf.pf())) {
                if (TextUtils.isEmpty(str)) {
                    dlVarG = com.ss.android.socialbase.downloader.downloader.e.g(wp.getContext()).g(str2, gc.this.pf.pf());
                } else {
                    dlVarG = com.ss.android.socialbase.downloader.downloader.e.g(wp.getContext()).gz(com.ss.android.socialbase.downloader.downloader.e.g(wp.getContext()).z(str, gc.this.pf.pf()));
                }
            }
            if (dlVarG != null) {
                return dlVarG;
            }
            if (!TextUtils.isEmpty(str)) {
                return com.ss.android.socialbase.appdownloader.a.kb().z(wp.getContext(), str);
            }
            return com.ss.android.socialbase.appdownloader.a.kb().z(wp.getContext(), str2);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(com.ss.android.socialbase.downloader.e.dl dlVar) {
            super.onPostExecute(dlVar);
            if (isCancelled() || gc.this.pf == null) {
                return;
            }
            try {
                com.ss.android.downloadlib.addownload.g.dl dlVarZ = com.ss.android.downloadlib.e.i.z(gc.this.pf.sy(), gc.this.pf.iq(), gc.this.pf.zw());
                com.ss.android.downloadlib.addownload.g.gz.z().z(gc.this.pf.iq(), dlVarZ.g(), com.ss.android.downloadlib.addownload.g.m.z().z(dlVar));
                boolean z = dlVarZ.z();
                if (dlVar != null && dlVar.e() != 0 && (z || !com.ss.android.socialbase.downloader.downloader.e.g(wp.getContext()).z(dlVar))) {
                    com.ss.android.socialbase.downloader.downloader.e.g(wp.getContext()).kb(dlVar.e());
                    if (gc.this.gz == null || gc.this.gz.p() != -4) {
                        gc.this.gz = dlVar;
                        if (gc.this.tb) {
                            com.ss.android.socialbase.downloader.downloader.e.g(wp.getContext()).z(gc.this.gz.e(), gc.this.uy, false);
                        } else {
                            com.ss.android.socialbase.downloader.downloader.e.g(wp.getContext()).z(gc.this.gz.e(), gc.this.uy);
                        }
                    } else {
                        gc.this.gz = null;
                    }
                    gc.this.dl.z(gc.this.gz, gc.this.p(), gz.z((Map<Integer, Object>) gc.this.m), z);
                } else {
                    if (dlVar != null && com.ss.android.socialbase.downloader.downloader.e.g(wp.getContext()).z(dlVar)) {
                        com.ss.android.socialbase.downloader.notification.g.z().m(dlVar.e());
                        gc.this.gz = null;
                    }
                    if (gc.this.gz != null) {
                        com.ss.android.socialbase.downloader.downloader.e.g(wp.getContext()).kb(gc.this.gz.e());
                        if (gc.this.tb) {
                            com.ss.android.socialbase.downloader.downloader.e.g(gc.this.getContext()).z(gc.this.gz.e(), gc.this.uy, false);
                        } else {
                            com.ss.android.socialbase.downloader.downloader.e.g(gc.this.getContext()).z(gc.this.gz.e(), gc.this.uy);
                        }
                    }
                    if (!z) {
                        Iterator<com.ss.android.z.z.dl.a> it = gz.z((Map<Integer, Object>) gc.this.m).iterator();
                        while (it.hasNext()) {
                            it.next().z();
                        }
                        gc.this.gz = null;
                    } else {
                        gc.this.gz = new dl.z(gc.this.pf.z()).z();
                        gc.this.gz.a(-3);
                        gc.this.dl.z(gc.this.gz, gc.this.p(), gz.z((Map<Integer, Object>) gc.this.m), z);
                    }
                }
                gc.this.dl.dl(gc.this.gz);
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.wp.z(e);
            }
        }
    }

    private void z(com.ss.android.socialbase.downloader.e.dl dlVar) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 3;
        messageObtain.obj = dlVar;
        this.g.sendMessage(messageObtain);
    }

    private void ls() {
        dl dlVar = this.fo;
        if (dlVar != null && dlVar.getStatus() != AsyncTask.Status.FINISHED) {
            this.fo.cancel(true);
        }
        this.fo = new dl();
        if (!TextUtils.isEmpty(this.i)) {
            com.ss.android.downloadlib.e.g.z(this.fo, this.pf.z(), this.pf.sy(), this.i);
        } else {
            com.ss.android.downloadlib.e.g.z(this.fo, this.pf.z(), this.pf.sy());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.ss.android.z.z.gc.gc p() {
        if (this.e == null) {
            this.e = new com.ss.android.z.z.gc.gc();
        }
        return this.e;
    }

    @Override // com.ss.android.downloadlib.addownload.e
    public void gz() {
        com.ss.android.downloadlib.addownload.g.m.z().m(this.v);
    }

    @Override // com.ss.android.downloadlib.addownload.e
    public e z(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.i = str;
        }
        return this;
    }

    @Override // com.ss.android.downloadlib.addownload.e
    public e z(p pVar) {
        if (pVar == null) {
            this.q = null;
        } else {
            this.q = new SoftReference<>(pVar);
        }
        return this;
    }

    public boolean fo() {
        SoftReference<p> softReference = this.q;
        if (softReference == null) {
            return false;
        }
        return fo.z(this.pf, softReference.get());
    }

    public boolean a(boolean z2) {
        SoftReference<p> softReference = this.q;
        if (softReference != null && softReference.get() != null) {
            try {
                if (!z2) {
                    this.q.get().z(true);
                } else {
                    this.q.get().z();
                }
                this.q = null;
                return true;
            } catch (Exception unused) {
                com.ss.android.downloadlib.gc.dl.z().g("mDownloadButtonClickListener has recycled");
                return false;
            }
        }
        com.ss.android.downloadlib.gc.dl.z().g("mDownloadButtonClickListener has recycled");
        return false;
    }
}
