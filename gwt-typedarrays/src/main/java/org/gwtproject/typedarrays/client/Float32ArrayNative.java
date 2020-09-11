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
import org.gwtproject.typedarrays.shared.Float32Array;

/** JS native implementation of {@link Float32Array}. */
@JsType(isNative = true, name = "Float32Array", namespace = JsPackage.GLOBAL)
public final class Float32ArrayNative extends ArrayBufferViewNative implements Float32Array {

  /**
   * @param buffer a buffer to that this array should use for storage
   * @return a {@link Float32Array} instance
   */
  @JsOverlay
  public static Float32ArrayNative create(ArrayBuffer buffer) {
    return new Float32ArrayNative(buffer);
  };
  /** @param buffer a buffer to that this array should use for storage */
  public Float32ArrayNative(ArrayBuffer buffer) {}

  /**
   * @param buffer a buffer to that this array should use for storage
   * @param byteOffset the offset in bytes to the first item to reference in the buffer
   * @return a {@link Float32Array} instance
   */
  @JsOverlay
  public static Float32ArrayNative create(ArrayBuffer buffer, int byteOffset) {
    return new Float32ArrayNative(buffer, byteOffset);
  };
  /**
   * @param buffer a buffer to that this array should use for storage
   * @param byteOffset the offset in bytes to the first item to reference in the buffer
   */
  public Float32ArrayNative(ArrayBuffer buffer, int byteOffset) {}

  /**
   * @param buffer a buffer to that this array should use for storage
   * @param byteOffset the offset in bytes to the first item to reference in the buffer
   * @param length the number of elements in the array to reference
   * @return a {@link Float32Array} instance
   */
  @JsOverlay
  public static Float32ArrayNative create(ArrayBuffer buffer, int byteOffset, int length) {
    return new Float32ArrayNative(buffer, byteOffset, length);
  }
  /**
   * @param buffer a buffer to that this array should use for storage
   * @param byteOffset the offset in bytes to the first item to reference in the buffer
   * @param length the number of elements in the array to reference
   */
  public Float32ArrayNative(ArrayBuffer buffer, int byteOffset, int length) {}

  /**
   * Create a {@link Float32ArrayNative} instance from an array.
   *
   * @param array an array of initial values
   * @return a {@link Float32ArrayNative} instance
   */
  @JsOverlay
  public static Float32ArrayNative create(float[] array) {
    return new Float32ArrayNative(array);
  }

  /**
   * Create a {@link Float32ArrayNative} instance from an array.
   *
   * @param array an array of initial values
   */
  public Float32ArrayNative(float[] array) {}

  /**
   * @param length the number of items that the created array should contain
   * @return a {@link Float32Array} instance
   */
  @JsOverlay
  public static Float32ArrayNative create(int length) {
    return new Float32ArrayNative(length);
  }
  /** @param length the number of items that the created array should contain */
  public Float32ArrayNative(int length) {}

  //  @Override
  //  @JsOverlay
  //  public float get(int index) {
  //    return Js.<JsArrayLike<Double>>uncheckedCast(this).getAt(index).floatValue();
  //  }

  @Override
  @JsProperty(name = "length")
  public native int length();

  @Override
  public native void set(float[] array);

  @Override
  public native void set(float[] array, int offset);

  @Override
  public native void set(Float32Array array);

  @Override
  public native void set(Float32Array array, int offset);

  //  @Override
  //  @JsOverlay
  //  public void set(int index, float value) {
  //    Js.<JsArrayLike<Double>>uncheckedCast(this).setAt(index, (double) value);
  //  }

  @Override
  public native Float32Array subarray(int begin);

  @Override
  public native Float32Array subarray(int begin, int end);
}
