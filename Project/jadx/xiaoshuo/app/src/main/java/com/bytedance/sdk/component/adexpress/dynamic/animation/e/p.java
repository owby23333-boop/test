package com.bytedance.sdk.component.adexpress.dynamic.animation.e;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.view.View;
import com.bytedance.sdk.component.utils.dt;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class p extends tg {
    public p(View view, com.bytedance.sdk.component.adexpress.dynamic.d.e eVar) {
        super(view, eVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.e.tg
    @SuppressLint({"ObjectAnimatorBinding"})
    public List<ObjectAnimator> e() {
        View view = this.d;
        view.setTag(dt.ga(view.getContext(), "tt_id_width"), Integer.valueOf(this.bf.d()));
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.d, "marqueeValue", 0.0f, 1.0f).setDuration((int) (this.bf.m() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(e(duration));
        return arrayList;
    }
}
