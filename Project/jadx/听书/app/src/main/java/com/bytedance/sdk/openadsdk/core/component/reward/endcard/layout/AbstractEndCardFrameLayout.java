package com.bytedance.sdk.openadsdk.core.component.reward.endcard.layout;

import android.widget.FrameLayout;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.g.g;
import com.bytedance.sdk.openadsdk.core.iq.na;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractEndCardFrameLayout extends FrameLayout {
    protected final na g;
    protected final TTBaseVideoActivity z;

    public void g() {
    }

    public abstract SSWebView getEndCardWebView();

    public abstract SSWebView getPlayableWebView();

    public abstract FrameLayout getVideoArea();

    public abstract void setClickListener(g gVar);

    abstract void z();

    public AbstractEndCardFrameLayout(TTBaseVideoActivity tTBaseVideoActivity, na naVar) {
        super(tTBaseVideoActivity);
        this.z = tTBaseVideoActivity;
        this.g = naVar;
        z();
    }
}
