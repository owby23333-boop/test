package androidx.media3.session;

import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.media.MediaSessionManager;
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
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.session.MediaLibraryService;
import androidx.media3.session.MediaSession;
import androidx.media3.session.SessionCommands;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Longs;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.errorprone.annotations.DoNotMock;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@DoNotMock
public class MediaSession {
    private static final HashMap<String, MediaSession> SESSION_ID_TO_SESSION_MAP;
    private static final Object STATIC_LOCK;
    private final MediaSessionImpl impl;

    interface ControllerCb {
        default void onAudioAttributesChanged(int i, AudioAttributes audioAttributes) throws RemoteException {
        }

        default void onAvailableCommandsChangedFromPlayer(int i, Player.Commands commands) throws RemoteException {
        }

        default void onAvailableCommandsChangedFromSession(int i, SessionCommands sessionCommands, Player.Commands commands) throws RemoteException {
        }

        default void onChildrenChanged(int i, String str, int i2, MediaLibraryService.LibraryParams libraryParams) throws RemoteException {
        }

        default void onDeviceInfoChanged(int i, DeviceInfo deviceInfo) throws RemoteException {
        }

        default void onDeviceVolumeChanged(int i, int i2, boolean z) throws RemoteException {
        }

        default void onDisconnected(int i) throws RemoteException {
        }

        default void onIsLoadingChanged(int i, boolean z) throws RemoteException {
        }

        default void onIsPlayingChanged(int i, boolean z) throws RemoteException {
        }

        default void onLibraryResult(int i, LibraryResult<?> libraryResult) throws RemoteException {
        }

        default void onMediaItemTransition(int i, MediaItem mediaItem, int i2) throws RemoteException {
        }

        default void onMediaMetadataChanged(int i, MediaMetadata mediaMetadata) throws RemoteException {
        }

        default void onPeriodicSessionPositionInfoChanged(int i, SessionPositionInfo sessionPositionInfo, boolean z, boolean z2) throws RemoteException {
        }

        default void onPlayWhenReadyChanged(int i, boolean z, int i2) throws RemoteException {
        }

        default void onPlaybackParametersChanged(int i, PlaybackParameters playbackParameters) throws RemoteException {
        }

        default void onPlaybackStateChanged(int i, int i2, PlaybackException playbackException) throws RemoteException {
        }

        default void onPlaybackSuppressionReasonChanged(int i, int i2) throws RemoteException {
        }

        default void onPlayerChanged(int i, PlayerWrapper playerWrapper, PlayerWrapper playerWrapper2) throws RemoteException {
        }

        default void onPlayerError(int i, PlaybackException playbackException) throws RemoteException {
        }

        default void onPlayerInfoChanged(int i, PlayerInfo playerInfo, Player.Commands commands, boolean z, boolean z2, int i2) throws RemoteException {
        }

        default void onPlaylistMetadataChanged(int i, MediaMetadata mediaMetadata) throws RemoteException {
        }

        default void onPositionDiscontinuity(int i, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i2) throws RemoteException {
        }

        default void onRenderedFirstFrame(int i) throws RemoteException {
        }

        default void onRepeatModeChanged(int i, int i2) throws RemoteException {
        }

        default void onSearchResultChanged(int i, String str, int i2, MediaLibraryService.LibraryParams libraryParams) throws RemoteException {
        }

        default void onSeekBackIncrementChanged(int i, long j) throws RemoteException {
        }

        default void onSeekForwardIncrementChanged(int i, long j) throws RemoteException {
        }

        default void onSessionActivityChanged(int i, PendingIntent pendingIntent) throws RemoteException {
        }

        default void onSessionExtrasChanged(int i, Bundle bundle) throws RemoteException {
        }

        default void onSessionResult(int i, SessionResult sessionResult) throws RemoteException {
        }

        default void onShuffleModeEnabledChanged(int i, boolean z) throws RemoteException {
        }

        default void onTimelineChanged(int i, Timeline timeline, int i2) throws RemoteException {
        }

        default void onTrackSelectionParametersChanged(int i, TrackSelectionParameters trackSelectionParameters) throws RemoteException {
        }

        default void onTracksChanged(int i, Tracks tracks) throws RemoteException {
        }

        default void onVideoSizeChanged(int i, VideoSize videoSize) throws RemoteException {
        }

        default void onVolumeChanged(int i, float f) throws RemoteException {
        }

        default void sendCustomCommand(int i, SessionCommand sessionCommand, Bundle bundle) throws RemoteException {
        }

        default void setCustomLayout(int i, List<CommandButton> list) throws RemoteException {
        }
    }

    interface Listener {
        void onNotificationRefreshRequired(MediaSession mediaSession);

        boolean onPlayRequested(MediaSession mediaSession);
    }

    static {
        MediaLibraryInfo.registerModule("media3.session");
        STATIC_LOCK = new Object();
        SESSION_ID_TO_SESSION_MAP = new HashMap<>();
    }

    public static final class Builder extends BuilderBase<MediaSession, Builder, Callback> {
        @Override // androidx.media3.session.MediaSession.BuilderBase
        public /* bridge */ /* synthetic */ BuilderBase setCustomLayout(List list) {
            return setCustomLayout((List<CommandButton>) list);
        }

        public Builder(Context context, Player player) {
            super(context, player, new Callback() { // from class: androidx.media3.session.MediaSession.Builder.1
            });
        }

        @Override // androidx.media3.session.MediaSession.BuilderBase
        public Builder setSessionActivity(PendingIntent pendingIntent) {
            return (Builder) super.setSessionActivity(pendingIntent);
        }

        @Override // androidx.media3.session.MediaSession.BuilderBase
        public Builder setId(String str) {
            return (Builder) super.setId(str);
        }

        @Override // androidx.media3.session.MediaSession.BuilderBase
        public Builder setCallback(Callback callback) {
            return (Builder) super.setCallback(callback);
        }

        @Override // androidx.media3.session.MediaSession.BuilderBase
        public Builder setExtras(Bundle bundle) {
            return (Builder) super.setExtras(bundle);
        }

        @Override // androidx.media3.session.MediaSession.BuilderBase
        public Builder setBitmapLoader(androidx.media3.common.util.BitmapLoader bitmapLoader) {
            return (Builder) super.setBitmapLoader(bitmapLoader);
        }

        @Override // androidx.media3.session.MediaSession.BuilderBase
        public Builder setCustomLayout(List<CommandButton> list) {
            return (Builder) super.setCustomLayout(list);
        }

        @Override // androidx.media3.session.MediaSession.BuilderBase
        public MediaSession build() {
            if (this.bitmapLoader == null) {
                this.bitmapLoader = new CacheBitmapLoader(new SimpleBitmapLoader());
            }
            return new MediaSession(this.context, this.id, this.player, this.sessionActivity, this.customLayout, this.callback, this.extras, (androidx.media3.common.util.BitmapLoader) Assertions.checkNotNull(this.bitmapLoader));
        }
    }

    public static final class ControllerInfo {
        public static final int LEGACY_CONTROLLER_INTERFACE_VERSION = 0;
        public static final int LEGACY_CONTROLLER_VERSION = 0;
        private final Bundle connectionHints;
        private final ControllerCb controllerCb;
        private final int interfaceVersion;
        private final boolean isTrusted;
        private final int libraryVersion;
        private final MediaSessionManager.RemoteUserInfo remoteUserInfo;

        ControllerInfo(MediaSessionManager.RemoteUserInfo remoteUserInfo, int i, int i2, boolean z, ControllerCb controllerCb, Bundle bundle) {
            this.remoteUserInfo = remoteUserInfo;
            this.libraryVersion = i;
            this.interfaceVersion = i2;
            this.isTrusted = z;
            this.controllerCb = controllerCb;
            this.connectionHints = bundle;
        }

        MediaSessionManager.RemoteUserInfo getRemoteUserInfo() {
            return this.remoteUserInfo;
        }

        public int getControllerVersion() {
            return this.libraryVersion;
        }

        public int getInterfaceVersion() {
            return this.interfaceVersion;
        }

        public String getPackageName() {
            return this.remoteUserInfo.getPackageName();
        }

        public int getUid() {
            return this.remoteUserInfo.getUid();
        }

        public Bundle getConnectionHints() {
            return new Bundle(this.connectionHints);
        }

        boolean isTrusted() {
            return this.isTrusted;
        }

        public int hashCode() {
            return Objects.hashCode(this.controllerCb, this.remoteUserInfo);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ControllerInfo)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            ControllerInfo controllerInfo = (ControllerInfo) obj;
            ControllerCb controllerCb = this.controllerCb;
            if (controllerCb != null || controllerInfo.controllerCb != null) {
                return Util.areEqual(controllerCb, controllerInfo.controllerCb);
            }
            return this.remoteUserInfo.equals(controllerInfo.remoteUserInfo);
        }

        public String toString() {
            return "ControllerInfo {pkg=" + this.remoteUserInfo.getPackageName() + ", uid=" + this.remoteUserInfo.getUid() + "})";
        }

        ControllerCb getControllerCb() {
            return this.controllerCb;
        }

        static ControllerInfo createLegacyControllerInfo() {
            return new ControllerInfo(new MediaSessionManager.RemoteUserInfo(MediaSessionManager.RemoteUserInfo.LEGACY_CONTROLLER, -1, -1), 0, 0, false, null, Bundle.EMPTY);
        }

        public static ControllerInfo createTestOnlyControllerInfo(MediaSessionManager.RemoteUserInfo remoteUserInfo, int i, int i2, boolean z, Bundle bundle) {
            return new ControllerInfo(remoteUserInfo, i, i2, z, null, bundle);
        }
    }

    MediaSession(Context context, String str, Player player, PendingIntent pendingIntent, ImmutableList<CommandButton> immutableList, Callback callback, Bundle bundle, androidx.media3.common.util.BitmapLoader bitmapLoader) {
        synchronized (STATIC_LOCK) {
            HashMap<String, MediaSession> map = SESSION_ID_TO_SESSION_MAP;
            if (map.containsKey(str)) {
                throw new IllegalStateException("Session ID must be unique. ID=" + str);
            }
            map.put(str, this);
        }
        this.impl = createImpl(context, str, player, pendingIntent, immutableList, callback, bundle, bitmapLoader);
    }

    MediaSessionImpl createImpl(Context context, String str, Player player, PendingIntent pendingIntent, ImmutableList<CommandButton> immutableList, Callback callback, Bundle bundle, androidx.media3.common.util.BitmapLoader bitmapLoader) {
        return new MediaSessionImpl(this, context, str, player, pendingIntent, immutableList, callback, bundle, bitmapLoader);
    }

    MediaSessionImpl getImpl() {
        return this.impl;
    }

    static MediaSession getSession(Uri uri) {
        synchronized (STATIC_LOCK) {
            for (MediaSession mediaSession : SESSION_ID_TO_SESSION_MAP.values()) {
                if (Util.areEqual(mediaSession.getUri(), uri)) {
                    return mediaSession;
                }
            }
            return null;
        }
    }

    public final PendingIntent getSessionActivity() {
        return this.impl.getSessionActivity();
    }

    public final void setSessionActivity(PendingIntent pendingIntent) {
        this.impl.setSessionActivity(pendingIntent);
    }

    public final void setPlayer(Player player) {
        Assertions.checkNotNull(player);
        Assertions.checkArgument(player.canAdvertiseSession());
        Assertions.checkArgument(player.getApplicationLooper() == getPlayer().getApplicationLooper());
        Assertions.checkState(player.getApplicationLooper() == Looper.myLooper());
        this.impl.setPlayer(player);
    }

    public final void release() {
        try {
            synchronized (STATIC_LOCK) {
                SESSION_ID_TO_SESSION_MAP.remove(this.impl.getId());
            }
            this.impl.release();
        } catch (Exception unused) {
        }
    }

    final boolean isReleased() {
        return this.impl.isReleased();
    }

    public final Player getPlayer() {
        return this.impl.getPlayerWrapper().getWrappedPlayer();
    }

    public final String getId() {
        return this.impl.getId();
    }

    public final SessionToken getToken() {
        return this.impl.getToken();
    }

    public final List<ControllerInfo> getConnectedControllers() {
        return this.impl.getConnectedControllers();
    }

    public final ControllerInfo getControllerForCurrentRequest() {
        return this.impl.getControllerForCurrentRequest();
    }

    public final ListenableFuture<SessionResult> setCustomLayout(ControllerInfo controllerInfo, List<CommandButton> list) {
        Assertions.checkNotNull(controllerInfo, "controller must not be null");
        Assertions.checkNotNull(list, "layout must not be null");
        return this.impl.setCustomLayout(controllerInfo, list);
    }

    public final void setCustomLayout(List<CommandButton> list) {
        Assertions.checkNotNull(list, "layout must not be null");
        this.impl.setCustomLayout(list);
    }

    public final void setAvailableCommands(ControllerInfo controllerInfo, SessionCommands sessionCommands, Player.Commands commands) {
        Assertions.checkNotNull(controllerInfo, "controller must not be null");
        Assertions.checkNotNull(sessionCommands, "sessionCommands must not be null");
        Assertions.checkNotNull(commands, "playerCommands must not be null");
        this.impl.setAvailableCommands(controllerInfo, sessionCommands, commands);
    }

    public ImmutableList<CommandButton> getCustomLayout() {
        return this.impl.getCustomLayout();
    }

    public final void broadcastCustomCommand(SessionCommand sessionCommand, Bundle bundle) {
        Assertions.checkNotNull(sessionCommand);
        Assertions.checkNotNull(bundle);
        Assertions.checkArgument(sessionCommand.commandCode == 0, "command must be a custom command");
        this.impl.broadcastCustomCommand(sessionCommand, bundle);
    }

    public final void setSessionExtras(Bundle bundle) {
        Assertions.checkNotNull(bundle);
        this.impl.setSessionExtras(bundle);
    }

    public final void setSessionExtras(ControllerInfo controllerInfo, Bundle bundle) {
        Assertions.checkNotNull(controllerInfo, "controller must not be null");
        Assertions.checkNotNull(bundle);
        this.impl.setSessionExtras(controllerInfo, bundle);
    }

    public final androidx.media3.common.util.BitmapLoader getBitmapLoader() {
        return this.impl.getBitmapLoader();
    }

    public final ListenableFuture<SessionResult> sendCustomCommand(ControllerInfo controllerInfo, SessionCommand sessionCommand, Bundle bundle) {
        Assertions.checkNotNull(controllerInfo);
        Assertions.checkNotNull(sessionCommand);
        Assertions.checkNotNull(bundle);
        Assertions.checkArgument(sessionCommand.commandCode == 0, "command must be a custom command");
        return this.impl.sendCustomCommand(controllerInfo, sessionCommand, bundle);
    }

    final MediaSessionCompat getSessionCompat() {
        return this.impl.getSessionCompat();
    }

    public final MediaSessionCompat.Token getSessionCompatToken() {
        return this.impl.getSessionCompat().getSessionToken();
    }

    final void setLegacyControllerConnectionTimeoutMs(long j) {
        this.impl.setLegacyControllerConnectionTimeoutMs(j);
    }

    final void handleControllerConnectionFromService(IMediaController iMediaController, int i, int i2, String str, int i3, int i4, Bundle bundle) {
        this.impl.connectFromService(iMediaController, i, i2, str, i3, i4, bundle);
    }

    final IBinder getLegacyBrowserServiceBinder() {
        return this.impl.getLegacyBrowserServiceBinder();
    }

    final void setSessionPositionUpdateDelayMs(long j) {
        this.impl.setSessionPositionUpdateDelayMsOnHandler(j);
    }

    final void setListener(Listener listener) {
        this.impl.setMediaSessionListener(listener);
    }

    final void clearListener() {
        this.impl.clearMediaSessionListener();
    }

    final Uri getUri() {
        return this.impl.getUri();
    }

    public interface Callback {
        default void onDisconnected(MediaSession mediaSession, ControllerInfo controllerInfo) {
        }

        @Deprecated
        default int onPlayerCommandRequest(MediaSession mediaSession, ControllerInfo controllerInfo, int i) {
            return 0;
        }

        default void onPostConnect(MediaSession mediaSession, ControllerInfo controllerInfo) {
        }

        default ConnectionResult onConnect(MediaSession mediaSession, ControllerInfo controllerInfo) {
            return new ConnectionResult.AcceptedResultBuilder(mediaSession).build();
        }

        default ListenableFuture<SessionResult> onSetRating(MediaSession mediaSession, ControllerInfo controllerInfo, String str, Rating rating) {
            return Futures.immediateFuture(new SessionResult(-6));
        }

        default ListenableFuture<SessionResult> onSetRating(MediaSession mediaSession, ControllerInfo controllerInfo, Rating rating) {
            return Futures.immediateFuture(new SessionResult(-6));
        }

        default ListenableFuture<SessionResult> onCustomCommand(MediaSession mediaSession, ControllerInfo controllerInfo, SessionCommand sessionCommand, Bundle bundle) {
            return Futures.immediateFuture(new SessionResult(-6));
        }

        default ListenableFuture<List<MediaItem>> onAddMediaItems(MediaSession mediaSession, ControllerInfo controllerInfo, List<MediaItem> list) {
            Iterator<MediaItem> it = list.iterator();
            while (it.hasNext()) {
                if (it.next().localConfiguration == null) {
                    return Futures.immediateFailedFuture(new UnsupportedOperationException());
                }
            }
            return Futures.immediateFuture(list);
        }

        default ListenableFuture<MediaItemsWithStartPosition> onSetMediaItems(MediaSession mediaSession, ControllerInfo controllerInfo, List<MediaItem> list, final int i, final long j) {
            return Util.transformFutureAsync(onAddMediaItems(mediaSession, controllerInfo, list), new AsyncFunction() { // from class: androidx.media3.session.MediaSession$Callback$$ExternalSyntheticLambda0
                @Override // com.google.common.util.concurrent.AsyncFunction
                public final ListenableFuture apply(Object obj) {
                    return Futures.immediateFuture(new MediaSession.MediaItemsWithStartPosition((List) obj, i, j));
                }
            });
        }

        default ListenableFuture<MediaItemsWithStartPosition> onPlaybackResumption(MediaSession mediaSession, ControllerInfo controllerInfo) {
            return Futures.immediateFailedFuture(new UnsupportedOperationException());
        }
    }

    public static final class MediaItemsWithStartPosition {
        public final ImmutableList<MediaItem> mediaItems;
        public final int startIndex;
        public final long startPositionMs;

        public MediaItemsWithStartPosition(List<MediaItem> list, int i, long j) {
            this.mediaItems = ImmutableList.copyOf((Collection) list);
            this.startIndex = i;
            this.startPositionMs = j;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MediaItemsWithStartPosition)) {
                return false;
            }
            MediaItemsWithStartPosition mediaItemsWithStartPosition = (MediaItemsWithStartPosition) obj;
            return this.mediaItems.equals(mediaItemsWithStartPosition.mediaItems) && Util.areEqual(Integer.valueOf(this.startIndex), Integer.valueOf(mediaItemsWithStartPosition.startIndex)) && Util.areEqual(Long.valueOf(this.startPositionMs), Long.valueOf(mediaItemsWithStartPosition.startPositionMs));
        }

        public int hashCode() {
            return (((this.mediaItems.hashCode() * 31) + this.startIndex) * 31) + Longs.hashCode(this.startPositionMs);
        }
    }

    public static final class ConnectionResult {
        public final Player.Commands availablePlayerCommands;
        public final SessionCommands availableSessionCommands;
        public final ImmutableList<CommandButton> customLayout;
        public final boolean isAccepted;
        public static final SessionCommands DEFAULT_SESSION_COMMANDS = new SessionCommands.Builder().addAllSessionCommands().build();
        public static final SessionCommands DEFAULT_SESSION_AND_LIBRARY_COMMANDS = new SessionCommands.Builder().addAllLibraryCommands().addAllSessionCommands().build();
        public static final Player.Commands DEFAULT_PLAYER_COMMANDS = new Player.Commands.Builder().addAllCommands().build();

        public static class AcceptedResultBuilder {
            private Player.Commands availablePlayerCommands = ConnectionResult.DEFAULT_PLAYER_COMMANDS;
            private SessionCommands availableSessionCommands;
            private ImmutableList<CommandButton> customLayout;

            public AcceptedResultBuilder(MediaSession mediaSession) {
                SessionCommands sessionCommands;
                if (mediaSession instanceof MediaLibraryService.MediaLibrarySession) {
                    sessionCommands = ConnectionResult.DEFAULT_SESSION_AND_LIBRARY_COMMANDS;
                } else {
                    sessionCommands = ConnectionResult.DEFAULT_SESSION_COMMANDS;
                }
                this.availableSessionCommands = sessionCommands;
            }

            public AcceptedResultBuilder setAvailableSessionCommands(SessionCommands sessionCommands) {
                this.availableSessionCommands = (SessionCommands) Assertions.checkNotNull(sessionCommands);
                return this;
            }

            public AcceptedResultBuilder setAvailablePlayerCommands(Player.Commands commands) {
                this.availablePlayerCommands = (Player.Commands) Assertions.checkNotNull(commands);
                return this;
            }

            public AcceptedResultBuilder setCustomLayout(ImmutableList<CommandButton> immutableList) {
                this.customLayout = immutableList;
                return this;
            }

            public ConnectionResult build() {
                return new ConnectionResult(true, this.availableSessionCommands, this.availablePlayerCommands, this.customLayout);
            }
        }

        private ConnectionResult(boolean z, SessionCommands sessionCommands, Player.Commands commands, ImmutableList<CommandButton> immutableList) {
            this.isAccepted = z;
            this.availableSessionCommands = sessionCommands;
            this.availablePlayerCommands = commands;
            this.customLayout = immutableList;
        }

        public static ConnectionResult accept(SessionCommands sessionCommands, Player.Commands commands) {
            return new ConnectionResult(true, sessionCommands, commands, null);
        }

        public static ConnectionResult reject() {
            return new ConnectionResult(false, SessionCommands.EMPTY, Player.Commands.EMPTY, ImmutableList.of());
        }
    }

    static abstract class BuilderBase<SessionT extends MediaSession, BuilderT extends BuilderBase<SessionT, BuilderT, CallbackT>, CallbackT extends Callback> {
        androidx.media3.common.util.BitmapLoader bitmapLoader;
        CallbackT callback;
        final Context context;
        ImmutableList<CommandButton> customLayout;
        Bundle extras;
        String id;
        final Player player;
        PendingIntent sessionActivity;

        public abstract SessionT build();

        public BuilderBase(Context context, Player player, CallbackT callbackt) {
            this.context = (Context) Assertions.checkNotNull(context);
            this.player = (Player) Assertions.checkNotNull(player);
            Assertions.checkArgument(player.canAdvertiseSession());
            this.id = "";
            this.callback = callbackt;
            this.extras = Bundle.EMPTY;
            this.customLayout = ImmutableList.of();
        }

        public BuilderT setSessionActivity(PendingIntent pendingIntent) {
            this.sessionActivity = (PendingIntent) Assertions.checkNotNull(pendingIntent);
            return this;
        }

        public BuilderT setId(String str) {
            this.id = (String) Assertions.checkNotNull(str);
            return this;
        }

        BuilderT setCallback(CallbackT callbackt) {
            this.callback = (CallbackT) Assertions.checkNotNull(callbackt);
            return this;
        }

        public BuilderT setExtras(Bundle bundle) {
            this.extras = new Bundle((Bundle) Assertions.checkNotNull(bundle));
            return this;
        }

        public BuilderT setBitmapLoader(androidx.media3.common.util.BitmapLoader bitmapLoader) {
            this.bitmapLoader = (androidx.media3.common.util.BitmapLoader) Assertions.checkNotNull(bitmapLoader);
            return this;
        }

        public BuilderT setCustomLayout(List<CommandButton> list) {
            this.customLayout = ImmutableList.copyOf((Collection) list);
            return this;
        }
    }
}
