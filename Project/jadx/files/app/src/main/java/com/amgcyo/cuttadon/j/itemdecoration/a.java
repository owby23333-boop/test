package com.amgcyo.cuttadon.j.itemdecoration;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: DividerDecoration.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends RecyclerView.ItemDecoration {
    private int a;
    private int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f4061c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Paint f4062d;

    /* JADX INFO: compiled from: DividerDecoration.java */
    public static class b {
        private Context a;
        private Resources b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f4063c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f4064d = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f4065e = 0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f4066f = -16777216;

        public b(Context context) {
            this.a = context;
            this.b = context.getResources();
            this.f4063c = (int) TypedValue.applyDimension(0, 1.0f, context.getResources().getDisplayMetrics());
        }

        public b a(@ColorInt int i2) {
            this.f4066f = i2;
            return this;
        }

        public b b(@ColorRes int i2) {
            a(ContextCompat.getColor(this.a, i2));
            return this;
        }

        public b c(@DimenRes int i2) {
            this.f4063c = this.b.getDimensionPixelSize(i2);
            return this;
        }

        public b d(@DimenRes int i2) {
            this.f4064d = this.b.getDimensionPixelSize(i2);
            return this;
        }

        public b e(@DimenRes int i2) {
            d(i2);
            f(i2);
            return this;
        }

        public b f(@DimenRes int i2) {
            this.f4065e = this.b.getDimensionPixelSize(i2);
            return this;
        }

        public a a() {
            return new a(this.f4063c, this.f4064d, this.f4065e, this.f4066f);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        recyclerView.getAdapter();
        recyclerView.getChildAdapterPosition(view);
        rect.set(0, 0, 0, this.a);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        recyclerView.getAdapter();
        int childCount = recyclerView.getChildCount() - 1;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = recyclerView.getChildAt(i2);
            int bottom = childAt.getBottom();
            int i3 = this.a + bottom;
            int left = childAt.getLeft() + this.b;
            int right = childAt.getRight() - this.f4061c;
            recyclerView.getChildAdapterPosition(childAt);
            canvas.save();
            canvas.drawRect(left, bottom, right, i3, this.f4062d);
            canvas.restore();
        }
    }

    private a(int i2, int i3, int i4, int i5) {
        this.a = i2;
        this.b = i3;
        this.f4061c = i4;
        this.f4062d = new Paint();
        this.f4062d.setColor(i5);
    }
}
