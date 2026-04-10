package com.ss.android.socialbase.downloader.impls;

import android.net.Uri;
import android.text.TextUtils;
import com.efs.sdk.base.Constants;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.zip.GZIPInputStream;
import okhttp3.Call;
import okhttp3.Dns;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: classes4.dex */
public class e implements com.ss.android.socialbase.downloader.fo.uy {
    private final com.ss.android.socialbase.downloader.pf.gz<String, OkHttpClient> z = new com.ss.android.socialbase.downloader.pf.gz<>(4, 8);

    @Override // com.ss.android.socialbase.downloader.fo.uy
    public com.ss.android.socialbase.downloader.fo.fo z(int i, String str, List<com.ss.android.socialbase.downloader.e.gc> list) throws IOException {
        String strG;
        OkHttpClient okHttpClientFv;
        Request.Builder builderUrl = new Request.Builder().url(str);
        if (list == null || list.size() <= 0) {
            strG = null;
        } else {
            strG = null;
            for (com.ss.android.socialbase.downloader.e.gc gcVar : list) {
                String strZ = gcVar.z();
                if (strG == null && "ss_d_request_host_ip_114".equals(strZ)) {
                    strG = gcVar.g();
                } else {
                    builderUrl.addHeader(strZ, com.ss.android.socialbase.downloader.pf.m.e(gcVar.g()));
                }
            }
        }
        if (!TextUtils.isEmpty(strG)) {
            okHttpClientFv = z(str, strG);
        } else {
            okHttpClientFv = com.ss.android.socialbase.downloader.downloader.dl.fv();
        }
        if (okHttpClientFv == null) {
            throw new IOException("can't get httpClient");
        }
        final Call callNewCall = okHttpClientFv.newCall(builderUrl.build());
        final Response responseExecute = callNewCall.execute();
        if (responseExecute == null) {
            throw new IOException("can't get response");
        }
        final ResponseBody responseBodyBody = responseExecute.body();
        if (responseBodyBody == null) {
            return null;
        }
        InputStream inputStreamByteStream = responseBodyBody.byteStream();
        String strHeader = responseExecute.header(HttpHeaders.CONTENT_ENCODING);
        final InputStream gZIPInputStream = (strHeader == null || !Constants.CP_GZIP.equalsIgnoreCase(strHeader) || (inputStreamByteStream instanceof GZIPInputStream)) ? inputStreamByteStream : new GZIPInputStream(inputStreamByteStream);
        return new com.ss.android.socialbase.downloader.fo.gc() { // from class: com.ss.android.socialbase.downloader.impls.e.1
            @Override // com.ss.android.socialbase.downloader.fo.z
            public String gc() {
                return "";
            }

            @Override // com.ss.android.socialbase.downloader.fo.fo
            public InputStream z() throws IOException {
                return gZIPInputStream;
            }

            @Override // com.ss.android.socialbase.downloader.fo.e
            public String z(String str2) {
                return responseExecute.header(str2);
            }

            @Override // com.ss.android.socialbase.downloader.fo.e
            public int g() throws IOException {
                return responseExecute.code();
            }

            @Override // com.ss.android.socialbase.downloader.fo.e
            public void dl() {
                Call call = callNewCall;
                if (call == null || call.getCanceled()) {
                    return;
                }
                callNewCall.cancel();
            }

            @Override // com.ss.android.socialbase.downloader.fo.fo
            public void a() {
                try {
                    ResponseBody responseBody = responseBodyBody;
                    if (responseBody != null) {
                        responseBody.close();
                    }
                    Call call = callNewCall;
                    if (call == null || call.getCanceled()) {
                        return;
                    }
                    callNewCall.cancel();
                } catch (Throwable unused) {
                }
            }
        };
    }

    private OkHttpClient z(String str, final String str2) {
        try {
            final String host = Uri.parse(str).getHost();
            if (!TextUtils.isEmpty(host) && !TextUtils.isEmpty(str2)) {
                String str3 = host + "_" + str2;
                synchronized (this.z) {
                    OkHttpClient okHttpClient = this.z.get(str3);
                    if (okHttpClient != null) {
                        return okHttpClient;
                    }
                    OkHttpClient.Builder builderTb = com.ss.android.socialbase.downloader.downloader.dl.tb();
                    builderTb.dns(new Dns() { // from class: com.ss.android.socialbase.downloader.impls.e.2
                    });
                    OkHttpClient okHttpClientBuild = builderTb.build();
                    synchronized (this.z) {
                        this.z.put(str3, okHttpClientBuild);
                    }
                    return okHttpClientBuild;
                }
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.wp.z(th);
        }
        return com.ss.android.socialbase.downloader.downloader.dl.fv();
    }
}
