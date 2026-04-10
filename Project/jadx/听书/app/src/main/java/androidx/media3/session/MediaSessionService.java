package androidx.media3.session;

import android.app.ForegroundServiceStartNotAllowedException;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.view.KeyEvent;
import androidx.collection.ArrayMap;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media.MediaSessionManager;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.session.DefaultMediaNotificationProvider;
import androidx.media3.session.IMediaSessionService;
import androidx.media3.session.MediaNotification;
import androidx.media3.session.MediaSession;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class MediaSessionService extends Service {
    public static final String SERVICE_INTERFACE = "androidx.media3.session.MediaSessionService";
    private static final String TAG = "MSSImpl";
    private DefaultActionFactory actionFactory;
    private Listener listener;
    private MediaNotificationManager mediaNotificationManager;
    private MediaNotification.Provider mediaNotificationProvider;
    private MediaSessionServiceStub stub;
    private final Object lock = new Object();
    private final Handler mainHandler = new Handler(Looper.getMainLooper());
    private final Map<String, MediaSession> sessions = new ArrayMap();
    private boolean defaultMethodCalled = false;

    public interface Listener {
        default void onForegroundServiceStartNotAllowedException() {
        }
    }

    public abstract MediaSession onGetSession(MediaSession.ControllerInfo controllerInfo);

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        synchronized (this.lock) {
            this.stub = new MediaSessionServiceStub(this);
        }
    }

    public final void addSession(final MediaSession mediaSession) {
        MediaSession mediaSession2;
        Assertions.checkNotNull(mediaSession, "session must not be null");
        boolean z = true;
        Assertions.checkArgument(!mediaSession.isReleased(), "session is already released");
        synchronized (this.lock) {
            mediaSession2 = this.sessions.get(mediaSession.getId());
            if (mediaSession2 != null && mediaSession2 != mediaSession) {
                z = false;
            }
            Assertions.checkArgument(z, "Session ID should be unique");
            this.sessions.put(mediaSession.getId(), mediaSession);
        }
        if (mediaSession2 == null) {
            final MediaNotificationManager mediaNotificationManager = getMediaNotificationManager();
            Util.postOrRun(this.mainHandler, new Runnable() { // from class: androidx.media3.session.MediaSessionService$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m392lambda$addSession$0$androidxmedia3sessionMediaSessionService(mediaNotificationManager, mediaSession);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$addSession$0$androidx-media3-session-MediaSessionService, reason: not valid java name */
    /* synthetic */ void m392lambda$addSession$0$androidxmedia3sessionMediaSessionService(MediaNotificationManager mediaNotificationManager, MediaSession mediaSession) {
        mediaNotificationManager.addSession(mediaSession);
        mediaSession.setListener(new MediaSessionListener());
    }

    public final void removeSession(final MediaSession mediaSession) {
        Assertions.checkNotNull(mediaSession, "session must not be null");
        synchronized (this.lock) {
            Assertions.checkArgument(this.sessions.containsKey(mediaSession.getId()), "session not found");
            this.sessions.remove(mediaSession.getId());
        }
        final MediaNotificationManager mediaNotificationManager = getMediaNotificationManager();
        Util.postOrRun(this.mainHandler, new Runnable() { // from class: androidx.media3.session.MediaSessionService$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                MediaSessionService.lambda$removeSession$1(mediaNotificationManager, mediaSession);
            }
        });
    }

    static /* synthetic */ void lambda$removeSession$1(MediaNotificationManager mediaNotificationManager, MediaSession mediaSession) {
        mediaNotificationManager.removeSession(mediaSession);
        mediaSession.clearListener();
    }

    public final List<MediaSession> getSessions() {
        ArrayList arrayList;
        synchronized (this.lock) {
            arrayList = new ArrayList(this.sessions.values());
        }
        return arrayList;
    }

    public final boolean isSessionAdded(MediaSession mediaSession) {
        boolean zContainsKey;
        synchronized (this.lock) {
            zContainsKey = this.sessions.containsKey(mediaSession.getId());
        }
        return zContainsKey;
    }

    public final void setListener(Listener listener) {
        synchronized (this.lock) {
            this.listener = listener;
        }
    }

    public final void clearListener() {
        synchronized (this.lock) {
            this.listener = null;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        String action;
        MediaSession mediaSessionOnGetSession;
        if (intent == null || (action = intent.getAction()) == null) {
            return null;
        }
        action.hashCode();
        if (action.equals(SERVICE_INTERFACE)) {
            return getServiceBinder();
        }
        if (!action.equals(MediaBrowserServiceCompat.SERVICE_INTERFACE) || (mediaSessionOnGetSession = onGetSession(MediaSession.ControllerInfo.createLegacyControllerInfo())) == null) {
            return null;
        }
        addSession(mediaSessionOnGetSession);
        return mediaSessionOnGetSession.getLegacyBrowserServiceBinder();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        String customAction;
        if (intent == null) {
            return 1;
        }
        DefaultActionFactory actionFactory = getActionFactory();
        Uri data = intent.getData();
        MediaSession session = data != null ? MediaSession.getSession(data) : null;
        if (actionFactory.isMediaAction(intent)) {
            if (session == null) {
                session = onGetSession(MediaSession.ControllerInfo.createLegacyControllerInfo());
                if (session == null) {
                    return 1;
                }
                addSession(session);
            }
            KeyEvent keyEvent = actionFactory.getKeyEvent(intent);
            if (keyEvent != null) {
                session.getSessionCompat().getController().dispatchMediaButtonEvent(keyEvent);
            }
        } else {
            if (session == null || !actionFactory.isCustomAction(intent) || (customAction = actionFactory.getCustomAction(intent)) == null) {
                return 1;
            }
            getMediaNotificationManager().onCustomAction(session, customAction, actionFactory.getCustomActionExtras(intent));
        }
        return 1;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        synchronized (this.lock) {
            MediaSessionServiceStub mediaSessionServiceStub = this.stub;
            if (mediaSessionServiceStub != null) {
                mediaSessionServiceStub.release();
                this.stub = null;
            }
        }
    }

    @Deprecated
    public void onUpdateNotification(MediaSession mediaSession) {
        this.defaultMethodCalled = true;
    }

    public void onUpdateNotification(MediaSession mediaSession, boolean z) {
        onUpdateNotification(mediaSession);
        if (this.defaultMethodCalled) {
            getMediaNotificationManager().updateNotification(mediaSession, z);
        }
    }

    protected final void setMediaNotificationProvider(MediaNotification.Provider provider) {
        Assertions.checkNotNull(provider);
        synchronized (this.lock) {
            this.mediaNotificationProvider = provider;
        }
    }

    IBinder getServiceBinder() {
        IBinder iBinderAsBinder;
        synchronized (this.lock) {
            iBinderAsBinder = ((MediaSessionServiceStub) Assertions.checkStateNotNull(this.stub)).asBinder();
        }
        return iBinderAsBinder;
    }

    boolean onUpdateNotificationInternal(MediaSession mediaSession, boolean z) {
        try {
            onUpdateNotification(mediaSession, getMediaNotificationManager().shouldRunInForeground(mediaSession, z));
            return true;
        } catch (IllegalStateException e) {
            if (Util.SDK_INT >= 31 && Api31.instanceOfForegroundServiceStartNotAllowedException(e)) {
                Log.e(TAG, "Failed to start foreground", e);
                onForegroundServiceStartNotAllowedException();
                return false;
            }
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaNotificationManager getMediaNotificationManager() {
        MediaNotificationManager mediaNotificationManager;
        synchronized (this.lock) {
            if (this.mediaNotificationManager == null) {
                if (this.mediaNotificationProvider == null) {
                    this.mediaNotificationProvider = new DefaultMediaNotificationProvider.Builder(getApplicationContext()).build();
                }
                this.mediaNotificationManager = new MediaNotificationManager(this, this.mediaNotificationProvider, getActionFactory());
            }
            mediaNotificationManager = this.mediaNotificationManager;
        }
        return mediaNotificationManager;
    }

    private DefaultActionFactory getActionFactory() {
        DefaultActionFactory defaultActionFactory;
        synchronized (this.lock) {
            if (this.actionFactory == null) {
                this.actionFactory = new DefaultActionFactory(this);
            }
            defaultActionFactory = this.actionFactory;
        }
        return defaultActionFactory;
    }

    private Listener getListener() {
        Listener listener;
        synchronized (this.lock) {
            listener = this.listener;
        }
        return listener;
    }

    private void onForegroundServiceStartNotAllowedException() {
        this.mainHandler.post(new Runnable() { // from class: androidx.media3.session.MediaSessionService$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m393x5eef798a();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onForegroundServiceStartNotAllowedException$2$androidx-media3-session-MediaSessionService, reason: not valid java name */
    /* synthetic */ void m393x5eef798a() {
        Listener listener = getListener();
        if (listener != null) {
            listener.onForegroundServiceStartNotAllowedException();
        }
    }

    private final class MediaSessionListener implements MediaSession.Listener {
        private MediaSessionListener() {
        }

        @Override // androidx.media3.session.MediaSession.Listener
        public void onNotificationRefreshRequired(MediaSession mediaSession) {
            MediaSessionService.this.onUpdateNotificationInternal(mediaSession, false);
        }

        @Override // androidx.media3.session.MediaSession.Listener
        public boolean onPlayRequested(MediaSession mediaSession) {
            if (Util.SDK_INT < 31 || Util.SDK_INT >= 33 || MediaSessionService.this.getMediaNotificationManager().isStartedInForeground()) {
                return true;
            }
            return MediaSessionService.this.onUpdateNotificationInternal(mediaSession, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class MediaSessionServiceStub extends IMediaSessionService.Stub {
        private final Handler handler;
        private final MediaSessionManager mediaSessionManager;
        private final Set<IMediaController> pendingControllers;
        private final WeakReference<MediaSessionService> serviceReference;

        public MediaSessionServiceStub(MediaSessionService mediaSessionService) {
            this.serviceReference = new WeakReference<>(mediaSessionService);
            Context applicationContext = mediaSessionService.getApplicationContext();
            this.handler = new Handler(applicationContext.getMainLooper());
            this.mediaSessionManager = MediaSessionManager.getSessionManager(applicationContext);
            this.pendingControllers = Collections.synchronizedSet(new HashSet());
        }

        @Override // androidx.media3.session.IMediaSessionService
        public void connect(final IMediaController iMediaController, Bundle bundle) {
            if (iMediaController == null || bundle == null) {
                return;
            }
            try {
                final ConnectionRequest connectionRequest = (ConnectionRequest) ConnectionRequest.CREATOR.fromBundle(bundle);
                if (this.serviceReference.get() == null) {
                    try {
                        iMediaController.onDisconnected(0);
                        return;
                    } catch (RemoteException unused) {
                        return;
                    }
                }
                int callingPid = Binder.getCallingPid();
                final int callingUid = Binder.getCallingUid();
                long jClearCallingIdentity = Binder.clearCallingIdentity();
                if (callingPid == 0) {
                    callingPid = connectionRequest.pid;
                }
                final int i = callingPid;
                final MediaSessionManager.RemoteUserInfo remoteUserInfo = new MediaSessionManager.RemoteUserInfo(connectionRequest.packageName, i, callingUid);
                final boolean zIsTrustedForMediaControl = this.mediaSessionManager.isTrustedForMediaControl(remoteUserInfo);
                this.pendingControllers.add(iMediaController);
                try {
                    this.handler.post(new Runnable() { // from class: androidx.media3.session.MediaSessionService$MediaSessionServiceStub$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() throws Throwable {
                            this.f$0.m394x7a28fad4(iMediaController, remoteUserInfo, connectionRequest, zIsTrustedForMediaControl, i, callingUid);
                        }
                    });
                } finally {
                    Binder.restoreCallingIdentity(jClearCallingIdentity);
                }
            } catch (RuntimeException e) {
                Log.w(MediaSessionService.TAG, "Ignoring malformed Bundle for ConnectionRequest", e);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:42:0x0063 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
        /* JADX INFO: renamed from: lambda$connect$0$androidx-media3-session-MediaSessionService$MediaSessionServiceStub, reason: not valid java name */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        /* synthetic */ void m394x7a28fad4(androidx.media3.session.IMediaController r20, androidx.media.MediaSessionManager.RemoteUserInfo r21, androidx.media3.session.ConnectionRequest r22, boolean r23, int r24, int r25) throws java.lang.Throwable {
            /*
                r19 = this;
                r1 = r19
                r10 = r20
                r0 = r22
                java.util.Set<androidx.media3.session.IMediaController> r2 = r1.pendingControllers
                r2.remove(r10)
                r11 = 0
                r2 = 1
                java.lang.ref.WeakReference<androidx.media3.session.MediaSessionService> r3 = r1.serviceReference     // Catch: java.lang.Throwable -> L67
                java.lang.Object r3 = r3.get()     // Catch: java.lang.Throwable -> L67
                androidx.media3.session.MediaSessionService r3 = (androidx.media3.session.MediaSessionService) r3     // Catch: java.lang.Throwable -> L67
                if (r3 != 0) goto L1b
                r10.onDisconnected(r11)     // Catch: android.os.RemoteException -> L1a
            L1a:
                return
            L1b:
                androidx.media3.session.MediaSession$ControllerInfo r4 = new androidx.media3.session.MediaSession$ControllerInfo     // Catch: java.lang.Throwable -> L67
                int r14 = r0.libraryVersion     // Catch: java.lang.Throwable -> L67
                int r15 = r0.controllerInterfaceVersion     // Catch: java.lang.Throwable -> L67
                r17 = 0
                android.os.Bundle r5 = r0.connectionHints     // Catch: java.lang.Throwable -> L67
                r12 = r4
                r13 = r21
                r16 = r23
                r18 = r5
                r12.<init>(r13, r14, r15, r16, r17, r18)     // Catch: java.lang.Throwable -> L67
                androidx.media3.session.MediaSession r4 = r3.onGetSession(r4)     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> L67
                if (r4 != 0) goto L39
                r10.onDisconnected(r11)     // Catch: android.os.RemoteException -> L38
            L38:
                return
            L39:
                r3.addSession(r4)     // Catch: java.lang.Exception -> L59 java.lang.Throwable -> L67
                int r5 = r0.libraryVersion     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L56
                int r6 = r0.controllerInterfaceVersion     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L56
                java.lang.String r7 = r0.packageName     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L56
                android.os.Bundle r9 = r0.connectionHints     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L56
                r2 = r4
                r3 = r20
                r4 = r5
                r5 = r6
                r6 = r7
                r7 = r24
                r8 = r25
                r2.handleControllerConnectionFromService(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L56
                r2 = r11
                goto L61
            L53:
                r0 = move-exception
                r2 = r11
                goto L68
            L56:
                r0 = move-exception
                r2 = r11
                goto L5a
            L59:
                r0 = move-exception
            L5a:
                java.lang.String r3 = "MSSImpl"
                java.lang.String r4 = "Failed to add a session to session service"
                androidx.media3.common.util.Log.w(r3, r4, r0)     // Catch: java.lang.Throwable -> L67
            L61:
                if (r2 == 0) goto L66
                r10.onDisconnected(r11)     // Catch: android.os.RemoteException -> L66
            L66:
                return
            L67:
                r0 = move-exception
            L68:
                if (r2 == 0) goto L6d
                r10.onDisconnected(r11)     // Catch: android.os.RemoteException -> L6d
            L6d:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.session.MediaSessionService.MediaSessionServiceStub.m394x7a28fad4(androidx.media3.session.IMediaController, androidx.media.MediaSessionManager$RemoteUserInfo, androidx.media3.session.ConnectionRequest, boolean, int, int):void");
        }

        public void release() {
            this.serviceReference.clear();
            this.handler.removeCallbacksAndMessages(null);
            Iterator<IMediaController> it = this.pendingControllers.iterator();
            while (it.hasNext()) {
                try {
                    it.next().onDisconnected(0);
                } catch (RemoteException unused) {
                }
            }
        }
    }

    private static final class Api31 {
        private Api31() {
        }

        public static boolean instanceOfForegroundServiceStartNotAllowedException(IllegalStateException illegalStateException) {
            return illegalStateException instanceof ForegroundServiceStartNotAllowedException;
        }
    }
}
