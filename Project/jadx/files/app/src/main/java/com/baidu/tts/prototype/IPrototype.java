package com.baidu.tts.prototype;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public interface IPrototype<T> extends Cloneable, Serializable {
    T deepClone();

    T shallowClone();
}
