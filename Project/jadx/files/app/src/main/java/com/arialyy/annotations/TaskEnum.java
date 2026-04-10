package com.arialyy.annotations;

/* JADX INFO: loaded from: classes2.dex */
public enum TaskEnum {
    DOWNLOAD("com.arialyy.aria.core.task", "DownloadTask", "$$DownloadListenerProxy", "AptNormalTaskListener"),
    DOWNLOAD_GROUP("com.arialyy.aria.core.task", "DownloadGroupTask", "$$DownloadGroupListenerProxy", "AptNormalTaskListener"),
    DOWNLOAD_GROUP_SUB("com.arialyy.aria.core.task", "DownloadGroupTask", "$$DGSubListenerProxy", "AptSubTaskListener"),
    UPLOAD("com.arialyy.aria.core.task", "UploadTask", "$$UploadListenerProxy", "AptNormalTaskListener"),
    M3U8_PEER("com.arialyy.aria.core.task", "DownloadTask", "$$M3U8PeerListenerProxy", "AptM3U8PeerTaskListener");


    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f12781s;

    TaskEnum(String str, String str2, String str3, String str4) {
        this.f12781s = str3;
    }
}
