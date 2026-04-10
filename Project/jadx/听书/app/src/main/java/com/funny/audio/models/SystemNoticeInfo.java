package com.funny.audio.models;

import com.kwad.sdk.api.model.AdnName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SystemNoticeInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J;\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0005HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006&"}, d2 = {"Lcom/funny/audio/models/SystemNoticeInfo;", "", "id", "", "type", "", "title", "content", "publishTime", "", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;J)V", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getId", "setId", "getPublishTime", "()J", "setPublishTime", "(J)V", "getTitle", "setTitle", "getType", "()I", "setType", "(I)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", AdnName.OTHER, "hashCode", "toString", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SystemNoticeInfo {
    private String content;
    private String id;
    private long publishTime;
    private String title;
    private int type;

    public SystemNoticeInfo() {
        this(null, 0, null, null, 0L, 31, null);
    }

    public static /* synthetic */ SystemNoticeInfo copy$default(SystemNoticeInfo systemNoticeInfo, String str, int i, String str2, String str3, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = systemNoticeInfo.id;
        }
        if ((i2 & 2) != 0) {
            i = systemNoticeInfo.type;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            str2 = systemNoticeInfo.title;
        }
        String str4 = str2;
        if ((i2 & 8) != 0) {
            str3 = systemNoticeInfo.content;
        }
        String str5 = str3;
        if ((i2 & 16) != 0) {
            j = systemNoticeInfo.publishTime;
        }
        return systemNoticeInfo.copy(str, i3, str4, str5, j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getPublishTime() {
        return this.publishTime;
    }

    public final SystemNoticeInfo copy(String id, int type, String title, String content, long publishTime) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(content, "content");
        return new SystemNoticeInfo(id, type, title, content, publishTime);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SystemNoticeInfo)) {
            return false;
        }
        SystemNoticeInfo systemNoticeInfo = (SystemNoticeInfo) other;
        return Intrinsics.areEqual(this.id, systemNoticeInfo.id) && this.type == systemNoticeInfo.type && Intrinsics.areEqual(this.title, systemNoticeInfo.title) && Intrinsics.areEqual(this.content, systemNoticeInfo.content) && this.publishTime == systemNoticeInfo.publishTime;
    }

    public int hashCode() {
        return (((((((this.id.hashCode() * 31) + Integer.hashCode(this.type)) * 31) + this.title.hashCode()) * 31) + this.content.hashCode()) * 31) + Long.hashCode(this.publishTime);
    }

    public String toString() {
        return "SystemNoticeInfo(id=" + this.id + ", type=" + this.type + ", title=" + this.title + ", content=" + this.content + ", publishTime=" + this.publishTime + ")";
    }

    public SystemNoticeInfo(String id, int i, String title, String content, long j) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(content, "content");
        this.id = id;
        this.type = i;
        this.title = title;
        this.content = content;
        this.publishTime = j;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }

    public /* synthetic */ SystemNoticeInfo(String str, int i, String str2, String str3, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? SystemNoticeTypes.INSTANCE.getCONTENT() : i, (i2 & 4) != 0 ? "" : str2, (i2 & 8) == 0 ? str3 : "", (i2 & 16) != 0 ? 0L : j);
    }

    public final int getType() {
        return this.type;
    }

    public final void setType(int i) {
        this.type = i;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final String getContent() {
        return this.content;
    }

    public final void setContent(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.content = str;
    }

    public final long getPublishTime() {
        return this.publishTime;
    }

    public final void setPublishTime(long j) {
        this.publishTime = j;
    }
}
