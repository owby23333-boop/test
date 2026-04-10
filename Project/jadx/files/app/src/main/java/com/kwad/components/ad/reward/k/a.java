package com.kwad.components.ad.reward.k;

import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public class a implements b {
    private Context mContext;
    private com.kwad.components.ad.reward.j qS;

    public a(Context context, com.kwad.components.ad.reward.j jVar) {
        this.qS = jVar;
        this.mContext = context;
    }

    @Override // com.kwad.components.ad.reward.k.b
    public final void hg() {
        this.qS.a(1, this.mContext, 1, 1);
    }

    @Override // com.kwad.components.ad.reward.k.b
    public void iy() {
        this.qS.a(1, this.mContext, 13, 2);
    }

    @Override // com.kwad.components.ad.reward.k.b
    public void iz() {
        this.qS.a(1, this.mContext, 117, 2);
    }
}
