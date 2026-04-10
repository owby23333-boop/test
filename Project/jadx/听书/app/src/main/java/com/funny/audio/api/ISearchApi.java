package com.funny.audio.api;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.funny.audio.core.net.PageData;
import com.funny.audio.core.net.Response;
import com.funny.audio.models.AssociateInfo;
import com.funny.audio.models.SearchAlbumInfo;
import com.funny.audio.models.SearchAlbumReq;
import com.funny.audio.models.SearchAssociateReq;
import java.util.List;
import kotlin.Metadata;
import retrofit2.http.Body;
import retrofit2.http.POST;

/* JADX INFO: compiled from: ISearchApi.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H'J\u001e\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u000bH'¨\u0006\f"}, d2 = {"Lcom/funny/audio/api/ISearchApi;", "", "querySearchAssociates", "Lcom/funny/audio/core/net/Response;", "", "Lcom/funny/audio/models/AssociateInfo;", TtmlNode.TAG_BODY, "Lcom/funny/audio/models/SearchAssociateReq;", "searchAlbums", "Lcom/funny/audio/core/net/PageData;", "Lcom/funny/audio/models/SearchAlbumInfo;", "Lcom/funny/audio/models/SearchAlbumReq;", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ISearchApi {
    @POST("/api/search/v1/associate")
    Response<List<AssociateInfo>> querySearchAssociates(@Body SearchAssociateReq body);

    @POST("/api/search/v1/albums")
    Response<PageData<SearchAlbumInfo>> searchAlbums(@Body SearchAlbumReq body);
}
