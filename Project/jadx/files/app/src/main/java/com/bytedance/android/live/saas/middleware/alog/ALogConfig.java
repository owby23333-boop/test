package com.bytedance.android.live.saas.middleware.alog;

/* JADX INFO: loaded from: classes2.dex */
public class ALogConfig {
    private ILogProtocol aLogService;
    private boolean isDebug;
    private boolean standalone;

    public ALogConfig(ILogProtocol iLogProtocol, boolean z2) {
        this(iLogProtocol, z2, false);
    }

    public ILogProtocol getALogService() {
        return this.aLogService;
    }

    public boolean getStandalone() {
        return this.standalone;
    }

    public boolean isDebug() {
        return this.isDebug;
    }

    public void setALogService(ILogProtocol iLogProtocol) {
        this.aLogService = iLogProtocol;
    }

    public void setDebug(boolean z2) {
        this.isDebug = z2;
    }

    public void setStandalone(boolean z2) {
        this.standalone = z2;
    }

    public ALogConfig(ILogProtocol iLogProtocol, boolean z2, boolean z3) {
        this.standalone = true;
        this.isDebug = false;
        this.aLogService = iLogProtocol;
        this.standalone = z2;
        this.isDebug = z3;
    }
}
