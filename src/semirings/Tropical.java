package semirings;

public class Tropical extends AbstractSemiring {

    @Override
    public float zero() {
        return Float.POSITIVE_INFINITY;
    }

    @Override
    public float one() {
        return 0;
    }

    @Override
    public float add(float a, float b) {
        return Math.min(a, b);
    }

    @Override
    public float star(float a) {
        if(a == 0){
            return zero();
        }
        else{
            return one();
        }
    }

    @Override
    public float times(float a, float b) {
        return a + b;
    }
}
