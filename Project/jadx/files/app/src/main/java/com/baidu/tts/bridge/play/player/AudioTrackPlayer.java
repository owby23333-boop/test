package com.baidu.tts.bridge.play.player;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.os.Build;
import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.bridge.play.PlayListener;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.enumtype.CommandEnum;
import com.baidu.tts.enumtype.SampleRateEnum;
import com.baidu.tts.iterator.playsubpackage.AudioChunk;
import com.baidu.tts.iterator.playsubpackage.UtteranceSubpackager;
import com.baidu.tts.param.BasePlayerParams;
import com.baidu.tts.param.ResponseBag;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes2.dex */
public class AudioTrackPlayer extends APlayer {
    private static final String TAG = "AudioTrackPlayer";
    private volatile AudioTrack mAudioTrack;
    private int mMaxProgress;
    private AudioTrackPlayerParams mPlayerParams;
    private PlayCache2Tts playCache2Tts;
    private UtteranceSubpackager mUtteranceSubpackager = new UtteranceSubpackager();
    protected final Lock mStateLock = new ReentrantLock();
    protected final Condition mPauseCondition = this.mStateLock.newCondition();
    private boolean isPause = false;

    public static class AudioTrackPlayerParams extends BasePlayerParams<AudioTrackPlayerParams> {
        private static final long serialVersionUID = 8169297001897771181L;
        private int mSampleRate = SampleRateEnum.HZ16K.getHz();
        private int mChannelConfig = 4;
        private int mAudioFormat = 2;
        private int mMode = 1;
        private float mLeftVolume = 1.0f;
        private float mRightVolume = 1.0f;
        private int mUsage = 1;
        private int mContentType = 2;

        public int getAudioFormat() {
            return this.mAudioFormat;
        }

        public int getChannelConfig() {
            return this.mChannelConfig;
        }

        public int getContentType() {
            return this.mContentType;
        }

        public float getLeftVolume() {
            return this.mLeftVolume;
        }

        public int getMode() {
            return this.mMode;
        }

        public float getRightVolume() {
            return this.mRightVolume;
        }

        public int getSampleRate() {
            return this.mSampleRate;
        }

        public int getUsage() {
            return this.mUsage;
        }

        public void setAudioFormat(int i2) {
            this.mAudioFormat = i2;
        }

        public void setChannelConfig(int i2) {
            this.mChannelConfig = i2;
        }

        public void setContentType(int i2) {
            this.mContentType = i2;
        }

        public void setLeftVolume(float f2) {
            this.mLeftVolume = f2;
        }

        public void setMode(int i2) {
            this.mMode = i2;
        }

        public void setRightVolume(float f2) {
            this.mRightVolume = f2;
        }

        public void setSampleRate(int i2) {
            this.mSampleRate = i2;
        }

        public void setUsage(int i2) {
            this.mUsage = i2;
        }
    }

    private int fixProgress(int i2) {
        if (i2 > this.mMaxProgress) {
            this.mMaxProgress = i2;
        }
        return this.mMaxProgress;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int getMinBufferSize(int r5, int r6, int r7) {
        /*
            r4 = this;
            int r5 = android.media.AudioTrack.getMinBufferSize(r5, r6, r7)
            r0 = 2
            int r5 = r5 * 2
            r1 = 3
            r2 = 1
            if (r6 == r2) goto L1d
            if (r6 == r0) goto L1d
            if (r6 == r1) goto L1b
            r3 = 4
            if (r6 == r3) goto L1d
            r3 = 12
            if (r6 == r3) goto L1b
            int r6 = java.lang.Integer.bitCount(r6)
            goto L1e
        L1b:
            r6 = 2
            goto L1e
        L1d:
            r6 = 1
        L1e:
            if (r7 != r1) goto L21
            r0 = 1
        L21:
            int r6 = r6 * r0
            int r6 = r5 % r6
            if (r6 != 0) goto L29
            if (r5 >= r2) goto L2b
        L29:
            r5 = 5120(0x1400, float:7.175E-42)
        L2b:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.tts.bridge.play.player.AudioTrackPlayer.getMinBufferSize(int, int, int):int");
    }

    private int getProgressChunk() {
        return (this.mPlayerParams.getSampleRate() * 2) / this.mPlayerParams.getNotificationCountPerSecond();
    }

    private void oneUtteranceFinish(ResponseBag responseBag) {
        this.mUtteranceSubpackager.end();
        playFinished(responseBag);
    }

    private void oneUtteranceStart(ResponseBag responseBag) {
        this.mUtteranceSubpackager.setProgressChunkSize(getProgressChunk());
        this.mUtteranceSubpackager.start();
        this.mMaxProgress = 0;
        playStart(responseBag);
    }

    private void playFinished(ResponseBag responseBag) {
        PlayListener playListener = this.mPlayListener;
        if (playListener != null) {
            playListener.onPlayFinished(responseBag);
        }
    }

    private void playProgressUpdate(ResponseBag responseBag) {
        PlayListener playListener = this.mPlayListener;
        if (playListener != null) {
            playListener.onPlayProgressUpdate(responseBag);
        }
    }

    private void playStart(ResponseBag responseBag) {
        PlayListener playListener = this.mPlayListener;
        if (playListener != null) {
            playListener.onPlayStart(responseBag);
        }
    }

    private void signalAll() {
        try {
            try {
                this.mStateLock.lock();
                this.mPauseCondition.signalAll();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } finally {
            this.mStateLock.unlock();
        }
    }

    @Override // com.baidu.tts.bridge.play.player.APlayer, com.baidu.tts.bridge.play.player.IPlayer
    public TtsError initial() {
        int sampleRate = this.mPlayerParams.getSampleRate();
        int channelConfig = this.mPlayerParams.getChannelConfig();
        int audioFormat = this.mPlayerParams.getAudioFormat();
        int streamType = this.mPlayerParams.getStreamType();
        int mode = this.mPlayerParams.getMode();
        int usage = this.mPlayerParams.getUsage();
        int contentType = this.mPlayerParams.getContentType();
        int minBufferSize = getMinBufferSize(sampleRate, channelConfig, audioFormat);
        if (Build.VERSION.SDK_INT >= 21) {
            this.mAudioTrack = new AudioTrack(new AudioAttributes.Builder().setUsage(usage).setContentType(contentType).build(), new AudioFormat.Builder().setSampleRate(sampleRate).setEncoding(audioFormat).setChannelMask(channelConfig).build(), minBufferSize, mode, 0);
        } else {
            this.mAudioTrack = new AudioTrack(streamType, sampleRate, channelConfig, audioFormat, minBufferSize, mode);
        }
        this.mAudioTrack.setStereoVolume(this.mPlayerParams.getLeftVolume(), this.mPlayerParams.getRightVolume());
        return null;
    }

    @Override // com.baidu.tts.bridge.play.player.APlayer, com.baidu.tts.bridge.play.player.IPlayer
    public void pause() {
        try {
            this.isPause = true;
            if (this.mAudioTrack != null) {
                this.mAudioTrack.pause();
            }
            if (this.playCache2Tts != null) {
                this.playCache2Tts.close();
                this.playCache2Tts = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.baidu.tts.bridge.play.player.APlayer, com.baidu.tts.bridge.play.player.IPlayer
    public void play() {
        try {
            if (this.mAudioTrack != null) {
                this.mAudioTrack.play();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.baidu.tts.bridge.play.player.APlayer, com.baidu.tts.bridge.play.player.IPlayer
    public TtsError put(ResponseBag responseBag) {
        Lock lock;
        synchronized (this.mAudioTrack) {
            LoggerProxy.d(TAG, "enter put");
            if (responseBag != null) {
                CommandEnum commandEnum = responseBag.getCommandEnum();
                if (commandEnum == CommandEnum.SYN_START) {
                    this.mAudioTrack.setPositionNotificationPeriod(0);
                    oneUtteranceStart(responseBag);
                }
                if (commandEnum == CommandEnum.SYN_DATA) {
                    int hz = responseBag.getSampleRate().getHz();
                    if (hz != this.mAudioTrack.getSampleRate()) {
                        setAudioSampleRate(hz);
                    }
                    this.mUtteranceSubpackager.setmProgress(responseBag.getProgress());
                }
                byte[] audioData = responseBag.getAudioData();
                if (audioData != null) {
                    this.mUtteranceSubpackager.append(audioData.length);
                }
                while (this.mUtteranceSubpackager.hasNext()) {
                    AudioChunk next = this.mUtteranceSubpackager.next();
                    int startIndex = next.getStartIndex();
                    int length = next.getLength();
                    int i2 = 0;
                    while (i2 < length && this.mAudioTrack.getPlayState() != 1 && audioData != null) {
                        int i3 = length - i2;
                        LoggerProxy.d(TAG, "before write");
                        int i4 = i2 + startIndex;
                        if (PlayCache2Tts.getEnableAecPlay()) {
                            if (this.playCache2Tts == null) {
                                this.playCache2Tts = new PlayCache2Tts(System.currentTimeMillis());
                            }
                            PlayCache2Tts playCache2Tts = this.playCache2Tts;
                            if (playCache2Tts != null) {
                                playCache2Tts.write(audioData, i4, i3);
                            }
                        }
                        int iWrite = this.mAudioTrack.write(audioData, i4, i3);
                        LoggerProxy.d(TAG, "writtenbytes=" + iWrite + "--offset=" + i2 + "--dataLength=" + length);
                        if (iWrite < 0) {
                            return null;
                        }
                        i2 += iWrite;
                        while (this.isPause) {
                            try {
                                try {
                                    this.mStateLock.lock();
                                    LoggerProxy.d(TAG, "await before" + System.currentTimeMillis());
                                    this.mPauseCondition.await();
                                    LoggerProxy.d(TAG, "await after" + System.currentTimeMillis());
                                    lock = this.mStateLock;
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    lock = this.mStateLock;
                                }
                                lock.unlock();
                            } catch (Throwable th) {
                                this.mStateLock.unlock();
                                throw th;
                            }
                        }
                    }
                    if (this.mAudioTrack.getPlayState() == 1) {
                        return null;
                    }
                    if (next.isUpdateProgress()) {
                        int progress = responseBag.getProgress();
                        float percent = next.getPercent();
                        int iRound = Math.round(progress * percent);
                        int iFixProgress = fixProgress(iRound);
                        LoggerProxy.d(TAG, "percent=" + percent + "--currentProgress=" + iRound + "--progress=" + iFixProgress);
                        ResponseBag responseBagShallowClone = responseBag.shallowClone();
                        responseBagShallowClone.setProgress(iFixProgress);
                        playProgressUpdate(responseBagShallowClone);
                    }
                }
                if (commandEnum == CommandEnum.SYN_FINISH) {
                    int i5 = this.mUtteranceSubpackager.getmProgress();
                    ResponseBag responseBagShallowClone2 = responseBag.shallowClone();
                    responseBagShallowClone2.setProgress(i5);
                    playProgressUpdate(responseBagShallowClone2);
                    oneUtteranceFinish(responseBag);
                }
            } else {
                LoggerProxy.d(TAG, "put responseBag=null");
            }
            LoggerProxy.d(TAG, "end put");
            return null;
        }
    }

    @Override // com.baidu.tts.bridge.play.player.APlayer, com.baidu.tts.bridge.play.player.IPlayer
    public TtsError release() {
        stop();
        try {
            if (this.mAudioTrack != null) {
                this.mAudioTrack.release();
            }
            this.mAudioTrack = null;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return null;
    }

    @Override // com.baidu.tts.bridge.play.player.APlayer, com.baidu.tts.bridge.play.player.IPlayer
    public void resume() {
        try {
            this.isPause = false;
            if (this.mAudioTrack != null) {
                this.mAudioTrack.play();
            }
            signalAll();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.baidu.tts.bridge.play.player.IPlayer
    public int setAudioAttributes(int i2, int i3) {
        LoggerProxy.d(TAG, " setAudioAttributes   mUsage:" + i2 + " mContentType:" + i3);
        if (this.mAudioTrack == null) {
            return -2;
        }
        synchronized (this.mAudioTrack) {
            try {
                try {
                    if (i2 != this.mPlayerParams.getUsage() || i3 != this.mPlayerParams.getContentType()) {
                        int sampleRate = this.mPlayerParams.getSampleRate();
                        int channelConfig = this.mPlayerParams.getChannelConfig();
                        int audioFormat = this.mPlayerParams.getAudioFormat();
                        int mode = this.mPlayerParams.getMode();
                        int minBufferSize = getMinBufferSize(sampleRate, channelConfig, audioFormat);
                        if (Build.VERSION.SDK_INT < 21) {
                            return -1;
                        }
                        if (this.mAudioTrack.getState() == 1) {
                            this.mAudioTrack.release();
                        }
                        this.mAudioTrack = new AudioTrack(new AudioAttributes.Builder().setUsage(i2).setContentType(i3).build(), new AudioFormat.Builder().setSampleRate(sampleRate).setEncoding(audioFormat).setChannelMask(channelConfig).build(), minBufferSize, mode, 0);
                        this.mPlayerParams.setUsage(i2);
                        this.mPlayerParams.setContentType(i3);
                        this.mAudioTrack.setStereoVolume(this.mPlayerParams.getLeftVolume(), this.mPlayerParams.getRightVolume());
                        this.mAudioTrack.play();
                    }
                    return 0;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return -2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.baidu.tts.bridge.play.player.IPlayer
    public int setAudioSampleRate(int i2) {
        try {
            if (this.mAudioTrack == null) {
                return -2;
            }
            LoggerProxy.d(TAG, "sampleRate:" + i2 + " mAudioTrack sampleRate:" + this.mAudioTrack.getSampleRate());
            if (i2 == this.mAudioTrack.getSampleRate()) {
                return 0;
            }
            int streamType = this.mPlayerParams.getStreamType();
            int channelConfig = this.mPlayerParams.getChannelConfig();
            int audioFormat = this.mPlayerParams.getAudioFormat();
            int mode = this.mPlayerParams.getMode();
            int usage = this.mPlayerParams.getUsage();
            int contentType = this.mPlayerParams.getContentType();
            int minBufferSize = getMinBufferSize(i2, channelConfig, audioFormat);
            if (this.mAudioTrack.getState() == 1) {
                this.mAudioTrack.release();
            }
            if (Build.VERSION.SDK_INT >= 21) {
                this.mAudioTrack = new AudioTrack(new AudioAttributes.Builder().setUsage(usage).setContentType(contentType).build(), new AudioFormat.Builder().setSampleRate(i2).setEncoding(audioFormat).setChannelMask(channelConfig).build(), minBufferSize, mode, 0);
            } else {
                this.mAudioTrack = new AudioTrack(streamType, i2, channelConfig, audioFormat, minBufferSize, mode);
            }
            this.mAudioTrack.setStereoVolume(this.mPlayerParams.getLeftVolume(), this.mPlayerParams.getRightVolume());
            this.mAudioTrack.play();
            return 0;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    @Override // com.baidu.tts.bridge.play.player.IPlayer
    public int setAudioStreamType(int i2) {
        LoggerProxy.d(TAG, "setAudioStreamType:" + i2);
        if (this.mAudioTrack != null) {
            return -2;
        }
        synchronized (this.mAudioTrack) {
            try {
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (i2 != this.mPlayerParams.getStreamType()) {
                int sampleRate = this.mPlayerParams.getSampleRate();
                int channelConfig = this.mPlayerParams.getChannelConfig();
                int audioFormat = this.mPlayerParams.getAudioFormat();
                int mode = this.mPlayerParams.getMode();
                int minBufferSize = getMinBufferSize(sampleRate, channelConfig, audioFormat);
                if (this.mAudioTrack.getState() == 1) {
                    this.mAudioTrack.release();
                }
                this.mAudioTrack = new AudioTrack(i2, sampleRate, channelConfig, audioFormat, minBufferSize, mode);
                this.mPlayerParams.setStreamType(i2);
                this.mAudioTrack.setStereoVolume(this.mPlayerParams.getLeftVolume(), this.mPlayerParams.getRightVolume());
                this.mAudioTrack.play();
            }
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tts.bridge.play.player.APlayer, com.baidu.tts.bridge.play.player.IPlayer
    public <AudioTrackPlayerParams> void setParam(AudioTrackPlayerParams audiotrackplayerparams) {
        this.mPlayerParams = (AudioTrackPlayerParams) audiotrackplayerparams;
    }

    @Override // com.baidu.tts.bridge.play.player.APlayer, com.baidu.tts.bridge.play.player.IPlayer
    public void setPlayListener(PlayListener playListener) {
        this.mPlayListener = playListener;
    }

    @Override // com.baidu.tts.bridge.play.player.IPlayer
    public int setStereoVolume(float f2, float f3) {
        int stereoVolume = this.mAudioTrack.setStereoVolume(f2, f3);
        this.mPlayerParams.setLeftVolume(f2);
        this.mPlayerParams.setRightVolume(f3);
        return stereoVolume;
    }

    @Override // com.baidu.tts.bridge.play.player.APlayer, com.baidu.tts.bridge.play.player.IPlayer
    public void stop() {
        try {
            if (this.isPause) {
                this.isPause = false;
                signalAll();
            }
            if (this.mAudioTrack != null) {
                this.mAudioTrack.pause();
                this.mAudioTrack.flush();
                this.mAudioTrack.stop();
            }
            if (this.playCache2Tts != null) {
                this.playCache2Tts.close();
                this.playCache2Tts = null;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
