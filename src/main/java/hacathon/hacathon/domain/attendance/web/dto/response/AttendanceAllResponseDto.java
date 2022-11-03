package hacathon.hacathon.domain.attendance.web.dto.response;

import hacathon.hacathon.domain.attendance.domain.Attendance;
import lombok.Builder;
import lombok.Getter;

@Getter
public class AttendanceAllResponseDto {

    private final String name;
    private final String status;

    @Builder
    public AttendanceAllResponseDto(Attendance attendance) {
        this.name = attendance.getUser().getName();
        this.status = attendance.getAttendanceStatus().getName();
    }
}
