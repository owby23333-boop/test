package com.pddstudio.preferences.encrypted;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import com.iflytek.aikit.media.param.MscKeys;
import com.scottyab.aescrypt.AESCrypt;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class EncryptedPreferences {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f7208a = "EncryptedPreferences";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static EncryptedPreferences f7209b;
    private final SharedPreferences c;
    private final String d;
    private final EncryptedEditor e;
    private final Utils f;
    private final boolean g;
    private final List<OnSharedPreferenceChangeListenerImpl> h;

    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f7210a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f7211b;
        private String c;
        private boolean d = false;
        private final List<OnSharedPreferenceChangeListener> e = new ArrayList();

        public Builder(Context context) {
            this.f7210a = context.getApplicationContext();
        }

        public Builder a(String encryptionPassword) {
            this.f7211b = encryptionPassword;
            return this;
        }

        public EncryptedPreferences a() {
            return new EncryptedPreferences(this);
        }

        public Builder b(String preferenceName) {
            this.c = preferenceName;
            return this;
        }
    }

    public final class EncryptedEditor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f7212a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final EncryptedPreferences f7213b;
        private final SharedPreferences.Editor c;

        private EncryptedEditor(EncryptedPreferences encryptedPreferences) {
            this.f7212a = EncryptedEditor.class.getSimpleName();
            this.f7213b = encryptedPreferences;
            this.c = encryptedPreferences.c.edit();
        }

        private SharedPreferences.Editor c() {
            return this.c;
        }

        public EncryptedEditor a(String key, float value) {
            b(key, String.valueOf(value));
            return this;
        }

        public EncryptedEditor b() {
            b("clear() => clearing preferences.");
            c().clear();
            return this;
        }

        private synchronized void b(String logMessage) {
            if (this.f7213b.g) {
                Log.d(this.f7212a, logMessage);
            }
        }

        public EncryptedEditor a(String key, int value) {
            b(key, String.valueOf(value));
            return this;
        }

        private void b(String key, String value) {
            b("putValue() => " + key + " [" + a(key) + "] || " + value + " [" + a(value) + "]");
            c().putString(a(key), a(value));
        }

        public EncryptedEditor a(String key, long value) {
            b(key, String.valueOf(value));
            return this;
        }

        public EncryptedEditor a(String key, String value) {
            b(key, value);
            return this;
        }

        public EncryptedEditor a(String key, boolean value) {
            b(key, String.valueOf(value));
            return this;
        }

        private String a(String value) {
            String strD = this.f7213b.d(value);
            b("encryptValue() => " + strD);
            return strD;
        }

        public void a() {
            c().apply();
        }
    }

    public interface OnSharedPreferenceChangeListener {
        void a(EncryptedPreferences encryptedPreferences, String key);
    }

    public class OnSharedPreferenceChangeListenerImpl implements SharedPreferences.OnSharedPreferenceChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final OnSharedPreferenceChangeListener f7214a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final EncryptedPreferences f7215b;

        private OnSharedPreferenceChangeListenerImpl(EncryptedPreferences encryptedPreferences, OnSharedPreferenceChangeListener listener2) {
            this.f7214a = listener2;
            this.f7215b = encryptedPreferences;
        }

        public OnSharedPreferenceChangeListener a() {
            return this.f7214a;
        }

        @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
            if (!EncryptedPreferences.this.a(this.f7214a)) {
                EncryptedPreferences.this.e("onSharedPreferenceChanged() : couldn't find listener (" + this.f7214a + ")");
                return;
            }
            EncryptedPreferences.this.e("onSharedPreferenceChanged() : found listener " + this.f7214a);
            OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = this.f7214a;
            EncryptedPreferences encryptedPreferences = this.f7215b;
            onSharedPreferenceChangeListener.a(encryptedPreferences, encryptedPreferences.b().a(key));
        }
    }

    public final class Utils {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final EncryptedPreferences f7216a;

        private Utils(EncryptedPreferences encryptedPreferences) {
            this.f7216a = encryptedPreferences;
        }

        public String a(String value) {
            return this.f7216a.b(value);
        }
    }

    private EncryptedPreferences(Builder builder) {
        this.c = TextUtils.isEmpty(builder.c) ? PreferenceManager.getDefaultSharedPreferences(builder.f7210a) : builder.f7210a.getSharedPreferences(builder.c, 0);
        if (TextUtils.isEmpty(builder.f7211b)) {
            throw new RuntimeException("Unable to initialize EncryptedPreferences! Did you forget to set a password using Builder.withEncryptionPassword(encryptionKey) ?");
        }
        this.d = builder.f7211b;
        this.e = new EncryptedEditor(this);
        this.f = new Utils(this);
        this.g = false;
        this.h = new ArrayList();
        if (!builder.e.isEmpty()) {
            Iterator it = builder.e.iterator();
            while (it.hasNext()) {
                b((OnSharedPreferenceChangeListener) it.next());
            }
        }
        f7209b = builder.d ? this : null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String d(String message) {
        try {
            return c(AESCrypt.b(this.d, message));
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void e(String logMessage) {
        if (this.g) {
            Log.d(f7208a, logMessage);
        }
    }

    private String f(String value) {
        String strReplaceAll = value.replaceAll("x0P1Xx", "\\+").replaceAll("x0P2Xx", "/").replaceAll("x0P3Xx", MscKeys.KEY_VAL_SEP);
        e("removeEncoding() : " + value + " => " + strReplaceAll);
        return strReplaceAll;
    }

    public float a(String key, float defaultValue) {
        return ((Float) a(key, Float.valueOf(0.0f), Float.valueOf(defaultValue))).floatValue();
    }

    public Utils b() {
        return this.f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(String message) {
        try {
            return AESCrypt.a(this.d, f(message));
        } catch (GeneralSecurityException unused) {
            return null;
        }
    }

    private String c(String value) {
        String strReplaceAll = value.replaceAll("\\+", "x0P1Xx").replaceAll("/", "x0P2Xx").replaceAll(MscKeys.KEY_VAL_SEP, "x0P3Xx");
        e("encodeCharset() : " + value + " => " + strReplaceAll);
        return strReplaceAll;
    }

    public int a(String key, int defaultValue) {
        return ((Integer) a(key, 0, Integer.valueOf(defaultValue))).intValue();
    }

    private void b(OnSharedPreferenceChangeListener listener2) {
        StringBuilder sb;
        String str;
        if (a(listener2)) {
            sb = new StringBuilder();
            sb.append("registerListener() : ");
            sb.append(listener2);
            str = " is already registered - skip adding.";
        } else {
            OnSharedPreferenceChangeListenerImpl onSharedPreferenceChangeListenerImpl = new OnSharedPreferenceChangeListenerImpl(this, listener2);
            this.c.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListenerImpl);
            this.h.add(onSharedPreferenceChangeListenerImpl);
            sb = new StringBuilder();
            sb.append("registerListener() : interface registered: ");
            sb.append(listener2);
            str = " ";
        }
        sb.append(str);
        e(sb.toString());
    }

    public long a(String key, long defaultValue) {
        return ((Long) a(key, 0L, Long.valueOf(defaultValue))).longValue();
    }

    public EncryptedEditor a() {
        return this.e;
    }

    private <T> Object a(String key, Object type, T defaultType) {
        String strD = d(key);
        e("decryptType() => encryptedKey => " + strD);
        if (TextUtils.isEmpty(strD) || !a(strD)) {
            e("unable to encrypt or find key => " + strD);
            return defaultType;
        }
        String string = this.c.getString(strD, null);
        e("decryptType() => encryptedValue => " + string);
        if (TextUtils.isEmpty(string)) {
            return defaultType;
        }
        String strB = b(string);
        e("decryptType() => orgValue => " + strB);
        if (TextUtils.isEmpty(strB)) {
            return defaultType;
        }
        if (type instanceof String) {
            return strB;
        }
        if (type instanceof Integer) {
            try {
                return Integer.valueOf(Integer.parseInt(strB));
            } catch (NumberFormatException unused) {
                return defaultType;
            }
        }
        if (type instanceof Long) {
            try {
                return Long.valueOf(Long.parseLong(strB));
            } catch (NumberFormatException unused2) {
                return defaultType;
            }
        }
        if (!(type instanceof Float)) {
            return type instanceof Boolean ? Boolean.valueOf(Boolean.parseBoolean(strB)) : defaultType;
        }
        try {
            return Float.valueOf(Float.parseFloat(strB));
        } catch (NumberFormatException unused3) {
            return defaultType;
        }
    }

    public String a(String key, String defaultValue) {
        return (String) a(key, "", defaultValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(OnSharedPreferenceChangeListener changeListener) {
        for (OnSharedPreferenceChangeListenerImpl onSharedPreferenceChangeListenerImpl : this.h) {
            if (changeListener.equals(onSharedPreferenceChangeListenerImpl.a())) {
                e("checkListener() : " + changeListener + " found implementation: " + onSharedPreferenceChangeListenerImpl);
                return true;
            }
        }
        return false;
    }

    private boolean a(String encryptedKey) {
        return this.c.contains(encryptedKey);
    }

    public boolean a(String key, boolean defaultValue) {
        return ((Boolean) a(key, Boolean.valueOf(defaultValue), Boolean.valueOf(defaultValue))).booleanValue();
    }
}
