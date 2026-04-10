package com.dangdang.reader.dread.data;

import com.dangdang.zframework.network.download.DownloadConstant;
import java.io.Serializable;

/* JADX INFO: loaded from: classes10.dex */
public class FontDomain implements Serializable {
    private String downloadURL;
    public String fontFtfPath;
    private String fontPath;
    private String fontSize;
    public String fontZipPath;
    public boolean freeBook;
    private String imageURL;
    public String jsonStr;
    private float originalPrice;
    public String productId;
    public long progress;
    private float salePrice;
    public long totalSize;
    private String productname = "";
    public DownloadConstant.Status status = DownloadConstant.Status.UNSTART;
    private boolean isBought = false;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FontDomain fontDomain = (FontDomain) obj;
        if (this.isBought != fontDomain.isBought || Float.compare(fontDomain.originalPrice, this.originalPrice) != 0 || Float.compare(fontDomain.salePrice, this.salePrice) != 0) {
            return false;
        }
        String str = this.downloadURL;
        if (str == null ? fontDomain.downloadURL != null : !str.equals(fontDomain.downloadURL)) {
            return false;
        }
        String str2 = this.fontPath;
        if (str2 == null ? fontDomain.fontPath != null : !str2.equals(fontDomain.fontPath)) {
            return false;
        }
        String str3 = this.fontSize;
        if (str3 == null ? fontDomain.fontSize != null : !str3.equals(fontDomain.fontSize)) {
            return false;
        }
        String str4 = this.imageURL;
        if (str4 == null ? fontDomain.imageURL != null : !str4.equals(fontDomain.imageURL)) {
            return false;
        }
        String str5 = this.productId;
        if (str5 == null ? fontDomain.productId != null : !str5.equals(fontDomain.productId)) {
            return false;
        }
        String str6 = this.productname;
        String str7 = fontDomain.productname;
        return str6 == null ? str7 == null : str6.equals(str7);
    }

    public String getDownloadURL() {
        return this.downloadURL;
    }

    public String getFontPath() {
        return this.fontPath;
    }

    public String getFontSize() {
        return this.fontSize;
    }

    public String getImageURL() {
        return this.imageURL;
    }

    public float getOriginalPrice() {
        return this.originalPrice;
    }

    public String getProductId() {
        return this.productId;
    }

    public String getProductname() {
        return this.productname;
    }

    public float getSalePrice() {
        return this.salePrice;
    }

    public int hashCode() {
        String str = this.productId;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.downloadURL;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.fontSize;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.imageURL;
        int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        float f = this.originalPrice;
        int iFloatToIntBits = (iHashCode4 + (f != 0.0f ? Float.floatToIntBits(f) : 0)) * 31;
        String str5 = this.productname;
        int iHashCode5 = (iFloatToIntBits + (str5 != null ? str5.hashCode() : 0)) * 31;
        float f2 = this.salePrice;
        int iFloatToIntBits2 = (iHashCode5 + (f2 != 0.0f ? Float.floatToIntBits(f2) : 0)) * 31;
        String str6 = this.fontPath;
        return ((iFloatToIntBits2 + (str6 != null ? str6.hashCode() : 0)) * 31) + (this.isBought ? 1 : 0);
    }

    public boolean isBought() {
        return this.isBought;
    }

    public int percent() {
        if (this.totalSize > 0) {
            return (int) Math.rint((this.progress * 100.0f) / r0);
        }
        return 0;
    }

    public void setBought(boolean z) {
        this.isBought = z;
    }

    public void setDownloadURL(String str) {
        this.downloadURL = str;
    }

    public void setFontPath(String str) {
        this.fontPath = str;
    }

    public void setFontSize(String str) {
        this.fontSize = str;
    }

    public void setImageURL(String str) {
        this.imageURL = str;
    }

    public void setOriginalPrice(float f) {
        this.originalPrice = f;
    }

    public void setProductId(String str) {
        this.productId = str;
    }

    public void setProductname(String str) {
        this.productname = str;
    }

    public void setSalePrice(float f) {
        this.salePrice = f;
    }
}
