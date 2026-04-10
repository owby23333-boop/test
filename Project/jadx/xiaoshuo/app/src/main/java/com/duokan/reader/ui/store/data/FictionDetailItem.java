package com.duokan.reader.ui.store.data;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.duokan.free.tts.service.e;
import com.duokan.reader.ui.store.data.cms.Categorie;
import com.duokan.reader.ui.store.data.cms.Data;
import com.google.gson.annotations.SerializedName;
import com.yuewen.gg1;
import com.yuewen.oo;
import com.yuewen.p61;
import com.yuewen.w6;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public class FictionDetailItem extends Data {
    private Item item;
    private SimDetailBookItem mSimDetailBookItem;
    public int result;
    private int type;

    public static class Item extends Data {
        private String authors;

        @SerializedName("book_id")
        private String bookId;
        private List<Categorie> categories;

        @SerializedName(gg1.a.InterfaceC0618a.f11552b)
        private int chapterCount;
        private String content;
        private String cover;

        @SerializedName("dkfree_new_tags")
        private List<String> dkfreeNewTags;

        @SerializedName(e.c.f3725a)
        private String fictionId;
        private boolean finish;
        private w6 mAdInfo;
        private boolean mHasAd;
        private int mIndex;
        private SpannableStringBuilder mRecommendParagraph;

        @SerializedName("qmss_popular")
        private int qmssPopular;

        @SerializedName("qmss_score")
        private double qmssScore;
        private String rights;

        @SerializedName(gg1.a.InterfaceC0618a.i)
        private int rightsId;
        private double score;
        private String summary;
        private String title;
        private List<TocItem> toc;
        private long updated;

        @SerializedName("word_count")
        private long wordCount;

        public String getAuthors() {
            return this.authors;
        }

        public String getBookId() {
            return this.bookId;
        }

        public List<Categorie> getCategories() {
            List<Categorie> list = this.categories;
            return list == null ? Collections.EMPTY_LIST : list;
        }

        public int getChapterCount() {
            return this.chapterCount;
        }

        public w6 getCommonAdInfo() {
            return this.mAdInfo;
        }

        public String getContent() {
            return this.content;
        }

        public String getCover() {
            return this.cover;
        }

        public List<String> getDkfreeNewTags() {
            return this.dkfreeNewTags;
        }

        public String getFictionId() {
            return this.fictionId;
        }

        public String getFinishText(Context context) {
            return p61.b(context, this.finish);
        }

        public double getFixedScore() {
            return oo.c(this.rightsId, this.score, this.qmssScore);
        }

        public int getIndex() {
            return this.mIndex;
        }

        public int getQmssPopular() {
            return this.qmssPopular;
        }

        public double getQmssScore() {
            return this.qmssScore;
        }

        public SpannableStringBuilder getRecommendParagraph() {
            return this.mRecommendParagraph;
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

        public String getSummary() {
            return this.summary;
        }

        public String getTitle() {
            return this.title;
        }

        public List<TocItem> getToc() {
            return this.toc;
        }

        public long getUpdated() {
            return this.updated;
        }

        public long getWordCount() {
            return this.wordCount;
        }

        public String getWordCountText(Context context) {
            return p61.e(context, this.wordCount);
        }

        public boolean hasAd() {
            return this.mHasAd;
        }

        public boolean isFinish() {
            return this.finish;
        }

        public boolean isUiSame(Item item) {
            return item != null && TextUtils.equals(this.cover, item.cover) && TextUtils.equals(this.authors, item.authors) && TextUtils.equals(this.title, item.title) && TextUtils.equals(this.summary, item.summary) && this.qmssScore == item.qmssScore && this.qmssPopular == item.qmssPopular && this.wordCount == item.wordCount && this.finish == item.finish && Objects.equals(this.categories, item.categories);
        }

        public void setAuthors(String str) {
            this.authors = str;
        }

        public void setBookId(String str) {
            this.bookId = str;
        }

        public void setCategories(List<Categorie> list) {
            this.categories = list;
        }

        public void setChapterCount(int i) {
            this.chapterCount = i;
        }

        public void setCommonAdInfo(w6 w6Var) {
            this.mAdInfo = w6Var;
        }

        public void setContent(String str) {
            this.content = str;
        }

        public void setCover(String str) {
            this.cover = str;
        }

        public void setDkfreeNewTags(List<String> list) {
            this.dkfreeNewTags = list;
        }

        public void setFictionId(String str) {
            this.fictionId = str;
        }

        public void setFinish(boolean z) {
            this.finish = z;
        }

        public void setHasAd(boolean z) {
            this.mHasAd = z;
        }

        public void setIndex(int i) {
            this.mIndex = i;
        }

        public void setQmssPopular(int i) {
            this.qmssPopular = i;
        }

        public void setQmssScore(double d) {
            this.qmssScore = d;
        }

        public void setRecommendParagraph(SpannableStringBuilder spannableStringBuilder) {
            this.mRecommendParagraph = spannableStringBuilder;
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

        public void setSummary(String str) {
            this.summary = str;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public void setToc(List<TocItem> list) {
            this.toc = list;
        }

        public void setUpdated(long j) {
            this.updated = j;
        }

        public void setWordCount(long j) {
            this.wordCount = j;
        }
    }

    public static class TocItem extends Data {

        @SerializedName("chapter_id")
        private long chapterId;

        @SerializedName("jsonp_url")
        private String jsonpUrl;
        private String preview;
        private int price;
        private String title;

        @SerializedName("word_count")
        private int wordCount;

        public long getChapterId() {
            return this.chapterId;
        }

        public String getJsonpUrl() {
            return this.jsonpUrl;
        }

        public String getPreview() {
            return this.preview;
        }

        public int getPrice() {
            return this.price;
        }

        public String getTitle() {
            return this.title;
        }

        public int getWordCount() {
            return this.wordCount;
        }

        public void setChapterId(long j) {
            this.chapterId = j;
        }

        public void setJsonpUrl(String str) {
            this.jsonpUrl = str;
        }

        public void setPreview(String str) {
            this.preview = str;
        }

        public void setPrice(int i) {
            this.price = i;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public void setWordCount(int i) {
            this.wordCount = i;
        }
    }

    public Item getItem() {
        return this.item;
    }

    public SimDetailBookItem getSimDetailBookItem() {
        return this.mSimDetailBookItem;
    }

    public int getType() {
        return this.type;
    }

    public boolean isSuccess() {
        return this.result == 0;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setSimDetailBookItem(SimDetailBookItem simDetailBookItem) {
        this.mSimDetailBookItem = simDetailBookItem;
    }

    public void setType(int i) {
        this.type = i;
    }
}
