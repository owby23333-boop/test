package com.amgcyo.cuttadon.view.comic.comictoast;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.fatcatfat.io.R;

/* JADX INFO: loaded from: classes.dex */
public class ToastLayout extends RelativeLayout {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private TextView f4529s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private View f4530t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f4531u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private RelativeLayout f4532v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private ImageView f4533w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f4534x;

    class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            ToastLayout.this.f4531u = false;
            ToastLayout.this.setVisibility(8);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            ToastLayout.this.f4531u = true;
            ToastLayout.this.setVisibility(0);
        }
    }

    public ToastLayout(Context context) {
        this(context, null);
    }

    public void setBgColor(int i2) {
        this.f4532v.setBackgroundColor(i2);
    }

    public void setContent(String str) {
        TextView textView = this.f4529s;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setHeight(int i2) {
        this.f4534x = i2;
    }

    public void setIcon(int i2) {
        this.f4533w.setImageResource(i2);
    }

    public void setIconVisible(boolean z2) {
        if (z2) {
            this.f4533w.setVisibility(0);
        } else {
            this.f4533w.setVisibility(8);
        }
    }

    public void setTextColor(int i2) {
        this.f4529s.setTextColor(i2);
    }

    public ToastLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void a(long j2) {
        AnimationSet animationSet = new AnimationSet(true);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, -a(getContext(), this.f4534x), 0.0f);
        TranslateAnimation translateAnimation2 = new TranslateAnimation(0.0f, 0.0f, 0.0f, -a(getContext(), this.f4534x));
        translateAnimation.setDuration(200L);
        translateAnimation2.setStartOffset(j2 + 200);
        translateAnimation2.setDuration(200L);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(translateAnimation2);
        startAnimation(animationSet);
        animationSet.setAnimationListener(new a());
    }

    public ToastLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f4530t = LayoutInflater.from(getContext()).inflate(R.layout.layout_toast, (ViewGroup) null);
        addView(this.f4530t);
        this.f4529s = (TextView) this.f4530t.findViewById(R.id.tv_content);
        this.f4532v = (RelativeLayout) this.f4530t.findViewById(R.id.rl_toast);
        this.f4533w = (ImageView) this.f4530t.findViewById(R.id.iv_icon);
        this.f4534x = 60;
    }

    public static int a(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
