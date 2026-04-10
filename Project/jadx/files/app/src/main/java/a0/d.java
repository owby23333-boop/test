package a0;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/* JADX INFO: compiled from: FileUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class d {
    public static boolean a(File file) {
        if (file.exists()) {
            return false;
        }
        try {
            return file.createNewFile();
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean a(File file, String str) throws Throwable {
        BufferedWriter bufferedWriter;
        a(file);
        BufferedWriter bufferedWriter2 = null;
        try {
            try {
                bufferedWriter = new BufferedWriter(new FileWriter(file));
                try {
                    bufferedWriter.write(str);
                    try {
                        bufferedWriter.close();
                        return true;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        return true;
                    }
                } catch (IOException e3) {
                    e = e3;
                    bufferedWriter2 = bufferedWriter;
                    e.printStackTrace();
                    if (bufferedWriter2 != null) {
                        try {
                            bufferedWriter2.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    if (bufferedWriter != null) {
                        try {
                            bufferedWriter.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e6) {
                e = e6;
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedWriter = bufferedWriter2;
        }
    }
}
