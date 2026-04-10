package com.tramini.plugin.a.i;

import android.net.Uri;
import android.text.TextUtils;
import com.tramini.plugin.a.k.a;
import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public class f {

    final class a implements Runnable {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ String f19358s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        final /* synthetic */ String f19359t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        final /* synthetic */ String[] f19360u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        final /* synthetic */ int f19361v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        final /* synthetic */ ExecutorService f19362w;

        a(String str, String str2, String[] strArr, int i2, ExecutorService executorService) {
            this.f19358s = str;
            this.f19359t = str2;
            this.f19360u = strArr;
            this.f19361v = i2;
            this.f19362w = executorService;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                Matcher matcher = Pattern.compile(this.f19358s, 34).matcher(new a.c(this.f19359t));
                if (matcher.find()) {
                    this.f19360u[0] = matcher.group(this.f19361v);
                }
            } catch (Throwable unused) {
            }
            try {
                synchronized (this.f19362w) {
                    this.f19362w.notifyAll();
                }
            } catch (Throwable unused2) {
            }
        }
    }

    public static class c {
        public static String a(String str, String str2) {
            for (String str3 : str2.split(",")) {
                str = f.c(str, str3.replaceAll("#01;", ","));
            }
            return !TextUtils.isEmpty(str) ? str : "";
        }
    }

    public interface d {
        boolean a(Object obj);

        b b(Object obj);
    }

    public static class e {
        public static String a(String str, String str2) {
            String strC = str;
            for (String str3 : str2.split(",")) {
                if (str3.contains("#")) {
                    String[] strArrSplit = str3.split("#");
                    String str4 = strArrSplit[0];
                    strC = f.c(strC, ".*<" + str4 + ".*?>(.*?" + strArrSplit[1] + ".*?)</" + str4 + ">");
                } else {
                    strC = f.c(strC, "<" + str3 + ".*?>(.*?)</" + str3 + ">");
                }
            }
            if (TextUtils.isEmpty(strC)) {
                return "";
            }
            String strC2 = f.c(strC, "<!\\[CDATA\\[(.*?)\\]\\]>");
            return !TextUtils.isEmpty(strC2) ? strC2 : strC;
        }

        public static String b(String str, String str2) {
            try {
                String strC = f.c(str, "<" + str2 + ">(.*?)</" + str2 + ">");
                if (TextUtils.isEmpty(strC)) {
                    return "";
                }
                String[] strArrSplit = strC.split(":");
                return String.valueOf(Integer.parseInt(strArrSplit[2].substring(0, 2)) + (Integer.parseInt(strArrSplit[1].substring(0, 2)) * 60) + (Integer.parseInt(strArrSplit[0].substring(0, 2)) * 60 * 60));
            } catch (Throwable unused) {
                return "";
            }
        }
    }

    protected static void b(Class cls, List<Method> list) {
        if (cls != null) {
            try {
                if (cls.getName().equals(Object.class.getName())) {
                    return;
                }
                Method[] declaredMethods = cls.getDeclaredMethods();
                if (declaredMethods != null && declaredMethods.length > 0) {
                    list.addAll(Arrays.asList(declaredMethods));
                }
                b(cls.getSuperclass(), list);
            } catch (Throwable unused) {
            }
        }
    }

    public static String c(String str) {
        Properties properties = new Properties();
        try {
            properties.load(new StringReader("unicodedString=".concat(String.valueOf(str))));
        } catch (IOException unused) {
        }
        return properties.getProperty("unicodedString");
    }

    public static String d(String str) {
        try {
            return URLDecoder.decode(str.replaceAll("%(?![0-9a-fA-F]{2})", "%25"), "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return str;
        }
    }

    protected static void a(Class cls, List<Field> list) {
        if (cls != null) {
            try {
                if (cls.getName().equals(Object.class.getName())) {
                    return;
                }
                Field[] declaredFields = cls.getDeclaredFields();
                if (declaredFields != null && declaredFields.length > 0) {
                    list.addAll(Arrays.asList(declaredFields));
                }
                a(cls.getSuperclass(), list);
            } catch (Throwable unused) {
            }
        }
    }

    public static class b {
        public int a;
        public Object b;

        public static b a(Object obj) {
            b bVar = new b();
            bVar.a = 1;
            bVar.b = obj;
            return bVar;
        }

        public static b b(Object obj) {
            b bVar = new b();
            bVar.a = -1;
            bVar.b = obj;
            return bVar;
        }

        public static b a() {
            b bVar = new b();
            bVar.a = 0;
            return bVar;
        }
    }

    protected static Object b(String str, String str2) {
        try {
            return Class.forName(str).getMethod(str2, new Class[0]).invoke(null, new Object[0]);
        } catch (Throwable unused) {
            return null;
        }
    }

    static /* synthetic */ String c(String str, String str2) {
        return b(str, str2, 1);
    }

    protected static Object a(String str, String str2) {
        try {
            Object objInvoke = Class.forName(str).getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            Field[] declaredFields = objInvoke.getClass().getDeclaredFields();
            if (declaredFields != null) {
                for (Field field : declaredFields) {
                    field.setAccessible(true);
                    if (field.get(objInvoke) instanceof Map) {
                        Map map = (Map) field.get(objInvoke);
                        if (map == null) {
                            return null;
                        }
                        Object obj = map.get(str2);
                        if (obj instanceof WeakReference) {
                            return ((WeakReference) obj).get();
                        }
                        return map.get(str2);
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    protected static Object b(Object obj, String str) {
        try {
            Field declaredField = obj.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            String queryParameter = Uri.parse(str).getQueryParameter("adurl");
            return TextUtils.isEmpty(queryParameter) ? "" : a(queryParameter);
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(String str, String str2, int i2) {
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(2);
        String[] strArr = new String[1];
        executorServiceNewFixedThreadPool.submit(new a(str2, str, strArr, i2, executorServiceNewFixedThreadPool));
        try {
            synchronized (executorServiceNewFixedThreadPool) {
                executorServiceNewFixedThreadPool.wait(500L);
            }
            executorServiceNewFixedThreadPool.shutdown();
            return strArr[0] != null ? strArr[0] : "";
        } catch (Exception unused) {
            return "";
        }
    }

    protected static Object a(Object obj, String str) {
        try {
            return obj.getClass().getMethod(str, new Class[0]).invoke(obj, new Object[0]);
        } catch (Throwable unused) {
            return null;
        }
    }

    protected static Object a(Object obj, String str, StringBuffer stringBuffer, d dVar) {
        Object obj2;
        Object objA;
        Object objA2;
        if (dVar != null && obj != null && obj.getClass().getName().startsWith(str)) {
            stringBuffer.append(obj.getClass().getName() + ",");
            try {
                ArrayList<Field> arrayList = new ArrayList();
                for (Class<?> superclass = obj.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
                    arrayList.addAll(Arrays.asList(superclass.getDeclaredFields()));
                }
                if (arrayList.size() != 0) {
                    for (Field field : arrayList) {
                        field.setAccessible(true);
                        Object obj3 = field.get(obj);
                        if (obj3 != null) {
                            if (dVar.a(obj3)) {
                                b bVarB = dVar.b(obj3);
                                int i2 = bVarB.a;
                                if (i2 == 0) {
                                    continue;
                                } else {
                                    if (i2 == 1) {
                                        return bVarB.b;
                                    }
                                    if (i2 == -1 && (obj2 = bVarB.b) != null && !stringBuffer.toString().contains(obj2.getClass().getName()) && (objA = a(obj2, str, stringBuffer, dVar)) != null) {
                                        return objA;
                                    }
                                }
                            } else if (!stringBuffer.toString().contains(obj3.getClass().getName()) && (objA2 = a(obj3, str, stringBuffer, dVar)) != null) {
                                return objA2;
                            }
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static String a(String str) {
        try {
            return TextUtils.isEmpty(str) ? "" : Uri.parse(str).getQueryParameter("id");
        } catch (Throwable unused) {
            return "";
        }
    }
}
