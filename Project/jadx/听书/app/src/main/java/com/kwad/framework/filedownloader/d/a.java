package com.kwad.framework.filedownloader.d;

import android.content.ContentValues;
import com.kwad.framework.filedownloader.f.f;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private long anh;
    private long ani;
    private long anj;
    private int id;
    private int index;

    public final int getId() {
        return this.id;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final int getIndex() {
        return this.index;
    }

    public final void setIndex(int i) {
        this.index = i;
    }

    public final long getStartOffset() {
        return this.anh;
    }

    public final void setStartOffset(long j) {
        this.anh = j;
    }

    public final long yV() {
        return this.ani;
    }

    public final void X(long j) {
        this.ani = j;
    }

    public final long yW() {
        return this.anj;
    }

    public final void Y(long j) {
        this.anj = j;
    }

    public final ContentValues yX() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(this.id));
        contentValues.put("connectionIndex", Integer.valueOf(this.index));
        contentValues.put("startOffset", Long.valueOf(this.anh));
        contentValues.put("currentOffset", Long.valueOf(this.ani));
        contentValues.put("endOffset", Long.valueOf(this.anj));
        return contentValues;
    }

    public static long s(List<a> list) {
        long jYV = 0;
        for (a aVar : list) {
            jYV += aVar.yV() - aVar.getStartOffset();
        }
        return jYV;
    }

    public final String toString() {
        return f.c("id[%d] index[%d] range[%d, %d) current offset(%d)", Integer.valueOf(this.id), Integer.valueOf(this.index), Long.valueOf(this.anh), Long.valueOf(this.anj), Long.valueOf(this.ani));
    }
}
