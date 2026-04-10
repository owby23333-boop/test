package com.baidu.tts.observer;

/* JADX INFO: loaded from: classes2.dex */
public interface IObservable {
    void clearChanged();

    boolean hasChanged();

    <T> void notifyObservers(IObservable iObservable, T t2);

    void registerObserver(IObserver iObserver);

    void removeObserver(IObserver iObserver);

    void setChanged();
}
