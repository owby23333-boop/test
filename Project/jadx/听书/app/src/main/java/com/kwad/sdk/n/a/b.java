package com.kwad.sdk.n.a;

import android.text.TextUtils;
import android.util.Log;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class b extends com.kwad.sdk.core.response.a.a {
    public static final String TAG = "Ranger_b";
    public Object aXq;
    public String aXr;
    public String aXs;
    public boolean aXt;
    public String aXu;
    public C0423b aXv;
    public b aXw;

    public static class a extends com.kwad.sdk.core.response.a.a {
        public List<String> aXA;
        public List<a> aXB = new ArrayList();
        public Object aXC;
        public List<Object> aXD;
        public String aXx;
        public String aXy;
        public String aXz;
        public String className;
        public String fieldName;

        public final Object getValue() {
            if (!TextUtils.isEmpty(this.aXx) || !TextUtils.isEmpty(this.aXz)) {
                return Pd();
            }
            return Pc();
        }

        private Object Pc() {
            Object objGU = null;
            try {
            } catch (Exception e) {
                c.d(b.TAG, Log.getStackTraceString(e));
            }
            if (TextUtils.isEmpty(this.className)) {
                c.w(b.TAG, "SpecialParam className is null");
                return null;
            }
            objGU = z.gU(this.className);
            c.d(b.TAG, "Class.forName(className):" + this.className + " value:" + objGU);
            List<a> list = this.aXB;
            if (list != null && !list.isEmpty()) {
                for (a aVar : this.aXB) {
                    aVar.aXC = objGU;
                    c.d(b.TAG, "param.ob:" + aVar.aXC);
                    try {
                        z.a(aVar.aXC, aVar.fieldName, aVar.getValue());
                    } catch (Exception e2) {
                        c.d(b.TAG, Log.getStackTraceString(e2));
                    }
                }
            }
            c.d(b.TAG, "return value in special:" + objGU);
            return objGU;
        }

        private Object Pd() {
            if (TextUtils.isEmpty(this.aXz)) {
                return ao(this.aXx, this.aXy);
            }
            this.aXD = new ArrayList();
            Iterator<String> it = this.aXA.iterator();
            while (it.hasNext()) {
                Object objAo = ao(this.aXz, it.next());
                if (objAo != null) {
                    this.aXD.add(objAo);
                }
            }
            return this.aXD;
        }

        private static Object ao(String str, String str2) {
            Object objValueOf = null;
            try {
                Class<?> cls = Class.forName(str);
                if (cls == Integer.class) {
                    objValueOf = Integer.valueOf(Integer.parseInt(str2));
                } else if (cls == Long.class) {
                    objValueOf = Long.valueOf(Long.parseLong(str2));
                } else if (cls == Float.class) {
                    objValueOf = Float.valueOf(Float.parseFloat(str2));
                } else if (cls == Boolean.class) {
                    objValueOf = Boolean.valueOf(Boolean.parseBoolean(str2));
                } else if (cls == Double.class) {
                    objValueOf = Double.valueOf(Double.parseDouble(str2));
                } else {
                    if (cls != String.class) {
                        str2 = null;
                    }
                    objValueOf = str2;
                }
            } catch (Exception e) {
                c.w(b.TAG, Log.getStackTraceString(e));
            }
            return objValueOf;
        }
    }

    /* JADX INFO: renamed from: com.kwad.sdk.n.a.b$b, reason: collision with other inner class name */
    public static class C0423b extends com.kwad.sdk.core.response.a.a {
        public boolean aXE;
        public List<a> aXF;
        public Object[] aXG;
        public String name;

        public final Object[] Pe() {
            List<a> list = this.aXF;
            if (list == null || list.isEmpty()) {
                return null;
            }
            Object[] objArr = new Object[this.aXF.size()];
            for (int i = 0; i < this.aXF.size(); i++) {
                objArr[i] = this.aXF.get(i).getValue();
            }
            return objArr;
        }

        public final boolean Pb() {
            if (!TextUtils.isEmpty(this.name)) {
                return false;
            }
            List<a> list = this.aXF;
            return (list == null || list.isEmpty()) && this.aXG == null;
        }
    }

    public final boolean Pb() {
        if (this.aXq != null || !TextUtils.isEmpty(this.aXr) || !TextUtils.isEmpty(this.aXs) || !TextUtils.isEmpty(this.aXu)) {
            return false;
        }
        C0423b c0423b = this.aXv;
        if (c0423b != null && !c0423b.Pb()) {
            return false;
        }
        b bVar = this.aXw;
        return bVar == null || bVar.Pb();
    }
}
