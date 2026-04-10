package fm.qingting.qtsdk.c;

import android.content.Context;
import com.pddstudio.preferences.encrypted.EncryptedPreferences;

/* JADX INFO: loaded from: classes8.dex */
public class c {
    public static Object a(Context context, String key, Object defaultObject) {
        try {
            String simpleName = defaultObject.getClass().getSimpleName();
            EncryptedPreferences encryptedPreferencesA = new EncryptedPreferences.Builder(context).b("qt_sp_data").a("qtpassword").a();
            if ("String".equals(simpleName)) {
                return encryptedPreferencesA.a(key, (String) defaultObject);
            }
            if ("Integer".equals(simpleName)) {
                return Integer.valueOf(encryptedPreferencesA.a(key, ((Integer) defaultObject).intValue()));
            }
            if ("Boolean".equals(simpleName)) {
                return Boolean.valueOf(encryptedPreferencesA.a(key, ((Boolean) defaultObject).booleanValue()));
            }
            if ("Float".equals(simpleName)) {
                return Float.valueOf(encryptedPreferencesA.a(key, ((Float) defaultObject).floatValue()));
            }
            if ("Long".equals(simpleName)) {
                return Long.valueOf(encryptedPreferencesA.a(key, ((Long) defaultObject).longValue()));
            }
            return null;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void b(Context context, String key, Object object) {
        String simpleName = object.getClass().getSimpleName();
        EncryptedPreferences.EncryptedEditor encryptedEditorA = new EncryptedPreferences.Builder(context).b("qt_sp_data").a("qtpassword").a().a();
        if ("String".equals(simpleName)) {
            encryptedEditorA.a(key, (String) object);
        } else if ("Integer".equals(simpleName)) {
            encryptedEditorA.a(key, ((Integer) object).intValue());
        } else if ("Boolean".equals(simpleName)) {
            encryptedEditorA.a(key, ((Boolean) object).booleanValue());
        } else if ("Float".equals(simpleName)) {
            encryptedEditorA.a(key, ((Float) object).floatValue());
        } else if ("Long".equals(simpleName)) {
            encryptedEditorA.a(key, ((Long) object).longValue());
        }
        encryptedEditorA.a();
    }

    public static void a(Context context) {
        try {
            new EncryptedPreferences.Builder(context).b("qt_sp_data").a("qtpassword").a().a().b().a();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
