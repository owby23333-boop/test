package com.kwad.components.ad.reward.n;

import android.view.ViewGroup;
import android.view.ViewStub;

/* JADX INFO: loaded from: classes3.dex */
public abstract class s extends d {
    protected ViewGroup vV;

    public final void a(ViewGroup viewGroup, int i, int i2) {
        if (this.vV != null) {
            return;
        }
        ViewStub viewStub = (ViewStub) viewGroup.findViewById(i);
        if (viewStub != null) {
            this.vV = (ViewGroup) viewStub.inflate();
        } else {
            this.vV = (ViewGroup) viewGroup.findViewById(i2);
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    public ViewGroup hP() {
        return this.vV;
    }
}
