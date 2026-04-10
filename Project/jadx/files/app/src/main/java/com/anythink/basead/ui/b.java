package com.anythink.basead.ui;

import android.util.TypedValue;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.anythink.core.common.k.h;
import com.anythink.expressad.foundation.h.i;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    private ViewGroup a;
    private ImageView b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f6322c;

    /* JADX INFO: renamed from: com.anythink.basead.ui.b$1, reason: invalid class name */
    final class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (b.this.a instanceof RelativeLayout) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(b.this.f6322c, b.this.f6322c);
                    layoutParams.addRule(13);
                    b.this.a.addView(b.this.b, layoutParams);
                } else if (b.this.a instanceof FrameLayout) {
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(b.this.f6322c, b.this.f6322c);
                    layoutParams2.gravity = 17;
                    b.this.a.addView(b.this.b, layoutParams2);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public b(ViewGroup viewGroup) {
        this.a = viewGroup;
        this.b = new ImageView(this.a.getContext());
        this.b.setId(h.a(this.a.getContext(), "myoffer_loading_id", "id"));
        this.b.setImageResource(h.a(this.a.getContext(), "myoffer_loading", i.f10645c));
        this.f6322c = (int) TypedValue.applyDimension(1, 50.0f, this.a.getResources().getDisplayMetrics());
    }

    private void d() {
        ImageView imageView = this.b;
        if (imageView != null) {
            this.a.removeView(imageView);
        }
        this.a.post(new AnonymousClass1());
    }

    public final void a() {
        this.f6322c = (int) TypedValue.applyDimension(1, 30.0f, this.a.getResources().getDisplayMetrics());
    }

    public final void b() {
        ImageView imageView = this.b;
        if (imageView != null) {
            this.a.removeView(imageView);
        }
        this.a.post(new AnonymousClass1());
        this.b.post(new Runnable() { // from class: com.anythink.basead.ui.b.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    b.this.b.setAlpha(1.0f);
                    RotateAnimation rotateAnimation = new RotateAnimation(0.0f, -360.0f, 1, 0.5f, 1, 0.5f);
                    rotateAnimation.setDuration(1000L);
                    rotateAnimation.setInterpolator(new LinearInterpolator());
                    rotateAnimation.setRepeatCount(-1);
                    b.this.b.startAnimation(rotateAnimation);
                } catch (Throwable unused) {
                }
            }
        });
    }

    public final void c() {
        if (this.b != null) {
            this.a.post(new Runnable() { // from class: com.anythink.basead.ui.b.3
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        b.this.b.clearAnimation();
                        b.this.b.setAlpha(0.0f);
                        b.this.a.removeView(b.this.b);
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }
}
