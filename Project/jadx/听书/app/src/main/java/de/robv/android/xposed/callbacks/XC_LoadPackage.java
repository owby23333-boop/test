package de.robv.android.xposed.callbacks;

import android.content.pm.ApplicationInfo;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XCallback;

/* JADX INFO: loaded from: classes5.dex */
public abstract class XC_LoadPackage extends XCallback implements IXposedHookLoadPackage {

    public static final class LoadPackageParam extends XCallback.Param {
        public ApplicationInfo appInfo;
        public ClassLoader classLoader;
        public boolean isFirstApplication;
        public String packageName;
        public String processName;

        public LoadPackageParam(XposedBridge.CopyOnWriteSortedSet<XC_LoadPackage> copyOnWriteSortedSet) {
            super(copyOnWriteSortedSet);
        }
    }

    public XC_LoadPackage() {
    }

    public XC_LoadPackage(int i) {
        super(i);
    }

    @Override // de.robv.android.xposed.callbacks.XCallback
    public void call(XCallback.Param param) {
        if (param instanceof LoadPackageParam) {
            handleLoadPackage((LoadPackageParam) param);
        }
    }
}
