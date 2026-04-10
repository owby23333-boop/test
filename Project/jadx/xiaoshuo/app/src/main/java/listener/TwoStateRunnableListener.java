package listener;

/* JADX INFO: loaded from: classes8.dex */
public abstract class TwoStateRunnableListener<T> extends ComponentListener {
    public void onError() {
    }

    public abstract void onSuccess(T t);

    public void onError(String str) {
    }
}
