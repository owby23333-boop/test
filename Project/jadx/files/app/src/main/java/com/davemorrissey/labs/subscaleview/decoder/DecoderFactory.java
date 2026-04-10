package com.davemorrissey.labs.subscaleview.decoder;

import androidx.annotation.NonNull;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes2.dex */
public interface DecoderFactory<T> {
    @NonNull
    T make() throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException;
}
