package br.pro.hashi.ensino.desagil.aps.model;

<<<<<<< HEAD
public class XorGate extends Gate {
    private final NandGate nandLeft;
    private final NandGate nandTop;
    private final NandGate nandBottom;
    private final NandGate nandRight;


    public XorGate() {
        super("XOR", 2);

        nandLeft = new NandGate();

        nandTop = new NandGate();
        nandTop.connect(1, nandLeft);

        nandBottom = new NandGate();
        nandBottom.connect(0, nandLeft);

        nandRight = new NandGate();
        nandRight.connect(0, nandTop);
        nandRight.connect(1, nandBottom);
    }


    @Override
    public boolean read() {
        return nandRight.read();
=======
public class XorGate extends Gate{
    private final NandGate nand0;
    private final NandGate nand1;
    private final NandGate nand2;
    private final NandGate nand3;



    public XorGate() {
        super(2);
        nand0= new NandGate();
        nand1 = new NandGate();
        nand2 = new NandGate();
        nand3 = new NandGate();

        nand1.connect(1, nand0);
        nand2.connect(0, nand0);
        nand3.connect(0, nand1);
        nand3.connect(1, nand2);


    }

    @Override
    public boolean read() {
        return nand3.read();
>>>>>>> eed1e0ec11c3b4f9ac8a514f680338ff251beec8
    }


    @Override
    public void connect(int inputPin, SignalEmitter emitter) {
<<<<<<< HEAD
        switch (inputPin) {
            case 0:
                nandTop.connect(0, emitter);
                nandLeft.connect(0, emitter);
                break;
            case 1:
                nandLeft.connect(1, emitter);
                nandBottom.connect(1, emitter);
                break;
            default:
                throw new IndexOutOfBoundsException(inputPin);
        }
=======
        if (inputPin < 0 || inputPin > 1) {
            throw new IndexOutOfBoundsException(inputPin);
        }

        if(inputPin == 0){
            nand0.connect(0, emitter);
            nand1.connect(0, emitter);
        }

        else{
            nand0.connect(1,emitter);
            nand2.connect(1, emitter);
        }

>>>>>>> eed1e0ec11c3b4f9ac8a514f680338ff251beec8
    }
}
