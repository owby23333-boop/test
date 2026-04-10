package com.bytedance.sdk.component.adexpress.dynamic.animation.e;

import android.animation.ObjectAnimator;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class w extends tg {
    public w(View view, com.bytedance.sdk.component.adexpress.dynamic.d.e eVar) {
        super(view, eVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.e.tg
    public List<ObjectAnimator> e() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.d, "translationX", 0.0f, com.bytedance.sdk.component.adexpress.d.bf.e(com.bytedance.sdk.component.adexpress.tg.getContext(), 20.0f), 0.0f, -com.bytedance.sdk.component.adexpress.d.bf.e(com.bytedance.sdk.component.adexpress.tg.getContext(), 20.0f), 0.0f).setDuration((int) (this.bf.m() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(e(duration));
        return arrayList;
    }
}
