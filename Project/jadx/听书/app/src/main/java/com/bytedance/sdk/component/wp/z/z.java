package com.bytedance.sdk.component.wp.z;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.appcompat.app.AppCompatDelegate;
import com.bykv.vk.component.ttvideo.ILiveListener;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bykv.vk.component.ttvideo.ILiveSettingBundle;
import com.bykv.vk.component.ttvideo.INetworkClient;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bykv.vk.component.ttvideo.VideoLiveManager;
import com.bykv.vk.component.ttvideo.log.LiveError;
import com.bykv.vk.openvk.component.video.api.dl;
import com.bykv.vk.openvk.component.video.api.dl.a;
import com.bykv.vk.openvk.component.video.api.dl.g;
import com.bykv.vk.openvk.component.video.api.z;
import com.bytedance.sdk.component.g.z.ls;
import com.bytedance.sdk.component.g.z.v;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z implements com.bykv.vk.openvk.component.video.api.z, l.z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f855a;
    private final Context dl;
    private volatile boolean e;
    private int gc;
    private volatile a h;
    private SurfaceTexture hh;
    private l m;
    private JSONObject mc;
    private long p;
    private SurfaceHolder sy;
    private boolean ti;
    private boolean un;
    private ILivePlayer z;
    private long zw;
    private final List<WeakReference<z.InterfaceC0029z>> g = Collections.synchronizedList(new ArrayList());
    private AtomicBoolean gz = new AtomicBoolean(false);
    private AtomicBoolean fo = new AtomicBoolean(false);
    private volatile boolean uy = false;
    private volatile boolean kb = false;
    private volatile boolean wp = false;
    private volatile boolean i = false;
    private volatile boolean v = false;
    private volatile boolean pf = false;
    private volatile boolean ls = true;
    private long fv = 0;
    private long js = 0;
    private final int tb = 0;
    private int q = 0;
    private long iq = 0;
    private long io = 0;
    private volatile boolean uf = false;
    private volatile int l = 200;
    private long gk = 0;
    private final ArrayList<Runnable> x = new ArrayList<>();
    private final Runnable lq = new Runnable() { // from class: com.bytedance.sdk.component.wp.z.z.1
        @Override // java.lang.Runnable
        public void run() {
            long jJs = z.this.js();
            z.this.io += (long) z.this.l;
            if (z.this.fv() > 0 && z.this.gk != jJs) {
                if (dl.a()) {
                    com.bykv.vk.openvk.component.video.api.m.dl.z("TTLiveVideoPlayer", "run: lastCur = " + z.this.gk + "  currentPosition=" + jJs);
                }
                z zVar = z.this;
                zVar.z(jJs, zVar.fv());
            }
            z.this.gk = jJs;
            if (z.this.js() >= z.this.zw) {
                z.this.i = true;
                z.this.gc();
                for (WeakReference weakReference : z.this.g) {
                    if (weakReference != null && weakReference.get() != null) {
                        ((z.InterfaceC0029z) weakReference.get()).z(z.this);
                    }
                }
            }
            if (!z.this.i) {
                if (z.this.m != null) {
                    z.this.m.postDelayed(this, z.this.l);
                }
            } else {
                z zVar2 = z.this;
                zVar2.z(zVar2.fv(), z.this.fv());
            }
        }
    };
    private final ILiveListener eo = new ILiveListener() { // from class: com.bytedance.sdk.component.wp.z.z.7
        private boolean g = false;

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onAbrSwitch(String str) {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onAudioRenderStall(int i) {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onCacheFileCompletion() {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onReportALog(int i, String str) {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onResolutionDegrade(String str) {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onSeiUpdate(String str) {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onVideoRenderStall(int i) {
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onError(LiveError liveError) {
            if (liveError != null) {
                if (this.g) {
                    return;
                }
                this.g = true;
                g gVar = new g(liveError.code, 0, liveError.getInfoJSON());
                for (WeakReference weakReference : z.this.g) {
                    if (weakReference != null && weakReference.get() != null) {
                        ((z.InterfaceC0029z) weakReference.get()).z(z.this, gVar);
                    }
                }
            }
            z.this.ls = true;
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onFirstFrame(boolean z) {
            if (z.this.m == null) {
                return;
            }
            z.this.uf = true;
            z.this.m.removeCallbacks(z.this.lq);
            if (z.this.zw > 0) {
                z.this.m.postDelayed(z.this.lq, z.this.l);
            }
            z.this.ls = false;
            if (z) {
                z.this.fv = System.currentTimeMillis() - z.this.p;
                for (WeakReference weakReference : z.this.g) {
                    if (weakReference != null && weakReference.get() != null) {
                        z.InterfaceC0029z interfaceC0029z = (z.InterfaceC0029z) weakReference.get();
                        z zVar = z.this;
                        interfaceC0029z.z(zVar, zVar.fv);
                    }
                }
                return;
            }
            com.bykv.vk.openvk.component.video.api.m.dl.g("TTLiveVideoPlayer", "onFirstFrame-> not first frame , isFirstFrame=".concat(String.valueOf(z)));
            for (WeakReference weakReference2 : z.this.g) {
                if (weakReference2 != null && weakReference2.get() != null) {
                    ((z.InterfaceC0029z) weakReference2.get()).z((com.bykv.vk.openvk.component.video.api.z) z.this, -1);
                }
            }
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onStallStart() {
            if (z.this.m == null) {
                return;
            }
            z.p(z.this);
            z.this.iq = System.currentTimeMillis();
            z.this.m.removeCallbacks(z.this.lq);
            for (WeakReference weakReference : z.this.g) {
                if (weakReference != null && weakReference.get() != null) {
                    ((z.InterfaceC0029z) weakReference.get()).z(z.this, -1, -1, -1);
                }
            }
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onStallEnd() {
            if (z.this.m == null) {
                return;
            }
            if (z.this.zw > 0) {
                z.this.m.postDelayed(z.this.lq, z.this.l);
            }
            z.this.js += System.currentTimeMillis() - z.this.iq;
            for (WeakReference weakReference : z.this.g) {
                if (weakReference != null && weakReference.get() != null) {
                    ((z.InterfaceC0029z) weakReference.get()).z((com.bykv.vk.openvk.component.video.api.z) z.this, -1);
                }
            }
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onCompletion() {
            if (z.this.m == null) {
                return;
            }
            z.this.m.removeCallbacks(z.this.lq);
            for (WeakReference weakReference : z.this.g) {
                if (weakReference != null && weakReference.get() != null) {
                    ((z.InterfaceC0029z) weakReference.get()).z(z.this, -1, -1, -1);
                }
            }
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onPrepared() {
            com.bykv.vk.openvk.component.video.api.m.dl.z("TTLiveVideoPlayer", "onPrepared.....");
            z.this.v = true;
            for (WeakReference weakReference : z.this.g) {
                if (weakReference != null && weakReference.get() != null) {
                    ((z.InterfaceC0029z) weakReference.get()).g(z.this);
                }
            }
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onVideoSizeChanged(int i, int i2) {
            z.this.f855a = i;
            z.this.gc = i2;
            for (WeakReference weakReference : z.this.g) {
                if (weakReference != null && weakReference.get() != null) {
                    ((z.InterfaceC0029z) weakReference.get()).z((com.bykv.vk.openvk.component.video.api.z) z.this, i, i2);
                }
            }
        }

        @Override // com.bykv.vk.component.ttvideo.ILiveListener
        public void onMonitorLog(JSONObject jSONObject, String str) {
            for (WeakReference weakReference : z.this.g) {
                if (weakReference != null && weakReference.get() != null) {
                    ((z.InterfaceC0029z) weakReference.get()).z(z.this, jSONObject, str);
                }
            }
        }
    };

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void z(float f) {
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void z(int i) {
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void z(long j) {
    }

    static /* synthetic */ int p(z zVar) {
        int i = zVar.q;
        zVar.q = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(long j, long j2) {
        for (WeakReference<z.InterfaceC0029z> weakReference : this.g) {
            if (weakReference != null && weakReference.get() != null) {
                weakReference.get().z(this, j, j2);
            }
        }
    }

    public z(Context context, boolean z, long j, JSONObject jSONObject, Looper looper) {
        this.m = null;
        this.e = false;
        this.zw = 0L;
        this.dl = context;
        this.mc = jSONObject;
        this.zw = j > 0 ? j * 1000 : -1L;
        if (looper != null) {
            this.m = new l(looper, this);
            this.e = true;
        } else if (this.m == null) {
            this.m = com.bytedance.sdk.component.uy.g.z.z().z(this, "tt-live-video-player");
        }
        a(z);
    }

    private void a(final boolean z) {
        l lVar = this.m;
        if (lVar != null) {
            lVar.post(new Runnable() { // from class: com.bytedance.sdk.component.wp.z.z.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ILiveSettingBundle iLiveSettingBundle = new ILiveSettingBundle() { // from class: com.bytedance.sdk.component.wp.z.z.2.1
                            /* JADX WARN: Removed duplicated region for block: B:13:0x002c  */
                            /* JADX WARN: Removed duplicated region for block: B:14:0x002f  */
                            @Override // com.bykv.vk.component.ttvideo.ILiveSettingBundle
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                                To view partially-correct code enable 'Show inconsistent code' option in preferences
                            */
                            public <T> T getSettingsValueForKey(java.lang.String r2, T r3) {
                                /*
                                    r1 = this;
                                    r2.hashCode()
                                    java.lang.String r0 = "live_enable_close_play_retry"
                                    boolean r0 = r2.equals(r0)
                                    if (r0 != 0) goto L14
                                    java.lang.String r0 = "live_sdk_cancel_sdk_dns_fail_retry"
                                    boolean r2 = r2.equals(r0)
                                    if (r2 != 0) goto L23
                                    goto L30
                                L14:
                                    java.lang.Class r2 = r3.getClass()
                                    java.lang.Class<java.lang.Integer> r0 = java.lang.Integer.class
                                    if (r2 != r0) goto L23
                                    java.lang.String r2 = "1"
                                    java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                                    goto L24
                                L23:
                                    r2 = r3
                                L24:
                                    java.lang.Class r3 = r3.getClass()
                                    java.lang.Class<java.lang.Boolean> r0 = java.lang.Boolean.class
                                    if (r3 != r0) goto L2f
                                    java.lang.Boolean r3 = java.lang.Boolean.TRUE
                                    goto L30
                                L2f:
                                    r3 = r2
                                L30:
                                    return r3
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.wp.z.z.AnonymousClass2.AnonymousClass1.getSettingsValueForKey(java.lang.String, java.lang.Object):java.lang.Object");
                            }
                        };
                        z zVar = z.this;
                        zVar.z = VideoLiveManager.newBuilder(zVar.dl).setProjectKey("pangle_ad_live").setNetworkClient(new C0146z()).setForceHttpDns(false).setForceTTNetHttpDns(false).setSettingsBundle(iLiveSettingBundle).setPlayerType(1).setListener(z.this.eo).build();
                        z.this.z.setIntOption(69, z ? 1 : 0);
                        z.this.z.setStringOption(72, com.bytedance.sdk.openadsdk.api.plugin.g.z(z.this.dl, null).getAbsolutePath() + "/pangle_live/");
                    } catch (Exception e) {
                        com.bykv.vk.openvk.component.video.api.m.dl.dl("TTLiveVideoPlayer", e.getMessage());
                    }
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void z(a aVar) {
        if (aVar == null) {
            return;
        }
        this.h = aVar;
        com.bykv.vk.openvk.component.video.api.m.dl.z("TTLiveVideoPlayer", "setDataSource: model = " + aVar.ls());
        l lVar = this.m;
        if (lVar != null) {
            lVar.sendEmptyMessage(107);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void z() {
        this.q = 0;
        this.js = 0L;
        this.iq = 0L;
        z(true, 0L, false);
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void z(boolean z, final long j, final boolean z2) {
        l lVar;
        if (this.fo.get() && this.uy && this.z != null) {
            this.io = j;
            this.p = System.currentTimeMillis();
            z(z2);
            l lVar2 = this.m;
            if (lVar2 != null) {
                lVar2.sendEmptyMessage(100);
            }
            wp.g("TTLiveVideoPlayer", "TTLiveVideoPlayer...play......");
        } else {
            z(new Runnable() { // from class: com.bytedance.sdk.component.wp.z.z.3
                @Override // java.lang.Runnable
                public void run() {
                    z.this.io = j;
                    z.this.p = System.currentTimeMillis();
                    z.this.z(z2);
                    if (z.this.m != null) {
                        z.this.m.sendEmptyMessage(100);
                    }
                }
            });
        }
        this.gz.set(true);
        if (!this.fo.get() || (lVar = this.m) == null) {
            return;
        }
        lVar.post(new Runnable() { // from class: com.bytedance.sdk.component.wp.z.z.4
            @Override // java.lang.Runnable
            public void run() {
                z.this.tb();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void tb() {
        ArrayList<Runnable> arrayList = this.x;
        if (arrayList != null && !arrayList.isEmpty()) {
            q();
        }
    }

    private synchronized void z(Runnable runnable) {
        this.x.add(runnable);
    }

    private synchronized void q() {
        if (this.un) {
            return;
        }
        this.un = true;
        Iterator it = new ArrayList(this.x).iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.x.clear();
        this.un = false;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void g() {
        l lVar = this.m;
        if (lVar != null) {
            lVar.post(new Runnable() { // from class: com.bytedance.sdk.component.wp.z.z.5
                @Override // java.lang.Runnable
                public void run() {
                    if (z.this.z == null || z.this.i()) {
                        return;
                    }
                    try {
                        z.this.z.play();
                        z zVar = z.this;
                        zVar.z(zVar.ti);
                        for (WeakReference weakReference : z.this.g) {
                            if (weakReference != null && weakReference.get() != null) {
                                weakReference.get();
                            }
                        }
                    } catch (Throwable th) {
                        com.bykv.vk.openvk.component.video.api.m.dl.z("TTLiveVideoPlayer", "play: catch exception", th);
                    }
                    z.this.ls = false;
                }
            });
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void z(boolean z) {
        this.ti = z;
        if (this.z != null) {
            com.bykv.vk.openvk.component.video.api.m.dl.g("TTLiveVideoPlayer", "TTLiveVideoPlayer...setQuietPlay......isMute=".concat(String.valueOf(z)));
            try {
                this.z.setMute(Boolean.valueOf(z));
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.m.dl.z("TTLiveVideoPlayer", "setMute: catch exception:", th);
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void dl() {
        com.bykv.vk.openvk.component.video.api.m.dl.g("TTLiveVideoPlayer", "TTLiveVideoPlayer...pause......pause....currentPosition=" + js());
        l lVar = this.m;
        if (lVar != null) {
            lVar.removeCallbacks(this.lq);
            lVar.sendEmptyMessage(101);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void a() {
        com.bykv.vk.openvk.component.video.api.m.dl.g("TTLiveVideoPlayer", "TTLiveVideoPlayer...stop......stop....currentPosition=" + js());
        l lVar = this.m;
        if (lVar != null) {
            lVar.removeCallbacks(this.lq);
            lVar.sendEmptyMessage(105);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void gc() {
        l lVar = this.m;
        if (lVar != null) {
            lVar.removeCallbacks(this.lq);
            lVar.sendEmptyMessage(103);
            iq();
        }
        com.bykv.vk.openvk.component.video.api.m.dl.g("TTLiveVideoPlayer", "TTLiveVideoPlayer...release......release....");
    }

    private void iq() {
        l lVar = this.m;
        if (lVar == null || lVar.getLooper() == null) {
            return;
        }
        this.m.post(new Runnable() { // from class: com.bytedance.sdk.component.wp.z.z.6
            @Override // java.lang.Runnable
            public void run() {
                if (z.this.m == null || z.this.m.getLooper() == null) {
                    return;
                }
                try {
                    z.this.hh = null;
                    z.this.sy = null;
                    if (z.this.e) {
                        z.this.m.removeCallbacksAndMessages(null);
                    } else {
                        com.bytedance.sdk.component.uy.g.z.z().z(z.this.m);
                    }
                    z.this.m = null;
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public boolean m() {
        return this.uf;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void g(boolean z) {
        this.wp = z;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void z(SurfaceHolder surfaceHolder) {
        this.sy = surfaceHolder;
        com.bykv.vk.openvk.component.video.api.m.dl.g("TTLiveVideoPlayer", "TTLiveVideoPlayer...SurfaceHolder......".concat(String.valueOf(surfaceHolder)));
        l lVar = this.m;
        if (lVar != null) {
            lVar.obtainMessage(110, surfaceHolder).sendToTarget();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void z(SurfaceTexture surfaceTexture) {
        this.hh = surfaceTexture;
        l lVar = this.m;
        if (lVar != null) {
            lVar.obtainMessage(111, surfaceTexture).sendToTarget();
        }
        com.bykv.vk.openvk.component.video.api.m.dl.g("TTLiveVideoPlayer", "setSurface...surface=");
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public boolean fo() {
        com.bykv.vk.openvk.component.video.api.m.dl.g("TTLiveVideoPlayer", "TTLiveVideoPlayer...isCompleted......isComplete....=" + this.i);
        return this.i;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public boolean uy() {
        return this.pf;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public int kb() {
        return this.f855a;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public int wp() {
        return this.gc;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public boolean i() {
        ILivePlayer iLivePlayer = this.z;
        if (iLivePlayer == null) {
            return false;
        }
        try {
            return iLivePlayer.isPlaying();
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.m.dl.z("TTLiveVideoPlayer", "isPlaying: catch exception:", th);
            return false;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public boolean v() {
        return this.ls;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public boolean pf() {
        return this.kb;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public long ls() {
        return this.js;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public int p() {
        return this.q;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public long fv() {
        return this.zw;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public long js() {
        return this.io;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void dl(boolean z) {
        com.bykv.vk.openvk.component.video.api.m.dl.z("TTLiveVideoPlayer", "setLoop: live is invalid ");
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void z(z.InterfaceC0029z interfaceC0029z) {
        if (interfaceC0029z == null) {
            return;
        }
        for (WeakReference<z.InterfaceC0029z> weakReference : this.g) {
            if (weakReference != null && weakReference.get() == interfaceC0029z) {
                return;
            }
        }
        this.g.add(new WeakReference<>(interfaceC0029z));
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public void g(int i) {
        this.l = i;
    }

    @Override // com.bytedance.sdk.component.utils.l.z
    public void z(Message message) {
        try {
            switch (message.what) {
                case 100:
                    g();
                    this.pf = true;
                    return;
                case 101:
                    ILivePlayer iLivePlayer = this.z;
                    if (iLivePlayer != null) {
                        try {
                            iLivePlayer.stop();
                            for (WeakReference<z.InterfaceC0029z> weakReference : this.g) {
                                if (weakReference != null && weakReference.get() != null) {
                                    weakReference.get();
                                }
                                break;
                            }
                        } catch (Throwable th) {
                            com.bykv.vk.openvk.component.video.api.m.dl.z("TTLiveVideoPlayer", "pause: catch exception:", th);
                        }
                        this.ls = true;
                        return;
                    }
                    return;
                case 102:
                    ILivePlayer iLivePlayer2 = this.z;
                    if (iLivePlayer2 != null) {
                        try {
                            iLivePlayer2.reset();
                            break;
                        } catch (Throwable th2) {
                            com.bykv.vk.openvk.component.video.api.m.dl.z("TTLiveVideoPlayer", "reset: catch exception:", th2);
                        }
                        this.ls = true;
                        return;
                    }
                    return;
                case 103:
                    ILivePlayer iLivePlayer3 = this.z;
                    if (iLivePlayer3 != null) {
                        try {
                            iLivePlayer3.release();
                            break;
                        } catch (Throwable th3) {
                            com.bykv.vk.openvk.component.video.api.m.dl.z("TTLiveVideoPlayer", "release: catch exception:", th3);
                        }
                        this.kb = true;
                        this.ls = true;
                        return;
                    }
                    return;
                case 104:
                case 106:
                case AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR /* 108 */:
                case 109:
                default:
                    return;
                case 105:
                    ILivePlayer iLivePlayer4 = this.z;
                    if (iLivePlayer4 != null) {
                        try {
                            iLivePlayer4.stop();
                            break;
                        } catch (Throwable th4) {
                            com.bykv.vk.openvk.component.video.api.m.dl.z("TTLiveVideoPlayer", "stop: catch exception:", th4);
                        }
                        this.ls = true;
                        return;
                    }
                    return;
                case 107:
                    if (this.z == null || this.h == null) {
                        return;
                    }
                    String strLs = this.h.ls();
                    z(strLs);
                    this.z.setStreamInfo(strLs);
                    this.uy = true;
                    com.bykv.vk.openvk.component.video.api.m.dl.z("TTLiveVideoPlayer", "set Datasource:" + this.uy);
                    this.q = 0;
                    return;
                case 110:
                    if (this.z != null) {
                        SurfaceHolder surfaceHolder = (SurfaceHolder) message.obj;
                        this.z.setSurfaceHolder(surfaceHolder);
                        this.z.setSurface(surfaceHolder.getSurface());
                        this.fo.set(true);
                        if (this.gz.get()) {
                            tb();
                            return;
                        }
                        return;
                    }
                    return;
                case 111:
                    ILivePlayer iLivePlayer5 = this.z;
                    if (iLivePlayer5 != null) {
                        iLivePlayer5.setSurface(new Surface(this.hh));
                        this.fo.set(true);
                        if (this.gz.get()) {
                            tb();
                            return;
                        }
                        return;
                    }
                    return;
            }
        } catch (Exception e) {
            e.getMessage();
        }
        e.getMessage();
    }

    private void z(String str) {
        String str2 = LiveConfigKey.LOW;
        try {
            JSONObject jSONObject = this.mc;
            if (jSONObject == null) {
                return;
            }
            com.bykv.vk.openvk.component.video.api.m.dl.z("TTLiveVideoPlayer", "live ".concat(String.valueOf(jSONObject)));
            int iOptInt = jSONObject.optInt("enable");
            String strOptString = jSONObject.optString("appids");
            if (iOptInt == 1 && !TextUtils.isEmpty(strOptString)) {
                JSONObject jSONObject2 = new JSONObject(str);
                JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("common");
                JSONObject jSONObjectOptJSONObject2 = jSONObject2.optJSONObject("data");
                if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject2 != null) {
                    String strOptString2 = jSONObjectOptJSONObject.optString(PluginConstants.KEY_APP_ID);
                    com.bykv.vk.openvk.component.video.api.m.dl.z("TTLiveVideoPlayer", "api ".concat(String.valueOf(strOptString2)));
                    if (strOptString.contains(strOptString2)) {
                        if (jSONObjectOptJSONObject2.optJSONObject(LiveConfigKey.UHD) != null) {
                            str2 = LiveConfigKey.UHD;
                        } else if (jSONObjectOptJSONObject2.optJSONObject(LiveConfigKey.HIGH) != null) {
                            str2 = LiveConfigKey.HIGH;
                        } else if (jSONObjectOptJSONObject2.optJSONObject(LiveConfigKey.STANDARD) != null) {
                            str2 = LiveConfigKey.STANDARD;
                        } else if (jSONObjectOptJSONObject2.optJSONObject(LiveConfigKey.LOW) == null) {
                            str2 = null;
                        }
                        if (TextUtils.isEmpty(str2)) {
                            return;
                        }
                        com.bykv.vk.openvk.component.video.api.m.dl.z("TTLiveVideoPlayer", "update reso:".concat(String.valueOf(str2)));
                        this.z.setStringOption(43, str2);
                    }
                }
            }
        } catch (Exception e) {
            com.bykv.vk.openvk.component.video.api.m.dl.z("TTLiveVideoPlayer", "updateStream: catch exception:", e.getMessage());
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.component.wp.z.z$z, reason: collision with other inner class name */
    public static class C0146z implements INetworkClient {
        private final com.bytedance.sdk.component.g.z.wp z = dl.dl().g().z(10, TimeUnit.SECONDS).g(10, TimeUnit.SECONDS).dl(10, TimeUnit.SECONDS).z();

        @Override // com.bykv.vk.component.ttvideo.INetworkClient
        public INetworkClient.Result doPost(String str, String str2) {
            return null;
        }

        @Override // com.bykv.vk.component.ttvideo.INetworkClient
        public INetworkClient.Result doRequest(String str, String str2) {
            String str3;
            String strG;
            String str4 = null;
            String string = null;
            JSONObject jSONObject = null;
            try {
                try {
                    ls lsVarG = this.z.z(new v.z().z(str).g("host", str2).g()).g();
                    if (lsVarG.a()) {
                        strG = lsVarG.m().g();
                        try {
                            string = lsVarG.e().toString();
                            jSONObject = new JSONObject(strG);
                        } catch (JSONException e) {
                            e = e;
                            String str5 = string;
                            str4 = strG;
                            str3 = str5;
                            return INetworkClient.Result.newBuilder().setBody(str4).setHeader(str3).setException(e).build();
                        }
                    } else {
                        strG = null;
                    }
                    return INetworkClient.Result.newBuilder().setResponse(jSONObject).setBody(strG).build();
                } catch (IOException e2) {
                    return INetworkClient.Result.newBuilder().setException(e2).build();
                } catch (Exception e3) {
                    return INetworkClient.Result.newBuilder().setException(e3).build();
                }
            } catch (JSONException e4) {
                e = e4;
                str3 = null;
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public SurfaceTexture gz() {
        return this.hh;
    }

    @Override // com.bykv.vk.openvk.component.video.api.z
    public SurfaceHolder e() {
        return this.sy;
    }
}
