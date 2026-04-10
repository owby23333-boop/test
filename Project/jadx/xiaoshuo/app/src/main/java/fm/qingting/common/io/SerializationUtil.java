package fm.qingting.common.io;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import androidx.annotation.NonNull;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* JADX INFO: loaded from: classes8.dex */
public class SerializationUtil {
    public static byte[] toBlob(Serializable o) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = null;
        try {
            try {
                try {
                    ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);
                    try {
                        objectOutputStream2.writeObject(o);
                        objectOutputStream2.flush();
                        objectOutputStream2.close();
                    } catch (IOException e) {
                        e = e;
                        objectOutputStream = objectOutputStream2;
                        e.printStackTrace();
                        if (objectOutputStream == null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                            return byteArrayOutputStream.toByteArray();
                        }
                        objectOutputStream.close();
                    } catch (Throwable th) {
                        th = th;
                        objectOutputStream = objectOutputStream2;
                        if (objectOutputStream != null) {
                            try {
                                objectOutputStream.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        } else {
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (IOException e5) {
                    e = e5;
                }
            } catch (IOException e6) {
                e6.printStackTrace();
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static Serializable toObject(@NonNull byte[] data) throws Throwable {
        ObjectInputStream objectInputStream;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
        ObjectInputStream objectInputStream2 = null;
        try {
            try {
                try {
                    try {
                        objectInputStream = new ObjectInputStream(byteArrayInputStream);
                    } catch (IOException e) {
                        e = e;
                        objectInputStream = null;
                    } catch (ClassNotFoundException e2) {
                        e = e2;
                        objectInputStream = null;
                    } catch (Throwable th) {
                        th = th;
                        if (0 != 0) {
                            try {
                                objectInputStream2.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        } else {
                            try {
                                byteArrayInputStream.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        throw th;
                    }
                    try {
                        Serializable serializable = (Serializable) objectInputStream.readObject();
                        try {
                            objectInputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                        return serializable;
                    } catch (IOException e6) {
                        e = e6;
                        e.printStackTrace();
                        if (objectInputStream != null) {
                            objectInputStream.close();
                            return null;
                        }
                        byteArrayInputStream.close();
                        return null;
                    } catch (ClassNotFoundException e7) {
                        e = e7;
                        e.printStackTrace();
                        if (objectInputStream != null) {
                            objectInputStream.close();
                            return null;
                        }
                        byteArrayInputStream.close();
                        return null;
                    }
                } catch (IOException e8) {
                    e8.printStackTrace();
                    return null;
                }
            } catch (IOException e9) {
                e9.printStackTrace();
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static <T extends Parcelable> T toParcelable(@NonNull byte[] bArr, Class<T> cls) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.unmarshall(bArr, 0, bArr.length);
            parcelObtain.setDataPosition(0);
            T t = (T) parcelObtain.readParcelable(cls.getClassLoader());
            if (cls.isInstance(t)) {
                return t;
            }
            throw new IllegalArgumentException("Class does not match.");
        } finally {
            parcelObtain.recycle();
        }
    }

    public static String toString(Serializable o) {
        return Base64.encodeToString(toBlob(o), 3);
    }

    public static byte[] toBlob(@NonNull Parcelable p) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeParcelable(p, 0);
            return parcelObtain.marshall();
        } finally {
            parcelObtain.recycle();
        }
    }

    public static Serializable toObject(String s) {
        if (s == null) {
            return null;
        }
        return toObject(Base64.decode(s, 3));
    }
}
