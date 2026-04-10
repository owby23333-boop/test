package com.duokan.bean;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.yuewen.so2;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/duokan/bean/LayerCard;", "Ljava/io/Serializable;", "layerViewShowTimeDistance", "", "(I)V", "getLayerViewShowTimeDistance", "()I", "component1", so2.od, "equals", "", "other", "", TTDownloadField.TT_HASHCODE, "toString", "", "Companion", "network_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class LayerCard implements Serializable {
    public static final int DEFAULT_DISTANCE = 12;
    private final int layerViewShowTimeDistance;

    public LayerCard() {
        this(0, 1, null);
    }

    public static /* synthetic */ LayerCard copy$default(LayerCard layerCard, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = layerCard.layerViewShowTimeDistance;
        }
        return layerCard.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getLayerViewShowTimeDistance() {
        return this.layerViewShowTimeDistance;
    }

    @NotNull
    public final LayerCard copy(int layerViewShowTimeDistance) {
        return new LayerCard(layerViewShowTimeDistance);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof LayerCard) && this.layerViewShowTimeDistance == ((LayerCard) other).layerViewShowTimeDistance;
    }

    public final int getLayerViewShowTimeDistance() {
        return this.layerViewShowTimeDistance;
    }

    public int hashCode() {
        return Integer.hashCode(this.layerViewShowTimeDistance);
    }

    @NotNull
    public String toString() {
        return "LayerCard(layerViewShowTimeDistance=" + this.layerViewShowTimeDistance + ")";
    }

    public LayerCard(int i) {
        this.layerViewShowTimeDistance = i;
    }

    public /* synthetic */ LayerCard(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 12 : i);
    }
}
