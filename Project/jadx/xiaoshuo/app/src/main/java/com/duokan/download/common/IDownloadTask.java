package com.duokan.download.common;

import com.duokan.reader.common.download.DownloadFailCode;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public interface IDownloadTask {

    public enum TaskState {
        SUCCEEDED,
        FAILED,
        UNFINISHED
    }

    public enum TaskStatus {
        RUNNING,
        PENDING,
        PAUSED,
        STOPPED
    }

    TaskState a();

    long d();

    boolean e();

    void f(JSONObject jSONObject);

    long g();

    DownloadFailCode h();

    long i();

    int j();

    float k();

    TaskStatus l();

    String m();

    String o();

    long p();

    JSONObject q();

    String r();
}
