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

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import org.gwtproject.typedarrays.shared.ArrayBuffer;

/** JS native implementation of {@link ArrayBuffer}. */
@JsType(isNative = true, name = "ArrayBuffer", namespace = JsPackage.GLOBAL)
public final class ArrayBufferNative implements ArrayBuffer {

  /**
   * @param length the size in bytes of the new array buffer instance
   * @return an {@link ArrayBuffer} instance
   */
  @JsOverlay
  public static ArrayBufferNative create(int length) {
    return new ArrayBufferNative(length);
  }

  /** @param length the size in bytes of the new array buffer instance */
  public ArrayBufferNative(int length) {}

  @Override
  @JsProperty(name = "byteLength")
  public native int byteLength();
}
