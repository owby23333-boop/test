package com.bytedance.sdk.openadsdk.core.component.reward.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.media3.exoplayer.ExoPlayer;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.iq.ec;
import com.bytedance.sdk.openadsdk.core.iq.eo;
import com.bytedance.sdk.openadsdk.core.iq.fo;
import com.bytedance.sdk.openadsdk.core.iq.gb;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.tf;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.zw;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class uy extends z {
    boolean gk;
    private boolean x;

    public static int z(na naVar) {
        return 9;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.g
    public boolean f() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.g
    public boolean jq() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.g
    public void lw() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public boolean m() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.g
    public boolean sv() {
        return false;
    }

    public uy(TTBaseVideoActivity tTBaseVideoActivity, na naVar) {
        super(tTBaseVideoActivity, naVar);
        this.gk = false;
        this.x = false;
        this.x = com.bytedance.sdk.openadsdk.core.live.dl.g.z(naVar) == 1;
    }

    public static boolean z(Context context, na naVar) {
        long jM;
        if (!ec.a(naVar)) {
            return false;
        }
        if (eo.z(naVar)) {
            jM = ((long) eo.g(naVar)) * 1000;
        } else {
            jM = tf.v(naVar) != null ? (long) (tf.m(naVar) * 1000.0d) : 0L;
        }
        long jMin = Math.min(gb.z(), (long) (jM * (naVar.kg() / 100.0f)));
        HashMap map = new HashMap(3);
        map.put("reward_countdown", Long.valueOf(jMin));
        map.put("event_tag", "rewarded_video");
        map.put("reward_live_scene", Integer.valueOf(com.bytedance.sdk.openadsdk.core.live.dl.g.z(naVar)));
        return com.bytedance.sdk.openadsdk.core.live.g.z().g(context, naVar, map) == 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public com.bytedance.sdk.openadsdk.core.component.reward.layout.g z(boolean z) {
        this.fo = new com.bytedance.sdk.openadsdk.core.component.reward.layout.fo(this.z, this.g, z);
        return this.fo;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z, com.bytedance.sdk.openadsdk.core.component.reward.a.g
    protected void dl() {
        this.z.g(true, true);
        this.fo.dl(true);
        this.uy.dl(false);
        this.fv.z(false);
        int iGz = oq.gz(zw.getContext());
        com.bytedance.sdk.openadsdk.core.i.a.z("click", this.g, new fo.z().m(-1.0f).gc(-1.0f).a(-1.0f).dl(-1.0f).g(-1L).z(-1L).dl(-1).a(-1).gc(-1024).g(com.bytedance.sdk.openadsdk.core.uy.ls().dl() ? 1 : 2).z(iGz).z(oq.m(zw.getContext())).g(oq.e(zw.getContext())).z(), this.wp, true, this.z.j(), -1, false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public void z(int i, int i2, Intent intent) {
        super.z(i, i2, intent);
        if (i != 1) {
            this.z.finish();
            return;
        }
        if (intent == null || intent.getExtras() == null) {
            this.z.finish();
            return;
        }
        if (intent.getExtras().getLong("csj.reward_countdown_duration_ms") <= 0) {
            int i3 = intent.getExtras().getInt("csj.reward_auth_status", 0);
            if (this.x && i3 == 1) {
                this.z.finish();
                return;
            }
            com.bytedance.sdk.component.utils.wp.a("rewardAuthFlag", "verify rew....");
            this.z.a(0);
            gz(true);
            this.z.eo().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.a.uy.1
                @Override // java.lang.Runnable
                public void run() {
                    uy.this.me();
                }
            }, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
            return;
        }
        this.z.finish();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public void z(int i) {
        super.z(i);
        if (i == 0) {
            me();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public View fo() {
        FrameLayout frameLayout = new FrameLayout(this.z);
        frameLayout.setId(2114387959);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return frameLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void me() {
        if (this.gk) {
            return;
        }
        this.gk = true;
        gz(false);
        this.z.finish();
    }

    private void gz(final boolean z) {
        if (this.fo instanceof com.bytedance.sdk.openadsdk.core.component.reward.layout.fo) {
            com.bytedance.sdk.openadsdk.hh.e.z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.a.uy.2
                @Override // java.lang.Runnable
                public void run() {
                    if (uy.this.fo == null) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.core.component.reward.layout.fo foVar = (com.bytedance.sdk.openadsdk.core.component.reward.layout.fo) uy.this.fo;
                    if (z) {
                        foVar.g();
                    } else {
                        foVar.dl();
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public int h() {
        return z(this.g);
    }
}
