package com.duokan.reader.ui.store.data.cms;

import android.text.TextUtils;
import com.alipay.sdk.m.y.l;
import com.duokan.reader.domain.payment.a;
import com.google.gson.annotations.SerializedName;
import com.yuewen.lp2;
import com.yuewen.qe0;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes5.dex */
public class Advertisement extends Data implements Serializable {

    @SerializedName(qe0.b.g)
    public String adId;

    @SerializedName("banner")
    public String bannerUrl;
    public AudioBook book;

    @SerializedName("config")
    public Config config;

    @SerializedName("data")
    public DataInfo dataInfo;

    @SerializedName("desc")
    public String desc;

    @SerializedName("extend")
    public Extend extend;

    @SerializedName("id")
    public String id;

    @SerializedName("parent")
    public String parent;

    @SerializedName("sub_title")
    public String subTitle;

    @SerializedName("title")
    public String title;

    @SerializedName("track")
    public String track;

    @SerializedName("type")
    public int type;

    public String getActionType() {
        Extend extend = this.extend;
        return (extend == null || TextUtils.isEmpty(extend.actionType)) ? "" : this.extend.actionType;
    }

    public int getAudioBookPlayCount() {
        List<? extends Data> list;
        DataInfo dataInfo = this.dataInfo;
        int i = 0;
        if (dataInfo != null && (list = dataInfo.datas) != null) {
            for (Data data : list) {
                if (data instanceof AudioBook) {
                    i += ((AudioBook) data).playCount;
                }
            }
        }
        return i;
    }

    public int getBookListType() {
        Extend extend = this.extend;
        if (extend != null) {
            return extend.listType;
        }
        return -1;
    }

    public long getCloseDelay() {
        Extend extend = this.extend;
        if (extend != null) {
            return extend.closeDelay;
        }
        return 0L;
    }

    public String getDataSource() {
        Extend extend = this.extend;
        if (extend != null) {
            return extend.dataSource;
        }
        return null;
    }

    public String getExtendLayout() {
        Extend extend = this.extend;
        return (extend == null || TextUtils.isEmpty(extend.layout)) ? "" : this.extend.layout;
    }

    public String getExtendMaxDiscount() {
        Extend extend = this.extend;
        if (extend != null) {
            return extend.maxDiscountToShow;
        }
        return null;
    }

    public String getExtendType() {
        Extend extend = this.extend;
        return extend != null ? extend.type : "";
    }

    public String getImageLayoutType() {
        Extend extend = this.extend;
        return (extend == null || TextUtils.isEmpty(extend.actionType)) ? "" : this.extend.actionType;
    }

    public List<ImageInfo> getImages() {
        Extend extend = this.extend;
        if (extend == null || TextUtils.isEmpty(extend.images)) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(this.extend.images);
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add((ImageInfo) lp2.j(jSONArray.getJSONObject(i), ImageInfo.class));
            }
            return arrayList;
        } catch (Throwable unused) {
            return new ArrayList();
        }
    }

    public long getLimitEndTime() {
        Extend extend = this.extend;
        if (extend != null) {
            return extend.limitEndTime;
        }
        return 0L;
    }

    public String getMoreText() {
        Extend extend = this.extend;
        if (extend != null) {
            return extend.moreText;
        }
        return null;
    }

    public String getMoreType() {
        Extend extend = this.extend;
        if (extend != null) {
            return extend.moreType;
        }
        return null;
    }

    public String getMoreUrl() {
        Extend extend = this.extend;
        return extend != null ? extend.moreUrl : "";
    }

    public String getNewbieDefaultUrl() {
        Extend extend = this.extend;
        return extend != null ? extend.newbieDefaultUrl : "";
    }

    public String getNewbieSuccessUrl() {
        Extend extend = this.extend;
        return extend != null ? extend.newbieSuccessUrl : "";
    }

    public String getPageTrackInfo() {
        return this.adId + "_" + this.id;
    }

    public String getRecommendUri() {
        Extend extend = this.extend;
        if (extend != null) {
            return extend.recommendUri;
        }
        return null;
    }

    public int getShowCount() {
        Extend extend = this.extend;
        if (extend != null) {
            return extend.showCount;
        }
        return 0;
    }

    public int getShowCover() {
        Extend extend = this.extend;
        if (extend != null) {
            return extend.showCover;
        }
        return 0;
    }

    public String[] getShowInfoTypes() {
        Extend extend = this.extend;
        return extend != null ? !TextUtils.isEmpty(extend.showInfo) ? this.extend.showInfo.contains(",") ? this.extend.showInfo.split(",") : new String[]{this.extend.showInfo} : new String[0] : new String[0];
    }

    public List<TagInfo> getTags() {
        Extend extend = this.extend;
        if (extend == null || TextUtils.isEmpty(extend.tags)) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(this.extend.tags);
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add((TagInfo) lp2.j(jSONArray.getJSONObject(i), TagInfo.class));
            }
            return arrayList;
        } catch (Throwable unused) {
            return new ArrayList();
        }
    }

    public int getUncloseable() {
        Extend extend = this.extend;
        if (extend != null) {
            return extend.uncloseable;
        }
        return 0;
    }

    public String getUpId() {
        Extend extend = this.extend;
        return extend != null ? extend.upId : "";
    }

    public String getUrl() {
        Extend extend = this.extend;
        if (extend != null) {
            return extend.url;
        }
        return null;
    }

    public boolean hasData() {
        List<? extends Data> list;
        DataInfo dataInfo = this.dataInfo;
        return (dataInfo == null || (list = dataInfo.datas) == null || list.size() <= 0) ? false : true;
    }

    public boolean hasMoreData() {
        DataInfo dataInfo;
        return needDetail() || ((dataInfo = this.dataInfo) != null && dataInfo.count < dataInfo.total);
    }

    public boolean hideMore() {
        Extend extend = this.extend;
        if (extend != null) {
            return TextUtils.equals(extend.footStyle, "display: none");
        }
        return false;
    }

    public boolean needDetail() {
        Extend extend = this.extend;
        if (extend != null) {
            return "1".equals(extend.needDetail) || a.c.equalsIgnoreCase(this.extend.needDetail);
        }
        return false;
    }

    public boolean showTitle() {
        Extend extend = this.extend;
        return extend == null || !TextUtils.equals(extend.titleStyle, "display: none");
    }

    public String toString() {
        return "Advertisement{extend = '" + this.extend + "',ad_id = '" + this.adId + "',data = '" + this.dataInfo + "',bannerUrl = '" + this.bannerUrl + "',id = '" + this.id + "',title = '" + this.title + "',subTitle = '" + this.subTitle + "',track = '" + this.track + "',type = '" + this.type + "',config = '" + this.config + "',desc = '" + this.desc + '\'' + l.d;
    }
}
