package com.duokan.reader.ui.store.data.cms;

import com.alibaba.android.arouter.utils.Consts;
import com.alipay.sdk.m.y.l;
import com.google.gson.annotations.SerializedName;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;

/* JADX INFO: loaded from: classes5.dex */
public class RecommendAd implements Serializable {

    @SerializedName("ad_copy")
    public String adCopy;

    @SerializedName("ad_name")
    public String adName;

    @SerializedName("ad_pic_url")
    public String adPicUrl;

    @SerializedName("ad_priority")
    public int adPriority;

    @SerializedName("ad_type")
    public int adType;

    @SerializedName("height")
    public int height;

    @SerializedName("hidden_info")
    public String hiddenInfo;

    @SerializedName("id")
    public String id;

    @SerializedName("reference_id")
    public String referenceId;

    @SerializedName("size")
    public int size;

    @SerializedName("status")
    public int status;

    @SerializedName("width")
    public int width;

    public Advertisement toAdvertisement(Advertisement advertisement, int i) {
        Advertisement advertisement2 = new Advertisement();
        advertisement2.type = this.adType;
        advertisement2.bannerUrl = this.adPicUrl;
        advertisement2.title = this.adName;
        advertisement2.desc = this.adCopy;
        advertisement2.adId = this.id;
        advertisement2.id = this.referenceId;
        Extend extend = new Extend();
        advertisement2.extend = extend;
        extend.type = "banner";
        advertisement2.track = advertisement.track + Consts.DOT + "12_" + i + Constants.ACCEPT_TIME_SEPARATOR_SERVER + advertisement2.adId;
        return advertisement2;
    }

    public String toString() {
        return "Response{ad_type = '" + this.adType + "',reference_id = '" + this.referenceId + "',size = '" + this.size + "',ad_priority = '" + this.adPriority + "',width = '" + this.width + "',ad_name = '" + this.adName + "',ad_pic_url = '" + this.adPicUrl + "',ad_copy = '" + this.adCopy + "',id = '" + this.id + "',hidden_info = '" + this.hiddenInfo + "',status = '" + this.status + "',height = '" + this.height + '\'' + l.d;
    }
}
