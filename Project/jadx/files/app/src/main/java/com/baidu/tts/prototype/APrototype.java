package com.baidu.tts.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/* JADX INFO: loaded from: classes2.dex */
public abstract class APrototype<T> implements IPrototype<T> {
    private static final long serialVersionUID = 4287291866065118635L;

    @Override // com.baidu.tts.prototype.IPrototype
    public T deepClone() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new ObjectOutputStream(byteArrayOutputStream).writeObject(this);
            return (T) new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray())).readObject();
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        } catch (ClassNotFoundException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    @Override // com.baidu.tts.prototype.IPrototype
    public T shallowClone() {
        try {
            return (T) super.clone();
        } catch (CloneNotSupportedException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
