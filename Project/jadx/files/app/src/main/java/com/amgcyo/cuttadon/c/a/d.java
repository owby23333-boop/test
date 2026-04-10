package com.amgcyo.cuttadon.c.a;

import com.amgcyo.cuttadon.api.entity.comic.Base64Bean;
import com.amgcyo.cuttadon.api.entity.comment.CommentReprotType;
import com.taobao.accs.common.Constants;
import io.reactivex.Observable;
import java.util.List;
import me.jessyan.art.entity.BaseModel;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

/* JADX INFO: compiled from: ConfigService.java */
/* JADX INFO: loaded from: classes.dex */
public interface d {
    @Headers({"Domain-Name: conf", "volley-branches-tags:1.2.1"})
    @GET("/a_package.html")
    Observable<BaseModel> a();

    @Headers({"Domain-Name: s"})
    @GET("/v4/1/keyword.api")
    Observable<BaseModel<Base64Bean>> a(@Query("data_conf") int i2, @Query(Constants.KEY_PACKAGE) String str);

    @Headers({"Domain-Name: conf", "volley-branches-tags:1.2.1"})
    @GET("v4/android_channel/{package_name}/{channel}")
    Observable<BaseModel<Base64Bean>> a(@Path("package_name") String str, @Path("channel") String str2);

    @Headers({"Domain-Name: conf", "volley-branches-tags:1.2.1"})
    @GET("v4/android/{package_name}/{channel}")
    Observable<BaseModel<Base64Bean>> a(@Path("package_name") String str, @Path("channel") String str2, @Query("t") String str3);

    @Headers({"Domain-Name: conf"})
    @GET("/v4/ad/android/all.html")
    Observable<BaseModel<Base64Bean>> b();

    @Headers({"Domain-Name: my"})
    @GET("/{api_version}/center/index.api")
    Observable<BaseModel<Base64Bean>> b(@Path("api_version") String str, @Query("time_token") String str2);

    @Headers({"Domain-Name: conf"})
    @GET("/v4/source/site.html")
    Observable<BaseModel<Base64Bean>> c();

    @Headers({"Domain-Name: my"})
    @GET("/v1/comment/report/type.api")
    Observable<BaseModel<List<CommentReprotType>>> d();
}
