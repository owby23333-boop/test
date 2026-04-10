package androidx.media3.session;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.collection.ArrayMap;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Player;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.session.MediaLibraryService;
import androidx.media3.session.MediaSession;
import androidx.media3.session.MediaSessionImpl;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
class MediaLibrarySessionImpl extends MediaSessionImpl {
    private static final String RECENT_LIBRARY_ROOT_MEDIA_ID = "androidx.media3.session.recent.root";
    private static final String SYSTEM_UI_PACKAGE_NAME = "com.android.systemui";
    private final MediaLibraryService.MediaLibrarySession.Callback callback;
    private final MediaLibraryService.MediaLibrarySession instance;
    private final ArrayMap<MediaSession.ControllerCb, Set<String>> subscriptions;

    public MediaLibrarySessionImpl(MediaLibraryService.MediaLibrarySession mediaLibrarySession, Context context, String str, Player player, PendingIntent pendingIntent, ImmutableList<CommandButton> immutableList, MediaLibraryService.MediaLibrarySession.Callback callback, Bundle bundle, androidx.media3.common.util.BitmapLoader bitmapLoader) {
        super(mediaLibrarySession, context, str, player, pendingIntent, immutableList, callback, bundle, bitmapLoader);
        this.instance = mediaLibrarySession;
        this.callback = callback;
        this.subscriptions = new ArrayMap<>();
    }

    @Override // androidx.media3.session.MediaSessionImpl
    public List<MediaSession.ControllerInfo> getConnectedControllers() {
        List<MediaSession.ControllerInfo> connectedControllers = super.getConnectedControllers();
        MediaLibraryServiceLegacyStub legacyBrowserService = getLegacyBrowserService();
        if (legacyBrowserService != null) {
            connectedControllers.addAll(legacyBrowserService.getConnectedControllersManager().getConnectedControllers());
        }
        return connectedControllers;
    }

    @Override // androidx.media3.session.MediaSessionImpl
    public boolean isConnected(MediaSession.ControllerInfo controllerInfo) {
        if (super.isConnected(controllerInfo)) {
            return true;
        }
        MediaLibraryServiceLegacyStub legacyBrowserService = getLegacyBrowserService();
        return legacyBrowserService != null && legacyBrowserService.getConnectedControllersManager().isConnected(controllerInfo);
    }

    public void notifyChildrenChanged(final String str, final int i, final MediaLibraryService.LibraryParams libraryParams) {
        dispatchRemoteControllerTaskWithoutReturn(new MediaSessionImpl.RemoteControllerTask() { // from class: androidx.media3.session.MediaLibrarySessionImpl$$ExternalSyntheticLambda5
            @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
            public final void run(MediaSession.ControllerCb controllerCb, int i2) throws RemoteException {
                this.f$0.m337x43706a65(str, i, libraryParams, controllerCb, i2);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$notifyChildrenChanged$0$androidx-media3-session-MediaLibrarySessionImpl, reason: not valid java name */
    /* synthetic */ void m337x43706a65(String str, int i, MediaLibraryService.LibraryParams libraryParams, MediaSession.ControllerCb controllerCb, int i2) throws RemoteException {
        if (isSubscribed(controllerCb, str)) {
            controllerCb.onChildrenChanged(i2, str, i, libraryParams);
        }
    }

    public void notifyChildrenChanged(MediaSession.ControllerInfo controllerInfo, final String str, final int i, final MediaLibraryService.LibraryParams libraryParams) {
        dispatchRemoteControllerTaskWithoutReturn(controllerInfo, new MediaSessionImpl.RemoteControllerTask() { // from class: androidx.media3.session.MediaLibrarySessionImpl$$ExternalSyntheticLambda10
            @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
            public final void run(MediaSession.ControllerCb controllerCb, int i2) throws RemoteException {
                this.f$0.m338x42fa0466(str, i, libraryParams, controllerCb, i2);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$notifyChildrenChanged$1$androidx-media3-session-MediaLibrarySessionImpl, reason: not valid java name */
    /* synthetic */ void m338x42fa0466(String str, int i, MediaLibraryService.LibraryParams libraryParams, MediaSession.ControllerCb controllerCb, int i2) throws RemoteException {
        if (isSubscribed(controllerCb, str)) {
            controllerCb.onChildrenChanged(i2, str, i, libraryParams);
        }
    }

    public void notifySearchResultChanged(MediaSession.ControllerInfo controllerInfo, final String str, final int i, final MediaLibraryService.LibraryParams libraryParams) {
        dispatchRemoteControllerTaskWithoutReturn(controllerInfo, new MediaSessionImpl.RemoteControllerTask() { // from class: androidx.media3.session.MediaLibrarySessionImpl$$ExternalSyntheticLambda11
            @Override // androidx.media3.session.MediaSessionImpl.RemoteControllerTask
            public final void run(MediaSession.ControllerCb controllerCb, int i2) throws RemoteException {
                controllerCb.onSearchResultChanged(i2, str, i, libraryParams);
            }
        });
    }

    public ListenableFuture<LibraryResult<MediaItem>> onGetLibraryRootOnHandler(MediaSession.ControllerInfo controllerInfo, MediaLibraryService.LibraryParams libraryParams) {
        if (libraryParams != null && libraryParams.isRecent && Objects.equals(controllerInfo.getPackageName(), SYSTEM_UI_PACKAGE_NAME)) {
            if (!canResumePlaybackOnStart()) {
                return Futures.immediateFuture(LibraryResult.ofError(-6));
            }
            return Futures.immediateFuture(LibraryResult.ofItem(new MediaItem.Builder().setMediaId(RECENT_LIBRARY_ROOT_MEDIA_ID).setMediaMetadata(new MediaMetadata.Builder().setIsBrowsable(true).setIsPlayable(false).build()).build(), libraryParams));
        }
        final ListenableFuture<LibraryResult<MediaItem>> listenableFutureOnGetLibraryRoot = this.callback.onGetLibraryRoot(this.instance, controllerInfo, libraryParams);
        listenableFutureOnGetLibraryRoot.addListener(new Runnable() { // from class: androidx.media3.session.MediaLibrarySessionImpl$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m343xc63c65c1(listenableFutureOnGetLibraryRoot);
            }
        }, new Executor() { // from class: androidx.media3.session.MediaLibrarySessionImpl$$ExternalSyntheticLambda13
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                this.f$0.m344xc5c5ffc2(runnable);
            }
        });
        return listenableFutureOnGetLibraryRoot;
    }

    /* JADX INFO: renamed from: lambda$onGetLibraryRootOnHandler$3$androidx-media3-session-MediaLibrarySessionImpl, reason: not valid java name */
    /* synthetic */ void m343xc63c65c1(ListenableFuture listenableFuture) {
        LibraryResult<?> libraryResult = (LibraryResult) tryGetFutureResult(listenableFuture);
        if (libraryResult != null) {
            maybeUpdateLegacyErrorState(libraryResult);
        }
    }

    /* JADX INFO: renamed from: lambda$onGetLibraryRootOnHandler$4$androidx-media3-session-MediaLibrarySessionImpl, reason: not valid java name */
    /* synthetic */ void m344xc5c5ffc2(Runnable runnable) {
        Util.postOrRun(getApplicationHandler(), runnable);
    }

    public ListenableFuture<LibraryResult<ImmutableList<MediaItem>>> onGetChildrenOnHandler(MediaSession.ControllerInfo controllerInfo, String str, int i, final int i2, MediaLibraryService.LibraryParams libraryParams) {
        if (Objects.equals(str, RECENT_LIBRARY_ROOT_MEDIA_ID)) {
            if (!canResumePlaybackOnStart()) {
                return Futures.immediateFuture(LibraryResult.ofError(-6));
            }
            if (getPlayerWrapper().getPlaybackState() == 1) {
                return getRecentMediaItemAtDeviceBootTime(controllerInfo, libraryParams);
            }
            return Futures.immediateFuture(LibraryResult.ofItemList(ImmutableList.of(new MediaItem.Builder().setMediaId("androidx.media3.session.recent.item").setMediaMetadata(new MediaMetadata.Builder().setIsBrowsable(false).setIsPlayable(true).build()).build()), libraryParams));
        }
        final ListenableFuture<LibraryResult<ImmutableList<MediaItem>>> listenableFutureOnGetChildren = this.callback.onGetChildren(this.instance, controllerInfo, str, i, i2, libraryParams);
        listenableFutureOnGetChildren.addListener(new Runnable() { // from class: androidx.media3.session.MediaLibrarySessionImpl$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m339x7f1c3c0d(listenableFutureOnGetChildren, i2);
            }
        }, new Executor() { // from class: androidx.media3.session.MediaLibrarySessionImpl$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                this.f$0.m340x7ea5d60e(runnable);
            }
        });
        return listenableFutureOnGetChildren;
    }

    /* JADX INFO: renamed from: lambda$onGetChildrenOnHandler$5$androidx-media3-session-MediaLibrarySessionImpl, reason: not valid java name */
    /* synthetic */ void m339x7f1c3c0d(ListenableFuture listenableFuture, int i) {
        LibraryResult<?> libraryResult = (LibraryResult) tryGetFutureResult(listenableFuture);
        if (libraryResult != null) {
            maybeUpdateLegacyErrorState(libraryResult);
            verifyResultItems(libraryResult, i);
        }
    }

    /* JADX INFO: renamed from: lambda$onGetChildrenOnHandler$6$androidx-media3-session-MediaLibrarySessionImpl, reason: not valid java name */
    /* synthetic */ void m340x7ea5d60e(Runnable runnable) {
        Util.postOrRun(getApplicationHandler(), runnable);
    }

    public ListenableFuture<LibraryResult<MediaItem>> onGetItemOnHandler(MediaSession.ControllerInfo controllerInfo, String str) {
        final ListenableFuture<LibraryResult<MediaItem>> listenableFutureOnGetItem = this.callback.onGetItem(this.instance, controllerInfo, str);
        listenableFutureOnGetItem.addListener(new Runnable() { // from class: androidx.media3.session.MediaLibrarySessionImpl$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m341x17a8e97b(listenableFutureOnGetItem);
            }
        }, new Executor() { // from class: androidx.media3.session.MediaLibrarySessionImpl$$ExternalSyntheticLambda4
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                this.f$0.m342x1732837c(runnable);
            }
        });
        return listenableFutureOnGetItem;
    }

    /* JADX INFO: renamed from: lambda$onGetItemOnHandler$7$androidx-media3-session-MediaLibrarySessionImpl, reason: not valid java name */
    /* synthetic */ void m341x17a8e97b(ListenableFuture listenableFuture) {
        LibraryResult<?> libraryResult = (LibraryResult) tryGetFutureResult(listenableFuture);
        if (libraryResult != null) {
            maybeUpdateLegacyErrorState(libraryResult);
        }
    }

    /* JADX INFO: renamed from: lambda$onGetItemOnHandler$8$androidx-media3-session-MediaLibrarySessionImpl, reason: not valid java name */
    /* synthetic */ void m342x1732837c(Runnable runnable) {
        Util.postOrRun(getApplicationHandler(), runnable);
    }

    public ListenableFuture<LibraryResult<Void>> onSubscribeOnHandler(MediaSession.ControllerInfo controllerInfo, final String str, MediaLibraryService.LibraryParams libraryParams) {
        final MediaSession.ControllerCb controllerCb = (MediaSession.ControllerCb) Assertions.checkStateNotNull(controllerInfo.getControllerCb());
        synchronized (this.lock) {
            Set<String> hashSet = this.subscriptions.get(controllerCb);
            if (hashSet == null) {
                hashSet = new HashSet<>();
                this.subscriptions.put(controllerCb, hashSet);
            }
            hashSet.add(str);
        }
        final ListenableFuture<LibraryResult<Void>> listenableFuture = (ListenableFuture) Assertions.checkNotNull(this.callback.onSubscribe(this.instance, controllerInfo, str, libraryParams), "onSubscribe must return non-null future");
        listenableFuture.addListener(new Runnable() { // from class: androidx.media3.session.MediaLibrarySessionImpl$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m349x9112881c(listenableFuture, controllerCb, str);
            }
        }, MoreExecutors.directExecutor());
        return listenableFuture;
    }

    /* JADX INFO: renamed from: lambda$onSubscribeOnHandler$9$androidx-media3-session-MediaLibrarySessionImpl, reason: not valid java name */
    /* synthetic */ void m349x9112881c(ListenableFuture listenableFuture, MediaSession.ControllerCb controllerCb, String str) {
        LibraryResult libraryResult = (LibraryResult) tryGetFutureResult(listenableFuture);
        if (libraryResult == null || libraryResult.resultCode != 0) {
            removeSubscription(controllerCb, str);
        }
    }

    public ListenableFuture<LibraryResult<Void>> onUnsubscribeOnHandler(final MediaSession.ControllerInfo controllerInfo, final String str) {
        ListenableFuture<LibraryResult<Void>> listenableFutureOnUnsubscribe = this.callback.onUnsubscribe(this.instance, controllerInfo, str);
        listenableFutureOnUnsubscribe.addListener(new Runnable() { // from class: androidx.media3.session.MediaLibrarySessionImpl$$ExternalSyntheticLambda14
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m350xf2aee877(controllerInfo, str);
            }
        }, MoreExecutors.directExecutor());
        return listenableFutureOnUnsubscribe;
    }

    /* JADX INFO: renamed from: lambda$onUnsubscribeOnHandler$10$androidx-media3-session-MediaLibrarySessionImpl, reason: not valid java name */
    /* synthetic */ void m350xf2aee877(MediaSession.ControllerInfo controllerInfo, String str) {
        removeSubscription((MediaSession.ControllerCb) Assertions.checkStateNotNull(controllerInfo.getControllerCb()), str);
    }

    public ListenableFuture<LibraryResult<Void>> onSearchOnHandler(MediaSession.ControllerInfo controllerInfo, String str, MediaLibraryService.LibraryParams libraryParams) {
        final ListenableFuture<LibraryResult<Void>> listenableFutureOnSearch = this.callback.onSearch(this.instance, controllerInfo, str, libraryParams);
        listenableFutureOnSearch.addListener(new Runnable() { // from class: androidx.media3.session.MediaLibrarySessionImpl$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m347x8a75a547(listenableFutureOnSearch);
            }
        }, new Executor() { // from class: androidx.media3.session.MediaLibrarySessionImpl$$ExternalSyntheticLambda9
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                this.f$0.m348x89ff3f48(runnable);
            }
        });
        return listenableFutureOnSearch;
    }

    /* JADX INFO: renamed from: lambda$onSearchOnHandler$11$androidx-media3-session-MediaLibrarySessionImpl, reason: not valid java name */
    /* synthetic */ void m347x8a75a547(ListenableFuture listenableFuture) {
        LibraryResult<?> libraryResult = (LibraryResult) tryGetFutureResult(listenableFuture);
        if (libraryResult != null) {
            maybeUpdateLegacyErrorState(libraryResult);
        }
    }

    /* JADX INFO: renamed from: lambda$onSearchOnHandler$12$androidx-media3-session-MediaLibrarySessionImpl, reason: not valid java name */
    /* synthetic */ void m348x89ff3f48(Runnable runnable) {
        Util.postOrRun(getApplicationHandler(), runnable);
    }

    public ListenableFuture<LibraryResult<ImmutableList<MediaItem>>> onGetSearchResultOnHandler(MediaSession.ControllerInfo controllerInfo, String str, int i, final int i2, MediaLibraryService.LibraryParams libraryParams) {
        final ListenableFuture<LibraryResult<ImmutableList<MediaItem>>> listenableFutureOnGetSearchResult = this.callback.onGetSearchResult(this.instance, controllerInfo, str, i, i2, libraryParams);
        listenableFutureOnGetSearchResult.addListener(new Runnable() { // from class: androidx.media3.session.MediaLibrarySessionImpl$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m345xd2547d04(listenableFutureOnGetSearchResult, i2);
            }
        }, new Executor() { // from class: androidx.media3.session.MediaLibrarySessionImpl$$ExternalSyntheticLambda6
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                this.f$0.m346xd1de1705(runnable);
            }
        });
        return listenableFutureOnGetSearchResult;
    }

    /* JADX INFO: renamed from: lambda$onGetSearchResultOnHandler$13$androidx-media3-session-MediaLibrarySessionImpl, reason: not valid java name */
    /* synthetic */ void m345xd2547d04(ListenableFuture listenableFuture, int i) {
        LibraryResult<?> libraryResult = (LibraryResult) tryGetFutureResult(listenableFuture);
        if (libraryResult != null) {
            maybeUpdateLegacyErrorState(libraryResult);
            verifyResultItems(libraryResult, i);
        }
    }

    /* JADX INFO: renamed from: lambda$onGetSearchResultOnHandler$14$androidx-media3-session-MediaLibrarySessionImpl, reason: not valid java name */
    /* synthetic */ void m346xd1de1705(Runnable runnable) {
        Util.postOrRun(getApplicationHandler(), runnable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.session.MediaSessionImpl
    public MediaLibraryServiceLegacyStub getLegacyBrowserService() {
        return (MediaLibraryServiceLegacyStub) super.getLegacyBrowserService();
    }

    @Override // androidx.media3.session.MediaSessionImpl
    protected MediaSessionServiceLegacyStub createLegacyBrowserService(MediaSessionCompat.Token token) {
        MediaLibraryServiceLegacyStub mediaLibraryServiceLegacyStub = new MediaLibraryServiceLegacyStub(this);
        mediaLibraryServiceLegacyStub.initialize(token);
        return mediaLibraryServiceLegacyStub;
    }

    @Override // androidx.media3.session.MediaSessionImpl
    protected void dispatchRemoteControllerTaskWithoutReturn(MediaSessionImpl.RemoteControllerTask remoteControllerTask) {
        super.dispatchRemoteControllerTaskWithoutReturn(remoteControllerTask);
        MediaLibraryServiceLegacyStub legacyBrowserService = getLegacyBrowserService();
        if (legacyBrowserService != null) {
            try {
                remoteControllerTask.run(legacyBrowserService.getBrowserLegacyCbForBroadcast(), 0);
            } catch (RemoteException e) {
                Log.e(MediaSessionImpl.TAG, "Exception in using media1 API", e);
            }
        }
    }

    private boolean isSubscribed(MediaSession.ControllerCb controllerCb, String str) {
        synchronized (this.lock) {
            Set<String> set = this.subscriptions.get(controllerCb);
            if (set != null && set.contains(str)) {
                return true;
            }
            return false;
        }
    }

    private void maybeUpdateLegacyErrorState(LibraryResult<?> libraryResult) {
        PlayerWrapper playerWrapper = getPlayerWrapper();
        if (libraryResult.resultCode == -102 && libraryResult.params != null && libraryResult.params.extras.containsKey("android.media.extras.ERROR_RESOLUTION_ACTION_INTENT")) {
            MediaSessionCompat sessionCompat = getSessionCompat();
            if (playerWrapper.getLegacyStatusCode() != -102) {
                playerWrapper.setLegacyErrorStatus(3, getContext().getString(R.string.authentication_required), libraryResult.params.extras);
                sessionCompat.setPlaybackState(playerWrapper.createPlaybackStateCompat());
                return;
            }
            return;
        }
        if (playerWrapper.getLegacyStatusCode() != 0) {
            playerWrapper.clearLegacyErrorStatus();
            getSessionCompat().setPlaybackState(playerWrapper.createPlaybackStateCompat());
        }
    }

    private static <T> T tryGetFutureResult(Future<T> future) {
        Assertions.checkState(future.isDone());
        try {
            return future.get();
        } catch (InterruptedException | CancellationException | ExecutionException e) {
            Log.w(MediaSessionImpl.TAG, "Library operation failed", e);
            return null;
        }
    }

    private static void verifyResultItems(LibraryResult<ImmutableList<MediaItem>> libraryResult, int i) {
        if (libraryResult.resultCode == 0) {
            List list = (List) Assertions.checkNotNull(libraryResult.value);
            if (list.size() > i) {
                throw new IllegalStateException("Invalid size=" + list.size() + ", pageSize=" + i);
            }
        }
    }

    private void removeSubscription(MediaSession.ControllerCb controllerCb, String str) {
        synchronized (this.lock) {
            Set<String> set = this.subscriptions.get(controllerCb);
            if (set != null) {
                set.remove(str);
                if (set.isEmpty()) {
                    this.subscriptions.remove(controllerCb);
                }
            }
        }
    }

    private ListenableFuture<LibraryResult<ImmutableList<MediaItem>>> getRecentMediaItemAtDeviceBootTime(MediaSession.ControllerInfo controllerInfo, final MediaLibraryService.LibraryParams libraryParams) {
        final SettableFuture settableFutureCreate = SettableFuture.create();
        Futures.addCallback(this.callback.onPlaybackResumption(this.instance, controllerInfo), new FutureCallback<MediaSession.MediaItemsWithStartPosition>() { // from class: androidx.media3.session.MediaLibrarySessionImpl.1
            @Override // com.google.common.util.concurrent.FutureCallback
            public void onSuccess(MediaSession.MediaItemsWithStartPosition mediaItemsWithStartPosition) {
                if (mediaItemsWithStartPosition.mediaItems.isEmpty()) {
                    settableFutureCreate.set(LibraryResult.ofError(-2, libraryParams));
                } else {
                    settableFutureCreate.set(LibraryResult.ofItemList(ImmutableList.of(mediaItemsWithStartPosition.mediaItems.get(Math.max(0, Math.min(mediaItemsWithStartPosition.startIndex, mediaItemsWithStartPosition.mediaItems.size() - 1)))), libraryParams));
                }
            }

            @Override // com.google.common.util.concurrent.FutureCallback
            public void onFailure(Throwable th) {
                settableFutureCreate.set(LibraryResult.ofError(-1, libraryParams));
                Log.e(MediaSessionImpl.TAG, "Failed fetching recent media item at boot time: " + th.getMessage(), th);
            }
        }, MoreExecutors.directExecutor());
        return settableFutureCreate;
    }
}
