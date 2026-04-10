package com.bykv.vk.component.ttvideo.playerwrapper;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.bykv.vk.component.ttvideo.player.IMediaDataSource;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.component.ttvideo.player.MediaPlayerClient;
import com.bykv.vk.component.ttvideo.player.MediaTransport;
import com.bykv.vk.component.ttvideo.player.OSPlayerClient;
import com.bykv.vk.component.ttvideo.player.PlaybackParams;
import com.bytedance.sdk.component.utils.wp;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class MediaPlayerWrapper implements MediaPlayer {
    private static final String OWN_LITE_PLAYER_CLASS_NAME = "com.ss.ttmplayer.player.TTPlayerClient";
    private static final String OWN_PLAYER_CLASS_NAME = "com.bykv.vk.component.ttvideo.player.TTPlayerClient";
    private MediaPlayerClient mClient;

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void selectTrack(int i) {
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setDataSource(IMediaDataSource iMediaDataSource) throws IOException, IllegalArgumentException {
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setDataSource(FileDescriptor fileDescriptor, long j, long j2) throws IllegalStateException, IOException, IllegalArgumentException {
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setOnExternInfoListener(MediaPlayer.OnExternInfoListener onExternInfoListener) {
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void switchStream(int i, int i2) {
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0072 A[Catch: all -> 0x0085, TryCatch #0 {, blocks: (B:4:0x0008, B:11:0x003b, B:17:0x006f, B:10:0x0038, B:18:0x0072, B:20:0x0076, B:21:0x0083, B:7:0x0011, B:14:0x0041), top: B:26:0x0008, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0076 A[Catch: all -> 0x0085, TryCatch #0 {, blocks: (B:4:0x0008, B:11:0x003b, B:17:0x006f, B:10:0x0038, B:18:0x0072, B:20:0x0076, B:21:0x0083, B:7:0x0011, B:14:0x0041), top: B:26:0x0008, inners: #1, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.bykv.vk.component.ttvideo.player.MediaPlayer create(android.content.Context r9, int r10) {
        /*
            com.bykv.vk.component.ttvideo.playerwrapper.MediaPlayerWrapper r0 = new com.bykv.vk.component.ttvideo.playerwrapper.MediaPlayerWrapper
            r0.<init>()
            java.lang.Class<com.bykv.vk.component.ttvideo.playerwrapper.MediaPlayerWrapper> r1 = com.bykv.vk.component.ttvideo.playerwrapper.MediaPlayerWrapper.class
            monitor-enter(r1)
            boolean r2 = com.bykv.vk.component.ttvideo.player.TTPlayerConfiger.isOnTTPlayer()     // Catch: java.lang.Throwable -> L85
            if (r2 == 0) goto L72
            r2 = 0
            r3 = 2
            r4 = 1
            java.lang.String r5 = "com.bykv.vk.component.ttvideo.player.TTPlayerClient"
            java.lang.Class r5 = java.lang.Class.forName(r5)     // Catch: java.lang.Throwable -> L37
            java.lang.String r6 = "create"
            java.lang.Class[] r7 = new java.lang.Class[r3]     // Catch: java.lang.Throwable -> L37
            java.lang.Class<com.bykv.vk.component.ttvideo.player.MediaPlayer> r8 = com.bykv.vk.component.ttvideo.player.MediaPlayer.class
            r7[r2] = r8     // Catch: java.lang.Throwable -> L37
            java.lang.Class<android.content.Context> r8 = android.content.Context.class
            r7[r4] = r8     // Catch: java.lang.Throwable -> L37
            java.lang.reflect.Method r6 = r5.getDeclaredMethod(r6, r7)     // Catch: java.lang.Throwable -> L37
            r6.setAccessible(r4)     // Catch: java.lang.Throwable -> L37
            java.lang.Object[] r7 = new java.lang.Object[]{r0, r9}     // Catch: java.lang.Throwable -> L37
            java.lang.Object r5 = r6.invoke(r5, r7)     // Catch: java.lang.Throwable -> L37
            com.bykv.vk.component.ttvideo.player.MediaPlayerClient r5 = (com.bykv.vk.component.ttvideo.player.MediaPlayerClient) r5     // Catch: java.lang.Throwable -> L37
            r0.mClient = r5     // Catch: java.lang.Throwable -> L37
            goto L3b
        L37:
            r5 = move-exception
            com.bytedance.sdk.component.utils.wp.z(r5)     // Catch: java.lang.Throwable -> L85
        L3b:
            com.bykv.vk.component.ttvideo.player.MediaPlayerClient r5 = r0.mClient     // Catch: java.lang.Throwable -> L85
            if (r5 != 0) goto L72
            if (r10 != 0) goto L72
            java.lang.String r10 = "com.ss.ttmplayer.player.TTPlayerClient"
            java.lang.Class r10 = java.lang.Class.forName(r10)     // Catch: java.lang.Throwable -> L6e
            java.lang.String r5 = "fsl"
            java.lang.String r6 = "create lite player"
            com.bykv.vk.component.ttvideo.log.MyLog.i(r5, r6)     // Catch: java.lang.Throwable -> L6e
            java.lang.String r5 = "create"
            java.lang.Class[] r3 = new java.lang.Class[r3]     // Catch: java.lang.Throwable -> L6e
            java.lang.Class<com.bykv.vk.component.ttvideo.player.MediaPlayer> r6 = com.bykv.vk.component.ttvideo.player.MediaPlayer.class
            r3[r2] = r6     // Catch: java.lang.Throwable -> L6e
            java.lang.Class<android.content.Context> r2 = android.content.Context.class
            r3[r4] = r2     // Catch: java.lang.Throwable -> L6e
            java.lang.reflect.Method r2 = r10.getDeclaredMethod(r5, r3)     // Catch: java.lang.Throwable -> L6e
            r2.setAccessible(r4)     // Catch: java.lang.Throwable -> L6e
            java.lang.Object[] r3 = new java.lang.Object[]{r0, r9}     // Catch: java.lang.Throwable -> L6e
            java.lang.Object r10 = r2.invoke(r10, r3)     // Catch: java.lang.Throwable -> L6e
            com.bykv.vk.component.ttvideo.player.MediaPlayerClient r10 = (com.bykv.vk.component.ttvideo.player.MediaPlayerClient) r10     // Catch: java.lang.Throwable -> L6e
            r0.mClient = r10     // Catch: java.lang.Throwable -> L6e
            goto L72
        L6e:
            r10 = move-exception
            com.bytedance.sdk.component.utils.wp.z(r10)     // Catch: java.lang.Throwable -> L85
        L72:
            com.bykv.vk.component.ttvideo.player.MediaPlayerClient r10 = r0.mClient     // Catch: java.lang.Throwable -> L85
            if (r10 != 0) goto L83
            java.lang.String r10 = "fsl"
            java.lang.String r2 = "create osplayer"
            com.bykv.vk.component.ttvideo.log.MyLog.i(r10, r2)     // Catch: java.lang.Throwable -> L85
            com.bykv.vk.component.ttvideo.player.OSPlayerClient r9 = com.bykv.vk.component.ttvideo.player.OSPlayerClient.create(r0, r9)     // Catch: java.lang.Throwable -> L85
            r0.mClient = r9     // Catch: java.lang.Throwable -> L85
        L83:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L85
            return r0
        L85:
            r9 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L85
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.playerwrapper.MediaPlayerWrapper.create(android.content.Context, int):com.bykv.vk.component.ttvideo.player.MediaPlayer");
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public boolean isOSPlayer() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        return mediaPlayerClient == null || (mediaPlayerClient instanceof OSPlayerClient);
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public int getPlayerType() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.getType();
        }
        return 0;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void prevClose() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.prevClose();
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void release() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.release();
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void start() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.start();
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void pause() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.pause();
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void reset() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.reset();
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void stop() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.stop();
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void prepare() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.prepare();
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void prepareAsync() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.prepareAsync();
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public int getCurrentPosition() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public int getVideoHeight() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.getVideoHeight();
        }
        return 0;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public int getVideoWidth() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.getVideoWidth();
        }
        return 0;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public int getDuration() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.getDuration();
        }
        return 0;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public int getVideoType() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.getVideoType();
        }
        return 0;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setPanoVideoControlModel(int i) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setPanoVideoControlModel(i);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setDisplay(SurfaceHolder surfaceHolder) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setDisplay(surfaceHolder);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setSurface(Surface surface) {
        if (this.mClient == null || surface == null || !surface.isValid()) {
            return;
        }
        this.mClient.setSurface(surface);
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setDataSource(Context context, Uri uri, Map<String, String> map) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setDataSource(context, uri, map);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setDataSource(String str) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setDataSource(str);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setDataSource(Context context, Uri uri) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setDataSource(context, uri);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public String getDataSource() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.getDataSource();
        }
        return null;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public boolean isPlaying() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.isPlaying();
        }
        return false;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public boolean isLooping() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.isLooping();
        }
        return false;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setLooping(boolean z) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setLooping(z);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setVolume(float f, float f2) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setVolume(f, f2);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void mouseEvent(int i, int i2, int i3) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.mouseEvent(i, i2, i3);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void seekTo(int i) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.seekTo(i);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setScreenOnWhilePlaying(boolean z) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setScreenOnWhilePlaying(z);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setOnLogListener(MediaPlayer.OnLogListener onLogListener) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setOnLogListener(onLogListener);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setOnBufferingUpdateListener(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setOnBufferingUpdateListener(onBufferingUpdateListener);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setOnCompletionListener(onCompletionListener);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setOnErrorListener(onErrorListener);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setOnInfoListener(onInfoListener);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setOnPreparedListener(onPreparedListener);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setOnSeekCompleteListener(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setOnSeekCompleteListener(onSeekCompleteListener);
        }
    }

    public void setFrameMetadataListener(Object obj) {
        if (this.mClient != null) {
            try {
                Class<?> cls = Class.forName("com.bykv.vk.component.ttvideo.player.FrameMetadataListener");
                if (cls != null) {
                    Method method = Class.forName(OWN_PLAYER_CLASS_NAME).getMethod("setFrameMetadataListener", cls);
                    method.setAccessible(true);
                    method.invoke(this.mClient, obj);
                }
            } catch (Throwable th) {
                wp.z(th);
            }
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setOnVideoSizeChangedListener(MediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setOnVideoSizeChangedListener(onVideoSizeChangedListener);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setOnSARChangedListener(MediaPlayer.onSARChangedListener onsarchangedlistener) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setOnSARChangedListener(onsarchangedlistener);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setIntOption(int i, int i2) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setIntOption(i, i2);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setWakeMode(Context context, int i) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setWakeMode(context, i);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setIsMute(boolean z) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setIsMute(z);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public boolean isMute() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.isMute();
        }
        return false;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setCacheFile(String str, int i) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setCacheFile(str, i);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setStringOption(int i, String str) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setStringOption(i, str);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public int getIntOption(int i, int i2) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        return mediaPlayerClient != null ? mediaPlayerClient.getIntOption(i, i2) : i2;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public String getStringOption(int i) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.getStringOption(i);
        }
        return null;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public long getLongOption(int i, long j) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        return mediaPlayerClient != null ? mediaPlayerClient.getLongOption(i, j) : j;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public long setLongOption(int i, long j) {
        if (this.mClient != null) {
            return r0.setLongOption(i, j);
        }
        return -1L;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void rotateCamera(float f, float f2) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.rotateCamera(f, f2);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void takeScreenshot(MediaPlayer.OnScreenshotListener onScreenshotListener) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.takeScreenshot(onScreenshotListener);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public MediaPlayer.TrackInfo[] getTrackInfo() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.getTrackInfo();
        }
        return null;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public int getSelectedTrack(int i) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.getSelectedTrack(i);
        }
        return -1;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void deselectTrack(int i) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.deselectTrack(i);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setPlaybackParams(PlaybackParams playbackParams) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setPlaybackParams(playbackParams);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public float getFloatOption(int i, float f) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        return mediaPlayerClient != null ? mediaPlayerClient.getFloatOption(i, f) : f;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public int setFloatOption(int i, float f) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            return mediaPlayerClient.setFloatOption(i, f);
        }
        return -1;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void releaseAsync() {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.releaseAsync();
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer
    public void setMediaTransport(MediaTransport mediaTransport) {
        MediaPlayerClient mediaPlayerClient = this.mClient;
        if (mediaPlayerClient != null) {
            mediaPlayerClient.setMediaTransport(mediaTransport);
        }
    }
}
