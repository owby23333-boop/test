package com.kwad.components.ad.feed.widget;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.utils.bg;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends b {
    public h(Context context) {
        super(context);
        setRadiusDp(12);
    }

    @Override // com.kwad.components.ad.feed.widget.b, com.kwad.components.core.widget.b
    public final void bw() {
        super.bw();
        View viewFindViewById = findViewById(R.id.ksad_feed_novel_image);
        if (viewFindViewById != null) {
            viewFindViewById.setClipToOutline(true);
        }
    }

    @Override // com.kwad.components.core.widget.b
    public final int getLayoutId() {
        return R.layout.ksad_feed_novel_regular_image;
    }

    @Override // com.kwad.components.core.widget.b
    public final void setMargin(int i) {
        if (com.kwad.sdk.core.config.e.Gh()) {
            return;
        }
        setBackgroundColor(-1);
    }

    @Override // com.kwad.components.ad.feed.widget.b
    public final void cl() {
        this.hB.post(new bg() { // from class: com.kwad.components.ad.feed.widget.h.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                ViewGroup.LayoutParams layoutParams = h.this.hD.getLayoutParams();
                layoutParams.width = h.this.getWidth();
                h.this.hD.setRatio(1.7857142686843872d);
                h.this.hD.setLayoutParams(layoutParams);
                List<String> listBa = com.kwad.sdk.core.response.b.a.ba(h.this.mAdInfo);
                if (listBa.size() > 0) {
                    h.this.ht = SystemClock.elapsedRealtime();
                    KSImageLoader.loadFeeImage(h.this.hB, listBa.get(0), h.this.mAdTemplate, h.this.hy);
                    return;
                }
                com.kwad.sdk.core.d.c.e("FeedNovelImageView", "getImageUrlList size less than one");
            }
        });
    }
}
