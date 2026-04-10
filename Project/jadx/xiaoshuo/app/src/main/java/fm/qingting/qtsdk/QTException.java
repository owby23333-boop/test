package fm.qingting.qtsdk;

/* JADX INFO: loaded from: classes8.dex */
public class QTException extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f21019a;

    public QTException(String errorMessage, int errorCode) {
        super(errorMessage);
        setErrorCode(errorCode);
    }

    public int getErrorCode() {
        return this.f21019a;
    }

    public void setErrorCode(int errorCode) {
        this.f21019a = errorCode;
    }

    public QTException(String errorMessage, Throwable throwable) {
        super(errorMessage, throwable);
    }

    public QTException(Throwable throwable) {
        super(throwable);
    }
}
