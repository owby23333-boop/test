package com.kwad.components.ad.reward.m;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.kwad.components.ad.reward.g;
import com.kwad.components.core.video.i;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends com.kwad.components.ad.k.a<i> implements g.a {
    private com.kwad.components.core.h.c Bg;

    @Override // com.kwad.components.ad.reward.g.a
    public final void hd() {
    }

    public b(AdTemplate adTemplate) {
        super(adTemplate);
        long jM = com.kwad.sdk.core.response.b.a.M(com.kwad.sdk.core.response.b.e.el(adTemplate));
        com.kwad.components.core.h.c cVar = new com.kwad.components.core.h.c();
        this.Bg = cVar;
        cVar.E(jM);
    }

    public final FrameLayout T(Context context) {
        FrameLayout imagePlayerView = this.Bg.getImagePlayerView(context);
        this.Bg.setImageScaleType(ImageView.ScaleType.FIT_CENTER);
        return imagePlayerView;
    }

    public final void kS() {
        this.Bg.setURLs(com.kwad.sdk.core.response.b.a.ba(com.kwad.sdk.core.response.b.e.el(this.mAdTemplate)));
        this.Bg.play();
    }

    @Override // com.kwad.components.ad.k.a
    public final void skipToEnd() {
        this.Bg.skipToEnd();
    }

    @Override // com.kwad.components.ad.k.a
    public final long getPlayDuration() {
        return this.Bg.getPlayDuration();
    }

    @Override // com.kwad.components.ad.k.a
    public final void resume() {
        this.Bg.resume();
    }

    @Override // com.kwad.components.ad.k.a
    public final void pause() {
        this.Bg.pause();
    }

    @Override // com.kwad.components.ad.k.a
    public final void b(i iVar) {
        this.Bg.c(iVar);
    }

    @Override // com.kwad.components.ad.k.a
    public final void a(i iVar) {
        this.Bg.d(iVar);
    }

    @Override // com.kwad.components.ad.k.a
    public final void release() {
        super.release();
        this.Bg.destroy();
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void he() {
        resume();
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void hf() {
        pause();
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void hg() {
        this.Bg.destroy();
    }
}
