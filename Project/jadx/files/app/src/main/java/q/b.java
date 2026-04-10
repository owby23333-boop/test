package q;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.UUID;

/* JADX INFO: compiled from: Const.java */
/* JADX INFO: loaded from: classes3.dex */
public class b {
    public static String a = null;
    public static String b = "AN_A4";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f21663c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final byte[] f21664d = Arrays.copyOf("x04VOtkJ".getBytes(), 16);

    public static String a(Context context) {
        try {
            File file = new File(context.getFilesDir(), "snc_did.data");
            strA = file.exists() ? a.a(file.getPath()) : null;
            if (TextUtils.isEmpty(strA)) {
                strA = d.a(UUID.randomUUID().toString().getBytes());
                FileWriter fileWriter = new FileWriter(file);
                try {
                    fileWriter.write(strA);
                    fileWriter.close();
                } finally {
                }
            }
        } catch (Exception unused) {
        }
        return strA;
    }
}
