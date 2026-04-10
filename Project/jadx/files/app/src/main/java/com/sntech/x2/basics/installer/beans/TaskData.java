package com.sntech.x2.basics.installer.beans;

import androidx.annotation.Keep;
import java.util.List;
import y.b;

/* JADX INFO: loaded from: classes3.dex */
@Keep
public class TaskData {

    @Keep
    private List<String> downloadPaths;

    @Keep
    private String packageName;

    public List<String> getDownloadPaths() {
        return this.downloadPaths;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public void setDownloadPaths(List<String> list) {
        this.downloadPaths = list;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public String toString() {
        StringBuilder sbA = b.a("TaskData{downloadPaths=");
        sbA.append(this.downloadPaths);
        sbA.append(", packageName='");
        sbA.append(this.packageName);
        sbA.append('\'');
        sbA.append('}');
        return sbA.toString();
    }
}
