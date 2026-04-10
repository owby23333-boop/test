package com.bykv.vk.openvk.component.video.z.a;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.bytedance.sdk.component.utils.wp;
import com.funny.audio.core.utils.FileUtils;
import java.io.FileDescriptor;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes2.dex */
public class g extends com.bykv.vk.openvk.component.video.z.a.z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bykv.vk.openvk.component.video.z.z.z f101a;
    private final z dl;
    private volatile boolean e;
    private final MediaPlayer g;
    private Surface gc;
    private final Object m;

    public g() {
        MediaPlayer mediaPlayer;
        Object obj = new Object();
        this.m = obj;
        synchronized (obj) {
            mediaPlayer = new MediaPlayer();
            this.g = mediaPlayer;
        }
        z(mediaPlayer);
        try {
            mediaPlayer.setAudioStreamType(3);
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.m.dl.dl("CSJ_VIDEO", "setAudioStreamType error: ", th);
        }
        this.dl = new z(this);
        ls();
    }

    private void z(MediaPlayer mediaPlayer) {
        if (Build.VERSION.SDK_INT >= 28) {
            return;
        }
        try {
            Class<?> cls = Class.forName("android.media.MediaTimeProvider");
            Class<?> cls2 = Class.forName("android.media.SubtitleController");
            Class<?> cls3 = Class.forName("android.media.SubtitleController$Anchor");
            Object objNewInstance = cls2.getConstructor(Context.class, cls, Class.forName("android.media.SubtitleController$Listener")).newInstance(com.bykv.vk.openvk.component.video.api.dl.getContext(), null, null);
            Field declaredField = cls2.getDeclaredField("mHandler");
            declaredField.setAccessible(true);
            try {
                declaredField.set(objNewInstance, new Handler());
                declaredField.setAccessible(false);
                mediaPlayer.getClass().getMethod("setSubtitleAnchor", cls2, cls3).invoke(mediaPlayer, objNewInstance, null);
            } catch (Throwable th) {
                try {
                    com.bykv.vk.openvk.component.video.api.m.dl.dl("CSJ_VIDEO", "subtitleInstance error: ", th);
                } finally {
                    declaredField.setAccessible(false);
                }
            }
        } catch (Throwable th2) {
            com.bykv.vk.openvk.component.video.api.m.dl.dl("CSJ_VIDEO", "setSubtitleController error: ", th2);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.z.a.dl
    public void z(SurfaceHolder surfaceHolder) throws Throwable {
        synchronized (this.m) {
            try {
            } finally {
            }
            if (!this.e && surfaceHolder != null && surfaceHolder.getSurface() != null && this.z) {
                this.g.setDisplay(surfaceHolder);
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.z.a.dl
    public void z(Surface surface) {
        p();
        this.gc = surface;
        this.g.setSurface(surface);
    }

    @Override // com.bykv.vk.openvk.component.video.z.a.dl
    public void z(com.bykv.vk.openvk.component.video.api.g gVar) throws Throwable {
        this.g.setPlaybackParams(this.g.getPlaybackParams().setSpeed(gVar.z()));
    }

    @Override // com.bykv.vk.openvk.component.video.z.a.dl
    public void z(String str) throws Throwable {
        Uri uri = Uri.parse(str);
        String scheme = uri.getScheme();
        if (!TextUtils.isEmpty(scheme) && scheme.equalsIgnoreCase(FileUtils.URI_TYPE_FILE)) {
            this.g.setDataSource(uri.getPath());
        } else {
            this.g.setDataSource(str);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.z.a.dl
    public void z(FileDescriptor fileDescriptor) throws Throwable {
        this.g.setDataSource(fileDescriptor);
    }

    @Override // com.bykv.vk.openvk.component.video.z.a.dl
    public synchronized void z(com.bykv.vk.openvk.component.video.api.dl.a aVar) {
        this.f101a = com.bykv.vk.openvk.component.video.z.z.z.z(com.bykv.vk.openvk.component.video.api.dl.getContext(), aVar);
        com.bykv.vk.openvk.component.video.z.z.g.dl.z(aVar);
        this.g.setDataSource(this.f101a);
    }

    private void pf() {
        com.bykv.vk.openvk.component.video.z.z.z zVar = this.f101a;
        if (zVar != null) {
            try {
                zVar.close();
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.m.dl.dl("CSJ_VIDEO", "releaseMediaDataSource error: ", th);
            }
            this.f101a = null;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.z.a.dl
    public void gc() throws Throwable {
        this.g.start();
    }

    @Override // com.bykv.vk.openvk.component.video.z.a.dl
    public void m() throws Throwable {
        this.g.stop();
    }

    @Override // com.bykv.vk.openvk.component.video.z.a.dl
    public void e() throws Throwable {
        this.g.pause();
    }

    @Override // com.bykv.vk.openvk.component.video.z.a.dl
    public void gz() {
        MediaPlayer mediaPlayer = this.g;
        if (mediaPlayer != null) {
            mediaPlayer.prepareAsync();
        }
    }

    @Override // com.bykv.vk.openvk.component.video.z.a.dl
    public void g(boolean z2) throws Throwable {
        this.g.setScreenOnWhilePlaying(z2);
    }

    @Override // com.bykv.vk.openvk.component.video.z.a.dl
    public void z(long j, int i) throws Throwable {
        if (i == 0) {
            this.g.seekTo((int) j, 0);
            return;
        }
        if (i == 1) {
            this.g.seekTo((int) j, 1);
            return;
        }
        if (i == 2) {
            this.g.seekTo((int) j, 2);
        } else if (i == 3) {
            this.g.seekTo((int) j, 3);
        } else {
            this.g.seekTo((int) j);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.z.a.dl
    public long fo() {
        try {
            return this.g.getCurrentPosition();
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.m.dl.dl("CSJ_VIDEO", "getCurrentPosition error: ", th);
            return 0L;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.z.a.dl
    public long uy() {
        try {
            return this.g.getDuration();
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.m.dl.dl("CSJ_VIDEO", "getDuration error: ", th);
            return 0L;
        }
    }

    @Override // com.bykv.vk.openvk.component.video.z.a.dl
    public void kb() throws Throwable {
        synchronized (this.m) {
            if (!this.e) {
                this.g.release();
                this.e = true;
                p();
                pf();
                z();
                ls();
            }
        }
    }

    @Override // com.bykv.vk.openvk.component.video.z.a.dl
    public void wp() throws Throwable {
        try {
            this.g.reset();
        } catch (Throwable th) {
            com.bykv.vk.openvk.component.video.api.m.dl.dl("CSJ_VIDEO", "reset error: ", th);
        }
        pf();
        z();
        ls();
    }

    @Override // com.bykv.vk.openvk.component.video.z.a.dl
    public void dl(boolean z2) throws Throwable {
        this.g.setLooping(z2);
    }

    @Override // com.bykv.vk.openvk.component.video.z.a.dl
    public void a(boolean z2) throws Throwable {
        MediaPlayer mediaPlayer = this.g;
        if (mediaPlayer == null) {
            return;
        }
        if (z2) {
            mediaPlayer.setVolume(0.0f, 0.0f);
        } else {
            mediaPlayer.setVolume(1.0f, 1.0f);
        }
    }

    @Override // com.bykv.vk.openvk.component.video.z.a.dl
    public int i() {
        MediaPlayer mediaPlayer = this.g;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoWidth();
        }
        return 0;
    }

    @Override // com.bykv.vk.openvk.component.video.z.a.dl
    public int v() {
        MediaPlayer mediaPlayer = this.g;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoHeight();
        }
        return 0;
    }

    @Override // com.bykv.vk.openvk.component.video.z.a.dl
    public void gc(boolean z2) {
        try {
            MediaPlayer mediaPlayer = this.g;
            if (mediaPlayer != null) {
                mediaPlayer.setLooping(z2);
            }
        } catch (Throwable th) {
            wp.z(th);
        }
    }

    private void ls() {
        this.g.setOnPreparedListener(this.dl);
        this.g.setOnBufferingUpdateListener(this.dl);
        this.g.setOnCompletionListener(this.dl);
        this.g.setOnSeekCompleteListener(this.dl);
        this.g.setOnVideoSizeChangedListener(this.dl);
        this.g.setOnErrorListener(this.dl);
        this.g.setOnInfoListener(this.dl);
    }

    private static class z implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener {
        private final WeakReference<g> z;

        public z(g gVar) {
            this.z = new WeakReference<>(gVar);
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            try {
                com.bykv.vk.openvk.component.video.api.m.dl.z("CSJ_VIDEO", "onInfo: ");
                g gVar = this.z.get();
                if (gVar != null) {
                    if (gVar.g(i, i2)) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.m.dl.dl("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onInfo error: ", th);
                return false;
            }
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            try {
                com.bykv.vk.openvk.component.video.api.m.dl.z("CSJ_VIDEO", "onError: ", Integer.valueOf(i), Integer.valueOf(i2));
                g gVar = this.z.get();
                if (gVar != null) {
                    if (gVar.z(i, i2)) {
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.m.dl.dl("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onError error: ", th);
                return false;
            }
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            try {
                g gVar = this.z.get();
                if (gVar != null) {
                    gVar.z(i, i2, 1, 1);
                }
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.m.dl.dl("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onVideoSizeChanged error: ", th);
            }
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            try {
                g gVar = this.z.get();
                if (gVar != null) {
                    gVar.a();
                }
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.m.dl.dl("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onSeekComplete error: ", th);
            }
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            try {
                g gVar = this.z.get();
                if (gVar != null) {
                    gVar.z(i);
                }
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.m.dl.dl("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onBufferingUpdate error: ", th);
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            try {
                g gVar = this.z.get();
                if (gVar != null) {
                    gVar.dl();
                }
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.m.dl.dl("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onCompletion error: ", th);
            }
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            try {
                g gVar = this.z.get();
                if (gVar != null) {
                    gVar.g();
                }
            } catch (Throwable th) {
                com.bykv.vk.openvk.component.video.api.m.dl.dl("CSJ_VIDEO", "AndroidMediaPlayerListenerHolder.onPrepared error: ", th);
            }
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
        p();
    }

    private void p() {
        try {
            Surface surface = this.gc;
            if (surface != null) {
                surface.release();
                this.gc = null;
            }
        } catch (Throwable unused) {
        }
    }
}
