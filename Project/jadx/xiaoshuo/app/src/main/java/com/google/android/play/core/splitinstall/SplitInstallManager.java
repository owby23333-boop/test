package com.google.android.play.core.splitinstall;

import com.google.android.play.core.tasks.Task;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes7.dex */
public interface SplitInstallManager {
    Task<Void> cancelInstall(int i);

    Task<Void> deferredInstall(List<String> list);

    Task<Void> deferredUninstall(List<String> list);

    Set<String> getInstalledModules();

    Task<SplitInstallSessionState> getSessionState(int i);

    Task<List<SplitInstallSessionState>> getSessionStates();

    void registerListener(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener);

    Task<Integer> startInstall(SplitInstallRequest splitInstallRequest);

    void unregisterListener(SplitInstallStateUpdatedListener splitInstallStateUpdatedListener);
}
