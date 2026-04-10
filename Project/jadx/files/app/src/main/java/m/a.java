package m;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import v.c;

/* JADX INFO: compiled from: C0030a.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    public static Uri a = Uri.parse("content://cn.nubia.identity/identity");

    public static String a(Context context, String str) {
        Bundle bundleCall;
        try {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 17) {
                ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(a);
                bundleCall = contentProviderClientAcquireUnstableContentProviderClient.call("getAAID", str, null);
                if (i2 >= 24) {
                    contentProviderClientAcquireUnstableContentProviderClient.close();
                } else {
                    contentProviderClientAcquireUnstableContentProviderClient.release();
                }
            } else {
                bundleCall = context.getContentResolver().call(a, "getAAID", str, (Bundle) null);
            }
            if (bundleCall.getInt("code", -1) == 0) {
                String string = bundleCall.getString("id");
                c.a("NubiaLog", "succeed:" + string);
                return string;
            }
            String string2 = bundleCall.getString("message");
            try {
                c.a("NubiaLog", "failed:" + string2);
                return string2;
            } catch (Exception unused) {
                return string2;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String b(Context context) {
        Bundle bundleCall;
        try {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 17) {
                ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(a);
                bundleCall = contentProviderClientAcquireUnstableContentProviderClient.call("getOAID", null, null);
                if (i2 >= 24) {
                    contentProviderClientAcquireUnstableContentProviderClient.close();
                } else {
                    contentProviderClientAcquireUnstableContentProviderClient.release();
                }
            } else {
                bundleCall = context.getContentResolver().call(a, "getOAID", (String) null, (Bundle) null);
            }
            if (bundleCall.getInt("code", -1) == 0) {
                String string = bundleCall.getString("id");
                c.a("NubiaLog", "succeed:" + string);
                return string;
            }
            String string2 = bundleCall.getString("message");
            try {
                c.a("NubiaLog", "failed:" + string2);
                return string2;
            } catch (Exception unused) {
                return string2;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static boolean a(Context context) {
        Bundle bundleCall;
        try {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 17) {
                ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(a);
                bundleCall = contentProviderClientAcquireUnstableContentProviderClient.call("isSupport", null, null);
                if (i2 >= 24) {
                    contentProviderClientAcquireUnstableContentProviderClient.close();
                } else {
                    contentProviderClientAcquireUnstableContentProviderClient.release();
                }
            } else {
                bundleCall = context.getContentResolver().call(a, "isSupport", (String) null, (Bundle) null);
            }
            if (bundleCall.getInt("code", -1) == 0) {
                c.a("NubiaLog", "succeed");
                return bundleCall.getBoolean("issupport", true);
            }
            c.a("NubiaLog", "failed:" + bundleCall.getString("message"));
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static String b(Context context, String str) {
        Bundle bundleCall;
        try {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 17) {
                ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(a);
                bundleCall = contentProviderClientAcquireUnstableContentProviderClient.call("getVAID", str, null);
                if (i2 >= 24) {
                    contentProviderClientAcquireUnstableContentProviderClient.close();
                } else {
                    contentProviderClientAcquireUnstableContentProviderClient.release();
                }
            } else {
                context.getContentResolver().call(a, "getVAID", str, (Bundle) null);
                bundleCall = null;
            }
            if (bundleCall.getInt("code", -1) == 0) {
                String string = bundleCall.getString("id");
                c.a("NubiaLog", "succeed:" + string);
                return string;
            }
            String string2 = bundleCall.getString("message");
            try {
                c.a("NubiaLog", "failed:" + string2);
                return string2;
            } catch (Exception unused) {
                return string2;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
