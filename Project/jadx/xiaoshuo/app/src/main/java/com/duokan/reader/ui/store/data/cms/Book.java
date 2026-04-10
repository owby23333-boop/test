package com.duokan.reader.ui.store.data.cms;

import com.google.gson.annotations.SerializedName;
import com.iflytek.aikit.media.speech.SpeechConstant;
import com.yuewen.h8;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class Book extends Data {
    public static final int PRICE_DEF = -1;

    @SerializedName("ad")
    public int ad;

    @SerializedName("ad_duration")
    public int adDuration;

    @SerializedName("ad_level")
    public int adLevel;

    @SerializedName("ad_time")
    public long adTime;

    @SerializedName("afs")
    public String afs;

    @SerializedName("allow_free_read")
    public int allowFreeRead;

    @SerializedName("authors")
    public String authors;

    @SerializedName("book_id")
    public String bookId;

    @SerializedName("book_level")
    public int bookLevel;

    @SerializedName("categories")
    public List<PubCategory> categories;

    @SerializedName("category_name")
    public String categoryName;

    @SerializedName("classic_sentences")
    public String classicSentences;

    @SerializedName("comment_count")
    public int commentCount;

    @SerializedName("content")
    public String content;

    @SerializedName("cover")
    public String cover;

    @SerializedName("du")
    public String du;

    @SerializedName("editors")
    public String editors;

    @SerializedName("extra_tag")
    public ExtraTag extraTag;

    @SerializedName("has_ad")
    public int hasAd;

    @SerializedName("hot")
    public int hot;

    @SerializedName("limited_time")
    public long limitedTime;

    @SerializedName("main_tag")
    public String mainTag;

    @SerializedName("out_book_id")
    public String outBookId;

    @SerializedName("paper_price")
    public double paperPrice;

    @SerializedName("platforms")
    public String platforms;

    @SerializedName("qmss_popular")
    public int qmssPopular;

    @SerializedName("quality")
    public int quality;

    @SerializedName(h8.d)
    public String reason;

    @SerializedName("right_id")
    public int rightId;

    @SerializedName("score")
    public double score;

    @SerializedName("score_count")
    public int scoreCount;

    @SerializedName(SpeechConstant.IST_SESSION_ID)
    public int sid;

    @SerializedName("sp_end_time")
    public long spEndTime;

    @SerializedName("summary")
    public String summary;

    @SerializedName("title")
    public String title;

    @SerializedName("trace_id")
    public String traceId;

    @SerializedName("updated")
    public String updated;

    @SerializedName("vip_end")
    public long vipEnd;

    @SerializedName("vip_status")
    public int vipStatus;

    @SerializedName("webreader")
    public int webreader;

    @SerializedName("word_count")
    public long wordCount;

    @SerializedName("sp_end_price")
    public double spEndPrice = -1.0d;

    @SerializedName("price")
    public double price = -1.0d;

    @SerializedName("new_price")
    public double newPrice = -1.0d;

    public String toString() {
        return "Book{commentCount=" + this.commentCount + ", categoryName='" + this.categoryName + "', spEndPrice=" + this.spEndPrice + ", scoreCount=" + this.scoreCount + ", wordCount=" + this.wordCount + ", title='" + this.title + "', platforms='" + this.platforms + "', sid=" + this.sid + ", spEndTime=" + this.spEndTime + ", mainTag='" + this.mainTag + "', cover='" + this.cover + "', score=" + this.score + ", price=" + this.price + ", categories" + this.categories + ", adLevel=" + this.adLevel + ", webreader=" + this.webreader + ", limitedTime=" + this.limitedTime + ", editors='" + this.editors + "', summary='" + this.summary + "', ad=" + this.ad + ", allowFreeRead=" + this.allowFreeRead + ", newPrice=" + this.newPrice + ", bookId='" + this.bookId + "', hasAd=" + this.hasAd + ", quality=" + this.quality + ", afs='" + this.afs + "', adDuration=" + this.adDuration + ", vipStatus=" + this.vipStatus + ", adTime=" + this.adTime + ", paperPrice=" + this.paperPrice + ", updated='" + this.updated + "', authors='" + this.authors + "', vipEnd=" + this.vipEnd + ", du='" + this.du + "', reason='" + this.reason + "', qmssPopular='" + this.qmssPopular + "'}";
    }
}
