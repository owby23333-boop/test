package com.xiaomi.onetrack;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.xiaomi.onetrack.util.p;

/* JADX INFO: loaded from: classes8.dex */
public class AppWebViewInterface {
    public static final String JAVASCRIPT_INTERFACE_NAME = "OneTrack_APP_H5_Bridge";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f7457a = "AppWebViewInterface";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private OneTrack f7458b;

    public AppWebViewInterface(OneTrack oneTrack) {
        this.f7458b = oneTrack;
    }

    @JavascriptInterface
    public boolean track(String str) {
        p.a(f7457a, "received h5 data. data: " + str);
        if (this.f7458b == null) {
            p.a(f7457a, "mOneTrack is null, return false");
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            p.a(f7457a, "h5 data is empty, return false");
            return false;
        }
        this.f7458b.trackEventFromH5(str);
        return true;
    }
}
