package q;

import com.kuaishou.weapon.p0.bh;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* JADX INFO: compiled from: RootCheckUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class f {
    public static boolean a() {
        Process processExec;
        try {
            processExec = Runtime.getRuntime().exec(new String[]{"which", "busybox"});
            try {
                if (new BufferedReader(new InputStreamReader(processExec.getInputStream())).readLine() != null) {
                    processExec.destroy();
                    return true;
                }
                processExec.destroy();
                return false;
            } catch (Throwable unused) {
                if (processExec != null) {
                    processExec.destroy();
                }
                return false;
            }
        } catch (Throwable unused2) {
            processExec = null;
        }
    }

    public static boolean b() {
        Process processExec;
        try {
            processExec = Runtime.getRuntime().exec(new String[]{"which", bh.f16586y});
            try {
                if (new BufferedReader(new InputStreamReader(processExec.getInputStream())).readLine() != null) {
                    processExec.destroy();
                    return true;
                }
                processExec.destroy();
                return false;
            } catch (Throwable unused) {
                if (processExec != null) {
                    processExec.destroy();
                }
                return false;
            }
        } catch (Throwable unused2) {
            processExec = null;
        }
    }
}
