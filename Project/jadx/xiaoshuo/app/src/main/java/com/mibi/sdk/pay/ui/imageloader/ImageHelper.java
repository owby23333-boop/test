package com.mibi.sdk.pay.ui.imageloader;

import android.content.Context;
import com.mibi.sdk.common.Utils;

/* JADX INFO: loaded from: classes15.dex */
public class ImageHelper {
    private static final String IMAGE_HOST = "http://file.market.xiaomi.com/mfc/download/";
    private static IImageLoader sImageLoader;

    private ImageHelper() {
    }

    private static void checkImageLoader() {
        if (sImageLoader == null) {
            sImageLoader = new IImageLoaderImpl();
        }
    }

    public static IImageLoader get(Context context) {
        checkImageLoader();
        return sImageLoader.get(context);
    }

    public static String getAbsoluteUrl(String str) {
        return Utils.joinUrl(IMAGE_HOST, str);
    }

    public static void setImageLoader(IImageLoader iImageLoader) {
        sImageLoader = iImageLoader;
    }
}
