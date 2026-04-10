package com.amgcyo.cuttadon.database;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.amgcyo.cuttadon.api.entity.other.MkBook;
import java.util.List;

/* JADX INFO: compiled from: MkBookDao.java */
/* JADX INFO: loaded from: classes.dex */
@Dao
public interface f {
    @Query("DELETE FROM MkBook  ")
    int a();

    @Query("delete  from MkBook where book_id = :book_id ")
    int a(int i2);

    @Query("update MkBook set is_fatten =:fatten,fatten_num = 0 where book_id = :book_id ")
    int a(int i2, int i3);

    @Query("update MkBook set reading_chapter_key =:reading_chapter_key ,updated =8, read_begin = :readBegin,vertical_top=:vertical_top,  reading_datetime=:last_read_time where book_id = :book_id ")
    int a(int i2, long j2, int i3, int i4, int i5);

    @Query("update MkBook set reading_chapter_key =:reading_chapter_key ,updated =:updated, read_begin = :readBegin,vertical_top=:vertical_top,  reading_datetime=:last_read_time, last_read_chapterName=:last_read_chapterName  where book_id = :book_id ")
    int a(int i2, long j2, int i3, int i4, int i5, int i6, String str);

    @Query("update MkBook set reading_chapter_key =:reading_chapter_key ,updated =8, last_read_chapterName=:last_read_chapterName where book_id = :book_id ")
    int a(int i2, String str, int i3);

    @Query("update MkBook set reload_updated_at =:reload_updated_at   where book_id = :book_id ")
    int a(long j2, int i2);

    @Query("update MkBook set book_shelf_category =:book_shelf_category   where book_id = :book_id ")
    int a(String str, int i2);

    @Query("update MkBook set updated_at =:update_at ,updated =:updated, fatten_num =:fatten_num, last_chapter_name=:last_chapter_name where book_id = :book_id ")
    int a(String str, int i2, int i3, String str2, int i4);

    @Query("update MkBook set reading_site_id =:siteId , siteName=:siteName ,reading_site_path =:site_path  ,site_path_reload =:site_path_reload , crawl_book_id =:crawl_book_id  where book_id = :book_id ")
    int a(String str, String str2, String str3, int i2, String str4, int i3);

    @Query("delete from MkBook where book_id in (:idList)")
    int a(List<Integer> list);

    @Query("update MkBook set updated_at =:update_at ,updated =:updated,   last_chapter_name=:last_chapter_name where book_id = :book_id ")
    void a(String str, int i2, String str2, int i3);

    @Query("update MkBook set list_path =:list_path ,list_reload_path =:list_reload_path   where book_id = :book_id ")
    void a(String str, String str2, int i2);

    @Query("update MkBook set comic_source =:comic_source ,reading_site_id =:siteId , siteName=:siteName  where book_id = :book_id ")
    void a(String str, String str2, String str3, int i2);

    @Query("update MkBook set name =:name,author=:author, image =:image,ltype=:ltype,  stype=:stype,  status=:status   where book_id = :book_id ")
    void a(String str, String str2, String str3, String str4, String str5, int i2, int i3);

    @Query("update MkBook set name =:name,author=:author, image =:image,ltype=:ltype,  stype=:stype,  status=:status , is_fatten=:fatten , is_top=:top   where book_id = :book_id ")
    void a(String str, String str2, String str3, String str4, String str5, int i2, int i3, int i4, int i5);

    @Query("update MkBook set name =:name,author=:author, image =:image,list_path=:list_path,last_chapter_name=:last_chapter_name , list_reload_path=:list_reload_path,  status=:status ,chapter_count=:chapter_count ,is_fatten=:fatten,is_top=:top where book_id = :book_id ")
    void a(String str, String str2, String str3, String str4, String str5, String str6, int i2, int i3, int i4, int i5, int i6);

    @Query("update MkBook set book_text_filed_1 =:book_text_filed_1  where book_id = :book_id ")
    int b(String str, int i2);

    @Nullable
    @Query("select * from MkBook  WHERE jpush_status == 1  ")
    List<MkBook> b();

    @Nullable
    @Query("select * from MkBook WHERE is_fatten ==1 and form =:form  ORDER BY is_top DESC ,reading_datetime DESC ")
    List<MkBook> b(int i2);

    @Query("update MkBook set score_number =:score_number   where book_id = :book_id ")
    void b(int i2, int i3);

    @Query("update MkBook set reading_site_id =:siteId , siteName=:siteName  where book_id = :book_id ")
    void b(String str, String str2, int i2);

    @Nullable
    @Query("select * from MkBook  ORDER BY is_top DESC ,reading_datetime DESC ")
    List<MkBook> c();

    @Nullable
    @Query("select * from MkBook    where form=:form   ORDER BY is_top DESC ,updated_at ASC")
    List<MkBook> c(int i2);

    @Query("update MkBook set updated =:updated   where book_id = :book_id ")
    void c(int i2, int i3);

    @Query("update MkBook set jpush_today_time =:jpush_today_time   where book_id = :book_id ")
    void c(String str, int i2);

    @Query("update MkBook set is_top =:top where book_id = :book_id ")
    int d(int i2, int i3);

    @Query("select * from MkBook  ORDER BY is_top DESC ,reading_datetime DESC ")
    LiveData<List<MkBook>> d();

    @Nullable
    @Query("select * from MkBook where book_id = :book_id ")
    LiveData<MkBook> d(int i2);

    @Query("update MkBook set score =:score   where book_id = :book_id ")
    void d(String str, int i2);

    @Query("select count(book_id) from MkBook where form=:form ")
    int e(int i2);

    @Query("update MkBook set comment_number =:comment_number   where book_id = :book_id ")
    void e(int i2, int i3);

    @Query("update MkBook set list_path =:list_path   where book_id = :book_id ")
    void e(String str, int i2);

    @Nullable
    @Query("select image from MkBook  WHERE is_fatten ==1 and form =:form ORDER BY is_top DESC ,updated_at DESC")
    List<String> f(int i2);

    @Query("update MkBook set words_number =:words_number   where book_id = :book_id ")
    void f(int i2, int i3);

    @Query("update MkBook set book_text_filed_3 =:book_text_filed_3   where book_id = :book_id ")
    void f(String str, int i2);

    @Query("SELECT COUNT(*)  FROM MkBook   where fatten_num >=:fattenedCount and form=:form")
    int g(int i2, int i3);

    @Nullable
    @Query("select * from MkBook  where form=:form ORDER BY is_top DESC ,reading_datetime ASC ")
    List<MkBook> g(int i2);

    @Nullable
    @Query("select * from MkBook    where form=:form   ORDER BY is_top DESC ,updated_at DESC")
    List<MkBook> h(int i2);

    @Query("update MkBook set fav_count =:fav_count   where book_id = :book_id ")
    void h(int i2, int i3);

    @Nullable
    @Query("select * from MkBook where book_id = :book_id ")
    MkBook i(int i2);

    @Query("update MkBook set view_count =:view_count   where book_id = :book_id ")
    void i(int i2, int i3);

    @Insert(onConflict = 1)
    long insert(MkBook mkBook);

    @Nullable
    @Query("select * from MkBook  WHERE is_fatten ==1 and form =:form ORDER BY is_top DESC ,updated_at DESC")
    List<MkBook> j(int i2);

    @Query("update MkBook set crawl_book_id =:crawl_book_id   where book_id = :book_id ")
    void j(int i2, int i3);

    @Query("SELECT COUNT(*)  FROM MkBook   where is_fatten >=1 and form=:form")
    int k(int i2);

    @Query("update MkBook set jpush_status =:jpush_status   where book_id = :book_id ")
    void k(int i2, int i3);

    @Nullable
    @Query("select * from MkBook  where form=:form ORDER BY is_top DESC ,reading_datetime DESC ")
    List<MkBook> l(int i2);
}
