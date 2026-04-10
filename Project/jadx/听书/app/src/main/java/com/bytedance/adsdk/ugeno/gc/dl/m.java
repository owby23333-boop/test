package com.bytedance.adsdk.ugeno.gc.dl;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.adsdk.ugeno.m.fo;

/* JADX INFO: loaded from: classes2.dex */
public class m extends g implements fo.z {
    private Handler i;
    private int kb;
    private int v;
    private int wp;

    public m(Context context) {
        super(context);
        this.wp = 0;
        this.i = new fo(Looper.getMainLooper(), this);
        this.v = 0;
    }

    @Override // com.bytedance.adsdk.ugeno.gc.dl.g
    public boolean z(Object... objArr) {
        if (this.gc != null) {
            int iZ = com.bytedance.adsdk.ugeno.m.dl.z(this.gc.get("loop"), 0);
            this.kb = iZ;
            if (iZ <= 0) {
                this.v = -1;
            } else {
                this.v = iZ;
            }
            this.wp = com.bytedance.adsdk.ugeno.m.dl.z(this.gc.get("duration"), 0);
        }
        this.i.sendEmptyMessageDelayed(1001, this.wp);
        return true;
    }

    @Override // com.bytedance.adsdk.ugeno.m.fo.z
    public void z(Message message) {
        int i;
        int i2;
        if (message.what != 1001) {
            return;
        }
        this.z.z(this.g, this.m, this.dl.g());
        int i3 = this.v - 1;
        this.v = i3;
        if (i3 < 0 && (i2 = this.wp) != 0) {
            this.i.sendEmptyMessageDelayed(1001, i2);
        } else if (i3 > 0 && (i = this.wp) != 0) {
            this.i.sendEmptyMessageDelayed(1001, i);
        } else {
            this.i.removeMessages(1001);
        }
    }
}
