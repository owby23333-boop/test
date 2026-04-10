package com.funny.audio.models;

import com.kwad.sdk.api.model.AdnName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CloudServiceInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b$\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003JY\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020+HÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000fR\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\r\"\u0004\b\u001d\u0010\u000f¨\u0006-"}, d2 = {"Lcom/funny/audio/models/CloudServiceInfo;", "", "businessDynamicAddress", "", "businessStaticAddress", "userAddress", "cloudAddress", "staticResource", "searchAddress", "trackResource", "noticeAddress", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBusinessDynamicAddress", "()Ljava/lang/String;", "setBusinessDynamicAddress", "(Ljava/lang/String;)V", "getBusinessStaticAddress", "setBusinessStaticAddress", "getCloudAddress", "setCloudAddress", "getNoticeAddress", "setNoticeAddress", "getSearchAddress", "setSearchAddress", "getStaticResource", "setStaticResource", "getTrackResource", "setTrackResource", "getUserAddress", "setUserAddress", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", AdnName.OTHER, "hashCode", "", "toString", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class CloudServiceInfo {
    private String businessDynamicAddress;
    private String businessStaticAddress;
    private String cloudAddress;
    private String noticeAddress;
    private String searchAddress;
    private String staticResource;
    private String trackResource;
    private String userAddress;

    public CloudServiceInfo() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getBusinessDynamicAddress() {
        return this.businessDynamicAddress;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getBusinessStaticAddress() {
        return this.businessStaticAddress;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getUserAddress() {
        return this.userAddress;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getCloudAddress() {
        return this.cloudAddress;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getStaticResource() {
        return this.staticResource;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getSearchAddress() {
        return this.searchAddress;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getTrackResource() {
        return this.trackResource;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getNoticeAddress() {
        return this.noticeAddress;
    }

    public final CloudServiceInfo copy(String businessDynamicAddress, String businessStaticAddress, String userAddress, String cloudAddress, String staticResource, String searchAddress, String trackResource, String noticeAddress) {
        Intrinsics.checkNotNullParameter(businessDynamicAddress, "businessDynamicAddress");
        Intrinsics.checkNotNullParameter(businessStaticAddress, "businessStaticAddress");
        Intrinsics.checkNotNullParameter(userAddress, "userAddress");
        Intrinsics.checkNotNullParameter(cloudAddress, "cloudAddress");
        Intrinsics.checkNotNullParameter(staticResource, "staticResource");
        Intrinsics.checkNotNullParameter(searchAddress, "searchAddress");
        Intrinsics.checkNotNullParameter(trackResource, "trackResource");
        Intrinsics.checkNotNullParameter(noticeAddress, "noticeAddress");
        return new CloudServiceInfo(businessDynamicAddress, businessStaticAddress, userAddress, cloudAddress, staticResource, searchAddress, trackResource, noticeAddress);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CloudServiceInfo)) {
            return false;
        }
        CloudServiceInfo cloudServiceInfo = (CloudServiceInfo) other;
        return Intrinsics.areEqual(this.businessDynamicAddress, cloudServiceInfo.businessDynamicAddress) && Intrinsics.areEqual(this.businessStaticAddress, cloudServiceInfo.businessStaticAddress) && Intrinsics.areEqual(this.userAddress, cloudServiceInfo.userAddress) && Intrinsics.areEqual(this.cloudAddress, cloudServiceInfo.cloudAddress) && Intrinsics.areEqual(this.staticResource, cloudServiceInfo.staticResource) && Intrinsics.areEqual(this.searchAddress, cloudServiceInfo.searchAddress) && Intrinsics.areEqual(this.trackResource, cloudServiceInfo.trackResource) && Intrinsics.areEqual(this.noticeAddress, cloudServiceInfo.noticeAddress);
    }

    public int hashCode() {
        return (((((((((((((this.businessDynamicAddress.hashCode() * 31) + this.businessStaticAddress.hashCode()) * 31) + this.userAddress.hashCode()) * 31) + this.cloudAddress.hashCode()) * 31) + this.staticResource.hashCode()) * 31) + this.searchAddress.hashCode()) * 31) + this.trackResource.hashCode()) * 31) + this.noticeAddress.hashCode();
    }

    public String toString() {
        return "CloudServiceInfo(businessDynamicAddress=" + this.businessDynamicAddress + ", businessStaticAddress=" + this.businessStaticAddress + ", userAddress=" + this.userAddress + ", cloudAddress=" + this.cloudAddress + ", staticResource=" + this.staticResource + ", searchAddress=" + this.searchAddress + ", trackResource=" + this.trackResource + ", noticeAddress=" + this.noticeAddress + ")";
    }

    public CloudServiceInfo(String businessDynamicAddress, String businessStaticAddress, String userAddress, String cloudAddress, String staticResource, String searchAddress, String trackResource, String noticeAddress) {
        Intrinsics.checkNotNullParameter(businessDynamicAddress, "businessDynamicAddress");
        Intrinsics.checkNotNullParameter(businessStaticAddress, "businessStaticAddress");
        Intrinsics.checkNotNullParameter(userAddress, "userAddress");
        Intrinsics.checkNotNullParameter(cloudAddress, "cloudAddress");
        Intrinsics.checkNotNullParameter(staticResource, "staticResource");
        Intrinsics.checkNotNullParameter(searchAddress, "searchAddress");
        Intrinsics.checkNotNullParameter(trackResource, "trackResource");
        Intrinsics.checkNotNullParameter(noticeAddress, "noticeAddress");
        this.businessDynamicAddress = businessDynamicAddress;
        this.businessStaticAddress = businessStaticAddress;
        this.userAddress = userAddress;
        this.cloudAddress = cloudAddress;
        this.staticResource = staticResource;
        this.searchAddress = searchAddress;
        this.trackResource = trackResource;
        this.noticeAddress = noticeAddress;
    }

    public /* synthetic */ CloudServiceInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6, (i & 64) != 0 ? "" : str7, (i & 128) == 0 ? str8 : "");
    }

    public final String getBusinessDynamicAddress() {
        return this.businessDynamicAddress;
    }

    public final void setBusinessDynamicAddress(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.businessDynamicAddress = str;
    }

    public final String getBusinessStaticAddress() {
        return this.businessStaticAddress;
    }

    public final void setBusinessStaticAddress(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.businessStaticAddress = str;
    }

    public final String getUserAddress() {
        return this.userAddress;
    }

    public final void setUserAddress(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.userAddress = str;
    }

    public final String getCloudAddress() {
        return this.cloudAddress;
    }

    public final void setCloudAddress(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cloudAddress = str;
    }

    public final String getStaticResource() {
        return this.staticResource;
    }

    public final void setStaticResource(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.staticResource = str;
    }

    public final String getSearchAddress() {
        return this.searchAddress;
    }

    public final void setSearchAddress(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.searchAddress = str;
    }

    public final String getTrackResource() {
        return this.trackResource;
    }

    public final void setTrackResource(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.trackResource = str;
    }

    public final String getNoticeAddress() {
        return this.noticeAddress;
    }

    public final void setNoticeAddress(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.noticeAddress = str;
    }
}
