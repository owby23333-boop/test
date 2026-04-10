package com.ss.android.socialbase.downloader.impls;

import java.io.IOException;
import java.util.List;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes4.dex */
public class m implements com.ss.android.socialbase.downloader.fo.gz {
    @Override // com.ss.android.socialbase.downloader.fo.gz
    public com.ss.android.socialbase.downloader.fo.e z(String str, List<com.ss.android.socialbase.downloader.e.gc> list) throws IOException {
        OkHttpClient okHttpClientFv = com.ss.android.socialbase.downloader.downloader.dl.fv();
        if (okHttpClientFv == null) {
            throw new IOException("can't get httpClient");
        }
        Request.Builder builderHead = new Request.Builder().url(str).head();
        if (list != null && list.size() > 0) {
            for (com.ss.android.socialbase.downloader.e.gc gcVar : list) {
                builderHead.addHeader(gcVar.z(), com.ss.android.socialbase.downloader.pf.m.e(gcVar.g()));
            }
        }
        final Call callNewCall = okHttpClientFv.newCall(builderHead.build());
        final Response responseExecute = callNewCall.execute();
        if (responseExecute == null) {
            throw new IOException("can't get response");
        }
        if (com.ss.android.socialbase.downloader.pf.z.z(2097152)) {
            responseExecute.close();
        }
        return new com.ss.android.socialbase.downloader.fo.e() { // from class: com.ss.android.socialbase.downloader.impls.m.1
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
        };
    }
}
