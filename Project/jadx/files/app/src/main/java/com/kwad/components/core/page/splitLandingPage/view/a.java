package com.kwad.components.core.page.splitLandingPage.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.annotation.SuppressLint;
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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.r.o;
import com.kwad.components.core.video.a;
import com.kwad.components.core.video.e;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.loader.Wrapper;
import com.kwad.sdk.contentalliance.kwai.kwai.b;
import com.kwad.sdk.core.d.b;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.a.f;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.AdVideoPlayerViewCache;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private ImageView HN;

    @Nullable
    private WindowManager Nf;
    private com.kwad.components.core.page.splitLandingPage.kwai.a Ng;
    private FrameLayout Nh;
    private FrameLayout Ni;
    private e Nj;
    private final WindowManager.LayoutParams Nk = new WindowManager.LayoutParams();
    private InterfaceC0407a Nl;
    private ImageView eL;
    private com.kwad.sdk.core.video.videoview.a eM;
    private Context mContext;
    private ViewGroup yx;

    /* JADX INFO: renamed from: com.kwad.components.core.page.splitLandingPage.view.a$a, reason: collision with other inner class name */
    public interface InterfaceC0407a {
        boolean ph();
    }

    @SuppressLint({"ClickableViewAccessibility", "InflateParams"})
    public a(Context context, com.kwad.components.core.page.splitLandingPage.kwai.a aVar) {
        if (context == null) {
            return;
        }
        this.mContext = Wrapper.wrapContextIfNeed(context);
        this.Ng = aVar;
        this.Nf = (WindowManager) this.mContext.getSystemService("window");
        if (this.Nf == null) {
            return;
        }
        this.yx = (ViewGroup) LayoutInflater.from(this.mContext).inflate(R.layout.ksad_split_mini_video, (ViewGroup) null);
        this.Nh = (FrameLayout) this.yx.findViewById(R.id.ksad_split_texture);
        this.Ni = (FrameLayout) this.yx.findViewById(R.id.ksad_video_container);
        this.eL = (ImageView) this.yx.findViewById(R.id.ksad_video_first_frame_container);
        this.HN = (ImageView) this.yx.findViewById(R.id.ksad_split_mini_close_btn);
        this.Nh.setOnTouchListener(new View.OnTouchListener() { // from class: com.kwad.components.core.page.splitLandingPage.view.a.1
            float Nm = 0.0f;
            float Nn = 0.0f;
            float top = 0.0f;
            float left = 0.0f;
            long No = 0;

            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (a.this.Nk == null) {
                    return false;
                }
                if (motionEvent.getActionMasked() == 0) {
                    this.Nm = motionEvent.getRawX();
                    this.Nn = motionEvent.getRawY();
                    this.left = a.this.Nk.x;
                    this.top = a.this.Nk.y;
                    this.No = SystemClock.elapsedRealtime();
                    System.out.println(" actionDownX " + this.Nm + " actionDownX " + this.Nm);
                } else {
                    if (motionEvent.getActionMasked() == 2) {
                        float rawX = motionEvent.getRawX() - this.Nm;
                        float rawY = motionEvent.getRawY() - this.Nn;
                        if (Math.sqrt((rawX * rawX) + (rawY * rawY)) > 15.0d) {
                            a.this.Nk.x = (int) (this.left + rawX);
                            a.this.Nk.y = (int) (this.top + rawY);
                            if (a.this.Nf != null) {
                                try {
                                    a.this.Nf.updateViewLayout(a.this.yx, a.this.Nk);
                                } catch (Exception e2) {
                                    com.kwad.components.core.c.a.b(e2);
                                    b.printStackTraceOnly(e2);
                                }
                            }
                        }
                        return true;
                    }
                    if (motionEvent.getActionMasked() == 1) {
                        float rawX2 = motionEvent.getRawX() - this.Nm;
                        float rawY2 = motionEvent.getRawY() - this.Nn;
                        float fElapsedRealtime = SystemClock.elapsedRealtime() - this.No;
                        if (Math.sqrt((rawX2 * rawX2) + (rawY2 * rawY2)) < 15.0d && fElapsedRealtime > 30.0f && fElapsedRealtime < 300.0f && a.this.Nl != null && a.this.Ng != null && com.kwad.sdk.core.response.a.a.ay(d.cb(a.this.Ng.getAdTemplate()))) {
                            a.this.Nl.ph();
                        }
                    }
                }
                return true;
            }
        });
    }

    private void b(@NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        AdTemplate adTemplate = this.Ng.getAdTemplate();
        AdInfo adInfoCb = d.cb(adTemplate);
        String url = com.kwad.sdk.core.response.a.a.bh(adInfoCb).getUrl();
        if (TextUtils.isEmpty(url)) {
            this.eL.setVisibility(8);
        } else {
            this.eL.setImageDrawable(null);
            KSImageLoader.loadImage(this.eL, url, adTemplate);
            this.eL.setVisibility(0);
        }
        String strE = com.kwad.sdk.core.response.a.a.E(adInfoCb);
        if (TextUtils.isEmpty(strE)) {
            return;
        }
        this.eM = AdVideoPlayerViewCache.getInstance().cv(strE);
        com.kwad.sdk.core.video.videoview.a aVar = this.eM;
        if (aVar == null) {
            this.eM = new com.kwad.sdk.core.video.videoview.a(this.mContext);
            com.kwad.sdk.core.response.a.a.T(adInfoCb);
            this.eM.a(new b.a(adTemplate).a(adTemplate.mVideoPlayerStatus).bd(d.cd(adTemplate)).be(f.b(d.cc(adTemplate))).b(new com.kwad.sdk.contentalliance.kwai.kwai.a(adTemplate, System.currentTimeMillis())).uc(), null);
            this.eM.setVideoSoundEnable(ksAdVideoPlayConfig.isVideoSoundEnable());
            this.Nj = new e(this.mContext, adTemplate, this.eM, ksAdVideoPlayConfig);
            this.Nj.setDataFlowAutoStart(ksAdVideoPlayConfig.isDataFlowAutoStart());
            this.eM.setController(this.Nj);
            this.Nj.setAutoRelease(false);
        } else {
            this.Nj = (e) aVar.getController();
            this.Nj.setAutoRelease(false);
            this.Nj.getAdTemplate().mAdWebVideoPageShowing = true;
        }
        this.eM.setVideoSoundEnable(ksAdVideoPlayConfig.isVideoSoundEnable());
        if (this.eM.getParent() != null) {
            ((ViewGroup) this.eM.getParent()).removeView(this.eM);
        }
        if (this.Ni.getTag() != null) {
            FrameLayout frameLayout = this.Ni;
            frameLayout.removeView((View) frameLayout.getTag());
            this.Ni.setTag(null);
        }
        this.Ni.addView(this.eM);
        this.Ni.setTag(this.eM);
        this.Nj.setAlpha(0.01f);
        this.Nj.setVideoPlayCallback(new a.c() { // from class: com.kwad.components.core.page.splitLandingPage.view.a.3
            @Override // com.kwad.components.core.video.a.c
            public final void bt() {
                a.this.pg();
                a.this.aB(false).start();
            }

            @Override // com.kwad.components.core.video.a.c
            public final void d(long j2) {
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlayStart() {
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlaying() {
            }
        });
    }

    public final void a(InterfaceC0407a interfaceC0407a) {
        this.Nl = interfaceC0407a;
    }

    public final Animator aB(boolean z2) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(o.h(this.yx, z2), o.h(this.eL, z2));
        return animatorSet;
    }

    public final boolean isVisible() {
        return this.yx.getAlpha() > 0.0f;
    }

    public final void pg() {
        this.Nj.onViewDetached();
    }

    public final boolean pj() {
        int i2;
        int iA;
        if (this.Ng == null || this.Nf == null) {
            return false;
        }
        b(new KsAdVideoPlayConfig.Builder().videoSoundEnable(this.Ng.getAdTemplate().mIsAudioEnable).build());
        AdInfo adInfoCb = d.cb(this.Ng.getAdTemplate());
        int iK = com.kwad.sdk.core.response.a.a.K(adInfoCb);
        int iJ = com.kwad.sdk.core.response.a.a.J(adInfoCb);
        Rect rect = new Rect();
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        if (iK > iJ) {
            rect.right = displayMetrics.widthPixels;
            rect.left = rect.right - com.kwad.sdk.b.kwai.a.a(this.mContext, 86.0f);
            rect.bottom = displayMetrics.heightPixels - com.kwad.sdk.b.kwai.a.a(this.mContext, 252.0f);
            i2 = rect.bottom;
            iA = com.kwad.sdk.b.kwai.a.a(this.mContext, 154.0f);
        } else {
            rect.right = displayMetrics.widthPixels;
            rect.left = rect.right - com.kwad.sdk.b.kwai.a.a(this.mContext, 154.0f);
            rect.bottom = displayMetrics.heightPixels - com.kwad.sdk.b.kwai.a.a(this.mContext, 252.0f);
            i2 = rect.bottom;
            iA = com.kwad.sdk.b.kwai.a.a(this.mContext, 86.0f);
        }
        rect.top = i2 - iA;
        rect.left -= com.kwad.sdk.b.kwai.a.a(this.mContext, 12.0f);
        rect.right -= com.kwad.sdk.b.kwai.a.a(this.mContext, 12.0f);
        WindowManager.LayoutParams layoutParams = this.Nk;
        layoutParams.type = 1003;
        layoutParams.flags = 8;
        layoutParams.gravity = 51;
        layoutParams.format = 1;
        layoutParams.width = displayMetrics.widthPixels;
        layoutParams.height = displayMetrics.heightPixels;
        int i3 = rect.left;
        layoutParams.x = i3;
        layoutParams.y = rect.top;
        layoutParams.width = (rect.right - i3) + com.kwad.sdk.b.kwai.a.a(this.mContext, 12.0f);
        this.Nk.height = (rect.bottom - rect.top) + com.kwad.sdk.b.kwai.a.a(this.mContext, 12.0f);
        float f2 = (rect.left * displayMetrics.widthPixels) / ((r0 + r5) - rect.right);
        float f3 = (rect.top * displayMetrics.heightPixels) / ((r0 + r3) - rect.bottom);
        this.yx.setPivotX(f2);
        this.yx.setPivotY(f3);
        this.yx.setAlpha(0.0f);
        WindowManager windowManager = this.Nf;
        if (windowManager != null) {
            try {
                windowManager.addView(this.yx, this.Nk);
            } catch (Exception e2) {
                com.kwad.components.core.c.a.b(e2);
                com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            }
        }
        this.HN.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.splitLandingPage.view.a.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                a.this.pg();
                a.this.aB(false).start();
            }
        });
        return true;
    }

    public final void pk() {
        com.kwad.sdk.core.video.videoview.a aVar = this.eM;
        if (aVar == null || aVar.isPlaying()) {
            return;
        }
        this.Nj.qO();
    }
}
