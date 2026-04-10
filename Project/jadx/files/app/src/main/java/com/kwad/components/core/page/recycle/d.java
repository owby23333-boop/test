package com.kwad.components.core.page.recycle;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.mvp.Presenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d extends RecyclerView.Adapter<c> {
    private List<Presenter> MU = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(c cVar) {
        super.onViewRecycled(cVar);
        cVar.mPresenter.ko();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public c onCreateViewHolder(ViewGroup viewGroup, int i2) {
        c cVarB = b(viewGroup, i2);
        this.MU.add(cVarB.mPresenter);
        return cVarB;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(c cVar, int i2) {
        cVar.mPresenter.f(cVar.Lo);
    }

    protected abstract c b(ViewGroup viewGroup, int i2);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        pd();
    }

    public final void pd() {
        Iterator<Presenter> it = this.MU.iterator();
        while (it.hasNext()) {
            it.next().destroy();
        }
    }
}
