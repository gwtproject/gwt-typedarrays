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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import com.google.j2cl.junit.apt.J2clTestInput;
import org.junit.Test;

/** Test {@link Uint8ClampedArray} implementations. */
@J2clTestInput(Uint8ClampedArrayTest.class)
public class Uint8ClampedArrayTest {

  private static final int BYTES_PER_ELEMENT = Uint8ClampedArray.BYTES_PER_ELEMENT;

  protected void setFromJavaIntArray(Uint8ClampedArray array, int offset) {
    int[] values =
        new int[] {
          1, 2, 256, -1,
        };
    array.set(values, offset);
  }

  protected void validateArrayContents(Uint8ClampedArray array, int offset) {
    for (int i = 0; i < offset; ++i) {
      assertEquals("index " + i, 0, array.get(i));
    }
    assertEquals("Index " + offset, 1, array.get(offset++));
    assertEquals("Index " + offset, 2, array.get(offset++));
    assertEquals("Index " + offset, 255, array.get(offset++));
    assertEquals("Index " + offset, 0, array.get(offset++));
    for (int i = offset + 4; i < array.length(); ++i) {
      assertEquals("index " + i, 0, array.get(i));
    }
  }

  @Test
  public void testBasic() {
    if (!TypedArrays.isSupported()) {
      // TODO: some way of showing test as skipped in this case?
      return;
    }
    int byteLen = 40;
    ArrayBuffer buf = TypedArrays.createArrayBuffer(byteLen);
    assertEquals(byteLen, buf.byteLength());
    DataView view = TypedArrays.createDataView(buf);
    Uint8ClampedArray array = TypedArrays.createUint8ClampedArray(buf);
    assertSame(buf, array.buffer());
    assertEquals(byteLen, array.byteLength());
    assertEquals(0, array.byteOffset());
    int len = byteLen / BYTES_PER_ELEMENT;
    assertEquals(len, array.length());

    // check that it is initialized to zeros
    for (int i = 0; i < len; ++i) {
      assertEquals(0, array.get(i));
    }

    // store some data
    for (int i = 0; i < len; ++i) {
      array.set(i, 0x20 + i);
    }

    // check the underlying buffer
    for (int i = 0; i < len; ++i) {
      assertEquals(0x20 + i, view.getUint8(i));
    }

    // check the underlying buffer after modifying
    array.set(0, -1);
    array.set(1, 256);
    assertEquals(0, view.getInt8(0));
    assertEquals(-1, view.getInt8(1)); // 0xFF == -1 as a byte
  }

  @Test
  public void testSetFromJavaArray() {
    if (!TypedArrays.isSupported()) {
      // TODO: some way of showing test as skipped in this case?
      return;
    }
    ArrayBuffer buf = TypedArrays.createArrayBuffer(6);
    Uint8ClampedArray array = TypedArrays.createUint8ClampedArray(buf);
    setFromJavaIntArray(array, 0);
    validateArrayContents(array, 0);

    // On Chrome, there is a bug where the first offset is ignored, so this test will fail if there
    // isn't a test with offset 0 first.
    // See http://code.google.com/p/chromium/issues/detail?id=109785
    buf = TypedArrays.createArrayBuffer(6);
    array = TypedArrays.createUint8ClampedArray(buf);
    setFromJavaIntArray(array, 1);
    validateArrayContents(array, 1);
  }
}
