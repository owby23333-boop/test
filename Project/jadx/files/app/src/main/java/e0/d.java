package e0;

import java.io.PrintWriter;
import java.io.StringWriter;

/* JADX INFO: compiled from: DataHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public class d {
    public static String a(Throwable th) {
        String string = null;
        if (th == null) {
            return null;
        }
        try {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            while (true) {
                th = th.getCause();
                if (th == null) {
                    string = stringWriter.toString();
                    printWriter.close();
                    stringWriter.close();
                    return string;
                }
                th.printStackTrace(printWriter);
            }
        } catch (Exception unused) {
            return string;
        }
    }
}
