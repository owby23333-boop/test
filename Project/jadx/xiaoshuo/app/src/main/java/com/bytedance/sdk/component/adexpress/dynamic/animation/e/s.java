package com.bytedance.sdk.component.adexpress.dynamic.animation.e;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class s extends tg {
    public s(View view, com.bytedance.sdk.component.adexpress.dynamic.d.e eVar) {
        super(view, eVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.e.tg
    public List<ObjectAnimator> e() {
        float f;
        float fE = com.bytedance.sdk.component.adexpress.d.bf.e(com.bytedance.sdk.component.adexpress.tg.getContext(), this.bf.vn());
        float fE2 = com.bytedance.sdk.component.adexpress.d.bf.e(com.bytedance.sdk.component.adexpress.tg.getContext(), this.bf.p());
        float f2 = 0.0f;
        if ("reverse".equals(this.bf.w())) {
            f = fE2;
            fE2 = 0.0f;
            f2 = fE;
            fE = 0.0f;
        } else {
            f = 0.0f;
        }
        this.d.setTranslationX(fE);
        this.d.setTranslationY(fE2);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.d, "translationX", fE, f2).setDuration((int) (this.bf.m() * 1000.0d));
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.d, "translationY", fE2, f).setDuration((int) (this.bf.m() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(e(duration));
        arrayList.add(e(duration2));
        return arrayList;
    }
}
