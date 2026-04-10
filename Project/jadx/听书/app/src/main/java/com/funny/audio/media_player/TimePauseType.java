package com.funny.audio.media_player;

import kotlin.Metadata;

/* JADX INFO: compiled from: PlaySetting.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/funny/audio/media_player/TimePauseType;", "", "()V", "EPISODES", "", "getEPISODES", "()I", "setEPISODES", "(I)V", "MINUTES", "getMINUTES", "setMINUTES", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TimePauseType {
    private static int EPISODES;
    public static final TimePauseType INSTANCE = new TimePauseType();
    private static int MINUTES = 1;

    private TimePauseType() {
    }

    public final int getEPISODES() {
        return EPISODES;
    }

    public final void setEPISODES(int i) {
        EPISODES = i;
    }

    public final int getMINUTES() {
        return MINUTES;
    }

    public final void setMINUTES(int i) {
        MINUTES = i;
    }
}
