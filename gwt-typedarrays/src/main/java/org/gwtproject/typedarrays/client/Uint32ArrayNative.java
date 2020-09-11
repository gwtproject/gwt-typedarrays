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

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.gwtproject.typedarrays.shared.ArrayBuffer;
import org.gwtproject.typedarrays.shared.Uint32Array;

/** JS native implementation of {@link Uint32Array}. */
@JsType(isNative = true, name = "Uint32Array", namespace = JsPackage.GLOBAL)
public final class Uint32ArrayNative extends ArrayBufferViewNative implements Uint32Array {

  /**
   * @param buffer a buffer to that this array should use for storage
   * @return a {@link Uint32Array} instance
   */
  @JsOverlay
  public static Uint32ArrayNative create(ArrayBuffer buffer) {
    return new Uint32ArrayNative(buffer);
  }

  /** @param buffer a buffer to that this array should use for storage */
  public Uint32ArrayNative(ArrayBuffer buffer) {}

  /**
   * @param buffer a buffer to that this array should use for storage
   * @param byteOffset the offset in bytes to the first item to reference in the buffer
   * @return a {@link Uint32Array} instance
   */
  @JsOverlay
  public static Uint32ArrayNative create(ArrayBuffer buffer, int byteOffset) {
    return new Uint32ArrayNative(buffer, byteOffset);
  }

  /**
   * @param buffer a buffer to that this array should use for storage
   * @param byteOffset the offset in bytes to the first item to reference in the buffer
   */
  public Uint32ArrayNative(ArrayBuffer buffer, int byteOffset) {}

  /**
   * @param buffer a buffer to that this array should use for storage
   * @param byteOffset the offset in bytes to the first item to reference in the buffer
   * @param length the number of elements in the array to reference
   * @return a {@link Uint32Array} instance
   */
  @JsOverlay
  public static Uint32ArrayNative create(ArrayBuffer buffer, int byteOffset, int length) {
    return new Uint32ArrayNative(buffer, byteOffset, length);
  }

  /**
   * @param buffer a buffer to that this array should use for storage
   * @param byteOffset the offset in bytes to the first item to reference in the buffer
   * @param length the number of elements in the array to reference
   */
  public Uint32ArrayNative(ArrayBuffer buffer, int byteOffset, int length) {}

  /**
   * Create a Uint32ArrayNative instance, from a double array.
   *
   * @param array source data in a double[]
   * @return a {@link Uint32ArrayNative} instance
   */
  @JsOverlay
  public static Uint32ArrayNative create(double[] array) {
    return new Uint32ArrayNative(array);
  }

  /**
   * A new Uint32Array instance.
   *
   * @param array
   */
  public Uint32ArrayNative(double[] array) {}

  /**
   * @param length the number of items that the created array should contain
   * @return a {@link Uint32Array} instance
   */
  @JsOverlay
  public static Uint32ArrayNative create(int length) {
    return new Uint32ArrayNative(length);
  }

  /** @param length the number of items that the created array should contain */
  public Uint32ArrayNative(int length) {}

  //  @Override
  //  @JsOverlay
  //  public long get(int index) {
  //    return (long) getAsDouble(index);
  //  }
  //
  //  @Override
  //  @JsOverlay
  //  public double getAsDouble(int index) {
  //    return Js.<JsArrayLike<Double>>uncheckedCast(this).getAt(index);
  //  }

  @Override
  @JsProperty(name = "length")
  public native int length();

  @Override
  public native void set(double[] array);

  @Override
  public native void set(double[] array, int offset);

  //  @Override
  //  @JsOverlay
  //  public void set(int index, double value) {
  //    Js.<JsArrayLike<Double>>uncheckedCast(this).setAt(index, value);
  //  }

  //  @Override
  //  public void set(int index, long value) {
  //    set(index, (double) value);
  //  }

  //  @Override
  //  @JsOverlay
  //  public void set(long[] array, int offset) {
  //    int len = array.length;
  //    double[] temp = new double[len];
  //    for (int i = 0; i < len; ++i) {
  //      temp[i] = array[i];
  //    }
  //    set(temp, offset);
  //  }

  @Override
  public native void set(Uint32Array array);

  @Override
  public native void set(Uint32Array array, int offset);

  @Override
  public native Uint32Array subarray(int begin);

  @Override
  public native Uint32Array subarray(int begin, int end);
}
