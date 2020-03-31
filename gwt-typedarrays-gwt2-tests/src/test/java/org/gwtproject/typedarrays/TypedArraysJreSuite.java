/*
 * Copyright 2013 Google Inc.
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
package org.gwtproject.typedarrays;

import junit.framework.Test;
import junit.framework.TestSuite;
import org.gwtproject.typedarrays.shared.DataViewTest;
import org.gwtproject.typedarrays.shared.Float32ArrayTest;
import org.gwtproject.typedarrays.shared.Float64ArrayTest;
import org.gwtproject.typedarrays.shared.Int16ArrayTest;
import org.gwtproject.typedarrays.shared.Int32ArrayTest;
import org.gwtproject.typedarrays.shared.Int8ArrayTest;
import org.gwtproject.typedarrays.shared.Uint16ArrayTest;
import org.gwtproject.typedarrays.shared.Uint32ArrayTest;
import org.gwtproject.typedarrays.shared.Uint8ArrayTest;
import org.gwtproject.typedarrays.shared.Uint8ClampedArrayTest;

/** TypedArray tests for shared code running as a regular JRE test. */
public class TypedArraysJreSuite {
  public static Test suite() {
    TestSuite suite = new TestSuite("TypedArray tests for shared code");

    // $JUnit-BEGIN$
    suite.addTestSuite(DataViewTest.class);
    suite.addTestSuite(Float32ArrayTest.class);
    suite.addTestSuite(Float64ArrayTest.class);
    suite.addTestSuite(Int16ArrayTest.class);
    suite.addTestSuite(Int32ArrayTest.class);
    suite.addTestSuite(Int8ArrayTest.class);
    suite.addTestSuite(Uint16ArrayTest.class);
    suite.addTestSuite(Uint32ArrayTest.class);
    suite.addTestSuite(Uint8ArrayTest.class);
    suite.addTestSuite(Uint8ClampedArrayTest.class);
    // $JUnit-END$

    return suite;
  }
}
