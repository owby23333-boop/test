package com.duokan.bean;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.yuewen.so2;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/duokan/bean/VipUiConfig;", "Ljava/io/Serializable;", "useVipButton", "", "(Z)V", "getUseVipButton", "()Z", "component1", so2.od, "equals", "other", "", TTDownloadField.TT_HASHCODE, "", "toString", "", "network_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class VipUiConfig implements Serializable {
    private final boolean useVipButton;

    public VipUiConfig() {
        this(false, 1, null);
    }

    public static /* synthetic */ VipUiConfig copy$default(VipUiConfig vipUiConfig, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = vipUiConfig.useVipButton;
        }
        return vipUiConfig.copy(z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getUseVipButton() {
        return this.useVipButton;
    }

    @NotNull
    public final VipUiConfig copy(boolean useVipButton) {
        return new VipUiConfig(useVipButton);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof VipUiConfig) && this.useVipButton == ((VipUiConfig) other).useVipButton;
    }

    public final boolean getUseVipButton() {
        return this.useVipButton;
    }

    public int hashCode() {
        boolean z = this.useVipButton;
        if (z) {
            return 1;
        }
        return z ? 1 : 0;
    }

    @NotNull
    public String toString() {
        return "VipUiConfig(useVipButton=" + this.useVipButton + ")";
    }

    public VipUiConfig(boolean z) {
        this.useVipButton = z;
    }

    public /* synthetic */ VipUiConfig(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }
}
