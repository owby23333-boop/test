package de.robv.android.xposed.callbacks;

/* JADX INFO: loaded from: classes5.dex */
public interface IXUnhook<T> {
    T getCallback();

    void unhook();
}
