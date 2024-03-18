package pl.akademiaspecjalistowit.powtorzeniematerialu.app;

import pl.akademiaspecjalistowit.powtorzeniematerialu.meeting.Meeting;
import pl.akademiaspecjalistowit.powtorzeniematerialu.meeting.MeetingService;
import pl.akademiaspecjalistowit.powtorzeniematerialu.notification.NotificationService;

import java.util.List;
import java.util.Set;

public class MeetingWithNotificationService implements MeetingService {
    public MeetingWithNotificationService(MeetingService meetingService, NotificationService notificationService) {
        this.meetingService = meetingService;
        this.notificationService = notificationService;
    }

    private MeetingService meetingService;
    private NotificationService notificationService;

    @Override
    public Meeting createNewMeeting(String meetingName, String meetingDateTimeString, Set<String> participantEmail, String meetingDuration) {
        Meeting newMeeting = meetingService.createNewMeeting(meetingName, meetingDateTimeString, participantEmail, meetingDuration);
        notificationService.notifyParticipants(newMeeting.getParticipantEmail());
        return newMeeting;
    }

    @Override
    public List<Meeting> getAllMeetings() {
        return meetingService.getAllMeetings();
    }
}
