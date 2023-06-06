/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfce;

import java.util.List;
import model.Renter;

/**
 *
 * @author acer
 */
public interface interfaceRenter {
    public List<Renter> getAll();
    public void inputRenter (Renter renter);
    public void updateRenter (Renter renter);
    public void hapusRenter (String id);
    public void SetPaid (String id);
    
    
}
