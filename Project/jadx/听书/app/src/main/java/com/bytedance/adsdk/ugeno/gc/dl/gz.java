package com.bytedance.adsdk.ugeno.gc.dl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import com.bytedance.adsdk.ugeno.m.fo;

/* JADX INFO: loaded from: classes2.dex */
public class gz extends g implements fo.z {
    private int kb;
    private Handler wp;

    public gz(Context context) {
        super(context);
        this.kb = 500;
        this.wp = new fo(Looper.getMainLooper(), this);
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
            this.wp.sendEmptyMessageDelayed(1101, this.kb);
            return false;
        }
        if (action != 1 && action != 3) {
            return false;
        }
        this.wp.removeMessages(1101);
        return false;
    }

    @Override // com.bytedance.adsdk.ugeno.m.fo.z
    public void z(Message message) {
        if (message.what != 1101) {
            return;
        }
        if (this.z != null) {
            this.z.z(this.g, this.m, this.dl.g());
        }
        Handler handler = this.wp;
        if (handler != null) {
            handler.removeMessages(1101);
        }
    }
}
