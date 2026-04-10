package com.kwad.components.core.page.recycle;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes4.dex */
public class g extends RecyclerView {
    private boolean Vd;

    public g(Context context) {
        super(context);
    }

    public g(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public g(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setIngoreTmpDetachedFlag(boolean z) {
        this.Vd = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    protected void removeDetachedView(View view, boolean z) {
        if (!this.Vd) {
            super.removeDetachedView(view, z);
        } else {
            super.removeDetachedView(view, z);
        }
    }
}
