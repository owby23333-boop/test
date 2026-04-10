package com.iflytek.aikit.media;

import android.content.Context;
import com.iflytek.aikit.media.player.AudioParam;
import com.iflytek.aikit.media.player.PlayerListener;
import com.iflytek.aikit.media.player.SimplePlayer;
import com.iflytek.aikit.media.speech.SpeechError;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: classes7.dex */
public class SimplePlayerHelper implements MediaPlayerHelper, SimplePlayerWriter {
    private SimplePlayer simplePlayer = null;

    public static class Holder {
        private static final SimplePlayerHelper instance = new SimplePlayerHelper();

        private Holder() {
        }
    }

    private AudioParam getAudioParam() {
        AudioParam audioParam = new AudioParam();
        audioParam.mFrequency = 16000;
        audioParam.mChannel = 2;
        audioParam.mSampleBit = 2;
        return audioParam;
    }

    public static SimplePlayerHelper getInst() {
        return Holder.instance;
    }

    private byte[] getPCMData(String str) {
        File file = new File(str);
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[(int) file.length()];
            try {
                fileInputStream.read(bArr);
                return bArr;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Deprecated
    public void init(String str, SimplePlayer.PlayerListener playerListener) {
        init(getPCMData(str), playerListener);
    }

    @Override // com.iflytek.aikit.media.MediaPlayerHelper
    public boolean isPlaying() {
        return false;
    }

    @Override // com.iflytek.aikit.media.MediaPlayerHelper
    public void pause() {
        SimplePlayer simplePlayer = this.simplePlayer;
        if (simplePlayer != null) {
            simplePlayer.pause();
        }
    }

    @Override // com.iflytek.aikit.media.MediaPlayerHelper
    public void play() {
        SimplePlayer simplePlayer = this.simplePlayer;
        if (simplePlayer != null) {
            simplePlayer.play();
        }
    }

    @Override // com.iflytek.aikit.media.MediaPlayerHelper
    public void release() {
        SimplePlayer simplePlayer = this.simplePlayer;
        if (simplePlayer != null) {
            simplePlayer.release();
        }
    }

    @Override // com.iflytek.aikit.media.MediaPlayerHelper
    public void resume() {
        SimplePlayer simplePlayer = this.simplePlayer;
        if (simplePlayer != null) {
            simplePlayer.resume();
        }
    }

    @Override // com.iflytek.aikit.media.MediaPlayerHelper
    public void stop() {
        SimplePlayer simplePlayer = this.simplePlayer;
        if (simplePlayer != null) {
            simplePlayer.stop();
        }
    }

    @Override // com.iflytek.aikit.media.SimplePlayerWriter
    public boolean write(String str) {
        return write(getPCMData(str));
    }

    @Deprecated
    public void init(byte[] bArr, final SimplePlayer.PlayerListener playerListener) {
        init((Context) null, new PlayerListener() { // from class: com.iflytek.aikit.media.SimplePlayerHelper.1
            @Override // com.iflytek.aikit.media.player.PlayerListener
            public void onError(SpeechError speechError) {
                playerListener.onError(speechError.getErrorCode());
            }

            @Override // com.iflytek.aikit.media.player.PlayerListener
            public void onFinish() {
                playerListener.onCompleted();
            }

            @Override // com.iflytek.aikit.media.player.PlayerListener
            public void onPause() {
                playerListener.onPause();
            }

            @Override // com.iflytek.aikit.media.player.PlayerListener
            public void onPercent(int i, int i2, int i3) {
            }

            @Override // com.iflytek.aikit.media.player.PlayerListener
            public void onResume() {
            }

            @Override // com.iflytek.aikit.media.player.PlayerListener
            public void onStart() {
                playerListener.onStart();
            }

            @Override // com.iflytek.aikit.media.player.PlayerListener
            public void onStop() {
                playerListener.onStop();
            }
        });
        write(bArr);
    }

    @Override // com.iflytek.aikit.media.SimplePlayerWriter
    public boolean write(byte[] bArr) {
        this.simplePlayer.setDataSource(bArr);
        this.simplePlayer.prepare();
        return true;
    }

    @Override // com.iflytek.aikit.media.MediaPlayerHelper
    public void init(Context context, PlayerListener playerListener) {
        SimplePlayer simplePlayer = this.simplePlayer;
        if (simplePlayer != null) {
            simplePlayer.stop();
            this.simplePlayer = null;
        }
        this.simplePlayer = new SimplePlayer(playerListener);
        this.simplePlayer.setAudioParam(getAudioParam());
    }
}
