package com.iflytek.aikit.media.player;

import android.media.AudioTrack;
import android.util.Log;

/* JADX INFO: loaded from: classes7.dex */
public class SimplePlayer implements MediaPlayer {
    private static final int MIN_SLEEP = 5;
    public static final int STATE_MSG_ID = 16;
    private static final String TAG = "AudioPlayerPlugin";

    /* JADX INFO: renamed from: listener, reason: collision with root package name */
    private com.iflytek.aikit.media.player.PlayerListener f7020listener;
    private AudioParam mAudioParam;
    private AudioTrack mAudioTrack;
    private byte[] mData;
    private PlayAudioThread mPlayAudioThread;
    private PlayerListener oldListener;
    private boolean mBReady = false;
    private Object mSyncObj = this;
    private boolean mThreadExitFlag = false;
    private int mPrimePlaySize = 0;
    private int mPlayOffset = 0;
    private int mPlayState = 0;

    public class PlayAudioThread extends Thread {
        private PlayAudioThread() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                try {
                    SimplePlayer.this.oldListener.onStart();
                    synchronized (SimplePlayer.this.mSyncObj) {
                        if (SimplePlayer.this.mPlayState != 0 && SimplePlayer.this.mPlayState != 3) {
                            SimplePlayer.this.mPlayState = 2;
                        }
                    }
                    while (true) {
                        if (SimplePlayer.this.mThreadExitFlag) {
                            SimplePlayer.this.oldListener.onStop();
                            break;
                        }
                        if (SimplePlayer.this.mPlayState == 3) {
                            SimplePlayer.this.oldListener.onPause();
                            SimplePlayer.this.mAudioTrack.pause();
                        } else if (SimplePlayer.this.mPlayState == 2) {
                            SimplePlayer.this.mAudioTrack.play();
                        }
                        SimplePlayer.this.mAudioTrack.write(SimplePlayer.this.mData, SimplePlayer.this.mPlayOffset, SimplePlayer.this.mPrimePlaySize);
                        SimplePlayer simplePlayer = SimplePlayer.this;
                        SimplePlayer.access$712(simplePlayer, simplePlayer.mPrimePlaySize);
                        if (SimplePlayer.this.mPlayOffset >= SimplePlayer.this.mData.length) {
                            SimplePlayer.this.onPlayComplete();
                            break;
                        }
                    }
                    synchronized (SimplePlayer.this.mSyncObj) {
                        SimplePlayer.this.mPlayState = 1;
                    }
                    if (SimplePlayer.this.mAudioTrack == null) {
                        return;
                    }
                } catch (Exception e) {
                    Log.e(SimplePlayer.TAG, "play media failed:" + e);
                    synchronized (SimplePlayer.this.mSyncObj) {
                        SimplePlayer.this.mPlayState = 1;
                        if (SimplePlayer.this.mAudioTrack == null) {
                            return;
                        }
                    }
                }
                SimplePlayer.this.mAudioTrack.release();
                SimplePlayer.this.mAudioTrack = null;
            } catch (Throwable th) {
                synchronized (SimplePlayer.this.mSyncObj) {
                    SimplePlayer.this.mPlayState = 1;
                    if (SimplePlayer.this.mAudioTrack != null) {
                        SimplePlayer.this.mAudioTrack.release();
                        SimplePlayer.this.mAudioTrack = null;
                    }
                    throw th;
                }
            }
        }
    }

    @Deprecated
    public interface PlayerListener {
        void onCompleted();

        void onError(int i);

        void onPause();

        void onStart();

        void onStop();
    }

    @Deprecated
    public SimplePlayer(PlayerListener playerListener) {
        this.oldListener = playerListener;
    }

    public static /* synthetic */ int access$712(SimplePlayer simplePlayer, int i) {
        int i2 = simplePlayer.mPlayOffset + i;
        simplePlayer.mPlayOffset = i2;
        return i2;
    }

    private void createAudioTrack() throws Exception {
        AudioParam audioParam = this.mAudioParam;
        int minBufferSize = AudioTrack.getMinBufferSize(audioParam.mFrequency, audioParam.mChannel, audioParam.mSampleBit);
        this.mPrimePlaySize = minBufferSize * 2;
        AudioParam audioParam2 = this.mAudioParam;
        this.mAudioTrack = new AudioTrack(3, audioParam2.mFrequency, audioParam2.mChannel, audioParam2.mSampleBit, minBufferSize, 1);
    }

    private void releaseAudioTrack() {
        AudioTrack audioTrack = this.mAudioTrack;
        if (audioTrack != null) {
            audioTrack.stop();
            this.mAudioTrack.release();
            this.mAudioTrack = null;
        }
    }

    private boolean setPlayState(int i) {
        synchronized (this.mSyncObj) {
            this.mPlayState = i;
        }
        return true;
    }

    private void startThread() {
        if (this.mPlayAudioThread == null) {
            this.mThreadExitFlag = false;
            PlayAudioThread playAudioThread = new PlayAudioThread();
            this.mPlayAudioThread = playAudioThread;
            playAudioThread.start();
        }
    }

    private void stopThread() {
        if (this.mPlayAudioThread != null) {
            this.mThreadExitFlag = true;
            this.mPlayAudioThread = null;
        }
    }

    public void onPlayComplete() {
        this.mPlayAudioThread = null;
        if (this.mPlayState != 3) {
            setPlayState(1);
            PlayerListener playerListener = this.oldListener;
            if (playerListener != null) {
                playerListener.onCompleted();
            }
        }
    }

    @Override // com.iflytek.aikit.media.player.MediaPlayer
    public boolean pause() {
        if (!this.mBReady) {
            return false;
        }
        if (this.mPlayState != 2) {
            return true;
        }
        setPlayState(3);
        stopThread();
        return true;
    }

    public boolean play() {
        if (!this.mBReady) {
            return false;
        }
        int i = this.mPlayState;
        if (i == 1) {
            this.mPlayOffset = 0;
            setPlayState(2);
            startThread();
        } else if (i == 3) {
            setPlayState(2);
            startThread();
        }
        return true;
    }

    public boolean prepare() {
        if (this.mData != null && this.mAudioParam != null) {
            if (this.mBReady) {
                return true;
            }
            try {
                createAudioTrack();
                this.mBReady = true;
                setPlayState(1);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean release() {
        stop();
        releaseAudioTrack();
        this.mBReady = false;
        setPlayState(0);
        return true;
    }

    @Override // com.iflytek.aikit.media.player.MediaPlayer
    public boolean resume() {
        return true;
    }

    public void setAudioParam(AudioParam audioParam) {
        this.mAudioParam = audioParam;
    }

    public void setDataSource(byte[] bArr) {
        if (bArr == null) {
            return;
        }
        this.mData = bArr;
    }

    public void setListener(PlayerListener playerListener) {
        this.oldListener = playerListener;
    }

    @Override // com.iflytek.aikit.media.player.MediaPlayer
    public boolean stop() {
        if (!this.mBReady) {
            return false;
        }
        setPlayState(1);
        stopThread();
        return true;
    }

    @Override // com.iflytek.aikit.media.player.MediaPlayer
    public void setListener(com.iflytek.aikit.media.player.PlayerListener playerListener) {
        this.f7020listener = playerListener;
    }

    @Deprecated
    public SimplePlayer(PlayerListener playerListener, AudioParam audioParam) {
        this.oldListener = playerListener;
        setAudioParam(audioParam);
    }

    public SimplePlayer(com.iflytek.aikit.media.player.PlayerListener playerListener) {
        setListener(playerListener);
    }

    public SimplePlayer(com.iflytek.aikit.media.player.PlayerListener playerListener, AudioParam audioParam) {
        setListener(playerListener);
        setAudioParam(audioParam);
    }
}
