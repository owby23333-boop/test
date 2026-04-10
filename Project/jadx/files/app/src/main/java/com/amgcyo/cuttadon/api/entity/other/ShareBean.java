package com.amgcyo.cuttadon.api.entity.other;

/* JADX INFO: loaded from: classes.dex */
public class ShareBean {
    private String WXMiniProgramID;
    private String WXMiniProgramPath;
    private String WXMiniProgramType;
    private String contentType;
    private String[] imageArray;
    private String shareContent;
    private String shareTitle;
    private String shareUrl;
    private String[] shareWay;

    public String getContentType() {
        return this.contentType;
    }

    public String[] getImageArray() {
        return this.imageArray;
    }

    public String getShareContent() {
        return this.shareContent;
    }

    public String getShareTitle() {
        return this.shareTitle;
    }

    public String getShareUrl() {
        return this.shareUrl;
    }

    public String[] getShareWay() {
        return this.shareWay;
    }

    public String getWXMiniProgramID() {
        return this.WXMiniProgramID;
    }

    public String getWXMiniProgramPath() {
        return this.WXMiniProgramPath;
    }

    public String getWXMiniProgramType() {
        return this.WXMiniProgramType;
    }

    public void setContentType(String str) {
        this.contentType = str;
    }

    public void setImageArray(String[] strArr) {
        this.imageArray = strArr;
    }

    public void setShareContent(String str) {
        this.shareContent = str;
    }

    public void setShareTitle(String str) {
        this.shareTitle = str;
    }

    public void setShareUrl(String str) {
        this.shareUrl = str;
    }

    public void setShareWay(String[] strArr) {
        this.shareWay = strArr;
    }

    public void setWXMiniProgramID(String str) {
        this.WXMiniProgramID = str;
    }

    public void setWXMiniProgramPath(String str) {
        this.WXMiniProgramPath = str;
    }

    public void setWXMiniProgramType(String str) {
        this.WXMiniProgramType = str;
    }
}
