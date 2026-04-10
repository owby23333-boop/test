package com.bytedance.sdk.openadsdk.core.io.z;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.sdk.component.m.io;
import com.bytedance.sdk.component.m.ls;
import com.bytedance.sdk.component.m.tb;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class z {

    public interface g {
        void z(int i, String str, Throwable th);

        void z(ls lsVar, com.bytedance.sdk.openadsdk.core.io.z.g gVar);
    }

    protected void z() {
    }

    public void z(com.bytedance.sdk.openadsdk.i.g gVar, g gVar2, int i, int i2, String str) {
        z(gVar, gVar2, i, i2, ImageView.ScaleType.CENTER_INSIDE, str);
    }

    public void z(com.bytedance.sdk.openadsdk.i.g gVar, g gVar2, int i, int i2, String str, int i3, tb tbVar, boolean z) {
        z(gVar, gVar2, i, i2, ImageView.ScaleType.CENTER_INSIDE, str, i3, tbVar, z);
    }

    public void z(com.bytedance.sdk.openadsdk.i.g gVar, final g gVar2, int i, int i2, ImageView.ScaleType scaleType, String str) {
        com.bytedance.sdk.openadsdk.gz.g.z(gVar.z).key(gVar.g).width(i).height(i2).cacheDir(str).config(Bitmap.Config.RGB_565).scaleType(scaleType).requestTime(!TextUtils.isEmpty(str)).to(new io() { // from class: com.bytedance.sdk.openadsdk.core.io.z.z.1
            @Override // com.bytedance.sdk.component.m.io
            public void onSuccess(ls lsVar) {
                z.this.z(lsVar, gVar2);
            }

            @Override // com.bytedance.sdk.component.m.io
            public void onFailed(int i3, String str2, Throwable th) {
                z.this.z(i3, str2, th, gVar2);
            }
        });
        z();
    }

    public void z(com.bytedance.sdk.openadsdk.i.g gVar, final g gVar2, int i, int i2, ImageView.ScaleType scaleType, String str, int i3, tb tbVar, boolean z) {
        com.bytedance.sdk.openadsdk.gz.g.z(gVar.z).key(gVar.g).width(i).height(i2).cacheDir(str).config(Bitmap.Config.RGB_565).scaleType(scaleType).loadSetp(tbVar).headers(z).requestTime(!TextUtils.isEmpty(str)).to(new io() { // from class: com.bytedance.sdk.openadsdk.core.io.z.z.2
            @Override // com.bytedance.sdk.component.m.io
            public void onSuccess(ls lsVar) {
                z.this.z(lsVar, gVar2);
            }

            @Override // com.bytedance.sdk.component.m.io
            public void onFailed(int i4, String str2, Throwable th) {
                z.this.z(i4, str2, th, gVar2);
            }
        }, i3);
        z();
    }

    protected void z(ls lsVar, g gVar) {
        if (gVar != null) {
            Object result = lsVar.getResult();
            int iZ = z(lsVar);
            if (result instanceof byte[]) {
                gVar.z(lsVar, new com.bytedance.sdk.openadsdk.core.io.z.g((byte[]) result, iZ));
            } else if (result instanceof Bitmap) {
                gVar.z(lsVar, new com.bytedance.sdk.openadsdk.core.io.z.g((Bitmap) result, iZ));
            } else {
                gVar.z(0, "not bitmap or gif result!", null);
            }
        }
    }

    private int z(ls lsVar) {
        Map<String, String> headers = lsVar.getHeaders();
        if (headers == null) {
            return 0;
        }
        try {
            String str = headers.get("image_size");
            if (str == null || !(str instanceof String)) {
                return 0;
            }
            return Integer.parseInt(str);
        } catch (Throwable unused) {
            return 0;
        }
    }

    protected void z(int i, String str, Throwable th, g gVar) {
        if (gVar != null) {
            gVar.z(i, str, th);
        }
    }

    public static C0181z g() {
        return new C0181z();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.io.z.z$z, reason: collision with other inner class name */
    public static class C0181z implements g {
        @Override // com.bytedance.sdk.openadsdk.core.io.z.z.g
        public void z(int i, String str, Throwable th) {
        }

        @Override // com.bytedance.sdk.openadsdk.core.io.z.z.g
        public void z(ls lsVar, com.bytedance.sdk.openadsdk.core.io.z.g gVar) {
        }

        C0181z() {
        }
    }
}
