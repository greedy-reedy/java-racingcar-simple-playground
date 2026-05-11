public class TestNumberGenerator implements NumberGenerator{
    private final int testNumber;

    public TestNumberGenerator(int testNumber) {
        this.testNumber = testNumber;
    }

    @Override
    public int generate() {
        return this.testNumber;
    }
}
