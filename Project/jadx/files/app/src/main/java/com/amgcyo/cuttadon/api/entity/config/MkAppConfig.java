package com.amgcyo.cuttadon.api.entity.config;

import com.amgcyo.cuttadon.api.entity.migrate.MigrateData;
import com.amgcyo.cuttadon.api.entity.other.DownloadBean;
import com.amgcyo.cuttadon.api.entity.reader.FontBean;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class MkAppConfig implements Serializable {
    private AdDataBean ad_data;
    private BaseStochasticBean asking_book;
    private BaseStochasticBean awaken;
    private BaseStochasticBean awaken_err;
    private ArrayList<Bd_Data> bd_data;
    private BookTCBAdBean book;
    private BookTCBAdBean book_city;
    private BookTCBAdBean book_city_classification;
    private BookTCBAdBean book_city_end;
    private BookTCBAdBean book_city_female;
    private BookTCBAdBean book_city_male;
    private BookTCBAdBean bookself;
    private ChapterTCBAdBean chapter;
    private ChapterTCBAdBean comics_chapter;
    private BaseStochasticBean comics_exempt_ad;
    private BaseStochasticBean comment_lists;
    private int data_conf;
    private BaseStochasticBean down_cache;
    private ArrayList<DownloadBean> download;
    private BaseStochasticBean err_ad;
    private BaseStochasticBean err_phone;
    private BaseStochasticBean exempt_ad;
    private ArrayList<Fission> fission;
    private ArrayList<FontBean> font;
    private ForceBean force;
    private GameBean game;
    private HotBookBean hot_book;
    private Intervalminarr interval_min_arr;
    private boolean is_cache;
    private boolean is_success;
    private BaseStochasticBean listening_book;
    private BaseStochasticBean lists;
    private MigrateData migrate_data;
    private NotifyBean notify;
    private PushDataBean push_data;
    private String qq;
    private BaseStochasticBean rank;
    private String save_time;
    private BaseStochasticBean search;
    private SecondaryDomain secondary_domain;
    private BaseStochasticBean splash_screen;
    private BaseStochasticBean splash_screen_err;
    private UrlsBean urls;
    private BaseStochasticBean video_add_book;
    private String wechat;
    private BaseStochasticBean welfare_center;

    public AdDataBean getAd_data() {
        return this.ad_data;
    }

    public BaseStochasticBean getAsking_book() {
        return this.asking_book;
    }

    public BaseStochasticBean getAwaken() {
        return this.awaken;
    }

    public BaseStochasticBean getAwaken_err() {
        return this.awaken_err;
    }

    public ArrayList<Bd_Data> getBd_data() {
        return this.bd_data;
    }

    public BookTCBAdBean getBook() {
        return this.book;
    }

    public BookTCBAdBean getBook_city() {
        return this.book_city;
    }

    public BookTCBAdBean getBook_city_classification() {
        return this.book_city_classification;
    }

    public BookTCBAdBean getBook_city_end() {
        return this.book_city_end;
    }

    public BookTCBAdBean getBook_city_female() {
        return this.book_city_female;
    }

    public BookTCBAdBean getBook_city_male() {
        return this.book_city_male;
    }

    public BookTCBAdBean getBookself() {
        return this.bookself;
    }

    public ChapterTCBAdBean getChapter() {
        return this.chapter;
    }

    public ChapterTCBAdBean getComics_chapter() {
        return this.comics_chapter;
    }

    public BaseStochasticBean getComics_exempt_ad() {
        return this.comics_exempt_ad;
    }

    public BaseStochasticBean getComment_lists() {
        return this.comment_lists;
    }

    public int getData_conf() {
        return this.data_conf;
    }

    public BaseStochasticBean getDown_cache() {
        return this.down_cache;
    }

    public ArrayList<DownloadBean> getDownload() {
        return this.download;
    }

    public BaseStochasticBean getErr_ad() {
        return this.err_ad;
    }

    public BaseStochasticBean getErr_phone() {
        return this.err_phone;
    }

    public BaseStochasticBean getExempt_ad() {
        return this.exempt_ad;
    }

    public ArrayList<Fission> getFission() {
        return this.fission;
    }

    public ArrayList<FontBean> getFont() {
        return this.font;
    }

    public ForceBean getForce() {
        return this.force;
    }

    public GameBean getGame() {
        return this.game;
    }

    public HotBookBean getHot_book() {
        return this.hot_book;
    }

    public Intervalminarr getInterval_min_arr() {
        return this.interval_min_arr;
    }

    public BaseStochasticBean getListening_book() {
        return this.listening_book;
    }

    public BaseStochasticBean getLists() {
        return this.lists;
    }

    public MigrateData getMigrate_data() {
        return this.migrate_data;
    }

    public NotifyBean getNotify() {
        return this.notify;
    }

    public PushDataBean getPush_data() {
        return this.push_data;
    }

    public String getQq() {
        return this.qq;
    }

    public BaseStochasticBean getRank() {
        return this.rank;
    }

    public String getSave_time() {
        return this.save_time;
    }

    public BaseStochasticBean getSearch() {
        return this.search;
    }

    public SecondaryDomain getSecondary_domain() {
        return this.secondary_domain;
    }

    public BaseStochasticBean getSplash_screen() {
        return this.splash_screen;
    }

    public BaseStochasticBean getSplash_screen_err() {
        return this.splash_screen_err;
    }

    public UrlsBean getUrls() {
        return this.urls;
    }

    public BaseStochasticBean getVideo_add_book() {
        return this.video_add_book;
    }

    public String getWechat() {
        return this.wechat;
    }

    public BaseStochasticBean getWelfare_center() {
        return this.welfare_center;
    }

    public boolean isIs_cache() {
        return this.is_cache;
    }

    public boolean isIs_success() {
        return this.is_success;
    }

    public void setAd_data(AdDataBean adDataBean) {
        this.ad_data = adDataBean;
    }

    public void setAsking_book(BaseStochasticBean baseStochasticBean) {
        this.asking_book = baseStochasticBean;
    }

    public void setAwaken(BaseStochasticBean baseStochasticBean) {
        this.awaken = baseStochasticBean;
    }

    public void setAwaken_err(BaseStochasticBean baseStochasticBean) {
        this.awaken_err = baseStochasticBean;
    }

    public void setBd_data(ArrayList<Bd_Data> arrayList) {
        this.bd_data = arrayList;
    }

    public void setBook(BookTCBAdBean bookTCBAdBean) {
        this.book = bookTCBAdBean;
    }

    public void setBook_city(BookTCBAdBean bookTCBAdBean) {
        this.book_city = bookTCBAdBean;
    }

    public void setBook_city_classification(BookTCBAdBean bookTCBAdBean) {
        this.book_city_classification = bookTCBAdBean;
    }

    public void setBook_city_end(BookTCBAdBean bookTCBAdBean) {
        this.book_city_end = bookTCBAdBean;
    }

    public void setBook_city_female(BookTCBAdBean bookTCBAdBean) {
        this.book_city_female = bookTCBAdBean;
    }

    public void setBook_city_male(BookTCBAdBean bookTCBAdBean) {
        this.book_city_male = bookTCBAdBean;
    }

    public void setBookself(BookTCBAdBean bookTCBAdBean) {
        this.bookself = bookTCBAdBean;
    }

    public void setChapter(ChapterTCBAdBean chapterTCBAdBean) {
        this.chapter = chapterTCBAdBean;
    }

    public void setComics_chapter(ChapterTCBAdBean chapterTCBAdBean) {
        this.comics_chapter = chapterTCBAdBean;
    }

    public void setComics_exempt_ad(BaseStochasticBean baseStochasticBean) {
        this.comics_exempt_ad = baseStochasticBean;
    }

    public void setComment_lists(BaseStochasticBean baseStochasticBean) {
        this.comment_lists = baseStochasticBean;
    }

    public void setData_conf(int i2) {
        this.data_conf = i2;
    }

    public void setDown_cache(BaseStochasticBean baseStochasticBean) {
        this.down_cache = baseStochasticBean;
    }

    public void setDownload(ArrayList<DownloadBean> arrayList) {
        this.download = arrayList;
    }

    public void setErr_ad(BaseStochasticBean baseStochasticBean) {
        this.err_ad = baseStochasticBean;
    }

    public void setErr_phone(BaseStochasticBean baseStochasticBean) {
        this.err_phone = baseStochasticBean;
    }

    public void setExempt_ad(BaseStochasticBean baseStochasticBean) {
        this.exempt_ad = baseStochasticBean;
    }

    public void setFission(ArrayList<Fission> arrayList) {
        this.fission = arrayList;
    }

    public void setFont(ArrayList<FontBean> arrayList) {
        this.font = arrayList;
    }

    public void setForce(ForceBean forceBean) {
        this.force = forceBean;
    }

    public void setGame(GameBean gameBean) {
        this.game = gameBean;
    }

    public void setHot_book(HotBookBean hotBookBean) {
        this.hot_book = hotBookBean;
    }

    public void setInterval_min_arr(Intervalminarr intervalminarr) {
        this.interval_min_arr = intervalminarr;
    }

    public void setIs_cache(boolean z2) {
        this.is_cache = z2;
    }

    public void setIs_success(boolean z2) {
        this.is_success = z2;
    }

    public void setListening_book(BaseStochasticBean baseStochasticBean) {
        this.listening_book = baseStochasticBean;
    }

    public void setLists(BaseStochasticBean baseStochasticBean) {
        this.lists = baseStochasticBean;
    }

    public void setMigrate_data(MigrateData migrateData) {
        this.migrate_data = migrateData;
    }

    public void setNotify(NotifyBean notifyBean) {
        this.notify = notifyBean;
    }

    public void setPush_data(PushDataBean pushDataBean) {
        this.push_data = pushDataBean;
    }

    public void setQq(String str) {
        this.qq = str;
    }

    public void setRank(BaseStochasticBean baseStochasticBean) {
        this.rank = baseStochasticBean;
    }

    public void setSave_time(String str) {
        this.save_time = str;
    }

    public void setSearch(BaseStochasticBean baseStochasticBean) {
        this.search = baseStochasticBean;
    }

    public void setSecondary_domain(SecondaryDomain secondaryDomain) {
        this.secondary_domain = secondaryDomain;
    }

    public void setSplash_screen(BaseStochasticBean baseStochasticBean) {
        this.splash_screen = baseStochasticBean;
    }

    public void setSplash_screen_err(BaseStochasticBean baseStochasticBean) {
        this.splash_screen_err = baseStochasticBean;
    }

    public void setUrls(UrlsBean urlsBean) {
        this.urls = urlsBean;
    }

    public void setVideo_add_book(BaseStochasticBean baseStochasticBean) {
        this.video_add_book = baseStochasticBean;
    }

    public void setWechat(String str) {
        this.wechat = str;
    }

    public void setWelfare_center(BaseStochasticBean baseStochasticBean) {
        this.welfare_center = baseStochasticBean;
    }
}
