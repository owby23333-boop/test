package com.bytedance.sdk.component.adexpress.dynamic.animation.e;

import android.animation.ObjectAnimator;
import android.view.View;
import com.yuewen.w51;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class e extends tg {
    public e(View view, com.bytedance.sdk.component.adexpress.dynamic.d.e eVar) {
        super(view, eVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.e.tg
    public List<ObjectAnimator> e() {
        float f = this.bf.f() / 100.0f;
        float fK = this.bf.k() / 100.0f;
        if ("reverse".equals(this.bf.w()) && this.bf.t() <= w51.l) {
            fK = f;
            f = fK;
        }
        this.d.setAlpha(f);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.d, "alpha", f, fK).setDuration((int) (this.bf.m() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(e(duration));
        return arrayList;
    }
}
