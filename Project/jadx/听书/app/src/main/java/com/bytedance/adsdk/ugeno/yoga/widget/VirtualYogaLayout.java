package com.bytedance.adsdk.ugeno.yoga.widget;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.adsdk.ugeno.yoga.e;
import com.bytedance.adsdk.ugeno.yoga.kb;
import com.bytedance.adsdk.ugeno.yoga.uy;
import com.bytedance.adsdk.ugeno.yoga.widget.YogaLayout;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class VirtualYogaLayout extends ViewGroup {
    private final uy dl;
    private final Map<View, uy> g;
    private final List<View> z;

    public uy getYogaNode() {
        return this.dl;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof VirtualYogaLayout) {
            VirtualYogaLayout virtualYogaLayout = (VirtualYogaLayout) view;
            virtualYogaLayout.z(this);
            uy yogaNode = virtualYogaLayout.getYogaNode();
            uy uyVar = this.dl;
            uyVar.z(yogaNode, uyVar.z());
            return;
        }
        uy uyVarZ = kb.z();
        YogaLayout.z(new YogaLayout.z(layoutParams), uyVarZ, view);
        uyVarZ.z(view);
        uyVarZ.z((e) new YogaLayout.g());
        uy uyVar2 = this.dl;
        uyVar2.z(uyVarZ, uyVar2.z());
        z(view, uyVarZ);
    }

    public void z(View view, uy uyVar) {
        this.z.add(view);
        this.g.put(view, uyVar);
    }

    protected void z(ViewGroup viewGroup) {
        if (viewGroup instanceof VirtualYogaLayout) {
            for (View view : this.z) {
                ((VirtualYogaLayout) viewGroup).z(view, this.g.get(view));
            }
        } else if (viewGroup instanceof YogaLayout) {
            for (View view2 : this.z) {
                ((YogaLayout) viewGroup).z(view2, this.g.get(view2));
            }
        } else {
            throw new RuntimeException("VirtualYogaLayout cannot transfer children to ViewGroup of type " + viewGroup.getClass().getCanonicalName() + ".  Must either be a VirtualYogaLayout or a YogaLayout.");
        }
        this.z.clear();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        throw new RuntimeException("Attempting to layout a VirtualYogaLayout");
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new YogaLayout.z(-1, -1);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new YogaLayout.z(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof YogaLayout.z;
    }
}
