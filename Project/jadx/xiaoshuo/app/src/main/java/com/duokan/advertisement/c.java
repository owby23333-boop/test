package com.duokan.advertisement;

import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import com.duokan.advertisement.i;
import com.yuewen.cs1;

/* JADX INFO: loaded from: classes12.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f2502a = 0.4f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final float f2503b = 0.7f;

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f2504a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ImageView f2505b;

        public a(TextView textView, ImageView imageView) {
            this.f2504a = textView;
            this.f2505b = imageView;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            this.f2504a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            c.h(this.f2505b, this.f2504a.getWidth());
        }
    }

    public static void b(TextView textView, TextView textView2, int i) {
    }

    public static void c(View view, int i) {
        if (view == null) {
            return;
        }
        if (g(i)) {
            if (view.getBackground() instanceof GradientDrawable) {
                ((GradientDrawable) view.getBackground()).setColor(view.getContext().getResources().getColor(i.f.eT));
            }
        } else if (view.getBackground() instanceof GradientDrawable) {
            ((GradientDrawable) view.getBackground()).setColor(view.getContext().getResources().getColor(i.f.bT));
        }
    }

    public static void d(TextView textView, ImageView imageView, int i) {
        if (g(i)) {
            if (imageView != null) {
                imageView.setImageResource(i.h.Jq);
            }
            if (textView != null) {
                textView.setTextColor(-16777216);
                textView.setAlpha(0.7f);
                return;
            }
            return;
        }
        if (imageView != null) {
            imageView.setImageResource(i.h.Kq);
        }
        if (textView != null) {
            textView.setTextColor(-1);
            textView.setAlpha(0.7f);
        }
    }

    public static void e(View view, int i) {
        TextView textView = (TextView) view.findViewById(i.k.Y0);
        TextView textView2 = (TextView) view.findViewById(i.k.T0);
        TextView textView3 = (TextView) view.findViewById(i.k.U0);
        TextView textView4 = (TextView) view.findViewById(i.k.V0);
        TextView textView5 = (TextView) view.findViewById(i.k.W0);
        TextView textView6 = (TextView) view.findViewById(i.k.X0);
        if (g(i)) {
            if (textView != null) {
                textView.setTextColor(Color.parseColor("#321F2126"));
            }
            if (textView2 != null) {
                textView2.setTextColor(-16777216);
            }
            if (textView5 != null) {
                textView5.setTextColor(-16777216);
            }
            if (textView6 != null) {
                textView6.setTextColor(-16777216);
            }
            if (textView3 != null) {
                textView3.setTextColor(-16777216);
            }
            if (textView4 != null) {
                textView4.setTextColor(-16777216);
                return;
            }
            return;
        }
        if (textView != null) {
            textView.setTextColor(Color.parseColor(cs1.I));
        }
        if (textView2 != null) {
            textView2.setTextColor(-1);
        }
        if (textView5 != null) {
            textView5.setTextColor(-1);
        }
        if (textView6 != null) {
            textView6.setTextColor(-1);
        }
        if (textView3 != null) {
            textView3.setTextColor(-1);
        }
        if (textView4 != null) {
            textView4.setTextColor(-1);
        }
    }

    public static int f(float f, int i) {
        return (Math.min(255, Math.max(0, (int) (f * 255.0f))) << 24) + (i & 16777215);
    }

    public static boolean g(int i) {
        return (((((double) Color.red(i)) / 255.0d) * 0.2126d) + ((((double) Color.green(i)) / 255.0d) * 0.7152d)) + ((((double) Color.blue(i)) / 255.0d) * 0.0722d) < 0.5d;
    }

    public static void h(ImageView imageView, int i) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(imageView, "translationX", -120.0f, i);
        objectAnimatorOfFloat.setDuration(1000L);
        objectAnimatorOfFloat.setRepeatCount(2);
        objectAnimatorOfFloat.start();
    }

    public static void i(ImageView imageView, TextView textView) {
        if (imageView == null || textView == null) {
            return;
        }
        imageView.setVisibility(0);
        if (textView.getWidth() > 0) {
            h(imageView, textView.getWidth());
        } else {
            textView.getViewTreeObserver().addOnGlobalLayoutListener(new a(textView, imageView));
        }
    }
}
