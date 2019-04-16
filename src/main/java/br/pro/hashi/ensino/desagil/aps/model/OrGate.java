package br.pro.hashi.ensino.desagil.aps.model;

public class OrGate extends Gate {
<<<<<<< HEAD
    private final NandGate nandTop;
    private final NandGate nandBottom;
    private final NandGate nandRight;


    public OrGate() {
        super("OR", 2);

        nandTop = new NandGate();

        nandBottom = new NandGate();

        nandRight = new NandGate();
        nandRight.connect(0, nandTop);
        nandRight.connect(1, nandBottom);
    }


    @Override
    public boolean read() {
        return nandRight.read();
    }


    @Override
    public void connect(int inputPin, SignalEmitter emitter) {
        switch (inputPin) {
            case 0:
                nandTop.connect(0, emitter);
                nandTop.connect(1, emitter);
                break;
            case 1:
                nandBottom.connect(0, emitter);
                nandBottom.connect(1, emitter);
                break;
            default:
                throw new IndexOutOfBoundsException(inputPin);
        }
    }
}
=======
        private final NandGate nand0;
        private final NandGate nand1;
        private final NandGate nand2;


    public OrGate() {
            super(2);
            nand0= new NandGate();
            nand1 = new NandGate();
            nand2 = new NandGate();

            nand2.connect(0, nand0);
            nand2.connect(1, nand1);


        }

        @Override
        public boolean read() {
            return nand2.read();
        }


        @Override
        public void connect(int inputPin, SignalEmitter emitter) {
            if (inputPin < 0 || inputPin > 1) {
                throw new IndexOutOfBoundsException(inputPin);
            }

            if(inputPin == 0){
                nand0.connect(0, emitter);
                nand0.connect(1, emitter);
            }

            else{
                nand1.connect(0,emitter);
                nand1.connect(1, emitter);
            }

        }
}

>>>>>>> eed1e0ec11c3b4f9ac8a514f680338ff251beec8
