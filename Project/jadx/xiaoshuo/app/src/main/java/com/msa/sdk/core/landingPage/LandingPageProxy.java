package com.msa.sdk.core.landingPage;

import android.content.Context;
import com.miui.systemAdSolution.landingPageV2.listener.IActionTaskResultListener;
import com.miui.systemAdSolution.landingPageV2.task.action.Action;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class LandingPageProxy {
    private static final String TAG = "LandingPageProxy";
    private static volatile RemoteProxy sRemoteProxy;
    private List<Action> mActions = new ArrayList();
    private IActionTaskResultListener mListener;

    public LandingPageProxy(Context context) {
        initRemoteProxy(context);
    }

    public static void initRemoteProxy(Context context) {
        if (sRemoteProxy == null) {
            synchronized (LandingPageProxy.class) {
                if (sRemoteProxy == null) {
                    sRemoteProxy = new RemoteProxy(context);
                }
            }
        }
    }

    public void addAction(Action action) throws Exception {
        this.mActions.add(action);
    }

    public void cancelTask(String str) {
        sRemoteProxy.cancelTask(str);
    }

    public void clearBeforeActions() {
        this.mActions.clear();
    }

    public void executeTask() {
        sRemoteProxy.executeTask(this.mActions, this.mListener);
    }

    public AppStatus getPackageDownloadStatus(String str) {
        return sRemoteProxy.getPackageDownloadStatus(str);
    }

    public int getServiceVersion() {
        return sRemoteProxy.getServiceVersion();
    }

    public void removeAction(Action action) throws Exception {
        this.mActions.remove(action);
    }

    public void setListener(IActionTaskResultListener iActionTaskResultListener) {
        this.mListener = iActionTaskResultListener;
    }

    public void addAction(int i, Action action) {
        this.mActions.add(i, action);
    }

    public void removeAction(int i) throws Exception {
        this.mActions.remove(i);
    }
}
