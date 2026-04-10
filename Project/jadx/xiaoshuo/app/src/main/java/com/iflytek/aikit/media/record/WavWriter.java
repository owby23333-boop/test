package com.iflytek.aikit.media.record;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes7.dex */
public class WavWriter {
    private static final String CHUNK_ID = "RIFF";
    private static final short DEFAULT_BITS_PER_SAMPLE = 16;
    private static final short DEFAULT_NUM_CHANNELS = 1;
    private static final String FORMAT = "WAVE";
    private static final short FORMAT_PCM = 1;
    private static final int SIZE_OF_WAVE_HEADER = 44;
    private static final String SUB_CHUNK1_ID = "fmt ";
    private static final int SUB_CHUNK1_SIZE = 16;
    private static final String SUB_CHUNK2_ID = "data";
    private short mBitsPerSample;
    private RandomAccessFile mInternalWriter;
    private short mNumChannels;
    private int mSampleRate;

    public WavWriter(File file, int i) throws IOException {
        init(file, (short) 1, i, (short) 16);
    }

    private boolean init(File file, short s, int i, short s2) throws IOException {
        if (file == null) {
            return false;
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        this.mInternalWriter = randomAccessFile;
        this.mNumChannels = s;
        this.mSampleRate = i;
        this.mBitsPerSample = s2;
        randomAccessFile.write(new byte[44]);
        return true;
    }

    public void close() throws IOException {
        RandomAccessFile randomAccessFile = this.mInternalWriter;
        if (randomAccessFile != null) {
            randomAccessFile.close();
            this.mInternalWriter = null;
        }
    }

    public int getDataSize() throws IOException {
        return (int) (this.mInternalWriter.length() - 44);
    }

    public void write(byte[] bArr) throws IOException {
        this.mInternalWriter.write(bArr);
    }

    public void writeChars(String str) throws IOException {
        for (int i = 0; i < str.length(); i++) {
            this.mInternalWriter.write(str.charAt(i));
        }
    }

    public void writeHeader() throws IOException {
        this.mInternalWriter.seek(0L);
        writeChars(CHUNK_ID);
        writeInt(getDataSize() + 36);
        writeChars(FORMAT);
        writeChars(SUB_CHUNK1_ID);
        writeInt(16);
        writeShort((short) 1);
        writeShort(this.mNumChannels);
        writeInt(this.mSampleRate);
        writeInt(((this.mNumChannels * this.mSampleRate) * this.mBitsPerSample) / 8);
        writeShort((short) ((this.mNumChannels * this.mBitsPerSample) / 8));
        writeShort(this.mBitsPerSample);
        writeChars("data");
        writeInt(getDataSize());
    }

    public void writeInt(int i) throws IOException {
        this.mInternalWriter.write(i >> 0);
        this.mInternalWriter.write(i >> 8);
        this.mInternalWriter.write(i >> 16);
        this.mInternalWriter.write(i >> 24);
    }

    public void writeShort(short s) throws IOException {
        this.mInternalWriter.write(s >> 0);
        this.mInternalWriter.write(s >> 8);
    }
}
