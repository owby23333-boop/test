package com.king.zxing;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: compiled from: BeepManager.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g implements MediaPlayer.OnErrorListener, Closeable {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final Activity f16495s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private MediaPlayer f16496t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private boolean f16497u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f16498v;

    g(Activity activity) {
        this.f16495s = activity;
        j();
    }

    public void a(boolean z2) {
        this.f16497u = z2;
    }

    public void b(boolean z2) {
        this.f16498v = z2;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.f16496t != null) {
            this.f16496t.release();
            this.f16496t = null;
        }
    }

    synchronized void i() {
        if (this.f16497u && this.f16496t != null) {
            this.f16496t.start();
        }
        if (this.f16498v) {
            ((Vibrator) this.f16495s.getSystemService("vibrator")).vibrate(200L);
        }
    }

    synchronized void j() {
        a(PreferenceManager.getDefaultSharedPreferences(this.f16495s), this.f16495s);
        if (this.f16497u && this.f16496t == null) {
            this.f16495s.setVolumeControlStream(3);
            this.f16496t = a(this.f16495s);
        }
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public synchronized boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
        if (i2 == 100) {
            this.f16495s.finish();
        } else {
            close();
            j();
        }
        return true;
    }

    private static boolean a(SharedPreferences sharedPreferences, Context context) {
        boolean z2 = sharedPreferences.getBoolean("preferences_play_beep", false);
        if (!z2 || ((AudioManager) context.getSystemService(com.anythink.expressad.exoplayer.k.o.b)).getRingerMode() == 2) {
            return z2;
        }
        return false;
    }

    @TargetApi(19)
    private MediaPlayer a(Context context) {
        MediaPlayer mediaPlayer = new MediaPlayer();
        try {
            AssetFileDescriptor assetFileDescriptorOpenRawResourceFd = context.getResources().openRawResourceFd(R$raw.zxl_beep);
            try {
                mediaPlayer.setDataSource(assetFileDescriptorOpenRawResourceFd.getFileDescriptor(), assetFileDescriptorOpenRawResourceFd.getStartOffset(), assetFileDescriptorOpenRawResourceFd.getLength());
                mediaPlayer.setOnErrorListener(this);
                mediaPlayer.setAudioStreamType(3);
                mediaPlayer.setLooping(false);
                mediaPlayer.setVolume(0.1f, 0.1f);
                mediaPlayer.prepare();
                if (assetFileDescriptorOpenRawResourceFd != null) {
                    assetFileDescriptorOpenRawResourceFd.close();
                }
                return mediaPlayer;
            } finally {
            }
        } catch (IOException e2) {
            com.king.zxing.r.b.b(e2);
            mediaPlayer.release();
            return null;
        }
    }
}
