package com.yuewen;

import android.app.Activity;
import android.media.MediaPlayer;
import java.io.Closeable;

/* JADX INFO: loaded from: classes5.dex */
public final class xj implements MediaPlayer.OnErrorListener, Closeable {
    public static final String c = "xj";
    public static final boolean d = true;
    public static final float e = 0.1f;
    public static final long f = 200;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f19915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MediaPlayer f19916b = null;

    public xj(Activity activity) {
        this.f19915a = activity;
        c();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:38:0x005a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.media.MediaPlayer a(android.content.Context r9) throws java.lang.Throwable {
        /*
            r8 = this;
            android.media.MediaPlayer r6 = new android.media.MediaPlayer
            r6.<init>()
            r7 = 0
            android.content.res.Resources r9 = r9.getResources()     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L41
            int r0 = com.yuewen.st2.r.f17713a     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L41
            android.content.res.AssetFileDescriptor r9 = r9.openRawResourceFd(r0)     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L41
            java.io.FileDescriptor r1 = r9.getFileDescriptor()     // Catch: java.io.IOException -> L3d java.lang.Throwable -> L56
            long r2 = r9.getStartOffset()     // Catch: java.io.IOException -> L3d java.lang.Throwable -> L56
            long r4 = r9.getLength()     // Catch: java.io.IOException -> L3d java.lang.Throwable -> L56
            r0 = r6
            r0.setDataSource(r1, r2, r4)     // Catch: java.io.IOException -> L3d java.lang.Throwable -> L56
            r6.setOnErrorListener(r8)     // Catch: java.io.IOException -> L3d java.lang.Throwable -> L56
            r0 = 3
            r6.setAudioStreamType(r0)     // Catch: java.io.IOException -> L3d java.lang.Throwable -> L56
            r0 = 0
            r6.setLooping(r0)     // Catch: java.io.IOException -> L3d java.lang.Throwable -> L56
            r0 = 1036831949(0x3dcccccd, float:0.1)
            r6.setVolume(r0, r0)     // Catch: java.io.IOException -> L3d java.lang.Throwable -> L56
            r6.prepare()     // Catch: java.io.IOException -> L3d java.lang.Throwable -> L56
            r9.close()     // Catch: java.io.IOException -> L38
            goto L3c
        L38:
            r9 = move-exception
            r9.printStackTrace()
        L3c:
            return r6
        L3d:
            r0 = move-exception
            goto L43
        L3f:
            r0 = move-exception
            goto L58
        L41:
            r0 = move-exception
            r9 = r7
        L43:
            java.lang.String r1 = com.yuewen.xj.c     // Catch: java.lang.Throwable -> L56
            android.util.Log.w(r1, r0)     // Catch: java.lang.Throwable -> L56
            r6.release()     // Catch: java.lang.Throwable -> L56
            if (r9 == 0) goto L55
            r9.close()     // Catch: java.io.IOException -> L51
            goto L55
        L51:
            r9 = move-exception
            r9.printStackTrace()
        L55:
            return r7
        L56:
            r0 = move-exception
            r7 = r9
        L58:
            if (r7 == 0) goto L62
            r7.close()     // Catch: java.io.IOException -> L5e
            goto L62
        L5e:
            r9 = move-exception
            r9.printStackTrace()
        L62:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yuewen.xj.a(android.content.Context):android.media.MediaPlayer");
    }

    public synchronized void b() {
        MediaPlayer mediaPlayer = this.f19916b;
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
    }

    public synchronized void c() {
        if (this.f19916b == null) {
            this.f19915a.setVolumeControlStream(3);
            this.f19916b = a(this.f19915a);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        MediaPlayer mediaPlayer = this.f19916b;
        if (mediaPlayer != null) {
            mediaPlayer.release();
            this.f19916b = null;
        }
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public synchronized boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        if (i == 100) {
            this.f19915a.finish();
        } else {
            close();
            c();
        }
        return true;
    }
}
