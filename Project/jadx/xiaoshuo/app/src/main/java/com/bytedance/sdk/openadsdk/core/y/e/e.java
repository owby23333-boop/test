package com.bytedance.sdk.openadsdk.core.y.e;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.sdk.component.ga.s;
import com.bytedance.sdk.component.ga.wu;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public class e {

    public interface bf {
        void e();

        void e(int i, String str, Throwable th);

        void e(wu wuVar, com.bytedance.sdk.openadsdk.core.y.e.bf bfVar);
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.y.e.e$e, reason: collision with other inner class name */
    public static class C0171e implements bf {
        @Override // com.bytedance.sdk.openadsdk.core.y.e.e.bf
        public void e() {
        }

        @Override // com.bytedance.sdk.openadsdk.core.y.e.e.bf
        public void e(int i, String str, Throwable th) {
        }

        @Override // com.bytedance.sdk.openadsdk.core.y.e.e.bf
        public void e(wu wuVar, com.bytedance.sdk.openadsdk.core.y.e.bf bfVar) {
        }
    }

    public static C0171e bf() {
        return new C0171e();
    }

    public void e() {
    }

    public void e(com.bytedance.sdk.openadsdk.xu.bf bfVar, bf bfVar2, int i, int i2, String str) {
        e(bfVar, bfVar2, i, i2, ImageView.ScaleType.CENTER_INSIDE, str);
    }

    public void e(com.bytedance.sdk.openadsdk.xu.bf bfVar, final bf bfVar2, int i, int i2, ImageView.ScaleType scaleType, String str) {
        com.bytedance.sdk.openadsdk.vn.e.e(bfVar.e).e(bfVar.bf).e(i).bf(i2).bf(str).e(Bitmap.Config.RGB_565).e(scaleType).e(!TextUtils.isEmpty(str)).e(new s() { // from class: com.bytedance.sdk.openadsdk.core.y.e.e.1
            @Override // com.bytedance.sdk.component.ga.s
            public void e(wu wuVar) {
                e.this.e(wuVar, bfVar2);
            }

            @Override // com.bytedance.sdk.component.ga.s
            public void e(int i3, String str2, Throwable th) {
                e.this.e(i3, str2, th, bfVar2);
            }
        });
        e();
    }

    public void e(wu wuVar, bf bfVar) {
        if (bfVar != null) {
            Object objE = wuVar.e();
            int iE = e(wuVar);
            if (objE instanceof byte[]) {
                bfVar.e(wuVar, new com.bytedance.sdk.openadsdk.core.y.e.bf((byte[]) objE, iE));
            } else if (objE instanceof Bitmap) {
                bfVar.e(wuVar, new com.bytedance.sdk.openadsdk.core.y.e.bf((Bitmap) objE, iE));
            } else {
                bfVar.e(0, "not bitmap or gif result!", null);
            }
        }
        if (bfVar != null) {
            bfVar.e();
        }
    }

    private int e(wu wuVar) {
        Map<String, String> mapD = wuVar.d();
        if (mapD == null) {
            return 0;
        }
        try {
            String str = mapD.get("image_size");
            if (str == null || !(str instanceof String)) {
                return 0;
            }
            return Integer.parseInt(str);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public void e(int i, String str, Throwable th, bf bfVar) {
        if (bfVar != null) {
            bfVar.e(i, str, th);
        }
    }
}
