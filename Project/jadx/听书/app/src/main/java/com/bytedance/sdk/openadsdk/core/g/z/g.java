package com.bytedance.sdk.openadsdk.core.g.z;

import android.content.Context;
import android.graphics.Point;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.zw;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class g extends z {
    public g() {
    }

    public g(na naVar, Context context) {
        this.z = naVar;
        this.g = context;
    }

    @Override // com.bytedance.sdk.openadsdk.core.g.z.z
    public int z(Map<String, Object> map, dl dlVar) {
        return !g(this.f1076a) ? 1 : 0;
    }

    public boolean g(View view) {
        if (view != null && this.z != null) {
            String strValueOf = String.valueOf(view.getTag(2097610717));
            if (view.getTag(2097610717) != null && !TextUtils.isEmpty(strValueOf)) {
                if ("click".equals(strValueOf)) {
                    return this.dl.gc();
                }
                return true;
            }
            if (z(view, this.g != null ? this.g : zw.getContext())) {
                return this.z.wj() != 1 || this.dl.gc();
            }
            if (this.z.oq() == 1 && !this.dl.gc()) {
                return false;
            }
        }
        return true;
    }

    public boolean z(View view, Context context) {
        int id = view.getId();
        List<Integer> listKb = this.dl.kb();
        if (listKb != null && listKb.size() == 0) {
            listKb.add(2114387830);
            listKb.add(2114387864);
            listKb.add(2114387633);
            listKb.add(2114387466);
            listKb.add(2114387468);
            listKb.add(2114387962);
            listKb.add(2114387625);
        }
        return listKb != null && listKb.contains(Integer.valueOf(id));
    }

    public boolean z(View view, Point point) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (z(childAt, this.g != null ? this.g : zw.getContext())) {
                    int[] iArr = new int[2];
                    childAt.getLocationOnScreen(iArr);
                    return point.x >= iArr[0] && point.x <= iArr[0] + childAt.getWidth() && point.y >= iArr[1] && point.y <= iArr[1] + childAt.getHeight();
                }
                if (z(childAt, point)) {
                    return true;
                }
            }
        }
        return false;
    }
}
