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
import org.gwtproject.typedarrays.shared.DataView;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * JS native implementation of {@link DataView}.
 */
@JsType(isNative = true, name = "DataView", namespace = JsPackage.GLOBAL)
public final class DataViewNative extends ArrayBufferViewNative implements DataView {

  /**
   * @param buffer
   * @return a {@link DataView} instance
   */
  @JsOverlay
  public static DataView create(ArrayBuffer buffer) {
    return new DataViewNative(buffer);
  }
  /**
   * @param buffer
   * @return a {@link DataView} instance
   */
  public DataViewNative(ArrayBuffer buffer) {
  }

  /**
   * @param buffer
   * @param byteOffset
   * @return a {@link DataView} instance
   */
  @JsOverlay
  public static DataView create(ArrayBuffer buffer, int byteOffset) {
    return new DataViewNative(buffer, byteOffset);
  }
  /**
   * @param buffer
   * @param byteOffset
   * @return a {@link DataView} instance
   */
  public DataViewNative(ArrayBuffer buffer, int byteOffset) {
  }

  /**
   * @param buffer
   * @param byteOffset
   * @param byteLength
   * @return a {@link DataView} instance
   */
  @JsOverlay
  public static DataView create(ArrayBuffer buffer, int byteOffset,
      int byteLength) {
    return new DataViewNative(buffer, byteOffset, byteLength);
  }
  /**
   * @param buffer
   * @param byteOffset
   * @param byteLength
   * @return a {@link DataView} instance
   */
  public DataViewNative(ArrayBuffer buffer, int byteOffset,
      int byteLength) {
  }

  @Override
  public native float getFloat32(int byteOffset);

  @Override
  public native float getFloat32(int byteOffset, boolean littleEndian);

  @Override
  public native double getFloat64(int byteOffset);

  @Override
  public native double getFloat64(int byteOffset, boolean littleEndian);

  @Override
  public native short getInt16(int byteOffset);

  @Override
  public native short getInt16(int byteOffset, boolean littleEndian);

  @Override
  public native int getInt32(int byteOffset);

  @Override
  public native int getInt32(int byteOffset, boolean littleEndian);

  @Override
  public native byte getInt8(int byteOffset);

  @Override
  public native int getUint16(int byteOffset);

  @Override
  public native int getUint16(int byteOffset, boolean littleEndian);

//  @Override
//  @JsOverlay
//  public long getUint32(int byteOffset) {
//    return (long) getUint32AsDouble(byteOffset);
//  }
//
//  @Override
//  @JsOverlay
//  public long getUint32(int byteOffset, boolean littleEndian) {
//    return (long) getUint32AsDouble(byteOffset, littleEndian);
//  }

  @Override
  @JsMethod(name = "getUint32")
  public native double getUint32AsDouble(int byteOffset);

  @Override
  @JsMethod(name = "getUint32")
  public native double getUint32AsDouble(int byteOffset, boolean littleEndian);

  @Override
  public native short getUint8(int byteOffset);

  @Override
  public native void setFloat32(int byteOffset, float value);

  @Override
  public native void setFloat32(int byteOffset, float value, boolean littleEndian);

  @Override
  public native void setFloat64(int byteOffset, double value);

  @Override
  public native void setFloat64(int byteOffset, double value, boolean littleEndian);

  @Override
  public native void setInt16(int byteOffset, int value);

  @Override
  public native void setInt16(int byteOffset, int value, boolean littleEndian);

  @Override
  public native void setInt32(int byteOffset, int value);

  @Override
  public native void setInt32(int byteOffset, int value, boolean littleEndian);

  @Override
  public native void setInt8(int byteOffset, int value);

  @Override
  public native void setUint16(int byteOffset, int value);

  @Override
  public native void setUint16(int byteOffset, int value, boolean littleEndian);

//  @Override
//  @JsOverlay
//  public void setUint32(int byteOffset, long value) {
//    setUint32FromDouble(byteOffset, value);
//  }
//
//  @Override
//  @JsOverlay
//  public void setUint32(int byteOffset, long value, boolean littleEndian) {
//    setUint32FromDouble(byteOffset, value, littleEndian);
//  }

  @Override
  @JsMethod(name = "setUint32")
  public native void setUint32FromDouble(int byteOffset, double value);

  @Override
  @JsMethod(name = "setUint32")
  public native void setUint32FromDouble(int byteOffset, double value, boolean littleEndian);

  @Override
  public native void setUint8(int byteOffset, int value);

}
