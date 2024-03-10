package pl.akademiaspecjalistowit.powtorzeniematerialu.meeting;

import java.time.LocalDate;
import java.util.*;

public class MeetingRepository {

    private Map<UUID, Meeting> meetings;

    public MeetingRepository() {
        meetings = new HashMap<>();
    }

    public void save(Meeting meeting) {
        meetings.put((meeting.getMeetingId()), meeting);
    }

    public List<Meeting> findAll() {
        return meetings.values().stream().toList();
    }

    public List<Meeting> findAllByDate(LocalDate date) {
        List<Meeting> meetings = this.meetings.values().stream().toList();
        ArrayList<Meeting> meetingsInGivenDay = new ArrayList<>();
        for (Meeting m : meetings) {
            if (m.getDateAndTime().toLocalDate().equals(date)) {
                meetingsInGivenDay.add(m);
            }
        }
        return meetingsInGivenDay;
    }
}
