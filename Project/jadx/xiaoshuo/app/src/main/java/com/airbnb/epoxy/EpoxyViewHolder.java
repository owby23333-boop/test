package com.airbnb.epoxy;

import android.view.View;
import android.view.ViewParent;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.epoxy.ViewHolderState;
import com.yuewen.w51;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class EpoxyViewHolder extends RecyclerView.ViewHolder {
    private EpoxyHolder epoxyHolder;
    private EpoxyModel epoxyModel;

    @Nullable
    ViewHolderState.ViewState initialViewState;
    private ViewParent parent;
    private List<Object> payloads;

    public EpoxyViewHolder(ViewParent viewParent, View view, boolean z) {
        super(view);
        this.parent = viewParent;
        if (z) {
            ViewHolderState.ViewState viewState = new ViewHolderState.ViewState();
            this.initialViewState = viewState;
            viewState.save(this.itemView);
        }
    }

    private void assertBound() {
        if (this.epoxyModel == null) {
            throw new IllegalStateException("This holder is not currently bound.");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void bind(EpoxyModel epoxyModel, @Nullable EpoxyModel<?> epoxyModel2, List<Object> list, int i) {
        this.payloads = list;
        if (this.epoxyHolder == null && (epoxyModel instanceof EpoxyModelWithHolder)) {
            EpoxyHolder epoxyHolderCreateNewHolder = ((EpoxyModelWithHolder) epoxyModel).createNewHolder(this.parent);
            this.epoxyHolder = epoxyHolderCreateNewHolder;
            epoxyHolderCreateNewHolder.bindView(this.itemView);
        }
        this.parent = null;
        if (epoxyModel instanceof GeneratedModel) {
            ((GeneratedModel) epoxyModel).handlePreBind(this, objectToBind(), i);
        }
        epoxyModel.preBind(objectToBind(), epoxyModel2);
        if (epoxyModel2 != null) {
            epoxyModel.bind(objectToBind(), epoxyModel2);
        } else if (list.isEmpty()) {
            epoxyModel.bind(objectToBind());
        } else {
            epoxyModel.bind(objectToBind(), list);
        }
        if (epoxyModel instanceof GeneratedModel) {
            ((GeneratedModel) epoxyModel).handlePostBind(objectToBind(), i);
        }
        this.epoxyModel = epoxyModel;
    }

    public EpoxyHolder getHolder() {
        assertBound();
        return this.epoxyHolder;
    }

    public EpoxyModel<?> getModel() {
        assertBound();
        return this.epoxyModel;
    }

    public List<Object> getPayloads() {
        assertBound();
        return this.payloads;
    }

    @NonNull
    public Object objectToBind() {
        EpoxyHolder epoxyHolder = this.epoxyHolder;
        return epoxyHolder != null ? epoxyHolder : this.itemView;
    }

    public void restoreInitialViewState() {
        ViewHolderState.ViewState viewState = this.initialViewState;
        if (viewState != null) {
            viewState.restore(this.itemView);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ViewHolder
    public String toString() {
        return "EpoxyViewHolder{epoxyModel=" + this.epoxyModel + ", view=" + this.itemView + ", super=" + super.toString() + '}';
    }

    public void unbind() {
        assertBound();
        this.epoxyModel.unbind(objectToBind());
        this.epoxyModel = null;
        this.payloads = null;
    }

    public void visibilityChanged(@FloatRange(from = w51.l, to = 100.0d) float f, @FloatRange(from = w51.l, to = 100.0d) float f2, @Px int i, @Px int i2) {
        assertBound();
        this.epoxyModel.onVisibilityChanged(f, f2, i, i2, objectToBind());
    }

    public void visibilityStateChanged(int i) {
        assertBound();
        this.epoxyModel.onVisibilityStateChanged(i, objectToBind());
    }
}
