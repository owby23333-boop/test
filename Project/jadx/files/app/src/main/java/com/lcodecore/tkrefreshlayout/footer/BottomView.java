package com.lcodecore.tkrefreshlayout.footer;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import com.lcodecore.tkrefreshlayout.R$id;
import com.lcodecore.tkrefreshlayout.R$layout;
import com.lcodecore.tkrefreshlayout.a;

/* JADX INFO: loaded from: classes3.dex */
public class BottomView extends FrameLayout implements a {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private ImageView f17005s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private TextView f17006t;

    public BottomView(Context context) {
        this(context, null);
    }

    private void a() {
        View viewInflate = LayoutInflater.from(getContext()).inflate(R$layout.view_sina_footer, (ViewGroup) null, false);
        this.f17006t = (TextView) viewInflate.findViewById(R$id.tv);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f17006t.getLayoutParams();
        layoutParams.leftMargin = com.lcodecore.tkrefreshlayout.h.a.a(getContext()) / 3;
        this.f17006t.setLayoutParams(layoutParams);
        this.f17005s = (ImageView) viewInflate.findViewById(R$id.iv_loading);
        addView(viewInflate);
    }

    @Override // com.lcodecore.tkrefreshlayout.a
    public void a(float f2, float f3, float f4) {
    }

    @Override // com.lcodecore.tkrefreshlayout.a
    public void b(float f2, float f3, float f4) {
        this.f17006t.setVisibility(0);
        if (f2 < -1.0f) {
            this.f17006t.setText("松手加载下一话");
        }
        if (f2 > -1.0f) {
            this.f17006t.setText("上拉加载下一话");
        }
    }

    @Override // com.lcodecore.tkrefreshlayout.a
    public View getView() {
        return this;
    }

    @Override // com.lcodecore.tkrefreshlayout.a
    public void onFinish() {
        ((AnimationDrawable) this.f17005s.getDrawable()).stop();
        this.f17006t.setVisibility(4);
    }

    @Override // com.lcodecore.tkrefreshlayout.a
    public void reset() {
    }

    public void setTextColor(@ColorInt int i2) {
        this.f17006t.setTextColor(i2);
    }

    public BottomView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BottomView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }

    @Override // com.lcodecore.tkrefreshlayout.a
    public void a(float f2, float f3) {
        this.f17006t.setVisibility(0);
        this.f17006t.setText("正在加载下一话");
        ((AnimationDrawable) this.f17005s.getDrawable()).start();
    }
}
