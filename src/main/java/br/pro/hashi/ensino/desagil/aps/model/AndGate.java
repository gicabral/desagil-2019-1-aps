package br.pro.hashi.ensino.desagil.aps.model;

public class AndGate extends Gate {
<<<<<<< HEAD
    private final NandGate nandLeft;
    private final NandGate nandRight;


    public AndGate() {
        super("AND", 2);

        nandLeft = new NandGate();

        nandRight = new NandGate();
        nandRight.connect(0, nandLeft);
        nandRight.connect(1, nandLeft);
    }


    @Override
    public boolean read() {
        return nandRight.read();
=======
    private final NandGate nand0;
    private final NandGate nand1;

    public AndGate() {
        super(2);
        nand0= new NandGate();
        nand1 = new NandGate();

        nand1.connect(0, nand0);
        nand1.connect(1, nand0);

    }

    @Override
    public boolean read() {
        return nand1.read();
>>>>>>> eed1e0ec11c3b4f9ac8a514f680338ff251beec8
    }


    @Override
    public void connect(int inputPin, SignalEmitter emitter) {
        if (inputPin < 0 || inputPin > 1) {
            throw new IndexOutOfBoundsException(inputPin);
        }
<<<<<<< HEAD
        nandLeft.connect(inputPin, emitter);
    }
=======

        if(inputPin == 0){
            nand0.connect(0, emitter);
        }

        else{
            nand0.connect(1,emitter);
        }

    }



>>>>>>> eed1e0ec11c3b4f9ac8a514f680338ff251beec8
}
