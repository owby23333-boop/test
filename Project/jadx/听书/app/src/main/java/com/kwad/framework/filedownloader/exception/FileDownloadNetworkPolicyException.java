package com.kwad.framework.filedownloader.exception;

/* JADX INFO: loaded from: classes4.dex */
public class FileDownloadNetworkPolicyException extends FileDownloadGiveUpRetryException {
    public FileDownloadNetworkPolicyException() {
        super("Only allows downloading this task on the wifi network type");
    }
}
