package de.robv.android.xposed;

import de.robv.android.xposed.callbacks.XC_LoadPackage;

/* JADX INFO: loaded from: classes5.dex */
public interface IXposedHookLoadPackage extends IXposedMod {

    public static final class Wrapper extends XC_LoadPackage {
        private final IXposedHookLoadPackage instance;

        public Wrapper(IXposedHookLoadPackage iXposedHookLoadPackage) {
            this.instance = iXposedHookLoadPackage;
        }

        @Override // de.robv.android.xposed.IXposedHookLoadPackage
        public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) {
            this.instance.handleLoadPackage(loadPackageParam);
        }
    }

    void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam);
}
