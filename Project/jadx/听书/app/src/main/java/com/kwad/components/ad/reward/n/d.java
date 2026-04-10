package com.kwad.components.ad.reward.n;

import android.view.ViewGroup;
import com.kwad.sdk.utils.aq;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d {
    protected void a(r rVar) {
    }

    protected void ac(boolean z) {
    }

    public abstract ViewGroup hP();

    public void onUnbind() {
    }

    public final void b(r rVar) {
        a(rVar);
        hP().getContext();
        ac(aq.QW());
    }
}
