package com.funny.audio.models;

import com.kwad.sdk.api.model.AdnName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AlbumTrackAnalysisInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006¢\u0006\u0002\u0010\nJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u0017\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006HÆ\u0003Ja\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR(\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR(\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000e¨\u0006("}, d2 = {"Lcom/funny/audio/models/AlbumTrackAnalysisInfo;", "", "playType", "", "accessPath", "extras", "", "sourceAlbumId", "sourceTrackId", "sourceExtras", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getAccessPath", "()Ljava/lang/String;", "setAccessPath", "(Ljava/lang/String;)V", "getExtras", "()Ljava/util/Map;", "setExtras", "(Ljava/util/Map;)V", "getPlayType", "setPlayType", "getSourceAlbumId", "setSourceAlbumId", "getSourceExtras", "setSourceExtras", "getSourceTrackId", "setSourceTrackId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", AdnName.OTHER, "hashCode", "", "toString", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class AlbumTrackAnalysisInfo {
    private String accessPath;
    private Map<String, ? extends Object> extras;
    private String playType;
    private String sourceAlbumId;
    private Map<String, ? extends Object> sourceExtras;
    private String sourceTrackId;

    public AlbumTrackAnalysisInfo() {
        this(null, null, null, null, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AlbumTrackAnalysisInfo copy$default(AlbumTrackAnalysisInfo albumTrackAnalysisInfo, String str, String str2, Map map, String str3, String str4, Map map2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = albumTrackAnalysisInfo.playType;
        }
        if ((i & 2) != 0) {
            str2 = albumTrackAnalysisInfo.accessPath;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            map = albumTrackAnalysisInfo.extras;
        }
        Map map3 = map;
        if ((i & 8) != 0) {
            str3 = albumTrackAnalysisInfo.sourceAlbumId;
        }
        String str6 = str3;
        if ((i & 16) != 0) {
            str4 = albumTrackAnalysisInfo.sourceTrackId;
        }
        String str7 = str4;
        if ((i & 32) != 0) {
            map2 = albumTrackAnalysisInfo.sourceExtras;
        }
        return albumTrackAnalysisInfo.copy(str, str5, map3, str6, str7, map2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getPlayType() {
        return this.playType;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAccessPath() {
        return this.accessPath;
    }

    public final Map<String, Object> component3() {
        return this.extras;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSourceAlbumId() {
        return this.sourceAlbumId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getSourceTrackId() {
        return this.sourceTrackId;
    }

    public final Map<String, Object> component6() {
        return this.sourceExtras;
    }

    public final AlbumTrackAnalysisInfo copy(String playType, String accessPath, Map<String, ? extends Object> extras, String sourceAlbumId, String sourceTrackId, Map<String, ? extends Object> sourceExtras) {
        Intrinsics.checkNotNullParameter(playType, "playType");
        Intrinsics.checkNotNullParameter(accessPath, "accessPath");
        Intrinsics.checkNotNullParameter(sourceAlbumId, "sourceAlbumId");
        Intrinsics.checkNotNullParameter(sourceTrackId, "sourceTrackId");
        return new AlbumTrackAnalysisInfo(playType, accessPath, extras, sourceAlbumId, sourceTrackId, sourceExtras);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AlbumTrackAnalysisInfo)) {
            return false;
        }
        AlbumTrackAnalysisInfo albumTrackAnalysisInfo = (AlbumTrackAnalysisInfo) other;
        return Intrinsics.areEqual(this.playType, albumTrackAnalysisInfo.playType) && Intrinsics.areEqual(this.accessPath, albumTrackAnalysisInfo.accessPath) && Intrinsics.areEqual(this.extras, albumTrackAnalysisInfo.extras) && Intrinsics.areEqual(this.sourceAlbumId, albumTrackAnalysisInfo.sourceAlbumId) && Intrinsics.areEqual(this.sourceTrackId, albumTrackAnalysisInfo.sourceTrackId) && Intrinsics.areEqual(this.sourceExtras, albumTrackAnalysisInfo.sourceExtras);
    }

    public int hashCode() {
        int iHashCode = ((this.playType.hashCode() * 31) + this.accessPath.hashCode()) * 31;
        Map<String, ? extends Object> map = this.extras;
        int iHashCode2 = (((((iHashCode + (map == null ? 0 : map.hashCode())) * 31) + this.sourceAlbumId.hashCode()) * 31) + this.sourceTrackId.hashCode()) * 31;
        Map<String, ? extends Object> map2 = this.sourceExtras;
        return iHashCode2 + (map2 != null ? map2.hashCode() : 0);
    }

    public String toString() {
        return "AlbumTrackAnalysisInfo(playType=" + this.playType + ", accessPath=" + this.accessPath + ", extras=" + this.extras + ", sourceAlbumId=" + this.sourceAlbumId + ", sourceTrackId=" + this.sourceTrackId + ", sourceExtras=" + this.sourceExtras + ")";
    }

    public AlbumTrackAnalysisInfo(String playType, String accessPath, Map<String, ? extends Object> map, String sourceAlbumId, String sourceTrackId, Map<String, ? extends Object> map2) {
        Intrinsics.checkNotNullParameter(playType, "playType");
        Intrinsics.checkNotNullParameter(accessPath, "accessPath");
        Intrinsics.checkNotNullParameter(sourceAlbumId, "sourceAlbumId");
        Intrinsics.checkNotNullParameter(sourceTrackId, "sourceTrackId");
        this.playType = playType;
        this.accessPath = accessPath;
        this.extras = map;
        this.sourceAlbumId = sourceAlbumId;
        this.sourceTrackId = sourceTrackId;
        this.sourceExtras = map2;
    }

    public /* synthetic */ AlbumTrackAnalysisInfo(String str, String str2, Map map, String str3, String str4, Map map2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? null : map, (i & 8) != 0 ? "" : str3, (i & 16) == 0 ? str4 : "", (i & 32) != 0 ? null : map2);
    }

    public final String getPlayType() {
        return this.playType;
    }

    public final void setPlayType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.playType = str;
    }

    public final String getAccessPath() {
        return this.accessPath;
    }

    public final void setAccessPath(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.accessPath = str;
    }

    public final Map<String, Object> getExtras() {
        return this.extras;
    }

    public final void setExtras(Map<String, ? extends Object> map) {
        this.extras = map;
    }

    public final String getSourceAlbumId() {
        return this.sourceAlbumId;
    }

    public final void setSourceAlbumId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sourceAlbumId = str;
    }

    public final String getSourceTrackId() {
        return this.sourceTrackId;
    }

    public final void setSourceTrackId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sourceTrackId = str;
    }

    public final Map<String, Object> getSourceExtras() {
        return this.sourceExtras;
    }

    public final void setSourceExtras(Map<String, ? extends Object> map) {
        this.sourceExtras = map;
    }
}
