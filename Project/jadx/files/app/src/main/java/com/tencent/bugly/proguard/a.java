package com.tencent.bugly.proguard;

import com.baidu.mobads.sdk.api.IAdInterListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static String a(ArrayList<String> arrayList) {
        StringBuffer stringBuffer = new StringBuffer();
        int i2 = 0;
        while (true) {
            String str = "map";
            if (i2 >= arrayList.size()) {
                Collections.reverse(arrayList);
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    String str2 = arrayList.get(i3);
                    if (str2.equals("list")) {
                        int i4 = i3 - 1;
                        arrayList.set(i4, "<" + arrayList.get(i4));
                        arrayList.set(0, arrayList.get(0) + ">");
                    } else if (str2.equals("map")) {
                        int i5 = i3 - 1;
                        arrayList.set(i5, "<" + arrayList.get(i5) + ",");
                        arrayList.set(0, arrayList.get(0) + ">");
                    } else if (str2.equals("Array")) {
                        int i6 = i3 - 1;
                        arrayList.set(i6, "<" + arrayList.get(i6));
                        arrayList.set(0, arrayList.get(0) + ">");
                    }
                }
                Collections.reverse(arrayList);
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    stringBuffer.append(it.next());
                }
                return stringBuffer.toString();
            }
            String str3 = arrayList.get(i2);
            if (str3.equals("java.lang.Integer") || str3.equals(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL)) {
                str = "int32";
            } else if (str3.equals("java.lang.Boolean") || str3.equals("boolean")) {
                str = "bool";
            } else if (str3.equals("java.lang.Byte") || str3.equals("byte")) {
                str = "char";
            } else if (str3.equals("java.lang.Double") || str3.equals("double")) {
                str = "double";
            } else if (str3.equals("java.lang.Float") || str3.equals("float")) {
                str = "float";
            } else if (str3.equals("java.lang.Long") || str3.equals("long")) {
                str = "int64";
            } else if (str3.equals("java.lang.Short") || str3.equals("short")) {
                str = "short";
            } else {
                if (str3.equals("java.lang.Character")) {
                    throw new IllegalArgumentException("can not support java.lang.Character");
                }
                if (str3.equals("java.lang.String")) {
                    str = com.anythink.expressad.foundation.h.i.f10649g;
                } else if (str3.equals("java.util.List")) {
                    str = "list";
                } else if (!str3.equals("java.util.Map")) {
                    str = str3;
                }
            }
            arrayList.set(i2, str);
            i2++;
        }
    }
}
