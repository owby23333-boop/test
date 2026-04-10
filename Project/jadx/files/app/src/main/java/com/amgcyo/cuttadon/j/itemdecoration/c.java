package com.amgcyo.cuttadon.j.itemdecoration;

import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: GridItem.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends RecyclerView.ItemDecoration {
    private int a;
    private int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f4067c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f4068d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f4069e;

    public c(int i2, int i3, boolean z2) {
        this.a = i2;
        this.b = i3;
        this.f4067c = z2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NonNull Rect rect, @NonNull View view, RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int i2 = this.a;
        int i3 = childAdapterPosition % i2;
        if (!this.f4067c) {
            int i4 = this.b;
            rect.left = (i3 * i4) / i2;
            rect.right = i4 - (((i3 + 1) * i4) / i2);
            return;
        }
        int i5 = this.b;
        rect.left = i5 - ((i3 * i5) / i2);
        rect.right = ((i3 + 1) * i5) / i2;
        if (childAdapterPosition < i2 && this.f4069e) {
            rect.top = i5;
        }
        if (this.f4068d) {
            rect.bottom = this.b;
        }
    }
}
