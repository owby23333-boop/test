package com.bytedance.sdk.openadsdk.ats;

import android.content.Context;
import com.bytedance.sdk.component.a.kb;
import com.bytedance.sdk.component.a.uy;
import com.bytedance.sdk.component.a.wp;
import com.bytedance.sdk.component.m.iq;
import com.bytedance.sdk.component.m.js;
import com.bytedance.sdk.component.m.zw;
import com.bytedance.sdk.openadsdk.core.un.fo;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private gc f908a;
    private List<String> dl;
    private final Map<String, Object> z = new HashMap();
    private final Map<String, Object> g = new HashMap();

    private <T> T z(Class<T> cls) {
        if (cls == js.class) {
            return (T) com.bytedance.sdk.openadsdk.gz.z.z();
        }
        if (cls == Context.class) {
            return (T) com.bytedance.sdk.openadsdk.gz.z.getContext();
        }
        if (cls == iq.class) {
            return (T) com.bytedance.sdk.openadsdk.gz.z.z(com.bytedance.sdk.openadsdk.gz.z.getContext(), com.bytedance.sdk.openadsdk.gz.z.z());
        }
        return null;
    }

    e g(String str) {
        Class cls;
        Class cls2;
        Class cls3;
        switch (str.hashCode()) {
            case -1543207689:
                cls = com.bytedance.sdk.component.a.z.z.class;
                cls2 = fo.class;
                cls3 = com.bytedance.sdk.component.a.z.g.class;
                break;
            case -1535463234:
                cls = kb.class;
                cls2 = gz.class;
                cls3 = wp.class;
                break;
            case -1083272647:
                cls = iq.class;
                cls2 = com.bytedance.sdk.component.m.dl.g.class;
                cls3 = zw.class;
                break;
            case -987979858:
                cls = com.bytedance.sdk.openadsdk.core.sy.dl.class;
                cls2 = com.bytedance.sdk.openadsdk.core.sy.m.class;
                cls3 = com.bytedance.sdk.openadsdk.core.sy.a.class;
                break;
            case 96891546:
                cls = com.bytedance.sdk.component.a.e.class;
                cls2 = com.bytedance.sdk.openadsdk.core.q.dl.class;
                cls3 = com.bytedance.sdk.component.a.gz.class;
                break;
            case 658907061:
                cls = com.bytedance.sdk.component.a.z.class;
                cls2 = g.class;
                cls3 = com.bytedance.sdk.component.a.a.class;
                break;
            case 1209788376:
                cls = com.bytedance.sdk.component.a.fo.class;
                cls2 = a.class;
                cls3 = uy.class;
                break;
            case 1390272937:
                cls = com.bytedance.sdk.component.a.gc.class;
                cls2 = com.bytedance.sdk.openadsdk.core.q.a.class;
                cls3 = com.bytedance.sdk.component.a.m.class;
                break;
            default:
                return null;
        }
        return new e(cls, cls2, cls3, true, 0);
    }

    z() {
    }

    public Map<String, Object> z() {
        return this.z;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public <T> T z(String str) {
        if (str == null) {
            gc gcVar = this.f908a;
            if (gcVar != null) {
                gcVar.z("", (Throwable) new RuntimeException("null key"));
            }
            return null;
        }
        T t = (T) this.z.get(str);
        if (t == null) {
            t = (T) this.g.get(str);
        } else {
            gc gcVar2 = this.f908a;
            if (gcVar2 != null) {
                gcVar2.z(str, t);
            }
        }
        if (t != null) {
            return t;
        }
        e eVarG = g(str);
        if (eVarG == null) {
            gc gcVar3 = this.f908a;
            if (gcVar3 != null) {
                gcVar3.z(str, (Throwable) new RuntimeException("clazz not register"));
            }
            return null;
        }
        return (T) z(str, eVarG);
    }

    private Object z(String str, e eVar) {
        Object objZ = null;
        try {
            if (eVar.f906a) {
                objZ = this.z.get(str);
                if (objZ != null) {
                    return objZ;
                }
                synchronized (eVar.g) {
                    objZ = this.z.get(str);
                    if (objZ == null) {
                        objZ = z((Class<Object>) eVar.g, (Class<Object>) eVar.z);
                        this.z.put(str, objZ);
                    }
                }
                return objZ;
            }
            return z((Class) eVar.g, (Class) eVar.z);
        } catch (Throwable th) {
            gc gcVar = this.f908a;
            if (gcVar == null) {
                return objZ;
            }
            gcVar.z(str, th);
            return objZ;
        }
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    Object z(String str, Object obj) {
        e eVarG = g(str);
        if (eVarG == null) {
            gc gcVar = this.f908a;
            if (gcVar != null) {
                gcVar.z(str, (Throwable) new RuntimeException("reuseservice not register"));
            }
            return null;
        }
        try {
            Object objNewInstance = eVarG.dl.getDeclaredConstructor(Function.class).newInstance(obj);
            if (eVarG.f906a) {
                this.z.put(str, objNewInstance);
            }
            return objNewInstance;
        } catch (Exception e) {
            gc gcVar2 = this.f908a;
            if (gcVar2 != null) {
                gcVar2.z(eVarG.z.getName(), eVarG.g.getName(), "reuse failed", e);
            }
            return null;
        }
    }

    private <T> T z(Class<T> cls, Class<T> cls2) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        T t = (T) z(cls2);
        if (t != null) {
            return t;
        }
        T t2 = (T) z(cls);
        if (t2 != null) {
            return t2;
        }
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        if (declaredConstructors.length > 0) {
            Constructor<?> constructor = declaredConstructors[0];
            try {
                constructor.setAccessible(true);
            } catch (Exception unused) {
            }
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            if (parameterTypes.length != 0) {
                Object[] objArr = new Object[parameterTypes.length];
                for (int i = 0; i < parameterTypes.length; i++) {
                    Object objZ = z(parameterTypes[i]);
                    if (objZ == null) {
                        throw new RuntimeException("params type " + parameterTypes[i] + "  for " + cls + " not config!");
                    }
                    objArr[i] = objZ;
                }
                return (T) constructor.newInstance(objArr);
            }
        }
        return cls.newInstance();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    void z(String str, Object obj, int i) {
        e eVarG = g(str);
        if (eVarG == null || obj == null || eVarG.gc > i) {
            return;
        }
        List<String> list = this.dl;
        if (list == null || !list.contains(str)) {
            try {
                Object objNewInstance = eVarG.dl.getDeclaredConstructor(Function.class).newInstance(obj);
                this.g.put(str, objNewInstance);
                gc gcVar = this.f908a;
                if (gcVar != null) {
                    gcVar.g(str, objNewInstance);
                }
            } catch (Exception e) {
                gc gcVar2 = this.f908a;
                if (gcVar2 != null) {
                    gcVar2.z(eVarG.z.getName(), eVarG.g.getName(), "reuse failed", e);
                }
            }
        }
    }
}
