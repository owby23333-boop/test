package f;

import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;

/* JADX INFO: compiled from: HttpManager.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    public static String a;

    /* JADX WARN: Removed duplicated region for block: B:8:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.lang.String r9, java.util.Map<java.lang.String, java.lang.Object> r10) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 343
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: f.a.a(java.lang.String, java.util.Map):java.lang.String");
    }

    public static OkHttpClient a() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return builder.connectTimeout(30L, timeUnit).readTimeout(30L, timeUnit).writeTimeout(30L, timeUnit).build();
    }
}
