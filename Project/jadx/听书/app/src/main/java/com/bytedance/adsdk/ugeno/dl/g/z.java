package com.bytedance.adsdk.ugeno.dl.g;

import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    public String z = "GesThrough_";
    private List<MotionEvent> g = new ArrayList();
    private Set<String> dl = Collections.synchronizedSet(new HashSet());

    public void z(com.bytedance.adsdk.ugeno.g.dl dlVar, MotionEvent motionEvent) {
        if (dlVar == null || motionEvent == null || this.g == null) {
            return;
        }
        this.z = "GesThrough_" + dlVar.x();
        int[] iArr = new int[2];
        dlVar.fo().getLocationInWindow(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        if (motionEvent.getAction() == 0) {
            this.g.clear();
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.offsetLocation(i, i2);
        this.g.add(motionEventObtain);
    }

    public boolean z(MotionEvent motionEvent) {
        if (motionEvent == null || this.dl == null) {
            return false;
        }
        return this.dl.contains(motionEvent.getDownTime() + "_" + motionEvent.getPointerId(motionEvent.getActionIndex()));
    }

    public void z(com.bytedance.adsdk.ugeno.g.dl dlVar) {
        if (this.g.isEmpty() || this.dl == null || dlVar == null || dlVar.fo() == null || dlVar.fo().getRootView() == null) {
            return;
        }
        final View rootView = dlVar.fo().getRootView();
        this.g.size();
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bytedance.adsdk.ugeno.dl.g.z.1
            @Override // java.lang.Runnable
            public void run() {
                for (MotionEvent motionEvent : z.this.g) {
                    if (motionEvent != null) {
                        z.this.dl.add(motionEvent.getDownTime() + "_" + motionEvent.getPointerId(motionEvent.getActionIndex()));
                        rootView.dispatchTouchEvent(motionEvent);
                        motionEvent.recycle();
                    }
                }
                z.this.g.clear();
            }
        }, 300L);
    }
}
