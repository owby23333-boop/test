package com.iflytek.aikit.plugin.player;

import android.util.Log;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes7.dex */
public class AudioBuffer {
    private AtomicBoolean canWrite;
    private Lock lock;
    private ArrayList<AudioInfo> mAudioInfo;
    private ByteBuffer playBuffer;
    private Condition readFromBuffer;
    private Condition writeToBuffer;

    public static class AudioInfo {
        public long beginIndex;
        public long beginOffset;
        public long endIndex;
        public long endOffset;

        public AudioInfo(long j, long j2, long j3, long j4) {
            this.beginIndex = j;
            this.endIndex = j2;
            this.beginOffset = j3;
            this.endOffset = j4;
        }
    }

    public AudioBuffer() {
        this.mAudioInfo = null;
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.writeToBuffer = reentrantLock.newCondition();
        this.readFromBuffer = this.lock.newCondition();
        this.canWrite = new AtomicBoolean(true);
        this.mAudioInfo = new ArrayList<>();
    }

    public void addInfo(AudioInfo audioInfo) {
        this.mAudioInfo.add(audioInfo);
    }

    public void clear() {
        ByteBuffer byteBuffer = this.playBuffer;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        this.mAudioInfo.clear();
    }

    public void finalize() throws Throwable {
        clear();
        super.finalize();
    }

    public ArrayList<AudioInfo> getAudioInfoList() {
        return this.mAudioInfo;
    }

    public ByteBuffer getPlayBuffer(int i) {
        if (this.playBuffer == null) {
            this.playBuffer = ByteBuffer.allocate(i);
        }
        return this.playBuffer;
    }

    public void readData(byte[] bArr, int i) {
        this.playBuffer.flip();
        Log.e("playBuffer: ", "pos: " + this.playBuffer.position() + " cap: " + this.playBuffer.capacity() + " limit: " + this.playBuffer.limit() + " bufOffset: " + i);
        this.playBuffer.get(bArr, 0, i);
        this.playBuffer.compact();
    }

    public void writeData(byte[] bArr) {
        this.playBuffer.put(bArr);
    }
}
