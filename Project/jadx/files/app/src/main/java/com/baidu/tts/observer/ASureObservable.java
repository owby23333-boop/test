package com.baidu.tts.observer;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ASureObservable extends AObservable {
    @Override // com.baidu.tts.observer.AObservable, com.baidu.tts.observer.IObservable
    public <T> void notifyObservers(IObservable iObservable, T t2) {
        setChanged();
        super.notifyObservers(iObservable, t2);
    }
}
