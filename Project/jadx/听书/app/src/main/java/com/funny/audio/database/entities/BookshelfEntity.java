package com.funny.audio.database.entities;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BookshelfEntity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u001e\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001e\u0010\u001e\u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#R\u001e\u0010'\u001a\u00020(8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010)\"\u0004\b*\u0010+R\u001e\u0010,\u001a\u00020(8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010)\"\u0004\b-\u0010+R\u001a\u0010.\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0018\"\u0004\b0\u0010\u001aR\u001e\u00101\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0018\"\u0004\b3\u0010\u001aR\u001a\u00104\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0018\"\u0004\b6\u0010\u001aR\u001a\u00107\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0006\"\u0004\b9\u0010\bR\u001a\u0010:\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0006\"\u0004\b<\u0010\bR\u001a\u0010=\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0006\"\u0004\b?\u0010\bR\u001a\u0010@\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010!\"\u0004\bB\u0010#R\u001a\u0010C\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010!\"\u0004\bE\u0010#¨\u0006F"}, d2 = {"Lcom/funny/audio/database/entities/BookshelfEntity;", "", "()V", "albumId", "", "getAlbumId", "()Ljava/lang/String;", "setAlbumId", "(Ljava/lang/String;)V", "announcer", "getAnnouncer", "setAnnouncer", "announcerId", "getAnnouncerId", "setAnnouncerId", "category", "getCategory", "setCategory", "categoryId", "getCategoryId", "setCategoryId", "collectTime", "", "getCollectTime", "()J", "setCollectTime", "(J)V", "coverPath", "getCoverPath", "setCoverPath", "dataState", "", "getDataState", "()I", "setDataState", "(I)V", "finishStatus", "getFinishStatus", "setFinishStatus", "isEditMode", "", "()Z", "setEditMode", "(Z)V", "isSelected", "setSelected", "lastReadTime", "getLastReadTime", "setLastReadTime", "lastSyncTime", "getLastSyncTime", "setLastSyncTime", "lastUpdateTime", "getLastUpdateTime", "setLastUpdateTime", "latestTrackId", "getLatestTrackId", "setLatestTrackId", "latestTrackTitle", "getLatestTrackTitle", "setLatestTrackTitle", "title", "getTitle", "setTitle", "trackCount", "getTrackCount", "setTrackCount", "trackIndex", "getTrackIndex", "setTrackIndex", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BookshelfEntity {
    private long collectTime;
    private int dataState;
    private int finishStatus;
    private boolean isEditMode;
    private boolean isSelected;
    private long lastReadTime;
    private long lastSyncTime;
    private long lastUpdateTime;
    private int trackCount;
    private int trackIndex;
    private String albumId = "";
    private String title = "";
    private String announcer = "";
    private String announcerId = "";
    private String categoryId = "";
    private String category = "";
    private String coverPath = "";
    private String latestTrackId = "";
    private String latestTrackTitle = "";

    public final String getAlbumId() {
        return this.albumId;
    }

    public final void setAlbumId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.albumId = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final String getAnnouncer() {
        return this.announcer;
    }

    public final void setAnnouncer(String str) {
        this.announcer = str;
    }

    public final String getAnnouncerId() {
        return this.announcerId;
    }

    public final void setAnnouncerId(String str) {
        this.announcerId = str;
    }

    public final String getCategoryId() {
        return this.categoryId;
    }

    public final void setCategoryId(String str) {
        this.categoryId = str;
    }

    public final String getCategory() {
        return this.category;
    }

    public final void setCategory(String str) {
        this.category = str;
    }

    public final String getCoverPath() {
        return this.coverPath;
    }

    public final void setCoverPath(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.coverPath = str;
    }

    public final int getFinishStatus() {
        return this.finishStatus;
    }

    public final void setFinishStatus(int i) {
        this.finishStatus = i;
    }

    public final int getTrackCount() {
        return this.trackCount;
    }

    public final void setTrackCount(int i) {
        this.trackCount = i;
    }

    public final int getTrackIndex() {
        return this.trackIndex;
    }

    public final void setTrackIndex(int i) {
        this.trackIndex = i;
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

    public final long getLastUpdateTime() {
        return this.lastUpdateTime;
    }

    public final void setLastUpdateTime(long j) {
        this.lastUpdateTime = j;
    }

    public final long getLastReadTime() {
        return this.lastReadTime;
    }

    public final void setLastReadTime(long j) {
        this.lastReadTime = j;
    }

    public final long getLastSyncTime() {
        return this.lastSyncTime;
    }

    public final void setLastSyncTime(long j) {
        this.lastSyncTime = j;
    }

    public final int getDataState() {
        return this.dataState;
    }

    public final void setDataState(int i) {
        this.dataState = i;
    }

    public final long getCollectTime() {
        return this.collectTime;
    }

    public final void setCollectTime(long j) {
        this.collectTime = j;
    }

    /* JADX INFO: renamed from: isSelected, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }

    /* JADX INFO: renamed from: isEditMode, reason: from getter */
    public final boolean getIsEditMode() {
        return this.isEditMode;
    }

    public final void setEditMode(boolean z) {
        this.isEditMode = z;
    }
}
