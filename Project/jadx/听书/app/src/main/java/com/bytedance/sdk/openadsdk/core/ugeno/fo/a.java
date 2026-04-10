package com.bytedance.sdk.openadsdk.core.ugeno.fo;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.openadsdk.core.i.m;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.core.ugeno.component.g.gc;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a extends com.bytedance.sdk.openadsdk.core.ugeno.e.z {
    private boolean io;
    private List<com.bytedance.sdk.openadsdk.core.ugeno.component.g.dl> iq;
    private int zw;

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void a() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public int dl() {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void dl(int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void e() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void fo() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public int g() {
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void g(int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void gc() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public long getActualPlayDuration() {
        return 0L;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void gz() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void kb() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void m() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void setPauseFromExpressView(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void uy() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public long z() {
        return 0L;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void z(float f) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void z(float f, float f2, float f3, float f4, int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void z(int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void z(int i, String str) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.e.a
    public void z(RecyclerView recyclerView, int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.uy
    public void z(boolean z) {
    }

    public a(Context context, ViewGroup viewGroup, m mVar, na naVar, String str, int i) {
        super(context, viewGroup, mVar, naVar, str, i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.e.z
    public List<com.bytedance.sdk.openadsdk.core.ugeno.component.g.dl> wp() {
        this.iq = new ArrayList();
        JSONObject jSONObjectKv = this.gc.kv();
        this.iq.add(0, new com.bytedance.sdk.openadsdk.core.ugeno.component.g.dl(jSONObjectKv, -1221270899));
        this.iq.add(new com.bytedance.sdk.openadsdk.core.ugeno.component.g.dl(jSONObjectKv, -2134548432));
        return this.iq;
    }

    public void a(int i) {
        this.zw = i;
        if (i < 0) {
            return;
        }
        final String str = String.format("浏览%d秒可领金币", Integer.valueOf(i));
        if (this.e instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.g.m) {
            q.m().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.fo.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.e != null) {
                        try {
                            RecyclerView recyclerView = (RecyclerView) ((com.bytedance.sdk.openadsdk.core.ugeno.component.g.m) a.this.e).z();
                            if (recyclerView.getScrollState() != 0 || recyclerView.v()) {
                                return;
                            }
                            ((com.bytedance.sdk.openadsdk.core.ugeno.component.g.m) a.this.e).z(0, "header");
                        } catch (Exception unused) {
                        }
                    }
                }
            });
            ((com.bytedance.sdk.openadsdk.core.ugeno.component.g.m) this.e).z(new gc.a() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.fo.a.2
                @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.g.gc.a
                public void z(RecyclerView.zw zwVar, int i2) {
                    com.bytedance.adsdk.ugeno.g.dl dlVarA = ((gc.C0196gc) zwVar).hh().a("count_down");
                    if (dlVarA instanceof com.bytedance.adsdk.ugeno.widget.text.g) {
                        ((com.bytedance.adsdk.ugeno.widget.text.g) dlVarA).kb(str);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.e.a
    public void a(com.bytedance.adsdk.ugeno.g.dl<View> dlVar) {
        z(dlVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.e.a
    public void z(int i, int i2) {
        if (i2 > 0) {
            this.uy.set(1);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.e.a
    public void z(com.bytedance.adsdk.ugeno.g.dl dlVar, int i, View view, com.bytedance.sdk.openadsdk.core.ugeno.component.g.dl dlVar2) {
        if (dlVar2 == null || dlVar2.z() == null) {
            return;
        }
        int iHashCode = dlVar2.z().hashCode();
        if (this.kb.get(Integer.valueOf(iHashCode)) != null && this.kb.containsKey(Integer.valueOf(iHashCode)) && this.kb.get(Integer.valueOf(iHashCode)).booleanValue()) {
            return;
        }
        z(dlVar2.z());
        this.kb.put(Integer.valueOf(iHashCode), Boolean.TRUE);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.e.a
    public void gc(com.bytedance.adsdk.ugeno.g.dl<View> dlVar) {
        if (dlVar == null) {
            return;
        }
        if (this.zw <= 0 && !this.io && TextUtils.equals(dlVar.x(), "header")) {
            a(0);
            this.io = true;
        }
        JSONObject jSONObjectUy = dlVar.uy();
        if (jSONObjectUy == null) {
            return;
        }
        com.bytedance.adsdk.ugeno.dl dlVarA = dlVar.a("video_".concat(String.valueOf(jSONObjectUy.optInt("image_mode"))));
        if (dlVarA instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.video.g) {
            com.bytedance.sdk.openadsdk.core.ugeno.component.video.g gVar = (com.bytedance.sdk.openadsdk.core.ugeno.component.video.g) dlVarA;
            gVar.z(this.i);
            gVar.jq();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.e.a
    public void m(com.bytedance.adsdk.ugeno.g.dl<View> dlVar) {
        JSONObject jSONObjectUy;
        if (dlVar == null || (jSONObjectUy = dlVar.uy()) == null) {
            return;
        }
        com.bytedance.adsdk.ugeno.dl dlVarA = dlVar.a("video_".concat(String.valueOf(jSONObjectUy.optInt("image_mode"))));
        if (dlVarA instanceof com.bytedance.sdk.openadsdk.core.ugeno.component.video.g) {
            ((com.bytedance.sdk.openadsdk.core.ugeno.component.video.g) dlVarA).yx();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.ugeno.e.dl
    public void dl(com.bytedance.adsdk.ugeno.g.dl dlVar) {
        na naVarZ;
        if (dlVar == null || (naVarZ = com.bytedance.sdk.openadsdk.core.z.z(dlVar.uy())) == null) {
            return;
        }
        z(naVarZ, dlVar);
    }
}
