package com.bytedance.sdk.component.wp.g;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.bykv.vk.component.ttvideo.SeekCompletionListener;
import com.bykv.vk.component.ttvideo.TTVideoEngine;
import com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback;
import com.bykv.vk.component.ttvideo.log.VideoEventEngineUploader;
import com.bykv.vk.component.ttvideo.player.TTPlayerClient;
import com.bykv.vk.component.ttvideo.playerwrapper.MediaPlayerWrapper;
import com.bykv.vk.component.ttvideo.utils.Error;
import com.bykv.vk.openvk.component.video.api.dl;
import com.bykv.vk.openvk.component.video.api.dl.a;
import com.bykv.vk.openvk.component.video.api.z;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.wp;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class g implements com.bykv.vk.openvk.component.video.api.z, l.z {
    public static volatile boolean z;
    private TTVideoEngine g;
    private boolean gk;
    private volatile l io;
    private SurfaceHolder iq;
    private int js;
    private SurfaceTexture q;
    private int tb;
    private long uy;
    private boolean dl = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f852a = false;
    private boolean gc = false;
    private boolean m = false;
    private boolean e = false;
    private boolean gz = false;
    private boolean fo = false;
    private long kb = 0;
    private long wp = 0;
    private long i = 0;
    private int v = 0;
    private int pf = 0;
    private boolean ls = false;
    private AtomicBoolean p = new AtomicBoolean(false);
    private AtomicBoolean fv = new AtomicBoolean(false);
    private final List<WeakReference<z.InterfaceC0029z>> zw = Collections.synchronizedList(new ArrayList());
    private volatile boolean uf = false;
    private volatile int sy = 200;
    private long hh = 0;
    private Runnable l = new Runnable() { // from class: com.bytedance.sdk.component.wp.g.g.1
        @Override // java.lang.Runnable
        public void run() {
            long jJs = g.this.js();
            if (g.this.fv() > 0) {
                if (g.this.hh != jJs) {
                    if (dl.a()) {
                        com.bykv.vk.openvk.component.video.api.m.dl.z("CSJ_VIDEO_TTVideo", "run: lastCur = ", Long.valueOf(g.this.hh), "  curPosition=", Long.valueOf(jJs));
                    }
                    g gVar = g.this;
                    gVar.z(jJs, gVar.fv());
                }
                g.this.hh = jJs;
            }
            if (!g.this.m) {
                if (g.this.io != null) {
                    g.this.io.postDelayed(this, g.this.sy);
                }
            } else {
                g gVar2 = g.this;
                gVar2.z(gVar2.fv(), g.this.fv());
            }
        }
    };
    private final ArrayList<Runnable> h = new ArrayList<>();

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void z(float f) {
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void z(int i) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(long j, long j2) {
        for (WeakReference<z.InterfaceC0029z> weakReference : this.zw) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().z(this, j, j2);
            }
        }
    }

    public g(Context context, String str) {
        z(context, "vd_".concat(String.valueOf(str)), (Looper) null);
    }

    private void z(Context context, String str, Looper looper) {
        this.g = z.z(context);
        if (looper != null) {
            this.io = new l(looper, this);
            this.uf = true;
        } else if (this.io == null) {
            this.io = com.bytedance.sdk.component.uy.g.z.z().z(this, "csj_".concat(String.valueOf(str)));
        }
        uf();
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void z(final SurfaceHolder surfaceHolder) {
        com.bykv.vk.openvk.component.video.api.m.dl.z("CSJ_VIDEO_TTVideo", "setDisplay:  SurfaceView");
        g(true);
        this.iq = surfaceHolder;
        g(new Runnable() { // from class: com.bytedance.sdk.component.wp.g.g.3
            @Override // java.lang.Runnable
            public void run() {
                if (g.this.io != null) {
                    g.this.io.obtainMessage(110, surfaceHolder).sendToTarget();
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void z(final SurfaceTexture surfaceTexture) {
        g(true);
        this.q = surfaceTexture;
        g(new Runnable() { // from class: com.bytedance.sdk.component.wp.g.g.4
            @Override // java.lang.Runnable
            public void run() {
                if (g.this.io != null) {
                    g.this.io.obtainMessage(111, surfaceTexture).sendToTarget();
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public boolean fo() {
        return this.m;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public boolean uy() {
        return this.gz;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void z(a aVar) {
        this.g.setDirectUrlUseDataLoader(aVar.ls(), aVar.p(), (String) null, aVar.gc());
        this.dl = true;
        this.pf = 0;
        com.bykv.vk.openvk.component.video.api.m.dl.z("CSJ_VIDEO_TTVideo", "TTVideoPlayer setDirectUrlUseDataLoader:  url =", aVar.ls(), " isH265=", Boolean.valueOf(aVar.v()), " presize=", Integer.valueOf(aVar.m()), " path=", aVar.gc(), " fileName =", aVar.p());
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void z() {
        TTVideoEngine tTVideoEngine = this.g;
        boolean zIsMute = tTVideoEngine != null ? tTVideoEngine.isMute() : false;
        this.pf = 0;
        this.wp = 0L;
        this.i = 0L;
        this.m = false;
        z(true, 0L, zIsMute);
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void z(boolean z2, long j, boolean z3) {
        com.bykv.vk.openvk.component.video.api.m.dl.z("CSJ_VIDEO_TTVideo", "start: firstSeek:" + j + " first:" + z2 + " quiet:" + z3);
        if (this.io != null) {
            this.io.postDelayed(this.l, this.sy);
        }
        this.uy = System.currentTimeMillis();
        this.g.setStartTime((int) j);
        this.g.setIsMute(z3);
        if (this.fv.get() && this.dl) {
            q();
        } else {
            com.bykv.vk.openvk.component.video.api.m.dl.z("CSJ_VIDEO_TTVideo", "seekTo: ", "Can not exec play, please exec setDataSource && setSurface before seek");
            z(new Runnable() { // from class: com.bytedance.sdk.component.wp.g.g.5
                @Override // java.lang.Runnable
                public void run() {
                    g.this.q();
                }
            });
        }
        com.bykv.vk.openvk.component.video.api.m.dl.z("CSJ_VIDEO_TTVideo", "start:end");
        this.p.set(true);
        if (!this.fv.get() || this.io == null) {
            return;
        }
        this.io.post(new Runnable() { // from class: com.bytedance.sdk.component.wp.g.g.6
            @Override // java.lang.Runnable
            public void run() {
                g.this.zw();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        this.gz = true;
        this.f852a = true;
        if (this.io != null) {
            this.io.sendEmptyMessage(100);
        }
    }

    private synchronized void z(Runnable runnable) {
        this.h.add(runnable);
    }

    private void iq() {
        if (this.gk) {
            return;
        }
        this.gk = true;
        Iterator it = new ArrayList(this.h).iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.h.clear();
        this.gk = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zw() {
        ArrayList<Runnable> arrayList = this.h;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        iq();
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void g() {
        com.bykv.vk.openvk.component.video.api.m.dl.z("CSJ_VIDEO_TTVideo", "play: ");
        l lVar = this.io;
        if (lVar != null) {
            lVar.postDelayed(this.l, this.sy);
            lVar.post(new Runnable() { // from class: com.bytedance.sdk.component.wp.g.g.7
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (g.this.g != null) {
                            g.this.g.play();
                            for (WeakReference weakReference : g.this.zw) {
                                if (weakReference != null && weakReference.get() != null) {
                                    weakReference.get();
                                }
                            }
                        }
                    } catch (Throwable th) {
                        com.bykv.vk.openvk.component.video.api.m.dl.z("CSJ_VIDEO_TTVideo", "play: catch exception:" + th.getMessage());
                    }
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void a() {
        com.bykv.vk.openvk.component.video.api.m.dl.z("CSJ_VIDEO_TTVideo", "stop: ");
        if (this.io != null) {
            this.io.sendEmptyMessage(105);
        }
    }

    @Override // com.bytedance.sdk.component.utils.l.z
    public void z(Message message) {
        int i = message.what;
        try {
            if (i == 105) {
                TTVideoEngine tTVideoEngine = this.g;
                if (tTVideoEngine != null) {
                    tTVideoEngine.stop();
                    return;
                }
                return;
            }
            if (i == 110) {
                if (this.g != null) {
                    this.g.setSurfaceHolder((SurfaceHolder) message.obj);
                    this.fv.set(true);
                    if (this.p.get()) {
                        zw();
                        return;
                    }
                    return;
                }
                return;
            }
            if (i != 111) {
                switch (i) {
                    case 100:
                        TTVideoEngine tTVideoEngine2 = this.g;
                        if (tTVideoEngine2 != null) {
                            tTVideoEngine2.play();
                        }
                        break;
                    case 101:
                        if (this.g != null && this.io != null) {
                            this.g.pause();
                            for (WeakReference<z.InterfaceC0029z> weakReference : this.zw) {
                                if (weakReference != null && weakReference.get() != null) {
                                    weakReference.get();
                                }
                            }
                            this.io.removeCallbacks(this.l);
                        }
                        break;
                    case 102:
                        sy();
                        break;
                    case 103:
                        TTVideoEngine tTVideoEngine3 = this.g;
                        if (tTVideoEngine3 != null) {
                            tTVideoEngine3.release();
                        }
                        this.gc = true;
                        for (WeakReference<z.InterfaceC0029z> weakReference2 : this.zw) {
                            if (weakReference2 != null && weakReference2.get() != null) {
                                weakReference2.get().dl(this);
                            }
                        }
                        break;
                }
                return;
            }
            if (this.g != null) {
                SurfaceTexture surfaceTexture = (SurfaceTexture) message.obj;
                com.bykv.vk.openvk.component.video.api.m.dl.z("CSJ_VIDEO_TTVideo", "setSurface: TextureView ");
                this.g.setSurface(new Surface(surfaceTexture));
                this.fv.set(true);
                if (this.p.get()) {
                    zw();
                }
            }
        } catch (Exception e) {
            wp.z(e);
        }
    }

    private void g(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (!this.gc) {
            runnable.run();
        } else {
            z(runnable);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void dl() {
        com.bykv.vk.openvk.component.video.api.m.dl.z("CSJ_VIDEO_TTVideo", "pause: ");
        l lVar = this.io;
        if (lVar != null) {
            lVar.removeMessages(100);
            lVar.sendEmptyMessage(101);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void z(long j) {
        com.bykv.vk.openvk.component.video.api.m.dl.z("CSJ_VIDEO_TTVideo", "seekTo: ");
        if (this.f852a) {
            this.g.seekTo((int) j, new SeekCompletionListener() { // from class: com.bytedance.sdk.component.wp.g.g.8
                @Override // com.bykv.vk.component.ttvideo.SeekCompletionListener
                public void onCompletion(boolean z2) {
                    for (WeakReference weakReference : g.this.zw) {
                        if (weakReference != null && weakReference.get() != null) {
                            ((z.InterfaceC0029z) weakReference.get()).z(g.this, z2);
                        }
                    }
                    com.bykv.vk.openvk.component.video.api.m.dl.z("CSJ_VIDEO_TTVideo", "seekTo: ", " isSuccess =", Boolean.valueOf(z2));
                }
            });
        } else {
            com.bykv.vk.openvk.component.video.api.m.dl.z("CSJ_VIDEO_TTVideo", "seekTo: ", "Can not exec seek, please exec setDataSource before seek");
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public boolean m() {
        return this.ls;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void g(boolean z2) {
        this.fo = z2;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public long fv() {
        return this.g.getDuration();
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public long js() {
        try {
            return this.g.getCurrentPlaybackTime();
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.m.dl.g(th.getMessage());
            return 0L;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void dl(boolean z2) {
        this.g.setLooping(z2);
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void z(z.InterfaceC0029z interfaceC0029z) {
        if (interfaceC0029z == null) {
            return;
        }
        for (WeakReference<z.InterfaceC0029z> weakReference : this.zw) {
            if (weakReference != null && weakReference.get() == interfaceC0029z) {
                return;
            }
        }
        this.zw.add(new WeakReference<>(interfaceC0029z));
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void g(int i) {
        this.sy = i;
    }

    private void io() {
        ArrayList<Runnable> arrayList = this.h;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        this.h.clear();
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void gc() {
        io();
        l lVar = this.io;
        if (lVar != null) {
            lVar.removeCallbacksAndMessages(null);
            lVar.sendEmptyMessage(103);
            if (lVar.getLooper() != null) {
                lVar.post(new Runnable() { // from class: com.bytedance.sdk.component.wp.g.g.9
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (!g.this.uf) {
                                com.bytedance.sdk.component.uy.g.z.z().z(g.this.io);
                            }
                            g.this.io = null;
                        } catch (Throwable th) {
                            com.bykv.vk.openvk.component.video.api.m.dl.dl("CSJ_VIDEO_TTVideo", "release error:" + th.getMessage());
                        }
                    }
                });
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void z(boolean z2) {
        com.bykv.vk.openvk.component.video.api.m.dl.z("CSJ_VIDEO_TTVideo", "setIsMute: ");
        this.g.setIsMute(z2);
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public int kb() {
        com.bykv.vk.openvk.component.video.api.m.dl.z("CSJ_VIDEO_TTVideo", "getVideoWidth: ");
        return this.js;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public int wp() {
        com.bykv.vk.openvk.component.video.api.m.dl.z("CSJ_VIDEO_TTVideo", "getVideoHeight: ");
        return this.tb;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public boolean i() {
        return this.g.getPlaybackState() == 1;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public boolean v() {
        return this.g.getPlaybackState() == 2;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public boolean pf() {
        return this.gc;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public long ls() {
        if (this.pf == 0) {
            return 0L;
        }
        if (this.wp == 0 && this.i != 0) {
            this.wp = System.currentTimeMillis() - this.i;
        }
        return this.wp;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public int p() {
        return this.pf;
    }

    private void uf() {
        this.g.setVideoEngineSimpleCallback(new VideoEngineSimpleCallback() { // from class: com.bytedance.sdk.component.wp.g.g.2
            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onPlaybackStateChanged(TTVideoEngine tTVideoEngine, int i) {
                com.bykv.vk.openvk.component.video.api.m.dl.z("CSJ_VIDEO_TTVideo", "onPlaybackStateChanged: playbackState =", Integer.valueOf(i));
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onLoadStateChanged(TTVideoEngine tTVideoEngine, int i) {
                com.bykv.vk.openvk.component.video.api.m.dl.z("CSJ_VIDEO_TTVideo", "onLoadStateChanged: loadState =", Integer.valueOf(i));
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onVideoSizeChanged(TTVideoEngine tTVideoEngine, int i, int i2) {
                com.bykv.vk.openvk.component.video.api.m.dl.z("CSJ_VIDEO_TTVideo", "onVideoSizeChanged: width = ", Integer.valueOf(i), " height = ", Integer.valueOf(i2));
                g.this.js = i;
                g.this.tb = i2;
                for (WeakReference weakReference : g.this.zw) {
                    if (weakReference != null && weakReference.get() != null) {
                        ((z.InterfaceC0029z) weakReference.get()).z((com.bykv.vk.openvk.component.video.api.z) g.this, i, i2);
                    }
                }
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onBufferingUpdate(TTVideoEngine tTVideoEngine, int i) {
                com.bykv.vk.openvk.component.video.api.m.dl.z("CSJ_VIDEO_TTVideo", "onBufferingUpdate: percent =", Integer.valueOf(i));
                for (WeakReference weakReference : g.this.zw) {
                    if (weakReference != null && weakReference.get() != null) {
                        ((z.InterfaceC0029z) weakReference.get()).g(g.this, i);
                    }
                }
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onPrepare(TTVideoEngine tTVideoEngine) {
                com.bykv.vk.openvk.component.video.api.m.dl.z("CSJ_VIDEO_TTVideo", "onPrepare: ");
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onPrepared(TTVideoEngine tTVideoEngine) {
                com.bykv.vk.openvk.component.video.api.m.dl.z("CSJ_VIDEO_TTVideo", "onPrepared: ");
                g.this.e = true;
                for (WeakReference weakReference : g.this.zw) {
                    if (weakReference != null && weakReference.get() != null) {
                        ((z.InterfaceC0029z) weakReference.get()).g(g.this);
                    }
                }
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onRenderStart(TTVideoEngine tTVideoEngine) {
                com.bykv.vk.openvk.component.video.api.m.dl.z("CSJ_VIDEO_TTVideo", "onRenderStart: ");
                g.this.kb = System.currentTimeMillis() - g.this.uy;
                for (WeakReference weakReference : g.this.zw) {
                    if (weakReference != null && weakReference.get() != null) {
                        z.InterfaceC0029z interfaceC0029z = (z.InterfaceC0029z) weakReference.get();
                        g gVar = g.this;
                        interfaceC0029z.z(gVar, gVar.kb);
                    }
                }
                g.this.ls = true;
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onCompletion(TTVideoEngine tTVideoEngine) {
                com.bykv.vk.openvk.component.video.api.m.dl.z("CSJ_VIDEO_TTVideo", "onCompletion: ");
                g.this.m = true;
                if (g.this.io != null) {
                    g.this.io.removeCallbacks(g.this.l);
                }
                for (WeakReference weakReference : g.this.zw) {
                    if (weakReference != null && weakReference.get() != null) {
                        ((z.InterfaceC0029z) weakReference.get()).z(g.this);
                    }
                }
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onError(Error error) {
                com.bykv.vk.openvk.component.video.api.m.dl.z("CSJ_VIDEO_TTVideo", "onError: ");
                com.bykv.vk.openvk.component.video.api.dl.g gVar = new com.bykv.vk.openvk.component.video.api.dl.g(error.getCode(), error.getInternalCode());
                for (WeakReference weakReference : g.this.zw) {
                    if (weakReference != null && weakReference.get() != null) {
                        ((z.InterfaceC0029z) weakReference.get()).z(g.this, gVar);
                    }
                }
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onBufferStart(int i, int i2, int i3) {
                g.this.v = i;
                g.this.pf++;
                g.this.i = System.currentTimeMillis();
                com.bykv.vk.openvk.component.video.api.m.dl.z("CSJ_VIDEO_TTVideo", "onBufferStart: reason =", Integer.valueOf(i), "  afterFirstFrame =", Integer.valueOf(i2), "  action=", Integer.valueOf(i3));
                for (WeakReference weakReference : g.this.zw) {
                    if (weakReference != null && weakReference.get() != null) {
                        ((z.InterfaceC0029z) weakReference.get()).z(g.this, i, i2, i3);
                    }
                }
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onBufferEnd(int i) {
                if (g.this.v == i) {
                    g.this.wp += System.currentTimeMillis() - g.this.i;
                }
                com.bykv.vk.openvk.component.video.api.m.dl.z("CSJ_VIDEO_TTVideo", "onBufferEnd: code =", Integer.valueOf(i));
                for (WeakReference weakReference : g.this.zw) {
                    if (weakReference != null && weakReference.get() != null) {
                        ((z.InterfaceC0029z) weakReference.get()).z((com.bykv.vk.openvk.component.video.api.z) g.this, i);
                    }
                }
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onRenderSeekComplete(int i) {
                com.bykv.vk.openvk.component.video.api.m.dl.z("CSJ_VIDEO_TTVideo", "onRenderSeekComplete: isSeekInCached = ", Integer.valueOf(i));
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onRetry(int i) {
                com.bykv.vk.openvk.component.video.api.m.dl.z("CSJ_VIDEO_TTVideo", "onRetry: playType = ", Integer.valueOf(i));
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onMDLHitCache(String str, long j) {
                com.bykv.vk.openvk.component.video.api.m.dl.z("CSJ_VIDEO_TTVideo", "onMDLHitCache: MDLPlayTaskKey =", str, " hitCacheSize = ", Long.valueOf(j));
            }

            @Override // com.bykv.vk.component.ttvideo.VideoEngineSimpleCallback, com.bykv.vk.component.ttvideo.VideoEngineCallback
            public void onUseMDLCacheEnd() {
                com.bykv.vk.openvk.component.video.api.m.dl.z("CSJ_VIDEO_TTVideo", "onUseMDLCacheEnd: ");
            }
        });
    }

    private void sy() {
        this.dl = false;
        this.f852a = false;
        this.m = false;
        this.e = false;
        this.gz = false;
    }

    public static boolean tb() {
        return z;
    }

    public static void z(Context context, String str, int i, String[] strArr, long[] jArr, boolean z2, VideoEventEngineUploader videoEventEngineUploader) {
        boolean z3;
        try {
            TTPlayerClient.create(new MediaPlayerWrapper(), dl.getContext()).release();
            z.z(context, str, i, strArr, jArr, videoEventEngineUploader);
            z.z(z2);
            z3 = true;
        } catch (Throwable unused) {
            z3 = false;
        }
        z = z3;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public SurfaceHolder e() {
        return this.iq;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public SurfaceTexture gz() {
        return this.q;
    }
}
