package taskMemory;



public class ReferenceTest {


    private  void testScalar(int testval) {
        System.out.println("Scalar value is " + testval + ", altering");
        testval++;

    }

    private  void testObj(IntContainer testObj) {
        System.out.println("Object value is " + testObj.getValue() + ", altering");
        testObj.setValue(6);

    }

    public  void run() {
        int testval = 5;
        IntContainer testingObj = new IntContainer(5);
        testScalar(testval);
        testObj(testingObj);
        System.out.println("Scalar after altering is " + testval);
        System.out.println("Object after altering is " + testingObj.getValue());
    }

    public static void main(String[] args) {
       ReferenceTest referenceTest=new ReferenceTest();
       referenceTest.run();
    }

    private  class IntContainer {
        private int value;

        public IntContainer(int value) {
            this.value = value;
        }



        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }


}

