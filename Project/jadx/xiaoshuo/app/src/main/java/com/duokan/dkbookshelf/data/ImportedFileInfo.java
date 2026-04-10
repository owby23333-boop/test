package com.duokan.dkbookshelf.data;

/* JADX INFO: loaded from: classes13.dex */
public class ImportedFileInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f3098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f3099b;
    public String c;
    public FileStatus d;

    public enum FileStatus {
        UNSELECTED,
        SELECTED,
        IMPORTED,
        UPLOADED
    }

    public ImportedFileInfo() {
    }

    public String a() {
        return this.c;
    }

    public String b() {
        return this.f3099b;
    }

    public long c() {
        return this.f3098a;
    }

    public FileStatus d() {
        return this.d;
    }

    public void e(FileStatus fileStatus) {
        this.d = fileStatus;
    }

    public ImportedFileInfo(String str, String str2, long j) {
        this.f3099b = str;
        this.c = str2;
        this.f3098a = j;
    }
}
