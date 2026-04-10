package com.kwad.components.core.page.splitLandingPage.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.Rect;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.kwad.components.core.t.o;
import com.kwad.components.core.video.a;
import com.kwad.components.core.video.e;
import com.kwad.components.core.video.g;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.contentalliance.a.a.b;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.b.h;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.AdVideoPlayerViewCache;
import com.kwad.sdk.core.video.videoview.a;
import com.kwad.sdk.o.m;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private ViewGroup Cc;
    private ImageView No;
    private WindowManager Vl;
    private com.kwad.components.core.page.splitLandingPage.a.a Vm;
    private FrameLayout Vn;
    private FrameLayout Vo;
    private e Vp;
    private final WindowManager.LayoutParams Vq = new WindowManager.LayoutParams();
    private InterfaceC0347a Vr;
    private com.kwad.sdk.core.video.videoview.a cq;
    private a.InterfaceC0409a cz;
    private ImageView hM;
    private Context mContext;

    /* JADX INFO: renamed from: com.kwad.components.core.page.splitLandingPage.view.a$a, reason: collision with other inner class name */
    public interface InterfaceC0347a {
        boolean rK();
    }

    public final void a(InterfaceC0347a interfaceC0347a) {
        this.Vr = interfaceC0347a;
    }

    public a(Context context, com.kwad.components.core.page.splitLandingPage.a.a aVar) {
        if (context == null) {
            return;
        }
        Context contextWrapContextIfNeed = m.wrapContextIfNeed(context);
        this.mContext = contextWrapContextIfNeed;
        this.Vm = aVar;
        WindowManager windowManager = (WindowManager) contextWrapContextIfNeed.getSystemService("window");
        this.Vl = windowManager;
        if (windowManager == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.ksad_split_mini_video, (ViewGroup) null);
        this.Cc = viewGroup;
        this.Vn = (FrameLayout) viewGroup.findViewById(R.id.ksad_split_texture);
        this.Vo = (FrameLayout) this.Cc.findViewById(R.id.ksad_video_container);
        this.hM = (ImageView) this.Cc.findViewById(R.id.ksad_video_first_frame_container);
        this.No = (ImageView) this.Cc.findViewById(R.id.ksad_split_mini_close_btn);
        this.Vn.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.components.core.page.splitLandingPage.view.a.1
            float Vs = 0.0f;
            float Vt = 0.0f;

            /* JADX INFO: renamed from: top, reason: collision with root package name */
            float f1899top = 0.0f;
            float left = 0.0f;
            long Vu = 0;

            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (a.this.Vq == null) {
                    return false;
                }
                if (motionEvent.getActionMasked() == 0) {
                    this.Vs = motionEvent.getRawX();
                    this.Vt = motionEvent.getRawY();
                    this.left = a.this.Vq.x;
                    this.f1899top = a.this.Vq.y;
                    this.Vu = SystemClock.elapsedRealtime();
                    System.out.println(" actionDownX " + this.Vs + " actionDownX " + this.Vs);
                } else {
                    if (motionEvent.getActionMasked() == 2) {
                        float rawX = motionEvent.getRawX() - this.Vs;
                        float rawY = motionEvent.getRawY() - this.Vt;
                        if (Math.sqrt((rawX * rawX) + (rawY * rawY)) > 15.0d) {
                            a.this.Vq.x = (int) (this.left + rawX);
                            a.this.Vq.y = (int) (this.f1899top + rawY);
                            if (a.this.Vl != null) {
                                try {
                                    a.this.Vl.updateViewLayout(a.this.Cc, a.this.Vq);
                                } catch (Exception e) {
                                    com.kwad.components.core.d.a.reportSdkCaughtException(e);
                                    c.printStackTraceOnly(e);
                                }
                            }
                        }
                        return true;
                    }
                    if (motionEvent.getActionMasked() == 1) {
                        float rawX2 = motionEvent.getRawX() - this.Vs;
                        float rawY2 = motionEvent.getRawY() - this.Vt;
                        float fElapsedRealtime = SystemClock.elapsedRealtime() - this.Vu;
                        if (Math.sqrt((rawX2 * rawX2) + (rawY2 * rawY2)) < 15.0d && fElapsedRealtime > 30.0f && fElapsedRealtime < 300.0f && a.this.Vr != null && a.this.Vm != null && com.kwad.sdk.core.response.b.a.aF(com.kwad.sdk.core.response.b.e.el(a.this.Vm.getAdTemplate()))) {
                            a.this.Vr.rK();
                        }
                    }
                }
                return true;
            }
        });
    }

    public final void rJ() {
        this.Vp.ab();
    }

    public final boolean isVisible() {
        return this.Cc.getAlpha() > 0.0f;
    }

    public final boolean rM() {
        if (this.Vm == null || this.Vl == null) {
            return false;
        }
        c(new KsAdVideoPlayConfig.Builder().videoSoundEnable(this.Vm.getAdTemplate().mIsAudioEnable).build());
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(this.Vm.getAdTemplate());
        int iR = com.kwad.sdk.core.response.b.a.R(adInfoEl);
        int iQ = com.kwad.sdk.core.response.b.a.Q(adInfoEl);
        Rect rect = new Rect();
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        if (iR > iQ) {
            rect.right = displayMetrics.widthPixels;
            rect.left = rect.right - com.kwad.sdk.c.a.a.a(this.mContext, 86.0f);
            rect.bottom = displayMetrics.heightPixels - com.kwad.sdk.c.a.a.a(this.mContext, 252.0f);
            rect.top = rect.bottom - com.kwad.sdk.c.a.a.a(this.mContext, 154.0f);
        } else {
            rect.right = displayMetrics.widthPixels;
            rect.left = rect.right - com.kwad.sdk.c.a.a.a(this.mContext, 154.0f);
            rect.bottom = displayMetrics.heightPixels - com.kwad.sdk.c.a.a.a(this.mContext, 252.0f);
            rect.top = rect.bottom - com.kwad.sdk.c.a.a.a(this.mContext, 86.0f);
        }
        rect.left -= com.kwad.sdk.c.a.a.a(this.mContext, 12.0f);
        rect.right -= com.kwad.sdk.c.a.a.a(this.mContext, 12.0f);
        this.Vq.type = 1003;
        this.Vq.flags = 8;
        this.Vq.gravity = 51;
        this.Vq.format = 1;
        this.Vq.width = displayMetrics.widthPixels;
        this.Vq.height = displayMetrics.heightPixels;
        this.Vq.x = rect.left;
        this.Vq.y = rect.top;
        this.Vq.width = (rect.right - rect.left) + com.kwad.sdk.c.a.a.a(this.mContext, 12.0f);
        this.Vq.height = (rect.bottom - rect.top) + com.kwad.sdk.c.a.a.a(this.mContext, 12.0f);
        this.Cc.setPivotX((rect.left * displayMetrics.widthPixels) / ((rect.left + displayMetrics.widthPixels) - rect.right));
        this.Cc.setPivotY((rect.top * displayMetrics.heightPixels) / ((rect.top + displayMetrics.heightPixels) - rect.bottom));
        this.Cc.setAlpha(0.0f);
        if (this.Vl != null) {
            try {
                if (this.Cc.getWindowToken() == null) {
                    this.Vl.addView(this.Cc, this.Vq);
                }
            } catch (Exception e) {
                com.kwad.components.core.d.a.reportSdkCaughtException(e);
                c.printStackTraceOnly(e);
            }
        }
        this.No.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.splitLandingPage.view.a.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                a.this.rJ();
                a.this.aK(false).start();
            }
        });
        return true;
    }

    private void c(KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        final AdTemplate adTemplate = this.Vm.getAdTemplate();
        AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(adTemplate);
        String url = com.kwad.sdk.core.response.b.a.bu(adInfoEl).getUrl();
        if (!TextUtils.isEmpty(url)) {
            this.hM.setImageDrawable(null);
            KSImageLoader.loadImage(this.hM, url, adTemplate);
            this.hM.setVisibility(0);
        } else {
            this.hM.setVisibility(8);
        }
        String strK = com.kwad.sdk.core.response.b.a.K(adInfoEl);
        if (TextUtils.isEmpty(strK)) {
            return;
        }
        com.kwad.sdk.core.video.videoview.a aVarEF = AdVideoPlayerViewCache.getInstance().eF(strK);
        this.cq = aVarEF;
        if (aVarEF == null) {
            this.cq = new com.kwad.sdk.core.video.videoview.a(this.mContext);
            com.kwad.sdk.core.response.b.a.ab(adInfoEl);
            this.cq.a(new b.a(adTemplate).a(adTemplate.mVideoPlayerStatus).dg(com.kwad.sdk.core.response.b.e.en(adTemplate)).dh(h.b(com.kwad.sdk.core.response.b.e.em(adTemplate))).b(new com.kwad.sdk.contentalliance.a.a.a(adTemplate, System.currentTimeMillis())).El(), null);
            a.InterfaceC0409a interfaceC0409a = new a.InterfaceC0409a() { // from class: com.kwad.components.core.page.splitLandingPage.view.a.3
                @Override // com.kwad.sdk.core.video.videoview.a.InterfaceC0409a
                public final com.kwad.sdk.core.video.a.c a(b bVar) {
                    if (!((Boolean) com.kwad.sdk.core.config.e.b(com.kwad.sdk.core.config.c.aBS)).booleanValue() || !((Boolean) com.kwad.sdk.core.config.e.b(com.kwad.sdk.core.config.c.aBT)).booleanValue()) {
                        return null;
                    }
                    g gVar = new g(bVar, adTemplate);
                    if (g.isWaynePlayerReady()) {
                        return gVar;
                    }
                    return null;
                }
            };
            this.cz = interfaceC0409a;
            this.cq.setExternalPlayerListener(interfaceC0409a);
            this.cq.setVideoSoundEnable(ksAdVideoPlayConfig.isVideoSoundEnable());
            e eVar = new e(this.mContext, adTemplate, this.cq, ksAdVideoPlayConfig);
            this.Vp = eVar;
            eVar.setDataFlowAutoStart(ksAdVideoPlayConfig.isDataFlowAutoStart());
            this.cq.setController(this.Vp);
            this.Vp.setAutoRelease(false);
        } else {
            e eVar2 = (e) aVarEF.getController();
            this.Vp = eVar2;
            eVar2.setAutoRelease(false);
            this.Vp.getAdTemplate().mAdWebVideoPageShowing = true;
        }
        this.cq.setVideoSoundEnable(ksAdVideoPlayConfig.isVideoSoundEnable());
        if (this.cq.getParent() != null) {
            ((ViewGroup) this.cq.getParent()).removeView(this.cq);
        }
        if (this.Vo.getTag() != null) {
            FrameLayout frameLayout = this.Vo;
            frameLayout.removeView((View) frameLayout.getTag());
            this.Vo.setTag(null);
        }
        this.Vo.addView(this.cq);
        this.Vo.setTag(this.cq);
        this.Vp.setAlpha(0.01f);
        this.Vp.setVideoPlayCallback(new a.c() { // from class: com.kwad.components.core.page.splitLandingPage.view.a.4
            @Override // com.kwad.components.core.video.a.c
            public final void aq() {
            }

            @Override // com.kwad.components.core.video.a.c
            public final void d(long j) {
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlayStart() {
            }

            @Override // com.kwad.components.core.video.a.c
            public final void ar() {
                a.this.rJ();
                a.this.aK(false).start();
            }
        });
    }

    public final void rN() {
        com.kwad.sdk.core.video.videoview.a aVar = this.cq;
        if (aVar == null || aVar.isPlaying()) {
            return;
        }
        this.Vp.tT();
    }

    public final Animator aK(boolean z) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(o.h(this.Cc, z), o.h(this.hM, z));
        return animatorSet;
    }
}
