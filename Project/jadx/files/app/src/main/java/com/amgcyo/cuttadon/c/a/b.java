package com.amgcyo.cuttadon.c.a;

import com.amgcyo.cuttadon.api.entity.other.MkCatalog;
import com.amgcyo.cuttadon.api.entity.other.MkChapterContent;
import com.amgcyo.cuttadon.api.entity.reader.ReadLog;
import com.amgcyo.cuttadon.api.entity.reader.SitePathReload;
import com.bytedance.sdk.openadsdk.live.TTLiveConstants;
import io.reactivex.Observable;
import java.util.ArrayList;
import me.jessyan.art.entity.BaseModel;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

/* JADX INFO: compiled from: CatalogService.java */
/* JADX INFO: loaded from: classes.dex */
public interface b {
    @FormUrlEncoded
    @Headers({"Domain-Name: my"})
    @POST("/v4/book/history/add.api")
    Observable<BaseModel> a(@Field("book_id") int i2, @Field("form") int i3);

    @FormUrlEncoded
    @Headers({"Domain-Name: my"})
    @POST("/v4/book/read/set.api")
    Observable<BaseModel> a(@Field("book_id") int i2, @Field("chapter_key") int i3, @Field(TTLiveConstants.APP_SITEID_KEY) String str, @Field("crawl_book_id") int i4, @Field("is_top") int i5, @Field("is_fatten") int i6, @Field("form") int i7);

    @FormUrlEncoded
    @Headers({"Domain-Name: my"})
    @POST("/v4/book/read/log.api")
    Observable<BaseModel<ReadLog>> a(@Field("book_id") int i2, @Field("chapter_path") String str, @Field(TTLiveConstants.APP_SITEID_KEY) String str2, @Field("read_time") int i3, @Field("form") int i4);

    @Headers({"Domain-Name: catalog"})
    @GET("/{path}")
    Observable<BaseModel<SitePathReload>> a(@Path(encoded = true, value = "path") String str);

    @Headers({"Domain-Name: chapter"})
    @GET("/{path}")
    Observable<BaseModel<MkChapterContent>> b(@Path(encoded = true, value = "path") String str);

    @Headers({"Domain-Name: catalog"})
    @GET("/{path}")
    Observable<BaseModel<ArrayList<MkCatalog>>> c(@Path(encoded = true, value = "path") String str);
}
