package com.funny.audio.models;

import androidx.core.app.NotificationCompat;
import com.kwad.sdk.api.model.AdnName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AlbumDetailInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u0006\n\u0002\bM\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bå\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001d¢\u0006\u0002\u0010\u001eJ\t\u0010T\u001a\u00020\u0003HÆ\u0003J\u0010\u0010U\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u00106J\t\u0010V\u001a\u00020\u0012HÆ\u0003J\t\u0010W\u001a\u00020\u0012HÆ\u0003J\t\u0010X\u001a\u00020\u000eHÆ\u0003J\t\u0010Y\u001a\u00020\u0003HÆ\u0003J\t\u0010Z\u001a\u00020\u0003HÆ\u0003J\u0010\u0010[\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u00106J\t\u0010\\\u001a\u00020\u0003HÆ\u0003J\t\u0010]\u001a\u00020\u0003HÆ\u0003J\u0010\u0010^\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u00106J\t\u0010_\u001a\u00020\u0003HÆ\u0003J\t\u0010`\u001a\u00020\u001dHÆ\u0003J\u000f\u0010a\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\u000f\u0010b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006HÆ\u0003J\u000f\u0010c\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006HÆ\u0003J\t\u0010d\u001a\u00020\u0003HÆ\u0003J\t\u0010e\u001a\u00020\u000eHÆ\u0003J\t\u0010f\u001a\u00020\u000eHÆ\u0003J\t\u0010g\u001a\u00020\u0003HÆ\u0003Jî\u0001\u0010h\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00062\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00062\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u000e2\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u001c\u001a\u00020\u001dHÆ\u0001¢\u0006\u0002\u0010iJ\u0013\u0010j\u001a\u00020k2\b\u0010l\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010m\u001a\u00020\u000eHÖ\u0001J\t\u0010n\u001a\u00020\u0003HÖ\u0001R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010 \"\u0004\b$\u0010\"R\u001a\u0010\u0014\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010\u0010\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010*\"\u0004\b.\u0010,R\u001a\u0010\u000f\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u0010\u0016\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010*\"\u0004\b4\u0010,R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0010\n\u0002\u00109\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u0010\u0017\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010*\"\u0004\b;\u0010,R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010*\"\u0004\b=\u0010,R\u001a\u0010\u0019\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010*\"\u0004\b?\u0010,R\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0010\n\u0002\u00109\u001a\u0004\b@\u00106\"\u0004\bA\u00108R\u001a\u0010\u001a\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010*\"\u0004\bC\u0010,R\u001a\u0010\u0013\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010&\"\u0004\bE\u0010(R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u0010\n\u0002\u00109\u001a\u0004\bF\u00106\"\u0004\bG\u00108R\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u00100\"\u0004\bM\u00102R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010 \"\u0004\bO\u0010\"R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010*\"\u0004\bQ\u0010,R\u001a\u0010\u0015\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u00100\"\u0004\bS\u00102¨\u0006o"}, d2 = {"Lcom/funny/audio/models/AlbumDetailInfo;", "", "id", "", "title", "announcers", "", "Lcom/funny/audio/models/AnnouncerItem;", "tags", "Lcom/funny/audio/models/TagItem;", "categories", "Lcom/funny/audio/models/CategoryItem;", "coverPath", NotificationCompat.CATEGORY_STATUS, "", "finishStatus", "desc", "publishTime", "", "playCount", "collectCount", "trackCount", "firstTrackId", "firstTrackTitle", "firstTrackTime", "latestTrackId", "latestTrackTitle", "latestTrackTime", "score", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;IILjava/lang/String;Ljava/lang/Long;JJILjava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;D)V", "getAnnouncers", "()Ljava/util/List;", "setAnnouncers", "(Ljava/util/List;)V", "getCategories", "setCategories", "getCollectCount", "()J", "setCollectCount", "(J)V", "getCoverPath", "()Ljava/lang/String;", "setCoverPath", "(Ljava/lang/String;)V", "getDesc", "setDesc", "getFinishStatus", "()I", "setFinishStatus", "(I)V", "getFirstTrackId", "setFirstTrackId", "getFirstTrackTime", "()Ljava/lang/Long;", "setFirstTrackTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getFirstTrackTitle", "setFirstTrackTitle", "getId", "setId", "getLatestTrackId", "setLatestTrackId", "getLatestTrackTime", "setLatestTrackTime", "getLatestTrackTitle", "setLatestTrackTitle", "getPlayCount", "setPlayCount", "getPublishTime", "setPublishTime", "getScore", "()D", "setScore", "(D)V", "getStatus", "setStatus", "getTags", "setTags", "getTitle", "setTitle", "getTrackCount", "setTrackCount", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;IILjava/lang/String;Ljava/lang/Long;JJILjava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;D)Lcom/funny/audio/models/AlbumDetailInfo;", "equals", "", AdnName.OTHER, "hashCode", "toString", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class AlbumDetailInfo {
    private List<AnnouncerItem> announcers;
    private List<CategoryItem> categories;
    private long collectCount;
    private String coverPath;
    private String desc;
    private int finishStatus;
    private String firstTrackId;
    private Long firstTrackTime;
    private String firstTrackTitle;
    private String id;
    private String latestTrackId;
    private Long latestTrackTime;
    private String latestTrackTitle;
    private long playCount;
    private Long publishTime;
    private double score;
    private int status;
    private List<TagItem> tags;
    private String title;
    private int trackCount;

    public AlbumDetailInfo() {
        this(null, null, null, null, null, null, 0, 0, null, null, 0L, 0L, 0, null, null, null, null, null, null, 0.0d, 1048575, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Long getPublishTime() {
        return this.publishTime;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final long getPlayCount() {
        return this.playCount;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final long getCollectCount() {
        return this.collectCount;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final int getTrackCount() {
        return this.trackCount;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getFirstTrackId() {
        return this.firstTrackId;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getFirstTrackTitle() {
        return this.firstTrackTitle;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final Long getFirstTrackTime() {
        return this.firstTrackTime;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getLatestTrackId() {
        return this.latestTrackId;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final String getLatestTrackTitle() {
        return this.latestTrackTitle;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final Long getLatestTrackTime() {
        return this.latestTrackTime;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final double getScore() {
        return this.score;
    }

    public final List<AnnouncerItem> component3() {
        return this.announcers;
    }

    public final List<TagItem> component4() {
        return this.tags;
    }

    public final List<CategoryItem> component5() {
        return this.categories;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getCoverPath() {
        return this.coverPath;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getFinishStatus() {
        return this.finishStatus;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    public final AlbumDetailInfo copy(String id, String title, List<AnnouncerItem> announcers, List<TagItem> tags, List<CategoryItem> categories, String coverPath, int status, int finishStatus, String desc, Long publishTime, long playCount, long collectCount, int trackCount, String firstTrackId, String firstTrackTitle, Long firstTrackTime, String latestTrackId, String latestTrackTitle, Long latestTrackTime, double score) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(announcers, "announcers");
        Intrinsics.checkNotNullParameter(tags, "tags");
        Intrinsics.checkNotNullParameter(categories, "categories");
        Intrinsics.checkNotNullParameter(coverPath, "coverPath");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(firstTrackId, "firstTrackId");
        Intrinsics.checkNotNullParameter(firstTrackTitle, "firstTrackTitle");
        Intrinsics.checkNotNullParameter(latestTrackId, "latestTrackId");
        Intrinsics.checkNotNullParameter(latestTrackTitle, "latestTrackTitle");
        return new AlbumDetailInfo(id, title, announcers, tags, categories, coverPath, status, finishStatus, desc, publishTime, playCount, collectCount, trackCount, firstTrackId, firstTrackTitle, firstTrackTime, latestTrackId, latestTrackTitle, latestTrackTime, score);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AlbumDetailInfo)) {
            return false;
        }
        AlbumDetailInfo albumDetailInfo = (AlbumDetailInfo) other;
        return Intrinsics.areEqual(this.id, albumDetailInfo.id) && Intrinsics.areEqual(this.title, albumDetailInfo.title) && Intrinsics.areEqual(this.announcers, albumDetailInfo.announcers) && Intrinsics.areEqual(this.tags, albumDetailInfo.tags) && Intrinsics.areEqual(this.categories, albumDetailInfo.categories) && Intrinsics.areEqual(this.coverPath, albumDetailInfo.coverPath) && this.status == albumDetailInfo.status && this.finishStatus == albumDetailInfo.finishStatus && Intrinsics.areEqual(this.desc, albumDetailInfo.desc) && Intrinsics.areEqual(this.publishTime, albumDetailInfo.publishTime) && this.playCount == albumDetailInfo.playCount && this.collectCount == albumDetailInfo.collectCount && this.trackCount == albumDetailInfo.trackCount && Intrinsics.areEqual(this.firstTrackId, albumDetailInfo.firstTrackId) && Intrinsics.areEqual(this.firstTrackTitle, albumDetailInfo.firstTrackTitle) && Intrinsics.areEqual(this.firstTrackTime, albumDetailInfo.firstTrackTime) && Intrinsics.areEqual(this.latestTrackId, albumDetailInfo.latestTrackId) && Intrinsics.areEqual(this.latestTrackTitle, albumDetailInfo.latestTrackTitle) && Intrinsics.areEqual(this.latestTrackTime, albumDetailInfo.latestTrackTime) && Double.compare(this.score, albumDetailInfo.score) == 0;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((((((this.id.hashCode() * 31) + this.title.hashCode()) * 31) + this.announcers.hashCode()) * 31) + this.tags.hashCode()) * 31) + this.categories.hashCode()) * 31) + this.coverPath.hashCode()) * 31) + Integer.hashCode(this.status)) * 31) + Integer.hashCode(this.finishStatus)) * 31) + this.desc.hashCode()) * 31;
        Long l = this.publishTime;
        int iHashCode2 = (((((((((((iHashCode + (l == null ? 0 : l.hashCode())) * 31) + Long.hashCode(this.playCount)) * 31) + Long.hashCode(this.collectCount)) * 31) + Integer.hashCode(this.trackCount)) * 31) + this.firstTrackId.hashCode()) * 31) + this.firstTrackTitle.hashCode()) * 31;
        Long l2 = this.firstTrackTime;
        int iHashCode3 = (((((iHashCode2 + (l2 == null ? 0 : l2.hashCode())) * 31) + this.latestTrackId.hashCode()) * 31) + this.latestTrackTitle.hashCode()) * 31;
        Long l3 = this.latestTrackTime;
        return ((iHashCode3 + (l3 != null ? l3.hashCode() : 0)) * 31) + Double.hashCode(this.score);
    }

    public String toString() {
        return "AlbumDetailInfo(id=" + this.id + ", title=" + this.title + ", announcers=" + this.announcers + ", tags=" + this.tags + ", categories=" + this.categories + ", coverPath=" + this.coverPath + ", status=" + this.status + ", finishStatus=" + this.finishStatus + ", desc=" + this.desc + ", publishTime=" + this.publishTime + ", playCount=" + this.playCount + ", collectCount=" + this.collectCount + ", trackCount=" + this.trackCount + ", firstTrackId=" + this.firstTrackId + ", firstTrackTitle=" + this.firstTrackTitle + ", firstTrackTime=" + this.firstTrackTime + ", latestTrackId=" + this.latestTrackId + ", latestTrackTitle=" + this.latestTrackTitle + ", latestTrackTime=" + this.latestTrackTime + ", score=" + this.score + ")";
    }

    public AlbumDetailInfo(String id, String title, List<AnnouncerItem> announcers, List<TagItem> tags, List<CategoryItem> categories, String coverPath, int i, int i2, String desc, Long l, long j, long j2, int i3, String firstTrackId, String firstTrackTitle, Long l2, String latestTrackId, String latestTrackTitle, Long l3, double d) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(announcers, "announcers");
        Intrinsics.checkNotNullParameter(tags, "tags");
        Intrinsics.checkNotNullParameter(categories, "categories");
        Intrinsics.checkNotNullParameter(coverPath, "coverPath");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(firstTrackId, "firstTrackId");
        Intrinsics.checkNotNullParameter(firstTrackTitle, "firstTrackTitle");
        Intrinsics.checkNotNullParameter(latestTrackId, "latestTrackId");
        Intrinsics.checkNotNullParameter(latestTrackTitle, "latestTrackTitle");
        this.id = id;
        this.title = title;
        this.announcers = announcers;
        this.tags = tags;
        this.categories = categories;
        this.coverPath = coverPath;
        this.status = i;
        this.finishStatus = i2;
        this.desc = desc;
        this.publishTime = l;
        this.playCount = j;
        this.collectCount = j2;
        this.trackCount = i3;
        this.firstTrackId = firstTrackId;
        this.firstTrackTitle = firstTrackTitle;
        this.firstTrackTime = l2;
        this.latestTrackId = latestTrackId;
        this.latestTrackTitle = latestTrackTitle;
        this.latestTrackTime = l3;
        this.score = d;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public /* synthetic */ AlbumDetailInfo(String str, String str2, List list, List list2, List list3, String str3, int i, int i2, String str4, Long l, long j, long j2, int i3, String str5, String str6, Long l2, String str7, String str8, Long l3, double d, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? "" : str, (i4 & 2) != 0 ? "" : str2, (i4 & 4) != 0 ? CollectionsKt.emptyList() : list, (i4 & 8) != 0 ? CollectionsKt.emptyList() : list2, (i4 & 16) != 0 ? CollectionsKt.emptyList() : list3, (i4 & 32) != 0 ? "" : str3, (i4 & 64) != 0 ? AlbumStatus.INSTANCE.getNORMAL() : i, (i4 & 128) != 0 ? AlbumFinishStatus.INSTANCE.getFINISHED() : i2, (i4 & 256) != 0 ? "" : str4, (i4 & 512) != 0 ? null : l, (i4 & 1024) != 0 ? 0L : j, (i4 & 2048) == 0 ? j2 : 0L, (i4 & 4096) != 0 ? 0 : i3, (i4 & 8192) != 0 ? "" : str5, (i4 & 16384) != 0 ? "" : str6, (i4 & 32768) != 0 ? null : l2, (i4 & 65536) != 0 ? "" : str7, (i4 & 131072) != 0 ? "" : str8, (i4 & 262144) != 0 ? null : l3, (i4 & 524288) != 0 ? 0.0d : d);
    }

    public final List<AnnouncerItem> getAnnouncers() {
        return this.announcers;
    }

    public final void setAnnouncers(List<AnnouncerItem> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.announcers = list;
    }

    public final List<TagItem> getTags() {
        return this.tags;
    }

    public final void setTags(List<TagItem> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.tags = list;
    }

    public final List<CategoryItem> getCategories() {
        return this.categories;
    }

    public final void setCategories(List<CategoryItem> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.categories = list;
    }

    public final String getCoverPath() {
        return this.coverPath;
    }

    public final void setCoverPath(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.coverPath = str;
    }

    public final int getStatus() {
        return this.status;
    }

    public final void setStatus(int i) {
        this.status = i;
    }

    public final int getFinishStatus() {
        return this.finishStatus;
    }

    public final void setFinishStatus(int i) {
        this.finishStatus = i;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final void setDesc(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.desc = str;
    }

    public final Long getPublishTime() {
        return this.publishTime;
    }

    public final void setPublishTime(Long l) {
        this.publishTime = l;
    }

    public final long getPlayCount() {
        return this.playCount;
    }

    public final void setPlayCount(long j) {
        this.playCount = j;
    }

    public final long getCollectCount() {
        return this.collectCount;
    }

    public final void setCollectCount(long j) {
        this.collectCount = j;
    }

    public final int getTrackCount() {
        return this.trackCount;
    }

    public final void setTrackCount(int i) {
        this.trackCount = i;
    }

    public final String getFirstTrackId() {
        return this.firstTrackId;
    }

    public final void setFirstTrackId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.firstTrackId = str;
    }

    public final String getFirstTrackTitle() {
        return this.firstTrackTitle;
    }

    public final void setFirstTrackTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.firstTrackTitle = str;
    }

    public final Long getFirstTrackTime() {
        return this.firstTrackTime;
    }

    public final void setFirstTrackTime(Long l) {
        this.firstTrackTime = l;
    }

    public final String getLatestTrackId() {
        return this.latestTrackId;
    }

    public final void setLatestTrackId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.latestTrackId = str;
    }

    public final String getLatestTrackTitle() {
        return this.latestTrackTitle;
    }

    public final void setLatestTrackTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.latestTrackTitle = str;
    }

    public final Long getLatestTrackTime() {
        return this.latestTrackTime;
    }

    public final void setLatestTrackTime(Long l) {
        this.latestTrackTime = l;
    }

    public final double getScore() {
        return this.score;
    }

    public final void setScore(double d) {
        this.score = d;
    }
}
