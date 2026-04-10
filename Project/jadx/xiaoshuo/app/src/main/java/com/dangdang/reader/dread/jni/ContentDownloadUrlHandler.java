package com.dangdang.reader.dread.jni;

/* JADX INFO: loaded from: classes10.dex */
public class ContentDownloadUrlHandler {
    private String picUrl = "";
    private String avUrl = "";
    private String htmlUrl = "";
    private String modVersion = "";

    public String getAvUrl() {
        return this.avUrl;
    }

    public String getHtmlUrl() {
        return this.htmlUrl;
    }

    public String getModVersion() {
        return this.modVersion;
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public void setContentDownloadUrl(String str, String str2, String str3, String str4) {
        this.picUrl = str;
        this.avUrl = str2;
        this.htmlUrl = str3;
        this.modVersion = str4;
    }
}
