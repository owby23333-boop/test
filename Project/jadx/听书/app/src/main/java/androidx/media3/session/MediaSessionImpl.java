package androidx.media3.session;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.core.os.ExecutorCompat;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Rating;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.session.MediaSession;
import androidx.media3.session.PlayerInfo;
import androidx.media3.session.SequencedFutureManager;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
class MediaSessionImpl {
    private static final long DEFAULT_SESSION_POSITION_UPDATE_DELAY_MS = 3000;
    private static final SessionResult RESULT_WHEN_CLOSED = new SessionResult(1);
    public static final String TAG = "MSImplBase";
    private static final String WRONG_THREAD_ERROR_MESSAGE = "Player callback method is called from a wrong thread. See javadoc of MediaSession for details.";
    private final Handler applicationHandler;
    private final androidx.media3.common.util.BitmapLoader bitmapLoader;
    private MediaSessionServiceLegacyStub browserServiceLegacyStub;
    private final MediaSession.Callback callback;
    private boolean closed;
    private final Context context;
    private MediaSession.ControllerInfo controllerForCurrentRequest;
    private ImmutableList<CommandButton> customLayout;
    private final MediaSession instance;
    protected final Object lock = new Object();
    private final Handler mainHandler;
    private MediaSession.Listener mediaSessionListener;
    private final PlayerInfoChangedHandler onPlayerInfoChangedHandler;
    private final Runnable periodicSessionPositionInfoUpdateRunnable;
    private PlayerInfo playerInfo;
    private PlayerListener playerListener;
    private PlayerWrapper playerWrapper;
    private PendingIntent sessionActivity;
    private final String sessionId;
    private final MediaSessionLegacyStub sessionLegacyStub;
    private long sessionPositionUpdateDelayMs;
    private final MediaSessionStub sessionStub;
    private final SessionToken sessionToken;
    private final Uri sessionUri;

    interface RemoteControllerTask {
        void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException;
    }

    public MediaSessionImpl(MediaSession mediaSession, Context context, String str, Player player, PendingIntent pendingIntent, ImmutableList<CommandButton> immutableList, MediaSession.Callback callback, Bundle bundle, androidx.media3.common.util.BitmapLoader bitmapLoader) {
        this.context = context;
        this.instance = mediaSession;
        MediaSessionStub mediaSessionStub = new MediaSessionStub(this);
        this.sessionStub = mediaSessionStub;
        this.sessionActivity = pendingIntent;
        this.customLayout = immutableList;
        this.mainHandler = new Handler(Looper.getMainLooper());
        Handler handler = new Handler(player.getApplicationLooper());
        this.applicationHandler = handler;
        this.callback = callback;
        this.bitmapLoader = bitmapLoader;
        this.playerInfo = PlayerInfo.DEFAULT;
        this.onPlayerInfoChangedHandler = new PlayerInfoChangedHandler(player.getApplicationLooper());
        this.sessionId = str;
        Uri uriBuild = new Uri.Builder().scheme(MediaSessionImpl.class.getName()).appendPath(str).appendPath(String.valueOf(SystemClock.elapsedRealtime())).build();
        this.sessionUri = uriBuild;
        this.sessionToken = new SessionToken(Process.myUid(), 0, MediaLibraryInfo.VERSION_INT, 2, context.getPackageName(), mediaSessionStub, bundle);
        this.sessionLegacyStub = new MediaSessionLegacyStub(this, uriBuild, handler);
        final PlayerWrapper playerWrapper = new PlayerWrapper(player);
        this.playerWrapper = playerWrapper;
        playerWrapper.setCustomLayout(immutableList);
        Util.postOrRun(handler, new Runnable() { // from class: androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda14
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.setPlayerInternal(null, playerWrapper);
            }
        });
        this.sessionPositionUpdateDelayMs = 3000L;
        Objects.requireNonNull(this);
        this.periodicSessionPositionInfoUpdateRunnable = new Runnable() { // from class: androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda15
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.notifyPeriodicSessionPositionInfoChangesOnHandler();
            }
        };
        Objects.requireNonNull(this);
        Util.postOrRun(handler, new Runnable() { // from class: androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda16
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.schedulePeriodicSessionPositionInfoChanges();
            }
        });
    }

    public void setPlayer(Player player) {
        if (player == this.playerWrapper.getWrappedPlayer()) {
            return;
        }
        setPlayerInternal(this.playerWrapper, new PlayerWrapper(player));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPlayerInternal(final PlayerWrapper playerWrapper, final PlayerWrapper playerWrapper2) {
        this.playerWrapper = playerWrapper2;
        playerWrapper2.setCustomLayout(this.customLayout);
        if (playerWrapper != null) {
            playerWrapper.removeListener((Player.Listener) Assertions.checkStateNotNull(this.playerListener));
        }
        PlayerListener playerListener = new PlayerListener(this, playerWrapper2);
        playerWrapper2.addListener(playerListener);
        this.playerListener = playerListener;
        dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda9
            @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
            public final void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                controllerCb.onPlayerChanged(i, playerWrapper, playerWrapper2);
            }
        });
        if (playerWrapper == null) {
            this.sessionLegacyStub.start();
        }
        this.playerInfo = playerWrapper2.createPlayerInfoForBundling();
        handleAvailablePlayerCommandsChanged(playerWrapper2.getAvailableCommands());
    }

    public void release() {
        synchronized (this.lock) {
            if (this.closed) {
                return;
            }
            this.closed = true;
            this.applicationHandler.removeCallbacksAndMessages(null);
            try {
                Util.postOrRun(this.applicationHandler, new Runnable() { // from class: androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda6
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.m363lambda$release$2$androidxmedia3sessionMediaSessionImpl();
                    }
                });
            } catch (Exception e) {
                Log.w(TAG, "Exception thrown while closing", e);
            }
            this.sessionLegacyStub.release();
            this.sessionStub.release();
        }
    }

    /* JADX INFO: renamed from: lambda$release$2$androidx-media3-session-MediaSessionImpl, reason: not valid java name */
    /* synthetic */ void m363lambda$release$2$androidxmedia3sessionMediaSessionImpl() {
        PlayerListener playerListener = this.playerListener;
        if (playerListener != null) {
            this.playerWrapper.removeListener(playerListener);
        }
    }

    public PlayerWrapper getPlayerWrapper() {
        return this.playerWrapper;
    }

    public Runnable callWithControllerForCurrentRequestSet(final MediaSession.ControllerInfo controllerInfo, final Runnable runnable) {
        return new Runnable() { // from class: androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m359x8683e518(controllerInfo, runnable);
            }
        };
    }

    /* JADX INFO: renamed from: lambda$callWithControllerForCurrentRequestSet$3$androidx-media3-session-MediaSessionImpl, reason: not valid java name */
    /* synthetic */ void m359x8683e518(MediaSession.ControllerInfo controllerInfo, Runnable runnable) {
        this.controllerForCurrentRequest = controllerInfo;
        runnable.run();
        this.controllerForCurrentRequest = null;
    }

    public String getId() {
        return this.sessionId;
    }

    public Uri getUri() {
        return this.sessionUri;
    }

    public SessionToken getToken() {
        return this.sessionToken;
    }

    public List<MediaSession.ControllerInfo> getConnectedControllers() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.sessionStub.getConnectedControllersManager().getConnectedControllers());
        arrayList.addAll(this.sessionLegacyStub.getConnectedControllersManager().getConnectedControllers());
        return arrayList;
    }

    public MediaSession.ControllerInfo getControllerForCurrentRequest() {
        return this.controllerForCurrentRequest;
    }

    public boolean isConnected(MediaSession.ControllerInfo controllerInfo) {
        return this.sessionStub.getConnectedControllersManager().isConnected(controllerInfo) || this.sessionLegacyStub.getConnectedControllersManager().isConnected(controllerInfo);
    }

    public ListenableFuture<SessionResult> setCustomLayout(MediaSession.ControllerInfo controllerInfo, final List<CommandButton> list) {
        return dispatchRemoteControllerTask(controllerInfo, new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda10
            @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
            public final void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                controllerCb.setCustomLayout(i, list);
            }
        });
    }

    public void setCustomLayout(final List<CommandButton> list) {
        ImmutableList<CommandButton> immutableListCopyOf = ImmutableList.copyOf((Collection) list);
        this.customLayout = immutableListCopyOf;
        this.playerWrapper.setCustomLayout(immutableListCopyOf);
        dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda5
            @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
            public final void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                controllerCb.setCustomLayout(i, list);
            }
        });
    }

    public void setSessionExtras(final Bundle bundle) {
        dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda3
            @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
            public final void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                controllerCb.onSessionExtrasChanged(i, bundle);
            }
        });
    }

    public void setSessionExtras(MediaSession.ControllerInfo controllerInfo, final Bundle bundle) {
        if (this.sessionStub.getConnectedControllersManager().isConnected(controllerInfo)) {
            dispatchRemoteControllerTaskWithoutReturn(controllerInfo, new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda1
                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onSessionExtrasChanged(i, bundle);
                }
            });
        }
    }

    public androidx.media3.common.util.BitmapLoader getBitmapLoader() {
        return this.bitmapLoader;
    }

    public void setAvailableCommands(MediaSession.ControllerInfo controllerInfo, final SessionCommands sessionCommands, final Player.Commands commands) {
        if (this.sessionStub.getConnectedControllersManager().isConnected(controllerInfo)) {
            this.sessionStub.getConnectedControllersManager().updateCommandsFromSession(controllerInfo, sessionCommands, commands);
            dispatchRemoteControllerTaskWithoutReturn(controllerInfo, new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda7
                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onAvailableCommandsChangedFromSession(i, sessionCommands, commands);
                }
            });
            this.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(false, false);
            return;
        }
        this.sessionLegacyStub.getConnectedControllersManager().updateCommandsFromSession(controllerInfo, sessionCommands, commands);
    }

    public void broadcastCustomCommand(final SessionCommand sessionCommand, final Bundle bundle) {
        dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda2
            @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
            public final void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                controllerCb.sendCustomCommand(i, sessionCommand, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchOnPlayerInfoChanged(PlayerInfo playerInfo, boolean z, boolean z2) {
        int iObtainNextSequenceNumber;
        PlayerInfo playerInfoGenerateAndCacheUniqueTrackGroupIds = this.sessionStub.generateAndCacheUniqueTrackGroupIds(playerInfo);
        ImmutableList<MediaSession.ControllerInfo> connectedControllers = this.sessionStub.getConnectedControllersManager().getConnectedControllers();
        for (int i = 0; i < connectedControllers.size(); i++) {
            MediaSession.ControllerInfo controllerInfo = connectedControllers.get(i);
            try {
                ConnectedControllersManager<IBinder> connectedControllersManager = this.sessionStub.getConnectedControllersManager();
                SequencedFutureManager sequencedFutureManager = connectedControllersManager.getSequencedFutureManager(controllerInfo);
                if (sequencedFutureManager != null) {
                    iObtainNextSequenceNumber = sequencedFutureManager.obtainNextSequenceNumber();
                } else if (!isConnected(controllerInfo)) {
                    return;
                } else {
                    iObtainNextSequenceNumber = 0;
                }
                ((MediaSession.ControllerCb) Assertions.checkStateNotNull(controllerInfo.getControllerCb())).onPlayerInfoChanged(iObtainNextSequenceNumber, playerInfoGenerateAndCacheUniqueTrackGroupIds, MediaUtils.intersect(connectedControllersManager.getAvailablePlayerCommands(controllerInfo), getPlayerWrapper().getAvailableCommands()), z, z2, controllerInfo.getInterfaceVersion());
            } catch (DeadObjectException unused) {
                onDeadObjectException(controllerInfo);
            } catch (RemoteException e) {
                Log.w(TAG, "Exception in " + controllerInfo.toString(), e);
            }
        }
    }

    public ListenableFuture<SessionResult> sendCustomCommand(MediaSession.ControllerInfo controllerInfo, final SessionCommand sessionCommand, final Bundle bundle) {
        return dispatchRemoteControllerTask(controllerInfo, new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda11
            @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
            public final void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                controllerCb.sendCustomCommand(i, sessionCommand, bundle);
            }
        });
    }

    public MediaSession.ConnectionResult onConnectOnHandler(MediaSession.ControllerInfo controllerInfo) {
        return (MediaSession.ConnectionResult) Assertions.checkNotNull(this.callback.onConnect(this.instance, controllerInfo), "Callback.onConnect must return non-null future");
    }

    public void onPostConnectOnHandler(MediaSession.ControllerInfo controllerInfo) {
        this.callback.onPostConnect(this.instance, controllerInfo);
    }

    public void onDisconnectedOnHandler(MediaSession.ControllerInfo controllerInfo) {
        this.callback.onDisconnected(this.instance, controllerInfo);
    }

    public int onPlayerCommandRequestOnHandler(MediaSession.ControllerInfo controllerInfo, int i) {
        return this.callback.onPlayerCommandRequest(this.instance, controllerInfo, i);
    }

    public ListenableFuture<SessionResult> onSetRatingOnHandler(MediaSession.ControllerInfo controllerInfo, String str, Rating rating) {
        return (ListenableFuture) Assertions.checkNotNull(this.callback.onSetRating(this.instance, controllerInfo, str, rating), "Callback.onSetRating must return non-null future");
    }

    public ListenableFuture<SessionResult> onSetRatingOnHandler(MediaSession.ControllerInfo controllerInfo, Rating rating) {
        return (ListenableFuture) Assertions.checkNotNull(this.callback.onSetRating(this.instance, controllerInfo, rating), "Callback.onSetRating must return non-null future");
    }

    public ListenableFuture<SessionResult> onCustomCommandOnHandler(MediaSession.ControllerInfo controllerInfo, SessionCommand sessionCommand, Bundle bundle) {
        return (ListenableFuture) Assertions.checkNotNull(this.callback.onCustomCommand(this.instance, controllerInfo, sessionCommand, bundle), "Callback.onCustomCommandOnHandler must return non-null future");
    }

    public void connectFromService(IMediaController iMediaController, int i, int i2, String str, int i3, int i4, Bundle bundle) {
        this.sessionStub.connect(iMediaController, i, i2, str, i3, i4, (Bundle) Assertions.checkStateNotNull(bundle));
    }

    public MediaSessionCompat getSessionCompat() {
        return this.sessionLegacyStub.getSessionCompat();
    }

    public void setLegacyControllerConnectionTimeoutMs(long j) {
        this.sessionLegacyStub.setLegacyControllerDisconnectTimeoutMs(j);
    }

    protected Context getContext() {
        return this.context;
    }

    protected Handler getApplicationHandler() {
        return this.applicationHandler;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ListenableFuture<List<MediaItem>> onAddMediaItemsOnHandler(MediaSession.ControllerInfo controllerInfo, List<MediaItem> list) {
        return (ListenableFuture) Assertions.checkNotNull(this.callback.onAddMediaItems(this.instance, controllerInfo, list), "Callback.onAddMediaItems must return a non-null future");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ListenableFuture<MediaSession.MediaItemsWithStartPosition> onSetMediaItemsOnHandler(MediaSession.ControllerInfo controllerInfo, List<MediaItem> list, int i, long j) {
        return (ListenableFuture) Assertions.checkNotNull(this.callback.onSetMediaItems(this.instance, controllerInfo, list, i, j), "Callback.onSetMediaItems must return a non-null future");
    }

    protected boolean isReleased() {
        boolean z;
        synchronized (this.lock) {
            z = this.closed;
        }
        return z;
    }

    protected PendingIntent getSessionActivity() {
        return this.sessionActivity;
    }

    protected ImmutableList<CommandButton> getCustomLayout() {
        return this.customLayout;
    }

    protected void setSessionActivity(final PendingIntent pendingIntent) {
        if (Objects.equals(this.sessionActivity, pendingIntent)) {
            return;
        }
        this.sessionActivity = pendingIntent;
        this.sessionLegacyStub.getSessionCompat().setSessionActivity(pendingIntent);
        ImmutableList<MediaSession.ControllerInfo> connectedControllers = this.sessionStub.getConnectedControllersManager().getConnectedControllers();
        for (int i = 0; i < connectedControllers.size(); i++) {
            MediaSession.ControllerInfo controllerInfo = connectedControllers.get(i);
            if (controllerInfo.getControllerVersion() >= 3) {
                dispatchRemoteControllerTaskWithoutReturn(controllerInfo, new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda13
                    @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                    public final void run(MediaSession.ControllerCb controllerCb, int i2) throws RemoteException {
                        controllerCb.onSessionActivityChanged(i2, pendingIntent);
                    }
                });
            }
        }
    }

    protected IBinder getLegacyBrowserServiceBinder() {
        MediaSessionServiceLegacyStub mediaSessionServiceLegacyStub;
        synchronized (this.lock) {
            if (this.browserServiceLegacyStub == null) {
                this.browserServiceLegacyStub = createLegacyBrowserService(this.instance.getSessionCompat().getSessionToken());
            }
            mediaSessionServiceLegacyStub = this.browserServiceLegacyStub;
        }
        return mediaSessionServiceLegacyStub.onBind(new Intent(MediaBrowserServiceCompat.SERVICE_INTERFACE));
    }

    protected MediaSessionServiceLegacyStub createLegacyBrowserService(MediaSessionCompat.Token token) {
        MediaSessionServiceLegacyStub mediaSessionServiceLegacyStub = new MediaSessionServiceLegacyStub(this);
        mediaSessionServiceLegacyStub.initialize(token);
        return mediaSessionServiceLegacyStub;
    }

    protected void setSessionPositionUpdateDelayMsOnHandler(long j) {
        verifyApplicationThread();
        this.sessionPositionUpdateDelayMs = j;
        schedulePeriodicSessionPositionInfoChanges();
    }

    protected MediaSessionServiceLegacyStub getLegacyBrowserService() {
        MediaSessionServiceLegacyStub mediaSessionServiceLegacyStub;
        synchronized (this.lock) {
            mediaSessionServiceLegacyStub = this.browserServiceLegacyStub;
        }
        return mediaSessionServiceLegacyStub;
    }

    boolean canResumePlaybackOnStart() {
        return this.sessionLegacyStub.canResumePlaybackOnStart();
    }

    void setMediaSessionListener(MediaSession.Listener listener) {
        this.mediaSessionListener = listener;
    }

    void clearMediaSessionListener() {
        this.mediaSessionListener = null;
    }

    void onNotificationRefreshRequired() {
        Util.postOrRun(this.mainHandler, new Runnable() { // from class: androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m361x831b50d5();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onNotificationRefreshRequired$12$androidx-media3-session-MediaSessionImpl, reason: not valid java name */
    /* synthetic */ void m361x831b50d5() {
        MediaSession.Listener listener = this.mediaSessionListener;
        if (listener != null) {
            listener.onNotificationRefreshRequired(this.instance);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    boolean onPlayRequested() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            final SettableFuture settableFutureCreate = SettableFuture.create();
            this.mainHandler.post(new Runnable() { // from class: androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m362x75435bdf(settableFutureCreate);
                }
            });
            try {
                return ((Boolean) settableFutureCreate.get()).booleanValue();
            } catch (InterruptedException | ExecutionException e) {
                throw new IllegalStateException(e);
            }
        }
        MediaSession.Listener listener = this.mediaSessionListener;
        if (listener != null) {
            return listener.onPlayRequested(this.instance);
        }
        return true;
    }

    /* JADX INFO: renamed from: lambda$onPlayRequested$13$androidx-media3-session-MediaSessionImpl, reason: not valid java name */
    /* synthetic */ void m362x75435bdf(SettableFuture settableFuture) {
        settableFuture.set(Boolean.valueOf(onPlayRequested()));
    }

    void prepareAndPlayForPlaybackResumption(MediaSession.ControllerInfo controllerInfo, final Player player) {
        Executor executorCreate;
        verifyApplicationThread();
        ListenableFuture listenableFuture = (ListenableFuture) Assertions.checkNotNull(this.callback.onPlaybackResumption(this.instance, controllerInfo), "Callback.onPlaybackResumption must return a non-null future");
        if (listenableFuture.isDone()) {
            executorCreate = MoreExecutors.directExecutor();
        } else {
            executorCreate = ExecutorCompat.create(getApplicationHandler());
        }
        Futures.addCallback(listenableFuture, new FutureCallback<MediaSession.MediaItemsWithStartPosition>() { // from class: androidx.media3.session.MediaSessionImpl.1
            @Override // com.google.common.util.concurrent.FutureCallback
            public void onSuccess(MediaSession.MediaItemsWithStartPosition mediaItemsWithStartPosition) {
                ImmutableList<MediaItem> immutableList = mediaItemsWithStartPosition.mediaItems;
                player.setMediaItems(immutableList, mediaItemsWithStartPosition.startIndex != -1 ? Math.min(immutableList.size() - 1, mediaItemsWithStartPosition.startIndex) : 0, mediaItemsWithStartPosition.startPositionMs);
                if (player.getPlaybackState() == 1) {
                    player.prepare();
                }
                player.play();
            }

            @Override // com.google.common.util.concurrent.FutureCallback
            public void onFailure(Throwable th) {
                if (th instanceof UnsupportedOperationException) {
                    Log.w(MediaSessionImpl.TAG, "UnsupportedOperationException: Make sure to implement MediaSession.Callback.onPlaybackResumption() if you add a media button receiver to your manifest or if you implement the recent media item contract with your MediaLibraryService.", th);
                } else {
                    Log.e(MediaSessionImpl.TAG, "Failure calling MediaSession.Callback.onPlaybackResumption(): " + th.getMessage(), th);
                }
                Util.handlePlayButtonAction(player);
            }
        }, executorCreate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchRemoteControllerTaskToLegacyStub(RemoteControllerTask remoteControllerTask) {
        try {
            remoteControllerTask.run(this.sessionLegacyStub.getControllerLegacyCbForBroadcast(), 0);
        } catch (RemoteException e) {
            Log.e(TAG, "Exception in using media1 API", e);
        }
    }

    private void dispatchOnPeriodicSessionPositionInfoChanged(final SessionPositionInfo sessionPositionInfo) {
        ConnectedControllersManager<IBinder> connectedControllersManager = this.sessionStub.getConnectedControllersManager();
        ImmutableList<MediaSession.ControllerInfo> connectedControllers = this.sessionStub.getConnectedControllersManager().getConnectedControllers();
        for (int i = 0; i < connectedControllers.size(); i++) {
            MediaSession.ControllerInfo controllerInfo = connectedControllers.get(i);
            final boolean zIsPlayerCommandAvailable = connectedControllersManager.isPlayerCommandAvailable(controllerInfo, 16);
            final boolean zIsPlayerCommandAvailable2 = connectedControllersManager.isPlayerCommandAvailable(controllerInfo, 17);
            dispatchRemoteControllerTaskWithoutReturn(controllerInfo, new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda4
                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i2) throws RemoteException {
                    controllerCb.onPeriodicSessionPositionInfoChanged(i2, sessionPositionInfo, zIsPlayerCommandAvailable, zIsPlayerCommandAvailable2);
                }
            });
        }
        try {
            this.sessionLegacyStub.getControllerLegacyCbForBroadcast().onPeriodicSessionPositionInfoChanged(0, sessionPositionInfo, true, true);
        } catch (RemoteException e) {
            Log.e(TAG, "Exception in using media1 API", e);
        }
    }

    protected void dispatchRemoteControllerTaskWithoutReturn(RemoteControllerTask remoteControllerTask) {
        ImmutableList<MediaSession.ControllerInfo> connectedControllers = this.sessionStub.getConnectedControllersManager().getConnectedControllers();
        for (int i = 0; i < connectedControllers.size(); i++) {
            dispatchRemoteControllerTaskWithoutReturn(connectedControllers.get(i), remoteControllerTask);
        }
        try {
            remoteControllerTask.run(this.sessionLegacyStub.getControllerLegacyCbForBroadcast(), 0);
        } catch (RemoteException e) {
            Log.e(TAG, "Exception in using media1 API", e);
        }
    }

    protected void dispatchRemoteControllerTaskWithoutReturn(MediaSession.ControllerInfo controllerInfo, RemoteControllerTask remoteControllerTask) {
        int iObtainNextSequenceNumber;
        try {
            SequencedFutureManager sequencedFutureManager = this.sessionStub.getConnectedControllersManager().getSequencedFutureManager(controllerInfo);
            if (sequencedFutureManager != null) {
                iObtainNextSequenceNumber = sequencedFutureManager.obtainNextSequenceNumber();
            } else if (!isConnected(controllerInfo)) {
                return;
            } else {
                iObtainNextSequenceNumber = 0;
            }
            MediaSession.ControllerCb controllerCb = controllerInfo.getControllerCb();
            if (controllerCb != null) {
                remoteControllerTask.run(controllerCb, iObtainNextSequenceNumber);
            }
        } catch (DeadObjectException unused) {
            onDeadObjectException(controllerInfo);
        } catch (RemoteException e) {
            Log.w(TAG, "Exception in " + controllerInfo.toString(), e);
        }
    }

    private ListenableFuture<SessionResult> dispatchRemoteControllerTask(MediaSession.ControllerInfo controllerInfo, RemoteControllerTask remoteControllerTask) {
        int sequenceNumber;
        ListenableFuture<SessionResult> listenableFutureImmediateFuture;
        try {
            SequencedFutureManager sequencedFutureManager = this.sessionStub.getConnectedControllersManager().getSequencedFutureManager(controllerInfo);
            if (sequencedFutureManager != null) {
                SequencedFutureManager.SequencedFuture sequencedFutureCreateSequencedFuture = sequencedFutureManager.createSequencedFuture(RESULT_WHEN_CLOSED);
                SequencedFutureManager.SequencedFuture sequencedFuture = sequencedFutureCreateSequencedFuture;
                sequenceNumber = sequencedFutureCreateSequencedFuture.getSequenceNumber();
                listenableFutureImmediateFuture = sequencedFutureCreateSequencedFuture;
            } else {
                if (!isConnected(controllerInfo)) {
                    return Futures.immediateFuture(new SessionResult(-100));
                }
                sequenceNumber = 0;
                listenableFutureImmediateFuture = Futures.immediateFuture(new SessionResult(0));
            }
            MediaSession.ControllerCb controllerCb = controllerInfo.getControllerCb();
            if (controllerCb != null) {
                remoteControllerTask.run(controllerCb, sequenceNumber);
            }
            return listenableFutureImmediateFuture;
        } catch (DeadObjectException unused) {
            onDeadObjectException(controllerInfo);
            return Futures.immediateFuture(new SessionResult(-100));
        } catch (RemoteException e) {
            Log.w(TAG, "Exception in " + controllerInfo.toString(), e);
            return Futures.immediateFuture(new SessionResult(-1));
        }
    }

    private void onDeadObjectException(MediaSession.ControllerInfo controllerInfo) {
        this.sessionStub.getConnectedControllersManager().removeController(controllerInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void verifyApplicationThread() {
        if (Looper.myLooper() != this.applicationHandler.getLooper()) {
            throw new IllegalStateException(WRONG_THREAD_ERROR_MESSAGE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyPeriodicSessionPositionInfoChangesOnHandler() {
        synchronized (this.lock) {
            if (this.closed) {
                return;
            }
            SessionPositionInfo sessionPositionInfoCreateSessionPositionInfoForBundling = this.playerWrapper.createSessionPositionInfoForBundling();
            if (!this.onPlayerInfoChangedHandler.hasPendingPlayerInfoChangedUpdate() && MediaUtils.areSessionPositionInfosInSamePeriodOrAd(sessionPositionInfoCreateSessionPositionInfoForBundling, this.playerInfo.sessionPositionInfo)) {
                dispatchOnPeriodicSessionPositionInfoChanged(sessionPositionInfoCreateSessionPositionInfoForBundling);
            }
            schedulePeriodicSessionPositionInfoChanges();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void schedulePeriodicSessionPositionInfoChanges() {
        this.applicationHandler.removeCallbacks(this.periodicSessionPositionInfoUpdateRunnable);
        if (this.sessionPositionUpdateDelayMs > 0) {
            if (this.playerWrapper.isPlaying() || this.playerWrapper.isLoading()) {
                this.applicationHandler.postDelayed(this.periodicSessionPositionInfoUpdateRunnable, this.sessionPositionUpdateDelayMs);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleAvailablePlayerCommandsChanged(final Player.Commands commands) {
        this.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(false, false);
        dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda17
            @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
            public final void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                controllerCb.onAvailableCommandsChangedFromPlayer(i, commands);
            }
        });
        dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$$ExternalSyntheticLambda18
            @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
            public final void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                this.f$0.m360x8219cf45(controllerCb, i);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$handleAvailablePlayerCommandsChanged$16$androidx-media3-session-MediaSessionImpl, reason: not valid java name */
    /* synthetic */ void m360x8219cf45(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
        controllerCb.onDeviceInfoChanged(i, this.playerInfo.deviceInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class PlayerListener implements Player.Listener {
        private final WeakReference<PlayerWrapper> player;
        private final WeakReference<MediaSessionImpl> session;

        public PlayerListener(MediaSessionImpl mediaSessionImpl, PlayerWrapper playerWrapper) {
            this.session = new WeakReference<>(mediaSessionImpl);
            this.player = new WeakReference<>(playerWrapper);
        }

        @Override // androidx.media3.common.Player.Listener
        public void onPlayerError(final PlaybackException playbackException) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            if (this.player.get() == null) {
                return;
            }
            session.playerInfo = session.playerInfo.copyWithPlayerError(playbackException);
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
            session.dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$PlayerListener$$ExternalSyntheticLambda19
                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onPlayerError(i, playbackException);
                }
            });
        }

        @Override // androidx.media3.common.Player.Listener
        public void onMediaItemTransition(final MediaItem mediaItem, final int i) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            if (this.player.get() == null) {
                return;
            }
            session.playerInfo = session.playerInfo.copyWithMediaItemTransitionReason(i);
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
            session.dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$PlayerListener$$ExternalSyntheticLambda17
                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i2) throws RemoteException {
                    controllerCb.onMediaItemTransition(i2, mediaItem, i);
                }
            });
        }

        @Override // androidx.media3.common.Player.Listener
        public void onPlayWhenReadyChanged(final boolean z, final int i) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            if (this.player.get() == null) {
                return;
            }
            session.playerInfo = session.playerInfo.copyWithPlayWhenReady(z, i, session.playerInfo.playbackSuppressionReason);
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
            session.dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$PlayerListener$$ExternalSyntheticLambda20
                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i2) throws RemoteException {
                    controllerCb.onPlayWhenReadyChanged(i2, z, i);
                }
            });
        }

        @Override // androidx.media3.common.Player.Listener
        public void onPlaybackSuppressionReasonChanged(final int i) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            if (this.player.get() == null) {
                return;
            }
            session.playerInfo = session.playerInfo.copyWithPlayWhenReady(session.playerInfo.playWhenReady, session.playerInfo.playWhenReadyChangeReason, i);
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
            session.dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$PlayerListener$$ExternalSyntheticLambda7
                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i2) throws RemoteException {
                    controllerCb.onPlaybackSuppressionReasonChanged(i2, i);
                }
            });
        }

        @Override // androidx.media3.common.Player.Listener
        public void onPlaybackStateChanged(final int i) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            final PlayerWrapper playerWrapper = this.player.get();
            if (playerWrapper == null) {
                return;
            }
            session.playerInfo = session.playerInfo.copyWithPlaybackState(i, playerWrapper.getPlayerError());
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
            session.dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$PlayerListener$$ExternalSyntheticLambda11
                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i2) throws RemoteException {
                    controllerCb.onPlaybackStateChanged(i2, i, playerWrapper.getPlayerError());
                }
            });
        }

        @Override // androidx.media3.common.Player.Listener
        public void onIsPlayingChanged(final boolean z) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            if (this.player.get() == null) {
                return;
            }
            session.playerInfo = session.playerInfo.copyWithIsPlaying(z);
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
            session.dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$PlayerListener$$ExternalSyntheticLambda8
                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onIsPlayingChanged(i, z);
                }
            });
            session.schedulePeriodicSessionPositionInfoChanges();
        }

        @Override // androidx.media3.common.Player.Listener
        public void onIsLoadingChanged(final boolean z) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            if (this.player.get() == null) {
                return;
            }
            session.playerInfo = session.playerInfo.copyWithIsLoading(z);
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
            session.dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$PlayerListener$$ExternalSyntheticLambda15
                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onIsLoadingChanged(i, z);
                }
            });
            session.schedulePeriodicSessionPositionInfoChanges();
        }

        @Override // androidx.media3.common.Player.Listener
        public void onPositionDiscontinuity(final Player.PositionInfo positionInfo, final Player.PositionInfo positionInfo2, final int i) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            if (this.player.get() == null) {
                return;
            }
            session.playerInfo = session.playerInfo.copyWithPositionInfos(positionInfo, positionInfo2, i);
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
            session.dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$PlayerListener$$ExternalSyntheticLambda12
                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i2) throws RemoteException {
                    controllerCb.onPositionDiscontinuity(i2, positionInfo, positionInfo2, i);
                }
            });
        }

        @Override // androidx.media3.common.Player.Listener
        public void onPlaybackParametersChanged(final PlaybackParameters playbackParameters) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            if (this.player.get() == null) {
                return;
            }
            session.playerInfo = session.playerInfo.copyWithPlaybackParameters(playbackParameters);
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
            session.dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$PlayerListener$$ExternalSyntheticLambda23
                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onPlaybackParametersChanged(i, playbackParameters);
                }
            });
        }

        @Override // androidx.media3.common.Player.Listener
        public void onSeekBackIncrementChanged(final long j) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            if (this.player.get() == null) {
                return;
            }
            session.playerInfo = session.playerInfo.copyWithSeekBackIncrement(j);
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
            session.dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$PlayerListener$$ExternalSyntheticLambda2
                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onSeekBackIncrementChanged(i, j);
                }
            });
        }

        @Override // androidx.media3.common.Player.Listener
        public void onSeekForwardIncrementChanged(final long j) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            if (this.player.get() == null) {
                return;
            }
            session.playerInfo = session.playerInfo.copyWithSeekForwardIncrement(j);
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
            session.dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$PlayerListener$$ExternalSyntheticLambda0
                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onSeekForwardIncrementChanged(i, j);
                }
            });
        }

        @Override // androidx.media3.common.Player.Listener
        public void onTimelineChanged(final Timeline timeline, final int i) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            PlayerWrapper playerWrapper = this.player.get();
            if (playerWrapper == null) {
                return;
            }
            session.playerInfo = session.playerInfo.copyWithTimelineAndSessionPositionInfo(timeline, playerWrapper.createSessionPositionInfoForBundling(), i);
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(false, true);
            session.dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$PlayerListener$$ExternalSyntheticLambda13
                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i2) throws RemoteException {
                    controllerCb.onTimelineChanged(i2, timeline, i);
                }
            });
        }

        @Override // androidx.media3.common.Player.Listener
        public void onPlaylistMetadataChanged(final MediaMetadata mediaMetadata) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            session.playerInfo = session.playerInfo.copyWithPlaylistMetadata(mediaMetadata);
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
            session.dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$PlayerListener$$ExternalSyntheticLambda1
                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onPlaylistMetadataChanged(i, mediaMetadata);
                }
            });
        }

        @Override // androidx.media3.common.Player.Listener
        public void onRepeatModeChanged(final int i) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            if (this.player.get() == null) {
                return;
            }
            session.playerInfo = session.playerInfo.copyWithRepeatMode(i);
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
            session.dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$PlayerListener$$ExternalSyntheticLambda10
                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i2) throws RemoteException {
                    controllerCb.onRepeatModeChanged(i2, i);
                }
            });
        }

        @Override // androidx.media3.common.Player.Listener
        public void onShuffleModeEnabledChanged(final boolean z) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            if (this.player.get() == null) {
                return;
            }
            session.playerInfo = session.playerInfo.copyWithShuffleModeEnabled(z);
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
            session.dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$PlayerListener$$ExternalSyntheticLambda4
                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onShuffleModeEnabledChanged(i, z);
                }
            });
        }

        @Override // androidx.media3.common.Player.Listener
        public void onAudioAttributesChanged(final AudioAttributes audioAttributes) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            if (this.player.get() == null) {
                return;
            }
            session.playerInfo = session.playerInfo.copyWithAudioAttributes(audioAttributes);
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
            session.dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$PlayerListener$$ExternalSyntheticLambda5
                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onAudioAttributesChanged(i, audioAttributes);
                }
            });
        }

        @Override // androidx.media3.common.Player.Listener
        public void onVideoSizeChanged(final VideoSize videoSize) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            session.playerInfo = session.playerInfo.copyWithVideoSize(videoSize);
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
            session.dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$PlayerListener$$ExternalSyntheticLambda9
                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onVideoSizeChanged(i, videoSize);
                }
            });
        }

        @Override // androidx.media3.common.Player.Listener
        public void onVolumeChanged(final float f) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            session.playerInfo = session.playerInfo.copyWithVolume(f);
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
            session.dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$PlayerListener$$ExternalSyntheticLambda6
                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onVolumeChanged(i, f);
                }
            });
        }

        @Override // androidx.media3.common.Player.Listener
        public void onCues(CueGroup cueGroup) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            if (this.player.get() == null) {
                return;
            }
            session.playerInfo = new PlayerInfo.Builder(session.playerInfo).setCues(cueGroup).build();
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
        }

        @Override // androidx.media3.common.Player.Listener
        public void onDeviceInfoChanged(final DeviceInfo deviceInfo) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            if (this.player.get() == null) {
                return;
            }
            session.playerInfo = session.playerInfo.copyWithDeviceInfo(deviceInfo);
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
            session.dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$PlayerListener$$ExternalSyntheticLambda16
                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onDeviceInfoChanged(i, deviceInfo);
                }
            });
        }

        @Override // androidx.media3.common.Player.Listener
        public void onDeviceVolumeChanged(final int i, final boolean z) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            if (this.player.get() == null) {
                return;
            }
            session.playerInfo = session.playerInfo.copyWithDeviceVolume(i, z);
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
            session.dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$PlayerListener$$ExternalSyntheticLambda22
                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i2) throws RemoteException {
                    controllerCb.onDeviceVolumeChanged(i2, i, z);
                }
            });
        }

        @Override // androidx.media3.common.Player.Listener
        public void onAvailableCommandsChanged(Player.Commands commands) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            if (this.player.get() == null) {
                return;
            }
            session.handleAvailablePlayerCommandsChanged(commands);
        }

        @Override // androidx.media3.common.Player.Listener
        public void onTracksChanged(final Tracks tracks) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            if (this.player.get() == null) {
                return;
            }
            session.playerInfo = session.playerInfo.copyWithCurrentTracks(tracks);
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, false);
            session.dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$PlayerListener$$ExternalSyntheticLambda3
                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onTracksChanged(i, tracks);
                }
            });
        }

        @Override // androidx.media3.common.Player.Listener
        public void onTrackSelectionParametersChanged(final TrackSelectionParameters trackSelectionParameters) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            if (this.player.get() == null) {
                return;
            }
            session.playerInfo = session.playerInfo.copyWithTrackSelectionParameters(trackSelectionParameters);
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
            session.dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$PlayerListener$$ExternalSyntheticLambda14
                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onTrackSelectionParametersChanged(i, trackSelectionParameters);
                }
            });
        }

        @Override // androidx.media3.common.Player.Listener
        public void onMediaMetadataChanged(final MediaMetadata mediaMetadata) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            if (this.player.get() == null) {
                return;
            }
            session.playerInfo = session.playerInfo.copyWithMediaMetadata(mediaMetadata);
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
            session.dispatchRemoteControllerTaskToLegacyStub(new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$PlayerListener$$ExternalSyntheticLambda21
                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onMediaMetadataChanged(i, mediaMetadata);
                }
            });
        }

        @Override // androidx.media3.common.Player.Listener
        public void onRenderedFirstFrame() {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            session.dispatchRemoteControllerTaskWithoutReturn(new RemoteControllerTask() { // from class: androidx.media3.session.MediaSessionImpl$PlayerListener$$ExternalSyntheticLambda18
                @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
                public final void run(MediaSession.ControllerCb controllerCb, int i) throws RemoteException {
                    controllerCb.onRenderedFirstFrame(i);
                }
            });
        }

        @Override // androidx.media3.common.Player.Listener
        public void onMaxSeekToPreviousPositionChanged(long j) {
            MediaSessionImpl session = getSession();
            if (session == null) {
                return;
            }
            session.verifyApplicationThread();
            if (this.player.get() == null) {
                return;
            }
            session.playerInfo = session.playerInfo.copyWithMaxSeekToPreviousPositionMs(j);
            session.onPlayerInfoChangedHandler.sendPlayerInfoChangedMessage(true, true);
        }

        private MediaSessionImpl getSession() {
            return this.session.get();
        }
    }

    private class PlayerInfoChangedHandler extends Handler {
        private static final int MSG_PLAYER_INFO_CHANGED = 1;
        private boolean excludeTimeline;
        private boolean excludeTracks;

        public PlayerInfoChangedHandler(Looper looper) {
            super(looper);
            this.excludeTimeline = true;
            this.excludeTracks = true;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                MediaSessionImpl mediaSessionImpl = MediaSessionImpl.this;
                mediaSessionImpl.playerInfo = mediaSessionImpl.playerInfo.copyWithTimelineAndSessionPositionInfo(MediaSessionImpl.this.getPlayerWrapper().getCurrentTimelineWithCommandCheck(), MediaSessionImpl.this.getPlayerWrapper().createSessionPositionInfoForBundling(), MediaSessionImpl.this.playerInfo.timelineChangeReason);
                MediaSessionImpl mediaSessionImpl2 = MediaSessionImpl.this;
                mediaSessionImpl2.dispatchOnPlayerInfoChanged(mediaSessionImpl2.playerInfo, this.excludeTimeline, this.excludeTracks);
                this.excludeTimeline = true;
                this.excludeTracks = true;
                return;
            }
            throw new IllegalStateException("Invalid message what=" + message.what);
        }

        public boolean hasPendingPlayerInfoChangedUpdate() {
            return hasMessages(1);
        }

        public void sendPlayerInfoChangedMessage(boolean z, boolean z2) {
            boolean z3 = false;
            this.excludeTimeline = this.excludeTimeline && z;
            if (this.excludeTracks && z2) {
                z3 = true;
            }
            this.excludeTracks = z3;
            if (hasMessages(1)) {
                return;
            }
            sendEmptyMessage(1);
        }
    }
}
