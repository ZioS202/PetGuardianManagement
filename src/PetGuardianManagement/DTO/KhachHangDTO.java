/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PetGuardianManagement.DTO;

public class KhachHangDTO {
    private int iMaKH;
    private long longSoDu;

    public KhachHangDTO() {
    }

    public KhachHangDTO(int iMaKH, long longSoDu) {
        this.iMaKH = iMaKH;
        this.longSoDu = longSoDu;
    }

    
    public int getIMaKH() {
        return iMaKH;
    }

    public void setIMaKH(int iMaKH) {
        this.iMaKH = iMaKH;
    }

    public long getLongSoDu() {
        return longSoDu;
    }

    public void setLongSoDu(long longSoDu) {
        this.longSoDu = longSoDu;
    }

    @Override
    public String toString() {
        return "KhachHangDTO{" + "iMaKH=" + iMaKH + ", longSoDu=" + longSoDu + '}';
    }
    
}
