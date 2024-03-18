package pl.akademiaspecjalistowit.powtorzeniematerialu.notification;

import java.util.Set;

public class NotService implements NotificationService{
    @Override
    public void notifyParticipants(Set<String> participants) {
        participants.forEach(participant -> System.out.println(participant+" invited for meeting"));
    }
}
