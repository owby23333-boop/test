package com.anythink.expressad.foundation.h;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class u {
    private static final String a = "SerializeTools";

    private static String a(Object obj) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(obj);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            objectOutputStream.flush();
            objectOutputStream.close();
            return new String(byteArray, "ISO-8859-1");
        } catch (IOException e2) {
            o.b(a, "IOException", e2);
            return "";
        }
    }

    private static Object a(String str) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes("ISO-8859-1"));
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            Object object = objectInputStream.readObject();
            objectInputStream.close();
            byteArrayInputStream.close();
            return object;
        } catch (Exception e2) {
            o.b(a, "Exception", e2);
            return null;
        }
    }
}
