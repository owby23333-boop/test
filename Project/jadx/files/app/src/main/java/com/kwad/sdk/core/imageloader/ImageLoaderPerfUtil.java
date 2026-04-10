package com.kwad.sdk.core.imageloader;

import com.kwad.sdk.core.d.b;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.x;

/* JADX INFO: loaded from: classes3.dex */
public class ImageLoaderPerfUtil {
    private static final String TAG = "ImageLoaderPerfUtil";

    public static ImageLoaderInfo getInfo() {
        ImageLoaderInfo imageLoaderInfo = new ImageLoaderInfo();
        imageLoaderInfo.totalCount = x.DB();
        imageLoaderInfo.successCount = x.DC();
        imageLoaderInfo.failedCount = x.DD();
        imageLoaderInfo.duration = x.DA();
        return imageLoaderInfo;
    }

    public static void report() {
        g.execute(new av() { // from class: com.kwad.sdk.core.imageloader.ImageLoaderPerfUtil.1
            @Override // com.kwad.sdk.utils.av
            public final void doTask() {
                ImageLoaderInfo info = ImageLoaderPerfUtil.getInfo();
                if (info.totalCount == 0) {
                    b.w(ImageLoaderPerfUtil.TAG, "info.totalCount == 0");
                    return;
                }
                b.d(ImageLoaderPerfUtil.TAG, "ImageLoaderInfo:" + info.toJson().toString());
                KSLoggerReporter.w(info.toJson());
            }
        });
    }
}
