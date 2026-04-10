package com.xiaomi.ad;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.ad.common.util.MLog;
import com.xiaomi.ad.common.util.SharedPreferencesWrapper;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes5.dex */
@SuppressLint({"PrivateApi"})
public class d {
    public static final String f = "MIUIIdentifierManager";
    public static final String g = "android.permission.READ_PRIVILEGED_PHONE_STATE";
    public static volatile d h = null;
    public static final String i = "_m_cfg";
    public static final String j = "oaid";
    public static final String k = "value_read_fail";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f7257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Class<?> f7258b;
    public Method c;
    public SharedPreferencesWrapper d;
    public String e;

    public d(Context context) {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            this.f7258b = cls;
            this.f7257a = cls.newInstance();
        } catch (Exception unused) {
        }
        this.c = a(this.f7258b, "getOAID", Context.class);
        this.e = a(context);
    }

    public static d b(Context context) {
        if (h == null) {
            synchronized (d.class) {
                if (h == null) {
                    h = new d(context.getApplicationContext());
                }
            }
        }
        return h;
    }

    private SharedPreferencesWrapper c(Context context) {
        if (this.d == null) {
            this.d = new SharedPreferencesWrapper(context.getApplicationContext(), i);
        }
        return this.d;
    }

    public String a() {
        return this.e;
    }

    private String a(Context context) {
        if (context == null) {
            return null;
        }
        String string = c(context).getString("oaid", null);
        if (string == null) {
            string = a(context, this.c);
            c(context).putString("oaid", string);
        }
        if (TextUtils.equals(string, k)) {
            return null;
        }
        return string;
    }

    private String a(Context context, Method method) {
        Object obj = this.f7257a;
        if (obj != null && method != null) {
            try {
                Object objInvoke = method.invoke(obj, context);
                if (objInvoke instanceof String) {
                    return (String) objInvoke;
                }
            } catch (Exception e) {
                MLog.e(f, "invoke excepion!", e);
            }
        }
        return k;
    }

    private Method a(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (Exception unused) {
            return null;
        }
    }
}
