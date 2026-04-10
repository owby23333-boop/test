package com.bytedance.sdk.openadsdk.core.component.reward.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes10.dex */
public class PlayableEndcardFrameLayout extends FrameLayout {
    private int bf;
    private e e;

    public interface e {
        void e();
    }

    public PlayableEndcardFrameLayout(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.bf = y;
        } else if (action == 2 && Math.abs(this.bf - y) > 100) {
            e();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void e(e eVar) {
        this.e = eVar;
    }

    public PlayableEndcardFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void e() {
        e eVar = this.e;
        if (eVar != null) {
            eVar.e();
        }
    }

    public PlayableEndcardFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
