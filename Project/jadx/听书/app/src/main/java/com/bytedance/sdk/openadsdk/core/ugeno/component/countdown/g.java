package com.bytedance.sdk.openadsdk.core.ugeno.component.countdown;

import android.content.Context;
import android.graphics.Bitmap;
import com.bytedance.adsdk.ugeno.z;

/* JADX INFO: loaded from: classes2.dex */
public class g extends com.bytedance.adsdk.ugeno.g.dl<CycleCountDownView> {
    private String k;
    private String wo;
    private String wx;
    private String z;

    public g(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public CycleCountDownView z() {
        return new CycleCountDownView(this.g);
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    public void g() {
        super.g();
    }

    @Override // com.bytedance.adsdk.ugeno.g.dl
    public void z(String str, String str2) {
        super.z(str, str2);
        str.hashCode();
        switch (str) {
            case "boxImage":
                ((CycleCountDownView) this.gc).setBoxImage(null);
                com.bytedance.adsdk.ugeno.a.z().g().z(this.fo, str2, new z.InterfaceC0053z() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.g.1
                    @Override // com.bytedance.adsdk.ugeno.z.InterfaceC0053z
                    public void z(Bitmap bitmap) {
                        ((CycleCountDownView) g.this.gc).setBoxImage(bitmap);
                    }
                });
                break;
            case "before":
                this.z = str2;
                break;
            case "finish":
                this.wx = str2;
                break;
            case "text":
                this.k = str2;
                break;
            case "after":
                this.wo = str2;
                break;
            case "boxFinishImage":
                com.bytedance.adsdk.ugeno.a.z().g().z(this.fo, str2, new z.InterfaceC0053z() { // from class: com.bytedance.sdk.openadsdk.core.ugeno.component.countdown.g.2
                    @Override // com.bytedance.adsdk.ugeno.z.InterfaceC0053z
                    public void z(Bitmap bitmap) {
                        ((CycleCountDownView) g.this.gc).setBoxFinish(bitmap);
                    }
                });
                break;
        }
        ((CycleCountDownView) this.gc).z(this.z, this.wo, this.k, this.wx);
    }

    public void z(int i, int i2, int i3, boolean z) {
        if (this.gc != 0) {
            ((CycleCountDownView) this.gc).z(i, i2, i3);
            ((CycleCountDownView) this.gc).setCanSkip(z);
            ((CycleCountDownView) this.gc).setClickable(z);
            ((CycleCountDownView) this.gc).setEnabled(z);
        }
    }
}
