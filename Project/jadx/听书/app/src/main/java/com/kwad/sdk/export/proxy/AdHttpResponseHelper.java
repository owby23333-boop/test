package com.kwad.sdk.export.proxy;

import com.kwad.sdk.utils.bw;

/* JADX INFO: loaded from: classes4.dex */
public class AdHttpResponseHelper {
    public static void notifyResponseStart(final AdHttpResponseListener adHttpResponseListener) {
        if (adHttpResponseListener == null) {
            return;
        }
        bw.postOnUiThread(new Runnable() { // from class: com.kwad.sdk.export.proxy.AdHttpResponseHelper.1
            @Override // java.lang.Runnable
            public void run() {
                adHttpResponseListener.onResponseStart();
            }
        });
    }

    public static void notifyResponseEnd(final AdHttpResponseListener adHttpResponseListener) {
        if (adHttpResponseListener == null) {
            return;
        }
        bw.postOnUiThread(new Runnable() { // from class: com.kwad.sdk.export.proxy.AdHttpResponseHelper.2
            @Override // java.lang.Runnable
            public void run() {
                adHttpResponseListener.onResponseEnd();
            }
        });
    }

    public static boolean notifyResponseProgress(AdHttpResponseListener adHttpResponseListener, long j, long j2) {
        if (adHttpResponseListener == null) {
            return false;
        }
        return adHttpResponseListener.onReadProgress(j, j2);
    }
}
