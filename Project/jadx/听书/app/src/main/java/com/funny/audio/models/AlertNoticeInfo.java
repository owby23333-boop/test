package com.funny.audio.models;

import com.kwad.sdk.api.model.AdnName;
import com.xuexiang.xupdate.proxy.impl.DefaultUpdateParser;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AlertNoticeInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b$\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005¢\u0006\u0002\u0010\rJ\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\tHÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003JY\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0005HÆ\u0001J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u00020\u0005HÖ\u0001J\t\u00101\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000f\"\u0004\b\u001f\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0017\"\u0004\b!\u0010\u0019R\u001a\u0010\f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0017\"\u0004\b#\u0010\u0019¨\u00062"}, d2 = {"Lcom/funny/audio/models/AlertNoticeInfo;", "", "id", "", "type", "", "title", "content", "publishTime", "", "okType", "okContent", DefaultUpdateParser.APIKeyLower.VERSION_CODE, "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;JILjava/lang/String;I)V", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getId", "setId", "getOkContent", "setOkContent", "getOkType", "()I", "setOkType", "(I)V", "getPublishTime", "()J", "setPublishTime", "(J)V", "getTitle", "setTitle", "getType", "setType", "getVersionCode", "setVersionCode", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", AdnName.OTHER, "hashCode", "toString", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class AlertNoticeInfo {
    private String content;
    private String id;
    private String okContent;
    private int okType;
    private long publishTime;
    private String title;
    private int type;
    private int versionCode;

    public AlertNoticeInfo() {
        this(null, 0, null, null, 0L, 0, null, 0, 255, null);
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

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getOkType() {
        return this.okType;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getOkContent() {
        return this.okContent;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getVersionCode() {
        return this.versionCode;
    }

    public final AlertNoticeInfo copy(String id, int type, String title, String content, long publishTime, int okType, String okContent, int versionCode) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(okContent, "okContent");
        return new AlertNoticeInfo(id, type, title, content, publishTime, okType, okContent, versionCode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AlertNoticeInfo)) {
            return false;
        }
        AlertNoticeInfo alertNoticeInfo = (AlertNoticeInfo) other;
        return Intrinsics.areEqual(this.id, alertNoticeInfo.id) && this.type == alertNoticeInfo.type && Intrinsics.areEqual(this.title, alertNoticeInfo.title) && Intrinsics.areEqual(this.content, alertNoticeInfo.content) && this.publishTime == alertNoticeInfo.publishTime && this.okType == alertNoticeInfo.okType && Intrinsics.areEqual(this.okContent, alertNoticeInfo.okContent) && this.versionCode == alertNoticeInfo.versionCode;
    }

    public int hashCode() {
        return (((((((((((((this.id.hashCode() * 31) + Integer.hashCode(this.type)) * 31) + this.title.hashCode()) * 31) + this.content.hashCode()) * 31) + Long.hashCode(this.publishTime)) * 31) + Integer.hashCode(this.okType)) * 31) + this.okContent.hashCode()) * 31) + Integer.hashCode(this.versionCode);
    }

    public String toString() {
        return "AlertNoticeInfo(id=" + this.id + ", type=" + this.type + ", title=" + this.title + ", content=" + this.content + ", publishTime=" + this.publishTime + ", okType=" + this.okType + ", okContent=" + this.okContent + ", versionCode=" + this.versionCode + ")";
    }

    public AlertNoticeInfo(String id, int i, String title, String content, long j, int i2, String okContent, int i3) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(okContent, "okContent");
        this.id = id;
        this.type = i;
        this.title = title;
        this.content = content;
        this.publishTime = j;
        this.okType = i2;
        this.okContent = okContent;
        this.versionCode = i3;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }

    public /* synthetic */ AlertNoticeInfo(String str, int i, String str2, String str3, long j, int i2, String str4, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? "" : str, (i4 & 2) != 0 ? AlertNoticeTypes.INSTANCE.getTEXT() : i, (i4 & 4) != 0 ? "" : str2, (i4 & 8) != 0 ? "" : str3, (i4 & 16) != 0 ? 0L : j, (i4 & 32) != 0 ? 0 : i2, (i4 & 64) == 0 ? str4 : "", (i4 & 128) == 0 ? i3 : 0);
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

    public final int getOkType() {
        return this.okType;
    }

    public final void setOkType(int i) {
        this.okType = i;
    }

    public final String getOkContent() {
        return this.okContent;
    }

    public final void setOkContent(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.okContent = str;
    }

    public final int getVersionCode() {
        return this.versionCode;
    }

    public final void setVersionCode(int i) {
        this.versionCode = i;
    }
}
