package com.kwad.components.core.proxy;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: classes3.dex */
public class h extends KsFragment implements com.kwad.sdk.m.a.b {
    protected ViewGroup Wh;
    private final com.kwad.sdk.m.a.a mBackPressDelete = new com.kwad.sdk.m.a.a();
    protected Context mContext;
    protected ViewGroup nY;

    protected ViewGroup nj() {
        return null;
    }

    protected int qN() {
        return 0;
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            this.mContext = com.kwad.sdk.o.m.wrapContextIfNeed(getActivity());
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.mContext);
        this.Wh = viewGroup;
        if (this.nY == null) {
            ViewGroup viewGroupNj = nj();
            this.nY = viewGroupNj;
            if (viewGroupNj == null && qN() != 0) {
                this.nY = (ViewGroup) layoutInflaterFrom.inflate(qN(), viewGroup, false);
            }
        }
        return this.nY;
    }

    public final <T extends View> T findViewById(int i) {
        ViewGroup viewGroup = this.nY;
        if (viewGroup == null) {
            throw new IllegalArgumentException("ID does not reference a View inside this View");
        }
        return (T) viewGroup.findViewById(i);
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroy() {
        super.onDestroy();
        if (getHost() != null) {
            com.kwad.components.core.t.g.destroyFragment(this.mContext, getView());
        }
    }

    public boolean onBackPressed() {
        return this.mBackPressDelete.onBackPressed();
    }
}
