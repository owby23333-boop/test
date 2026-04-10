package com.bytedance.e.e.ga;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import xcrash.TombstoneParser;

/* JADX INFO: loaded from: classes.dex */
public class ga {

    public static class bf extends Thread {
        private long bf;
        private Process e;

        public bf(Process process, long j) {
            this.e = process;
            this.bf = j;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                Thread.sleep(this.bf);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Process process = this.e;
            if (process != null) {
                process.destroy();
            }
        }
    }

    public static class e extends Thread {
        private List<String> bf;
        private InputStream e;

        public e(InputStream inputStream, List<String> list) {
            this.e = inputStream;
            this.bf = list;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.e));
            int length = 32768;
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    if (!line.startsWith("---------")) {
                        length -= line.getBytes("UTF-8").length;
                        if (length < 0) {
                            break;
                        } else {
                            this.bf.add(line);
                        }
                    }
                } catch (IOException unused) {
                } catch (Throwable th) {
                    com.bytedance.e.e.v.vn.e(bufferedReader);
                    throw th;
                }
            }
            com.bytedance.e.e.v.vn.e(bufferedReader);
        }
    }

    public static List<String> e(int i, int i2) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        String[] strArr = {TombstoneParser.keyLogcat, "-t", String.valueOf(i), e(i2)};
        Process processExec = null;
        try {
            processExec = Runtime.getRuntime().exec(strArr);
            new e(processExec.getInputStream(), copyOnWriteArrayList).start();
            new e(processExec.getErrorStream(), copyOnWriteArrayList).start();
            new bf(processExec, 3000L).start();
            processExec.waitFor(3000L, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            try {
                th.printStackTrace();
                return copyOnWriteArrayList;
            } finally {
                if (processExec != null) {
                    processExec.destroy();
                }
            }
        }
        return copyOnWriteArrayList;
    }

    private static String e(int i) {
        return (i < 0 || i >= 6) ? "*:V" : new String[]{"*:V", "*:D", "*:I", "*:W", "*:E", "*:F"}[i];
    }
}
