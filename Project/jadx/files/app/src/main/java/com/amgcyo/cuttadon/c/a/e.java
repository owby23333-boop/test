package com.amgcyo.cuttadon.c.a;

import com.amgcyo.cuttadon.api.entity.comic.Base64Bean;
import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.baidu.mobads.sdk.api.ArticleInfo;
import com.taobao.accs.common.Constants;
import io.reactivex.Observable;
import java.util.List;
import me.jessyan.art.entity.BaseModel;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/* JADX INFO: compiled from: SearchService.java */
/* JADX INFO: loaded from: classes.dex */
public interface e {
    @Headers({"Domain-Name: s"})
    @GET("/v1/rank.api")
    Observable<BaseModel<List<MkBook>>> a(@Query(ArticleInfo.USER_SEX) int i2, @Query("data_conf") int i3);

    @FormUrlEncoded
    @Headers({"Domain-Name: s"})
    @POST("/log/v4/keyword.api")
    Observable<BaseModel> a(@Field("keyword") String str, @Field("form") int i2);

    @Headers({"Domain-Name: s"})
    @GET("/{api_version}/1/lists.api")
    Observable<BaseModel<Base64Bean>> a(@Path("api_version") String str, @Query("keyword") String str2, @Query("form") int i2);

    @Headers({"Domain-Name: s"})
    @GET("/{api_version}/1/auto.api")
    Observable<BaseModel<Base64Bean>> a(@Path("api_version") String str, @Query("keyword") String str2, @Query(Constants.KEY_PACKAGE) String str3, @Query("form") int i2);

    @FormUrlEncoded
    @Headers({"Domain-Name: s"})
    @POST("/log/v4/book.api")
    Observable<BaseModel> b(@Field("keyword") String str, @Field("book_id") String str2, @Field("form") int i2);

    @Headers({"Domain-Name: s"})
    @GET("/{api_version}/1/author.api")
    Observable<BaseModel<Base64Bean>> c(@Path("api_version") String str, @Query("author") String str2, @Query("form") int i2);
}
