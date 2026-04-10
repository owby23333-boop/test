package com.iflytek.aikit.media.player;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.iflytek.aikit.core.media.player.PcmPlayer;
import com.iflytek.aikit.media.record.PcmBuffer;
import com.iflytek.aikit.media.speech.SpeechError;
import com.iflytek.aikit.utils.FuncAdapter;
import com.iflytek.aikit.utils.log.LogUtil;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes7.dex */
public class PcmPlayer implements MediaPlayer {
    public static final int BUFFERING = 1;
    public static final int INIT = 0;
    private static final int MIN_SLEEP = 5;
    private static final int MSG_ERROR = 0;
    private static final int MSG_PAUSE = 1;
    private static final int MSG_PERCENT = 3;
    private static final int MSG_RESUME = 2;
    private static final int MSG_STOPED = 4;
    public static final int PAUSED = 3;
    public static final int PLAYING = 2;
    public static final int STOPED = 4;
    private static final String TAG = "PcmPlayer";
    private final int BYTES_OF_PER_SAMPLE;
    private final int FADE_PERIOD;
    private final int FADE_TIME;
    private final float MAX_VOL;
    private final float MIN_VOL;
    private final float PER;
    AudioManager.OnAudioFocusChangeListener afChangeListener;
    private AtomicBoolean isExist;

    /* JADX INFO: renamed from: listener, reason: collision with root package name */
    private PlayerListener f7019listener;
    private boolean mAudioFocus;
    private Object mAudioLock;
    private AudioTrack mAudioTrack;
    private PcmBuffer mBuffer;
    private int mBufferSize;
    private boolean mBufferingFadingEnable;
    private boolean mChangeListenerFlag;
    private Context mContext;
    private int mCurEndPos;
    private float mCurFadingPeriod;
    private float mCurVol;
    Condition mEndCondition;
    ReentrantLock mEndLock;
    private boolean mFading;
    private boolean mFadingEnable;
    private int mFadingSize;
    private int mPerPlaySize;
    private volatile int mPlaytate;
    private boolean mRequestFocus;
    private int mStreamType;
    private Object mSyncObj;
    private float mTargetVol;
    private PcmThread mThread;
    private Handler mUihandler;

    public class PcmThread extends Thread {
        private int mCurrentStreamType;

        private PcmThread() {
            this.mCurrentStreamType = PcmPlayer.this.mStreamType;
        }

        public int getSreamType() {
            return this.mCurrentStreamType;
        }

        /* JADX WARN: Removed duplicated region for block: B:137:0x038f  */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                Method dump skipped, instruction units count: 1072
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iflytek.aikit.media.player.PcmPlayer.PcmThread.run():void");
        }

        public void setStreamType(int i) {
            this.mCurrentStreamType = i;
        }
    }

    public PcmPlayer(Context context, int i, boolean z, boolean z2, boolean z3) {
        this.mAudioTrack = null;
        this.mBuffer = null;
        this.mContext = null;
        this.mThread = null;
        this.f7019listener = null;
        this.mPlaytate = 0;
        this.mAudioFocus = true;
        this.mStreamType = 3;
        this.mRequestFocus = false;
        this.mChangeListenerFlag = false;
        this.mAudioLock = new Object();
        this.mSyncObj = this;
        this.BYTES_OF_PER_SAMPLE = 2;
        this.FADE_TIME = 500;
        this.FADE_PERIOD = 50;
        this.mPerPlaySize = 1600;
        this.MAX_VOL = 1.0f;
        this.MIN_VOL = 0.0f;
        this.PER = 0.1f;
        this.mFadingSize = 1600 * 10;
        this.mCurVol = 0.0f;
        this.mTargetVol = 1.0f;
        this.mCurFadingPeriod = 0.1f;
        this.mFading = false;
        this.isExist = new AtomicBoolean(true);
        this.mBufferingFadingEnable = false;
        this.mFadingEnable = false;
        ReentrantLock reentrantLock = new ReentrantLock();
        this.mEndLock = reentrantLock;
        this.mEndCondition = reentrantLock.newCondition();
        this.afChangeListener = new AudioManager.OnAudioFocusChangeListener() { // from class: com.iflytek.aikit.media.player.PcmPlayer.1
            @Override // android.media.AudioManager.OnAudioFocusChangeListener
            public void onAudioFocusChange(int i2) {
                if (i2 == -2 || i2 == -3 || i2 == -1) {
                    LogUtil.d(PcmPlayer.TAG, "pause start");
                    if (PcmPlayer.this.pause()) {
                        LogUtil.d(PcmPlayer.TAG, "pause success");
                        PcmPlayer.this.mChangeListenerFlag = true;
                        PcmPlayer.this.onPause();
                        return;
                    }
                    return;
                }
                if (i2 == 1) {
                    LogUtil.d(PcmPlayer.TAG, "resume start");
                    if (PcmPlayer.this.mChangeListenerFlag) {
                        PcmPlayer.this.mChangeListenerFlag = false;
                        if (PcmPlayer.this.resume()) {
                            LogUtil.d(PcmPlayer.TAG, "resume success");
                            PcmPlayer.this.onResume();
                        }
                    }
                }
            }
        };
        this.mCurEndPos = 0;
        this.mUihandler = new Handler(Looper.getMainLooper()) { // from class: com.iflytek.aikit.media.player.PcmPlayer.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i2 = message.what;
                if (i2 == 0) {
                    PcmPlayer.this.onError((SpeechError) message.obj);
                    return;
                }
                if (i2 == 1) {
                    PcmPlayer.this.onPause();
                    return;
                }
                if (i2 == 2) {
                    PcmPlayer.this.onResume();
                } else if (i2 == 3) {
                    PcmPlayer.this.onPercent(message.arg1, message.arg2);
                } else {
                    if (i2 != 4) {
                        return;
                    }
                    PcmPlayer.this.onStop();
                }
            }
        };
        this.mContext = context;
        this.mStreamType = i;
        this.mRequestFocus = z;
        this.mFadingEnable = z2;
        this.mBufferingFadingEnable = z3;
    }

    private void createAudio() throws Exception {
        LogUtil.d(TAG, "createAudio start");
        int rate = this.mBuffer.getRate();
        this.mBufferSize = AudioTrack.getMinBufferSize(rate, 2, 2);
        int i = (rate / 1000) * 2 * 50;
        this.mPerPlaySize = i;
        this.mFadingSize = i * 10;
        if (this.mAudioTrack != null) {
            release();
        }
        LogUtil.d(TAG, "createAudio || mStreamType = " + this.mStreamType + ", buffer size: " + this.mBufferSize);
        this.mAudioTrack = new AudioTrack(this.mStreamType, rate, 2, 2, this.mBufferSize * 2, 1);
        this.mBuffer.setAudioTrackBuffSize(this.mBufferSize * 2);
        int i2 = this.mBufferSize;
        if (i2 == -2 || i2 == -1) {
            throw new Exception();
        }
        LogUtil.d(TAG, "createAudio end");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(SpeechError speechError) {
        PlayerListener playerListener = this.f7019listener;
        if (playerListener != null) {
            playerListener.onError(speechError);
            this.f7019listener = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPause() {
        PlayerListener playerListener = this.f7019listener;
        if (playerListener != null) {
            playerListener.onPause();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPercent(int i, int i2) {
        if (this.f7019listener == null || this.mPlaytate == 4) {
            return;
        }
        this.f7019listener.onPercent(i, i2, this.mCurEndPos);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onResume() {
        PlayerListener playerListener = this.f7019listener;
        if (playerListener != null) {
            playerListener.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStop() {
        PlayerListener playerListener = this.f7019listener;
        if (playerListener != null) {
            playerListener.onStop();
            this.f7019listener = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void prepAudioPlayer() throws Exception {
        PcmThread pcmThread = this.mThread;
        if (this.mAudioTrack == null || !(pcmThread == null || pcmThread.getSreamType() == this.mStreamType)) {
            LogUtil.d(TAG, "prepAudioPlayer || audiotrack is null or stream type is change.");
            createAudio();
            if (pcmThread != null) {
                pcmThread.setStreamType(this.mStreamType);
            }
        }
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
                LogUtil.d("fading finish");
            } else {
                this.mCurVol += this.mCurFadingPeriod;
            }
        }
        AudioTrack audioTrack = this.mAudioTrack;
        float f = this.mCurVol;
        audioTrack.setStereoVolume(f, f);
    }

    public int getState() {
        return this.mPlaytate;
    }

    @Override // com.iflytek.aikit.media.player.MediaPlayer
    public boolean pause() {
        if (this.mPlaytate == 4 || this.mPlaytate == 3) {
            return false;
        }
        LogUtil.d("pause start fade out");
        startFadeOut();
        this.mPlaytate = 3;
        return true;
    }

    public boolean play(PcmBuffer pcmBuffer) {
        boolean z;
        LogUtil.d(TAG, "play mPlaytate= " + this.mPlaytate + ",mAudioFocus= " + this.mAudioFocus);
        synchronized (this.mSyncObj) {
            z = false;
            if (this.mPlaytate == 4 || this.mPlaytate == 0 || this.mPlaytate == 3 || this.mThread == null) {
                if (this.mThread == null) {
                    this.mThread = new PcmThread();
                    this.mPlaytate = 0;
                }
                this.mBuffer = pcmBuffer;
                this.isExist.set(false);
                this.mThread.start();
                z = true;
            }
        }
        return z;
    }

    public boolean rePlay(PcmBuffer pcmBuffer) {
        setState(0);
        return play(pcmBuffer);
    }

    public boolean reSetStatus() {
        setState(0);
        return true;
    }

    public void release() {
        synchronized (this.mAudioLock) {
            AudioTrack audioTrack = this.mAudioTrack;
            if (audioTrack != null) {
                if (audioTrack.getPlayState() == 3) {
                    this.mAudioTrack.stop();
                }
                this.mAudioTrack.release();
                this.mAudioTrack = null;
            }
            LogUtil.d(TAG, "mAudioTrack released");
        }
    }

    @Override // com.iflytek.aikit.media.player.MediaPlayer
    public boolean resume() {
        boolean state = setState(3, 2);
        FuncAdapter.Lock(this.mContext, Boolean.valueOf(this.mRequestFocus), this.afChangeListener);
        if (state) {
            LogUtil.d("resume start fade in");
            Message.obtain(this.mUihandler, 2).sendToTarget();
            startFadeIn();
        }
        return state;
    }

    public void setAudioFocus(boolean z) {
        LogUtil.d(TAG, "setAudioFocus " + z);
        this.mAudioFocus = z;
    }

    @Override // com.iflytek.aikit.media.player.MediaPlayer
    public void setListener(PlayerListener playerListener) {
        this.f7019listener = playerListener;
    }

    public void setSilence() {
        LogUtil.d("fading set silence");
        synchronized (this.mSyncObj) {
            if (Math.abs(0.0f - this.mTargetVol) < 0.1f) {
                this.mCurVol = 0.0f;
                this.mFading = false;
            }
        }
        AudioTrack audioTrack = this.mAudioTrack;
        float f = this.mCurVol;
        audioTrack.setStereoVolume(f, f);
    }

    public void setState(int i) {
        this.mPlaytate = i;
    }

    public void setStreamType(int i) {
        LogUtil.d(TAG, "setmStreamType || streamType = " + i);
        this.mStreamType = i;
    }

    public void startFadeIn() {
        if (this.mFadingEnable) {
            synchronized (this.mSyncObj) {
                LogUtil.d("start fade in");
                this.mFading = true;
                this.mTargetVol = 1.0f;
                this.mCurFadingPeriod = 0.1f;
            }
        }
    }

    public void startFadeOut() {
        if (this.mFadingEnable) {
            synchronized (this.mSyncObj) {
                LogUtil.d("start fade out");
                this.mFading = true;
                this.mTargetVol = 0.0f;
                this.mCurFadingPeriod = -0.1f;
            }
        }
    }

    @Override // com.iflytek.aikit.media.player.MediaPlayer
    public boolean stop() {
        if (4 != this.mPlaytate) {
            LogUtil.d("stop start fade out");
            startFadeOut();
        }
        synchronized (this.mSyncObj) {
            this.mPlaytate = 4;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean setState(int i, int i2) {
        boolean z;
        synchronized (this.mSyncObj) {
            if (i == this.mPlaytate) {
                this.mPlaytate = i2;
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public void setListener(final PcmPlayer.PcmPlayerListener pcmPlayerListener) {
        setListener(new PlayerListener() { // from class: com.iflytek.aikit.media.player.PcmPlayer.3
            @Override // com.iflytek.aikit.media.player.PlayerListener
            public void onError(SpeechError speechError) {
                pcmPlayerListener.onError((com.iflytek.aikit.core.media.speech.SpeechError) speechError);
            }

            @Override // com.iflytek.aikit.media.player.PlayerListener
            public void onFinish() {
            }

            @Override // com.iflytek.aikit.media.player.PlayerListener
            public void onPause() {
                pcmPlayerListener.onPaused();
            }

            @Override // com.iflytek.aikit.media.player.PlayerListener
            public void onPercent(int i, int i2, int i3) {
                pcmPlayerListener.onPercent(i, i2, i3);
            }

            @Override // com.iflytek.aikit.media.player.PlayerListener
            public void onResume() {
                pcmPlayerListener.onResume();
            }

            @Override // com.iflytek.aikit.media.player.PlayerListener
            public void onStart() {
            }

            @Override // com.iflytek.aikit.media.player.PlayerListener
            public void onStop() {
                pcmPlayerListener.onStoped();
            }
        });
    }

    public PcmPlayer(Context context) {
        this.mAudioTrack = null;
        this.mBuffer = null;
        this.mContext = null;
        this.mThread = null;
        this.f7019listener = null;
        this.mPlaytate = 0;
        this.mAudioFocus = true;
        this.mStreamType = 3;
        this.mRequestFocus = false;
        this.mChangeListenerFlag = false;
        this.mAudioLock = new Object();
        this.mSyncObj = this;
        this.BYTES_OF_PER_SAMPLE = 2;
        this.FADE_TIME = 500;
        this.FADE_PERIOD = 50;
        this.mPerPlaySize = 1600;
        this.MAX_VOL = 1.0f;
        this.MIN_VOL = 0.0f;
        this.PER = 0.1f;
        this.mFadingSize = 1600 * 10;
        this.mCurVol = 0.0f;
        this.mTargetVol = 1.0f;
        this.mCurFadingPeriod = 0.1f;
        this.mFading = false;
        this.isExist = new AtomicBoolean(true);
        this.mBufferingFadingEnable = false;
        this.mFadingEnable = false;
        ReentrantLock reentrantLock = new ReentrantLock();
        this.mEndLock = reentrantLock;
        this.mEndCondition = reentrantLock.newCondition();
        this.afChangeListener = new AudioManager.OnAudioFocusChangeListener() { // from class: com.iflytek.aikit.media.player.PcmPlayer.1
            @Override // android.media.AudioManager.OnAudioFocusChangeListener
            public void onAudioFocusChange(int i2) {
                if (i2 == -2 || i2 == -3 || i2 == -1) {
                    LogUtil.d(PcmPlayer.TAG, "pause start");
                    if (PcmPlayer.this.pause()) {
                        LogUtil.d(PcmPlayer.TAG, "pause success");
                        PcmPlayer.this.mChangeListenerFlag = true;
                        PcmPlayer.this.onPause();
                        return;
                    }
                    return;
                }
                if (i2 == 1) {
                    LogUtil.d(PcmPlayer.TAG, "resume start");
                    if (PcmPlayer.this.mChangeListenerFlag) {
                        PcmPlayer.this.mChangeListenerFlag = false;
                        if (PcmPlayer.this.resume()) {
                            LogUtil.d(PcmPlayer.TAG, "resume success");
                            PcmPlayer.this.onResume();
                        }
                    }
                }
            }
        };
        this.mCurEndPos = 0;
        this.mUihandler = new Handler(Looper.getMainLooper()) { // from class: com.iflytek.aikit.media.player.PcmPlayer.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i2 = message.what;
                if (i2 == 0) {
                    PcmPlayer.this.onError((SpeechError) message.obj);
                    return;
                }
                if (i2 == 1) {
                    PcmPlayer.this.onPause();
                    return;
                }
                if (i2 == 2) {
                    PcmPlayer.this.onResume();
                } else if (i2 == 3) {
                    PcmPlayer.this.onPercent(message.arg1, message.arg2);
                } else {
                    if (i2 != 4) {
                        return;
                    }
                    PcmPlayer.this.onStop();
                }
            }
        };
        this.mContext = context;
    }
}
