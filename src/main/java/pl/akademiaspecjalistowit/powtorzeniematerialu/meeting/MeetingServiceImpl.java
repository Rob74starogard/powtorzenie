package pl.akademiaspecjalistowit.powtorzeniematerialu.meeting;

import java.util.List;
import java.util.Set;

public class MeetingServiceImpl implements MeetingService{

    private MeetingRepository meetingRepository;

    public MeetingServiceImpl() {
        meetingRepository = new MeetingRepository();
    }

    public Meeting createNewMeeting(String meetingName, String meetingDateTimeString, Set<String> participantEmail,
                                    String meetingDuration) {
        Meeting meeting = new Meeting(meetingName, meetingDateTimeString, participantEmail, meetingDuration);
        meetingRepository.save(meeting);
        return meeting;
    }


    public List<Meeting> getAllMeetings() {
        return meetingRepository.findAll();
    }

    public void showMeetingbyEmail(String email) {
        List<Meeting> meetingsAll = getAllMeetings();
        for (Meeting meet : meetingsAll) {
            if (meet.getParticipantEmail().contains(email)) {
                System.out.println(meet);
            }
        }

    }
}
