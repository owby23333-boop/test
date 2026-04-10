package com.bytedance.sdk.openadsdk.res.layout;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public final class TTViewStub extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private z f1472a;
    private Context dl;
    private com.bytedance.sdk.openadsdk.res.layout.z g;
    private WeakReference<View> z;

    public interface z {
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
    }

    public TTViewStub(Context context, com.bytedance.sdk.openadsdk.res.layout.z zVar) {
        super(context);
        this.dl = context;
        this.g = zVar;
        setVisibility(8);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        WeakReference<View> weakReference = this.z;
        if (weakReference != null) {
            View view = weakReference.get();
            if (view != null) {
                view.setVisibility(i);
                return;
            }
            throw new IllegalStateException("setVisibility called on un-referenced view");
        }
        super.setVisibility(i);
        if (i == 0 || i == 4) {
            z();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public View z() {
        ViewParent parent = getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            com.bytedance.sdk.openadsdk.res.layout.z zVar = this.g;
            if (zVar != null) {
                View viewG = zVar.g(this.dl);
                z(viewG, (ViewGroup) parent);
                this.z = new WeakReference<>(viewG);
                return viewG;
            }
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
        throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
    }

    private void z(View view, ViewGroup viewGroup) {
        int iIndexOfChild = viewGroup.indexOfChild(this);
        viewGroup.removeViewInLayout(this);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(view, iIndexOfChild, layoutParams);
        } else {
            viewGroup.addView(view, iIndexOfChild);
        }
    }

    public void setOnInflateListener(z zVar) {
        this.f1472a = zVar;
    }
}
