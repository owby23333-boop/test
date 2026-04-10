package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.bytedance.sdk.component.adexpress.dynamic.a.kb;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.tb;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class AnimationText extends TextSwitcher implements ViewSwitcher.ViewFactory, l.z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f587a;
    private int dl;
    private int e;
    private float fo;
    private List<String> g;
    private Context gc;
    private int gz;
    private int i;
    private int kb;
    private TextView m;
    private int uy;
    private Handler v;
    private int wp;
    Animation.AnimationListener z;

    public AnimationText(Context context, int i, float f, int i2, int i3) {
        super(context);
        this.g = new ArrayList();
        this.dl = 0;
        this.f587a = 1;
        this.v = new l(Looper.getMainLooper(), this);
        this.z = new Animation.AnimationListener() { // from class: com.bytedance.sdk.component.adexpress.widget.AnimationText.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (AnimationText.this.m != null) {
                    AnimationText.this.m.setText("");
                }
            }
        };
        this.gc = context;
        this.gz = i;
        this.fo = f;
        this.uy = i2;
        this.i = i3;
        dl();
    }

    private void dl() {
        setFactory(this);
    }

    public void setAnimationType(int i) {
        this.wp = i;
    }

    public void setAnimationDuration(int i) {
        this.e = i;
    }

    public void z() {
        int i = this.wp;
        if (i == 1) {
            setInAnimation(getContext(), tb.wp(this.gc, "tt_text_animation_y_in"));
            setOutAnimation(getContext(), tb.wp(this.gc, "tt_text_animation_y_out"));
        } else if (i == 0) {
            setInAnimation(getContext(), tb.wp(this.gc, "tt_text_animation_x_in"));
            setOutAnimation(getContext(), tb.wp(this.gc, "tt_text_animation_x_in"));
            getInAnimation().setInterpolator(new LinearInterpolator());
            getOutAnimation().setInterpolator(new LinearInterpolator());
            getInAnimation().setAnimationListener(this.z);
            getOutAnimation().setAnimationListener(this.z);
        }
        this.v.sendEmptyMessage(1);
    }

    public void setAnimationText(List<String> list) {
        this.g = list;
    }

    public void g() {
        List<String> list = this.g;
        if (list == null || list.size() <= 0) {
            return;
        }
        int i = this.dl;
        this.dl = i + 1;
        this.kb = i;
        setText(this.g.get(i));
        if (this.dl > this.g.size() - 1) {
            this.dl = 0;
        }
    }

    public void setTextColor(int i) {
        this.gz = i;
    }

    public void setTextSize(float f) {
        this.fo = f;
    }

    public void setMaxLines(int i) {
        this.uy = i;
    }

    @Override // android.widget.ViewSwitcher.ViewFactory
    public View makeView() {
        TextView textView = new TextView(getContext());
        this.m = textView;
        textView.setTextColor(this.gz);
        this.m.setTextSize(this.fo);
        this.m.setMaxLines(this.uy);
        this.m.setTextAlignment(this.i);
        return this.m;
    }

    @Override // com.bytedance.sdk.component.utils.l.z
    public void z(Message message) {
        if (message.what != 1) {
            return;
        }
        g();
        this.v.sendEmptyMessageDelayed(1, this.e);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        try {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(kb.g(this.g.get(this.kb), this.fo, false)[0], 1073741824), i);
        } catch (Exception unused) {
            super.onMeasure(i, i2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.v.removeMessages(1);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.v.sendEmptyMessageDelayed(1, this.e);
    }
}
