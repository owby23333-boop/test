package com.kwad.components.ad.splashscreen.b.kwai;

import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.splashscreen.widget.CloseCountDownView;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.io.InputStream;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends com.kwad.components.ad.splashscreen.b.e implements com.kwad.sdk.core.g.c {
    private CloseCountDownView DV;
    private ImageView DY;
    private TextView DZ;
    private TextView Ea;
    private ViewGroup Ed;
    private ImageView Ee;
    private KsLogoView Ef;
    private TextView Eg;
    private TextView Eh;

    private static void a(ImageView imageView, String str, AdTemplate adTemplate) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        KSImageLoader.loadImage(imageView, str, adTemplate, new DisplayImageOptionsCompat.Builder().setBlurRadius(20).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.splashscreen.b.kwai.d.2
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final boolean onDecode(String str2, InputStream inputStream, DecodedResult decodedResult) {
                decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 20, false);
                return true;
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str2, View view, DecodedResult decodedResult) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ac(String str) {
        this.Eg.setText(str);
    }

    private void initView() {
        ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_splash_endcard_view_stub);
        this.Ed = (ViewGroup) (viewStub != null ? viewStub.inflate() : findViewById(R.id.ksad_splash_end_card_native_root));
        this.Ee = (ImageView) findViewById(R.id.ksad_splash_end_card_native_bg);
        this.DY = (ImageView) findViewById(R.id.ksad_ad_endcard_icon);
        this.DZ = (TextView) findViewById(R.id.ksad_ad_endcard_appname);
        this.Ea = (TextView) findViewById(R.id.ksad_ad_endcard_appdesc);
        this.Ef = (KsLogoView) findViewById(R.id.ksad_ad_endcard_logo);
        this.Eg = (TextView) findViewById(R.id.ksad_ad_btn_title);
        this.Eh = (TextView) findViewById(R.id.ksad_ad_btn_sub_title);
        this.DV = (CloseCountDownView) findViewById(R.id.ksad_ad_endcard_close_root);
    }

    private void lH() {
        if (com.kwad.sdk.core.response.a.a.ay(com.kwad.sdk.core.response.a.d.cb(this.Cx.mAdTemplate))) {
            com.kwad.components.ad.splashscreen.e.a aVar = new com.kwad.components.ad.splashscreen.e.a(getContext(), this.Cx.mAdTemplate) { // from class: com.kwad.components.ad.splashscreen.b.kwai.d.1
                @Override // com.kwad.components.ad.splashscreen.e.a
                public final void aa(String str) {
                    d.this.ac(str);
                }
            };
            com.kwad.components.core.d.b.c cVar = this.Cx.mApkDownloadHelper;
            if (cVar != null) {
                cVar.b(aVar);
            }
        }
    }

    private void lI() {
        this.Ed.setVisibility(0);
        AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(this.Cx.mAdTemplate);
        a(this.Ee, com.kwad.sdk.core.response.a.a.aN(adInfoCb).materialUrl, this.Cx.mAdTemplate);
        this.DY.setImageResource(R.drawable.ksad_default_app_icon);
        KSImageLoader.loadAppIcon(this.DY, com.kwad.sdk.core.response.a.a.bL(adInfoCb), this.Cx.mAdTemplate, 24);
        this.DZ.setText(com.kwad.sdk.core.response.a.a.bJ(adInfoCb));
        this.Ea.setText(com.kwad.sdk.core.response.a.a.ao(adInfoCb));
        this.Ef.U(this.Cx.mAdTemplate);
        if (com.kwad.sdk.core.response.a.a.ay(adInfoCb)) {
            t(adInfoCb);
        } else {
            this.Eg.setText("点击查看");
            this.Eh.setVisibility(0);
            this.Eh.setText("跳转详情页/第三方应用");
        }
        this.DV.a(adInfoCb);
    }

    private void t(AdInfo adInfo) {
        com.kwad.components.core.d.b.c cVar = this.Cx.mApkDownloadHelper;
        if (cVar == null) {
            return;
        }
        int iNw = cVar.nw();
        AdMatrixInfo.DownloadTexts downloadTextsCM = com.kwad.sdk.core.response.a.b.cM(adInfo);
        String str = iNw != 8 ? iNw != 12 ? downloadTextsCM.adActionDescription : downloadTextsCM.openAppLabel : downloadTextsCM.installAppLabel;
        if (TextUtils.isEmpty(str)) {
            this.Eg.setText(com.kwad.sdk.core.response.a.a.ax(adInfo));
        } else {
            this.Eg.setText(str);
        }
    }

    @Override // com.kwad.sdk.core.g.c
    public final void aS() {
        this.DV.aS();
    }

    @Override // com.kwad.sdk.core.g.c
    public final void aT() {
        this.DV.aT();
    }

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.Cx.BZ.a(this);
        com.kwad.sdk.core.report.a.b(this.Cx.mAdTemplate, 87, (JSONObject) null);
        lH();
        lI();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        initView();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.DV.bn();
        this.Cx.BZ.b(this);
    }
}
