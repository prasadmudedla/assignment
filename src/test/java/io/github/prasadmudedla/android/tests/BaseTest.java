package io.github.prasadmudedla.android.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static io.github.prasadmudedla.drivers.AndroidDriverManager.createAndroidDriver;
import static io.github.prasadmudedla.drivers.AndroidDriverManager.quitSession;

public class BaseTest {
    @BeforeClass(alwaysRun = true)
    public void testSetup() {
        createAndroidDriver();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        quitSession();
    }
}
