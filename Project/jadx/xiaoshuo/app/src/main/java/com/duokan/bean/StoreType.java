package com.duokan.bean;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.gson.annotations.SerializedName;
import com.yuewen.so2;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0086\b\u0018\u0000 -2\u00020\u0001:\u0001-B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004BK\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\n¢\u0006\u0002\u0010\u000fJ\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003J\t\u0010!\u001a\u00020\nHÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\t\u0010#\u001a\u00020\rHÆ\u0003J\t\u0010$\u001a\u00020\nHÆ\u0003JO\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\nHÆ\u0001J\u0013\u0010&\u001a\u00020\r2\b\u0010'\u001a\u0004\u0018\u00010(H\u0096\u0002J\b\u0010)\u001a\u00020\nH\u0016J\u0006\u0010*\u001a\u00020\rJ\u0006\u0010+\u001a\u00020\rJ\t\u0010,\u001a\u00020\u0006HÖ\u0001R\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u000e\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0016\u0010\b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017¨\u0006."}, d2 = {"Lcom/duokan/bean/StoreType;", "Ljava/io/Serializable;", "oldStoreType", "Lcom/duokan/bean/OldStoreType;", "(Lcom/duokan/bean/OldStoreType;)V", "id", "", "title", "uri", "default", "", "type", "isSelected", "", "deviceTab", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ZI)V", "getDefault", "()I", "setDefault", "(I)V", "getDeviceTab", "setDeviceTab", "getId", "()Ljava/lang/String;", "()Z", "setSelected", "(Z)V", "getTitle", "getType", "getUri", "component1", "component2", "component3", "component4", "component5", "component6", "component7", so2.od, "equals", "other", "", TTDownloadField.TT_HASHCODE, "isH5", "isRec", "toString", "Companion", "network_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class StoreType implements Serializable {

    @NotNull
    private static final String ID_REC = "rec";

    @NotNull
    private static final String TYPE_H5 = "h5";

    @SerializedName("default")
    private int default;

    @SerializedName("deviceTab")
    private int deviceTab;

    @SerializedName("id")
    @NotNull
    private final String id;

    @SerializedName("selected")
    private boolean isSelected;

    @SerializedName("title")
    @NotNull
    private final String title;

    @NotNull
    private final String type;

    @SerializedName("uri")
    @NotNull
    private final String uri;

    public StoreType() {
        this(null, null, null, 0, null, false, 0, 127, null);
    }

    public static /* synthetic */ StoreType copy$default(StoreType storeType, String str, String str2, String str3, int i, String str4, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = storeType.id;
        }
        if ((i3 & 2) != 0) {
            str2 = storeType.title;
        }
        String str5 = str2;
        if ((i3 & 4) != 0) {
            str3 = storeType.uri;
        }
        String str6 = str3;
        if ((i3 & 8) != 0) {
            i = storeType.default;
        }
        int i4 = i;
        if ((i3 & 16) != 0) {
            str4 = storeType.type;
        }
        String str7 = str4;
        if ((i3 & 32) != 0) {
            z = storeType.isSelected;
        }
        boolean z2 = z;
        if ((i3 & 64) != 0) {
            i2 = storeType.deviceTab;
        }
        return storeType.copy(str, str5, str6, i4, str7, z2, i2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getUri() {
        return this.uri;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getDefault() {
        return this.default;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getDeviceTab() {
        return this.deviceTab;
    }

    @NotNull
    public final StoreType copy(@NotNull String id, @NotNull String title, @NotNull String uri, int i, @NotNull String type, boolean isSelected, int deviceTab) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(type, "type");
        return new StoreType(id, title, uri, i, type, isSelected, deviceTab);
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof StoreType)) {
            return false;
        }
        StoreType storeType = (StoreType) other;
        return Intrinsics.areEqual(storeType.id, this.id) && Intrinsics.areEqual(storeType.title, this.title) && Intrinsics.areEqual(storeType.uri, this.uri) && storeType.default == this.default && storeType.isSelected == this.isSelected && Intrinsics.areEqual(storeType.type, this.type);
    }

    public final int getDefault() {
        return this.default;
    }

    public final int getDeviceTab() {
        return this.deviceTab;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    @NotNull
    public final String getUri() {
        return this.uri;
    }

    public int hashCode() {
        return (((((((((this.id.hashCode() * 31) + this.title.hashCode()) * 31) + this.uri.hashCode()) * 31) + this.default) * 31) + this.type.hashCode()) * 31) + Boolean.hashCode(this.isSelected);
    }

    public final boolean isH5() {
        return Intrinsics.areEqual(this.type, "h5");
    }

    public final boolean isRec() {
        return Intrinsics.areEqual(this.id, ID_REC);
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setDefault(int i) {
        this.default = i;
    }

    public final void setDeviceTab(int i) {
        this.deviceTab = i;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }

    @NotNull
    public String toString() {
        return "StoreType(id=" + this.id + ", title=" + this.title + ", uri=" + this.uri + ", default=" + this.default + ", type=" + this.type + ", isSelected=" + this.isSelected + ", deviceTab=" + this.deviceTab + ")";
    }

    public StoreType(@NotNull String id, @NotNull String title, @NotNull String uri, int i, @NotNull String type, boolean z, int i2) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(type, "type");
        this.id = id;
        this.title = title;
        this.uri = uri;
        this.default = i;
        this.type = type;
        this.isSelected = z;
        this.deviceTab = i2;
    }

    public /* synthetic */ StoreType(String str, String str2, String str3, int i, String str4, boolean z, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? 0 : i, (i3 & 16) == 0 ? str4 : "", (i3 & 32) != 0 ? true : z, (i3 & 64) != 0 ? 0 : i2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StoreType(@NotNull OldStoreType oldStoreType) {
        this(oldStoreType.getId(), oldStoreType.getTitle(), oldStoreType.getUri(), oldStoreType.getDefault(), oldStoreType.getType(), oldStoreType.isSelected(), 0, 64, null);
        Intrinsics.checkNotNullParameter(oldStoreType, "oldStoreType");
    }
}
