package com.bytedance.sdk.component.vn.d.e;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.yuewen.eq2;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class bf {
    private static ContentResolver bf() {
        try {
            if (e()) {
                return com.bytedance.sdk.component.vn.d.getContext().getContentResolver();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String d() {
        return ga.bf + "/t_sp/";
    }

    public static boolean e() {
        return com.bytedance.sdk.component.vn.d.getContext() != null;
    }

    public static Context getContext() {
        return com.bytedance.sdk.component.vn.d.getContext();
    }

    private static String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return "?sp_file_name=" + str;
    }

    public static synchronized void e(String str, String str2, Boolean bool) {
        if (e()) {
            try {
                ContentResolver contentResolverBf = bf();
                if (contentResolverBf != null) {
                    Uri uri = Uri.parse(d(TypedValues.Custom.S_BOOLEAN, str2, str));
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("value", bool);
                    contentResolverBf.update(uri, contentValues, null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static String bf(String str, String str2, String str3) {
        String type;
        if (!e()) {
            return str3;
        }
        try {
            ContentResolver contentResolverBf = bf();
            if (contentResolverBf != null && (type = contentResolverBf.getType(Uri.parse(d(TypedValues.Custom.S_STRING, str2, str)))) != null && !type.equals(eq2.g)) {
                if (!TextUtils.isEmpty(type)) {
                    return type;
                }
            }
        } catch (Throwable unused) {
        }
        return str3;
    }

    private static String d(String str, String str2, String str3) {
        return d() + str + "/" + str2 + d(str3);
    }

    @TargetApi(11)
    public static Set<String> bf(String str, String str2, Set<String> set) {
        String type;
        if (!e()) {
            return set;
        }
        try {
            ContentResolver contentResolverBf = bf();
            if (contentResolverBf == null || (type = contentResolverBf.getType(Uri.parse(d("string_set", str2, str)))) == null || type.equals(eq2.g) || TextUtils.isEmpty(type) || !type.matches("\\[.*\\]")) {
                return set;
            }
            String[] strArrSplit = type.substring(1, type.length() - 1).split(", ");
            HashSet hashSet = new HashSet();
            for (String str3 : strArrSplit) {
                hashSet.add(str3.replace("__COMMA__", ", "));
            }
            return hashSet;
        } catch (Throwable unused) {
        }
        return set;
    }

    public static synchronized void e(String str, String str2, String str3) {
        if (e()) {
            try {
                ContentResolver contentResolverBf = bf();
                if (contentResolverBf != null) {
                    Uri uri = Uri.parse(d(TypedValues.Custom.S_STRING, str2, str));
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("value", str3);
                    contentResolverBf.update(uri, contentValues, null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static synchronized void e(String str, String str2, Integer num) {
        if (e()) {
            try {
                ContentResolver contentResolverBf = bf();
                if (contentResolverBf != null) {
                    Uri uri = Uri.parse(d("int", str2, str));
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("value", num);
                    contentResolverBf.update(uri, contentValues, null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static Map<String, ?> bf(String str) {
        Cursor cursorQuery;
        Object string;
        if (!e()) {
            return null;
        }
        try {
            ContentResolver contentResolverBf = bf();
            if (contentResolverBf != null) {
                cursorQuery = contentResolverBf.query(Uri.parse(d() + "get_all" + d(str)), null, null, null, null);
                try {
                    HashMap map = new HashMap();
                    if (cursorQuery != null && cursorQuery.moveToFirst()) {
                        int columnIndex = cursorQuery.getColumnIndex("cursor_name");
                        int columnIndex2 = cursorQuery.getColumnIndex("cursor_type");
                        int columnIndex3 = cursorQuery.getColumnIndex("cursor_value");
                        do {
                            String string2 = cursorQuery.getString(columnIndex);
                            String string3 = cursorQuery.getString(columnIndex2);
                            if (string3.equalsIgnoreCase(TypedValues.Custom.S_STRING)) {
                                String string4 = cursorQuery.getString(columnIndex3);
                                boolean zContains = string4.contains("__COMMA__");
                                string = string4;
                                if (zContains) {
                                    boolean zMatches = string4.matches("\\[.*\\]");
                                    string = string4;
                                    if (zMatches) {
                                        String[] strArrSplit = string4.substring(1, string4.length() - 1).split(", ");
                                        HashSet hashSet = new HashSet();
                                        for (String str2 : strArrSplit) {
                                            hashSet.add(str2.replace("__COMMA__", ", "));
                                        }
                                        string = hashSet;
                                    }
                                }
                            } else if (string3.equalsIgnoreCase(TypedValues.Custom.S_BOOLEAN)) {
                                string = cursorQuery.getString(columnIndex3);
                            } else if (string3.equalsIgnoreCase("int")) {
                                string = Integer.valueOf(cursorQuery.getInt(columnIndex3));
                            } else if (string3.equalsIgnoreCase("long")) {
                                string = Long.valueOf(cursorQuery.getLong(columnIndex3));
                            } else if (string3.equalsIgnoreCase("float")) {
                                string = Float.valueOf(cursorQuery.getFloat(columnIndex3));
                            } else {
                                string = string3.equalsIgnoreCase("string_set") ? cursorQuery.getString(columnIndex3) : null;
                            }
                            map.put(string2, string);
                        } while (cursorQuery.moveToNext());
                    }
                    if (cursorQuery != null && !cursorQuery.isClosed()) {
                        cursorQuery.close();
                    }
                    return map;
                } catch (Throwable unused) {
                    if (cursorQuery != null && !cursorQuery.isClosed()) {
                        cursorQuery.close();
                    }
                    return null;
                }
            }
        } catch (Throwable unused2) {
            cursorQuery = null;
        }
        return null;
    }

    public static synchronized void e(String str, String str2, Long l) {
        if (e()) {
            try {
                ContentResolver contentResolverBf = bf();
                if (contentResolverBf != null) {
                    Uri uri = Uri.parse(d("long", str2, str));
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("value", l);
                    contentResolverBf.update(uri, contentValues, null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static synchronized void e(String str, String str2, Float f) {
        if (e()) {
            try {
                ContentResolver contentResolverBf = bf();
                if (contentResolverBf != null) {
                    Uri uri = Uri.parse(d("float", str2, str));
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("value", f);
                    contentResolverBf.update(uri, contentValues, null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static synchronized void e(String str, String str2, Set<String> set) {
        if (e()) {
            try {
                ContentResolver contentResolverBf = bf();
                if (contentResolverBf != null) {
                    Uri uri = Uri.parse(d("string_set", str2, str));
                    ContentValues contentValues = new ContentValues();
                    HashSet hashSet = new HashSet();
                    Iterator<String> it = set.iterator();
                    while (it.hasNext()) {
                        hashSet.add(it.next().replace(",", "__COMMA__"));
                    }
                    contentValues.put("value", hashSet.toString());
                    contentResolverBf.update(uri, contentValues, null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static int e(String str, String str2, int i) {
        String type;
        if (!e()) {
            return i;
        }
        try {
            ContentResolver contentResolverBf = bf();
            if (contentResolverBf != null && (type = contentResolverBf.getType(Uri.parse(d("int", str2, str)))) != null && !type.equals(eq2.g) && !TextUtils.isEmpty(type)) {
                return Integer.parseInt(type);
            }
        } catch (Throwable unused) {
        }
        return i;
    }

    public static float e(String str, String str2, float f) {
        String type;
        if (!e()) {
            return f;
        }
        try {
            ContentResolver contentResolverBf = bf();
            if (contentResolverBf != null && (type = contentResolverBf.getType(Uri.parse(d("float", str2, str)))) != null && !type.equals(eq2.g) && !TextUtils.isEmpty(type)) {
                return Float.parseFloat(type);
            }
        } catch (Throwable unused) {
        }
        return f;
    }

    public static boolean e(String str, String str2, boolean z) {
        String type;
        if (!e()) {
            return z;
        }
        try {
            ContentResolver contentResolverBf = bf();
            if (contentResolverBf != null && (type = contentResolverBf.getType(Uri.parse(d(TypedValues.Custom.S_BOOLEAN, str2, str)))) != null && !type.equals(eq2.g) && !TextUtils.isEmpty(type)) {
                return Boolean.parseBoolean(type);
            }
        } catch (Throwable unused) {
        }
        return z;
    }

    public static long e(String str, String str2, long j) {
        String type;
        if (!e()) {
            return j;
        }
        try {
            ContentResolver contentResolverBf = bf();
            if (contentResolverBf != null && (type = contentResolverBf.getType(Uri.parse(d("long", str2, str)))) != null && !type.equals(eq2.g) && !TextUtils.isEmpty(type)) {
                return Long.parseLong(type);
            }
        } catch (Throwable unused) {
        }
        return j;
    }

    public static void e(String str, String str2) {
        if (e()) {
            try {
                ContentResolver contentResolverBf = bf();
                if (contentResolverBf != null) {
                    contentResolverBf.delete(Uri.parse(d("long", str2, str)), null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void e(String str) {
        if (e()) {
            try {
                ContentResolver contentResolverBf = bf();
                if (contentResolverBf != null) {
                    contentResolverBf.delete(Uri.parse(d() + "clean" + d(str)), null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
