package com.funny.audio.api;

import com.funny.audio.core.net.Response;
import com.funny.audio.models.AdInfo;
import com.funny.audio.models.CloudServiceInfo;
import com.funny.audio.models.CloudUpdateInfo;
import java.util.List;
import kotlin.Metadata;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

/* JADX INFO: compiled from: ICloudApi.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H'J\u001e\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H'J(\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u0007H'J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003H'J\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H'J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003H'J\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H'J\"\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u0007H'¨\u0006\r"}, d2 = {"Lcom/funny/audio/api/ICloudApi;", "", "getAdInfo", "Lcom/funny/audio/core/net/Response;", "", "Lcom/funny/audio/models/AdInfo;", "appKey", "", "channel", "getServiceInfo", "Lcom/funny/audio/models/CloudServiceInfo;", "getUpdateInfo", "Lcom/funny/audio/models/CloudUpdateInfo;", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ICloudApi {
    @Headers({"Cache-Control:no-store"})
    @GET("/cloud/app/appAdg.json")
    Response<List<AdInfo>> getAdInfo();

    @Headers({"Cache-Control:no-store"})
    @GET("/cloud/app/{appKey}/appAdg.json")
    Response<List<AdInfo>> getAdInfo(@Path("appKey") String appKey);

    @Headers({"Cache-Control:no-store"})
    @GET("/cloud/app/{appKey}/{channel}/appAdg.json")
    Response<List<AdInfo>> getAdInfo(@Path("appKey") String appKey, @Path("channel") String channel);

    @Headers({"Cache-Control:no-store"})
    @GET("/cloud/app/appService.json")
    Response<CloudServiceInfo> getServiceInfo();

    @Headers({"Cache-Control:no-store"})
    @GET("/cloud/app/{appKey}/appService.json")
    Response<CloudServiceInfo> getServiceInfo(@Path("appKey") String appKey);

    @Headers({"Cache-Control:no-store"})
    @GET("/cloud/app/update.json")
    Response<CloudUpdateInfo> getUpdateInfo();

    @Headers({"Cache-Control:no-store"})
    @GET("/cloud/app/{appKey}/update.json")
    Response<CloudUpdateInfo> getUpdateInfo(@Path("appKey") String appKey);

    @Headers({"Cache-Control:no-store"})
    @GET("/cloud/app/{appKey}/{channel}/update.json")
    Response<CloudUpdateInfo> getUpdateInfo(@Path("appKey") String appKey, @Path("channel") String channel);
}
