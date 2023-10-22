package hotel.service;

import hotel.data.RoomRepository;
import hotel.model.Room;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    private final RoomRepository roomRepository;


    public RoomService(RoomRepository roomRepository) {

        this.roomRepository = roomRepository;
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();

    }
}
