package com.bytedance.sdk.component.adexpress.dynamic.animation.z;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class e extends a {
    public e(View view, com.bytedance.sdk.component.adexpress.dynamic.dl.z zVar) {
        super(view, zVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.z.a
    List<ObjectAnimator> z() {
        this.dl.setTag(2097610709, Integer.valueOf(this.g.dl()));
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.dl, "marqueeValue", 0.0f, 1.0f).setDuration((int) (this.g.uy() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(z(duration));
        return arrayList;
    }
}
