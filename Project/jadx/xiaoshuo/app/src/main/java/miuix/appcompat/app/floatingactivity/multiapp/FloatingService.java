package miuix.appcompat.app.floatingactivity.multiapp;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import miuix.appcompat.app.floatingactivity.multiapp.IFloatingService;

/* JADX INFO: loaded from: classes7.dex */
public class FloatingService extends Service {
    private static final String TAG = "FloatingService";
    private final RemoteCallbackList<IServiceNotify> mServiceNotify = new RemoteCallbackList<>();
    private final SparseArray<LinkedList<String>> mNotifyIdentity = new SparseArray<>();
    private final ConcurrentHashMap<String, Integer> mServiceNotifyMap = new ConcurrentHashMap<>();
    private final IFloatingService mBinder = new IFloatingService.Stub() { // from class: miuix.appcompat.app.floatingactivity.multiapp.FloatingService.1
        /* JADX WARN: Removed duplicated region for block: B:12:0x0022  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private android.util.Pair<java.lang.String, java.lang.Integer> parseIdentity(java.lang.String r5) {
            /*
                r4 = this;
                boolean r0 = android.text.TextUtils.isEmpty(r5)
                r1 = 0
                if (r0 != 0) goto L22
                java.lang.String r0 = ":"
                java.lang.String[] r5 = r5.split(r0)
                int r0 = r5.length
                r2 = 1
                if (r0 != r2) goto L14
                r5 = r5[r1]
                goto L23
            L14:
                int r0 = r5.length
                r3 = 2
                if (r0 < r3) goto L22
                r0 = r5[r1]
                r5 = r5[r2]     // Catch: java.lang.Exception -> L20
                int r1 = java.lang.Integer.parseInt(r5)     // Catch: java.lang.Exception -> L20
            L20:
                r5 = r0
                goto L23
            L22:
                r5 = 0
            L23:
                miuix.appcompat.app.floatingactivity.multiapp.FloatingService r0 = miuix.appcompat.app.floatingactivity.multiapp.FloatingService.this
                int r0 = miuix.appcompat.app.floatingactivity.multiapp.FloatingService.access$800(r0, r1)
                android.util.Pair r1 = new android.util.Pair
                java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
                r1.<init>(r5, r0)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: miuix.appcompat.app.floatingactivity.multiapp.FloatingService.AnonymousClass1.parseIdentity(java.lang.String):android.util.Pair");
        }

        @Override // miuix.appcompat.app.floatingactivity.multiapp.IFloatingService
        public Bundle callServiceMethod(int i, Bundle bundle) throws RemoteException {
            Bundle bundle2 = new Bundle();
            if (i == 6) {
                bundle2.putInt(String.valueOf(6), FloatingService.this.getPageCount(bundle != null ? bundle.getInt(MethodCodeHelper.KEY_TASK_ID, 0) : 0));
            } else if (i != 7) {
                String string = null;
                if (i == 9) {
                    if (bundle != null) {
                        i = bundle.getInt(MethodCodeHelper.KEY_TASK_ID, 0);
                        string = bundle.getString(MethodCodeHelper.KEY_REQUEST_IDENTITY);
                    }
                    bundle2.putBoolean(MethodCodeHelper.METHOD_RESULT_CHECK_FINISHNING, FloatingService.this.checkFinishing(i, string, i));
                } else if (i != 10) {
                    FloatingService.this.onMethodCall(i);
                } else {
                    if (bundle != null) {
                        i = bundle.getInt(MethodCodeHelper.KEY_TASK_ID, 0);
                        string = bundle.getString(MethodCodeHelper.METHOD_EXECUTE_SLIDE);
                    }
                    FloatingService.this.notifyPreviousSlide(i, string, i);
                }
            } else {
                String strFindPreviousIdentity = FloatingService.this.findPreviousIdentity(bundle.getString(MethodCodeHelper.KEY_REQUEST_IDENTITY), bundle.getInt(MethodCodeHelper.KEY_TASK_ID, 0));
                int iBeginBroadcast = FloatingService.this.mServiceNotify.beginBroadcast();
                while (true) {
                    if (i >= iBeginBroadcast) {
                        break;
                    }
                    if (TextUtils.equals(strFindPreviousIdentity, FloatingService.this.mServiceNotify.getBroadcastCookie(i).toString())) {
                        ((IServiceNotify) FloatingService.this.mServiceNotify.getBroadcastItem(i)).notifyFromService(8, bundle);
                        break;
                    }
                    i++;
                }
                FloatingService.this.mServiceNotify.finishBroadcast();
            }
            return bundle2;
        }

        @Override // miuix.appcompat.app.floatingactivity.multiapp.IFloatingService
        public int registerServiceNotify(IServiceNotify iServiceNotify, String str) throws RemoteException {
            Pair<String, Integer> identity = parseIdentity(str);
            String str2 = (String) identity.first;
            int iIntValue = ((Integer) identity.second).intValue();
            LinkedList linkedList = (LinkedList) FloatingService.this.mNotifyIdentity.get(iIntValue);
            if (linkedList == null) {
                linkedList = new LinkedList();
                FloatingService.this.mNotifyIdentity.put(iIntValue, linkedList);
            } else {
                linkedList.remove(str2);
            }
            FloatingService.this.mServiceNotify.unregister(iServiceNotify);
            int registeredCallbackCount = FloatingService.this.mServiceNotify.getRegisteredCallbackCount();
            FloatingService.this.mServiceNotify.register(iServiceNotify, str2);
            linkedList.add(str2);
            return registeredCallbackCount;
        }

        @Override // miuix.appcompat.app.floatingactivity.multiapp.IFloatingService
        public void unregisterServiceNotify(IServiceNotify iServiceNotify, String str) throws RemoteException {
            Pair<String, Integer> identity = parseIdentity(str);
            String str2 = (String) identity.first;
            int iIntValue = ((Integer) identity.second).intValue();
            LinkedList linkedList = (LinkedList) FloatingService.this.mNotifyIdentity.get(iIntValue);
            if (linkedList != null) {
                linkedList.remove(str2);
                if (linkedList.isEmpty()) {
                    FloatingService.this.mNotifyIdentity.remove(iIntValue);
                }
            }
            FloatingService.this.mServiceNotify.unregister(iServiceNotify);
            FloatingService.this.mServiceNotifyMap.remove(str2);
        }

        @Override // miuix.appcompat.app.floatingactivity.multiapp.IFloatingService
        public void upDateRemoteActivityInfo(String str, int i) throws RemoteException {
            FloatingService.this.mServiceNotifyMap.put((String) parseIdentity(str).first, Integer.valueOf(i));
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0034, code lost:
    
        r0 = ((miuix.appcompat.app.floatingactivity.multiapp.IServiceNotify) r3.mServiceNotify.getBroadcastItem(r6)).notifyFromService(r4, null).getBoolean(miuix.appcompat.app.floatingactivity.multiapp.MethodCodeHelper.METHOD_RESULT_CHECK_FINISHNING);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean checkFinishing(int r4, java.lang.String r5, int r6) throws android.os.RemoteException {
        /*
            r3 = this;
            r0 = 0
            if (r5 != 0) goto L4
            return r0
        L4:
            android.os.RemoteCallbackList<miuix.appcompat.app.floatingactivity.multiapp.IServiceNotify> r1 = r3.mServiceNotify     // Catch: java.lang.Throwable -> L39 android.os.RemoteException -> L3b
            int r1 = r1.beginBroadcast()     // Catch: java.lang.Throwable -> L39 android.os.RemoteException -> L3b
            java.lang.String r5 = r3.findNextIdentity(r5, r6)     // Catch: java.lang.Throwable -> L39 android.os.RemoteException -> L3b
            r6 = r0
        Lf:
            if (r6 >= r1) goto L43
            android.os.RemoteCallbackList<miuix.appcompat.app.floatingactivity.multiapp.IServiceNotify> r2 = r3.mServiceNotify     // Catch: java.lang.Throwable -> L39 android.os.RemoteException -> L3b
            java.lang.Object r2 = r2.getBroadcastCookie(r6)     // Catch: java.lang.Throwable -> L39 android.os.RemoteException -> L3b
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L39 android.os.RemoteException -> L3b
            boolean r2 = android.text.TextUtils.equals(r5, r2)     // Catch: java.lang.Throwable -> L39 android.os.RemoteException -> L3b
            if (r2 == 0) goto L36
            android.os.RemoteCallbackList<miuix.appcompat.app.floatingactivity.multiapp.IServiceNotify> r5 = r3.mServiceNotify     // Catch: java.lang.Throwable -> L39 android.os.RemoteException -> L3b
            android.os.IInterface r5 = r5.getBroadcastItem(r6)     // Catch: java.lang.Throwable -> L39 android.os.RemoteException -> L3b
            miuix.appcompat.app.floatingactivity.multiapp.IServiceNotify r5 = (miuix.appcompat.app.floatingactivity.multiapp.IServiceNotify) r5     // Catch: java.lang.Throwable -> L39 android.os.RemoteException -> L3b
            r6 = 0
            android.os.Bundle r4 = r5.notifyFromService(r4, r6)     // Catch: java.lang.Throwable -> L39 android.os.RemoteException -> L3b
            java.lang.String r5 = "check_finishing"
            boolean r4 = r4.getBoolean(r5)     // Catch: java.lang.Throwable -> L39 android.os.RemoteException -> L3b
            r0 = r4
            goto L43
        L36:
            int r6 = r6 + 1
            goto Lf
        L39:
            r4 = move-exception
            goto L49
        L3b:
            r4 = move-exception
            java.lang.String r5 = "FloatingService"
            java.lang.String r6 = "checkFinishing is faulty"
            android.util.Log.w(r5, r6, r4)     // Catch: java.lang.Throwable -> L39
        L43:
            android.os.RemoteCallbackList<miuix.appcompat.app.floatingactivity.multiapp.IServiceNotify> r4 = r3.mServiceNotify
            r4.finishBroadcast()
            return r0
        L49:
            android.os.RemoteCallbackList<miuix.appcompat.app.floatingactivity.multiapp.IServiceNotify> r5 = r3.mServiceNotify
            r5.finishBroadcast()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: miuix.appcompat.app.floatingactivity.multiapp.FloatingService.checkFinishing(int, java.lang.String, int):boolean");
    }

    private String findNextIdentity(String str, int i) {
        Integer num = this.mServiceNotifyMap.get(str);
        int iIntValue = num == null ? -1 : num.intValue() + 1;
        for (String str2 : this.mServiceNotifyMap.keySet()) {
            Integer num2 = this.mServiceNotifyMap.get(str2);
            if (num2 != null && num2.intValue() == iIntValue) {
                return str2;
            }
        }
        LinkedList<String> linkedList = this.mNotifyIdentity.get(getCompatTaskId(i));
        if (linkedList != null) {
            boolean zEquals = false;
            for (String str3 : linkedList) {
                if (zEquals) {
                    return str3;
                }
                zEquals = TextUtils.equals(str, str3);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String findPreviousIdentity(String str, int i) {
        LinkedList<String> linkedList = this.mNotifyIdentity.get(getCompatTaskId(i));
        String str2 = null;
        if (linkedList != null) {
            for (String str3 : linkedList) {
                if (TextUtils.equals(str, str3)) {
                    break;
                }
                str2 = str3;
            }
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getCompatTaskId(int i) {
        return (i != 0 || this.mNotifyIdentity.size() <= 0) ? i : this.mNotifyIdentity.keyAt(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getPageCount(int i) {
        LinkedList<String> linkedList = this.mNotifyIdentity.get(getCompatTaskId(i));
        if (linkedList != null) {
            return linkedList.size();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyPreviousSlide(int i, String str, int i2) throws RemoteException {
        if (str == null) {
            return;
        }
        int iBeginBroadcast = this.mServiceNotify.beginBroadcast();
        String strFindPreviousIdentity = findPreviousIdentity(str, getCompatTaskId(i2));
        int i3 = 0;
        while (true) {
            if (i3 >= iBeginBroadcast) {
                break;
            }
            if (TextUtils.equals(strFindPreviousIdentity, this.mServiceNotify.getBroadcastCookie(i3).toString())) {
                ((IServiceNotify) this.mServiceNotify.getBroadcastItem(i3)).notifyFromService(i, null);
                break;
            }
            i3++;
        }
        this.mServiceNotify.finishBroadcast();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onMethodCall(int i) throws RemoteException {
        int iBeginBroadcast = this.mServiceNotify.beginBroadcast();
        for (int i2 = 0; i2 < iBeginBroadcast; i2++) {
            ((IServiceNotify) this.mServiceNotify.getBroadcastItem(i2)).notifyFromService(i, null);
        }
        this.mServiceNotify.finishBroadcast();
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return this.mBinder.asBinder();
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        stopSelf();
        return super.onUnbind(intent);
    }
}
