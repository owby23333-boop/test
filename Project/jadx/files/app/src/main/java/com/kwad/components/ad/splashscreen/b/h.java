package com.kwad.components.ad.splashscreen.b;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.kwad.components.splash.SplashPreloadManager;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwai.adclient.logger.model.BusinessType;
import java.io.File;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends e implements com.kwad.sdk.core.g.c {
    private ImageView CA;
    private ImageView CB;
    private AdInfo mAdInfo;
    private boolean Cz = false;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private boolean CC = false;
    private boolean CD = false;
    private boolean CE = false;
    private boolean CF = false;

    /* JADX INFO: renamed from: com.kwad.components.ad.splashscreen.b.h$1, reason: invalid class name */
    final class AnonymousClass1 implements ImageLoadingListener {
        AnonymousClass1() {
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
            return false;
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingCancelled(String str, View view) {
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingComplete(String str, View view, final DecodedResult decodedResult) {
            h.a(h.this, true);
            h.this.kN();
            h.this.CB.setVisibility(0);
            com.kwad.sdk.core.threads.b.xX().submit(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.h.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    final Bitmap bitmapStackBlur = BlurUtils.stackBlur(decodedResult.mBitmap, 20, false);
                    h.this.CB.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.h.1.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            h.this.CB.setImageDrawable(new BitmapDrawable(h.this.getContext().getResources(), bitmapStackBlur));
                        }
                    });
                }
            });
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingFailed(String str, View view, FailReason failReason) {
            if (h.this.CC) {
                return;
            }
            h.this.Cx.f(0, "load image error");
        }

        @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
        public final void onLoadingStarted(String str, View view) {
        }
    }

    private void a(final ImageView imageView) {
        ((FrameLayout) this.Cx.mRootContainer.findViewById(R.id.splash_play_card_view)).setClipChildren(false);
        imageView.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.h.3
            @Override // java.lang.Runnable
            public final void run() {
                float width = imageView.getWidth() / 1080.0f;
                float f2 = ((width * 880.0f) * 1152.0f) / 880.0f;
                float f3 = width * 2340.0f;
                float height = imageView.getHeight();
                float f4 = (f3 - height) / 2.0f;
                float f5 = f3 - f2;
                float f6 = (0.44107744f * f5) - f4;
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                marginLayoutParams.topMargin = (int) (((((f5 * 0.5589225f) - f4) - f6) / 2.0f) - (height * 0.03f));
                imageView.setLayoutParams(marginLayoutParams);
            }
        });
    }

    static /* synthetic */ boolean a(h hVar, boolean z2) {
        hVar.CD = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kN() {
        if (this.CF && this.CD && !this.CE) {
            this.CE = true;
            this.Cx.kN();
        }
    }

    private void l(String str, int i2) {
        ImageView imageView;
        AdTemplate adTemplate;
        ImageLoadingListener anonymousClass1;
        if (i2 == 0) {
            this.CA.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.CA.setVisibility(0);
            imageView = this.CA;
            adTemplate = this.Cx.mAdTemplate;
            anonymousClass1 = new AnonymousClass1();
        } else {
            this.CB.setVisibility(0);
            if (com.kwad.components.ad.splashscreen.a.b.kX()) {
                a(this.CB);
            }
            imageView = this.CB;
            adTemplate = this.Cx.mAdTemplate;
            anonymousClass1 = new ImageLoadingListener() { // from class: com.kwad.components.ad.splashscreen.b.h.2
                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final boolean onDecode(String str2, InputStream inputStream, DecodedResult decodedResult) {
                    return false;
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final void onLoadingCancelled(String str2, View view) {
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final void onLoadingComplete(String str2, View view, DecodedResult decodedResult) {
                    h.a(h.this, true);
                    h.this.kN();
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final void onLoadingFailed(String str2, View view, FailReason failReason) {
                    if (h.this.CC) {
                        return;
                    }
                    h.this.Cx.f(0, "load image error");
                }

                @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final void onLoadingStarted(String str2, View view) {
                }
            };
        }
        KSImageLoader.loadImage(imageView, str, adTemplate, anonymousClass1);
    }

    @Override // com.kwad.sdk.core.g.c
    public final void aS() {
        this.CF = true;
        if (!this.Cz) {
            this.Cz = true;
            com.kwad.components.ad.splashscreen.local.c.Z(getContext());
            com.kwad.components.core.r.c.qa().a(this.Cx.mAdTemplate, null, null);
            KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_SPLASH, "adShowSuccess").report();
        }
        kN();
    }

    @Override // com.kwad.sdk.core.g.c
    public final void aT() {
    }

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.CB = (ImageView) this.Cx.mRootContainer.findViewById(R.id.ksad_splash_background);
        this.CA = (ImageView) this.Cx.mRootContainer.findViewById(R.id.ksad_splash_foreground);
        this.mAdInfo = com.kwad.sdk.core.response.a.d.cb(this.Cx.mAdTemplate);
        String string = com.kwad.sdk.core.response.a.a.aN(this.mAdInfo).materialUrl;
        this.CB.setVisibility(0);
        int i2 = com.kwad.sdk.core.response.a.a.aN(this.mAdInfo).source;
        if (getContext() != null) {
            SplashPreloadManager.sm();
            File fileAM = SplashPreloadManager.aM(this.mAdInfo.adPreloadInfo.preloadId);
            if (fileAM != null && fileAM.exists() && fileAM.length() > 0) {
                string = Uri.fromFile(fileAM).toString();
            }
            l(string, i2);
        }
        com.kwad.sdk.core.g.a aVar = this.Cx.BZ;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        this.CC = true;
        this.CD = false;
        this.CE = false;
        this.CF = false;
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.core.g.a aVar = this.Cx.BZ;
        if (aVar != null) {
            aVar.b(this);
        }
    }
}
