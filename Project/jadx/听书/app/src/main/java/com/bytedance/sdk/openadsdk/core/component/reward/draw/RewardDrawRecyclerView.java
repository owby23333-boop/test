package com.bytedance.sdk.openadsdk.core.component.reward.draw;

import android.content.Context;
import android.view.MotionEvent;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;

/* JADX INFO: loaded from: classes3.dex */
public class RewardDrawRecyclerView extends RecyclerView {
    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public RewardDrawRecyclerView(Context context) {
        super(context);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        wp.a("lfz", motionEvent.toString());
        return false;
    }
}
