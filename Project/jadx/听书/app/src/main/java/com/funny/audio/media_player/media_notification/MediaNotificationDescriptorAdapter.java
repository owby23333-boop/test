package com.funny.audio.media_player.media_notification;

import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.media3.common.Player;
import androidx.media3.ui.PlayerNotificationManager;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.umeng.analytics.pro.d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MediaNotificationDescriptorAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH\u0016J:\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u000b0\u000f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000b0\u000fH\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\tH\u0016J\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00102\u0006\u0010\b\u001a\u00020\t2\n\u0010\u0017\u001a\u00060\u0018R\u00020\u0019H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/funny/audio/media_player/media_notification/MediaNotificationDescriptorAdapter;", "Landroidx/media3/ui/PlayerNotificationManager$MediaDescriptionAdapter;", d.R, "Landroid/content/Context;", "pendingIntent", "Landroid/app/PendingIntent;", "(Landroid/content/Context;Landroid/app/PendingIntent;)V", "createCurrentContentIntent", "player", "Landroidx/media3/common/Player;", "getBitmap", "", "url", "Landroid/net/Uri;", "onSuccess", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "onError", "", "getCurrentContentText", "", "getCurrentContentTitle", "getCurrentLargeIcon", "callback", "Landroidx/media3/ui/PlayerNotificationManager$BitmapCallback;", "Landroidx/media3/ui/PlayerNotificationManager;", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MediaNotificationDescriptorAdapter implements PlayerNotificationManager.MediaDescriptionAdapter {
    private final Context context;
    private final PendingIntent pendingIntent;

    public MediaNotificationDescriptorAdapter(Context context, PendingIntent pendingIntent) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.pendingIntent = pendingIntent;
    }

    @Override // androidx.media3.ui.PlayerNotificationManager.MediaDescriptionAdapter
    public CharSequence getCurrentContentTitle(Player player) {
        Intrinsics.checkNotNullParameter(player, "player");
        CharSequence charSequence = player.getMediaMetadata().albumTitle;
        return charSequence == null ? "未知" : charSequence;
    }

    @Override // androidx.media3.ui.PlayerNotificationManager.MediaDescriptionAdapter
    public PendingIntent createCurrentContentIntent(Player player) {
        Intrinsics.checkNotNullParameter(player, "player");
        return this.pendingIntent;
    }

    @Override // androidx.media3.ui.PlayerNotificationManager.MediaDescriptionAdapter
    public CharSequence getCurrentContentText(Player player) {
        Intrinsics.checkNotNullParameter(player, "player");
        CharSequence charSequence = player.getMediaMetadata().displayTitle;
        return charSequence == null ? "未知" : charSequence;
    }

    @Override // androidx.media3.ui.PlayerNotificationManager.MediaDescriptionAdapter
    public Bitmap getCurrentLargeIcon(Player player, final PlayerNotificationManager.BitmapCallback callback) {
        Intrinsics.checkNotNullParameter(player, "player");
        Intrinsics.checkNotNullParameter(callback, "callback");
        getBitmap(player.getMediaMetadata().artworkUri, new Function1<Bitmap, Unit>() { // from class: com.funny.audio.media_player.media_notification.MediaNotificationDescriptorAdapter.getCurrentLargeIcon.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap) {
                invoke2(bitmap);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Bitmap it) {
                Intrinsics.checkNotNullParameter(it, "it");
                callback.onBitmap(it);
            }
        }, new Function1<String, Unit>() { // from class: com.funny.audio.media_player.media_notification.MediaNotificationDescriptorAdapter.getCurrentLargeIcon.2
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }
        });
        return null;
    }

    private final void getBitmap(Uri url, final Function1<? super Bitmap, Unit> onSuccess, final Function1<? super String, Unit> onError) {
        if (url == null) {
            onError.invoke("URL null");
        } else {
            Glide.with(this.context).asBitmap().load(url).into(new CustomTarget<Bitmap>() { // from class: com.funny.audio.media_player.media_notification.MediaNotificationDescriptorAdapter.getBitmap.1
                @Override // com.bumptech.glide.request.target.Target
                public void onLoadCleared(Drawable placeholder) {
                }

                @Override // com.bumptech.glide.request.target.Target
                public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
                    onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
                }

                public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                    Intrinsics.checkNotNullParameter(resource, "resource");
                    onSuccess.invoke(resource);
                }

                @Override // com.bumptech.glide.request.target.CustomTarget, com.bumptech.glide.request.target.Target
                public void onLoadFailed(Drawable errorDrawable) {
                    onError.invoke("Unknown Exception");
                }
            });
        }
    }
}
