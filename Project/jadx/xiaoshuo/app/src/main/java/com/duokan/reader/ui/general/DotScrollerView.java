package com.duokan.reader.ui.general;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.duokan.core.ui.LinearScrollView;
import com.duokan.core.ui.Scrollable;
import com.yuewen.st2;

/* JADX INFO: loaded from: classes5.dex */
public class DotScrollerView extends LinearLayout {
    public static final int e = 5;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearScrollView f5417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DotProgressBar f5418b;
    public Scrollable.b c;
    public boolean d;

    public class a implements Scrollable.b {
        public a() {
        }

        @Override // com.duokan.core.ui.Scrollable.b
        public void a(Scrollable scrollable, Scrollable.ScrollState scrollState, Scrollable.ScrollState scrollState2) {
            if (DotScrollerView.this.c != null) {
                DotScrollerView.this.c.a(scrollable, scrollState, scrollState2);
            }
        }

        @Override // com.duokan.core.ui.Scrollable.b
        public void b(Scrollable scrollable, boolean z) {
            DotScrollerView.this.e();
            if (DotScrollerView.this.c != null) {
                DotScrollerView.this.c.b(scrollable, z);
            }
        }
    }

    public class b implements ViewGroup.OnHierarchyChangeListener {
        public b() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            DotScrollerView.this.d = true;
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            DotScrollerView.this.d = true;
        }
    }

    public DotScrollerView(Context context) {
        this(context, null);
    }

    public void d(View view) {
        this.f5417a.addView(view, new LinearLayout.LayoutParams(-2, -2));
    }

    public final void e() {
        if (this.f5417a.b1()) {
            this.f5418b.setCurrentIndex(0);
            return;
        }
        if (this.f5417a.y0()) {
            this.f5418b.setCurrentIndex(5);
            return;
        }
        this.f5418b.setCurrentIndex(Math.round((this.f5417a.getViewportBounds().centerX() * 1.0f) / (this.f5417a.getContentWidth() / 5)));
    }

    public LinearScrollView getScrollView() {
        return this.f5417a;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z || this.d) {
            this.d = false;
            if (!this.f5417a.R1()) {
                this.f5418b.setVisibility(4);
            } else {
                this.f5418b.setVisibility(0);
                e();
            }
        }
    }

    public void setOnScrollListener(Scrollable.b bVar) {
        this.c = bVar;
    }

    public DotScrollerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = null;
        this.d = false;
        LayoutInflater.from(getContext()).inflate(st2.n.a5, this);
        LinearScrollView linearScrollView = (LinearScrollView) findViewById(st2.k.pm);
        this.f5417a = linearScrollView;
        DotProgressBar dotProgressBar = (DotProgressBar) findViewById(st2.k.om);
        this.f5418b = dotProgressBar;
        linearScrollView.setThumbEnabled(false);
        dotProgressBar.setNums(5);
        dotProgressBar.setCurrentIndex(0);
        linearScrollView.setOnScrollListener(new a());
        linearScrollView.setOnHierarchyChangeListener(new b());
    }
}
