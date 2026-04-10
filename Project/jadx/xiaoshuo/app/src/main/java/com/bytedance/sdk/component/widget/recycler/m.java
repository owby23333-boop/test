package com.bytedance.sdk.component.widget.recycler;

import android.view.View;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
class m {
    public static int bf(RecyclerView.dt dtVar, v vVar, View view, View view2, RecyclerView.zk zkVar, boolean z) {
        if (zkVar.pe() == 0 || dtVar.tg() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return dtVar.tg();
        }
        return (int) (((vVar.bf(view2) - vVar.e(view)) / (Math.abs(zkVar.tg(view) - zkVar.tg(view2)) + 1)) * dtVar.tg());
    }

    public static int e(RecyclerView.dt dtVar, v vVar, View view, View view2, RecyclerView.zk zkVar, boolean z, boolean z2) {
        if (zkVar.pe() == 0 || dtVar.tg() == 0 || view == null || view2 == null) {
            return 0;
        }
        int iMax = z2 ? Math.max(0, (dtVar.tg() - Math.max(zkVar.tg(view), zkVar.tg(view2))) - 1) : Math.max(0, Math.min(zkVar.tg(view), zkVar.tg(view2)));
        if (z) {
            return Math.round((iMax * (Math.abs(vVar.bf(view2) - vVar.e(view)) / (Math.abs(zkVar.tg(view) - zkVar.tg(view2)) + 1))) + (vVar.d() - vVar.e(view)));
        }
        return iMax;
    }

    public static int e(RecyclerView.dt dtVar, v vVar, View view, View view2, RecyclerView.zk zkVar, boolean z) {
        if (zkVar.pe() == 0 || dtVar.tg() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(zkVar.tg(view) - zkVar.tg(view2)) + 1;
        }
        return Math.min(vVar.vn(), vVar.bf(view2) - vVar.e(view));
    }
}
