package com.bytedance.sdk.component.adexpress.dynamic.animation.z;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class z extends a {
    public z(View view, com.bytedance.sdk.component.adexpress.dynamic.dl.z zVar) {
        super(view, zVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.z.a
    List<ObjectAnimator> z() {
        float fFv = this.g.fv() / 100.0f;
        float fJs = this.g.js() / 100.0f;
        if ("reverse".equals(this.g.ls()) && this.g.v() <= 0.0d) {
            fJs = fFv;
            fFv = fJs;
        }
        this.dl.setAlpha(fFv);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.dl, "alpha", fFv, fJs).setDuration((int) (this.g.uy() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(z(duration));
        return arrayList;
    }
}
