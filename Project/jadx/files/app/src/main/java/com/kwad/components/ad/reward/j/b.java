package com.kwad.components.ad.reward.j;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.video.i;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    @Nullable
    private IAdLivePlayModule eU;

    @NonNull
    private a gR;
    private int xX = 0;

    public b(@NonNull a aVar) {
        this.gR = aVar;
    }

    public final void a(@Nullable i iVar, @Nullable AdLivePlayStateListener adLivePlayStateListener) {
        if (!jY()) {
            this.gR.a(iVar);
            return;
        }
        IAdLivePlayModule iAdLivePlayModule = this.eU;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.registerAdLivePlayStateListener(adLivePlayStateListener);
        }
    }

    public final void a(@Nullable IAdLivePlayModule iAdLivePlayModule) {
        this.eU = iAdLivePlayModule;
    }

    public final void b(@Nullable i iVar, @Nullable AdLivePlayStateListener adLivePlayStateListener) {
        if (!jY()) {
            this.gR.b(iVar);
            return;
        }
        IAdLivePlayModule iAdLivePlayModule = this.eU;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.unRegisterAdLivePlayStateListener(adLivePlayStateListener);
        }
    }

    public final long getPlayDuration() {
        IAdLivePlayModule iAdLivePlayModule = this.eU;
        return iAdLivePlayModule != null ? iAdLivePlayModule.getPlayDuration() : this.gR.getPlayDuration();
    }

    public final boolean jY() {
        return this.eU != null;
    }

    @Nullable
    public final IAdLivePlayModule jZ() {
        return this.eU;
    }

    @NonNull
    public final a ka() {
        return this.gR;
    }

    public final void pause() {
        IAdLivePlayModule iAdLivePlayModule = this.eU;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.pause();
        } else {
            this.gR.pause();
        }
    }

    public final void release() {
        IAdLivePlayModule iAdLivePlayModule = this.eU;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.release();
        }
        this.gR.release();
    }

    public final void releaseSync() {
        IAdLivePlayModule iAdLivePlayModule = this.eU;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.release();
        }
        this.gR.releaseSync();
    }

    public final void resume() {
        IAdLivePlayModule iAdLivePlayModule = this.eU;
        if (iAdLivePlayModule == null) {
            this.gR.resume();
            return;
        }
        iAdLivePlayModule.resume();
        int i2 = this.xX;
        if (i2 > 0) {
            this.eU.setAudioEnabled(i2 == 2, false);
        }
    }

    public final void setAudioEnabled(boolean z2, boolean z3) {
        this.xX = z2 ? 2 : 1;
        IAdLivePlayModule iAdLivePlayModule = this.eU;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.setAudioEnabled(z2, z3);
        } else {
            this.gR.setAudioEnabled(z2, z3);
        }
    }

    public final void skipToEnd() {
        IAdLivePlayModule iAdLivePlayModule = this.eU;
        if (iAdLivePlayModule != null) {
            iAdLivePlayModule.skipToEnd();
        } else {
            this.gR.skipToEnd();
        }
    }
}
