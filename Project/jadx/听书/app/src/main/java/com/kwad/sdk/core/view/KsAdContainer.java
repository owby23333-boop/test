package com.kwad.sdk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.kwad.sdk.utils.aj;

/* JADX INFO: loaded from: classes4.dex */
public class KsAdContainer extends RelativeLayout {
    protected aj.a aLL;

    public KsAdContainer(Context context) {
        super(context);
        this.aLL = new aj.a();
    }

    public KsAdContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aLL = new aj.a();
    }

    public KsAdContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aLL = new aj.a();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            aj.a aVar = new aj.a(getWidth(), getHeight());
            this.aLL = aVar;
            aVar.e(motionEvent.getX(), motionEvent.getY());
        } else if (action == 1) {
            this.aLL.f(motionEvent.getX(), motionEvent.getY());
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public aj.a getTouchCoords() {
        return this.aLL;
    }
}
