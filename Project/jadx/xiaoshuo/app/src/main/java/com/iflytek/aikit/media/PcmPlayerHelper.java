package com.iflytek.aikit.media;

import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.iflytek.aikit.core.media.player.PcmPlayer;
import com.iflytek.aikit.media.player.PcmPlayer;
import com.iflytek.aikit.media.player.PlayerListener;
import com.iflytek.aikit.media.record.PcmBuffer;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes7.dex */
public class PcmPlayerHelper implements MediaPlayerHelper, PcmPlayerWriter {
    private Context mContext;
    private PcmPlayer mPlayer = null;
    private PcmBuffer mBuffer = null;
    private AtomicBoolean isInit = new AtomicBoolean(false);
    private AtomicInteger totalPercent = new AtomicInteger(100);

    public static class Holder {
        private static PcmPlayerHelper instance = new PcmPlayerHelper();

        private Holder() {
        }
    }

    private void doInitPlayer(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        if (this.mPlayer == null) {
            this.mPlayer = new PcmPlayer(applicationContext, 3, true, false, false);
        }
        this.isInit.set(true);
    }

    public static PcmPlayerHelper getInst() {
        return Holder.instance;
    }

    @Override // com.iflytek.aikit.media.MediaPlayerHelper
    public void init(Context context, PlayerListener playerListener) {
        doInitPlayer(context);
        this.mPlayer.setListener(playerListener);
    }

    @Deprecated
    public void initPlayer(@NonNull Context context) {
        doInitPlayer(context);
    }

    public boolean isInit() {
        return this.isInit.get();
    }

    @Override // com.iflytek.aikit.media.MediaPlayerHelper
    public boolean isPlaying() {
        PcmPlayer pcmPlayer = this.mPlayer;
        return pcmPlayer != null && pcmPlayer.getState() == 2;
    }

    @Override // com.iflytek.aikit.media.MediaPlayerHelper
    public void pause() {
        PcmPlayer pcmPlayer = this.mPlayer;
        if (pcmPlayer != null) {
            pcmPlayer.pause();
        }
    }

    @Override // com.iflytek.aikit.media.MediaPlayerHelper
    public void play() {
        PcmPlayer pcmPlayer = this.mPlayer;
        if (pcmPlayer == null) {
            return;
        }
        if (pcmPlayer.getState() == 2 || this.mPlayer.getState() == 3) {
            this.mPlayer.stop();
            SystemClock.sleep(200L);
        }
        this.mPlayer.play(this.mBuffer);
    }

    @Override // com.iflytek.aikit.media.MediaPlayerHelper
    public void release() {
        this.mContext = null;
        PcmPlayer pcmPlayer = this.mPlayer;
        if (pcmPlayer != null) {
            pcmPlayer.stop();
            this.mPlayer.release();
        }
        this.mPlayer = null;
        this.mBuffer = null;
        this.isInit.set(false);
    }

    public void resetBuffer(int i) {
        if (this.mPlayer == null) {
            return;
        }
        PcmBuffer pcmBuffer = this.mBuffer;
        if (pcmBuffer == null) {
            this.mBuffer = new PcmBuffer(this.mContext, 16000, i <= 0 ? 1 : i, null, 100);
        } else {
            pcmBuffer.reset(this.mContext, 16000, i <= 0 ? 1 : i, null, 100);
            this.mBuffer.deleteFile();
        }
    }

    public void resetPercent(int i) {
        if (this.isInit.get()) {
            this.totalPercent.set(i);
        }
    }

    @Override // com.iflytek.aikit.media.MediaPlayerHelper
    public void resume() {
        PcmPlayer pcmPlayer = this.mPlayer;
        if (pcmPlayer != null) {
            pcmPlayer.resume();
        }
    }

    public void setLocalDataSize(int i) {
        resetBuffer(1);
        this.mBuffer.setMaxFileSize(i);
    }

    @Deprecated
    public synchronized int startPlay(PcmPlayer.PcmPlayerListener pcmPlayerListener) {
        com.iflytek.aikit.media.player.PcmPlayer pcmPlayer = this.mPlayer;
        if (pcmPlayer == null) {
            return -1;
        }
        pcmPlayer.setListener(pcmPlayerListener);
        play();
        return 0;
    }

    @Override // com.iflytek.aikit.media.MediaPlayerHelper
    public void stop() {
        com.iflytek.aikit.media.player.PcmPlayer pcmPlayer = this.mPlayer;
        if (pcmPlayer != null) {
            pcmPlayer.stop();
        }
        resetBuffer(0);
    }

    public boolean write(ArrayList<byte[]> arrayList, int i, int i2) {
        PcmBuffer pcmBuffer = this.mBuffer;
        if (pcmBuffer == null) {
            return false;
        }
        return pcmBuffer.writeStream(arrayList, this.totalPercent.get(), i, i2);
    }

    @Override // com.iflytek.aikit.media.PcmPlayerWriter
    public boolean write(byte[] bArr, int i, int i2) {
        if (this.mBuffer == null) {
            return false;
        }
        ArrayList<byte[]> arrayList = new ArrayList<>();
        arrayList.add(bArr);
        return this.mBuffer.writeStream(arrayList, this.totalPercent.get(), i, i2);
    }
}
