package com.kwad.components.ad.feed.a;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.components.core.widget.ComplianceTextView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends com.kwad.components.core.widget.b<AdTemplate> {
    private boolean ev;
    protected long ew;
    protected SimpleImageLoadingListener ex;

    public a(@NonNull Context context) {
        super(context);
        this.ex = new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.feed.a.a.1
            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
                com.kwad.components.ad.feed.monitor.a.a(a.this.mAdTemplate, 1, 2, str, null, SystemClock.elapsedRealtime() - a.this.ew);
            }

            @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
            public final void onLoadingFailed(String str, View view, FailReason failReason) {
                com.kwad.components.ad.feed.monitor.a.a(a.this.mAdTemplate, 2, 2, str, failReason.toString(), SystemClock.elapsedRealtime() - a.this.ew);
            }
        };
    }

    public final void bi() {
        if (this.ev) {
            return;
        }
        this.ev = true;
        com.kwad.components.ad.feed.monitor.a.a(this.mAdTemplate, 1, getStayTime());
    }

    protected final void bj() {
        ComplianceTextView complianceTextView = (ComplianceTextView) findViewById(R.id.ksad_compliance_view);
        if (!com.kwad.sdk.core.response.a.a.aI(this.mAdInfo)) {
            complianceTextView.setVisibility(8);
        } else {
            complianceTextView.setVisibility(0);
            complianceTextView.setAdTemplate(this.mAdTemplate);
        }
    }
}
