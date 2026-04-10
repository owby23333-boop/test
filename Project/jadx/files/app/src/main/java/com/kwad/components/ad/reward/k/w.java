package com.kwad.components.ad.reward.k;

import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.annotation.IdRes;

/* JADX INFO: loaded from: classes3.dex */
public abstract class w extends d {
    protected ViewGroup sN;

    public final void a(ViewGroup viewGroup, @IdRes int i2, @IdRes int i3) {
        if (this.sN != null) {
            return;
        }
        ViewStub viewStub = (ViewStub) viewGroup.findViewById(i2);
        this.sN = (ViewGroup) (viewStub != null ? viewStub.inflate() : viewGroup.findViewById(i3));
    }

    @Override // com.kwad.components.ad.reward.k.d
    public ViewGroup hc() {
        return this.sN;
    }
}
