package com.amgcyo.cuttadon.c.a;

import com.amgcyo.cuttadon.api.entity.comic.Base64Bean;
import com.anythink.expressad.foundation.h.i;
import io.reactivex.Observable;
import me.jessyan.art.entity.BaseModel;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/* JADX INFO: compiled from: ComicService.java */
/* JADX INFO: loaded from: classes.dex */
public interface c {
    @Headers({"Domain-Name: my"})
    @GET("/v4/book/barrage/lists.api")
    Observable<BaseModel<Base64Bean>> a(@Query("form") int i2, @Query("book_id") int i3, @Query("chapter_path") String str);

    @FormUrlEncoded
    @Headers({"Domain-Name: my"})
    @POST("/v4/book/barrage/add.api")
    Observable<BaseModel> a(@Field("book_id") int i2, @Field("chapter_path") String str, @Field("pic_key") int i3, @Field("content") String str2, @Field(i.f10646d) int i4, @Query("form") int i5);

    @Headers({"Domain-Name: comic_catalog"})
    @GET("/{path}")
    Observable<BaseModel<Base64Bean>> a(@Path(encoded = true, value = "path") String str);

    @Headers({"Domain-Name: comic_pic"})
    @GET("/{path}")
    Observable<BaseModel<Base64Bean>> a(@Path(encoded = true, value = "path") String str, @Query(encoded = true, value = "time") long j2);

    @Headers({"Domain-Name: comic_catalog"})
    @GET("/{path}")
    Observable<BaseModel<Base64Bean>> b(@Path(encoded = true, value = "path") String str);
}
