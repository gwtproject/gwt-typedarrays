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
package org.gwtproject.typedarrays.shared;

import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * A view representing an {@link ArrayBuffer} as heterogeneous values.
 * 
 * {@link "http://www.khronos.org/registry/typedarray/specs/latest/#8"}
 */
@JsType(isNative = true, name = "DataView", namespace = JsPackage.GLOBAL)
public interface DataView extends ArrayBufferView {

  /**
   * @param byteOffset
   * @return
   */
  float getFloat32(int byteOffset);

  /**
   * @param byteOffset
   * @param littleEndian
   * @return
   */
  float getFloat32(int byteOffset, boolean littleEndian);

  /**
   * @param byteOffset
   * @return
   */
  double getFloat64(int byteOffset);

  /**
   * @param byteOffset
   * @param littleEndian
   * @return
   */
  double getFloat64(int byteOffset, boolean littleEndian);

  /**
   * @param byteOffset
   * @return
   */
  short getInt16(int byteOffset);

  /**
   * @param byteOffset
   * @param littleEndian
   * @return
   */
  short getInt16(int byteOffset, boolean littleEndian);

  /**
   * @param byteOffset
   * @return
   */
  int getInt32(int byteOffset);

  /**
   * @param byteOffset
   * @param littleEndian
   * @return
   */
  int getInt32(int byteOffset, boolean littleEndian);

  /**
   * @param byteOffset
   * @return
   */
  byte getInt8(int byteOffset);

  /**
   * @param byteOffset
   * @return
   */
  int getUint16(int byteOffset);

  /**
   * @param byteOffset
   * @param littleEndian
   * @return
   */
  int getUint16(int byteOffset, boolean littleEndian);

  /**
   * @param byteOffset
   * @return
   */
  @JsOverlay
  default long getUint32(int byteOffset) {
    return (long) getUint32AsDouble(byteOffset);
  }

  /**
   * @param byteOffset
   * @param littleEndian
   * @return
   */
  @JsOverlay
  default long getUint32(int byteOffset, boolean littleEndian) {
    return (long) getUint32AsDouble(byteOffset, littleEndian);
  }

  /**
   * @param byteOffset
   * @return unsigned 32-bit int as a double
   */
  @JsMethod(name = "getUint32")
  double getUint32AsDouble(int byteOffset);

  /**
   * @param byteOffset
   * @param littleEndian
   * @return unsigned 32-bit int as a double
   */
  @JsMethod(name = "getUint32")
  double getUint32AsDouble(int byteOffset, boolean littleEndian);

  /**
   * @param byteOffset
   * @return
   */
  short getUint8(int byteOffset);

  /**
   * @param byteOffset
   * @param value
   */
  void setFloat32(int byteOffset, float value);

  /**
   * @param byteOffset
   * @param value
   * @param littleEndian
   */
  void setFloat32(int byteOffset, float value, boolean littleEndian);

  /**
   * @param byteOffset
   * @param value
   */
  void setFloat64(int byteOffset, double value);

  /**
   * @param byteOffset
   * @param value
   * @param littleEndian
   */
  void setFloat64(int byteOffset, double value, boolean littleEndian);

  /**
   * @param byteOffset
   * @param value
   */
  void setInt16(int byteOffset, int value);

  /**
   * @param byteOffset
   * @param value
   * @param littleEndian
   */
  void setInt16(int byteOffset, int value, boolean littleEndian);

  /**
   * @param byteOffset
   * @param value
   */
  void setInt32(int byteOffset, int value);

  /**
   * @param byteOffset
   * @param value
   * @param littleEndian
   */
  void setInt32(int byteOffset, int value, boolean littleEndian);

  /**
   * @param byteOffset
   * @param value
   */
  void setInt8(int byteOffset, int value);

  /**
   * @param byteOffset
   * @param value
   */
  void setUint16(int byteOffset, int value);

  /**
   * @param byteOffset
   * @param value
   * @param littleEndian
   */
  void setUint16(int byteOffset, int value, boolean littleEndian);

  /**
   * @param byteOffset
   * @param value
   */
  @JsOverlay
  default void setUint32(int byteOffset, long value) {
    // overlay required to translate emulated long to a double
    setUint32FromDouble(byteOffset, value);
  }

  /**
   * @param byteOffset
   * @param value
   * @param littleEndian
   */
  @JsOverlay
  default void setUint32(int byteOffset, long value, boolean littleEndian) {
    // overlay required to translate emulated long to a double
    setUint32FromDouble(byteOffset, value, littleEndian);
  }
  /**
   * @param byteOffset
   * @param value
   */
  @JsMethod(name = "setUint32")
  void setUint32FromDouble(int byteOffset, double value);

  /**
   * @param byteOffset
   * @param value
   * @param littleEndian
   */
  @JsMethod(name = "setUint32")
  void setUint32FromDouble(int byteOffset, double value, boolean littleEndian);

  /**
   * @param byteOffset
   * @param i
   */
  void setUint8(int byteOffset, int i);
}
