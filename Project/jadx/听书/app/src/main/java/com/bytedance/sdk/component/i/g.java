package com.bytedance.sdk.component.i;

import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public interface g {

    public interface z {
        Pair<Boolean, Boolean> z(View view, MotionEvent motionEvent);
    }

    void setTag(int i, Object obj);

    void setTouchEventListener(z zVar);
}
