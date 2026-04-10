package com.bytedance.sdk.openadsdk.core.ugeno.component.g;

import android.graphics.Rect;
import android.view.View;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g extends RecyclerView.v {
    private int dl;
    private z g;
    private boolean z = false;

    public abstract void g(RecyclerView recyclerView, int i);

    public abstract void z();

    public abstract void z(int i, int i2);

    public abstract void z(int i, View view);

    public g(z zVar) {
        this.g = zVar;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.v
    public void z(RecyclerView recyclerView, int i) {
        super.z(recyclerView, i);
        com.bytedance.sdk.component.widget.recycler.gc gcVar = (com.bytedance.sdk.component.widget.recycler.gc) recyclerView.getLayoutManager();
        if (i == 0) {
            int iKb = gcVar.kb();
            if (!z(gcVar.g(iKb), 50)) {
                iKb--;
            }
            int iMax = Math.max(0, Math.max(iKb, this.dl));
            for (int iMin = Math.min(this.dl, iKb); iMin <= iMax; iMin++) {
                z(iMin, gcVar.g(iMin));
            }
            this.dl = iKb;
            int iH = gcVar.h();
            this.g.z(recyclerView);
            if ((iKb == iH - 1 && this.z) || iH == 1) {
                z();
            }
        }
        g(recyclerView, i);
    }

    private int z(View view) {
        Rect rect = new Rect();
        if (!view.getLocalVisibleRect(rect) || view.getMeasuredHeight() <= 0) {
            return -1;
        }
        return (rect.height() * 100) / view.getMeasuredHeight();
    }

    private boolean z(View view, int i) {
        return view != null && view.getLocalVisibleRect(new Rect()) && view.getVisibility() == 0 && z(view) >= i;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.v
    public void z(RecyclerView recyclerView, int i, int i2) {
        super.z(recyclerView, i, i2);
        if (i2 == 0) {
            com.bytedance.sdk.component.widget.recycler.gc gcVar = (com.bytedance.sdk.component.widget.recycler.gc) recyclerView.getLayoutManager();
            this.dl = gcVar.uy();
            int iKb = gcVar.kb();
            if (!z(gcVar.g(iKb), 50)) {
                iKb--;
            }
            int iMax = Math.max(0, Math.max(iKb, this.dl));
            for (int i3 = this.dl; i3 <= iMax; i3++) {
                z(i3, gcVar.g(i3));
            }
        }
        this.z = i2 > 0;
        this.g.z();
        z(i, i2);
    }
}
