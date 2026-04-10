package com.taobao.aranger.core.ipc.provider;

import android.os.Binder;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import androidx.annotation.NonNull;
import androidx.core.util.Pair;
import com.taobao.aranger.constant.Constants;
import com.taobao.aranger.core.entity.Callback;
import com.taobao.aranger.core.entity.Reply;
import com.taobao.aranger.core.wrapper.ParameterWrapper;
import com.taobao.aranger.exception.IPCException;
import com.taobao.aranger.intf.IClientService;
import com.taobao.aranger.logs.IPCLog;
import com.taobao.aranger.utils.CallbackManager;
import com.taobao.aranger.utils.IPCThreadCaller;
import com.taobao.aranger.utils.ParameterTransformer;
import com.taobao.aranger.utils.TypeCenter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class ClientServiceProvider extends Binder implements IClientService {
    private static final String TAG = ClientServiceProvider.class.getSimpleName();
    private static volatile ClientServiceProvider sInstance;

    private static class CallbackRunnable implements Runnable {
        private final Object mCallback;
        private final CountDownLatch mCountDownLatch;
        private Exception mException;
        private final Method mMethod;
        private final Object[] mParameters;
        private Object mResult;

        CallbackRunnable(CountDownLatch countDownLatch, Method method, Object obj, Object[] objArr) {
            this.mCountDownLatch = countDownLatch;
            this.mMethod = method;
            this.mCallback = obj;
            this.mParameters = objArr;
        }

        Exception getException() {
            return this.mException;
        }

        Object getResult() {
            return this.mResult;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    this.mResult = this.mMethod.invoke(this.mCallback, this.mParameters);
                } catch (Exception e2) {
                    IPCLog.e(ClientServiceProvider.TAG, "[CallbackRunnable][run]", e2, new Object[0]);
                    this.mException = e2;
                }
            } finally {
                this.mCountDownLatch.countDown();
            }
        }
    }

    private ClientServiceProvider() {
        attachInterface(this, Constants.CLIENT_SERVICE_DESCRIPTOR);
    }

    public static ClientServiceProvider getClientService() {
        if (sInstance == null) {
            synchronized (ClientServiceProvider.class) {
                if (sInstance == null) {
                    sInstance = new ClientServiceProvider();
                }
            }
        }
        return sInstance;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    protected boolean onTransact(int i2, @NonNull Parcel parcel, Parcel parcel2, int i3) {
        if (i2 != 3) {
            if (i2 == 4) {
                final ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
                IPCThreadCaller.execute(new Runnable() { // from class: com.taobao.aranger.core.ipc.provider.ClientServiceProvider.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            ClientServiceProvider.this.recycle(arrayListCreateStringArrayList);
                        } catch (Exception e2) {
                            IPCLog.e(ClientServiceProvider.TAG, "[onTransact][recycle]", e2, new Object[0]);
                        }
                    }
                });
            }
            return true;
        }
        final Callback callbackCreateFromParcel = Callback.CREATOR.createFromParcel(parcel);
        if (i3 == 1) {
            IPCThreadCaller.execute(new Runnable() { // from class: com.taobao.aranger.core.ipc.provider.ClientServiceProvider.1
                @Override // java.lang.Runnable
                public void run() throws IllegalAccessException, InvocationTargetException {
                    ClientServiceProvider.this.sendCallback(callbackCreateFromParcel);
                }
            });
        } else {
            try {
                Reply replySendCallback = sendCallback(callbackCreateFromParcel);
                if (!Constants.VOID.equals(callbackCreateFromParcel.getMethodWrapper().getReturnType()) || replySendCallback.isError() || replySendCallback.getFlowParameterWrappers() != null) {
                    replySendCallback.writeToParcel(parcel2, 0);
                }
            } catch (Exception e2) {
                Reply.obtain().setErrorCode(8).setErrorMessage(e2.getMessage()).writeToParcel(parcel2, i3);
            }
        }
        return true;
    }

    @Override // com.taobao.aranger.intf.IService
    public void recycle(List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            CallbackManager.getInstance().removeCallback(it.next());
        }
    }

    @Override // com.taobao.aranger.intf.IClientService
    public Reply sendCallback(Callback callback) throws IllegalAccessException, InvocationTargetException {
        Object obj;
        Object objInvoke;
        Pair<Boolean, Object> callback2 = CallbackManager.getInstance().getCallback(callback.getKey());
        if (callback2 == null || (obj = callback2.second) == null) {
            return Reply.obtain().setErrorCode(6).setErrorMessage("can't find callback in current process");
        }
        boolean zBooleanValue = callback2.first.booleanValue();
        try {
            ArrayList arrayList = new ArrayList();
            Method method = TypeCenter.getInstance().getMethod(obj.getClass(), callback.getMethodWrapper());
            Object[] objArrUnWrapperParameters = ParameterTransformer.unWrapperParameters(callback.getParameterWrappers(), arrayList);
            boolean z2 = Looper.getMainLooper() == Looper.myLooper();
            ParameterWrapper[] parameterWrapperArr = null;
            if (!(zBooleanValue ^ z2)) {
                try {
                    objInvoke = method.invoke(obj, objArrUnWrapperParameters);
                    e = null;
                } catch (Exception e2) {
                    e = e2;
                    objInvoke = null;
                }
                if (e != null) {
                    e.printStackTrace();
                    throw new IPCException(4, e);
                }
                if (!arrayList.isEmpty()) {
                    parameterWrapperArr = new ParameterWrapper[arrayList.size()];
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        int iIntValue = ((Integer) it.next()).intValue();
                        parameterWrapperArr[iIntValue] = ParameterWrapper.obtain().setData(objArrUnWrapperParameters[((Integer) arrayList.get(iIntValue)).intValue()]);
                    }
                }
                return Reply.obtain().setFlowParameterWrappers(parameterWrapperArr).setResult(objInvoke);
            }
            try {
                CountDownLatch countDownLatch = new CountDownLatch(1);
                CallbackRunnable callbackRunnable = new CallbackRunnable(countDownLatch, method, obj, objArrUnWrapperParameters);
                if (z2) {
                    IPCThreadCaller.execute(callbackRunnable);
                    countDownLatch.await(1L, TimeUnit.SECONDS);
                } else {
                    IPCThreadCaller.post(true, callbackRunnable);
                    countDownLatch.await();
                }
                if (callbackRunnable.getException() != null) {
                    return Reply.obtain().setErrorCode(4).setErrorMessage(callbackRunnable.getException().getMessage());
                }
                if (!arrayList.isEmpty()) {
                    parameterWrapperArr = new ParameterWrapper[arrayList.size()];
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        int iIntValue2 = ((Integer) it2.next()).intValue();
                        parameterWrapperArr[iIntValue2] = ParameterWrapper.obtain().setData(objArrUnWrapperParameters[((Integer) arrayList.get(iIntValue2)).intValue()]);
                    }
                }
                return Reply.obtain().setFlowParameterWrappers(parameterWrapperArr).setResult(callbackRunnable.getResult());
            } catch (Exception e3) {
                return Reply.obtain().setErrorCode(7).setErrorMessage("callback invoke error: " + e3.getMessage());
            }
        } catch (IPCException e4) {
            IPCLog.e(TAG, "[sendCallback]", e4, new Object[0]);
            return Reply.obtain().setErrorCode(e4.getErrorCode()).setErrorMessage(e4.getMessage());
        }
    }
}
