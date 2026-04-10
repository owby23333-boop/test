package com.duokan.monitor.dump;

import android.os.Build;
import android.os.Debug;
import android.text.TextUtils;
import com.yuewen.qt1;
import com.yuewen.um3;
import com.yuewen.wc1;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes17.dex */
public class ForkHeapDumper implements wc1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f3787b = "ForkHeapDumper";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f3788a = um3.a("mboom");

    public ForkHeapDumper() {
        if (qt1.g()) {
            qt1.d(f3787b, "-->ForkHeapDumper.init<>, soLoaded=" + this.f3788a);
        }
        if (this.f3788a) {
            initForkDump();
        } else {
            qt1.d(f3787b, "init so fail.");
        }
    }

    public static native boolean dumpHprofDataNative(String str);

    private native void exitProcess();

    private native void initForkDump();

    private native void resumeVM();

    private native int trySuspendVMThenFork();

    private native void waitPid(int i);

    @Override // com.yuewen.wc1
    public boolean a(String str) {
        if (qt1.g()) {
            qt1.i(f3787b, "dump " + str);
        }
        boolean zB = false;
        if (!this.f3788a) {
            qt1.d(f3787b, "dump failed caused by so not loaded!");
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            qt1.d(f3787b, "dump failed caused by missing target file");
            return false;
        }
        File parentFile = new File(str).getParentFile();
        if (qt1.g()) {
            qt1.c(f3787b, "-->dump(): parent path=" + parentFile.getAbsolutePath() + ", exist?", Boolean.valueOf(parentFile.exists()), ", directory?", Boolean.valueOf(parentFile.isDirectory()));
        }
        if (parentFile != null && (!parentFile.exists() || !parentFile.isDirectory())) {
            qt1.a(f3787b, "try dump, target folder not exist, create it now");
            parentFile.mkdirs();
        }
        if (Build.VERSION.SDK_INT > 29) {
            return dumpHprofDataNative(str);
        }
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            int iTrySuspendVMThenFork = trySuspendVMThenFork();
            if (qt1.g()) {
                qt1.i(f3787b, "fork process done, pid=" + iTrySuspendVMThenFork + ", cost time=" + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms");
            }
            if (iTrySuspendVMThenFork == 0) {
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                Debug.dumpHprofData(str);
                long jCurrentTimeMillis3 = System.currentTimeMillis();
                if (qt1.g()) {
                    qt1.i(f3787b, "notifyDumped:false, cost time=" + (jCurrentTimeMillis3 - jCurrentTimeMillis2) + "ms");
                }
                exitProcess();
            } else {
                long jCurrentTimeMillis4 = System.currentTimeMillis();
                resumeVM();
                if (qt1.g()) {
                    qt1.i(f3787b, "resume VM done, cost time=" + (System.currentTimeMillis() - jCurrentTimeMillis4) + "ms");
                }
                zB = b(iTrySuspendVMThenFork);
                if (qt1.g()) {
                    qt1.i(f3787b, "hprof pid:" + iTrySuspendVMThenFork + " dumped: " + str);
                }
            }
        } catch (IOException e) {
            qt1.b(f3787b, "dump failed caused by IOException!", e);
        }
        return zB;
    }

    public final boolean b(int i) {
        waitPid(i);
        return true;
    }
}
