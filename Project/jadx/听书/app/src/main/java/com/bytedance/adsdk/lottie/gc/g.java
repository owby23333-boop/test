package com.bytedance.adsdk.lottie.gc;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private static final String z = "tt_derive" + File.separator + "lottie" + File.separator + "anim_img";
    private static final String g = "tt_derive" + File.separator + "lottie" + File.separator + "anim_video";

    public interface z<T> {
        void z(int i, String str);

        void z(T t);
    }

    public static String z(Context context) {
        return com.bytedance.sdk.component.utils.m.z(context, com.bytedance.sdk.component.adexpress.z.z.z.z().dl().wp(), z).getAbsolutePath();
    }

    public static String g(Context context) {
        return com.bytedance.sdk.component.utils.m.z(context, com.bytedance.sdk.component.adexpress.z.z.z.z().dl().wp(), g).getAbsolutePath();
    }

    public static void z(String str, Context context, final z<File> zVar) {
        if (context == null || TextUtils.isEmpty(str)) {
            if (zVar != null) {
                zVar.z(2, "url is empty");
                return;
            }
            return;
        }
        com.bytedance.sdk.component.fo.g.g gVarA = com.bytedance.sdk.component.adexpress.z.z.z.z().dl().a();
        if (gVarA == null) {
            if (zVar != null) {
                zVar.z(3, "exec is null");
            }
        } else {
            final String strZ = z(context);
            final String strG = com.bytedance.sdk.component.utils.gc.g(str);
            gVarA.z(str);
            gVarA.z(strZ, strG);
            gVarA.z(new com.bytedance.sdk.component.fo.z.z() { // from class: com.bytedance.adsdk.lottie.gc.g.1
                @Override // com.bytedance.sdk.component.fo.z.z
                public void z(com.bytedance.sdk.component.fo.g.a aVar, com.bytedance.sdk.component.fo.g gVar) {
                    if (zVar != null) {
                        File file = new File(strZ, strG);
                        if (file.exists()) {
                            zVar.z(file);
                        } else {
                            zVar.z(4, "file not exist");
                        }
                    }
                }

                @Override // com.bytedance.sdk.component.fo.z.z
                public void z(com.bytedance.sdk.component.fo.g.a aVar, IOException iOException) {
                    z zVar2 = zVar;
                    if (zVar2 != null) {
                        zVar2.z(1, "net err: " + iOException.getMessage());
                    }
                }
            });
        }
    }
}
