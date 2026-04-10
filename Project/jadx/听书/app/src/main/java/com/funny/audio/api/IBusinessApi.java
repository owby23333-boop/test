package com.funny.audio.api;

import com.funny.audio.core.net.PageData;
import com.funny.audio.core.net.Response;
import com.funny.audio.models.AlbumDetailInfo;
import com.funny.audio.models.AlbumInfo;
import com.funny.audio.models.AlbumTrackAnalysisInfo;
import com.funny.audio.models.AlbumTrackInfo;
import com.funny.audio.models.AlbumUpdateInfo;
import com.funny.audio.models.BannerInfo;
import com.funny.audio.models.CategoryItem;
import com.funny.audio.models.GroupInfo;
import com.funny.audio.models.HotSearchAlbumInfo;
import com.funny.audio.models.TabInfo;
import com.funny.audio.models.UpdateAlbumInfo;
import java.util.List;
import kotlin.Metadata;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

/* JADX INFO: compiled from: IBusinessApi.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H'J(\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00032\b\b\u0001\u0010\u000b\u001a\u00020\u00062\b\b\u0001\u0010\f\u001a\u00020\rH'J(\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00032\b\b\u0001\u0010\u000f\u001a\u00020\u00062\b\b\u0001\u0010\f\u001a\u00020\rH'J(\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00032\b\b\u0001\u0010\u0011\u001a\u00020\u00062\b\b\u0001\u0010\f\u001a\u00020\rH'J\u0018\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'J\u001e\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'J\u0018\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'J\u0014\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00150\u0003H'J\u0014\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u00150\u0003H'J\u001e\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00150\u00032\b\b\u0001\u0010\u001f\u001a\u00020\u0006H'J\u0014\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00150\u0003H'J\u0014\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"0\u0003H'J\u0014\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\"0\u0003H'J\u001e\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00032\b\b\u0001\u0010\f\u001a\u00020\rH'J\u0014\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0\u00150\u0003H'J\u001e\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0\t0\u00032\b\b\u0001\u0010\f\u001a\u00020\rH'¨\u0006*"}, d2 = {"Lcom/funny/audio/api/IBusinessApi;", "", "analysisAlbumTrack", "Lcom/funny/audio/core/net/Response;", "Lcom/funny/audio/models/AlbumTrackAnalysisInfo;", "albumId", "", "trackId", "getAlbumByAnnouncer", "Lcom/funny/audio/core/net/PageData;", "Lcom/funny/audio/models/AlbumInfo;", "announcerId", "page", "", "getAlbumByCategory", "categoryId", "getAlbumByTag", "tagId", "getAlbumDetailInfo", "Lcom/funny/audio/models/AlbumDetailInfo;", "getAlbumTrackList", "", "Lcom/funny/audio/models/AlbumTrackInfo;", "getAlbumUpdateInfo", "Lcom/funny/audio/models/AlbumUpdateInfo;", "getBannerList", "Lcom/funny/audio/models/BannerInfo;", "getCategories", "Lcom/funny/audio/models/CategoryItem;", "getGroupsByTab", "Lcom/funny/audio/models/GroupInfo;", "tabId", "getHomeGroups", "getHotSearchAlbums", "", "Lcom/funny/audio/models/HotSearchAlbumInfo;", "getHotSearchKeyword", "getNewAlbumList", "getTabList", "Lcom/funny/audio/models/TabInfo;", "getUpdateAlbumList", "Lcom/funny/audio/models/UpdateAlbumInfo;", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface IBusinessApi {
    @Headers({"Cache-Control:public,max-age=120"})
    @GET("/api/business/v1/album/analysis/{albumId}/{trackId}.json")
    Response<AlbumTrackAnalysisInfo> analysisAlbumTrack(@Path("albumId") String albumId, @Path("trackId") String trackId);

    @Headers({"Cache-Control:public,max-age=7200"})
    @GET("/api/business/v1/album/list/announcer/{announcerId}/{page}.json")
    Response<PageData<AlbumInfo>> getAlbumByAnnouncer(@Path("announcerId") String announcerId, @Path("page") int page);

    @Headers({"Cache-Control:public,max-age=7200"})
    @GET("/api/business/v1/album/list/category/{categoryId}/{page}.json")
    Response<PageData<AlbumInfo>> getAlbumByCategory(@Path("categoryId") String categoryId, @Path("page") int page);

    @Headers({"Cache-Control:public,max-age=7200"})
    @GET("/api/business/v1/album/list/tag/{tagId}/{page}.json")
    Response<PageData<AlbumInfo>> getAlbumByTag(@Path("tagId") String tagId, @Path("page") int page);

    @Headers({"Cache-Control:public,max-age=120"})
    @GET("/api/business/v1/album/info/{albumId}.json")
    Response<AlbumDetailInfo> getAlbumDetailInfo(@Path("albumId") String albumId);

    @Headers({"Cache-Control:public,max-age=120"})
    @GET("/api/business/v1/album/tracks/{albumId}.json")
    Response<List<AlbumTrackInfo>> getAlbumTrackList(@Path("albumId") String albumId);

    @Headers({"Cache-Control:public,max-age=120"})
    @GET("/api/business/v1/album/update/{albumId}.json")
    Response<AlbumUpdateInfo> getAlbumUpdateInfo(@Path("albumId") String albumId);

    @Headers({"Cache-Control:public,max-age=3600"})
    @GET("/api/business/v1/lib/home/banner/list.json")
    Response<List<BannerInfo>> getBannerList();

    @Headers({"Cache-Control:public,max-age=7200"})
    @GET("/api/business/v1/category/list.json")
    Response<List<CategoryItem>> getCategories();

    @Headers({"Cache-Control:public,max-age=3600"})
    @GET("/api/business/v1/lib/home/tab/{tabId}/groups.json")
    Response<List<GroupInfo>> getGroupsByTab(@Path("tabId") String tabId);

    @Headers({"Cache-Control:public,max-age=3600"})
    @GET("/api/business/v1/lib/home/groups.json")
    Response<List<GroupInfo>> getHomeGroups();

    @Headers({"Cache-Control:public,max-age=3600"})
    @GET("/api/search/v1/albums/hot.json")
    Response<List<HotSearchAlbumInfo>> getHotSearchAlbums();

    @Headers({"Cache-Control:public,max-age=3600"})
    @GET("/api/search/v1/keys/hot.json")
    Response<List<String>> getHotSearchKeyword();

    @Headers({"Cache-Control:public,max-age=120"})
    @GET("/api/business/v1/lib/new/album/{page}.json")
    Response<PageData<AlbumInfo>> getNewAlbumList(@Path("page") int page);

    @Headers({"Cache-Control:public,max-age=3600"})
    @GET("/api/business/v1/lib/home/tab/list.json")
    Response<List<TabInfo>> getTabList();

    @Headers({"Cache-Control:public,max-age=120"})
    @GET("/api/business/v1/lib/update/album/{page}.json")
    Response<PageData<UpdateAlbumInfo>> getUpdateAlbumList(@Path("page") int page);
}
