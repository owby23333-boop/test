package com.iflytek.aikit.plugin.record;

import android.media.AudioRecord;
import android.os.Handler;
import android.os.Looper;
import com.iflytek.aikit.plugin.AudioSourceType;
import com.iflytek.aikit.plugin.ChannelConfig;
import com.iflytek.aikit.plugin.EventType;
import com.iflytek.aikit.plugin.PcmEncoding;
import com.iflytek.aikit.plugin.RateType;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes7.dex */
public class AudioRecorderImpl {
    private AudioRecord audioRecord;
    private int bufferSize;
    private File recordFile;
    private RecorderListener recorderListener;
    private Thread recordingThread;
    private final String TAG = "AudioRecorderImpl";
    private int mSimpleRate = RateType.RATE16K.getValue();
    private int mAudioSource = AudioSourceType.MIC.getValue();
    private int mChannel = ChannelConfig.ChannelMono.getValue();
    private int mAudioFormat = PcmEncoding.ENCODING_PCM_16BIT.getValue();
    private AtomicBoolean isRecording = new AtomicBoolean(false);
    private AtomicBoolean isPaused = new AtomicBoolean(false);
    private String saveFilePath = "";
    private boolean isSaveToFile = false;
    private Handler myHandle = new Handler(Looper.myLooper());

    public class RecordThread extends Thread {
        private RecordThread() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            FileOutputStream fileOutputStream;
            int audioRecordBuffer;
            super.run();
            int i = AudioRecorderImpl.this.bufferSize;
            byte[] bArr = new byte[AudioRecorderImpl.this.bufferSize];
            if (AudioRecorderImpl.this.isSaveToFile) {
                try {
                    fileOutputStream = new FileOutputStream(AudioRecorderImpl.this.recordFile);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            } else {
                fileOutputStream = null;
            }
            while (AudioRecorderImpl.this.isRecording()) {
                if (!AudioRecorderImpl.this.isPaused() && (audioRecordBuffer = AudioRecorderImpl.this.getAudioRecordBuffer(i, bArr)) > 0) {
                    float fAbs = Math.abs((int) bArr[0]) / 32767.0f;
                    int iRound = Math.round(((2.0f * fAbs) - (fAbs * fAbs)) * 9.0f);
                    if (audioRecordBuffer == i) {
                        AudioRecorderImpl.this.doMyThreadProcess(bArr, audioRecordBuffer, iRound);
                        if (AudioRecorderImpl.this.isSaveToFile) {
                            AudioRecorderImpl.this.writeToFile(fileOutputStream, bArr);
                        }
                    } else {
                        byte[] bArr2 = new byte[audioRecordBuffer];
                        System.arraycopy(bArr, 0, bArr2, 0, audioRecordBuffer);
                        AudioRecorderImpl.this.doMyThreadProcess(bArr2, audioRecordBuffer, iRound);
                        if (AudioRecorderImpl.this.isSaveToFile) {
                            AudioRecorderImpl.this.writeToFile(fileOutputStream, bArr);
                        }
                    }
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    private void doMyThread(final EventType eventType, final String str) {
        this.myHandle.post(new Runnable() { // from class: com.iflytek.aikit.plugin.record.AudioRecorderImpl.2
            @Override // java.lang.Runnable
            public void run() {
                AudioRecorderImpl.this.recorderListener.onEvent(eventType.getValue(), str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doMyThreadProcess(final byte[] bArr, int i, int i2) {
        this.myHandle.post(new Runnable() { // from class: com.iflytek.aikit.plugin.record.AudioRecorderImpl.1
            @Override // java.lang.Runnable
            public void run() {
                AudioRecorderImpl.this.recorderListener.onData(bArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getAudioRecordBuffer(int i, byte[] bArr) {
        AudioRecord audioRecord = this.audioRecord;
        if (audioRecord != null) {
            return audioRecord.read(bArr, 0, i);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writeToFile(FileOutputStream fileOutputStream, byte[] bArr) {
        if (fileOutputStream == null) {
            return;
        }
        try {
            fileOutputStream.write(bArr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void init() {
        AudioRecord audioRecord = this.audioRecord;
        if (audioRecord != null) {
            audioRecord.release();
        }
        try {
            this.bufferSize = AudioRecord.getMinBufferSize(this.mSimpleRate, this.mChannel, this.mAudioFormat);
            this.audioRecord = new AudioRecord(this.mAudioSource, this.mSimpleRate, this.mChannel, this.mAudioFormat, this.bufferSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        AudioRecord audioRecord2 = this.audioRecord;
        if (audioRecord2 != null && audioRecord2.getState() != 1) {
            throw new RuntimeException("初始化录音失败");
        }
    }

    public boolean isPaused() {
        return this.isPaused.get();
    }

    public boolean isRecording() {
        return this.isRecording.get();
    }

    public void pauseRecording() {
        if (this.audioRecord == null || !this.isRecording.get()) {
            return;
        }
        this.audioRecord.stop();
        this.isPaused.set(true);
        doMyThread(EventType.PAUSED, "");
    }

    public void resumeRecording() {
        AudioRecord audioRecord = this.audioRecord;
        if (audioRecord != null && audioRecord.getState() == 1 && this.isPaused.get()) {
            this.audioRecord.startRecording();
            doMyThread(EventType.RESUMED, "");
            this.isPaused.set(false);
        }
    }

    public void setRecorderListener(RecorderListener recorderListener) {
        this.recorderListener = recorderListener;
    }

    public void startRecording() {
        AudioRecord audioRecord = this.audioRecord;
        if (audioRecord != null) {
            int state = audioRecord.getState();
            if (state == 0) {
                init();
                this.audioRecord.startRecording();
            } else if (state == 1) {
                try {
                    this.audioRecord.startRecording();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.isRecording.set(true);
                this.isPaused.set(false);
                if (this.isSaveToFile && !this.saveFilePath.isEmpty()) {
                    File file = new File(this.saveFilePath);
                    this.recordFile = file;
                    this.isSaveToFile = false;
                    if (!file.isFile()) {
                        throw new RuntimeException("File path error:  " + this.isSaveToFile);
                    }
                }
                RecordThread recordThread = new RecordThread();
                this.recordingThread = recordThread;
                recordThread.setName("RecordThread");
                try {
                    Thread thread = this.recordingThread;
                    if (thread != null) {
                        thread.start();
                        doMyThread(EventType.STARTED, "");
                        return;
                    }
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            throw new RuntimeException("录音失败");
        }
    }

    public void stopRecording() {
        if (this.audioRecord != null) {
            this.isRecording.set(false);
            this.isPaused.set(false);
            if (this.audioRecord.getState() == 1) {
                try {
                    this.audioRecord.stop();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                }
            }
            this.audioRecord.release();
            this.recordingThread.interrupt();
            doMyThread(EventType.STOPPED, "");
        }
    }
}
