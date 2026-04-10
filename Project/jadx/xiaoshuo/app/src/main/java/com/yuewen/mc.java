package com.yuewen;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes5.dex */
public class mc {

    public static class a implements View.OnTouchListener {
        public static final float g = 0.3f;
        public static final int h = 150;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f14346a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public View f14347b;
        public boolean c;
        public ValueAnimator d;
        public final AnimatorListenerAdapter e;
        public final ValueAnimator.AnimatorUpdateListener f;

        /* JADX INFO: renamed from: com.yuewen.mc$a$a, reason: collision with other inner class name */
        public class C0669a extends AnimatorListenerAdapter {

            /* JADX INFO: renamed from: com.yuewen.mc$a$a$a, reason: collision with other inner class name */
            public class RunnableC0670a implements Runnable {
                public RunnableC0670a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    a.this.d();
                }
            }

            public C0669a() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.f14347b.post(new RunnableC0670a());
            }
        }

        public class b implements ValueAnimator.AnimatorUpdateListener {
            public b() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                a.this.f14347b.setAlpha(a.this.f14346a + ((0.3f - a.this.f14346a) * ((Float) valueAnimator.getAnimatedValue()).floatValue()));
            }
        }

        public final void d() {
            ValueAnimator valueAnimator = this.d;
            if (valueAnimator == null || this.c || ((Float) valueAnimator.getAnimatedValue()).floatValue() < 1.0f) {
                return;
            }
            this.d.cancel();
            this.d.reverse();
        }

        public final void e() {
            ValueAnimator valueAnimator = this.d;
            if (valueAnimator != null) {
                if (!valueAnimator.isStarted() || ((Float) this.d.getAnimatedValue()).floatValue() <= 0.0f) {
                    this.d.cancel();
                    this.d.start();
                }
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.c = true;
                e();
            } else if (action == 1 || action == 3) {
                this.c = false;
                d();
            }
            return false;
        }

        public a(View view) {
            C0669a c0669a = new C0669a();
            this.e = c0669a;
            b bVar = new b();
            this.f = bVar;
            this.f14347b = view;
            ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(150L);
            this.d = duration;
            duration.addUpdateListener(bVar);
            this.d.addListener(c0669a);
            this.f14346a = view.getAlpha();
        }
    }

    public static void a(View view) {
        view.setOnTouchListener(new a(view));
    }

    public static void b(View view, View view2) {
        view.setOnTouchListener(new a(view2));
    }

    public static void c(View... viewArr) {
        for (View view : viewArr) {
            view.setOnTouchListener(new a(view));
        }
    }
}
