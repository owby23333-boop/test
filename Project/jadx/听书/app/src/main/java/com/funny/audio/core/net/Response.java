package com.funny.audio.core.net;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.gson.annotations.SerializedName;
import com.kwad.sdk.api.model.AdnName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NetModels.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B?\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b¢\u0006\u0002\u0010\fJ\t\u0010\u001f\u001a\u00020\u0004HÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003J\t\u0010!\u001a\u00020\bHÆ\u0003J\u0011\u0010\"\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\nHÆ\u0003J\t\u0010#\u001a\u00020\bHÆ\u0003JI\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\bHÆ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010(\u001a\u00020\u0004HÖ\u0001J\t\u0010)\u001a\u00020\u0006HÖ\u0001R&\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u000b\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001c¨\u0006*"}, d2 = {"Lcom/funny/audio/core/net/Response;", ExifInterface.GPS_DIRECTION_TRUE, "", "code", "", "message", "", "requestTime", "", TtmlNode.TAG_BODY, "Lcom/funny/audio/core/net/AppBody;", "processingTime", "(ILjava/lang/String;JLcom/funny/audio/core/net/AppBody;J)V", "getBody", "()Lcom/funny/audio/core/net/AppBody;", "setBody", "(Lcom/funny/audio/core/net/AppBody;)V", "getCode", "()I", "setCode", "(I)V", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "getProcessingTime", "()J", "setProcessingTime", "(J)V", "getRequestTime", "setRequestTime", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", AdnName.OTHER, "hashCode", "toString", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class Response<T> {

    @SerializedName(TtmlNode.TAG_BODY)
    private AppBody<T> body;

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("processingTime")
    private long processingTime;

    @SerializedName("requestTime")
    private long requestTime;

    public Response() {
        this(0, null, 0L, null, 0L, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Response copy$default(Response response, int i, String str, long j, AppBody appBody, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = response.code;
        }
        if ((i2 & 2) != 0) {
            str = response.message;
        }
        String str2 = str;
        if ((i2 & 4) != 0) {
            j = response.requestTime;
        }
        long j3 = j;
        if ((i2 & 8) != 0) {
            appBody = response.body;
        }
        AppBody appBody2 = appBody;
        if ((i2 & 16) != 0) {
            j2 = response.processingTime;
        }
        return response.copy(i, str2, j3, appBody2, j2);
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

    public final AppBody<T> component4() {
        return this.body;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getProcessingTime() {
        return this.processingTime;
    }

    public final Response<T> copy(int code, String message, long requestTime, AppBody<T> body, long processingTime) {
        Intrinsics.checkNotNullParameter(message, "message");
        return new Response<>(code, message, requestTime, body, processingTime);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Response)) {
            return false;
        }
        Response response = (Response) other;
        return this.code == response.code && Intrinsics.areEqual(this.message, response.message) && this.requestTime == response.requestTime && Intrinsics.areEqual(this.body, response.body) && this.processingTime == response.processingTime;
    }

    public int hashCode() {
        int iHashCode = ((((Integer.hashCode(this.code) * 31) + this.message.hashCode()) * 31) + Long.hashCode(this.requestTime)) * 31;
        AppBody<T> appBody = this.body;
        return ((iHashCode + (appBody == null ? 0 : appBody.hashCode())) * 31) + Long.hashCode(this.processingTime);
    }

    public String toString() {
        return "Response(code=" + this.code + ", message=" + this.message + ", requestTime=" + this.requestTime + ", body=" + this.body + ", processingTime=" + this.processingTime + ")";
    }

    public Response(int i, String message, long j, AppBody<T> appBody, long j2) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.code = i;
        this.message = message;
        this.requestTime = j;
        this.body = appBody;
        this.processingTime = j2;
    }

    public /* synthetic */ Response(int i, String str, long j, AppBody appBody, long j2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? 0L : j, (i2 & 8) != 0 ? null : appBody, (i2 & 16) == 0 ? j2 : 0L);
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

    public final AppBody<T> getBody() {
        return this.body;
    }

    public final void setBody(AppBody<T> appBody) {
        this.body = appBody;
    }

    public final long getProcessingTime() {
        return this.processingTime;
    }

    public final void setProcessingTime(long j) {
        this.processingTime = j;
    }
}
