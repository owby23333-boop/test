package com.dangdang.reader.domain;

import android.text.TextUtils;
import java.io.Serializable;

/* JADX INFO: loaded from: classes10.dex */
public class BaseBook implements Serializable {
    private static final long serialVersionUID = 1;
    private String audioAuthorPenname;
    private String authorName;
    private String authorPenname;
    private String boughtId;
    private String categoryIds;
    private String coverPic;
    private String descs;
    protected String mediaId;
    private int mediaType;
    private String productId;
    private String publishDate;
    private String publisher;
    private String saleId;
    private String shortDescs;
    protected String title;
    private String categorys = "无";
    private byte[] bookStructDatas = null;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        String str = this.mediaId;
        String str2 = ((BaseBook) obj).mediaId;
        if (str != null) {
            if (str.equals(str2)) {
                return true;
            }
        } else if (str2 == null) {
            return true;
        }
        return false;
    }

    public String getAudioAuthorPenname() {
        return (!TextUtils.isEmpty(this.authorPenname) && this.authorPenname.contains(";;") && this.authorPenname.split(";;").length > 1) ? this.authorPenname.split(";;")[1] : "";
    }

    public String getAuthorName() {
        return this.authorName;
    }

    public String getAuthorPenname() {
        if (!TextUtils.isEmpty(this.authorPenname) && this.authorPenname.contains(";;")) {
            return this.authorPenname.split(";;")[0];
        }
        return this.authorPenname;
    }

    public byte[] getBookStructDatas() {
        return this.bookStructDatas;
    }

    public String getBoughtId() {
        return this.boughtId;
    }

    public String getCategoryIds() {
        return this.categoryIds;
    }

    public String getCategorys() {
        if (!TextUtils.isEmpty(this.categorys) && this.categorys.contains(",")) {
            return this.categorys.split(",")[0];
        }
        return this.categorys;
    }

    public String getCoverPic() {
        return this.coverPic;
    }

    public String getDescs() {
        return this.descs;
    }

    public String getMediaId() {
        return this.mediaId;
    }

    public int getMediaType() {
        return this.mediaType;
    }

    public String getProductId() {
        return this.productId;
    }

    public String getPublishDate() {
        return this.publishDate;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public String getSaleId() {
        return this.saleId;
    }

    public String getShortDescs() {
        return this.shortDescs;
    }

    public String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.mediaId;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public void setAudioAuthorPenname(String str) {
        this.audioAuthorPenname = str;
    }

    public void setAuthorName(String str) {
        this.authorName = str;
    }

    public void setAuthorPenname(String str) {
        this.authorPenname = str;
    }

    public void setBookStructDatas(byte[] bArr) {
        this.bookStructDatas = bArr;
    }

    public void setBoughtId(String str) {
        this.boughtId = str;
    }

    public void setCategoryIds(String str) {
        this.categoryIds = str;
    }

    public void setCategorys(String str) {
        this.categorys = str;
    }

    public void setCoverPic(String str) {
        this.coverPic = str;
    }

    public void setDescs(String str) {
        this.descs = str;
    }

    public void setMediaId(String str) {
        this.mediaId = str;
    }

    public void setMediaType(int i) {
        this.mediaType = i;
    }

    public void setProductId(String str) {
        this.productId = str;
    }

    public void setPublishDate(String str) {
        this.publishDate = str;
    }

    public void setPublisher(String str) {
        this.publisher = str;
    }

    public void setSaleId(String str) {
        this.saleId = str;
    }

    public void setShortDescs(String str) {
        this.shortDescs = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        return "BaseBook [saleId=" + this.saleId + ", mediaId=" + this.mediaId + ", productId=" + this.productId + ", title=" + this.title + ", authorPenname=" + this.authorPenname + ", coverPic=" + this.coverPic + ", descs=" + this.descs + ", categorys=" + this.categorys + ", categoryIds=" + this.categoryIds + ", publisher=" + this.publisher + ", publishDate=" + this.publishDate + "]";
    }
}
