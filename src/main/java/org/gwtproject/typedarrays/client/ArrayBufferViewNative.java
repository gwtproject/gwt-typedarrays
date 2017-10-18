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

import org.gwtproject.typedarrays.shared.ArrayBuffer;
import org.gwtproject.typedarrays.shared.ArrayBufferView;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/**
 * Base class for JS implementation of various views.
 */
@JsType(isNative = true, name = "ArrayBufferView", namespace = JsPackage.GLOBAL)
public abstract class ArrayBufferViewNative implements ArrayBufferView {

  @Override
  @JsProperty(name = "buffer")
  public native ArrayBuffer buffer();

  @Override
  @JsProperty(name = "byteLength")
  public native int byteLength();

  @Override
  @JsProperty(name = "byteOffset")
  public native int byteOffset();
}
