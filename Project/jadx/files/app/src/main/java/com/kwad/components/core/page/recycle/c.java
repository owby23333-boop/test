package com.kwad.components.core.page.recycle;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.mvp.Presenter;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends RecyclerView.ViewHolder {
    public final e Lo;
    public final Presenter mPresenter;

    public c(View view, Presenter presenter, e eVar) {
        super(view);
        this.Lo = eVar;
        this.mPresenter = presenter;
        presenter.H(view);
    }
}
