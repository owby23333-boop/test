package com.kwad.components.core.page.recycle;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.kwad.sdk.mvp.Presenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d extends RecyclerView.Adapter<c> {
    private List<Presenter> Va = new ArrayList();

    protected abstract c c(ViewGroup viewGroup, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public c onCreateViewHolder(ViewGroup viewGroup, int i) {
        c cVarC = c(viewGroup, i);
        this.Va.add(cVarC.mPresenter);
        return cVarC;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(c cVar, int i) {
        cVar.mPresenter.n(cVar.Th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(c cVar) {
        super.onViewRecycled(cVar);
        cVar.mPresenter.ny();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        rG();
    }

    public final void rG() {
        Iterator<Presenter> it = this.Va.iterator();
        while (it.hasNext()) {
            it.next().destroy();
        }
    }
}
