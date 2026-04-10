package com.kwad.components.ad.splashscreen.presenter;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.kwad.components.ad.splashscreen.SplashPreloadManager;
import com.kwad.components.ad.splashscreen.presenter.playcard.SplashPlayDefaultInfoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import java.io.File;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends e {
    private ImageView Gh;
    private ImageView Gi;
    private int Gl;
    private long Gn;
    private View Go;
    private ViewGroup Gp;
    private SplashPlayDefaultInfoView Gq;
    private AdInfo mAdInfo;
    private boolean Gj = false;
    private boolean Gk = false;
    private int Gm = 1;
    Runnable Gr = new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.h.5
        @Override // java.lang.Runnable
        public final void run() {
            h.this.ml();
        }
    };

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        this.Go = findViewById(R.id.ksad_splash_root_container);
        this.Gi = (ImageView) findViewById(R.id.ksad_splash_background);
        this.Gh = (ImageView) findViewById(R.id.ksad_splash_foreground);
        this.mAdInfo = com.kwad.sdk.core.response.b.e.el(this.Gf.mAdTemplate);
        this.Gp = (ViewGroup) findViewById(R.id.ksad_splash_default_image_view_container);
        this.Gq = (SplashPlayDefaultInfoView) findViewById(R.id.ksad_splash_default_image_view);
        this.Gl = com.kwad.components.ad.splashscreen.h.ac(this.Gf.mAdTemplate) ? 2 : 1;
        String string = com.kwad.sdk.core.response.b.a.aU(this.mAdInfo).materialUrl;
        this.Gi.setVisibility(0);
        int i = com.kwad.sdk.core.response.b.a.aU(this.mAdInfo).source;
        mk();
        if (getContext() != null) {
            SplashPreloadManager.lD();
            File fileAa = SplashPreloadManager.aa(this.mAdInfo.adPreloadInfo.preloadId);
            if (fileAa != null && fileAa.exists() && fileAa.length() > 0) {
                this.Gm = 2;
                string = Uri.fromFile(fileAa).toString();
            }
            l(string, i);
        }
    }

    private void l(String str, int i) {
        if (i == 0) {
            this.Gh.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.Gh.setVisibility(0);
            KSImageLoader.loadImage(this.Gh, str, this.Gf.mAdTemplate, new AnonymousClass1());
        } else {
            this.Gi.setVisibility(0);
            if (com.kwad.sdk.core.config.e.a(com.kwad.components.ad.splashscreen.b.a.FP)) {
                a(this.Gi, this.mAdInfo);
            } else {
                a(this.Gi);
            }
            KSImageLoader.loadImage(this.Gi, str, this.Gf.mAdTemplate, new ImageLoadingListener() { // from class: com.kwad.components.ad.splashscreen.presenter.h.2
                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final boolean onDecode(String str2, InputStream inputStream, DecodedResult decodedResult) {
                    return false;
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final void onLoadingCancelled(String str2, View view) {
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final void onLoadingStarted(String str2, View view) {
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final void onLoadingFailed(String str2, View view, FailReason failReason) {
                    h.this.ml();
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final void onLoadingComplete(String str2, View view, DecodedResult decodedResult) {
                    if (com.kwad.sdk.core.config.e.a(com.kwad.components.ad.splashscreen.b.a.FQ)) {
                        long jElapsedRealtime = SystemClock.elapsedRealtime();
                        com.kwad.components.ad.splashscreen.monitor.b.lZ();
                        com.kwad.components.ad.splashscreen.monitor.b.a(h.this.Gf.mAdTemplate, 2, h.this.Gl, h.this.Gm, jElapsedRealtime - h.this.Gn, jElapsedRealtime - h.this.Gf.mAdTemplate.showTime);
                    }
                    h.this.mm();
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.kwad.components.ad.splashscreen.presenter.h$1, reason: invalid class name */
    final class AnonymousClass1 implements ImageLoadingListener {
        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
            return false;
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingCancelled(String str, View view) {
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingStarted(String str, View view) {
        }

        AnonymousClass1() {
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingFailed(String str, View view, FailReason failReason) {
            h.this.ml();
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingComplete(String str, View view, final DecodedResult decodedResult) {
            if (com.kwad.sdk.core.config.e.a(com.kwad.components.ad.splashscreen.b.a.FQ)) {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                com.kwad.components.ad.splashscreen.monitor.b.lZ();
                com.kwad.components.ad.splashscreen.monitor.b.a(h.this.Gf.mAdTemplate, 2, h.this.Gl, h.this.Gm, jElapsedRealtime - h.this.Gn, jElapsedRealtime - h.this.Gf.mAdTemplate.showTime);
            }
            h.this.mm();
            h.this.Gi.setVisibility(0);
            GlobalThreadPools.Jo().submit(new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.h.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    final Bitmap bitmapStackBlur = BlurUtils.stackBlur(decodedResult.mBitmap, 20, false);
                    h.this.Gi.post(new bg() { // from class: com.kwad.components.ad.splashscreen.presenter.h.1.1.1
                        @Override // com.kwad.sdk.utils.bg
                        public final void doTask() {
                            h.this.Gi.setImageDrawable(new BitmapDrawable(h.this.getContext().getResources(), bitmapStackBlur));
                        }
                    });
                }
            });
        }
    }

    private void a(final ImageView imageView, final AdInfo adInfo) {
        ((FrameLayout) this.Gf.mRootContainer.findViewById(R.id.splash_play_card_view)).setClipChildren(false);
        final AdInfo.CutRuleInfo cutRuleInfoCt = com.kwad.sdk.core.response.b.a.ct(adInfo);
        imageView.post(new bg() { // from class: com.kwad.components.ad.splashscreen.presenter.h.3
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                int height = imageView.getHeight();
                int width = imageView.getWidth();
                double d = com.kwad.sdk.core.response.b.a.aU(adInfo).width;
                double d2 = cutRuleInfoCt.picHeight;
                double d3 = cutRuleInfoCt.viewTopMargin;
                double d4 = cutRuleInfoCt.safeAreaHeight;
                if (d2 <= 0.0d || d4 <= 0.0d) {
                    return;
                }
                double d5 = ((double) width) / d;
                double d6 = d3 / (d2 - d4);
                double d7 = d3 * d5;
                double d8 = (d2 * d5) - ((double) height);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                marginLayoutParams.topMargin = (int) (((d8 / 2.0d) - (d7 - (d7 - (d6 * d8)))) * 2.0d);
                imageView.setLayoutParams(marginLayoutParams);
            }
        });
    }

    private void a(final ImageView imageView) {
        ((FrameLayout) this.Gf.mRootContainer.findViewById(R.id.splash_play_card_view)).setClipChildren(false);
        imageView.post(new bg() { // from class: com.kwad.components.ad.splashscreen.presenter.h.4
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                float width = imageView.getWidth() / 1080.0f;
                float f = ((width * 880.0f) * 1152.0f) / 880.0f;
                float f2 = width * 2340.0f;
                float height = imageView.getHeight();
                float f3 = (f2 - height) / 2.0f;
                float f4 = f2 - f;
                float f5 = (0.44107744f * f4) - f3;
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                marginLayoutParams.topMargin = (int) (((((f4 * 0.5589225f) - f3) - f5) / 2.0f) - (height * 0.03f));
                imageView.setLayoutParams(marginLayoutParams);
            }
        });
    }

    private void mk() {
        if (com.kwad.sdk.core.config.e.a(com.kwad.components.ad.splashscreen.b.a.FQ)) {
            this.Gn = SystemClock.elapsedRealtime();
            com.kwad.components.ad.splashscreen.monitor.b.lZ();
            com.kwad.components.ad.splashscreen.monitor.b.e(this.Gf.mAdTemplate, 2, this.Gl);
            bw.runOnUiThreadDelay(this.Gr, com.kwad.sdk.core.config.e.a(com.kwad.components.ad.splashscreen.b.a.FR));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ml() {
        if (this.Gj) {
            return;
        }
        if (com.kwad.sdk.core.config.e.a(com.kwad.components.ad.splashscreen.b.a.FQ)) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            com.kwad.components.ad.splashscreen.monitor.b.lZ();
            com.kwad.components.ad.splashscreen.monitor.b.b(this.Gf.mAdTemplate, 2, this.Gl, this.Gm, jElapsedRealtime - this.Gn, jElapsedRealtime - this.Gf.mAdTemplate.showTime);
        }
        this.Gj = true;
        this.Go.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.h.6
            @Override // java.lang.Runnable
            public final void run() {
                h.this.Gp.setVisibility(0);
                h.this.Gq.a(h.this.Gf.mAdTemplate, com.kwad.sdk.c.a.a.px2dip(h.this.getContext(), h.this.Go.getHeight()) / 414.0f);
            }
        });
        this.Gh.setVisibility(8);
        this.Gi.setVisibility(8);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        mm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mm() {
        if (this.Gk) {
            return;
        }
        this.Gk = true;
        if (com.kwad.sdk.core.config.e.a(com.kwad.components.ad.splashscreen.b.a.FQ)) {
            bw.c(this.Gr);
        }
    }
}
