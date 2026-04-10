package com.baidu.tts.observer;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AObservable implements IObservable {
    protected ArrayList<IObserver> mObserverList = new ArrayList<>();
    private boolean changed = false;

    @Override // com.baidu.tts.observer.IObservable
    public void clearChanged() {
        this.changed = false;
    }

    @Override // com.baidu.tts.observer.IObservable
    public boolean hasChanged() {
        return this.changed;
    }

    @Override // com.baidu.tts.observer.IObservable
    public <T> void notifyObservers(IObservable iObservable, T t2) {
        if (this.changed) {
            for (int i2 = 0; i2 < this.mObserverList.size(); i2++) {
                this.mObserverList.get(i2).update(iObservable, t2);
            }
            this.changed = false;
        }
    }

    @Override // com.baidu.tts.observer.IObservable
    public void registerObserver(IObserver iObserver) {
        if (this.mObserverList.contains(iObserver)) {
            return;
        }
        this.mObserverList.add(iObserver);
    }

    @Override // com.baidu.tts.observer.IObservable
    public void removeObserver(IObserver iObserver) {
        this.mObserverList.remove(iObserver);
    }

    @Override // com.baidu.tts.observer.IObservable
    public void setChanged() {
        this.changed = true;
    }
}
