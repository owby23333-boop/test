package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Bundle;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.tencent.smtt.export.external.DexLoader;

/* JADX INFO: loaded from: classes3.dex */
public class TbsVideoCacheTask {
    public static final String KEY_VIDEO_CACHE_PARAM_FILENAME = "filename";
    public static final String KEY_VIDEO_CACHE_PARAM_FOLDERPATH = "folderPath";
    public static final String KEY_VIDEO_CACHE_PARAM_HEADER = "header";
    public static final String KEY_VIDEO_CACHE_PARAM_URL = "url";
    Context a;
    TbsVideoCacheListener b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f18946e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f18947f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f18944c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private q f18945d = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Object f18948g = null;

    public TbsVideoCacheTask(Context context, Bundle bundle, TbsVideoCacheListener tbsVideoCacheListener) {
        this.a = null;
        this.b = null;
        this.a = context;
        this.b = tbsVideoCacheListener;
        if (bundle != null) {
            this.f18946e = bundle.getString(DBDefinition.TASK_ID);
            this.f18947f = bundle.getString("url");
        }
        a(bundle);
    }

    private void a(Bundle bundle) {
        TbsVideoCacheListener tbsVideoCacheListener;
        String str;
        DexLoader dexLoaderC;
        if (this.f18945d == null) {
            g.a(true).a(this.a, false, false);
            u uVarA = g.a(true).a();
            if (uVarA != null) {
                dexLoaderC = uVarA.c();
            } else {
                this.b.onVideoDownloadError(this, -1, "init engine error!", null);
                dexLoaderC = null;
            }
            if (dexLoaderC != null) {
                this.f18945d = new q(dexLoaderC);
            } else {
                this.b.onVideoDownloadError(this, -1, "Java dexloader invalid!", null);
            }
        }
        q qVar = this.f18945d;
        if (qVar != null) {
            this.f18948g = qVar.a(this.a, this, bundle);
            if (this.f18948g != null) {
                return;
            }
            tbsVideoCacheListener = this.b;
            str = "init task error!";
        } else {
            tbsVideoCacheListener = this.b;
            if (tbsVideoCacheListener == null) {
                return;
            } else {
                str = "init error!";
            }
        }
        tbsVideoCacheListener.onVideoDownloadError(this, -1, str, null);
    }

    public long getContentLength() {
        q qVar = this.f18945d;
        if (qVar != null && this.f18948g != null) {
            return qVar.d();
        }
        TbsVideoCacheListener tbsVideoCacheListener = this.b;
        if (tbsVideoCacheListener == null) {
            return 0L;
        }
        tbsVideoCacheListener.onVideoDownloadError(this, -1, "getContentLength failed, init uncompleted!", null);
        return 0L;
    }

    public int getDownloadedSize() {
        q qVar = this.f18945d;
        if (qVar != null && this.f18948g != null) {
            return qVar.e();
        }
        TbsVideoCacheListener tbsVideoCacheListener = this.b;
        if (tbsVideoCacheListener == null) {
            return 0;
        }
        tbsVideoCacheListener.onVideoDownloadError(this, -1, "getDownloadedSize failed, init uncompleted!", null);
        return 0;
    }

    public int getProgress() {
        q qVar = this.f18945d;
        if (qVar != null && this.f18948g != null) {
            return qVar.f();
        }
        TbsVideoCacheListener tbsVideoCacheListener = this.b;
        if (tbsVideoCacheListener == null) {
            return 0;
        }
        tbsVideoCacheListener.onVideoDownloadError(this, -1, "getProgress failed, init uncompleted!", null);
        return 0;
    }

    public String getTaskID() {
        return this.f18946e;
    }

    public String getTaskUrl() {
        return this.f18947f;
    }

    public void pauseTask() {
        q qVar = this.f18945d;
        if (qVar != null && this.f18948g != null) {
            qVar.a();
            return;
        }
        TbsVideoCacheListener tbsVideoCacheListener = this.b;
        if (tbsVideoCacheListener != null) {
            tbsVideoCacheListener.onVideoDownloadError(this, -1, "pauseTask failed, init uncompleted!", null);
        }
    }

    public void removeTask(boolean z2) {
        q qVar = this.f18945d;
        if (qVar != null && this.f18948g != null) {
            qVar.a(z2);
            return;
        }
        TbsVideoCacheListener tbsVideoCacheListener = this.b;
        if (tbsVideoCacheListener != null) {
            tbsVideoCacheListener.onVideoDownloadError(this, -1, "removeTask failed, init uncompleted!", null);
        }
    }

    public void resumeTask() {
        q qVar = this.f18945d;
        if (qVar != null && this.f18948g != null) {
            qVar.b();
            return;
        }
        TbsVideoCacheListener tbsVideoCacheListener = this.b;
        if (tbsVideoCacheListener != null) {
            tbsVideoCacheListener.onVideoDownloadError(this, -1, "resumeTask failed, init uncompleted!", null);
        }
    }

    public void stopTask() {
        q qVar = this.f18945d;
        if (qVar != null && this.f18948g != null) {
            qVar.c();
            return;
        }
        TbsVideoCacheListener tbsVideoCacheListener = this.b;
        if (tbsVideoCacheListener != null) {
            tbsVideoCacheListener.onVideoDownloadError(this, -1, "stopTask failed, init uncompleted!", null);
        }
    }
}
