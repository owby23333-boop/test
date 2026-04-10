package com.bytedance.sdk.component.adexpress.dynamic.animation.z;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class m extends a {
    public m(View view, com.bytedance.sdk.component.adexpress.dynamic.dl.z zVar) {
        super(view, zVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.z.a
    List<ObjectAnimator> z() {
        float f = this.dl.getLayoutParams().width;
        this.dl.setTranslationX(f);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.dl, "translationX", f, 0.0f).setDuration((int) (this.g.uy() * 1000.0d));
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.dl, "alpha", 0.0f, 1.0f).setDuration((int) (this.g.uy() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(z(duration));
        arrayList.add(z(duration2));
        return arrayList;
    }
}
