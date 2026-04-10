package com.bytedance.adsdk.ugeno.z;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class gz implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f272a;
    private float dl;
    private float g;
    private float gc;
    private float m;
    private View z;

    public gz(View view) {
        this.z = view;
    }

    public void z(float f) {
        View view = this.z;
        if (view == null) {
            return;
        }
        this.g = f;
        Drawable background = view.getBackground();
        if (background instanceof GradientDrawable) {
            ((GradientDrawable) background).setCornerRadius(f);
        }
    }

    public float z() {
        return this.g;
    }

    public void g(float f) {
        View view = this.z;
        if (view == null) {
            return;
        }
        this.dl = f;
        view.postInvalidate();
    }

    @Override // com.bytedance.adsdk.ugeno.z.e
    public float getRipple() {
        return this.dl;
    }

    public void dl(float f) {
        View view = this.z;
        if (view == null) {
            return;
        }
        this.f272a = f;
        view.postInvalidate();
    }

    @Override // com.bytedance.adsdk.ugeno.z.e
    public float getShine() {
        return this.f272a;
    }

    public void a(float f) {
        this.gc = f;
        this.z.postInvalidate();
    }

    @Override // com.bytedance.adsdk.ugeno.z.e
    public float getStretch() {
        return this.gc;
    }

    public void gc(float f) {
        this.m = f;
        this.z.postInvalidate();
    }

    @Override // com.bytedance.adsdk.ugeno.z.e
    public float getRubIn() {
        return this.m;
    }

    public void z(int i) {
        View view = this.z;
        if (view == null) {
            return;
        }
        Drawable background = view.getBackground();
        if (background instanceof GradientDrawable) {
            ((GradientDrawable) background).setColor(i);
        } else if (background instanceof ColorDrawable) {
            ((ColorDrawable) background.mutate()).setColor(i);
        }
    }
}
