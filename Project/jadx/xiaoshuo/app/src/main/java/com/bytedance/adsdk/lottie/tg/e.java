package com.bytedance.adsdk.lottie.tg;

import com.bytedance.component.sdk.annotation.RestrictTo;
import com.xiaomi.ad.common.util.SignatureUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class e implements tg {
    private final HttpURLConnection e;

    public e(HttpURLConnection httpURLConnection) {
        this.e = httpURLConnection;
    }

    @Override // com.bytedance.adsdk.lottie.tg.tg
    public InputStream bf() throws IOException {
        return this.e.getInputStream();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.e.disconnect();
    }

    @Override // com.bytedance.adsdk.lottie.tg.tg
    public String d() {
        return this.e.getContentType();
    }

    @Override // com.bytedance.adsdk.lottie.tg.tg
    public boolean e() {
        try {
            return this.e.getResponseCode() / 100 == 2;
        } catch (IOException unused) {
            return false;
        }
    }

    @Override // com.bytedance.adsdk.lottie.tg.tg
    public String tg() {
        try {
            if (e()) {
                return null;
            }
            return "Unable to fetch " + this.e.getURL() + ". Failed with " + this.e.getResponseCode() + SignatureUtils.DELIMITER + e(this.e);
        } catch (IOException e) {
            com.bytedance.adsdk.lottie.vn.tg.e("get error failed ", e);
            return e.getMessage();
        }
    }

    private String e(HttpURLConnection httpURLConnection) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line != null) {
                    sb.append(line);
                    sb.append('\n');
                } else {
                    try {
                        break;
                    } catch (Exception unused) {
                    }
                }
            } finally {
                try {
                    bufferedReader.close();
                } catch (Exception unused2) {
                }
            }
        }
        return sb.toString();
    }
}
