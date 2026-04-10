package com.kwad.components.core.video.a;

import android.os.SystemClock;
import com.kwad.components.core.video.j;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.h;

/* JADX INFO: loaded from: classes4.dex */
public final class d extends com.kwad.components.core.video.a.a {
    private String Bh;
    private long abi;
    private long abj;
    private long abk;
    private String abl;
    private boolean abm;
    private boolean abn;
    private boolean abo;
    private long abp;
    private long abq;
    private long abr;
    private long abs;
    private int abt;
    private boolean abu;
    private int mMediaPlayerType;
    private j xp;

    public static class a extends com.kwad.sdk.commercial.c.a {
        public long XI;
        public int abA;
        public String abz;
        public int code;
        public long creativeId;
        public long llsid;
        public String msg;
        public String videoUrl;
    }

    private d(AdTemplate adTemplate, int i, boolean z) {
        this.abm = false;
        this.abn = false;
        this.abo = false;
        this.mMediaPlayerType = 0;
        this.abu = false;
        try {
            AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(adTemplate);
            this.Bh = com.kwad.sdk.core.response.b.a.K(adInfoEl);
            this.abi = com.kwad.sdk.core.response.b.e.ei(adTemplate);
            this.abj = com.kwad.sdk.core.response.b.e.ev(adTemplate);
            this.abk = com.kwad.sdk.core.response.b.a.cp(adInfoEl);
            this.abl = com.kwad.sdk.core.response.b.a.cl(adInfoEl);
            this.abt = com.kwad.sdk.core.response.b.e.ef(adTemplate);
            this.mMediaPlayerType = i;
            this.abu = z;
            this.xp = new j();
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }

    private d(String str, int i) {
        this.abm = false;
        this.abn = false;
        this.abo = false;
        this.abu = false;
        this.Bh = str;
        this.mMediaPlayerType = i;
        this.xp = new j();
    }

    @Override // com.kwad.components.core.video.a.c
    public final void onStart() {
        if (this.abm) {
            return;
        }
        this.abp = SystemClock.elapsedRealtime();
        this.abm = true;
    }

    @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
    public final void onMediaPlayStart() {
        super.onMediaPlayStart();
        if (this.abn) {
            return;
        }
        this.abq = SystemClock.elapsedRealtime();
        this.abn = true;
    }

    @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
    public final void onMediaPlaying() {
        super.onMediaPlaying();
        qm();
        this.xp.ue();
    }

    @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
    public final void onMediaPlayPaused() {
        super.onMediaPlayPaused();
        this.xp.ue();
    }

    @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
    public final void onMediaPlayError(int i, int i2) {
        super.onMediaPlayError(i, i2);
        this.xp.ue();
        b(false, i, i2);
    }

    @Override // com.kwad.components.core.video.a.c
    public final void onRelease() {
        b(true, 0, 0);
    }

    @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.l
    public final void onVideoPlayBufferingPlaying() {
        super.onVideoPlayBufferingPlaying();
        this.xp.ud();
    }

    @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.l
    public final void onVideoPlayBufferingPaused() {
        super.onVideoPlayBufferingPaused();
        this.xp.ud();
    }

    @Override // com.kwad.components.core.video.a.a
    public final void qm() {
        if (this.abo) {
            return;
        }
        this.abr = SystemClock.elapsedRealtime();
        this.abo = true;
    }

    @Override // com.kwad.components.core.video.a.c
    public final void onReset() {
        b(false, 0, 0);
    }

    private void reset() {
        this.xp.reset();
        this.abp = 0L;
        this.abq = 0L;
        this.abs = 0L;
        this.abr = 0L;
        this.abm = false;
        this.abn = false;
        this.abo = false;
    }

    private void a(final boolean z, final int i, final int i2) {
        final b bVarClone = uk().clone();
        h.execute(new bg() { // from class: com.kwad.components.core.video.a.d.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                if (!z) {
                    com.kwad.sdk.commercial.b.u(d.this.p(i, i2));
                } else {
                    com.kwad.sdk.commercial.b.t(bVarClone);
                }
            }
        });
    }

    private void b(boolean z, int i, int i2) {
        if (this.abo) {
            this.xp.ue();
            this.abs = SystemClock.elapsedRealtime();
            a(z, i, i2);
            reset();
        }
    }

    private b uk() {
        b bVar = new b();
        bVar.abB = this.abq - this.abp;
        bVar.abC = this.abr - this.abp;
        bVar.abD = this.xp.ug().uj();
        bVar.videoDuration = this.abs - this.abp;
        bVar.abg = this.xp.ug().ui();
        bVar.videoUrl = this.Bh;
        bVar.llsid = this.abi;
        bVar.creativeId = this.abj;
        bVar.XI = this.abk;
        bVar.abz = this.abl;
        bVar.adStyle = this.abt;
        bVar.abA = this.mMediaPlayerType;
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a p(int i, int i2) {
        a aVar = new a();
        aVar.code = i;
        aVar.msg = String.valueOf(i2);
        aVar.videoUrl = this.Bh;
        aVar.llsid = this.abi;
        aVar.creativeId = this.abj;
        aVar.XI = this.abk;
        aVar.abz = this.abl;
        aVar.abA = this.mMediaPlayerType;
        return aVar;
    }

    public static class b extends com.kwad.sdk.commercial.c.a implements Cloneable {
        public long XI;
        public int abA;
        public long abB;
        public long abC;
        public long abD;
        public int abg;
        public String abz;
        public int adStyle;
        public long creativeId;
        public long llsid;
        public long videoDuration;
        public String videoUrl;

        /* JADX INFO: renamed from: ul, reason: merged with bridge method [inline-methods] */
        public final b clone() {
            try {
                return (b) super.clone();
            } catch (CloneNotSupportedException unused) {
                return new b();
            }
        }
    }

    public static com.kwad.components.core.video.a.a a(AdTemplate adTemplate, int i, boolean z) {
        return com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aBn) ? new d(adTemplate, i, false) : new com.kwad.components.core.video.a.b();
    }

    public static com.kwad.components.core.video.a.a a(AdTemplate adTemplate, AdTemplate adTemplate2, String str, int i, boolean z) {
        if (!com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aBn)) {
            return new com.kwad.components.core.video.a.b();
        }
        if (adTemplate != null) {
            return new d(adTemplate, i, z);
        }
        if (adTemplate2 == null) {
            return new d(str, i);
        }
        return new d(adTemplate2, i, z);
    }
}
