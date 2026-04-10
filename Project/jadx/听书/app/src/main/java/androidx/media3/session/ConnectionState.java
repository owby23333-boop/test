package androidx.media3.session;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.IBinder;
import androidx.core.app.BundleCompat;
import androidx.media3.common.Bundleable;
import androidx.media3.common.Player;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.BundleableUtil;
import androidx.media3.common.util.Util;
import androidx.media3.session.IMediaSession;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class ConnectionState implements Bundleable {
    public final ImmutableList<CommandButton> customLayout;
    public final int libraryVersion;
    public final Player.Commands playerCommandsFromPlayer;
    public final Player.Commands playerCommandsFromSession;
    public final PlayerInfo playerInfo;
    public final PendingIntent sessionActivity;
    public final IMediaSession sessionBinder;
    public final SessionCommands sessionCommands;
    public final int sessionInterfaceVersion;
    public final Bundle tokenExtras;
    private static final String FIELD_LIBRARY_VERSION = Util.intToStringMaxRadix(0);
    private static final String FIELD_SESSION_BINDER = Util.intToStringMaxRadix(1);
    private static final String FIELD_SESSION_ACTIVITY = Util.intToStringMaxRadix(2);
    private static final String FIELD_CUSTOM_LAYOUT = Util.intToStringMaxRadix(9);
    private static final String FIELD_SESSION_COMMANDS = Util.intToStringMaxRadix(3);
    private static final String FIELD_PLAYER_COMMANDS_FROM_SESSION = Util.intToStringMaxRadix(4);
    private static final String FIELD_PLAYER_COMMANDS_FROM_PLAYER = Util.intToStringMaxRadix(5);
    private static final String FIELD_TOKEN_EXTRAS = Util.intToStringMaxRadix(6);
    private static final String FIELD_PLAYER_INFO = Util.intToStringMaxRadix(7);
    private static final String FIELD_SESSION_INTERFACE_VERSION = Util.intToStringMaxRadix(8);
    public static final Bundleable.Creator<ConnectionState> CREATOR = new Bundleable.Creator() { // from class: androidx.media3.session.ConnectionState$$ExternalSyntheticLambda0
        @Override // androidx.media3.common.Bundleable.Creator
        public final Bundleable fromBundle(Bundle bundle) {
            return ConnectionState.fromBundle(bundle);
        }
    };

    public ConnectionState(int i, int i2, IMediaSession iMediaSession, PendingIntent pendingIntent, ImmutableList<CommandButton> immutableList, SessionCommands sessionCommands, Player.Commands commands, Player.Commands commands2, Bundle bundle, PlayerInfo playerInfo) {
        this.libraryVersion = i;
        this.sessionInterfaceVersion = i2;
        this.sessionBinder = iMediaSession;
        this.sessionCommands = sessionCommands;
        this.playerCommandsFromSession = commands;
        this.playerCommandsFromPlayer = commands2;
        this.sessionActivity = pendingIntent;
        this.tokenExtras = bundle;
        this.playerInfo = playerInfo;
        this.customLayout = immutableList;
    }

    @Override // androidx.media3.common.Bundleable
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(FIELD_LIBRARY_VERSION, this.libraryVersion);
        BundleCompat.putBinder(bundle, FIELD_SESSION_BINDER, this.sessionBinder.asBinder());
        bundle.putParcelable(FIELD_SESSION_ACTIVITY, this.sessionActivity);
        if (!this.customLayout.isEmpty()) {
            bundle.putParcelableArrayList(FIELD_CUSTOM_LAYOUT, BundleableUtil.toBundleArrayList(this.customLayout));
        }
        bundle.putBundle(FIELD_SESSION_COMMANDS, this.sessionCommands.toBundle());
        bundle.putBundle(FIELD_PLAYER_COMMANDS_FROM_SESSION, this.playerCommandsFromSession.toBundle());
        bundle.putBundle(FIELD_PLAYER_COMMANDS_FROM_PLAYER, this.playerCommandsFromPlayer.toBundle());
        bundle.putBundle(FIELD_TOKEN_EXTRAS, this.tokenExtras);
        bundle.putBundle(FIELD_PLAYER_INFO, this.playerInfo.toBundle(MediaUtils.intersect(this.playerCommandsFromSession, this.playerCommandsFromPlayer), false, false));
        bundle.putInt(FIELD_SESSION_INTERFACE_VERSION, this.sessionInterfaceVersion);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ConnectionState fromBundle(Bundle bundle) {
        ImmutableList immutableListOf;
        SessionCommands sessionCommands;
        Player.Commands commands;
        Player.Commands commands2;
        PlayerInfo playerInfo;
        int i = bundle.getInt(FIELD_LIBRARY_VERSION, 0);
        int i2 = bundle.getInt(FIELD_SESSION_INTERFACE_VERSION, 0);
        IBinder iBinder = (IBinder) Assertions.checkNotNull(BundleCompat.getBinder(bundle, FIELD_SESSION_BINDER));
        PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable(FIELD_SESSION_ACTIVITY);
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(FIELD_CUSTOM_LAYOUT);
        if (parcelableArrayList != null) {
            immutableListOf = BundleableUtil.fromBundleList(CommandButton.CREATOR, parcelableArrayList);
        } else {
            immutableListOf = ImmutableList.of();
        }
        ImmutableList immutableList = immutableListOf;
        Bundle bundle2 = bundle.getBundle(FIELD_SESSION_COMMANDS);
        if (bundle2 == null) {
            sessionCommands = SessionCommands.EMPTY;
        } else {
            sessionCommands = (SessionCommands) SessionCommands.CREATOR.fromBundle(bundle2);
        }
        SessionCommands sessionCommands2 = sessionCommands;
        Bundle bundle3 = bundle.getBundle(FIELD_PLAYER_COMMANDS_FROM_PLAYER);
        if (bundle3 == null) {
            commands = Player.Commands.EMPTY;
        } else {
            commands = (Player.Commands) Player.Commands.CREATOR.fromBundle(bundle3);
        }
        Player.Commands commands3 = commands;
        Bundle bundle4 = bundle.getBundle(FIELD_PLAYER_COMMANDS_FROM_SESSION);
        if (bundle4 == null) {
            commands2 = Player.Commands.EMPTY;
        } else {
            commands2 = (Player.Commands) Player.Commands.CREATOR.fromBundle(bundle4);
        }
        Player.Commands commands4 = commands2;
        Bundle bundle5 = bundle.getBundle(FIELD_TOKEN_EXTRAS);
        Bundle bundle6 = bundle.getBundle(FIELD_PLAYER_INFO);
        if (bundle6 == null) {
            playerInfo = PlayerInfo.DEFAULT;
        } else {
            playerInfo = (PlayerInfo) PlayerInfo.CREATOR.fromBundle(bundle6);
        }
        return new ConnectionState(i, i2, IMediaSession.Stub.asInterface(iBinder), pendingIntent, immutableList, sessionCommands2, commands4, commands3, bundle5 == null ? Bundle.EMPTY : bundle5, playerInfo);
    }
}
