package com.ss.android.socialbase.downloader.exception;

/* JADX INFO: loaded from: classes4.dex */
public class p extends BaseException {
    public p(int i, String str) {
        super(i, str);
    }

    public p e(String str) {
        setExtraInfo(str);
        return this;
    }

    public String e() {
        return getExtraInfo();
    }
}
