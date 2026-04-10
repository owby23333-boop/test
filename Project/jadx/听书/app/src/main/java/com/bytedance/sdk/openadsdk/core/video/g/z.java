package com.bytedance.sdk.openadsdk.core.video.g;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.component.video.api.a.dl;
import com.bykv.vk.openvk.component.video.api.a.g;
import com.bykv.vk.openvk.component.video.api.z;
import com.bykv.vk.openvk.component.video.z.a.a;
import com.bytedance.android.metrics.LiveMetrics;
import com.bytedance.sdk.component.utils.gz;
import com.bytedance.sdk.component.utils.uf;
import com.bytedance.sdk.component.utils.v;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.gk;
import com.bytedance.sdk.openadsdk.core.i.z;
import com.bytedance.sdk.openadsdk.core.iq.js;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.tf;
import com.bytedance.sdk.openadsdk.core.iq.vm;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.uy;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.m;
import com.bytedance.sdk.openadsdk.core.widget.pf;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.res.layout.video.LayoutVideoPlayLayoutForLive;
import com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView;
import java.lang.ref.WeakReference;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class z extends com.bytedance.sdk.openadsdk.core.video.z.z {
    private final String ec;
    private int f;
    private int gb;
    private final int gp;
    private WeakReference<dl.g> j;
    private int jq;
    private InterfaceC0210z na;
    private dl.z oq;
    private long sv;
    protected ViewGroup sy;
    public long uf;
    protected com.bytedance.sdk.openadsdk.core.g.z x;
    private long y;
    protected long hh = 0;
    protected boolean l = false;
    protected boolean h = false;
    protected Map<String, Object> gk = null;
    private final AtomicInteger mc = new AtomicInteger(0);
    private final AtomicInteger un = new AtomicInteger(0);
    private long ti = 0;
    private long eo = 0;
    private final Runnable wj = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.g.z.1
        @Override // java.lang.Runnable
        public void run() {
            if (z.this.oq != null) {
                z.this.oq.z();
            }
            if (z.this.na != null) {
                z.this.na.g();
            }
        }
    };
    private boolean xl = false;
    private boolean t = false;
    private boolean vm = true;
    private boolean bv = false;
    z.InterfaceC0029z lq = new z.InterfaceC0029z() { // from class: com.bytedance.sdk.openadsdk.core.video.g.z.2
        @Override // com.bykv.vk.openvk.component.video.api.z.InterfaceC0029z
        public void z(com.bykv.vk.openvk.component.video.api.z zVar) {
            wp.z("BaseVideoController", "IVideoPlayerCallback onCompletion: ");
            z.this.z.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.g.z.2.1
                @Override // java.lang.Runnable
                public void run() {
                    z.this.m(false);
                }
            });
            z.this.z(4);
            z.this.dl(4);
        }

        @Override // com.bykv.vk.openvk.component.video.api.z.InterfaceC0029z
        public void z(com.bykv.vk.openvk.component.video.api.z zVar, long j) {
            wp.z("BaseVideoController", "IVideoPlayerCallback onRenderStart: ");
            z.this.z.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.g.z.2.2
                @Override // java.lang.Runnable
                public void run() {
                    if (z.this.gc != null) {
                        z.this.m(0);
                        z.this.gc.g();
                        z.this.z.removeCallbacks(z.this.wj);
                        z.this.t = false;
                    }
                }
            });
            z.this.z(j, false);
            z.this.y = System.currentTimeMillis();
            z.this.zx();
            if (z.this.na != null) {
                z.this.na.dl();
            }
        }

        @Override // com.bykv.vk.openvk.component.video.api.z.InterfaceC0029z
        public void g(com.bykv.vk.openvk.component.video.api.z zVar) {
            wp.z("BaseVideoController", "IVideoPlayerCallback onPrepared: ");
            z.this.z.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.g.z.2.3
                @Override // java.lang.Runnable
                public void run() {
                    z.this.z.removeCallbacks(z.this.wj);
                    if (z.this.gc != null) {
                        z.this.m(0);
                        z.this.gc.g();
                    }
                }
            });
        }

        @Override // com.bykv.vk.openvk.component.video.api.z.InterfaceC0029z
        public void z(final com.bykv.vk.openvk.component.video.api.z zVar, final com.bykv.vk.openvk.component.video.api.dl.g gVar) {
            if (gVar == null) {
                return;
            }
            wp.z("BaseVideoController", "IVideoPlayerCallback video_pip_big_error onError: code:" + gVar.z() + " msg:" + gVar.dl());
            z.this.z.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.g.z.2.4
                @Override // java.lang.Runnable
                public void run() {
                    com.bykv.vk.openvk.component.video.api.z zVar2;
                    com.bykv.vk.openvk.component.video.api.z zVar3;
                    int iTb;
                    int iZ = gVar.z();
                    if (iZ != 308 || (zVar2 = z.this.f1409a) == null || zVar2 == (zVar3 = zVar) || !(zVar3 instanceof a) || ((iTb = ((a) zVar3).tb()) != 200 && iTb != 203)) {
                        z.this.z(iZ, gVar.g(), gVar.dl(), (JSONArray) null);
                        z.this.z.removeCallbacks(z.this.wj);
                        if (z.this.gc != null) {
                            z.this.m(0);
                            z.this.gc.g();
                        }
                        if (z.this.oq != null) {
                            z.this.oq.g(z.this.eo, com.bykv.vk.openvk.component.video.z.gc.z.z(z.this.e, z.this.uf));
                        }
                        if (z.this.na != null) {
                            z.this.na.z(iZ, gVar.dl());
                            return;
                        }
                        return;
                    }
                    wp.a("BaseVideoController", "ignore errorCode:" + iZ + " state:" + iTb);
                }
            });
            z.this.z(gVar.z(), gVar.dl());
        }

        @Override // com.bykv.vk.openvk.component.video.api.z.InterfaceC0029z
        public void z(com.bykv.vk.openvk.component.video.api.z zVar, boolean z) {
            wp.z("BaseVideoController", "IVideoPlayerCallback onSeekCompletion: ");
            z.this.z.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.g.z.2.5
                @Override // java.lang.Runnable
                public void run() {
                    z.this.z.removeCallbacks(z.this.wj);
                    if (z.this.gc != null) {
                        z.this.m(0);
                        z.this.gc.g();
                    }
                }
            });
        }

        @Override // com.bykv.vk.openvk.component.video.api.z.InterfaceC0029z
        public void dl(com.bykv.vk.openvk.component.video.api.z zVar) {
            wp.z("BaseVideoController", "IVideoPlayerCallback onRelease: ");
        }

        @Override // com.bykv.vk.openvk.component.video.api.z.InterfaceC0029z
        public void z(com.bykv.vk.openvk.component.video.api.z zVar, int i, int i2) {
            wp.z("BaseVideoController", "IVideoPlayerCallback onVideoSizeChanged: ");
            z.this.gb = i;
            z.this.jq = i2;
            z.this.b();
        }

        @Override // com.bykv.vk.openvk.component.video.api.z.InterfaceC0029z
        public void z(com.bykv.vk.openvk.component.video.api.z zVar, int i, int i2, int i3) {
            wp.z("BaseVideoController", "IVideoPlayerCallback onBufferStart: ");
            z.this.z.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.g.z.2.6
                @Override // java.lang.Runnable
                public void run() {
                    if (z.this.gc != null) {
                        z.this.m(8);
                        z.this.gc.zw();
                        z.this.ec();
                        z.this.t = true;
                    }
                }
            });
        }

        @Override // com.bykv.vk.openvk.component.video.api.z.InterfaceC0029z
        public void z(com.bykv.vk.openvk.component.video.api.z zVar, int i) {
            wp.z("BaseVideoController", "IVideoPlayerCallback onBufferEnd: ");
            z.this.z.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.g.z.2.7
                @Override // java.lang.Runnable
                public void run() {
                    if (z.this.gc != null) {
                        z.this.m(0);
                        z.this.gc.g();
                        z.this.z.removeCallbacks(z.this.wj);
                        z.this.t = false;
                    }
                }
            });
        }

        @Override // com.bykv.vk.openvk.component.video.api.z.InterfaceC0029z
        public void g(com.bykv.vk.openvk.component.video.api.z zVar, int i) {
            wp.z("BaseVideoController", "IVideoPlayerCallback onBufferingUpdate: ");
        }

        @Override // com.bykv.vk.openvk.component.video.api.z.InterfaceC0029z
        public void z(final com.bykv.vk.openvk.component.video.api.z zVar, final long j, final long j2) {
            if (Math.abs(j - z.this.e) < 50) {
                return;
            }
            wp.z("BaseVideoController", "IVideoPlayerCallback onPlayPositionUpdate: current = ", Long.valueOf(j), "; duration=", Long.valueOf(j2));
            z.this.z.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.g.z.2.8
                @Override // java.lang.Runnable
                public void run() {
                    if (z.this.zw != null) {
                        z.this.zw.z(j, j2);
                    }
                    z.this.dl(j, j2);
                    z.this.g(j, j2);
                    if (z.this.m.qz() <= 0 || j2 <= ((long) z.this.m.qz()) * 1000 || j < ((long) z.this.m.qz()) * 1000 || z.this.v) {
                        return;
                    }
                    z.this.v = true;
                    zVar.a();
                    z.this.m(false);
                }
            });
        }

        @Override // com.bykv.vk.openvk.component.video.api.z.InterfaceC0029z
        public void z(com.bykv.vk.openvk.component.video.api.z zVar, JSONObject jSONObject, String str) {
            if (uy.ls().t()) {
                jSONObject.optString(TtmlNode.START);
                jSONObject.optString("sdk_dns_analysis_end");
                jSONObject.optString("player_dns_analysis_end");
                jSONObject.optString("tcp_connect_end");
                jSONObject.optString("tcp_first_package_end");
                jSONObject.optString("first_video_package_end");
                jSONObject.optString("first_frame_video_decode_end");
                jSONObject.optString("first_frame_render_end");
                jSONObject.optLong("first_frame_render_end");
                jSONObject.optLong(TtmlNode.START);
            }
            com.bytedance.sdk.openadsdk.core.i.a.z((Context) z.this.fo.get(), z.this.m, z.this.ec, "pangle_live_sdk_monitor", jSONObject);
        }
    };
    private final uf.z yx = new uf.z() { // from class: com.bytedance.sdk.openadsdk.core.video.g.z.3
        @Override // com.bytedance.sdk.component.utils.uf.z
        public void z(Context context, Intent intent, boolean z, int i) {
            z.this.z(context, i);
        }
    };
    private boolean qd = false;
    private long zx = 0;
    private AtomicBoolean b = new AtomicBoolean(false);

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.video.g.z$z, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes2.dex */
    public interface InterfaceC0210z {
        void dl();

        void g();

        void z();

        void z(int i, String str);

        void z(long j, long j2);
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl
    public void a(boolean z) {
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.z
    public void gc(com.bykv.vk.openvk.component.video.api.a.g gVar, View view) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.z.z
    public boolean hh() {
        return true;
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl
    public boolean q() {
        return false;
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl
    public void z(dl.a aVar) {
    }

    protected abstract int zw();

    protected z(Context context, ViewGroup viewGroup, na naVar, com.bytedance.sdk.openadsdk.core.g.z zVar) {
        this.f = 1;
        this.f = v.dl(context);
        this.sy = viewGroup;
        this.fo = new WeakReference<>(context);
        this.m = naVar;
        this.x = zVar;
        z(context);
        this.gp = eo.fo(this.m);
        this.ec = eo.g(this.m);
    }

    private void z(Context context) {
        EnumSet enumSetNoneOf = EnumSet.noneOf(g.z.class);
        enumSetNoneOf.add(g.z.hideCloseBtn);
        enumSetNoneOf.add(g.z.hideBackBtn);
        this.gc = new m(context.getApplicationContext(), new LayoutVideoPlayLayoutForLive(context), true, enumSetNoneOf, this.m, this, this.x);
        this.gc.z((com.bykv.vk.openvk.component.video.api.a.z) this);
    }

    public void z(long j, boolean z) {
        if (this.q.z(2)) {
            return;
        }
        this.hh = j;
        uy(z);
        this.h = true;
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl
    public boolean z(com.bykv.vk.openvk.component.video.api.dl.a aVar) {
        if (aVar == null) {
            z("model is null");
            return false;
        }
        if (this.f1409a != null && this.f1409a.v()) {
            this.f1409a.g();
            return true;
        }
        this.iq = aVar;
        aVar.ls();
        if (TextUtils.isEmpty(aVar.ls())) {
            wp.a("BaseVideoController", "No video info");
            z("url is null");
            return false;
        }
        this.l = (aVar.ls().startsWith("http") || com.bytedance.sdk.openadsdk.core.video.dl.z.z(this.m)) ? false : true;
        this.p = aVar.kb();
        if (aVar.uy() > 0) {
            this.e = aVar.uy();
            this.gz = this.gz > this.e ? this.gz : this.e;
        }
        if (this.gc != null) {
            this.gc.z();
            m(8);
            this.gc.e();
            this.gc.dl(aVar.gz(), aVar.fo());
            this.gc.dl(this.sy);
        }
        try {
            if (this.f1409a == null) {
                if (!io()) {
                    z("create video error");
                    return false;
                }
                this.f1409a.z(this.lq);
            }
            sy();
            this.eo = 0L;
            a(aVar);
            return true;
        } catch (Throwable th) {
            z(th.getMessage());
            wp.a("BaseVideoController", "create video error:" + th.getMessage());
            return false;
        }
    }

    private boolean io() {
        com.bykv.vk.openvk.component.video.api.z aVar;
        na naVar = this.m;
        if (com.bytedance.sdk.openadsdk.gc.z.g(naVar)) {
            com.bykv.vk.openvk.component.video.api.renderview.g gVarRv = rv();
            if (gVarRv != null) {
                this.f1409a = new com.bytedance.sdk.openadsdk.upie.video.lottie.z(gVarRv, com.bytedance.sdk.openadsdk.gc.z.fo(naVar), new a(String.valueOf(eo.gz(this.m))), tf.p(naVar));
            } else {
                if (this.lq != null) {
                    this.lq.z((com.bykv.vk.openvk.component.video.api.z) null, new com.bykv.vk.openvk.component.video.api.dl.g(60008, AVMDLDataLoader.KeyIsStoIoWriteLimitKBTh2, "创建lottie播放器时，iRenderView为null, mediaLayout is null: " + (this.gc == null)));
                }
                wp.a("BaseVideoController", "[video] invoke NativeVideoController#playVideo error: iRenderView为null");
                return false;
            }
        } else if (com.bytedance.sdk.openadsdk.gc.z.dl(naVar)) {
            com.bykv.vk.openvk.component.video.api.renderview.g gVarRv2 = rv();
            if (gVarRv2 != null) {
                int iGz = eo.gz(this.m);
                if (gk.a() && this.iq.fv() == 1) {
                    aVar = new com.bytedance.sdk.component.wp.g.g(zw.getContext(), String.valueOf(iGz));
                } else {
                    aVar = new a(String.valueOf(iGz));
                }
                this.f1409a = new com.bytedance.sdk.openadsdk.upie.video.lottie.g(aVar, com.bytedance.sdk.openadsdk.gc.z.fo(naVar), gVarRv2);
            } else {
                if (this.lq != null) {
                    this.lq.z((com.bykv.vk.openvk.component.video.api.z) null, new com.bykv.vk.openvk.component.video.api.dl.g(60008, AVMDLDataLoader.KeyIsStoIoWriteLimitKBTh2, "创建Upie播放器时，iRenderView为null, mediaLayout is null: " + (this.gc == null)));
                }
                wp.a("BaseVideoController", "[video] invoke NativeVideoController#playVideo error: iRenderView为null");
                return false;
            }
        } else {
            int iGz2 = eo.gz(this.m);
            if (com.bytedance.sdk.openadsdk.core.video.dl.z.z(this.m)) {
                this.f1409a = new com.bytedance.sdk.component.wp.z.z(zw.getContext(), hh(), (long) tf.m(this.m), zw.g().yz(), null);
            } else if (gk.a() && this.iq.fv() == 1) {
                this.f1409a = new com.bytedance.sdk.component.wp.g.g(zw.getContext(), String.valueOf(iGz2));
            } else {
                this.f1409a = new a(String.valueOf(iGz2));
            }
        }
        return true;
    }

    public long gc(long j) {
        long jV = v();
        long jUn = (j - un()) + (jV * ((long) y()));
        long j2 = this.zx;
        if (jUn < j2) {
            return j2;
        }
        this.zx = jUn;
        return jUn;
    }

    public long t() {
        return this.zx;
    }

    public void vm() {
        if (this.m != null) {
            new z.C0178z().g("auto_replay").z(eo.g(this.m)).gc(this.m.mj()).a(this.m.vk()).z(new com.bytedance.sdk.openadsdk.m.z.z() { // from class: com.bytedance.sdk.openadsdk.core.video.g.z.4
                @Override // com.bytedance.sdk.openadsdk.m.z.z
                public void z(JSONObject jSONObject) throws JSONException {
                    com.bykv.vk.openvk.component.video.api.dl.dl dlVarUf;
                    JSONObject jSONObject2 = new JSONObject();
                    if (com.bytedance.sdk.openadsdk.hh.uy.z(z.this.m)) {
                        jSONObject2.put("is_audio", 1);
                    }
                    if (z.this.iq != null && (dlVarUf = z.this.iq.uf()) != null && dlVarUf.e() > 0.0d) {
                        jSONObject2.put(TtmlNode.START, dlVarUf.e());
                    }
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl
    public void g() {
        if (this.f1409a != null) {
            if (!gc()) {
                this.mc.getAndAdd(1);
                vm();
            }
            this.un.getAndAdd(1);
            if (!mc()) {
                this.q.z();
                j();
                z(0L, true);
            }
            dl(false);
            this.f1409a.z();
        }
    }

    public int y() {
        if (com.bytedance.sdk.openadsdk.hh.uy.z(this.m)) {
            return this.un.get();
        }
        return this.mc.get();
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl
    public boolean dl() {
        return this.mc.get() > 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.z.z, com.bykv.vk.openvk.component.video.api.a.dl
    public boolean a() {
        if (com.bytedance.sdk.openadsdk.hh.uy.z(this.m)) {
            return ((double) this.un.get()) <= ((double) tf.ls(this.m).e());
        }
        return super.a();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.z.z, com.bykv.vk.openvk.component.video.api.a.dl
    public boolean gc() {
        if (com.bytedance.sdk.openadsdk.hh.uy.z(this.m)) {
            return ((double) this.un.get()) < ((double) tf.ls(this.m).e());
        }
        return super.a();
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl
    public boolean iq() {
        return this.t;
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl
    public void gc(boolean z) {
        this.vm = z;
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl
    public int pf() {
        return com.bykv.vk.openvk.component.video.z.gc.z.z(this.gz, this.uf);
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl
    public void g(Map<String, Object> map) {
        this.gk = map;
    }

    private void a(com.bykv.vk.openvk.component.video.api.dl.a aVar) throws Exception {
        if (aVar == null) {
            z("model is null");
            return;
        }
        this.iq = aVar;
        final long jDl = dl(aVar);
        if (this.f1409a != null) {
            if (this.m != null) {
                aVar.a(String.valueOf(eo.fo(this.m)));
            }
            aVar.a(1);
            this.f1409a.z(aVar);
            this.f1409a.z(lq());
        }
        this.ti = System.currentTimeMillis();
        if (!TextUtils.isEmpty(aVar.ls())) {
            this.gc.gc(8);
            this.gc.gc(0);
            z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.g.z.5
                @Override // java.lang.Runnable
                public void run() {
                    if (z.this.q.a(1)) {
                        z.this.z("multi play_start");
                        return;
                    }
                    z.this.q.z();
                    if (!z.this.mc() || !z.this.yx()) {
                        z.this.j();
                    }
                    z.this.ti = System.currentTimeMillis();
                    z.this.gc.a(0);
                    if (z.this.f1409a == null || z.this.e != 0) {
                        if (z.this.f1409a != null) {
                            z.this.f1409a.z(true, z.this.e, z.this.p);
                            return;
                        }
                        return;
                    }
                    z.this.f1409a.z(true, jDl, z.this.p);
                }
            });
            return;
        }
        z("url is null");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void ec() {
        /*
            r5 = this;
            int r0 = r5.zw()
            r1 = 2
            if (r0 == r1) goto L20
            r1 = 1
            if (r0 == r1) goto L20
            r1 = 5
            if (r0 != r1) goto Le
            goto L20
        Le:
            r2 = 3
            if (r0 != r2) goto L2a
            com.bytedance.sdk.openadsdk.core.gk.uy r0 = com.bytedance.sdk.openadsdk.core.zw.g()
            int r1 = r5.gp
            java.lang.String r1 = java.lang.String.valueOf(r1)
            int r1 = r0.fo(r1)
            goto L2a
        L20:
            com.bytedance.sdk.openadsdk.core.gk.uy r0 = com.bytedance.sdk.openadsdk.core.zw.g()
            int r0 = r0.c()
            int r1 = r0 * 1000
        L2a:
            com.bytedance.sdk.component.utils.l r0 = r5.z
            java.lang.Runnable r2 = r5.wj
            r0.removeCallbacks(r2)
            com.bytedance.sdk.component.utils.l r0 = r5.z
            java.lang.Runnable r2 = r5.wj
            long r3 = (long) r1
            r0.postDelayed(r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.video.g.z.ec():void");
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl
    public void z(dl.g gVar) {
        this.j = new WeakReference<>(gVar);
    }

    protected void m(boolean z) {
        if (l() && this.gc != null) {
            this.z.removeCallbacks(this.wj);
            m(0);
            this.gc.g();
            this.eo = System.currentTimeMillis() - this.ti;
            this.gc.gc(true);
            if (eo.m(this.m)) {
                this.gc.z(this.m, this.fo, true);
            } else {
                this.gc.sy();
            }
            e(z);
            if (!z) {
                this.b.set(true);
            }
            dl.z zVar = this.oq;
            if (zVar != null) {
                zVar.z(this.eo, com.bykv.vk.openvk.component.video.z.gc.z.z(this.e, this.uf));
            }
            kb(z);
            this.js = true;
        }
    }

    private void e(boolean z) {
        if (!this.q.z(64) || dl() || a()) {
            this.q.dl(64);
            if (!mc() || this.m == null) {
                long j = this.uf;
                dl(j, j);
                long j2 = this.uf;
                this.e = j2;
                this.gz = j2;
                na();
                return;
            }
            if (z) {
                na();
                if (this.m.d() != 8) {
                    this.q.z();
                    j();
                    z(0L, true);
                    return;
                }
                return;
            }
            long j3 = this.uf;
            dl(j3, j3);
            long j4 = this.uf;
            this.e = j4;
            this.gz = j4;
        }
    }

    private void kb(boolean z) {
        if (this.na != null) {
            if (!mc() || z) {
                this.na.z();
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl
    public void z(dl.z zVar) {
        this.oq = zVar;
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl
    public void m() {
        if (this.f1409a != null) {
            this.f1409a.dl();
        }
        if (!this.q.z(64) || dl() || a()) {
            if (this.q.z(2) || com.bytedance.sdk.openadsdk.hh.uy.z(this.m)) {
                dl((Map<String, Object>) null);
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl
    public void z(Map<String, Object> map) {
        if (this.f1409a != null) {
            this.f1409a.dl();
        }
        if (!this.q.z(64) || dl() || a()) {
            if (this.q.z(2) || com.bytedance.sdk.openadsdk.hh.uy.z(this.m)) {
                dl(map);
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl
    public void e() {
        if (this.f1409a != null) {
            this.f1409a.dl();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl
    public void gz() {
        if (this.gc != null) {
            this.gc.z();
            this.gc.tb();
            this.gc.io();
        }
        wp.z("BaseVideoController", "resumeVideo:  mIsSurfaceValid = ", Boolean.valueOf(this.uy));
        if (this.f1409a != null) {
            if (this.f1409a.v()) {
                if (this.uy || ((this.iq != null && this.iq.e()) || com.bytedance.sdk.openadsdk.gc.z.g(this.m))) {
                    eo();
                } else {
                    g(this.io);
                }
                wp.z("BaseVideoController", "resumeVideo: isPaused = true , mIsSurfaceValid = ", Boolean.valueOf(this.uy));
            } else {
                this.f1409a.z(false, this.e, this.p);
            }
        }
        if (!this.q.z(64) || dl() || a()) {
            if (this.q.z(2) || com.bytedance.sdk.openadsdk.hh.uy.z(this.m)) {
                xl();
            }
        }
    }

    public void bv() {
        if (!this.q.z(64) || dl() || a()) {
            if (this.q.z(2) || com.bytedance.sdk.openadsdk.hh.uy.z(this.m)) {
                xl();
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl
    public void z(long j) {
        this.e = Math.max(j, p().js());
        this.gz = Math.max(this.gz, kb());
        if (this.gc != null) {
            this.gc.z();
        }
        if (this.f1409a != null) {
            this.f1409a.z(false, this.e, this.p);
            this.f1409a.z(this.e);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl
    public void fo() {
        if (this.f1409a != null) {
            this.f1409a.gc();
            this.f1409a = null;
        }
        if (this.gc != null) {
            this.gc.fo();
        }
        this.z.removeCallbacks(this.wj);
        this.z.removeCallbacksAndMessages(null);
        this.oq = null;
        this.na = null;
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl
    public void z(boolean z, int i) {
        dl(i);
        fo();
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl
    public void uy() {
        dl(-1);
        fo();
    }

    protected boolean v_() {
        return this.m == null || this.m.tk() == 100.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(int i, int i2) {
        ViewGroup viewGroup;
        try {
            if (rv() != null && this.f1409a != null && (viewGroup = this.sy) != null) {
                float f = i;
                float f2 = i2;
                float width = viewGroup.getWidth();
                float f3 = f / (width * 1.0f);
                float height = this.sy.getHeight();
                if (f3 <= f2 / (height * 1.0f)) {
                    width = f * (height / (f2 * 1.0f));
                } else {
                    height = f2 * (width / (f * 1.0f));
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) width, (int) height);
                layoutParams.addRule(13);
                Object objRv = rv();
                if (objRv instanceof TextureView) {
                    ((TextureView) objRv).setLayoutParams(layoutParams);
                } else if (objRv instanceof UpieVideoView) {
                    ((UpieVideoView) objRv).setLayoutParams(layoutParams);
                }
            }
        } catch (Throwable th) {
            wp.dl("changeVideoSize", "changeVideoSizeSupportInteraction error", th);
        }
    }

    private boolean lw() throws Throwable {
        return this.fo == null || this.fo.get() == null || rv() == null || this.f1409a == null || this.m == null || vm.m(this.m) != null || vm.e(this.m) != null || this.m.b() == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i, int i2) {
        try {
            if (this.fo != null && this.fo.get() != null && rv() != null && this.f1409a != null && this.m != null) {
                int[] iArrG = oq.g(zw.getContext());
                boolean z = this.m.zr() == 1;
                float f = iArrG[0];
                float f2 = iArrG[1];
                float f3 = i;
                float f4 = i2;
                if (z) {
                    if (f3 > f4) {
                        z(f, f2, f3, f4, true);
                        return;
                    }
                    f2 = (f4 * f) / f3;
                } else {
                    if (f3 < f4) {
                        z(f, f2, f3, f4, false);
                        return;
                    }
                    f = (f3 * f2) / f4;
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) f, (int) f2);
                layoutParams.addRule(13);
                if (this.sy != null) {
                    Object objRv = rv();
                    if (objRv instanceof TextureView) {
                        ((TextureView) objRv).setLayoutParams(layoutParams);
                    } else if (objRv instanceof UpieVideoView) {
                        ((UpieVideoView) objRv).setLayoutParams(layoutParams);
                    }
                }
            }
        } catch (Throwable th) {
            wp.dl("changeVideoSize", "changeVideoSizeByWidth error", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dl(int i, int i2) {
        try {
            wp.z("changeVideoSize", "changeVideoSize start.......mMaterialMeta.getAdSlot()=" + this.m.lw());
            if (lw()) {
                return;
            }
            wp.z("changeVideoSize", "changeVideoSize start check condition complete ... go ..");
            int[] iArrG = oq.g(zw.getContext());
            boolean z = false;
            boolean z2 = this.m.zr() == 1;
            float f = iArrG[0];
            float f2 = iArrG[1];
            float f3 = i;
            float f4 = i2;
            if (z2) {
                if (f3 > f4) {
                    z(f, f2, f3, f4, true);
                    return;
                }
            } else if (f3 < f4) {
                z(f, f2, f3, f4, false);
                return;
            }
            float f5 = f3 / f4;
            float f6 = f / f2;
            if (z2) {
                if (f6 < 0.5625f && f5 == 0.5625f) {
                    f3 = (9.0f * f2) / 16.0f;
                    z = true;
                    f4 = f2;
                }
            } else if (f6 > 1.7777778f && f5 == 1.7777778f) {
                f4 = (9.0f * f) / 16.0f;
                z = true;
                f3 = f;
            }
            wp.z("changeVideoSize", "适配后宽高：videoHeight=" + f4 + ",videoWidth=" + f3);
            if (z) {
                f = f3;
                f2 = f4;
            } else {
                wp.z("changeVideoSize", " 屏幕比例和视频比例相同，以及其他情况都按照屏幕宽高播放，videoHeight=" + f2 + "，videoWidth=" + f);
            }
            int i3 = (int) f;
            int i4 = (int) f2;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i3, i4);
            layoutParams.addRule(13);
            Object objRv = rv();
            if ((objRv instanceof TextureView) || (objRv instanceof UpieVideoView)) {
                if (objRv instanceof TextureView) {
                    ((TextureView) objRv).setLayoutParams(layoutParams);
                } else {
                    ((UpieVideoView) objRv).setLayoutParams(layoutParams);
                }
                ViewGroup.LayoutParams layoutParams2 = this.sy.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2.height = i4;
                    layoutParams2.width = i3;
                    this.sy.setLayoutParams(layoutParams2);
                }
            }
        } catch (Throwable th) {
            wp.dl("changeVideoSize", "changeSize error", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        try {
            if (this.fo != null && this.fo.get() != null && rv() != null && this.f1409a != null && this.m != null) {
                boolean z = this.m.zr() == 1;
                int[] iArrG = oq.g(zw.getContext());
                z(iArrG[0], iArrG[1], i, i2, z);
            }
        } catch (Throwable unused) {
        }
    }

    private void z(float f, float f2, float f3, float f4, boolean z) {
        RelativeLayout.LayoutParams layoutParams;
        if (f3 <= 0.0f || f4 <= 0.0f) {
            try {
                f3 = tf.a(this.m);
                f4 = tf.dl(this.m);
            } catch (Throwable unused) {
                return;
            }
        }
        if (f4 > 0.0f && f3 > 0.0f) {
            if (z) {
                if (f3 < f4) {
                    return;
                }
                layoutParams = new RelativeLayout.LayoutParams((int) f, (int) ((f4 * f) / f3));
            } else if (f3 > f4) {
                return;
            } else {
                layoutParams = new RelativeLayout.LayoutParams((int) ((f3 * f2) / f4), (int) f2);
            }
            layoutParams.addRule(13);
            Object objRv = rv();
            if (objRv instanceof TextureView) {
                ((TextureView) objRv).setLayoutParams(layoutParams);
            } else if (objRv instanceof UpieVideoView) {
                ((UpieVideoView) objRv).setLayoutParams(layoutParams);
            }
            this.bv = true;
        }
    }

    public boolean gb() {
        return this.bv;
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.z
    public void z(com.bykv.vk.openvk.component.video.api.a.g gVar, View view) {
        if (this.f1409a == null || !l()) {
            return;
        }
        if (this.f1409a.i()) {
            m();
            this.gc.g(true, false);
            this.gc.m();
        } else {
            if (!this.f1409a.v()) {
                if (this.gc != null) {
                    this.gc.dl(this.sy);
                }
                z(this.e);
                if (this.gc != null) {
                    this.gc.g(false, false);
                    return;
                }
                return;
            }
            gz();
            if (this.gc != null) {
                this.gc.g(false, false);
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.z
    public void z(com.bykv.vk.openvk.component.video.api.a.g gVar, int i) {
        if (this.f1409a == null) {
            return;
        }
        g(this.sv, e(i));
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.z
    public void g(com.bykv.vk.openvk.component.video.api.a.g gVar, int i) {
        if (this.gc != null) {
            this.gc.m();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.z
    public void z(com.bykv.vk.openvk.component.video.api.a.g gVar, int i, boolean z) {
        if (l()) {
            long j = (long) (((((long) i) * r0) * 1.0f) / 100.0f);
            if (this.uf > 0) {
                this.sv = (int) j;
            } else {
                this.sv = 0L;
            }
            if (this.gc != null) {
                this.gc.z(this.sv);
            }
        }
    }

    public boolean jq() {
        return this.b.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dl(long j, long j2) {
        this.e = j;
        this.uf = j2;
        this.gc.z(j, j2);
        int iZ = com.bykv.vk.openvk.component.video.z.gc.z.z(j, j2);
        if (dl() || a()) {
            this.gc.g(100);
        } else {
            this.gc.g(iZ);
        }
        a(j, j2);
        try {
            dl.z zVar = this.oq;
            if (zVar != null) {
                zVar.z(j, j2);
            }
            InterfaceC0210z interfaceC0210z = this.na;
            if (interfaceC0210z != null) {
                interfaceC0210z.z(j, j2);
            }
        } catch (Throwable th) {
            wp.dl("BaseVideoController", "onProgressUpdate error: ", th);
        }
    }

    private void a(long j, long j2) {
        if (mc()) {
            final int iD = this.m.d();
            if (g(iD)) {
                long jUn = un();
                if (qd() && j >= jUn - 200 && this.b.get() && Math.abs(j - j2) > 200) {
                    this.b.set(false);
                    this.z.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.g.z.6
                        @Override // java.lang.Runnable
                        public void run() {
                            z.this.m(true);
                            if (iD == 8) {
                                z.this.p().a();
                            }
                        }
                    });
                }
            }
        }
        gc(j);
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.z
    public void g(com.bykv.vk.openvk.component.video.api.a.g gVar, View view) {
        g(gVar, view, false, false);
    }

    public void g(com.bykv.vk.openvk.component.video.api.a.g gVar, View view, boolean z, boolean z2) {
        if (l()) {
            fo(!this.tb);
            if (this.fo.get() instanceof Activity) {
                if (this.tb) {
                    gc(z ? 8 : 0);
                    if (this.gc != null) {
                        this.gc.z(this.sy);
                        this.gc.dl(false);
                    }
                } else {
                    gc(1);
                    if (this.gc != null) {
                        this.gc.g(this.sy);
                        this.gc.dl(false);
                    }
                }
                WeakReference<dl.g> weakReference = this.j;
                dl.g gVar2 = weakReference != null ? weakReference.get() : null;
                if (gVar2 != null) {
                    gVar2.z(this.tb);
                }
            }
        }
    }

    public void gc(int i) {
        if (l()) {
            boolean z = i == 0 || i == 8;
            Context context = this.fo.get();
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                try {
                    activity.setRequestedOrientation(i);
                } catch (Throwable unused) {
                }
                if (!z) {
                    activity.getWindow().setFlags(1024, 1024);
                } else {
                    activity.getWindow().clearFlags(1024);
                }
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.z
    public void dl(com.bykv.vk.openvk.component.video.api.a.g gVar, View view) {
        if (this.gc != null) {
            this.gc.fo();
        }
        z(1);
        z(true, 3);
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.z
    public void z(com.bykv.vk.openvk.component.video.api.a.g gVar, View view, boolean z, boolean z2) {
        if (this.wp) {
            m();
        }
        if (z && !this.wp && !sv()) {
            this.gc.g(!f(), false);
            this.gc.z(z2, true, false);
        }
        if (this.f1409a != null && this.f1409a.i()) {
            this.gc.m();
            this.gc.gc();
        } else {
            this.gc.m();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.z
    public void a(com.bykv.vk.openvk.component.video.api.a.g gVar, View view) {
        if (this.tb) {
            fo(false);
            if (this.gc != null) {
                this.gc.g(this.sy);
            }
            gc(1);
            return;
        }
        z(1);
        z(true, 3);
    }

    private com.bykv.vk.openvk.component.video.api.renderview.g rv() {
        if (this.fo == null || this.fo.get() == null || this.gc == null) {
            return null;
        }
        return this.gc.p();
    }

    public boolean sv() {
        return this.f1409a.fo();
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.z
    public void z() {
        if (this.gc != null) {
            this.gc.gc();
            this.gc.z();
        }
        if (this.gc != null) {
            this.gc.io();
        }
        z(-1L);
    }

    public boolean f() {
        return this.f1409a != null && this.f1409a.i();
    }

    private void g(long j, boolean z) {
        if (this.f1409a == null) {
            return;
        }
        if (z) {
            tc();
        }
        this.f1409a.z(j);
    }

    private boolean e(int i) {
        return this.gc.dl(i);
    }

    public boolean yx() {
        boolean zDl = dl();
        if (!zDl || y() >= 2) {
            return zDl;
        }
        return this.zx >= v() - 400;
    }

    public boolean qd() {
        if (mc()) {
            return yx();
        }
        return dl();
    }

    private void tc() {
        if (this.gc != null) {
            this.gc.a(0);
            this.gc.z(false, false);
            this.gc.dl(false);
            this.gc.gc();
            m(8);
            this.gc.e();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.video.g.z$9, reason: invalid class name */
    /* JADX INFO: loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass9 {
        static final /* synthetic */ int[] z;

        static {
            int[] iArr = new int[pf.z.values().length];
            z = iArr;
            try {
                iArr[pf.z.PAUSE_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                z[pf.z.RELEASE_VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                z[pf.z.START_VIDEO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.g
    public void z(pf.z zVar, String str) {
        int i = AnonymousClass9.z[zVar.ordinal()];
        if (i == 1) {
            m();
            return;
        }
        if (i == 2) {
            z(true, 3);
        } else {
            if (i != 3) {
                return;
            }
            gz();
            this.pf = false;
            this.xl = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean gz(int i) {
        int iDl = v.dl(zw.getContext());
        if (iDl != 4 && iDl != 0) {
            m();
            this.pf = true;
            this.xl = false;
            if (this.gc != null && this.m != null) {
                return this.gc.z(i, tf.v(this.m), true);
            }
        } else if (iDl == 4) {
            this.pf = false;
            if (this.gc != null) {
                this.gc.tb();
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(Context context, int i) {
        if (l() && this.f != i) {
            if (!this.xl) {
                gz.g().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.g.z.7
                    @Override // java.lang.Runnable
                    public void run() {
                        z.this.gz(2);
                    }
                });
            }
            this.f = i;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl
    public void z(int i) {
        if (com.bytedance.sdk.openadsdk.core.video.dl.z.z(this.m)) {
            int iZw = zw();
            long jCurrentTimeMillis = System.currentTimeMillis() - this.y;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("close_reason", Integer.valueOf(i));
                jSONObject.putOpt("buffer_count", Integer.valueOf(i()));
                jSONObject.putOpt("buffer_time", Long.valueOf(wp()));
            } catch (Exception e) {
                wp.z(e);
            }
            if (!this.q.z(512)) {
                this.q.dl(512);
                if (iZw == 1) {
                    com.bytedance.sdk.openadsdk.core.i.a.z(this.m, "rewarded_video", jCurrentTimeMillis, jSONObject, com.bytedance.sdk.openadsdk.m.g.a.z(this.gc));
                } else if (iZw == 2) {
                    com.bytedance.sdk.openadsdk.core.i.a.z(this.m, "fullscreen_interstitial_ad", jCurrentTimeMillis, jSONObject, com.bytedance.sdk.openadsdk.m.g.a.z(this.gc));
                }
            }
            if (com.bytedance.sdk.openadsdk.core.video.dl.z.z(this.m)) {
                if (com.bytedance.sdk.openadsdk.core.live.g.z().z(this.m)) {
                    com.bytedance.sdk.openadsdk.core.live.g.z().z(LiveMetrics.EVENT_LIVESDK_LIVE_WINDOW_DURATION_V2, this.m, jCurrentTimeMillis);
                } else {
                    com.bytedance.sdk.openadsdk.core.video.dl.z.z(LiveMetrics.EVENT_LIVESDK_LIVE_WINDOW_DURATION_V2, this.m, jCurrentTimeMillis);
                }
            }
        }
    }

    protected void m(int i) {
        Object obj;
        if (this.fo == null || !com.bytedance.sdk.openadsdk.core.video.dl.z.z(this.m) || this.fo.get() == null || (obj = (Context) this.fo.get()) == null || !(obj instanceof com.bytedance.sdk.openadsdk.core.gz.g)) {
            return;
        }
        ((com.bytedance.sdk.openadsdk.core.gz.g) obj).z(i == 0);
    }

    protected void zx() {
        if (com.bytedance.sdk.openadsdk.core.video.dl.z.z(this.m)) {
            int iZw = zw();
            boolean z = this.q.z(1024);
            long jLongValue = this.q.g(1).longValue();
            if (z) {
                return;
            }
            this.q.dl(1024);
            if (iZw == 1) {
                com.bytedance.sdk.openadsdk.core.i.a.z(this.m, "rewarded_video", System.currentTimeMillis() - jLongValue, com.bytedance.sdk.openadsdk.m.g.a.z(this.gc));
            } else if (iZw == 2) {
                com.bytedance.sdk.openadsdk.core.i.a.z(this.m, "fullscreen_interstitial_ad", System.currentTimeMillis() - jLongValue, com.bytedance.sdk.openadsdk.m.g.a.z(this.gc));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(int i, String str) {
        if (com.bytedance.sdk.openadsdk.core.video.dl.z.z(this.m)) {
            int iZw = zw();
            if (iZw == 1) {
                com.bytedance.sdk.openadsdk.core.i.a.z(this.m, "rewarded_video", i, str, com.bytedance.sdk.openadsdk.m.g.a.z(this.gc));
            } else if (iZw == 2) {
                com.bytedance.sdk.openadsdk.core.i.a.z(this.m, "fullscreen_interstitial_ad", i, str, com.bytedance.sdk.openadsdk.m.g.a.z(this.gc));
            }
        }
    }

    public void b() {
        this.z.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.g.z.8
            @Override // java.lang.Runnable
            public void run() {
                if (!js.a(z.this.m) && z.this.v_()) {
                    if (com.bytedance.sdk.openadsdk.core.video.dl.z.z(z.this.m) && z.this.m.zr() == 2 && z.this.v_()) {
                        return;
                    }
                    if (z.this.v_()) {
                        if (z.this.m == null || z.this.m.qd() != 0) {
                            if (z.this.m != null && z.this.m.qd() == 2) {
                                z zVar = z.this;
                                zVar.g(zVar.gb, z.this.jq);
                                return;
                            } else {
                                z zVar2 = z.this;
                                zVar2.dl(zVar2.gb, z.this.jq);
                                return;
                            }
                        }
                        z zVar3 = z.this;
                        zVar3.a(zVar3.gb, z.this.jq);
                        return;
                    }
                    z zVar4 = z.this;
                    zVar4.z(zVar4.gb, z.this.jq);
                    return;
                }
                z zVar5 = z.this;
                zVar5.z(zVar5.gb, z.this.jq);
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl
    public int i() {
        if (this.f1409a == null) {
            return 0;
        }
        return this.f1409a.p();
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl
    public void g(com.bykv.vk.openvk.component.video.api.dl.a aVar) {
        this.iq = aVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.z.z
    protected Map<String, Object> gp() {
        HashMap map = new HashMap();
        Map<String, Object> map2 = this.gk;
        if (map2 != null) {
            for (Map.Entry<String, Object> entry : map2.entrySet()) {
                map.put(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry<String, Object> entry2 : eo.z(this.hh, this.m, p()).entrySet()) {
            map.put(entry2.getKey(), entry2.getValue());
        }
        return map;
    }

    public void z(InterfaceC0210z interfaceC0210z) {
        this.na = interfaceC0210z;
    }
}
