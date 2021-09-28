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

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.gwtproject.typedarrays.shared.ArrayBuffer;
import org.gwtproject.typedarrays.shared.ArrayBufferView;
import org.gwtproject.typedarrays.shared.TextDecoder;

@JsType(isNative = true, name = "TextDecoder", namespace = JsPackage.GLOBAL)
public class TextDecoderNative implements TextDecoder {

  public TextDecoderNative(String label) {}

  @Override
  public native String decode(ArrayBuffer buffer);

  @Override
  public native String decode(ArrayBufferView bufferView);
}
