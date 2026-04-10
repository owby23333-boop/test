package com.bytedance.sdk.openadsdk.upie;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bytedance.sdk.component.a.g.dl;
import com.bytedance.sdk.component.e.a;
import com.bytedance.sdk.component.m.io;
import com.bytedance.sdk.component.m.iq;
import com.bytedance.sdk.component.m.ls;
import com.bytedance.sdk.component.utils.gc;
import com.bytedance.sdk.component.utils.m;
import com.bytedance.sdk.component.utils.wp;
import java.io.File;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile g f1475a;
    private final dl dl = new a.z().z("lottie_tpl_info").z(com.bytedance.sdk.component.adexpress.z.z.z.z().dl().getContext()).z(1).z(com.bytedance.sdk.component.adexpress.z.z.z.z().dl().wp()).z();
    private static final String z = "tt_derive" + File.separator + "lottie" + File.separator + "audio";
    private static final String g = "tt_derive" + File.separator + "lottie" + File.separator + "anim_img";

    public interface z<T> {
        void z(int i, String str);

        void z(T t);
    }

    private g() {
    }

    public static g z() {
        if (f1475a == null) {
            synchronized (g.class) {
                if (f1475a == null) {
                    f1475a = new g();
                }
            }
        }
        return f1475a;
    }

    public void z(Context context, com.bytedance.sdk.openadsdk.upie.z zVar) {
        if (zVar != null) {
            String strDl = zVar.dl();
            if (!TextUtils.isEmpty(strDl)) {
                g(strDl, null);
            }
            String strZ = zVar.z();
            if (TextUtils.isEmpty(strZ) || !TextUtils.isEmpty(z(strZ))) {
                return;
            }
            z(strZ, (z<String>) null);
        }
    }

    public void z(final String str, final z<String> zVar) {
        com.bytedance.sdk.component.fo.g.dl dlVarGc = com.bytedance.sdk.component.adexpress.z.z.z.z().dl().gc();
        if (dlVarGc == null) {
            return;
        }
        dlVarGc.z(str);
        dlVarGc.z(new com.bytedance.sdk.component.fo.z.z() { // from class: com.bytedance.sdk.openadsdk.upie.g.1
            @Override // com.bytedance.sdk.component.fo.z.z
            public void z(com.bytedance.sdk.component.fo.g.a aVar, com.bytedance.sdk.component.fo.g gVar) {
                String strA;
                boolean z2 = false;
                if (gVar != null) {
                    try {
                        if (gVar.gz() && (strA = gVar.a()) != null) {
                            try {
                                wp.z("TTDeriveTplManager", "lottie content is ok, version: " + new JSONObject(strA).optString("v"));
                                g.this.z(str, strA);
                                z zVar2 = zVar;
                                if (zVar2 != null) {
                                    zVar2.z(strA);
                                    return;
                                }
                                return;
                            } catch (JSONException e) {
                                wp.z(e);
                                if (zVar != null) {
                                    String message = e.getMessage();
                                    if (message != null && message.length() > 100) {
                                        message = message.substring(0, 100);
                                    }
                                    zVar.z(AVMDLDataLoader.KeyIsStoMaxIdleTimeSec, "lottieJsonUrl加载失败0, " + message);
                                    return;
                                }
                                return;
                            }
                        }
                    } catch (Throwable th) {
                        wp.z(th);
                        z zVar3 = zVar;
                        if (zVar3 != null) {
                            zVar3.z(10001, "lottieJsonUrl加载失败2, " + th.getMessage());
                            return;
                        }
                        return;
                    }
                }
                z zVar4 = zVar;
                if (zVar4 != null) {
                    StringBuilder sbAppend = new StringBuilder("lottieJsonUrl加载失败1, response is not null:").append(gVar != null).append(", isSuccess:");
                    if (gVar != null && gVar.gz()) {
                        z2 = true;
                    }
                    zVar4.z(10001, sbAppend.append(z2).toString());
                }
            }

            @Override // com.bytedance.sdk.component.fo.z.z
            public void z(com.bytedance.sdk.component.fo.g.a aVar, IOException iOException) {
                z zVar2 = zVar;
                if (zVar2 != null) {
                    zVar2.z(10001, "lottieJsonUrl加载失败3, " + iOException.getMessage());
                }
            }
        });
    }

    public void z(Context context, String str, final z<Bitmap> zVar) {
        iq iqVarGc = com.bytedance.sdk.component.adexpress.z.z.z.z().gc();
        if (iqVarGc != null) {
            iqVarGc.from(str).cacheDir(z(context)).config(Bitmap.Config.ARGB_4444).type(2).to(new io<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.upie.g.2
                @Override // com.bytedance.sdk.component.m.io
                public void onSuccess(ls<Bitmap> lsVar) {
                    z zVar2;
                    try {
                        Bitmap result = lsVar.getResult();
                        if (result == null || (zVar2 = zVar) == null) {
                            return;
                        }
                        zVar2.z(result);
                    } catch (Throwable th) {
                        wp.z(th);
                    }
                }

                @Override // com.bytedance.sdk.component.m.io
                public void onFailed(int i, String str2, Throwable th) {
                    z zVar2 = zVar;
                    if (zVar2 != null) {
                        zVar2.z(i, "load lottie pic fail: ".concat(String.valueOf(str2)));
                    }
                }
            }, 4);
        } else if (zVar != null) {
            zVar.z(-1, "imageCenter is null");
        }
    }

    public void g(String str, final z<Bitmap> zVar) {
        iq iqVarGc = com.bytedance.sdk.component.adexpress.z.z.z.z().gc();
        if (iqVarGc != null) {
            iqVarGc.from(str).config(Bitmap.Config.ARGB_4444).type(2).to(new io<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.upie.g.3
                @Override // com.bytedance.sdk.component.m.io
                public void onSuccess(ls<Bitmap> lsVar) {
                    z zVar2;
                    try {
                        Bitmap result = lsVar.getResult();
                        if (result == null || (zVar2 = zVar) == null) {
                            return;
                        }
                        zVar2.z(result);
                    } catch (Throwable th) {
                        wp.z(th);
                    }
                }

                @Override // com.bytedance.sdk.component.m.io
                public void onFailed(int i, String str2, Throwable th) {
                    z zVar2 = zVar;
                    if (zVar2 != null) {
                        zVar2.z(i, "load ad pic fail: ".concat(String.valueOf(str2)));
                    }
                }
            }, 4);
        } else if (zVar != null) {
            zVar.z(-1, "imageCenter is null");
        }
    }

    public String z(String str) {
        String strG = gc.g(str);
        if (TextUtils.isEmpty(strG)) {
            return null;
        }
        return this.dl.get(strG, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(String str, String str2) {
        String strG = gc.g(str);
        if (TextUtils.isEmpty(strG)) {
            return;
        }
        this.dl.put(strG, str2);
    }

    public String z(Context context) {
        return m.z(context, com.bytedance.sdk.component.adexpress.z.z.z.z().dl().wp(), g).getAbsolutePath();
    }
}
