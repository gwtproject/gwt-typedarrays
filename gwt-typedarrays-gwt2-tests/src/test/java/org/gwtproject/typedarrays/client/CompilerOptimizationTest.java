/*
 * Copyright © 2019 The GWT Project Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.gwtproject.typedarrays.client;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import org.gwtproject.typedarrays.shared.IntegrationTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

/** Check that the compiler is actually optimizing as we assume. */
@Category(IntegrationTest.class)
public class CompilerOptimizationTest {

  @Test
  public void testJavaImplRemoved() throws IOException {
    String jsText = getDeployedFile("*cache.js");
    assertTrue("Expected NativeImpl", jsText.contains("NativeImpl"));
    assertFalse("Expected no JavaImpl", jsText.contains("JavaImpl"));
  }

  private String getDeployedFile(String s) throws IOException {
    // The law of demeter weeps
    String path =
        CompilerOptimizationTest.class
            .getProtectionDomain()
            .getCodeSource()
            .getLocation()
            .getPath();
    path =
        path.split("test-classes")[0]
            + "gwt-tests/www/org.gwtproject.typedarrays.TypedArrays.JUnit";
    Path root = Paths.get(path);
    // ...it's a test.  I wouldn't do this in production code.
    final DirectoryStream<Path> stream = Files.newDirectoryStream(root, s);
    final Path match = stream.iterator().next();
    @SuppressWarnings("UnnecessaryLocalVariable") // nice for debugging
    final String text = Files.readAllLines(match).stream().collect(Collectors.joining("\n"));
    return text;
  }
}
