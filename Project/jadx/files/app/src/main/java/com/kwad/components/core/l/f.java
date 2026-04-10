package com.kwad.components.core.l;

import com.kwad.components.core.r.i;
import com.kwad.sdk.api.core.fragment.KsFragment;

/* JADX INFO: loaded from: classes3.dex */
public class f extends KsFragment implements com.kwad.sdk.h.kwai.b {
    private final com.kwad.sdk.h.kwai.a mBackPressDelete = new com.kwad.sdk.h.kwai.a();
    private boolean enableDestroyer = true;

    @Override // com.kwad.sdk.h.kwai.b
    public boolean bX() {
        return this.mBackPressDelete.bX();
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroy() {
        super.onDestroy();
        if (!this.enableDestroyer || getHost() == null) {
            return;
        }
        i.destroyFragment(getContext(), getView());
    }
}
