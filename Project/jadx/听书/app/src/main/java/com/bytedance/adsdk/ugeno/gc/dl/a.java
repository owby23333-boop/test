package com.bytedance.adsdk.ugeno.gc.dl;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class a extends g {
    private int i;
    private float kb;
    private AtomicBoolean ls;
    private String p;
    private int pf;
    private int v;
    private float wp;

    public a(Context context) {
        super(context);
        this.i = 0;
        this.v = Integer.MAX_VALUE;
        this.pf = Integer.MAX_VALUE;
        this.ls = new AtomicBoolean(true);
        this.p = "up";
    }

    @Override // com.bytedance.adsdk.ugeno.gc.dl.g
    public boolean z(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return false;
        }
        if (this.gc != null) {
            this.p = TextUtils.isEmpty(this.gc.get("direction")) ? TtmlNode.COMBINE_ALL : this.gc.get("direction");
            this.i = com.bytedance.adsdk.ugeno.m.dl.z(this.gc.get("distance"), 0);
            if (this.v == Integer.MAX_VALUE) {
                this.v = com.bytedance.adsdk.ugeno.m.dl.z(this.gc.get("frequency"), Integer.MAX_VALUE);
            }
            if (this.pf == Integer.MAX_VALUE) {
                this.pf = com.bytedance.adsdk.ugeno.m.dl.z(this.gc.get("effectiveDuration"), Integer.MAX_VALUE);
            }
            this.ls.get();
        }
        MotionEvent motionEvent = (MotionEvent) objArr[0];
        z();
        return z(this.g, motionEvent);
    }

    private void z() {
        if (this.pf == Integer.MAX_VALUE || this.g == null || System.currentTimeMillis() - this.g.zw() < this.pf) {
            return;
        }
        this.ls.set(false);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean z(com.bytedance.adsdk.ugeno.g.dl r11, android.view.MotionEvent r12) {
        /*
            Method dump skipped, instruction units count: 206
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.gc.dl.a.z(com.bytedance.adsdk.ugeno.g.dl, android.view.MotionEvent):boolean");
    }

    private boolean g(com.bytedance.adsdk.ugeno.g.dl dlVar) {
        if (this.v <= 0 || !this.ls.get()) {
            return false;
        }
        this.z.z(dlVar, this.m, this.dl.g());
        int i = this.v;
        if (i != Integer.MAX_VALUE) {
            this.v = i - 1;
        }
        return true;
    }
}
