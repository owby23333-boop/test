package com.bumptech.glide.request.l;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import com.bumptech.glide.request.l.d;

/* JADX INFO: compiled from: DrawableCrossFadeTransition.java */
/* JADX INFO: loaded from: classes2.dex */
public class b implements d<Drawable> {
    private final int a;
    private final boolean b;

    public b(int i2, boolean z2) {
        this.a = i2;
        this.b = z2;
    }

    @Override // com.bumptech.glide.request.l.d
    public boolean a(Drawable drawable, d.a aVar) {
        Drawable drawableB = aVar.b();
        if (drawableB == null) {
            drawableB = new ColorDrawable(0);
        }
        TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{drawableB, drawable});
        transitionDrawable.setCrossFadeEnabled(this.b);
        transitionDrawable.startTransition(this.a);
        aVar.d(transitionDrawable);
        return true;
    }
}
