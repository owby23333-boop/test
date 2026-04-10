package com.funny.audio.api;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.funny.audio.core.net.Response;
import com.funny.audio.core.net.ResponseInfo;
import com.funny.audio.models.CheckAccountReq;
import com.funny.audio.models.EditUserInfoReq;
import com.funny.audio.models.FeedbackReq;
import com.funny.audio.models.GetUserDataReq;
import com.funny.audio.models.LoginAccountReq;
import com.funny.audio.models.PleaseAlbumReq;
import com.funny.audio.models.RegisterAccountReq;
import com.funny.audio.models.SyncUserDataReq;
import com.funny.audio.models.UserDataInfo;
import com.funny.audio.models.UserInfo;
import java.util.List;
import kotlin.Metadata;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/* JADX INFO: compiled from: IUserApi.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H'J\u0012\u0010\u0006\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0007H'J\u0012\u0010\b\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0007H'J\u001e\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n2\b\b\u0001\u0010\u0004\u001a\u00020\rH'J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\nH'J\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\n2\b\b\u0001\u0010\u0004\u001a\u00020\u0011H'J\u0018\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\n2\b\b\u0001\u0010\u0004\u001a\u00020\u0011H'J\u0012\u0010\u0013\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0014H'J\u0012\u0010\u0015\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0016H'J\u0012\u0010\u0017\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0018H'J\u0012\u0010\u0019\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u001aH'J\u0012\u0010\u001b\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0016H'¨\u0006\u001c"}, d2 = {"Lcom/funny/audio/api/IUserApi;", "", "changeUserInfo", "Lcom/funny/audio/core/net/ResponseInfo;", TtmlNode.TAG_BODY, "Lcom/funny/audio/models/EditUserInfoReq;", "checkEmail", "Lcom/funny/audio/models/CheckAccountReq;", "checkPhone", "getUserData", "Lcom/funny/audio/core/net/Response;", "", "Lcom/funny/audio/models/UserDataInfo;", "Lcom/funny/audio/models/GetUserDataReq;", "getUserInfo", "Lcom/funny/audio/models/UserInfo;", "loginByEmail", "Lcom/funny/audio/models/LoginAccountReq;", "loginByPhone", "register", "Lcom/funny/audio/models/RegisterAccountReq;", "removeUserData", "Lcom/funny/audio/models/SyncUserDataReq;", "submitFeedback", "Lcom/funny/audio/models/FeedbackReq;", "submitPleaseAlbum", "Lcom/funny/audio/models/PleaseAlbumReq;", "submitUserData", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface IUserApi {
    @POST("/api/user/v1/change/userinfo")
    ResponseInfo changeUserInfo(@Body EditUserInfoReq body);

    @POST("/api/user/v1/check/email")
    ResponseInfo checkEmail(@Body CheckAccountReq body);

    @POST("/api/user/v1/check/phone")
    ResponseInfo checkPhone(@Body CheckAccountReq body);

    @POST("/api/user/v1/data/sync/get")
    Response<List<UserDataInfo>> getUserData(@Body GetUserDataReq body);

    @GET("/api/user/v1/getinfo")
    Response<UserInfo> getUserInfo();

    @POST("/api/user/v1/login/email")
    Response<UserInfo> loginByEmail(@Body LoginAccountReq body);

    @POST("/api/user/v1/login/phone")
    Response<UserInfo> loginByPhone(@Body LoginAccountReq body);

    @POST("/api/user/v1/register")
    ResponseInfo register(@Body RegisterAccountReq body);

    @POST("/api/user/v1/data/sync/remove")
    ResponseInfo removeUserData(@Body SyncUserDataReq body);

    @POST("/api/report/v1/feedback/submit")
    ResponseInfo submitFeedback(@Body FeedbackReq body);

    @POST("/api/report/v1/please/album/submit")
    ResponseInfo submitPleaseAlbum(@Body PleaseAlbumReq body);

    @POST("/api/user/v1/data/sync/submit")
    ResponseInfo submitUserData(@Body SyncUserDataReq body);
}
