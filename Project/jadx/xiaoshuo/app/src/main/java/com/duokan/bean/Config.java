package com.duokan.bean;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.gson.annotations.SerializedName;
import com.yuewen.so2;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/duokan/bean/Config;", "Ljava/io/Serializable;", "count", "", "userType", "module", "(III)V", "getCount", "()I", "getModule", "getUserType", "component1", "component2", "component3", so2.od, "equals", "", "other", "", TTDownloadField.TT_HASHCODE, "toString", "", "network_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class Config implements Serializable {

    @SerializedName("count")
    private final int count;

    @SerializedName("module")
    private final int module;

    @SerializedName("user_type")
    private final int userType;

    public Config() {
        this(0, 0, 0, 7, null);
    }

    public static /* synthetic */ Config copy$default(Config config, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = config.count;
        }
        if ((i4 & 2) != 0) {
            i2 = config.userType;
        }
        if ((i4 & 4) != 0) {
            i3 = config.module;
        }
        return config.copy(i, i2, i3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getCount() {
        return this.count;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getUserType() {
        return this.userType;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getModule() {
        return this.module;
    }

    @NotNull
    public final Config copy(int count, int userType, int module) {
        return new Config(count, userType, module);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Config)) {
            return false;
        }
        Config config = (Config) other;
        return this.count == config.count && this.userType == config.userType && this.module == config.module;
    }

    public final int getCount() {
        return this.count;
    }

    public final int getModule() {
        return this.module;
    }

    public final int getUserType() {
        return this.userType;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.count) * 31) + Integer.hashCode(this.userType)) * 31) + Integer.hashCode(this.module);
    }

    @NotNull
    public String toString() {
        return "Config(count=" + this.count + ", userType=" + this.userType + ", module=" + this.module + ")";
    }

    public Config(int i, int i2, int i3) {
        this.count = i;
        this.userType = i2;
        this.module = i3;
    }

    public /* synthetic */ Config(int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? 0 : i3);
    }
}
