package com.iflytek.aikit.plugin.player;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.util.Log;
import com.dangdang.zframework.utils.MemoryStatus;
import com.iflytek.aikit.plugin.ChannelConfig;
import com.iflytek.aikit.plugin.EventType;
import com.iflytek.aikit.plugin.PcmEncoding;
import com.iflytek.aikit.plugin.RateType;
import com.iflytek.aikit.plugin.StreamType;
import com.iflytek.aikit.plugin.player.AudioBuffer;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes7.dex */
public class AudioPlayerImpl {
    private final int BUFFERING;
    private final int FADE_PERIOD;
    private final int FADE_TIME;
    private final int INIT;
    private final float MAX_VOL;
    private final long MIN_SLEEP;
    private final float MIN_VOL;
    private final int PAUSED;
    private final float PER;
    private final int PLAYING;
    private final int STOPPED;
    private final String TAG;
    private AudioManager.OnAudioFocusChangeListener afChangeListener;
    private AudioBuffer audioBuffer;
    private AudioManager audioManager;
    private AudioTrack audioTrack;
    private ReentrantLock buffLock;
    private boolean changeListenerFlag;
    private int currentIndex;
    private AtomicBoolean isExit;
    private boolean mAudioFocus;
    private int mBufferCapital;
    private int mBufferSize;
    private int mChannelConfig;
    private Context mContext;
    private float mCurFadingPeriod;
    private float mCurVol;
    private Condition mEndCondition;
    private ReentrantLock mEndLock;
    private boolean mFading;
    private boolean mFadingEnable;
    private int mFadingSize;
    private int mPcmEncoding;
    private int mPerPlaySize;
    private int mSampleRate;
    private int mStreamType;
    private final Object mSyncObj;
    private float mTargetVol;
    private int minBufferSize;
    private volatile long playPercent;
    private int playState;
    private PlayerThread playThread;
    private ByteBuffer playerBuffer;
    private PlayerCallBack playerListener;
    private volatile int readOffset;
    private boolean requestFocus;
    private volatile long totalSize;

    public class PlayerThread extends Thread {
        private int bufOffset;
        private byte[] mAudioBuffer;

        private PlayerThread() {
            this.mAudioBuffer = null;
            this.bufOffset = 0;
        }

        private void readAudio(int i) {
            AudioPlayerImpl.this.buffLock.lock();
            byte[] bArr = this.mAudioBuffer;
            if (bArr == null || bArr.length < i * 10) {
                this.mAudioBuffer = new byte[i * 10];
            }
            AudioPlayerImpl.this.playerBuffer.flip();
            int iLimit = AudioPlayerImpl.this.playerBuffer.limit() - AudioPlayerImpl.this.playerBuffer.position();
            byte[] bArr2 = this.mAudioBuffer;
            if (iLimit < bArr2.length) {
                int iLimit2 = AudioPlayerImpl.this.playerBuffer.limit() - AudioPlayerImpl.this.playerBuffer.position();
                this.bufOffset = iLimit2;
                this.mAudioBuffer = new byte[iLimit2];
                AudioPlayerImpl.this.playerBuffer.get(this.mAudioBuffer, 0, this.bufOffset);
                AudioPlayerImpl.this.playerBuffer.compact();
            } else {
                this.bufOffset = bArr2.length;
                AudioPlayerImpl.this.playerBuffer.get(this.mAudioBuffer, 0, this.bufOffset);
                AudioPlayerImpl.this.playerBuffer.compact();
            }
            AudioPlayerImpl.this.buffLock.unlock();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            ReentrantLock reentrantLock;
            try {
                if (AudioPlayerImpl.this.mAudioFocus) {
                    FuncAdapter.Lock(AudioPlayerImpl.this.audioManager, Boolean.valueOf(AudioPlayerImpl.this.requestFocus), AudioPlayerImpl.this.afChangeListener);
                } else {
                    FuncAdapter.Lock(AudioPlayerImpl.this.audioManager, Boolean.valueOf(AudioPlayerImpl.this.requestFocus), null);
                }
                Log.i("AudioPlayer", "start player");
                AudioPlayerImpl.this.readOffset = 0;
                synchronized (AudioPlayerImpl.this.mSyncObj) {
                    if (AudioPlayerImpl.this.playState != 4 && AudioPlayerImpl.this.playState != 3) {
                        AudioPlayerImpl.this.playState = 2;
                    }
                }
                while (!AudioPlayerImpl.this.isExit.get()) {
                    int i = AudioPlayerImpl.this.playState;
                    if (i == 1 || i == 2) {
                        if (AudioPlayerImpl.this.audioTrack != null) {
                            if (AudioPlayerImpl.this.playAble()) {
                                AudioPlayerImpl.this.setState(1, 2);
                                if (AudioPlayerImpl.this.playerListener != null) {
                                    AudioPlayerImpl.this.playerListener.onEvent(EventType.PLAYING, "");
                                }
                                if (AudioPlayerImpl.this.audioTrack.getState() != 3) {
                                    AudioPlayerImpl.this.audioTrack.play();
                                }
                                if (AudioPlayerImpl.this.mFading) {
                                    AudioPlayerImpl.this.fading();
                                }
                                readAudio(AudioPlayerImpl.this.minBufferSize);
                                if (this.mAudioBuffer != null) {
                                    AudioPlayerImpl.this.audioTrack.write(this.mAudioBuffer, 0, this.bufOffset);
                                }
                            } else if (AudioPlayerImpl.this.isOver()) {
                                try {
                                    int playbackHeadPosition = AudioPlayerImpl.this.audioTrack.getPlaybackHeadPosition();
                                    int i2 = (int) (AudioPlayerImpl.this.totalSize / 2);
                                    if (i2 > playbackHeadPosition && AudioPlayerImpl.this.mEndLock.tryLock()) {
                                        AudioPlayerImpl.this.audioTrack.setNotificationMarkerPosition(i2);
                                        AudioPlayerImpl.this.audioTrack.setPlaybackPositionUpdateListener(new AudioTrack.OnPlaybackPositionUpdateListener() { // from class: com.iflytek.aikit.plugin.player.AudioPlayerImpl.PlayerThread.1
                                            @Override // android.media.AudioTrack.OnPlaybackPositionUpdateListener
                                            public void onMarkerReached(AudioTrack audioTrack) {
                                                AudioPlayerImpl.this.mEndLock.lock();
                                                try {
                                                    try {
                                                        AudioPlayerImpl.this.mEndCondition.signalAll();
                                                    } catch (Exception e) {
                                                        e.printStackTrace();
                                                    }
                                                } finally {
                                                    AudioPlayerImpl.this.mEndLock.unlock();
                                                }
                                            }

                                            @Override // android.media.AudioTrack.OnPlaybackPositionUpdateListener
                                            public void onPeriodicNotification(AudioTrack audioTrack) {
                                            }
                                        });
                                        try {
                                            try {
                                                AudioPlayerImpl.this.mEndCondition.await(1000L, TimeUnit.MILLISECONDS);
                                                reentrantLock = AudioPlayerImpl.this.mEndLock;
                                            } catch (Throwable th) {
                                                AudioPlayerImpl.this.mEndLock.unlock();
                                                throw th;
                                            }
                                        } catch (InterruptedException e) {
                                            Log.i("AudioPlayer", "player interrupted");
                                            e.printStackTrace();
                                            reentrantLock = AudioPlayerImpl.this.mEndLock;
                                        }
                                        reentrantLock.unlock();
                                    }
                                    synchronized (AudioPlayerImpl.this.mSyncObj) {
                                        Log.i("AudioPlayer", "play isOver stop:$playState");
                                        if (AudioPlayerImpl.this.playState != 4) {
                                            AudioPlayerImpl.this.stop();
                                            AudioPlayerImpl.this.audioTrack.stop();
                                            if (AudioPlayerImpl.this.playerListener != null) {
                                                AudioPlayerImpl.this.playerListener.onEvent(EventType.COMPLETED, "");
                                            }
                                        }
                                    }
                                } catch (Exception e2) {
                                    Log.d("AudioPlayer", e2.getMessage() + " ");
                                }
                            } else {
                                if (AudioPlayerImpl.this.setState(2, 1)) {
                                    Log.i("AudioPlayer", "play onPaused!");
                                    if (AudioPlayerImpl.this.playerListener != null) {
                                        AudioPlayerImpl.this.playerListener.onEvent(EventType.PAUSED, "");
                                    }
                                }
                                Thread.sleep(5L);
                            }
                        }
                    } else if (i != 3) {
                        if (i == 4) {
                            AudioPlayerImpl.this.setSilence();
                        }
                    } else if (AudioPlayerImpl.this.audioTrack != null) {
                        if (2 != AudioPlayerImpl.this.audioTrack.getState()) {
                            AudioPlayerImpl.this.audioTrack.pause();
                            if (AudioPlayerImpl.this.playerListener != null) {
                                AudioPlayerImpl.this.playerListener.onEvent(EventType.PAUSED, "");
                            }
                            if (AudioPlayerImpl.this.mFading) {
                                AudioPlayerImpl.this.setSilence();
                            }
                        }
                        Thread.sleep(5L);
                    }
                }
            } catch (Exception e3) {
                Log.e("AudioPlayer", "PlayerThread error: " + e3.getMessage());
                e3.printStackTrace();
            }
            synchronized (AudioPlayerImpl.this.mSyncObj) {
                AudioPlayerImpl.this.playState = 4;
            }
            if (AudioPlayerImpl.this.audioTrack != null) {
                AudioPlayerImpl.this.audioTrack.release();
                AudioPlayerImpl.this.audioTrack = null;
            }
            if (AudioPlayerImpl.this.mAudioFocus) {
                FuncAdapter.UnLock(AudioPlayerImpl.this.audioManager, Boolean.valueOf(AudioPlayerImpl.this.requestFocus), AudioPlayerImpl.this.afChangeListener);
            } else {
                FuncAdapter.UnLock(AudioPlayerImpl.this.audioManager, Boolean.valueOf(AudioPlayerImpl.this.requestFocus), null);
            }
            AudioPlayerImpl.this.playThread = null;
            Log.i("AudioPlayer", "player stopped");
        }
    }

    public AudioPlayerImpl(Context context) {
        this.TAG = "AudioPlayer";
        this.mSampleRate = RateType.RATE24K.getValue();
        this.mPcmEncoding = PcmEncoding.ENCODING_PCM_16BIT.getValue();
        this.mChannelConfig = ChannelConfig.ChannelDefault.getValue();
        this.mStreamType = StreamType.STREAM_MUSIC.getValue();
        this.mBufferCapital = 10;
        this.INIT = 0;
        this.BUFFERING = 1;
        this.PLAYING = 2;
        this.PAUSED = 3;
        this.STOPPED = 4;
        this.MIN_SLEEP = 5L;
        this.MAX_VOL = 1.0f;
        this.MIN_VOL = 0.0f;
        this.FADE_TIME = 500;
        this.FADE_PERIOD = 50;
        this.mPerPlaySize = 1600;
        this.PER = 0.1f;
        this.mFadingSize = 1600 * 10;
        this.mCurFadingPeriod = 0.1f;
        this.mCurVol = 0.0f;
        this.mTargetVol = 1.0f;
        this.mFadingEnable = false;
        this.mFading = true;
        this.playState = 0;
        this.mSyncObj = this;
        this.minBufferSize = 0;
        this.mBufferSize = MemoryStatus.MIN_SPACE;
        this.audioTrack = null;
        ReentrantLock reentrantLock = new ReentrantLock();
        this.mEndLock = reentrantLock;
        this.mEndCondition = reentrantLock.newCondition();
        this.isExit = new AtomicBoolean(true);
        this.requestFocus = false;
        this.mAudioFocus = true;
        this.changeListenerFlag = false;
        this.playerListener = null;
        this.readOffset = 0;
        this.playPercent = 0L;
        this.totalSize = 0L;
        this.buffLock = new ReentrantLock();
        this.playThread = null;
        this.afChangeListener = new AudioManager.OnAudioFocusChangeListener() { // from class: com.iflytek.aikit.plugin.player.AudioPlayerImpl.2
            @Override // android.media.AudioManager.OnAudioFocusChangeListener
            public void onAudioFocusChange(int i) {
                Log.d("AudioPlayer", "focusChange： " + i);
                if (i == -2 || i == -3 || i == -1) {
                    Log.i("AudioPlayer", "Listener pause start");
                    if (AudioPlayerImpl.this.pause()) {
                        Log.i("AudioPlayer", "Listener pause success");
                        AudioPlayerImpl.this.changeListenerFlag = true;
                        if (AudioPlayerImpl.this.playerListener != null) {
                            AudioPlayerImpl.this.playerListener.onEvent(EventType.PAUSED, "");
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (i == 1) {
                    Log.i("AudioPlayer", "Listener resume start");
                    if (AudioPlayerImpl.this.changeListenerFlag) {
                        AudioPlayerImpl.this.changeListenerFlag = false;
                        if (AudioPlayerImpl.this.resume()) {
                            Log.i("AudioPlayer", "resume success");
                            if (AudioPlayerImpl.this.playerListener != null) {
                                AudioPlayerImpl.this.playerListener.onEvent(EventType.RESUMED, "");
                            }
                        }
                    }
                }
            }
        };
        this.currentIndex = 0;
        if (context != null) {
            this.mContext = context;
        }
    }

    @SuppressLint({"WrongConstant"})
    private void initAudioTrack() {
        int minBufferSize = AudioTrack.getMinBufferSize(this.mSampleRate, this.mChannelConfig, this.mPcmEncoding);
        this.minBufferSize = minBufferSize;
        this.mBufferSize = minBufferSize * this.mBufferCapital * 600;
        initBuffer();
        AudioTrack audioTrackBuild = new AudioTrack.Builder().setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(2).setLegacyStreamType(3).build()).setAudioFormat(new AudioFormat.Builder().setSampleRate(this.mSampleRate).setChannelMask(this.mChannelConfig).setEncoding(this.mPcmEncoding).build()).setTransferMode(1).setBufferSizeInBytes(this.minBufferSize * this.mBufferCapital).build();
        this.audioTrack = audioTrackBuild;
        audioTrackBuild.setPositionNotificationPeriod(5);
        this.audioTrack.setPlaybackPositionUpdateListener(new AudioTrack.OnPlaybackPositionUpdateListener() { // from class: com.iflytek.aikit.plugin.player.AudioPlayerImpl.1
            @Override // android.media.AudioTrack.OnPlaybackPositionUpdateListener
            public void onMarkerReached(AudioTrack audioTrack) {
            }

            @Override // android.media.AudioTrack.OnPlaybackPositionUpdateListener
            public void onPeriodicNotification(AudioTrack audioTrack) {
                if (AudioPlayerImpl.this.playState == 4 || AudioPlayerImpl.this.audioTrack == null) {
                    return;
                }
                synchronized (AudioPlayerImpl.this.mSyncObj) {
                    float playbackHeadPosition = AudioPlayerImpl.this.audioTrack.getPlaybackHeadPosition();
                    if (AudioPlayerImpl.this.playerListener != null) {
                        AudioPlayerImpl.this.getCurrentTextIndex(playbackHeadPosition);
                    }
                }
            }
        });
    }

    private void initBuffer() {
        this.playerBuffer = this.audioBuffer.getPlayBuffer(this.mBufferSize);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isOver() {
        return !this.playerBuffer.hasRemaining() || this.playerBuffer.position() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean playAble() {
        return this.playerBuffer.hasRemaining() && this.playerBuffer.position() != 0;
    }

    private void resetAudio() {
        this.isExit.set(true);
        this.totalSize = 0L;
        this.currentIndex = 0;
        this.audioBuffer.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean setState(int i, int i2) {
        boolean z;
        synchronized (this.mSyncObj) {
            if (i == this.playState) {
                this.playState = i2;
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public void fading() {
        if (!this.mFadingEnable) {
            this.mFading = false;
            return;
        }
        synchronized (this.mSyncObj) {
            if (Math.abs(this.mTargetVol - this.mCurVol) < 0.1f) {
                this.mCurVol = this.mTargetVol;
                this.mFading = false;
                Log.d("AudioPlayer", "fading finish");
            } else {
                this.mCurVol += this.mCurFadingPeriod;
            }
        }
        AudioTrack audioTrack = this.audioTrack;
        float f = this.mCurVol;
        audioTrack.setStereoVolume(f, f);
    }

    public void finalize() throws Throwable {
        AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener;
        super.finalize();
        this.mContext = null;
        AudioManager audioManager = this.audioManager;
        if (audioManager != null && (onAudioFocusChangeListener = this.afChangeListener) != null) {
            audioManager.abandonAudioFocus(onAudioFocusChangeListener);
        }
        release();
        this.playerListener = null;
    }

    public boolean getArriveMin() {
        return this.totalSize - ((long) (this.minBufferSize * this.mBufferCapital)) > 0;
    }

    public void getCurrentTextIndex(float f) {
        if (this.playState != 4 && this.currentIndex < this.audioBuffer.getAudioInfoList().size()) {
            AudioBuffer.AudioInfo audioInfo = this.audioBuffer.getAudioInfoList().get(this.currentIndex);
            if (f * 2.0f >= audioInfo.beginOffset) {
                this.playerListener.onPlayTextProcess(audioInfo.beginIndex, audioInfo.endIndex);
                this.currentIndex++;
            }
        }
    }

    public int getMinBufferSize() {
        return this.minBufferSize;
    }

    public long getTotalSize() {
        return this.totalSize;
    }

    public void init() {
        this.audioBuffer = new AudioBuffer();
        this.audioManager = (AudioManager) this.mContext.getSystemService("audio");
        initAudioTrack();
    }

    public boolean pause() {
        Log.w("AudioPlayer", "player pause...");
        int i = this.playState;
        if (i == 4 || i == 3) {
            return false;
        }
        try {
            startFadeOut();
            this.playState = 3;
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public boolean play() {
        Log.i("AudioPlayer", "play playState= $playState");
        synchronized (this.mSyncObj) {
            int i = this.playState;
            if (i != 4 && i != 0 && i != 3 && this.playThread != null) {
                return false;
            }
            if (this.playThread == null) {
                this.playThread = new PlayerThread();
            }
            if (this.audioTrack == null) {
                initAudioTrack();
            }
            this.playState = 0;
            this.isExit.set(false);
            this.playThread.start();
            return true;
        }
    }

    public void prepareAudio() {
        Log.i("AudioPlayer", "prepareAudio: ======> ");
        AudioTrack audioTrack = this.audioTrack;
        if (audioTrack == null) {
            return;
        }
        if (audioTrack.getState() == 0) {
            initAudioTrack();
        }
        AudioTrack audioTrack2 = this.audioTrack;
        if (audioTrack2 != null) {
            audioTrack2.play();
        }
    }

    public void release() {
        Log.w("AudioPlayer", "player release...");
        stop();
        try {
            AudioTrack audioTrack = this.audioTrack;
            if (audioTrack != null && audioTrack.getState() == 1) {
                this.audioTrack.release();
                this.audioTrack = null;
            }
            this.mContext = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean resume() {
        Log.w("AudioPlayer", "player resume.");
        if (this.audioTrack == null) {
            return false;
        }
        boolean state = setState(3, 2);
        FuncAdapter.Lock(this.audioManager, Boolean.valueOf(this.requestFocus), this.afChangeListener);
        if (!state) {
            return state;
        }
        try {
            Log.i("AudioPlayer", "resume start fade in");
            this.audioTrack.play();
            startFadeIn();
            return state;
        } catch (Exception e) {
            e.printStackTrace();
            return state;
        }
    }

    public void setBufferSize(int i) {
        this.mBufferSize = i;
    }

    public void setFadingEnable(boolean z) {
        this.mFadingEnable = z;
    }

    public void setFocus(boolean z) {
        this.requestFocus = z;
    }

    public void setPlayerListener(PlayerCallBack playerCallBack) {
        this.playerListener = playerCallBack;
    }

    public void setSilence() {
        Log.d("AudioPlayer", "fading set silence");
        synchronized (this.mSyncObj) {
            if (Math.abs(0.0f - this.mTargetVol) < 0.1f) {
                this.mCurVol = 0.0f;
                this.mFading = false;
            }
        }
        AudioTrack audioTrack = this.audioTrack;
        if (audioTrack != null) {
            float f = this.mCurVol;
            audioTrack.setStereoVolume(f, f);
        }
    }

    public void setStreamType(StreamType streamType) {
        this.mStreamType = streamType.getValue();
    }

    public void startFadeIn() {
        if (this.mFadingEnable) {
            synchronized (this.mSyncObj) {
                Log.d("AudioPlayer", "start fade in");
                this.mFading = true;
                this.mTargetVol = 1.0f;
                this.mCurFadingPeriod = 0.1f;
            }
        }
    }

    public void startFadeOut() {
        if (this.mFadingEnable) {
            synchronized (this.mSyncObj) {
                Log.d("AudioPlayer", "start fade out");
                this.mFading = true;
                this.mTargetVol = 0.0f;
                this.mCurFadingPeriod = -0.1f;
            }
        }
    }

    public void stop() {
        if (this.playState != 4) {
            startFadeOut();
        }
        Log.w("AudioPlayer", "player stop...");
        try {
            synchronized (this.mSyncObj) {
                this.playState = 4;
                resetAudio();
                setSilence();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeBuffer(byte[] bArr) {
        this.buffLock.lock();
        if (this.playerBuffer.position() + bArr.length <= this.playerBuffer.capacity()) {
            this.playerBuffer.put(bArr);
            this.totalSize += (long) bArr.length;
        }
        this.buffLock.unlock();
    }

    public void writeBuffer(byte[] bArr, long j, long j2) {
        this.buffLock.lock();
        if (this.playerBuffer.position() + bArr.length <= this.playerBuffer.capacity()) {
            this.audioBuffer.addInfo(new AudioBuffer.AudioInfo(j, j2, this.totalSize, this.totalSize + ((long) bArr.length)));
            this.playerBuffer.put(bArr);
            this.totalSize += (long) bArr.length;
        }
        this.buffLock.unlock();
    }

    public AudioPlayerImpl(RateType rateType, PcmEncoding pcmEncoding, ChannelConfig channelConfig, Context context) {
        this.TAG = "AudioPlayer";
        this.mSampleRate = RateType.RATE24K.getValue();
        this.mPcmEncoding = PcmEncoding.ENCODING_PCM_16BIT.getValue();
        this.mChannelConfig = ChannelConfig.ChannelDefault.getValue();
        this.mStreamType = StreamType.STREAM_MUSIC.getValue();
        this.mBufferCapital = 10;
        this.INIT = 0;
        this.BUFFERING = 1;
        this.PLAYING = 2;
        this.PAUSED = 3;
        this.STOPPED = 4;
        this.MIN_SLEEP = 5L;
        this.MAX_VOL = 1.0f;
        this.MIN_VOL = 0.0f;
        this.FADE_TIME = 500;
        this.FADE_PERIOD = 50;
        this.mPerPlaySize = 1600;
        this.PER = 0.1f;
        this.mFadingSize = 1600 * 10;
        this.mCurFadingPeriod = 0.1f;
        this.mCurVol = 0.0f;
        this.mTargetVol = 1.0f;
        this.mFadingEnable = false;
        this.mFading = true;
        this.playState = 0;
        this.mSyncObj = this;
        this.minBufferSize = 0;
        this.mBufferSize = MemoryStatus.MIN_SPACE;
        this.audioTrack = null;
        ReentrantLock reentrantLock = new ReentrantLock();
        this.mEndLock = reentrantLock;
        this.mEndCondition = reentrantLock.newCondition();
        this.isExit = new AtomicBoolean(true);
        this.requestFocus = false;
        this.mAudioFocus = true;
        this.changeListenerFlag = false;
        this.playerListener = null;
        this.readOffset = 0;
        this.playPercent = 0L;
        this.totalSize = 0L;
        this.buffLock = new ReentrantLock();
        this.playThread = null;
        this.afChangeListener = new AudioManager.OnAudioFocusChangeListener() { // from class: com.iflytek.aikit.plugin.player.AudioPlayerImpl.2
            @Override // android.media.AudioManager.OnAudioFocusChangeListener
            public void onAudioFocusChange(int i) {
                Log.d("AudioPlayer", "focusChange： " + i);
                if (i == -2 || i == -3 || i == -1) {
                    Log.i("AudioPlayer", "Listener pause start");
                    if (AudioPlayerImpl.this.pause()) {
                        Log.i("AudioPlayer", "Listener pause success");
                        AudioPlayerImpl.this.changeListenerFlag = true;
                        if (AudioPlayerImpl.this.playerListener != null) {
                            AudioPlayerImpl.this.playerListener.onEvent(EventType.PAUSED, "");
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (i == 1) {
                    Log.i("AudioPlayer", "Listener resume start");
                    if (AudioPlayerImpl.this.changeListenerFlag) {
                        AudioPlayerImpl.this.changeListenerFlag = false;
                        if (AudioPlayerImpl.this.resume()) {
                            Log.i("AudioPlayer", "resume success");
                            if (AudioPlayerImpl.this.playerListener != null) {
                                AudioPlayerImpl.this.playerListener.onEvent(EventType.RESUMED, "");
                            }
                        }
                    }
                }
            }
        };
        this.currentIndex = 0;
        if (context != null) {
            this.mContext = context;
        }
        this.mSampleRate = rateType.getValue();
        this.mPcmEncoding = pcmEncoding.getValue();
        this.mChannelConfig = channelConfig.getValue();
    }
}
