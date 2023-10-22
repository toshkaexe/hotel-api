package hotel.service;

import hotel.data.StuffRepository;
import hotel.model.StaffMember;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {
    private final StuffRepository stuffRepository;

    public StaffService(StuffRepository stuffRepository) {
        this.stuffRepository = stuffRepository;
    }
    public List<StaffMember> getAllStaff(){

        return stuffRepository.findAll();
    }
}
