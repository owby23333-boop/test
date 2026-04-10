package com.funny.audio.models;

import com.kwad.sdk.api.model.AdnName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CloudUpdateInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b.\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\b\b\u0002\u0010\f\u001a\u00020\b\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\b¢\u0006\u0002\u0010\u0011J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\bHÆ\u0003J\u000f\u00102\u001a\b\u0012\u0004\u0012\u00020\b0\u000fHÆ\u0003J\t\u00103\u001a\u00020\bHÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\bHÆ\u0003J\t\u00108\u001a\u00020\bHÆ\u0003J\t\u00109\u001a\u00020\bHÆ\u0003J\t\u0010:\u001a\u00020\bHÆ\u0003J\t\u0010;\u001a\u00020\bHÆ\u0003J\u0087\u0001\u0010<\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\b2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\bHÆ\u0001J\u0013\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010@\u001a\u00020\u0003HÖ\u0001J\t\u0010A\u001a\u00020\bHÖ\u0001R\u001a\u0010\u0010\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\t\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0013\"\u0004\b\u001d\u0010\u0015R\u001a\u0010\n\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0013\"\u0004\b\u001f\u0010\u0015R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR\u001a\u0010\u000b\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0013\"\u0004\b#\u0010\u0015R\u001a\u0010\f\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0013\"\u0004\b%\u0010\u0015R\u001a\u0010\r\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0013\"\u0004\b'\u0010\u0015R \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0019\"\u0004\b-\u0010\u001bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0019\"\u0004\b/\u0010\u001b¨\u0006B"}, d2 = {"Lcom/funny/audio/models/CloudUpdateInfo;", "", "upgradeType", "", "latestVersionCode", "minimumVersionCode", "updateType", "latestVersionName", "", "latestDownloadUrl", "manualUpdateUrl", "shareDownloadUrl", "shareHtml", "updateContent", "updateIncludes", "", "feedbackTip", "(IIIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getFeedbackTip", "()Ljava/lang/String;", "setFeedbackTip", "(Ljava/lang/String;)V", "getLatestDownloadUrl", "setLatestDownloadUrl", "getLatestVersionCode", "()I", "setLatestVersionCode", "(I)V", "getLatestVersionName", "setLatestVersionName", "getManualUpdateUrl", "setManualUpdateUrl", "getMinimumVersionCode", "setMinimumVersionCode", "getShareDownloadUrl", "setShareDownloadUrl", "getShareHtml", "setShareHtml", "getUpdateContent", "setUpdateContent", "getUpdateIncludes", "()Ljava/util/List;", "setUpdateIncludes", "(Ljava/util/List;)V", "getUpdateType", "setUpdateType", "getUpgradeType", "setUpgradeType", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", AdnName.OTHER, "hashCode", "toString", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class CloudUpdateInfo {
    private String feedbackTip;
    private String latestDownloadUrl;
    private int latestVersionCode;
    private String latestVersionName;
    private String manualUpdateUrl;
    private int minimumVersionCode;
    private String shareDownloadUrl;
    private String shareHtml;
    private String updateContent;
    private List<String> updateIncludes;
    private int updateType;
    private int upgradeType;

    public CloudUpdateInfo() {
        this(0, 0, 0, 0, null, null, null, null, null, null, null, null, 4095, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getUpgradeType() {
        return this.upgradeType;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getUpdateContent() {
        return this.updateContent;
    }

    public final List<String> component11() {
        return this.updateIncludes;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getFeedbackTip() {
        return this.feedbackTip;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getLatestVersionCode() {
        return this.latestVersionCode;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getMinimumVersionCode() {
        return this.minimumVersionCode;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getUpdateType() {
        return this.updateType;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getLatestVersionName() {
        return this.latestVersionName;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getLatestDownloadUrl() {
        return this.latestDownloadUrl;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getManualUpdateUrl() {
        return this.manualUpdateUrl;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getShareDownloadUrl() {
        return this.shareDownloadUrl;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getShareHtml() {
        return this.shareHtml;
    }

    public final CloudUpdateInfo copy(int upgradeType, int latestVersionCode, int minimumVersionCode, int updateType, String latestVersionName, String latestDownloadUrl, String manualUpdateUrl, String shareDownloadUrl, String shareHtml, String updateContent, List<String> updateIncludes, String feedbackTip) {
        Intrinsics.checkNotNullParameter(latestVersionName, "latestVersionName");
        Intrinsics.checkNotNullParameter(latestDownloadUrl, "latestDownloadUrl");
        Intrinsics.checkNotNullParameter(manualUpdateUrl, "manualUpdateUrl");
        Intrinsics.checkNotNullParameter(shareDownloadUrl, "shareDownloadUrl");
        Intrinsics.checkNotNullParameter(shareHtml, "shareHtml");
        Intrinsics.checkNotNullParameter(updateContent, "updateContent");
        Intrinsics.checkNotNullParameter(updateIncludes, "updateIncludes");
        Intrinsics.checkNotNullParameter(feedbackTip, "feedbackTip");
        return new CloudUpdateInfo(upgradeType, latestVersionCode, minimumVersionCode, updateType, latestVersionName, latestDownloadUrl, manualUpdateUrl, shareDownloadUrl, shareHtml, updateContent, updateIncludes, feedbackTip);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CloudUpdateInfo)) {
            return false;
        }
        CloudUpdateInfo cloudUpdateInfo = (CloudUpdateInfo) other;
        return this.upgradeType == cloudUpdateInfo.upgradeType && this.latestVersionCode == cloudUpdateInfo.latestVersionCode && this.minimumVersionCode == cloudUpdateInfo.minimumVersionCode && this.updateType == cloudUpdateInfo.updateType && Intrinsics.areEqual(this.latestVersionName, cloudUpdateInfo.latestVersionName) && Intrinsics.areEqual(this.latestDownloadUrl, cloudUpdateInfo.latestDownloadUrl) && Intrinsics.areEqual(this.manualUpdateUrl, cloudUpdateInfo.manualUpdateUrl) && Intrinsics.areEqual(this.shareDownloadUrl, cloudUpdateInfo.shareDownloadUrl) && Intrinsics.areEqual(this.shareHtml, cloudUpdateInfo.shareHtml) && Intrinsics.areEqual(this.updateContent, cloudUpdateInfo.updateContent) && Intrinsics.areEqual(this.updateIncludes, cloudUpdateInfo.updateIncludes) && Intrinsics.areEqual(this.feedbackTip, cloudUpdateInfo.feedbackTip);
    }

    public int hashCode() {
        return (((((((((((((((((((((Integer.hashCode(this.upgradeType) * 31) + Integer.hashCode(this.latestVersionCode)) * 31) + Integer.hashCode(this.minimumVersionCode)) * 31) + Integer.hashCode(this.updateType)) * 31) + this.latestVersionName.hashCode()) * 31) + this.latestDownloadUrl.hashCode()) * 31) + this.manualUpdateUrl.hashCode()) * 31) + this.shareDownloadUrl.hashCode()) * 31) + this.shareHtml.hashCode()) * 31) + this.updateContent.hashCode()) * 31) + this.updateIncludes.hashCode()) * 31) + this.feedbackTip.hashCode();
    }

    public String toString() {
        return "CloudUpdateInfo(upgradeType=" + this.upgradeType + ", latestVersionCode=" + this.latestVersionCode + ", minimumVersionCode=" + this.minimumVersionCode + ", updateType=" + this.updateType + ", latestVersionName=" + this.latestVersionName + ", latestDownloadUrl=" + this.latestDownloadUrl + ", manualUpdateUrl=" + this.manualUpdateUrl + ", shareDownloadUrl=" + this.shareDownloadUrl + ", shareHtml=" + this.shareHtml + ", updateContent=" + this.updateContent + ", updateIncludes=" + this.updateIncludes + ", feedbackTip=" + this.feedbackTip + ")";
    }

    public CloudUpdateInfo(int i, int i2, int i3, int i4, String latestVersionName, String latestDownloadUrl, String manualUpdateUrl, String shareDownloadUrl, String shareHtml, String updateContent, List<String> updateIncludes, String feedbackTip) {
        Intrinsics.checkNotNullParameter(latestVersionName, "latestVersionName");
        Intrinsics.checkNotNullParameter(latestDownloadUrl, "latestDownloadUrl");
        Intrinsics.checkNotNullParameter(manualUpdateUrl, "manualUpdateUrl");
        Intrinsics.checkNotNullParameter(shareDownloadUrl, "shareDownloadUrl");
        Intrinsics.checkNotNullParameter(shareHtml, "shareHtml");
        Intrinsics.checkNotNullParameter(updateContent, "updateContent");
        Intrinsics.checkNotNullParameter(updateIncludes, "updateIncludes");
        Intrinsics.checkNotNullParameter(feedbackTip, "feedbackTip");
        this.upgradeType = i;
        this.latestVersionCode = i2;
        this.minimumVersionCode = i3;
        this.updateType = i4;
        this.latestVersionName = latestVersionName;
        this.latestDownloadUrl = latestDownloadUrl;
        this.manualUpdateUrl = manualUpdateUrl;
        this.shareDownloadUrl = shareDownloadUrl;
        this.shareHtml = shareHtml;
        this.updateContent = updateContent;
        this.updateIncludes = updateIncludes;
        this.feedbackTip = feedbackTip;
    }

    public final int getUpgradeType() {
        return this.upgradeType;
    }

    public final void setUpgradeType(int i) {
        this.upgradeType = i;
    }

    public final int getLatestVersionCode() {
        return this.latestVersionCode;
    }

    public final void setLatestVersionCode(int i) {
        this.latestVersionCode = i;
    }

    public final int getMinimumVersionCode() {
        return this.minimumVersionCode;
    }

    public final void setMinimumVersionCode(int i) {
        this.minimumVersionCode = i;
    }

    public final int getUpdateType() {
        return this.updateType;
    }

    public final void setUpdateType(int i) {
        this.updateType = i;
    }

    public final String getLatestVersionName() {
        return this.latestVersionName;
    }

    public final void setLatestVersionName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.latestVersionName = str;
    }

    public final String getLatestDownloadUrl() {
        return this.latestDownloadUrl;
    }

    public final void setLatestDownloadUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.latestDownloadUrl = str;
    }

    public final String getManualUpdateUrl() {
        return this.manualUpdateUrl;
    }

    public final void setManualUpdateUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.manualUpdateUrl = str;
    }

    public final String getShareDownloadUrl() {
        return this.shareDownloadUrl;
    }

    public final void setShareDownloadUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.shareDownloadUrl = str;
    }

    public final String getShareHtml() {
        return this.shareHtml;
    }

    public final void setShareHtml(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.shareHtml = str;
    }

    public final String getUpdateContent() {
        return this.updateContent;
    }

    public final void setUpdateContent(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.updateContent = str;
    }

    public /* synthetic */ CloudUpdateInfo(int i, int i2, int i3, int i4, String str, String str2, String str3, String str4, String str5, String str6, List list, String str7, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? 0 : i, (i5 & 2) != 0 ? 0 : i2, (i5 & 4) != 0 ? 0 : i3, (i5 & 8) == 0 ? i4 : 0, (i5 & 16) != 0 ? "" : str, (i5 & 32) != 0 ? "" : str2, (i5 & 64) != 0 ? "" : str3, (i5 & 128) != 0 ? "" : str4, (i5 & 256) != 0 ? "" : str5, (i5 & 512) != 0 ? "" : str6, (i5 & 1024) != 0 ? new ArrayList() : list, (i5 & 2048) == 0 ? str7 : "");
    }

    public final List<String> getUpdateIncludes() {
        return this.updateIncludes;
    }

    public final void setUpdateIncludes(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.updateIncludes = list;
    }

    public final String getFeedbackTip() {
        return this.feedbackTip;
    }

    public final void setFeedbackTip(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.feedbackTip = str;
    }
}
