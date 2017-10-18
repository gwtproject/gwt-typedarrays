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
import org.gwtproject.typedarrays.shared.Uint16Array;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * JS native implementation of {@link Uint16Array}.
 */
@JsType(isNative = true, name = "Uint16Array", namespace = JsPackage.GLOBAL)
public final class Uint16ArrayNative extends ArrayBufferViewNative implements Uint16Array {

  /**
   * @param buffer
   * @return a {@link Uint16Array} instance
   */
  @JsOverlay
  public static Uint16ArrayNative create(ArrayBuffer buffer) {
    return new Uint16ArrayNative(buffer);
  }

  /**
   * @param buffer
   * @return a {@link Uint16Array} instance
   */
  public Uint16ArrayNative(ArrayBuffer buffer) {
  }

  /**
   * @param buffer
   * @param byteOffset
   * @return a {@link Uint16Array} instance
   */
  @JsOverlay
  public static Uint16ArrayNative create(ArrayBuffer buffer, int byteOffset) {
    return new Uint16ArrayNative(buffer, byteOffset);
  }

  /**
   * @param buffer
   * @param byteOffset
   * @return a {@link Uint16Array} instance
   */
  public Uint16ArrayNative(ArrayBuffer buffer, int byteOffset) {
  }

  /**
   * @param buffer
   * @param byteOffset
   * @param length
   * @return a {@link Uint16Array} instance
   */
  @JsOverlay
  public static Uint16ArrayNative create(ArrayBuffer buffer, int byteOffset,
      int length) {
    return new Uint16ArrayNative(buffer, byteOffset, length);
  }

  /**
   * @param buffer
   * @param byteOffset
   * @param length
   * @return a {@link Uint16Array} instance
   */
  public Uint16ArrayNative(ArrayBuffer buffer, int byteOffset,
      int length) {
  }

  /**
   *
   * @param array
   * @return a {@link Uint16Array} instance
   */
  @JsOverlay
  public static Uint16ArrayNative create(int[] array) {
    return new Uint16ArrayNative(array);
  }

  /**
   * @param array
   */
  public Uint16ArrayNative(int[] array) {
  }

  /**
   * @param length
   * @return a {@link Uint16Array} instance
   */
  @JsOverlay
  public static Uint16ArrayNative create(int length) {
    return new Uint16ArrayNative(length);
  }

  /**
   * @param length
   * @return a {@link Uint16Array} instance
   */
  public Uint16ArrayNative(int length) {
  }

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
