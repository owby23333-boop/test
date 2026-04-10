package com.bytedance.android.live.saas.middleware.applog;

import com.bytedance.android.live.base.api.IHostPermission;

/* JADX INFO: loaded from: classes2.dex */
public class AppLogConfig {
    private String appLogId;
    private IHostPermission hostPermission;
    private IAppLog impl;
    private boolean isToBVersion;
    private boolean standalone;

    public AppLogConfig() {
        this.impl = null;
        this.standalone = false;
        this.isToBVersion = false;
        this.appLogId = null;
        this.hostPermission = null;
    }

    public String getAppLogId() {
        return this.appLogId;
    }

    public IHostPermission getHostPermission() {
        return this.hostPermission;
    }

    public IAppLog getImpl() {
        return this.impl;
    }

    public boolean getStandalone() {
        return this.standalone;
    }

    public boolean isToBVersion() {
        return this.isToBVersion;
    }

    public void setAppLogId(String str) {
        this.appLogId = str;
    }

    public void setHostPermission(IHostPermission iHostPermission) {
        this.hostPermission = iHostPermission;
    }

    public void setImpl(IAppLog iAppLog) {
        this.impl = iAppLog;
    }

    public void setStandalone(boolean z2) {
        this.standalone = z2;
    }

    public void setToBVersion(boolean z2) {
        this.isToBVersion = z2;
    }

    public AppLogConfig(IAppLog iAppLog, boolean z2) {
        this(iAppLog, z2, false);
    }

    public AppLogConfig(IAppLog iAppLog, boolean z2, boolean z3) {
        this(iAppLog, z2, z3, null);
    }

    public AppLogConfig(IAppLog iAppLog, boolean z2, boolean z3, String str) {
        this(iAppLog, z2, z3, str, null);
    }

    public AppLogConfig(IAppLog iAppLog, boolean z2, boolean z3, String str, IHostPermission iHostPermission) {
        this.impl = null;
        this.standalone = false;
        this.isToBVersion = false;
        this.appLogId = null;
        this.hostPermission = null;
        this.impl = iAppLog;
        this.standalone = z2;
        this.isToBVersion = z3;
        this.appLogId = str;
        this.hostPermission = iHostPermission;
    }
}
