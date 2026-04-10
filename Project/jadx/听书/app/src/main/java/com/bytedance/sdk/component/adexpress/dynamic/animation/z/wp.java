package com.bytedance.sdk.component.adexpress.dynamic.animation.z;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class wp extends a {
    public wp(View view, com.bytedance.sdk.component.adexpress.dynamic.dl.z zVar) {
        super(view, zVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.z.a
    List<ObjectAnimator> z() {
        int i;
        int i2;
        this.dl.setTag(2097610711, Integer.valueOf(this.g.a()));
        if (this.dl == null || !com.bytedance.sdk.component.adexpress.a.dl.z(this.dl.getContext())) {
            i = 0;
            i2 = 1;
        } else {
            i2 = 0;
            i = 1;
        }
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.dl, "shineValue", i, i2).setDuration((int) (this.g.uy() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(z(duration));
        return arrayList;
    }
}
