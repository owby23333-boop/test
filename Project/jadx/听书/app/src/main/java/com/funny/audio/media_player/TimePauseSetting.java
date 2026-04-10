package com.funny.audio.media_player;

import com.kwad.sdk.api.model.AdnName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: PlaySetting.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J1\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0006\u0010\u0011¨\u0006!"}, d2 = {"Lcom/funny/audio/media_player/TimePauseSetting;", "", "enable", "", "type", "", "setValue", "", "value", "(ZIJJ)V", "getEnable", "()Z", "setEnable", "(Z)V", "getSetValue", "()J", "setSetValue", "(J)V", "getType", "()I", "setType", "(I)V", "getValue", "component1", "component2", "component3", "component4", "copy", "equals", AdnName.OTHER, "hashCode", "toString", "", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class TimePauseSetting {
    private boolean enable;
    private long setValue;
    private int type;
    private long value;

    public TimePauseSetting() {
        this(false, 0, 0L, 0L, 15, null);
    }

    public static /* synthetic */ TimePauseSetting copy$default(TimePauseSetting timePauseSetting, boolean z, int i, long j, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = timePauseSetting.enable;
        }
        if ((i2 & 2) != 0) {
            i = timePauseSetting.type;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            j = timePauseSetting.setValue;
        }
        long j3 = j;
        if ((i2 & 8) != 0) {
            j2 = timePauseSetting.value;
        }
        return timePauseSetting.copy(z, i3, j3, j2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getEnable() {
        return this.enable;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getSetValue() {
        return this.setValue;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getValue() {
        return this.value;
    }

    public final TimePauseSetting copy(boolean enable, int type, long setValue, long value) {
        return new TimePauseSetting(enable, type, setValue, value);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TimePauseSetting)) {
            return false;
        }
        TimePauseSetting timePauseSetting = (TimePauseSetting) other;
        return this.enable == timePauseSetting.enable && this.type == timePauseSetting.type && this.setValue == timePauseSetting.setValue && this.value == timePauseSetting.value;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        boolean z = this.enable;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((((r0 * 31) + Integer.hashCode(this.type)) * 31) + Long.hashCode(this.setValue)) * 31) + Long.hashCode(this.value);
    }

    public String toString() {
        return "TimePauseSetting(enable=" + this.enable + ", type=" + this.type + ", setValue=" + this.setValue + ", value=" + this.value + ")";
    }

    public TimePauseSetting(boolean z, int i, long j, long j2) {
        this.enable = z;
        this.type = i;
        this.setValue = j;
        this.value = j2;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final void setEnable(boolean z) {
        this.enable = z;
    }

    public /* synthetic */ TimePauseSetting(boolean z, int i, long j, long j2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? TimePauseType.INSTANCE.getEPISODES() : i, (i2 & 4) != 0 ? 0L : j, (i2 & 8) == 0 ? j2 : 0L);
    }

    public final int getType() {
        return this.type;
    }

    public final void setType(int i) {
        this.type = i;
    }

    public final long getSetValue() {
        return this.setValue;
    }

    public final void setSetValue(long j) {
        this.setValue = j;
    }

    public final long getValue() {
        return this.value;
    }

    public final void setValue(long j) {
        this.value = j;
    }
}
