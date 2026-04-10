package com.bytedance.sdk.component.e.dl.z;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    public static boolean z() {
        return com.bytedance.sdk.component.e.dl.getContext() != null;
    }

    private static ContentResolver g() {
        try {
            if (z()) {
                return com.bytedance.sdk.component.e.dl.getContext().getContentResolver();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Context getContext() {
        return com.bytedance.sdk.component.e.dl.getContext();
    }

    private static String dl() {
        return gc.g + "/t_sp/";
    }

    private static String dl(String str) {
        return TextUtils.isEmpty(str) ? "" : "?sp_file_name=".concat(String.valueOf(str));
    }

    private static String dl(String str, String str2, String str3) {
        return dl() + str + "/" + str2 + dl(str3);
    }

    public static synchronized void z(String str, String str2, Boolean bool) {
        if (z()) {
            try {
                ContentResolver contentResolverG = g();
                if (contentResolverG != null) {
                    Uri uri = Uri.parse(dl(TypedValues.Custom.S_BOOLEAN, str2, str));
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("value", bool);
                    contentResolverG.update(uri, contentValues, null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static synchronized void z(String str, String str2, String str3) {
        if (z()) {
            try {
                ContentResolver contentResolverG = g();
                if (contentResolverG != null) {
                    Uri uri = Uri.parse(dl(TypedValues.Custom.S_STRING, str2, str));
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("value", str3);
                    contentResolverG.update(uri, contentValues, null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static synchronized void z(String str, String str2, Integer num) {
        if (z()) {
            try {
                ContentResolver contentResolverG = g();
                if (contentResolverG != null) {
                    Uri uri = Uri.parse(dl("int", str2, str));
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("value", num);
                    contentResolverG.update(uri, contentValues, null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static synchronized void z(String str, String str2, Long l) {
        if (z()) {
            try {
                ContentResolver contentResolverG = g();
                if (contentResolverG != null) {
                    Uri uri = Uri.parse(dl("long", str2, str));
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("value", l);
                    contentResolverG.update(uri, contentValues, null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static synchronized void z(String str, String str2, Float f) {
        if (z()) {
            try {
                ContentResolver contentResolverG = g();
                if (contentResolverG != null) {
                    Uri uri = Uri.parse(dl(TypedValues.Custom.S_FLOAT, str2, str));
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("value", f);
                    contentResolverG.update(uri, contentValues, null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static synchronized void z(String str, String str2, Set<String> set) {
        if (z()) {
            try {
                ContentResolver contentResolverG = g();
                if (contentResolverG != null) {
                    Uri uri = Uri.parse(dl("string_set", str2, str));
                    ContentValues contentValues = new ContentValues();
                    HashSet hashSet = new HashSet();
                    Iterator<String> it = set.iterator();
                    while (it.hasNext()) {
                        hashSet.add(it.next().replace(",", "__COMMA__"));
                    }
                    contentValues.put("value", hashSet.toString());
                    contentResolverG.update(uri, contentValues, null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static String g(String str, String str2, String str3) {
        String type;
        if (!z()) {
            return str3;
        }
        try {
            ContentResolver contentResolverG = g();
            if (contentResolverG != null && (type = contentResolverG.getType(Uri.parse(dl(TypedValues.Custom.S_STRING, str2, str)))) != null && !type.equals("null")) {
                if (!TextUtils.isEmpty(type)) {
                    return type;
                }
            }
        } catch (Throwable unused) {
        }
        return str3;
    }

    public static int z(String str, String str2, int i) {
        String type;
        if (!z()) {
            return i;
        }
        try {
            ContentResolver contentResolverG = g();
            if (contentResolverG != null && (type = contentResolverG.getType(Uri.parse(dl("int", str2, str)))) != null && !type.equals("null") && !TextUtils.isEmpty(type)) {
                return Integer.parseInt(type);
            }
        } catch (Throwable unused) {
        }
        return i;
    }

    public static float z(String str, String str2, float f) {
        String type;
        if (!z()) {
            return f;
        }
        try {
            ContentResolver contentResolverG = g();
            if (contentResolverG != null && (type = contentResolverG.getType(Uri.parse(dl(TypedValues.Custom.S_FLOAT, str2, str)))) != null && !type.equals("null") && !TextUtils.isEmpty(type)) {
                return Float.parseFloat(type);
            }
        } catch (Throwable unused) {
        }
        return f;
    }

    public static boolean z(String str, String str2, boolean z) {
        String type;
        if (!z()) {
            return z;
        }
        try {
            ContentResolver contentResolverG = g();
            if (contentResolverG != null && (type = contentResolverG.getType(Uri.parse(dl(TypedValues.Custom.S_BOOLEAN, str2, str)))) != null && !type.equals("null") && !TextUtils.isEmpty(type)) {
                return Boolean.parseBoolean(type);
            }
        } catch (Throwable unused) {
        }
        return z;
    }

    public static long z(String str, String str2, long j) {
        String type;
        if (!z()) {
            return j;
        }
        try {
            ContentResolver contentResolverG = g();
            if (contentResolverG != null && (type = contentResolverG.getType(Uri.parse(dl("long", str2, str)))) != null && !type.equals("null") && !TextUtils.isEmpty(type)) {
                return Long.parseLong(type);
            }
        } catch (Throwable unused) {
        }
        return j;
    }

    public static Set<String> g(String str, String str2, Set<String> set) {
        String type;
        if (!z()) {
            return set;
        }
        try {
            ContentResolver contentResolverG = g();
            if (contentResolverG == null || (type = contentResolverG.getType(Uri.parse(dl("string_set", str2, str)))) == null || type.equals("null") || TextUtils.isEmpty(type) || !type.matches("\\[.*\\]")) {
                return set;
            }
            String strSubstring = type.substring(1, type.length() - 1);
            String[] strArrSplit = strSubstring.split(", ");
            HashSet hashSet = new HashSet();
            if (!TextUtils.isEmpty(strSubstring)) {
                for (String str3 : strArrSplit) {
                    hashSet.add(str3.replace("__COMMA__", ", "));
                }
            }
            return hashSet;
        } catch (Throwable unused) {
        }
        return set;
    }

    public static boolean z(String str, String str2) {
        String type;
        if (!z()) {
            return false;
        }
        try {
            ContentResolver contentResolverG = g();
            if (contentResolverG != null && (type = contentResolverG.getType(Uri.parse(dl("contain", str2, str)))) != null && !type.equals("null") && !TextUtils.isEmpty(type)) {
                return Boolean.parseBoolean(type);
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static void g(String str, String str2) {
        if (z()) {
            try {
                ContentResolver contentResolverG = g();
                if (contentResolverG != null) {
                    contentResolverG.delete(Uri.parse(dl("long", str2, str)), null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void z(String str) {
        if (z()) {
            try {
                ContentResolver contentResolverG = g();
                if (contentResolverG != null) {
                    contentResolverG.delete(Uri.parse(dl() + "clean" + dl(str)), null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static Map<String, ?> g(String str) {
        Cursor cursorQuery;
        Object string;
        if (!z()) {
            return null;
        }
        try {
            ContentResolver contentResolverG = g();
            if (contentResolverG != null) {
                cursorQuery = contentResolverG.query(Uri.parse(dl() + "get_all" + dl(str)), null, null, null, null);
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
                                String str2 = string4;
                                boolean zContains = string4.contains("__COMMA__");
                                string = string4;
                                if (zContains) {
                                    String str3 = string4;
                                    boolean zMatches = string4.matches("\\[.*\\]");
                                    string = string4;
                                    if (zMatches) {
                                        String strSubstring = string4.substring(1, string4.length() - 1);
                                        String[] strArrSplit = strSubstring.split(", ");
                                        HashSet hashSet = new HashSet();
                                        if (!TextUtils.isEmpty(strSubstring)) {
                                            for (String str4 : strArrSplit) {
                                                hashSet.add(str4.replace("__COMMA__", ", "));
                                            }
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
                            } else if (string3.equalsIgnoreCase(TypedValues.Custom.S_FLOAT)) {
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
}
