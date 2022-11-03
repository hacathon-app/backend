package hacathon.hacathon.domain.attendance.validate;

import hacathon.hacathon.domain.attendance.domain.Attendance;
import hacathon.hacathon.domain.attendance.domain.AttendanceQuerydslRepository;
import hacathon.hacathon.domain.attendance.domain.AttendanceRepository;
import hacathon.hacathon.domain.attendance.domain.AttendanceStatus;
import hacathon.hacathon.domain.attendance.exception.AttendanceException;
import hacathon.hacathon.domain.attendance.exception.AttendanceExceptionType;
import hacathon.hacathon.domain.user.domain.User;
import hacathon.hacathon.domain.user.domain.UserRepository;
import hacathon.hacathon.domain.user.exception.UserException;
import hacathon.hacathon.domain.user.exception.UserExceptionType;
import hacathon.hacathon.global.security.jwt.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AttendanceValidator {
    private final AttendanceQuerydslRepository attendanceQuerydslRepository;
    private final UserRepository userRepository;

    public Attendance validateUserAndAttendance() {
        User user = validateUser();

        return attendanceQuerydslRepository.getAttendanceByUser(user)
                .orElseThrow(() -> new AttendanceException(AttendanceExceptionType.NOT_START_ATTENDANCE_YET));
    }

    public User validateUser() {
        return userRepository.findByName(SecurityUtil.getLoginUserEmail())
                .orElseThrow(() -> new UserException(UserExceptionType.REQUIRED_DO_LOGIN));
    }

    public boolean isLeaveWorkUser(Attendance attendance) {
        return attendance.getAttendanceStatus().equals(AttendanceStatus.LEAVE_WORK);
    }
}
