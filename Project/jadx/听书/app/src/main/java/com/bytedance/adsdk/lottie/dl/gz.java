package com.bytedance.adsdk.lottie.dl;

import android.content.Context;
import android.util.Pair;
import com.bytedance.adsdk.lottie.wp;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: classes2.dex */
public class gz {
    private final m g;
    private final e z;

    public gz(e eVar, m mVar) {
        this.z = eVar;
        this.g = mVar;
    }

    public wp<com.bytedance.adsdk.lottie.m> z(Context context, String str, String str2) {
        com.bytedance.adsdk.lottie.m mVarG = g(context, str, str2);
        if (mVarG != null) {
            return new wp<>(mVarG);
        }
        com.bytedance.adsdk.lottie.gc.gc.z("Animation for " + str + " not found in cache. Fetching from network.");
        return dl(context, str, str2);
    }

    private com.bytedance.adsdk.lottie.m g(Context context, String str, String str2) {
        e eVar;
        Pair<dl, InputStream> pairZ;
        wp<com.bytedance.adsdk.lottie.m> wpVarG;
        if (str2 == null || (eVar = this.z) == null || (pairZ = eVar.z(str)) == null) {
            return null;
        }
        dl dlVar = (dl) pairZ.first;
        InputStream inputStream = (InputStream) pairZ.second;
        if (dlVar == dl.ZIP) {
            wpVarG = com.bytedance.adsdk.lottie.e.z(context, new ZipInputStream(inputStream), str2);
        } else {
            wpVarG = com.bytedance.adsdk.lottie.e.g(inputStream, str2);
        }
        if (wpVarG.z() != null) {
            return wpVarG.z();
        }
        return null;
    }

    private wp<com.bytedance.adsdk.lottie.m> dl(Context context, String str, String str2) {
        com.bytedance.adsdk.lottie.gc.gc.z("Fetching " + str);
        a aVar = null;
        try {
            try {
                a aVarZ = this.g.z(str);
                if (!aVarZ.z()) {
                    wp<com.bytedance.adsdk.lottie.m> wpVar = new wp<>(new IllegalArgumentException(aVarZ.a()));
                    if (aVarZ != null) {
                        try {
                            aVarZ.close();
                        } catch (IOException e) {
                            com.bytedance.adsdk.lottie.gc.gc.z("LottieFetchResult close failed ", e);
                        }
                    }
                    return wpVar;
                }
                wp<com.bytedance.adsdk.lottie.m> wpVarZ = z(context, str, aVarZ.g(), aVarZ.dl(), str2);
                com.bytedance.adsdk.lottie.gc.gc.z("Completed fetch from network. Success: " + (wpVarZ.z() != null));
                if (aVarZ != null) {
                    try {
                        aVarZ.close();
                    } catch (IOException e2) {
                        com.bytedance.adsdk.lottie.gc.gc.z("LottieFetchResult close failed ", e2);
                    }
                }
                return wpVarZ;
            } catch (Exception e3) {
                wp<com.bytedance.adsdk.lottie.m> wpVar2 = new wp<>(e3);
                if (0 != 0) {
                    try {
                        aVar.close();
                    } catch (IOException e4) {
                        com.bytedance.adsdk.lottie.gc.gc.z("LottieFetchResult close failed ", e4);
                    }
                }
                return wpVar2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    aVar.close();
                } catch (IOException e5) {
                    com.bytedance.adsdk.lottie.gc.gc.z("LottieFetchResult close failed ", e5);
                }
            }
            throw th;
        }
    }

    private wp<com.bytedance.adsdk.lottie.m> z(Context context, String str, InputStream inputStream, String str2, String str3) throws IOException {
        wp<com.bytedance.adsdk.lottie.m> wpVarZ;
        dl dlVar;
        e eVar;
        if (str2 == null) {
            str2 = "application/json";
        }
        if (str2.contains("application/zip") || str2.contains("application/x-zip") || str2.contains("application/x-zip-compressed") || str.split("\\?")[0].endsWith(".lottie")) {
            com.bytedance.adsdk.lottie.gc.gc.z("Handling zip response.");
            dl dlVar2 = dl.ZIP;
            wpVarZ = z(context, str, inputStream, str3);
            dlVar = dlVar2;
        } else {
            com.bytedance.adsdk.lottie.gc.gc.z("Received json response.");
            dlVar = dl.JSON;
            wpVarZ = z(str, inputStream, str3);
        }
        if (str3 != null && wpVarZ.z() != null && (eVar = this.z) != null) {
            eVar.z(str, dlVar);
        }
        return wpVarZ;
    }

    private wp<com.bytedance.adsdk.lottie.m> z(Context context, String str, InputStream inputStream, String str2) throws IOException {
        e eVar;
        if (str2 == null || (eVar = this.z) == null) {
            return com.bytedance.adsdk.lottie.e.z(context, new ZipInputStream(inputStream), (String) null);
        }
        return com.bytedance.adsdk.lottie.e.z(context, new ZipInputStream(new FileInputStream(eVar.z(str, inputStream, dl.ZIP))), str);
    }

    private wp<com.bytedance.adsdk.lottie.m> z(String str, InputStream inputStream, String str2) throws IOException {
        e eVar;
        if (str2 == null || (eVar = this.z) == null) {
            return com.bytedance.adsdk.lottie.e.g(inputStream, (String) null);
        }
        return com.bytedance.adsdk.lottie.e.g(new FileInputStream(eVar.z(str, inputStream, dl.JSON).getAbsolutePath()), str);
    }
}
