package com.bytedance.sdk.openadsdk.core.dislike.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.dt;

/* JADX INFO: loaded from: classes10.dex */
public class TTDislikeToast extends FrameLayout {
    private TextView bf;
    private Handler e;

    public TTDislikeToast(Context context) {
        this(context, null);
    }

    public void bf() {
        try {
            e(dt.e(getContext(), "tt_dislike_feedback_repeat"));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void d() {
        setVisibility(8);
        this.e.removeCallbacksAndMessages(null);
    }

    public TTDislikeToast(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void e(Context context) {
        TextView textView = new TextView(context);
        this.bf = textView;
        textView.setClickable(false);
        this.bf.setFocusable(false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        int iE = com.bytedance.sdk.openadsdk.core.dislike.e.e.bf().e(getContext(), 20.0f);
        int iE2 = com.bytedance.sdk.openadsdk.core.dislike.e.e.bf().e(getContext(), 12.0f);
        this.bf.setPadding(iE, iE2, iE, iE2);
        this.bf.setLayoutParams(layoutParams);
        this.bf.setTextColor(-1);
        this.bf.setTextSize(16.0f);
        this.bf.setGravity(17);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(Color.parseColor("#CC000000"));
        gradientDrawable.setCornerRadius(com.bytedance.sdk.openadsdk.core.dislike.e.e.bf().e(getContext(), 6.0f));
        this.bf.setBackgroundDrawable(gradientDrawable);
        addView(this.bf);
    }

    public TTDislikeToast(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = new Handler(Looper.getMainLooper());
        setVisibility(8);
        setClickable(false);
        setFocusable(false);
        e(context);
    }

    public void e(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.e.removeCallbacksAndMessages(null);
        this.e.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.TTDislikeToast.1
            @Override // java.lang.Runnable
            public void run() {
                if (TTDislikeToast.this.bf != null) {
                    TTDislikeToast.this.bf.setText(String.valueOf(str));
                }
                TTDislikeToast.this.setVisibility(0);
            }
        });
        this.e.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.TTDislikeToast.2
            @Override // java.lang.Runnable
            public void run() {
                TTDislikeToast.this.setVisibility(8);
            }
        }, 2000L);
    }

    public void e() {
        e(dt.e(getContext(), "tt_dislike_feedback_success"));
    }
}
