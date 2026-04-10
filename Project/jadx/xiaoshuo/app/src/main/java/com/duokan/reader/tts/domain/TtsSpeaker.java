package com.duokan.reader.tts.domain;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.market.sdk.reflect.Field;
import com.market.sdk.reflect.ReflectUtilsForMiui;
import com.mibi.sdk.component.Constants;
import com.yuewen.so2;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\bG\b\u0086\b\u0018\u0000 Z2\u00020\u0001:\u0001[B\u0083\u0001\u0012\b\b\u0002\u0010\u001d\u001a\u00020\n\u0012\b\b\u0002\u0010\u001e\u001a\u00020\f\u0012\b\b\u0002\u0010\u001f\u001a\u00020\f\u0012\b\b\u0002\u0010 \u001a\u00020\f\u0012\b\b\u0002\u0010!\u001a\u00020\b\u0012\b\b\u0002\u0010\"\u001a\u00020\n\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010%\u001a\u00020\u0015\u0012\b\b\u0002\u0010&\u001a\u00020\n\u0012\b\b\u0002\u0010'\u001a\u00020\n\u0012\b\b\u0002\u0010(\u001a\u00020\b¢\u0006\u0004\bV\u0010WB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\bV\u0010XB\u0011\b\u0016\u0012\u0006\u0010Y\u001a\u00020\f¢\u0006\u0004\bV\u00104J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0096\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0006\u0010\u000e\u001a\u00020\u0002J\t\u0010\u000f\u001a\u00020\nHÆ\u0003J\t\u0010\u0010\u001a\u00020\fHÆ\u0003J\t\u0010\u0011\u001a\u00020\fHÆ\u0003J\t\u0010\u0012\u001a\u00020\fHÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J\t\u0010\u0014\u001a\u00020\nHÆ\u0003J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u0010\u0019\u001a\u00020\u0015HÆ\u0003J\t\u0010\u001a\u001a\u00020\nHÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J\u008c\u0001\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u001d\u001a\u00020\n2\b\b\u0002\u0010\u001e\u001a\u00020\f2\b\b\u0002\u0010\u001f\u001a\u00020\f2\b\b\u0002\u0010 \u001a\u00020\f2\b\b\u0002\u0010!\u001a\u00020\b2\b\b\u0002\u0010\"\u001a\u00020\n2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010%\u001a\u00020\u00152\b\b\u0002\u0010&\u001a\u00020\n2\b\b\u0002\u0010'\u001a\u00020\n2\b\b\u0002\u0010(\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b)\u0010*R\"\u0010\u001d\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u0010\u001e\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u0010\u001f\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u00100\u001a\u0004\b5\u00102\"\u0004\b6\u00104R\"\u0010 \u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u00100\u001a\u0004\b7\u00102\"\u0004\b8\u00104R\"\u0010!\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\"\u0010\"\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010+\u001a\u0004\b>\u0010-\"\u0004\b?\u0010/R$\u0010#\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010@\u001a\u0004\bA\u0010\u0017\"\u0004\bB\u0010CR$\u0010$\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u00100\u001a\u0004\bD\u00102\"\u0004\bE\u00104R\"\u0010%\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\"\u0010&\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010+\u001a\u0004\bK\u0010-\"\u0004\bL\u0010/R\"\u0010'\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010+\u001a\u0004\bM\u0010-\"\u0004\bN\u0010/R\"\u0010(\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u00109\u001a\u0004\bO\u0010;\"\u0004\bP\u0010=R\u0011\u0010Q\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\bQ\u0010;R\u0011\u0010R\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\bR\u0010;R\u0011\u0010S\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\bS\u0010;R\u0011\u0010T\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\bT\u0010;R\u0011\u0010U\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\bU\u0010;¨\u0006\\"}, d2 = {"Lcom/duokan/reader/tts/domain/TtsSpeaker;", "Ljava/io/Serializable;", "Lorg/json/JSONObject;", "jsonObject", "", "parseJsonObject", "", "other", "", "equals", "", TTDownloadField.TT_HASHCODE, "", "toString", "toJSONObject", "component1", "component2", "component3", "component4", "component5", "component6", "", "component7", "()Ljava/lang/Long;", "component8", "component9", "component10", "component11", "component12", "resId", "resName", "resCode", "tag", "defaultTts", "free", Constants.KEY_EXPIRED_TIME, "resUrl", "resSize", "businessType", "status", "setAfterDownload", so2.od, "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Long;Ljava/lang/String;JIIZ)Lcom/duokan/reader/tts/domain/TtsSpeaker;", Field.INT_SIGNATURE_PRIMITIVE, "getResId", "()I", "setResId", "(I)V", "Ljava/lang/String;", "getResName", "()Ljava/lang/String;", "setResName", "(Ljava/lang/String;)V", "getResCode", "setResCode", "getTag", "setTag", Field.BOOLEAN_SIGNATURE_PRIMITIVE, "getDefaultTts", "()Z", "setDefaultTts", "(Z)V", "getFree", "setFree", "Ljava/lang/Long;", "getExpireTime", "setExpireTime", "(Ljava/lang/Long;)V", "getResUrl", "setResUrl", Field.LONG_SIGNATURE_PRIMITIVE, "getResSize", "()J", "setResSize", "(J)V", "getBusinessType", "setBusinessType", "getStatus", "setStatus", "getSetAfterDownload", "setSetAfterDownload", "isEmpty", "isCloud", "isBaseResource", "isDefault", "isOrder", ReflectUtilsForMiui.OBJECT_CONSTRUCTOR, "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Long;Ljava/lang/String;JIIZ)V", "(Lorg/json/JSONObject;)V", "speaker", "Companion", "a", "DkReaderPlayer_release"}, k = 1, mv = {1, 8, 0})
public final /* data */ class TtsSpeaker implements Serializable {
    public static final int STATUS_DOWNLOADED = 101;
    public static final int STATUS_NOT_DOWNLOAD = -1;
    public static final int STATUS_PLAYING = 102;
    private int businessType;
    private boolean defaultTts;

    @Nullable
    private Long expireTime;
    private int free;

    @NotNull
    private String resCode;
    private int resId;

    @NotNull
    private String resName;
    private long resSize;

    @Nullable
    private String resUrl;
    private boolean setAfterDownload;
    private int status;

    @NotNull
    private String tag;

    public TtsSpeaker() {
        this(0, null, null, null, false, 0, null, null, 0L, 0, 0, false, 4095, null);
    }

    private final void parseJsonObject(JSONObject jsonObject) {
        this.resId = jsonObject.optInt("resId");
        String strOptString = jsonObject.optString("resName");
        Intrinsics.checkNotNullExpressionValue(strOptString, "jsonObject.optString(\"resName\")");
        this.resName = strOptString;
        String strOptString2 = jsonObject.optString("resCode");
        Intrinsics.checkNotNullExpressionValue(strOptString2, "jsonObject.optString(\"resCode\")");
        this.resCode = strOptString2;
        String strOptString3 = jsonObject.optString("tag");
        Intrinsics.checkNotNullExpressionValue(strOptString3, "jsonObject.optString(\"tag\")");
        this.tag = strOptString3;
        this.defaultTts = jsonObject.optBoolean("defaultTts");
        this.free = jsonObject.optInt("free");
        this.expireTime = Long.valueOf(jsonObject.optLong(Constants.KEY_EXPIRED_TIME));
        this.resUrl = jsonObject.optString("resUrl");
        this.resSize = jsonObject.optLong("resSize");
        this.businessType = jsonObject.optInt("businessType");
        this.status = jsonObject.optInt("status");
        this.setAfterDownload = jsonObject.optBoolean("setAfterDownload");
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getResId() {
        return this.resId;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final int getBusinessType() {
        return this.businessType;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final boolean getSetAfterDownload() {
        return this.setAfterDownload;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getResName() {
        return this.resName;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getResCode() {
        return this.resCode;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getTag() {
        return this.tag;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getDefaultTts() {
        return this.defaultTts;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getFree() {
        return this.free;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Long getExpireTime() {
        return this.expireTime;
    }

    @Nullable
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getResUrl() {
        return this.resUrl;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final long getResSize() {
        return this.resSize;
    }

    @NotNull
    public final TtsSpeaker copy(int resId, @NotNull String resName, @NotNull String resCode, @NotNull String tag, boolean defaultTts, int free, @Nullable Long expireTime, @Nullable String resUrl, long resSize, int businessType, int status, boolean setAfterDownload) {
        Intrinsics.checkNotNullParameter(resName, "resName");
        Intrinsics.checkNotNullParameter(resCode, "resCode");
        Intrinsics.checkNotNullParameter(tag, "tag");
        return new TtsSpeaker(resId, resName, resCode, tag, defaultTts, free, expireTime, resUrl, resSize, businessType, status, setAfterDownload);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(TtsSpeaker.class, other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.duokan.reader.tts.domain.TtsSpeaker");
        return Intrinsics.areEqual(this.resCode, ((TtsSpeaker) other).resCode);
    }

    public final int getBusinessType() {
        return this.businessType;
    }

    public final boolean getDefaultTts() {
        return this.defaultTts;
    }

    @Nullable
    public final Long getExpireTime() {
        return this.expireTime;
    }

    public final int getFree() {
        return this.free;
    }

    @NotNull
    public final String getResCode() {
        return this.resCode;
    }

    public final int getResId() {
        return this.resId;
    }

    @NotNull
    public final String getResName() {
        return this.resName;
    }

    public final long getResSize() {
        return this.resSize;
    }

    @Nullable
    public final String getResUrl() {
        return this.resUrl;
    }

    public final boolean getSetAfterDownload() {
        return this.setAfterDownload;
    }

    public final int getStatus() {
        return this.status;
    }

    @NotNull
    public final String getTag() {
        return this.tag;
    }

    public int hashCode() {
        int iHashCode = this.resCode.hashCode() * 31;
        String str = this.resUrl;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public final boolean isBaseResource() {
        return this.resId == -1;
    }

    public final boolean isCloud() {
        return TextUtils.isEmpty(this.resUrl);
    }

    public final boolean isDefault() {
        return this.defaultTts;
    }

    public final boolean isEmpty() {
        return TextUtils.isEmpty(this.resCode);
    }

    public final boolean isOrder() {
        return this.businessType == 1;
    }

    public final void setBusinessType(int i) {
        this.businessType = i;
    }

    public final void setDefaultTts(boolean z) {
        this.defaultTts = z;
    }

    public final void setExpireTime(@Nullable Long l) {
        this.expireTime = l;
    }

    public final void setFree(int i) {
        this.free = i;
    }

    public final void setResCode(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.resCode = str;
    }

    public final void setResId(int i) {
        this.resId = i;
    }

    public final void setResName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.resName = str;
    }

    public final void setResSize(long j) {
        this.resSize = j;
    }

    public final void setResUrl(@Nullable String str) {
        this.resUrl = str;
    }

    public final void setSetAfterDownload(boolean z) {
        this.setAfterDownload = z;
    }

    public final void setStatus(int i) {
        this.status = i;
    }

    public final void setTag(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.tag = str;
    }

    @NotNull
    public final JSONObject toJSONObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("resId", this.resId);
        jSONObject.put("resName", this.resName);
        jSONObject.put("resCode", this.resCode);
        jSONObject.put("tag", this.tag);
        jSONObject.put("defaultTts", this.defaultTts);
        jSONObject.put("free", this.free);
        jSONObject.put(Constants.KEY_EXPIRED_TIME, this.expireTime);
        jSONObject.put("resUrl", this.resUrl);
        jSONObject.put("resSize", this.resSize);
        jSONObject.put("businessType", this.businessType);
        jSONObject.put("status", this.status);
        jSONObject.put("setAfterDownload", this.setAfterDownload);
        return jSONObject;
    }

    @NotNull
    public String toString() {
        String string = toJSONObject().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toJSONObject().toString()");
        return string;
    }

    public TtsSpeaker(int i, @NotNull String resName, @NotNull String resCode, @NotNull String tag, boolean z, int i2, @Nullable Long l, @Nullable String str, long j, int i3, int i4, boolean z2) {
        Intrinsics.checkNotNullParameter(resName, "resName");
        Intrinsics.checkNotNullParameter(resCode, "resCode");
        Intrinsics.checkNotNullParameter(tag, "tag");
        this.resId = i;
        this.resName = resName;
        this.resCode = resCode;
        this.tag = tag;
        this.defaultTts = z;
        this.free = i2;
        this.expireTime = l;
        this.resUrl = str;
        this.resSize = j;
        this.businessType = i3;
        this.status = i4;
        this.setAfterDownload = z2;
    }

    public /* synthetic */ TtsSpeaker(int i, String str, String str2, String str3, boolean z, int i2, Long l, String str4, long j, int i3, int i4, boolean z2, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? 0 : i, (i5 & 2) != 0 ? "" : str, (i5 & 4) != 0 ? "" : str2, (i5 & 8) != 0 ? "" : str3, (i5 & 16) != 0 ? false : z, (i5 & 32) != 0 ? 0 : i2, (i5 & 64) != 0 ? 0L : l, (i5 & 128) == 0 ? str4 : "", (i5 & 256) == 0 ? j : 0L, (i5 & 512) == 0 ? i3 : 0, (i5 & 1024) != 0 ? -1 : i4, (i5 & 2048) != 0 ? true : z2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TtsSpeaker(@NotNull JSONObject jsonObject) {
        this(0, null, null, null, false, 0, null, null, 0L, 0, 0, false, 4095, null);
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        try {
            parseJsonObject(jsonObject);
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TtsSpeaker(@NotNull String speaker) {
        this(0, null, null, null, false, 0, null, null, 0L, 0, 0, false, 4095, null);
        Intrinsics.checkNotNullParameter(speaker, "speaker");
        try {
            try {
                parseJsonObject(new JSONObject(speaker));
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
        }
    }
}
