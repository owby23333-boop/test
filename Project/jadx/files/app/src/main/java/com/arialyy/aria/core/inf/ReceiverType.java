package com.arialyy.aria.core.inf;

/* JADX INFO: loaded from: classes2.dex */
public enum ReceiverType {
    DOWNLOAD(1, "download"),
    UPLOAD(2, "upload");

    String name;
    int type;

    ReceiverType(int i2, String str) {
        this.type = i2;
        this.name = str;
    }
}
