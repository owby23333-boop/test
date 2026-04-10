package com.bytedance.sdk.openadsdk.core.component.reward.a;

import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.iq.gb;
import com.bytedance.sdk.openadsdk.core.iq.jq;
import com.bytedance.sdk.openadsdk.core.iq.na;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public class fo extends z {
    private final AtomicBoolean eo;
    protected final AtomicLong gk;
    private long lq;
    private final AtomicBoolean mc;
    private com.bytedance.sdk.openadsdk.core.component.reward.business.z.z oq;
    private final AtomicBoolean ti;
    private final AtomicBoolean un;
    private final com.bytedance.sdk.openadsdk.core.video.g.g wj;
    private final int x;

    public static int g(na naVar) {
        return 10;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.g
    public boolean f() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.g
    public boolean jq() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.g
    public boolean sv() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.g
    public boolean yx() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.g
    public boolean zx() {
        return true;
    }

    public fo(TTBaseVideoActivity tTBaseVideoActivity, na naVar) {
        super(tTBaseVideoActivity, naVar);
        this.x = 4;
        this.lq = 4L;
        this.mc = new AtomicBoolean(false);
        this.un = new AtomicBoolean(false);
        this.ti = new AtomicBoolean(false);
        this.eo = new AtomicBoolean(false);
        this.gk = new AtomicLong();
        this.wj = new com.bytedance.sdk.openadsdk.core.video.g.g() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.a.fo.1
            @Override // com.bytedance.sdk.openadsdk.core.video.g.g
            public boolean z() {
                if (!fo.this.ti.get() && !jq.g(fo.this.g)) {
                    return false;
                }
                fo.this.nh();
                return true;
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.g.g
            public void g() {
                fo.this.ti.set(false);
                fo.this.fo.gc(8);
                if (!fo.this.e()) {
                    fo.this.z.xl();
                }
                fo.this.z.zw();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.g.g
            public void z(long j, long j2) {
                fo.this.js.g(j);
                fo.this.tb();
                fo.this.gk.set(j);
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.g.g
            public void dl() {
                fo.this.lq();
                fo.this.eo.set(true);
                fo.this.z.wp();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.g.g
            public boolean a() {
                return fo.this.eo.get();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.g.g
            public long gc() {
                return fo.this.gk.get();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.g.g
            public boolean m() {
                return fo.this.q.m();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.g.g
            public Map<String, Object> e() {
                HashMap map = new HashMap();
                map.put("refer", "in_video");
                return map;
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.g.g
            public void gz() {
                fo.this.r();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.g.g
            public void fo() {
                fo.this.z.xl();
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.g.g
            public void uy() {
                if (fo.this.z != null) {
                    fo.this.z.kb();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.g.g
            public int kb() {
                return fo.this.ti.get() ? 1 : 2;
            }
        };
    }

    public static boolean z(na naVar) {
        return jq.z(naVar);
    }

    public void me() {
        if (this.un.get()) {
            return;
        }
        int iGk = (int) this.js.gk();
        int iQ = (int) this.js.q();
        int iDl = jq.dl(this.g);
        if (iDl == 1) {
            z(jq.a(this.g), iQ, 1000 * ((long) this.h.gc()), false);
        } else if (iDl == 2) {
            z((int) (iQ * 0.001f * 0.01f * jq.a(this.g)), iQ, iGk, false);
        } else {
            if (iDl != 3) {
                return;
            }
            z(ti(), iQ, iGk, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nh() {
        this.fo.gc(0);
        this.z.na();
        this.oq.dl();
        this.z.iq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        this.mc.set(false);
    }

    private void z(int i, long j, long j2, boolean z) {
        if (z) {
            if (i <= 3) {
                yz();
            }
        } else if (i > 0) {
            long j3 = ((long) i) * 1000;
            if (j3 > j) {
                return;
            }
            long j4 = j3 - j2;
            if (j4 <= 0 || Math.abs(j4) > 3200) {
                return;
            }
            yz();
        }
    }

    private void yz() {
        this.un.set(true);
        this.oq.z();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.g
    public void lw() {
        this.fo.gc(8);
        this.fo.m(0);
        this.fv.gc(true);
        this.fv.dl(true);
        this.fv.g(true);
        this.fv.z(true);
        this.z.t();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.g
    protected void rv() {
        if (this.zw != null) {
            ((com.bytedance.sdk.openadsdk.core.g.z.z.z) this.zw.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).z(this.wj);
            ((com.bytedance.sdk.openadsdk.core.g.z.dl.z) this.zw.z(com.bytedance.sdk.openadsdk.core.g.z.dl.z.class)).z(this.wj);
        }
        if (this.gz != null) {
            ((com.bytedance.sdk.openadsdk.core.g.z.z.z) this.gz.z(com.bytedance.sdk.openadsdk.core.g.z.z.z.class)).z(this.wj);
            ((com.bytedance.sdk.openadsdk.core.g.z.dl.z) this.gz.z(com.bytedance.sdk.openadsdk.core.g.z.dl.z.class)).z(this.wj);
        }
        com.bytedance.sdk.openadsdk.core.component.reward.business.z.z zVar = new com.bytedance.sdk.openadsdk.core.component.reward.business.z.z(this.z, this.g, this.wj);
        this.oq = zVar;
        zVar.z(this.z.mc().getSceneFrameContainer(), this.z.mc().getSceneFrame());
        this.mc.set(jq.dl(this.g) != 0);
        if (this.mc.get()) {
            this.ls = true;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public int h() {
        return g(this.g);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.g
    protected void b() {
        bm();
        if (gb.p(this.g)) {
            this.z.dl(0);
            if (uf() > na() || this.pf) {
                com.bytedance.sdk.openadsdk.core.gz.a.z = 0;
            }
            g(m(true));
            com.bytedance.sdk.openadsdk.core.gz.a.z = oq();
        }
    }

    private void bm() {
        if (this.mc.get()) {
            me();
            sd();
        }
    }

    private void sd() {
        if (this.un.get()) {
            long j = this.lq - 1;
            this.lq = j;
            if (j != 0) {
                if (j > 0) {
                    this.oq.z(j);
                }
            } else {
                this.oq.z(j);
                this.ti.set(true);
                if (e()) {
                    this.oq.z(this.zw);
                } else {
                    this.oq.z(this.gz);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public void tb() {
        super.tb();
        this.ls = false;
        boolean z = ((int) (this.js.gk() / 1000)) >= this.h.dl() || this.z.y();
        if (this.js.mc()) {
            this.fv.z(false, null, "跳过", false, true);
            return;
        }
        int iH = this.js.h();
        if (this.js.z()) {
            return;
        }
        this.fv.z(false, iH + "s", z ? "跳过" : "", false, z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public void lq() {
        super.lq();
        this.fv.z(false, "奖励已领取", "跳过", false, true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public void io() {
        super.io();
        this.fv.z(false, "奖励已领取", "跳过", false, true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public com.bytedance.sdk.openadsdk.core.video.g.g mc() {
        return this.wj;
    }
}
