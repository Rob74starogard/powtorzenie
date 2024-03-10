package pl.akademiaspecjalistowit.powtorzeniematerialu.meeting;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MeetingService {

    private MeetingRepository meetingRepository;

    public MeetingService() {
        meetingRepository = new MeetingRepository();
    }

    public Meeting createNewMeeting(String meetingName, String meetingDateTimeString, Set<String> participantEmail,
                                    String meetingDuration) {
        Meeting meeting = new Meeting(meetingName,meetingDateTimeString, participantEmail, meetingDuration);
        List<Meeting> meetingsAtTheseSameDay = getMeetingsAtTheseSameDay(meeting);
        meeting.checkForParticipantsAlreadyScheduledMeetingsCollisions(meetingsAtTheseSameDay);
        meetingRepository.save(meeting);
        return meeting;
    }
    private List<Meeting> getMeetingsAtTheseSameDay(Meeting meeting) {
        return meetingRepository.findAllByDate(meeting.getDateAndTime().toLocalDate());
    }

    public List<Meeting> getAllMeetings() {
        return meetingRepository.findAll();
    }
}
