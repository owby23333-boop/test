package com.bytedance.sdk.component.gz.g.g.g;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.gz.g.z.z.a;
import com.bytedance.sdk.component.gz.g.z.z.dl;
import com.bytedance.sdk.component.gz.z.e;
import com.bytedance.sdk.component.gz.z.fo;
import com.bytedance.sdk.component.gz.z.gc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private fo f741a;
    private gc dl;
    private Context g;
    private String z;

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

    public z(String str) {
        this.z = str;
        e eVarDl = com.bytedance.sdk.component.gz.g.z.dl(str);
        this.dl = eVarDl.dl();
        this.f741a = eVarDl.a();
    }

    private gc g() {
        if (this.dl == null) {
            this.dl = com.bytedance.sdk.component.gz.g.z.dl(this.z).dl();
        }
        return this.dl;
    }

    private fo dl() {
        if (this.f741a == null) {
            this.f741a = com.bytedance.sdk.component.gz.g.z.dl(this.z).a();
        }
        return this.f741a;
    }

    private static ContentResolver g(gc gcVar) {
        try {
            if (gcVar.getContext() != null) {
                return gcVar.getContext().getContentResolver();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void z(gc gcVar) {
        if (gcVar == null) {
            return;
        }
        try {
            ContentResolver contentResolverG = g(gcVar);
            if (contentResolverG != null) {
                contentResolverG.getType(Uri.parse(dl(gcVar) + "adLogStart"));
            }
        } catch (Throwable unused) {
        }
    }

    public static void z(com.bytedance.sdk.component.gz.z.g gVar, gc gcVar) {
        if (gVar == null) {
            return;
        }
        try {
            ContentResolver contentResolverG = g(gcVar);
            if (contentResolverG != null) {
                contentResolverG.getType(Uri.parse(dl(gcVar) + "adLogDispatch?event=" + dl.z(gVar.m())));
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.gz.g.dl.dl.dl("dispatch event Throwable:" + th.toString(), gcVar);
        }
    }

    public static void z(String str, List<String> list, boolean z, gc gcVar, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || list == null || list.isEmpty()) {
            return;
        }
        try {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                sb.append(dl.z(it.next())).append(",");
            }
            String str2 = "?did=" + String.valueOf(str) + "&track=" + String.valueOf(dl.z(sb.toString())) + "&replace=" + String.valueOf(z) + "&extraMate=" + dl.z(jSONObject.toString());
            ContentResolver contentResolverG = g(gcVar);
            if (contentResolverG != null) {
                contentResolverG.getType(Uri.parse(dl(gcVar) + "trackAdUrl" + str2));
            }
        } catch (Throwable unused) {
        }
    }

    public static void z(String str, gc gcVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            ContentResolver contentResolverG = g(gcVar);
            if (contentResolverG != null) {
                contentResolverG.getType(Uri.parse(dl(gcVar) + "trackAdFailed?did=" + String.valueOf(str)));
            }
        } catch (Throwable unused) {
        }
    }

    private static String dl(gc gcVar) {
        return a.z(gcVar) + "/" + ("csj_mediation".equals(gcVar.gc()) ? "gromore_ad_log_event" : "ad_log_event") + "/";
    }

    public void z(Context context) {
        this.g = context;
    }

    public String z() {
        return "csj_mediation".equals(this.z) ? "gromore_ad_log_event" : "ad_log_event";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public String getType(Uri uri) {
        int i;
        JSONObject jSONObject;
        g();
        fo foVarDl = dl();
        if (foVarDl == null) {
            com.bytedance.sdk.component.gz.g.dl.dl.a("getType center is null", g());
            return null;
        }
        String str = uri.getPath().split("/")[2];
        str.hashCode();
        switch (str) {
            case "trackAdFailed":
                com.bytedance.sdk.component.gz.g.m.z.z(g()).z(uri.getQueryParameter("did"));
                return null;
            case "adLogStart":
                g();
                foVarDl.z();
                return null;
            case "adLogStop":
                g();
                return null;
            case "adLogDispatch":
                g();
                com.bytedance.sdk.component.gz.z.g gVarA = com.bytedance.sdk.component.gz.g.a.z.z.a(dl.g(uri.getQueryParameter(NotificationCompat.CATEGORY_EVENT)));
                if (gVarA != null) {
                    foVarDl.z(gVarA);
                }
                return null;
            case "trackAdUrl":
                try {
                    String queryParameter = uri.getQueryParameter("did");
                    boolean zBooleanValue = Boolean.valueOf(uri.getQueryParameter("replace")).booleanValue();
                    String queryParameter2 = uri.getQueryParameter("track");
                    try {
                        jSONObject = new JSONObject(dl.g(uri.getQueryParameter("extraMate")));
                    } catch (Exception unused) {
                        jSONObject = null;
                    }
                    String[] strArrSplit = dl.g(queryParameter2).split(",");
                    if (strArrSplit.length > 0) {
                        ArrayList arrayList = new ArrayList();
                        for (String str2 : strArrSplit) {
                            String strG = dl.g(str2);
                            if (!TextUtils.isEmpty(strG)) {
                                arrayList.add(strG);
                            }
                        }
                        com.bytedance.sdk.component.gz.g.m.z.z(g()).z(queryParameter, arrayList, zBooleanValue, null, jSONObject);
                    }
                    break;
                } catch (Throwable unused2) {
                }
                return null;
            default:
                return null;
        }
    }
}
