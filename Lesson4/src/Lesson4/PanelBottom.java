package Lesson4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class PanelBottom extends JPanel {

    private final ClientGUI gui;
    private final JButton btnDisconnect = new JButton("<html><b>Disconnect</b></html>");
    private final JTextField tfMessage = new JTextField();
    private final JButton btnSend = new JButton("Send");

    //Мне кажется так код выглядит аккуратнее и читаемее
    private KeyListener getMessageKeyListener() {
        KeyListener keyListener = new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyChar() == '\n') {
                    sendMessageToLog();
                }
            }
        };
        return keyListener;
    }

    private ActionListener getSendButtonActionListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessageToLog();
            }
        };
    }

    private void appendToLogFile(String text) {
        try {
            Writer output;
            output = new BufferedWriter(new FileWriter("./logfile", true));
            output.close();
        } catch (IOException e) {
            String msg = "Failed to write to logfile";
            JOptionPane.showMessageDialog(this, msg, "Exception", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void sendMessageToLog() {
        String text = tfMessage.getText() + "\n";
        gui.getLog().append(text);
        appendToLogFile(text);
        tfMessage.setText("");
    }
    
    PanelBottom (ClientGUI gui) {
        this.gui = gui;
        setLayout(new BorderLayout());

        btnSend.addActionListener(getSendButtonActionListener());
        tfMessage.addKeyListener(getMessageKeyListener());
        add(btnDisconnect, BorderLayout.WEST);
        add(tfMessage, BorderLayout.CENTER);
        add(btnSend, BorderLayout.EAST);
    }
}

