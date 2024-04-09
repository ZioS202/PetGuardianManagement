
package PetGuardianManagement.GUI.homepageUser.swing;
import PetGuardianManagement.GUI.homepageUser.model.Model_Menu;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class ListMenu<E extends Object> extends JList<E>  {
    private final DefaultListModel model;
    public ListMenu(){
        model = new DefaultListModel();
        setModel(model);
    }
    @Override
    public ListCellRenderer<? super E> getCellRenderer() {
        return new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> jlist, Object o, int index, boolean selected, boolean focus) {
                Model_Menu data;
                if (o instanceof Model_Menu) {
                    data = (Model_Menu) o;
                } else {
                    data = new Model_Menu("", o + "", Model_Menu.MenuType.EMPTY);
                }
                MenuItem item = new MenuItem(data);
//                item.setSelected(selectedIndex == index);
//                item.setOver(overIndex == index);
                return item;
            }

        };
    }
    public void addItem(Model_Menu data) {
        model.addElement(data);
    }
 
}
