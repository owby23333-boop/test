package com.bytedance.sdk.openadsdk.core.ugeno.component.interact;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.pf;
import com.bytedance.sdk.openadsdk.core.un.oq;

/* JADX INFO: loaded from: classes2.dex */
public class EasyPlayableContainer extends FrameLayout {
    private final na dl;
    private final pf g;
    private final e z;

    public EasyPlayableContainer(Context context, e eVar, pf pfVar, na naVar) {
        super(context);
        this.z = eVar;
        this.g = pfVar;
        this.dl = naVar;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.g != null) {
            float fA = oq.a(getContext(), motionEvent.getX());
            float fA2 = oq.a(getContext(), motionEvent.getY());
            if (this.g.z(fA, fA2)) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            if (motionEvent.getAction() == 0) {
                com.bytedance.sdk.openadsdk.core.zw.g.z(this.dl, fA, fA2, 1);
            }
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.g != null) {
            if (this.g.z(oq.a(getContext(), motionEvent.getX()), oq.a(getContext(), motionEvent.getY()))) {
                return super.onTouchEvent(motionEvent);
            }
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        e eVar = this.z;
        if (eVar != null) {
            eVar.g();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e eVar = this.z;
        if (eVar != null) {
            eVar.dl();
        }
    }
}
