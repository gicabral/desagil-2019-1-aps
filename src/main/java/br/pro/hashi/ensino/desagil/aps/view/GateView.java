package br.pro.hashi.ensino.desagil.aps.view;

import br.pro.hashi.ensino.desagil.aps.model.Gate;
import br.pro.hashi.ensino.desagil.aps.model.Switch;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GateView extends JPanel implements ActionListener {


    private final Gate gate;

    private final JCheckBox entrada1;
    private final JCheckBox entrada2;
    private final JCheckBox saida;

    private final Switch switchin = new Switch();
    private final Switch switchout = new Switch();

    public GateView(Gate gate) {
        this.gate = gate;


        entrada1 = new JCheckBox("Entrada 1");
        entrada2 = new JCheckBox("Entrada 2");
        saida = new JCheckBox("Saída");
        saida.setEnabled(false);

        JLabel inLabel = new JLabel;
        JLabel outLabel = new JLabel;


        entrada1.addActionListener(this);
        entrada2.addActionListener(this);


        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));


        if (gate.getInputSize() == 2) {
            add(inLabel);
            add(entrada1);
            add(entrada2);
            add(outLabel);
            add(saida);

            this.gate.connect(0, switchin);
            this.gate.connect(1, switchout);
        } else {
            add(inLabel);
            add(entrada1);
            add(outLabel);
            add(saida);

            this.gate.connect(0, switchin);
        }


        update();
    }

    private void update() {
        if (entrada1.isSelected()) {
            switchin.turnOn();
        } else {
            switchin.turnOff();
        }

        if (entrada2.isSelected()) {
            switchout.turnOn();
        } else {
            switchout.turnOff();
        }

        saida.setSelected(this.gate.read());
    }


    @Override
    public void actionPerformed(ActionEvent event) {
        update();
    }
}