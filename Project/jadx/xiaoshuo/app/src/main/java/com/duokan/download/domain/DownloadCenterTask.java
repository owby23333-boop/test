package com.duokan.download.domain;

import com.duokan.download.common.IDownloadTask;
import com.duokan.reader.common.download.DownloadFailCode;
import com.yuewen.a54;
import com.yuewen.cn;
import com.yuewen.iw2;
import com.yuewen.kd0;
import com.yuewen.st0;
import com.yuewen.v51;
import com.yuewen.yk2;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public class DownloadCenterTask {
    public static final String f = ".tmp";
    public static final /* synthetic */ boolean g = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IDownloadTask f3570a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TaskResult f3571b;
    public st0 c;
    public boolean d;
    public boolean e;

    public enum TaskResult {
        NONE,
        OK,
        DOWNLOAD_FAILED,
        DECODE_ERROR,
        URI_EXPIRED
    }

    public static class a {

        /* JADX INFO: renamed from: com.duokan.download.domain.DownloadCenterTask$a$a, reason: collision with other inner class name */
        public static class C0239a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final String f3572a = "download_info";

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final String f3573b = "task_result";
            public static final String c = "is_handled";
            public static final String d = "is_finished_notification_read";
        }
    }

    public DownloadCenterTask(IDownloadTask iDownloadTask) throws Exception {
        TaskResult taskResult = TaskResult.NONE;
        this.f3571b = taskResult;
        JSONObject jSONObjectQ = null;
        this.c = null;
        this.d = false;
        this.e = false;
        this.f3570a = iDownloadTask;
        if (iDownloadTask != null) {
            try {
                jSONObjectQ = iDownloadTask.q();
            } catch (JSONException unused) {
                return;
            }
        }
        if (jSONObjectQ == null || jSONObjectQ.length() <= 0) {
            return;
        }
        this.f3571b = TaskResult.valueOf(jSONObjectQ.optString(a.C0239a.f3573b, taskResult.toString()));
        this.d = jSONObjectQ.optBoolean(a.C0239a.c, false);
        this.e = jSONObjectQ.optBoolean(a.C0239a.d, false);
        JSONObject jSONObjectOptJSONObject = jSONObjectQ.optJSONObject(a.C0239a.f3572a);
        if (jSONObjectOptJSONObject == null) {
            cn cnVar = new cn();
            JSONObject jSONObject = jSONObjectQ.getJSONObject("book_info");
            cnVar.f = jSONObject.optString(iw2.r);
            cnVar.g = jSONObject.optString("book_uuid");
            cnVar.h = jSONObject.getString("book_name");
            cnVar.i = jSONObject.optString(iw2.t);
            cnVar.j = jSONObject.optString("author");
            cnVar.k = jSONObject.optString("abstract");
            cnVar.f17622b = jSONObject.optLong("size", 0L);
            cnVar.l = jSONObject.optString("cover_url");
            this.c = cnVar;
            return;
        }
        cn cnVarG = cn.g(jSONObjectOptJSONObject);
        if (cnVarG != null) {
            this.c = cnVarG;
            return;
        }
        v51 v51VarE = v51.e(jSONObjectOptJSONObject);
        if (v51VarE != null) {
            this.c = v51VarE;
            return;
        }
        yk2 yk2VarE = yk2.e(jSONObjectOptJSONObject);
        if (yk2VarE != null) {
            this.c = yk2VarE;
            return;
        }
        kd0 kd0VarE = kd0.e(jSONObjectOptJSONObject);
        if (kd0VarE != null) {
            this.c = kd0VarE;
            return;
        }
        a54 a54VarF = a54.f(jSONObjectOptJSONObject);
        if (a54VarF == null) {
            throw new IllegalArgumentException();
        }
        this.c = a54VarF;
    }

    public static DownloadCenterTask x(IDownloadTask iDownloadTask) {
        try {
            return new DownloadCenterTask(iDownloadTask);
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean a() {
        return this.f3570a.e();
    }

    public st0 b() {
        return this.c;
    }

    public long c() {
        return this.f3570a.g();
    }

    public float d() {
        return this.f3570a.k();
    }

    public long e() {
        return this.f3570a.i();
    }

    public long f() {
        return this.f3570a.p();
    }

    public DownloadFailCode g() {
        return this.f3570a.h();
    }

    public boolean h() {
        TaskResult taskResult = this.f3571b;
        return (taskResult == TaskResult.NONE || taskResult == TaskResult.OK) ? false : true;
    }

    public boolean i() {
        return this.f3571b != TaskResult.NONE;
    }

    public boolean j() {
        return m() || n();
    }

    public boolean k() {
        return this.f3570a.a() == IDownloadTask.TaskState.UNFINISHED && this.f3570a.l() == IDownloadTask.TaskStatus.STOPPED;
    }

    public boolean l() {
        return this.f3570a.a() == IDownloadTask.TaskState.UNFINISHED && this.f3570a.l() == IDownloadTask.TaskStatus.PAUSED;
    }

    public boolean m() {
        return this.f3570a.l() == IDownloadTask.TaskStatus.PENDING;
    }

    public boolean n() {
        return (k() || l() || this.f3571b != TaskResult.NONE) ? false : true;
    }

    public boolean o() {
        return this.f3571b == TaskResult.OK;
    }

    public String p() {
        String strO = this.f3570a.o();
        return strO.endsWith(f) ? strO.substring(0, strO.length() - 4) : strO;
    }

    public TaskResult q() {
        return this.f3571b;
    }

    public String r() {
        return this.f3570a.m();
    }

    public int s() {
        return this.f3570a.j();
    }

    public boolean t() {
        return this.e;
    }

    public boolean u() {
        return this.d;
    }

    public void v() {
        this.e = true;
        z();
    }

    public void w() {
        this.d = true;
        z();
    }

    public void y(TaskResult taskResult) {
        this.f3571b = taskResult;
        z();
    }

    public final void z() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(a.C0239a.f3573b, this.f3571b);
            jSONObject.put(a.C0239a.f3572a, this.c.d());
            jSONObject.put(a.C0239a.c, this.d);
            jSONObject.put(a.C0239a.d, this.e);
            this.f3570a.f(jSONObject);
        } catch (Exception unused) {
        }
    }
}
