package com.duokan.reader.ui.store.data.favite;

import com.duokan.free.tts.service.e;
import com.duokan.reader.ui.store.data.cms.Categorie;
import com.google.gson.annotations.SerializedName;
import com.yuewen.gg1;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class RecommendBean implements Serializable {
    public static final int FICTION = 1;
    private int count;
    private List<Items> items;
    private int mShowViewCount;
    private boolean more;
    private String msg;
    private int result;
    private String traceId;

    public static class Items implements Serializable {
        private int ad;
        private int ad_duration;
        private int ad_time;

        @SerializedName("allow_discount")
        private String allowDiscount;
        private int allow_free_read;
        private List<Integer> auth_device;
        private List<Integer> author_ids;
        private String authors;
        private List<Categorie> categories;
        private List<Integer> channel;

        @SerializedName(gg1.a.InterfaceC0618a.f11552b)
        public int chapterCount;
        private long click;
        private int comment_count;
        private String copyright;
        private String cover;
        private List<String> dkfree_new_tags;

        @SerializedName(e.c.f3725a)
        public int fictionId;
        private int fiction_level;
        private boolean finish;
        private boolean free_chapter;
        private int has_ad;
        private long hot;
        private String latest;
        private long latest_created;
        private int latest_id;
        private int level;
        private boolean mExposure;
        private int mItemType = 1;
        private double new_score;
        private boolean on_sale;
        private String outer_id;
        private int owner;
        private int price;
        private int publish_to_free;

        @SerializedName("qmss_read")
        public int qmssRead;

        @SerializedName("qmss_score")
        public double qmssScore;
        private long qmss_final_score;
        private int qmss_popular;

        @SerializedName("read_7d")
        public int read7d;
        private int rec_location;
        private int rec_score;
        private String rec_traceId;
        private String rights;
        private int rights_id;
        private float score;
        private int score_count;
        private int subscribe_discount;
        private String summary;
        private List<String> tags;
        private String title;
        private int tts;
        private long updated;
        private int vip_status;

        @SerializedName("word_count")
        public int wordCount;

        public int getAd() {
            return this.ad;
        }

        public int getAd_duration() {
            return this.ad_duration;
        }

        public int getAd_time() {
            return this.ad_time;
        }

        public String getAllowDiscount() {
            return this.allowDiscount;
        }

        public int getAllow_free_read() {
            return this.allow_free_read;
        }

        public List<Integer> getAuth_device() {
            return this.auth_device;
        }

        public List<Integer> getAuthor_ids() {
            return this.author_ids;
        }

        public String getAuthors() {
            return this.authors;
        }

        public List<Categorie> getCategories() {
            return this.categories;
        }

        public List<Integer> getChannel() {
            return this.channel;
        }

        public int getChapterCount() {
            return this.chapterCount;
        }

        public long getClick() {
            return this.click;
        }

        public int getComment_count() {
            return this.comment_count;
        }

        public String getCopyright() {
            return this.copyright;
        }

        public String getCover() {
            return this.cover;
        }

        public List<String> getDkfree_new_tags() {
            return this.dkfree_new_tags;
        }

        public int getFictionId() {
            return this.fictionId;
        }

        public int getFiction_level() {
            return this.fiction_level;
        }

        public boolean getFinish() {
            return this.finish;
        }

        public boolean getFree_chapter() {
            return this.free_chapter;
        }

        public int getHas_ad() {
            return this.has_ad;
        }

        public long getHot() {
            return this.hot;
        }

        public int getItemType() {
            return this.mItemType;
        }

        public String getLatest() {
            return this.latest;
        }

        public long getLatest_created() {
            return this.latest_created;
        }

        public int getLatest_id() {
            return this.latest_id;
        }

        public int getLevel() {
            return this.level;
        }

        public double getNew_score() {
            return this.new_score;
        }

        public boolean getOn_sale() {
            return this.on_sale;
        }

        public String getOuter_id() {
            return this.outer_id;
        }

        public int getOwner() {
            return this.owner;
        }

        public int getPrice() {
            return this.price;
        }

        public int getPublish_to_free() {
            return this.publish_to_free;
        }

        public int getQmssRead() {
            return this.qmssRead;
        }

        public double getQmssScore() {
            return this.qmssScore;
        }

        public long getQmss_final_score() {
            return this.qmss_final_score;
        }

        public int getQmss_popular() {
            return this.qmss_popular;
        }

        public int getRead7d() {
            return this.read7d;
        }

        public int getRec_location() {
            return this.rec_location;
        }

        public int getRec_score() {
            return this.rec_score;
        }

        public String getRec_traceId() {
            return this.rec_traceId;
        }

        public String getRights() {
            return this.rights;
        }

        public int getRights_id() {
            return this.rights_id;
        }

        public float getScore() {
            return this.score;
        }

        public int getScore_count() {
            return this.score_count;
        }

        public int getSubscribe_discount() {
            return this.subscribe_discount;
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

        public int getTts() {
            return this.tts;
        }

        public long getUpdated() {
            return this.updated;
        }

        public int getVip_status() {
            return this.vip_status;
        }

        public int getWordCount() {
            return this.wordCount;
        }

        public boolean isExposure() {
            return this.mExposure;
        }

        public boolean isFinish() {
            return this.finish;
        }

        public void setAd(int i) {
            this.ad = i;
        }

        public void setAd_duration(int i) {
            this.ad_duration = i;
        }

        public void setAd_time(int i) {
            this.ad_time = i;
        }

        public void setAllowDiscount(String str) {
            this.allowDiscount = str;
        }

        public void setAllow_free_read(int i) {
            this.allow_free_read = i;
        }

        public void setAuth_device(List<Integer> list) {
            this.auth_device = list;
        }

        public void setAuthor_ids(List<Integer> list) {
            this.author_ids = list;
        }

        public void setAuthors(String str) {
            this.authors = str;
        }

        public void setCategories(List<Categorie> list) {
            this.categories = list;
        }

        public void setChannel(List<Integer> list) {
            this.channel = list;
        }

        public void setChapterCount(int i) {
            this.chapterCount = i;
        }

        public void setClick(long j) {
            this.click = j;
        }

        public void setComment_count(int i) {
            this.comment_count = i;
        }

        public void setCopyright(String str) {
            this.copyright = str;
        }

        public void setCover(String str) {
            this.cover = str;
        }

        public void setDkfree_new_tags(List<String> list) {
            this.dkfree_new_tags = list;
        }

        public void setExposure(boolean z) {
            this.mExposure = z;
        }

        public void setFictionId(int i) {
            this.fictionId = i;
        }

        public void setFiction_level(int i) {
            this.fiction_level = i;
        }

        public void setFinish(boolean z) {
            this.finish = z;
        }

        public void setFree_chapter(boolean z) {
            this.free_chapter = z;
        }

        public void setHas_ad(int i) {
            this.has_ad = i;
        }

        public void setHot(long j) {
            this.hot = j;
        }

        public void setItemType(int i) {
            this.mItemType = i;
        }

        public void setLatest(String str) {
            this.latest = str;
        }

        public void setLatest_created(long j) {
            this.latest_created = j;
        }

        public void setLatest_id(int i) {
            this.latest_id = i;
        }

        public void setLevel(int i) {
            this.level = i;
        }

        public void setNew_score(double d) {
            this.new_score = d;
        }

        public void setOn_sale(boolean z) {
            this.on_sale = z;
        }

        public void setOuter_id(String str) {
            this.outer_id = str;
        }

        public void setOwner(int i) {
            this.owner = i;
        }

        public void setPrice(int i) {
            this.price = i;
        }

        public void setPublish_to_free(int i) {
            this.publish_to_free = i;
        }

        public void setQmssRead(int i) {
            this.qmssRead = i;
        }

        public void setQmssScore(double d) {
            this.qmssScore = d;
        }

        public void setQmss_final_score(long j) {
            this.qmss_final_score = j;
        }

        public void setQmss_popular(int i) {
            this.qmss_popular = i;
        }

        public void setRead7d(int i) {
            this.read7d = i;
        }

        public void setRec_location(int i) {
            this.rec_location = i;
        }

        public void setRec_score(int i) {
            this.rec_score = i;
        }

        public void setRec_traceId(String str) {
            this.rec_traceId = str;
        }

        public void setRights(String str) {
            this.rights = str;
        }

        public void setRights_id(int i) {
            this.rights_id = i;
        }

        public void setScore(float f) {
            this.score = f;
        }

        public void setScore_count(int i) {
            this.score_count = i;
        }

        public void setSubscribe_discount(int i) {
            this.subscribe_discount = i;
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

        public void setTts(int i) {
            this.tts = i;
        }

        public void setUpdated(long j) {
            this.updated = j;
        }

        public void setVip_status(int i) {
            this.vip_status = i;
        }

        public void setWordCount(int i) {
            this.wordCount = i;
        }
    }

    public int getCount() {
        return this.count;
    }

    public List<Items> getItems() {
        return this.items;
    }

    public boolean getMore() {
        return this.more;
    }

    public String getMsg() {
        return this.msg;
    }

    public int getResult() {
        return this.result;
    }

    public int getShowViewCount() {
        return this.mShowViewCount;
    }

    public String getTraceId() {
        return this.traceId;
    }

    public void setCount(int i) {
        this.count = i;
    }

    public void setItems(List<Items> list) {
        this.items = list;
    }

    public void setMore(boolean z) {
        this.more = z;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setResult(int i) {
        this.result = i;
    }

    public void setShowViewCount(int i) {
        this.mShowViewCount = i;
    }

    public void setTraceId(String str) {
        this.traceId = str;
    }
}
