package j0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import com.repack.meizu.flyme.openidsdk.C0064a;

/* JADX INFO: compiled from: C0065b.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile a f20913g;
    public c a = new c("udid");
    public c b = new c("oaid");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f20914c = new c("aaid");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f20915d = new c("vaid");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Boolean f20916e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public BroadcastReceiver f20917f;

    public final String a(Context context, c cVar) throws Throwable {
        if (cVar == null) {
            return null;
        }
        if (cVar.a > System.currentTimeMillis()) {
            return cVar.b;
        }
        try {
            Cursor cursorQuery = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{cVar.f20918c}, null);
            if (cursorQuery == null) {
                if (!a(context, false)) {
                    return null;
                }
                a(context, true);
                return null;
            }
            try {
                d dVarA = a(cursorQuery);
                String str = dVarA.a;
                try {
                    cVar.b = str;
                    cVar.a = dVarA.f20919c;
                    if (dVarA.b != 1000) {
                        a(context);
                        if (!a(context, false)) {
                            a(context, true);
                        }
                    }
                    return str;
                } catch (Exception e2) {
                    try {
                        e2.getMessage();
                        return str;
                    } finally {
                        cursorQuery.close();
                    }
                }
            } catch (Exception e3) {
                e3.getMessage();
                return null;
            }
        } catch (Exception e4) {
            e4.getMessage();
            throw null;
        }
    }

    public static d a(Cursor cursor) {
        d dVar = new d(null, 0);
        if (!cursor.isClosed()) {
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex("value");
            if (columnIndex >= 0) {
                dVar.a = cursor.getString(columnIndex);
            }
            int columnIndex2 = cursor.getColumnIndex("code");
            if (columnIndex2 >= 0) {
                dVar.b = cursor.getInt(columnIndex2);
            }
            int columnIndex3 = cursor.getColumnIndex("expired");
            if (columnIndex3 >= 0) {
                dVar.f20919c = cursor.getLong(columnIndex3);
            }
        }
        return dVar;
    }

    public static final a a() {
        if (f20913g == null) {
            synchronized (a.class) {
                f20913g = new a();
            }
        }
        return f20913g;
    }

    public final synchronized void a(Context context) {
        if (this.f20917f == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.meizu.flyme.openid.ACTION_OPEN_ID_CHANGE");
            C0064a c0064a = new C0064a();
            this.f20917f = c0064a;
            context.registerReceiver(c0064a, intentFilter, "com.meizu.flyme.openid.permission.OPEN_ID_CHANGE", null);
        }
    }

    public final boolean a(Context context, boolean z2) throws Throwable {
        Exception e2;
        Cursor cursorQuery;
        String str;
        Boolean bool = this.f20916e;
        if (bool != null && !z2) {
            return bool.booleanValue();
        }
        PackageManager packageManager = context.getPackageManager();
        if (!((packageManager == null || packageManager.resolveContentProvider("com.meizu.flyme.openidsdk", 0) == null) ? false : true)) {
            this.f20916e = Boolean.FALSE;
            return false;
        }
        try {
            try {
                cursorQuery = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"supported"}, null);
                if (cursorQuery != null) {
                    try {
                        str = a(cursorQuery).a;
                        cursorQuery.close();
                    } catch (Exception e22) {
                        try {
                            e22.getMessage();
                            str = null;
                        } finally {
                            try {
                            } catch (Throwable th) {
                                e22 = th;
                                if (cursorQuery != null) {
                                    cursorQuery.close();
                                }
                                throw e22;
                            }
                        }
                    }
                    Boolean boolValueOf = Boolean.valueOf("0".equals(str));
                    this.f20916e = boolValueOf;
                    return boolValueOf.booleanValue();
                }
            } catch (Throwable th2) {
                e22 = th2;
                cursorQuery = null;
            }
        } catch (Exception e3) {
            e3.getMessage();
        }
        return false;
    }
}
