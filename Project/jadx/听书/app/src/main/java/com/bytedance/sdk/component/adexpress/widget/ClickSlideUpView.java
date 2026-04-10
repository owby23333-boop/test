package com.bytedance.sdk.component.adexpress.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.CycleInterpolator;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.a.gz;

/* JADX INFO: loaded from: classes2.dex */
public class ClickSlideUpView extends SlideUpView {
    private AnimatorSet dl;
    private View g;
    private TextView z;

    @Override // com.bytedance.sdk.component.adexpress.widget.SlideUpView
    protected void z(Context context) {
    }

    public ClickSlideUpView(Context context) {
        super(context);
        this.dl = new AnimatorSet();
        g(context);
    }

    private void g(Context context) {
        View viewZ = com.bytedance.sdk.component.adexpress.dl.z.z(context);
        this.g = viewZ;
        addView(viewZ);
        setClipChildren(false);
        this.z = (TextView) findViewById(2097610748);
    }

    public void setButtonText(String str) {
        if (this.z == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.z.setText(str);
    }

    private void a() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.g, "translationY", 0.0f, gz.z(getContext(), -3.0f));
        objectAnimatorOfFloat.setInterpolator(new CycleInterpolator(1.0f));
        objectAnimatorOfFloat.setDuration(1000L);
        objectAnimatorOfFloat.setRepeatCount(-1);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.g, "alpha", 1.0f, 0.8f);
        objectAnimatorOfFloat2.setDuration(1000L);
        objectAnimatorOfFloat2.setInterpolator(new CycleInterpolator(1.0f));
        objectAnimatorOfFloat2.setRepeatCount(-1);
        this.dl.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        this.dl.setDuration(1000L);
        this.dl.start();
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.SlideUpView
    public void z() {
        a();
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.SlideUpView
    public void g() {
        this.dl.cancel();
    }
}
