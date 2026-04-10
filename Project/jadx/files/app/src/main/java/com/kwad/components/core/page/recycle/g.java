package com.kwad.components.core.page.recycle;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes3.dex */
public class g extends RecyclerView {
    private boolean MX;

    public g(Context context) {
        super(context);
    }

    public g(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public g(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    protected void removeDetachedView(View view, boolean z2) {
        boolean z3 = this.MX;
        super.removeDetachedView(view, z2);
    }

    public void setIngoreTmpDetachedFlag(boolean z2) {
        this.MX = z2;
    }
}
