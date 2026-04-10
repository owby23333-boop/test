package com.funny.audio.settings;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AppSettingEntity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001a\u0010\u001b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u00100\u001a\u000201X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u00106\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0012\"\u0004\b8\u0010\u0014¨\u00069"}, d2 = {"Lcom/funny/audio/settings/AppSettingEntity;", "", "()V", "desc", "", "getDesc", "()Ljava/lang/String;", "setDesc", "(Ljava/lang/String;)V", "name", "getName", "setName", "settingKey", "getSettingKey", "setSettingKey", "time", "", "getTime", "()J", "setTime", "(J)V", "type", "getType", "setType", "userId", "getUserId", "setUserId", "value", "getValue", "setValue", "valueBoolean", "", "getValueBoolean", "()Z", "setValueBoolean", "(Z)V", "valueDouble", "", "getValueDouble", "()D", "setValueDouble", "(D)V", "valueFloat", "", "getValueFloat", "()F", "setValueFloat", "(F)V", "valueInt", "", "getValueInt", "()I", "setValueInt", "(I)V", "valueLong", "getValueLong", "setValueLong", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AppSettingEntity {
    private boolean valueBoolean;
    private double valueDouble;
    private float valueFloat;
    private int valueInt;
    private long valueLong;
    private String settingKey = "";
    private String type = "";
    private String name = "";
    private String desc = "";
    private long time = System.currentTimeMillis();
    private String userId = "";
    private String value = "";

    public final String getSettingKey() {
        return this.settingKey;
    }

    public final void setSettingKey(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.settingKey = str;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.type = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final void setDesc(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.desc = str;
    }

    public final long getTime() {
        return this.time;
    }

    public final void setTime(long j) {
        this.time = j;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final void setUserId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.userId = str;
    }

    public final String getValue() {
        return this.value;
    }

    public final void setValue(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.value = str;
    }

    public final boolean getValueBoolean() {
        return this.valueBoolean;
    }

    public final void setValueBoolean(boolean z) {
        this.valueBoolean = z;
    }

    public final int getValueInt() {
        return this.valueInt;
    }

    public final void setValueInt(int i) {
        this.valueInt = i;
    }

    public final long getValueLong() {
        return this.valueLong;
    }

    public final void setValueLong(long j) {
        this.valueLong = j;
    }

    public final float getValueFloat() {
        return this.valueFloat;
    }

    public final void setValueFloat(float f) {
        this.valueFloat = f;
    }

    public final double getValueDouble() {
        return this.valueDouble;
    }

    public final void setValueDouble(double d) {
        this.valueDouble = d;
    }
}
