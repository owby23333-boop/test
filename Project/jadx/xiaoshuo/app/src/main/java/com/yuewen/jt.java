package com.yuewen;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import androidx.annotation.IdRes;
import com.yuewen.st2;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class jt {
    public static final int[] d = {st2.k.ci0, st2.k.bi0, st2.k.Yh0, st2.k.Zh0, st2.k.ai0};
    public static final int[] e = {st2.h.Yf0, st2.h.Vf0, st2.h.dg0, st2.h.Mf0, st2.h.Pf0};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f13144a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<View> f13145b = new ArrayList();
    public boolean c = true;

    public jt(ViewGroup viewGroup) {
        int length = d.length;
        for (int i = 0; i < length; i++) {
            ImageView imageView = (ImageView) viewGroup.findViewById(d[i]);
            imageView.setImageResource(e[i]);
            this.f13145b.add(imageView);
        }
    }

    public View a(int i) {
        return this.f13145b.get(i);
    }

    public int b() {
        return this.f13145b.size();
    }

    public void c(int i) {
        if (i < 0 || i >= this.f13145b.size()) {
            return;
        }
        this.f13145b.get(i).setVisibility(8);
    }

    public boolean d(int i) {
        if (i < 0 || i >= this.f13145b.size()) {
            return false;
        }
        View view = this.f13145b.get(i);
        if (view.getVisibility() != 0) {
            return false;
        }
        view.setSelected(true);
        if (this.c) {
            this.c = false;
        } else {
            g(view);
        }
        int i2 = this.f13144a;
        if (i2 >= 0) {
            this.f13145b.get(i2).setSelected(false);
        }
        this.f13144a = i;
        return true;
    }

    public boolean e(int i) {
        return d(i);
    }

    public void f(int i) {
        if (i < 0 || i >= this.f13145b.size()) {
            return;
        }
        this.f13145b.get(i).setVisibility(0);
    }

    public final void g(View view) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "scaleX", 0.98f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "scaleY", 0.98f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        animatorSet.setDuration(100L);
        animatorSet.setInterpolator(new LinearInterpolator());
        animatorSet.start();
    }

    public jt(View view, @IdRes int... iArr) {
        for (int i : iArr) {
            this.f13145b.add(view.findViewById(i));
        }
    }
}
