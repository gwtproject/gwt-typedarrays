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
package org.gwtproject.typedarrays.server;

import org.gwtproject.core.shared.GwtIncompatible;
import org.gwtproject.typedarrays.client.NativeImpl;
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

/** Pure Java implementation class for typed arrays. */
public class JavaImpl extends NativeImpl {

  @GwtIncompatible
  @Override
  public ArrayBuffer createArrayBuffer(int length) {
    return new ArrayBufferImpl(length);
  }

  @GwtIncompatible
  @Override
  public DataView createDataView(ArrayBuffer buffer, int byteOffset, int byteLength) {
    return new DataViewImpl(buffer, byteOffset, byteLength);
  }

  @GwtIncompatible
  @Override
  public Float32Array createFloat32Array(ArrayBuffer buffer, int byteOffset, int length) {
    return new Float32ArrayImpl(buffer, byteOffset, length);
  }

  @GwtIncompatible
  @Override
  public Float32Array createFloat32Array(float[] array) {
    Float32Array result = TypedArrays.createFloat32Array(array.length);
    result.set(array);
    return result;
  }

  @GwtIncompatible
  @Override
  public Float32Array createFloat32Array(ArrayBuffer buffer) {
    return createFloat32Array(
        buffer, 0, getElementCount(buffer.byteLength(), Float32Array.BYTES_PER_ELEMENT));
  }

  @GwtIncompatible
  @Override
  public Float32Array createFloat32Array(ArrayBuffer buffer, int byteOffset) {
    return createFloat32Array(
        buffer,
        byteOffset,
        getElementCount(buffer.byteLength() - byteOffset, Float32Array.BYTES_PER_ELEMENT));
  }

  @GwtIncompatible
  @Override
  public Float32Array createFloat32Array(int length) {
    return createFloat32Array(createArrayBuffer(length * Float32Array.BYTES_PER_ELEMENT));
  }

  @GwtIncompatible
  @Override
  public Float64Array createFloat64Array(ArrayBuffer buffer) {
    return createFloat64Array(
        buffer, 0, getElementCount(buffer.byteLength(), Float64Array.BYTES_PER_ELEMENT));
  }

  @GwtIncompatible
  @Override
  public Float64Array createFloat64Array(ArrayBuffer buffer, int byteOffset) {
    return createFloat64Array(
        buffer,
        byteOffset,
        getElementCount(buffer.byteLength() - byteOffset, Float64Array.BYTES_PER_ELEMENT));
  }

  @GwtIncompatible
  @Override
  public Float64Array createFloat64Array(ArrayBuffer buffer, int byteOffset, int length) {
    return new Float64ArrayImpl(buffer, byteOffset, length);
  }

  @GwtIncompatible
  @Override
  public Float64Array createFloat64Array(double[] array) {
    Float64Array result = createFloat64Array(array.length);
    result.set(array);
    return result;
  }

  @GwtIncompatible
  @Override
  public Float64Array createFloat64Array(int length) {
    return createFloat64Array(createArrayBuffer(length * Float64Array.BYTES_PER_ELEMENT));
  }

  @GwtIncompatible
  @Override
  public Int16Array createInt16Array(ArrayBuffer buffer) {
    return createInt16Array(
        buffer, 0, getElementCount(buffer.byteLength(), Int16Array.BYTES_PER_ELEMENT));
  }

  @GwtIncompatible
  @Override
  public Int16Array createInt16Array(ArrayBuffer buffer, int byteOffset) {
    return createInt16Array(
        buffer,
        byteOffset,
        getElementCount(buffer.byteLength() - byteOffset, Int16Array.BYTES_PER_ELEMENT));
  }

  @GwtIncompatible
  @Override
  public Int16Array createInt16Array(ArrayBuffer buffer, int byteOffset, int length) {
    return new Int16ArrayImpl(buffer, byteOffset, length);
  }

  @GwtIncompatible
  @Override
  public Int16Array createInt16Array(int length) {
    return createInt16Array(createArrayBuffer(length * Int16Array.BYTES_PER_ELEMENT));
  }

  @GwtIncompatible
  @Override
  public Int16Array createInt16Array(short[] array) {
    Int16Array result = createInt16Array(array.length);
    result.set(array);
    return result;
  }

  @GwtIncompatible
  @Override
  public Int32Array createInt32Array(ArrayBuffer buffer) {
    return createInt32Array(
        buffer, 0, getElementCount(buffer.byteLength(), Int32Array.BYTES_PER_ELEMENT));
  }

  @GwtIncompatible
  @Override
  public Int32Array createInt32Array(ArrayBuffer buffer, int byteOffset) {
    return createInt32Array(
        buffer,
        byteOffset,
        getElementCount(buffer.byteLength() - byteOffset, Int32Array.BYTES_PER_ELEMENT));
  }

  @GwtIncompatible
  @Override
  public Int32Array createInt32Array(ArrayBuffer buffer, int byteOffset, int length) {
    return new Int32ArrayImpl(buffer, byteOffset, length);
  }

  @GwtIncompatible
  @Override
  public Int32Array createInt32Array(int length) {
    return createInt32Array(createArrayBuffer(length * Int32Array.BYTES_PER_ELEMENT));
  }

  @GwtIncompatible
  @Override
  public Int32Array createInt32Array(int[] array) {
    Int32Array result = createInt32Array(array.length);
    result.set(array);
    return result;
  }

  @GwtIncompatible
  @Override
  public Int8Array createInt8Array(ArrayBuffer buffer) {
    return createInt8Array(buffer, 0, buffer.byteLength());
  }

  @GwtIncompatible
  @Override
  public Int8Array createInt8Array(ArrayBuffer buffer, int byteOffset) {
    return createInt8Array(buffer, byteOffset, buffer.byteLength() - byteOffset);
  }

  @GwtIncompatible
  @Override
  public Int8Array createInt8Array(ArrayBuffer buffer, int byteOffset, int length) {
    return new Int8ArrayImpl(buffer, byteOffset, length);
  }

  @GwtIncompatible
  @Override
  public Int8Array createInt8Array(byte[] array) {
    Int8Array result = createInt8Array(array.length);
    result.set(array);
    return result;
  }

  @GwtIncompatible
  @Override
  public Int8Array createInt8Array(int length) {
    return createInt8Array(createArrayBuffer(length));
  }

  @GwtIncompatible
  @Override
  public Uint16Array createUint16Array(ArrayBuffer buffer) {
    return createUint16Array(
        buffer, 0, getElementCount(buffer.byteLength(), Uint16Array.BYTES_PER_ELEMENT));
  }

  @GwtIncompatible
  @Override
  public Uint16Array createUint16Array(ArrayBuffer buffer, int byteOffset) {
    return createUint16Array(
        buffer,
        byteOffset,
        getElementCount(buffer.byteLength() - byteOffset, Uint16Array.BYTES_PER_ELEMENT));
  }

  @GwtIncompatible
  @Override
  public Uint16Array createUint16Array(ArrayBuffer buffer, int byteOffset, int length) {
    return new Uint16ArrayImpl(buffer, byteOffset, length);
  }

  @GwtIncompatible
  @Override
  public Uint16Array createUint16Array(int length) {
    return createUint16Array(createArrayBuffer(length * Uint16Array.BYTES_PER_ELEMENT));
  }

  @GwtIncompatible
  @Override
  public Uint16Array createUint16Array(int[] array) {
    Uint16Array result = createUint16Array(array.length);
    result.set(array);
    return result;
  }

  @GwtIncompatible
  @Override
  public Uint32Array createUint32Array(ArrayBuffer buffer) {
    return createUint32Array(
        buffer, 0, getElementCount(buffer.byteLength(), Uint32Array.BYTES_PER_ELEMENT));
  }

  @GwtIncompatible
  @Override
  public Uint32Array createUint32Array(ArrayBuffer buffer, int byteOffset) {
    return createUint32Array(
        buffer,
        byteOffset,
        getElementCount(buffer.byteLength() - byteOffset, Uint32Array.BYTES_PER_ELEMENT));
  }

  @GwtIncompatible
  @Override
  public Uint32Array createUint32Array(ArrayBuffer buffer, int byteOffset, int length) {
    return new Uint32ArrayImpl(buffer, byteOffset, length);
  }

  @GwtIncompatible
  @Override
  public Uint32Array createUint32Array(double[] array) {
    Uint32Array result = createUint32Array(array.length);
    result.set(array);
    return result;
  }

  @GwtIncompatible
  @Override
  public Uint32Array createUint32Array(int length) {
    return createUint32Array(createArrayBuffer(length * Uint32Array.BYTES_PER_ELEMENT));
  }

  @GwtIncompatible
  @Override
  public Uint32Array createUint32Array(long[] array) {
    Uint32Array result = createUint32Array(array.length);
    result.set(array);
    return result;
  }

  @GwtIncompatible
  @Override
  public Uint8Array createUint8Array(ArrayBuffer buffer) {
    return createUint8Array(buffer, 0, buffer.byteLength());
  }

  @GwtIncompatible
  @Override
  public Uint8Array createUint8Array(ArrayBuffer buffer, int byteOffset) {
    return createUint8Array(buffer, byteOffset, buffer.byteLength() - byteOffset);
  }

  @GwtIncompatible
  @Override
  public Uint8Array createUint8Array(ArrayBuffer buffer, int byteOffset, int length) {
    return new Uint8ArrayImpl(buffer, byteOffset, length);
  }

  @GwtIncompatible
  @Override
  public Uint8Array createUint8Array(int length) {
    return createUint8Array(createArrayBuffer(length));
  }

  @GwtIncompatible
  @Override
  public Uint8Array createUint8Array(short[] array) {
    Uint8Array result = createUint8Array(array.length);
    result.set(array);
    return result;
  }

  @GwtIncompatible
  @Override
  public Uint8ClampedArray createUint8ClampedArray(ArrayBuffer buffer) {
    return createUint8ClampedArray(buffer, 0, buffer.byteLength());
  }

  @GwtIncompatible
  @Override
  public Uint8ClampedArray createUint8ClampedArray(ArrayBuffer buffer, int byteOffset) {
    return createUint8ClampedArray(buffer, byteOffset, buffer.byteLength() - byteOffset);
  }

  @GwtIncompatible
  @Override
  public Uint8ClampedArray createUint8ClampedArray(ArrayBuffer buffer, int byteOffset, int length) {
    return new Uint8ClampedArrayImpl(buffer, byteOffset, length);
  }

  @GwtIncompatible
  @Override
  public Uint8ClampedArray createUint8ClampedArray(int length) {
    return createUint8ClampedArray(createArrayBuffer(length));
  }

  @GwtIncompatible
  @Override
  public Uint8ClampedArray createUint8ClampedArray(short[] array) {
    Uint8ClampedArray result = createUint8ClampedArray(array.length);
    result.set(array);
    return result;
  }

  @GwtIncompatible
  @Override
  protected boolean runtimeSupportCheck() {
    return true;
  }
}
