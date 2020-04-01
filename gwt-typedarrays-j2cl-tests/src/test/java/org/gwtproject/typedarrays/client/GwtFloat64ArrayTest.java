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
import elemental2.core.JsNumber;
import elemental2.dom.DomGlobal;
import jsinterop.base.Js;
import org.gwtproject.core.client.JsArrayNumber;
import org.gwtproject.typedarrays.shared.ArrayBuffer;
import org.gwtproject.typedarrays.shared.Float64Array;
import org.gwtproject.typedarrays.shared.Float64ArrayTest;
import org.gwtproject.typedarrays.shared.TypedArrays;
import org.junit.Test;

/** Test client {@link Float64Array} implementations. */
@J2clTestInput(GwtFloat64ArrayTest.class)
public class GwtFloat64ArrayTest extends Float64ArrayTest {

  @Test
  public void testCreateJsArray() {
    if (!isSupported()) {
      // TODO: some way of showing test as skipped in this case?
      return;
    }
    JsArrayNumber src = getJsoArray();
    Float64Array array = JsUtils.createFloat64Array(src);
    validateArrayContents(array, 0);
  }

  @Test
  public void testSetJsArray() {
    if (!isSupported()) {
      // TODO: some way of showing test as skipped in this case?
      return;
    }
    ArrayBuffer buf = TypedArrays.createArrayBuffer(48);
    Float64Array array = TypedArrays.createFloat64Array(buf);
    setFromJsArray(array, 0);
    validateArrayContents(array, 0);

    buf = TypedArrays.createArrayBuffer(48);
    array = TypedArrays.createFloat64Array(buf);
    setFromJsArray(array, 1);
    validateArrayContents(array, 1);
  }

  @Override
  protected boolean isSupported() {
    // Safari doesn't currently support Float64Array
    return super.isSupported() && !isSafari();
  }

  /** Initialize from a JSO rather than a Java array */
  protected void setFromJsArray(Float64Array array, int offset) {
    JsUtils.set(array, getJsoArray(), offset);
  }

  private static JsArrayNumber getJsoArray() {
    return Js.cast(JsArray.of(1.0, JsNumber.NEGATIVE_INFINITY, JsNumber.NaN, JsNumber.MAX_VALUE));
  }

  private static boolean isSafari() {
    String ua = DomGlobal.navigator.userAgent.toLowerCase();
    return ua.indexOf("safari/") != -1 && ua.indexOf("chrome/") == -1;
  }
}
