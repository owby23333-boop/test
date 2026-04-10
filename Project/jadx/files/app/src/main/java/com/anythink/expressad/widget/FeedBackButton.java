package com.anythink.expressad.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.anythink.expressad.foundation.h.i;
import com.anythink.expressad.foundation.h.t;

/* JADX INFO: loaded from: classes2.dex */
public class FeedBackButton extends TextView {
    public static String FEEDBACK_BTN_BACKGROUND_COLOR_STR = "#60000000";

    public FeedBackButton(Context context) {
        super(context);
        a();
    }

    private void a() {
        setText(i.a(getContext(), "anythink_cm_feedback_btn_text", i.f10649g));
        Context context = getContext();
        setPadding(t.b(context, 5.0f), t.b(context, 5.0f), t.b(context, 5.0f), t.b(context, 5.0f));
        setTextIsSelectable(false);
        setGravity(17);
        setBackgroundColor(Color.parseColor(FEEDBACK_BTN_BACKGROUND_COLOR_STR));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(t.b(context, 20.0f));
        gradientDrawable.setColor(Color.parseColor(FEEDBACK_BTN_BACKGROUND_COLOR_STR));
        setBackground(gradientDrawable);
        setTextColor(-1);
    }

    public FeedBackButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public FeedBackButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }

    public FeedBackButton(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        a();
    }
}
