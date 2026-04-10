package com.kwai.filedownloader.c;

import android.content.ContentValues;
import com.kwai.filedownloader.e.f;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private long aFw;
    private long aFx;
    private long aFy;
    private int id;
    private int index;

    public static long J(List<a> list) {
        long jIl = 0;
        for (a aVar : list) {
            jIl += aVar.Il() - aVar.getStartOffset();
        }
        return jIl;
    }

    public final long Il() {
        return this.aFx;
    }

    public final long Im() {
        return this.aFy;
    }

    public final ContentValues In() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(this.id));
        contentValues.put("connectionIndex", Integer.valueOf(this.index));
        contentValues.put(DBDefinition.START_OFFSET, Long.valueOf(this.aFw));
        contentValues.put("currentOffset", Long.valueOf(this.aFx));
        contentValues.put(DBDefinition.END_OFFSET, Long.valueOf(this.aFy));
        return contentValues;
    }

    public final void am(long j2) {
        this.aFx = j2;
    }

    public final void an(long j2) {
        this.aFy = j2;
    }

    public final int getId() {
        return this.id;
    }

    public final int getIndex() {
        return this.index;
    }

    public final long getStartOffset() {
        return this.aFw;
    }

    public final void setId(int i2) {
        this.id = i2;
    }

    public final void setIndex(int i2) {
        this.index = i2;
    }

    public final void setStartOffset(long j2) {
        this.aFw = j2;
    }

    public final String toString() {
        return f.j("id[%d] index[%d] range[%d, %d) current offset(%d)", Integer.valueOf(this.id), Integer.valueOf(this.index), Long.valueOf(this.aFw), Long.valueOf(this.aFy), Long.valueOf(this.aFx));
    }
}
