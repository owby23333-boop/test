package com.amgcyo.cuttadon.c.a;

import com.amgcyo.cuttadon.api.entity.bookcity.ShudanListData;
import com.amgcyo.cuttadon.api.entity.bookcity.ThemeBookListBean;
import com.amgcyo.cuttadon.api.entity.bookcity.ThemeBookListDeatil;
import com.amgcyo.cuttadon.api.entity.bookcity.ThemeStates;
import com.amgcyo.cuttadon.api.entity.comic.Base64Bean;
import com.amgcyo.cuttadon.api.entity.comment.BaseCommentBean;
import com.amgcyo.cuttadon.api.entity.comment.BaseNewComment;
import com.amgcyo.cuttadon.api.entity.comment.CommentBean;
import com.amgcyo.cuttadon.api.entity.comment.CommentDetailBean;
import com.amgcyo.cuttadon.api.entity.comment.PostCommentRespone;
import com.amgcyo.cuttadon.api.entity.other.MkAllBookBean;
import com.amgcyo.cuttadon.api.entity.other.MkBook;
import com.amgcyo.cuttadon.api.entity.other.MkBookclassifyBean;
import com.amgcyo.cuttadon.api.entity.other.ThemeBookListID;
import com.amgcyo.cuttadon.api.entity.reader.SitePathReload;
import com.anythink.expressad.foundation.h.i;
import com.baidu.mobads.sdk.api.ArticleInfo;
import com.bytedance.sdk.openadsdk.live.TTLiveConstants;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.List;
import me.jessyan.art.entity.BaseModel;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/* JADX INFO: compiled from: BookService.java */
/* JADX INFO: loaded from: classes.dex */
public interface a {
    @Headers({"Domain-Name: book"})
    @GET("/hot_comment.html")
    Observable<BaseModel<List<MkBook>>> a();

    @Headers({"Domain-Name: my"})
    @GET("/v4/book/fav/lists.api")
    Observable<BaseModel<Base64Bean>> a(@Query("form") int i2);

    @FormUrlEncoded
    @Headers({"Domain-Name: my"})
    @POST("/v4/book/fav/top.api")
    Observable<BaseModel> a(@Field("book_id") int i2, @Field("form") int i3);

    @Headers({"Domain-Name: my"})
    @GET("/v1/comment/lists.api")
    Observable<BaseModel<CommentBean>> a(@Query("page") int i2, @Query("book_id") int i3, @Query("type") int i4);

    @Headers({"Domain-Name: book"})
    @GET("/classify/v4/all/{sex}/{ltype}/{stype}/{end}/{score}/{page}")
    Observable<BaseModel<Base64Bean>> a(@Path(encoded = true, value = ArticleInfo.USER_SEX) int i2, @Path(encoded = true, value = "ltype") int i3, @Path(encoded = true, value = "stype") int i4, @Path(encoded = true, value = "end") int i5, @Path(encoded = true, value = "score") int i6, @Path(encoded = true, value = "page") String str);

    @Headers({"Domain-Name: book"})
    @GET("/classify/style/{sex}/{ltype}/{style}")
    Observable<BaseModel<List<MkBook>>> a(@Path(encoded = true, value = ArticleInfo.USER_SEX) int i2, @Path(encoded = true, value = "ltype") int i3, @Path(encoded = true, value = i.f10647e) String str);

    @FormUrlEncoded
    @Headers({"Domain-Name: my"})
    @POST("/v4/comment/submit.api")
    Observable<BaseModel<BaseCommentBean>> a(@Field("book_id") int i2, @Field("score") int i3, @Field("content") String str, @Field("form") int i4);

    @Headers({"Domain-Name: d"})
    @GET("/book/source/v4/{floor}/{book_id}")
    Observable<BaseModel<Base64Bean>> a(@Path("floor") int i2, @Path("book_id") String str);

    @FormUrlEncoded
    @Headers({"Domain-Name: my"})
    @POST("/v1/comment/reply/submit.api")
    Observable<BaseModel<PostCommentRespone>> a(@Field("id") int i2, @Field("content") String str, @Field(com.anythink.expressad.d.a.b.aB) int i3);

    @Headers({"Domain-Name: catalog"})
    @GET("/{path}")
    Observable<BaseModel<SitePathReload>> a(@Path(encoded = true, value = "path") String str);

    @Headers({"Domain-Name: book"})
    @GET("/book_city/v7_more/{sex}/1/{data_conf}/{category}/{page}")
    Observable<BaseModel<Base64Bean>> a(@Path(encoded = true, value = ArticleInfo.USER_SEX) String str, @Path(encoded = true, value = "data_conf") int i2, @Path(encoded = true, value = "category") int i3, @Path(encoded = true, value = "page") String str2);

    @Headers({"Domain-Name: book"})
    @GET("/book_city/{sex}/{category}/{attributes}/{page}")
    Observable<BaseModel<MkAllBookBean>> a(@Path(encoded = true, value = ArticleInfo.USER_SEX) String str, @Path(encoded = true, value = "category") int i2, @Path(encoded = true, value = "attributes") int i3, @Path(encoded = true, value = "page") String str2, @Query("id") int i4);

    @Headers({"Domain-Name: book"})
    @GET("/book_city/v7/{sex}/1/{data_conf}/{rand}")
    Observable<BaseModel<Base64Bean>> a(@Path(encoded = true, value = ArticleInfo.USER_SEX) String str, @Path(encoded = true, value = "data_conf") int i2, @Path(encoded = true, value = "rand") String str2);

    @Headers({"Domain-Name: book"})
    @GET("/classify/v4/index.html")
    Observable<BaseModel<Base64Bean>> b();

    @Headers({"Domain-Name: my"})
    @GET("/v4/book/history/del_all.api")
    Observable<BaseModel> b(@Query("form") int i2);

    @FormUrlEncoded
    @Headers({"Domain-Name: my"})
    @POST("/v4/book/fav/del.api")
    Observable<BaseModel> b(@Field("book_id") int i2, @Field("form") int i3);

    @FormUrlEncoded
    @Headers({"Domain-Name: my"})
    @POST("/v6/book/fav/add.api")
    Observable<BaseModel> b(@Field("book_id") int i2, @Field("form") int i3, @Field("sign") String str);

    @Headers({"Domain-Name: book"})
    @GET("/book_lists/baseinfo/{floor}/{html}")
    Observable<BaseModel<ShudanListData>> b(@Path(encoded = true, value = "floor") int i2, @Path(encoded = true, value = com.baidu.mobads.sdk.internal.a.f12785f) String str);

    @Headers({"Domain-Name: book"})
    @GET("/book_lists/details/{path}")
    Observable<BaseModel<ThemeBookListDeatil>> b(@Path(encoded = true, value = "path") String str);

    @Headers({"Domain-Name: book"})
    @GET("/book_city/v7_recommend/{attributes}/{sex}/{page}")
    Observable<BaseModel<Base64Bean>> b(@Path(encoded = true, value = ArticleInfo.USER_SEX) String str, @Path(encoded = true, value = "attributes") int i2, @Path(encoded = true, value = "page") String str2);

    @Headers({"Domain-Name: my"})
    @GET("/v1/comment/book_details.api")
    Observable<BaseModel<List<BaseNewComment>>> c(@Query("book_id") int i2);

    @FormUrlEncoded
    @Headers({"Domain-Name: my"})
    @POST("/v4/book/fav/add.api")
    Observable<BaseModel> c(@Field("book_id") int i2, @Field("form") int i3);

    @Headers({"Domain-Name: book"})
    @GET("rank_lists/v7/details/1/{data_conf}/{sex}/{id}")
    Observable<BaseModel<Base64Bean>> c(@Path(encoded = true, value = "data_conf") int i2, @Path(encoded = true, value = ArticleInfo.USER_SEX) int i3, @Path(encoded = true, value = "id") String str);

    @Headers({"Domain-Name: book"})
    @GET("comics/details/v4/{floor}/{book_id}")
    Observable<BaseModel<Base64Bean>> c(@Path("floor") int i2, @Path("book_id") String str);

    @Headers({"Domain-Name: book"})
    @GET("rank_lists/v7/index/1/{data_conf}")
    Observable<BaseModel<Base64Bean>> c(@Path(encoded = true, value = "data_conf") String str);

    @FormUrlEncoded
    @Headers({"Domain-Name: my"})
    @POST("/v1/book/list/is_fav.api")
    Observable<BaseModel<ThemeStates>> d(@Field("id") int i2);

    @FormUrlEncoded
    @Headers({"Domain-Name: my"})
    @POST("/v4/book/fav/fatten_del.api")
    Observable<BaseModel> d(@Field("book_id") int i2, @Field("form") int i3);

    @FormUrlEncoded
    @Headers({"Domain-Name: my"})
    @POST("/v1/book/site/choose.api")
    Observable<BaseModel> d(@Field("book_id") int i2, @Field(TTLiveConstants.APP_SITEID_KEY) String str);

    @Headers({"Domain-Name: book"})
    @GET("/classify/index/{json}")
    Observable<BaseModel<ArrayList<MkBookclassifyBean>>> d(@Path("json") String str);

    @FormUrlEncoded
    @Headers({"Domain-Name: my"})
    @POST("/v1/comment/fav.api")
    Observable<BaseModel> e(@Field("id") int i2);

    @FormUrlEncoded
    @Headers({"Domain-Name: my"})
    @POST("/v4/book/fav/top_del.api")
    Observable<BaseModel> e(@Field("book_id") int i2, @Field("form") int i3);

    @Headers({"Domain-Name: d"})
    @GET("comics/base/v4/{floor}/{book_id}")
    Observable<BaseModel<Base64Bean>> e(@Path("floor") int i2, @Path("book_id") String str);

    @FormUrlEncoded
    @Headers({"Domain-Name: my"})
    @POST("/v1/book/list/del.api")
    Observable<BaseModel<ThemeStates>> f(@Field("id") int i2);

    @Headers({"Domain-Name: my"})
    @GET("/v1/comment/reply/lists.api")
    Observable<BaseModel<CommentDetailBean>> f(@Query("page") int i2, @Query("id") int i3);

    @Headers({"Domain-Name: book"})
    @GET("/book_lists/lists/{sex}/{page}")
    Observable<BaseModel<ThemeBookListBean>> f(@Path(encoded = true, value = ArticleInfo.USER_SEX) int i2, @Path(encoded = true, value = "page") String str);

    @Headers({"Domain-Name: my"})
    @GET("/v1/book/list/lists.api")
    Observable<BaseModel<ThemeBookListID>> g(@Query("page") int i2);

    @FormUrlEncoded
    @Headers({"Domain-Name: my"})
    @POST("/v4/book/fav/fatten.api")
    Observable<BaseModel> g(@Field("book_id") int i2, @Field("form") int i3);

    @Headers({"Domain-Name: d"})
    @GET("book/base/v4/{floor}/{book_id}")
    Observable<BaseModel<Base64Bean>> g(@Path("floor") int i2, @Path("book_id") String str);

    @FormUrlEncoded
    @Headers({"Domain-Name: my"})
    @POST("/v1/comment/del.api")
    Observable<BaseModel> h(@Field("id") int i2);

    @Headers({"Domain-Name: my"})
    @GET("/v4/book/history/lists.api")
    Observable<BaseModel<Base64Bean>> h(@Query("page") int i2, @Query("form") int i3);

    @Headers({"Domain-Name: d"})
    @GET("/book/details/v4/{floor}/{book_id}")
    Observable<BaseModel<Base64Bean>> h(@Path("floor") int i2, @Path("book_id") String str);

    @FormUrlEncoded
    @Headers({"Domain-Name: my"})
    @POST("/v1/comment/reply/fav.api")
    Observable<BaseModel> i(@Field("id") int i2);

    @FormUrlEncoded
    @Headers({"Domain-Name: my"})
    @POST("/v1/comment/reply/del.api")
    Observable<BaseModel> j(@Field("id") int i2);

    @FormUrlEncoded
    @Headers({"Domain-Name: my"})
    @POST("/v1/book/list/add.api")
    Observable<BaseModel<ThemeStates>> k(@Field("id") int i2);
}
