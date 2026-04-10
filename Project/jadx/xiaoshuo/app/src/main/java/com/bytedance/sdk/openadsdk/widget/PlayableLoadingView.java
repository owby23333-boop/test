package com.bytedance.sdk.openadsdk.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.utils.dt;

/* JADX INFO: loaded from: classes10.dex */
public class PlayableLoadingView extends FrameLayout {
    public PlayableLoadingView(Context context) {
        super(context);
        e(context);
    }

    public void bf() {
        setVisibility(0);
    }

    public void e(Context context) {
        setBackgroundColor(Color.parseColor("#0D1833"));
        setClickable(true);
        setVisibility(8);
        LayoutInflater.from(context).inflate(dt.vn(context, "tt_playable_loading_layout"), (ViewGroup) this, true);
    }

    public PlayableLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        e(context);
    }

    public PlayableLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        e(context);
    }

    public void e() {
        setVisibility(8);
    }
}
