package com.bytedance.sdk.component.adexpress.dynamic.animation.z;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class pf extends a {
    public pf(View view, com.bytedance.sdk.component.adexpress.dynamic.dl.z zVar) {
        super(view, zVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.z.a
    List<ObjectAnimator> z() {
        float f;
        float fZ = com.bytedance.sdk.component.adexpress.a.gz.z(com.bytedance.sdk.component.adexpress.a.getContext(), this.g.m());
        float fZ2 = com.bytedance.sdk.component.adexpress.a.gz.z(com.bytedance.sdk.component.adexpress.a.getContext(), this.g.e());
        float f2 = 0.0f;
        if ("reverse".equals(this.g.ls())) {
            f = fZ2;
            fZ2 = 0.0f;
            f2 = fZ;
            fZ = 0.0f;
        } else {
            f = 0.0f;
        }
        if (com.bytedance.sdk.component.adexpress.a.dl.z(this.dl.getContext())) {
            fZ = -fZ;
            f2 = -f2;
        }
        this.dl.setTranslationX(fZ);
        this.dl.setTranslationY(fZ2);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.dl, "translationX", fZ, f2).setDuration((int) (this.g.uy() * 1000.0d));
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.dl, "translationY", fZ2, f).setDuration((int) (this.g.uy() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(z(duration));
        arrayList.add(z(duration2));
        return arrayList;
    }
}
