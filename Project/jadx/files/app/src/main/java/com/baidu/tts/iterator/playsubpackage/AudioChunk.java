package com.baidu.tts.iterator.playsubpackage;

/* JADX INFO: loaded from: classes2.dex */
public class AudioChunk {
    private boolean isUpdateProgress = false;
    private int mLength;
    private float mPercent;
    private int mStartIndex;

    public int getLength() {
        return this.mLength;
    }

    public float getPercent() {
        return this.mPercent;
    }

    public int getStartIndex() {
        return this.mStartIndex;
    }

    public boolean isUpdateProgress() {
        return this.isUpdateProgress;
    }

    public void setLength(int i2) {
        this.mLength = i2;
    }

    public void setPercent(float f2) {
        this.mPercent = f2;
    }

    public void setStartIndex(int i2) {
        this.mStartIndex = i2;
    }

    public void setUpdateProgress(boolean z2) {
        this.isUpdateProgress = z2;
    }
}
