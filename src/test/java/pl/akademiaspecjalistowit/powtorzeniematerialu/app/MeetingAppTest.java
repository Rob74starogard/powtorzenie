package pl.akademiaspecjalistowit.powtorzeniematerialu.app;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.akademiaspecjalistowit.powtorzeniematerialu.meeting.Meeting;
import pl.akademiaspecjalistowit.powtorzeniematerialu.meeting.MeetingRepository;
import pl.akademiaspecjalistowit.powtorzeniematerialu.meeting.MeetingService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MeetingAppTest {
    private MeetingService meetingService;
    private MeetingRepository repository;

    @BeforeEach
    void setUp() {
        meetingService = new MeetingService();
        repository = new MeetingRepository();

    }
        @Test
    void can_meeting_be_correctly_removed() {
        // GIVEN
        String meetingName = "Test Meeting";
        String meetingDateTimeString = "01:01:2024 12:00";
        Set<String> participantEmails = new HashSet<>();
        participantEmails.add("test@example.com");
        String meetingDuration = "02:00";

        Meeting result =
                meetingService.createNewMeeting(meetingName, meetingDateTimeString, participantEmails, meetingDuration);
        //WHEN
            List<Meeting> allMeetings = meetingService.getAllMeetings();
            UUID id = allMeetings.get(0).getMeetingId();
            repository.deletedById(id);
        // THEN
            assertThat(repository.findAll()).hasSize(0);

    }



    }
