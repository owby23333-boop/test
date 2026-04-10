package com.kwad.components.ad.reward.presenter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ah;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class b extends a {
    private ImageView sq;
    private AdInfo sr;

    public b(AdInfo adInfo) {
        this.sr = adInfo;
    }

    public static void a(ImageView imageView, String str, AdTemplate adTemplate) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        KSImageLoader.loadImage(imageView, str, adTemplate, new DisplayImageOptionsCompat.Builder().setBlurRadius(50).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.reward.presenter.b.1
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final boolean onDecode(String str2, InputStream inputStream, DecodedResult decodedResult) {
                decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
                return true;
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str2, View view, DecodedResult decodedResult) {
            }
        });
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        AdTemplate adTemplate = this.qS.mAdTemplate;
        if (adTemplate.adInfoList.size() > 0) {
            String strP = com.kwad.sdk.core.response.a.a.P(adTemplate.adInfoList.get(0));
            this.sq.setVisibility(hJ());
            a(this.sq, strP, adTemplate);
        }
    }

    protected int hI() {
        return R.id.ksad_blur_video_cover;
    }

    protected int hJ() {
        Context context = getContext();
        if (com.kwad.components.ad.reward.j.q(this.qS.mAdTemplate) && !ah.cu(context)) {
            return 0;
        }
        if (com.kwad.components.ad.reward.j.p(this.qS.mAdTemplate) && !ah.cu(context)) {
            return 0;
        }
        if ((!com.kwad.sdk.core.response.a.d.cn(this.qS.mAdTemplate) || ah.cu(context)) && !com.kwad.components.ad.reward.j.h(this.sr)) {
            return (com.kwad.sdk.core.response.a.a.cg(this.sr) && com.kwad.components.ad.reward.kwai.b.hb() && !ah.cu(context)) ? 0 : 8;
        }
        return 0;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.sq = (ImageView) findViewById(hI());
    }
}
