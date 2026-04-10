package com.qmuiteam.qmui.util;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

/* JADX INFO: loaded from: classes4.dex */
public class QMUIToastHelper {
    private static final String TAG = "QMUIToastHelper";

    public static void show(Toast toast) {
        toast.show();
    }

    private static Toast fixToastForAndroidN(Toast toast) {
        Object fieldValue = QMUIReflectHelper.getFieldValue(toast, "mTN");
        if (fieldValue == null) {
            Log.w(TAG, "The value of field mTN of " + toast + " is null");
            return toast;
        }
        Object fieldValue2 = QMUIReflectHelper.getFieldValue(fieldValue, "mHandler");
        if ((fieldValue2 instanceof Handler) && QMUIReflectHelper.setFieldValue(fieldValue2, "mCallback", new FixCallback((Handler) fieldValue2))) {
            return toast;
        }
        Object fieldValue3 = QMUIReflectHelper.getFieldValue(fieldValue, "mShow");
        if ((fieldValue3 instanceof Runnable) && QMUIReflectHelper.setFieldValue(fieldValue, "mShow", new FixRunnable((Runnable) fieldValue3))) {
            return toast;
        }
        Log.w(TAG, "Neither field mHandler nor mShow of " + fieldValue + " is accessible");
        return toast;
    }

    public static class FixCallback implements Handler.Callback {
        private final Handler mHandler;

        public FixCallback(Handler handler) {
            this.mHandler = handler;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            try {
                this.mHandler.handleMessage(message);
                return true;
            } catch (Throwable unused) {
                return true;
            }
        }
    }

    public static class FixRunnable implements Runnable {
        private final Runnable mRunnable;

        public FixRunnable(Runnable runnable) {
            this.mRunnable = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.mRunnable.run();
            } catch (RuntimeException unused) {
            }
        }
    }
}
