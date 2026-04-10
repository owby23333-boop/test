package com.ss.android.socialbase.downloader.exception;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadFileExistException extends BaseException {
    private String existTargetFileName;

    public DownloadFileExistException(String str) {
        this.existTargetFileName = str;
    }

    public String getExistTargetFileName() {
        return this.existTargetFileName;
    }
}
