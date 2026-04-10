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
import com.bytedance.sdk.component.adexpress.dynamic.tg.wu;
import com.bytedance.sdk.component.utils.dt;
import com.bytedance.sdk.component.utils.za;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AnimationText extends TextSwitcher implements ViewSwitcher.ViewFactory, za.e {
    private List<String> bf;
    private int bh;
    private int d;
    Animation.AnimationListener e;
    private Context ga;
    private int m;
    private int p;
    private Handler t;
    private final int tg;
    private int v;
    private TextView vn;
    private int wu;
    private int xu;
    private float zk;

    public AnimationText(Context context, int i, float f, int i2, int i3) {
        super(context);
        this.bf = new ArrayList();
        this.d = 0;
        this.tg = 1;
        this.t = new za(Looper.getMainLooper(), this);
        this.e = new Animation.AnimationListener() { // from class: com.bytedance.sdk.component.adexpress.widget.AnimationText.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (AnimationText.this.vn != null) {
                    AnimationText.this.vn.setText("");
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        };
        this.v = i;
        this.zk = f;
        this.m = i2;
        this.bh = i3;
        d();
    }

    private void d() {
        setFactory(this);
    }

    public void bf() {
        List<String> list = this.bf;
        if (list == null || list.size() <= 0) {
            return;
        }
        int i = this.d;
        this.d = i + 1;
        this.wu = i;
        setText(this.bf.get(i));
        if (this.d > this.bf.size() - 1) {
            this.d = 0;
        }
    }

    @Override // android.widget.ViewSwitcher.ViewFactory
    public View makeView() {
        TextView textView = new TextView(getContext());
        this.vn = textView;
        textView.setTextColor(this.v);
        this.vn.setTextSize(this.zk);
        this.vn.setMaxLines(this.m);
        this.vn.setTextAlignment(this.bh);
        return this.vn;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.t.sendEmptyMessageDelayed(1, this.p);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.t.removeMessages(1);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        try {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(wu.bf(this.bf.get(this.wu), this.zk, false)[0], 1073741824), i);
        } catch (Exception unused) {
            super.onMeasure(i, i2);
        }
    }

    public void setAnimationDuration(int i) {
        this.p = i;
    }

    public void setAnimationText(List<String> list) {
        this.bf = list;
    }

    public void setAnimationType(int i) {
        this.xu = i;
    }

    public void setMaxLines(int i) {
        this.m = i;
    }

    public void setTextColor(int i) {
        this.v = i;
    }

    public void setTextSize(float f) {
        this.zk = f;
    }

    public void e() {
        int i = this.xu;
        if (i == 1) {
            setInAnimation(getContext(), dt.xu(this.ga, "tt_text_animation_y_in"));
            setOutAnimation(getContext(), dt.xu(this.ga, "tt_text_animation_y_out"));
        } else if (i == 0) {
            setInAnimation(getContext(), dt.xu(this.ga, "tt_text_animation_x_in"));
            setOutAnimation(getContext(), dt.xu(this.ga, "tt_text_animation_x_in"));
            getInAnimation().setInterpolator(new LinearInterpolator());
            getOutAnimation().setInterpolator(new LinearInterpolator());
            getInAnimation().setAnimationListener(this.e);
            getOutAnimation().setAnimationListener(this.e);
        }
        this.t.sendEmptyMessage(1);
    }

    @Override // com.bytedance.sdk.component.utils.za.e
    public void e(Message message) {
        if (message.what != 1) {
            return;
        }
        bf();
        this.t.sendEmptyMessageDelayed(1, this.p);
    }
}
