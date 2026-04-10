package com.bytedance.sdk.component.adexpress.dynamic.animation.z;

import android.animation.ObjectAnimator;
import android.view.View;
import androidx.constraintlayout.motion.widget.Key;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class v extends a {
    public v(View view, com.bytedance.sdk.component.adexpress.dynamic.dl.z zVar) {
        super(view, zVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.z.a
    List<ObjectAnimator> z() {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.dl, Key.ROTATION, 0.0f, this.g.gc(), 0.0f, this.g.gc(), 0.0f).setDuration((int) (this.g.uy() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(z(duration));
        return arrayList;
    }
}
