package com.amgcyo.cuttadon.c.a;

import com.amgcyo.cuttadon.api.entity.comic.Base64Bean;
import com.amgcyo.cuttadon.api.entity.cz.CzIndexBean;
import com.amgcyo.cuttadon.api.entity.cz.CzOrderBean;
import com.amgcyo.cuttadon.api.entity.cz.CzRecordBean;
import com.amgcyo.cuttadon.api.entity.fission5.Fuli5Index;
import com.amgcyo.cuttadon.api.entity.fission5.Fuli5SignIndex;
import com.amgcyo.cuttadon.api.entity.fission5.Income5Bean;
import com.amgcyo.cuttadon.api.entity.fission5.Invalitation5Bean;
import com.amgcyo.cuttadon.api.entity.fission5.OpenBoxBean;
import com.amgcyo.cuttadon.api.entity.fission5.Task5ResultBean;
import com.amgcyo.cuttadon.api.entity.fission5.TxStepBean;
import com.amgcyo.cuttadon.api.entity.fission5.WithDrawBean;
import com.amgcyo.cuttadon.api.entity.fission5.WithdrawalListBean;
import com.amgcyo.cuttadon.api.entity.fission6.Fission6Index;
import com.amgcyo.cuttadon.api.entity.other.LimitCenterListBean;
import com.amgcyo.cuttadon.api.entity.other.MkAdBean;
import com.amgcyo.cuttadon.api.entity.other.MkAreaCodeBean;
import com.amgcyo.cuttadon.api.entity.other.MkFeedbackHisBean;
import com.amgcyo.cuttadon.api.entity.other.MkUplaodAvatar;
import com.baidu.mobads.sdk.api.ArticleInfo;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import io.reactivex.Observable;
import java.util.List;
import java.util.Map;
import me.jessyan.art.entity.BaseModel;
import okhttp3.MultipartBody;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

/* JADX INFO: compiled from: UserService.java */
/* JADX INFO: loaded from: classes.dex */
public interface f {
    @Headers({"Domain-Name: my"})
    @POST("/v3/gold/open/treasure_chest.api")
    Observable<BaseModel<OpenBoxBean>> a();

    @FormUrlEncoded
    @Headers({"Domain-Name: my"})
    @POST("/v3/gold/video/reward.api")
    Observable<BaseModel<Task5ResultBean>> a(@Field("id") int i2);

    @FormUrlEncoded
    @Headers({"Domain-Name: my"})
    @POST("/v3/gold/my_earnings/index.api")
    Observable<BaseModel<Income5Bean>> a(@Field("tid") int i2, @Field("page") int i3);

    @FormUrlEncoded
    @Headers({"Domain-Name: my"})
    @POST("/v1/comment/report/submit.api")
    Observable<BaseModel> a(@Field("comment_id") int i2, @Field("comment_reply_id") int i3, @Field("type_id") int i4);

    @FormUrlEncoded
    @Headers({"Domain-Name: my"})
    @POST("/v3/gold/withdrawal/action.api")
    Observable<BaseModel<TxStepBean>> a(@Field("amount_id") int i2, @Field("amount_type") int i3, @Field("name") String str, @Field("account") String str2);

    @FormUrlEncoded
    @Headers({"Domain-Name: my"})
    @POST("/v1/service/chapter/err_new.api")
    Observable<BaseModel> a(@Field("book_id") int i2, @Field("type_id") int i3, @Field("chapter_path") String str, @Field("content") String str2, @Field("form") int i4);

    @Headers({"Domain-Name: my"})
    @POST
    Observable<BaseModel<Fuli5Index>> a(@Url String str);

    @FormUrlEncoded
    @Headers({"Domain-Name: my"})
    @POST("/v4/book/fav/del_batch.api")
    Observable<BaseModel> a(@Field("book_id") String str, @Field("form") int i2);

    @FormUrlEncoded
    @Headers({"Domain-Name: my"})
    @POST("/v2/phone/send.api")
    Observable<BaseModel> a(@Field("phone") String str, @Field("type") int i2, @Field("tel") String str2);

    @FormUrlEncoded
    @Headers({"Domain-Name: my"})
    @POST("/v5/phone/cancel.api")
    Observable<BaseModel> a(@Field("phone") String str, @Field("tel") String str2);

    @FormUrlEncoded
    @Headers({"Domain-Name: my"})
    @POST("/v6/pay/order.api")
    Observable<BaseModel<CzOrderBean>> a(@Field("channel") String str, @Field("type") String str2, @Field(PangleAdapterUtils.MEDIA_EXTRA_PRODUCT) int i2);

    @FormUrlEncoded
    @Headers({"Domain-Name: my"})
    @POST("/v2/invitation/bind_phone.api")
    Observable<BaseModel> a(@Field("phone") String str, @Field("phone_code") String str2, @Field("tel") String str3);

    @FormUrlEncoded
    @Headers({"Domain-Name: my"})
    @POST("/v4/center/asking/book/add.api")
    Observable<BaseModel> a(@Field("author") String str, @Field("name") String str2, @Field("remark") String str3, @Field("form") int i2);

    @FormUrlEncoded
    @Headers({"Domain-Name: my"})
    @POST("/{api_version}/reg.api")
    Observable<BaseModel<Base64Bean>> a(@Path("api_version") String str, @Field("login") String str2, @Field("password") String str3, @Field(ArticleInfo.USER_SEX) int i2, @Field("vercode") int i3, @Field("version") String str4, @Field("brand") String str5, @Field("device") String str6, @Field("serial") String str7, @Field("channel") String str8, @Field("phone_code") String str9, @Field("ids") String str10, @Field("code") String str11, @Field("tel") String str12, @Field("encode") int i4);

    @FormUrlEncoded
    @Headers({"Domain-Name: my"})
    @POST("/v2/forgot_password.api")
    Observable<BaseModel> a(@Field("phone") String str, @Field("code") String str2, @Field("password") String str3, @Field("tel") String str4);

    @FormUrlEncoded
    @Headers({"Domain-Name: my"})
    @POST("/{api_version}/login.api")
    Observable<BaseModel<Base64Bean>> a(@Path("api_version") String str, @Field("login") String str2, @Field("password") String str3, @Field("tel") String str4, @Field("encode") int i2);

    @FormUrlEncoded
    @Headers({"Domain-Name: my"})
    @POST("/v6/center/migrate.api")
    Observable<BaseModel<Base64Bean>> a(@Field("user_id") String str, @Field("token") String str2, @Field("package_name") String str3, @Field("channel") String str4, @Field("sign") String str5);

    @FormUrlEncoded
    @Headers({"Domain-Name: my"})
    @POST("/v1/service/add.api")
    Observable<BaseModel> a(@Field("content") String str, @Field("contact") String str2, @Field("app_version") String str3, @Field("os_version") String str4, @Field("device") String str5, @Field("serial") String str6);

    @FormUrlEncoded
    @Headers({"Domain-Name: my"})
    @POST("/v2/service/add.api")
    Observable<BaseModel> a(@Field("content") String str, @Field("contact") String str2, @Field("app_version") String str3, @Field("os_version") String str4, @Field("device") String str5, @Field("serial") String str6, @Field("other_data") String str7);

    @FormUrlEncoded
    @Headers({"Domain-Name: my"})
    @POST("{path}")
    Observable<BaseModel> a(@Path("path") String str, @FieldMap Map<String, Object> map);

    @Headers({"Domain-Name: my"})
    @POST("/v1/center/avatar/upload.api")
    @Multipart
    Observable<BaseModel<MkUplaodAvatar>> a(@Part List<MultipartBody.Part> list);

    @Headers({"Domain-Name: my"})
    @GET("/v1/service/lists.api")
    Observable<BaseModel<List<MkFeedbackHisBean>>> b();

    @FormUrlEncoded
    @Headers({"Domain-Name: my"})
    @POST("/v3/gold/withdrawal/lists.api")
    Observable<BaseModel<List<WithdrawalListBean>>> b(@Field("page") int i2);

    @Headers({"Domain-Name: my"})
    @GET("/v6/pay/lists.api")
    Observable<BaseModel<List<CzRecordBean>>> b(@Query("page") int i2, @Query("limit") int i3);

    @FormUrlEncoded
    @Headers({"Domain-Name: my"})
    @POST("/v2/center/bind/master_code.api")
    Observable<BaseModel> b(@Field("code") String str);

    @FormUrlEncoded
    @Headers({"Domain-Name: my"})
    @POST("/v5/phone/replace.api")
    Observable<BaseModel> b(@Field("phone") String str, @Field("tel") String str2);

    @FormUrlEncoded
    @Headers({"Domain-Name: my"})
    @POST("/v1/center/update/pwd.api")
    Observable<BaseModel> b(@Field("password_old") String str, @Field("password") String str2, @Field("password_confirm") String str3);

    @Headers({"Domain-Name: my"})
    @POST("/v3/gold/withdrawal/index.api")
    Observable<BaseModel<WithDrawBean>> c();

    @Headers({"Domain-Name: my"})
    @GET("/v1/center/comment/lists.api")
    Observable<BaseModel<LimitCenterListBean>> c(@Query("page") int i2);

    @FormUrlEncoded
    @Headers({"Domain-Name: my"})
    @POST("/v6/pay/status.api")
    Observable<BaseModel<MkAdBean>> c(@Field("order_id") String str);

    @FormUrlEncoded
    @Headers({"Domain-Name: my"})
    @POST("/{api_version}/fission/user/data.api")
    Observable<BaseModel<Fission6Index>> c(@Path("api_version") String str, @Field("sign") String str2);

    @FormUrlEncoded
    @Headers({"Domain-Name: my"})
    @POST("/v5/center/account/replace.api")
    Observable<BaseModel> c(@Field("phone") String str, @Field("code") String str2, @Field("tel") String str3);

    @Headers({"Domain-Name: my"})
    @POST("/v3/gold/bind/master_code_10.api")
    Observable<BaseModel<Task5ResultBean>> d();

    @Headers({"Domain-Name: my"})
    @GET("/v4/center/asking/book/lists.api")
    Observable<BaseModel<Base64Bean>> d(@Query("page") int i2);

    @FormUrlEncoded
    @Headers({"Domain-Name: my"})
    @POST("/v5/center/account/cancel.api")
    Observable<BaseModel> d(@Field("code") String str);

    @FormUrlEncoded
    @Headers({"Domain-Name: my"})
    @POST("/v3/gold/bind/master_code.api")
    Observable<BaseModel<Task5ResultBean>> d(@Field("code") String str, @Field("serial") String str2);

    @Headers({"Domain-Name: my"})
    @POST("/v3/gold/video/look.api")
    Observable<BaseModel<Task5ResultBean>> e();

    @Headers({"Domain-Name: my"})
    @GET
    Observable<BaseModel> e(@Url String str);

    @Headers({"Domain-Name: my"})
    @POST("/v3/gold/sign_in.api")
    Observable<BaseModel<Fuli5SignIndex>> f();

    @FormUrlEncoded
    @Headers({"Domain-Name: my"})
    @POST("/v1/center/update/nick.api")
    Observable<BaseModel> f(@Field("nick") String str);

    @Headers({"Domain-Name: my"})
    @GET("/v6/pay/index.api")
    Observable<BaseModel<CzIndexBean>> g();

    @FormUrlEncoded
    @Headers({"Domain-Name: my"})
    @POST("/v1/book/fav/merge.api")
    Observable<BaseModel> g(@Field("book_id") String str);

    @Headers({"Domain-Name: my"})
    @POST("/v2/phone/area_code.api")
    Observable<BaseModel<List<MkAreaCodeBean>>> h();

    @Headers({"Domain-Name: my"})
    @POST("/v3/gold/invitation/index.api")
    Observable<BaseModel<Invalitation5Bean>> i();

    @Headers({"Domain-Name: my"})
    @POST("/v3/gold/receive10000.api")
    Observable<BaseModel<Task5ResultBean>> j();
}
