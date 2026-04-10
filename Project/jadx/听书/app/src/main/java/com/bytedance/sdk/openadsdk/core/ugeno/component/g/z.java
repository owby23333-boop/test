package com.bytedance.sdk.openadsdk.core.ugeno.component.g;

import android.graphics.Rect;
import android.view.View;
import com.bytedance.adsdk.ugeno.m.gz;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.openadsdk.core.ugeno.component.g.gc;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    public static int g = 1;
    public static int z;
    private gc.z dl;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1331a = 60;
    private int gc = g;

    public int z(RecyclerView recyclerView) {
        gc.z zVar;
        View viewDl;
        gc.z zVar2 = null;
        com.bytedance.sdk.component.widget.recycler.gc gcVar = recyclerView.getLayoutManager() instanceof com.bytedance.sdk.component.widget.recycler.gc ? (com.bytedance.sdk.component.widget.recycler.gc) recyclerView.getLayoutManager() : null;
        if (gcVar != null) {
            int iKb = gcVar.kb();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (int iUy = gcVar.uy(); iUy <= iKb; iUy++) {
                Object objDl = recyclerView.dl(iUy);
                if ((objDl instanceof gc.z) && (viewDl = (zVar = (gc.z) objDl).dl()) != null && z(viewDl, this.f1331a)) {
                    if (this.gc == z) {
                        zVar.K_();
                        this.dl = zVar;
                        return iUy;
                    }
                    linkedHashMap.put(Integer.valueOf(iUy), zVar);
                }
            }
            int i = Integer.MAX_VALUE;
            int iIntValue = -1;
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                int iG = g(((gc.z) entry.getValue()).dl());
                if (iG < i) {
                    gc.z zVar3 = (gc.z) entry.getValue();
                    iIntValue = ((Integer) entry.getKey()).intValue();
                    zVar2 = zVar3;
                    i = iG;
                }
            }
            gc.z zVar4 = this.dl;
            if (zVar4 != zVar2) {
                if (zVar4 != null) {
                    zVar4.J_();
                }
                this.dl = zVar2;
            }
            gc.z zVar5 = this.dl;
            if (zVar5 != null) {
                zVar5.K_();
                return iIntValue;
            }
        }
        return -1;
    }

    public void z() {
        gc.z zVar = this.dl;
        if (zVar == null || zVar.dl() == null || z(this.dl.dl(), this.f1331a)) {
            return;
        }
        this.dl.J_();
    }

    private int z(View view) {
        Rect rect = new Rect();
        if (!view.getLocalVisibleRect(rect) || view.getMeasuredHeight() <= 0) {
            return -1;
        }
        return (rect.height() * 100) / view.getMeasuredHeight();
    }

    private boolean z(View view, int i) {
        return view.getLocalVisibleRect(new Rect()) && view.getVisibility() == 0 && z(view) >= i;
    }

    private int g(View view) {
        int iZ = (int) (((double) gz.z(view.getContext())) / 2.3d);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return Math.abs((iArr[1] + (view.getHeight() / 2)) - iZ);
    }
}
