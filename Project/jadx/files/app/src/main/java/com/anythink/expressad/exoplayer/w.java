package com.anythink.expressad.exoplayer;

import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.annotation.Nullable;
import com.anythink.expressad.exoplayer.h.af;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public interface w {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f10072h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f10073i = 2;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f10074j = 3;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f10075k = 4;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f10076l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f10077m = 1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f10078n = 2;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f10079o = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f10080p = 1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f10081q = 2;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f10082r = 3;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f10083s = 4;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f10084t = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f10085u = 1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f10086v = 2;

    public static abstract class a implements c {
        @Deprecated
        private static void a() {
        }

        @Override // com.anythink.expressad.exoplayer.w.c
        public void onLoadingChanged(boolean z2) {
        }

        @Override // com.anythink.expressad.exoplayer.w.c
        public void onPlaybackParametersChanged(v vVar) {
        }

        @Override // com.anythink.expressad.exoplayer.w.c
        public void onPlayerError(com.anythink.expressad.exoplayer.g gVar) {
        }

        @Override // com.anythink.expressad.exoplayer.w.c
        public void onPlayerStateChanged(boolean z2, int i2) {
        }

        @Override // com.anythink.expressad.exoplayer.w.c
        public void onPositionDiscontinuity(int i2) {
        }

        @Override // com.anythink.expressad.exoplayer.w.c
        public void onRepeatModeChanged(int i2) {
        }

        @Override // com.anythink.expressad.exoplayer.w.c
        public void onSeekProcessed() {
        }

        @Override // com.anythink.expressad.exoplayer.w.c
        public void onShuffleModeEnabledChanged(boolean z2) {
        }

        @Override // com.anythink.expressad.exoplayer.w.c
        public void onTimelineChanged(ae aeVar, @Nullable Object obj, int i2) {
        }

        @Override // com.anythink.expressad.exoplayer.w.c
        public void onTracksChanged(af afVar, com.anythink.expressad.exoplayer.i.g gVar) {
        }
    }

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface b {
    }

    public interface c {
        void onLoadingChanged(boolean z2);

        void onPlaybackParametersChanged(v vVar);

        void onPlayerError(com.anythink.expressad.exoplayer.g gVar);

        void onPlayerStateChanged(boolean z2, int i2);

        void onPositionDiscontinuity(int i2);

        void onRepeatModeChanged(int i2);

        void onSeekProcessed();

        void onShuffleModeEnabledChanged(boolean z2);

        void onTimelineChanged(ae aeVar, @Nullable Object obj, int i2);

        void onTracksChanged(af afVar, com.anythink.expressad.exoplayer.i.g gVar);
    }

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface d {
    }

    public interface e {
    }

    /* JADX INFO: loaded from: classes.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface f {
    }

    public interface g {
        int H();

        void I();

        void a(Surface surface);

        void a(SurfaceHolder surfaceHolder);

        void a(SurfaceView surfaceView);

        void a(TextureView textureView);

        void a(com.anythink.expressad.exoplayer.l.g gVar);

        void b(Surface surface);

        void b(SurfaceHolder surfaceHolder);

        void b(SurfaceView surfaceView);

        void b(TextureView textureView);

        void b(com.anythink.expressad.exoplayer.l.g gVar);

        void d(int i2);
    }

    int A();

    long B();

    int C();

    af D();

    com.anythink.expressad.exoplayer.i.g E();

    ae F();

    @Nullable
    Object G();

    void a(int i2);

    void a(int i2, long j2);

    void a(long j2);

    void a(@Nullable v vVar);

    void a(c cVar);

    void a(boolean z2);

    @Nullable
    g b();

    void b(int i2);

    void b(c cVar);

    void b(boolean z2);

    int c(int i2);

    @Nullable
    e c();

    void c(boolean z2);

    int d();

    @Nullable
    com.anythink.expressad.exoplayer.g e();

    boolean f();

    int g();

    boolean h();

    boolean i();

    void j();

    v k();

    @Nullable
    Object l();

    void m();

    void n();

    int o();

    int p();

    int q();

    int r();

    long s();

    long t();

    long u();

    int v();

    boolean w();

    boolean x();

    boolean y();

    int z();
}
