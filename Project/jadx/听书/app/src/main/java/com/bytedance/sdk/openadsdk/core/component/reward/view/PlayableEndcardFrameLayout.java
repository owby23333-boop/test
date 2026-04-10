package com.bytedance.sdk.openadsdk.core.component.reward.view;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes2.dex */
public class PlayableEndcardFrameLayout extends FrameLayout {
    private int g;
    private z z;

    public interface z {
        void z();
    }

    public PlayableEndcardFrameLayout(Context context) {
        super(context);
    }

    public void z(z zVar) {
        this.z = zVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 2 && Math.abs(this.g - y) > 100) {
                z();
                this.g = y;
            }
        } else {
            this.g = y;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    private void z() {
        z zVar = this.z;
        if (zVar != null) {
            zVar.z();
        }
    }
}
