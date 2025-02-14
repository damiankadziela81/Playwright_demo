package org.example.module_7;

import com.microsoft.playwright.Download;
import org.example.common.BaseTest;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

class _4DownloadFileTest extends BaseTest {

    @Test
    void downloadWithHandlerTest() {

        page.navigate("https://the-internet.herokuapp.com/download");

        // handler before click action
        page.onDownload(download -> download.saveAs(Paths.get("downloads/some-file.txt")));
        page.getByText("sample-file-dams.txt").click();
    }

    @Test
    void downloadWithSaveTest() {
        page.navigate("https://the-internet.herokuapp.com/download");

        // 1st click
        Download download = page.waitForDownload(() -> page.getByText("sample-file-dams.txt").click());

        // 2nd save as
        download.saveAs(Paths.get("downloads/some-file-2.txt"));
    }
}
