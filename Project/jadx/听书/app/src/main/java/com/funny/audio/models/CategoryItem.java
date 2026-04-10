package com.funny.audio.models;

import com.kwad.sdk.api.model.AdnName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AlbumDetailInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/funny/audio/models/CategoryItem;", "", "id", "", "categoryName", "(Ljava/lang/String;Ljava/lang/String;)V", "getCategoryName", "()Ljava/lang/String;", "setCategoryName", "(Ljava/lang/String;)V", "getId", "setId", "component1", "component2", "copy", "equals", "", AdnName.OTHER, "hashCode", "", "toString", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class CategoryItem {
    private String categoryName;
    private String id;

    public CategoryItem() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ CategoryItem copy$default(CategoryItem categoryItem, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = categoryItem.id;
        }
        if ((i & 2) != 0) {
            str2 = categoryItem.categoryName;
        }
        return categoryItem.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCategoryName() {
        return this.categoryName;
    }

    public final CategoryItem copy(String id, String categoryName) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(categoryName, "categoryName");
        return new CategoryItem(id, categoryName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CategoryItem)) {
            return false;
        }
        CategoryItem categoryItem = (CategoryItem) other;
        return Intrinsics.areEqual(this.id, categoryItem.id) && Intrinsics.areEqual(this.categoryName, categoryItem.categoryName);
    }

    public int hashCode() {
        return (this.id.hashCode() * 31) + this.categoryName.hashCode();
    }

    public String toString() {
        return "CategoryItem(id=" + this.id + ", categoryName=" + this.categoryName + ")";
    }

    public CategoryItem(String id, String categoryName) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(categoryName, "categoryName");
        this.id = id;
        this.categoryName = categoryName;
    }

    public /* synthetic */ CategoryItem(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }

    public final String getCategoryName() {
        return this.categoryName;
    }

    public final void setCategoryName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.categoryName = str;
    }
}
