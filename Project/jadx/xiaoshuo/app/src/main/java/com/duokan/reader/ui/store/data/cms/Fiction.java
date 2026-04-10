package com.duokan.reader.ui.store.data.cms;

import com.alipay.sdk.m.y.l;
import com.duokan.core.io.a;
import com.duokan.free.tts.service.e;
import com.google.gson.annotations.SerializedName;
import com.xiaomi.onetrack.b.a;
import com.yuewen.gg1;
import com.yuewen.h8;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class Fiction extends Data {

    @SerializedName("ad")
    public int ad;

    @SerializedName("ad_duration")
    public int adDuration;

    @SerializedName("ad_time")
    public long adTime;

    @SerializedName("allow_discount")
    public String allowDiscount;

    @SerializedName("allow_free_read")
    public int allowFreeRead;

    @SerializedName("auth_device")
    public List<Integer> authDevice;

    @SerializedName("author_ids")
    public List<Integer> authorIds;

    @SerializedName("authors")
    public String authors;

    @SerializedName("categories")
    public List<Categorie> categories;

    @SerializedName(gg1.a.InterfaceC0618a.f11552b)
    public int chapterCount;

    @SerializedName("click")
    public int click;

    @SerializedName("comment_count")
    public int commentCount;

    @SerializedName("content")
    public String content;

    @SerializedName("copyright")
    public String copyright;

    @SerializedName("cover")
    public String cover;

    @SerializedName("dkfree_new_tags")
    public List<String> dkfreeNewTags;

    @SerializedName("ex")
    public int ex;

    @SerializedName("rec_extra")
    public String extra;

    @SerializedName("extra_tag")
    public ExtraTag extraTag;

    @SerializedName("extra_url")
    public String extraUrl;

    @SerializedName(e.c.f3725a)
    public String fictionId;

    @SerializedName("fiction_level")
    public String fictionLevel;

    @SerializedName("finish")
    public boolean finish;

    @SerializedName("free_chapter")
    public boolean freeChapter;

    @SerializedName("has_ad")
    public int hasAd;

    @SerializedName("hot")
    public int hot;

    @SerializedName("latest")
    public String latest;

    @SerializedName("latest_created")
    public long latestCreated;

    @SerializedName(gg1.a.InterfaceC0618a.g)
    public int latestId;

    @SerializedName(a.d)
    public int level;

    @SerializedName("limited_time")
    public long limitedTime;

    @SerializedName("new_score")
    public double newScore;

    @SerializedName("new_tags")
    public List<String> newTags;

    @SerializedName("on_sale")
    public boolean onSale;

    @SerializedName("outer_id")
    public String outerId;

    @SerializedName(a.C0200a.C0201a.g)
    public int owner;

    @SerializedName("price")
    public int price;

    @SerializedName("qmss_final_score")
    public long qmssFinalScore;

    @SerializedName("qmss_popular")
    public int qmssPopular;

    @SerializedName("qmss_read")
    public int qmssRead;

    @SerializedName("qmss_score")
    public double qmssScore;

    @SerializedName("read_7d")
    public int read7d;

    @SerializedName("real_extra")
    public String realExtra;

    @SerializedName(h8.d)
    public String reason;

    @SerializedName("rec_reason")
    public String recReason;

    @SerializedName("rec_score")
    public double recScore;

    @SerializedName("rec_traceId")
    public String recTraceId;

    @SerializedName("rec_words")
    public String recWords;

    @SerializedName(gg1.a.InterfaceC0618a.h)
    public String rights;

    @SerializedName(gg1.a.InterfaceC0618a.i)
    public int rightsId;

    @SerializedName("score")
    public double score;

    @SerializedName("score_count")
    public int scoreCount;

    @SerializedName("started")
    public long started;

    @SerializedName("subscribe_discount")
    public int subscribeDiscount;

    @SerializedName("summary")
    public String summary;

    @SerializedName("tags")
    public List<String> tags;

    @SerializedName("ti")
    public String ti;

    @SerializedName("title")
    public String title;

    @SerializedName("trace_id")
    public String traceId;

    @SerializedName("tts")
    public int tts;

    @SerializedName("updated")
    public long updated;

    @SerializedName("vip_end")
    public long vipEnd;

    @SerializedName("vip_status")
    public int vipStatus;

    @SerializedName("word_count")
    public int wordCount;

    public int getAd() {
        return this.ad;
    }

    public int getAdDuration() {
        return this.adDuration;
    }

    public long getAdTime() {
        return this.adTime;
    }

    public String getAllowDiscount() {
        return this.allowDiscount;
    }

    public int getAllowFreeRead() {
        return this.allowFreeRead;
    }

    public List<Integer> getAuthDevice() {
        return this.authDevice;
    }

    public List<Integer> getAuthorIds() {
        return this.authorIds;
    }

    public String getAuthors() {
        return this.authors;
    }

    public List<Categorie> getCategories() {
        return this.categories;
    }

    public int getChapterCount() {
        return this.chapterCount;
    }

    public int getClick() {
        return this.click;
    }

    public int getCommentCount() {
        return this.commentCount;
    }

    public String getCopyright() {
        return this.copyright;
    }

    public String getCover() {
        return this.cover;
    }

    public List<String> getDkfreeNewTags() {
        return this.dkfreeNewTags;
    }

    public int getEx() {
        return this.ex;
    }

    public String getFictionId() {
        return this.fictionId;
    }

    public int getHasAd() {
        return this.hasAd;
    }

    public int getHot() {
        return this.hot;
    }

    public String getLatest() {
        return this.latest;
    }

    public long getLatestCreated() {
        return this.latestCreated;
    }

    public int getLatestId() {
        return this.latestId;
    }

    public int getLevel() {
        return this.level;
    }

    public long getLimitedTime() {
        return this.limitedTime;
    }

    public List<String> getNewTags() {
        return this.newTags;
    }

    public String getOuterId() {
        return this.outerId;
    }

    public int getOwner() {
        return this.owner;
    }

    public int getPrice() {
        return this.price;
    }

    public long getQmssFinalScore() {
        return this.qmssFinalScore;
    }

    public int getQmssPopular() {
        return this.qmssPopular;
    }

    public int getQmssRead() {
        return this.qmssRead;
    }

    public double getQmssScore() {
        return this.qmssScore;
    }

    public int getRead7d() {
        return this.read7d;
    }

    public String getReason() {
        return this.reason;
    }

    public String getRecReason() {
        return this.recReason;
    }

    public double getRecScore() {
        return this.recScore;
    }

    public String getRecTraceId() {
        return this.recTraceId;
    }

    public String getRights() {
        return this.rights;
    }

    public int getRightsId() {
        return this.rightsId;
    }

    public double getScore() {
        return this.score;
    }

    public int getScoreCount() {
        return this.scoreCount;
    }

    public int getSubscribeDiscount() {
        return this.subscribeDiscount;
    }

    public String getSummary() {
        return this.summary;
    }

    public List<String> getTags() {
        return this.tags;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public int getTts() {
        return this.tts;
    }

    public long getUpdated() {
        return this.updated;
    }

    public long getVipEnd() {
        return this.vipEnd;
    }

    public int getVipStatus() {
        return this.vipStatus;
    }

    public long getWordCount() {
        return this.wordCount;
    }

    public boolean isFinish() {
        return this.finish;
    }

    public boolean isFreeChapter() {
        return this.freeChapter;
    }

    public boolean isOnSale() {
        return this.onSale;
    }

    public void setAd(int i) {
        this.ad = i;
    }

    public void setAdDuration(int i) {
        this.adDuration = i;
    }

    public void setAdTime(long j) {
        this.adTime = j;
    }

    public void setAllowDiscount(String str) {
        this.allowDiscount = str;
    }

    public void setAllowFreeRead(int i) {
        this.allowFreeRead = i;
    }

    public void setAuthDevice(List<Integer> list) {
        this.authDevice = list;
    }

    public void setAuthorIds(List<Integer> list) {
        this.authorIds = list;
    }

    public void setAuthors(String str) {
        this.authors = str;
    }

    public void setCategories(List<Categorie> list) {
        this.categories = list;
    }

    public void setChapterCount(int i) {
        this.chapterCount = i;
    }

    public void setClick(int i) {
        this.click = i;
    }

    public void setCommentCount(int i) {
        this.commentCount = i;
    }

    public void setCopyright(String str) {
        this.copyright = str;
    }

    public void setCover(String str) {
        this.cover = str;
    }

    public void setDkfreeNewTags(List<String> list) {
        this.dkfreeNewTags = list;
    }

    public void setEx(int i) {
        this.ex = i;
    }

    public void setFictionId(String str) {
        this.fictionId = str;
    }

    public void setFinish(boolean z) {
        this.finish = z;
    }

    public void setFreeChapter(boolean z) {
        this.freeChapter = z;
    }

    public void setHasAd(int i) {
        this.hasAd = i;
    }

    public void setHot(int i) {
        this.hot = i;
    }

    public void setLatest(String str) {
        this.latest = str;
    }

    public void setLatestCreated(long j) {
        this.latestCreated = j;
    }

    public void setLatestId(int i) {
        this.latestId = i;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    public void setLimitedTime(long j) {
        this.limitedTime = j;
    }

    public void setNewTags(List<String> list) {
        this.newTags = list;
    }

    public void setOnSale(boolean z) {
        this.onSale = z;
    }

    public void setOuterId(String str) {
        this.outerId = str;
    }

    public void setOwner(int i) {
        this.owner = i;
    }

    public void setPrice(int i) {
        this.price = i;
    }

    public void setQmssFinalScore(long j) {
        this.qmssFinalScore = j;
    }

    public void setQmssPopular(int i) {
        this.qmssPopular = i;
    }

    public void setQmssRead(int i) {
        this.qmssRead = i;
    }

    public void setQmssScore(double d) {
        this.qmssScore = d;
    }

    public void setRead7d(int i) {
        this.read7d = i;
    }

    public void setReason(String str) {
        this.reason = str;
    }

    public void setRecReason(String str) {
        this.recReason = str;
    }

    public void setRecScore(double d) {
        this.recScore = d;
    }

    public void setRecTraceId(String str) {
        this.recTraceId = str;
    }

    public void setRights(String str) {
        this.rights = str;
    }

    public void setRightsId(int i) {
        this.rightsId = i;
    }

    public void setScore(double d) {
        this.score = d;
    }

    public void setScoreCount(int i) {
        this.scoreCount = i;
    }

    public void setSubscribeDiscount(int i) {
        this.subscribeDiscount = i;
    }

    public void setSummary(String str) {
        this.summary = str;
    }

    public void setTags(List<String> list) {
        this.tags = list;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTraceId(String str) {
        this.traceId = str;
    }

    public void setTts(int i) {
        this.tts = i;
    }

    public void setUpdated(long j) {
        this.updated = j;
    }

    public void setVipEnd(long j) {
        this.vipEnd = j;
    }

    public void setVipStatus(int i) {
        this.vipStatus = i;
    }

    public void setWordCount(int i) {
        this.wordCount = i;
    }

    public boolean supportTts() {
        return this.tts == 1;
    }

    public String toString() {
        return "Fiction{new_tags = '" + this.newTags + "',comment_count = '" + this.commentCount + "',reason = '" + this.reason + "',copyright = '" + this.copyright + "',rights_id = '" + this.rightsId + "',allow_discount = '" + this.allowDiscount + "',score_count = '" + this.scoreCount + "',qmss_popular = '" + this.qmssPopular + "',title = '" + this.title + "',hot = '" + this.hot + "',author_ids = '" + this.authorIds + "',outer_id = '" + this.outerId + "',qmss_score = '" + this.qmssScore + "',new_score = '" + this.newScore + "',free_chapter = '" + this.freeChapter + "',cover = '" + this.cover + "',score = '" + this.score + "',word_count = '" + this.wordCount + "',price = '" + this.price + "',qmss_read = '" + this.qmssRead + "',subscribe_discount = '" + this.subscribeDiscount + "',rights = '" + this.rights + "',finish = '" + this.finish + "',categories = '" + this.categories + "',auth_device = '" + this.authDevice + "',on_sale = '" + this.onSale + "',chapter_count = '" + this.chapterCount + "',fiction_id = '" + this.fictionId + "',latest = '" + this.latest + "',owner = '" + this.owner + "',summary = '" + this.summary + "',trace_id = '" + this.traceId + "',ad = '" + this.ad + "',level = '" + this.level + "',allow_free_read = '" + this.allowFreeRead + "',has_ad = '" + this.hasAd + "',click = '" + this.click + "',tags = '" + this.tags + "',ad_duration = '" + this.adDuration + "',latest_id = '" + this.latestId + "',vip_status = '" + this.vipStatus + "',ad_time = '" + this.adTime + "',updated = '" + this.updated + "',latest_created = '" + this.latestCreated + "',authors = '" + this.authors + "',vipEnd = '" + this.vipEnd + "',limitedTime = '" + this.limitedTime + "',dkfreeNewTags = '" + this.dkfreeNewTags + "',ex = '" + this.ex + "',read7d = '" + this.read7d + "',recTraceId = '" + this.recTraceId + "'extra = '" + this.extra + "'realExtra = '" + this.realExtra + '\'' + l.d;
    }
}
