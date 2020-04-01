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

import com.google.j2cl.junit.apt.J2clTestInput;
import elemental2.core.JsArray;
import jsinterop.base.Js;
import org.gwtproject.core.client.JsArrayInteger;
import org.gwtproject.typedarrays.shared.ArrayBuffer;
import org.gwtproject.typedarrays.shared.Int8Array;
import org.gwtproject.typedarrays.shared.Int8ArrayTest;
import org.gwtproject.typedarrays.shared.TypedArrays;
import org.junit.Test;

/** Test client {@link Int8Array} implementations. */
@J2clTestInput(GwtInt8ArrayTest.class)
public class GwtInt8ArrayTest extends Int8ArrayTest {

  private static JsArrayInteger getJsoArray() {
    return Js.cast(JsArray.of(1.0, 2.0, 256.0, -1.0));
  }

  @Test
  public void testCreateJsArray() {
    if (!TypedArrays.isSupported()) {
      // TODO: some way of showing test as skipped in this case?
      return;
    }
    JsArrayInteger src = getJsoArray();
    Int8Array array = JsUtils.createInt8Array(src);
    validateArrayContents(array, 0);
  }

  @Test
  public void testSetJsArray() {
    if (!TypedArrays.isSupported()) {
      // TODO: some way of showing test as skipped in this case?
      return;
    }
    ArrayBuffer buf = TypedArrays.createArrayBuffer(12);
    Int8Array array = TypedArrays.createInt8Array(buf);
    setFromJsArray(array, 0);
    validateArrayContents(array, 0);

    buf = TypedArrays.createArrayBuffer(12);
    array = TypedArrays.createInt8Array(buf);
    setFromJsArray(array, 1);
    validateArrayContents(array, 1);
  }

  /** Initialize from a JSO rather than a Java array */
  protected void setFromJsArray(Int8Array array, int offset) {
    JsUtils.set(array, getJsoArray(), offset);
  }
}
