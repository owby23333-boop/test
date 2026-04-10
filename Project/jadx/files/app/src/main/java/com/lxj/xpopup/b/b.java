package com.lxj.xpopup.b;

import android.view.View;
import android.view.ViewPropertyAnimator;

/* JADX INFO: compiled from: EmptyAnimator.java */
/* JADX INFO: loaded from: classes3.dex */
public class b extends c {
    public b(View view, int i2) {
        super(view, i2);
    }

    @Override // com.lxj.xpopup.b.c
    public void a() {
        if (this.a) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimatorWithLayer = this.b.animate().alpha(0.0f).setDuration(this.f17324c).withLayer();
        a(viewPropertyAnimatorWithLayer);
        viewPropertyAnimatorWithLayer.start();
    }

    @Override // com.lxj.xpopup.b.c
    public void b() {
        this.b.animate().alpha(1.0f).setDuration(this.f17324c).withLayer().start();
    }

    @Override // com.lxj.xpopup.b.c
    public void c() {
        this.b.setAlpha(0.0f);
    }
}
