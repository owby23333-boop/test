package com.bytedance.sdk.openadsdk.core.ugeno.component.g;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.dl.fo;
import com.bytedance.adsdk.ugeno.g.z;
import com.bytedance.adsdk.ugeno.m.gz;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.openadsdk.core.ugeno.component.g.gc;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class m extends com.bytedance.adsdk.ugeno.g.z<RecyclerView> {
    private g cb;
    private gc.dl dt;
    private Map<Integer, fo.z> k;
    private gc o;
    private RecyclerView.fo wo;
    private List<dl> wx;
    private a yt;

    /* JADX INFO: loaded from: classes2.dex */
    public interface g {
        void z();

        void z(int i, int i2);

        void z(int i, View view, dl dlVar);

        void z(RecyclerView recyclerView, int i);
    }

    @Override // com.bytedance.adsdk.ugeno.g.z
    public z.C0045z gz() {
        return null;
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    public void z(ViewGroup.LayoutParams layoutParams) {
    }

    public m(Context context) {
        super(context);
        this.k = new HashMap();
    }

    public void z(a aVar) {
        this.yt = aVar;
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    public View z() {
        return new RecyclerView(this.g);
    }

    @Override // com.bytedance.adsdk.ugeno.g.z, com.bytedance.adsdk.ugeno.g.dl
    public void g() {
        super.g();
        gc gcVar = new gc(this.g);
        this.o = gcVar;
        gcVar.z(this.lk);
        this.o.z(this.u);
        this.o.z(this.sf);
        this.o.z(this.yt);
        this.o.z(this.dt);
        this.o.z(this.k);
        this.o.z(this.wx);
        ((RecyclerView) this.gc).setLayoutManager(this.wo);
        ((RecyclerView) this.gc).setAdapter(this.o);
        ((RecyclerView) this.gc).z((RecyclerView.gz) new z((int) gz.z(this.g, 10.0f)));
        ((RecyclerView) this.gc).z((RecyclerView.v) new com.bytedance.sdk.openadsdk.core.ugeno.component.g.g(new com.bytedance.sdk.openadsdk.core.ugeno.component.g.z()) { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.g.m.1
            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.g.g
            public void z(int i, int i2) {
                if (m.this.cb != null) {
                    m.this.cb.z(i, i2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.g.g
            public void z(int i, View view) {
                if (m.this.cb == null || i < 0 || m.this.wx == null || i >= m.this.wx.size()) {
                    return;
                }
                m.this.cb.z(i, view, (dl) m.this.wx.get(i));
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.g.g
            public void g(RecyclerView recyclerView, int i) {
                if (m.this.cb != null) {
                    m.this.cb.z(recyclerView, i);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.g.g
            public void z() {
                if (m.this.cb != null) {
                    m.this.cb.z();
                }
            }
        });
    }

    public void z(g gVar) {
        this.cb = gVar;
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    public void z(JSONObject jSONObject) {
        super.z(jSONObject);
    }

    public void z(List<dl> list) {
        this.wx = list;
    }

    public void g(List<dl> list) {
        if (this.o == null || list == null || list.isEmpty()) {
            return;
        }
        if (this.wx == null) {
            this.wx = new ArrayList();
        }
        int size = this.wx.size();
        this.wx.addAll(list);
        this.o.z(list);
        this.o.z(size, this.wx.size());
    }

    public void z(int i, Object obj) {
        gc gcVar = this.o;
        if (gcVar != null) {
            gcVar.z(obj);
            this.o.z(i, obj);
        }
    }

    public void z(gc.a aVar) {
        this.o.z(aVar);
    }

    @Override // com.bytedance.adsdk.ugeno.g.z
    public void z(com.bytedance.adsdk.ugeno.g.dl dlVar) {
        if (dlVar == null) {
            return;
        }
        this.z.add(dlVar);
        if (dlVar.x() != null) {
            this.k.put(Integer.valueOf(dlVar.x().hashCode()), dlVar.l());
        }
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    public void z(String str, String str2) {
        super.z(str, str2);
        str.hashCode();
        if (str.equals("layoutType") && !TextUtils.equals("grid", str2)) {
            this.wo = new com.bytedance.sdk.component.widget.recycler.gc(this.g);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.g.z
    public void z(com.bytedance.adsdk.ugeno.g.dl dlVar, ViewGroup.LayoutParams layoutParams) {
        this.z.add(dlVar);
        this.k.put(Integer.valueOf(dlVar.x().hashCode()), dlVar.l());
    }

    /* JADX INFO: loaded from: classes2.dex */
    private static class z extends RecyclerView.gz implements gc.z {
        private int z;

        @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.g.gc.z
        public void J_() {
        }

        @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.g.gc.z
        public void K_() {
        }

        @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.g.gc.z
        public View dl() {
            return null;
        }

        public z(int i) {
            this.z = i;
        }

        @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.gz
        public void z(Rect rect, View view, RecyclerView recyclerView, RecyclerView.tb tbVar) {
            super.z(rect, view, recyclerView, tbVar);
            rect.left = this.z;
            rect.right = this.z;
            rect.bottom = this.z;
            if (recyclerView.m(view) == 0) {
                rect.top = this.z;
            }
        }
    }
}
