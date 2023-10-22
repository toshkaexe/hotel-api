package hotel.data;

import hotel.model.StaffMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StuffRepository extends JpaRepository<StaffMember, String> {
}
