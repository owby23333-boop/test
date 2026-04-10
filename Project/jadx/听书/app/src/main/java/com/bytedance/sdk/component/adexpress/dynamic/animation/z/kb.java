package com.bytedance.sdk.component.adexpress.dynamic.animation.z;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class kb extends a {
    public kb(View view, com.bytedance.sdk.component.adexpress.dynamic.dl.z zVar) {
        super(view, zVar);
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.setClipChildren(false);
            viewGroup.setClipToPadding(false);
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
            if (viewGroup2 == null || !(viewGroup2 instanceof DynamicBaseWidget)) {
                return;
            }
            viewGroup2.setClipChildren(false);
            viewGroup2.setClipToPadding(false);
            ViewGroup viewGroup3 = (ViewGroup) viewGroup2.getParent();
            if (viewGroup3 == null || !(viewGroup3 instanceof DynamicBaseWidget)) {
                return;
            }
            viewGroup3.setClipChildren(false);
            viewGroup3.setClipToPadding(false);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.z.a
    List<ObjectAnimator> z() {
        float f;
        float fKb = (float) this.g.kb();
        float fWp = (float) this.g.wp();
        String strLs = this.g.ls();
        float f2 = 1.0f;
        if ("reverse".equals(strLs) || "alternate-reverse".equals(strLs)) {
            f = 1.0f;
        } else {
            f = fWp;
            fWp = 1.0f;
            f2 = fKb;
            fKb = 1.0f;
        }
        this.dl.setTag(2097610710, this.g.g());
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.dl, "scaleX", fKb, f2).setDuration((int) (this.g.uy() * 1000.0d));
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.dl, "scaleY", fWp, f).setDuration((int) (this.g.uy() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(z(duration));
        arrayList.add(z(duration2));
        return arrayList;
    }
}
