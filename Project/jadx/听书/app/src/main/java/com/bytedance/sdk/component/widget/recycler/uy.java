package com.bytedance.sdk.component.widget.recycler;

import android.view.View;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;

/* JADX INFO: loaded from: classes2.dex */
class uy {
    static int z(RecyclerView.tb tbVar, gz gzVar, View view, View view2, RecyclerView.fo foVar, boolean z, boolean z2) {
        if (foVar.js() == 0 || tbVar.a() == 0 || view == null || view2 == null) {
            return 0;
        }
        int iMax = z2 ? Math.max(0, (tbVar.a() - Math.max(foVar.a(view), foVar.a(view2))) - 1) : Math.max(0, Math.min(foVar.a(view), foVar.a(view2)));
        if (z) {
            return Math.round((iMax * (Math.abs(gzVar.g(view2) - gzVar.z(view)) / (Math.abs(foVar.a(view) - foVar.a(view2)) + 1))) + (gzVar.dl() - gzVar.z(view)));
        }
        return iMax;
    }

    static int z(RecyclerView.tb tbVar, gz gzVar, View view, View view2, RecyclerView.fo foVar, boolean z) {
        if (foVar.js() == 0 || tbVar.a() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(foVar.a(view) - foVar.a(view2)) + 1;
        }
        return Math.min(gzVar.m(), gzVar.g(view2) - gzVar.z(view));
    }

    static int g(RecyclerView.tb tbVar, gz gzVar, View view, View view2, RecyclerView.fo foVar, boolean z) {
        if (foVar.js() == 0 || tbVar.a() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return tbVar.a();
        }
        return (int) (((gzVar.g(view2) - gzVar.z(view)) / (Math.abs(foVar.a(view) - foVar.a(view2)) + 1)) * tbVar.a());
    }
}
