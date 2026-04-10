package q;

import android.content.Context;

/* JADX INFO: compiled from: MultiApkCheckUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class c {
    public static boolean a(Context context) {
        String absolutePath = context.getFilesDir().getAbsolutePath();
        String packageName = context.getPackageName();
        String str = "/data/data/" + packageName + "/files";
        StringBuilder sb = new StringBuilder();
        sb.append("/data/user/0/");
        sb.append(packageName);
        sb.append("/files");
        return (str.equals(absolutePath) || sb.toString().equals(absolutePath)) ? false : true;
    }
}
