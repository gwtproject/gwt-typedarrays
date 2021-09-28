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

package org.gwtproject.typedarrays.server;

import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;
import org.gwtproject.core.shared.GwtIncompatible;
import org.gwtproject.typedarrays.shared.ArrayBuffer;
import org.gwtproject.typedarrays.shared.ArrayBufferView;
import org.gwtproject.typedarrays.shared.TextDecoder;

@GwtIncompatible
public class TextDecoderImpl implements TextDecoder {

  private final CharsetDecoder decoder;

  public TextDecoderImpl(CharsetDecoder decoder) {
    this.decoder = decoder;
  }

  public TextDecoderImpl(String label) {
    if (label.equals("utf-8")) {
      this.decoder = StandardCharsets.UTF_8.newDecoder();
    } else {
      throw new RuntimeException("Label: " + label);
    }
  }

  @Override
  public String decode(ArrayBuffer buffer) {
    ArrayBufferImpl impl = (ArrayBufferImpl) buffer;
    try {
      return decoder.decode(impl.buf).toString();
    } catch (CharacterCodingException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public String decode(ArrayBufferView bufferView) {
    ArrayBufferViewImpl viewImpl = (ArrayBufferViewImpl) bufferView;
    ByteBuffer buf = viewImpl.arrayBuf.buf.slice();
    buf.position(viewImpl.byteOffset);
    buf.limit(viewImpl.byteOffset + viewImpl.byteLength);
    try {
      return decoder.decode(buf).toString();
    } catch (CharacterCodingException e) {
      throw new RuntimeException(e);
    }
  }
}
