package com.bytedance.sdk.openadsdk.api.e;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.ss.android.download.api.model.DownloadShortInfo;

/* JADX INFO: loaded from: classes10.dex */
public class tg implements Bridge {
    private DownloadShortInfo e;

    public tg(DownloadShortInfo downloadShortInfo) {
        this.e = downloadShortInfo;
    }

    public int bf() {
        DownloadShortInfo downloadShortInfo = this.e;
        if (downloadShortInfo != null) {
            return downloadShortInfo.status;
        }
        return -1;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        switch (i) {
            case 223700:
                return (T) Boolean.valueOf(equals(valueSet.objectValue(223709, Object.class)));
            case 223701:
                hashCode();
                return null;
            default:
                return null;
        }
    }

    public long d() {
        DownloadShortInfo downloadShortInfo = this.e;
        if (downloadShortInfo != null) {
            return downloadShortInfo.totalBytes;
        }
        return -1L;
    }

    public long e() {
        DownloadShortInfo downloadShortInfo = this.e;
        if (downloadShortInfo != null) {
            return downloadShortInfo.id;
        }
        return -1L;
    }

    public boolean equals(Object obj) {
        DownloadShortInfo downloadShortInfo = this.e;
        if (downloadShortInfo != null) {
            return downloadShortInfo.equals(obj);
        }
        return false;
    }

    public String ga() {
        DownloadShortInfo downloadShortInfo = this.e;
        return downloadShortInfo != null ? downloadShortInfo.fileName : "";
    }

    public int hashCode() {
        DownloadShortInfo downloadShortInfo = this.e;
        if (downloadShortInfo != null) {
            return downloadShortInfo.hashCode();
        }
        return 0;
    }

    public boolean p() {
        DownloadShortInfo downloadShortInfo = this.e;
        if (downloadShortInfo != null) {
            return downloadShortInfo.onlyWifi;
        }
        return false;
    }

    public long tg() {
        DownloadShortInfo downloadShortInfo = this.e;
        if (downloadShortInfo != null) {
            return downloadShortInfo.currentBytes;
        }
        return -1L;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return com.bytedance.sdk.openadsdk.api.tg.e().e(223702, e()).e(223703, bf()).e(223704, d()).e(223705, tg()).e(223706, ga()).e(223707, vn()).e(223708, p()).bf();
    }

    public int vn() {
        DownloadShortInfo downloadShortInfo = this.e;
        if (downloadShortInfo != null) {
            return downloadShortInfo.failStatus;
        }
        return 0;
    }
}
