package com.funny.audio.database.entities;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AdSettingEntity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001e\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001a\u0010\u001b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\u001a\u0010'\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u000f\"\u0004\b)\u0010\u0011R\u001a\u0010*\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR\u001e\u0010-\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u000f\"\u0004\b/\u0010\u0011R\u001a\u00100\u001a\u000201X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u00106\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u000f\"\u0004\b8\u0010\u0011R\u001a\u00109\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u000f\"\u0004\b;\u0010\u0011¨\u0006<"}, d2 = {"Lcom/funny/audio/database/entities/AdSettingEntity;", "", "()V", "adType", "", "getAdType", "()Ljava/lang/String;", "setAdType", "(Ljava/lang/String;)V", "codeId", "getCodeId", "setCodeId", "createTime", "", "getCreateTime", "()J", "setCreateTime", "(J)V", "description", "getDescription", "setDescription", "freeTime", "getFreeTime", "setFreeTime", "id", "getId", "setId", "key", "getKey", "setKey", "maxShowCount", "", "getMaxShowCount", "()I", "setMaxShowCount", "(I)V", "name", "getName", "setName", "preloadInterval", "getPreloadInterval", "setPreloadInterval", "psign", "getPsign", "setPsign", "rewardDuration", "getRewardDuration", "setRewardDuration", "show", "", "getShow", "()Z", "setShow", "(Z)V", "showInterval", "getShowInterval", "setShowInterval", "updateTime", "getUpdateTime", "setUpdateTime", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AdSettingEntity {
    private long createTime;
    private long freeTime;
    private int maxShowCount;
    private long preloadInterval;
    private long rewardDuration;
    private boolean show;
    private long showInterval;
    private long updateTime;
    private String id = "";
    private String key = "";
    private String name = "";
    private String psign = "";
    private String adType = "default";
    private String codeId = "";
    private String description = "";

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }

    public final String getKey() {
        return this.key;
    }

    public final void setKey(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.key = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final String getPsign() {
        return this.psign;
    }

    public final void setPsign(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.psign = str;
    }

    public final boolean getShow() {
        return this.show;
    }

    public final void setShow(boolean z) {
        this.show = z;
    }

    public final long getFreeTime() {
        return this.freeTime;
    }

    public final void setFreeTime(long j) {
        this.freeTime = j;
    }

    public final long getRewardDuration() {
        return this.rewardDuration;
    }

    public final void setRewardDuration(long j) {
        this.rewardDuration = j;
    }

    public final String getAdType() {
        return this.adType;
    }

    public final void setAdType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.adType = str;
    }

    public final int getMaxShowCount() {
        return this.maxShowCount;
    }

    public final void setMaxShowCount(int i) {
        this.maxShowCount = i;
    }

    public final long getPreloadInterval() {
        return this.preloadInterval;
    }

    public final void setPreloadInterval(long j) {
        this.preloadInterval = j;
    }

    public final long getShowInterval() {
        return this.showInterval;
    }

    public final void setShowInterval(long j) {
        this.showInterval = j;
    }

    public final String getCodeId() {
        return this.codeId;
    }

    public final void setCodeId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.codeId = str;
    }

    public final String getDescription() {
        return this.description;
    }

    public final void setDescription(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.description = str;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final void setCreateTime(long j) {
        this.createTime = j;
    }

    public final long getUpdateTime() {
        return this.updateTime;
    }

    public final void setUpdateTime(long j) {
        this.updateTime = j;
    }
}
