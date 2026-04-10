package com.amgcyo.cuttadon.view.read.anim;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import com.amgcyo.cuttadon.view.read.anim.PageAnimation;

/* JADX INFO: compiled from: SlidePageAnim.java */
/* JADX INFO: loaded from: classes.dex */
public class g extends c {
    private Rect C;
    private Rect D;
    private Rect E;
    private Rect F;

    /* JADX INFO: compiled from: SlidePageAnim.java */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a = new int[PageAnimation.Direction.values().length];

        static {
            try {
                a[PageAnimation.Direction.NEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public g(int i2, int i3, View view, PageAnimation.a aVar) {
        super(i2, i3, view, aVar);
        this.C = new Rect(0, 0, this.f5193j, this.f5194k);
        this.D = new Rect(0, 0, this.f5193j, this.f5194k);
        this.E = new Rect(0, 0, this.f5193j, this.f5194k);
        this.F = new Rect(0, 0, this.f5193j, this.f5194k);
    }

    @Override // com.amgcyo.cuttadon.view.read.anim.c
    public void b(Canvas canvas) {
        if (a.a[this.f5187d.ordinal()] == 1) {
            int i2 = this.f5189f;
            int i3 = (int) ((i2 - this.f5195l) + this.f5197n);
            if (i3 <= i2) {
                i2 = i3;
            }
            Rect rect = this.C;
            int i4 = this.f5189f;
            rect.left = i4 - i2;
            this.D.right = i2;
            Rect rect2 = this.E;
            rect2.right = i4 - i2;
            Rect rect3 = this.F;
            rect3.left = i2;
            canvas.drawBitmap(this.f5217v, rect2, rect3, (Paint) null);
            canvas.drawBitmap(this.f5216u, this.C, this.D, (Paint) null);
            return;
        }
        float f2 = this.f5197n;
        int i5 = (int) (f2 - this.f5195l);
        if (i5 < 0) {
            i5 = 0;
            this.f5195l = f2;
        }
        Rect rect4 = this.C;
        int i6 = this.f5189f;
        rect4.left = i6 - i5;
        this.D.right = i5;
        Rect rect5 = this.E;
        rect5.right = i6 - i5;
        Rect rect6 = this.F;
        rect6.left = i5;
        canvas.drawBitmap(this.f5216u, rect5, rect6, (Paint) null);
        canvas.drawBitmap(this.f5217v, this.C, this.D, (Paint) null);
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
        float fAbs;
        int i2;
        float f2;
        super.g();
        if (a.a[this.f5187d.ordinal()] != 1) {
            if (!this.f5218w) {
                f2 = this.f5189f - (this.f5197n - this.f5195l);
                i2 = (int) f2;
                int i3 = i2;
                this.b.startScroll((int) this.f5197n, 0, i3, 0, (Math.abs(i3) * 350) / this.f5189f);
            }
            fAbs = Math.abs(this.f5197n - this.f5195l);
        } else {
            if (this.f5218w) {
                int i4 = this.f5189f;
                int i5 = (int) ((i4 - this.f5195l) + this.f5197n);
                if (i5 <= i4) {
                    i4 = i5;
                }
                i2 = this.f5189f - i4;
                int i32 = i2;
                this.b.startScroll((int) this.f5197n, 0, i32, 0, (Math.abs(i32) * 350) / this.f5189f);
            }
            fAbs = this.f5197n + (this.f5189f - this.f5195l);
        }
        f2 = -fAbs;
        i2 = (int) f2;
        int i322 = i2;
        this.b.startScroll((int) this.f5197n, 0, i322, 0, (Math.abs(i322) * 350) / this.f5189f);
    }
}
