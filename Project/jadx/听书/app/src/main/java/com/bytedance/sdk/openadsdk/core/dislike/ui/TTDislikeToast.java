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
import androidx.media3.exoplayer.ExoPlayer;
import com.bytedance.sdk.component.utils.tb;
import com.bytedance.sdk.component.utils.wp;

/* JADX INFO: loaded from: classes2.dex */
public class TTDislikeToast extends FrameLayout {
    private TextView g;
    private Handler z;

    public TTDislikeToast(Context context) {
        this(context, null);
    }

    public TTDislikeToast(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TTDislikeToast(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.z = new Handler(Looper.getMainLooper());
        setVisibility(8);
        setClickable(false);
        setFocusable(false);
        z(context);
    }

    private void z(Context context) {
        TextView textView = new TextView(context);
        this.g = textView;
        textView.setClickable(false);
        this.g.setFocusable(false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        int iZ = com.bytedance.sdk.openadsdk.core.dislike.z.z.g().z(getContext(), 20.0f);
        int iZ2 = com.bytedance.sdk.openadsdk.core.dislike.z.z.g().z(getContext(), 12.0f);
        this.g.setPadding(iZ, iZ2, iZ, iZ2);
        this.g.setLayoutParams(layoutParams);
        this.g.setTextColor(-1);
        this.g.setTextSize(16.0f);
        this.g.setGravity(17);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(Color.parseColor("#CC000000"));
        gradientDrawable.setCornerRadius(com.bytedance.sdk.openadsdk.core.dislike.z.z.g().z(getContext(), 6.0f));
        this.g.setBackgroundDrawable(gradientDrawable);
        addView(this.g);
    }

    public void z(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.z.removeCallbacksAndMessages(null);
        this.z.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.TTDislikeToast.1
            @Override // java.lang.Runnable
            public void run() {
                if (TTDislikeToast.this.g != null) {
                    TTDislikeToast.this.g.setText(String.valueOf(str));
                }
                TTDislikeToast.this.setVisibility(0);
            }
        });
        this.z.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.TTDislikeToast.2
            @Override // java.lang.Runnable
            public void run() {
                TTDislikeToast.this.setVisibility(8);
            }
        }, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
    }

    public void z() {
        z(tb.z(getContext(), "tt_dislike_feedback_success"));
    }

    public void g() {
        try {
            z(tb.z(getContext(), "tt_dislike_feedback_repeat"));
        } catch (Throwable th) {
            wp.z(th);
        }
    }

    public void dl() {
        setVisibility(8);
        this.z.removeCallbacksAndMessages(null);
    }
}
