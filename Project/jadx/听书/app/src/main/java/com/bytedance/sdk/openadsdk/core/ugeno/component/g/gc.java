package com.bytedance.sdk.openadsdk.core.ugeno.component.g;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.dl.fo;
import com.bytedance.adsdk.ugeno.dl.fv;
import com.bytedance.adsdk.ugeno.dl.pf;
import com.bytedance.adsdk.ugeno.dl.tb;
import com.bytedance.adsdk.ugeno.dl.uy;
import com.bytedance.adsdk.ugeno.g.z;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class gc extends RecyclerView.z<RecyclerView.zw> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.ugeno.component.g.a f1330a;
    private Context dl;
    private a e;
    private uy fo;
    private Map<Integer, fo.z> g;
    private dl gc;
    private boolean gz = true;
    private tb kb;
    private Object m;
    private fv uy;
    private List<com.bytedance.sdk.openadsdk.core.ugeno.component.g.dl> z;

    public interface a {
        void z(RecyclerView.zw zwVar, int i);
    }

    public interface dl {
    }

    public interface z {
        void J_();

        void K_();

        View dl();
    }

    public gc(Context context) {
        this.dl = context;
    }

    public void z(Map<Integer, fo.z> map) {
        this.g = map;
    }

    public void z(List<com.bytedance.sdk.openadsdk.core.ugeno.component.g.dl> list) {
        if (this.z == null) {
            this.z = new ArrayList();
        }
        this.z.addAll(list);
    }

    public void z(com.bytedance.sdk.openadsdk.core.ugeno.component.g.a aVar) {
        this.f1330a = aVar;
    }

    public void z(uy uyVar) {
        this.fo = uyVar;
    }

    public void z(fv fvVar) {
        this.uy = fvVar;
    }

    public void z(tb tbVar) {
        this.kb = tbVar;
    }

    public void z(dl dlVar) {
        this.gc = dlVar;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.z
    public RecyclerView.zw z(ViewGroup viewGroup, int i) {
        fo.z zVar = this.g.get(Integer.valueOf(i));
        pf pfVar = new pf(this.dl);
        com.bytedance.adsdk.ugeno.g.dl<View> dlVarZ = pfVar.z(zVar);
        pfVar.z(dlVarZ);
        if (dlVarZ != null) {
            dlVarZ.z(new ViewGroup.LayoutParams(dlVarZ.mc(), dlVarZ.un()));
            C0196gc c0196gc = new C0196gc(dlVarZ.fo());
            c0196gc.z((com.bytedance.adsdk.ugeno.g.dl) dlVarZ);
            c0196gc.z(pfVar);
            return c0196gc;
        }
        return new g(new View(this.dl));
    }

    public void z(a aVar) {
        this.e = aVar;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.z
    public int z(int i) {
        return this.z.get(i).g();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.z
    public void z(RecyclerView.zw zwVar, int i, List<Object> list) {
        a aVar;
        if (list == null || list.isEmpty()) {
            z(zwVar, i);
            return;
        }
        for (Object obj : list) {
            if (obj != null && this.m != null && TextUtils.equals(obj.toString(), this.m.toString()) && (aVar = this.e) != null) {
                aVar.z(zwVar, i);
            }
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.z
    public void z(RecyclerView.zw zwVar, int i) {
        com.bytedance.sdk.openadsdk.core.ugeno.component.g.dl dlVar;
        com.bytedance.sdk.openadsdk.core.ugeno.component.g.a aVar;
        if (zwVar == null || (dlVar = this.z.get(i)) == null || !(zwVar instanceof C0196gc)) {
            return;
        }
        JSONObject jSONObjectZ = dlVar.z();
        C0196gc c0196gc = (C0196gc) zwVar;
        c0196gc.p.z(new ViewGroup.LayoutParams(c0196gc.p.mc(), c0196gc.p.un()));
        z(jSONObjectZ, c0196gc.hh());
        z(this.dl, jSONObjectZ, c0196gc.hh());
        if (i == 0 && (aVar = this.f1330a) != null && this.gz) {
            this.gz = false;
            aVar.z(c0196gc.p);
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.z
    public int z() {
        return this.z.size();
    }

    public void z(Object obj) {
        this.m = obj;
    }

    public class g extends RecyclerView.zw {
        public g(View view) {
            super(view);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.ugeno.component.g.gc$gc, reason: collision with other inner class name */
    public class C0196gc extends RecyclerView.zw implements z {
        pf fv;
        com.bytedance.adsdk.ugeno.g.dl p;

        C0196gc(View view) {
            super(view);
        }

        public void z(com.bytedance.adsdk.ugeno.g.dl dlVar) {
            this.p = dlVar;
        }

        public void z(pf pfVar) {
            this.fv = pfVar;
        }

        public com.bytedance.adsdk.ugeno.g.dl hh() {
            return this.p;
        }

        @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.g.gc.z
        public void J_() {
            if (gc.this.f1330a != null) {
                gc.this.f1330a.g(this.p);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.g.gc.z
        public void K_() {
            if (gc.this.f1330a != null) {
                gc.this.f1330a.z(this.p);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.core.ugeno.component.g.gc.z
        public View dl() {
            return this.p.fo();
        }
    }

    public void z(JSONObject jSONObject, com.bytedance.adsdk.ugeno.g.dl dlVar) {
        if (dlVar == null) {
            return;
        }
        if (dlVar instanceof com.bytedance.adsdk.ugeno.g.z) {
            dlVar.z(jSONObject);
            List<com.bytedance.adsdk.ugeno.g.dl<View>> listE = ((com.bytedance.adsdk.ugeno.g.z) dlVar).e();
            if (listE == null || listE.size() <= 0) {
                return;
            }
            Iterator<com.bytedance.adsdk.ugeno.g.dl<View>> it = listE.iterator();
            while (it.hasNext()) {
                z(jSONObject, it.next());
            }
            return;
        }
        dlVar.z(jSONObject);
    }

    public void z(Context context, JSONObject jSONObject, com.bytedance.adsdk.ugeno.g.dl dlVar) {
        if (dlVar == null) {
            return;
        }
        if (dlVar instanceof com.bytedance.adsdk.ugeno.g.z) {
            dlVar.z(this.fo);
            dlVar.z(this.uy);
            dlVar.g(true);
            dlVar.g();
            List<com.bytedance.adsdk.ugeno.g.dl<View>> listE = ((com.bytedance.adsdk.ugeno.g.z) dlVar).e();
            if (listE == null || listE.size() <= 0) {
                return;
            }
            Iterator<com.bytedance.adsdk.ugeno.g.dl<View>> it = listE.iterator();
            while (it.hasNext()) {
                z(context, jSONObject, it.next());
            }
            return;
        }
        JSONObject jSONObjectIo = dlVar.io();
        Iterator<String> itKeys = jSONObjectIo.keys();
        com.bytedance.adsdk.ugeno.g.z zVarGk = dlVar.gk();
        z.C0045z c0045zGz = zVarGk != null ? zVarGk.gz() : null;
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strZ = com.bytedance.adsdk.ugeno.a.g.z(jSONObjectIo.optString(next), jSONObject);
            dlVar.z(next, strZ);
            dlVar.z(this.fo);
            dlVar.z(this.uy);
            if (c0045zGz != null) {
                c0045zGz.z(context, next, strZ);
            }
        }
        dlVar.g(true);
        dlVar.g();
    }
}
