package com.duokan.reader.ui.store.data.cms;

import com.alipay.sdk.m.y.l;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class ImageInfo implements Serializable {

    @SerializedName("currentOption")
    public JSONObject currentOption;

    @SerializedName("id")
    public String imageId;

    @SerializedName("name")
    public String imageName;

    @SerializedName("ratio")
    public float imageRatio;

    @SerializedName("type")
    public int imageType;

    @SerializedName("url")
    public String imageUrl;

    @SerializedName("success")
    public boolean success;

    public String toString() {
        return "ImageInfo{url = '" + this.imageUrl + "',success = '" + this.success + "',name = '" + this.imageName + "',type= '" + this.imageType + "',id = '" + this.imageId + "',ratio = '" + this.imageRatio + "', currentOption = '" + this.currentOption.toString() + '\'' + l.d;
    }
}
