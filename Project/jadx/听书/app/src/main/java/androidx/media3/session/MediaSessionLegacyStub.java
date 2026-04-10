package androidx.media3.session;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import androidx.core.util.ObjectsCompat;
import androidx.media.MediaSessionManager;
import androidx.media.VolumeProviderCompat;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Rating;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.session.MediaSession;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
class MediaSessionLegacyStub extends MediaSessionCompat.Callback {
    private static final int DEFAULT_CONNECTION_TIMEOUT_MS = 300000;
    private static final String DEFAULT_MEDIA_SESSION_TAG_DELIM = ".";
    private static final String DEFAULT_MEDIA_SESSION_TAG_PREFIX = "androidx.media3.session.id";
    private static final int PENDING_INTENT_FLAG_MUTABLE;
    private static final String TAG = "MediaSessionLegacyStub";
    private final String appPackageName;
    private final boolean canResumePlaybackOnStart;
    private final ConnectedControllersManager<MediaSessionManager.RemoteUserInfo> connectedControllersManager;
    private final ConnectionTimeoutHandler connectionTimeoutHandler;
    private volatile long connectionTimeoutMs;
    private final MediaSession.ControllerCb controllerLegacyCbForBroadcast;
    private final MediaPlayPauseKeyHandler mediaPlayPauseKeyHandler;
    private FutureCallback<Bitmap> pendingBitmapLoadCallback;
    private final MediaButtonReceiver runtimeBroadcastReceiver;
    private final MediaSessionCompat sessionCompat;
    private int sessionFlags;
    private final MediaSessionImpl sessionImpl;
    private final MediaSessionManager sessionManager;
    private VolumeProviderCompat volumeProviderCompat;

    /* JADX INFO: Access modifiers changed from: private */
    interface SessionTask {
        void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException;
    }

    private static <T> void ignoreFuture(Future<T> future) {
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSetCaptioningEnabled(boolean z) {
    }

    static {
        PENDING_INTENT_FLAG_MUTABLE = Util.SDK_INT >= 31 ? 33554432 : 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0067 A[PHI: r0
  0x0067: PHI (r0v6 android.content.ComponentName) = (r0v5 android.content.ComponentName), (r0v17 android.content.ComponentName) binds: [B:7:0x0053, B:11:0x0063] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public MediaSessionLegacyStub(androidx.media3.session.MediaSessionImpl r9, android.net.Uri r10, android.os.Handler r11) {
        /*
            Method dump skipped, instruction units count: 250
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.session.MediaSessionLegacyStub.<init>(androidx.media3.session.MediaSessionImpl, android.net.Uri, android.os.Handler):void");
    }

    private static ComponentName queryPackageManagerForMediaButtonReceiver(Context context) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> listQueryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 0);
        if (listQueryBroadcastReceivers.size() == 1) {
            ResolveInfo resolveInfo = listQueryBroadcastReceivers.get(0);
            return new ComponentName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
        }
        if (listQueryBroadcastReceivers.isEmpty()) {
            return null;
        }
        throw new IllegalStateException("Expected 1 broadcast receiver that handles android.intent.action.MEDIA_BUTTON, found " + listQueryBroadcastReceivers.size());
    }

    public void start() {
        this.sessionCompat.setActive(true);
    }

    public void release() {
        if (!this.canResumePlaybackOnStart) {
            setMediaButtonReceiver(this.sessionCompat, null);
        }
        if (this.runtimeBroadcastReceiver != null) {
            this.sessionImpl.getContext().unregisterReceiver(this.runtimeBroadcastReceiver);
        }
        this.sessionCompat.release();
    }

    public MediaSessionCompat getSessionCompat() {
        return this.sessionCompat;
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onCommand(String str, final Bundle bundle, final ResultReceiver resultReceiver) {
        Assertions.checkStateNotNull(str);
        if (TextUtils.equals("androidx.media3.session.SESSION_COMMAND_REQUEST_SESSION3_TOKEN", str) && resultReceiver != null) {
            resultReceiver.send(0, this.sessionImpl.getToken().toBundle());
        } else {
            final SessionCommand sessionCommand = new SessionCommand(str, Bundle.EMPTY);
            dispatchSessionTaskWithSessionCommand(sessionCommand, new SessionTask() { // from class: androidx.media3.session.MediaSessionLegacyStub$$ExternalSyntheticLambda21
                @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
                public final void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                    this.f$0.m369xec90a203(sessionCommand, bundle, resultReceiver, controllerInfo);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$onCommand$0$androidx-media3-session-MediaSessionLegacyStub, reason: not valid java name */
    /* synthetic */ void m369xec90a203(SessionCommand sessionCommand, Bundle bundle, ResultReceiver resultReceiver, MediaSession.ControllerInfo controllerInfo) throws RemoteException {
        MediaSessionImpl mediaSessionImpl = this.sessionImpl;
        if (bundle == null) {
            bundle = Bundle.EMPTY;
        }
        ListenableFuture<SessionResult> listenableFutureOnCustomCommandOnHandler = mediaSessionImpl.onCustomCommandOnHandler(controllerInfo, sessionCommand, bundle);
        if (resultReceiver != null) {
            sendCustomCommandResultWhenReady(resultReceiver, listenableFutureOnCustomCommandOnHandler);
        } else {
            ignoreFuture(listenableFutureOnCustomCommandOnHandler);
        }
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onCustomAction(String str, final Bundle bundle) {
        final SessionCommand sessionCommand = new SessionCommand(str, Bundle.EMPTY);
        dispatchSessionTaskWithSessionCommand(sessionCommand, new SessionTask() { // from class: androidx.media3.session.MediaSessionLegacyStub$$ExternalSyntheticLambda17
            @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
            public final void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                this.f$0.m370x6dc3132e(sessionCommand, bundle, controllerInfo);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onCustomAction$1$androidx-media3-session-MediaSessionLegacyStub, reason: not valid java name */
    /* synthetic */ void m370x6dc3132e(SessionCommand sessionCommand, Bundle bundle, MediaSession.ControllerInfo controllerInfo) throws RemoteException {
        MediaSessionImpl mediaSessionImpl = this.sessionImpl;
        if (bundle == null) {
            bundle = Bundle.EMPTY;
        }
        ignoreFuture(mediaSessionImpl.onCustomCommandOnHandler(controllerInfo, sessionCommand, bundle));
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public boolean onMediaButtonEvent(Intent intent) {
        KeyEvent keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT");
        if (keyEvent == null || keyEvent.getAction() != 0) {
            return false;
        }
        MediaSessionManager.RemoteUserInfo currentControllerInfo = this.sessionCompat.getCurrentControllerInfo();
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 79 || keyCode == 85) {
            if (!this.appPackageName.equals(currentControllerInfo.getPackageName()) && keyEvent.getRepeatCount() == 0) {
                if (this.mediaPlayPauseKeyHandler.hasPendingMediaPlayPauseKey()) {
                    this.mediaPlayPauseKeyHandler.clearPendingMediaPlayPauseKey();
                    onSkipToNext();
                    return true;
                }
                this.mediaPlayPauseKeyHandler.addPendingMediaPlayPauseKey(currentControllerInfo);
                return true;
            }
            handleMediaPlayPauseOnHandler(currentControllerInfo);
            return true;
        }
        if (this.mediaPlayPauseKeyHandler.hasPendingMediaPlayPauseKey()) {
            handleMediaPlayPauseOnHandler(currentControllerInfo);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeUpdateFlags(PlayerWrapper playerWrapper) {
        int i = playerWrapper.isCommandAvailable(20) ? 4 : 0;
        if (this.sessionFlags != i) {
            this.sessionFlags = i;
            this.sessionCompat.setFlags(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleMediaPlayPauseOnHandler(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        this.mediaPlayPauseKeyHandler.clearPendingMediaPlayPauseKey();
        dispatchSessionTaskWithPlayerCommand(1, new SessionTask() { // from class: androidx.media3.session.MediaSessionLegacyStub$$ExternalSyntheticLambda19
            @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
            public final void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                this.f$0.m366x31f4e7a8(controllerInfo);
            }
        }, remoteUserInfo);
    }

    /* JADX INFO: renamed from: lambda$handleMediaPlayPauseOnHandler$2$androidx-media3-session-MediaSessionLegacyStub, reason: not valid java name */
    /* synthetic */ void m366x31f4e7a8(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
        Util.handlePlayPauseButtonAction(this.sessionImpl.getPlayerWrapper());
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onPrepare() {
        dispatchSessionTaskWithPlayerCommand(2, new SessionTask() { // from class: androidx.media3.session.MediaSessionLegacyStub$$ExternalSyntheticLambda22
            @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
            public final void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                this.f$0.m374xfc59f964(controllerInfo);
            }
        }, this.sessionCompat.getCurrentControllerInfo());
    }

    /* JADX INFO: renamed from: lambda$onPrepare$3$androidx-media3-session-MediaSessionLegacyStub, reason: not valid java name */
    /* synthetic */ void m374xfc59f964(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
        this.sessionImpl.getPlayerWrapper().prepare();
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onPrepareFromMediaId(String str, Bundle bundle) {
        handleMediaRequest(createMediaItemForMediaRequest(str, null, null, bundle), false);
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onPrepareFromSearch(String str, Bundle bundle) {
        handleMediaRequest(createMediaItemForMediaRequest(null, null, str, bundle), false);
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onPrepareFromUri(Uri uri, Bundle bundle) {
        handleMediaRequest(createMediaItemForMediaRequest(null, uri, null, bundle), false);
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onPlay() {
        dispatchSessionTaskWithPlayerCommand(1, new SessionTask() { // from class: androidx.media3.session.MediaSessionLegacyStub$$ExternalSyntheticLambda8
            @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
            public final void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                this.f$0.m373lambda$onPlay$4$androidxmedia3sessionMediaSessionLegacyStub(controllerInfo);
            }
        }, this.sessionCompat.getCurrentControllerInfo());
    }

    /* JADX INFO: renamed from: lambda$onPlay$4$androidx-media3-session-MediaSessionLegacyStub, reason: not valid java name */
    /* synthetic */ void m373lambda$onPlay$4$androidxmedia3sessionMediaSessionLegacyStub(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
        if (this.sessionImpl.onPlayRequested()) {
            PlayerWrapper playerWrapper = this.sessionImpl.getPlayerWrapper();
            if (playerWrapper.getMediaItemCount() == 0) {
                this.sessionImpl.prepareAndPlayForPlaybackResumption(controllerInfo, playerWrapper);
            } else {
                Util.handlePlayButtonAction(playerWrapper);
            }
        }
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onPlayFromMediaId(String str, Bundle bundle) {
        handleMediaRequest(createMediaItemForMediaRequest(str, null, null, bundle), true);
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onPlayFromSearch(String str, Bundle bundle) {
        handleMediaRequest(createMediaItemForMediaRequest(null, null, str, bundle), true);
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onPlayFromUri(Uri uri, Bundle bundle) {
        handleMediaRequest(createMediaItemForMediaRequest(null, uri, null, bundle), true);
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onPause() {
        dispatchSessionTaskWithPlayerCommand(1, new SessionTask() { // from class: androidx.media3.session.MediaSessionLegacyStub$$ExternalSyntheticLambda4
            @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
            public final void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                this.f$0.m372lambda$onPause$5$androidxmedia3sessionMediaSessionLegacyStub(controllerInfo);
            }
        }, this.sessionCompat.getCurrentControllerInfo());
    }

    /* JADX INFO: renamed from: lambda$onPause$5$androidx-media3-session-MediaSessionLegacyStub, reason: not valid java name */
    /* synthetic */ void m372lambda$onPause$5$androidxmedia3sessionMediaSessionLegacyStub(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
        Util.handlePauseButtonAction(this.sessionImpl.getPlayerWrapper());
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onStop() {
        dispatchSessionTaskWithPlayerCommand(3, new SessionTask() { // from class: androidx.media3.session.MediaSessionLegacyStub$$ExternalSyntheticLambda18
            @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
            public final void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                this.f$0.m388lambda$onStop$6$androidxmedia3sessionMediaSessionLegacyStub(controllerInfo);
            }
        }, this.sessionCompat.getCurrentControllerInfo());
    }

    /* JADX INFO: renamed from: lambda$onStop$6$androidx-media3-session-MediaSessionLegacyStub, reason: not valid java name */
    /* synthetic */ void m388lambda$onStop$6$androidxmedia3sessionMediaSessionLegacyStub(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
        this.sessionImpl.getPlayerWrapper().stop();
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSeekTo(final long j) {
        dispatchSessionTaskWithPlayerCommand(5, new SessionTask() { // from class: androidx.media3.session.MediaSessionLegacyStub$$ExternalSyntheticLambda6
            @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
            public final void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                this.f$0.m378lambda$onSeekTo$7$androidxmedia3sessionMediaSessionLegacyStub(j, controllerInfo);
            }
        }, this.sessionCompat.getCurrentControllerInfo());
    }

    /* JADX INFO: renamed from: lambda$onSeekTo$7$androidx-media3-session-MediaSessionLegacyStub, reason: not valid java name */
    /* synthetic */ void m378lambda$onSeekTo$7$androidxmedia3sessionMediaSessionLegacyStub(long j, MediaSession.ControllerInfo controllerInfo) throws RemoteException {
        this.sessionImpl.getPlayerWrapper().seekTo(j);
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSkipToNext() {
        if (this.sessionImpl.getPlayerWrapper().isCommandAvailable(9)) {
            dispatchSessionTaskWithPlayerCommand(9, new SessionTask() { // from class: androidx.media3.session.MediaSessionLegacyStub$$ExternalSyntheticLambda26
                @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
                public final void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                    this.f$0.m383x30de70a1(controllerInfo);
                }
            }, this.sessionCompat.getCurrentControllerInfo());
        } else {
            dispatchSessionTaskWithPlayerCommand(8, new SessionTask() { // from class: androidx.media3.session.MediaSessionLegacyStub$$ExternalSyntheticLambda1
                @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
                public final void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                    this.f$0.m384x6aa91280(controllerInfo);
                }
            }, this.sessionCompat.getCurrentControllerInfo());
        }
    }

    /* JADX INFO: renamed from: lambda$onSkipToNext$8$androidx-media3-session-MediaSessionLegacyStub, reason: not valid java name */
    /* synthetic */ void m383x30de70a1(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
        this.sessionImpl.getPlayerWrapper().seekToNext();
    }

    /* JADX INFO: renamed from: lambda$onSkipToNext$9$androidx-media3-session-MediaSessionLegacyStub, reason: not valid java name */
    /* synthetic */ void m384x6aa91280(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
        this.sessionImpl.getPlayerWrapper().seekToNextMediaItem();
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSkipToPrevious() {
        if (this.sessionImpl.getPlayerWrapper().isCommandAvailable(7)) {
            dispatchSessionTaskWithPlayerCommand(7, new SessionTask() { // from class: androidx.media3.session.MediaSessionLegacyStub$$ExternalSyntheticLambda13
                @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
                public final void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                    this.f$0.m385x6478fb88(controllerInfo);
                }
            }, this.sessionCompat.getCurrentControllerInfo());
        } else {
            dispatchSessionTaskWithPlayerCommand(6, new SessionTask() { // from class: androidx.media3.session.MediaSessionLegacyStub$$ExternalSyntheticLambda14
                @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
                public final void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                    this.f$0.m386x9e439d67(controllerInfo);
                }
            }, this.sessionCompat.getCurrentControllerInfo());
        }
    }

    /* JADX INFO: renamed from: lambda$onSkipToPrevious$10$androidx-media3-session-MediaSessionLegacyStub, reason: not valid java name */
    /* synthetic */ void m385x6478fb88(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
        this.sessionImpl.getPlayerWrapper().seekToPrevious();
    }

    /* JADX INFO: renamed from: lambda$onSkipToPrevious$11$androidx-media3-session-MediaSessionLegacyStub, reason: not valid java name */
    /* synthetic */ void m386x9e439d67(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
        this.sessionImpl.getPlayerWrapper().seekToPreviousMediaItem();
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSetPlaybackSpeed(final float f) {
        dispatchSessionTaskWithPlayerCommand(13, new SessionTask() { // from class: androidx.media3.session.MediaSessionLegacyStub$$ExternalSyntheticLambda15
            @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
            public final void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                this.f$0.m379x7cff143f(f, controllerInfo);
            }
        }, this.sessionCompat.getCurrentControllerInfo());
    }

    /* JADX INFO: renamed from: lambda$onSetPlaybackSpeed$12$androidx-media3-session-MediaSessionLegacyStub, reason: not valid java name */
    /* synthetic */ void m379x7cff143f(float f, MediaSession.ControllerInfo controllerInfo) throws RemoteException {
        this.sessionImpl.getPlayerWrapper().setPlaybackSpeed(f);
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSkipToQueueItem(final long j) {
        dispatchSessionTaskWithPlayerCommand(10, new SessionTask() { // from class: androidx.media3.session.MediaSessionLegacyStub$$ExternalSyntheticLambda3
            @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
            public final void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                this.f$0.m387x3ee1cf86(j, controllerInfo);
            }
        }, this.sessionCompat.getCurrentControllerInfo());
    }

    /* JADX INFO: renamed from: lambda$onSkipToQueueItem$13$androidx-media3-session-MediaSessionLegacyStub, reason: not valid java name */
    /* synthetic */ void m387x3ee1cf86(long j, MediaSession.ControllerInfo controllerInfo) throws RemoteException {
        this.sessionImpl.getPlayerWrapper().seekToDefaultPosition((int) j);
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onFastForward() {
        dispatchSessionTaskWithPlayerCommand(12, new SessionTask() { // from class: androidx.media3.session.MediaSessionLegacyStub$$ExternalSyntheticLambda7
            @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
            public final void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                this.f$0.m371x1c7427e4(controllerInfo);
            }
        }, this.sessionCompat.getCurrentControllerInfo());
    }

    /* JADX INFO: renamed from: lambda$onFastForward$14$androidx-media3-session-MediaSessionLegacyStub, reason: not valid java name */
    /* synthetic */ void m371x1c7427e4(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
        this.sessionImpl.getPlayerWrapper().seekForward();
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onRewind() {
        dispatchSessionTaskWithPlayerCommand(11, new SessionTask() { // from class: androidx.media3.session.MediaSessionLegacyStub$$ExternalSyntheticLambda12
            @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
            public final void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                this.f$0.m377x92b575ad(controllerInfo);
            }
        }, this.sessionCompat.getCurrentControllerInfo());
    }

    /* JADX INFO: renamed from: lambda$onRewind$15$androidx-media3-session-MediaSessionLegacyStub, reason: not valid java name */
    /* synthetic */ void m377x92b575ad(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
        this.sessionImpl.getPlayerWrapper().seekBack();
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSetRating(RatingCompat ratingCompat) {
        onSetRating(ratingCompat, null);
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSetRating(RatingCompat ratingCompat, Bundle bundle) {
        final Rating ratingConvertToRating = MediaUtils.convertToRating(ratingCompat);
        if (ratingConvertToRating == null) {
            Log.w(TAG, "Ignoring invalid RatingCompat " + ratingCompat);
        } else {
            dispatchSessionTaskWithSessionCommand(SessionCommand.COMMAND_CODE_SESSION_SET_RATING, new SessionTask() { // from class: androidx.media3.session.MediaSessionLegacyStub$$ExternalSyntheticLambda5
                @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
                public final void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                    this.f$0.m380xff1530f8(ratingConvertToRating, controllerInfo);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$onSetRating$16$androidx-media3-session-MediaSessionLegacyStub, reason: not valid java name */
    /* synthetic */ void m380xff1530f8(Rating rating, MediaSession.ControllerInfo controllerInfo) throws RemoteException {
        MediaItem currentMediaItemWithCommandCheck = this.sessionImpl.getPlayerWrapper().getCurrentMediaItemWithCommandCheck();
        if (currentMediaItemWithCommandCheck == null) {
            return;
        }
        ignoreFuture(this.sessionImpl.onSetRatingOnHandler(controllerInfo, currentMediaItemWithCommandCheck.mediaId, rating));
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSetRepeatMode(final int i) {
        dispatchSessionTaskWithPlayerCommand(15, new SessionTask() { // from class: androidx.media3.session.MediaSessionLegacyStub$$ExternalSyntheticLambda9
            @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
            public final void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                this.f$0.m381x107e51d8(i, controllerInfo);
            }
        }, this.sessionCompat.getCurrentControllerInfo());
    }

    /* JADX INFO: renamed from: lambda$onSetRepeatMode$17$androidx-media3-session-MediaSessionLegacyStub, reason: not valid java name */
    /* synthetic */ void m381x107e51d8(int i, MediaSession.ControllerInfo controllerInfo) throws RemoteException {
        this.sessionImpl.getPlayerWrapper().setRepeatMode(MediaUtils.convertToRepeatMode(i));
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onSetShuffleMode(final int i) {
        dispatchSessionTaskWithPlayerCommand(14, new SessionTask() { // from class: androidx.media3.session.MediaSessionLegacyStub$$ExternalSyntheticLambda23
            @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
            public final void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                this.f$0.m382xa4adaf49(i, controllerInfo);
            }
        }, this.sessionCompat.getCurrentControllerInfo());
    }

    /* JADX INFO: renamed from: lambda$onSetShuffleMode$18$androidx-media3-session-MediaSessionLegacyStub, reason: not valid java name */
    /* synthetic */ void m382xa4adaf49(int i, MediaSession.ControllerInfo controllerInfo) throws RemoteException {
        this.sessionImpl.getPlayerWrapper().setShuffleModeEnabled(MediaUtils.convertToShuffleModeEnabled(i));
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onAddQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
        handleOnAddQueueItem(mediaDescriptionCompat, -1);
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onAddQueueItem(MediaDescriptionCompat mediaDescriptionCompat, int i) {
        handleOnAddQueueItem(mediaDescriptionCompat, i);
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onRemoveQueueItem(final MediaDescriptionCompat mediaDescriptionCompat) {
        if (mediaDescriptionCompat == null) {
            return;
        }
        dispatchSessionTaskWithPlayerCommand(20, new SessionTask() { // from class: androidx.media3.session.MediaSessionLegacyStub$$ExternalSyntheticLambda20
            @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
            public final void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                this.f$0.m375x17150c56(mediaDescriptionCompat, controllerInfo);
            }
        }, this.sessionCompat.getCurrentControllerInfo());
    }

    /* JADX INFO: renamed from: lambda$onRemoveQueueItem$19$androidx-media3-session-MediaSessionLegacyStub, reason: not valid java name */
    /* synthetic */ void m375x17150c56(MediaDescriptionCompat mediaDescriptionCompat, MediaSession.ControllerInfo controllerInfo) throws RemoteException {
        String mediaId = mediaDescriptionCompat.getMediaId();
        if (TextUtils.isEmpty(mediaId)) {
            Log.w(TAG, "onRemoveQueueItem(): Media ID shouldn't be null");
            return;
        }
        PlayerWrapper playerWrapper = this.sessionImpl.getPlayerWrapper();
        if (!playerWrapper.isCommandAvailable(17)) {
            Log.w(TAG, "Can't remove item by id without availabe COMMAND_GET_TIMELINE");
            return;
        }
        Timeline currentTimeline = playerWrapper.getCurrentTimeline();
        Timeline.Window window = new Timeline.Window();
        for (int i = 0; i < currentTimeline.getWindowCount(); i++) {
            if (TextUtils.equals(currentTimeline.getWindow(i, window).mediaItem.mediaId, mediaId)) {
                playerWrapper.removeMediaItem(i);
                return;
            }
        }
    }

    @Override // android.support.v4.media.session.MediaSessionCompat.Callback
    public void onRemoveQueueItemAt(final int i) {
        dispatchSessionTaskWithPlayerCommand(20, new SessionTask() { // from class: androidx.media3.session.MediaSessionLegacyStub$$ExternalSyntheticLambda25
            @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
            public final void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                this.f$0.m376xbfe86a13(i, controllerInfo);
            }
        }, this.sessionCompat.getCurrentControllerInfo());
    }

    /* JADX INFO: renamed from: lambda$onRemoveQueueItemAt$20$androidx-media3-session-MediaSessionLegacyStub, reason: not valid java name */
    /* synthetic */ void m376xbfe86a13(int i, MediaSession.ControllerInfo controllerInfo) throws RemoteException {
        if (i < 0) {
            Log.w(TAG, "onRemoveQueueItem(): index shouldn't be negative");
        } else {
            this.sessionImpl.getPlayerWrapper().removeMediaItem(i);
        }
    }

    public MediaSession.ControllerCb getControllerLegacyCbForBroadcast() {
        return this.controllerLegacyCbForBroadcast;
    }

    public ConnectedControllersManager<MediaSessionManager.RemoteUserInfo> getConnectedControllersManager() {
        return this.connectedControllersManager;
    }

    boolean canResumePlaybackOnStart() {
        return this.canResumePlaybackOnStart;
    }

    private void dispatchSessionTaskWithPlayerCommand(final int i, final SessionTask sessionTask, final MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        if (this.sessionImpl.isReleased()) {
            return;
        }
        if (remoteUserInfo == null) {
            Log.d(TAG, "RemoteUserInfo is null, ignoring command=" + i);
        } else {
            Util.postOrRun(this.sessionImpl.getApplicationHandler(), new Runnable() { // from class: androidx.media3.session.MediaSessionLegacyStub$$ExternalSyntheticLambda24
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m364x1d8bc47a(i, remoteUserInfo, sessionTask);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$dispatchSessionTaskWithPlayerCommand$22$androidx-media3-session-MediaSessionLegacyStub, reason: not valid java name */
    /* synthetic */ void m364x1d8bc47a(int i, MediaSessionManager.RemoteUserInfo remoteUserInfo, final SessionTask sessionTask) {
        if (this.sessionImpl.isReleased()) {
            return;
        }
        if (!this.sessionCompat.isActive()) {
            Log.w(TAG, "Ignore incoming player command before initialization. command=" + i + ", pid=" + remoteUserInfo.getPid());
            return;
        }
        final MediaSession.ControllerInfo controllerInfoTryGetController = tryGetController(remoteUserInfo);
        if (controllerInfoTryGetController != null && this.connectedControllersManager.isPlayerCommandAvailable(controllerInfoTryGetController, i) && this.sessionImpl.onPlayerCommandRequestOnHandler(controllerInfoTryGetController, i) == 0) {
            this.sessionImpl.callWithControllerForCurrentRequestSet(controllerInfoTryGetController, new Runnable() { // from class: androidx.media3.session.MediaSessionLegacyStub$$ExternalSyntheticLambda10
                @Override // java.lang.Runnable
                public final void run() {
                    MediaSessionLegacyStub.lambda$dispatchSessionTaskWithPlayerCommand$21(sessionTask, controllerInfoTryGetController);
                }
            }).run();
        }
    }

    static /* synthetic */ void lambda$dispatchSessionTaskWithPlayerCommand$21(SessionTask sessionTask, MediaSession.ControllerInfo controllerInfo) {
        try {
            sessionTask.run(controllerInfo);
        } catch (RemoteException e) {
            Log.w(TAG, "Exception in " + controllerInfo, e);
        }
    }

    private void dispatchSessionTaskWithSessionCommand(int i, SessionTask sessionTask) {
        dispatchSessionTaskWithSessionCommandInternal(null, i, sessionTask, this.sessionCompat.getCurrentControllerInfo());
    }

    private void dispatchSessionTaskWithSessionCommand(SessionCommand sessionCommand, SessionTask sessionTask) {
        dispatchSessionTaskWithSessionCommandInternal(sessionCommand, 0, sessionTask, this.sessionCompat.getCurrentControllerInfo());
    }

    private void dispatchSessionTaskWithSessionCommandInternal(final SessionCommand sessionCommand, final int i, final SessionTask sessionTask, final MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        if (remoteUserInfo == null) {
            StringBuilder sb = new StringBuilder("RemoteUserInfo is null, ignoring command=");
            Object objValueOf = sessionCommand;
            if (sessionCommand == null) {
                objValueOf = Integer.valueOf(i);
            }
            Log.d(TAG, sb.append(objValueOf).toString());
            return;
        }
        Util.postOrRun(this.sessionImpl.getApplicationHandler(), new Runnable() { // from class: androidx.media3.session.MediaSessionLegacyStub$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m365x316e235(sessionCommand, i, remoteUserInfo, sessionTask);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$dispatchSessionTaskWithSessionCommandInternal$23$androidx-media3-session-MediaSessionLegacyStub, reason: not valid java name */
    /* synthetic */ void m365x316e235(SessionCommand sessionCommand, int i, MediaSessionManager.RemoteUserInfo remoteUserInfo, SessionTask sessionTask) {
        if (this.sessionImpl.isReleased()) {
            return;
        }
        if (!this.sessionCompat.isActive()) {
            Log.w(TAG, "Ignore incoming session command before initialization. command=" + (sessionCommand == null ? Integer.valueOf(i) : sessionCommand.customAction) + ", pid=" + remoteUserInfo.getPid());
            return;
        }
        MediaSession.ControllerInfo controllerInfoTryGetController = tryGetController(remoteUserInfo);
        if (controllerInfoTryGetController == null) {
            return;
        }
        if (sessionCommand != null) {
            if (!this.connectedControllersManager.isSessionCommandAvailable(controllerInfoTryGetController, sessionCommand)) {
                return;
            }
        } else if (!this.connectedControllersManager.isSessionCommandAvailable(controllerInfoTryGetController, i)) {
            return;
        }
        try {
            sessionTask.run(controllerInfoTryGetController);
        } catch (RemoteException e) {
            Log.w(TAG, "Exception in " + controllerInfoTryGetController, e);
        }
    }

    private MediaSession.ControllerInfo tryGetController(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        MediaSession.ControllerInfo controller = this.connectedControllersManager.getController(remoteUserInfo);
        if (controller == null) {
            ControllerLegacyCb controllerLegacyCb = new ControllerLegacyCb(remoteUserInfo);
            MediaSession.ControllerInfo controllerInfo = new MediaSession.ControllerInfo(remoteUserInfo, 0, 0, this.sessionManager.isTrustedForMediaControl(remoteUserInfo), controllerLegacyCb, Bundle.EMPTY);
            MediaSession.ConnectionResult connectionResultOnConnectOnHandler = this.sessionImpl.onConnectOnHandler(controllerInfo);
            if (!connectionResultOnConnectOnHandler.isAccepted) {
                try {
                    controllerLegacyCb.onDisconnected(0);
                    return null;
                } catch (RemoteException unused) {
                    return null;
                }
            }
            this.connectedControllersManager.addController(controllerInfo.getRemoteUserInfo(), controllerInfo, connectionResultOnConnectOnHandler.availableSessionCommands, connectionResultOnConnectOnHandler.availablePlayerCommands);
            controller = controllerInfo;
        }
        this.connectionTimeoutHandler.disconnectControllerAfterTimeout(controller, this.connectionTimeoutMs);
        return controller;
    }

    public void setLegacyControllerDisconnectTimeoutMs(long j) {
        this.connectionTimeoutMs = j;
    }

    private void handleMediaRequest(final MediaItem mediaItem, final boolean z) {
        dispatchSessionTaskWithPlayerCommand(31, new SessionTask() { // from class: androidx.media3.session.MediaSessionLegacyStub$$ExternalSyntheticLambda16
            @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
            public final void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                this.f$0.m367xe9158228(mediaItem, z, controllerInfo);
            }
        }, this.sessionCompat.getCurrentControllerInfo());
    }

    /* JADX INFO: renamed from: lambda$handleMediaRequest$24$androidx-media3-session-MediaSessionLegacyStub, reason: not valid java name */
    /* synthetic */ void m367xe9158228(MediaItem mediaItem, boolean z, MediaSession.ControllerInfo controllerInfo) throws RemoteException {
        Futures.addCallback(this.sessionImpl.onSetMediaItemsOnHandler(controllerInfo, ImmutableList.of(mediaItem), -1, -9223372036854775807L), new AnonymousClass1(controllerInfo, z), MoreExecutors.directExecutor());
    }

    /* JADX INFO: renamed from: androidx.media3.session.MediaSessionLegacyStub$1, reason: invalid class name */
    class AnonymousClass1 implements FutureCallback<MediaSession.MediaItemsWithStartPosition> {
        final /* synthetic */ MediaSession.ControllerInfo val$controller;
        final /* synthetic */ boolean val$play;

        @Override // com.google.common.util.concurrent.FutureCallback
        public void onFailure(Throwable th) {
        }

        AnonymousClass1(MediaSession.ControllerInfo controllerInfo, boolean z) {
            this.val$controller = controllerInfo;
            this.val$play = z;
        }

        @Override // com.google.common.util.concurrent.FutureCallback
        public void onSuccess(final MediaSession.MediaItemsWithStartPosition mediaItemsWithStartPosition) {
            Handler applicationHandler = MediaSessionLegacyStub.this.sessionImpl.getApplicationHandler();
            MediaSessionImpl mediaSessionImpl = MediaSessionLegacyStub.this.sessionImpl;
            MediaSession.ControllerInfo controllerInfo = this.val$controller;
            final boolean z = this.val$play;
            Util.postOrRun(applicationHandler, mediaSessionImpl.callWithControllerForCurrentRequestSet(controllerInfo, new Runnable() { // from class: androidx.media3.session.MediaSessionLegacyStub$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m389xec13c618(mediaItemsWithStartPosition, z);
                }
            }));
        }

        /* JADX INFO: renamed from: lambda$onSuccess$0$androidx-media3-session-MediaSessionLegacyStub$1, reason: not valid java name */
        /* synthetic */ void m389xec13c618(MediaSession.MediaItemsWithStartPosition mediaItemsWithStartPosition, boolean z) {
            PlayerWrapper playerWrapper = MediaSessionLegacyStub.this.sessionImpl.getPlayerWrapper();
            MediaUtils.setMediaItemsWithStartIndexAndPosition(playerWrapper, mediaItemsWithStartPosition);
            int playbackState = playerWrapper.getPlaybackState();
            if (playbackState == 1) {
                playerWrapper.prepareIfCommandAvailable();
            } else if (playbackState == 4) {
                playerWrapper.seekToDefaultPositionIfCommandAvailable();
            }
            if (z) {
                playerWrapper.playIfCommandAvailable();
            }
        }
    }

    private void handleOnAddQueueItem(final MediaDescriptionCompat mediaDescriptionCompat, final int i) {
        if (mediaDescriptionCompat == null) {
            return;
        }
        dispatchSessionTaskWithPlayerCommand(20, new SessionTask() { // from class: androidx.media3.session.MediaSessionLegacyStub$$ExternalSyntheticLambda0
            @Override // androidx.media3.session.MediaSessionLegacyStub.SessionTask
            public final void run(MediaSession.ControllerInfo controllerInfo) throws RemoteException {
                this.f$0.m368xabb1009e(mediaDescriptionCompat, i, controllerInfo);
            }
        }, this.sessionCompat.getCurrentControllerInfo());
    }

    /* JADX INFO: renamed from: lambda$handleOnAddQueueItem$25$androidx-media3-session-MediaSessionLegacyStub, reason: not valid java name */
    /* synthetic */ void m368xabb1009e(MediaDescriptionCompat mediaDescriptionCompat, int i, MediaSession.ControllerInfo controllerInfo) throws RemoteException {
        if (TextUtils.isEmpty(mediaDescriptionCompat.getMediaId())) {
            Log.w(TAG, "onAddQueueItem(): Media ID shouldn't be empty");
        } else {
            Futures.addCallback(this.sessionImpl.onAddMediaItemsOnHandler(controllerInfo, ImmutableList.of(MediaUtils.convertToMediaItem(mediaDescriptionCompat))), new AnonymousClass2(controllerInfo, i), MoreExecutors.directExecutor());
        }
    }

    /* JADX INFO: renamed from: androidx.media3.session.MediaSessionLegacyStub$2, reason: invalid class name */
    class AnonymousClass2 implements FutureCallback<List<MediaItem>> {
        final /* synthetic */ MediaSession.ControllerInfo val$controller;
        final /* synthetic */ int val$index;

        @Override // com.google.common.util.concurrent.FutureCallback
        public void onFailure(Throwable th) {
        }

        AnonymousClass2(MediaSession.ControllerInfo controllerInfo, int i) {
            this.val$controller = controllerInfo;
            this.val$index = i;
        }

        @Override // com.google.common.util.concurrent.FutureCallback
        public void onSuccess(final List<MediaItem> list) {
            Handler applicationHandler = MediaSessionLegacyStub.this.sessionImpl.getApplicationHandler();
            MediaSessionImpl mediaSessionImpl = MediaSessionLegacyStub.this.sessionImpl;
            MediaSession.ControllerInfo controllerInfo = this.val$controller;
            final int i = this.val$index;
            Util.postOrRun(applicationHandler, mediaSessionImpl.callWithControllerForCurrentRequestSet(controllerInfo, new Runnable() { // from class: androidx.media3.session.MediaSessionLegacyStub$2$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m390xec13c619(i, list);
                }
            }));
        }

        /* JADX INFO: renamed from: lambda$onSuccess$0$androidx-media3-session-MediaSessionLegacyStub$2, reason: not valid java name */
        /* synthetic */ void m390xec13c619(int i, List list) {
            if (i == -1) {
                MediaSessionLegacyStub.this.sessionImpl.getPlayerWrapper().addMediaItems(list);
            } else {
                MediaSessionLegacyStub.this.sessionImpl.getPlayerWrapper().addMediaItems(i, list);
            }
        }
    }

    private static void sendCustomCommandResultWhenReady(final ResultReceiver resultReceiver, final ListenableFuture<SessionResult> listenableFuture) {
        listenableFuture.addListener(new Runnable() { // from class: androidx.media3.session.MediaSessionLegacyStub$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                MediaSessionLegacyStub.lambda$sendCustomCommandResultWhenReady$26(listenableFuture, resultReceiver);
            }
        }, MoreExecutors.directExecutor());
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void lambda$sendCustomCommandResultWhenReady$26(ListenableFuture listenableFuture, ResultReceiver resultReceiver) {
        SessionResult sessionResult;
        try {
            sessionResult = (SessionResult) Assertions.checkNotNull((SessionResult) listenableFuture.get(), "SessionResult must not be null");
        } catch (InterruptedException e) {
            e = e;
            Log.w(TAG, "Custom command failed", e);
            sessionResult = new SessionResult(-1);
        } catch (CancellationException e2) {
            Log.w(TAG, "Custom command cancelled", e2);
            sessionResult = new SessionResult(1);
        } catch (ExecutionException e3) {
            e = e3;
            Log.w(TAG, "Custom command failed", e);
            sessionResult = new SessionResult(-1);
        }
        resultReceiver.send(sessionResult.resultCode, sessionResult.extras);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setMetadata(MediaSessionCompat mediaSessionCompat, MediaMetadataCompat mediaMetadataCompat) {
        mediaSessionCompat.setMetadata(mediaMetadataCompat);
    }

    private static void setMediaButtonReceiver(MediaSessionCompat mediaSessionCompat, PendingIntent pendingIntent) {
        mediaSessionCompat.setMediaButtonReceiver(pendingIntent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setQueue(MediaSessionCompat mediaSessionCompat, List<MediaSessionCompat.QueueItem> list) {
        mediaSessionCompat.setQueue(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setQueueTitle(MediaSessionCompat mediaSessionCompat, CharSequence charSequence) {
        mediaSessionCompat.setQueueTitle(charSequence);
    }

    private static MediaItem createMediaItemForMediaRequest(String str, Uri uri, String str2, Bundle bundle) {
        MediaItem.Builder builder = new MediaItem.Builder();
        if (str == null) {
            str = "";
        }
        return builder.setMediaId(str).setRequestMetadata(new MediaItem.RequestMetadata.Builder().setMediaUri(uri).setSearchQuery(str2).setExtras(bundle).build()).build();
    }

    private static final class ControllerLegacyCb implements MediaSession.ControllerCb {
        private final MediaSessionManager.RemoteUserInfo remoteUserInfo;

        public ControllerLegacyCb(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            this.remoteUserInfo = remoteUserInfo;
        }

        public int hashCode() {
            return ObjectsCompat.hash(this.remoteUserInfo);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != ControllerLegacyCb.class) {
                return false;
            }
            return Util.areEqual(this.remoteUserInfo, ((ControllerLegacyCb) obj).remoteUserInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    final class ControllerLegacyCbForBroadcast implements MediaSession.ControllerCb {
        private Uri lastMediaUri;
        private MediaMetadata lastMediaMetadata = MediaMetadata.EMPTY;
        private String lastMediaId = "";
        private long lastDurationMs = -9223372036854775807L;

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onDisconnected(int i) throws RemoteException {
        }

        public ControllerLegacyCbForBroadcast() {
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onAvailableCommandsChangedFromPlayer(int i, Player.Commands commands) {
            PlayerWrapper playerWrapper = MediaSessionLegacyStub.this.sessionImpl.getPlayerWrapper();
            MediaSessionLegacyStub.this.maybeUpdateFlags(playerWrapper);
            MediaSessionLegacyStub.this.sessionImpl.getSessionCompat().setPlaybackState(playerWrapper.createPlaybackStateCompat());
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onPlayerChanged(int i, PlayerWrapper playerWrapper, PlayerWrapper playerWrapper2) throws RemoteException {
            Timeline currentTimelineWithCommandCheck = playerWrapper2.getCurrentTimelineWithCommandCheck();
            if (playerWrapper == null || !Util.areEqual(playerWrapper.getCurrentTimelineWithCommandCheck(), currentTimelineWithCommandCheck)) {
                onTimelineChanged(i, currentTimelineWithCommandCheck, 0);
            }
            MediaMetadata playlistMetadataWithCommandCheck = playerWrapper2.getPlaylistMetadataWithCommandCheck();
            if (playerWrapper == null || !Util.areEqual(playerWrapper.getPlaylistMetadataWithCommandCheck(), playlistMetadataWithCommandCheck)) {
                onPlaylistMetadataChanged(i, playlistMetadataWithCommandCheck);
            }
            MediaMetadata mediaMetadataWithCommandCheck = playerWrapper2.getMediaMetadataWithCommandCheck();
            if (playerWrapper == null || !Util.areEqual(playerWrapper.getMediaMetadataWithCommandCheck(), mediaMetadataWithCommandCheck)) {
                onMediaMetadataChanged(i, mediaMetadataWithCommandCheck);
            }
            if (playerWrapper == null || playerWrapper.getShuffleModeEnabled() != playerWrapper2.getShuffleModeEnabled()) {
                onShuffleModeEnabledChanged(i, playerWrapper2.getShuffleModeEnabled());
            }
            if (playerWrapper == null || playerWrapper.getRepeatMode() != playerWrapper2.getRepeatMode()) {
                onRepeatModeChanged(i, playerWrapper2.getRepeatMode());
            }
            onDeviceInfoChanged(i, playerWrapper2.getDeviceInfo());
            MediaSessionLegacyStub.this.maybeUpdateFlags(playerWrapper2);
            MediaItem currentMediaItemWithCommandCheck = playerWrapper2.getCurrentMediaItemWithCommandCheck();
            if (playerWrapper != null && Util.areEqual(playerWrapper.getCurrentMediaItemWithCommandCheck(), currentMediaItemWithCommandCheck)) {
                MediaSessionLegacyStub.this.sessionCompat.setPlaybackState(playerWrapper2.createPlaybackStateCompat());
            } else {
                onMediaItemTransition(i, currentMediaItemWithCommandCheck, 3);
            }
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onPlayerError(int i, PlaybackException playbackException) {
            MediaSessionLegacyStub.this.sessionImpl.getSessionCompat().setPlaybackState(MediaSessionLegacyStub.this.sessionImpl.getPlayerWrapper().createPlaybackStateCompat());
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void setCustomLayout(int i, List<CommandButton> list) {
            MediaSessionLegacyStub.this.sessionImpl.getSessionCompat().setPlaybackState(MediaSessionLegacyStub.this.sessionImpl.getPlayerWrapper().createPlaybackStateCompat());
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onSessionExtrasChanged(int i, Bundle bundle) {
            MediaSessionLegacyStub.this.sessionImpl.getSessionCompat().setExtras(bundle);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void sendCustomCommand(int i, SessionCommand sessionCommand, Bundle bundle) {
            MediaSessionLegacyStub.this.sessionImpl.getSessionCompat().sendSessionEvent(sessionCommand.customAction, bundle);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onPlayWhenReadyChanged(int i, boolean z, int i2) throws RemoteException {
            MediaSessionLegacyStub.this.sessionImpl.getSessionCompat().setPlaybackState(MediaSessionLegacyStub.this.sessionImpl.getPlayerWrapper().createPlaybackStateCompat());
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onPlaybackSuppressionReasonChanged(int i, int i2) throws RemoteException {
            MediaSessionLegacyStub.this.sessionImpl.getSessionCompat().setPlaybackState(MediaSessionLegacyStub.this.sessionImpl.getPlayerWrapper().createPlaybackStateCompat());
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onPlaybackStateChanged(int i, int i2, PlaybackException playbackException) throws RemoteException {
            MediaSessionLegacyStub.this.sessionImpl.getSessionCompat().setPlaybackState(MediaSessionLegacyStub.this.sessionImpl.getPlayerWrapper().createPlaybackStateCompat());
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onIsPlayingChanged(int i, boolean z) throws RemoteException {
            MediaSessionLegacyStub.this.sessionImpl.getSessionCompat().setPlaybackState(MediaSessionLegacyStub.this.sessionImpl.getPlayerWrapper().createPlaybackStateCompat());
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onPositionDiscontinuity(int i, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i2) throws RemoteException {
            MediaSessionLegacyStub.this.sessionImpl.getSessionCompat().setPlaybackState(MediaSessionLegacyStub.this.sessionImpl.getPlayerWrapper().createPlaybackStateCompat());
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onPlaybackParametersChanged(int i, PlaybackParameters playbackParameters) throws RemoteException {
            MediaSessionLegacyStub.this.sessionImpl.getSessionCompat().setPlaybackState(MediaSessionLegacyStub.this.sessionImpl.getPlayerWrapper().createPlaybackStateCompat());
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onMediaItemTransition(int i, MediaItem mediaItem, int i2) throws RemoteException {
            updateMetadataIfChanged();
            if (mediaItem == null) {
                MediaSessionLegacyStub.this.sessionCompat.setRatingType(0);
            } else {
                MediaSessionLegacyStub.this.sessionCompat.setRatingType(MediaUtils.getRatingCompatStyle(mediaItem.mediaMetadata.userRating));
            }
            MediaSessionLegacyStub.this.sessionImpl.getSessionCompat().setPlaybackState(MediaSessionLegacyStub.this.sessionImpl.getPlayerWrapper().createPlaybackStateCompat());
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onMediaMetadataChanged(int i, MediaMetadata mediaMetadata) {
            updateMetadataIfChanged();
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onTimelineChanged(int i, Timeline timeline, int i2) throws RemoteException {
            if (timeline.isEmpty()) {
                MediaSessionLegacyStub.setQueue(MediaSessionLegacyStub.this.sessionCompat, null);
            } else {
                updateQueue(timeline);
                updateMetadataIfChanged();
            }
        }

        private void updateQueue(final Timeline timeline) {
            final List<MediaItem> listConvertToMediaItemList = MediaUtils.convertToMediaItemList(timeline);
            final ArrayList arrayList = new ArrayList();
            final AtomicInteger atomicInteger = new AtomicInteger(0);
            Runnable runnable = new Runnable() { // from class: androidx.media3.session.MediaSessionLegacyStub$ControllerLegacyCbForBroadcast$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m391x58a50959(atomicInteger, listConvertToMediaItemList, arrayList, timeline);
                }
            };
            for (int i = 0; i < listConvertToMediaItemList.size(); i++) {
                MediaMetadata mediaMetadata = listConvertToMediaItemList.get(i).mediaMetadata;
                if (mediaMetadata.artworkData != null) {
                    ListenableFuture<Bitmap> listenableFutureDecodeBitmap = MediaSessionLegacyStub.this.sessionImpl.getBitmapLoader().decodeBitmap(mediaMetadata.artworkData);
                    arrayList.add(listenableFutureDecodeBitmap);
                    Handler applicationHandler = MediaSessionLegacyStub.this.sessionImpl.getApplicationHandler();
                    Objects.requireNonNull(applicationHandler);
                    listenableFutureDecodeBitmap.addListener(runnable, new MediaSessionLegacyStub$ControllerLegacyCbForBroadcast$$ExternalSyntheticLambda1(applicationHandler));
                } else {
                    arrayList.add(null);
                    runnable.run();
                }
            }
        }

        /* JADX INFO: renamed from: lambda$updateQueue$0$androidx-media3-session-MediaSessionLegacyStub$ControllerLegacyCbForBroadcast, reason: not valid java name */
        /* synthetic */ void m391x58a50959(AtomicInteger atomicInteger, List list, List list2, Timeline timeline) {
            if (atomicInteger.incrementAndGet() == list.size()) {
                handleBitmapFuturesAllCompletedAndSetQueue(list2, timeline, list);
            }
        }

        private void handleBitmapFuturesAllCompletedAndSetQueue(List<ListenableFuture<Bitmap>> list, Timeline timeline, List<MediaItem> list2) {
            Bitmap bitmap;
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                ListenableFuture<Bitmap> listenableFuture = list.get(i);
                if (listenableFuture != null) {
                    try {
                        bitmap = (Bitmap) Futures.getDone(listenableFuture);
                    } catch (CancellationException | ExecutionException e) {
                        Log.d(MediaSessionLegacyStub.TAG, "Failed to get bitmap", e);
                        bitmap = null;
                    }
                } else {
                    bitmap = null;
                }
                arrayList.add(MediaUtils.convertToQueueItem(list2.get(i), i, bitmap));
            }
            if (Util.SDK_INT >= 21) {
                MediaSessionLegacyStub.this.sessionCompat.setQueue(arrayList);
                return;
            }
            List<MediaSessionCompat.QueueItem> listTruncateListBySize = MediaUtils.truncateListBySize(arrayList, 262144);
            if (listTruncateListBySize.size() != timeline.getWindowCount()) {
                Log.i(MediaSessionLegacyStub.TAG, "Sending " + listTruncateListBySize.size() + " items out of " + timeline.getWindowCount());
            }
            MediaSessionLegacyStub.this.sessionCompat.setQueue(listTruncateListBySize);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onPlaylistMetadataChanged(int i, MediaMetadata mediaMetadata) throws RemoteException {
            CharSequence queueTitle = MediaSessionLegacyStub.this.sessionCompat.getController().getQueueTitle();
            CharSequence charSequence = mediaMetadata.title;
            if (TextUtils.equals(queueTitle, charSequence)) {
                return;
            }
            MediaSessionLegacyStub.setQueueTitle(MediaSessionLegacyStub.this.sessionCompat, charSequence);
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onShuffleModeEnabledChanged(int i, boolean z) throws RemoteException {
            MediaSessionLegacyStub.this.sessionImpl.getSessionCompat().setShuffleMode(MediaUtils.convertToPlaybackStateCompatShuffleMode(z));
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onRepeatModeChanged(int i, int i2) throws RemoteException {
            MediaSessionLegacyStub.this.sessionImpl.getSessionCompat().setRepeatMode(MediaUtils.convertToPlaybackStateCompatRepeatMode(i2));
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onAudioAttributesChanged(int i, AudioAttributes audioAttributes) {
            if (MediaSessionLegacyStub.this.sessionImpl.getPlayerWrapper().getDeviceInfo().playbackType == 0) {
                MediaSessionLegacyStub.this.sessionCompat.setPlaybackToLocal(MediaUtils.getLegacyStreamType(audioAttributes));
            }
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onDeviceInfoChanged(int i, DeviceInfo deviceInfo) {
            PlayerWrapper playerWrapper = MediaSessionLegacyStub.this.sessionImpl.getPlayerWrapper();
            MediaSessionLegacyStub.this.volumeProviderCompat = playerWrapper.createVolumeProviderCompat();
            if (MediaSessionLegacyStub.this.volumeProviderCompat != null) {
                MediaSessionLegacyStub.this.sessionCompat.setPlaybackToRemote(MediaSessionLegacyStub.this.volumeProviderCompat);
            } else {
                MediaSessionLegacyStub.this.sessionCompat.setPlaybackToLocal(MediaUtils.getLegacyStreamType(playerWrapper.getAudioAttributesWithCommandCheck()));
            }
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onDeviceVolumeChanged(int i, int i2, boolean z) {
            if (MediaSessionLegacyStub.this.volumeProviderCompat != null) {
                VolumeProviderCompat volumeProviderCompat = MediaSessionLegacyStub.this.volumeProviderCompat;
                if (z) {
                    i2 = 0;
                }
                volumeProviderCompat.setCurrentVolume(i2);
            }
        }

        @Override // androidx.media3.session.MediaSession.ControllerCb
        public void onPeriodicSessionPositionInfoChanged(int i, SessionPositionInfo sessionPositionInfo, boolean z, boolean z2) throws RemoteException {
            MediaSessionLegacyStub.this.sessionImpl.getSessionCompat().setPlaybackState(MediaSessionLegacyStub.this.sessionImpl.getPlayerWrapper().createPlaybackStateCompat());
        }

        private void updateMetadataIfChanged() {
            Bitmap bitmap;
            PlayerWrapper playerWrapper = MediaSessionLegacyStub.this.sessionImpl.getPlayerWrapper();
            MediaItem currentMediaItemWithCommandCheck = playerWrapper.getCurrentMediaItemWithCommandCheck();
            final MediaMetadata mediaMetadataWithCommandCheck = playerWrapper.getMediaMetadataWithCommandCheck();
            final long durationWithCommandCheck = playerWrapper.getDurationWithCommandCheck();
            final String str = currentMediaItemWithCommandCheck != null ? currentMediaItemWithCommandCheck.mediaId : "";
            Uri uri = (currentMediaItemWithCommandCheck == null || currentMediaItemWithCommandCheck.localConfiguration == null) ? null : currentMediaItemWithCommandCheck.localConfiguration.uri;
            if (Objects.equals(this.lastMediaMetadata, mediaMetadataWithCommandCheck) && Objects.equals(this.lastMediaId, str) && Objects.equals(this.lastMediaUri, uri) && this.lastDurationMs == durationWithCommandCheck) {
                return;
            }
            this.lastMediaId = str;
            this.lastMediaUri = uri;
            this.lastMediaMetadata = mediaMetadataWithCommandCheck;
            this.lastDurationMs = durationWithCommandCheck;
            ListenableFuture<Bitmap> listenableFutureLoadBitmapFromMetadata = MediaSessionLegacyStub.this.sessionImpl.getBitmapLoader().loadBitmapFromMetadata(mediaMetadataWithCommandCheck);
            if (listenableFutureLoadBitmapFromMetadata != null) {
                MediaSessionLegacyStub.this.pendingBitmapLoadCallback = null;
                if (!listenableFutureLoadBitmapFromMetadata.isDone()) {
                    final Uri uri2 = uri;
                    MediaSessionLegacyStub.this.pendingBitmapLoadCallback = new FutureCallback<Bitmap>() { // from class: androidx.media3.session.MediaSessionLegacyStub.ControllerLegacyCbForBroadcast.1
                        @Override // com.google.common.util.concurrent.FutureCallback
                        public void onSuccess(Bitmap bitmap2) {
                            if (this != MediaSessionLegacyStub.this.pendingBitmapLoadCallback) {
                                return;
                            }
                            MediaSessionLegacyStub.setMetadata(MediaSessionLegacyStub.this.sessionCompat, MediaUtils.convertToMediaMetadataCompat(mediaMetadataWithCommandCheck, str, uri2, durationWithCommandCheck, bitmap2));
                            MediaSessionLegacyStub.this.sessionImpl.onNotificationRefreshRequired();
                        }

                        @Override // com.google.common.util.concurrent.FutureCallback
                        public void onFailure(Throwable th) {
                            if (this != MediaSessionLegacyStub.this.pendingBitmapLoadCallback) {
                                return;
                            }
                            Log.w(MediaSessionLegacyStub.TAG, MediaSessionLegacyStub.getBitmapLoadErrorMessage(th));
                        }
                    };
                    FutureCallback futureCallback = MediaSessionLegacyStub.this.pendingBitmapLoadCallback;
                    Handler applicationHandler = MediaSessionLegacyStub.this.sessionImpl.getApplicationHandler();
                    Objects.requireNonNull(applicationHandler);
                    Futures.addCallback(listenableFutureLoadBitmapFromMetadata, futureCallback, new MediaSessionLegacyStub$ControllerLegacyCbForBroadcast$$ExternalSyntheticLambda1(applicationHandler));
                } else {
                    try {
                        bitmap = (Bitmap) Futures.getDone(listenableFutureLoadBitmapFromMetadata);
                    } catch (ExecutionException e) {
                        Log.w(MediaSessionLegacyStub.TAG, MediaSessionLegacyStub.getBitmapLoadErrorMessage(e));
                        bitmap = null;
                    }
                }
                bitmap = null;
            } else {
                bitmap = null;
            }
            MediaSessionLegacyStub.setMetadata(MediaSessionLegacyStub.this.sessionCompat, MediaUtils.convertToMediaMetadataCompat(mediaMetadataWithCommandCheck, str, uri, durationWithCommandCheck, bitmap));
        }
    }

    private static class ConnectionTimeoutHandler extends Handler {
        private static final int MSG_CONNECTION_TIMED_OUT = 1001;
        private final ConnectedControllersManager<MediaSessionManager.RemoteUserInfo> connectedControllersManager;

        public ConnectionTimeoutHandler(Looper looper, ConnectedControllersManager<MediaSessionManager.RemoteUserInfo> connectedControllersManager) {
            super(looper);
            this.connectedControllersManager = connectedControllersManager;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            MediaSession.ControllerInfo controllerInfo = (MediaSession.ControllerInfo) message.obj;
            if (this.connectedControllersManager.isConnected(controllerInfo)) {
                try {
                    ((MediaSession.ControllerCb) Assertions.checkStateNotNull(controllerInfo.getControllerCb())).onDisconnected(0);
                } catch (RemoteException unused) {
                }
                this.connectedControllersManager.removeController(controllerInfo);
            }
        }

        public void disconnectControllerAfterTimeout(MediaSession.ControllerInfo controllerInfo, long j) {
            removeMessages(1001, controllerInfo);
            sendMessageDelayed(obtainMessage(1001, controllerInfo), j);
        }
    }

    private class MediaPlayPauseKeyHandler extends Handler {
        private static final int MSG_DOUBLE_TAP_TIMED_OUT = 1002;

        public MediaPlayPauseKeyHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            MediaSessionLegacyStub.this.handleMediaPlayPauseOnHandler((MediaSessionManager.RemoteUserInfo) message.obj);
        }

        public void addPendingMediaPlayPauseKey(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            sendMessageDelayed(obtainMessage(1002, remoteUserInfo), ViewConfiguration.getDoubleTapTimeout());
        }

        public void clearPendingMediaPlayPauseKey() {
            removeMessages(1002);
        }

        public boolean hasPendingMediaPlayPauseKey() {
            return hasMessages(1002);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getBitmapLoadErrorMessage(Throwable th) {
        return "Failed to load bitmap: " + th.getMessage();
    }

    private static ComponentName getServiceComponentByAction(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent(str);
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
            return null;
        }
        ResolveInfo resolveInfo = listQueryIntentServices.get(0);
        return new ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name);
    }

    private final class MediaButtonReceiver extends BroadcastReceiver {
        private MediaButtonReceiver() {
        }

        /* synthetic */ MediaButtonReceiver(MediaSessionLegacyStub mediaSessionLegacyStub, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            KeyEvent keyEvent;
            if (Util.areEqual(intent.getAction(), "android.intent.action.MEDIA_BUTTON")) {
                Uri data = intent.getData();
                if (Util.areEqual(data, data) && (keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT")) != null) {
                    MediaSessionLegacyStub.this.getSessionCompat().getController().dispatchMediaButtonEvent(keyEvent);
                }
            }
        }
    }
}
