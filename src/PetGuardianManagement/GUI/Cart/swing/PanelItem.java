package PetGuardianManagement.GUI.Cart.swing;

import PetGuardianManagement.GUI.BuyTicket.swing.WrapLayout;
import java.awt.Color;
import javax.swing.JPanel;

public class PanelItem extends JPanel {

    public PanelItem() {
        setBackground(new Color(242, 242, 242));
        setLayout(new WrapLayout(WrapLayout.LEFT, 50, 10));
    }

}
