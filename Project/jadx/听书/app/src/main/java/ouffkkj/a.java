package ouffkkj;

import bdrfccth.b;
import bdrfccth.e;
import java.util.HashMap;

/* JADX INFO: loaded from: classes5.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Class[] f2564a = {Byte.TYPE, Short.TYPE, Character.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE};

    public static float a(Class[] clsArr, Class[] clsArr2) {
        float f;
        float f2;
        float f3 = 0.0f;
        for (int i = 0; i < clsArr.length; i++) {
            Class superclass = clsArr[i];
            Class cls = clsArr2[i];
            if (cls.isPrimitive()) {
                if (superclass.isPrimitive()) {
                    f = 0.0f;
                } else {
                    superclass = (Class) b.b.get(superclass);
                    f = 0.1f;
                }
                int i2 = 0;
                while (superclass != cls) {
                    Class[] clsArr3 = f2564a;
                    if (i2 < 7) {
                        if (superclass == clsArr3[i2]) {
                            f += 0.1f;
                            if (i2 < 6) {
                                superclass = clsArr3[i2 + 1];
                            }
                        }
                        i2++;
                    }
                }
            } else {
                f = 0.0f;
                while (true) {
                    if (superclass != null && !cls.equals(superclass)) {
                        if (cls.isInterface()) {
                            HashMap map = b.f65a;
                            switch (e.d) {
                                case 1:
                                case 6:
                                    f2 = 1.5f;
                                    break;
                                case 2:
                                    f2 = 1.1f;
                                    break;
                                case 3:
                                    f2 = 1.2f;
                                    break;
                                case 4:
                                    f2 = 1.3f;
                                    break;
                                case 5:
                                    f2 = 1.4f;
                                    break;
                                case 7:
                                    f2 = 1.6f;
                                    break;
                                case 8:
                                    f2 = 1.7f;
                                    break;
                                case 9:
                                    f2 = 1.8f;
                                    break;
                                default:
                                    throw null;
                            }
                            if (b.a(superclass, cls, f2 >= 1.5f)) {
                                f += 0.25f;
                            }
                        }
                        f += 1.0f;
                        superclass = superclass.getSuperclass();
                    }
                }
                if (superclass == null) {
                    f += 1.5f;
                }
            }
            f3 += f;
        }
        return f3;
    }
}
