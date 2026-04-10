package com.bytedance.msdk.dl.z.z;

import android.app.Activity;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.component.utils.wp;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public abstract class gz extends dl {
    private boolean i;
    private int kb;
    private int wp;

    public abstract void z(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.msdk.api.a.z.e.uy uyVar);

    public gz(com.bytedance.msdk.dl.dl.g.z.z.g gVar, Function<SparseArray<Object>, Object> function) {
        super(gVar, function);
        this.kb = 0;
        this.wp = 0;
        this.i = false;
    }

    public final void z(z zVar) {
        int i = this.wp;
        if (i < 60) {
            this.wp = i + 1;
            if (zVar != null) {
                zVar.z();
                return;
            }
            return;
        }
        com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", "自定义Adapter click方法回调次数需要小于60次");
    }

    public final void g(z zVar) {
        if (this.i) {
            int i = this.kb;
            if (i < 2) {
                this.kb = i + 1;
                if (zVar != null) {
                    zVar.z();
                    return;
                }
                return;
            }
            com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", "自定义Adapter show方法回调次数需要小于2次");
            return;
        }
        com.bytedance.msdk.z.gc.dl.a("TTMediationSDK", "自定义Adapter show方法回调必须由GroMore触发show时才会生效");
    }

    @Override // com.bytedance.msdk.g.dl
    public void z(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.msdk.api.a.z.e.uy uyVar, List<View> list4) {
        super.z(activity, viewGroup, list, list2, list3, uyVar, list4);
        try {
            this.i = true;
            z(activity, viewGroup, list, list2, list3, uyVar);
        } catch (Exception e) {
            wp.z(e);
        }
    }

    @Override // com.bytedance.msdk.g.dl
    public void kb() {
        try {
            this.i = true;
            if (this.uy != null) {
                this.uy.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(6083).z(Void.class).g());
            }
        } catch (Exception e) {
            wp.z(e);
        }
    }
}
