package com.kwad.components.ad.k;

import com.kwad.components.core.video.i;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a<L extends i> {
    public AdTemplate mAdTemplate;

    public abstract void a(L l);

    public abstract void b(L l);

    public long getPlayDuration() {
        return 0L;
    }

    public boolean kR() {
        return false;
    }

    public abstract void pause();

    public void release() {
    }

    public abstract void resume();

    public void setAudioEnabled(boolean z, boolean z2) {
    }

    public void skipToEnd() {
    }

    public a(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }
}
