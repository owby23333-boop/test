package com.bytedance.sdk.openadsdk.core.component.reward.a;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.sdk.component.adexpress.g.v;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.dl.g;
import com.bytedance.sdk.openadsdk.core.component.reward.draw.dl;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.tf;
import com.bytedance.sdk.openadsdk.core.iq.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class dl extends com.bytedance.sdk.openadsdk.core.component.reward.a.z {
    private int eo;
    private final List<com.bytedance.sdk.openadsdk.core.component.reward.draw.g> gk;
    private com.bytedance.sdk.openadsdk.core.component.reward.draw.gc gp;
    private final AtomicBoolean j;
    private int lq;
    private int mc;
    private final AtomicBoolean na;
    private final AtomicBoolean oq;
    private com.bytedance.sdk.openadsdk.core.component.reward.view.ugen.z t;
    private int ti;
    private int un;
    private com.bytedance.sdk.openadsdk.core.ugeno.uy.z vm;
    private final AtomicBoolean wj;
    private int x;
    private final AtomicBoolean xl;

    public interface z {
        void a();

        Map<String, Object> dl();

        void g();

        void z();

        void z(int i);

        void z(long j, long j2);
    }

    public static int g(na naVar) {
        return 8;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.g
    public boolean f() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.g
    public boolean jq() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public boolean m() {
        return false;
    }

    public dl(TTBaseVideoActivity tTBaseVideoActivity, na naVar) {
        super(tTBaseVideoActivity, naVar);
        this.gk = new ArrayList();
        this.x = 0;
        this.lq = 0;
        this.mc = 0;
        this.un = 0;
        this.ti = 0;
        this.eo = 0;
        this.oq = new AtomicBoolean(false);
        this.wj = new AtomicBoolean(false);
        this.na = new AtomicBoolean(true);
        this.xl = new AtomicBoolean(false);
        this.j = new AtomicBoolean(true);
    }

    public static boolean z(na naVar) {
        return (naVar == null || !y.z(naVar) || TextUtils.isEmpty(naVar.lo())) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public com.bytedance.sdk.openadsdk.core.component.reward.layout.g z(boolean z2) {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.a aVar = new com.bytedance.sdk.openadsdk.core.component.reward.layout.a(this.z, this.g, z2);
        float f = this.m;
        float[] fArrJs = {this.gc, f};
        if (fArrJs[0] < 10.0f || f < 10.0f) {
            fArrJs = js();
        }
        aVar.z(fArrJs);
        this.fo = aVar;
        return this.fo;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public View fo() {
        return com.bytedance.sdk.openadsdk.res.gc.uy(this.z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.openadsdk.core.component.reward.layout.a r() {
        if (this.fo instanceof com.bytedance.sdk.openadsdk.core.component.reward.layout.a) {
            return (com.bytedance.sdk.openadsdk.core.component.reward.layout.a) this.fo;
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public void iq() {
        if (this.tb.mc()) {
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.core.component.reward.draw.gc gcVar = (com.bytedance.sdk.openadsdk.core.component.reward.draw.gc) r().g().dl(this.ti);
            if (gcVar != null) {
                gcVar.l();
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.dl("cubic  resume exception:" + e.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.g
    public boolean sv() {
        return this.g.d() == 2 || this.g.d() == 3 || this.g.d() == 7;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.g
    public void lw() {
        this.fv.z(true);
        this.fv.g(this.g.sz());
        this.fv.dl(true);
        this.fv.gc(true);
        if (!TextUtils.isEmpty(y.kb(this.g))) {
            this.fv.z(false);
            com.bytedance.sdk.openadsdk.core.component.reward.view.ugen.z zVar = new com.bytedance.sdk.openadsdk.core.component.reward.view.ugen.z(this.g);
            this.t = zVar;
            zVar.z(new com.bytedance.sdk.component.adexpress.g.e() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.a.dl.1
                boolean z = false;

                @Override // com.bytedance.sdk.component.adexpress.g.e
                public void z(final View view, final v vVar) {
                    if (this.z) {
                        return;
                    }
                    dl.this.z.mc().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.a.dl.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            dl.this.z.mc().getTopFrameContainer().removeAllViews();
                            dl.this.z.mc().getTopFrameContainer().addView(view);
                            dl.this.fv.z(true);
                            v vVar2 = vVar;
                            if (vVar2 instanceof com.bytedance.sdk.openadsdk.core.ugeno.express.dl) {
                                dl.this.vm = ((com.bytedance.sdk.openadsdk.core.ugeno.express.dl) vVar2).fv();
                                dl.this.vm.z((int) (dl.this.h.z() / 1000), dl.this.h.gc(), dl.this.h.g(), dl.this.m(false));
                                dl.this.b();
                            }
                        }
                    });
                }

                @Override // com.bytedance.sdk.component.adexpress.g.e
                public void z(int i, String str) {
                    this.z = true;
                    dl.this.fv.z(true);
                }
            });
            this.t.z(new com.bytedance.sdk.component.adexpress.g.gz() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.a.dl.2
                @Override // com.bytedance.sdk.component.adexpress.g.gz
                public void z(View view, int i, com.bytedance.sdk.component.adexpress.dl dlVar, int i2) {
                }

                @Override // com.bytedance.sdk.component.adexpress.g.gz
                public void z(View view, int i, com.bytedance.sdk.component.adexpress.dl dlVar) {
                    if (i == 3) {
                        dl.this.gp().uy();
                    } else if (i == 5) {
                        dl.this.gp().z(!dl.this.i);
                    } else {
                        if (i != 6) {
                            return;
                        }
                        dl.this.gp().e();
                    }
                }
            });
            this.t.z(new com.bytedance.sdk.openadsdk.core.ugeno.express.z.g() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.a.dl.3
                @Override // com.bytedance.sdk.openadsdk.core.ugeno.express.z.g
                public void z() {
                    dl.this.ec();
                }
            });
            this.t.z(y.kb(this.g), y.wp(this.g), this.gc, 0, y.i(this.g));
        }
        b();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public void gz() {
        super.gz();
        this.gk.add(new com.bytedance.sdk.openadsdk.core.component.reward.draw.g(this.z, this.g, this.wp, sv(), true));
        try {
            JSONArray jSONArray = new JSONArray(this.g.lo());
            for (int i = 0; i < jSONArray.length(); i++) {
                this.gk.add(new com.bytedance.sdk.openadsdk.core.component.reward.draw.g(this.z, com.bytedance.sdk.openadsdk.core.z.z(jSONArray.getJSONObject(i)), this.wp, sv(), false));
            }
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        Iterator<com.bytedance.sdk.openadsdk.core.component.reward.draw.g> it = this.gk.iterator();
        while (it.hasNext()) {
            it.next().z(this.i);
        }
        this.xl.set(y.v(this.g));
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z, com.bytedance.sdk.openadsdk.core.component.reward.a.g
    protected void dl() {
        this.fo.dl(true);
        if (r() != null) {
            r().dl().z(this.gk);
            r().a().z(new dl.z() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.a.dl.4
                @Override // com.bytedance.sdk.openadsdk.core.component.reward.draw.dl.z
                public void z() {
                    dl.this.ls = true;
                    dl.this.un = 0;
                    z((com.bytedance.sdk.openadsdk.core.component.reward.draw.gc) dl.this.r().g().dl(0));
                    dl.this.tf();
                    dl.this.ja();
                    dl.this.z.g(false, true);
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.reward.draw.dl.z
                public void z(boolean z2, int i, boolean z3) {
                    int i2 = dl.this.ti;
                    if (dl.this.gp != null) {
                        dl.this.z.bv().z(z2, i2 + 1, dl.this.gp.x());
                    }
                    dl.this.ti = i;
                    dl dlVar = dl.this;
                    dlVar.eo = Math.max(dlVar.eo, i + 1);
                    dl dlVar2 = dl.this;
                    dlVar2.un = i % dlVar2.gk.size();
                    z((com.bytedance.sdk.openadsdk.core.component.reward.draw.gc) dl.this.r().g().dl(i));
                    dl.this.r().m();
                    dl.this.wj.set(true);
                    dl.this.xl.set(y.v(dl.this.g) && dl.this.un + 1 < dl.this.gk.size());
                    dl.this.b();
                    dl.this.ja();
                    dl.this.fv.z(((com.bytedance.sdk.openadsdk.core.component.reward.draw.g) dl.this.gk.get(dl.this.un)).z());
                }

                @Override // com.bytedance.sdk.openadsdk.core.component.reward.draw.dl.z
                public void z(boolean z2, int i) {
                    com.bytedance.sdk.openadsdk.core.component.reward.draw.gc gcVar = (com.bytedance.sdk.openadsdk.core.component.reward.draw.gc) dl.this.r().g().dl(i);
                    if (gcVar != null) {
                        gcVar.g(false);
                    }
                }

                private void z(com.bytedance.sdk.openadsdk.core.component.reward.draw.gc gcVar) {
                    if (gcVar != null) {
                        dl.this.gp = gcVar;
                        dl.this.gp.g(true);
                        dl.this.gp.z(new z() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.a.dl.4.1
                            @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.dl.z
                            public void z() {
                                dl.this.ls = true;
                                dl.this.r().z(false);
                            }

                            @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.dl.z
                            public void g() {
                                dl.this.ls = false;
                                dl.this.r().z(true);
                            }

                            @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.dl.z
                            public void z(int i) {
                                dl.this.x += i;
                                dl.this.lq += i;
                                dl.this.z.kb(i);
                            }

                            @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.dl.z
                            public Map<String, Object> dl() {
                                return dl.this.z.gz();
                            }

                            @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.dl.z
                            public void a() {
                                if (dl.this.un + 1 >= dl.this.gk.size() || !dl.this.na.get()) {
                                    dl.this.z.m(1);
                                } else if (dl.this.nh()) {
                                    dl.this.gz(false);
                                }
                            }

                            @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.dl.z
                            public void z(long j, long j2) {
                                dl.this.ls = false;
                            }
                        });
                        dl.this.ls = gcVar.eo();
                        dl.this.r().z(!gcVar.oq());
                    } else {
                        dl.this.ls = false;
                    }
                    dl.this.tf();
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public void io() {
        super.io();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("visible", false);
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        this.tb.z(jSONObject);
        if (!bv()) {
            q();
        }
        this.na.set(false);
        this.fv.z((String) null, (String) null, false);
        com.bytedance.sdk.openadsdk.core.ugeno.uy.z zVar = this.vm;
        if (zVar != null) {
            zVar.z(0, true, 0, 0, false, false, false);
            this.vm.z((int) (this.h.z() / 1000), this.h.gc(), this.h.g(), m(false));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    protected int eo() {
        return y.dl(this.g) - this.lq;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    protected int e(boolean z2) {
        if (z2) {
            return eo();
        }
        return y.e(this.g) - this.lq;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    protected int wj() {
        return this.lq;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.g
    protected void b() {
        bm();
        yz();
        sd();
    }

    private void yz() {
        com.bytedance.sdk.openadsdk.core.component.reward.draw.gc gcVar = this.gp;
        if (gcVar == null || !gcVar.eo()) {
            int iA = this.gk.get(this.un).a();
            if (iA > 0) {
                this.x += iA;
            }
            if ((y.dl(this.g) <= this.lq) && !this.oq.get()) {
                this.z.a(0);
                this.z.wp();
                this.oq.set(true);
            }
            int i = this.lq;
            if (i < this.x) {
                this.lq = i + 1;
            }
        }
    }

    private void bm() {
        String str;
        boolean z2;
        boolean z3 = Math.max(0, this.h.dl() - uf()) == 0;
        int iA = y.a(this.g);
        int iGc = y.gc(this.g);
        int iM = m(false);
        if (y.gz(this.g)) {
            String str2 = iM > 0 ? iM + "s" : "奖励已领取";
            z2 = false;
            str = str2;
        } else {
            if (iA == 0) {
                str = iM > 0 ? iM + "s后可领取奖励" : "领取成功";
                z2 = true;
            } else {
                str = iM > 0 ? iM + "s" : "领取成功";
                z2 = false;
            }
        }
        g(m(true));
        this.fv.z(z2, str, (z3 && iGc == 1) ? "跳过" : null, z3 && iGc == 0, z3);
        com.bytedance.sdk.openadsdk.core.ugeno.uy.z zVar = this.vm;
        if (zVar != null) {
            zVar.z((int) (this.h.z() / 1000), this.h.gc(), this.h.g(), m(false));
        }
    }

    private void sd() {
        int i;
        String str;
        if (y.gz(this.g)) {
            int iMin = this.un + 1;
            int size = this.gk.size();
            boolean z2 = this.un + 1 >= this.gk.size();
            boolean z3 = this.un == 0;
            int iMe = me();
            boolean z4 = this.h.gc() - this.mc < y.pf(this.g);
            if (this.na.get()) {
                if (!z4) {
                    iMin = Math.min(iMin + 1, size);
                }
                int i2 = iMin;
                String str2 = i2 + "/" + size;
                if (z4) {
                    str = (z3 ? "可看" + size + "个视频,当前 " : "正在播放 ") + str2;
                } else {
                    str = (!z2 ? iMe + "秒后播放 " : "") + str2;
                }
                this.fv.z(str, this.xl.get() ? "取消" : null, this.xl.get());
                com.bytedance.sdk.openadsdk.core.ugeno.uy.z zVar = this.vm;
                if (zVar != null) {
                    zVar.z(iMe, z2, i2, size, true, z4, this.xl.get());
                }
            } else {
                this.fv.z((String) null, (String) null, false);
                com.bytedance.sdk.openadsdk.core.ugeno.uy.z zVar2 = this.vm;
                if (zVar2 != null) {
                    i = iMe;
                    zVar2.z(0, z2, 0, 0, false, false, false);
                }
                if (i == 0 && !nh()) {
                    gz(false);
                }
            }
            i = iMe;
            if (i == 0) {
                gz(false);
            }
        }
        if (this.h.gc() <= y.fo(this.g) || this.wj.get() || r() == null) {
            return;
        }
        r().gc();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public void gc(boolean z2) {
        super.gc(z2);
        com.bytedance.sdk.openadsdk.core.component.reward.draw.gc gcVar = this.gp;
        if (gcVar != null) {
            gcVar.dl(z2);
        }
        Iterator<com.bytedance.sdk.openadsdk.core.component.reward.draw.g> it = this.gk.iterator();
        while (it.hasNext()) {
            it.next().z(z2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public g.z z(na naVar, final com.bytedance.sdk.openadsdk.core.component.reward.dl.uy uyVar) {
        this.z.na();
        com.bytedance.sdk.openadsdk.core.component.reward.dl.z dlVar = y.gz(naVar) ? new com.bytedance.sdk.openadsdk.core.component.reward.dl.dl(this.z, naVar) : new com.bytedance.sdk.openadsdk.core.component.reward.dl.gc(this.z, naVar);
        dlVar.z(oq());
        return dlVar.g(new com.bytedance.sdk.openadsdk.core.component.reward.dl.uy() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.a.dl.5
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.uy
            public void z() {
                super.z();
                com.bytedance.sdk.openadsdk.core.component.reward.dl.uy uyVar2 = uyVar;
                if (uyVar2 != null) {
                    uyVar2.z();
                }
                dl.this.z.xl();
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.uy
            public void g() {
                com.bytedance.sdk.openadsdk.core.component.reward.dl.uy uyVar2 = uyVar;
                if (uyVar2 != null) {
                    uyVar2.g();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.uy
            public void dl() {
                super.dl();
                dl.this.z.xl();
                dl.this.gz(true);
                dl.this.z.bv().z("reward_retain_dialog_next", 0, "");
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public void pf() {
        super.pf();
        List<com.bytedance.sdk.openadsdk.core.component.reward.draw.g> list = this.gk;
        if (list != null) {
            Iterator<com.bytedance.sdk.openadsdk.core.component.reward.draw.g> it = list.iterator();
            while (it.hasNext()) {
                it.next().gz();
            }
        }
        if (r() != null) {
            r().dl().a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tf() {
        com.bykv.vk.openvk.component.video.api.dl.a aVarUy;
        com.bytedance.sdk.openadsdk.core.component.reward.draw.gc gcVar = this.gp;
        na naVarZ = null;
        com.bykv.vk.openvk.component.video.api.a.dl dlVarTi = gcVar != null ? gcVar.ti() : null;
        com.bytedance.sdk.openadsdk.core.component.reward.draw.g gVar = this.gk.get(this.un);
        if (gVar != null) {
            naVarZ = gVar.z();
            aVarUy = gVar.uy();
        } else {
            aVarUy = null;
        }
        this.js.z(naVarZ, dlVarTi, aVarUy);
        this.js.g(this.z.gz());
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public int h() {
        return g(this.g);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public void z(Map<String, Object> map) {
        super.z(map);
        map.put("group_pos", Integer.valueOf(this.ti + 1));
        com.bytedance.sdk.openadsdk.core.component.reward.draw.gc gcVar = this.gp;
        if (gcVar != null) {
            map.put("duration", Long.valueOf(gcVar.x()));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public void z(JSONObject jSONObject) {
        super.z(jSONObject);
        try {
            jSONObject.put("group_pos", this.un + 1);
            jSONObject.put("duration", this.gp.x());
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public void z(View view) {
        super.z(view);
        this.gp.z(view);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public void q() {
        try {
            com.bytedance.sdk.openadsdk.core.component.reward.draw.gc gcVar = (com.bytedance.sdk.openadsdk.core.component.reward.draw.gc) r().g().dl(this.ti);
            if (gcVar != null) {
                gcVar.hh();
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.dl("cubic pause exception:" + e.getMessage());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public void ec() {
        this.na.set(false);
        this.j.set(false);
        b();
    }

    public int me() {
        return Math.max(0, ((((int) Math.min(Math.round(tf.m(this.gk.get(this.un).z())), y.g(r0))) + (nh() ? 1 : 0)) + this.mc) - this.h.gc());
    }

    public boolean nh() {
        na naVarZ = this.gk.get(this.un).z();
        return Math.round(tf.m(naVarZ)) <= ((long) y.g(naVarZ));
    }

    public void gz(boolean z2) {
        if (!this.tb.mc() && this.un + 1 < this.gk.size()) {
            this.mc = this.h.gc();
            if (!(z2 || this.j.get() || y.m(this.g)) || r() == null) {
                return;
            }
            r().g().g(this.ti + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ja() {
        if (this.un < this.gk.size() - 1) {
            this.gk.get(this.un + 1).wp();
            this.gk.get(this.un + 1).z(this.gc, this.m);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.g
    public boolean tc() {
        if (y.ls(this.g)) {
            return this.ls;
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z, com.bytedance.sdk.openadsdk.core.component.reward.a.g
    public boolean bv() {
        return y.gz(this.g);
    }
}
