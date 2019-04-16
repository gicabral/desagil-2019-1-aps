package br.pro.hashi.ensino.desagil.aps.view;

import br.pro.hashi.ensino.desagil.aps.model.Gate;
import br.pro.hashi.ensino.desagil.aps.model.Switch;
import br.pro.hashi.ensino.desagil.aps.model.Light;

import javax.swing.*;
import java.awt.event.*;
import java.net.URL;
import java.awt.*;


public class GateView extends FixedPanel implements  ActionListener, MouseListener {
    private final Switch[] switches;
    private final Gate gate;

    private final JCheckBox[] inputBoxes;
    private final JCheckBox outputBox;
    private final Image images;
    private Light light;


    public GateView(Gate gate) {
        super(300, 270);
        this.gate = gate;
        this.light = new Light();


        int inputSize = gate.getInputSize();

        switches = new Switch[inputSize];
        inputBoxes = new JCheckBox[inputSize];
        light.connect(0, gate);
        light.setR(255);

        for (int i = 0; i < inputSize; i++) {
            switches[i] = new Switch();
            inputBoxes[i] = new JCheckBox();

            gate.connect(i, switches[i]);
        }

        outputBox = new JCheckBox();

        JLabel inputLabel = new JLabel("Input");
        JLabel outputLabel = new JLabel("Output");
        add(inputLabel);

        int c = -1;
        for (JCheckBox inputBox : inputBoxes) {
            c +=1;
            if(inputSize ==1){
                add(inputBox, 30, 60, 25, 25);
            }
            else {
                add(inputBox, 30, 120, 25, 25);
            }
        }
        add(outputLabel);
        add(outputBox);

        for (JCheckBox inputBox : inputBoxes) {
            inputBox.addItemListener(this);
        }

        String name = gate.toString() + ".png";
        URL url = getClass().getClassLoader().getResource(name);
        images = getToolkit().getImage(url);
        addMouseListener(this);
        update();


        outputBox.setEnabled(false);

        update();
    }

    private void update() {
        for (int i = 0; i < gate.getInputSize(); i++) {
            if (inputBoxes[i].isSelected()) {
                switches[i].turnOn();
            } else {
                switches[i].turnOff();
            }
        }

        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent event) {

        int x = event.getX();
        int y = event.getY();
        Color color;

        if (Math.pow((x-180),2) + Math.pow((y-57),2) <= Math.pow(20,2)){

            color = JColorChooser.showDialog(this, null, new Color(light.getR(), light.getG(), light.getB()));
            if (color != null) {
                light.setB(color.getBlue());
                light.setG(color.getGreen());
                light.setR(color.getRed());
            }
            repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent event) {
        update();
    }

    @Override
    public void mouseReleased(MouseEvent event) {
    }

    @Override
    public void mouseEntered(MouseEvent event) {
    }

    @Override
    public void mouseExited(MouseEvent event) {
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(images, 40, 40, 150, 70, this);
        g.setColor(new Color(light.getR(), light.getG(), light.getB()));
        g.fillOval(180, 50, 20, 25);
        getToolkit().sync();
    }


}
