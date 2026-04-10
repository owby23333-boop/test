package com.bytedance.pangle.m;

import com.bytedance.pangle.log.ZeusLogger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    public static boolean z(String[] strArr) {
        if (strArr.length <= 0) {
            return false;
        }
        try {
            Process processExec = Runtime.getRuntime().exec(strArr);
            InputStream errorStream = processExec.getErrorStream();
            InputStream inputStream = processExec.getInputStream();
            z(errorStream);
            z(inputStream);
            if (processExec.waitFor() == 0) {
                return true;
            }
            ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "exec dex2oat failed : " + Arrays.toString(strArr));
            return false;
        } catch (IOException e) {
            com.bytedance.sdk.openadsdk.api.m.z(e);
            return false;
        } catch (InterruptedException e2) {
            com.bytedance.sdk.openadsdk.api.m.z(e2);
            return false;
        }
    }

    private static void z(final InputStream inputStream) {
        com.bytedance.pangle.gc.gc.g(new Runnable() { // from class: com.bytedance.pangle.m.z.1
            @Override // java.lang.Runnable
            public void run() {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            return;
                        } else {
                            ZeusLogger.d(ZeusLogger.TAG_INSTALL, "exec cmd info : ".concat(String.valueOf(line)));
                        }
                    } catch (IOException e) {
                        ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "execCmd consumeInputStream failed : ".concat(String.valueOf(e)));
                        return;
                    } finally {
                        com.bytedance.pangle.util.e.z(bufferedReader);
                    }
                }
            }
        });
    }
}
