package com.bytedance.adsdk.lottie.dl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/* JADX INFO: loaded from: classes2.dex */
public class z implements a {
    private final HttpURLConnection z;

    public z(HttpURLConnection httpURLConnection) {
        this.z = httpURLConnection;
    }

    @Override // com.bytedance.adsdk.lottie.dl.a
    public boolean z() {
        try {
            return this.z.getResponseCode() / 100 == 2;
        } catch (IOException unused) {
            return false;
        }
    }

    @Override // com.bytedance.adsdk.lottie.dl.a
    public InputStream g() throws IOException {
        return this.z.getInputStream();
    }

    @Override // com.bytedance.adsdk.lottie.dl.a
    public String dl() {
        return this.z.getContentType();
    }

    @Override // com.bytedance.adsdk.lottie.dl.a
    public String a() {
        try {
            if (z()) {
                return null;
            }
            return "Unable to fetch " + this.z.getURL() + ". Failed with " + this.z.getResponseCode() + "\n" + z(this.z);
        } catch (IOException e) {
            com.bytedance.adsdk.lottie.gc.gc.z("get error failed ", e);
            return e.getMessage();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.z.disconnect();
    }

    private String z(HttpURLConnection httpURLConnection) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line != null) {
                    sb.append(line).append('\n');
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
