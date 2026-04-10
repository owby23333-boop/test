package com.taobao.aranger.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.util.Pair;
import com.taobao.aranger.ARanger;
import com.taobao.aranger.constant.Constants;
import com.taobao.aranger.intf.ProcessStateListener;
import com.taobao.aranger.logs.IPCLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class CallbackManager {
    private static final String TAG = "CallbackManager";
    private static volatile CallbackManager sInstance;
    private final BroadcastReceiver processStateReceiver = new BroadcastReceiver() { // from class: com.taobao.aranger.utils.CallbackManager.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String stringExtra = intent.getStringExtra(Constants.PARAM_PROCESS_NAME);
            if (Constants.ACTION_DISCONNECT.equals(intent.getAction())) {
                Iterator it = CallbackManager.this.mProcessStateListeners.iterator();
                while (it.hasNext()) {
                    try {
                        ((ProcessStateListener) it.next()).onProcessStop(stringExtra);
                    } catch (Throwable th) {
                        IPCLog.e(CallbackManager.TAG, "[onReceive][onProcessStop]", th, new Object[0]);
                    }
                }
                return;
            }
            Iterator it2 = CallbackManager.this.mProcessStateListeners.iterator();
            while (it2.hasNext()) {
                try {
                    ((ProcessStateListener) it2.next()).onProcessStart(stringExtra);
                } catch (Throwable th2) {
                    IPCLog.e(CallbackManager.TAG, "[onReceive][onProcessStart]", th2, new Object[0]);
                }
            }
        }
    };
    private final IntentFilter intentFilter = new IntentFilter();
    private final ConcurrentHashMap<String, CallbackWrapper> mCallbackWrapperMap = new ConcurrentHashMap<>();
    private final CopyOnWriteArrayList<ProcessStateListener> mProcessStateListeners = new CopyOnWriteArrayList<>();

    private static class CallbackWrapper {
        private final Object mCallback;
        private final boolean mUiThread;

        CallbackWrapper(boolean z2, Object obj, boolean z3) {
            if (z2) {
                this.mCallback = new WeakReference(obj);
            } else {
                this.mCallback = obj;
            }
            this.mUiThread = z3;
        }

        Pair<Boolean, Object> get() {
            Object obj = this.mCallback;
            if (obj instanceof WeakReference) {
                obj = ((WeakReference) obj).get();
            }
            return new Pair<>(Boolean.valueOf(this.mUiThread), obj);
        }
    }

    private CallbackManager() {
        this.intentFilter.addAction(Constants.ACTION_CONNECT);
        this.intentFilter.addAction(Constants.ACTION_DISCONNECT);
    }

    public static CallbackManager getInstance() {
        if (sInstance == null) {
            synchronized (CallbackManager.class) {
                if (sInstance == null) {
                    sInstance = new CallbackManager();
                }
            }
        }
        return sInstance;
    }

    void addCallback(String str, Object obj, boolean z2, boolean z3) {
        this.mCallbackWrapperMap.putIfAbsent(str, new CallbackWrapper(z2, obj, z3));
    }

    public Pair<Boolean, Object> getCallback(String str) {
        CallbackWrapper callbackWrapper = this.mCallbackWrapperMap.get(str);
        if (callbackWrapper == null) {
            return null;
        }
        Pair<Boolean, Object> pair = callbackWrapper.get();
        if (pair.second == null) {
            this.mCallbackWrapperMap.remove(str);
        }
        return pair;
    }

    public void registerProcessStateListener(ProcessStateListener processStateListener) {
        synchronized (this.mProcessStateListeners) {
            if (this.mProcessStateListeners.isEmpty()) {
                ARanger.getContext().registerReceiver(this.processStateReceiver, this.intentFilter);
            }
            this.mProcessStateListeners.add(processStateListener);
        }
    }

    public void removeCallback(String str) {
        this.mCallbackWrapperMap.remove(str);
    }

    public void unRegisterProcessStateListener(ProcessStateListener processStateListener) {
        synchronized (this.mProcessStateListeners) {
            this.mProcessStateListeners.remove(processStateListener);
            if (this.mProcessStateListeners.isEmpty()) {
                ARanger.getContext().unregisterReceiver(this.processStateReceiver);
            }
        }
    }
}
