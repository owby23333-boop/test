package com.bytedance.sdk.openadsdk.core.video.z;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import com.bykv.vk.openvk.component.video.api.a.dl;
import com.bykv.vk.openvk.component.video.api.dl.a;
import com.bykv.vk.openvk.component.video.api.renderview.SSRenderTextureView;
import com.bytedance.sdk.component.utils.gz;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.iq.jq;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.multipro.g.z;
import com.bytedance.sdk.openadsdk.core.q.v;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.g;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.m;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.hh.fo;
import com.bytedance.sdk.openadsdk.hh.uy;
import com.bytedance.sdk.openadsdk.m.dl.p;
import com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z implements dl, l.z, z.InterfaceC0190z, g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.bykv.vk.openvk.component.video.api.z f1409a;
    protected SurfaceTexture dl;
    protected WeakReference<Context> fo;
    protected SurfaceHolder g;
    protected m gc;
    protected a iq;
    protected List<Runnable> kb;
    protected long ls;
    protected na m;
    private long sy;
    private long uf;
    protected InterfaceC0212z zw;
    protected final l z = new l(Looper.getMainLooper(), this);
    protected long e = 0;
    protected long gz = 0;
    protected boolean uy = false;
    protected boolean wp = true;
    protected long i = 0;
    protected boolean v = false;
    protected boolean pf = false;
    protected boolean p = false;
    protected volatile boolean fv = false;
    protected boolean js = false;
    protected boolean tb = false;
    public com.bytedance.sdk.openadsdk.m.g.z q = new com.bytedance.sdk.openadsdk.m.g.z();
    protected Runnable io = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.z.z.1
        @Override // java.lang.Runnable
        public void run() {
            wp.z("BaseController", "resumeVideo: run ", Boolean.valueOf(z.this.uy));
            z.this.eo();
        }
    };
    private final AtomicBoolean hh = new AtomicBoolean(false);

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.video.z.z$z, reason: collision with other inner class name */
    public interface InterfaceC0212z {
        void z(long j, long j2);
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl
    public boolean a() {
        return false;
    }

    public boolean g(int i) {
        return i == 6 || i == 8 || i == 9;
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl
    public boolean gc() {
        return false;
    }

    protected Map<String, Object> gp() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.g.z.InterfaceC0190z
    public boolean h() {
        return false;
    }

    public boolean hh() {
        return true;
    }

    @Override // com.bytedance.sdk.component.utils.l.z
    public void z(Message message) {
    }

    protected void sy() {
        if (this.f1409a == null) {
            return;
        }
        if (zw()) {
            SurfaceTexture surfaceTexture = this.dl;
            if (surfaceTexture == null || surfaceTexture == this.f1409a.gz()) {
                return;
            }
            this.f1409a.z(this.dl);
            return;
        }
        SurfaceHolder surfaceHolder = this.g;
        if (surfaceHolder == null || surfaceHolder == this.f1409a.e()) {
            return;
        }
        this.f1409a.z(this.g);
    }

    private boolean zw() {
        m mVar = this.gc;
        if (mVar == null) {
            return false;
        }
        com.bykv.vk.openvk.component.video.api.renderview.g gVarP = mVar.p();
        return (gVarP instanceof SSRenderTextureView) || (gVarP instanceof UpieVideoView);
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl
    public long kb() {
        return this.e;
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl
    public void g(long j) {
        this.e = j;
        long j2 = this.gz;
        if (j2 > j) {
            j = j2;
        }
        this.gz = j;
    }

    protected boolean l() {
        WeakReference<Context> weakReference = this.fo;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    protected void z(Runnable runnable) {
        if (runnable == null || this.m == null) {
            return;
        }
        if ((this.gc.i() && this.uy) || uy.z(this.m) || com.bytedance.sdk.openadsdk.gc.z.g(this.m)) {
            runnable.run();
        } else {
            g(runnable);
        }
    }

    public boolean gk() {
        if ((this.gc.i() && this.uy) || uy.z(this.m) || com.bytedance.sdk.openadsdk.gc.z.g(this.m)) {
            gz(false);
            ti();
            return true;
        }
        z("not exec pending");
        return false;
    }

    protected int lq() {
        int i = jq.z(this.m) ? 3 : 0;
        if (mc()) {
            return 3;
        }
        return i;
    }

    public boolean mc() {
        return this.uf > 0;
    }

    public long un() {
        return this.uf;
    }

    protected long dl(a aVar) {
        com.bykv.vk.openvk.component.video.api.dl.dl dlVarUf;
        if (aVar == null || (dlVarUf = aVar.uf()) == null) {
            return 0L;
        }
        int iD = this.m.d();
        na naVar = this.m;
        if (naVar != null) {
            int iGz = eo.gz(naVar);
            if (!g(iD)) {
                return 0L;
            }
            if ((iGz != 7 && iGz != 8) || jq.z(this.m)) {
                return 0L;
            }
        }
        double dE = dlVarUf.e();
        if (dE < 0.0d || dE >= dlVarUf.m()) {
            return 0L;
        }
        long jG = fo.z(aVar.fv()).g(aVar);
        int iLs = dlVarUf.ls();
        if (!(iLs > 0 && jG >= ((long) iLs))) {
            return 0L;
        }
        long j = (long) (dE * 1000.0d);
        this.uf = j;
        return j;
    }

    protected void g(Runnable runnable) {
        if (this.kb == null) {
            this.kb = new ArrayList();
        }
        this.kb.add(runnable);
    }

    protected void ti() {
        wp.z("BaseController", "execPendingActions: before ");
        List<Runnable> list = this.kb;
        if (list == null || list.isEmpty() || this.fv) {
            return;
        }
        wp.z("BaseController", "execPendingActions:  exec");
        gz.g().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.z.z.2
            @Override // java.lang.Runnable
            public void run() {
                z.this.io();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void io() {
        Iterator it = new ArrayList(this.kb).iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.kb.clear();
    }

    public void gz(boolean z) {
        this.fv = z;
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.z
    public void z(com.bykv.vk.openvk.component.video.api.a.g gVar, SurfaceHolder surfaceHolder) {
        this.uy = true;
        this.g = surfaceHolder;
        com.bykv.vk.openvk.component.video.api.z zVar = this.f1409a;
        if (zVar == null) {
            return;
        }
        if (zVar != null) {
            zVar.z(surfaceHolder);
        }
        wp.z("BaseController", "surfaceCreated: ");
        ti();
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.z
    public void g(com.bykv.vk.openvk.component.video.api.a.g gVar, SurfaceHolder surfaceHolder) {
        this.uy = false;
        this.g = null;
        com.bykv.vk.openvk.component.video.api.z zVar = this.f1409a;
        if (zVar != null) {
            zVar.g(false);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.z
    public void z(com.bykv.vk.openvk.component.video.api.a.g gVar, SurfaceTexture surfaceTexture) {
        this.uy = true;
        this.dl = surfaceTexture;
        com.bykv.vk.openvk.component.video.api.z zVar = this.f1409a;
        if (zVar != null) {
            zVar.z(surfaceTexture);
            this.f1409a.g(this.uy);
        }
        wp.z("BaseController", "surfaceTextureCreated: ");
        ti();
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.z
    public void g(com.bykv.vk.openvk.component.video.api.a.g gVar, SurfaceTexture surfaceTexture) {
        this.uy = false;
        wp.z("BaseController", "surfaceTextureDestroyed: ");
        com.bykv.vk.openvk.component.video.api.z zVar = this.f1409a;
        if (zVar != null) {
            zVar.g(false);
        }
        this.dl = null;
        ti();
    }

    protected void eo() {
        this.z.postAtFrontOfQueue(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.z.z.3
            @Override // java.lang.Runnable
            public void run() {
                if (z.this.f1409a != null) {
                    wp.z("BaseController", "resumeVideo: execResumePlay", Boolean.valueOf(z.this.uy));
                    z.this.f1409a.g();
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl
    public com.bykv.vk.openvk.component.video.api.z p() {
        return this.f1409a;
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl
    /* JADX INFO: renamed from: oq, reason: merged with bridge method [inline-methods] */
    public m fv() {
        return this.gc;
    }

    public boolean wj() {
        return this.wp;
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl
    public void z(boolean z) {
        this.wp = z;
        m mVar = this.gc;
        if (mVar != null) {
            mVar.a(z);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl
    public void dl(long j) {
        this.i = j;
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl
    public boolean ls() {
        return this.pf;
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl
    public void a(long j) {
        this.ls = j;
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl
    public long wp() {
        if (p() == null) {
            return 0L;
        }
        return p().ls();
    }

    public long z(long j, long j2) {
        long jUn = un();
        if (!dl() && (j == jUn || j - jUn < 0 || j == 0)) {
            return 0L;
        }
        na naVar = this.m;
        if (naVar == null) {
            return j;
        }
        if (naVar.qz() > 0 && j2 > ((long) this.m.qz()) * 1000) {
            if (this.v) {
                long jQz = j2 - (((long) this.m.qz()) * 1000);
                long j3 = this.sy;
                if (j - j3 >= jQz) {
                    return j3;
                }
            }
            j2 = this.m.qz();
        }
        long j4 = j - jUn;
        long j5 = j4 + (j2 * ((long) (j4 > 0 ? 0 : 1)));
        this.sy = j5;
        return j5;
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl
    public boolean js() {
        return this.p;
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl
    public void g(boolean z) {
        this.p = z;
        com.bykv.vk.openvk.component.video.api.z zVar = this.f1409a;
        if (zVar != null) {
            zVar.z(z);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl
    public long v() {
        com.bykv.vk.openvk.component.video.api.z zVar = this.f1409a;
        if (zVar == null) {
            return 0L;
        }
        return zVar.fv();
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl
    public boolean tb() {
        return this.js;
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl
    public void dl(boolean z) {
        this.js = z;
    }

    protected void fo(boolean z) {
        this.tb = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void z(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("error", str);
        } catch (JSONException unused) {
        }
        v.z().z("video", jSONObject, (Throwable) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void z(int i, int i2, String str, JSONArray jSONArray) {
        if (this.fo == null) {
            return;
        }
        p.z zVar = new p.z();
        zVar.g(wp());
        long jV = v();
        zVar.dl(jV);
        zVar.z(gc(jV));
        zVar.z(i);
        zVar.g(i2);
        zVar.z(jSONArray);
        if (this.q.z(256)) {
            return;
        }
        this.q.dl(256);
        com.bytedance.sdk.openadsdk.m.g.a.z(fv(), zVar, str, !this.q.z(2) ? 1 : 0, this.q.z(128));
    }

    private long gc(long j) {
        long jKb = kb();
        return mc() ? z(jKb, j) : jKb;
    }

    protected void na() {
        p.z zVar = new p.z();
        long jV = v();
        zVar.z(gc(jV));
        zVar.dl(jV);
        zVar.g(wp());
        zVar.m(i());
        a aVarG = com.bytedance.sdk.openadsdk.m.g.a.g(this.gc);
        if (aVarG != null) {
            aVarG.z("EXTRA_PLAY_ACTION", gp());
        }
        com.bytedance.sdk.openadsdk.m.g.a.a(this.gc, zVar);
    }

    public void dl(int i) {
        if (this.q.a(1)) {
            if (!this.wp) {
                i *= 10;
            }
            z(-900001, i, "only play start", (JSONArray) null);
        }
        JSONArray jSONArray = new JSONArray();
        if (this.q.z(1)) {
            return;
        }
        String strG = eo.g(this.m);
        JSONObject jSONObjectZ = z(4, strG);
        if (jSONObjectZ != null) {
            jSONArray.put(jSONObjectZ);
        }
        JSONObject jSONObjectZ2 = z(2, strG);
        if (jSONObjectZ2 != null) {
            jSONArray.put(jSONObjectZ2);
        }
        JSONObject jSONObjectZ3 = z(8, strG);
        if (jSONObjectZ3 != null) {
            jSONArray.put(jSONObjectZ3);
        }
        JSONObject jSONObjectZ4 = z(32, strG);
        if (jSONObjectZ4 != null) {
            jSONArray.put(jSONObjectZ4);
        }
        JSONObject jSONObjectZ5 = z(64, strG);
        if (jSONObjectZ5 != null) {
            jSONArray.put(jSONObjectZ5);
        }
        JSONObject jSONObjectZ6 = z(128, strG);
        if (jSONObjectZ6 != null) {
            jSONArray.put(jSONObjectZ6);
        }
        z(-900002, -701, "lack play start", jSONArray);
    }

    private JSONObject z(int i, String str) {
        String str2;
        try {
            if (this.q.z(128)) {
                str2 = "endcard_skip";
            } else if (this.q.z(8)) {
                str2 = "feed_continue";
            } else if (this.q.z(4)) {
                str2 = "feed_pause";
            } else if (this.q.z(2)) {
                str2 = "feed_play";
            } else if (this.q.z(64)) {
                str2 = "feed_over";
            } else {
                str2 = this.q.z(32) ? "feed_break" : null;
            }
            if (!TextUtils.isEmpty(str2)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("tag", str);
                jSONObject.putOpt("label", str2);
                jSONObject.putOpt("time", this.q.g(i));
                return jSONObject;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    protected void dl(Map<String, Object> map) {
        p.z zVar = new p.z();
        long jV = v();
        zVar.z(gc(jV));
        zVar.dl(jV);
        zVar.g(wp());
        a aVarG = com.bytedance.sdk.openadsdk.m.g.a.g(this.gc);
        if (aVarG != null) {
            aVarG.z("EXTRA_PLAY_ACTION", gp());
        }
        if (map != null) {
            zVar.z(map);
        }
        z(this.gc, zVar);
    }

    protected void z(com.bykv.vk.openvk.component.video.api.g.z zVar, p.z zVar2) {
        this.q.dl(4);
        com.bytedance.sdk.openadsdk.m.g.a.z(this.gc, zVar2, !this.q.z(2) ? 1 : 0);
    }

    protected void xl() {
        p.z zVar = new p.z();
        long jV = v();
        zVar.z(gc(jV));
        zVar.dl(jV);
        zVar.g(wp());
        a aVarG = com.bytedance.sdk.openadsdk.m.g.a.g(this.gc);
        if (aVarG != null) {
            aVarG.z("EXTRA_PLAY_ACTION", gp());
        }
        g(fv(), zVar);
    }

    public void g(com.bykv.vk.openvk.component.video.api.g.z zVar, p.z zVar2) {
        this.q.dl(8);
        com.bytedance.sdk.openadsdk.m.g.a.g(fv(), zVar2);
    }

    protected void uy(boolean z) {
        p.z zVar = new p.z();
        zVar.g(true);
        zVar.dl(z);
        a aVarG = com.bytedance.sdk.openadsdk.m.g.a.g(this.gc);
        if (aVarG != null) {
            aVarG.z("EXTRA_PLAY_START", gp());
        }
        dl(this.gc, zVar);
    }

    protected void dl(com.bykv.vk.openvk.component.video.api.g.z zVar, p.z zVar2) {
        this.q.dl(2);
        com.bytedance.sdk.openadsdk.m.g.a.z(zVar, zVar2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j() {
        if (this.iq == null) {
            return;
        }
        this.q.dl(1);
        this.iq.z("EXTRA_PLAY_START", gp());
        com.bytedance.sdk.openadsdk.m.g.a.z(this.m, (com.bykv.vk.openvk.component.video.api.g.z) this.gc, this.iq, true);
    }

    public void a(int i) {
        com.bykv.vk.openvk.component.video.api.z zVar = this.f1409a;
        if (zVar != null) {
            zVar.g(i);
        }
    }

    public void z(InterfaceC0212z interfaceC0212z) {
        this.zw = interfaceC0212z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.multipro.g.z.InterfaceC0190z
    public com.bytedance.sdk.openadsdk.core.multipro.g.z x() {
        com.bytedance.sdk.openadsdk.core.multipro.g.z zVar = new com.bytedance.sdk.openadsdk.core.multipro.g.z();
        zVar.e = this.e;
        zVar.z = tb();
        zVar.gz = js();
        zVar.f1272a = q();
        return zVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(long j, long j2) {
        if (!this.hh.get() && zw.g().li() && (j * 1.0d) / j2 > 0.3d) {
            this.hh.set(true);
            com.bytedance.sdk.openadsdk.core.v.dl.gc().z("videoPercent30", this.m);
        }
    }
}
