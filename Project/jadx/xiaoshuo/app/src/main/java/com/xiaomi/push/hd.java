package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.duokan.core.io.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes8.dex */
public class hd implements hh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f8028a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private List<hd> f490a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private String[] f491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f8029b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private String[] f492b;
    private String c;

    public hd(String str, String str2, String[] strArr, String[] strArr2) {
        this.f490a = null;
        this.f8028a = str;
        this.f8029b = str2;
        this.f491a = strArr;
        this.f492b = strArr2;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m493a() {
        return this.f8028a;
    }

    public String b() {
        return this.f8029b;
    }

    public String c() {
        return !TextUtils.isEmpty(this.c) ? hr.b(this.c) : this.c;
    }

    @Override // com.xiaomi.push.hh
    public String d() {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        sb.append(this.f8028a);
        if (!TextUtils.isEmpty(this.f8029b)) {
            sb.append(" ");
            sb.append("xmlns=");
            sb.append("\"");
            sb.append(this.f8029b);
            sb.append("\"");
        }
        String[] strArr = this.f491a;
        if (strArr != null && strArr.length > 0) {
            for (int i = 0; i < this.f491a.length; i++) {
                if (!TextUtils.isEmpty(this.f492b[i])) {
                    sb.append(" ");
                    sb.append(this.f491a[i]);
                    sb.append("=\"");
                    sb.append(hr.a(this.f492b[i]));
                    sb.append("\"");
                }
            }
        }
        if (TextUtils.isEmpty(this.c)) {
            List<hd> list = this.f490a;
            if (list == null || list.size() <= 0) {
                sb.append("/>");
            } else {
                sb.append(">");
                Iterator<hd> it = this.f490a.iterator();
                while (it.hasNext()) {
                    sb.append(it.next().d());
                }
                sb.append("</");
                sb.append(this.f8028a);
                sb.append(">");
            }
        } else {
            sb.append(">");
            sb.append(this.c);
            sb.append("</");
            sb.append(this.f8028a);
            sb.append(">");
        }
        return sb.toString();
    }

    public String toString() {
        return d();
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putString("ext_ele_name", this.f8028a);
        bundle.putString("ext_ns", this.f8029b);
        bundle.putString("ext_text", this.c);
        Bundle bundle2 = new Bundle();
        String[] strArr = this.f491a;
        if (strArr != null && strArr.length > 0) {
            int i = 0;
            while (true) {
                String[] strArr2 = this.f491a;
                if (i >= strArr2.length) {
                    break;
                }
                bundle2.putString(strArr2[i], this.f492b[i]);
                i++;
            }
        }
        bundle.putBundle(a.C0200a.C0201a.h, bundle2);
        List<hd> list = this.f490a;
        if (list != null && list.size() > 0) {
            bundle.putParcelableArray("children", a(this.f490a));
        }
        return bundle;
    }

    public hd(String str, String str2, String[] strArr, String[] strArr2, String str3, List<hd> list) {
        this.f8028a = str;
        this.f8029b = str2;
        this.f491a = strArr;
        this.f492b = strArr2;
        this.c = str3;
        this.f490a = list;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public Parcelable m492a() {
        return a();
    }

    public static Parcelable[] a(hd[] hdVarArr) {
        if (hdVarArr == null) {
            return null;
        }
        Parcelable[] parcelableArr = new Parcelable[hdVarArr.length];
        for (int i = 0; i < hdVarArr.length; i++) {
            parcelableArr[i] = hdVarArr[i].m492a();
        }
        return parcelableArr;
    }

    public static Parcelable[] a(List<hd> list) {
        return a((hd[]) list.toArray(new hd[list.size()]));
    }

    public static hd a(Bundle bundle) {
        ArrayList arrayList;
        String string = bundle.getString("ext_ele_name");
        String string2 = bundle.getString("ext_ns");
        String string3 = bundle.getString("ext_text");
        Bundle bundle2 = bundle.getBundle(a.C0200a.C0201a.h);
        Set<String> setKeySet = bundle2.keySet();
        String[] strArr = new String[setKeySet.size()];
        String[] strArr2 = new String[setKeySet.size()];
        int i = 0;
        for (String str : setKeySet) {
            strArr[i] = str;
            strArr2[i] = bundle2.getString(str);
            i++;
        }
        if (bundle.containsKey("children")) {
            Parcelable[] parcelableArray = bundle.getParcelableArray("children");
            ArrayList arrayList2 = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                arrayList2.add(a((Bundle) parcelable));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        return new hd(string, string2, strArr, strArr2, string3, arrayList);
    }

    public String a(String str) {
        if (str != null) {
            if (this.f491a == null) {
                return null;
            }
            int i = 0;
            while (true) {
                String[] strArr = this.f491a;
                if (i >= strArr.length) {
                    return null;
                }
                if (str.equals(strArr[i])) {
                    return this.f492b[i];
                }
                i++;
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void a(hd hdVar) {
        if (this.f490a == null) {
            this.f490a = new ArrayList();
        }
        if (this.f490a.contains(hdVar)) {
            return;
        }
        this.f490a.add(hdVar);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m494a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.c = hr.a(str);
        } else {
            this.c = str;
        }
    }
}
