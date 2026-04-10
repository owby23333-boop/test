package com.ss.android.socialbase.downloader.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.thread.DownloadChunkRunnable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadChunk implements Parcelable {
    private int bindValueCount;
    private int chunkIndex;
    private DownloadChunkRunnable chunkRunnable;
    private long contentLength;
    private AtomicLong currentOffset;
    private long endOffset;
    private DownloadChunk hostChunk;
    private AtomicInteger hostChunkIndex;
    private int id;
    private AtomicBoolean isDownloading;
    private long oldOffset;
    private boolean reuseingFirstConnection;
    private long startOffset;
    private List<DownloadChunk> subChunkList;
    private static final String TAG = DownloadChunk.class.getSimpleName();
    public static final Parcelable.Creator<DownloadChunk> CREATOR = new Parcelable.Creator<DownloadChunk>() { // from class: com.ss.android.socialbase.downloader.model.DownloadChunk.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DownloadChunk createFromParcel(Parcel parcel) {
            return new DownloadChunk(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DownloadChunk[] newArray(int i2) {
            return new DownloadChunk[i2];
        }
    };

    public static class Builder {
        private int chunkIndex;
        private long contentLength;
        private long currentOffset;
        private long endOffset;
        private DownloadChunk hostChunk;
        private int id;
        private long oldOffset;
        private long startOffset;

        public Builder(int i2) {
            this.id = i2;
        }

        public DownloadChunk build() {
            return new DownloadChunk(this);
        }

        public Builder chunkIndex(int i2) {
            this.chunkIndex = i2;
            return this;
        }

        public Builder contentLength(long j2) {
            this.contentLength = j2;
            return this;
        }

        public Builder currentOffset(long j2) {
            this.currentOffset = j2;
            return this;
        }

        public Builder endOffset(long j2) {
            this.endOffset = j2;
            return this;
        }

        public Builder hostChunk(DownloadChunk downloadChunk) {
            this.hostChunk = downloadChunk;
            return this;
        }

        public Builder id(int i2) {
            this.id = i2;
            return this;
        }

        public Builder oldOffset(long j2) {
            this.oldOffset = j2;
            return this;
        }

        public Builder startOffset(long j2) {
            this.startOffset = j2;
            return this;
        }
    }

    public void bindValue(SQLiteStatement sQLiteStatement) {
        if (sQLiteStatement == null) {
            return;
        }
        this.bindValueCount = 0;
        sQLiteStatement.clearBindings();
        int i2 = this.bindValueCount + 1;
        this.bindValueCount = i2;
        sQLiteStatement.bindLong(i2, this.id);
        int i3 = this.bindValueCount + 1;
        this.bindValueCount = i3;
        sQLiteStatement.bindLong(i3, this.chunkIndex);
        int i4 = this.bindValueCount + 1;
        this.bindValueCount = i4;
        sQLiteStatement.bindLong(i4, this.startOffset);
        int i5 = this.bindValueCount + 1;
        this.bindValueCount = i5;
        sQLiteStatement.bindLong(i5, getCurrentOffset());
        int i6 = this.bindValueCount + 1;
        this.bindValueCount = i6;
        sQLiteStatement.bindLong(i6, this.endOffset);
        int i7 = this.bindValueCount + 1;
        this.bindValueCount = i7;
        sQLiteStatement.bindLong(i7, this.contentLength);
        int i8 = this.bindValueCount + 1;
        this.bindValueCount = i8;
        sQLiteStatement.bindLong(i8, getHostChunkIndex());
    }

    public boolean canRefreshCurOffsetForReuseChunk() {
        DownloadChunk downloadChunk = this.hostChunk;
        if (downloadChunk == null) {
            return true;
        }
        if (!downloadChunk.hasChunkDivided()) {
            return false;
        }
        for (int i2 = 0; i2 < this.hostChunk.getSubChunkList().size(); i2++) {
            DownloadChunk downloadChunk2 = this.hostChunk.getSubChunkList().get(i2);
            if (downloadChunk2 != null) {
                int iIndexOf = this.hostChunk.getSubChunkList().indexOf(this);
                if (iIndexOf > i2 && !downloadChunk2.hasNoBytesDownload()) {
                    return false;
                }
                if (iIndexOf == i2) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<DownloadChunk> divideChunkForReuse(int i2, long j2) {
        long j3;
        long j4;
        long startOffset;
        long j5;
        if (!isHostChunk() || hasChunkDivided()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        long curOffset = getCurOffset();
        int i3 = 1;
        long retainLength = getRetainLength(true);
        long j6 = retainLength / ((long) i2);
        Logger.d(TAG, "retainLen:" + retainLength + " divideChunkForReuse chunkSize:" + j6 + " current host downloadChunk index:" + this.chunkIndex);
        long j7 = curOffset;
        int i4 = 0;
        while (i4 < i2) {
            if (i4 == 0) {
                j3 = (j7 + j6) - 1;
                j4 = j6;
                startOffset = getStartOffset();
            } else {
                int i5 = i2 - 1;
                if (i4 == i5) {
                    long endOffset = getEndOffset();
                    j4 = endOffset > j7 ? 1 + (endOffset - j7) : retainLength - (((long) i5) * j6);
                    j5 = endOffset;
                    startOffset = j7;
                    Builder builderOldOffset = new Builder(this.id).chunkIndex((-i4) - i3).startOffset(startOffset).currentOffset(j7).oldOffset(j7);
                    long j8 = j5;
                    long j9 = j7;
                    long j10 = j4;
                    DownloadChunk downloadChunkBuild = builderOldOffset.endOffset(j8).contentLength(j10).hostChunk(this).build();
                    Logger.d(TAG, "divide sub chunk : " + i4 + " startOffset:" + startOffset + " curOffset:" + j9 + " endOffset:" + j8 + " contentLen:" + j10);
                    arrayList.add(downloadChunkBuild);
                    j7 = j9 + j6;
                    i4++;
                    retainLength = retainLength;
                    i3 = 1;
                } else {
                    j3 = (j7 + j6) - 1;
                    j4 = j6;
                    startOffset = j7;
                }
            }
            j5 = j3;
            Builder builderOldOffset2 = new Builder(this.id).chunkIndex((-i4) - i3).startOffset(startOffset).currentOffset(j7).oldOffset(j7);
            long j82 = j5;
            long j92 = j7;
            long j102 = j4;
            DownloadChunk downloadChunkBuild2 = builderOldOffset2.endOffset(j82).contentLength(j102).hostChunk(this).build();
            Logger.d(TAG, "divide sub chunk : " + i4 + " startOffset:" + startOffset + " curOffset:" + j92 + " endOffset:" + j82 + " contentLen:" + j102);
            arrayList.add(downloadChunkBuild2);
            j7 = j92 + j6;
            i4++;
            retainLength = retainLength;
            i3 = 1;
        }
        long contentLength = 0;
        for (int size = arrayList.size() - 1; size > 0; size--) {
            DownloadChunk downloadChunk = arrayList.get(size);
            if (downloadChunk != null) {
                contentLength += downloadChunk.getContentLength();
            }
        }
        Logger.d(TAG, "reuseChunkContentLen:" + contentLength);
        DownloadChunk downloadChunk2 = arrayList.get(0);
        if (downloadChunk2 != null) {
            downloadChunk2.setContentLength((getEndOffset() == 0 ? j2 - getStartOffset() : (getEndOffset() - getStartOffset()) + 1) - contentLength);
            downloadChunk2.setChunkIndex(this.chunkIndex);
            DownloadChunkRunnable downloadChunkRunnable = this.chunkRunnable;
            if (downloadChunkRunnable != null) {
                downloadChunkRunnable.refreshResponseHandleOffset(downloadChunk2.getEndOffset(), getContentLength() - contentLength);
            }
        }
        setSubChunkList(arrayList);
        return arrayList;
    }

    public int getBindValueCount() {
        return this.bindValueCount;
    }

    public int getChunkIndex() {
        return this.chunkIndex;
    }

    public long getContentLength() {
        return this.contentLength;
    }

    public long getCurOffset() {
        AtomicLong atomicLong = this.currentOffset;
        if (atomicLong != null) {
            return atomicLong.get();
        }
        return 0L;
    }

    public long getCurrentOffset() {
        if (!isHostChunk() || !hasChunkDivided()) {
            return getCurOffset();
        }
        long curOffset = 0;
        for (int i2 = 0; i2 < this.subChunkList.size(); i2++) {
            DownloadChunk downloadChunk = this.subChunkList.get(i2);
            if (downloadChunk != null) {
                if (!downloadChunk.hasNoBytesDownload()) {
                    return downloadChunk.getCurOffset();
                }
                if (curOffset < downloadChunk.getCurOffset()) {
                    curOffset = downloadChunk.getCurOffset();
                }
            }
        }
        return curOffset;
    }

    public long getDownloadChunkBytes() {
        long currentOffset = getCurrentOffset() - this.startOffset;
        if (hasChunkDivided()) {
            currentOffset = 0;
            for (int i2 = 0; i2 < this.subChunkList.size(); i2++) {
                DownloadChunk downloadChunk = this.subChunkList.get(i2);
                if (downloadChunk != null) {
                    currentOffset += downloadChunk.getCurrentOffset() - downloadChunk.getStartOffset();
                }
            }
        }
        return currentOffset;
    }

    public long getEndOffset() {
        return this.endOffset;
    }

    public DownloadChunk getFirstReuseChunk() {
        DownloadChunk downloadChunk = !isHostChunk() ? this.hostChunk : this;
        if (downloadChunk == null || !downloadChunk.hasChunkDivided()) {
            return null;
        }
        return downloadChunk.getSubChunkList().get(0);
    }

    public DownloadChunk getHostChunk() {
        return this.hostChunk;
    }

    public int getHostChunkIndex() {
        AtomicInteger atomicInteger = this.hostChunkIndex;
        if (atomicInteger == null) {
            return -1;
        }
        return atomicInteger.get();
    }

    public int getId() {
        return this.id;
    }

    public long getNextChunkCurOffset() {
        DownloadChunk downloadChunk = this.hostChunk;
        if (downloadChunk != null && downloadChunk.getSubChunkList() != null) {
            int iIndexOf = this.hostChunk.getSubChunkList().indexOf(this);
            boolean z2 = false;
            for (int i2 = 0; i2 < this.hostChunk.getSubChunkList().size(); i2++) {
                DownloadChunk downloadChunk2 = this.hostChunk.getSubChunkList().get(i2);
                if (downloadChunk2 != null) {
                    if (z2) {
                        return downloadChunk2.getCurrentOffset();
                    }
                    if (iIndexOf == i2) {
                        z2 = true;
                    }
                }
            }
        }
        return -1L;
    }

    public long getOldOffset() {
        return this.oldOffset;
    }

    public long getRetainLength(boolean z2) {
        long currentOffset = getCurrentOffset();
        long j2 = this.contentLength;
        long j3 = this.oldOffset;
        long j4 = j2 - (currentOffset - j3);
        if (!z2 && currentOffset == j3) {
            j4 = j2 - (currentOffset - this.startOffset);
        }
        Logger.d("DownloadChunk", "contentLength:" + this.contentLength + " curOffset:" + getCurrentOffset() + " oldOffset:" + this.oldOffset + " retainLen:" + j4);
        if (j4 < 0) {
            return 0L;
        }
        return j4;
    }

    public long getStartOffset() {
        return this.startOffset;
    }

    public List<DownloadChunk> getSubChunkList() {
        return this.subChunkList;
    }

    public boolean hasChunkDivided() {
        List<DownloadChunk> list = this.subChunkList;
        return list != null && list.size() > 0;
    }

    public boolean hasNoBytesDownload() {
        long j2 = this.startOffset;
        if (isHostChunk()) {
            long j3 = this.oldOffset;
            if (j3 > this.startOffset) {
                j2 = j3;
            }
        }
        return getCurrentOffset() - j2 >= this.contentLength;
    }

    public boolean isDownloading() {
        AtomicBoolean atomicBoolean = this.isDownloading;
        if (atomicBoolean == null) {
            return false;
        }
        return atomicBoolean.get();
    }

    public boolean isHostChunk() {
        return getHostChunkIndex() == -1;
    }

    public boolean isReuseingFirstConnection() {
        return this.chunkIndex == 0 && this.reuseingFirstConnection;
    }

    public void setChunkIndex(int i2) {
        this.chunkIndex = i2;
    }

    public void setChunkRunnable(DownloadChunkRunnable downloadChunkRunnable) {
        this.chunkRunnable = downloadChunkRunnable;
        setOldOffset();
    }

    public void setContentLength(long j2) {
        this.contentLength = j2;
    }

    public void setCurrentOffset(long j2) {
        AtomicLong atomicLong = this.currentOffset;
        if (atomicLong != null) {
            atomicLong.set(j2);
        } else {
            this.currentOffset = new AtomicLong(j2);
        }
    }

    public void setDownloading(boolean z2) {
        AtomicBoolean atomicBoolean = this.isDownloading;
        if (atomicBoolean == null) {
            this.isDownloading = new AtomicBoolean(z2);
        } else {
            atomicBoolean.set(z2);
        }
        this.chunkRunnable = null;
    }

    public void setHostChunk(DownloadChunk downloadChunk) {
        this.hostChunk = downloadChunk;
        DownloadChunk downloadChunk2 = this.hostChunk;
        if (downloadChunk2 != null) {
            setHostChunkIndex(downloadChunk2.getChunkIndex());
        }
    }

    public void setHostChunkIndex(int i2) {
        AtomicInteger atomicInteger = this.hostChunkIndex;
        if (atomicInteger == null) {
            this.hostChunkIndex = new AtomicInteger(i2);
        } else {
            atomicInteger.set(i2);
        }
    }

    public void setId(int i2) {
        this.id = i2;
    }

    public void setOldOffset(long j2) {
        this.oldOffset = j2;
    }

    public void setReuseingFirstConnection(boolean z2) {
        this.reuseingFirstConnection = z2;
    }

    public void setSubChunkList(List<DownloadChunk> list) {
        this.subChunkList = list;
    }

    public ContentValues toContentValues() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Integer.valueOf(this.id));
        contentValues.put(DBDefinition.CHUNK_INDEX, Integer.valueOf(this.chunkIndex));
        contentValues.put(DBDefinition.START_OFFSET, Long.valueOf(this.startOffset));
        contentValues.put(DBDefinition.CUR_OFFSET, Long.valueOf(getCurrentOffset()));
        contentValues.put(DBDefinition.END_OFFSET, Long.valueOf(this.endOffset));
        contentValues.put(DBDefinition.CHUNK_CONTENT_LEN, Long.valueOf(this.contentLength));
        contentValues.put(DBDefinition.HOST_CHUNK_INDEX, Integer.valueOf(getHostChunkIndex()));
        return contentValues;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.id);
        parcel.writeLong(this.startOffset);
        AtomicLong atomicLong = this.currentOffset;
        parcel.writeLong(atomicLong != null ? atomicLong.get() : 0L);
        parcel.writeLong(this.endOffset);
        parcel.writeLong(this.contentLength);
        parcel.writeInt(this.chunkIndex);
        AtomicInteger atomicInteger = this.hostChunkIndex;
        parcel.writeInt(atomicInteger != null ? atomicInteger.get() : -1);
    }

    private DownloadChunk(Builder builder) {
        if (builder == null) {
            return;
        }
        this.id = builder.id;
        this.startOffset = builder.startOffset;
        this.currentOffset = new AtomicLong(builder.currentOffset);
        this.endOffset = builder.endOffset;
        this.contentLength = builder.contentLength;
        this.chunkIndex = builder.chunkIndex;
        this.oldOffset = builder.oldOffset;
        this.hostChunkIndex = new AtomicInteger(-1);
        setHostChunk(builder.hostChunk);
        this.isDownloading = new AtomicBoolean(false);
    }

    public void setOldOffset() {
        this.oldOffset = getCurrentOffset();
    }

    public DownloadChunk(Cursor cursor) {
        if (cursor == null) {
            return;
        }
        this.id = cursor.getInt(cursor.getColumnIndex("_id"));
        this.chunkIndex = cursor.getInt(cursor.getColumnIndex(DBDefinition.CHUNK_INDEX));
        this.startOffset = cursor.getLong(cursor.getColumnIndex(DBDefinition.START_OFFSET));
        int columnIndex = cursor.getColumnIndex(DBDefinition.CUR_OFFSET);
        if (columnIndex != -1) {
            this.currentOffset = new AtomicLong(cursor.getLong(columnIndex));
        } else {
            this.currentOffset = new AtomicLong(0L);
        }
        this.endOffset = cursor.getLong(cursor.getColumnIndex(DBDefinition.END_OFFSET));
        int columnIndex2 = cursor.getColumnIndex(DBDefinition.HOST_CHUNK_INDEX);
        if (columnIndex2 != -1) {
            this.hostChunkIndex = new AtomicInteger(cursor.getInt(columnIndex2));
        } else {
            this.hostChunkIndex = new AtomicInteger(-1);
        }
        int columnIndex3 = cursor.getColumnIndex(DBDefinition.CHUNK_CONTENT_LEN);
        if (columnIndex3 != -1) {
            this.contentLength = cursor.getLong(columnIndex3);
        }
        this.isDownloading = new AtomicBoolean(false);
    }

    protected DownloadChunk(Parcel parcel) {
        this.id = parcel.readInt();
        this.startOffset = parcel.readLong();
        this.currentOffset = new AtomicLong(parcel.readLong());
        this.endOffset = parcel.readLong();
        this.contentLength = parcel.readLong();
        this.chunkIndex = parcel.readInt();
        this.hostChunkIndex = new AtomicInteger(parcel.readInt());
    }
}
