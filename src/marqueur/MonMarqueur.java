package marqueur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import org.jxmapviewer.viewer.DefaultWaypoint;
import org.jxmapviewer.viewer.GeoPosition;

public class MonMarqueur extends DefaultWaypoint {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JButton getButton() {
        return button;
    }

    public void setButton(JButton button) {
        this.button = button;
    }

    public MonMarqueur(String name, EventMarqueur event, GeoPosition coord) {
        super(coord);
        this.name = name;
        initButton(event);
    }

    public MonMarqueur() {
    }

    private String name;
    private JButton button;

    private void initButton(EventMarqueur event) {
        button = new Marqueur();
        button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                event.selected(MonMarqueur.this);
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

        });
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                event.selected(MonMarqueur.this);
            }

        });
    }
}
