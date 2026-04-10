package com.google.android.material.datepicker;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: SmoothCalendarLayoutManager.java */
/* JADX INFO: loaded from: classes2.dex */
class l extends LinearLayoutManager {

    /* JADX INFO: compiled from: SmoothCalendarLayoutManager.java */
    class a extends LinearSmoothScroller {
        a(l lVar, Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return 100.0f / displayMetrics.densityDpi;
        }
    }

    l(Context context, int i2, boolean z2) {
        super(context, i2, z2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i2) {
        a aVar = new a(this, recyclerView.getContext());
        aVar.setTargetPosition(i2);
        startSmoothScroll(aVar);
    }
}
