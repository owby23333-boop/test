package com.bytedance.sdk.openadsdk.core.un;

import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.bytedance.sdk.openadsdk.core.io.z.z;

/* JADX INFO: loaded from: classes2.dex */
public class fv {

    public interface z {
        void z();

        void z(com.bytedance.sdk.openadsdk.core.io.z.g gVar, com.bytedance.sdk.component.m.ls lsVar);
    }

    public static void z(com.bytedance.sdk.openadsdk.i.g gVar, int i, int i2, final z zVar, String str, int i3, com.bytedance.sdk.component.m.tb tbVar, boolean z2) {
        com.bytedance.sdk.component.utils.wp.a("splashLoadAd", " getImageBytes url ".concat(String.valueOf(gVar)));
        com.bytedance.sdk.openadsdk.core.io.gc.z().dl().z(gVar, new z.g() { // from class: com.bytedance.sdk.openadsdk.core.un.fv.1
            @Override // com.bytedance.sdk.openadsdk.core.io.z.z.g
            public void z(com.bytedance.sdk.component.m.ls lsVar, com.bytedance.sdk.openadsdk.core.io.z.g gVar2) {
                z zVar2;
                if (gVar2.a() && (zVar2 = zVar) != null) {
                    zVar2.z(gVar2, lsVar);
                    return;
                }
                z zVar3 = zVar;
                if (zVar3 != null) {
                    zVar3.z();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.io.z.z.g
            public void z(int i4, String str2, Throwable th) {
                z zVar2 = zVar;
                if (zVar2 != null) {
                    zVar2.z();
                }
            }
        }, i, i2, str, i3, tbVar, z2);
    }

    public static Drawable z(byte[] bArr, int i) {
        if (bArr == null || bArr.length <= 0) {
            return new ColorDrawable(0);
        }
        try {
            return new BitmapDrawable(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
        } catch (Throwable unused) {
            return new ColorDrawable(0);
        }
    }
}
