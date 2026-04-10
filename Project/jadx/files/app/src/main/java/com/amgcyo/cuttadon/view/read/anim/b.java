package com.amgcyo.cuttadon.view.read.anim;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import com.amgcyo.cuttadon.view.read.anim.PageAnimation;

/* JADX INFO: compiled from: CoverPageAnim.java */
/* JADX INFO: loaded from: classes.dex */
public class b extends c {
    private Rect C;
    private Rect D;
    private GradientDrawable E;

    /* JADX INFO: compiled from: CoverPageAnim.java */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a = new int[PageAnimation.Direction.values().length];

        static {
            try {
                a[PageAnimation.Direction.NEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public b(int i2, int i3, View view, PageAnimation.a aVar) {
        super(i2, i3, view, aVar);
        this.C = new Rect(0, 0, this.f5193j, this.f5194k);
        this.D = new Rect(0, 0, this.f5193j, this.f5194k);
        this.E = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{1711276032, 0});
        this.E.setGradientType(0);
    }

    public void a(int i2, Canvas canvas) {
        this.E.setBounds(i2, 0, i2 + 30, this.f5190g);
        this.E.draw(canvas);
    }

    @Override // com.amgcyo.cuttadon.view.read.anim.c
    public void b(Canvas canvas) {
        if (a.a[this.f5187d.ordinal()] != 1) {
            Rect rect = this.C;
            float f2 = this.f5193j;
            float f3 = this.f5197n;
            rect.left = (int) (f2 - f3);
            this.D.right = (int) f3;
            canvas.drawBitmap(this.f5216u, 0.0f, 0.0f, (Paint) null);
            canvas.drawBitmap(this.f5217v, this.C, this.D, (Paint) null);
            a((int) this.f5197n, canvas);
            return;
        }
        int i2 = this.f5193j;
        int i3 = (int) ((i2 - this.f5195l) + this.f5197n);
        if (i3 <= i2) {
            i2 = i3;
        }
        this.C.left = this.f5193j - i2;
        this.D.right = i2;
        canvas.drawBitmap(this.f5217v, 0.0f, 0.0f, (Paint) null);
        canvas.drawBitmap(this.f5216u, this.C, this.D, (Paint) null);
        a(i2, canvas);
    }

    @Override // com.amgcyo.cuttadon.view.read.anim.c
    public void c(Canvas canvas) {
        if (!this.f5218w) {
            canvas.drawBitmap(this.f5217v, 0.0f, 0.0f, (Paint) null);
        } else {
            this.f5217v = this.f5216u.copy(Bitmap.Config.RGB_565, true);
            canvas.drawBitmap(this.f5216u, 0.0f, 0.0f, (Paint) null);
        }
    }

    @Override // com.amgcyo.cuttadon.view.read.anim.PageAnimation
    public void g() {
        float f2;
        int i2;
        float f3;
        super.g();
        if (a.a[this.f5187d.ordinal()] != 1) {
            if (!this.f5218w) {
                f3 = this.f5193j - this.f5197n;
                i2 = (int) f3;
                int i3 = i2;
                this.b.startScroll((int) this.f5197n, 0, i3, 0, (Math.abs(i3) * 350) / this.f5193j);
            }
            f2 = this.f5197n;
        } else {
            if (this.f5218w) {
                int i4 = this.f5193j;
                int i5 = (int) ((i4 - this.f5195l) + this.f5197n);
                if (i5 <= i4) {
                    i4 = i5;
                }
                i2 = this.f5193j - i4;
                int i32 = i2;
                this.b.startScroll((int) this.f5197n, 0, i32, 0, (Math.abs(i32) * 350) / this.f5193j);
            }
            f2 = this.f5197n + (this.f5193j - this.f5195l);
        }
        f3 = -f2;
        i2 = (int) f3;
        int i322 = i2;
        this.b.startScroll((int) this.f5197n, 0, i322, 0, (Math.abs(i322) * 350) / this.f5193j);
    }
}
