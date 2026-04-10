package com.msa.sdk.core.landingPage.DownloadActionInfo;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadInfo {
    private String mCategory;
    private String mDownloadUrl;
    private String mIconUrl;
    private int mSize;
    private String mSummary;
    private String mTitle;

    public String getCategory() {
        return this.mCategory;
    }

    public String getDownloadUrl() {
        return this.mDownloadUrl;
    }

    public String getIconUrl() {
        return this.mIconUrl;
    }

    public int getSize() {
        return this.mSize;
    }

    public String getSummary() {
        return this.mSummary;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public DownloadInfo setCategory(String str) {
        this.mCategory = str;
        return this;
    }

    public DownloadInfo setDownloadUrl(String str) {
        this.mDownloadUrl = str;
        return this;
    }

    public DownloadInfo setIconUrl(String str) {
        this.mIconUrl = str;
        return this;
    }

    public DownloadInfo setSize(int i) {
        this.mSize = i;
        return this;
    }

    public DownloadInfo setSummary(String str) {
        this.mSummary = str;
        return this;
    }

    public DownloadInfo setTitle(String str) {
        this.mTitle = str;
        return this;
    }
}
