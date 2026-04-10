package com.duokan.reader.ui.store.data.cms;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class ElegantCard extends Data {
    public static final String PAGE_ID = "92452";

    @SerializedName("ad_setting_id")
    public String adSettingId;

    @SerializedName("card_items")
    public List<? extends Data> cardList;

    @SerializedName("card_source")
    public CardSource cardSource;

    @SerializedName("card_sub_title")
    public String cardSubTitle;

    @SerializedName("card_title")
    public String cardTitle;

    @SerializedName("card_top_level")
    public int cardTopLevel;

    @SerializedName("card_type")
    public String cardType;

    @SerializedName("display_type")
    public String displayType;

    @SerializedName("extra_url")
    public String extraUrl;

    @SerializedName("item_type")
    public String itemType;

    public String getPageTrackInfo() {
        return "92452_" + this.adSettingId;
    }

    public boolean hasData() {
        List<? extends Data> list = this.cardList;
        return list != null && list.size() > 0;
    }

    public String toString() {
        return "ElegantCard{cardType='" + this.cardType + "', displayType='" + this.displayType + "', cardTitle='" + this.cardTitle + "', cardSubTitle='" + this.cardSubTitle + "', extraUrl='" + this.extraUrl + "', itemType='" + this.itemType + "', adSettingId='" + this.adSettingId + "', cardSource=" + this.cardSource + ", cardTopLevel=" + this.cardTopLevel + ", cardList=" + this.cardList + '}';
    }
}
