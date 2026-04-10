package com.bytedance.sdk.openadsdk.res.layout;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.sdk.component.utils.gz;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.hh.e;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class LazeLayout<T extends View> extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AtomicBoolean f1471a;
    private z dl;
    private View.OnTouchListener e;
    private volatile Context g;
    private AtomicBoolean gc;
    private T gz;
    private View.OnClickListener m;
    private volatile com.bytedance.sdk.openadsdk.res.layout.z<T> z;

    public interface z<T extends View> {
        void z(T t);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
    }

    public LazeLayout(Context context, com.bytedance.sdk.openadsdk.res.layout.z zVar, z zVar2) {
        super(context);
        this.f1471a = new AtomicBoolean(false);
        this.gc = new AtomicBoolean(false);
        this.z = zVar;
        this.g = context;
        this.dl = zVar2;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.gc.set(true);
        if (this.f1471a.get()) {
            return;
        }
        this.f1471a.set(true);
        T t = this.gz;
        if (t != null) {
            z(t, getParent());
        } else {
            gz.dl().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.res.layout.LazeLayout.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        LazeLayout lazeLayout = LazeLayout.this;
                        lazeLayout.gz = lazeLayout.z.g(LazeLayout.this.g);
                        if (LazeLayout.this.gz == null) {
                            return;
                        }
                        LazeLayout lazeLayout2 = LazeLayout.this;
                        lazeLayout2.z(lazeLayout2.gz, LazeLayout.this.getParent());
                    } catch (Exception e) {
                        wp.g("LazeLayout", "inflate error", e);
                    }
                }
            });
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.gc.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(final T t, final ViewParent viewParent) {
        if (t == null) {
            return;
        }
        if (viewParent == null) {
            if (this.gc.get()) {
                gz.dl().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.res.layout.LazeLayout.2
                    @Override // java.lang.Runnable
                    public void run() {
                        LazeLayout lazeLayout = LazeLayout.this;
                        lazeLayout.z(t, lazeLayout.getParent());
                    }
                }, 50L);
                return;
            } else {
                this.f1471a.set(false);
                return;
            }
        }
        if (viewParent instanceof ViewGroup) {
            e.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.res.layout.LazeLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    if (LazeLayout.this.gc.get()) {
                        LazeLayout.this.z(t, (ViewGroup) viewParent);
                    } else {
                        LazeLayout.this.f1471a.set(false);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(T t, ViewGroup viewGroup) {
        int iIndexOfChild = viewGroup.indexOfChild(this);
        viewGroup.removeViewInLayout(this);
        this.g = null;
        this.z = null;
        ViewParent parent = t.getParent();
        if (parent != null) {
            ((ViewGroup) parent).removeView(t);
        }
        View.OnClickListener onClickListener = this.m;
        if (onClickListener != null) {
            t.setOnClickListener(onClickListener);
        }
        View.OnTouchListener onTouchListener = this.e;
        if (onTouchListener != null) {
            t.setOnTouchListener(onTouchListener);
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(t, iIndexOfChild, layoutParams);
        } else {
            viewGroup.addView(t, iIndexOfChild);
        }
        z zVar = this.dl;
        if (zVar != null) {
            zVar.z(t);
        }
        this.gz = null;
    }

    public void z() {
        this.gz = null;
        this.z = null;
        this.g = null;
        this.dl = null;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.m = onClickListener;
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.e = onTouchListener;
    }
}
