package com.bytedance.sdk.component.adexpress.dynamic.animation.z;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicImageView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class i extends a {
    public i(View view, com.bytedance.sdk.component.adexpress.dynamic.dl.z zVar) {
        super(view, zVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.z.a
    List<ObjectAnimator> z() {
        if ((this.dl instanceof ImageView) && (this.dl.getParent() instanceof DynamicImageView)) {
            this.dl = (View) this.dl.getParent();
            ((ViewGroup) this.dl).setClipChildren(true);
            ((ViewGroup) this.dl.getParent()).setClipChildren(true);
        }
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.dl, "stretchValue", 0.0f, 1.0f).setDuration((int) (this.g.uy() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(z(duration));
        return arrayList;
    }
}
