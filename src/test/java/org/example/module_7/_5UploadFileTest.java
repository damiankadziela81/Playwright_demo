package org.example.module_7;

import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.example.common.BaseTest;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

class _5UploadFileTest extends BaseTest {

    @Test
    void uploadSingleFileTest() {
        page.navigate("https://the-internet.herokuapp.com/upload");
        // make sure input type="file"
        page.setInputFiles("#file-upload", Paths.get("uploads/sample-text-file.txt"));
        page.locator("#file-submit").click();
        PlaywrightAssertions.assertThat(page.getByText("File Uploaded!")).isVisible();
    }

    @Test
    void uploadMultipleFilesTest() {
        page.navigate("https://davidwalsh.name/demo/multiple-file-upload.php");

        page.setInputFiles("#filesToUpload", new Path[]{
                Paths.get("uploads/sample-text-file.txt"),
                Paths.get("uploads/sample-text-file-2.txt")
        });

        page.waitForTimeout(3000);

    }
}
