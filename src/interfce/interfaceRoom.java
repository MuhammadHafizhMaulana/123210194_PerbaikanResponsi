/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfce;

import java.util.List;
import model.Room;

/**
 *
 * @author acer
 */
public interface interfaceRoom {
    public List<Room> getAll();
    public void UpdateNameInStatus (Room room);
    public void UpdateEmptyRoom (Room room);
    
}
