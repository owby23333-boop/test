package com.duokan.ad.video.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public class VideoAdBean implements Serializable {
    private final String Tag = "VideoAdBean";

    @SerializedName("btn_deeplink")
    private String btnDeeplink;
    private String category;
    private String deeplink;
    private String desc;

    @SerializedName("episode_num")
    private int episodeNum;
    private String focus;
    private String id;

    @SerializedName("info_cp")
    private String infoCp;
    private Item item;
    private String name;

    @SerializedName("poster_sh")
    private String posterSh;

    @SerializedName("poster_sv")
    private String posterSv;

    @SerializedName("purchase_type")
    private int purchaseType;

    @SerializedName("subscribe_flag")
    private boolean subscribeFlag;
    private Map<String, ArrayList<String>> tag;

    public class Item implements Serializable {
        private String desc;
        private int highLight;

        @SerializedName("high_play_url")
        private String highPlayUrl;
        private String id;
        private String name;

        @SerializedName("play_len")
        private int playLen;

        public Item() {
        }

        public String getDesc() {
            return this.desc;
        }

        public int getHighLight() {
            return this.highLight;
        }

        public String getHighPlayUrl() {
            return this.highPlayUrl;
        }

        public String getId() {
            return this.id;
        }

        public String getName() {
            return this.name;
        }

        public int getPlayLen() {
            return this.playLen;
        }

        public void setDesc(String str) {
            this.desc = str;
        }

        public void setHighLight(int i) {
            this.highLight = i;
        }

        public void setHighPlayUrl(String str) {
            this.highPlayUrl = str;
        }

        public void setId(String str) {
            this.id = str;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setPlayLen(int i) {
            this.playLen = i;
        }
    }

    public String getBtnDeeplink() {
        return this.btnDeeplink;
    }

    public String getCategory() {
        return this.category;
    }

    public String getDeeplink() {
        return this.deeplink;
    }

    public String getDesc() {
        return this.desc;
    }

    public int getEpisodeNum() {
        return this.episodeNum;
    }

    public String getFocus() {
        return this.focus;
    }

    public String getId() {
        return this.id;
    }

    public String getInfoCp() {
        return this.infoCp;
    }

    public Item getItem() {
        return this.item;
    }

    public String getName() {
        return this.name;
    }

    public String getPosterSh() {
        return this.posterSh;
    }

    public String getPosterSv() {
        return this.posterSv;
    }

    public int getPurchaseType() {
        return this.purchaseType;
    }

    public String getTag() {
        return "VideoAdBean";
    }

    public boolean isSubscribeFlag() {
        return this.subscribeFlag;
    }

    public void setBtnDeeplink(String str) {
        this.btnDeeplink = str;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public void setDeeplink(String str) {
        this.deeplink = str;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setEpisodeNum(int i) {
        this.episodeNum = i;
    }

    public void setFocus(String str) {
        this.focus = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setInfoCp(String str) {
        this.infoCp = str;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPosterSh(String str) {
        this.posterSh = str;
    }

    public void setPosterSv(String str) {
        this.posterSv = str;
    }

    public void setPurchaseType(int i) {
        this.purchaseType = i;
    }

    public void setSubscribeFlag(boolean z) {
        this.subscribeFlag = z;
    }

    public void setTag(Map<String, ArrayList<String>> map) {
        this.tag = map;
    }

    public String toString() {
        return "VideoAdBean{Tag='VideoAdBean', id='" + this.id + "', category='" + this.category + "', purchaseType=" + this.purchaseType + ", infoCp='" + this.infoCp + "', name='" + this.name + "', focus='" + this.focus + "', desc='" + this.desc + "', posterSh='" + this.posterSh + "', posterSv='" + this.posterSv + "', tag=" + this.tag + ", item=" + this.item + ", subscribeFlag=" + this.subscribeFlag + ", episodeNum=" + this.episodeNum + ", deeplink='" + this.deeplink + "', btnDeeplink='" + this.btnDeeplink + "'}";
    }
}
