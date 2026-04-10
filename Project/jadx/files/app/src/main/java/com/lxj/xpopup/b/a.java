package com.lxj.xpopup.b;

import android.animation.FloatEvaluator;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;

/* JADX INFO: compiled from: BlurAnimator.java */
/* JADX INFO: loaded from: classes3.dex */
public class a extends c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f17321e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Bitmap f17322f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f17323g;

    public a(View view, int i2) {
        super(view, 0);
        new FloatEvaluator();
        this.f17323g = false;
        this.f17321e = i2;
    }

    @Override // com.lxj.xpopup.b.c
    public void a() {
    }

    @Override // com.lxj.xpopup.b.c
    public void b() {
    }

    @Override // com.lxj.xpopup.b.c
    public void c() {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(this.b.getResources(), com.lxj.xpopup.util.b.a(this.b.getContext(), this.f17322f, 25.0f, true));
        if (this.f17323g) {
            bitmapDrawable.setColorFilter(this.f17321e, PorterDuff.Mode.SRC_OVER);
        }
        this.b.setBackground(bitmapDrawable);
    }
}
