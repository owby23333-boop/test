package com.dangdang.reader.dread.data;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class Footprint {
    public int bookmarksCount;
    public String date;
    public List<IFootprintData> footprints = new ArrayList();
    public int notesCount;

    public void addData(IFootprintData iFootprintData) {
        this.footprints.add(iFootprintData);
        if (iFootprintData instanceof BookMark) {
            this.bookmarksCount++;
        } else if (iFootprintData instanceof BookNote) {
            this.notesCount++;
        }
    }

    public String getBookmarksCountStr() {
        return String.valueOf(this.bookmarksCount);
    }

    public String getNotesCountStr() {
        return String.valueOf(this.notesCount);
    }
}
