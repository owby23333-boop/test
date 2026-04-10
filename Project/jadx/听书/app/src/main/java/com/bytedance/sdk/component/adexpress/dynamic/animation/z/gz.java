package com.bytedance.sdk.component.adexpress.dynamic.animation.z;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class gz extends a {
    public gz(View view, com.bytedance.sdk.component.adexpress.dynamic.dl.z zVar) {
        super(view, zVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.z.a
    List<ObjectAnimator> z() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.dl, "rippleValue", 0.0f, 1.0f).setDuration((int) (this.g.uy() * 1000.0d));
        ((ViewGroup) this.dl.getParent()).setClipChildren(false);
        ((ViewGroup) this.dl.getParent().getParent()).setClipChildren(false);
        ((ViewGroup) this.dl.getParent().getParent().getParent()).setClipChildren(false);
        this.dl.setTag(2097610712, this.g.gz());
        ArrayList arrayList = new ArrayList();
        arrayList.add(z(duration));
        return arrayList;
    }
}
