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
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * A buffer containing an arbitrary sequence of bytes.
 *
 * @see <a
 *     href="http://www.khronos.org/registry/typedarray/specs/latest/#5">http://www.khronos.org/registry/typedarray/specs/latest/#5</a>
 */
@JsType(isNative = true, name = "ArrayBuffer", namespace = JsPackage.GLOBAL)
public interface ArrayBuffer {

  /**
   * The length of the {@link ArrayBuffer} in bytes, which does not change.
   *
   * @return non-negative length
   */
  @JsProperty(name = "byteLength")
  int byteLength();
}
