package com.bykv.vk.component.ttvideo.mediakit.downloader;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLLog;
import com.bytedance.sdk.component.g.z.g;
import com.bytedance.sdk.component.g.z.ls;
import com.google.common.net.HttpHeaders;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class AVMDLResponse {
    private static final String TAG = "AVMDLResponse";
    public g call;
    public long readOff;
    public AVMDLRequest request;
    public ls response;
    public long contentlength = -1;
    public int statusCode = -1;
    public boolean isReadErr = false;

    public AVMDLResponse(AVMDLRequest aVMDLRequest, ls lsVar, g gVar) {
        this.request = aVMDLRequest;
        this.response = lsVar;
        this.call = gVar;
        this.readOff = aVMDLRequest.reqOff;
        parseResponse();
    }

    private void parseResponse() {
        int iLastIndexOf;
        ls lsVar = this.response;
        if (lsVar == null) {
            return;
        }
        int iDl = lsVar.dl();
        this.statusCode = iDl;
        if (iDl == 200) {
            this.contentlength = toInt(this.response.z(HttpHeaders.CONTENT_LENGTH));
            return;
        }
        if (iDl == 206) {
            String strZ = this.response.z(HttpHeaders.CONTENT_RANGE);
            if (TextUtils.isEmpty(strZ) || (iLastIndexOf = strZ.lastIndexOf("/")) < 0 || iLastIndexOf >= strZ.length() - 1) {
                return;
            }
            this.contentlength = toInt(strZ.substring(iLastIndexOf + 1), -1);
        }
    }

    public int readData(byte[] bArr) {
        if (this.response.m() == null) {
            return 0;
        }
        try {
            int i = this.response.m().dl().read(bArr);
            if (i <= 0) {
                return -1;
            }
            String.format("before read off:%d reqoff:%d req size:%d", Long.valueOf(this.readOff), Long.valueOf(this.request.reqOff), Long.valueOf(this.request.size));
            long j = i;
            this.readOff += j;
            this.request.reqOff += j;
            if (this.request.size > 0) {
                this.request.size -= j;
            }
            String.format("after read,ret:%d off:%d reqoff:%d req size:%d", Integer.valueOf(i), Long.valueOf(this.readOff), Long.valueOf(this.request.reqOff), Long.valueOf(this.request.size));
            return i;
        } catch (IOException e) {
            this.isReadErr = true;
            AVMDLLog.e(TAG, "read data exception:" + e.getLocalizedMessage());
            return -1;
        }
    }

    public void cancel() {
        g gVar = this.call;
        if (gVar != null) {
            gVar.dl();
        }
    }

    public void reset() {
        this.response = null;
        this.call = null;
        this.contentlength = -1L;
        this.statusCode = -1;
        this.isReadErr = false;
    }

    public boolean isOpenSuccessful() {
        int i = this.statusCode;
        return i >= 200 && i < 300;
    }

    public boolean isFinish() {
        long j = this.request.size >= 0 ? this.request.reqOff + this.request.size : this.contentlength;
        long j2 = this.contentlength;
        if (j > j2) {
            j = j2;
        }
        String.format("check readoff:%d reqoff:%d reqsize:%d contentlen:%d endoff:%d", Long.valueOf(this.readOff), Long.valueOf(this.request.reqOff), Long.valueOf(this.request.size), Long.valueOf(this.contentlength), Long.valueOf(j));
        return this.readOff >= j;
    }

    public boolean isReadSuccessful() {
        return !this.isReadErr;
    }

    public static int toInt(String str) {
        return toInt(str, 0);
    }

    public static int toInt(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i;
        }
    }
}
