package com.bytedance.sdk.openadsdk.core.component.reward.draw;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class z extends RecyclerView.z<gc> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f948a;
    private final float dl;
    private final List<g> g = new ArrayList();
    private final List<gc> gc = new ArrayList();
    private final Context z;

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.z
    public long g(int i) {
        return i;
    }

    public z(Context context, float f, float f2) {
        this.z = context;
        this.dl = f;
        this.f948a = f2;
    }

    public void z(List<g> list) {
        this.g.clear();
        this.g.addAll(list);
        dl();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.z
    public void z(gc gcVar) {
        super.z(gcVar);
        gcVar.un();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.z
    /* JADX INFO: renamed from: dl, reason: merged with bridge method [inline-methods] */
    public gc z(ViewGroup viewGroup, int i) {
        gc gcVar = new gc(com.bytedance.sdk.openadsdk.res.gc.wp(this.z));
        this.gc.add(gcVar);
        return gcVar;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.z
    public void z(gc gcVar, int i) {
        List<g> list = this.g;
        gcVar.z(list.get(i % list.size()), (int) this.dl, (int) this.f948a);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.z
    public int z() {
        return this.g.size();
    }

    public void a() {
        Iterator<gc> it = this.gc.iterator();
        while (it.hasNext()) {
            it.next().un();
        }
        this.gc.clear();
    }
}
