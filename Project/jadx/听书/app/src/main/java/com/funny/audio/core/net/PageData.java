package com.funny.audio.core.net;

import androidx.exifinterface.media.ExifInterface;
import com.google.gson.annotations.SerializedName;
import com.kwad.sdk.api.model.AdnName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NetModels.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B!\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006HÆ\u0003J+\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR&\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/funny/audio/core/net/PageData;", ExifInterface.GPS_DIRECTION_TRUE, "", "hasNext", "", "items", "", "(ZLjava/util/List;)V", "getHasNext", "()Z", "setHasNext", "(Z)V", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "component1", "component2", "copy", "equals", AdnName.OTHER, "hashCode", "", "toString", "", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class PageData<T> {

    @SerializedName("hasNext")
    private boolean hasNext;

    @SerializedName("items")
    private List<? extends T> items;

    public PageData() {
        this(false, null, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PageData copy$default(PageData pageData, boolean z, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            z = pageData.hasNext;
        }
        if ((i & 2) != 0) {
            list = pageData.items;
        }
        return pageData.copy(z, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getHasNext() {
        return this.hasNext;
    }

    public final List<T> component2() {
        return this.items;
    }

    public final PageData<T> copy(boolean hasNext, List<? extends T> items) {
        return new PageData<>(hasNext, items);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PageData)) {
            return false;
        }
        PageData pageData = (PageData) other;
        return this.hasNext == pageData.hasNext && Intrinsics.areEqual(this.items, pageData.items);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z = this.hasNext;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        List<? extends T> list = this.items;
        return i + (list == null ? 0 : list.hashCode());
    }

    public String toString() {
        return "PageData(hasNext=" + this.hasNext + ", items=" + this.items + ")";
    }

    public PageData(boolean z, List<? extends T> list) {
        this.hasNext = z;
        this.items = list;
    }

    public /* synthetic */ PageData(boolean z, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : list);
    }

    public final boolean getHasNext() {
        return this.hasNext;
    }

    public final void setHasNext(boolean z) {
        this.hasNext = z;
    }

    public final List<T> getItems() {
        return this.items;
    }

    public final void setItems(List<? extends T> list) {
        this.items = list;
    }
}
