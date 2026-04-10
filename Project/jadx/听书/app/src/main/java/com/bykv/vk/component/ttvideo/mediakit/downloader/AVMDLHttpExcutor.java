package com.bykv.vk.component.ttvideo.mediakit.downloader;

import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderConfigure;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLLog;
import com.bytedance.sdk.component.g.z.g;
import com.bytedance.sdk.component.g.z.i;
import com.bytedance.sdk.component.g.z.ls;
import com.bytedance.sdk.component.g.z.m;
import com.bytedance.sdk.component.g.z.pf;
import com.bytedance.sdk.component.g.z.v;
import com.bytedance.sdk.component.g.z.wp;
import com.google.common.net.HttpHeaders;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class AVMDLHttpExcutor {
    private static final String TAG = "AVMDLHttpExcutor";
    private static wp okHttpClient;

    private static synchronized wp getOkHttpClient() {
        long j;
        if (okHttpClient == null) {
            AVMDLDataLoaderConfigure config = AVMDLDataLoader.getInstance().getConfig();
            long j2 = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
            if (config != null) {
                long j3 = config.mOpenTimeOut > 0 ? config.mOpenTimeOut * 1000 : 10000L;
                if (config.mRWTimeOut > 0) {
                    j2 = config.mRWTimeOut * 1000;
                }
                long j4 = j2;
                j2 = j3;
                j = j4;
            } else {
                j = 10000;
            }
            wp.z zVar = new wp.z();
            zVar.z(Collections.singletonList(i.HTTP_1_1));
            zVar.z(j2, TimeUnit.MILLISECONDS).g(j, TimeUnit.MILLISECONDS).dl(j, TimeUnit.MILLISECONDS);
            okHttpClient = zVar.z();
        }
        return okHttpClient;
    }

    public static AVMDLResponse excute(AVMDLRequest aVMDLRequest, int i) throws Exception {
        v.z zVar = new v.z();
        zVar.z(aVMDLRequest.urls[i]);
        zVar.z("GET", (pf) null);
        zVar.z(toOkHttpHeaders(aVMDLRequest));
        g gVarZ = getOkHttpClient().z(zVar.g());
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            ls lsVarG = gVarZ.g();
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            aVMDLRequest.mCurlUrlIndex = i;
            String.format("http open cost time:%d url:%s", Long.valueOf(jCurrentTimeMillis2 - jCurrentTimeMillis), aVMDLRequest.urls[i]);
            return new AVMDLResponse(aVMDLRequest, lsVarG, gVarZ);
        } catch (Exception e) {
            AVMDLLog.e(TAG, "request exception is " + e.getLocalizedMessage());
            throw e;
        }
    }

    private static m toOkHttpHeaders(AVMDLRequest aVMDLRequest) {
        m.z zVar = new m.z();
        if (aVMDLRequest.headers != null) {
            for (Map.Entry<String, String> entry : aVMDLRequest.headers.entrySet()) {
                entry.getKey();
                entry.getValue();
                zVar.g(entry.getKey(), entry.getValue());
            }
        }
        String strBuildRangeHeader = buildRangeHeader(aVMDLRequest.reqOff, aVMDLRequest.size);
        if (strBuildRangeHeader != null) {
            zVar.g(HttpHeaders.RANGE, strBuildRangeHeader);
        }
        zVar.g(HttpHeaders.ACCEPT_ENCODING, "identity");
        return zVar.z();
    }

    public static String buildRangeHeader(long j, long j2) {
        String strFormRangeStrBySize = formRangeStrBySize(j, j2);
        if (strFormRangeStrBySize == null) {
            return null;
        }
        return "bytes=".concat(String.valueOf(strFormRangeStrBySize));
    }

    public static String formRangeStrBySize(long j, long j2) {
        return formRangeStrByPos(j, j2 > 0 ? (j2 + j) - 1 : -1L);
    }

    public static String formRangeStrByPos(long j, long j2) {
        if (j >= 0 && j2 > 0) {
            return j + "-" + j2;
        }
        if (j >= 0) {
            return j + "-";
        }
        if (j >= 0 || j2 <= 0) {
            return null;
        }
        return "-".concat(String.valueOf(j2));
    }
}
