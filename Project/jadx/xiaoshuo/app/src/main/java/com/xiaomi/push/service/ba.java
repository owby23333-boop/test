package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Pair;
import com.xiaomi.push.ig;
import com.xiaomi.push.ih;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class ba {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile ba f8231a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    protected SharedPreferences f969a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private HashSet<a> f970a = new HashSet<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected SharedPreferences f8232b;

    public static abstract class a implements Runnable {
        private String mDescription;
        private int mId;

        public a(int i, String str) {
            this.mId = i;
            this.mDescription = str;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && this.mId == ((a) obj).mId;
        }

        public int hashCode() {
            return this.mId;
        }

        public abstract void onCallback();

        @Override // java.lang.Runnable
        public final void run() {
            onCallback();
        }
    }

    private ba(Context context) {
        this.f969a = context.getSharedPreferences("mipush_oc_normal", 0);
        this.f8232b = context.getSharedPreferences("mipush_oc_custom", 0);
    }

    public synchronized void a(a aVar) {
        if (!this.f970a.contains(aVar)) {
            this.f970a.add(aVar);
        }
    }

    public void b() {
        com.xiaomi.channel.commonutils.logger.b.c("OC_Callback : receive new oc data");
        HashSet<a> hashSet = new HashSet();
        synchronized (this) {
            hashSet.addAll(this.f970a);
        }
        for (a aVar : hashSet) {
            if (aVar != null) {
                aVar.run();
            }
        }
        hashSet.clear();
    }

    public synchronized void a() {
        this.f970a.clear();
    }

    public static ba a(Context context) {
        if (f8231a == null) {
            synchronized (ba.class) {
                if (f8231a == null) {
                    f8231a = new ba(context);
                }
            }
        }
        return f8231a;
    }

    public void a(List<Pair<ih, Integer>> list, List<Pair<Integer, Object>> list2) {
        if (!com.xiaomi.push.ab.a(list) && !com.xiaomi.push.ab.a(list2)) {
            SharedPreferences.Editor editorEdit = this.f969a.edit();
            editorEdit.clear();
            for (Pair<ih, Integer> pair : list) {
                Object obj = pair.first;
                if (obj != null && pair.second != null) {
                    editorEdit.putInt(a((ih) obj), ((Integer) pair.second).intValue());
                }
            }
            for (Pair<Integer, Object> pair2 : list2) {
                Object obj2 = pair2.first;
                if (obj2 != null && pair2.second != null) {
                    a(editorEdit, pair2, a(((Integer) obj2).intValue()));
                }
            }
            editorEdit.apply();
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m106a("not update oc, because versions or configs are empty");
    }

    public void a(List<Pair<Integer, Object>> list) {
        if (com.xiaomi.push.ab.a(list)) {
            return;
        }
        SharedPreferences.Editor editorEdit = this.f8232b.edit();
        for (Pair<Integer, Object> pair : list) {
            Object obj = pair.first;
            if (obj != null) {
                String strA = a(((Integer) obj).intValue());
                if (pair.second == null) {
                    editorEdit.remove(strA);
                } else {
                    a(editorEdit, pair, strA);
                }
            }
        }
        editorEdit.apply();
    }

    private void a(SharedPreferences.Editor editor, Pair<Integer, Object> pair, String str) {
        Object obj = pair.second;
        if (obj instanceof Integer) {
            editor.putInt(str, ((Integer) obj).intValue());
            return;
        }
        if (obj instanceof Long) {
            editor.putLong(str, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof String) {
            String str2 = (String) obj;
            if (str.equals(a(ig.AppIsInstalledList.a()))) {
                editor.putString(str, com.xiaomi.push.bl.a(str2));
                return;
            } else {
                editor.putString(str, str2);
                return;
            }
        }
        if (obj instanceof Boolean) {
            editor.putBoolean(str, ((Boolean) obj).booleanValue());
        }
    }

    public int a(int i, int i2) {
        try {
            String strA = a(i);
            if (this.f8232b.contains(strA)) {
                return this.f8232b.getInt(strA, 0);
            }
            return this.f969a.contains(strA) ? this.f969a.getInt(strA, 0) : i2;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m106a(i + " oc int error " + e);
            return i2;
        }
    }

    public long a(int i, long j) {
        try {
            String strA = a(i);
            if (this.f8232b.contains(strA)) {
                return this.f8232b.getLong(strA, 0L);
            }
            return this.f969a.contains(strA) ? this.f969a.getLong(strA, 0L) : j;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m106a(i + " oc long error " + e);
            return j;
        }
    }

    public String a(int i, String str) {
        try {
            String strA = a(i);
            if (this.f8232b.contains(strA)) {
                return this.f8232b.getString(strA, null);
            }
            return this.f969a.contains(strA) ? this.f969a.getString(strA, null) : str;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m106a(i + " oc string error " + e);
            return str;
        }
    }

    public boolean a(int i, boolean z) {
        try {
            String strA = a(i);
            if (this.f8232b.contains(strA)) {
                return this.f8232b.getBoolean(strA, false);
            }
            return this.f969a.contains(strA) ? this.f969a.getBoolean(strA, false) : z;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m106a(i + " oc boolean error " + e);
            return z;
        }
    }

    public int a(ih ihVar, int i) {
        try {
            return this.f969a.getInt(a(ihVar), i);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m106a(ihVar + " version error " + e);
            return i;
        }
    }

    private String a(int i) {
        return "oc_" + i;
    }

    private String a(ih ihVar) {
        return "oc_version_" + ihVar.a();
    }
}
