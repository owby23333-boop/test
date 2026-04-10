package androidx.media3.session;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.Surface;
import androidx.core.util.ObjectsCompat;
import androidx.media.MediaSessionManager;
import androidx.media3.common.BundleListRetriever;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Rating;
import androidx.media3.common.TrackGroup;
import androidx.media3.common.TrackSelectionOverride;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.BundleableUtil;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.session.ConnectedControllersManager;
import androidx.media3.session.IMediaSession;
import androidx.media3.session.MediaLibraryService;
import androidx.media3.session.MediaSession;
import androidx.media3.session.PlayerInfo;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: classes.dex */
final class MediaSessionStub extends IMediaSession.Stub {
    private static final String TAG = "MediaSessionStub";
    public static final int VERSION_INT = 2;
    private final ConnectedControllersManager<IBinder> connectedControllersManager;
    private int nextUniqueTrackGroupIdPrefix;
    private final WeakReference<MediaSessionImpl> sessionImpl;
    private final MediaSessionManager sessionManager;
    private final Set<MediaSession.ControllerInfo> pendingControllers = Collections.synchronizedSet(new HashSet());
    private ImmutableBiMap<TrackGroup, String> trackGroupIdMap = ImmutableBiMap.of();

    /* JADX INFO: Access modifiers changed from: private */
    interface ControllerPlayerTask {
        void run(PlayerWrapper playerWrapper, MediaSession.ControllerInfo controllerInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    interface MediaItemPlayerTask {
        void run(PlayerWrapper playerWrapper, MediaSession.ControllerInfo controllerInfo, List<MediaItem> list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    interface MediaItemsWithStartPositionPlayerTask {
        void run(PlayerWrapper playerWrapper, MediaSession.MediaItemsWithStartPosition mediaItemsWithStartPosition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    interface SessionTask<T, K extends MediaSessionImpl> {
        T run(K k, MediaSession.ControllerInfo controllerInfo, int i);
    }

    public MediaSessionStub(MediaSessionImpl mediaSessionImpl) {
        this.sessionImpl = new WeakReference<>(mediaSessionImpl);
        this.sessionManager = MediaSessionManager.getSessionManager(mediaSessionImpl.getContext());
        this.connectedControllersManager = new ConnectedControllersManager<>(mediaSessionImpl);
    }

    public ConnectedControllersManager<IBinder> getConnectedControllersManager() {
        return this.connectedControllersManager;
    }

    private static void sendSessionResult(MediaSession.ControllerInfo controllerInfo, int i, SessionResult sessionResult) {
        try {
            ((MediaSession.ControllerCb) Assertions.checkStateNotNull(controllerInfo.getControllerCb())).onSessionResult(i, sessionResult);
        } catch (RemoteException e) {
            Log.w(TAG, "Failed to send result to controller " + controllerInfo, e);
        }
    }

    private static <K extends MediaSessionImpl> SessionTask<ListenableFuture<Void>, K> sendSessionResultSuccess(final Consumer<PlayerWrapper> consumer) {
        return sendSessionResultSuccess(new ControllerPlayerTask() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda24
            @Override // androidx.media3.session.MediaSessionStub.ControllerPlayerTask
            public final void run(PlayerWrapper playerWrapper, MediaSession.ControllerInfo controllerInfo) {
                consumer.accept(playerWrapper);
            }
        });
    }

    private static <K extends MediaSessionImpl> SessionTask<ListenableFuture<Void>, K> sendSessionResultSuccess(final ControllerPlayerTask controllerPlayerTask) {
        return new SessionTask() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda17
            @Override // androidx.media3.session.MediaSessionStub.SessionTask
            public final Object run(MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i) {
                return MediaSessionStub.lambda$sendSessionResultSuccess$1(controllerPlayerTask, mediaSessionImpl, controllerInfo, i);
            }
        };
    }

    static /* synthetic */ ListenableFuture lambda$sendSessionResultSuccess$1(ControllerPlayerTask controllerPlayerTask, MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i) {
        if (mediaSessionImpl.isReleased()) {
            return Futures.immediateVoidFuture();
        }
        controllerPlayerTask.run(mediaSessionImpl.getPlayerWrapper(), controllerInfo);
        sendSessionResult(controllerInfo, i, new SessionResult(0));
        return Futures.immediateVoidFuture();
    }

    private static <K extends MediaSessionImpl> SessionTask<ListenableFuture<Void>, K> sendSessionResultWhenReady(final SessionTask<ListenableFuture<SessionResult>, K> sessionTask) {
        return new SessionTask() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda36
            @Override // androidx.media3.session.MediaSessionStub.SessionTask
            public final Object run(MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i) {
                return MediaSessionStub.handleSessionTaskWhenReady(mediaSessionImpl, controllerInfo, i, sessionTask, new Consumer() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda31
                    @Override // androidx.media3.common.util.Consumer
                    public final void accept(Object obj) {
                        MediaSessionStub.lambda$sendSessionResultWhenReady$2(controllerInfo, i, (ListenableFuture) obj);
                    }
                });
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ void lambda$sendSessionResultWhenReady$2(androidx.media3.session.MediaSession.ControllerInfo r2, int r3, com.google.common.util.concurrent.ListenableFuture r4) {
        /*
            java.lang.String r0 = "MediaSessionStub"
            java.lang.Object r4 = r4.get()     // Catch: java.lang.InterruptedException -> L11 java.util.concurrent.ExecutionException -> L13 java.util.concurrent.CancellationException -> L2b
            androidx.media3.session.SessionResult r4 = (androidx.media3.session.SessionResult) r4     // Catch: java.lang.InterruptedException -> L11 java.util.concurrent.ExecutionException -> L13 java.util.concurrent.CancellationException -> L2b
            java.lang.String r1 = "SessionResult must not be null"
            java.lang.Object r4 = androidx.media3.common.util.Assertions.checkNotNull(r4, r1)     // Catch: java.lang.InterruptedException -> L11 java.util.concurrent.ExecutionException -> L13 java.util.concurrent.CancellationException -> L2b
            androidx.media3.session.SessionResult r4 = (androidx.media3.session.SessionResult) r4     // Catch: java.lang.InterruptedException -> L11 java.util.concurrent.ExecutionException -> L13 java.util.concurrent.CancellationException -> L2b
            goto L37
        L11:
            r4 = move-exception
            goto L14
        L13:
            r4 = move-exception
        L14:
            java.lang.String r1 = "Session operation failed"
            androidx.media3.common.util.Log.w(r0, r1, r4)
            androidx.media3.session.SessionResult r0 = new androidx.media3.session.SessionResult
            java.lang.Throwable r4 = r4.getCause()
            boolean r4 = r4 instanceof java.lang.UnsupportedOperationException
            if (r4 == 0) goto L25
            r4 = -6
            goto L26
        L25:
            r4 = -1
        L26:
            r0.<init>(r4)
            r4 = r0
            goto L37
        L2b:
            r4 = move-exception
            java.lang.String r1 = "Session operation cancelled"
            androidx.media3.common.util.Log.w(r0, r1, r4)
            androidx.media3.session.SessionResult r4 = new androidx.media3.session.SessionResult
            r0 = 1
            r4.<init>(r0)
        L37:
            sendSessionResult(r2, r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.session.MediaSessionStub.lambda$sendSessionResultWhenReady$2(androidx.media3.session.MediaSession$ControllerInfo, int, com.google.common.util.concurrent.ListenableFuture):void");
    }

    private static <K extends MediaSessionImpl> SessionTask<ListenableFuture<SessionResult>, K> handleMediaItemsWhenReady(final SessionTask<ListenableFuture<List<MediaItem>>, K> sessionTask, final MediaItemPlayerTask mediaItemPlayerTask) {
        return new SessionTask() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda43
            @Override // androidx.media3.session.MediaSessionStub.SessionTask
            public final Object run(MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i) {
                return MediaSessionStub.lambda$handleMediaItemsWhenReady$6(sessionTask, mediaItemPlayerTask, mediaSessionImpl, controllerInfo, i);
            }
        };
    }

    static /* synthetic */ ListenableFuture lambda$handleMediaItemsWhenReady$6(SessionTask sessionTask, final MediaItemPlayerTask mediaItemPlayerTask, final MediaSessionImpl mediaSessionImpl, final MediaSession.ControllerInfo controllerInfo, int i) {
        if (mediaSessionImpl.isReleased()) {
            return Futures.immediateFuture(new SessionResult(-100));
        }
        return Util.transformFutureAsync((ListenableFuture) sessionTask.run(mediaSessionImpl, controllerInfo, i), new AsyncFunction() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda53
            @Override // com.google.common.util.concurrent.AsyncFunction
            public final ListenableFuture apply(Object obj) {
                MediaSessionImpl mediaSessionImpl2 = mediaSessionImpl;
                MediaSession.ControllerInfo controllerInfo2 = controllerInfo;
                return Util.postOrRunWithCompletion(mediaSessionImpl2.getApplicationHandler(), mediaSessionImpl2.callWithControllerForCurrentRequestSet(controllerInfo2, new Runnable() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda71
                    @Override // java.lang.Runnable
                    public final void run() {
                        MediaSessionStub.lambda$handleMediaItemsWhenReady$4(mediaSessionImpl2, mediaItemPlayerTask, controllerInfo2, list);
                    }
                }), new SessionResult(0));
            }
        });
    }

    static /* synthetic */ void lambda$handleMediaItemsWhenReady$4(MediaSessionImpl mediaSessionImpl, MediaItemPlayerTask mediaItemPlayerTask, MediaSession.ControllerInfo controllerInfo, List list) {
        if (mediaSessionImpl.isReleased()) {
            return;
        }
        mediaItemPlayerTask.run(mediaSessionImpl.getPlayerWrapper(), controllerInfo, list);
    }

    private static <K extends MediaSessionImpl> SessionTask<ListenableFuture<SessionResult>, K> handleMediaItemsWithStartPositionWhenReady(final SessionTask<ListenableFuture<MediaSession.MediaItemsWithStartPosition>, K> sessionTask, final MediaItemsWithStartPositionPlayerTask mediaItemsWithStartPositionPlayerTask) {
        return new SessionTask() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda60
            @Override // androidx.media3.session.MediaSessionStub.SessionTask
            public final Object run(MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i) {
                return MediaSessionStub.lambda$handleMediaItemsWithStartPositionWhenReady$9(sessionTask, mediaItemsWithStartPositionPlayerTask, mediaSessionImpl, controllerInfo, i);
            }
        };
    }

    static /* synthetic */ ListenableFuture lambda$handleMediaItemsWithStartPositionWhenReady$9(SessionTask sessionTask, final MediaItemsWithStartPositionPlayerTask mediaItemsWithStartPositionPlayerTask, final MediaSessionImpl mediaSessionImpl, final MediaSession.ControllerInfo controllerInfo, int i) {
        if (mediaSessionImpl.isReleased()) {
            return Futures.immediateFuture(new SessionResult(-100));
        }
        return Util.transformFutureAsync((ListenableFuture) sessionTask.run(mediaSessionImpl, controllerInfo, i), new AsyncFunction() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda0
            @Override // com.google.common.util.concurrent.AsyncFunction
            public final ListenableFuture apply(Object obj) {
                MediaSessionImpl mediaSessionImpl2 = mediaSessionImpl;
                return Util.postOrRunWithCompletion(mediaSessionImpl2.getApplicationHandler(), mediaSessionImpl2.callWithControllerForCurrentRequestSet(controllerInfo, new Runnable() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda29
                    @Override // java.lang.Runnable
                    public final void run() {
                        MediaSessionStub.lambda$handleMediaItemsWithStartPositionWhenReady$7(mediaSessionImpl2, mediaItemsWithStartPositionPlayerTask, mediaItemsWithStartPosition);
                    }
                }), new SessionResult(0));
            }
        });
    }

    static /* synthetic */ void lambda$handleMediaItemsWithStartPositionWhenReady$7(MediaSessionImpl mediaSessionImpl, MediaItemsWithStartPositionPlayerTask mediaItemsWithStartPositionPlayerTask, MediaSession.MediaItemsWithStartPosition mediaItemsWithStartPosition) {
        if (mediaSessionImpl.isReleased()) {
            return;
        }
        mediaItemsWithStartPositionPlayerTask.run(mediaSessionImpl.getPlayerWrapper(), mediaItemsWithStartPosition);
    }

    private static void sendLibraryResult(MediaSession.ControllerInfo controllerInfo, int i, LibraryResult<?> libraryResult) {
        try {
            ((MediaSession.ControllerCb) Assertions.checkStateNotNull(controllerInfo.getControllerCb())).onLibraryResult(i, libraryResult);
        } catch (RemoteException e) {
            Log.w(TAG, "Failed to send result to browser " + controllerInfo, e);
        }
    }

    private static <V, K extends MediaLibrarySessionImpl> SessionTask<ListenableFuture<Void>, K> sendLibraryResultWhenReady(final SessionTask<ListenableFuture<LibraryResult<V>>, K> sessionTask) {
        return new SessionTask() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda78
            @Override // androidx.media3.session.MediaSessionStub.SessionTask
            public final Object run(MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i) {
                return MediaSessionStub.handleSessionTaskWhenReady((MediaLibrarySessionImpl) mediaSessionImpl, controllerInfo, i, sessionTask, new Consumer() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda22
                    @Override // androidx.media3.common.util.Consumer
                    public final void accept(Object obj) {
                        MediaSessionStub.lambda$sendLibraryResultWhenReady$10(controllerInfo, i, (ListenableFuture) obj);
                    }
                });
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void lambda$sendLibraryResultWhenReady$10(MediaSession.ControllerInfo controllerInfo, int i, ListenableFuture listenableFuture) {
        LibraryResult libraryResultOfError;
        try {
            libraryResultOfError = (LibraryResult) Assertions.checkNotNull((LibraryResult) listenableFuture.get(), "LibraryResult must not be null");
        } catch (InterruptedException e) {
            e = e;
            Log.w(TAG, "Library operation failed", e);
            libraryResultOfError = LibraryResult.ofError(-1);
        } catch (CancellationException e2) {
            Log.w(TAG, "Library operation cancelled", e2);
            libraryResultOfError = LibraryResult.ofError(1);
        } catch (ExecutionException e3) {
            e = e3;
            Log.w(TAG, "Library operation failed", e);
            libraryResultOfError = LibraryResult.ofError(-1);
        }
        sendLibraryResult(controllerInfo, i, libraryResultOfError);
    }

    private <K extends MediaSessionImpl> void queueSessionTaskWithPlayerCommand(IMediaController iMediaController, final int i, final int i2, final SessionTask<ListenableFuture<Void>, K> sessionTask) {
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            final MediaSessionImpl mediaSessionImpl = this.sessionImpl.get();
            if (mediaSessionImpl != null && !mediaSessionImpl.isReleased()) {
                final MediaSession.ControllerInfo controller = this.connectedControllersManager.getController(iMediaController.asBinder());
                if (controller == null) {
                    return;
                }
                Util.postOrRun(mediaSessionImpl.getApplicationHandler(), new Runnable() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda51
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m402xe2980b0b(controller, i2, i, mediaSessionImpl, sessionTask);
                    }
                });
            }
        } finally {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
        }
    }

    /* JADX INFO: renamed from: lambda$queueSessionTaskWithPlayerCommand$14$androidx-media3-session-MediaSessionStub, reason: not valid java name */
    /* synthetic */ void m402xe2980b0b(final MediaSession.ControllerInfo controllerInfo, int i, final int i2, final MediaSessionImpl mediaSessionImpl, final SessionTask sessionTask) {
        if (!this.connectedControllersManager.isPlayerCommandAvailable(controllerInfo, i)) {
            sendSessionResult(controllerInfo, i2, new SessionResult(-4));
            return;
        }
        int iOnPlayerCommandRequestOnHandler = mediaSessionImpl.onPlayerCommandRequestOnHandler(controllerInfo, i);
        if (iOnPlayerCommandRequestOnHandler != 0) {
            sendSessionResult(controllerInfo, i2, new SessionResult(iOnPlayerCommandRequestOnHandler));
        } else if (i == 27) {
            mediaSessionImpl.callWithControllerForCurrentRequestSet(controllerInfo, new Runnable() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda45
                @Override // java.lang.Runnable
                public final void run() {
                    sessionTask.run(mediaSessionImpl, controllerInfo, i2);
                }
            }).run();
        } else {
            this.connectedControllersManager.addToCommandQueue(controllerInfo, new ConnectedControllersManager.AsyncCommand() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda46
                @Override // androidx.media3.session.ConnectedControllersManager.AsyncCommand
                public final ListenableFuture run() {
                    return MediaSessionStub.lambda$queueSessionTaskWithPlayerCommand$13(sessionTask, mediaSessionImpl, controllerInfo, i2);
                }
            });
        }
    }

    static /* synthetic */ ListenableFuture lambda$queueSessionTaskWithPlayerCommand$13(SessionTask sessionTask, MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i) {
        return (ListenableFuture) sessionTask.run(mediaSessionImpl, controllerInfo, i);
    }

    private <K extends MediaSessionImpl> void dispatchSessionTaskWithSessionCommand(IMediaController iMediaController, int i, int i2, SessionTask<ListenableFuture<Void>, K> sessionTask) {
        dispatchSessionTaskWithSessionCommand(iMediaController, i, null, i2, sessionTask);
    }

    private <K extends MediaSessionImpl> void dispatchSessionTaskWithSessionCommand(IMediaController iMediaController, int i, SessionCommand sessionCommand, SessionTask<ListenableFuture<Void>, K> sessionTask) {
        dispatchSessionTaskWithSessionCommand(iMediaController, i, sessionCommand, 0, sessionTask);
    }

    private <K extends MediaSessionImpl> void dispatchSessionTaskWithSessionCommand(IMediaController iMediaController, final int i, final SessionCommand sessionCommand, final int i2, final SessionTask<ListenableFuture<Void>, K> sessionTask) {
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            final MediaSessionImpl mediaSessionImpl = this.sessionImpl.get();
            if (mediaSessionImpl != null && !mediaSessionImpl.isReleased()) {
                final MediaSession.ControllerInfo controller = this.connectedControllersManager.getController(iMediaController.asBinder());
                if (controller == null) {
                    return;
                }
                Util.postOrRun(mediaSessionImpl.getApplicationHandler(), new Runnable() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda69
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m399xc8132c6c(controller, sessionCommand, i, i2, sessionTask, mediaSessionImpl);
                    }
                });
            }
        } finally {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
        }
    }

    /* JADX INFO: renamed from: lambda$dispatchSessionTaskWithSessionCommand$15$androidx-media3-session-MediaSessionStub, reason: not valid java name */
    /* synthetic */ void m399xc8132c6c(MediaSession.ControllerInfo controllerInfo, SessionCommand sessionCommand, int i, int i2, SessionTask sessionTask, MediaSessionImpl mediaSessionImpl) {
        if (this.connectedControllersManager.isConnected(controllerInfo)) {
            if (sessionCommand != null) {
                if (!this.connectedControllersManager.isSessionCommandAvailable(controllerInfo, sessionCommand)) {
                    sendSessionResult(controllerInfo, i, new SessionResult(-4));
                    return;
                }
            } else if (!this.connectedControllersManager.isSessionCommandAvailable(controllerInfo, i2)) {
                sendSessionResult(controllerInfo, i, new SessionResult(-4));
                return;
            }
            sessionTask.run(mediaSessionImpl, controllerInfo, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T, K extends MediaSessionImpl> ListenableFuture<Void> handleSessionTaskWhenReady(final K k, MediaSession.ControllerInfo controllerInfo, int i, SessionTask<ListenableFuture<T>, K> sessionTask, final Consumer<ListenableFuture<T>> consumer) {
        if (k.isReleased()) {
            return Futures.immediateVoidFuture();
        }
        final ListenableFuture<T> listenableFutureRun = sessionTask.run(k, controllerInfo, i);
        final SettableFuture settableFutureCreate = SettableFuture.create();
        listenableFutureRun.addListener(new Runnable() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda38
            @Override // java.lang.Runnable
            public final void run() {
                MediaSessionStub.lambda$handleSessionTaskWhenReady$16(k, settableFutureCreate, consumer, listenableFutureRun);
            }
        }, MoreExecutors.directExecutor());
        return settableFutureCreate;
    }

    static /* synthetic */ void lambda$handleSessionTaskWhenReady$16(MediaSessionImpl mediaSessionImpl, SettableFuture settableFuture, Consumer consumer, ListenableFuture listenableFuture) {
        if (mediaSessionImpl.isReleased()) {
            settableFuture.set(null);
            return;
        }
        try {
            consumer.accept(listenableFuture);
            settableFuture.set(null);
        } catch (Throwable th) {
            settableFuture.setException(th);
        }
    }

    private int maybeCorrectMediaItemIndex(MediaSession.ControllerInfo controllerInfo, PlayerWrapper playerWrapper, int i) {
        return (playerWrapper.isCommandAvailable(17) && !this.connectedControllersManager.isPlayerCommandAvailable(controllerInfo, 17) && this.connectedControllersManager.isPlayerCommandAvailable(controllerInfo, 16)) ? i + playerWrapper.getCurrentMediaItemIndex() : i;
    }

    public void connect(final IMediaController iMediaController, int i, int i2, String str, int i3, int i4, Bundle bundle) {
        MediaSessionManager.RemoteUserInfo remoteUserInfo = new MediaSessionManager.RemoteUserInfo(str, i3, i4);
        final MediaSession.ControllerInfo controllerInfo = new MediaSession.ControllerInfo(remoteUserInfo, i, i2, this.sessionManager.isTrustedForMediaControl(remoteUserInfo), new Controller2Cb(iMediaController), bundle);
        final MediaSessionImpl mediaSessionImpl = this.sessionImpl.get();
        if (mediaSessionImpl == null || mediaSessionImpl.isReleased()) {
            try {
                iMediaController.onDisconnected(0);
            } catch (RemoteException unused) {
            }
        } else {
            this.pendingControllers.add(controllerInfo);
            Util.postOrRun(mediaSessionImpl.getApplicationHandler(), new Runnable() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda13
                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    this.f$0.m398lambda$connect$17$androidxmedia3sessionMediaSessionStub(controllerInfo, mediaSessionImpl, iMediaController);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$connect$17$androidx-media3-session-MediaSessionStub, reason: not valid java name */
    /* synthetic */ void m398lambda$connect$17$androidxmedia3sessionMediaSessionStub(MediaSession.ControllerInfo controllerInfo, MediaSessionImpl mediaSessionImpl, IMediaController iMediaController) throws Throwable {
        boolean z;
        try {
            this.pendingControllers.remove(controllerInfo);
            if (mediaSessionImpl.isReleased()) {
                try {
                    iMediaController.onDisconnected(0);
                    return;
                } catch (RemoteException unused) {
                    return;
                }
            }
            IBinder callbackBinder = ((Controller2Cb) Assertions.checkStateNotNull((Controller2Cb) controllerInfo.getControllerCb())).getCallbackBinder();
            MediaSession.ConnectionResult connectionResultOnConnectOnHandler = mediaSessionImpl.onConnectOnHandler(controllerInfo);
            if (!connectionResultOnConnectOnHandler.isAccepted && !controllerInfo.isTrusted()) {
                try {
                    iMediaController.onDisconnected(0);
                    return;
                } catch (RemoteException unused2) {
                    return;
                }
            }
            if (!connectionResultOnConnectOnHandler.isAccepted) {
                connectionResultOnConnectOnHandler = MediaSession.ConnectionResult.accept(SessionCommands.EMPTY, Player.Commands.EMPTY);
            }
            if (this.connectedControllersManager.isConnected(controllerInfo)) {
                Log.w(TAG, "Controller " + controllerInfo + " has sent connection request multiple times");
            }
            this.connectedControllersManager.addController(callbackBinder, controllerInfo, connectionResultOnConnectOnHandler.availableSessionCommands, connectionResultOnConnectOnHandler.availablePlayerCommands);
            SequencedFutureManager sequencedFutureManager = (SequencedFutureManager) Assertions.checkStateNotNull(this.connectedControllersManager.getSequencedFutureManager(controllerInfo));
            PlayerWrapper playerWrapper = mediaSessionImpl.getPlayerWrapper();
            ConnectionState connectionState = new ConnectionState(MediaLibraryInfo.VERSION_INT, 2, this, mediaSessionImpl.getSessionActivity(), connectionResultOnConnectOnHandler.customLayout != null ? connectionResultOnConnectOnHandler.customLayout : mediaSessionImpl.getCustomLayout(), connectionResultOnConnectOnHandler.availableSessionCommands, connectionResultOnConnectOnHandler.availablePlayerCommands, playerWrapper.getAvailableCommands(), mediaSessionImpl.getToken().getExtras(), generateAndCacheUniqueTrackGroupIds(playerWrapper.createPlayerInfoForBundling()));
            if (mediaSessionImpl.isReleased()) {
                try {
                    iMediaController.onDisconnected(0);
                    return;
                } catch (RemoteException unused3) {
                    return;
                }
            }
            try {
                iMediaController.onConnected(sequencedFutureManager.obtainNextSequenceNumber(), connectionState.toBundle());
                z = true;
            } catch (RemoteException unused4) {
                z = false;
            }
            try {
                mediaSessionImpl.onPostConnectOnHandler(controllerInfo);
                if (z) {
                    return;
                }
                try {
                    iMediaController.onDisconnected(0);
                    return;
                } catch (RemoteException unused5) {
                    return;
                }
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            z = false;
        }
        if (!z) {
            try {
                iMediaController.onDisconnected(0);
            } catch (RemoteException unused6) {
            }
        }
        throw th;
    }

    public void release() {
        Iterator<MediaSession.ControllerInfo> it = this.connectedControllersManager.getConnectedControllers().iterator();
        while (it.hasNext()) {
            MediaSession.ControllerCb controllerCb = it.next().getControllerCb();
            if (controllerCb != null) {
                try {
                    controllerCb.onDisconnected(0);
                } catch (RemoteException unused) {
                }
            }
        }
        Iterator<MediaSession.ControllerInfo> it2 = this.pendingControllers.iterator();
        while (it2.hasNext()) {
            MediaSession.ControllerCb controllerCb2 = it2.next().getControllerCb();
            if (controllerCb2 != null) {
                try {
                    controllerCb2.onDisconnected(0);
                } catch (RemoteException unused2) {
                }
            }
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public void connect(IMediaController iMediaController, int i, Bundle bundle) throws RuntimeException {
        if (iMediaController == null || bundle == null) {
            return;
        }
        try {
            ConnectionRequest connectionRequest = (ConnectionRequest) ConnectionRequest.CREATOR.fromBundle(bundle);
            int callingUid = Binder.getCallingUid();
            int callingPid = Binder.getCallingPid();
            long jClearCallingIdentity = Binder.clearCallingIdentity();
            if (callingPid == 0) {
                callingPid = connectionRequest.pid;
            }
            try {
                connect(iMediaController, connectionRequest.libraryVersion, connectionRequest.controllerInterfaceVersion, connectionRequest.packageName, callingPid, callingUid, connectionRequest.connectionHints);
            } finally {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
            }
        } catch (RuntimeException e) {
            Log.w(TAG, "Ignoring malformed Bundle for ConnectionRequest", e);
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public void stop(IMediaController iMediaController, int i) throws RemoteException {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i, 3, sendSessionResultSuccess((Consumer<PlayerWrapper>) new Consumer() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda56
            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                ((PlayerWrapper) obj).stop();
            }
        }));
    }

    @Override // androidx.media3.session.IMediaSession
    public void release(final IMediaController iMediaController, int i) throws RemoteException {
        if (iMediaController == null) {
            return;
        }
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            MediaSessionImpl mediaSessionImpl = this.sessionImpl.get();
            if (mediaSessionImpl != null && !mediaSessionImpl.isReleased()) {
                Util.postOrRun(mediaSessionImpl.getApplicationHandler(), new Runnable() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m403lambda$release$19$androidxmedia3sessionMediaSessionStub(iMediaController);
                    }
                });
            }
        } finally {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
        }
    }

    /* JADX INFO: renamed from: lambda$release$19$androidx-media3-session-MediaSessionStub, reason: not valid java name */
    /* synthetic */ void m403lambda$release$19$androidxmedia3sessionMediaSessionStub(IMediaController iMediaController) {
        this.connectedControllersManager.removeController(iMediaController.asBinder());
    }

    @Override // androidx.media3.session.IMediaSession
    public void onControllerResult(IMediaController iMediaController, int i, Bundle bundle) {
        if (iMediaController == null || bundle == null) {
            return;
        }
        try {
            SessionResult sessionResult = (SessionResult) SessionResult.CREATOR.fromBundle(bundle);
            long jClearCallingIdentity = Binder.clearCallingIdentity();
            try {
                SequencedFutureManager sequencedFutureManager = this.connectedControllersManager.getSequencedFutureManager(iMediaController.asBinder());
                if (sequencedFutureManager == null) {
                    return;
                }
                sequencedFutureManager.setFutureResult(i, sessionResult);
            } finally {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
            }
        } catch (RuntimeException e) {
            Log.w(TAG, "Ignoring malformed Bundle for SessionResult", e);
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public void play(IMediaController iMediaController, int i) throws RuntimeException {
        final MediaSession.ControllerInfo controller;
        if (iMediaController == null || (controller = this.connectedControllersManager.getController(iMediaController.asBinder())) == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i, 1, sendSessionResultSuccess((Consumer<PlayerWrapper>) new Consumer() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda47
            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                this.f$0.m401lambda$play$20$androidxmedia3sessionMediaSessionStub(controller, (PlayerWrapper) obj);
            }
        }));
    }

    /* JADX INFO: renamed from: lambda$play$20$androidx-media3-session-MediaSessionStub, reason: not valid java name */
    /* synthetic */ void m401lambda$play$20$androidxmedia3sessionMediaSessionStub(MediaSession.ControllerInfo controllerInfo, PlayerWrapper playerWrapper) {
        MediaSessionImpl mediaSessionImpl = this.sessionImpl.get();
        if (mediaSessionImpl == null || mediaSessionImpl.isReleased() || !mediaSessionImpl.onPlayRequested()) {
            return;
        }
        if (playerWrapper.getMediaItemCount() == 0) {
            mediaSessionImpl.prepareAndPlayForPlaybackResumption(controllerInfo, playerWrapper);
        } else {
            Util.handlePlayButtonAction(playerWrapper);
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public void pause(IMediaController iMediaController, int i) throws RuntimeException {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i, 1, sendSessionResultSuccess((Consumer<PlayerWrapper>) new Consumer() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda42
            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                ((PlayerWrapper) obj).pause();
            }
        }));
    }

    @Override // androidx.media3.session.IMediaSession
    public void prepare(IMediaController iMediaController, int i) throws RuntimeException {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i, 2, sendSessionResultSuccess((Consumer<PlayerWrapper>) new Consumer() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda63
            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                ((PlayerWrapper) obj).prepare();
            }
        }));
    }

    @Override // androidx.media3.session.IMediaSession
    public void seekToDefaultPosition(IMediaController iMediaController, int i) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i, 4, sendSessionResultSuccess((Consumer<PlayerWrapper>) new Consumer() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda32
            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                ((PlayerWrapper) obj).seekToDefaultPosition();
            }
        }));
    }

    @Override // androidx.media3.session.IMediaSession
    public void seekToDefaultPositionWithMediaItemIndex(IMediaController iMediaController, int i, final int i2) throws RemoteException {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i, 10, sendSessionResultSuccess(new ControllerPlayerTask() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda6
            @Override // androidx.media3.session.MediaSessionStub.ControllerPlayerTask
            public final void run(PlayerWrapper playerWrapper, MediaSession.ControllerInfo controllerInfo) {
                this.f$0.m408x736f604c(i2, playerWrapper, controllerInfo);
            }
        }));
    }

    /* JADX INFO: renamed from: lambda$seekToDefaultPositionWithMediaItemIndex$22$androidx-media3-session-MediaSessionStub, reason: not valid java name */
    /* synthetic */ void m408x736f604c(int i, PlayerWrapper playerWrapper, MediaSession.ControllerInfo controllerInfo) {
        playerWrapper.seekToDefaultPosition(maybeCorrectMediaItemIndex(controllerInfo, playerWrapper, i));
    }

    @Override // androidx.media3.session.IMediaSession
    public void seekTo(IMediaController iMediaController, int i, final long j) throws RuntimeException {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i, 5, sendSessionResultSuccess((Consumer<PlayerWrapper>) new Consumer() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda8
            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                ((PlayerWrapper) obj).seekTo(j);
            }
        }));
    }

    @Override // androidx.media3.session.IMediaSession
    public void seekToWithMediaItemIndex(IMediaController iMediaController, int i, final int i2, final long j) throws RemoteException {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i, 10, sendSessionResultSuccess(new ControllerPlayerTask() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda61
            @Override // androidx.media3.session.MediaSessionStub.ControllerPlayerTask
            public final void run(PlayerWrapper playerWrapper, MediaSession.ControllerInfo controllerInfo) {
                this.f$0.m409x4b8f44c0(i2, j, playerWrapper, controllerInfo);
            }
        }));
    }

    /* JADX INFO: renamed from: lambda$seekToWithMediaItemIndex$24$androidx-media3-session-MediaSessionStub, reason: not valid java name */
    /* synthetic */ void m409x4b8f44c0(int i, long j, PlayerWrapper playerWrapper, MediaSession.ControllerInfo controllerInfo) {
        playerWrapper.seekTo(maybeCorrectMediaItemIndex(controllerInfo, playerWrapper, i), j);
    }

    @Override // androidx.media3.session.IMediaSession
    public void seekBack(IMediaController iMediaController, int i) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i, 11, sendSessionResultSuccess((Consumer<PlayerWrapper>) new Consumer() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda58
            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                ((PlayerWrapper) obj).seekBack();
            }
        }));
    }

    @Override // androidx.media3.session.IMediaSession
    public void seekForward(IMediaController iMediaController, int i) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i, 12, sendSessionResultSuccess((Consumer<PlayerWrapper>) new Consumer() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda37
            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                ((PlayerWrapper) obj).seekForward();
            }
        }));
    }

    @Override // androidx.media3.session.IMediaSession
    public void onCustomCommand(IMediaController iMediaController, int i, Bundle bundle, final Bundle bundle2) {
        if (iMediaController == null || bundle == null || bundle2 == null) {
            return;
        }
        try {
            final SessionCommand sessionCommand = (SessionCommand) SessionCommand.CREATOR.fromBundle(bundle);
            dispatchSessionTaskWithSessionCommand(iMediaController, i, sessionCommand, sendSessionResultWhenReady(new SessionTask() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda20
                @Override // androidx.media3.session.MediaSessionStub.SessionTask
                public final Object run(MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i2) {
                    return mediaSessionImpl.onCustomCommandOnHandler(controllerInfo, sessionCommand, bundle2);
                }
            }));
        } catch (RuntimeException e) {
            Log.w(TAG, "Ignoring malformed Bundle for SessionCommand", e);
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public void setRatingWithMediaId(IMediaController iMediaController, int i, final String str, Bundle bundle) {
        if (iMediaController == null || bundle == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            Log.w(TAG, "setRatingWithMediaId(): Ignoring empty mediaId");
            return;
        }
        try {
            final Rating rating = (Rating) Rating.CREATOR.fromBundle(bundle);
            dispatchSessionTaskWithSessionCommand(iMediaController, i, SessionCommand.COMMAND_CODE_SESSION_SET_RATING, sendSessionResultWhenReady(new SessionTask() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda11
                @Override // androidx.media3.session.MediaSessionStub.SessionTask
                public final Object run(MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i2) {
                    return mediaSessionImpl.onSetRatingOnHandler(controllerInfo, str, rating);
                }
            }));
        } catch (RuntimeException e) {
            Log.w(TAG, "Ignoring malformed Bundle for Rating", e);
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public void setRating(IMediaController iMediaController, int i, Bundle bundle) {
        if (iMediaController == null || bundle == null) {
            return;
        }
        try {
            final Rating rating = (Rating) Rating.CREATOR.fromBundle(bundle);
            dispatchSessionTaskWithSessionCommand(iMediaController, i, SessionCommand.COMMAND_CODE_SESSION_SET_RATING, sendSessionResultWhenReady(new SessionTask() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda9
                @Override // androidx.media3.session.MediaSessionStub.SessionTask
                public final Object run(MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i2) {
                    return mediaSessionImpl.onSetRatingOnHandler(controllerInfo, rating);
                }
            }));
        } catch (RuntimeException e) {
            Log.w(TAG, "Ignoring malformed Bundle for Rating", e);
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public void setPlaybackSpeed(IMediaController iMediaController, int i, final float f) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i, 13, sendSessionResultSuccess((Consumer<PlayerWrapper>) new Consumer() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda54
            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                ((PlayerWrapper) obj).setPlaybackSpeed(f);
            }
        }));
    }

    @Override // androidx.media3.session.IMediaSession
    public void setPlaybackParameters(IMediaController iMediaController, int i, Bundle bundle) {
        if (iMediaController == null || bundle == null) {
            return;
        }
        final PlaybackParameters playbackParameters = (PlaybackParameters) PlaybackParameters.CREATOR.fromBundle(bundle);
        queueSessionTaskWithPlayerCommand(iMediaController, i, 13, sendSessionResultSuccess((Consumer<PlayerWrapper>) new Consumer() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda15
            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                ((PlayerWrapper) obj).setPlaybackParameters(playbackParameters);
            }
        }));
    }

    @Override // androidx.media3.session.IMediaSession
    public void setMediaItem(IMediaController iMediaController, int i, Bundle bundle) {
        setMediaItemWithResetPosition(iMediaController, i, bundle, true);
    }

    @Override // androidx.media3.session.IMediaSession
    public void setMediaItemWithStartPosition(IMediaController iMediaController, int i, Bundle bundle, final long j) {
        if (iMediaController == null || bundle == null) {
            return;
        }
        try {
            final MediaItem mediaItem = (MediaItem) MediaItem.CREATOR.fromBundle(bundle);
            queueSessionTaskWithPlayerCommand(iMediaController, i, 31, sendSessionResultWhenReady(handleMediaItemsWithStartPositionWhenReady(new SessionTask() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda62
                @Override // androidx.media3.session.MediaSessionStub.SessionTask
                public final Object run(MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i2) {
                    return mediaSessionImpl.onSetMediaItemsOnHandler(controllerInfo, ImmutableList.of(mediaItem), 0, j);
                }
            }, new MediaSessionStub$$ExternalSyntheticLambda1())));
        } catch (RuntimeException e) {
            Log.w(TAG, "Ignoring malformed Bundle for MediaItem", e);
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public void setMediaItemWithResetPosition(IMediaController iMediaController, int i, Bundle bundle, final boolean z) {
        if (iMediaController == null || bundle == null) {
            return;
        }
        try {
            final MediaItem mediaItem = (MediaItem) MediaItem.CREATOR.fromBundle(bundle);
            queueSessionTaskWithPlayerCommand(iMediaController, i, 31, sendSessionResultWhenReady(handleMediaItemsWithStartPositionWhenReady(new SessionTask() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda82
                @Override // androidx.media3.session.MediaSessionStub.SessionTask
                public final Object run(MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i2) {
                    MediaItem mediaItem2 = mediaItem;
                    boolean z2 = z;
                    return mediaSessionImpl.onSetMediaItemsOnHandler(controllerInfo, ImmutableList.of(mediaItem2), z2 ? -1 : mediaSessionImpl.getPlayerWrapper().getCurrentMediaItemIndex(), z2 ? -9223372036854775807L : mediaSessionImpl.getPlayerWrapper().getCurrentPosition());
                }
            }, new MediaSessionStub$$ExternalSyntheticLambda1())));
        } catch (RuntimeException e) {
            Log.w(TAG, "Ignoring malformed Bundle for MediaItem", e);
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public void setMediaItems(IMediaController iMediaController, int i, IBinder iBinder) {
        setMediaItemsWithResetPosition(iMediaController, i, iBinder, true);
    }

    @Override // androidx.media3.session.IMediaSession
    public void setMediaItemsWithResetPosition(IMediaController iMediaController, int i, IBinder iBinder, final boolean z) {
        if (iMediaController == null || iBinder == null) {
            return;
        }
        try {
            final ImmutableList immutableListFromBundleList = BundleableUtil.fromBundleList(MediaItem.CREATOR, BundleListRetriever.getList(iBinder));
            queueSessionTaskWithPlayerCommand(iMediaController, i, 20, sendSessionResultWhenReady(handleMediaItemsWithStartPositionWhenReady(new SessionTask() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda7
                @Override // androidx.media3.session.MediaSessionStub.SessionTask
                public final Object run(MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i2) {
                    List list = immutableListFromBundleList;
                    boolean z2 = z;
                    return mediaSessionImpl.onSetMediaItemsOnHandler(controllerInfo, list, z2 ? -1 : mediaSessionImpl.getPlayerWrapper().getCurrentMediaItemIndex(), z2 ? -9223372036854775807L : mediaSessionImpl.getPlayerWrapper().getCurrentPosition());
                }
            }, new MediaSessionStub$$ExternalSyntheticLambda1())));
        } catch (RuntimeException e) {
            Log.w(TAG, "Ignoring malformed Bundle for MediaItem", e);
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public void setMediaItemsWithStartIndex(IMediaController iMediaController, int i, IBinder iBinder, final int i2, final long j) {
        if (iMediaController == null || iBinder == null) {
            return;
        }
        try {
            final ImmutableList immutableListFromBundleList = BundleableUtil.fromBundleList(MediaItem.CREATOR, BundleListRetriever.getList(iBinder));
            queueSessionTaskWithPlayerCommand(iMediaController, i, 20, sendSessionResultWhenReady(handleMediaItemsWithStartPositionWhenReady(new SessionTask() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda70
                @Override // androidx.media3.session.MediaSessionStub.SessionTask
                public final Object run(MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i3) {
                    return MediaSessionStub.lambda$setMediaItemsWithStartIndex$33(immutableListFromBundleList, i2, j, mediaSessionImpl, controllerInfo, i3);
                }
            }, new MediaSessionStub$$ExternalSyntheticLambda1())));
        } catch (RuntimeException e) {
            Log.w(TAG, "Ignoring malformed Bundle for MediaItem", e);
        }
    }

    static /* synthetic */ ListenableFuture lambda$setMediaItemsWithStartIndex$33(List list, int i, long j, MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i2) {
        int currentMediaItemIndex = i == -1 ? mediaSessionImpl.getPlayerWrapper().getCurrentMediaItemIndex() : i;
        if (i == -1) {
            j = mediaSessionImpl.getPlayerWrapper().getCurrentPosition();
        }
        return mediaSessionImpl.onSetMediaItemsOnHandler(controllerInfo, list, currentMediaItemIndex, j);
    }

    @Override // androidx.media3.session.IMediaSession
    public void setPlaylistMetadata(IMediaController iMediaController, int i, Bundle bundle) {
        if (iMediaController == null || bundle == null) {
            return;
        }
        try {
            final MediaMetadata mediaMetadata = (MediaMetadata) MediaMetadata.CREATOR.fromBundle(bundle);
            queueSessionTaskWithPlayerCommand(iMediaController, i, 19, sendSessionResultSuccess((Consumer<PlayerWrapper>) new Consumer() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda34
                @Override // androidx.media3.common.util.Consumer
                public final void accept(Object obj) {
                    ((PlayerWrapper) obj).setPlaylistMetadata(mediaMetadata);
                }
            }));
        } catch (RuntimeException e) {
            Log.w(TAG, "Ignoring malformed Bundle for MediaMetadata", e);
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public void addMediaItem(IMediaController iMediaController, int i, Bundle bundle) {
        if (iMediaController == null || bundle == null) {
            return;
        }
        try {
            final MediaItem mediaItem = (MediaItem) MediaItem.CREATOR.fromBundle(bundle);
            queueSessionTaskWithPlayerCommand(iMediaController, i, 20, sendSessionResultWhenReady(handleMediaItemsWhenReady(new SessionTask() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda67
                @Override // androidx.media3.session.MediaSessionStub.SessionTask
                public final Object run(MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i2) {
                    return mediaSessionImpl.onAddMediaItemsOnHandler(controllerInfo, ImmutableList.of(mediaItem));
                }
            }, new MediaItemPlayerTask() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda68
                @Override // androidx.media3.session.MediaSessionStub.MediaItemPlayerTask
                public final void run(PlayerWrapper playerWrapper, MediaSession.ControllerInfo controllerInfo, List list) {
                    playerWrapper.addMediaItems(list);
                }
            })));
        } catch (RuntimeException e) {
            Log.w(TAG, "Ignoring malformed Bundle for MediaItem", e);
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public void addMediaItemWithIndex(IMediaController iMediaController, int i, final int i2, Bundle bundle) {
        if (iMediaController == null || bundle == null) {
            return;
        }
        try {
            final MediaItem mediaItem = (MediaItem) MediaItem.CREATOR.fromBundle(bundle);
            queueSessionTaskWithPlayerCommand(iMediaController, i, 20, sendSessionResultWhenReady(handleMediaItemsWhenReady(new SessionTask() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda72
                @Override // androidx.media3.session.MediaSessionStub.SessionTask
                public final Object run(MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i3) {
                    return mediaSessionImpl.onAddMediaItemsOnHandler(controllerInfo, ImmutableList.of(mediaItem));
                }
            }, new MediaItemPlayerTask() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda73
                @Override // androidx.media3.session.MediaSessionStub.MediaItemPlayerTask
                public final void run(PlayerWrapper playerWrapper, MediaSession.ControllerInfo controllerInfo, List list) {
                    this.f$0.m396xa33cfaa5(i2, playerWrapper, controllerInfo, list);
                }
            })));
        } catch (RuntimeException e) {
            Log.w(TAG, "Ignoring malformed Bundle for MediaItem", e);
        }
    }

    /* JADX INFO: renamed from: lambda$addMediaItemWithIndex$38$androidx-media3-session-MediaSessionStub, reason: not valid java name */
    /* synthetic */ void m396xa33cfaa5(int i, PlayerWrapper playerWrapper, MediaSession.ControllerInfo controllerInfo, List list) {
        playerWrapper.addMediaItems(maybeCorrectMediaItemIndex(controllerInfo, playerWrapper, i), list);
    }

    @Override // androidx.media3.session.IMediaSession
    public void addMediaItems(IMediaController iMediaController, int i, IBinder iBinder) {
        if (iMediaController == null || iBinder == null) {
            return;
        }
        try {
            final ImmutableList immutableListFromBundleList = BundleableUtil.fromBundleList(MediaItem.CREATOR, BundleListRetriever.getList(iBinder));
            queueSessionTaskWithPlayerCommand(iMediaController, i, 20, sendSessionResultWhenReady(handleMediaItemsWhenReady(new SessionTask() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda77
                @Override // androidx.media3.session.MediaSessionStub.SessionTask
                public final Object run(MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i2) {
                    return mediaSessionImpl.onAddMediaItemsOnHandler(controllerInfo, immutableListFromBundleList);
                }
            }, new MediaItemPlayerTask() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda81
                @Override // androidx.media3.session.MediaSessionStub.MediaItemPlayerTask
                public final void run(PlayerWrapper playerWrapper, MediaSession.ControllerInfo controllerInfo, List list) {
                    playerWrapper.addMediaItems(list);
                }
            })));
        } catch (RuntimeException e) {
            Log.w(TAG, "Ignoring malformed Bundle for MediaItem", e);
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public void addMediaItemsWithIndex(IMediaController iMediaController, int i, final int i2, IBinder iBinder) {
        if (iMediaController == null || iBinder == null) {
            return;
        }
        try {
            final ImmutableList immutableListFromBundleList = BundleableUtil.fromBundleList(MediaItem.CREATOR, BundleListRetriever.getList(iBinder));
            queueSessionTaskWithPlayerCommand(iMediaController, i, 20, sendSessionResultWhenReady(handleMediaItemsWhenReady(new SessionTask() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda49
                @Override // androidx.media3.session.MediaSessionStub.SessionTask
                public final Object run(MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i3) {
                    return mediaSessionImpl.onAddMediaItemsOnHandler(controllerInfo, immutableListFromBundleList);
                }
            }, new MediaItemPlayerTask() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda50
                @Override // androidx.media3.session.MediaSessionStub.MediaItemPlayerTask
                public final void run(PlayerWrapper playerWrapper, MediaSession.ControllerInfo controllerInfo, List list) {
                    this.f$0.m397xa7c8445f(i2, playerWrapper, controllerInfo, list);
                }
            })));
        } catch (RuntimeException e) {
            Log.w(TAG, "Ignoring malformed Bundle for MediaItem", e);
        }
    }

    /* JADX INFO: renamed from: lambda$addMediaItemsWithIndex$42$androidx-media3-session-MediaSessionStub, reason: not valid java name */
    /* synthetic */ void m397xa7c8445f(int i, PlayerWrapper playerWrapper, MediaSession.ControllerInfo controllerInfo, List list) {
        playerWrapper.addMediaItems(maybeCorrectMediaItemIndex(controllerInfo, playerWrapper, i), list);
    }

    @Override // androidx.media3.session.IMediaSession
    public void removeMediaItem(IMediaController iMediaController, int i, final int i2) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i, 20, sendSessionResultSuccess(new ControllerPlayerTask() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda59
            @Override // androidx.media3.session.MediaSessionStub.ControllerPlayerTask
            public final void run(PlayerWrapper playerWrapper, MediaSession.ControllerInfo controllerInfo) {
                this.f$0.m404x741d18a8(i2, playerWrapper, controllerInfo);
            }
        }));
    }

    /* JADX INFO: renamed from: lambda$removeMediaItem$43$androidx-media3-session-MediaSessionStub, reason: not valid java name */
    /* synthetic */ void m404x741d18a8(int i, PlayerWrapper playerWrapper, MediaSession.ControllerInfo controllerInfo) {
        playerWrapper.removeMediaItem(maybeCorrectMediaItemIndex(controllerInfo, playerWrapper, i));
    }

    @Override // androidx.media3.session.IMediaSession
    public void removeMediaItems(IMediaController iMediaController, int i, final int i2, final int i3) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i, 20, sendSessionResultSuccess(new ControllerPlayerTask() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda79
            @Override // androidx.media3.session.MediaSessionStub.ControllerPlayerTask
            public final void run(PlayerWrapper playerWrapper, MediaSession.ControllerInfo controllerInfo) {
                this.f$0.m405x379c9e4e(i2, i3, playerWrapper, controllerInfo);
            }
        }));
    }

    /* JADX INFO: renamed from: lambda$removeMediaItems$44$androidx-media3-session-MediaSessionStub, reason: not valid java name */
    /* synthetic */ void m405x379c9e4e(int i, int i2, PlayerWrapper playerWrapper, MediaSession.ControllerInfo controllerInfo) {
        playerWrapper.removeMediaItems(maybeCorrectMediaItemIndex(controllerInfo, playerWrapper, i), maybeCorrectMediaItemIndex(controllerInfo, playerWrapper, i2));
    }

    @Override // androidx.media3.session.IMediaSession
    public void clearMediaItems(IMediaController iMediaController, int i) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i, 20, sendSessionResultSuccess((Consumer<PlayerWrapper>) new Consumer() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda3
            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                ((PlayerWrapper) obj).clearMediaItems();
            }
        }));
    }

    @Override // androidx.media3.session.IMediaSession
    public void moveMediaItem(IMediaController iMediaController, int i, final int i2, final int i3) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i, 20, sendSessionResultSuccess((Consumer<PlayerWrapper>) new Consumer() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda75
            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                ((PlayerWrapper) obj).moveMediaItem(i2, i3);
            }
        }));
    }

    @Override // androidx.media3.session.IMediaSession
    public void moveMediaItems(IMediaController iMediaController, int i, final int i2, final int i3, final int i4) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i, 20, sendSessionResultSuccess((Consumer<PlayerWrapper>) new Consumer() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda19
            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                ((PlayerWrapper) obj).moveMediaItems(i2, i3, i4);
            }
        }));
    }

    @Override // androidx.media3.session.IMediaSession
    public void replaceMediaItem(IMediaController iMediaController, int i, final int i2, Bundle bundle) {
        if (iMediaController == null || bundle == null) {
            return;
        }
        try {
            final MediaItem mediaItem = (MediaItem) MediaItem.CREATOR.fromBundle(bundle);
            queueSessionTaskWithPlayerCommand(iMediaController, i, 20, sendSessionResultWhenReady(handleMediaItemsWhenReady(new SessionTask() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda40
                @Override // androidx.media3.session.MediaSessionStub.SessionTask
                public final Object run(MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i3) {
                    return mediaSessionImpl.onAddMediaItemsOnHandler(controllerInfo, ImmutableList.of(mediaItem));
                }
            }, new MediaItemPlayerTask() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda41
                @Override // androidx.media3.session.MediaSessionStub.MediaItemPlayerTask
                public final void run(PlayerWrapper playerWrapper, MediaSession.ControllerInfo controllerInfo, List list) {
                    this.f$0.m406x7425192d(i2, playerWrapper, controllerInfo, list);
                }
            })));
        } catch (RuntimeException e) {
            Log.w(TAG, "Ignoring malformed Bundle for MediaItem", e);
        }
    }

    /* JADX INFO: renamed from: lambda$replaceMediaItem$48$androidx-media3-session-MediaSessionStub, reason: not valid java name */
    /* synthetic */ void m406x7425192d(int i, PlayerWrapper playerWrapper, MediaSession.ControllerInfo controllerInfo, List list) {
        if (list.size() == 1) {
            playerWrapper.replaceMediaItem(maybeCorrectMediaItemIndex(controllerInfo, playerWrapper, i), (MediaItem) list.get(0));
        } else {
            playerWrapper.replaceMediaItems(maybeCorrectMediaItemIndex(controllerInfo, playerWrapper, i), maybeCorrectMediaItemIndex(controllerInfo, playerWrapper, i + 1), list);
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public void replaceMediaItems(IMediaController iMediaController, int i, final int i2, final int i3, IBinder iBinder) {
        if (iMediaController == null || iBinder == null) {
            return;
        }
        try {
            final ImmutableList immutableListFromBundleList = BundleableUtil.fromBundleList(MediaItem.CREATOR, BundleListRetriever.getList(iBinder));
            queueSessionTaskWithPlayerCommand(iMediaController, i, 20, sendSessionResultWhenReady(handleMediaItemsWhenReady(new SessionTask() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda55
                @Override // androidx.media3.session.MediaSessionStub.SessionTask
                public final Object run(MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i4) {
                    return mediaSessionImpl.onAddMediaItemsOnHandler(controllerInfo, immutableListFromBundleList);
                }
            }, new MediaItemPlayerTask() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda66
                @Override // androidx.media3.session.MediaSessionStub.MediaItemPlayerTask
                public final void run(PlayerWrapper playerWrapper, MediaSession.ControllerInfo controllerInfo, List list) {
                    this.f$0.m407x85fa1ee9(i2, i3, playerWrapper, controllerInfo, list);
                }
            })));
        } catch (RuntimeException e) {
            Log.w(TAG, "Ignoring malformed Bundle for MediaItem", e);
        }
    }

    /* JADX INFO: renamed from: lambda$replaceMediaItems$50$androidx-media3-session-MediaSessionStub, reason: not valid java name */
    /* synthetic */ void m407x85fa1ee9(int i, int i2, PlayerWrapper playerWrapper, MediaSession.ControllerInfo controllerInfo, List list) {
        playerWrapper.replaceMediaItems(maybeCorrectMediaItemIndex(controllerInfo, playerWrapper, i), maybeCorrectMediaItemIndex(controllerInfo, playerWrapper, i2), list);
    }

    @Override // androidx.media3.session.IMediaSession
    public void seekToPreviousMediaItem(IMediaController iMediaController, int i) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i, 6, sendSessionResultSuccess((Consumer<PlayerWrapper>) new Consumer() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda25
            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                ((PlayerWrapper) obj).seekToPreviousMediaItem();
            }
        }));
    }

    @Override // androidx.media3.session.IMediaSession
    public void seekToNextMediaItem(IMediaController iMediaController, int i) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i, 8, sendSessionResultSuccess((Consumer<PlayerWrapper>) new Consumer() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda44
            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                ((PlayerWrapper) obj).seekToNextMediaItem();
            }
        }));
    }

    @Override // androidx.media3.session.IMediaSession
    public void seekToPrevious(IMediaController iMediaController, int i) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i, 7, sendSessionResultSuccess((Consumer<PlayerWrapper>) new Consumer() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda57
            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                ((PlayerWrapper) obj).seekToPrevious();
            }
        }));
    }

    @Override // androidx.media3.session.IMediaSession
    public void seekToNext(IMediaController iMediaController, int i) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i, 9, sendSessionResultSuccess((Consumer<PlayerWrapper>) new Consumer() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda12
            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                ((PlayerWrapper) obj).seekToNext();
            }
        }));
    }

    @Override // androidx.media3.session.IMediaSession
    public void setRepeatMode(IMediaController iMediaController, int i, final int i2) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i, 15, sendSessionResultSuccess((Consumer<PlayerWrapper>) new Consumer() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda28
            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                ((PlayerWrapper) obj).setRepeatMode(i2);
            }
        }));
    }

    @Override // androidx.media3.session.IMediaSession
    public void setShuffleModeEnabled(IMediaController iMediaController, int i, final boolean z) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i, 14, sendSessionResultSuccess((Consumer<PlayerWrapper>) new Consumer() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda2
            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                ((PlayerWrapper) obj).setShuffleModeEnabled(z);
            }
        }));
    }

    @Override // androidx.media3.session.IMediaSession
    public void setVideoSurface(IMediaController iMediaController, int i, final Surface surface) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i, 27, sendSessionResultSuccess((Consumer<PlayerWrapper>) new Consumer() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda27
            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                ((PlayerWrapper) obj).setVideoSurface(surface);
            }
        }));
    }

    @Override // androidx.media3.session.IMediaSession
    public void setVolume(IMediaController iMediaController, int i, final float f) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i, 24, sendSessionResultSuccess((Consumer<PlayerWrapper>) new Consumer() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda35
            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                ((PlayerWrapper) obj).setVolume(f);
            }
        }));
    }

    @Override // androidx.media3.session.IMediaSession
    public void setDeviceVolume(IMediaController iMediaController, int i, final int i2) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i, 25, sendSessionResultSuccess((Consumer<PlayerWrapper>) new Consumer() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda21
            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                ((PlayerWrapper) obj).setDeviceVolume(i2);
            }
        }));
    }

    @Override // androidx.media3.session.IMediaSession
    public void setDeviceVolumeWithFlags(IMediaController iMediaController, int i, final int i2, final int i3) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i, 33, sendSessionResultSuccess((Consumer<PlayerWrapper>) new Consumer() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda33
            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                ((PlayerWrapper) obj).setDeviceVolume(i2, i3);
            }
        }));
    }

    @Override // androidx.media3.session.IMediaSession
    public void increaseDeviceVolume(IMediaController iMediaController, int i) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i, 26, sendSessionResultSuccess((Consumer<PlayerWrapper>) new Consumer() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda23
            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                ((PlayerWrapper) obj).increaseDeviceVolume();
            }
        }));
    }

    @Override // androidx.media3.session.IMediaSession
    public void increaseDeviceVolumeWithFlags(IMediaController iMediaController, int i, final int i2) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i, 34, sendSessionResultSuccess((Consumer<PlayerWrapper>) new Consumer() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda18
            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                ((PlayerWrapper) obj).increaseDeviceVolume(i2);
            }
        }));
    }

    @Override // androidx.media3.session.IMediaSession
    public void decreaseDeviceVolume(IMediaController iMediaController, int i) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i, 26, sendSessionResultSuccess((Consumer<PlayerWrapper>) new Consumer() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda14
            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                ((PlayerWrapper) obj).decreaseDeviceVolume();
            }
        }));
    }

    @Override // androidx.media3.session.IMediaSession
    public void decreaseDeviceVolumeWithFlags(IMediaController iMediaController, int i, final int i2) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i, 34, sendSessionResultSuccess((Consumer<PlayerWrapper>) new Consumer() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda30
            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                ((PlayerWrapper) obj).decreaseDeviceVolume(i2);
            }
        }));
    }

    @Override // androidx.media3.session.IMediaSession
    public void setDeviceMuted(IMediaController iMediaController, int i, final boolean z) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i, 26, sendSessionResultSuccess((Consumer<PlayerWrapper>) new Consumer() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda65
            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                ((PlayerWrapper) obj).setDeviceMuted(z);
            }
        }));
    }

    @Override // androidx.media3.session.IMediaSession
    public void setDeviceMutedWithFlags(IMediaController iMediaController, int i, final boolean z, final int i2) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i, 34, sendSessionResultSuccess((Consumer<PlayerWrapper>) new Consumer() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda26
            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                ((PlayerWrapper) obj).setDeviceMuted(z, i2);
            }
        }));
    }

    @Override // androidx.media3.session.IMediaSession
    public void setPlayWhenReady(IMediaController iMediaController, int i, final boolean z) {
        if (iMediaController == null) {
            return;
        }
        queueSessionTaskWithPlayerCommand(iMediaController, i, 1, sendSessionResultSuccess((Consumer<PlayerWrapper>) new Consumer() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda16
            @Override // androidx.media3.common.util.Consumer
            public final void accept(Object obj) {
                ((PlayerWrapper) obj).setPlayWhenReady(z);
            }
        }));
    }

    @Override // androidx.media3.session.IMediaSession
    public void flushCommandQueue(IMediaController iMediaController) {
        if (iMediaController == null) {
            return;
        }
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            MediaSessionImpl mediaSessionImpl = this.sessionImpl.get();
            if (mediaSessionImpl != null && !mediaSessionImpl.isReleased()) {
                final MediaSession.ControllerInfo controller = this.connectedControllersManager.getController(iMediaController.asBinder());
                if (controller != null) {
                    Util.postOrRun(mediaSessionImpl.getApplicationHandler(), new Runnable() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda39
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f$0.m400x787698c0(controller);
                        }
                    });
                }
            }
        } finally {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
        }
    }

    /* JADX INFO: renamed from: lambda$flushCommandQueue$64$androidx-media3-session-MediaSessionStub, reason: not valid java name */
    /* synthetic */ void m400x787698c0(MediaSession.ControllerInfo controllerInfo) {
        this.connectedControllersManager.flushCommandQueue(controllerInfo);
    }

    @Override // androidx.media3.session.IMediaSession
    public void setTrackSelectionParameters(IMediaController iMediaController, int i, Bundle bundle) throws RemoteException {
        if (iMediaController == null) {
            return;
        }
        try {
            final TrackSelectionParameters trackSelectionParametersFromBundle = TrackSelectionParameters.fromBundle(bundle);
            queueSessionTaskWithPlayerCommand(iMediaController, i, 29, sendSessionResultSuccess((Consumer<PlayerWrapper>) new Consumer() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda5
                @Override // androidx.media3.common.util.Consumer
                public final void accept(Object obj) {
                    this.f$0.m410x8b51cbc2(trackSelectionParametersFromBundle, (PlayerWrapper) obj);
                }
            }));
        } catch (RuntimeException e) {
            Log.w(TAG, "Ignoring malformed Bundle for TrackSelectionParameters", e);
        }
    }

    /* JADX INFO: renamed from: lambda$setTrackSelectionParameters$65$androidx-media3-session-MediaSessionStub, reason: not valid java name */
    /* synthetic */ void m410x8b51cbc2(TrackSelectionParameters trackSelectionParameters, PlayerWrapper playerWrapper) {
        playerWrapper.setTrackSelectionParameters(updateOverridesUsingUniqueTrackGroupIds(trackSelectionParameters));
    }

    @Override // androidx.media3.session.IMediaSession
    public void getLibraryRoot(IMediaController iMediaController, int i, Bundle bundle) throws RuntimeException {
        if (iMediaController == null) {
            return;
        }
        final MediaLibraryService.LibraryParams libraryParams = bundle == null ? null : (MediaLibraryService.LibraryParams) MediaLibraryService.LibraryParams.CREATOR.fromBundle(bundle);
        dispatchSessionTaskWithSessionCommand(iMediaController, i, 50000, sendLibraryResultWhenReady(new SessionTask() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda80
            @Override // androidx.media3.session.MediaSessionStub.SessionTask
            public final Object run(MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i2) {
                return ((MediaLibrarySessionImpl) mediaSessionImpl).onGetLibraryRootOnHandler(controllerInfo, libraryParams);
            }
        }));
    }

    @Override // androidx.media3.session.IMediaSession
    public void getItem(IMediaController iMediaController, int i, final String str) throws RuntimeException {
        if (iMediaController == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            Log.w(TAG, "getItem(): Ignoring empty mediaId");
        } else {
            dispatchSessionTaskWithSessionCommand(iMediaController, i, SessionCommand.COMMAND_CODE_LIBRARY_GET_ITEM, sendLibraryResultWhenReady(new SessionTask() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda64
                @Override // androidx.media3.session.MediaSessionStub.SessionTask
                public final Object run(MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i2) {
                    return ((MediaLibrarySessionImpl) mediaSessionImpl).onGetItemOnHandler(controllerInfo, str);
                }
            }));
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public void getChildren(IMediaController iMediaController, int i, final String str, final int i2, final int i3, Bundle bundle) throws RuntimeException {
        if (iMediaController == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            Log.w(TAG, "getChildren(): Ignoring empty parentId");
            return;
        }
        if (i2 < 0) {
            Log.w(TAG, "getChildren(): Ignoring negative page");
        } else if (i3 < 1) {
            Log.w(TAG, "getChildren(): Ignoring pageSize less than 1");
        } else {
            final MediaLibraryService.LibraryParams libraryParams = bundle == null ? null : (MediaLibraryService.LibraryParams) MediaLibraryService.LibraryParams.CREATOR.fromBundle(bundle);
            dispatchSessionTaskWithSessionCommand(iMediaController, i, SessionCommand.COMMAND_CODE_LIBRARY_GET_CHILDREN, sendLibraryResultWhenReady(new SessionTask() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda52
                @Override // androidx.media3.session.MediaSessionStub.SessionTask
                public final Object run(MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i4) {
                    return ((MediaLibrarySessionImpl) mediaSessionImpl).onGetChildrenOnHandler(controllerInfo, str, i2, i3, libraryParams);
                }
            }));
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public void search(IMediaController iMediaController, int i, final String str, Bundle bundle) {
        if (iMediaController == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            Log.w(TAG, "search(): Ignoring empty query");
        } else {
            final MediaLibraryService.LibraryParams libraryParams = bundle == null ? null : (MediaLibraryService.LibraryParams) MediaLibraryService.LibraryParams.CREATOR.fromBundle(bundle);
            dispatchSessionTaskWithSessionCommand(iMediaController, i, SessionCommand.COMMAND_CODE_LIBRARY_SEARCH, sendLibraryResultWhenReady(new SessionTask() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda48
                @Override // androidx.media3.session.MediaSessionStub.SessionTask
                public final Object run(MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i2) {
                    return ((MediaLibrarySessionImpl) mediaSessionImpl).onSearchOnHandler(controllerInfo, str, libraryParams);
                }
            }));
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public void getSearchResult(IMediaController iMediaController, int i, final String str, final int i2, final int i3, Bundle bundle) {
        if (iMediaController == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            Log.w(TAG, "getSearchResult(): Ignoring empty query");
            return;
        }
        if (i2 < 0) {
            Log.w(TAG, "getSearchResult(): Ignoring negative page");
        } else if (i3 < 1) {
            Log.w(TAG, "getSearchResult(): Ignoring pageSize less than 1");
        } else {
            final MediaLibraryService.LibraryParams libraryParams = bundle == null ? null : (MediaLibraryService.LibraryParams) MediaLibraryService.LibraryParams.CREATOR.fromBundle(bundle);
            dispatchSessionTaskWithSessionCommand(iMediaController, i, SessionCommand.COMMAND_CODE_LIBRARY_GET_SEARCH_RESULT, sendLibraryResultWhenReady(new SessionTask() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda10
                @Override // androidx.media3.session.MediaSessionStub.SessionTask
                public final Object run(MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i4) {
                    return ((MediaLibrarySessionImpl) mediaSessionImpl).onGetSearchResultOnHandler(controllerInfo, str, i2, i3, libraryParams);
                }
            }));
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public void subscribe(IMediaController iMediaController, int i, final String str, Bundle bundle) {
        if (iMediaController == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            Log.w(TAG, "subscribe(): Ignoring empty parentId");
        } else {
            final MediaLibraryService.LibraryParams libraryParams = bundle == null ? null : (MediaLibraryService.LibraryParams) MediaLibraryService.LibraryParams.CREATOR.fromBundle(bundle);
            dispatchSessionTaskWithSessionCommand(iMediaController, i, SessionCommand.COMMAND_CODE_LIBRARY_SUBSCRIBE, sendLibraryResultWhenReady(new SessionTask() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda76
                @Override // androidx.media3.session.MediaSessionStub.SessionTask
                public final Object run(MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i2) {
                    return ((MediaLibrarySessionImpl) mediaSessionImpl).onSubscribeOnHandler(controllerInfo, str, libraryParams);
                }
            }));
        }
    }

    @Override // androidx.media3.session.IMediaSession
    public void unsubscribe(IMediaController iMediaController, int i, final String str) {
        if (iMediaController == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            Log.w(TAG, "unsubscribe(): Ignoring empty parentId");
        } else {
            dispatchSessionTaskWithSessionCommand(iMediaController, i, SessionCommand.COMMAND_CODE_LIBRARY_UNSUBSCRIBE, sendLibraryResultWhenReady(new SessionTask() { // from class: androidx.media3.session.MediaSessionStub$$ExternalSyntheticLambda74
                @Override // androidx.media3.session.MediaSessionStub.SessionTask
                public final Object run(MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo, int i2) {
                    return ((MediaLibrarySessionImpl) mediaSessionImpl).onUnsubscribeOnHandler(controllerInfo, str);
                }
            }));
        }
    }

    PlayerInfo generateAndCacheUniqueTrackGroupIds(PlayerInfo playerInfo) {
        ImmutableList<Tracks.Group> groups = playerInfo.currentTracks.getGroups();
        ImmutableList.Builder builder = ImmutableList.builder();
        ImmutableBiMap.Builder builder2 = ImmutableBiMap.builder();
        for (int i = 0; i < groups.size(); i++) {
            Tracks.Group group = groups.get(i);
            TrackGroup mediaTrackGroup = group.getMediaTrackGroup();
            String strGenerateUniqueTrackGroupId = this.trackGroupIdMap.get(mediaTrackGroup);
            if (strGenerateUniqueTrackGroupId == null) {
                strGenerateUniqueTrackGroupId = generateUniqueTrackGroupId(mediaTrackGroup);
            }
            builder2.put(mediaTrackGroup, strGenerateUniqueTrackGroupId);
            builder.add(group.copyWithId(strGenerateUniqueTrackGroupId));
        }
        this.trackGroupIdMap = builder2.buildOrThrow();
        PlayerInfo playerInfoCopyWithCurrentTracks = playerInfo.copyWithCurrentTracks(new Tracks(builder.build()));
        if (playerInfoCopyWithCurrentTracks.trackSelectionParameters.overrides.isEmpty()) {
            return playerInfoCopyWithCurrentTracks;
        }
        TrackSelectionParameters.Builder builderClearOverrides = playerInfoCopyWithCurrentTracks.trackSelectionParameters.buildUpon().clearOverrides();
        UnmodifiableIterator<TrackSelectionOverride> it = playerInfoCopyWithCurrentTracks.trackSelectionParameters.overrides.values().iterator();
        while (it.hasNext()) {
            TrackSelectionOverride next = it.next();
            TrackGroup trackGroup = next.mediaTrackGroup;
            String str = this.trackGroupIdMap.get(trackGroup);
            if (str != null) {
                builderClearOverrides.addOverride(new TrackSelectionOverride(trackGroup.copyWithId(str), next.trackIndices));
            } else {
                builderClearOverrides.addOverride(next);
            }
        }
        return playerInfoCopyWithCurrentTracks.copyWithTrackSelectionParameters(builderClearOverrides.build());
    }

    private TrackSelectionParameters updateOverridesUsingUniqueTrackGroupIds(TrackSelectionParameters trackSelectionParameters) {
        if (trackSelectionParameters.overrides.isEmpty()) {
            return trackSelectionParameters;
        }
        TrackSelectionParameters.Builder builderClearOverrides = trackSelectionParameters.buildUpon().clearOverrides();
        UnmodifiableIterator<TrackSelectionOverride> it = trackSelectionParameters.overrides.values().iterator();
        while (it.hasNext()) {
            TrackSelectionOverride next = it.next();
            TrackGroup trackGroup = this.trackGroupIdMap.inverse().get(next.mediaTrackGroup.id);
            if (trackGroup != null && next.mediaTrackGroup.length == trackGroup.length) {
                builderClearOverrides.addOverride(new TrackSelectionOverride(trackGroup, next.trackIndices));
            } else {
                builderClearOverrides.addOverride(next);
            }
        }
        return builderClearOverrides.build();
    }

    private String generateUniqueTrackGroupId(TrackGroup trackGroup) {
        StringBuilder sb = new StringBuilder();
        int i = this.nextUniqueTrackGroupIdPrefix;
        this.nextUniqueTrackGroupIdPrefix = i + 1;
        return sb.append(Util.intToStringMaxRadix(i)).append("-").append(trackGroup.id).toString();
    }

    static final class Controller2Cb implements MediaSession.ControllerCb {
        private final IMediaController iController;

        public Controller2Cb(IMediaController iMediaController) {
            this.iController = iMediaController;
        }

        public IBinder getCallbackBinder() {
            return this.iController.asBinder();
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onSessionResult(int i, SessionResult sessionResult) throws RemoteException {
            this.iController.onSessionResult(i, sessionResult.toBundle());
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onLibraryResult(int i, LibraryResult<?> libraryResult) throws RemoteException {
            this.iController.onLibraryResult(i, libraryResult.toBundle());
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onPlayerInfoChanged(int i, PlayerInfo playerInfo, Player.Commands commands, boolean z, boolean z2, int i2) throws RemoteException {
            Assertions.checkState(i2 != 0);
            boolean z3 = z || !commands.contains(17);
            boolean z4 = z2 || !commands.contains(30);
            if (i2 >= 2) {
                this.iController.onPlayerInfoChangedWithExclusions(i, playerInfo.toBundle(commands, z, z2), new PlayerInfo.BundlingExclusions(z3, z4).toBundle());
            } else {
                this.iController.onPlayerInfoChanged(i, playerInfo.toBundle(commands, z, true), z3);
            }
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void setCustomLayout(int i, List<CommandButton> list) throws RemoteException {
            this.iController.onSetCustomLayout(i, BundleableUtil.toBundleList(list));
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onSessionActivityChanged(int i, PendingIntent pendingIntent) throws RemoteException {
            this.iController.onSessionActivityChanged(i, pendingIntent);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onAvailableCommandsChangedFromSession(int i, SessionCommands sessionCommands, Player.Commands commands) throws RemoteException {
            this.iController.onAvailableCommandsChangedFromSession(i, sessionCommands.toBundle(), commands.toBundle());
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onAvailableCommandsChangedFromPlayer(int i, Player.Commands commands) throws RemoteException {
            this.iController.onAvailableCommandsChangedFromPlayer(i, commands.toBundle());
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void sendCustomCommand(int i, SessionCommand sessionCommand, Bundle bundle) throws RemoteException {
            this.iController.onCustomCommand(i, sessionCommand.toBundle(), bundle);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onChildrenChanged(int i, String str, int i2, MediaLibraryService.LibraryParams libraryParams) throws RemoteException {
            this.iController.onChildrenChanged(i, str, i2, libraryParams == null ? null : libraryParams.toBundle());
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onSearchResultChanged(int i, String str, int i2, MediaLibraryService.LibraryParams libraryParams) throws RemoteException {
            this.iController.onSearchResultChanged(i, str, i2, libraryParams == null ? null : libraryParams.toBundle());
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onDisconnected(int i) throws RemoteException {
            this.iController.onDisconnected(i);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onPeriodicSessionPositionInfoChanged(int i, SessionPositionInfo sessionPositionInfo, boolean z, boolean z2) throws RemoteException {
            this.iController.onPeriodicSessionPositionInfoChanged(i, sessionPositionInfo.toBundle(z, z2));
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onRenderedFirstFrame(int i) throws RemoteException {
            this.iController.onRenderedFirstFrame(i);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onSessionExtrasChanged(int i, Bundle bundle) throws RemoteException {
            this.iController.onExtrasChanged(i, bundle);
        }

        public int hashCode() {
            return ObjectsCompat.hash(getCallbackBinder());
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != Controller2Cb.class) {
                return false;
            }
            return Util.areEqual(getCallbackBinder(), ((Controller2Cb) obj).getCallbackBinder());
        }
    }
}
