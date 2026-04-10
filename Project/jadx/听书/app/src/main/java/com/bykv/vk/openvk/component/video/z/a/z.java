package com.bykv.vk.openvk.component.video.z.a;

import com.bykv.vk.openvk.component.video.z.a.dl;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z implements dl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private dl.z f102a;
    private dl.g dl;
    private dl.InterfaceC0030dl e;
    private dl.gc g;
    private dl.m gc;
    private dl.a gz;
    private dl.e m;
    protected boolean z = false;

    @Override // com.bykv.vk.openvk.component.video.z.a.dl
    public final void z(dl.gc gcVar) {
        this.g = gcVar;
    }

    @Override // com.bykv.vk.openvk.component.video.z.a.dl
    public final void z(dl.g gVar) {
        this.dl = gVar;
    }

    @Override // com.bykv.vk.openvk.component.video.z.a.dl
    public final void z(dl.z zVar) {
        this.f102a = zVar;
    }

    @Override // com.bykv.vk.openvk.component.video.z.a.dl
    public final void z(dl.m mVar) {
        this.gc = mVar;
    }

    @Override // com.bykv.vk.openvk.component.video.z.a.dl
    public final void z(dl.InterfaceC0030dl interfaceC0030dl) {
        this.e = interfaceC0030dl;
    }

    @Override // com.bykv.vk.openvk.component.video.z.a.dl
    public final void z(dl.a aVar) {
        this.gz = aVar;
    }

    @Override // com.bykv.vk.openvk.component.video.z.a.dl
    public final void z(dl.e eVar) {
        this.m = eVar;
    }

    public void z() {
        this.g = null;
        this.f102a = null;
        this.dl = null;
        this.gc = null;
        this.m = null;
        this.e = null;
        this.gz = null;
    }

    protected final void g() {
        try {
            dl.gc gcVar = this.g;
            if (gcVar != null) {
                gcVar.g(this);
            }
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.m.dl.dl("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnPrepared error: ", th);
        }
    }

    protected final void dl() {
        try {
            dl.g gVar = this.dl;
            if (gVar != null) {
                gVar.z(this);
            }
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.m.dl.dl("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnCompletion error: ", th);
        }
    }

    protected final void z(int i) {
        try {
            dl.z zVar = this.f102a;
            if (zVar != null) {
                zVar.z(this, i);
            }
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.m.dl.dl("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnBufferingUpdate error: ", th);
        }
    }

    protected final void a() {
        try {
            dl.m mVar = this.gc;
            if (mVar != null) {
                mVar.dl(this);
            }
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.m.dl.dl("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnSeekComplete error: ", th);
        }
    }

    protected final void z(int i, int i2, int i3, int i4) {
        try {
            dl.e eVar = this.m;
            if (eVar != null) {
                eVar.z(this, i, i2, i3, i4);
            }
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.m.dl.dl("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnVideoSizeChanged error: ", th);
        }
    }

    protected final boolean z(int i, int i2) {
        try {
            dl.InterfaceC0030dl interfaceC0030dl = this.e;
            if (interfaceC0030dl != null) {
                if (interfaceC0030dl.z(this, i, i2)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.m.dl.dl("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnError error: ", th);
            return false;
        }
    }

    protected final boolean g(int i, int i2) {
        try {
            dl.a aVar = this.gz;
            if (aVar != null) {
                if (aVar.g(this, i, i2)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.m.dl.dl("AbstractMediaPlayer", "AbstractMediaPlayer.notifyOnInfo error: ", th);
            return false;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.z.a.dl
    public void z(boolean z) {
        this.z = z;
    }
}
