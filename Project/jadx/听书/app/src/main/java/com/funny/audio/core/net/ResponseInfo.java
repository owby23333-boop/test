package com.funny.audio.core.net;

import com.google.gson.annotations.SerializedName;
import com.kwad.sdk.api.model.AdnName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NetModels.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J1\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015¨\u0006\""}, d2 = {"Lcom/funny/audio/core/net/ResponseInfo;", "", "code", "", "message", "", "requestTime", "", "processingTime", "(ILjava/lang/String;JJ)V", "getCode", "()I", "setCode", "(I)V", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "getProcessingTime", "()J", "setProcessingTime", "(J)V", "getRequestTime", "setRequestTime", "component1", "component2", "component3", "component4", "copy", "equals", "", AdnName.OTHER, "hashCode", "toString", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ResponseInfo {

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("processingTime")
    private long processingTime;

    @SerializedName("requestTime")
    private long requestTime;

    public ResponseInfo() {
        this(0, null, 0L, 0L, 15, null);
    }

    public static /* synthetic */ ResponseInfo copy$default(ResponseInfo responseInfo, int i, String str, long j, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = responseInfo.code;
        }
        if ((i2 & 2) != 0) {
            str = responseInfo.message;
        }
        String str2 = str;
        if ((i2 & 4) != 0) {
            j = responseInfo.requestTime;
        }
        long j3 = j;
        if ((i2 & 8) != 0) {
            j2 = responseInfo.processingTime;
        }
        return responseInfo.copy(i, str2, j3, j2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getRequestTime() {
        return this.requestTime;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getProcessingTime() {
        return this.processingTime;
    }

    public final ResponseInfo copy(int code, String message, long requestTime, long processingTime) {
        Intrinsics.checkNotNullParameter(message, "message");
        return new ResponseInfo(code, message, requestTime, processingTime);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ResponseInfo)) {
            return false;
        }
        ResponseInfo responseInfo = (ResponseInfo) other;
        return this.code == responseInfo.code && Intrinsics.areEqual(this.message, responseInfo.message) && this.requestTime == responseInfo.requestTime && this.processingTime == responseInfo.processingTime;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.code) * 31) + this.message.hashCode()) * 31) + Long.hashCode(this.requestTime)) * 31) + Long.hashCode(this.processingTime);
    }

    public String toString() {
        return "ResponseInfo(code=" + this.code + ", message=" + this.message + ", requestTime=" + this.requestTime + ", processingTime=" + this.processingTime + ")";
    }

    public ResponseInfo(int i, String message, long j, long j2) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.code = i;
        this.message = message;
        this.requestTime = j;
        this.processingTime = j2;
    }

    public /* synthetic */ ResponseInfo(int i, String str, long j, long j2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? 0L : j, (i2 & 8) == 0 ? j2 : 0L);
    }

    public final int getCode() {
        return this.code;
    }

    public final void setCode(int i) {
        this.code = i;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.message = str;
    }

    public final long getRequestTime() {
        return this.requestTime;
    }

    public final void setRequestTime(long j) {
        this.requestTime = j;
    }

    public final long getProcessingTime() {
        return this.processingTime;
    }

    public final void setProcessingTime(long j) {
        this.processingTime = j;
    }
}
