package com.bytedance.sdk.component.gz.g.g.g;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.gz.g.dl;
import com.bytedance.sdk.component.gz.g.z.z.a;
import com.bytedance.sdk.component.gz.z.fo;
import com.bytedance.sdk.component.gz.z.gc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    public static dl z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private fo f740a;
    private gc dl;
    private String g;

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    private gc z() {
        if (this.dl == null) {
            this.dl = com.bytedance.sdk.component.gz.g.z.dl(this.g).dl();
        }
        return this.dl;
    }

    private fo g() {
        if (this.f740a == null) {
            this.f740a = com.bytedance.sdk.component.gz.g.z.dl(this.g).a();
        }
        return this.f740a;
    }

    public static dl z(gc gcVar) {
        try {
            if (z == null) {
                z = gcVar.a().kb();
            }
        } catch (Exception unused) {
        }
        return z;
    }

    public static void g(gc gcVar) {
        if (gcVar == null) {
            return;
        }
        try {
            dl dlVarZ = z(gcVar);
            if (dlVarZ != null) {
                dlVarZ.getType(Uri.parse(dl(gcVar) + "adLogStart"));
            }
        } catch (Throwable unused) {
        }
    }

    public static void z(com.bytedance.sdk.component.gz.z.g gVar, gc gcVar) {
        if (gVar == null || gcVar == null) {
            return;
        }
        try {
            dl dlVarZ = z(gcVar);
            if (dlVarZ != null) {
                dlVarZ.getType(Uri.parse(dl(gcVar) + "adLogDispatch?event=" + com.bytedance.sdk.component.gz.g.z.z.dl.z(gVar.m())));
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.gz.g.dl.dl.dl("dispatch event Throwable:" + th.toString(), gcVar);
        }
    }

    public static void z(String str, List<String> list, boolean z2, gc gcVar) {
        if (list == null || list.isEmpty() || gcVar == null) {
            return;
        }
        try {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                sb.append(com.bytedance.sdk.component.gz.g.z.z.dl.z(it.next())).append(",");
            }
            String str2 = "?did=" + String.valueOf(str) + "&track=" + String.valueOf(com.bytedance.sdk.component.gz.g.z.z.dl.z(sb.toString())) + "&replace=" + String.valueOf(z2);
            dl dlVarZ = z(gcVar);
            if (dlVarZ != null) {
                dlVarZ.getType(Uri.parse(dl(gcVar) + "trackAdUrl" + str2));
            }
        } catch (Throwable unused) {
        }
    }

    public static void z(String str, gc gcVar) {
        if (TextUtils.isEmpty(str) || gcVar == null) {
            return;
        }
        try {
            dl dlVarZ = z(gcVar);
            if (dlVarZ != null) {
                dlVarZ.getType(Uri.parse(dl(gcVar) + "trackAdFailed?did=" + String.valueOf(str)));
            }
        } catch (Throwable unused) {
        }
    }

    private static String dl(gc gcVar) {
        return a.z(gcVar) + "/ad_log_event/";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public String getType(Uri uri) {
        int i;
        com.bytedance.sdk.component.gz.z.g gVarA;
        z();
        fo foVarG = g();
        if (foVarG == null) {
            return null;
        }
        String str = uri.getPath().split("/")[2];
        str.hashCode();
        switch (str) {
            case "trackAdFailed":
                com.bytedance.sdk.component.gz.g.m.z.z(z()).z(uri.getQueryParameter("did"));
                return null;
            case "adLogStart":
                z();
                foVarG.z();
                return null;
            case "adLogStop":
                z();
                return null;
            case "adLogDispatch":
                z();
                String queryParameter = uri.getQueryParameter(NotificationCompat.CATEGORY_EVENT);
                if (!TextUtils.isEmpty(queryParameter) && (gVarA = com.bytedance.sdk.component.gz.g.a.z.z.a(com.bytedance.sdk.component.gz.g.z.z.dl.g(queryParameter))) != null) {
                    g().z(gVarA);
                }
                return null;
            case "trackAdUrl":
                z();
                try {
                    String queryParameter2 = uri.getQueryParameter("did");
                    boolean zBooleanValue = Boolean.valueOf(uri.getQueryParameter("replace")).booleanValue();
                    String[] strArrSplit = com.bytedance.sdk.component.gz.g.z.z.dl.g(uri.getQueryParameter("track")).split(",");
                    if (strArrSplit.length > 0) {
                        ArrayList arrayList = new ArrayList();
                        for (String str2 : strArrSplit) {
                            String strG = com.bytedance.sdk.component.gz.g.z.z.dl.g(str2);
                            if (!TextUtils.isEmpty(strG)) {
                                arrayList.add(strG);
                            }
                        }
                        com.bytedance.sdk.component.gz.g.m.z.z(z()).z(queryParameter2, arrayList, zBooleanValue, null, new JSONObject());
                    }
                    break;
                } catch (Throwable unused) {
                }
                return null;
            default:
                return null;
        }
    }
}
