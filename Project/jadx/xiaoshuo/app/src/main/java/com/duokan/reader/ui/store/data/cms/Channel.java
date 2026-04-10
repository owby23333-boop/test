package com.duokan.reader.ui.store.data.cms;

import com.alipay.sdk.m.y.l;
import com.duokan.reader.ReaderEnv;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class Channel implements Serializable {
    public static final String PAGE_ID = "92452";

    @SerializedName("items")
    public List<Advertisement> adItems;

    @SerializedName("ad_setting_id")
    public int adSettingId;

    @SerializedName("ad_setting_name")
    public String adSettingName;

    @SerializedName("hidden_info")
    public String hiddenInfo;

    @SerializedName("keyword")
    public String keyword;

    @SerializedName(ReaderEnv.d.l3)
    public List<String> recEid;

    @SerializedName("result")
    public int result = -1;

    public String getPageTrackInfo() {
        return "92452_" + this.adSettingId;
    }

    public boolean hasData() {
        List<Advertisement> list = this.adItems;
        return list != null && list.size() > 0;
    }

    public boolean isSuccess() {
        return this.result == 0;
    }

    public String toString() {
        return "Channel{result = '" + this.result + "',ad_setting_name = '" + this.adSettingName + "',ad_setting_id = '" + this.adSettingId + "',keyword = '" + this.keyword + "',hidden_info = '" + this.hiddenInfo + "',adItems = '" + this.adItems + '\'' + l.d;
    }
}
