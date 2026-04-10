package com.duokan.free.tts;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.duokan.free.tts.data.CatalogItem;
import com.duokan.free.tts.data.PlaybackInfo;
import com.duokan.free.tts.data.Sentence;
import com.duokan.free.tts.data.TTSIndex;

/* JADX INFO: loaded from: classes15.dex */
public interface IMediaServiceCallback extends IInterface {
    public static final String b0 = "com.duokan.free.tts.IMediaServiceCallback";

    public static class Default implements IMediaServiceCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.duokan.free.tts.IMediaServiceCallback
        public void k(CatalogItem catalogItem, int i, int i2) throws RemoteException {
        }

        @Override // com.duokan.free.tts.IMediaServiceCallback
        public void o0() throws RemoteException {
        }

        @Override // com.duokan.free.tts.IMediaServiceCallback
        public void p0(int i) throws RemoteException {
        }

        @Override // com.duokan.free.tts.IMediaServiceCallback
        public void q0(PlaybackInfo playbackInfo) throws RemoteException {
        }

        @Override // com.duokan.free.tts.IMediaServiceCallback
        public void r0(Sentence sentence, TTSIndex tTSIndex) throws RemoteException {
        }

        @Override // com.duokan.free.tts.IMediaServiceCallback
        public void s0(float f) throws RemoteException {
        }

        @Override // com.duokan.free.tts.IMediaServiceCallback
        public void t0(Bundle bundle) throws RemoteException {
        }
    }

    public static abstract class Stub extends Binder implements IMediaServiceCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f3602a = 1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f3603b = 2;
        public static final int c = 3;
        public static final int d = 4;
        public static final int e = 5;
        public static final int f = 6;
        public static final int g = 7;

        public static class a implements IMediaServiceCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public IBinder f3604a;

            public a(IBinder iBinder) {
                this.f3604a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f3604a;
            }

            public String f() {
                return IMediaServiceCallback.b0;
            }

            @Override // com.duokan.free.tts.IMediaServiceCallback
            public void k(CatalogItem catalogItem, int i, int i2) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaServiceCallback.b0);
                    a.d(parcelObtain, catalogItem, 0);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    this.f3604a.transact(5, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.duokan.free.tts.IMediaServiceCallback
            public void o0() throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaServiceCallback.b0);
                    this.f3604a.transact(7, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.duokan.free.tts.IMediaServiceCallback
            public void p0(int i) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaServiceCallback.b0);
                    parcelObtain.writeInt(i);
                    this.f3604a.transact(1, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.duokan.free.tts.IMediaServiceCallback
            public void q0(PlaybackInfo playbackInfo) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaServiceCallback.b0);
                    a.d(parcelObtain, playbackInfo, 0);
                    this.f3604a.transact(6, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.duokan.free.tts.IMediaServiceCallback
            public void r0(Sentence sentence, TTSIndex tTSIndex) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaServiceCallback.b0);
                    a.d(parcelObtain, sentence, 0);
                    a.d(parcelObtain, tTSIndex, 0);
                    this.f3604a.transact(4, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.duokan.free.tts.IMediaServiceCallback
            public void s0(float f) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaServiceCallback.b0);
                    parcelObtain.writeFloat(f);
                    this.f3604a.transact(2, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // com.duokan.free.tts.IMediaServiceCallback
            public void t0(Bundle bundle) throws RemoteException {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaServiceCallback.b0);
                    a.d(parcelObtain, bundle, 0);
                    this.f3604a.transact(3, parcelObtain, parcelObtain2, 0);
                    parcelObtain2.readException();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, IMediaServiceCallback.b0);
        }

        public static IMediaServiceCallback a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IMediaServiceCallback.b0);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof IMediaServiceCallback)) ? new a(iBinder) : (IMediaServiceCallback) iInterfaceQueryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IMediaServiceCallback.b0);
            }
            if (i == 1598968902) {
                parcel2.writeString(IMediaServiceCallback.b0);
                return true;
            }
            switch (i) {
                case 1:
                    p0(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 2:
                    s0(parcel.readFloat());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    t0((Bundle) a.c(parcel, Bundle.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    r0((Sentence) a.c(parcel, Sentence.CREATOR), (TTSIndex) a.c(parcel, TTSIndex.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 5:
                    k((CatalogItem) a.c(parcel, CatalogItem.CREATOR), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    q0((PlaybackInfo) a.c(parcel, PlaybackInfo.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 7:
                    o0();
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    public static class a {
        public static <T> T c(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        public static <T extends Parcelable> void d(Parcel parcel, T t, int i) {
            if (t == null) {
                parcel.writeInt(0);
            } else {
                parcel.writeInt(1);
                t.writeToParcel(parcel, i);
            }
        }
    }

    void k(CatalogItem catalogItem, int i, int i2) throws RemoteException;

    void o0() throws RemoteException;

    void p0(int i) throws RemoteException;

    void q0(PlaybackInfo playbackInfo) throws RemoteException;

    void r0(Sentence sentence, TTSIndex tTSIndex) throws RemoteException;

    void s0(float f) throws RemoteException;

    void t0(Bundle bundle) throws RemoteException;
}
