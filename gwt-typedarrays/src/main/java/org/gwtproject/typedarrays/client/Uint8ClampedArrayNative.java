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

import org.gwtproject.core.client.JavaScriptObject;
import org.gwtproject.typedarrays.shared.ArrayBuffer;
import org.gwtproject.typedarrays.shared.Uint8ClampedArray;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * JS native implementation of {@link org.gwtproject.typedarrays.shared.Uint8Array} and,
 * where natively supported, {@link Uint8ClampedArray}.
 * <p>
 * This should generally not be referenced directly -- see
 * {@link org.gwtproject.typedarrays.shared.TypedArrays} and
 * {@link JsUtils}.
 */
@JsType(isNative = true, name = "Uint8ClampedArray", namespace = JsPackage.GLOBAL)
public class Uint8ClampedArrayNative extends Uint8ArrayNative implements Uint8ClampedArray {

  /**
   * Create a {@link Uint8ClampedArray} instance. Must only be called if the
   * environment natively supports clamped arrays -- otherwise
   * {@link Uint8ClampedArrayNativeEmul} should be used instead.
   *
   * @param buffer
   */
  public Uint8ClampedArrayNative(ArrayBuffer buffer) {
  }

  /**
   * Create a {@link Uint8ClampedArray} instance. Must only be called if the
   * environment natively supports clamped arrays -- otherwise
   * {@link Uint8ClampedArrayNativeEmul} should be used instead.
   *
   * @param buffer
   * @param byteOffset
   */
  public Uint8ClampedArrayNative(ArrayBuffer buffer, int byteOffset) {
  }

  /**
   * Create a {@link Uint8ClampedArray} instance. Must only be called if the
   * environment natively supports clamped arrays -- otherwise
   * {@link Uint8ClampedArrayNativeEmul} should be used instead.
   *
   * @param buffer
   * @param byteOffset
   * @param length
   */
  public Uint8ClampedArrayNative(ArrayBuffer buffer, int byteOffset, int length) {
  }

  /**
   * Create a {@link org.gwtproject.typedarrays.shared.Uint8Array} instance from an array.
   * Must only be called if the environment natively supports clamped arrays -- otherwise
   * {@link Uint8ClampedArrayNativeEmul} should be used instead.
   *
   * @param array an array of initial values
   */
  public Uint8ClampedArrayNative(int[] array) {
  }

  /**
   * Create a {@link Uint8ClampedArray} instance from a JavaScript array-like
   * object. Must only be called if the environment natively supports clamped
   * arrays -- otherwise {@link Uint8ClampedArrayNativeEmul} should be used
   * instead.
   *
   * @param array a JS array or array-like object
   */
  public Uint8ClampedArrayNative(JavaScriptObject array) {
  }

  /**
   * Create a {@link org.gwtproject.typedarrays.shared.Uint8Array} instance from an array.
   * Must only be called if the environment natively supports clamped arrays -- otherwise
   * {@link Uint8ClampedArrayNativeEmul} should be used instead.
   *
   * @param array an array of initial values
   */
  public Uint8ClampedArrayNative(short[] array) {
  }

  /**
   * Create a {@link Uint8ClampedArray} instance. Must only be called if the
   * environment natively supports clamped arrays -- otherwise
   * {@link Uint8ClampedArrayNativeEmul} should be used instead.
   *
   * @param length
   */
  public Uint8ClampedArrayNative(int length) {
  }

//  @Override
//  @JsOverlay
//  public short get(int index) {
//    return Js.<JsArrayLike<Double>>uncheckedCast(this).getAt(index).shortValue();
//  }
//
//  @Override
//  @JsProperty(name = "length")
//  public native int length();
//
//  @Override
//  @JsOverlay
//  public void set(int index, int value) {
//    Js.<JsArrayLike<Double>>uncheckedCast(this).setAt(index, (double)value);
//  }
//
//  @Override
//  @JsOverlay
//  public void set(int[] array) {
//    set(array, 0);
//  }
//
//  @Override
//  public native void set(int[] array, int offset);
//
//  @Override
//  @JsOverlay
//  public void set(short[] array) {
//    set(array, 0);
//  }
//
//  @Override
//  public native void set(short[] array, int offset);
//
//  @Override
//  @JsOverlay
//  public void set(Uint8Array array) {
//    set(array, 0);
//  }
//
//  @Override
//  @JsOverlay
//  public void set(Uint8Array array, int offset) {
//    if (array instanceof Uint8ClampedArrayNative) {
//      // Note that any JSO would pass this check, but since only one JSO can
//      // implement a given interface it has to be this one, so any other
//      // implementations must be Java emulations.
//      setNative(array, offset);
//      return;
//    }
//    int len = array.length();
//    for (int i = 0; i < len; ++i) {
//      set(offset++, array.get(i));
//    }
//  }
//
//  @JsMethod(name = "set")
//  private native void setNative(Uint8Array array, int offset);
//
//  @Override
//  public native Uint8ClampedArrayNative subarray(int begin);
//
//  @Override
//  public native Uint8ClampedArrayNative subarray(int begin, int end);

}
