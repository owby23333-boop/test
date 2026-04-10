package com.yuewen;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.io.File;

/* JADX INFO: loaded from: classes12.dex */
public class qh {
    public static final int e = 1000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f16520a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f16521b;
    public long c;
    public long d;

    public qh(@NonNull String str, @NonNull String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.f16520a = str2;
            this.f16521b = str;
            return;
        }
        throw new RuntimeException("illegal param:folder=" + str + ", file=" + str2);
    }

    public boolean a() {
        return this.d > 0;
    }

    public boolean b(File file) {
        return this.d > file.lastModified() / 1000;
    }

    public boolean c(File file) {
        return this.d < file.lastModified() / 1000;
    }

    public void d(long j, long j2) {
        this.c = j;
        this.d = j2 / 1000;
    }

    public void e(File file) {
        if (file == null || !file.exists()) {
            this.c = 0L;
            this.d = 0L;
        } else {
            this.c = file.length();
            this.d = file.lastModified() / 1000;
        }
    }

    public String toString() {
        return "BackupInfo{fileName='" + this.f16520a + "', folder='" + this.f16521b + "', size=" + this.c + ", lastModifyTime=" + this.d + '}';
    }
}
