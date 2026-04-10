package com.duokan.reader.ui.store.data.cms;

import com.alipay.sdk.m.y.l;
import com.duokan.core.io.a;
import com.google.gson.annotations.SerializedName;
import com.yuewen.gg1;
import com.yuewen.zu0;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class ComicBook extends Data implements Serializable {

    @SerializedName("allow_anon_try")
    public int allowAnonTry;

    @SerializedName("allow_discount")
    public String allowDiscount;

    @SerializedName("allow_free_read")
    public int allowFreeRead;

    @SerializedName("audio_id")
    public int audioId;

    @SerializedName("authors")
    public String authors;

    @SerializedName("background")
    public String background;

    @SerializedName("book_cover")
    public String bookCover;

    @SerializedName("categories")
    public List<Categorie> categories;

    @SerializedName(gg1.a.InterfaceC0618a.f11552b)
    public int chapterCount;

    @SerializedName("chapter_price")
    public int chapterPrice;

    @SerializedName("charge_mode")
    public int chargeMode;

    @SerializedName("click")
    public int click;

    @SerializedName("comic_id")
    public String comic_id;

    @SerializedName("comment_count")
    public int commentCount;

    @SerializedName("content")
    public String content;

    @SerializedName("cover")
    public String cover;

    @SerializedName("cover_big")
    public String cover_big;

    @SerializedName("duration")
    public int duration;

    @SerializedName("encrypt")
    public int encrypt;
    public Extend extend;

    @SerializedName("extra_tag")
    public ExtraTag extraTag;

    @SerializedName("finish")
    public boolean finish;

    @SerializedName("first_categories")
    public List<Categorie> firstCategories;

    @SerializedName("free_count")
    public int freeCount;

    @SerializedName("has_ad")
    public String hasAd;

    @SerializedName("hot")
    public int hot;

    @SerializedName("item_id")
    public String itemId;

    @SerializedName("latest")
    public String latest;

    @SerializedName(gg1.a.InterfaceC0618a.g)
    public int latestId;

    @SerializedName("listener_count")
    public int listenerCount;

    @SerializedName("on_sale")
    public boolean onSale;

    @SerializedName("outer_id")
    public String outerId;

    @SerializedName(a.C0200a.C0201a.g)
    public int owner;

    @SerializedName("platforms")
    public String platforms;

    @SerializedName("play_count")
    public int playCount;

    @SerializedName("qmss_popular")
    public int qmssPopular;

    @SerializedName(gg1.a.InterfaceC0618a.h)
    public String rights;

    @SerializedName(gg1.a.InterfaceC0618a.i)
    public int rightsId;

    @SerializedName("score")
    public Float score;

    @SerializedName("score_count")
    public int scoreCount;

    @SerializedName("speaker")
    public String speaker;

    @SerializedName("special")
    public String special;

    @SerializedName("summary")
    public String summary;

    @SerializedName("title")
    public String title;

    @SerializedName("trace_id")
    public String traceId;

    @SerializedName("updated")
    public int updated;

    @SerializedName("vip_status")
    public int vipStatus;

    public boolean isAudio() {
        int i = this.audioId;
        return ((long) i) >= zu0.r && ((long) i) < zu0.s;
    }

    public boolean isQuality() {
        if (this.chargeMode == 0 || !isAudio()) {
            return false;
        }
        Iterator<Categorie> it = this.categories.iterator();
        while (it.hasNext()) {
            int i = it.next().categoryId;
            if (i == 10000 || i == 40000) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "ComicBook{comic_id = '" + this.comic_id + "'comment_count = '" + this.commentCount + "',rights_id = '" + this.rightsId + "',allow_discount = '" + this.allowDiscount + "',book_cover = '" + this.bookCover + "',score_count = '" + this.scoreCount + "',title = '" + this.title + "',hot = '" + this.hot + "',outer_id = '" + this.outerId + "',audio_id = '" + this.audioId + "',platforms = '" + this.platforms + "',free_count = '" + this.freeCount + "',duration = '" + this.duration + "',cover = '" + this.cover + "',score = '" + this.score + "',encrypt = '" + this.encrypt + "',rights = '" + this.rights + "',finish = '" + this.finish + "',categories = '" + this.categories + "',on_sale = '" + this.onSale + "',chapter_count = '" + this.chapterCount + "',latest = '" + this.latest + "',owner = '" + this.owner + "',summary = '" + this.summary + "',item_id = '" + this.itemId + "',allow_anon_try = '" + this.allowAnonTry + "',allow_free_read = '" + this.allowFreeRead + "',first_categories = '" + this.firstCategories + "',charge_mode = '" + this.chargeMode + "',has_ad = '" + this.hasAd + "',play_count = '" + this.playCount + "',chapter_price = '" + this.chapterPrice + "',click = '" + this.click + "',latest_id = '" + this.latestId + "',background = '" + this.background + "',speaker = '" + this.speaker + "',vip_status = '" + this.vipStatus + "',listener_count = '" + this.listenerCount + "',updated = '" + this.updated + "',authors = '" + this.authors + "',special = '" + this.special + "',cover_big = '" + this.cover_big + '\'' + l.d;
    }
}
