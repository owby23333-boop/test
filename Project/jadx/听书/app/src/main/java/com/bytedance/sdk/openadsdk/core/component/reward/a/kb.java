package com.bytedance.sdk.openadsdk.core.component.reward.a;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.component.reward.dl.g;
import com.bytedance.sdk.openadsdk.core.iq.hh;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.y;
import com.bytedance.sdk.openadsdk.core.q.v;
import com.bytedance.sdk.openadsdk.core.un.eo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class kb extends z {
    private final List<com.bytedance.sdk.openadsdk.core.component.reward.swiper.z> gk;
    private int x;

    public static int g(na naVar) {
        return 11;
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

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.g
    public boolean sv() {
        return true;
    }

    public kb(TTBaseVideoActivity tTBaseVideoActivity, na naVar) {
        super(tTBaseVideoActivity, naVar);
        this.gk = new ArrayList();
        this.x = 0;
    }

    public static boolean z(na naVar) {
        if (naVar == null || !hh.z(naVar)) {
            return false;
        }
        if (!com.bytedance.sdk.openadsdk.core.pf.a.z(String.valueOf(eo.fo(naVar)))) {
            return true;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CmcdConfiguration.KEY_CONTENT_ID, naVar.mk());
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
        v.z().z(naVar, "refresh_max", jSONObject);
        com.bytedance.sdk.openadsdk.core.i.a.e(naVar, eo.g(naVar), "refresh_max", null);
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public com.bytedance.sdk.openadsdk.core.component.reward.layout.g z(boolean z) {
        com.bytedance.sdk.openadsdk.core.component.reward.layout.uy uyVar = new com.bytedance.sdk.openadsdk.core.component.reward.layout.uy(this.z, this.g, z);
        uyVar.z(new float[]{this.gc, this.m});
        this.fo = uyVar;
        return this.fo;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public View fo() {
        FrameLayout frameLayout = new FrameLayout(this.z);
        frameLayout.setId(2114387959);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        frameLayout.setBackgroundColor(0);
        return frameLayout;
    }

    private com.bytedance.sdk.openadsdk.core.component.reward.layout.uy r() {
        if (this.fo instanceof com.bytedance.sdk.openadsdk.core.component.reward.layout.uy) {
            return (com.bytedance.sdk.openadsdk.core.component.reward.layout.uy) this.fo;
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public void iq() {
        ((com.bytedance.sdk.openadsdk.core.component.reward.layout.uy) this.fo).dl();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.g
    public void lw() {
        this.fv.z(false);
        this.fv.g(false);
        this.fv.gc(false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public void v() {
        super.v();
        ((com.bytedance.sdk.openadsdk.core.component.reward.layout.uy) this.fo).g();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public void g(boolean z) {
        super.g(z);
        ((com.bytedance.sdk.openadsdk.core.component.reward.layout.uy) this.fo).dl();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public void gz() {
        super.gz();
        com.bytedance.sdk.openadsdk.core.component.reward.swiper.z zVar = new com.bytedance.sdk.openadsdk.core.component.reward.swiper.z(this.z, this.g, this.wp, sv(), true);
        zVar.z(this.i);
        this.gk.add(zVar);
        if (hh.dl(this.g)) {
            try {
                JSONArray jSONArray = new JSONArray(this.g.lo());
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(com.bytedance.sdk.openadsdk.core.z.z(jSONArray.getJSONObject(i)));
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(this.g);
                arrayList2.addAll(arrayList);
                if (hh.z(arrayList2)) {
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        com.bytedance.sdk.openadsdk.core.component.reward.swiper.z zVar2 = new com.bytedance.sdk.openadsdk.core.component.reward.swiper.z(this.z, (na) arrayList.get(i2), this.wp, sv(), false);
                        zVar2.z(this.i);
                        this.gk.add(zVar2);
                    }
                }
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.wp.z(e);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z, com.bytedance.sdk.openadsdk.core.component.reward.a.g
    protected void dl() {
        this.fo.dl(true);
        if (r() != null) {
            r().z(this.gk);
        }
        this.z.g(false, true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public void io() {
        super.io();
        if (this.fo instanceof com.bytedance.sdk.openadsdk.core.component.reward.layout.uy) {
            ((com.bytedance.sdk.openadsdk.core.component.reward.layout.uy) this.fo).uy();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    protected int eo() {
        return y.dl(this.g) - this.x;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public void lq() {
        super.lq();
        if (this.fo instanceof com.bytedance.sdk.openadsdk.core.component.reward.layout.uy) {
            ((com.bytedance.sdk.openadsdk.core.component.reward.layout.uy) this.fo).a();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    protected int e(boolean z) {
        if (z) {
            return eo();
        }
        return y.e(this.g) - this.x;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    protected int wj() {
        return this.x;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public void gc(boolean z) {
        super.gc(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public g.z z(na naVar, final com.bytedance.sdk.openadsdk.core.component.reward.dl.uy uyVar) {
        this.z.na();
        com.bytedance.sdk.openadsdk.core.component.reward.dl.gc gcVar = new com.bytedance.sdk.openadsdk.core.component.reward.dl.gc(this.z, naVar);
        gcVar.z(oq());
        return gcVar.g(new com.bytedance.sdk.openadsdk.core.component.reward.dl.uy() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.a.kb.1
            @Override // com.bytedance.sdk.openadsdk.core.component.reward.dl.uy
            public void z() {
                super.z();
                com.bytedance.sdk.openadsdk.core.component.reward.dl.uy uyVar2 = uyVar;
                if (uyVar2 != null) {
                    uyVar2.z();
                }
                kb.this.z.xl();
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
                com.bytedance.sdk.openadsdk.core.component.reward.dl.uy uyVar2 = uyVar;
                if (uyVar2 != null) {
                    uyVar2.dl();
                }
                kb.this.z.xl();
                kb.this.z.bv().z("reward_retain_dialog_next", 0, "");
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public void pf() {
        super.pf();
        this.fo.uy();
        List<com.bytedance.sdk.openadsdk.core.component.reward.swiper.z> list = this.gk;
        if (list != null) {
            Iterator<com.bytedance.sdk.openadsdk.core.component.reward.swiper.z> it = list.iterator();
            while (it.hasNext()) {
                it.next().gz();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public int h() {
        return g(this.g);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public void z(Map<String, Object> map) {
        super.z(map);
        map.put("refresh_num", Integer.valueOf(yz()));
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public void z(JSONObject jSONObject) {
        super.z(jSONObject);
        try {
            jSONObject.put("refresh_num", yz());
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.wp.z(e);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public void g(Map<String, Object> map) {
        super.g(map);
        map.put("refresh_num", Integer.valueOf(yz()));
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public void z(View view) {
        super.z(view);
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.a.z
    public void q() {
        ((com.bytedance.sdk.openadsdk.core.component.reward.layout.uy) this.fo).g();
    }

    private int yz() {
        int iGc;
        com.bytedance.sdk.openadsdk.core.component.reward.swiper.z zVar;
        na naVarZ;
        hh hhVarDp;
        com.bytedance.sdk.openadsdk.core.component.reward.layout.uy uyVar = (com.bytedance.sdk.openadsdk.core.component.reward.layout.uy) this.fo;
        if (uyVar == null || (iGc = uyVar.gc()) < 0 || iGc >= this.gk.size() || (zVar = this.gk.get(iGc)) == null || (naVarZ = zVar.z()) == null || (hhVarDp = naVarZ.dp()) == null) {
            return 0;
        }
        return hhVarDp.dl();
    }

    public void me() {
        ((com.bytedance.sdk.openadsdk.core.component.reward.layout.uy) this.fo).a();
    }

    public void nh() {
        ((com.bytedance.sdk.openadsdk.core.component.reward.layout.uy) this.fo).m();
    }
}
