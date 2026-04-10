package com.amgcyo.cuttadon.api.entity.other;

import android.text.TextUtils;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import com.amgcyo.cuttadon.utils.otherutils.h;
import com.anythink.expressad.foundation.d.c;
import com.chad.library.adapter.base.d.b;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@Entity(indices = {@Index(unique = true, value = {"book_id"})}, tableName = "MkBook")
public class MkBook implements Serializable, b {

    @Ignore
    public static final int AD = 1;

    @Ignore
    public static final int AUTHOR_LIST = 3;

    @Ignore
    public static final int DATA_LIST = 2;

    @Ignore
    private ComicArea area;

    @PrimaryKey(autoGenerate = true)
    private int art_id;

    @ColumnInfo(name = "author")
    private String author;

    @Ignore
    private List<MkBook> author_book;

    @ColumnInfo(name = "bg_color")
    private int bg_color;

    @Ignore
    private int book_count;

    @ColumnInfo(name = "book_id")
    private int book_id;

    @ColumnInfo(name = "book_int_filed_1")
    private int book_int_filed_1;

    @ColumnInfo(name = "book_int_filed_2")
    private int book_int_filed_2;

    @ColumnInfo(name = "book_int_filed_3")
    private int book_int_filed_3;

    @ColumnInfo(name = "book_int_filed_4")
    private int book_int_filed_4;

    @ColumnInfo(name = "book_int_filed_5")
    private int book_int_filed_5;

    @ColumnInfo(name = "book_int_filed_6")
    private int book_int_filed_6;

    @ColumnInfo(name = "book_shelf_category")
    private String book_shelf_category;

    @ColumnInfo(name = "book_text_filed_1")
    private String book_text_filed_1;

    @ColumnInfo(name = "book_text_filed_2")
    private String book_text_filed_2;

    @ColumnInfo(name = "book_text_filed_3")
    private String book_text_filed_3;

    @ColumnInfo(name = "book_text_filed_4")
    private String book_text_filed_4;

    @ColumnInfo(name = "book_text_filed_5")
    private String book_text_filed_5;

    @ColumnInfo(name = "book_text_filed_6")
    private String book_text_filed_6;

    @Ignore
    private int cacheProgress;

    @Ignore
    private int cacheTotalSize;

    @ColumnInfo(name = "chapter_count")
    private int chapter_count;

    @ColumnInfo(name = "comic_source")
    private String comic_source;

    @ColumnInfo(name = "comment_number")
    private int comment_number;

    @ColumnInfo(name = "crawl_book_id")
    private int crawl_book_id;

    @Ignore
    private String created_at;

    @ColumnInfo(name = "fatten_num")
    private int fatten_num;

    @ColumnInfo(name = "fav_count")
    private int fav_count;

    @Ignore
    private String firstLineText;

    @ColumnInfo(name = "form")
    private int form;

    @Ignore
    private CharSequence highLightBookAuthor;

    @Ignore
    private CharSequence highLightBookName;

    @Ignore
    private CharSequence hotSize;

    @ColumnInfo(name = c.C0205c.f10205e)
    private String image;

    @Ignore
    private boolean isChangeSiteId;

    @Ignore
    private boolean isInshelf;

    @ColumnInfo(name = "is_fatten")
    private int is_fatten;

    @ColumnInfo(name = "is_top")
    private int is_top;

    @Ignore
    private int itemType;

    @ColumnInfo(name = "jpush_status")
    private int jpush_status;

    @ColumnInfo(name = "jpush_today_time")
    private String jpush_today_time;

    @ColumnInfo(name = "last_chapter_name")
    private String last_chapter_name;
    private int last_crawler_book_id;

    @ColumnInfo(name = "last_read_chapterName")
    private String last_read_chapterName;

    @ColumnInfo(name = "list_path")
    private String list_path;

    @ColumnInfo(name = "list_reload_path")
    private String list_reload_path;

    @ColumnInfo(name = "ltype")
    private String ltype;

    @ColumnInfo(name = "name")
    private String name;

    @Ignore
    private boolean needFinishActivity;

    @Ignore
    private NewApiAd newApiAd;

    @Ignore
    private int position;

    @Ignore
    private String push_status;

    @ColumnInfo(name = "read_begin")
    private int read_begin;

    @ColumnInfo(name = "reading_chapter_key")
    private int reading_chapter_key;

    @ColumnInfo(name = "reading_chapter_path")
    private String reading_chapter_path;

    @ColumnInfo(name = "reading_datetime")
    private long reading_datetime;

    @ColumnInfo(name = "reading_site_id")
    private String reading_site_id;

    @ColumnInfo(name = "reading_site_path")
    private String reading_site_path;

    @ColumnInfo(name = "reading_site_reload_path")
    private String reading_site_reload_path;

    @ColumnInfo(name = "refreshtime")
    private String refreshtime;

    @Ignore
    private List<MkBook> related_data;

    @Ignore
    private List<MkBook> relevant_book;

    @ColumnInfo(name = "reload_updated_at")
    private long reload_updated_at;

    @Ignore
    private String remark;

    @Ignore
    private int retryCount;

    @ColumnInfo(name = "score")
    private String score;

    @ColumnInfo(name = "score_number")
    private int score_number;

    @Ignore
    private int search_count;

    @Ignore
    private boolean select;

    @Ignore
    private int sex;

    @Ignore
    private List<Integer> shield_data;

    @Ignore
    private String show_last_read_at;

    @Ignore
    private String show_update_at;

    @ColumnInfo(name = "siteName")
    private String siteName;

    @ColumnInfo(name = "site_path_reload")
    private String site_path_reload;

    @Ignore
    private boolean skipToDetailPage;

    @Ignore
    private int source_count;

    @Ignore
    private int spanSize;

    @ColumnInfo(name = "status")
    private int status;

    @ColumnInfo(name = "stype")
    private String stype;

    @Ignore
    private Object tags;

    @Ignore
    private int total_count;

    @ColumnInfo(name = "updated")
    private int updated;

    @ColumnInfo(name = "updated_at")
    private String updated_at;

    @ColumnInfo(name = "vertical_top")
    private int vertical_top;

    @ColumnInfo(name = "view_count")
    private int view_count;

    @ColumnInfo(name = "words_number")
    private int words_number;

    @Ignore
    public MkBook(int i2) {
        this.form = 1;
        this.vertical_top = 0;
        this.select = false;
        this.updated = 8;
        this.itemType = i2;
    }

    public ComicArea getArea() {
        return this.area;
    }

    public int getArt_id() {
        return this.art_id;
    }

    public String getAuthor() {
        return (this.form == 3 && h.v0() == 1) ? "" : this.author;
    }

    public List<MkBook> getAuthor_book() {
        return this.author_book;
    }

    public int getBg_color() {
        return this.bg_color;
    }

    public int getBook_count() {
        return this.book_count;
    }

    public int getBook_id() {
        return this.book_id;
    }

    public int getBook_int_filed_1() {
        return this.book_int_filed_1;
    }

    public int getBook_int_filed_2() {
        return this.book_int_filed_2;
    }

    public int getBook_int_filed_3() {
        return this.book_int_filed_3;
    }

    public int getBook_int_filed_4() {
        return this.book_int_filed_4;
    }

    public int getBook_int_filed_5() {
        return this.book_int_filed_5;
    }

    public int getBook_int_filed_6() {
        return this.book_int_filed_6;
    }

    public String getBook_shelf_category() {
        return this.book_shelf_category;
    }

    public String getBook_text_filed_1() {
        return this.book_text_filed_1;
    }

    public String getBook_text_filed_2() {
        return this.book_text_filed_2;
    }

    public String getBook_text_filed_3() {
        return this.book_text_filed_3;
    }

    public String getBook_text_filed_4() {
        return this.book_text_filed_4;
    }

    public String getBook_text_filed_5() {
        return this.book_text_filed_5;
    }

    public String getBook_text_filed_6() {
        return this.book_text_filed_6;
    }

    public int getCacheProgress() {
        return this.cacheProgress;
    }

    public int getCacheTotalSize() {
        return this.cacheTotalSize;
    }

    public int getChapter_count() {
        int i2 = this.chapter_count;
        return i2 <= 0 ? getWords_number() : i2;
    }

    public String getComic_source() {
        return this.comic_source;
    }

    public int getComment_number() {
        return this.comment_number;
    }

    public int getCrawl_book_id() {
        return this.crawl_book_id;
    }

    public String getCreated_at() {
        return this.created_at;
    }

    public int getFatten_num() {
        return this.fatten_num;
    }

    public int getFav_count() {
        return this.fav_count;
    }

    public String getFirstLineText() {
        return this.firstLineText;
    }

    public int getForm() {
        if (this.form <= 0) {
            this.form = 1;
        }
        return this.form;
    }

    public CharSequence getHighLightBookAuthor() {
        return this.highLightBookAuthor;
    }

    public CharSequence getHighLightBookName() {
        return this.highLightBookName;
    }

    public CharSequence getHotSize() {
        return this.hotSize;
    }

    public String getImage() {
        return this.image;
    }

    public boolean getIsChangeSiteId() {
        return this.isChangeSiteId;
    }

    public int getIs_fatten() {
        return this.is_fatten;
    }

    public int getIs_top() {
        return this.is_top;
    }

    @Override // com.chad.library.adapter.base.d.b
    public int getItemType() {
        return this.itemType;
    }

    public int getJpush_status() {
        return this.jpush_status;
    }

    public String getJpush_today_time() {
        return this.jpush_today_time;
    }

    public String getLast_chapter_name() {
        return this.last_chapter_name;
    }

    public int getLast_crawler_book_id() {
        return this.last_crawler_book_id;
    }

    public String getLast_read_chapterName() {
        return this.last_read_chapterName;
    }

    public String getList_path() {
        return this.list_path;
    }

    public String getList_reload_path() {
        return this.list_reload_path;
    }

    public String getLtype() {
        return this.ltype;
    }

    public String getName() {
        return this.name;
    }

    public NewApiAd getNewApiAd() {
        return this.newApiAd;
    }

    public int getPosition() {
        return this.position;
    }

    public String getPush_status() {
        return this.push_status;
    }

    public int getRead_begin() {
        return this.read_begin;
    }

    public int getReading_chapter_key() {
        return this.reading_chapter_key;
    }

    public String getReading_chapter_path() {
        return this.reading_chapter_path;
    }

    public long getReading_datetime() {
        return this.reading_datetime;
    }

    public String getReading_site_id() {
        return this.reading_site_id;
    }

    public String getReading_site_path() {
        return this.reading_site_path;
    }

    public String getReading_site_reload_path() {
        return this.reading_site_reload_path;
    }

    public String getRefreshtime() {
        return this.refreshtime;
    }

    public List<MkBook> getRelated_data() {
        return this.related_data;
    }

    public List<MkBook> getRelevant_book() {
        return this.relevant_book;
    }

    public long getReload_updated_at() {
        return this.reload_updated_at;
    }

    public String getRemark() {
        return this.remark;
    }

    public int getRetryCount() {
        return this.retryCount;
    }

    public String getScore() {
        if (TextUtils.isEmpty(this.score)) {
            this.score = "7.5";
        }
        return this.score;
    }

    public int getScore_number() {
        if (this.score_number <= 0) {
            this.score_number = 1000;
        }
        return this.score_number;
    }

    public int getSearch_count() {
        return this.search_count;
    }

    public int getSex() {
        return this.sex;
    }

    public List<Integer> getShield_data() {
        return this.shield_data;
    }

    public String getShow_last_read_at() {
        return this.show_last_read_at;
    }

    public String getShow_update_at() {
        return this.show_update_at;
    }

    public String getSiteName() {
        return this.siteName;
    }

    public String getSite_path_reload() {
        return this.site_path_reload;
    }

    public int getSource_count() {
        return this.source_count;
    }

    public int getSpanSize() {
        return this.spanSize;
    }

    public int getStatus() {
        return this.status;
    }

    public String getStype() {
        return this.stype;
    }

    public Object getTags() {
        return this.tags;
    }

    public int getTotal_count() {
        return this.total_count;
    }

    public int getUpdated() {
        return this.updated;
    }

    public String getUpdated_at() {
        return this.updated_at;
    }

    public int getVertical_top() {
        return this.vertical_top;
    }

    public int getView_count() {
        return this.view_count;
    }

    public int getWords_number() {
        return this.words_number;
    }

    public boolean isInshelf() {
        return this.isInshelf;
    }

    public boolean isNeedFinishActivity() {
        return this.needFinishActivity;
    }

    public boolean isSelect() {
        return this.select;
    }

    public boolean isSkipToDetailPage() {
        return this.skipToDetailPage;
    }

    public void setArea(ComicArea comicArea) {
        this.area = comicArea;
    }

    public void setArt_id(int i2) {
        this.art_id = i2;
    }

    public void setAuthor(String str) {
        this.author = str;
    }

    public void setAuthor_book(List<MkBook> list) {
        this.author_book = list;
    }

    public void setBg_color(int i2) {
        this.bg_color = i2;
    }

    public void setBook_count(int i2) {
        this.book_count = i2;
    }

    public void setBook_id(int i2) {
        this.book_id = i2;
    }

    public void setBook_int_filed_1(int i2) {
        this.book_int_filed_1 = i2;
    }

    public void setBook_int_filed_2(int i2) {
        this.book_int_filed_2 = i2;
    }

    public void setBook_int_filed_3(int i2) {
        this.book_int_filed_3 = i2;
    }

    public void setBook_int_filed_4(int i2) {
        this.book_int_filed_4 = i2;
    }

    public void setBook_int_filed_5(int i2) {
        this.book_int_filed_5 = i2;
    }

    public void setBook_int_filed_6(int i2) {
        this.book_int_filed_6 = i2;
    }

    public void setBook_shelf_category(String str) {
        this.book_shelf_category = str;
    }

    public void setBook_text_filed_1(String str) {
        this.book_text_filed_1 = str;
    }

    public void setBook_text_filed_2(String str) {
        this.book_text_filed_2 = str;
    }

    public void setBook_text_filed_3(String str) {
        this.book_text_filed_3 = str;
    }

    public void setBook_text_filed_4(String str) {
        this.book_text_filed_4 = str;
    }

    public void setBook_text_filed_5(String str) {
        this.book_text_filed_5 = str;
    }

    public void setBook_text_filed_6(String str) {
        this.book_text_filed_6 = str;
    }

    public void setCacheProgress(int i2) {
        this.cacheProgress = i2;
    }

    public void setCacheTotalSize(int i2) {
        this.cacheTotalSize = i2;
    }

    public void setChapter_count(int i2) {
        this.chapter_count = i2;
    }

    public void setComic_source(String str) {
        this.comic_source = str;
    }

    public void setComment_number(int i2) {
        this.comment_number = i2;
    }

    public void setCrawl_book_id(int i2) {
        this.crawl_book_id = i2;
    }

    public void setCreated_at(String str) {
        this.created_at = str;
    }

    public void setFatten_num(int i2) {
        this.fatten_num = i2;
    }

    public void setFav_count(int i2) {
        this.fav_count = i2;
    }

    public void setFirstLineText(String str) {
        this.firstLineText = str;
    }

    public void setForm(int i2) {
        this.form = i2;
    }

    public void setHighLightBookAuthor(CharSequence charSequence) {
        this.highLightBookAuthor = charSequence;
    }

    public void setHighLightBookName(CharSequence charSequence) {
        this.highLightBookName = charSequence;
    }

    public void setHotSize(CharSequence charSequence) {
        this.hotSize = charSequence;
    }

    public void setImage(String str) {
        this.image = str;
    }

    public void setInshelf(boolean z2) {
        this.isInshelf = z2;
    }

    public void setIsChangeSiteId(boolean z2) {
        this.isChangeSiteId = z2;
    }

    public void setIs_fatten(int i2) {
        this.is_fatten = i2;
    }

    public void setIs_top(int i2) {
        this.is_top = i2;
    }

    public void setItemType(int i2) {
        this.itemType = i2;
    }

    public void setJpush_status(int i2) {
        this.jpush_status = i2;
    }

    public void setJpush_today_time(String str) {
        this.jpush_today_time = str;
    }

    public void setLast_chapter_name(String str) {
        this.last_chapter_name = str;
    }

    public void setLast_crawler_book_id(int i2) {
        this.last_crawler_book_id = i2;
    }

    public void setLast_read_chapterName(String str) {
        this.last_read_chapterName = str;
    }

    public void setList_path(String str) {
        this.list_path = str;
    }

    public void setList_reload_path(String str) {
        this.list_reload_path = str;
    }

    public void setLtype(String str) {
        this.ltype = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNeedFinishActivity(boolean z2) {
        this.needFinishActivity = z2;
    }

    public void setNewApiAd(NewApiAd newApiAd) {
        this.newApiAd = newApiAd;
    }

    public void setPosition(int i2) {
        this.position = i2;
    }

    public void setPush_status(String str) {
        this.push_status = str;
    }

    public void setRead_begin(int i2) {
        this.read_begin = i2;
    }

    public void setReading_chapter_key(int i2) {
        this.reading_chapter_key = i2;
    }

    public void setReading_chapter_path(String str) {
        this.reading_chapter_path = str;
    }

    public void setReading_datetime(long j2) {
        this.reading_datetime = j2;
    }

    public void setReading_site_id(String str) {
        this.reading_site_id = str;
    }

    public void setReading_site_path(String str) {
        this.reading_site_path = str;
    }

    public void setReading_site_reload_path(String str) {
        this.reading_site_reload_path = str;
    }

    public void setRefreshtime(String str) {
        this.refreshtime = str;
    }

    public void setRelated_data(List<MkBook> list) {
        this.related_data = list;
    }

    public void setRelevant_book(List<MkBook> list) {
        this.relevant_book = list;
    }

    public void setReload_updated_at(long j2) {
        this.reload_updated_at = j2;
    }

    public void setRemark(String str) {
        this.remark = str;
    }

    public void setRetryCount(int i2) {
        this.retryCount = i2;
    }

    public void setScore(String str) {
        this.score = str;
    }

    public void setScore_number(int i2) {
        this.score_number = i2;
    }

    public void setSearch_count(int i2) {
        this.search_count = i2;
    }

    public void setSelect(boolean z2) {
        this.select = z2;
    }

    public void setSex(int i2) {
        this.sex = i2;
    }

    public void setShield_data(List<Integer> list) {
        this.shield_data = list;
    }

    public void setShow_last_read_at(String str) {
        this.show_last_read_at = str;
    }

    public void setShow_update_at(String str) {
        this.show_update_at = str;
    }

    public void setSiteName(String str) {
        this.siteName = str;
    }

    public void setSite_path_reload(String str) {
        this.site_path_reload = str;
    }

    public void setSkipToDetailPage(boolean z2) {
        this.skipToDetailPage = z2;
    }

    public void setSource_count(int i2) {
        this.source_count = i2;
    }

    public void setSpanSize(int i2) {
        this.spanSize = i2;
    }

    public void setStatus(int i2) {
        this.status = i2;
    }

    public void setStype(String str) {
        this.stype = str;
    }

    public void setTags(Object obj) {
        this.tags = obj;
    }

    public void setTotal_count(int i2) {
        this.total_count = i2;
    }

    public void setUpdated(int i2) {
        this.updated = i2;
    }

    public void setUpdated_at(String str) {
        this.updated_at = str;
    }

    public void setVertical_top(int i2) {
        this.vertical_top = i2;
    }

    public void setView_count(int i2) {
        this.view_count = i2;
    }

    public void setWords_number(int i2) {
        this.words_number = i2;
    }

    @Ignore
    public MkBook(int i2, int i3) {
        this.form = 1;
        this.vertical_top = 0;
        this.select = false;
        this.updated = 8;
        this.itemType = i2;
        this.book_id = i3;
    }

    @Ignore
    public MkBook(String str, int i2, int i3) {
        this.form = 1;
        this.vertical_top = 0;
        this.select = false;
        this.updated = 8;
        this.name = str;
        this.form = i3;
        this.itemType = i2;
    }

    @Ignore
    public MkBook(long j2, int i2, int i3, int i4) {
        this.form = 1;
        this.vertical_top = 0;
        this.select = false;
        this.updated = 8;
        this.reading_datetime = j2;
        this.book_id = i2;
        this.jpush_status = i3;
        this.form = i4;
    }

    @Ignore
    public MkBook(int i2, String str, String str2) {
        this.form = 1;
        this.vertical_top = 0;
        this.select = false;
        this.updated = 8;
        this.name = str;
        this.book_id = i2;
        this.book_shelf_category = str2;
    }

    @Ignore
    public MkBook(int i2, int i3, String str, String str2, String str3, String str4) {
        this.form = 1;
        this.vertical_top = 0;
        this.select = false;
        this.updated = 8;
        this.book_id = i2;
        this.form = i3;
        this.name = str;
        this.image = str2;
        this.author = str3;
        this.score = str4;
    }

    @Ignore
    public MkBook(int i2, String str, String str2, String str3, String str4, String str5, String str6, int i3, int i4, int i5, int i6, String str7, String str8) {
        this.form = 1;
        this.vertical_top = 0;
        this.select = false;
        this.updated = 8;
        this.book_id = i2;
        this.name = str;
        this.author = str2;
        this.image = str3;
        this.created_at = str4;
        this.ltype = str5;
        this.stype = str6;
        this.status = i3;
        this.fav_count = i4;
        this.comment_number = i5;
        this.words_number = i6;
        this.last_chapter_name = str7;
        this.updated_at = str8;
    }

    @Ignore
    public MkBook(int i2, String str, String str2, int i3, String str3, String str4, String str5, int i4, String str6, int i5, int i6, String str7, int i7, String str8) {
        this.form = 1;
        this.vertical_top = 0;
        this.select = false;
        this.updated = 8;
        this.book_id = i2;
        this.name = str;
        this.author = str2;
        this.form = i3;
        this.image = str3;
        this.ltype = str4;
        this.stype = str5;
        this.status = i4;
        this.remark = str6;
        this.sex = i5;
        this.fav_count = i6;
        this.last_chapter_name = str7;
        this.last_crawler_book_id = i7;
        this.updated_at = str8;
    }

    @Ignore
    public MkBook(int i2, String str, String str2, String str3, String str4, String str5, String str6, int i3) {
        this.form = 1;
        this.vertical_top = 0;
        this.select = false;
        this.updated = 8;
        this.book_id = i2;
        this.name = str;
        this.author = str2;
        this.image = str3;
        this.ltype = str4;
        this.stype = str5;
        this.remark = str6;
        this.total_count = i3;
    }

    @Ignore
    public MkBook(int i2, int i3, String str, String str2, String str3, String str4, String str5, int i4) {
        this.form = 1;
        this.vertical_top = 0;
        this.select = false;
        this.updated = 8;
        this.book_id = i2;
        this.form = i3;
        this.name = str;
        this.image = str2;
        this.score = str3;
        this.remark = str4;
        this.ltype = str5;
        this.words_number = i4;
    }

    @Ignore
    public MkBook(int i2, String str, String str2, String str3, String str4, String str5, String str6, int i3, int i4) {
        this.form = 1;
        this.vertical_top = 0;
        this.select = false;
        this.updated = 8;
        this.book_id = i2;
        this.name = str;
        this.author = str2;
        this.image = str3;
        this.ltype = str4;
        this.stype = str5;
        this.remark = str6;
        this.status = i3;
        this.form = i4;
    }

    @Ignore
    public MkBook(int i2, String str, int i3, long j2) {
        this.form = 1;
        this.vertical_top = 0;
        this.select = false;
        this.updated = 8;
        this.book_id = i2;
        this.name = str;
        this.fatten_num = i3;
        this.reading_datetime = j2;
    }

    @Ignore
    public MkBook(int i2, String str, String str2, int i3) {
        this.form = 1;
        this.vertical_top = 0;
        this.select = false;
        this.updated = 8;
        this.book_id = i2;
        this.name = str;
        this.image = str2;
        this.total_count = i3;
    }

    @Ignore
    public MkBook(int i2, String str, String str2, String str3) {
        this.form = 1;
        this.vertical_top = 0;
        this.select = false;
        this.updated = 8;
        this.book_id = i2;
        this.name = str;
        this.image = str2;
        this.author = str3;
    }

    @Ignore
    public MkBook(int i2, int i3, String str, String str2, String str3) {
        this.form = 1;
        this.vertical_top = 0;
        this.select = false;
        this.updated = 8;
        this.book_id = i2;
        this.form = i3;
        this.name = str;
        this.image = str2;
        this.author = str3;
    }

    @Ignore
    public MkBook(int i2, String str, String str2, String str3, String str4) {
        this.form = 1;
        this.vertical_top = 0;
        this.select = false;
        this.updated = 8;
        this.book_id = i2;
        this.name = str;
        this.author = str2;
        this.image = str3;
        this.created_at = str4;
    }

    public MkBook(NewApiAd newApiAd, int i2) {
        this.form = 1;
        this.vertical_top = 0;
        this.select = false;
        this.updated = 8;
        this.newApiAd = newApiAd;
        this.itemType = i2;
    }

    public MkBook() {
        this.form = 1;
        this.vertical_top = 0;
        this.select = false;
        this.updated = 8;
    }

    @Ignore
    public MkBook(int i2, String str, String str2, int i3, String str3, int i4, int i5, int i6, long j2, int i7, String str4, String str5, int i8, String str6, String str7, String str8, String str9, int i9, int i10, int i11, int i12) {
        this.form = 1;
        this.vertical_top = 0;
        this.select = false;
        this.updated = 8;
        this.book_id = i2;
        this.name = str;
        this.author = str2;
        this.form = i3;
        this.image = str3;
        this.is_top = i4;
        this.is_fatten = i5;
        this.fatten_num = i6;
        this.reading_datetime = j2;
        this.reading_chapter_key = i7;
        this.last_read_chapterName = str4;
        this.last_chapter_name = str5;
        this.read_begin = i8;
        this.reading_chapter_path = str6;
        this.reading_site_id = str7;
        this.reading_site_path = str8;
        this.site_path_reload = str9;
        this.jpush_status = i9;
        this.crawl_book_id = i10;
        this.vertical_top = i11;
        this.words_number = i12;
    }
}
