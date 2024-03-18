package pl.akademiaspecjalistowit.powtorzeniematerialu.app;

import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.akademiaspecjalistowit.powtorzeniematerialu.meeting.Meeting;
import pl.akademiaspecjalistowit.powtorzeniematerialu.meeting.MeetingServiceImpl;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MeetingAppTest {
    private MeetingServiceImpl meetingService;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;


    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @BeforeEach
    void setUp() {
        meetingService = new MeetingServiceImpl();

    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
     void does_showMeetingbyEmail_method_search_and_prints_to_console_as_expected () {
        //GIVEN
        String meetingName = "Test Meeting";
        String meetingDateTimeString = "01:01:2024 12:00";
        Set<String> participantEmails = Set.of("test123@example.com");
        String meetingDuration = "02:00";
        Meeting meetingTwoadd =
                meetingService.createNewMeeting(meetingName, meetingDateTimeString, participantEmails, meetingDuration);
        List<Meeting> allMeetings = meetingService.getAllMeetings();
        String iD = allMeetings.get(0).getMeetingId().toString();
        //WHEN
        String testEmail = "test123@example.com";
        setUpStreams();
        meetingService.showMeetingbyEmail(testEmail);
        String consoleOutput = outContent.toString().trim();
        //THEN
        String expected ="Meeting{meetingId="+iD+", name='Test Meeting', dateAndTime=2024-01-01T12:00, participantEmail=[test123@example.com], meetingDuration=PT2H}";
        assertEquals(expected, consoleOutput);
    }
}
