package com.faoxis.krddesktop.view.bottom;

import com.faoxis.krddesktop.config.Configuration;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Sergei on 23.06.2016.
 */
public class UpdateLabelThread extends Thread {
    private JLabel label;

    public UpdateLabelThread(JLabel label) {
        this.label = label;
    }

    @Override
    public void run() {
        while(true) {
            try {
                label.setFont(new Font("TimesRoman", Font.BOLD + Font.ITALIC, 14));
                label.setText(Configuration.instance().getState());
                label.repaint();
                this.sleep(500);
            } catch (InterruptedException e) {
                JOptionPane.showMessageDialog(null, "Что-то пошло не так в отдельной ните");
            }
        }

    }
}
