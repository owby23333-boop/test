package com.amgcyo.cuttadon.j.itemdecoration;

import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/* JADX INFO: compiled from: GridSpaceItemDecoration.java */
/* JADX INFO: loaded from: classes.dex */
public class e extends RecyclerView.ItemDecoration {
    private int a;
    private int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f4076c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f4077d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f4078e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f4079f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f4080g = 1;

    public e(int i2, boolean z2) {
        this.b = i2;
        this.f4076c = z2;
    }

    public e a(int i2) {
        this.f4078e = i2;
        return this;
    }

    public e b(int i2) {
        this.f4077d = i2;
        return this;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        boolean zIsFullSpan;
        int spanIndex;
        int spanGroupIndex;
        int itemCount = state.getItemCount() - 1;
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (this.f4077d > childAdapterPosition || childAdapterPosition > itemCount - this.f4078e) {
            return;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        boolean z2 = false;
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            GridLayoutManager.SpanSizeLookup spanSizeLookup = gridLayoutManager.getSpanSizeLookup();
            int spanCount = gridLayoutManager.getSpanCount();
            int spanSize = spanSizeLookup.getSpanSize(childAdapterPosition);
            this.f4080g = gridLayoutManager.getOrientation();
            this.a = spanCount / spanSize;
            spanIndex = spanSizeLookup.getSpanIndex(childAdapterPosition, spanCount) / spanSize;
            spanGroupIndex = spanSizeLookup.getSpanGroupIndex(childAdapterPosition, spanCount) - this.f4077d;
            zIsFullSpan = false;
        } else {
            if (layoutManager instanceof StaggeredGridLayoutManager) {
                StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
                StaggeredGridLayoutManager.LayoutParams layoutParams = (StaggeredGridLayoutManager.LayoutParams) view.getLayoutParams();
                this.f4080g = staggeredGridLayoutManager.getOrientation();
                int spanIndex2 = layoutParams.getSpanIndex();
                zIsFullSpan = layoutParams.isFullSpan();
                this.a = staggeredGridLayoutManager.getSpanCount();
                spanIndex = spanIndex2;
            } else {
                zIsFullSpan = false;
                spanIndex = 0;
            }
            spanGroupIndex = -1;
        }
        int i2 = childAdapterPosition - this.f4077d;
        if (this.f4076c) {
            if (zIsFullSpan) {
                rect.left = 0;
                rect.right = 0;
            } else if (this.f4080g == 1) {
                int i3 = this.b;
                int i4 = this.a;
                rect.left = i3 - ((spanIndex * i3) / i4);
                rect.right = ((spanIndex + 1) * i3) / i4;
            } else {
                int i5 = this.b;
                int i6 = this.a;
                rect.top = i5 - ((spanIndex * i5) / i6);
                rect.bottom = ((spanIndex + 1) * i5) / i6;
            }
            if (spanGroupIndex <= -1) {
                if (this.f4079f == -1 && i2 < this.a && zIsFullSpan) {
                    this.f4079f = i2;
                }
                int i7 = this.f4079f;
                if ((i7 == -1 || i2 < i7) && i2 < this.a) {
                    z2 = true;
                }
                if (z2) {
                    if (this.f4080g == 1) {
                        rect.top = this.b;
                    } else {
                        rect.left = this.b;
                    }
                }
            } else if (spanGroupIndex < 1 && i2 < this.a) {
                if (this.f4080g == 1) {
                    rect.top = this.b;
                } else {
                    rect.left = this.b;
                }
            }
            if (this.f4080g == 1) {
                rect.bottom = this.b;
                return;
            } else {
                rect.right = this.b;
                return;
            }
        }
        if (zIsFullSpan) {
            rect.left = 0;
            rect.right = 0;
        } else if (this.f4080g == 1) {
            int i8 = this.b;
            int i9 = this.a;
            rect.left = (spanIndex * i8) / i9;
            rect.right = i8 - (((spanIndex + 1) * i8) / i9);
        } else {
            int i10 = this.b;
            int i11 = this.a;
            rect.top = (spanIndex * i10) / i11;
            rect.bottom = i10 - (((spanIndex + 1) * i10) / i11);
        }
        if (spanGroupIndex > -1) {
            if (spanGroupIndex >= 1) {
                if (this.f4080g == 1) {
                    rect.top = this.b;
                    return;
                } else {
                    rect.left = this.b;
                    return;
                }
            }
            return;
        }
        if (this.f4079f == -1 && i2 < this.a && zIsFullSpan) {
            this.f4079f = i2;
        }
        if (i2 >= this.a || ((zIsFullSpan && i2 != 0) || (this.f4079f != -1 && i2 != 0))) {
            z2 = true;
        }
        if (z2) {
            if (this.f4080g == 1) {
                rect.top = this.b;
            } else {
                rect.left = this.b;
            }
        }
    }
}
