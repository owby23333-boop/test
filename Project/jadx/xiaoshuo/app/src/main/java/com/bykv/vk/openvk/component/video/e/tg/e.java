package com.bykv.vk.openvk.component.video.e.tg;

import com.bykv.vk.openvk.component.video.e.tg.d;

/* JADX INFO: loaded from: classes.dex */
public abstract class e implements d {
    private d.ga bf;
    private d.bf d;
    protected boolean e = false;
    private d.vn ga;
    private d.InterfaceC0060d p;
    private d.e tg;
    private d.tg v;
    private d.p vn;

    public final void bf() {
        try {
            d.ga gaVar = this.bf;
            if (gaVar != null) {
                gaVar.bf(this);
            }
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.vn.d.d("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnPrepared error: ", th);
        }
    }

    public final void d() {
        try {
            d.bf bfVar = this.d;
            if (bfVar != null) {
                bfVar.e(this);
            }
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.vn.d.d("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnCompletion error: ", th);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.e.tg.d
    public final void e(d.ga gaVar) {
        this.bf = gaVar;
    }

    public final void tg() {
        try {
            d.vn vnVar = this.ga;
            if (vnVar != null) {
                vnVar.d(this);
            }
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.vn.d.d("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnSeekComplete error: ", th);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.e.tg.d
    public final void e(d.bf bfVar) {
        this.d = bfVar;
    }

    @Override // com.bykv.vk.openvk.component.video.e.tg.d
    public final void e(d.e eVar) {
        this.tg = eVar;
    }

    public final boolean bf(int i, int i2) {
        try {
            d.tg tgVar = this.v;
            if (tgVar != null) {
                return tgVar.bf(this, i, i2);
            }
            return false;
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.vn.d.d("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnInfo error: ", th);
            return false;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.e.tg.d
    public final void e(d.vn vnVar) {
        this.ga = vnVar;
    }

    @Override // com.bykv.vk.openvk.component.video.e.tg.d
    public final void e(d.InterfaceC0060d interfaceC0060d) {
        this.p = interfaceC0060d;
    }

    @Override // com.bykv.vk.openvk.component.video.e.tg.d
    public final void e(d.tg tgVar) {
        this.v = tgVar;
    }

    @Override // com.bykv.vk.openvk.component.video.e.tg.d
    public final void e(d.p pVar) {
        this.vn = pVar;
    }

    public void e() {
        this.bf = null;
        this.tg = null;
        this.d = null;
        this.ga = null;
        this.vn = null;
        this.p = null;
        this.v = null;
    }

    public final void e(int i) {
        try {
            d.e eVar = this.tg;
            if (eVar != null) {
                eVar.e(this, i);
            }
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.vn.d.d("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnBufferingUpdate error: ", th);
        }
    }

    public final void e(int i, int i2, int i3, int i4) {
        try {
            d.p pVar = this.vn;
            if (pVar != null) {
                pVar.e(this, i, i2, i3, i4);
            }
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.vn.d.d("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnVideoSizeChanged error: ", th);
        }
    }

    public final boolean e(int i, int i2) {
        try {
            d.InterfaceC0060d interfaceC0060d = this.p;
            if (interfaceC0060d != null) {
                return interfaceC0060d.e(this, i, i2);
            }
            return false;
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.vn.d.d("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnError error: ", th);
            return false;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.e.tg.d
    public void e(boolean z) {
        this.e = z;
    }
}
