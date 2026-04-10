package miuix.animation.internal;

/* JADX INFO: loaded from: classes8.dex */
public interface BlinkStateSubject {
    void attach(BlinkStateObserver blinkStateObserver);

    void detach(BlinkStateObserver blinkStateObserver);

    void notifyState(boolean z);
}
