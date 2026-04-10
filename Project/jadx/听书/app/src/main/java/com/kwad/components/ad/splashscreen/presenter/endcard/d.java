package com.kwad.components.ad.splashscreen.presenter.endcard;

import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.io.InputStream;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends com.kwad.components.ad.splashscreen.presenter.e implements com.kwad.sdk.core.j.c {
    private ViewGroup Is;
    private ImageView It;
    private SplashEndLandView Iu;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        initView();
        this.Gf.Fs.a(this);
        com.kwad.sdk.core.adlog.c.d(this.Gf.mAdTemplate, (JSONObject) null, new com.kwad.sdk.core.adlog.c.b().df(87).dm(6));
        mG();
        mH();
    }

    private void mG() {
        if (com.kwad.sdk.core.response.b.a.aF(com.kwad.sdk.core.response.b.e.el(this.Gf.mAdTemplate))) {
            com.kwad.components.ad.splashscreen.e.a aVar = new com.kwad.components.ad.splashscreen.e.a(getContext(), this.Gf.mAdTemplate) { // from class: com.kwad.components.ad.splashscreen.presenter.endcard.d.1
                {
                    super(adTemplate);
                }

                @Override // com.kwad.components.ad.splashscreen.e.a
                public final void j(int i, String str) {
                    d.this.ab(str);
                }
            };
            if (this.Gf.mApkDownloadHelper != null) {
                this.Gf.mApkDownloadHelper.b(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ab(String str) {
        SplashEndLandView splashEndLandView = this.Iu;
        if (splashEndLandView == null || str == null) {
            return;
        }
        splashEndLandView.ab(str);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        SplashEndLandView splashEndLandView = this.Iu;
        if (splashEndLandView != null) {
            splashEndLandView.mI();
        }
        this.Gf.Fs.b(this);
    }

    private void initView() {
        ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_splash_endcard_view_stub);
        if (viewStub != null) {
            this.Is = (ViewGroup) viewStub.inflate();
        } else {
            this.Is = (ViewGroup) findViewById(R.id.ksad_splash_end_card_native_root);
        }
        boolean zDn = com.kwad.sdk.core.response.b.a.dn(com.kwad.sdk.core.response.b.e.el(this.Gf.mAdTemplate));
        if (zDn) {
            this.Is.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.endcard.d.2
                @Override // java.lang.Runnable
                public final void run() {
                    d.this.Is.getWidth();
                    d.this.Iu.a(d.this.Gf.mAdTemplate, d.this.Gf.mApkDownloadHelper, com.kwad.sdk.c.a.a.px2dip(d.this.getContext(), d.this.Is.getHeight()) / 414.0f);
                }
            });
        }
        this.It = (ImageView) findViewById(R.id.ksad_splash_end_card_native_bg);
        SplashEndLandView splashEndLandView = (SplashEndLandView) findViewById(R.id.ksad_splash_end_card_native_dialog_root);
        this.Iu = splashEndLandView;
        splashEndLandView.t(zDn);
        this.Iu.a(this.Gf.mAdTemplate, this.Gf.mApkDownloadHelper, 1.0f);
    }

    private void mH() {
        this.Is.setVisibility(0);
        a(this.It, com.kwad.sdk.core.response.b.a.aU(com.kwad.sdk.core.response.b.e.el(this.Gf.mAdTemplate)).materialUrl, this.Gf.mAdTemplate);
    }

    private static void a(ImageView imageView, String str, AdTemplate adTemplate) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        KSImageLoader.loadImage(imageView, str, adTemplate, new DisplayImageOptionsCompat.Builder().setBlurRadius(20).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.splashscreen.presenter.endcard.d.3
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str2, View view, DecodedResult decodedResult) {
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final boolean onDecode(String str2, InputStream inputStream, DecodedResult decodedResult) {
                decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 20, false);
                return true;
            }
        });
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bt() {
        SplashEndLandView splashEndLandView = this.Iu;
        if (splashEndLandView != null) {
            splashEndLandView.bt();
        }
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bu() {
        SplashEndLandView splashEndLandView = this.Iu;
        if (splashEndLandView != null) {
            splashEndLandView.bu();
        }
    }
}
