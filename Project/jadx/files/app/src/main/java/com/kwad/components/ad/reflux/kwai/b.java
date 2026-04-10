package com.kwad.components.ad.reflux.kwai;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.components.ad.widget.DownloadProgressView;
import com.kwad.components.core.widget.ComplianceTextView;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends a {
    private ImageView oL;

    public b(@NonNull Context context) {
        super(context);
    }

    @Override // com.kwad.components.ad.reflux.kwai.a
    protected final void O(@NonNull Context context) {
        com.kwad.sdk.i.a.inflate(context, R.layout.ksad_reflux_card_left, this);
        this.oC = (TextView) findViewById(R.id.ksad_reflux_card_title);
        this.oG = (ImageView) findViewById(R.id.ksad_reflux_card_img);
        this.oH = (KsLogoView) findViewById(R.id.ksad_reflux_card_logo);
        this.oF = (ImageView) findViewById(R.id.ksad_reflux_app_icon);
        this.oD = (TextView) findViewById(R.id.ksad_reflux_app_name);
        this.oE = (TextView) findViewById(R.id.ksad_reflux_app_desc);
        this.cq = (ComplianceTextView) findViewById(R.id.ksad_reflux_card_title_compliance);
        this.eG = (DownloadProgressView) findViewById(R.id.ksad_reflux_app_download_btn);
        this.oL = (ImageView) findViewById(R.id.ksad_reflux_card_blur);
    }

    @Override // com.kwad.components.ad.reflux.kwai.a
    public final void a(com.kwad.components.ad.reflux.a aVar) {
        super.a(aVar);
        if (aVar == null || aVar.getAdTemplate() == null || this.oL == null) {
            return;
        }
        KSImageLoader.loadImage(this.oL, aVar.fr(), aVar.getAdTemplate(), new DisplayImageOptionsCompat.Builder().setBlurRadius(50).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.reflux.kwai.b.1
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
                decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
                return true;
            }
        });
    }
}
