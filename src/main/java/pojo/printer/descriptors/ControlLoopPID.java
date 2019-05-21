package pojo.printer.descriptors;

/**
 * The type Control loop pid.
 */
public class ControlLoopPID {
    /**
     * The P.
     */
    double P, /**
     * The .
     */
    I, /**
     * The D.
     */
    D;

    /**
     * Instantiates a new Control loop pid.
     */
    public ControlLoopPID() {
    }

    /**
     * Instantiates a new Control loop pid.
     *
     * @param p the p
     * @param i the
     * @param d the d
     */
    public ControlLoopPID(double p, double i, double d) {
        P = p;
        I = i;
        D = d;
    }

    /**
     * Gets p.
     *
     * @return the p
     */
    public double getP() {
        return P;
    }

    /**
     * Sets p.
     *
     * @param p the p
     */
    public void setP(double p) {
        P = p;
    }

    /**
     * Gets i.
     *
     * @return the i
     */
    public double getI() {
        return I;
    }

    /**
     * Sets i.
     *
     * @param i the
     */
    public void setI(double i) {
        I = i;
    }

    /**
     * Gets d.
     *
     * @return the d
     */
    public double getD() {
        return D;
    }

    /**
     * Sets d.
     *
     * @param d the d
     */
    public void setD(double d) {
        D = d;
    }

}
