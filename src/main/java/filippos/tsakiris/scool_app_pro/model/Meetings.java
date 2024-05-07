package filippos.tsakiris.scool_app_pro.model;

import java.util.Date;

/**
 * Represents a meeting within the school system. This class is used to track
 * the scheduling and location of meetings.
 */
public class Meetings {
    private String meeting_room;
    private Date date_time;

    /**
     * Default constructor for creating a new Meetings instance without initializing fields.
     */
    public Meetings() {
    }

    /**
     * Constructs a new Meetings instance with specified location and time.
     *
     * @param meeting_room the room where the meeting is to take place
     * @param date_time    the scheduled date and time of the meeting
     */
    public Meetings(String meeting_room, Date date_time) {
        this.meeting_room = meeting_room;
        this.date_time = date_time;
    }

    /**
     * Retrieves the meeting room location.
     *
     * @return the meeting room
     */
    public String getMeeting_room() {
        return meeting_room;
    }

    /**
     * Sets the location of the meeting room.
     *
     * @param meeting_room the meeting room to be set
     */
    public void setMeeting_room(String meeting_room) {
        this.meeting_room = meeting_room;
    }

    /**
     * Retrieves the date and time of the meeting.
     *
     * @return the scheduled date and time
     */
    public Date getDate_time() {
        return date_time;
    }

    /**
     * Sets the scheduled date and time of the meeting.
     *
     * @param date_time the date and time to be set
     */
    public void setDate_time(Date date_time) {
        this.date_time = date_time;
    }

    /**
     * Returns a string representation of the Meetings object, including the meeting room and date/time.
     *
     * @return a string representation of the Meetings object
     */
    @Override
    public String toString() {
        return "Meetings{" +
                "meeting_room='" + meeting_room + '\'' +
                ", date_time=" + date_time +
                '}';
    }
}
