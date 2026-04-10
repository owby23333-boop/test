package com.kwad.components.ad.reward.k;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.kwad.sdk.utils.ah;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d {
    protected void a(v vVar) {
    }

    protected void ad(boolean z2) {
    }

    public final void b(@NonNull v vVar) {
        a(vVar);
        ad(ah.cu(hc().getContext()));
    }

    public abstract ViewGroup hc();

    public void onUnbind() {
    }
}
