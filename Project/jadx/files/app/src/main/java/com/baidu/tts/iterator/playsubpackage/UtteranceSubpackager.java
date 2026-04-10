package com.baidu.tts.iterator.playsubpackage;

import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class UtteranceSubpackager implements Iterator<AudioChunk> {
    private static final String TAG = "UtteranceSubpackager";
    private int mCurrentAllUtteranceLenght;
    private int mCurrentAppendStartIndex;
    private int mCurrentProgressStartIndex;
    private int mCurrentWriteStartIndex;
    private int mProgress;
    private int mProgressChunkSize;
    private int mUtteranceStartIndex;

    private int getProgressEndIndex() {
        return (this.mCurrentProgressStartIndex + this.mProgressChunkSize) - 1;
    }

    private int getUtteranceEndIndex() {
        return (this.mUtteranceStartIndex + this.mCurrentAllUtteranceLenght) - 1;
    }

    public void append(int i2) {
        this.mCurrentAllUtteranceLenght += i2;
        this.mCurrentAppendStartIndex = 0;
    }

    public void end() {
    }

    public int getmProgress() {
        return this.mProgress;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.mCurrentWriteStartIndex < getUtteranceEndIndex();
    }

    @Override // java.util.Iterator
    public void remove() {
    }

    public void setProgressChunkSize(int i2) {
        this.mProgressChunkSize = i2;
    }

    public void setmProgress(int i2) {
        this.mProgress = i2;
    }

    public void start() {
        this.mUtteranceStartIndex = 0;
        this.mCurrentAllUtteranceLenght = 0;
        this.mCurrentProgressStartIndex = 0;
        this.mCurrentWriteStartIndex = 0;
        this.mCurrentAppendStartIndex = 0;
        this.mProgress = 0;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    public AudioChunk next() {
        AudioChunk audioChunk = new AudioChunk();
        int progressEndIndex = getProgressEndIndex();
        if (progressEndIndex <= getUtteranceEndIndex()) {
            int i2 = (progressEndIndex - this.mCurrentWriteStartIndex) + 1;
            audioChunk.setStartIndex(this.mCurrentAppendStartIndex);
            audioChunk.setLength(i2);
            this.mCurrentWriteStartIndex = progressEndIndex + 1;
            this.mCurrentProgressStartIndex = this.mCurrentWriteStartIndex;
            this.mCurrentAppendStartIndex += i2;
            float f2 = this.mCurrentProgressStartIndex / this.mCurrentAllUtteranceLenght;
            LoggerProxy.d(TAG, "mCurrentProgressStartIndex=" + this.mCurrentProgressStartIndex + "--mCurrentAllUtteranceLenght=" + this.mCurrentAllUtteranceLenght + "--percent=" + f2);
            audioChunk.setPercent(f2);
            audioChunk.setUpdateProgress(true);
        } else {
            int i3 = this.mCurrentAllUtteranceLenght - this.mCurrentWriteStartIndex;
            audioChunk.setStartIndex(this.mCurrentAppendStartIndex);
            audioChunk.setLength(i3);
            this.mCurrentWriteStartIndex += i3;
            this.mCurrentAppendStartIndex += i3;
        }
        return audioChunk;
    }
}
