package com.funny.audio.api;

import com.funny.audio.core.net.PageData;
import com.funny.audio.core.net.Response;
import com.funny.audio.models.AlertNoticeInfo;
import com.funny.audio.models.SystemNoticeInfo;
import kotlin.Metadata;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

/* JADX INFO: compiled from: INoticeApi.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H'J2\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u000b\u001a\u00020\fH'¨\u0006\r"}, d2 = {"Lcom/funny/audio/api/INoticeApi;", "", "getAlertNotice", "Lcom/funny/audio/core/net/Response;", "Lcom/funny/audio/models/AlertNoticeInfo;", "appKey", "", "channel", "getSystemNoticeList", "Lcom/funny/audio/core/net/PageData;", "Lcom/funny/audio/models/SystemNoticeInfo;", "page", "", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface INoticeApi {
    @Headers({"Cache-Control:public,max-age=120"})
    @GET("/api/notice/alert/{appKey}/{channel}.json")
    Response<AlertNoticeInfo> getAlertNotice(@Path("appKey") String appKey, @Path("channel") String channel);

    @Headers({"Cache-Control:public,max-age=2400"})
    @GET("/api/notice/system/list/{appKey}/{channel}/{page}.json")
    Response<PageData<SystemNoticeInfo>> getSystemNoticeList(@Path("appKey") String appKey, @Path("channel") String channel, @Path("page") int page);
}
