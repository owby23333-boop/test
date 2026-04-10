package com.bytedance.adsdk.ugeno.dl.g;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.bytedance.adsdk.ugeno.dl.fv;
import com.bytedance.adsdk.ugeno.dl.ls;

/* JADX INFO: loaded from: classes2.dex */
public class dl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f222a;
    private ls dl;
    private float g;
    private boolean gc;
    private final int m;
    private float z;

    public dl(Context context, ls lsVar) {
        this.f222a = context;
        this.dl = lsVar;
        this.m = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public boolean z(fv fvVar, com.bytedance.adsdk.ugeno.g.dl dlVar, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.z = motionEvent.getX();
            this.g = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (Math.abs(x - this.z) >= this.m || Math.abs(y - this.g) >= this.m) {
                    this.gc = true;
                }
            } else if (action == 3) {
                this.gc = false;
            }
        } else {
            if (this.gc) {
                this.gc = false;
                return false;
            }
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            if (Math.abs(x2 - this.z) >= this.m || Math.abs(y2 - this.g) >= this.m) {
                this.gc = false;
            } else if (fvVar != null) {
                fvVar.z(this.dl, dlVar, dlVar);
                return true;
            }
        }
        return true;
    }
}
