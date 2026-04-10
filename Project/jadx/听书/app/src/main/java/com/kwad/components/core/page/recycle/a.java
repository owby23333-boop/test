package com.kwad.components.core.page.recycle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.components.core.proxy.h;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a extends h {
    private RecyclerView Uv;
    private d Uw;

    protected abstract d a(RecyclerView recyclerView);

    private void rw() {
        RecyclerView recyclerView = (RecyclerView) findViewById(rA());
        this.Uv = recyclerView;
        recyclerView.setItemAnimator(null);
        this.Uv.setLayoutManager(rz());
        this.Uw = a(this.Uv);
    }

    private void rx() {
        this.Uv.setAdapter(this.Uw);
    }

    public final RecyclerView ry() {
        return this.Uv;
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        rw();
        rx();
    }

    private RecyclerView.LayoutManager rz() {
        return new LinearLayoutManager(this.mContext);
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroyView() {
        super.onDestroyView();
        this.Uv.clearOnChildAttachStateChangeListeners();
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onPause() {
        super.onPause();
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onResume() {
        super.onResume();
    }

    @Override // com.kwad.components.core.proxy.h, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public void onDestroy() {
        super.onDestroy();
    }

    private static int rA() {
        return R.id.ksad_recycler_view;
    }
}
