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
            + "gwt-tests/www/org.gwtproject.typedarrays.TypedArraysTest.JUnit";
    Path root = Paths.get(path);
    // ...it's a test.  I wouldn't do this in production code.
    final DirectoryStream<Path> stream = Files.newDirectoryStream(root, s);
    final Path match = stream.iterator().next();
    @SuppressWarnings("UnnecessaryLocalVariable") // nice for debugging
    final String text = Files.readAllLines(match).stream().collect(Collectors.joining("\n"));
    return text;
  }
}
