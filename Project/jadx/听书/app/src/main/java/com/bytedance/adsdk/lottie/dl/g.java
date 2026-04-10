package com.bytedance.adsdk.lottie.dl;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: loaded from: classes2.dex */
public class g implements m {
    @Override // com.bytedance.adsdk.lottie.dl.m
    public a z(String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.connect();
        return new z(httpURLConnection);
    }
}
