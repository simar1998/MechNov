package pojo.printer.descriptors;

import javax.persistence.*;

/**
 * The type Control loop pid.
 */
@Entity
@Table(name = "PID")
public class ControlLoopPID extends Serializer {

    /**
     * The Id.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue
    int id;
    /**
     * The P.
     */
    @Column(name = "P")
    double P;
    /**
     * The .
     */
    @Column(name = "I")
    double I;
    /**
     * The D.
     */
    @Column(name = "D")
    double D;

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

    /**
     * To String method for Control Loop PID
     * @return
     */
    @Override
    public String toString() {
        return "ControlLoopPID{" +
                "id=" + id +
                ", P=" + P +
                ", I=" + I +
                ", D=" + D +
                '}';
    }
}
