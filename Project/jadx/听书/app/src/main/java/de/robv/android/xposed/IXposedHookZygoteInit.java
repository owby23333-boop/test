package de.robv.android.xposed;

/* JADX INFO: loaded from: classes5.dex */
public interface IXposedHookZygoteInit extends IXposedMod {

    public static final class StartupParam {
        public String modulePath;
        public boolean startsSystemServer;
    }

    void initZygote(StartupParam startupParam);
}
