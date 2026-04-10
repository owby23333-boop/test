package com.bytedance.sdk.openadsdk.core.component.reward.activity;

import androidx.media3.exoplayer.ExoPlayer;
import com.bytedance.sdk.openadsdk.core.component.reward.z;
import com.bytedance.sdk.openadsdk.core.component.reward.z.g;
import com.bytedance.sdk.openadsdk.core.iq.gb;
import com.bytedance.sdk.openadsdk.core.zw;

/* JADX INFO: loaded from: classes2.dex */
public class TTFullScreenVideoActivity extends TTBaseVideoActivity {
    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public boolean sy() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    public void t() {
        String str;
        super.t();
        if (gb.p(this.gc) || this.mc.h()) {
            return;
        }
        if (this.ti.mc()) {
            this.lq.z(false, null, null, true, true);
            return;
        }
        int iGk = ((int) this.ti.gk()) / 1000;
        String str2 = this.wj.m(false) + "s";
        boolean z = iGk >= this.wj.vm();
        if (z) {
            str = "跳过";
        } else {
            str = zw.g().gc(String.valueOf(this.j)) ? (this.wj.vm() - iGk) + "s后可跳过" : null;
        }
        this.lq.z(false, str2, str, false, z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    protected void hh() {
        if (this.dl.getAndSet(true)) {
            return;
        }
        a("onAdClose");
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    protected void dl(boolean z) {
        byte b = -1;
        if (this.io) {
            if (zw.g().tp() == 1) {
                b = 2000;
            }
        } else if (z) {
            b = 0;
        }
        if (b < 0 || this.q.get()) {
            return;
        }
        if (b == 0) {
            if (this.q.getAndSet(true)) {
                return;
            }
            g.z().z(String.valueOf(this.j));
            return;
        }
        this.g.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.activity.TTFullScreenVideoActivity.1
            @Override // java.lang.Runnable
            public void run() {
                if (TTFullScreenVideoActivity.this.q.getAndSet(true)) {
                    return;
                }
                g.z().z(String.valueOf(TTFullScreenVideoActivity.this.j));
            }
        }, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity
    protected void a(String str) {
        z.z(1, this.gp, str, null);
    }
}
