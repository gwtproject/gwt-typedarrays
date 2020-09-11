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
 * @see <a
 *     href="http://www.khronos.org/registry/typedarray/specs/latest/#8">http://www.khronos.org/registry/typedarray/specs/latest/#8</a>
 */
@JsType(isNative = true, name = "DataView", namespace = JsPackage.GLOBAL)
public interface DataView extends ArrayBufferView {

  /**
   * @param byteOffset the offset in bytes from the start of the view to the data to read
   * @return a signed 32 bit float number
   */
  float getFloat32(int byteOffset);

  /**
   * @param byteOffset the offset in bytes from the start of the view to the data to read
   * @param littleEndian indicates if the data is stored in little endian or big endian format
   * @return a signed 32 bit float number
   */
  float getFloat32(int byteOffset, boolean littleEndian);

  /**
   * @param byteOffset the offset in bytes from the start of the view to the data to read
   * @return a signed 64 bit float number
   */
  double getFloat64(int byteOffset);

  /**
   * @param byteOffset the offset in bytes from the start of the view to the data to read
   * @param littleEndian indicates if the data is stored in little endian or big endian format
   * @return a signed 64 bit float number
   */
  double getFloat64(int byteOffset, boolean littleEndian);

  /**
   * @param byteOffset the offset in bytes from the start of the view to the data to read
   * @return a signed 16 bit integer number
   */
  short getInt16(int byteOffset);

  /**
   * @param byteOffset the offset in bytes from the start of the view to the data to read
   * @param littleEndian indicates if the data is stored in little endian or big endian format
   * @return a signed 16 bit integer number
   */
  short getInt16(int byteOffset, boolean littleEndian);

  /**
   * @param byteOffset the offset in bytes from the start of the view to the data to read
   * @return a signed 32 bit integer number
   */
  int getInt32(int byteOffset);

  /**
   * @param byteOffset the offset in bytes from the start of the view to the data to read
   * @param littleEndian indicates if the data is stored in little endian or big endian format
   * @return a signed 32 bit integer number
   */
  int getInt32(int byteOffset, boolean littleEndian);

  /**
   * @param byteOffset the offset in bytes from the start of the view to the data to read
   * @return a signed 8 bit integer number
   */
  byte getInt8(int byteOffset);

  /**
   * @param byteOffset the offset in bytes from the start of the view to the data to read
   * @return an unsigned 16 bit integer number
   */
  int getUint16(int byteOffset);

  /**
   * @param byteOffset the offset in bytes from the start of the view to the data to read
   * @param littleEndian indicates if the data is stored in little endian or big endian format
   * @return an unsigned 16 bit integer number
   */
  int getUint16(int byteOffset, boolean littleEndian);

  /**
   * @param byteOffset the offset in bytes from the start of the view to the data to read
   * @return an unsigned 32 bit integer number as a long
   */
  @JsOverlay
  default long getUint32(int byteOffset) {
    return (long) getUint32AsDouble(byteOffset);
  }

  /**
   * @param byteOffset the offset in bytes from the start of the view to the data to read
   * @param littleEndian indicates if the data is stored in little endian or big endian format
   * @return an unsigned 32 bit integer number as a long
   */
  @JsOverlay
  default long getUint32(int byteOffset, boolean littleEndian) {
    return (long) getUint32AsDouble(byteOffset, littleEndian);
  }

  /**
   * @param byteOffset the offset in bytes from the start of the view to the data to read
   * @return unsigned 32-bit int as a double
   */
  @JsMethod(name = "getUint32")
  double getUint32AsDouble(int byteOffset);

  /**
   * @param byteOffset the offset in bytes from the start of the view to the data to read
   * @param littleEndian indicates if the data is stored in little endian or big endian format
   * @return unsigned 32-bit int as a double
   */
  @JsMethod(name = "getUint32")
  double getUint32AsDouble(int byteOffset, boolean littleEndian);

  /**
   * @param byteOffset the offset in bytes from the start of the view to the data to read
   * @return an unsigned 8 bit integer number
   */
  short getUint8(int byteOffset);

  /**
   * @param byteOffset the offset in bytes from the start of the view to the data to write
   * @param value the value to set
   */
  void setFloat32(int byteOffset, float value);

  /**
   * @param byteOffset the offset in bytes from the start of the view to the data to write
   * @param value the value to set
   * @param littleEndian indicates if the data should be stored in little endian or big endian
   *     format
   */
  void setFloat32(int byteOffset, float value, boolean littleEndian);

  /**
   * @param byteOffset the offset in bytes from the start of the view to the data to write
   * @param value the value to set
   */
  void setFloat64(int byteOffset, double value);

  /**
   * @param byteOffset the offset in bytes from the start of the view to the data to write
   * @param value the value to set
   * @param littleEndian indicates if the data should be stored in little endian or big endian
   *     format
   */
  void setFloat64(int byteOffset, double value, boolean littleEndian);

  /**
   * @param byteOffset the offset in bytes from the start of the view to the data to write
   * @param value the value to set
   */
  void setInt16(int byteOffset, int value);

  /**
   * @param byteOffset the offset in bytes from the start of the view to the data to write
   * @param value the value to set
   * @param littleEndian indicates if the data should be stored in little endian or big endian
   *     format
   */
  void setInt16(int byteOffset, int value, boolean littleEndian);

  /**
   * @param byteOffset the offset in bytes from the start of the view to the data to write
   * @param value the value to set
   */
  void setInt32(int byteOffset, int value);

  /**
   * @param byteOffset the offset in bytes from the start of the view to the data to write
   * @param value the value to set
   * @param littleEndian indicates if the data should be stored in little endian or big endian
   *     format
   */
  void setInt32(int byteOffset, int value, boolean littleEndian);

  /**
   * @param byteOffset the offset in bytes from the start of the view to the data to write
   * @param value the value to set
   */
  void setInt8(int byteOffset, int value);

  /**
   * @param byteOffset the offset in bytes from the start of the view to the data to write
   * @param value the value to set
   */
  void setUint16(int byteOffset, int value);

  /**
   * @param byteOffset the offset in bytes from the start of the view to the data to write
   * @param value the value to set
   * @param littleEndian indicates if the data should be stored in little endian or big endian
   *     format
   */
  void setUint16(int byteOffset, int value, boolean littleEndian);

  /**
   * @param byteOffset the offset in bytes from the start of the view to the data to write
   * @param value the value to set
   */
  @JsOverlay
  default void setUint32(int byteOffset, long value) {
    // overlay required to translate emulated long to a double
    setUint32FromDouble(byteOffset, value);
  }

  /**
   * @param byteOffset the offset in bytes from the start of the view to the data to write
   * @param value the value to set
   * @param littleEndian indicates if the data should be stored in little endian or big endian
   *     format
   */
  @JsOverlay
  default void setUint32(int byteOffset, long value, boolean littleEndian) {
    // overlay required to translate emulated long to a double
    setUint32FromDouble(byteOffset, value, littleEndian);
  }
  /**
   * @param byteOffset the offset in bytes from the start of the view to the data to write
   * @param value the value to set
   */
  @JsMethod(name = "setUint32")
  void setUint32FromDouble(int byteOffset, double value);

  /**
   * @param byteOffset the offset in bytes from the start of the view to the data to write
   * @param value the value to set
   * @param littleEndian indicates if the data should be stored in little endian or big endian
   *     format
   */
  @JsMethod(name = "setUint32")
  void setUint32FromDouble(int byteOffset, double value, boolean littleEndian);

  /**
   * @param byteOffset the offset in bytes from the start of the view to the data to write
   * @param value the value to set
   */
  void setUint8(int byteOffset, int value);
}
