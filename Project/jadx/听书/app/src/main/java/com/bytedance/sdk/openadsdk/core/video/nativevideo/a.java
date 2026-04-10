package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.component.video.api.a.dl;
import com.bykv.vk.openvk.component.video.api.a.g;
import com.bykv.vk.openvk.component.video.api.z;
import com.bytedance.android.metrics.LiveMetrics;
import com.bytedance.sdk.component.utils.gz;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.component.utils.uf;
import com.bytedance.sdk.component.utils.v;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.gk;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.tc;
import com.bytedance.sdk.openadsdk.core.iq.tf;
import com.bytedance.sdk.openadsdk.core.multipro.g.z;
import com.bytedance.sdk.openadsdk.core.ti;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.widget.pf;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.hh.uy;
import com.bytedance.sdk.openadsdk.ls.dl.g.i;
import com.bytedance.sdk.openadsdk.m.dl.p;
import com.bytedance.sdk.openadsdk.res.layout.TTViewStub;
import com.bytedance.sdk.openadsdk.res.layout.video.LayoutVideoDetail;
import com.bytedance.sdk.openadsdk.upie.video.lottie.UpieVideoView;
import com.bytedance.sdk.openadsdk.widget.TTProgressBar;
import java.lang.ref.WeakReference;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class a extends com.bytedance.sdk.openadsdk.core.video.z.z {
    private int bv;
    private long ec;
    private long f;
    private Map<String, Object> gb;
    private final boolean gk;
    private int gp;
    private dl.z h;
    private int j;
    private boolean lq;
    private boolean mc;
    private WeakReference<dl.a> na;
    private int qd;
    private ViewGroup sy;
    private WeakReference<dl.g> un;
    private String x;
    private WeakReference<z> xl;
    private long hh = 0;
    private long l = 0;
    private boolean ti = false;
    private boolean eo = false;
    private boolean oq = true;
    private volatile boolean wj = false;
    private int t = 0;
    private boolean vm = false;
    private boolean y = true;
    private z.InterfaceC0029z jq = new z.InterfaceC0029z() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.a.1
        @Override // com.bykv.vk.openvk.component.video.api.z.InterfaceC0029z
        public void g(com.bykv.vk.openvk.component.video.api.z zVar, int i) {
        }

        @Override // com.bykv.vk.openvk.component.video.api.z.InterfaceC0029z
        public void z(com.bykv.vk.openvk.component.video.api.z zVar) {
            a.this.z.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.a.1.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.bv();
                }
            });
            a.this.z(4);
            a.this.dl(4);
        }

        @Override // com.bykv.vk.openvk.component.video.api.z.InterfaceC0029z
        public void z(com.bykv.vk.openvk.component.video.api.z zVar, long j) {
            a.this.z.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.a.1.2
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.gc != null) {
                        if (!a.this.qd() || !zw.g().dt()) {
                            a.this.gc.g();
                        } else {
                            a.this.gc.hh();
                        }
                        a.this.z.removeCallbacks(a.this.uf);
                        a.this.vm = false;
                    }
                    if (a.this.xl != null && a.this.xl.get() != null) {
                        ((z) a.this.xl.get()).C_();
                    }
                    a.this.z.removeCallbacks(a.this.uf);
                }
            });
            a.this.yx();
            a.this.ec = System.currentTimeMillis();
            a.this.me();
        }

        @Override // com.bykv.vk.openvk.component.video.api.z.InterfaceC0029z
        public void g(com.bykv.vk.openvk.component.video.api.z zVar) {
            if (!a.this.gk || uy.z(a.this.m)) {
                a.this.yx();
            }
            a.this.z.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.a.1.3
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.na != null && a.this.na.get() != null) {
                        ((dl.a) a.this.na.get()).p_();
                    }
                    if (a.this.gc != null && (!a.this.qd() || !zw.g().dt())) {
                        a.this.gc.g();
                    }
                    a.this.z.removeCallbacks(a.this.uf);
                }
            });
        }

        @Override // com.bykv.vk.openvk.component.video.api.z.InterfaceC0029z
        public void z(com.bykv.vk.openvk.component.video.api.z zVar, final com.bykv.vk.openvk.component.video.api.dl.g gVar) {
            a.this.z.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.a.1.4
                /* JADX WARN: Removed duplicated region for block: B:27:0x00d9  */
                /* JADX WARN: Removed duplicated region for block: B:30:0x00ee  */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void run() {
                    /*
                        Method dump skipped, instruction units count: 329
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.video.nativevideo.a.AnonymousClass1.AnonymousClass4.run():void");
                }
            });
            a.this.z(gVar.z(), gVar.dl());
        }

        @Override // com.bykv.vk.openvk.component.video.api.z.InterfaceC0029z
        public void z(com.bykv.vk.openvk.component.video.api.z zVar, boolean z2) {
            a.this.z.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.a.1.5
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.gc != null) {
                        a.this.gc.g();
                    }
                }
            });
        }

        @Override // com.bykv.vk.openvk.component.video.api.z.InterfaceC0029z
        public void dl(com.bykv.vk.openvk.component.video.api.z zVar) {
            a.this.rv();
        }

        @Override // com.bykv.vk.openvk.component.video.api.z.InterfaceC0029z
        public void z(com.bykv.vk.openvk.component.video.api.z zVar, final int i, final int i2) {
            a.this.z.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.a.1.6
                @Override // java.lang.Runnable
                public void run() {
                    a.this.g(i, i2);
                }
            });
        }

        @Override // com.bykv.vk.openvk.component.video.api.z.InterfaceC0029z
        public void z(com.bykv.vk.openvk.component.video.api.z zVar, int i, int i2, int i3) {
            a.this.z.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.a.1.7
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.gc != null) {
                        a.this.gc.zw();
                        a.this.z.postDelayed(a.this.uf, 8000L);
                        a.this.vm = true;
                    }
                }
            });
        }

        @Override // com.bykv.vk.openvk.component.video.api.z.InterfaceC0029z
        public void z(com.bykv.vk.openvk.component.video.api.z zVar, int i) {
            a.this.z.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.a.1.8
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.gc != null) {
                        a.this.gc.g();
                    }
                    a.this.z.removeCallbacks(a.this.uf);
                    a.this.vm = false;
                }
            });
        }

        @Override // com.bykv.vk.openvk.component.video.api.z.InterfaceC0029z
        public void z(com.bykv.vk.openvk.component.video.api.z zVar, final long j, final long j2) {
            if (Math.abs(j - a.this.e) < 50) {
                return;
            }
            a.this.z.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.a.1.9
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.zw != null) {
                        a.this.zw.z(j, j2);
                    }
                    a.this.g(j, j2);
                    a.this.dl(j, j2);
                }
            });
        }

        @Override // com.bykv.vk.openvk.component.video.api.z.InterfaceC0029z
        public void z(com.bykv.vk.openvk.component.video.api.z zVar, JSONObject jSONObject, String str) {
            if (com.bytedance.sdk.openadsdk.core.uy.ls().t()) {
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
            com.bytedance.sdk.openadsdk.core.i.a.z((Context) a.this.fo.get(), a.this.m, a.this.x, "pangle_live_sdk_monitor", jSONObject);
        }
    };
    private int sv = 0;
    Runnable uf = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.a.4
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.gc != null) {
                a.this.gc.z(a.this.m, a.this.fo, false);
                a.this.gc.g();
                a.this.dl(true);
                wp.a("NativeVideoController", "出错后展示结果页、、、、、、、showAdCard");
            }
        }
    };
    private final uf.z yx = new uf.z() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.a.6
        @Override // com.bytedance.sdk.component.utils.uf.z
        public void z(Context context, Intent intent, boolean z2, int i) {
            a.this.dl(context, i);
        }
    };
    private boolean zx = false;

    /* JADX INFO: loaded from: classes2.dex */
    public interface z {
        void C_();

        void fo();

        void z(int i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, int i2) {
        boolean z2 = i == -1010 || i == -1007 || i == -1004 || i == -110 || i == 100 || i == 200 || i == 60008;
        if (i2 == 1 || i2 == 700 || i2 == 800) {
            return true;
        }
        return z2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.z.z, com.bykv.vk.openvk.component.video.api.a.dl
    public boolean a() {
        return false;
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl
    public boolean dl() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.z.z, com.bykv.vk.openvk.component.video.api.a.dl
    public boolean gc() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.z.z
    public boolean hh() {
        return true;
    }

    public void gc(int i) {
        this.bv = i;
    }

    public void z(na naVar) {
        this.m = naVar;
    }

    public void z(com.bytedance.sdk.openadsdk.q.z.g.z.z zVar) {
        if (this.gc != null) {
            this.gc.z(zVar);
        }
    }

    public void z(final NativeVideoTsView.z zVar) {
        if (!this.wp || this.gc == null) {
            return;
        }
        this.gc.z(new NativeVideoTsView.z() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.a.2
            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.z
            public void z(View view, int i) {
                NativeVideoTsView.z zVar2 = zVar;
                if (zVar2 != null) {
                    zVar2.z(view, i);
                }
            }
        });
    }

    public void z(i iVar) {
        if (!this.wp || this.gc == null) {
            return;
        }
        this.gc.z(iVar);
    }

    public void z(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return;
        }
        this.j = i;
        this.gp = i2;
    }

    private void z(Context context) {
        EnumSet<g.z> enumSetNoneOf = EnumSet.noneOf(g.z.class);
        enumSetNoneOf.add(g.z.hideCloseBtn);
        enumSetNoneOf.add(g.z.hideBackBtn);
        try {
            this.gc = z(context, enumSetNoneOf);
            if (this.gc != null) {
                this.gc.z((com.bykv.vk.openvk.component.video.api.a.z) this);
                this.gc.z((z.InterfaceC0190z) this);
            }
        } catch (Throwable th) {
            wp.a("NativeVideoController", th.getMessage());
        }
    }

    protected m z(Context context, EnumSet<g.z> enumSet) {
        View layoutVideoDetail;
        if (this.wp) {
            layoutVideoDetail = g(context);
        } else {
            layoutVideoDetail = new LayoutVideoDetail(context);
        }
        View view = layoutVideoDetail;
        if (view == null) {
            return null;
        }
        if (this.wp) {
            return new m(context, view, true, enumSet, this.m, this, wj(), null);
        }
        return new gc(context, view, true, enumSet, this.m, this, false);
    }

    private View g(Context context) {
        Resources resources = context.getResources();
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(2114387714);
        relativeLayout.setBackgroundColor(-16777216);
        RelativeLayout relativeLayout2 = new RelativeLayout(context);
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        relativeLayout2.setId(2114387900);
        relativeLayout2.setBackgroundColor(0);
        relativeLayout2.setGravity(17);
        relativeLayout2.setLayoutParams(layoutParams);
        relativeLayout.addView(relativeLayout2);
        ImageView imageView = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        imageView.setId(2114387651);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setLayoutParams(layoutParams2);
        relativeLayout2.addView(imageView);
        TTProgressBar tTProgressBar = new TTProgressBar(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()));
        tTProgressBar.setId(2114387631);
        layoutParams3.addRule(13, -1);
        tTProgressBar.setLayoutParams(layoutParams3);
        tTProgressBar.setIndeterminateDrawable(tb.dl(context, "tt_video_loading_progress_bar"));
        relativeLayout2.addView(tTProgressBar);
        View viewG = new com.bytedance.sdk.openadsdk.res.layout.video.a().g(context);
        viewG.setId(2114387688);
        viewG.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        relativeLayout.addView(viewG);
        ImageView imageView2 = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        imageView2.setId(2114387626);
        layoutParams4.addRule(13, -1);
        imageView2.setScaleType(ImageView.ScaleType.CENTER);
        tb.z(context, "tt_play_movebar_textpage", imageView2);
        imageView2.setVisibility(8);
        imageView2.setLayoutParams(layoutParams4);
        relativeLayout.addView(imageView2);
        TTProgressBar tTProgressBar2 = new TTProgressBar(context, null, tb.gz(context, "tt_Widget_ProgressBar_Horizontal"));
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 1.5f, resources.getDisplayMetrics()));
        tTProgressBar2.setMax(100);
        tTProgressBar2.setId(2114387653);
        tTProgressBar2.setBackgroundColor(0);
        tTProgressBar2.setIndeterminateDrawable(null);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#A5FFFFFF"));
        float fDl = oq.dl(context, 1.0f);
        gradientDrawable.setCornerRadius(fDl);
        int iDl = oq.dl(context, 2.0f);
        gradientDrawable.setSize(-1, iDl);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(Color.parseColor("#FFFFFFFF"));
        gradientDrawable2.setCornerRadius(fDl);
        gradientDrawable2.setSize(-1, iDl);
        ClipDrawable clipDrawable = new ClipDrawable(gradientDrawable2, 3, 1);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setColor(Color.parseColor("#FFF85959"));
        gradientDrawable3.setCornerRadius(fDl);
        gradientDrawable3.setSize(-1, iDl);
        tTProgressBar2.setProgressDrawable(new LayerDrawable(new Drawable[]{gradientDrawable, clipDrawable, new ClipDrawable(gradientDrawable3, 3, 1)}));
        tTProgressBar2.setVisibility(8);
        layoutParams5.addRule(12, -1);
        tTProgressBar2.setLayoutParams(layoutParams5);
        relativeLayout.addView(tTProgressBar2);
        TTViewStub tTViewStub = new TTViewStub(context, new com.bytedance.sdk.openadsdk.res.layout.video.m());
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, -1);
        tTViewStub.setId(2114387744);
        tTViewStub.setLayoutParams(layoutParams6);
        relativeLayout.addView(tTViewStub);
        TTViewStub tTViewStub2 = new TTViewStub(context, new com.bytedance.sdk.openadsdk.res.layout.video.g());
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, -1);
        tTViewStub2.setId(2114387666);
        tTViewStub2.setLayoutParams(layoutParams7);
        relativeLayout.addView(tTViewStub2);
        TTViewStub tTViewStub3 = new TTViewStub(context, new com.bytedance.sdk.openadsdk.res.layout.video.e());
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.addRule(13, -1);
        tTViewStub3.setId(2114387828);
        tTViewStub3.setLayoutParams(layoutParams8);
        relativeLayout.addView(tTViewStub3);
        return relativeLayout;
    }

    public a(Context context, ViewGroup viewGroup, na naVar, String str, boolean z2, boolean z3, boolean z4) {
        this.x = "embeded_ad";
        this.lq = false;
        this.mc = true;
        this.j = 0;
        this.gp = 0;
        this.qd = 1;
        this.qd = v.dl(context);
        z(z2);
        this.x = str;
        try {
            this.j = viewGroup.getWidth();
            this.gp = viewGroup.getHeight();
        } catch (Throwable unused) {
        }
        this.sy = viewGroup;
        this.fo = new WeakReference<>(context);
        this.m = naVar;
        z(context);
        this.gk = true;
        this.lq = z3;
        this.mc = z4;
    }

    public a(Context context, ViewGroup viewGroup, na naVar, String str, boolean z2, boolean z3) {
        this.x = "embeded_ad";
        this.lq = false;
        this.mc = true;
        this.j = 0;
        this.gp = 0;
        this.qd = 1;
        this.qd = v.dl(context);
        try {
            this.j = viewGroup.getWidth();
            this.gp = viewGroup.getHeight();
        } catch (Throwable unused) {
        }
        this.sy = viewGroup;
        this.x = str;
        this.fo = new WeakReference<>(context);
        this.m = naVar;
        z(context);
        this.gk = true;
        this.lq = z2;
        this.mc = z3;
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl
    public void z(dl.a aVar) {
        this.na = new WeakReference<>(aVar);
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl
    public boolean z(com.bykv.vk.openvk.component.video.api.dl.a aVar) {
        aVar.ls();
        if (TextUtils.isEmpty(aVar.ls())) {
            z("url is null");
            wp.a("tag_video_play", "[video] play video stop , because no video info");
            return false;
        }
        this.iq = aVar;
        this.p = aVar.kb();
        this.e = aVar.uy();
        if (aVar.uy() > 0) {
            this.e = aVar.uy();
            this.gz = this.gz > this.e ? this.gz : this.e;
        }
        if (this.gc != null) {
            this.gc.z();
            if (this.sv == 0) {
                this.gc.e();
            }
            this.gc.dl(aVar.gz(), aVar.fo());
            this.gc.dl(this.sy);
            this.gc.z(aVar.gz(), aVar.fo());
        }
        try {
            if (this.f1409a == null) {
                if (!ec()) {
                    z("create video error");
                    return false;
                }
                this.f1409a.z(this.jq);
            }
            sy();
            this.l = 0L;
            a(aVar);
            return true;
        } catch (Throwable th) {
            z(th.getMessage());
            wp.a("tag_video_play", "[video] invoke NativeVideoController#playVideo cause exception :" + th.toString());
            return false;
        }
    }

    private boolean ec() {
        com.bykv.vk.openvk.component.video.api.z aVar;
        na naVar = this.m;
        if (com.bytedance.sdk.openadsdk.gc.z.g(naVar)) {
            com.bykv.vk.openvk.component.video.api.renderview.g gVarZw = zw();
            if (gVarZw != null) {
                this.f1409a = new com.bytedance.sdk.openadsdk.upie.video.lottie.z(gVarZw, com.bytedance.sdk.openadsdk.gc.z.fo(naVar), new com.bykv.vk.openvk.component.video.z.a.a(String.valueOf(eo.gz(this.m))), tf.p(naVar));
            } else {
                if (this.jq != null) {
                    this.jq.z((com.bykv.vk.openvk.component.video.api.z) null, new com.bykv.vk.openvk.component.video.api.dl.g(60008, AVMDLDataLoader.KeyIsStoIoWriteLimitKBTh2, "创建lottie播放器时，iRenderView为null, mediaLayout is null: " + (this.gc == null)));
                }
                wp.a("tag_video_play", "[video] invoke NativeVideoController#playVideo error: iRenderView为null");
                return false;
            }
        } else if (com.bytedance.sdk.openadsdk.gc.z.dl(naVar)) {
            com.bykv.vk.openvk.component.video.api.renderview.g gVarZw2 = zw();
            if (gVarZw2 != null) {
                int iGz = eo.gz(this.m);
                if (gk.a() && this.iq.fv() == 1) {
                    aVar = new com.bytedance.sdk.component.wp.g.g(zw.getContext(), String.valueOf(iGz));
                } else {
                    aVar = new com.bykv.vk.openvk.component.video.z.a.a(String.valueOf(iGz));
                }
                this.f1409a = new com.bytedance.sdk.openadsdk.upie.video.lottie.g(aVar, com.bytedance.sdk.openadsdk.gc.z.fo(naVar), gVarZw2);
            } else {
                if (this.jq != null) {
                    this.jq.z((com.bykv.vk.openvk.component.video.api.z) null, new com.bykv.vk.openvk.component.video.api.dl.g(60008, AVMDLDataLoader.KeyIsStoIoWriteLimitKBTh2, "创建Upie播放器时，iRenderView为null, mediaLayout is null: " + (this.gc == null)));
                }
                wp.a("tag_video_play", "[video] invoke NativeVideoController#playVideo error: iRenderView为null");
                return false;
            }
        } else {
            int iGz2 = eo.gz(this.m);
            if (com.bytedance.sdk.openadsdk.core.video.dl.z.z(this.m)) {
                this.f1409a = new com.bytedance.sdk.component.wp.z.z(zw.getContext(), hh(), (long) tf.m(this.m), zw.g().yz(), null);
            } else if (gk.a() && this.iq.fv() == 1) {
                this.f1409a = new com.bytedance.sdk.component.wp.g.g(zw.getContext(), String.valueOf(iGz2));
            } else {
                this.f1409a = new com.bykv.vk.openvk.component.video.z.a.a(String.valueOf(iGz2));
            }
        }
        return true;
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl
    public int pf() {
        return com.bykv.vk.openvk.component.video.z.gc.z.z(this.gz, this.ls);
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl
    public void g(Map<String, Object> map) {
        this.gb = map;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.z.z
    protected Map<String, Object> gp() {
        return this.gb;
    }

    private void a(com.bykv.vk.openvk.component.video.api.dl.a aVar) {
        if (aVar == null) {
            z("model is null");
            return;
        }
        final long jDl = dl(aVar);
        if (this.f1409a != null) {
            if (this.m != null) {
                aVar.a(String.valueOf(eo.fo(this.m)));
            }
            aVar.a(0);
            this.f1409a.z(aVar);
            this.f1409a.z(lq());
        }
        this.hh = System.currentTimeMillis();
        if (!TextUtils.isEmpty(aVar.ls())) {
            if (this.gc != null) {
                this.gc.gc(8);
                this.gc.gc(0);
            }
            boolean zDl = eo.dl(this.m);
            boolean zG = this.gc != null ? ti.g(this.gc.z, 50, 9) : true;
            Runnable runnable = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.a.3
                @Override // java.lang.Runnable
                public void run() {
                    a.this.q.z();
                    a.this.j();
                    a.this.hh = System.currentTimeMillis();
                    if (a.this.gc != null) {
                        a.this.gc.a(0);
                    }
                    if (a.this.f1409a == null || a.this.e != 0) {
                        if (a.this.f1409a != null) {
                            a.this.f1409a.z(true, a.this.e, a.this.p);
                            return;
                        }
                        return;
                    }
                    a.this.f1409a.z(true, jDl, a.this.p);
                }
            };
            if (zDl && !zG) {
                g(runnable);
                gz(true);
                WeakReference<z> weakReference = this.xl;
                if (weakReference != null && weakReference.get() != null) {
                    this.xl.get().fo();
                }
            } else {
                z(runnable);
            }
        } else {
            z("url is null");
        }
        if (this.wp) {
            vm();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl
    public void z(dl.g gVar) {
        this.un = new WeakReference<>(gVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.z.z, com.bykv.vk.openvk.component.video.api.a.dl
    public long wp() {
        if (p() == null) {
            return 0L;
        }
        return p().ls();
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl
    public int i() {
        if (p() == null) {
            return 0;
        }
        return p().p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bv() {
        this.sv++;
        if (l() && this.gc != null) {
            this.gc.g();
            dl.z zVar = this.h;
            if (zVar != null) {
                zVar.z(this.l, com.bykv.vk.openvk.component.video.z.gc.z.z(this.e, this.ls));
            }
            this.l = System.currentTimeMillis() - this.hh;
            this.gc.gc(true);
            boolean z2 = com.bytedance.sdk.openadsdk.core.video.dl.z.z(this.m);
            int iGb = this.m.gb();
            boolean z3 = iGb <= 0;
            boolean z4 = !z3 && this.sv >= iGb;
            boolean zDl = eo.dl(this.m);
            if (!zDl || z4 || z2) {
                this.gc.z(this.m, this.fo, true);
            }
            if (!this.q.z(64) || gb() || jq()) {
                this.q.dl(64);
                dl(this.ls, this.ls);
                long j = this.ls;
                this.e = j;
                this.gz = j;
                p.z zVar2 = new p.z();
                zVar2.z(kb());
                zVar2.dl(v());
                zVar2.g(wp());
                zVar2.m(i());
                com.bytedance.sdk.openadsdk.m.g.a.a(this.gc, zVar2);
            }
            if (!this.wp && this.tb) {
                gc(this.gc, null);
            }
            this.js = true;
            if (z2) {
                return;
            }
            if (zDl && (z3 || this.sv < iGb)) {
                uf();
                return;
            }
            if (!(uy.z(this.m) && (((v() / 1000) > 10L ? 1 : ((v() / 1000) == 10L ? 0 : -1)) < 0)) || this.sv >= 2) {
                return;
            }
            uf();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl
    public void z(dl.z zVar) {
        this.h = zVar;
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl
    public void m() {
        if (this.f1409a != null) {
            this.f1409a.dl();
        }
        if ((!this.q.z(64) || gb()) && this.q.z(2)) {
            p.z zVar = new p.z();
            zVar.z(kb());
            zVar.dl(v());
            zVar.g(wp());
            z(this.gc, zVar);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl
    public void z(Map<String, Object> map) {
        if (this.f1409a != null) {
            this.f1409a.dl();
        }
        if ((!this.q.z(64) || gb()) && this.q.z(2)) {
            p.z zVar = new p.z();
            zVar.z(kb());
            zVar.dl(v());
            zVar.g(wp());
            if (map != null) {
                zVar.z(map);
            }
            z(this.gc, zVar);
        }
    }

    private boolean gb() {
        return this.sv > 0 && eo.dl(this.m);
    }

    private boolean jq() {
        return this.sv > 0 && uy.z(this.m);
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
        }
        if (this.gc != null) {
            this.gc.io();
        }
        f();
    }

    public void m(boolean z2) {
        if (this.gc != null) {
            this.gc.z();
        }
        if (this.gc != null && z2) {
            this.gc.io();
        }
        f();
    }

    private boolean sv() {
        return this.wp && com.bytedance.sdk.openadsdk.core.uy.ls().yx() > 0;
    }

    private void f() {
        wp.z("NativeVideoController", "resumeVideo:  mIsSurfaceValid = ", Boolean.valueOf(this.uy));
        if (this.f1409a != null) {
            if (this.f1409a.v() && !sv()) {
                if (this.uy || ((this.iq != null && this.iq.e()) || com.bytedance.sdk.openadsdk.gc.z.g(this.m))) {
                    eo();
                } else {
                    g(this.io);
                }
                wp.z("NativeVideoController", "resumeVideo: isPaused = true , mIsSurfaceValid = ", Boolean.valueOf(this.uy));
            } else if (sv()) {
                this.e = com.bytedance.sdk.openadsdk.core.uy.ls().yx();
                com.bytedance.sdk.openadsdk.core.uy.ls().z(-1L);
                this.f1409a.z(this.e);
                this.f1409a.g();
            } else {
                this.f1409a.z(false, this.e, this.p);
            }
        }
        if (this.q.z(2)) {
            p.z zVar = new p.z();
            zVar.z(kb());
            zVar.dl(v());
            zVar.g(wp());
            g(fv(), zVar);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl
    public void z(long j) {
        this.e = j;
        this.gz = this.gz > this.e ? this.gz : this.e;
        if (this.gc != null) {
            this.gc.z();
        }
        if (this.f1409a != null) {
            this.f1409a.z(true, this.e, this.p);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl
    public void fo() {
        z(true, 3);
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl
    public void z(boolean z2, int i) {
        if (this.wp) {
            z(1);
        }
        long jV = v();
        if ((!this.q.z(64) || gb()) && this.q.z(1) && jV > 0) {
            if (z2) {
                p.z zVar = new p.z();
                zVar.z(kb());
                zVar.dl(jV);
                zVar.g(wp());
                zVar.gc(i);
                zVar.m(i());
                this.q.dl(32);
                com.bytedance.sdk.openadsdk.m.g.a.z(this.gc, zVar, this.gb, !this.q.z(2) ? 1 : 0);
            } else {
                p.z zVar2 = new p.z();
                zVar2.z(kb());
                zVar2.dl(jV);
                zVar2.g(wp());
                z(this.gc, zVar2);
            }
        }
        uy();
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl
    public void uy() {
        dl(v() == 0 ? -2 : -1);
        if (this.f1409a != null) {
            this.f1409a.gc();
            this.f1409a = null;
        }
        int iGb = this.m == null ? 2 : this.m.gb();
        boolean z2 = iGb > 0 && this.sv == iGb;
        if (!eo.dl(this.m) || z2) {
            try {
                this.gc.z(this.m, this.fo, true);
            } catch (Exception e) {
                wp.a("NativeVideoController", e.getMessage());
            }
        }
        if (this.z != null) {
            this.z.removeCallbacksAndMessages(null);
        }
        if (this.kb != null) {
            this.kb.clear();
        }
        y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yx() {
        if (!this.q.z(2) || gb()) {
            p.z zVar = new p.z();
            if (qd()) {
                this.oq = true;
            }
            zVar.g(this.oq);
            zVar.dl(v());
            this.q.dl(2);
            com.bytedance.sdk.openadsdk.m.g.a.z(this.gc, zVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x008d A[Catch: all -> 0x00ed, TryCatch #0 {all -> 0x00ed, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x000c, B:8:0x0012, B:10:0x0016, B:16:0x0022, B:17:0x002e, B:38:0x0080, B:41:0x0087, B:43:0x008d, B:45:0x0091, B:47:0x00a3, B:54:0x00bc, B:56:0x00c2, B:58:0x00ca, B:60:0x00d7, B:48:0x00a9, B:50:0x00ad, B:51:0x00b3, B:53:0x00b7, B:30:0x0051, B:31:0x0062, B:33:0x0068, B:62:0x00e1, B:64:0x00e5, B:65:0x00ea), top: B:68:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0091 A[Catch: all -> 0x00ed, TryCatch #0 {all -> 0x00ed, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x000c, B:8:0x0012, B:10:0x0016, B:16:0x0022, B:17:0x002e, B:38:0x0080, B:41:0x0087, B:43:0x008d, B:45:0x0091, B:47:0x00a3, B:54:0x00bc, B:56:0x00c2, B:58:0x00ca, B:60:0x00d7, B:48:0x00a9, B:50:0x00ad, B:51:0x00b3, B:53:0x00b7, B:30:0x0051, B:31:0x0062, B:33:0x0068, B:62:0x00e1, B:64:0x00e5, B:65:0x00ea), top: B:68:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void g(int r9, int r10) {
        /*
            Method dump skipped, instruction units count: 238
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.video.nativevideo.a.g(int, int):void");
    }

    private void z(int i, int i2, int i3, int i4) {
        Matrix matrix;
        if (i3 == 0 || i4 == 0) {
            return;
        }
        float f = i3;
        float f2 = i;
        float f3 = f / f2;
        float f4 = i4;
        float f5 = i2;
        float f6 = f4 / f5;
        try {
            Object objZw = zw();
            if (objZw instanceof TextureView) {
                matrix = ((TextureView) objZw).getMatrix();
            } else if (objZw instanceof UpieVideoView) {
                matrix = ((UpieVideoView) objZw).getMatrix();
            } else {
                matrix = objZw instanceof SurfaceView ? ((SurfaceView) objZw).getMatrix() : null;
            }
            float fMax = Math.max(f3, f6);
            if (matrix == null) {
                matrix = new Matrix();
            } else {
                matrix.reset();
            }
            matrix.preTranslate((i3 - i) / 2, (i4 - i2) / 2);
            matrix.preScale(f2 / f, f5 / f4);
            matrix.postScale(fMax, fMax, i3 / 2, i4 / 2);
            if (objZw instanceof TextureView) {
                ((TextureView) objZw).setTransform(matrix);
                ((TextureView) objZw).postInvalidate();
            } else if (objZw instanceof UpieVideoView) {
                if (Build.VERSION.SDK_INT >= 29) {
                    ((UpieVideoView) objZw).setAnimationMatrix(matrix);
                }
                ((UpieVideoView) objZw).postInvalidate();
            } else if (objZw instanceof SurfaceView) {
                if (Build.VERSION.SDK_INT >= 29) {
                    ((SurfaceView) objZw).setAnimationMatrix(matrix);
                }
                ((SurfaceView) objZw).postInvalidate();
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean qd() {
        return TextUtils.equals(this.x, "splash_ad") || TextUtils.equals(this.x, "cache_splash_ad");
    }

    private boolean zx() {
        tc tcVarUv;
        if (qd()) {
            return this.m == null || (tcVarUv = this.m.uv()) == null || tcVarUv.z() != 0;
        }
        return false;
    }

    private boolean g(int i, int i2, int i3, int i4) {
        return (i3 > i4 && !dl(i, i2)) || i3 <= 0;
    }

    private boolean dl(int i, int i2) {
        return i < i2 && b();
    }

    private boolean b() {
        return this.m != null && this.m.qd() == 1 && "draw_ad".equals(this.x) && this.sy != null;
    }

    protected com.bykv.vk.openvk.component.video.api.renderview.g zw() {
        if (this.fo == null || this.fo.get() == null) {
            return null;
        }
        if ((this.fo.get().getResources().getConfiguration().orientation == 1 || com.bytedance.sdk.openadsdk.gc.z.z(this.m)) && this.gc != null) {
            return this.gc.p();
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.z
    public void z(com.bykv.vk.openvk.component.video.api.a.g gVar, View view) {
        if (this.f1409a == null || !l()) {
            return;
        }
        if (this.f1409a.i()) {
            m();
            if (this.gc != null) {
                this.gc.g(true, false);
                this.gc.m();
                return;
            }
            return;
        }
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
        m(false);
        if (this.gc != null) {
            this.gc.g(false, false);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.z
    public void z(com.bykv.vk.openvk.component.video.api.a.g gVar, int i) {
        if (this.f1409a == null) {
            return;
        }
        z(this.f, e(i));
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.z
    public void g(com.bykv.vk.openvk.component.video.api.a.g gVar, int i) {
        if (this.gc != null) {
            this.gc.m();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.z
    public void z(com.bykv.vk.openvk.component.video.api.a.g gVar, int i, boolean z2) {
        if (l()) {
            long j = (long) (((((long) i) * this.ls) * 1.0f) / 100.0f);
            if (this.ls > 0) {
                this.f = (int) j;
            } else {
                this.f = 0L;
            }
            if (this.gc != null) {
                this.gc.z(this.f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dl(long j, long j2) {
        this.e = j;
        this.ls = j2;
        if (this.gc != null) {
            this.gc.z(j, j2);
            this.gc.g(com.bykv.vk.openvk.component.video.z.gc.z.z(j, j2));
        }
        try {
            dl.z zVar = this.h;
            if (zVar != null) {
                zVar.z(j, j2);
            }
        } catch (Throwable th) {
            wp.dl("NativeVideoController", "onProgressUpdate error: ", th);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.z
    public void g(com.bykv.vk.openvk.component.video.api.a.g gVar, View view) {
        g(gVar, view, false, false);
    }

    public void g(com.bykv.vk.openvk.component.video.api.a.g gVar, View view, boolean z2, boolean z3) {
        if (l()) {
            fo(!this.tb);
            if (this.fo.get() instanceof Activity) {
                if (this.tb) {
                    m(z2 ? 8 : 0);
                    if (this.gc != null) {
                        this.gc.z(this.sy);
                        this.gc.dl(false);
                    }
                } else {
                    m(1);
                    if (this.gc != null) {
                        this.gc.g(this.sy);
                        this.gc.dl(false);
                    }
                }
                WeakReference<dl.g> weakReference = this.un;
                dl.g gVar2 = weakReference != null ? weakReference.get() : null;
                if (gVar2 != null) {
                    gVar2.z(this.tb);
                }
            }
        }
    }

    public void m(int i) {
        if (l()) {
            boolean z2 = i == 0 || i == 8;
            Context context = this.fo.get();
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                try {
                    activity.setRequestedOrientation(i);
                } catch (Throwable unused) {
                }
                if (!z2) {
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
    public void z(com.bykv.vk.openvk.component.video.api.a.g gVar, View view, boolean z2, boolean z3) {
        if (this.wp) {
            m();
        }
        if (this.gc == null) {
            return;
        }
        if (z2 && !this.wp && !io()) {
            this.gc.g(!t(), false);
            this.gc.z(z3, true, false);
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
            m(1);
            return;
        }
        z(1);
        z(true, 3);
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.z
    public void gc(com.bykv.vk.openvk.component.video.api.a.g gVar, View view) {
        z(gVar, view, false);
    }

    public void z(com.bykv.vk.openvk.component.video.api.a.g gVar, View view, boolean z2) {
        lw();
    }

    private void lw() {
        if (l()) {
            fo(!this.tb);
            if (this.fo.get() instanceof Activity) {
                if (this.gc != null) {
                    this.gc.g(this.sy);
                    this.gc.dl(false);
                }
                m(1);
                WeakReference<dl.g> weakReference = this.un;
                dl.g gVar = weakReference != null ? weakReference.get() : null;
                if (gVar != null) {
                    gVar.z(this.tb);
                }
            }
        }
    }

    public boolean io() {
        return this.f1409a == null || this.f1409a.fo();
    }

    public void uf() {
        if (v.dl(zw.getContext()) == 0) {
            return;
        }
        if (this.gc != null) {
            this.gc.z();
        }
        dl(false);
        if (this.f1409a != null) {
            this.q.z();
            j();
            this.f1409a.z();
            yx();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rv() {
        if (!this.wj || this.gc == null || this.gc.dl() == null) {
            return;
        }
        this.wj = false;
        this.gc.dl().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.a.5
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.iq == null) {
                    return;
                }
                a.this.iq.g(a.this.m.mj());
                a.this.iq.g(a.this.j);
                a.this.iq.dl(a.this.gp);
                a.this.iq.z((List<String>) null);
                a.this.iq.dl(a.this.m.vk());
                a.this.iq.z(0L);
                a.this.iq.g(a.this.js());
                a.this.iq.z(a.this.iq.gc());
                a aVar = a.this;
                aVar.z(aVar.iq);
                a.this.dl(false);
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.z
    public void z() {
        if (v.dl(zw.getContext()) == 0) {
            return;
        }
        this.wj = true;
        if (this.f1409a == null) {
            uy();
            rv();
        } else {
            uy();
        }
    }

    public boolean t() {
        return this.f1409a != null && this.f1409a.i();
    }

    private void z(long j, boolean z2) {
        if (this.f1409a == null) {
            return;
        }
        if (z2) {
            tc();
        }
        this.f1409a.z(j);
    }

    private boolean e(int i) {
        return this.gc != null && this.gc.dl(i);
    }

    private void tc() {
        if (this.gc != null) {
            this.gc.a(0);
            this.gc.z(false, false);
            this.gc.dl(false);
            this.gc.gc();
            this.gc.e();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.video.nativevideo.a$9, reason: invalid class name */
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
            this.ti = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean gz(int i) {
        int iDl = v.dl(zw.getContext());
        if (iDl == 0) {
            m();
            this.pf = true;
            if (this.gc != null) {
                this.gc.z(this.m, this.fo, false);
            }
        }
        if (iDl != 4 && iDl != 0) {
            if (this.gc != null) {
                this.gc.z();
            }
            m();
            this.pf = true;
            this.ti = false;
            if (this.gc != null && this.m != null) {
                return this.gc.z(i, tf.v(this.m), this.mc);
            }
        } else if (iDl == 4) {
            this.pf = false;
            if (this.gc != null) {
                this.gc.tb();
            }
        }
        return true;
    }

    private void g(Context context, int i) {
        if (!l() || context == null || this.qd == i) {
            return;
        }
        this.qd = i;
        if (i != 4 && i != 0) {
            this.ti = false;
        }
        if (!this.ti && !tb() && this.lq) {
            gz.g().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.a.7
                @Override // java.lang.Runnable
                public void run() {
                    a.this.gz(2);
                }
            });
        }
        WeakReference<z> weakReference = this.xl;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.xl.get().z(this.qd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dl(Context context, int i) {
        g(context, i);
        if (i == 4) {
            this.pf = false;
        }
    }

    public void z(Context context, int i) {
        g(context, i);
        if (i == 4) {
            this.pf = false;
            gz.g().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.a.8
                @Override // java.lang.Runnable
                public void run() {
                    a.this.gz();
                }
            });
        }
    }

    public void vm() {
        if (this.zx || !this.y) {
            return;
        }
        this.zx = true;
        uf.z(this.yx, zw.getContext().getApplicationContext());
    }

    public void y() {
        if (this.zx) {
            this.zx = false;
            try {
                uf.z(this.yx);
            } catch (Throwable unused) {
            }
        }
    }

    public void z(z zVar) {
        this.xl = new WeakReference<>(zVar);
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl
    public boolean q() {
        return this.oq;
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl
    public void a(boolean z2) {
        this.oq = z2;
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl
    public boolean iq() {
        return this.vm;
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl
    public void gc(boolean z2) {
        this.y = z2;
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl
    public void g(com.bykv.vk.openvk.component.video.api.dl.a aVar) {
        this.iq = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.video.z.z
    public void j() {
        if (this.fo == null) {
            return;
        }
        this.q.dl(1);
        com.bytedance.sdk.openadsdk.m.g.a.z(this.m, this.gc, this.iq, this.oq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void me() {
        if (com.bytedance.sdk.openadsdk.core.video.dl.z.z(this.m) && !TextUtils.isEmpty(this.x)) {
            boolean z2 = this.q.z(1024);
            long jLongValue = this.q.g(1).longValue();
            if (z2) {
                return;
            }
            this.q.dl(1024);
            if (this.x.equals("embeded_ad")) {
                com.bytedance.sdk.openadsdk.core.i.a.z(this.m, "embeded_ad", System.currentTimeMillis() - jLongValue, com.bytedance.sdk.openadsdk.m.g.a.z(this.gc));
            } else if (this.x.equals("draw_ad")) {
                com.bytedance.sdk.openadsdk.core.i.a.z(this.m, "draw_ad", System.currentTimeMillis() - jLongValue, com.bytedance.sdk.openadsdk.m.g.a.z(this.gc));
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.a.dl
    public void z(int i) {
        if (com.bytedance.sdk.openadsdk.core.video.dl.z.z(this.m)) {
            if (this.ec <= 0) {
                this.ec = System.currentTimeMillis();
            }
            long jCurrentTimeMillis = System.currentTimeMillis() - this.ec;
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
                if (this.x.equals("embeded_ad")) {
                    com.bytedance.sdk.openadsdk.core.i.a.z(this.m, "embeded_ad", jCurrentTimeMillis, jSONObject, com.bytedance.sdk.openadsdk.m.g.a.z(this.gc));
                } else if (this.x.equals("draw_ad")) {
                    com.bytedance.sdk.openadsdk.core.i.a.z(this.m, "draw_ad", jCurrentTimeMillis, jSONObject, com.bytedance.sdk.openadsdk.m.g.a.z(this.gc));
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

    @Override // com.bykv.vk.openvk.component.video.api.a.dl
    public void g() {
        if (this.f1409a != null) {
            dl(false);
            this.f1409a.z();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(int i, String str) {
        if (com.bytedance.sdk.openadsdk.core.video.dl.z.z(this.m)) {
            if (this.x.equals("embeded_ad")) {
                com.bytedance.sdk.openadsdk.core.i.a.z(this.m, "embeded_ad", i, str, com.bytedance.sdk.openadsdk.m.g.a.z(this.gc));
            } else if (this.x.equals("draw_ad")) {
                com.bytedance.sdk.openadsdk.core.i.a.z(this.m, "draw_ad", i, str, com.bytedance.sdk.openadsdk.m.g.a.z(this.gc));
            }
        }
    }
}
