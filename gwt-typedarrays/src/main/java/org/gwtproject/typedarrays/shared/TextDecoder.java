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

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * The TextDecoder interface represents a decoder for a specific text encoding, such as UTF-8,
 * ISO-8859-2, KOI8-R, GBK, etc. A decoder takes a stream of bytes as input and emits a stream of
 * code points.
 */
@JsType(isNative = true, name = "TextDecoder", namespace = JsPackage.GLOBAL)
public interface TextDecoder {

  /**
   * The TextDecoder.prototype.decode() method returns a String containing the text in {@code
   * buffer}, decoded with the specific method for this TextDecoder object.
   */
  String decode(ArrayBuffer buffer);

  /**
   * The TextDecoder.prototype.decode() method returns a String containing the text in {@code
   * buffer}, decoded with the specific method for this TextDecoder object.
   */
  String decode(ArrayBufferView bufferView);
}
