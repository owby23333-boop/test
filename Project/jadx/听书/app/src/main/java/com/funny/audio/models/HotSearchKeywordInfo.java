package com.funny.audio.models;

import com.kwad.sdk.api.model.AdnName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HotSearchKeywordInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0010"}, d2 = {"Lcom/funny/audio/models/HotSearchKeywordInfo;", "", "keyword", "", "(Ljava/lang/String;)V", "getKeyword", "()Ljava/lang/String;", "setKeyword", "component1", "copy", "equals", "", AdnName.OTHER, "hashCode", "", "toString", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class HotSearchKeywordInfo {
    private String keyword;

    public HotSearchKeywordInfo() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ HotSearchKeywordInfo copy$default(HotSearchKeywordInfo hotSearchKeywordInfo, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = hotSearchKeywordInfo.keyword;
        }
        return hotSearchKeywordInfo.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getKeyword() {
        return this.keyword;
    }

    public final HotSearchKeywordInfo copy(String keyword) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        return new HotSearchKeywordInfo(keyword);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof HotSearchKeywordInfo) && Intrinsics.areEqual(this.keyword, ((HotSearchKeywordInfo) other).keyword);
    }

    public int hashCode() {
        return this.keyword.hashCode();
    }

    public String toString() {
        return "HotSearchKeywordInfo(keyword=" + this.keyword + ")";
    }

    public HotSearchKeywordInfo(String keyword) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        this.keyword = keyword;
    }

    public /* synthetic */ HotSearchKeywordInfo(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str);
    }

    public final String getKeyword() {
        return this.keyword;
    }

    public final void setKeyword(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.keyword = str;
    }
}
