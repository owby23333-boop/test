package com.bytedance.sdk.openadsdk.core.ugeno.fo;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.un.oq;

/* JADX INFO: loaded from: classes2.dex */
public class dl implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private z f1359a;
    private boolean dl;
    private float g;
    private int gc;
    private Context m;
    private float z;

    public interface z {
        void g();

        void z();
    }

    public dl(Context context, z zVar, int i) {
        this.m = context;
        this.gc = i;
        this.f1359a = zVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.z = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
                float y = motionEvent.getY();
                this.g = y;
                if (Math.abs(y - this.z) > 10.0f) {
                    this.dl = true;
                }
            }
        } else {
            if (!this.dl) {
                z zVar = this.f1359a;
                if (zVar != null) {
                    zVar.g();
                }
                return true;
            }
            int iA = oq.a(this.m, Math.abs(this.g - this.z));
            if (this.g - this.z < 0.0f && iA > this.gc) {
                z zVar2 = this.f1359a;
                if (zVar2 != null) {
                    zVar2.z();
                }
            } else {
                z zVar3 = this.f1359a;
                if (zVar3 != null) {
                    zVar3.g();
                }
            }
        }
        return true;
    }
}
