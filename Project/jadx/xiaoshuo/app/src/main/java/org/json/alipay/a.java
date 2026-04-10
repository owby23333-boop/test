package org.json.alipay;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: loaded from: classes9.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ArrayList f21192a;

    public a() {
        this.f21192a = new ArrayList();
    }

    public int a() {
        return this.f21192a.size();
    }

    public Object b(int i) {
        if (i < 0 || i >= a()) {
            return null;
        }
        return this.f21192a.get(i);
    }

    public String toString() {
        try {
            return '[' + a(",") + ']';
        } catch (Exception unused) {
            return null;
        }
    }

    public a(Object obj) throws JSONException {
        this();
        if (!obj.getClass().isArray()) {
            throw new JSONException("JSONArray initial value should be a string or collection or array.");
        }
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            a(Array.get(obj, i));
        }
    }

    public Object a(int i) throws JSONException {
        Object objB = b(i);
        if (objB != null) {
            return objB;
        }
        throw new JSONException("JSONArray[" + i + "] not found.");
    }

    public a(String str) {
        this(new c(str));
    }

    public String a(String str) {
        int iA = a();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < iA; i++) {
            if (i > 0) {
                stringBuffer.append(str);
            }
            stringBuffer.append(b.b(this.f21192a.get(i)));
        }
        return stringBuffer.toString();
    }

    public a(Collection collection) {
        this.f21192a = collection == null ? new ArrayList() : new ArrayList(collection);
    }

    public a a(Object obj) {
        this.f21192a.add(obj);
        return this;
    }

    public a(c cVar) throws JSONException {
        char c;
        ArrayList arrayList;
        Object objD;
        this();
        char c2 = cVar.c();
        if (c2 == '[') {
            c = ']';
        } else {
            if (c2 != '(') {
                throw cVar.a("A JSONArray text must start with '['");
            }
            c = ')';
        }
        if (cVar.c() == ']') {
            return;
        }
        do {
            cVar.a();
            char c3 = cVar.c();
            cVar.a();
            if (c3 == ',') {
                arrayList = this.f21192a;
                objD = null;
            } else {
                arrayList = this.f21192a;
                objD = cVar.d();
            }
            arrayList.add(objD);
            char c4 = cVar.c();
            if (c4 != ')') {
                if (c4 != ',' && c4 != ';') {
                    if (c4 != ']') {
                        throw cVar.a("Expected a ',' or ']'");
                    }
                }
            }
            if (c == c4) {
                return;
            }
            throw cVar.a("Expected a '" + new Character(c) + "'");
        } while (cVar.c() != ']');
    }
}
