package com.kwad.components.ad.reflux.kwai;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.components.ad.widget.DownloadProgressView;
import com.kwad.components.core.widget.ComplianceTextView;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends a {
    public c(@NonNull Context context) {
        super(context);
    }

    @Override // com.kwad.components.ad.reflux.kwai.a
    protected final void O(@NonNull Context context) {
        com.kwad.sdk.i.a.inflate(context, R.layout.ksad_reflux_card_top, this);
        this.oC = (TextView) findViewById(R.id.ksad_reflux_card_title);
        this.oG = (ImageView) findViewById(R.id.ksad_reflux_card_img);
        this.oH = (KsLogoView) findViewById(R.id.ksad_reflux_card_logo);
        this.oF = (ImageView) findViewById(R.id.ksad_reflux_app_icon);
        this.oD = (TextView) findViewById(R.id.ksad_reflux_app_name);
        this.oE = (TextView) findViewById(R.id.ksad_reflux_app_desc);
        this.cq = (ComplianceTextView) findViewById(R.id.ksad_reflux_card_title_compliance);
        this.eG = (DownloadProgressView) findViewById(R.id.ksad_reflux_app_download_btn);
    }
}
