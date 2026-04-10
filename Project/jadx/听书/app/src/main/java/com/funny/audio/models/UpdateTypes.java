package com.funny.audio.models;

import kotlin.Metadata;

/* JADX INFO: compiled from: CloudUpdateInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/funny/audio/models/UpdateTypes;", "", "()V", "AUTO_FORCE", "", "getAUTO_FORCE", "()I", "setAUTO_FORCE", "(I)V", "FORCE", "getFORCE", "setFORCE", "PART_FORCE", "getPART_FORCE", "setPART_FORCE", "SUGGEST", "getSUGGEST", "setSUGGEST", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class UpdateTypes {
    public static final UpdateTypes INSTANCE = new UpdateTypes();
    private static int FORCE = 1;
    private static int PART_FORCE = 2;
    private static int SUGGEST = 3;
    private static int AUTO_FORCE = 10;

    private UpdateTypes() {
    }

    public final int getFORCE() {
        return FORCE;
    }

    public final void setFORCE(int i) {
        FORCE = i;
    }

    public final int getPART_FORCE() {
        return PART_FORCE;
    }

    public final void setPART_FORCE(int i) {
        PART_FORCE = i;
    }

    public final int getSUGGEST() {
        return SUGGEST;
    }

    public final void setSUGGEST(int i) {
        SUGGEST = i;
    }

    public final int getAUTO_FORCE() {
        return AUTO_FORCE;
    }

    public final void setAUTO_FORCE(int i) {
        AUTO_FORCE = i;
    }
}
