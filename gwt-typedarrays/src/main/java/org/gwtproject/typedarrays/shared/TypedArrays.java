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

/**
 * Factory class for various typed arrays. Behavior of all other methods is undefined if {@link
 * #isSupported()} returns false.
 *
 * <p>In client code, the various types are implemented by JavaScriptObjects, so you cannot reliable
 * use instanceof checks on any of the returned implementations.
 */
public class TypedArrays {

  /**
   * Base class of implementations for creating various typed array structures.
   *
   * <p><b>*** NOT A PUBLIC API ***</b>
   */
  // CHECKSTYLE_OFF ignore missing javadoc
  public abstract static class Impl {

    /**
     * Get the number of elements in a number of bytes, throwing an exception if it isn't an
     * integral number.
     *
     * @param byteLength
     * @param elemLength length of each element in bytes
     * @return count of elements
     * @throws IllegalArgumentException if {@code byteLength} isn't an integral multiple of {@code
     *     elemLength}
     */
    protected static int getElementCount(int byteLength, int elemLength) {
      int count = byteLength / elemLength;
      if (count * elemLength != byteLength) {
        throw new IllegalArgumentException();
      }
      return count;
    }

    public abstract ArrayBuffer createArrayBuffer(int length);

    public DataView createDataView(ArrayBuffer buffer) {
      return createDataView(buffer, 0, buffer.byteLength());
    }

    public DataView createDataView(ArrayBuffer buffer, int offset) {
      return createDataView(buffer, offset, buffer.byteLength() - offset);
    }

    public abstract DataView createDataView(ArrayBuffer buffer, int byteOffset, int byteLength);

    public abstract Float32Array createFloat32Array(ArrayBuffer buffer);

    public abstract Float32Array createFloat32Array(ArrayBuffer buffer, int byteOffset);

    public abstract Float32Array createFloat32Array(ArrayBuffer buffer, int byteOffset, int length);

    public Float32Array createFloat32Array(float[] array) {
      Float32Array result = createFloat32Array(array.length);
      result.set(array);
      return result;
    }

    public abstract Float32Array createFloat32Array(int length);

    public abstract Float64Array createFloat64Array(ArrayBuffer buffer);

    public abstract Float64Array createFloat64Array(ArrayBuffer buffer, int byteOffset);

    public abstract Float64Array createFloat64Array(ArrayBuffer buffer, int byteOffset, int length);

    public abstract Float64Array createFloat64Array(double[] array);

    public abstract Float64Array createFloat64Array(int length);

    public abstract Int16Array createInt16Array(ArrayBuffer buffer);

    public abstract Int16Array createInt16Array(ArrayBuffer buffer, int byteOffset);

    public abstract Int16Array createInt16Array(ArrayBuffer buffer, int byteOffset, int length);

    public abstract Int16Array createInt16Array(int length);

    public abstract Int16Array createInt16Array(short[] array);

    public abstract Int32Array createInt32Array(ArrayBuffer buffer);

    public abstract Int32Array createInt32Array(ArrayBuffer buffer, int byteOffset);

    public abstract Int32Array createInt32Array(ArrayBuffer buffer, int byteOffset, int length);

    public abstract Int32Array createInt32Array(int length);

    public abstract Int32Array createInt32Array(int[] array);

    public abstract Int8Array createInt8Array(ArrayBuffer buffer);

    public abstract Int8Array createInt8Array(ArrayBuffer buffer, int byteOffset);

    public abstract Int8Array createInt8Array(ArrayBuffer buffer, int byteOffset, int length);

    public abstract Int8Array createInt8Array(byte[] array);

    public abstract Int8Array createInt8Array(int length);

    public abstract Uint16Array createUint16Array(ArrayBuffer buffer);

    public abstract Uint16Array createUint16Array(ArrayBuffer buffer, int byteOffset);

    public abstract Uint16Array createUint16Array(ArrayBuffer buffer, int byteOffset, int length);

    public abstract Uint16Array createUint16Array(int length);

    public abstract Uint16Array createUint16Array(int[] array);

    public abstract Uint32Array createUint32Array(ArrayBuffer buffer);

    public abstract Uint32Array createUint32Array(ArrayBuffer buffer, int byteOffset);

    public abstract Uint32Array createUint32Array(ArrayBuffer buffer, int byteOffset, int length);

    public abstract Uint32Array createUint32Array(double[] array);

    public abstract Uint32Array createUint32Array(int length);

    public abstract Uint32Array createUint32Array(long[] array);

    public abstract Uint8Array createUint8Array(ArrayBuffer buffer);

    public abstract Uint8Array createUint8Array(ArrayBuffer buffer, int byteOffset);

    public abstract Uint8Array createUint8Array(ArrayBuffer buffer, int byteOffset, int length);

    public abstract Uint8Array createUint8Array(int length);

    public abstract Uint8Array createUint8Array(short[] array);

    public abstract Uint8ClampedArray createUint8ClampedArray(ArrayBuffer buffer);

    public abstract Uint8ClampedArray createUint8ClampedArray(ArrayBuffer buffer, int byteOffset);

    public abstract Uint8ClampedArray createUint8ClampedArray(
        ArrayBuffer buffer, int byteOffset, int length);

    public abstract Uint8ClampedArray createUint8ClampedArray(int length);

    public abstract Uint8ClampedArray createUint8ClampedArray(short[] array);

    /**
     * Check if the current environment might possibly support typed arrays.
     *
     * <p>The default implementation always returns true, and this is intended to be a static check
     * based on deffered-bound parameters.
     *
     * @return true if the current environment might possibly support typed arrays
     */
    protected boolean mightBeSupported() {
      return true;
    }

    /**
     * Check if the current environment actually does support typed arrays (including emulation).
     * There is no partial support, so if true is returned, there must be acceptable implementations
     * for all of the {@code createXXX} methods.
     *
     * @return true if the current environment actually does support typed arrays
     */
    protected abstract boolean runtimeSupportCheck();
  }
  // CHECKSTYLE_ON

  /** This class exists to keep clinit calls from littering callsites when compiled to JS. */
  private static class Instance {
    protected static final Impl impl = TypedArraysFactory.createImpl();
  }

  /**
   * Create a new {@link ArrayBuffer} of {@code length} bytes.
   *
   * @param length length of buffer in bytes
   * @return an {@link ArrayBuffer} instance
   */
  public static ArrayBuffer createArrayBuffer(int length) {
    return Instance.impl.createArrayBuffer(length);
  }

  /**
   * Create a new {@link DataView} instance on an {@link ArrayBuffer}.
   *
   * @param buffer {@link ArrayBuffer}
   * @return {@link DataView} instance
   */
  public static DataView createDataView(ArrayBuffer buffer) {
    return Instance.impl.createDataView(buffer);
  }

  /**
   * Create a new {@link DataView} instance on an {@link ArrayBuffer}, starting at an offset of
   * {@code byteOffset}.
   *
   * @param buffer {@link ArrayBuffer}
   * @param byteOffset offset into buffer
   * @return {@link DataView} instance
   */
  public static DataView createDataView(ArrayBuffer buffer, int byteOffset) {
    return Instance.impl.createDataView(buffer, byteOffset);
  }

  /**
   * Create a new {@link DataView} instance on an {@link ArrayBuffer}, starting at an offset of
   * {@code byteOffset} and continuing for {@code length} bytes.
   *
   * @param buffer {@link ArrayBuffer}
   * @param byteOffset offset into buffer
   * @param byteLength length of view in bytes
   * @return {@link DataView} instance
   */
  public static DataView createDataView(ArrayBuffer buffer, int byteOffset, int byteLength) {
    return Instance.impl.createDataView(buffer, byteOffset, byteLength);
  }

  /**
   * Create a {@link Float32Array} instance on {@code buffer}, starting at starting at the beginning
   * of the buffer and continuing to the end (which must be an integral number of elements).
   *
   * @param buffer underlying {@link ArrayBuffer}
   * @return an {@link Float32Array} instance
   */
  public static Float32Array createFloat32Array(ArrayBuffer buffer) {
    return Instance.impl.createFloat32Array(buffer);
  }

  /**
   * Create a {@link Float32Array} instance on {@code buffer}, starting at {@code byteOffset} into
   * the buffer, continuing to the end of the buffer (which must be an integral number of elements).
   *
   * @param buffer underlying {@link ArrayBuffer}
   * @param byteOffset byte offset from the start of {@code buffer}
   * @return an {@link Float32Array} instance
   */
  public static Float32Array createFloat32Array(ArrayBuffer buffer, int byteOffset) {
    return Instance.impl.createFloat32Array(buffer, byteOffset);
  }

  /**
   * Create a {@link Float32Array} instance on {@code buffer}, starting at {@code byteOffset} into
   * the buffer, continuing for {@code length} elements.
   *
   * @param buffer underlying {@link ArrayBuffer}
   * @param byteOffset byte offset from the start of {@code buffer}
   * @param length number of elements in the resulting array
   * @return an {@link Float32Array} instance
   */
  public static Float32Array createFloat32Array(ArrayBuffer buffer, int byteOffset, int length) {
    return Instance.impl.createFloat32Array(buffer, byteOffset, length);
  }

  /**
   * Create a {@link Float32Array} instance of {@code length} elements, backed by a new {@link
   * ArrayBuffer}.
   *
   * @param length size of array
   * @return a {@link Float32Array} instance
   */
  public static Float32Array createFloat32Array(int length) {
    return Instance.impl.createFloat32Array(length);
  }

  /**
   * Create a {@link Float64Array} instance on {@code buffer}, starting at starting at the beginning
   * of the buffer and continuing to the end (which must be an integral number of elements).
   *
   * <p><b>Note that Safari does not currently support Float64 Arrays!</b>
   *
   * @param buffer underlying {@link ArrayBuffer}
   * @return an {@link Float64Array} instance
   */
  public static Float64Array createFloat64Array(ArrayBuffer buffer) {
    return Instance.impl.createFloat64Array(buffer);
  }

  /**
   * Create a {@link Float64Array} instance on {@code buffer}, starting at {@code byteOffset} into
   * the buffer, continuing to the end of the buffer (which must be an integral number of elements).
   *
   * <p><b>Note that Safari does not currently support Float64 Arrays!</b>
   *
   * @param buffer underlying {@link ArrayBuffer}
   * @param byteOffset byte offset from the start of {@code buffer}
   * @return an {@link Float64Array} instance
   */
  public static Float64Array createFloat64Array(ArrayBuffer buffer, int byteOffset) {
    return Instance.impl.createFloat64Array(buffer, byteOffset);
  }

  /**
   * Create a {@link Float64Array} instance on {@code buffer}, starting at {@code byteOffset} into
   * the buffer, continuing for {@code length} elements.
   *
   * <p><b>Note that Safari does not currently support Float64 Arrays!</b>
   *
   * @param buffer underlying {@link ArrayBuffer}
   * @param byteOffset byte offset from the start of {@code buffer}
   * @param length number of elements in the resulting array
   * @return an {@link Float64Array} instance
   */
  public static Float64Array createFloat64Array(ArrayBuffer buffer, int byteOffset, int length) {
    return Instance.impl.createFloat64Array(buffer, byteOffset, length);
  }

  /**
   * Create a {@link Float64Array} instance of {@code length} elements, backed by a new {@link
   * ArrayBuffer}.
   *
   * <p><b>Note that Safari does not currently support Float64 Arrays!</b>
   *
   * @param length size of array
   * @return a {@link Float64Array} instance
   */
  public static Float64Array createFloat64Array(int length) {
    return Instance.impl.createFloat64Array(length);
  }

  /**
   * Create a {@link Int16Array} instance on {@code buffer}, starting at starting at the beginning
   * of the buffer and continuing to the end (which must be an integral number of elements).
   *
   * @param buffer underlying {@link ArrayBuffer}
   * @return an {@link Int16Array} instance
   */
  public static Int16Array createInt16Array(ArrayBuffer buffer) {
    return Instance.impl.createInt16Array(buffer);
  }

  /**
   * Create a {@link Int16Array} instance on {@code buffer}, starting at {@code byteOffset} into the
   * buffer, continuing to the end of the buffer (which must be an integral number of elements).
   *
   * @param buffer underlying {@link ArrayBuffer}
   * @param byteOffset byte offset from the start of {@code buffer}
   * @return an {@link Int16Array} instance
   */
  public static Int16Array createInt16Array(ArrayBuffer buffer, int byteOffset) {
    return Instance.impl.createInt16Array(buffer, byteOffset);
  }

  /**
   * Create a {@link Int16Array} instance on {@code buffer}, starting at {@code byteOffset} into the
   * buffer, continuing for {@code length} elements.
   *
   * @param buffer underlying {@link ArrayBuffer}
   * @param byteOffset byte offset from the start of {@code buffer}
   * @param length number of elements in the resulting array
   * @return an {@link Int16Array} instance
   */
  public static Int16Array createInt16Array(ArrayBuffer buffer, int byteOffset, int length) {
    return Instance.impl.createInt16Array(buffer, byteOffset, length);
  }

  /**
   * Create a {@link Int16Array} instance of {@code length} elements, backed by a new {@link
   * ArrayBuffer}.
   *
   * @param length size of array
   * @return a {@link Int16Array} instance
   */
  public static Int16Array createInt16Array(int length) {
    return Instance.impl.createInt16Array(length);
  }

  /**
   * Create a {@link Int32Array} instance on {@code buffer}, starting at starting at the beginning
   * of the buffer and continuing to the end (which must be an integral number of elements).
   *
   * @param buffer underlying {@link ArrayBuffer}
   * @return an {@link Int32Array} instance
   */
  public static Int32Array createInt32Array(ArrayBuffer buffer) {
    return Instance.impl.createInt32Array(buffer);
  }

  /**
   * Create a {@link Int32Array} instance on {@code buffer}, starting at {@code byteOffset} into the
   * buffer, continuing to the end of the buffer (which must be an integral number of elements).
   *
   * @param buffer underlying {@link ArrayBuffer}
   * @param byteOffset byte offset from the start of {@code buffer}
   * @return an {@link Int32Array} instance
   */
  public static Int32Array createInt32Array(ArrayBuffer buffer, int byteOffset) {
    return Instance.impl.createInt32Array(buffer, byteOffset);
  }

  /**
   * Create a {@link Int32Array} instance on {@code buffer}, starting at {@code byteOffset} into the
   * buffer, continuing for {@code length} elements.
   *
   * @param buffer underlying {@link ArrayBuffer}
   * @param byteOffset byte offset from the start of {@code buffer}
   * @param length number of elements in the resulting array
   * @return an {@link Int32Array} instance
   */
  public static Int32Array createInt32Array(ArrayBuffer buffer, int byteOffset, int length) {
    return Instance.impl.createInt32Array(buffer, byteOffset, length);
  }

  /**
   * Create a {@link Int32Array} instance of {@code length} elements, backed by a new {@link
   * ArrayBuffer}.
   *
   * @param length size of array
   * @return a {@link Int32Array} instance
   */
  public static Int32Array createInt32Array(int length) {
    return Instance.impl.createInt32Array(length);
  }

  /**
   * Create a {@link Int8Array} instance on {@code buffer}, starting at starting at the beginning of
   * the buffer and continuing to the end.
   *
   * @param buffer underlying {@link ArrayBuffer}
   * @return an {@link Int8Array} instance
   */
  public static Int8Array createInt8Array(ArrayBuffer buffer) {
    return Instance.impl.createInt8Array(buffer);
  }

  /**
   * Create a {@link Int8Array} instance on {@code buffer}, starting at {@code byteOffset} into the
   * buffer, continuing to the end of the buffer (which must be an integral number of elements).
   *
   * @param buffer underlying {@link ArrayBuffer}
   * @param byteOffset byte offset from the start of {@code buffer}
   * @return an {@link Int8Array} instance
   */
  public static Int8Array createInt8Array(ArrayBuffer buffer, int byteOffset) {
    return Instance.impl.createInt8Array(buffer, byteOffset);
  }

  /**
   * Create a {@link Int8Array} instance on {@code buffer}, starting at {@code byteOffset} into the
   * buffer, continuing for {@code length} elements.
   *
   * @param buffer underlying {@link ArrayBuffer}
   * @param byteOffset byte offset from the start of {@code buffer}
   * @param length number of elements in the resulting array
   * @return an {@link Int8Array} instance
   */
  public static Int8Array createInt8Array(ArrayBuffer buffer, int byteOffset, int length) {
    return Instance.impl.createInt8Array(buffer, byteOffset, length);
  }

  /**
   * Create a {@link Int8Array} instance of {@code length} elements, backed by a new {@link
   * ArrayBuffer}.
   *
   * @param length size of array
   * @return a {@link Int8Array} instance
   */
  public static Int8Array createInt8Array(int length) {
    return Instance.impl.createInt8Array(length);
  }

  /**
   * Create a {@link Uint16Array} instance on {@code buffer}, starting at starting at the beginning
   * of the buffer and continuing to the end (which must be an integral number of elements).
   *
   * @param buffer underlying {@link ArrayBuffer}
   * @return an {@link Uint16Array} instance
   */
  public static Uint16Array createUint16Array(ArrayBuffer buffer) {
    return Instance.impl.createUint16Array(buffer);
  }

  /**
   * Create a {@link Uint16Array} instance on {@code buffer}, starting at {@code byteOffset} into
   * the buffer, continuing to the end of the buffer (which must be an integral number of elements).
   *
   * @param buffer underlying {@link ArrayBuffer}
   * @param byteOffset byte offset from the start of {@code buffer}
   * @return an {@link Uint16Array} instance
   */
  public static Uint16Array createUint16Array(ArrayBuffer buffer, int byteOffset) {
    return Instance.impl.createUint16Array(buffer, byteOffset);
  }

  /**
   * Create a {@link Uint16Array} instance on {@code buffer}, starting at {@code byteOffset} into
   * the buffer, continuing for {@code length} elements.
   *
   * @param buffer underlying {@link ArrayBuffer}
   * @param byteOffset byte offset from the start of {@code buffer}
   * @param length number of elements in the resulting array
   * @return an {@link Uint16Array} instance
   */
  public static Uint16Array createUint16Array(ArrayBuffer buffer, int byteOffset, int length) {
    return Instance.impl.createUint16Array(buffer, byteOffset, length);
  }

  /**
   * Create a {@link Uint16Array} instance of {@code length} elements, backed by a new {@link
   * ArrayBuffer}.
   *
   * @param length size of array
   * @return a {@link Uint16Array} instance
   */
  public static Uint16Array createUint16Array(int length) {
    return Instance.impl.createUint16Array(length);
  }

  /**
   * Create a {@link Uint32Array} instance on {@code buffer}, starting at starting at the beginning
   * of the buffer and continuing to the end (which must be an integral number of elements).
   *
   * @param buffer underlying {@link ArrayBuffer}
   * @return an {@link Uint32Array} instance
   */
  public static Uint32Array createUint32Array(ArrayBuffer buffer) {
    return Instance.impl.createUint32Array(buffer);
  }

  /**
   * Create a {@link Uint32Array} instance on {@code buffer}, starting at {@code byteOffset} into
   * the buffer, continuing to the end of the buffer (which must be an integral number of elements).
   *
   * @param buffer underlying {@link ArrayBuffer}
   * @param byteOffset byte offset from the start of {@code buffer}
   * @return an {@link Uint32Array} instance
   */
  public static Uint32Array createUint32Array(ArrayBuffer buffer, int byteOffset) {
    return Instance.impl.createUint32Array(buffer, byteOffset);
  }

  /**
   * Create a {@link Uint32Array} instance on {@code buffer}, starting at {@code byteOffset} into
   * the buffer, continuing for {@code length} elements.
   *
   * @param buffer underlying {@link ArrayBuffer}
   * @param byteOffset byte offset from the start of {@code buffer}
   * @param length number of elements in the resulting array
   * @return an {@link Uint32Array} instance
   */
  public static Uint32Array createUint32Array(ArrayBuffer buffer, int byteOffset, int length) {
    return Instance.impl.createUint32Array(buffer, byteOffset, length);
  }

  /**
   * Create a {@link Uint32Array} instance of {@code length} elements, backed by a new {@link
   * ArrayBuffer}.
   *
   * @param length size of array
   * @return a {@link Uint32Array} instance
   */
  public static Uint32Array createUint32Array(int length) {
    return Instance.impl.createUint32Array(length);
  }

  /**
   * Create a {@link Uint8Array} instance on {@code buffer}, starting at starting at the beginning
   * of the buffer and continuing to the end (which must be an integral number of elements).
   *
   * @param buffer underlying {@link ArrayBuffer}
   * @return an {@link Uint8Array} instance
   */
  public static Uint8Array createUint8Array(ArrayBuffer buffer) {
    return Instance.impl.createUint8Array(buffer);
  }

  /**
   * Create a {@link Uint8Array} instance on {@code buffer}, starting at {@code byteOffset} into the
   * buffer, continuing to the end of the buffer.
   *
   * @param buffer underlying {@link ArrayBuffer}
   * @param byteOffset byte offset from the start of {@code buffer}
   * @return an {@link Uint8Array} instance
   */
  public static Uint8Array createUint8Array(ArrayBuffer buffer, int byteOffset) {
    return Instance.impl.createUint8Array(buffer, byteOffset);
  }

  /**
   * Create a {@link Uint8Array} instance on {@code buffer}, starting at {@code byteOffset} into the
   * buffer, continuing for {@code length} elements.
   *
   * @param buffer underlying {@link ArrayBuffer}
   * @param byteOffset byte offset from the start of {@code buffer}
   * @param length number of elements in the resulting array
   * @return an {@link Uint8Array} instance
   */
  public static Uint8Array createUint8Array(ArrayBuffer buffer, int byteOffset, int length) {
    return Instance.impl.createUint8Array(buffer, byteOffset, length);
  }

  /**
   * Create a {@link Uint8Array} instance of {@code length} elements, backed by a new {@link
   * ArrayBuffer}.
   *
   * @param length size of array
   * @return a {@link Uint8Array} instance
   */
  public static Uint8Array createUint8Array(int length) {
    return Instance.impl.createUint8Array(length);
  }

  /**
   * Create a {@link Uint8ClampedArray} instance on {@code buffer}, starting at starting at the
   * beginning of the buffer and continuing to the end.
   *
   * @param buffer underlying {@link ArrayBuffer}
   * @return an {@link Uint8ClampedArray} instance
   */
  public static Uint8ClampedArray createUint8ClampedArray(ArrayBuffer buffer) {
    return Instance.impl.createUint8ClampedArray(buffer, 0, buffer.byteLength());
  }

  /**
   * Create a {@link Uint8ClampedArray} instance on {@code buffer}, starting at {@code byteOffset}
   * into the buffer, continuing to the end of the buffer.
   *
   * @param buffer underlying {@link ArrayBuffer}
   * @param byteOffset byte offset from the start of {@code buffer}
   * @return an {@link Uint8ClampedArray} instance
   */
  public static Uint8ClampedArray createUint8ClampedArray(ArrayBuffer buffer, int byteOffset) {
    return Instance.impl.createUint8ClampedArray(buffer, byteOffset);
  }

  /**
   * Create a {@link Uint8ClampedArray} instance on {@code buffer}, starting at {@code byteOffset}
   * into the buffer, continuing for {@code length} elements.
   *
   * @param buffer underlying {@link ArrayBuffer}
   * @param byteOffset byte offset from the start of {@code buffer}
   * @param length number of elements in the resulting array
   * @return an {@link Uint8ClampedArray} instance
   */
  public static Uint8ClampedArray createUint8ClampedArray(
      ArrayBuffer buffer, int byteOffset, int length) {
    return Instance.impl.createUint8ClampedArray(buffer, byteOffset, length);
  }

  /**
   * Create a {@link Uint8ClampedArray} instance of {@code length} elements, backed by a new {@link
   * ArrayBuffer}.
   *
   * @param length size of array
   * @return a {@link Uint8ClampedArray} instance
   */
  public static Uint8ClampedArray createUint8ClampedArray(int length) {
    return Instance.impl.createUint8ClampedArray(length);
  }

  /**
   * Check if the current environment supports typed arrays. Behavior of the various {@code
   * createXXX} methods is undefined if this method returns {@code false}, but will typically throw
   * some exception.
   *
   * @return true if typed arrays are support.
   */
  public static boolean isSupported() {
    return Instance.impl.mightBeSupported() && Instance.impl.runtimeSupportCheck();
  }
}
