package com.github.invictum.reportportal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.Logs;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import org.junit.Rule;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.quality.Strictness;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@RunWith(JUnit4.class)
public class SecondLogStorageTest {

    @Rule
    public MockitoRule experimentRule = MockitoJUnit.rule().strictness(Strictness.LENIENT);

    private LogStorage storage;

    private Logs logsMock;

    @Before
    public void beforeTest() {
        storage = new LogStorage();
        logsMock = Mockito.mock(Logs.class);
        LogEntry logEntry = new LogEntry(Level.INFO, 42, "Message");
        LogEntry entry = new EnhancedLogEntry("data", logEntry);
        LogEntries entries = new LogEntries(Collections.singleton(entry));
    }

    @Test
    public void queryLogsRemoveTest() {
        storage.query(item -> true);
        List<EnhancedLogEntry> actual = storage.query(item -> true);
        Assert.assertTrue(actual.isEmpty());
    }
}
