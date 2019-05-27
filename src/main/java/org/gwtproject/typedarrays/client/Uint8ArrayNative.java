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
import org.gwtproject.typedarrays.shared.Uint8Array;
import org.gwtproject.typedarrays.shared.Uint8ClampedArray;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * JS native implementation of {@link Uint8Array} and, where natively supported,
 * {@link Uint8ClampedArray}.
 * <p>
 * This should generally not be referenced directly -- see
 * {@link org.gwtproject.typedarrays.shared.TypedArrays} and
 * {@link org.gwtproject.typedarrays.client.JsUtils}.
 */
// TODO for legacy reasons, this is the supertype of the clamped impl too. To keep porting
// to a minimum, handle that in the next release
@JsType(isNative = true, name = "Uint8Array", namespace = JsPackage.GLOBAL)
public class Uint8ArrayNative extends ArrayBufferViewNative implements Uint8ClampedArray {

  protected Uint8ArrayNative() {
    // allow subclass to be created
  }

  /**
   * Create a {@link Uint8Array} instance.
   * 
   * @param buffer
   * @return a {@link Uint8Array} instance
   */
  @JsOverlay
  public static Uint8ArrayNative create(ArrayBuffer buffer) {
    return new Uint8ArrayNative(buffer);
  }

  /**
   * Create a {@link Uint8Array} instance.
   *
   * @param buffer
   * @return a {@link Uint8Array} instance
   */
  public Uint8ArrayNative(ArrayBuffer buffer) {
  }

  /**
   * Create a {@link Uint8Array} instance.
   * 
   * @param buffer
   * @param byteOffset
   * @return a {@link Uint8Array} instance
   */
  @JsOverlay
  public static Uint8ArrayNative create(ArrayBuffer buffer, int byteOffset) {
    return new Uint8ArrayNative(buffer, byteOffset);
  }

  /**
   * Create a {@link Uint8Array} instance.
   *
   * @param buffer
   * @param byteOffset
   * @return a {@link Uint8Array} instance
   */
  public Uint8ArrayNative(ArrayBuffer buffer, int byteOffset) {
  }

  /**
   * Create a {@link Uint8Array} instance.
   * 
   * @param buffer
   * @param byteOffset
   * @param length
   * @return a {@link Uint8Array} instance
   */
  @JsOverlay
  public static Uint8ArrayNative create(ArrayBuffer buffer, int byteOffset,
      int length) {
    return new Uint8ArrayNative(buffer, byteOffset, length);
  }

  /**
   * Create a {@link Uint8Array} instance.
   *
   * @param buffer
   * @param byteOffset
   * @param length
   * @return a {@link Uint8Array} instance
   */
  public Uint8ArrayNative(ArrayBuffer buffer, int byteOffset,
      int length) {
  }

  /**
   * Create a {@link Uint8Array} instance.
   * 
   * @param length
   * @return a {@link Uint8Array} instance
   */
  @JsOverlay
  public static Uint8ArrayNative create(int length) {
    return new Uint8ArrayNative(length);
  }

  /**
   * Create a {@link Uint8Array} instance.
   *
   * @param length
   * @return a {@link Uint8Array} instance
   */
  public Uint8ArrayNative(int length) {
  }

  /**
   * Create a {@link Uint8Array} instance from an array.
   * 
   * @param array an array of initial values
   * @return a {@link Uint8Array} instance
   */
  @JsOverlay
  public static Uint8ArrayNative create(int[] array) {
    return new Uint8ArrayNative(array);
  }

  /**
   * Create a {@link Uint8Array} instance from an array.
   *
   * @param array an array of initial values
   * @return a {@link Uint8Array} instance
   */
  public Uint8ArrayNative(int[] array) {
  }

  /**
   * Create a {@link Uint8Array} instance from a JavaScript array-like object.
   * 
   * @param array a JS array or array-like object
   * @return a {@link Uint8Array} instance
   */
  @JsOverlay
  public static Uint8ArrayNative create(JavaScriptObject array) {
    return new Uint8ArrayNative(array);
  }

  /**
   * Create a {@link Uint8Array} instance from a JavaScript array-like object.
   *
   * @param array a JS array or array-like object
   * @return a {@link Uint8Array} instance
   */
  public Uint8ArrayNative(JavaScriptObject array) {
  }

  /**
   * Create a {@link Uint8Array} instance from an array.
   * 
   * @param array an array of initial values
   * @return a {@link Uint8Array} instance
   */
  @JsOverlay
  public static Uint8ArrayNative create(short[] array) {
    return new Uint8ArrayNative(array);
  }

  /**
   * Create a {@link Uint8Array} instance from an array.
   *
   * @param array an array of initial values
   * @return a {@link Uint8Array} instance
   */
  public Uint8ArrayNative(short[] array) {
  }

  /**
   * Create a {@link Uint8ClampedArray} instance. Must only be called if the
   * environment natively supports clamped arrays -- otherwise
   * {@link Uint8ClampedArrayNativeEmul} should be used instead.
   * 
   * @param buffer
   * @return a {@link Uint8Array} instance
   */
  @JsOverlay
  public static Uint8ArrayNative createClamped(ArrayBuffer buffer) {
    return new Uint8ClampedArrayNative(buffer);
  }

  /**
   * Create a {@link Uint8ClampedArray} instance. Must only be called if the
   * environment natively supports clamped arrays -- otherwise
   * {@link Uint8ClampedArrayNativeEmul} should be used instead.
   * 
   * @param buffer
   * @param byteOffset
   * @return a {@link Uint8Array} instance
   */
  @JsOverlay
  public static Uint8ArrayNative createClamped(ArrayBuffer buffer,
      int byteOffset) {
    return new Uint8ClampedArrayNative(buffer, byteOffset);
  }

  /**
   * Create a {@link Uint8ClampedArray} instance. Must only be called if the
   * environment natively supports clamped arrays -- otherwise
   * {@link Uint8ClampedArrayNativeEmul} should be used instead.
   * 
   * @param buffer
   * @param byteOffset
   * @param length
   * @return a {@link Uint8Array} instance
   */
  @JsOverlay
  public static Uint8ArrayNative createClamped(ArrayBuffer buffer,
      int byteOffset, int length) {
    return new Uint8ClampedArrayNative(buffer, byteOffset, length);
  }

  /**
   * Create a {@link Uint8ClampedArray} instance. Must only be called if the
   * environment natively supports clamped arrays -- otherwise
   * {@link Uint8ClampedArrayNativeEmul} should be used instead.
   * 
   * @param length
   * @return a {@link Uint8Array} instance
   */
  @JsOverlay
  public static Uint8ArrayNative createClamped(int length) {
    return new Uint8ClampedArrayNative(length);
  };

  /**
   * Create a {@link Uint8Array} instance from an array. Must only be called if
   * the environment natively supports clamped arrays -- otherwise
   * {@link Uint8ClampedArrayNativeEmul} should be used instead.
   * 
   * @param array an array of initial values
   * @return a {@link Uint8Array} instance
   */
  @JsOverlay
  public static Uint8ArrayNative createClamped(int[] array) {
    return new Uint8ClampedArrayNative(array);
  }

  /**
   * Create a {@link Uint8ClampedArray} instance from a JavaScript array-like
   * object. Must only be called if the environment natively supports clamped
   * arrays -- otherwise {@link Uint8ClampedArrayNativeEmul} should be used
   * instead.
   * 
   * @param array a JS array or array-like object
   * @return a {@link Uint8ClampedArray} instance
   */
  @JsOverlay
  public static Uint8ArrayNative createClamped(JavaScriptObject array) {
    return new Uint8ClampedArrayNative(array);
  }

  /**
   * Create a {@link Uint8Array} instance from an array. Must only be called if
   * the environment natively supports clamped arrays -- otherwise
   * {@link Uint8ClampedArrayNativeEmul} should be used instead.
   * 
   * @param array an array of initial values
   * @return a {@link Uint8Array} instance
   */
  @JsOverlay
  public static Uint8ArrayNative createClamped(short[] array) {
    return new Uint8ClampedArrayNative(array);
  }

//  @Override
//  @JsOverlay
//  public short get(int index) {
//    return Js.<JsArrayLike<Double>>uncheckedCast(this).getAt(index).shortValue();
//  }

  @Override
  @JsProperty(name = "length")
  public native int length();

//  @Override
//  @JsOverlay
//  public void set(int index, int value) {
//    Js.<JsArrayLike<Double>>uncheckedCast(this).setAt(index, (double)value);
//  }

  @Override
  public native void set(int[] array);

  @Override
  public native void set(int[] array, int offset);

  @Override
  public native void set(short[] array);

  @Override
  public native void set(short[] array, int offset);

  @Override
  public native void set(Uint8Array array);

  @Override
  public native void set(Uint8Array array, int offset);

  // this is only needed if we support an emulated impl, which i dont think we do
//  @Override
//  @JsOverlay
//  public void set(Uint8Array array, int offset) {
//    if (array instanceof Uint8ArrayNative) {
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

  @Override
  public native Uint8ArrayNative subarray(int begin);

  @Override
  public native Uint8ArrayNative subarray(int begin, int end);

}
