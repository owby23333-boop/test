package com.baidu.tts.chainofresponsibility.logger;

import com.baidu.tts.factory.base.NameThreadFactory;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes2.dex */
public class LoggerChain {
    private static final String TAG = "LoggerChain";
    private static volatile LoggerChain mInstance;
    private ExecutorService mExecutorService;
    private PrintLogger mPrintLogger = new PrintLogger();
    private LoggerMode mLoggerMode = LoggerMode.RELEASE;
    private boolean isPrint = false;
    private List<ILoggerHandler> mHandlers = toResolveConcurrentModificationException();
    private StorageLoggerHandler mStorageLoggerHandler = new StorageLoggerHandler();

    /* JADX INFO: renamed from: com.baidu.tts.chainofresponsibility.logger.LoggerChain$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$tts$chainofresponsibility$logger$LoggerChain$LoggerMode = new int[LoggerMode.values().length];

        static {
            try {
                $SwitchMap$com$baidu$tts$chainofresponsibility$logger$LoggerChain$LoggerMode[LoggerMode.DEVELOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$tts$chainofresponsibility$logger$LoggerChain$LoggerMode[LoggerMode.RELEASE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private enum LoggerMode {
        DEVELOP,
        RELEASE
    }

    private class LoggerWork implements Runnable {
        private LoggerBean mLoggerBean;

        public LoggerWork(LoggerBean loggerBean) {
            this.mLoggerBean = loggerBean;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = LoggerChain.this.mHandlers.iterator();
            while (it.hasNext()) {
                ((ILoggerHandler) it.next()).handle(this.mLoggerBean, null, LoggerChain.mInstance);
            }
        }
    }

    private LoggerChain() {
        this.mHandlers.add(this.mStorageLoggerHandler);
        this.mExecutorService = Executors.newSingleThreadExecutor(new NameThreadFactory("bdtts-LoggerChainPoolThread"));
    }

    private void executeWork(LoggerBean loggerBean) {
        try {
            if (this.mExecutorService == null || this.mExecutorService.isShutdown()) {
                return;
            }
            this.mExecutorService.execute(new LoggerWork(loggerBean));
        } catch (Exception e2) {
            String str = "executeWork exception=" + e2.toString();
        }
    }

    public static LoggerChain getInstance() {
        if (mInstance == null) {
            synchronized (LoggerChain.class) {
                if (mInstance == null) {
                    mInstance = new LoggerChain();
                }
            }
        }
        return mInstance;
    }

    private List<ILoggerHandler> toResolveConcurrentModificationException() {
        List<ILoggerHandler> list = this.mHandlers;
        return list == null ? new CopyOnWriteArrayList() : list;
    }

    public void addHandler(ILoggerHandler iLoggerHandler) {
        List<ILoggerHandler> list = this.mHandlers;
        if (list == null || list.contains(iLoggerHandler)) {
            return;
        }
        this.mHandlers.add(iLoggerHandler);
    }

    public void addPrintString(String str) {
        PrintLogger printLogger = this.mPrintLogger;
        if (printLogger != null) {
            printLogger.addPrintString(str);
        }
    }

    public void addPrintStrings(List<String> list) {
        PrintLogger printLogger = this.mPrintLogger;
        if (printLogger != null) {
            printLogger.addPrintStrings(list);
        }
    }

    public void addUnPrintString(String str) {
        PrintLogger printLogger = this.mPrintLogger;
        if (printLogger != null) {
            printLogger.addUnPrintString(str);
        }
    }

    public void addUnPrintStrings(List<String> list) {
        PrintLogger printLogger = this.mPrintLogger;
        if (printLogger != null) {
            printLogger.addUnPrintStrings(list);
        }
    }

    public void clearHandler() {
        List<ILoggerHandler> list = this.mHandlers;
        if (list != null) {
            list.clear();
        }
    }

    public void clearSpecifyStrings() {
        PrintLogger printLogger = this.mPrintLogger;
        if (printLogger != null) {
            printLogger.clear();
        }
    }

    public boolean isModeRelease() {
        LoggerMode loggerMode = this.mLoggerMode;
        return loggerMode == null || loggerMode == LoggerMode.RELEASE;
    }

    public void log(int i2, String str, String str2) {
        log(new LoggerBean(), i2, str, str2);
    }

    public void printable(boolean z2) {
        this.isPrint = z2;
    }

    public void removeHandler(ILoggerHandler iLoggerHandler) {
        List<ILoggerHandler> list = this.mHandlers;
        if (list != null) {
            list.remove(iLoggerHandler);
        }
    }

    public void setModeRelease() {
        this.mLoggerMode = LoggerMode.RELEASE;
    }

    private void log(LoggerBean loggerBean, int i2, String str, String str2) {
        if (loggerBean == null) {
            loggerBean = new LoggerBean();
        }
        loggerBean.setLevel(i2);
        loggerBean.setTag(str);
        loggerBean.setMessage(str2);
        log(loggerBean);
    }

    public void log(LoggerBean loggerBean) {
        if (loggerBean != null) {
            int i2 = AnonymousClass1.$SwitchMap$com$baidu$tts$chainofresponsibility$logger$LoggerChain$LoggerMode[this.mLoggerMode.ordinal()];
            if (i2 != 1) {
                if (i2 == 2 && this.isPrint) {
                    this.mPrintLogger.print(loggerBean, null, mInstance);
                }
            } else {
                loggerBean.setLevel(6);
                this.mPrintLogger.print(loggerBean, null, mInstance);
            }
            executeWork(loggerBean);
        }
    }
}
