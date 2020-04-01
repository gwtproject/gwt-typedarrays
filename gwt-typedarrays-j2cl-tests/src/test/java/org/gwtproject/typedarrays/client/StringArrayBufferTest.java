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

import static org.junit.Assert.assertEquals;

import com.google.j2cl.junit.apt.J2clTestInput;
import org.gwtproject.typedarrays.shared.ArrayBuffer;
import org.gwtproject.typedarrays.shared.TypedArrays;
import org.gwtproject.typedarrays.shared.Uint8Array;
import org.junit.Test;

/** Test converting to/from a string encoding of an array buffer. */
@J2clTestInput(StringArrayBufferTest.class)
public class StringArrayBufferTest {

  @Test
  public void testFromString() {
    if (!TypedArrays.isSupported()) {
      // TODO: some way of showing test as skipped in this case?
      return;
    }
    String str = "\u0001\u0000\u0080\u0081";
    ArrayBuffer buf = JsUtils.arrayBufferFromString(str);
    Uint8Array view = TypedArrays.createUint8Array(buf);
    assertEquals(4, buf.byteLength());
    assertEquals(1, view.get(0));
    assertEquals(0, view.get(1));
    assertEquals(128, view.get(2));
    assertEquals(129, view.get(3));
  }

  @Test
  public void testToString() {
    if (!TypedArrays.isSupported()) {
      // TODO: some way of showing test as skipped in this case?
      return;
    }
    Uint8Array view = TypedArrays.createUint8Array(4);
    view.set(0, 1);
    view.set(1, 0);
    view.set(2, 128);
    view.set(3, 129);
    String str = JsUtils.stringFromArrayBuffer(view.buffer());
    assertEquals(4, str.length());
    assertEquals(1, str.charAt(0));
    assertEquals(0, str.charAt(1));
    assertEquals(128, str.charAt(2));
    assertEquals(129, str.charAt(3));
  }

  // Tests which actually use unicode
  //  public void testFromString() {
  //    if (!TypedArrays.isSupported()) {
  //      // TODO: some way of showing test as skipped in this case?
  //      return;
  //    }
  //    String str = "\u0080 !\"|}~漢字\uD841\uDF0E";
  //    ArrayBuffer buf = JsUtils.arrayBufferFromString(str);
  //    Uint8Array view = TypedArrays.createUint8Array(buf);
  //    assertEquals(18, buf.byteLength());
  //    assertEquals(0xC2, view.get(0));
  //    assertEquals(0x80, view.get(1));
  //    assertEquals(0x20, view.get(2));
  //    assertEquals(0x21, view.get(3));
  //    assertEquals(0x22, view.get(4));
  //    assertEquals(0x7C, view.get(5));
  //    assertEquals(0x7D, view.get(6));
  //    assertEquals(0x7E, view.get(7));
  //    assertEquals(0xE6, view.get(8));
  //    assertEquals(0xBC, view.get(9));
  //    assertEquals(0xA2, view.get(10));
  //    assertEquals(0xE5, view.get(11));
  //    assertEquals(0xAD, view.get(12));
  //    assertEquals(0x97, view.get(13));
  //    assertEquals(0xF0, view.get(14));
  //    assertEquals(0xA0, view.get(15));
  //    assertEquals(0x9C, view.get(16));
  //    assertEquals(0x8E, view.get(17));
  //  }
  //
  //  public void testToString() {
  //    if (!TypedArrays.isSupported()) {
  //      // TODO: some way of showing test as skipped in this case?
  //      return;
  //    }
  //    Uint8Array view = TypedArrays.createUint8Array(18);
  //    view.set(0, 0xC2);
  //    view.set(1, 0x80);
  //    view.set(2, 0x20);
  //    view.set(3, 0x21);
  //    view.set(4, 0x22);
  //    view.set(5, 0x7C);
  //    view.set(6, 0x7D);
  //    view.set(7, 0x7E);
  //    view.set(8, 0xE6);
  //    view.set(9, 0xBC);
  //    view.set(10, 0xA2);
  //    view.set(11, 0xE5);
  //    view.set(12, 0xAD);
  //    view.set(13, 0x97);
  //    view.set(14, 0xF0);
  //    view.set(15, 0xA0);
  //    view.set(16, 0x9C);
  //    view.set(17, 0x8E);
  //    String str = JsUtils.stringFromArrayBuffer(view.buffer());
  //    assertEquals(11, str.length());
  //    assertEquals(0x80, str.charAt(0));
  //    assertEquals("\u0080", str.substring(0, 1));
  //
  //    assertEquals(0x20, str.charAt(1));
  //    assertEquals(0x21, str.charAt(2));
  //    assertEquals(0x22, str.charAt(3));
  //    assertEquals(" !\"", str.substring(1, 4));
  //
  //    assertEquals(0x7C, str.charAt(4));
  //    assertEquals(0x7D, str.charAt(5));
  //    assertEquals(0x7E, str.charAt(6));
  //    assertEquals("|}~", str.substring(4, 7));
  //
  ////    assertEquals(0x____, str.charAt(7));
  ////    assertEquals(0x____, str.charAt(8));
  //    assertEquals("漢字", str.substring(7, 9));
  //
  ////    assertEquals(0x____, str.charAt(9));
  ////    assertEquals(0x____, str.charAt(10));
  //    assertEquals("\uD841\uDF0E", str.substring(9, 11));
  //  }
}
