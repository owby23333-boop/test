package com.yuewen;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.yuewen.rt2;

/* JADX INFO: loaded from: classes5.dex */
public class ry1 extends bd0 {
    public final e A;
    public Runnable B;
    public boolean C;
    public boolean D;
    public boolean E;
    public final FrameLayout y;
    public final View z;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ry1.this.E) {
                ry1.this.g();
            }
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup.LayoutParams f17299a;

        public b(ViewGroup.LayoutParams layoutParams) {
            this.f17299a = layoutParams;
        }

        @Override // java.lang.Runnable
        public void run() {
            ry1.this.y.setLayoutParams(this.f17299a);
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f17301a;

        public c(int i) {
            this.f17301a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) ry1.this.y.getLayoutParams();
            int[] iArr = new int[2];
            ry1.this.y.getLocationOnScreen(iArr);
            int i = this.f17301a;
            int i2 = iArr[1];
            if (i > i2) {
                layoutParams.topMargin = i - i2;
                ry1.this.y.setLayoutParams(layoutParams);
            }
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ry1.this.g();
        }
    }

    public class e extends FrameLayout {
        public e(Context context) {
            super(context);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            if (ry1.this.We()) {
                return super.dispatchTouchEvent(motionEvent);
            }
            return true;
        }
    }

    public ry1(xv1 xv1Var) {
        super(xv1Var);
        this.C = false;
        this.D = false;
        this.E = true;
        e eVar = new e(getContext());
        this.A = eVar;
        Ie(eVar);
        LayoutInflater.from(getContext()).inflate(af(), (ViewGroup) eVar, true);
        FrameLayout frameLayout = (FrameLayout) od(rt2.k.f1);
        this.y = frameLayout;
        Rect rect = new Rect();
        frameLayout.getBackground().getPadding(rect);
        frameLayout.setPadding(rect.left, rect.top, rect.right, rect.bottom);
        this.z = od(rt2.k.e1);
        eVar.setOnClickListener(new a());
        uc(true);
        pk4.f(frameLayout);
    }

    @Override // com.yuewen.w60
    public void Td() {
        super.Td();
        this.A.setOnApplyWindowInsetsListener(null);
    }

    public void Ue(View view) {
        this.y.addView(view, new FrameLayout.LayoutParams(-1, -2));
    }

    public void Ve(Runnable runnable) {
        this.B = runnable;
    }

    public final boolean We() {
        return this.C && !this.D;
    }

    public void Xe() {
        this.y.setClipToOutline(true);
    }

    public int Ye() {
        return ((FrameLayout.LayoutParams) this.y.getLayoutParams()).topMargin;
    }

    public View Ze() {
        return this.z;
    }

    public int af() {
        return rt2.n.C;
    }

    public View bf() {
        return this.y;
    }

    public Runnable cf() {
        return this.B;
    }

    public void df(boolean z) {
        this.C = z;
    }

    public void ef(boolean z) {
        this.E = z;
    }

    public void ff(int i) {
        e84.Y0(this.y, new c(i));
    }

    public void gf(ViewGroup.LayoutParams layoutParams) {
        hf(layoutParams, false);
    }

    public void hf(ViewGroup.LayoutParams layoutParams, boolean z) {
        if (z) {
            e84.Y0(this.y, new b(layoutParams));
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.y.getLayoutParams();
        layoutParams2.width = layoutParams.width;
        layoutParams2.height = layoutParams.height;
        this.y.setLayoutParams(layoutParams2);
    }

    @Override // com.yuewen.w60
    public boolean ke() {
        if (!We()) {
            return true;
        }
        this.D = true;
        e84.t(getContentView(), 1.0f, 0.0f, e84.b0(0), true, new d());
        return true;
    }

    @Override // com.yuewen.bd0, com.yuewen.w60
    public void ne() {
        super.ne();
        Runnable runnable = this.B;
        if (runnable != null) {
            runnable.run();
        }
    }
}
