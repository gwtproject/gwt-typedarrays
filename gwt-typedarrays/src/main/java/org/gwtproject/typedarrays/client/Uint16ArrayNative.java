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
import org.gwtproject.typedarrays.shared.Uint16Array;

/** JS native implementation of {@link Uint16Array}. */
@JsType(isNative = true, name = "Uint16Array", namespace = JsPackage.GLOBAL)
public final class Uint16ArrayNative extends ArrayBufferViewNative implements Uint16Array {

  /**
   * @param buffer a buffer to that this array should use for storage
   * @return a {@link Uint16Array} instance
   */
  @JsOverlay
  public static Uint16ArrayNative create(ArrayBuffer buffer) {
    return new Uint16ArrayNative(buffer);
  }

  /** @param buffer a buffer to that this array should use for storage */
  public Uint16ArrayNative(ArrayBuffer buffer) {}

  /**
   * @param buffer a buffer to that this array should use for storage
   * @param byteOffset the offset in bytes to the first item to reference in the buffer
   * @return a {@link Uint16Array} instance
   */
  @JsOverlay
  public static Uint16ArrayNative create(ArrayBuffer buffer, int byteOffset) {
    return new Uint16ArrayNative(buffer, byteOffset);
  }

  /**
   * @param buffer a buffer to that this array should use for storage
   * @param byteOffset the offset in bytes to the first item to reference in the buffer
   */
  public Uint16ArrayNative(ArrayBuffer buffer, int byteOffset) {}

  /**
   * @param buffer a buffer to that this array should use for storage
   * @param byteOffset the offset in bytes to the first item to reference in the buffer
   * @param length the number of elements in the array to reference
   * @return a {@link Uint16Array} instance
   */
  @JsOverlay
  public static Uint16ArrayNative create(ArrayBuffer buffer, int byteOffset, int length) {
    return new Uint16ArrayNative(buffer, byteOffset, length);
  }

  /**
   * @param buffer a buffer to that this array should use for storage
   * @param byteOffset the offset in bytes to the first item to reference in the buffer
   * @param length the number of elements in the array to reference
   */
  public Uint16ArrayNative(ArrayBuffer buffer, int byteOffset, int length) {}

  /**
   * @param array an array of initial values
   * @return a {@link Uint16Array} instance
   */
  @JsOverlay
  public static Uint16ArrayNative create(int[] array) {
    return new Uint16ArrayNative(array);
  }

  /** @param array an array of initial values */
  public Uint16ArrayNative(int[] array) {}

  /**
   * @param length the number of items that the created array should contain
   * @return a {@link Uint16Array} instance
   */
  @JsOverlay
  public static Uint16ArrayNative create(int length) {
    return new Uint16ArrayNative(length);
  }

  /** @param length the number of items that the created array should contain */
  public Uint16ArrayNative(int length) {}

  //  @Override
  //  @JsOverlay
  //  public int get(int index) {
  //    return Js.<JsArrayLike<Double>>cast(this).getAt(index).intValue();
  //  }

  @Override
  @JsProperty(name = "length")
  public native int length();

  //  @Override
  //  @JsOverlay
  //  public void set(int index, int value) {
  //    Js.<JsArrayLike<Double>>cast(this).setAt(index, (double) value);
  //  }

  @Override
  public native void set(int[] array);

  @Override
  public native void set(int[] array, int offset);

  @Override
  public native void set(Uint16Array array);

  @Override
  public native void set(Uint16Array array, int offset);

  @Override
  public native Uint16Array subarray(int begin);

  @Override
  public native Uint16Array subarray(int begin, int end);
}
