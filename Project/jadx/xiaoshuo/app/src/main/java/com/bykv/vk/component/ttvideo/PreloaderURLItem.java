package com.bykv.vk.component.ttvideo;

/* JADX INFO: loaded from: classes.dex */
public class PreloaderURLItem {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f2038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f2039b;
    private final String c;
    private final long d;
    private String[] e;
    private IPreLoaderItemCallBackListener f;

    public PreloaderURLItem(String str, String str2, long j, String[] strArr) {
        this.f2039b = null;
        this.f = null;
        this.f2038a = str;
        this.c = str2;
        this.d = j;
        this.e = strArr;
    }

    public IPreLoaderItemCallBackListener getCallBackListener() {
        return this.f;
    }

    public String getFilePath() {
        return this.f2039b;
    }

    public String getKey() {
        return this.f2038a;
    }

    public long getPreloadSize() {
        return this.d;
    }

    public String[] getUrls() {
        return this.e;
    }

    public String getVideoId() {
        return this.c;
    }

    public void setCallBackListener(IPreLoaderItemCallBackListener iPreLoaderItemCallBackListener) {
        this.f = iPreLoaderItemCallBackListener;
    }

    public void setKey(String str) {
        this.f2038a = str;
    }

    public PreloaderURLItem(String str, String str2, long j, String[] strArr, String str3) {
        this.f = null;
        this.f2038a = str;
        this.f2039b = str3;
        this.c = str2;
        this.d = j;
        this.e = strArr;
    }
}
