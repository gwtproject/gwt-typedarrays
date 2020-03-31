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

import org.gwtproject.typedarrays.shared.ArrayBuffer;
import org.gwtproject.typedarrays.shared.Int8Array;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * JS native implementation of {@link Int8Array}.
 */
@JsType(isNative = true, name = "Int8Array", namespace = JsPackage.GLOBAL)
public final class Int8ArrayNative extends ArrayBufferViewNative implements Int8Array {

  /**
   * @param buffer
   * @return a {@link Int8Array} instance
   */
  @JsOverlay
  public static Int8ArrayNative create(ArrayBuffer buffer) {
    return new Int8ArrayNative(buffer);
  }

  /**
   * @param buffer
   * @return a {@link Int8Array} instance
   */
  public Int8ArrayNative(ArrayBuffer buffer) {
  }

  /**
   * @param buffer
   * @param byteOffset
   * @return a {@link Int8Array} instance
   */
  @JsOverlay
  public static Int8ArrayNative create(ArrayBuffer buffer, int byteOffset) {
    return new Int8ArrayNative(buffer, byteOffset);
  }
  /**
   * @param buffer
   * @param byteOffset
   * @return a {@link Int8Array} instance
   */
  public Int8ArrayNative(ArrayBuffer buffer, int byteOffset) {
  }

  /**
   * @param buffer
   * @param byteOffset
   * @param length
   * @return a {@link Int8Array} instance
   */
  @JsOverlay
  public static Int8ArrayNative create(ArrayBuffer buffer, int byteOffset,
      int length) {
    return new Int8ArrayNative(buffer, byteOffset, length);
  }

  /**
   * @param buffer
   * @param byteOffset
   * @param length
   * @return a {@link Int8Array} instance
   */
  public Int8ArrayNative(ArrayBuffer buffer, int byteOffset,
      int length) {
  }

  /**
   * @param array
   * @return
   */
  @JsOverlay
  public static Int8ArrayNative create(byte[] array) {
    return new Int8ArrayNative(array);
  }

  /**
   * @param array
   */
  public Int8ArrayNative(byte[] array) {
  }

  /**
   * @param length
   * @return a {@link Int8Array} instance
   */
  @JsOverlay
  public static Int8ArrayNative create(int length) {
    return new Int8ArrayNative(length);
  }

  /**
   * @param length
   * @return a {@link Int8Array} instance
   */
  public Int8ArrayNative(int length) {
  }

//  @Override
//  @JsOverlay
//  public byte get(int index) {
//    return Js.<JsArrayLike<Double>>uncheckedCast(this).getAt(index).byteValue();
//  }

  @Override
  @JsProperty(name = "length")
  public native int length();

  @Override
  public native void set(byte[] array);

  @Override
  public native void set(byte[] array, int offset);

//  @Override
//  @JsOverlay
//  public void set(int index, int value) {
//    Js.<JsArrayLike<Double>>uncheckedCast(this).setAt(index, (double) value);
//  }

  @Override
  public native void set(int[] array);

  @Override
  public native void set(int[] array, int offset);

  @Override
  public native void set(Int8Array array);

  @Override
  public native void set(Int8Array array, int offset);

  @Override
  public native Int8Array subarray(int begin);

  @Override
  public native Int8Array subarray(int begin, int end);

}
