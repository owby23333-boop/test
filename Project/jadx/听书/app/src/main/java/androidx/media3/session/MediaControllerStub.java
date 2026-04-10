package androidx.media3.session;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.media3.common.Player;
import androidx.media3.common.util.BundleableUtil;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.session.IMediaController;
import androidx.media3.session.MediaLibraryService;
import androidx.media3.session.PlayerInfo;
import com.google.common.collect.ImmutableList;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
class MediaControllerStub extends IMediaController.Stub {
    private static final String TAG = "MediaControllerStub";
    public static final int VERSION_INT = 3;
    private final WeakReference<MediaControllerImplBase> controller;

    /* JADX INFO: Access modifiers changed from: private */
    interface ControllerTask<T extends MediaControllerImplBase> {
        void run(T t);
    }

    public MediaControllerStub(MediaControllerImplBase mediaControllerImplBase) {
        this.controller = new WeakReference<>(mediaControllerImplBase);
    }

    @Override // androidx.media3.session.IMediaController
    public void onSessionResult(int i, Bundle bundle) {
        try {
            setControllerFutureResult(i, (SessionResult) SessionResult.CREATOR.fromBundle(bundle));
        } catch (RuntimeException e) {
            Log.w(TAG, "Ignoring malformed Bundle for SessionResult", e);
        }
    }

    @Override // androidx.media3.session.IMediaController
    public void onLibraryResult(int i, Bundle bundle) {
        try {
            setControllerFutureResult(i, (LibraryResult) LibraryResult.UNKNOWN_TYPE_CREATOR.fromBundle(bundle));
        } catch (RuntimeException e) {
            Log.w(TAG, "Ignoring malformed Bundle for LibraryResult", e);
        }
    }

    @Override // androidx.media3.session.IMediaController
    public void onConnected(int i, Bundle bundle) {
        try {
            final ConnectionState connectionState = (ConnectionState) ConnectionState.CREATOR.fromBundle(bundle);
            dispatchControllerTaskOnHandler(new ControllerTask() { // from class: androidx.media3.session.MediaControllerStub$$ExternalSyntheticLambda7
                @Override // androidx.media3.session.MediaControllerStub.ControllerTask
                public final void run(MediaControllerImplBase mediaControllerImplBase) {
                    mediaControllerImplBase.onConnected(connectionState);
                }
            });
        } catch (RuntimeException e) {
            Log.w(TAG, "Malformed Bundle for ConnectionResult. Disconnected from the session.", e);
            onDisconnected(i);
        }
    }

    @Override // androidx.media3.session.IMediaController
    public void onDisconnected(int i) {
        dispatchControllerTaskOnHandler(new ControllerTask() { // from class: androidx.media3.session.MediaControllerStub$$ExternalSyntheticLambda4
            @Override // androidx.media3.session.MediaControllerStub.ControllerTask
            public final void run(MediaControllerImplBase mediaControllerImplBase) {
                MediaControllerStub.lambda$onDisconnected$1(mediaControllerImplBase);
            }
        });
    }

    static /* synthetic */ void lambda$onDisconnected$1(MediaControllerImplBase mediaControllerImplBase) {
        MediaController mediaControllerImplBase2 = mediaControllerImplBase.getInstance();
        MediaController mediaControllerImplBase3 = mediaControllerImplBase.getInstance();
        Objects.requireNonNull(mediaControllerImplBase3);
        mediaControllerImplBase2.runOnApplicationLooper(new MediaControllerImplBase$$ExternalSyntheticLambda39(mediaControllerImplBase3));
    }

    @Override // androidx.media3.session.IMediaController
    public void onSetCustomLayout(final int i, List<Bundle> list) {
        try {
            final ImmutableList immutableListFromBundleList = BundleableUtil.fromBundleList(CommandButton.CREATOR, list);
            dispatchControllerTaskOnHandler(new ControllerTask() { // from class: androidx.media3.session.MediaControllerStub$$ExternalSyntheticLambda5
                @Override // androidx.media3.session.MediaControllerStub.ControllerTask
                public final void run(MediaControllerImplBase mediaControllerImplBase) {
                    mediaControllerImplBase.onSetCustomLayout(i, immutableListFromBundleList);
                }
            });
        } catch (RuntimeException e) {
            Log.w(TAG, "Ignoring malformed Bundle for CommandButton", e);
        }
    }

    @Override // androidx.media3.session.IMediaController
    public void onAvailableCommandsChangedFromSession(int i, Bundle bundle, Bundle bundle2) {
        try {
            final SessionCommands sessionCommands = (SessionCommands) SessionCommands.CREATOR.fromBundle(bundle);
            try {
                final Player.Commands commands = (Player.Commands) Player.Commands.CREATOR.fromBundle(bundle2);
                dispatchControllerTaskOnHandler(new ControllerTask() { // from class: androidx.media3.session.MediaControllerStub$$ExternalSyntheticLambda1
                    @Override // androidx.media3.session.MediaControllerStub.ControllerTask
                    public final void run(MediaControllerImplBase mediaControllerImplBase) {
                        mediaControllerImplBase.onAvailableCommandsChangedFromSession(sessionCommands, commands);
                    }
                });
            } catch (RuntimeException e) {
                Log.w(TAG, "Ignoring malformed Bundle for Commands", e);
            }
        } catch (RuntimeException e2) {
            Log.w(TAG, "Ignoring malformed Bundle for SessionCommands", e2);
        }
    }

    @Override // androidx.media3.session.IMediaController
    public void onAvailableCommandsChangedFromPlayer(int i, Bundle bundle) {
        try {
            final Player.Commands commands = (Player.Commands) Player.Commands.CREATOR.fromBundle(bundle);
            dispatchControllerTaskOnHandler(new ControllerTask() { // from class: androidx.media3.session.MediaControllerStub$$ExternalSyntheticLambda8
                @Override // androidx.media3.session.MediaControllerStub.ControllerTask
                public final void run(MediaControllerImplBase mediaControllerImplBase) {
                    mediaControllerImplBase.onAvailableCommandsChangedFromPlayer(commands);
                }
            });
        } catch (RuntimeException e) {
            Log.w(TAG, "Ignoring malformed Bundle for Commands", e);
        }
    }

    @Override // androidx.media3.session.IMediaController
    public void onCustomCommand(final int i, Bundle bundle, final Bundle bundle2) {
        if (bundle2 == null) {
            Log.w(TAG, "Ignoring custom command with null args.");
            return;
        }
        try {
            final SessionCommand sessionCommand = (SessionCommand) SessionCommand.CREATOR.fromBundle(bundle);
            dispatchControllerTaskOnHandler(new ControllerTask() { // from class: androidx.media3.session.MediaControllerStub$$ExternalSyntheticLambda2
                @Override // androidx.media3.session.MediaControllerStub.ControllerTask
                public final void run(MediaControllerImplBase mediaControllerImplBase) {
                    mediaControllerImplBase.onCustomCommand(i, sessionCommand, bundle2);
                }
            });
        } catch (RuntimeException e) {
            Log.w(TAG, "Ignoring malformed Bundle for SessionCommand", e);
        }
    }

    @Override // androidx.media3.session.IMediaController
    public void onSessionActivityChanged(final int i, final PendingIntent pendingIntent) throws RemoteException {
        dispatchControllerTaskOnHandler(new ControllerTask() { // from class: androidx.media3.session.MediaControllerStub$$ExternalSyntheticLambda11
            @Override // androidx.media3.session.MediaControllerStub.ControllerTask
            public final void run(MediaControllerImplBase mediaControllerImplBase) {
                mediaControllerImplBase.onSetSessionActivity(i, pendingIntent);
            }
        });
    }

    @Override // androidx.media3.session.IMediaController
    public void onPeriodicSessionPositionInfoChanged(int i, Bundle bundle) {
        try {
            final SessionPositionInfo sessionPositionInfo = (SessionPositionInfo) SessionPositionInfo.CREATOR.fromBundle(bundle);
            dispatchControllerTaskOnHandler(new ControllerTask() { // from class: androidx.media3.session.MediaControllerStub$$ExternalSyntheticLambda12
                @Override // androidx.media3.session.MediaControllerStub.ControllerTask
                public final void run(MediaControllerImplBase mediaControllerImplBase) {
                    mediaControllerImplBase.notifyPeriodicSessionPositionInfoChanged(sessionPositionInfo);
                }
            });
        } catch (RuntimeException e) {
            Log.w(TAG, "Ignoring malformed Bundle for SessionPositionInfo", e);
        }
    }

    @Override // androidx.media3.session.IMediaController
    @Deprecated
    public void onPlayerInfoChanged(int i, Bundle bundle, boolean z) {
        onPlayerInfoChangedWithExclusions(i, bundle, new PlayerInfo.BundlingExclusions(z, true).toBundle());
    }

    @Override // androidx.media3.session.IMediaController
    public void onPlayerInfoChangedWithExclusions(int i, Bundle bundle, Bundle bundle2) {
        try {
            final PlayerInfo playerInfo = (PlayerInfo) PlayerInfo.CREATOR.fromBundle(bundle);
            try {
                final PlayerInfo.BundlingExclusions bundlingExclusions = (PlayerInfo.BundlingExclusions) PlayerInfo.BundlingExclusions.CREATOR.fromBundle(bundle2);
                dispatchControllerTaskOnHandler(new ControllerTask() { // from class: androidx.media3.session.MediaControllerStub$$ExternalSyntheticLambda0
                    @Override // androidx.media3.session.MediaControllerStub.ControllerTask
                    public final void run(MediaControllerImplBase mediaControllerImplBase) {
                        mediaControllerImplBase.onPlayerInfoChanged(playerInfo, bundlingExclusions);
                    }
                });
            } catch (RuntimeException e) {
                Log.w(TAG, "Ignoring malformed Bundle for BundlingExclusions", e);
            }
        } catch (RuntimeException e2) {
            Log.w(TAG, "Ignoring malformed Bundle for PlayerInfo", e2);
        }
    }

    @Override // androidx.media3.session.IMediaController
    public void onExtrasChanged(int i, final Bundle bundle) {
        dispatchControllerTaskOnHandler(new ControllerTask() { // from class: androidx.media3.session.MediaControllerStub$$ExternalSyntheticLambda10
            @Override // androidx.media3.session.MediaControllerStub.ControllerTask
            public final void run(MediaControllerImplBase mediaControllerImplBase) {
                mediaControllerImplBase.onExtrasChanged(bundle);
            }
        });
    }

    @Override // androidx.media3.session.IMediaController
    public void onRenderedFirstFrame(int i) {
        dispatchControllerTaskOnHandler(new ControllerTask() { // from class: androidx.media3.session.MediaControllerStub$$ExternalSyntheticLambda6
            @Override // androidx.media3.session.MediaControllerStub.ControllerTask
            public final void run(MediaControllerImplBase mediaControllerImplBase) {
                mediaControllerImplBase.onRenderedFirstFrame();
            }
        });
    }

    @Override // androidx.media3.session.IMediaController
    public void onSearchResultChanged(int i, final String str, final int i2, final Bundle bundle) throws RuntimeException {
        if (TextUtils.isEmpty(str)) {
            Log.w(TAG, "onSearchResultChanged(): Ignoring empty query");
        } else if (i2 < 0) {
            Log.w(TAG, "onSearchResultChanged(): Ignoring negative itemCount: " + i2);
        } else {
            dispatchControllerTaskOnHandler(new ControllerTask() { // from class: androidx.media3.session.MediaControllerStub$$ExternalSyntheticLambda3
                @Override // androidx.media3.session.MediaControllerStub.ControllerTask
                public final void run(MediaControllerImplBase mediaControllerImplBase) {
                    String str2 = str;
                    int i3 = i2;
                    Bundle bundle2 = bundle;
                    ((MediaBrowserImplBase) mediaControllerImplBase).notifySearchResultChanged(str2, i3, bundle2 == null ? null : (MediaLibraryService.LibraryParams) MediaLibraryService.LibraryParams.CREATOR.fromBundle(bundle2));
                }
            });
        }
    }

    @Override // androidx.media3.session.IMediaController
    public void onChildrenChanged(int i, final String str, final int i2, final Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            Log.w(TAG, "onChildrenChanged(): Ignoring empty parentId");
        } else if (i2 < 0) {
            Log.w(TAG, "onChildrenChanged(): Ignoring negative itemCount: " + i2);
        } else {
            dispatchControllerTaskOnHandler(new ControllerTask() { // from class: androidx.media3.session.MediaControllerStub$$ExternalSyntheticLambda9
                @Override // androidx.media3.session.MediaControllerStub.ControllerTask
                public final void run(MediaControllerImplBase mediaControllerImplBase) {
                    String str2 = str;
                    int i3 = i2;
                    Bundle bundle2 = bundle;
                    ((MediaBrowserImplBase) mediaControllerImplBase).notifyChildrenChanged(str2, i3, bundle2 == null ? null : (MediaLibraryService.LibraryParams) MediaLibraryService.LibraryParams.CREATOR.fromBundle(bundle2));
                }
            });
        }
    }

    public void destroy() {
        this.controller.clear();
    }

    private <T> void setControllerFutureResult(int i, T t) {
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            MediaControllerImplBase mediaControllerImplBase = this.controller.get();
            if (mediaControllerImplBase == null) {
                return;
            }
            mediaControllerImplBase.setFutureResult(i, t);
        } finally {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
        }
    }

    private <T extends MediaControllerImplBase> void dispatchControllerTaskOnHandler(final ControllerTask<T> controllerTask) {
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            final MediaControllerImplBase mediaControllerImplBase = this.controller.get();
            if (mediaControllerImplBase == null) {
                return;
            }
            Util.postOrRun(mediaControllerImplBase.getInstance().applicationHandler, new Runnable() { // from class: androidx.media3.session.MediaControllerStub$$ExternalSyntheticLambda13
                @Override // java.lang.Runnable
                public final void run() {
                    MediaControllerStub.lambda$dispatchControllerTaskOnHandler$12(mediaControllerImplBase, controllerTask);
                }
            });
        } finally {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
        }
    }

    static /* synthetic */ void lambda$dispatchControllerTaskOnHandler$12(MediaControllerImplBase mediaControllerImplBase, ControllerTask controllerTask) {
        if (mediaControllerImplBase.isReleased()) {
            return;
        }
        controllerTask.run(mediaControllerImplBase);
    }
}
