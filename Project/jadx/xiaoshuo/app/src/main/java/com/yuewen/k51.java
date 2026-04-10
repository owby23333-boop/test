package com.yuewen;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class k51 extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewGroup f13375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f13376b;
    public LinkedHashMap<View, RelativeLayout.LayoutParams> c;
    public boolean d;

    public k51(Activity activity) {
        this((Context) activity);
        this.f13375a = (ViewGroup) activity.getWindow().getDecorView();
    }

    public void a(View view, RelativeLayout.LayoutParams layoutParams) {
        this.c.put(view, layoutParams);
    }

    public void b(View view) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        this.c.put(view, layoutParams);
    }

    public void c(View view) {
        this.d = true;
        this.c.put(view, new RelativeLayout.LayoutParams(-1, -1));
    }

    public void d() {
        this.c.clear();
        this.f13376b = false;
        this.f13375a.removeView(this);
    }

    public boolean e() {
        return this.f13376b;
    }

    public void f() {
        if (this.f13376b) {
            return;
        }
        this.f13376b = true;
        this.f13375a.addView(this, new ViewGroup.LayoutParams(-1, -1));
        removeAllViews();
        if (this.c.isEmpty()) {
            this.c.clear();
            this.f13375a.removeView(this);
            return;
        }
        for (Map.Entry<View, RelativeLayout.LayoutParams> entry : this.c.entrySet()) {
            addView(entry.getKey(), entry.getValue());
        }
        this.c.clear();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.d) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public k51(ViewGroup viewGroup) {
        this(viewGroup.getContext());
        this.f13375a = viewGroup;
    }

    public k51(Context context) {
        this(context, null);
    }

    public k51(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public k51(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = new LinkedHashMap<>();
    }
}
