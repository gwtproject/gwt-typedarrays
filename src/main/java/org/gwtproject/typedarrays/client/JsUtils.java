/*
 * Copyright 2012 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.gwtproject.typedarrays.client;

import org.gwtproject.core.client.JsArrayInteger;
import org.gwtproject.core.client.JsArrayNumber;
import org.gwtproject.typedarrays.shared.ArrayBuffer;
import org.gwtproject.typedarrays.shared.Float32Array;
import org.gwtproject.typedarrays.shared.Float64Array;
import org.gwtproject.typedarrays.shared.Int16Array;
import org.gwtproject.typedarrays.shared.Int32Array;
import org.gwtproject.typedarrays.shared.Int8Array;
import org.gwtproject.typedarrays.shared.Uint16Array;
import org.gwtproject.typedarrays.shared.Uint32Array;
import org.gwtproject.typedarrays.shared.Uint8Array;
import org.gwtproject.typedarrays.shared.Uint8ClampedArray;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;

/**
 * JS-specific utility methods, for use in client-side code that has the values in
 * JS objects already.
 * <p/>
 * @deprecated In addition to
 */
@Deprecated// This class assumes GWT2 JSOs, and will be removed in the next release
//CHECKSTYLE_OFF deprecated class, not going to worry about javadoc
public class JsUtils {

  /**
   * Creates an {@link ArrayBuffer} from a string, with bytes encoded as
   * individual characters (which means in UTF8-encoded strings, byte
   * values {@code 0x80-0xFF} take two bytes. 
   * 
   * @param str
   * @return an {@link ArrayBuffer} containing the bytes decoded from the
   *     string
   * @deprecated This does not actually handle utf-8 correctly!
   */
  @Deprecated
  public static ArrayBuffer arrayBufferFromString(String str) {
    // TODO(jat): more efficient way to do this?
    int len = str.length();
    Uint8ArrayNative buf = new Uint8ArrayNative(len);
    for (int i = 0; i < len; ++i) {
       buf.set(i, str.charAt(i));
    }
    return buf.buffer();
    // Correct implementation:
//    return new Int8ArrayNative(str.getBytes(StandardCharsets.UTF_8)).buffer();
  }

  public static Float32ArrayNative createFloat32Array(JsArrayNumber array) {
    return Js.uncheckedCast(new Float32ArrayN(array));
  }

  public static Float64ArrayNative createFloat64Array(JsArrayNumber array) {
    return Js.uncheckedCast(new Float64ArrayN(array));
  }

  public static Int16ArrayNative createInt16Array(JsArrayInteger array) {
    return Js.uncheckedCast(new Int16ArrayN(array));
  }

  public static Int32ArrayNative createInt32Array(JsArrayInteger array) {
    return Js.uncheckedCast(new Int32ArrayN(array));
  }

  public static Int8ArrayNative createInt8Array(JsArrayInteger array) {
    return Js.uncheckedCast(new Int8ArrayN(array));
  }

  public static Uint16ArrayNative createUint16Array(JsArrayInteger array) {
    return Js.uncheckedCast(new Uint16ArrayN(array));
  }

  public static Uint32ArrayNative createUint32Array(JsArrayNumber array) {
    return Js.uncheckedCast(new Uint32ArrayN(array));
  }

  public static Uint8ArrayNative createUint8Array(JsArrayInteger array) {
    return Js.uncheckedCast(new Uint8ArrayN(array));
  }

//  public static Uint8ClampedArray createUint8ClampedArray(JsArrayInteger array) {
//    if (hasClampedArray()) {
//      return Uint8ArrayNative.createClamped(array);
//    } else {
//      return Uint8ClampedArrayNativeEmul.create(array);
//    }
//  }

  @JsType(isNative = true, name = "Float32Array", namespace = JsPackage.GLOBAL)
  private static class Float32ArrayN {
    Float32ArrayN(JsArrayNumber array) {
    }
    native void set(JsArrayNumber array);
    native void set(JsArrayNumber array, int offset);
  }
  @JsType(isNative = true, name = "Float64Array", namespace = JsPackage.GLOBAL)
  private static class Float64ArrayN {
    Float64ArrayN(JsArrayNumber array) {
    }
    native void set(JsArrayNumber array);
    native void set(JsArrayNumber array, int offset);
  }
  @JsType(isNative = true, name = "Int16Array", namespace = JsPackage.GLOBAL)
  private static class Int16ArrayN {
    Int16ArrayN(JsArrayInteger array) {
    }
    native void set(JsArrayInteger array);
    native void set(JsArrayInteger array, int offset);
  }
  @JsType(isNative = true, name = "Int32Array", namespace = JsPackage.GLOBAL)
  private static class Int32ArrayN {
    Int32ArrayN(JsArrayInteger array) {
    }
    native void set(JsArrayInteger array);
    native void set(JsArrayInteger array, int offset);
  }
  @JsType(isNative = true, name = "Int8Array", namespace = JsPackage.GLOBAL)
  private static class Int8ArrayN {
    Int8ArrayN(JsArrayInteger array) {
    }
    native void set(JsArrayInteger array);
    native void set(JsArrayInteger array, int offset);
  }
  @JsType(isNative = true, name = "Uint16Array", namespace = JsPackage.GLOBAL)
  private static class Uint16ArrayN {
    Uint16ArrayN(JsArrayInteger array) {
    }
    native void set(JsArrayInteger array);
    native void set(JsArrayInteger array, int offset);
  }
  @JsType(isNative = true, name = "Uint32Array", namespace = JsPackage.GLOBAL)
  private static class Uint32ArrayN {
    Uint32ArrayN(JsArrayNumber array) {
    }
    native void set(JsArrayNumber array);
    native void set(JsArrayNumber array, int offset);
  }
  @JsType(isNative = true, name = "Uint8Array", namespace = JsPackage.GLOBAL)
  private static class Uint8ArrayN {
    Uint8ArrayN(JsArrayInteger array) {
    }
    native void set(JsArrayInteger array);
    native void set(JsArrayInteger array, int offset);
  }
  public static void set(Float32Array dest, JsArrayNumber array) {
    ((Float32ArrayN) dest).set(array);
  }

  public static void set(Float32Array dest, JsArrayNumber array, int offset) {
    Js.<Float32ArrayN>uncheckedCast(dest).set(array, offset);
  }

  public static void set(Float64Array dest, JsArrayNumber array) {
    Js.<Float64ArrayN>uncheckedCast(dest).set(array);
  }

  public static void set(Float64Array dest, JsArrayNumber array, int offset) {
    Js.<Float64ArrayN>uncheckedCast(dest).set(array, offset);
  }

  public static void set(Int16Array dest, JsArrayInteger array) {
    Js.<Int16ArrayN>uncheckedCast(dest).set(array);
  }

  public static void set(Int16Array dest, JsArrayInteger array, int offset) {
    Js.<Int16ArrayN>uncheckedCast(dest).set(array, offset);
  }

  public static void set(Int32Array dest, JsArrayInteger array) {
    Js.<Int32ArrayN>uncheckedCast(dest).set(array);
  }

  public static void set(Int32Array dest, JsArrayInteger array, int offset) {
    Js.<Int32ArrayN>uncheckedCast(dest).set(array, offset);
  }

  public static void set(Int8Array dest, JsArrayInteger array) {
    Js.<Int8ArrayN>uncheckedCast(dest).set(array);
  }

  public static void set(Int8Array dest, JsArrayInteger array, int offset) {
    Js.<Int8ArrayN>uncheckedCast(dest).set(array, offset);
  }

  public static void set(Uint16Array dest, JsArrayInteger array) {
    Js.<Uint16ArrayN>uncheckedCast(dest).set(array);
  }

  public static void set(Uint16Array dest, JsArrayInteger array, int offset) {
    Js.<Uint16ArrayN>uncheckedCast(dest).set(array, offset);
  }

  public static void set(Uint32Array dest, JsArrayNumber array) {
    Js.<Uint32ArrayN>uncheckedCast(dest).set(array);
  }

  public static void set(Uint32Array dest, JsArrayNumber array, int offset) {
    Js.<Uint32ArrayN>uncheckedCast(dest).set(array, offset);
  }

  public static void set(Uint8Array dest, JsArrayInteger array) {
    Js.<Uint8ArrayN>uncheckedCast(dest).set(array);
  }

  public static void set(Uint8Array dest, JsArrayInteger array, int offset) {
    Js.<Uint8ArrayN>uncheckedCast(dest).set(array, offset);
  }

  public static void set(Uint8ClampedArray dest, JsArrayInteger array) {
    if (hasClampedArray()) {
      set((Uint8Array) dest, array, 0);
    } else {
      int len = array.length();
      for (int i = 0; i < len; ++i) {
        dest.set(i, array.get(i));
      }
    }
  }

  public static void set(Uint8ClampedArray dest, JsArrayInteger array, int offset) {
    if (hasClampedArray()) {
      set((Uint8Array) dest, array, offset);
    } else {
      int len = array.length();
      for (int i = 0; i < len; ++i) {
        dest.set(i + offset, array.get(i));
      }
    }
  }

  /**
   * Creates a string from an {@link ArrayBuffer}, with bytes encoded as
   * individual characters (which means in UTF8-encoded strings, byte
   * values {@code 0x80-0xFF} take two bytes. 
   * 
   * @param buf
   * @return a string encoding the bytes in the {@link ArrayBuffer}
   * @deprecated This does not actually handle utf-8 correctly!
   */
  @Deprecated
  public static String stringFromArrayBuffer(ArrayBuffer buf) {
    // TODO(jat): more efficient way to do this?
    int[] cc = new int[0];
    Uint8ArrayNative i8 = new Uint8ArrayNative(buf);
    for (int i = 0; i < buf.byteLength(); ++i) {
      cc[cc.length] = i8.get(i);
    }
    return fromCharCode(null, cc);
    // Correct implementation:
//    return new String(Js.uncheckedCast(new Int8ArrayNative(buf)), StandardCharsets.UTF_8);
  }

  @JsMethod(name = "String.fromCharCode.apply", namespace = JsPackage.GLOBAL)
  private static native String fromCharCode(Object nullThis, int[] bytes);


  private static boolean hasClampedArray() {
//    // TODO(jat): this is awkward - should this be deferred bound?
//    return !!(.Uint8ClampedArray);
    return true;
  }

  private JsUtils() {
  }
}
