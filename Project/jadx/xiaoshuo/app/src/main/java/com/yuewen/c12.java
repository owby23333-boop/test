package com.yuewen;

import android.content.Context;
import android.net.Uri;
import com.duokan.core.async.work.IAsyncWorkProgressListener;
import com.duokan.core.async.work.b;
import com.duokan.download.common.IDownloadTask;
import com.duokan.reader.common.download.DownloadFailCode;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public class c12 implements IDownloadTask {
    public static final String j = "json_tag_idownloadtask_user_value";
    public static final String k = "json_tag_idownloadtask_tag";
    public static final /* synthetic */ boolean l = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f9500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f9501b;
    public String c;
    public u12 d;
    public JSONObject e;
    public com.duokan.download.common.b f;
    public it0 g;
    public IDownloadTask.TaskStatus h;
    public IDownloadTask.TaskState i;

    public class a implements IAsyncWorkProgressListener<it0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ jt0 f9502a;

        public a(jt0 jt0Var) {
            this.f9502a = jt0Var;
        }

        @Override // com.duokan.core.async.work.IAsyncWorkProgressListener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void k(it0 it0Var) {
            IDownloadTask.TaskStatus taskStatus;
            IDownloadTask.TaskState taskState;
            this.f9502a.B(it0Var, this);
            synchronized (c12.this) {
                taskStatus = IDownloadTask.TaskStatus.STOPPED;
                taskState = IDownloadTask.TaskState.UNFINISHED;
                c12.this.h = taskStatus;
                c12.this.i = taskState;
                c12.this.g = null;
            }
            c12.this.w(taskStatus);
            c12.this.v(taskState);
        }

        @Override // com.duokan.core.async.work.IAsyncWorkProgressListener
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public IAsyncWorkProgressListener.CheckErrorResult h(it0 it0Var, b.a aVar) {
            return IAsyncWorkProgressListener.CheckErrorResult.Ignored;
        }

        @Override // com.duokan.core.async.work.IAsyncWorkProgressListener
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void j(it0 it0Var) {
            IDownloadTask.TaskStatus taskStatus;
            synchronized (c12.this) {
                taskStatus = IDownloadTask.TaskStatus.RUNNING;
                c12.this.h = taskStatus;
            }
            c12.this.w(taskStatus);
        }

        @Override // com.duokan.core.async.work.IAsyncWorkProgressListener
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public void c(it0 it0Var) {
            IDownloadTask.TaskStatus taskStatus;
            IDownloadTask.TaskState taskState;
            this.f9502a.B(it0Var, this);
            synchronized (c12.this) {
                taskStatus = IDownloadTask.TaskStatus.STOPPED;
                taskState = IDownloadTask.TaskState.FAILED;
                c12.this.h = taskStatus;
                c12.this.i = taskState;
            }
            c12.this.w(taskStatus);
            c12.this.v(taskState);
        }

        @Override // com.duokan.core.async.work.IAsyncWorkProgressListener
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public void f(it0 it0Var) {
            IDownloadTask.TaskStatus taskStatus;
            this.f9502a.B(it0Var, this);
            synchronized (c12.this) {
                taskStatus = it0Var.u() ? IDownloadTask.TaskStatus.PAUSED : IDownloadTask.TaskStatus.STOPPED;
                c12.this.h = taskStatus;
            }
            c12.this.w(taskStatus);
        }

        @Override // com.duokan.core.async.work.IAsyncWorkProgressListener
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public void e(it0 it0Var) {
            c12.this.u();
        }

        @Override // com.duokan.core.async.work.IAsyncWorkProgressListener
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public void l(it0 it0Var) {
        }

        @Override // com.duokan.core.async.work.IAsyncWorkProgressListener
        /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
        public void b(it0 it0Var) {
            IDownloadTask.TaskStatus taskStatus;
            IDownloadTask.TaskState taskState;
            this.f9502a.B(it0Var, this);
            synchronized (c12.this) {
                taskStatus = IDownloadTask.TaskStatus.STOPPED;
                taskState = IDownloadTask.TaskState.SUCCEEDED;
                c12.this.h = taskStatus;
                c12.this.i = taskState;
            }
            c12.this.w(taskStatus);
            c12.this.v(taskState);
        }
    }

    public c12(Context context, String str, String str2, u12 u12Var, JSONObject jSONObject, com.duokan.download.common.b bVar) {
        IDownloadTask.TaskStatus taskStatus = IDownloadTask.TaskStatus.STOPPED;
        this.h = taskStatus;
        IDownloadTask.TaskState taskState = IDownloadTask.TaskState.UNFINISHED;
        this.f9500a = context;
        this.f9501b = str;
        this.g = null;
        this.c = str2;
        this.d = u12Var;
        this.e = jSONObject;
        this.f = bVar;
        this.h = taskStatus;
        this.i = taskState;
    }

    @Override // com.duokan.download.common.IDownloadTask
    public IDownloadTask.TaskState a() {
        return this.i;
    }

    @Override // com.duokan.download.common.IDownloadTask
    public long d() {
        it0 it0Var = this.g;
        if (it0Var == null) {
            return 0L;
        }
        return it0Var.f();
    }

    @Override // com.duokan.download.common.IDownloadTask
    public boolean e() {
        return true;
    }

    @Override // com.duokan.download.common.IDownloadTask
    public void f(JSONObject jSONObject) {
        try {
            it0 it0Var = this.g;
            if (it0Var != null) {
                this.e = jSONObject;
                it0Var.g().put(j, jSONObject);
                m12.h(this.f9500a, this.d.f(), this.d.i()).l().E(it0Var);
            }
        } catch (JSONException unused) {
        }
    }

    @Override // com.duokan.download.common.IDownloadTask
    public long g() {
        return this.d.n();
    }

    @Override // com.duokan.download.common.IDownloadTask
    public DownloadFailCode h() {
        return DownloadFailCode.NONE;
    }

    @Override // com.duokan.download.common.IDownloadTask
    public long i() {
        it0 it0Var = this.g;
        if (it0Var == null || !it0Var.r() || it0Var.P() == 0 || it0Var.Q() == 0) {
            return 0L;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - it0Var.P();
        if (jCurrentTimeMillis == 0) {
            return 0L;
        }
        return (it0Var.Q() * 1000) / jCurrentTimeMillis;
    }

    @Override // com.duokan.download.common.IDownloadTask
    public int j() {
        return 0;
    }

    @Override // com.duokan.download.common.IDownloadTask
    public float k() {
        it0 it0Var = this.g;
        if (it0Var == null) {
            return 0.0f;
        }
        if (((Long) it0Var.j().second).longValue() == 0) {
            return 0.0f;
        }
        return (((Long) r0.first).longValue() / ((Long) r0.second).longValue()) * 100.0f;
    }

    @Override // com.duokan.download.common.IDownloadTask
    public IDownloadTask.TaskStatus l() {
        return this.h;
    }

    @Override // com.duokan.download.common.IDownloadTask
    public String m() {
        return this.d.h();
    }

    @Override // com.duokan.download.common.IDownloadTask
    public String o() {
        return this.c;
    }

    @Override // com.duokan.download.common.IDownloadTask
    public long p() {
        it0 it0Var = this.g;
        if (it0Var == null) {
            return 0L;
        }
        return it0Var.N();
    }

    @Override // com.duokan.download.common.IDownloadTask
    public JSONObject q() {
        return this.e;
    }

    @Override // com.duokan.download.common.IDownloadTask
    public String r() {
        return this.f9501b;
    }

    public void s() {
        m12 m12VarH = m12.h(this.f9500a, this.d.f(), this.d.i());
        it0 it0Var = this.g;
        if (it0Var != null) {
            m12VarH.l().l(it0Var);
        }
    }

    public u12 t() {
        return this.d;
    }

    public void u() {
        this.f.b(this);
    }

    public void v(IDownloadTask.TaskState taskState) {
        this.f.y(this, taskState);
    }

    public void w(IDownloadTask.TaskStatus taskStatus) {
        this.f.a(this, taskStatus);
    }

    public void x(boolean z) {
        m12 m12VarH = m12.h(this.f9500a, this.d.f(), this.d.i());
        it0 it0Var = this.g;
        if (it0Var != null) {
            m12VarH.l().A(it0Var, z);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void y() {
        IDownloadTask.TaskStatus taskStatus;
        it0 it0VarL;
        synchronized (this) {
            if (this.i == IDownloadTask.TaskState.SUCCEEDED) {
                return;
            }
            IDownloadTask.TaskStatus taskStatus2 = this.h;
            if (taskStatus2 != IDownloadTask.TaskStatus.RUNNING && taskStatus2 != (taskStatus = IDownloadTask.TaskStatus.PENDING)) {
                IDownloadTask.TaskState taskState = IDownloadTask.TaskState.UNFINISHED;
                this.h = taskStatus;
                this.i = taskState;
                w(taskStatus);
                v(taskState);
                jt0 jt0VarL = m12.h(this.f9500a, this.d.f(), this.d.i()).l();
                it0 it0Var = this.g;
                if (it0Var == null) {
                    String path = Uri.parse(this.c).getPath();
                    it0VarL = jt0VarL.L(path, path + ".micloud.temp", this.d, 5);
                } else {
                    it0VarL = (it0) jt0VarL.F(it0Var);
                }
                try {
                    it0VarL.g().put(j, this.e);
                    it0VarL.g().put(k, this.f9501b);
                } catch (JSONException unused) {
                }
                jt0VarL.E(it0VarL);
                synchronized (this) {
                    this.g = it0VarL;
                }
                jt0VarL.h(it0VarL, new a(jt0VarL));
            }
        }
    }

    public c12(Context context, it0 it0Var, com.duokan.download.common.b bVar) {
        this.h = IDownloadTask.TaskStatus.STOPPED;
        this.i = IDownloadTask.TaskState.UNFINISHED;
        this.f9500a = context;
        this.f9501b = it0Var.g().optString(k);
        this.g = it0Var;
        this.c = Uri.fromFile(new File(this.g.S())).toString();
        this.d = it0Var.L();
        JSONObject jSONObjectOptJSONObject = this.g.g().optJSONObject(j);
        this.e = jSONObjectOptJSONObject;
        if (jSONObjectOptJSONObject == null) {
            String strOptString = this.g.g().optString(j);
            if (strOptString == null) {
                this.e = new JSONObject();
            } else {
                try {
                    this.e = new JSONObject(strOptString);
                } catch (JSONException unused) {
                    this.e = new JSONObject();
                }
            }
        }
        this.f = bVar;
        IDownloadTask.TaskStatus taskStatus = IDownloadTask.TaskStatus.STOPPED;
        this.h = taskStatus;
        IDownloadTask.TaskState taskState = IDownloadTask.TaskState.UNFINISHED;
        this.i = taskState;
        if (this.g.w()) {
            this.h = IDownloadTask.TaskStatus.PENDING;
            this.i = taskState;
            return;
        }
        if (this.g.r()) {
            this.h = IDownloadTask.TaskStatus.RUNNING;
            this.i = taskState;
            return;
        }
        if (this.g.u()) {
            this.h = IDownloadTask.TaskStatus.PAUSED;
            this.i = taskState;
            return;
        }
        if (this.g.t()) {
            this.h = taskStatus;
            this.i = taskState;
            return;
        }
        if (this.g.s()) {
            this.h = taskStatus;
            this.i = IDownloadTask.TaskState.FAILED;
        } else if (this.g.x()) {
            this.h = taskStatus;
            this.i = IDownloadTask.TaskState.SUCCEEDED;
        } else if (this.g.p()) {
            this.h = taskStatus;
            this.i = taskState;
        }
    }
}
