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

import static org.junit.Assert.*;

import com.google.j2cl.junit.apt.J2clTestInput;
import elemental2.dom.DomGlobal;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;
import org.gwtproject.typedarrays.shared.TypedArrays;
import org.junit.Test;

/** Test that client-side code has support on the user agents where it is expected. */
@J2clTestInput(ClientSupportTest.class)
public class ClientSupportTest {

  @Test
  public void testSupported() {
    boolean isSupported = TypedArrays.isSupported();
    String ua = getUserAgent();
    if (ua.contains("msie")) {
      if (getIeDocumentMode() <= 9) {
        assertFalse("IE9 and below do not support typed array", isSupported);
      } else {
        // TODO(dankurka) change this once we get type array support in for ie10
        assertFalse(
            "IE10 does support typed array, but GWT still uses old implementation", isSupported);
      }
      return;
    }
    if (ua.contains("firefox/")) {
      int idx = ua.indexOf("firefox/") + 8;
      int endIdx = idx;
      int len = ua.length();
      while (endIdx < len && Character.isDigit(ua.charAt(endIdx))) {
        endIdx++;
      }
      int majorVers = Integer.parseInt(ua.substring(idx, endIdx), 10);
      // FF4+ should support typed arrays
      assertEquals("FF" + majorVers, majorVers >= 4, isSupported);
      return;
    }
    if (ua.contains("webkit")) {
      // which versions support typed arrays?
      assertTrue(isSupported);
      return;
    }

    // IE11 - choosing the gecko permutation
    if (ua.contains("trident/7.0")) {
      assertTrue(isSupported);
      return;
    }

    assertFalse("Unknown browser (" + ua + ") assumed not to support typed arrays", isSupported);
  }

  private static String getUserAgent() {
    return DomGlobal.navigator.userAgent.toLowerCase();
  }

  private static int getIeDocumentMode() {
    return Js.coerceToInt(
        Js.<JsPropertyMap<Double>>uncheckedCast(DomGlobal.document).get("documentMode"));
  };
}
