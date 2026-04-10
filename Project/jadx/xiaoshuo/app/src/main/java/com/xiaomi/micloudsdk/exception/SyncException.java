package com.xiaomi.micloudsdk.exception;

/* JADX INFO: loaded from: classes8.dex */
public class SyncException extends Exception {
    private static final long serialVersionUID = 1;
    private String mDescription;

    public SyncException() {
    }

    public String getDescription() {
        return this.mDescription;
    }

    public void setDescription(String str) {
        this.mDescription = str;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return this.mDescription;
    }

    public SyncException(String str) {
        this.mDescription = str;
    }
}
