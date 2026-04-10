package com.amgcyo.cuttadon.view.read.anim;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import com.amgcyo.cuttadon.view.read.anim.PageAnimation;

/* JADX INFO: compiled from: NonePageAnim.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends c {
    public d(int i2, int i3, View view, PageAnimation.a aVar) {
        super(i2, i3, view, aVar);
    }

    @Override // com.amgcyo.cuttadon.view.read.anim.c
    public void b(Canvas canvas) {
        if (this.f5218w) {
            canvas.drawBitmap(this.f5216u, 0.0f, 0.0f, (Paint) null);
        } else {
            canvas.drawBitmap(this.f5217v, 0.0f, 0.0f, (Paint) null);
        }
    }

    @Override // com.amgcyo.cuttadon.view.read.anim.c
    public void c(Canvas canvas) {
        if (this.f5218w) {
            canvas.drawBitmap(this.f5216u, 0.0f, 0.0f, (Paint) null);
        } else {
            canvas.drawBitmap(this.f5217v, 0.0f, 0.0f, (Paint) null);
        }
    }

    @Override // com.amgcyo.cuttadon.view.read.anim.PageAnimation
    public void g() {
    }
}
