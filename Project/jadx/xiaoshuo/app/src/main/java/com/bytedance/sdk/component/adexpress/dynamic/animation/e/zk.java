package com.bytedance.sdk.component.adexpress.dynamic.animation.e;

import android.animation.ObjectAnimator;
import android.view.View;
import androidx.constraintlayout.motion.widget.Key;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class zk extends tg {
    public zk(View view, com.bytedance.sdk.component.adexpress.dynamic.d.e eVar) {
        super(view, eVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.e.tg
    public List<ObjectAnimator> e() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.d, Key.ROTATION, 0.0f, 360.0f).setDuration((int) (this.bf.m() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(e(duration));
        return arrayList;
    }
}
