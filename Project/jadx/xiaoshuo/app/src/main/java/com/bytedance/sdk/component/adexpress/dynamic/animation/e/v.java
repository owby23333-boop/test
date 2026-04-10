package com.bytedance.sdk.component.adexpress.dynamic.animation.e;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.utils.dt;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class v extends tg {
    public v(View view, com.bytedance.sdk.component.adexpress.dynamic.d.e eVar) {
        super(view, eVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.e.tg
    @SuppressLint({"ObjectAnimatorBinding"})
    public List<ObjectAnimator> e() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.d, "rippleValue", 0.0f, 1.0f).setDuration((int) (this.bf.m() * 1000.0d));
        ((ViewGroup) this.d.getParent()).setClipChildren(false);
        ((ViewGroup) this.d.getParent().getParent()).setClipChildren(false);
        ((ViewGroup) this.d.getParent().getParent().getParent()).setClipChildren(false);
        View view = this.d;
        view.setTag(dt.ga(view.getContext(), "tt_id_ripple_bg"), this.bf.v());
        ArrayList arrayList = new ArrayList();
        arrayList.add(e(duration));
        return arrayList;
    }
}
