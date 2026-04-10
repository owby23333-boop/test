package com.yuewen;

import com.duokan.dkbookshelf.data.ImportedFileInfo;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public class gn1 extends ImportedFileInfo {
    public List<ImportedFileInfo> e;

    public gn1() {
        this.e = new LinkedList();
    }

    public void f(ImportedFileInfo importedFileInfo) {
        this.e.add(importedFileInfo);
    }

    public boolean g(ImportedFileInfo importedFileInfo) {
        return this.e.contains(importedFileInfo);
    }

    public int h() {
        return this.e.size();
    }

    public List<ImportedFileInfo> i() {
        return this.e;
    }

    public gn1(String str, String str2, long j) {
        super(str, str2, j);
        this.e = new LinkedList();
    }

    public gn1(ImportedFileInfo importedFileInfo) {
        super(importedFileInfo.b(), importedFileInfo.a(), importedFileInfo.c());
        this.e = new LinkedList();
    }
}
