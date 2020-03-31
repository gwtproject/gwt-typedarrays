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

import elemental2.dom.DomGlobal;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import org.gwtproject.typedarrays.shared.ArrayBuffer;
import org.gwtproject.typedarrays.shared.DataView;
import org.gwtproject.typedarrays.shared.Float32Array;
import org.gwtproject.typedarrays.shared.Float64Array;
import org.gwtproject.typedarrays.shared.Int16Array;
import org.gwtproject.typedarrays.shared.Int32Array;
import org.gwtproject.typedarrays.shared.Int8Array;
import org.gwtproject.typedarrays.shared.TypedArrays;
import org.gwtproject.typedarrays.shared.Uint16Array;
import org.gwtproject.typedarrays.shared.Uint32Array;
import org.gwtproject.typedarrays.shared.Uint8Array;
import org.gwtproject.typedarrays.shared.Uint8ClampedArray;

/**
 * The default implementation class, which assumes that Typed Arrays might be supported and does
 * runtime checks where necessary, substituting emulated implementations of DataView and
 * Uint8ClampedArray where they are missing.
 *
 * <p>This can be replaced with a version which avoids runtime checks where possible for efficiency.
 */
public class NativeImpl extends TypedArrays.Impl {

  @Override
  public ArrayBuffer createArrayBuffer(int length) {
    return ArrayBufferNative.create(length);
  }

  //  @Override
  //  public DataView createDataView(ArrayBuffer buffer) {
  //    if (checkDataViewSupport()) {
  //      return DataViewNative.create(buffer);
  //    } else {
  //      return DataViewNativeEmul.create(buffer, 0, buffer.byteLength());
  //    }
  //  }

  //  @Override
  //  public DataView createDataView(ArrayBuffer buffer, int byteOffset) {
  //    if (checkDataViewSupport()) {
  //      return DataViewNative.create(buffer, byteOffset);
  //    } else {
  //      return DataViewNativeEmul.create(buffer, byteOffset, buffer.byteLength() - byteOffset);
  //    }
  //  }

  @Override
  public DataView createDataView(ArrayBuffer buffer, int byteOffset, int byteLength) {
    if (checkDataViewSupport()) {
      return DataViewNative.create(buffer, byteOffset, byteLength);
    } else {
      return null; // DataViewNativeEmul.create(buffer, byteOffset, byteLength);
    }
  }

  @Override
  public Float32Array createFloat32Array(ArrayBuffer buffer) {
    return Float32ArrayNative.create(buffer);
  }

  @Override
  public Float32Array createFloat32Array(ArrayBuffer buffer, int byteOffset) {
    return Float32ArrayNative.create(buffer, byteOffset);
  }

  @Override
  public Float32Array createFloat32Array(ArrayBuffer buffer, int byteOffset, int length) {
    return Float32ArrayNative.create(buffer, byteOffset, length);
  }

  @Override
  public Float32Array createFloat32Array(float[] array) {
    return Float32ArrayNative.create(array);
  }

  @Override
  public Float32Array createFloat32Array(int length) {
    return Float32ArrayNative.create(length);
  }

  @Override
  public Float64Array createFloat64Array(ArrayBuffer buffer) {
    return Float64ArrayNative.create(buffer);
  }

  @Override
  public Float64Array createFloat64Array(ArrayBuffer buffer, int byteOffset) {
    return Float64ArrayNative.create(buffer, byteOffset);
  }

  @Override
  public Float64Array createFloat64Array(ArrayBuffer buffer, int byteOffset, int length) {
    return Float64ArrayNative.create(buffer, byteOffset, length);
  }

  @Override
  public Float64Array createFloat64Array(double[] array) {
    return Float64ArrayNative.create(array);
  }

  @Override
  public Float64Array createFloat64Array(int length) {
    return Float64ArrayNative.create(length);
  }

  @Override
  public Int16Array createInt16Array(ArrayBuffer buffer) {
    return Int16ArrayNative.create(buffer);
  }

  @Override
  public Int16Array createInt16Array(ArrayBuffer buffer, int byteOffset) {
    return Int16ArrayNative.create(buffer, byteOffset);
  }

  @Override
  public Int16Array createInt16Array(ArrayBuffer buffer, int byteOffset, int length) {
    return Int16ArrayNative.create(buffer, byteOffset, length);
  }

  @Override
  public Int16Array createInt16Array(int length) {
    return Int16ArrayNative.create(length);
  }

  @Override
  public Int16Array createInt16Array(short[] array) {
    return Int16ArrayNative.create(array);
  }

  @Override
  public Int32Array createInt32Array(ArrayBuffer buffer) {
    return Int32ArrayNative.create(buffer);
  }

  @Override
  public Int32Array createInt32Array(ArrayBuffer buffer, int byteOffset) {
    return Int32ArrayNative.create(buffer, byteOffset);
  }

  @Override
  public Int32Array createInt32Array(ArrayBuffer buffer, int byteOffset, int length) {
    return Int32ArrayNative.create(buffer, byteOffset, length);
  }

  @Override
  public Int32Array createInt32Array(int length) {
    return Int32ArrayNative.create(length);
  }

  @Override
  public Int32Array createInt32Array(int[] array) {
    return Int32ArrayNative.create(array);
  }

  @Override
  public Int8Array createInt8Array(ArrayBuffer buffer) {
    return Int8ArrayNative.create(buffer);
  }

  @Override
  public Int8Array createInt8Array(ArrayBuffer buffer, int byteOffset) {
    return Int8ArrayNative.create(buffer, byteOffset);
  }

  @Override
  public Int8Array createInt8Array(ArrayBuffer buffer, int byteOffset, int length) {
    return Int8ArrayNative.create(buffer, byteOffset, length);
  }

  @Override
  public Int8Array createInt8Array(byte[] array) {
    return Int8ArrayNative.create(array);
  }

  @Override
  public Int8Array createInt8Array(int length) {
    return Int8ArrayNative.create(length);
  }

  @Override
  public Uint16Array createUint16Array(ArrayBuffer buffer) {
    return Uint16ArrayNative.create(buffer);
  }

  @Override
  public Uint16Array createUint16Array(ArrayBuffer buffer, int byteOffset) {
    return Uint16ArrayNative.create(buffer, byteOffset);
  }

  @Override
  public Uint16Array createUint16Array(ArrayBuffer buffer, int byteOffset, int length) {
    return Uint16ArrayNative.create(buffer, byteOffset, length);
  }

  @Override
  public Uint16Array createUint16Array(int length) {
    return Uint16ArrayNative.create(length);
  }

  @Override
  public Uint16Array createUint16Array(int[] array) {
    return Uint16ArrayNative.create(array);
  }

  @Override
  public Uint32Array createUint32Array(ArrayBuffer buffer) {
    return Uint32ArrayNative.create(buffer);
  }

  @Override
  public Uint32Array createUint32Array(ArrayBuffer buffer, int byteOffset) {
    return Uint32ArrayNative.create(buffer, byteOffset);
  }

  @Override
  public Uint32Array createUint32Array(ArrayBuffer buffer, int byteOffset, int length) {
    return Uint32ArrayNative.create(buffer, byteOffset, length);
  }

  @Override
  public Uint32Array createUint32Array(double[] array) {
    return Uint32ArrayNative.create(array);
  }

  @Override
  public Uint32Array createUint32Array(int length) {
    return Uint32ArrayNative.create(length);
  }

  @Override
  public Uint32Array createUint32Array(long[] array) {
    int len = array.length;
    double[] temp = new double[len];
    for (int i = 0; i < len; ++i) {
      temp[i] = array[i];
    }
    return Uint32ArrayNative.create(temp);
  }

  @Override
  public Uint8Array createUint8Array(ArrayBuffer buffer) {
    return Uint8ArrayNative.create(buffer);
  }

  @Override
  public Uint8Array createUint8Array(ArrayBuffer buffer, int byteOffset) {
    return Uint8ArrayNative.create(buffer, byteOffset);
  }

  @Override
  public Uint8Array createUint8Array(ArrayBuffer buffer, int byteOffset, int length) {
    return Uint8ArrayNative.create(buffer, byteOffset, length);
  }

  @Override
  public Uint8Array createUint8Array(int length) {
    return Uint8ArrayNative.create(length);
  }

  @Override
  public Uint8Array createUint8Array(short[] array) {
    return Uint8ArrayNative.create(array);
  }

  @Override
  public Uint8ClampedArray createUint8ClampedArray(ArrayBuffer buffer) {
    if (checkUint8ClampedArraySupport()) {
      return Uint8ArrayNative.createClamped(buffer);
    } else {
      return null; // Uint8ClampedArrayNativeEmul.create(buffer, 0, buffer.byteLength());
    }
  }

  @Override
  public Uint8ClampedArray createUint8ClampedArray(ArrayBuffer buffer, int byteOffset) {
    if (checkUint8ClampedArraySupport()) {
      return Uint8ArrayNative.createClamped(buffer, byteOffset);
    } else {
      return null;
      // Uint8ClampedArrayNativeEmul.create(buffer, byteOffset,
      // buffer.byteLength() - byteOffset);
    }
  }

  @Override
  public Uint8ClampedArray createUint8ClampedArray(ArrayBuffer buffer, int byteOffset, int length) {
    if (checkUint8ClampedArraySupport()) {
      return Uint8ArrayNative.createClamped(buffer, byteOffset, length);
    } else {
      return null;
      // Uint8ClampedArrayNativeEmul.create(buffer, byteOffset, length);
    }
  }

  @Override
  public Uint8ClampedArray createUint8ClampedArray(int length) {
    if (checkUint8ClampedArraySupport()) {
      return Uint8ArrayNative.createClamped(length);
    } else {
      return null;
      // Uint8ClampedArrayNativeEmul.create(createArrayBuffer(length), 0, length);
    }
  }

  @Override
  public Uint8ClampedArray createUint8ClampedArray(short[] array) {
    if (checkUint8ClampedArraySupport()) {
      return Uint8ArrayNative.createClamped(array);
    } else {
      return null;
      // Uint8ClampedArrayNativeEmul.create(array);
    }
  }

  // In contrast to GWT2, these default to true, but left here for compatibility
  protected boolean checkDataViewSupport() {
    return true;
  }

  protected boolean checkUint8ClampedArraySupport() {
    return true;
  }

  @Override
  protected boolean runtimeSupportCheck() {
    return Js.<JsPropertyMap<Object>>uncheckedCast(DomGlobal.window).has("ArrayBuffer");
  }
}
