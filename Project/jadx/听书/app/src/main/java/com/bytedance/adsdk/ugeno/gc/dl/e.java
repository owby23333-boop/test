package com.bytedance.adsdk.ugeno.gc.dl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import com.bytedance.adsdk.ugeno.m.fo;

/* JADX INFO: loaded from: classes2.dex */
public class e extends g implements fo.z {
    private Handler i;
    private int kb;
    private boolean wp;

    public e(Context context) {
        super(context);
        this.kb = 500;
        this.i = new fo(Looper.getMainLooper(), this);
    }

    @Override // com.bytedance.adsdk.ugeno.gc.dl.g
    public boolean z(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return false;
        }
        MotionEvent motionEvent = (MotionEvent) objArr[0];
        this.kb = com.bytedance.adsdk.ugeno.m.dl.z(this.gc.get("delay"), 500);
        return z(this.g, motionEvent);
    }

    private boolean z(com.bytedance.adsdk.ugeno.g.dl dlVar, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.i.sendEmptyMessageDelayed(1102, this.kb);
        } else {
            if (action == 1) {
                if (this.wp && this.z != null) {
                    this.z.z(this.g, this.m, this.dl.g());
                    this.wp = false;
                    Handler handler = this.i;
                    if (handler != null) {
                        handler.removeMessages(1102);
                    }
                    return true;
                }
                Handler handler2 = this.i;
                if (handler2 != null) {
                    handler2.removeMessages(1102);
                }
                this.wp = false;
                return false;
            }
            if (action == 3) {
                Handler handler3 = this.i;
                if (handler3 != null) {
                    handler3.removeMessages(1102);
                }
                this.wp = false;
            }
        }
        return true;
    }

    @Override // com.bytedance.adsdk.ugeno.m.fo.z
    public void z(Message message) {
        if (message.what != 1102) {
            return;
        }
        this.wp = true;
        Handler handler = this.i;
        if (handler != null) {
            handler.removeMessages(1102);
        }
    }
}
