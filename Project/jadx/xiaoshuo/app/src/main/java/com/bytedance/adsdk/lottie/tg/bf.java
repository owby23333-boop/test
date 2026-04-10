package com.bytedance.adsdk.lottie.tg;

import com.bytedance.component.sdk.annotation.RestrictTo;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class bf implements vn {
    @Override // com.bytedance.adsdk.lottie.tg.vn
    public tg e(String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.connect();
        return new e(httpURLConnection);
    }
}
