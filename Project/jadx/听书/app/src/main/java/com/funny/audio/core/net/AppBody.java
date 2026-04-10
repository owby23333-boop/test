package com.funny.audio.core.net;

import androidx.exifinterface.media.ExifInterface;
import com.google.gson.annotations.SerializedName;
import com.kwad.sdk.api.model.AdnName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NetModels.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B)\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00018\u0000\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00018\u0000HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0003J8\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00018\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0004HÖ\u0001R\"\u0010\u0005\u001a\u0004\u0018\u00018\u00008\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/funny/audio/core/net/AppBody;", ExifInterface.GPS_DIRECTION_TRUE, "", "encType", "", "data", "encData", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;)V", "getData", "()Ljava/lang/Object;", "setData", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "getEncData", "()Ljava/lang/String;", "setEncData", "(Ljava/lang/String;)V", "getEncType", "setEncType", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;)Lcom/funny/audio/core/net/AppBody;", "equals", "", AdnName.OTHER, "hashCode", "", "toString", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class AppBody<T> {

    @SerializedName("data")
    private T data;

    @SerializedName("encData")
    private String encData;

    @SerializedName("encType")
    private String encType;

    public AppBody() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AppBody copy$default(AppBody appBody, String str, Object obj, String str2, int i, Object obj2) {
        if ((i & 1) != 0) {
            str = appBody.encType;
        }
        if ((i & 2) != 0) {
            obj = appBody.data;
        }
        if ((i & 4) != 0) {
            str2 = appBody.encData;
        }
        return appBody.copy(str, obj, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getEncType() {
        return this.encType;
    }

    public final T component2() {
        return this.data;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getEncData() {
        return this.encData;
    }

    public final AppBody<T> copy(String encType, T data, String encData) {
        return new AppBody<>(encType, data, encData);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppBody)) {
            return false;
        }
        AppBody appBody = (AppBody) other;
        return Intrinsics.areEqual(this.encType, appBody.encType) && Intrinsics.areEqual(this.data, appBody.data) && Intrinsics.areEqual(this.encData, appBody.encData);
    }

    public int hashCode() {
        String str = this.encType;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        T t = this.data;
        int iHashCode2 = (iHashCode + (t == null ? 0 : t.hashCode())) * 31;
        String str2 = this.encData;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "AppBody(encType=" + this.encType + ", data=" + this.data + ", encData=" + this.encData + ")";
    }

    public AppBody(String str, T t, String str2) {
        this.encType = str;
        this.data = t;
        this.encData = str2;
    }

    public /* synthetic */ AppBody(String str, Object obj, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? null : obj, (i & 4) != 0 ? "" : str2);
    }

    public final String getEncType() {
        return this.encType;
    }

    public final void setEncType(String str) {
        this.encType = str;
    }

    public final T getData() {
        return this.data;
    }

    public final void setData(T t) {
        this.data = t;
    }

    public final String getEncData() {
        return this.encData;
    }

    public final void setEncData(String str) {
        this.encData = str;
    }
}
