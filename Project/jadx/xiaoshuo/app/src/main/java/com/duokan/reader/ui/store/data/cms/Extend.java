package com.duokan.reader.ui.store.data.cms;

import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alipay.sdk.m.y.l;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.duokan.bean.CalendarRemindInfo;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.gson.annotations.SerializedName;
import com.yuewen.e01;
import com.yuewen.lp2;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class Extend implements Serializable {

    @SerializedName("act_type")
    public String actionType;

    @SerializedName("animation")
    public int animation;

    @SerializedName("appointInfo")
    public CalendarRemindInfo appointInfo;

    @SerializedName("auto_banner")
    public int autoBanner;

    @SerializedName("banner_img")
    public int bannerImg;

    @SerializedName("banner_ratio")
    public double bannerRatio;

    @SerializedName("book_info")
    public int bookInfo;

    @SerializedName("buttons")
    public List<Buttons> buttons;

    @SerializedName("backgrounds")
    public List<String> cardBackgrounds;

    @SerializedName("is_title_center")
    public int centerTitle;

    @SerializedName("close_delay")
    public long closeDelay;

    @SerializedName("countdown")
    public String countdown;

    @SerializedName("data_source")
    public String dataSource;

    @SerializedName("diversion_app_url")
    public String diversionAppUrl;

    @SerializedName("diversion_app_version")
    public String diversionAppVersion;

    @SerializedName("diversion_h5_url")
    public String diversionH5Url;

    @SerializedName("diversion_only_miui")
    public int diversionOnlyMiui;

    @SerializedName("diversion_shield_phone")
    public String diversionShieldPhone;

    @SerializedName("diversion_shield_version")
    public String diversionShieldVersion;

    @SerializedName("female_url")
    public String femaleUrl;

    @SerializedName("style__append_hide_footer")
    public String footStyle;

    @SerializedName("free_min")
    public int freeMinutes;

    @SerializedName("free_title")
    public String freeTitle;

    @SerializedName("style__append_store_bgImage")
    public String gbImage;

    @SerializedName("gift_code")
    public int gift_code;

    @SerializedName("hide_header")
    public int hideHeader;

    @SerializedName("images")
    public String images;

    @SerializedName("layer_style")
    public String layerStyle;

    @SerializedName("layer_key")
    public String layer_key;

    @SerializedName(TtmlNode.TAG_LAYOUT)
    public String layout;

    @SerializedName("lessOneDay")
    public int lessOneDay;

    @SerializedName("limit_end_time")
    public long limitEndTime;

    @SerializedName("show_vertical")
    public int listType;

    @SerializedName("max_discount_to_show")
    public String maxDiscountToShow;

    @SerializedName("module")
    public String module;

    @SerializedName("style__append_more_text")
    public String moreText;

    @SerializedName("more_type")
    public String moreType;

    @SerializedName("more_url")
    public String moreUrl;

    @SerializedName("need_detail")
    public String needDetail;

    @SerializedName("show_days")
    public int newUserCardShowDays;

    @SerializedName("newbie_default_url")
    public String newbieDefaultUrl;

    @SerializedName("newbie_success_url")
    public String newbieSuccessUrl;

    @SerializedName("newer_show_info")
    public String newerShowInfo;

    @SerializedName("once")
    public int once;

    @SerializedName("posterUrl")
    public String posterUrl;

    @SerializedName("recommend")
    public String recommend;

    @SerializedName("recommend_api")
    public String recommendApi;

    @SerializedName("recommend_uri")
    public String recommendUri;

    @SerializedName("rock_api")
    public String rockApi;

    @SerializedName("rock_finder")
    public String rockFinder;

    @SerializedName("route")
    public String route;

    @SerializedName(e01.I3)
    public int show;

    @SerializedName("show_count")
    public int showCount;

    @SerializedName("show_cover")
    public int showCover;

    @SerializedName("show_info")
    public String showInfo;

    @SerializedName("tags")
    public String tags;

    @SerializedName("three_layout")
    public String threeLayout;

    @SerializedName("style__append_hide_title")
    public String titleStyle;

    @SerializedName("try_sec")
    public int trySeconds;

    @SerializedName("type")
    public String type;

    @SerializedName("uncloseable")
    public int uncloseable;

    @SerializedName("up_id")
    public String upId;

    @SerializedName("url")
    public String url;

    @SerializedName("v")
    public String version;

    @SerializedName("videoUrl")
    public String videoUrls;

    @SerializedName("view_url")
    public String viewUrl;

    @SerializedName("is_vip")
    public int isVip = -1;

    @SerializedName("show_start")
    public int showStart = -1;

    @SerializedName("exchange")
    public int exchange = -1;

    public static class Buttons implements Serializable {

        @SerializedName(TTDownloadField.TT_LABEL)
        public String label;

        @SerializedName("url")
        public String url;

        @NonNull
        public String toString() {
            return "Buttons{url=" + this.url + ",label=" + this.label + l.d;
        }
    }

    public boolean hasDiversionInfo() {
        if (this.diversionOnlyMiui == 1 && !lp2.H()) {
            return false;
        }
        if (!TextUtils.isEmpty(this.diversionShieldPhone)) {
            String str = Build.MODEL;
            if (!TextUtils.isEmpty(str) && Arrays.binarySearch(this.diversionShieldPhone.split(","), str) > -1) {
                return false;
            }
        }
        return (TextUtils.isEmpty(this.diversionAppUrl) && TextUtils.isEmpty(this.diversionH5Url)) ? false : true;
    }

    public String toString() {
        return "Extend{banner_ratio = '" + this.bannerRatio + "',type = '" + this.type + "',act_type = '" + this.actionType + "',style__append_hide_title = '" + this.titleStyle + "',style__append_hide_footer = '" + this.footStyle + "',is_vip= '" + this.isVip + "',showVertical = '" + this.listType + "',is_title_center = '" + this.centerTitle + "',recommend = '" + this.recommend + "',animation = '" + this.animation + "',images = '" + this.images + "',tags = '" + this.tags + "',show = '" + this.show + "',once = '" + this.once + "',gift_code = '" + this.gift_code + "',layer_key = '" + this.layer_key + "',layerStyle = '" + this.layerStyle + "',book_info = '" + this.bookInfo + "',show_info = '" + this.showInfo + "',up_id = '" + this.upId + "', threeLayout = '" + this.threeLayout + "', countdown = '" + this.countdown + "', lessOneDay = '" + this.lessOneDay + "', route='" + this.route + "', v='" + this.version + "', exchange='" + this.exchange + "', buttons='" + this.buttons + "', rock_api='" + this.rockApi + "', data_source='" + this.dataSource + "', module='" + this.module + "', videoUrl='" + this.videoUrls + "', posterUrl='" + this.posterUrl + "', view_url='" + this.viewUrl + "', more_text='" + this.moreText + "', style__append_more_text='" + this.moreText + "', view_url='" + this.viewUrl + "', appointInfo='" + this.appointInfo + '\'' + l.d;
    }
}
