package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class ab {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile ab f7412a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f76a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private List<t> f77a = new ArrayList();

    private ab(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f76a = applicationContext;
        if (applicationContext == null) {
            this.f76a = context;
        }
    }

    public static ab a(Context context) {
        if (f7412a == null) {
            synchronized (ab.class) {
                if (f7412a == null) {
                    f7412a = new ab(context);
                }
            }
        }
        return f7412a;
    }

    public void b(String str) {
        synchronized (this.f77a) {
            t tVar = new t();
            tVar.f117a = str;
            if (this.f77a.contains(tVar)) {
                Iterator<t> it = this.f77a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    t next = it.next();
                    if (tVar.equals(next)) {
                        tVar = next;
                        break;
                    }
                }
            }
            tVar.f7450a++;
            this.f77a.remove(tVar);
            this.f77a.add(tVar);
        }
    }

    public void c(String str) {
        synchronized (this.f77a) {
            t tVar = new t();
            tVar.f117a = str;
            if (this.f77a.contains(tVar)) {
                this.f77a.remove(tVar);
            }
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m133a(String str) {
        synchronized (this.f77a) {
            t tVar = new t();
            tVar.f7450a = 0;
            tVar.f117a = str;
            if (this.f77a.contains(tVar)) {
                this.f77a.remove(tVar);
            }
            this.f77a.add(tVar);
        }
    }

    public int a(String str) {
        synchronized (this.f77a) {
            t tVar = new t();
            tVar.f117a = str;
            if (this.f77a.contains(tVar)) {
                for (t tVar2 : this.f77a) {
                    if (tVar2.equals(tVar)) {
                        return tVar2.f7450a;
                    }
                }
            }
            return 0;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m134a(String str) {
        synchronized (this.f77a) {
            t tVar = new t();
            tVar.f117a = str;
            return this.f77a.contains(tVar);
        }
    }

    public synchronized String a(aq aqVar) {
        return this.f76a.getSharedPreferences("mipush_extra", 0).getString(aqVar.name(), "");
    }

    public synchronized void a(aq aqVar, String str) {
        SharedPreferences sharedPreferences = this.f76a.getSharedPreferences("mipush_extra", 0);
        sharedPreferences.edit().putString(aqVar.name(), str).apply();
    }
}
