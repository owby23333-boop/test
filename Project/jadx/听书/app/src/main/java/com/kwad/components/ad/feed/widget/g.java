package com.kwad.components.ad.feed.widget;

import android.content.Context;
import android.view.View;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends c {
    public g(Context context) {
        super(context);
        setmIsShowComplianceView(false);
        setRadiusDp(4);
    }

    @Override // com.kwad.components.ad.feed.widget.c, com.kwad.components.core.widget.b
    public final void bw() {
        super.bw();
        View viewFindViewById = findViewById(R.id.ksad_feed_biserial_video);
        if (viewFindViewById != null) {
            viewFindViewById.setClipToOutline(true);
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final int getLayoutId() {
        return R.layout.ksad_feed_biserial_video;
    }

    @Override // com.kwad.components.core.widget.b
    public final void setMargin(int i) {
        if (com.kwad.sdk.core.config.e.Gh()) {
            return;
        }
        setBackgroundColor(-1);
    }

    @Override // com.kwad.components.ad.feed.widget.c
    protected final void cr() {
        this.hL.setRatio(1.7857143f);
    }
}
