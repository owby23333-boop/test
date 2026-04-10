package com.amgcyo.cuttadon.view.read.anim;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import com.amgcyo.cuttadon.view.read.anim.PageAnimation;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: ScrollPageAnim.java */
/* JADX INFO: loaded from: classes.dex */
public class e extends PageAnimation {
    private Iterator<a> A;
    private Iterator<a> B;
    a C;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private VelocityTracker f5222u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private Bitmap f5223v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private Bitmap f5224w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private ArrayDeque<a> f5225x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private ArrayList<a> f5226y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f5227z;

    /* JADX INFO: compiled from: ScrollPageAnim.java */
    private static class a {
        Bitmap a;
        Rect b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Rect f5228c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f5229d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f5230e;

        private a() {
        }

        public String toString() {
            return "BitmapView{, srcRect=" + this.b + ", destRect=" + this.f5228c + ", top=" + this.f5229d + ", bottom=" + this.f5230e + '}';
        }
    }

    private void a(int i2, int i3) {
        a first;
        this.A = this.f5226y.iterator();
        while (this.A.hasNext()) {
            a next = this.A.next();
            next.f5229d += i3;
            next.f5230e += i3;
            Rect rect = next.f5228c;
            rect.top = next.f5229d;
            int i4 = next.f5230e;
            rect.bottom = i4;
            if (i4 <= 0) {
                this.f5225x.add(next);
                this.A.remove();
                if (this.f5187d == PageAnimation.Direction.UP) {
                    this.f5186c.b();
                    this.f5187d = PageAnimation.Direction.NONE;
                }
            }
        }
        while (true) {
            i2 += i3;
            if (i2 >= this.f5194k || this.f5226y.size() >= 2 || (first = this.f5225x.getFirst()) == null) {
                return;
            }
            Bitmap bitmap = this.f5224w;
            this.f5224w = first.a;
            if (!this.f5227z && !this.f5186c.hasNext()) {
                this.f5224w = bitmap;
                for (a aVar : this.f5226y) {
                    aVar.f5229d = 0;
                    aVar.f5230e = this.f5194k;
                    Rect rect2 = aVar.f5228c;
                    rect2.top = aVar.f5229d;
                    rect2.bottom = aVar.f5230e;
                }
                a();
                return;
            }
            this.f5225x.removeFirst();
            this.f5226y.add(first);
            this.f5187d = PageAnimation.Direction.DOWN;
            first.f5229d = i2;
            first.f5230e = first.a.getHeight() + i2;
            Rect rect3 = first.f5228c;
            rect3.top = first.f5229d;
            rect3.bottom = first.f5230e;
            i3 = first.a.getHeight();
        }
    }

    private void b(int i2, int i3) {
        this.B = this.f5226y.iterator();
        while (this.B.hasNext()) {
            a next = this.B.next();
            next.f5229d += i3;
            next.f5230e += i3;
            Rect rect = next.f5228c;
            int i4 = next.f5229d;
            rect.top = i4;
            rect.bottom = next.f5230e;
            if (i4 >= this.f5194k) {
                this.f5225x.add(next);
                this.B.remove();
                if (this.f5187d == PageAnimation.Direction.DOWN) {
                    this.f5186c.b();
                    this.f5187d = PageAnimation.Direction.NONE;
                }
            }
        }
        int height = i2 + i3;
        while (height > 0 && this.f5226y.size() < 2) {
            a first = this.f5225x.getFirst();
            if (first == null) {
                return;
            }
            Bitmap bitmap = this.f5224w;
            this.f5224w = first.a;
            if (!this.f5227z && !this.f5186c.a()) {
                this.f5224w = bitmap;
                for (a aVar : this.f5226y) {
                    aVar.f5229d = 0;
                    aVar.f5230e = this.f5194k;
                    Rect rect2 = aVar.f5228c;
                    rect2.top = aVar.f5229d;
                    rect2.bottom = aVar.f5230e;
                }
                a();
                return;
            }
            this.f5225x.removeFirst();
            this.f5226y.add(0, first);
            this.f5187d = PageAnimation.Direction.UP;
            first.f5229d = height - first.a.getHeight();
            first.f5230e = height;
            Rect rect3 = first.f5228c;
            rect3.top = first.f5229d;
            rect3.bottom = first.f5230e;
            height -= first.a.getHeight();
        }
    }

    private void i() {
        if (this.f5226y.size() == 0) {
            a(0, 0);
            this.f5187d = PageAnimation.Direction.NONE;
            return;
        }
        int i2 = this.f5202s ? this.f5201r : (int) (this.f5198o - this.f5199p);
        if (i2 > 0) {
            b(this.f5226y.get(0).f5229d, i2);
        } else {
            a(this.f5226y.get(r1.size() - 1).f5230e, i2);
        }
    }

    @Override // com.amgcyo.cuttadon.view.read.anim.PageAnimation
    public Bitmap c() {
        return this.f5223v;
    }

    @Override // com.amgcyo.cuttadon.view.read.anim.PageAnimation
    public Bitmap d() {
        return this.f5224w;
    }

    @Override // com.amgcyo.cuttadon.view.read.anim.PageAnimation
    public void f() {
        if (this.b.computeScrollOffset()) {
            int currX = this.b.getCurrX();
            int currY = this.b.getCurrY();
            b(currX, currY);
            if (this.b.getFinalX() == currX && this.b.getFinalY() == currY) {
                this.f5188e = false;
            }
            this.a.postInvalidate();
        }
    }

    @Override // com.amgcyo.cuttadon.view.read.anim.PageAnimation
    public synchronized void g() {
        this.f5188e = true;
        this.b.fling(0, (int) this.f5198o, 0, (int) this.f5222u.getYVelocity(), 0, 0, -2147483647, Integer.MAX_VALUE);
    }

    public void h() {
        this.f5227z = true;
        Iterator<a> it = this.f5226y.iterator();
        while (it.hasNext()) {
            this.f5225x.add(it.next());
        }
        this.f5226y.clear();
        i();
        this.f5227z = false;
    }

    @Override // com.amgcyo.cuttadon.view.read.anim.PageAnimation
    public boolean a(MotionEvent motionEvent) {
        int x2 = (int) motionEvent.getX();
        int y2 = (int) motionEvent.getY();
        if (this.f5222u == null) {
            this.f5222u = VelocityTracker.obtain();
        }
        this.f5222u.addMovement(motionEvent);
        float f2 = x2;
        float f3 = y2;
        b(f2, f3);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f5188e = false;
            a(f2, f3);
            a();
        } else if (action == 1) {
            this.f5188e = false;
            g();
            this.f5222u.recycle();
            this.f5222u = null;
        } else if (action == 2) {
            this.f5222u.computeCurrentVelocity(1000);
            this.f5188e = true;
            this.a.postInvalidate();
        } else if (action == 3) {
            try {
                this.f5222u.recycle();
                this.f5222u = null;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return true;
    }

    @Override // com.amgcyo.cuttadon.view.read.anim.PageAnimation
    public void a(Canvas canvas) {
        i();
        canvas.drawBitmap(this.f5223v, 0.0f, 0.0f, (Paint) null);
        canvas.save();
        canvas.translate(0.0f, this.f5192i);
        canvas.clipRect(0, 0, this.f5193j, this.f5194k);
        for (int i2 = 0; i2 < this.f5226y.size(); i2++) {
            this.C = this.f5226y.get(i2);
            a aVar = this.C;
            canvas.drawBitmap(aVar.a, aVar.b, aVar.f5228c, (Paint) null);
        }
        canvas.restore();
    }

    @Override // com.amgcyo.cuttadon.view.read.anim.PageAnimation
    public void a() {
        if (this.b.isFinished()) {
            return;
        }
        this.b.abortAnimation();
        this.f5188e = false;
    }
}
