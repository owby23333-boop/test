package com.iflytek.aikit.media.record;

import android.annotation.SuppressLint;
import android.media.AudioRecord;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.iflytek.aikit.core.media.record.PcmRecorder;
import com.iflytek.aikit.media.RecorderHelper;
import com.iflytek.aikit.media.listener.DecibelListener;
import com.iflytek.aikit.media.speech.SpeechError;
import com.iflytek.aikit.utils.constants.ErrorCode;
import com.yuewen.w51;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes7.dex */
public class PcmRecorder extends Thread {
    public static final int MSG_RELEASE_RECORD = 2;
    public static final int MSG_START_RECORD = 0;
    public static final int MSG_STOP_RECORD = 1;
    public static final int RATE16K = 16000;
    public static final int READ_INTERVAL40MS = 40;
    private static final int RECORD_BUFFER_TIMES_FOR_FRAME = 4;
    private static final String TAG = "PcmRecorder";
    private startFinishListener finishListener;
    private int mAudioSource;
    public Handler mRecordHandle;
    private final short DEFAULT_BIT_SAMPLES = 16;
    private byte[] mDataBuffer = null;
    private AudioRecord mRecorder = null;
    private RecorderListener mOutListener = null;
    private AtomicBoolean exit = new AtomicBoolean(false);
    private double checkDataSum = w51.l;
    private double checkStandDev = w51.l;
    private int mRate = 16000;
    private int mInterval = 40;
    private int mReadInterval = 40;
    private short mChannel = 1;
    private int audioFormat = 2;
    private int mBufferSize = 0;

    @Deprecated
    public static class Builder {
        private DecibelListener decibelListener;
        private int audioSource = 1;
        private int rate = 16000;
        private short channel = 1;
        private int audioFormat = 2;
        private int bufferSize = 0;

        public static Builder build() {
            return new Builder();
        }

        public int getAudioFormat() {
            return this.audioFormat;
        }

        public int getAudioSource() {
            return this.audioSource;
        }

        public int getBufferSize() {
            return this.bufferSize;
        }

        public short getChannel() {
            return this.channel;
        }

        public DecibelListener getDecibelListener() {
            return this.decibelListener;
        }

        public int getRate() {
            return this.rate;
        }

        public Builder setAudioFormat(int i) {
            this.audioFormat = i;
            return this;
        }

        public Builder setAudioSource(int i) {
            this.audioSource = i;
            return this;
        }

        public Builder setBufferSize(int i) {
            this.bufferSize = i;
            return this;
        }

        public Builder setChannel(short s) {
            this.channel = s;
            return this;
        }

        public Builder setDecibelListener(DecibelListener decibelListener) {
            this.decibelListener = decibelListener;
            return this;
        }

        public Builder setRate(int i) {
            this.rate = i;
            return this;
        }
    }

    public interface startFinishListener {
        void onFinish();
    }

    public PcmRecorder(RecorderHelper.Params params, RecorderListener recorderListener) {
        setListener(recorderListener);
        init(params.getSource(), params.getRate(), params.getChannel(), params.getFormat(), params.getSize());
    }

    private int calculateVolume(byte[] bArr) {
        double dAbs = w51.l;
        for (int i = 0; i < bArr.length; i += 2) {
            int i2 = (bArr[i] & 255) + ((bArr[i + 1] & 255) << 8);
            if (i2 >= 32768) {
                i2 = 65535 - i2;
            }
            dAbs += (double) Math.abs(i2);
        }
        return (int) (Math.log10(((dAbs / ((double) bArr.length)) / 2.0d) + 1.0d) * 10.0d);
    }

    private double checkAudio(byte[] bArr, int i) {
        double dPow = w51.l;
        if (bArr == null || i <= 0) {
            return w51.l;
        }
        double d = 0.0d;
        for (byte b2 : bArr) {
            d += (double) b2;
        }
        double length = d / ((double) bArr.length);
        for (byte b3 : bArr) {
            dPow += Math.pow(((double) b3) - length, 2.0d);
        }
        return Math.sqrt(dPow / ((double) (bArr.length - 1)));
    }

    private void init(int i, int i2, short s, int i3, int i4) {
        this.mAudioSource = i;
        this.mRate = i2;
        this.mChannel = s;
        this.audioFormat = i3;
        this.mBufferSize = i4;
        int i5 = this.mInterval;
        if (i5 < 40 || i5 > 100) {
            this.mInterval = 40;
        }
        this.mReadInterval = 10;
        setPriority(10);
        setFinishListener(new startFinishListener() { // from class: com.iflytek.aikit.media.record.PcmRecorder.1
            boolean isInit = false;

            @Override // com.iflytek.aikit.media.record.PcmRecorder.startFinishListener
            public void onFinish() {
                if (this.isInit) {
                    return;
                }
                PcmRecorder.this.startRecording();
                this.isInit = true;
            }
        });
        start();
        Log.i(TAG, "START RUN");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initRetry() throws InterruptedException, SpeechError {
        if (this.exit.get()) {
            return;
        }
        try {
            initRecord(this.mChannel, this.mRate, this.mInterval, this.audioFormat, this.mBufferSize);
        } catch (Exception unused) {
            Thread.sleep(40L);
            throw new SpeechError(ErrorCode.ERROR_AUDIO_RECORD);
        }
    }

    private int readRecordData() throws SpeechError {
        RecorderListener recorderListener;
        AudioRecord audioRecord = this.mRecorder;
        if (audioRecord == null) {
            Log.e(TAG, "mRecorder is null");
            return 0;
        }
        if (this.mOutListener == null) {
            Log.e(TAG, "mOutListener is null");
            return 0;
        }
        byte[] bArr = this.mDataBuffer;
        int i = audioRecord.read(bArr, 0, bArr.length);
        if (i > 0 && (recorderListener = this.mOutListener) != null) {
            recorderListener.onBuffer(this.mDataBuffer, 0, i);
            this.mOutListener.onDecibel(calculateVolume(this.mDataBuffer));
        } else if (i < 0) {
            Log.e(TAG, "Record read data error: " + i);
            RecorderListener recorderListener2 = this.mOutListener;
            if (recorderListener2 != null) {
                recorderListener2.onError(new SpeechError(ErrorCode.ERROR_AUDIO_RECORD));
            }
            throw new SpeechError(ErrorCode.ERROR_AUDIO_RECORD);
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release() {
        synchronized (this) {
            try {
            } catch (Exception e) {
                Log.e(TAG, "Exception：" + e.toString());
            }
            if (this.mRecorder != null) {
                Log.d(TAG, "release record begin");
                this.mRecorder.release();
                this.mRecorder = null;
                RecorderListener recorderListener = this.mOutListener;
                if (recorderListener != null) {
                    recorderListener.onRelease();
                    this.mOutListener = null;
                }
                Log.d(TAG, "release record over");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startRecord() throws InterruptedException, SpeechError {
        RecorderListener recorderListener = this.mOutListener;
        boolean z = true;
        if (recorderListener != null) {
            recorderListener.onStart(true);
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        while (!this.exit.get()) {
            int recordData = readRecordData();
            if (z) {
                this.checkDataSum += (double) recordData;
                double d = this.checkStandDev;
                byte[] bArr = this.mDataBuffer;
                this.checkStandDev = d + checkAudio(bArr, bArr.length);
                Log.e(TAG, "checkAudio:checkStandDev=" + this.checkStandDev);
                if (System.currentTimeMillis() - jCurrentTimeMillis >= 1000) {
                    if (this.checkDataSum == w51.l || this.checkStandDev == w51.l) {
                        Log.e(TAG, "checkDataSum=" + this.checkDataSum + ",checkStandDev=" + this.checkStandDev);
                        Log.e(TAG, "cannot get record permission, get invalid audio data.");
                        throw new SpeechError(ErrorCode.ERROR_AUDIO_RECORD);
                    }
                    z = false;
                }
            }
            if (this.mDataBuffer.length > recordData) {
                Log.i(TAG, "current record read size is less than buffer size: " + recordData);
                Thread.sleep((long) this.mReadInterval);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startRetry() throws InterruptedException, SpeechError {
        int i = 0;
        while (!this.exit.get()) {
            try {
                this.mRecorder.startRecording();
                if (this.mRecorder.getRecordingState() == 3) {
                    return;
                }
                Log.e(TAG, "recorder state is not recoding");
                throw new SpeechError(ErrorCode.ERROR_AUDIO_RECORD);
            } catch (Exception unused) {
                i++;
                if (i >= 10) {
                    Log.e(TAG, "recoder start failed");
                    throw new SpeechError(ErrorCode.ERROR_AUDIO_RECORD);
                }
                Thread.sleep(40L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop(boolean z) {
        if (z) {
            synchronized (this) {
                try {
                    Log.d(TAG, "stopRecord...release");
                    AudioRecord audioRecord = this.mRecorder;
                    if (audioRecord != null) {
                        if (3 == audioRecord.getRecordingState() && 1 == this.mRecorder.getState()) {
                            Log.d(TAG, "stopRecord releaseRecording ing...");
                            this.mRecorder.release();
                            Log.d(TAG, "stopRecord releaseRecording end...");
                            this.mRecorder = null;
                        }
                        RecorderListener recorderListener = this.mOutListener;
                        if (recorderListener != null) {
                            recorderListener.onRelease();
                            this.mOutListener = null;
                        }
                    }
                } catch (Exception e) {
                    Log.e(TAG, "Exception: " + e.toString());
                }
            }
        }
        Log.d(TAG, "stop record");
    }

    public void finalize() throws Throwable {
        Log.d(TAG, "[finalize] release recoder");
        releaseRecord();
        super.finalize();
    }

    public void initRecord(short s, int i, int i2, int i3, int i4) throws SpeechError {
        if (this.mRecorder != null) {
            Log.d(TAG, "[initRecord] recoder release first");
            release();
        }
        int i5 = (i2 * i) / 1000;
        int i6 = (((i5 * 4) * 16) * s) / 8;
        int i7 = s == 1 ? 2 : 3;
        int minBufferSize = AudioRecord.getMinBufferSize(i, i7, i3);
        AudioRecord audioRecord = new AudioRecord(this.mAudioSource, i, i7, i3, i6 < minBufferSize ? minBufferSize : i6);
        this.mRecorder = audioRecord;
        if (i4 == 0) {
            i4 = ((i5 * s) * 16) / 8;
        }
        this.mDataBuffer = new byte[i4];
        if (audioRecord.getState() != 1) {
            Log.d(TAG, "create AudioRecord errormRecorder state" + this.mRecorder.getState());
            RecorderListener recorderListener = this.mOutListener;
            if (recorderListener != null) {
                recorderListener.onError(new SpeechError(ErrorCode.ERROR_AUDIO_RECORD));
            }
            throw new SpeechError(ErrorCode.ERROR_AUDIO_RECORD);
        }
    }

    public void releaseRecord() {
        if (this.mRecordHandle == null) {
            Log.e(TAG, "mRecordHandle is NULL");
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = 2;
        this.mRecordHandle.sendMessage(messageObtain);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    @SuppressLint({"HandlerLeak"})
    public void run() {
        Log.i("PcmRecord", "run....");
        try {
            initRetry();
            startRetry();
            Looper.prepare();
            this.mRecordHandle = new Handler() { // from class: com.iflytek.aikit.media.record.PcmRecorder.3
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    try {
                        int i = message.what;
                        if (i == 0) {
                            Log.i("mRecordHandle: ", "msg.what: " + message.what);
                            PcmRecorder.this.exit.set(false);
                            if (PcmRecorder.this.mRecorder == null) {
                                PcmRecorder.this.initRetry();
                                PcmRecorder.this.startRetry();
                            }
                            PcmRecorder.this.startRecord();
                            return;
                        }
                        if (i == 1) {
                            Log.i("mRecordHandle: ", "msg.what: " + message.what);
                            PcmRecorder.this.stop(((Boolean) message.obj).booleanValue());
                            return;
                        }
                        if (i != 2) {
                            return;
                        }
                        Log.i("mRecordHandle: ", "msg.what: " + message.what);
                        PcmRecorder.this.release();
                    } catch (Exception e) {
                        Log.e(PcmRecorder.TAG, "Exception：" + e.getMessage());
                        if (PcmRecorder.this.mOutListener != null) {
                            PcmRecorder.this.mOutListener.onError(new SpeechError(ErrorCode.ERROR_AUDIO_RECORD));
                        }
                    }
                }
            };
            this.finishListener.onFinish();
            Looper.loop();
        } catch (Exception e) {
            Log.e("PcmRecord", "Exception：" + e.getMessage());
            RecorderListener recorderListener = this.mOutListener;
            if (recorderListener != null) {
                recorderListener.onError(new SpeechError(ErrorCode.ERROR_AUDIO_RECORD));
            }
        }
    }

    public void setFinishListener(startFinishListener startfinishlistener) {
        this.finishListener = startfinishlistener;
    }

    public void setListener(RecorderListener recorderListener) {
        this.mOutListener = recorderListener;
    }

    public void startRecording() {
        if (this.mRecordHandle == null) {
            Log.e(TAG, "mRecordHandle is NULL");
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = 0;
        this.mRecordHandle.sendMessage(messageObtain);
    }

    public void stopRecord(boolean z) {
        if (this.mRecordHandle == null) {
            Log.e(TAG, "mRecordHandle is NULL");
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = 1;
        messageObtain.obj = Boolean.valueOf(z);
        Log.i("mRecordHandle: ", "stopRecord " + messageObtain.what);
        this.exit.set(true);
        this.mRecordHandle.sendMessage(messageObtain);
    }

    public void setListener(final PcmRecorder.PcmRecordListener pcmRecordListener) {
        this.mOutListener = new RecorderListener() { // from class: com.iflytek.aikit.media.record.PcmRecorder.2
            @Override // com.iflytek.aikit.media.record.RecorderListener
            public void onBuffer(byte[] bArr, int i, int i2) {
                pcmRecordListener.onRecordBuffer(bArr, i, i2);
            }

            @Override // com.iflytek.aikit.media.record.RecorderListener
            public void onDecibel(int i) {
                pcmRecordListener.onDecibel(i);
            }

            @Override // com.iflytek.aikit.media.record.RecorderListener
            public void onError(SpeechError speechError) {
                pcmRecordListener.onError((com.iflytek.aikit.core.media.speech.SpeechError) speechError);
            }

            @Override // com.iflytek.aikit.media.record.RecorderListener
            public void onRelease() {
                pcmRecordListener.onRecordReleased();
            }

            @Override // com.iflytek.aikit.media.record.RecorderListener
            public void onStart(boolean z) {
                pcmRecordListener.onRecordStarted(z);
            }
        };
    }

    public PcmRecorder(Builder builder, PcmRecorder.PcmRecordListener pcmRecordListener) {
        setListener(pcmRecordListener);
        init(builder.audioSource, builder.rate, builder.channel, builder.audioFormat, builder.bufferSize);
    }
}
