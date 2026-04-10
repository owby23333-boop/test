package androidx.media3.session;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import androidx.media3.common.Bundleable;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Player;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.session.MediaLibraryService;
import androidx.media3.session.MediaSession;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class MediaLibraryService extends MediaSessionService {
    public static final String SERVICE_INTERFACE = "androidx.media3.session.MediaLibraryService";

    @Override // androidx.media3.session.MediaSessionService
    public abstract MediaLibrarySession onGetSession(MediaSession.ControllerInfo controllerInfo);

    public static final class MediaLibrarySession extends MediaSession {
        @Override // androidx.media3.session.MediaSession
        /* bridge */ /* synthetic */ MediaSessionImpl createImpl(Context context, String str, Player player, PendingIntent pendingIntent, ImmutableList immutableList, MediaSession.Callback callback, Bundle bundle, androidx.media3.common.util.BitmapLoader bitmapLoader) {
            return createImpl(context, str, player, pendingIntent, (ImmutableList<CommandButton>) immutableList, callback, bundle, bitmapLoader);
        }

        public interface Callback extends MediaSession.Callback {
            default ListenableFuture<LibraryResult<MediaItem>> onGetLibraryRoot(MediaLibrarySession mediaLibrarySession, MediaSession.ControllerInfo controllerInfo, LibraryParams libraryParams) {
                return Futures.immediateFuture(LibraryResult.ofError(-6));
            }

            default ListenableFuture<LibraryResult<MediaItem>> onGetItem(MediaLibrarySession mediaLibrarySession, MediaSession.ControllerInfo controllerInfo, String str) {
                return Futures.immediateFuture(LibraryResult.ofError(-6));
            }

            default ListenableFuture<LibraryResult<ImmutableList<MediaItem>>> onGetChildren(MediaLibrarySession mediaLibrarySession, MediaSession.ControllerInfo controllerInfo, String str, int i, int i2, LibraryParams libraryParams) {
                return Futures.immediateFuture(LibraryResult.ofError(-6));
            }

            default ListenableFuture<LibraryResult<Void>> onSubscribe(MediaLibrarySession mediaLibrarySession, MediaSession.ControllerInfo controllerInfo, String str, LibraryParams libraryParams) {
                return Futures.immediateFuture(LibraryResult.ofError(-6));
            }

            default ListenableFuture<LibraryResult<Void>> onUnsubscribe(MediaLibrarySession mediaLibrarySession, MediaSession.ControllerInfo controllerInfo, String str) {
                return Futures.immediateFuture(LibraryResult.ofError(-6));
            }

            default ListenableFuture<LibraryResult<Void>> onSearch(MediaLibrarySession mediaLibrarySession, MediaSession.ControllerInfo controllerInfo, String str, LibraryParams libraryParams) {
                return Futures.immediateFuture(LibraryResult.ofError(-6));
            }

            default ListenableFuture<LibraryResult<ImmutableList<MediaItem>>> onGetSearchResult(MediaLibrarySession mediaLibrarySession, MediaSession.ControllerInfo controllerInfo, String str, int i, int i2, LibraryParams libraryParams) {
                return Futures.immediateFuture(LibraryResult.ofError(-6));
            }
        }

        public static final class Builder extends MediaSession.BuilderBase<MediaLibrarySession, Builder, Callback> {
            @Override // androidx.media3.session.MediaSession.BuilderBase
            public /* bridge */ /* synthetic */ MediaSession.BuilderBase setCustomLayout(List list) {
                return setCustomLayout((List<CommandButton>) list);
            }

            public Builder(MediaLibraryService mediaLibraryService, Player player, Callback callback) {
                super(mediaLibraryService, player, callback);
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
            public MediaLibrarySession build() {
                if (this.bitmapLoader == null) {
                    this.bitmapLoader = new CacheBitmapLoader(new SimpleBitmapLoader());
                }
                return new MediaLibrarySession(this.context, this.id, this.player, this.sessionActivity, this.customLayout, this.callback, this.extras, (androidx.media3.common.util.BitmapLoader) Assertions.checkNotNull(this.bitmapLoader));
            }
        }

        MediaLibrarySession(Context context, String str, Player player, PendingIntent pendingIntent, ImmutableList<CommandButton> immutableList, MediaSession.Callback callback, Bundle bundle, androidx.media3.common.util.BitmapLoader bitmapLoader) {
            super(context, str, player, pendingIntent, immutableList, callback, bundle, bitmapLoader);
        }

        @Override // androidx.media3.session.MediaSession
        MediaLibrarySessionImpl createImpl(Context context, String str, Player player, PendingIntent pendingIntent, ImmutableList<CommandButton> immutableList, MediaSession.Callback callback, Bundle bundle, androidx.media3.common.util.BitmapLoader bitmapLoader) {
            return new MediaLibrarySessionImpl(this, context, str, player, pendingIntent, immutableList, (Callback) callback, bundle, bitmapLoader);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.media3.session.MediaSession
        public MediaLibrarySessionImpl getImpl() {
            return (MediaLibrarySessionImpl) super.getImpl();
        }

        public void notifyChildrenChanged(MediaSession.ControllerInfo controllerInfo, String str, int i, LibraryParams libraryParams) {
            Assertions.checkArgument(i >= 0);
            getImpl().notifyChildrenChanged((MediaSession.ControllerInfo) Assertions.checkNotNull(controllerInfo), Assertions.checkNotEmpty(str), i, libraryParams);
        }

        public void notifyChildrenChanged(String str, int i, LibraryParams libraryParams) {
            Assertions.checkArgument(i >= 0);
            getImpl().notifyChildrenChanged(Assertions.checkNotEmpty(str), i, libraryParams);
        }

        public void notifySearchResultChanged(MediaSession.ControllerInfo controllerInfo, String str, int i, LibraryParams libraryParams) {
            Assertions.checkArgument(i >= 0);
            getImpl().notifySearchResultChanged((MediaSession.ControllerInfo) Assertions.checkNotNull(controllerInfo), Assertions.checkNotEmpty(str), i, libraryParams);
        }
    }

    public static final class LibraryParams implements Bundleable {
        public final Bundle extras;
        public final boolean isOffline;
        public final boolean isRecent;
        public final boolean isSuggested;
        private static final String FIELD_EXTRAS = Util.intToStringMaxRadix(0);
        private static final String FIELD_RECENT = Util.intToStringMaxRadix(1);
        private static final String FIELD_OFFLINE = Util.intToStringMaxRadix(2);
        private static final String FIELD_SUGGESTED = Util.intToStringMaxRadix(3);
        public static final Bundleable.Creator<LibraryParams> CREATOR = new Bundleable.Creator() { // from class: androidx.media3.session.MediaLibraryService$LibraryParams$$ExternalSyntheticLambda0
            @Override // androidx.media3.common.Bundleable.Creator
            public final Bundleable fromBundle(Bundle bundle) {
                return MediaLibraryService.LibraryParams.fromBundle(bundle);
            }
        };

        private LibraryParams(Bundle bundle, boolean z, boolean z2, boolean z3) {
            this.extras = new Bundle(bundle);
            this.isRecent = z;
            this.isOffline = z2;
            this.isSuggested = z3;
        }

        public static final class Builder {
            private Bundle extras = Bundle.EMPTY;
            private boolean offline;
            private boolean recent;
            private boolean suggested;

            public Builder setRecent(boolean z) {
                this.recent = z;
                return this;
            }

            public Builder setOffline(boolean z) {
                this.offline = z;
                return this;
            }

            public Builder setSuggested(boolean z) {
                this.suggested = z;
                return this;
            }

            public Builder setExtras(Bundle bundle) {
                this.extras = (Bundle) Assertions.checkNotNull(bundle);
                return this;
            }

            public LibraryParams build() {
                return new LibraryParams(this.extras, this.recent, this.offline, this.suggested);
            }
        }

        @Override // androidx.media3.common.Bundleable
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putBundle(FIELD_EXTRAS, this.extras);
            bundle.putBoolean(FIELD_RECENT, this.isRecent);
            bundle.putBoolean(FIELD_OFFLINE, this.isOffline);
            bundle.putBoolean(FIELD_SUGGESTED, this.isSuggested);
            return bundle;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static LibraryParams fromBundle(Bundle bundle) {
            Bundle bundle2 = bundle.getBundle(FIELD_EXTRAS);
            boolean z = bundle.getBoolean(FIELD_RECENT, false);
            boolean z2 = bundle.getBoolean(FIELD_OFFLINE, false);
            boolean z3 = bundle.getBoolean(FIELD_SUGGESTED, false);
            if (bundle2 == null) {
                bundle2 = Bundle.EMPTY;
            }
            return new LibraryParams(bundle2, z, z2, z3);
        }
    }

    @Override // androidx.media3.session.MediaSessionService, android.app.Service
    public IBinder onBind(Intent intent) {
        if (intent == null) {
            return null;
        }
        if (SERVICE_INTERFACE.equals(intent.getAction())) {
            return getServiceBinder();
        }
        return super.onBind(intent);
    }
}
