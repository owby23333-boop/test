package com.bytedance.sdk.component.adexpress.dynamic.animation.e;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class vn extends tg {
    public vn(View view, com.bytedance.sdk.component.adexpress.dynamic.d.e eVar) {
        super(view, eVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.e.tg
    public List<ObjectAnimator> e() {
        float f = this.d.getLayoutParams().width;
        this.d.setTranslationX(f);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.d, "translationX", f, 0.0f).setDuration((int) (this.bf.m() * 1000.0d));
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.d, "alpha", 0.0f, 1.0f).setDuration((int) (this.bf.m() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(e(duration));
        arrayList.add(e(duration2));
        return arrayList;
    }
}
