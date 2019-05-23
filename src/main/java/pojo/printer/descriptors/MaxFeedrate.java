package pojo.printer.descriptors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This descriptor class strores the maximum feedrate for a printer
 */
@Entity
@Table(name = "MaxFeedrate")
public class MaxFeedrate extends Serializer {
    /**
     * The Id.
     */
    @Id
    @Column(name = "Id")
    int id;

    /**
     * The Descriptor.
     */
    @Column(name = "Descriptor")
    String descriptor = "Maximum feedrates";

    /**
     * The Feed x.
     */
    @Column(name = "feedX")
    double feedX;
    /**
     * The Feed y.
     */
    @Column(name = "feedY")
    double feedY;
    /**
     * The Feed z.
     */
    @Column(name = "feedZ")
    double feedZ;
    /**
     * The Feed e.
     */
    @Column(name = "feedE")
    double feedE;

    /**
     * Instantiates a new Max feedrate.
     */
    public MaxFeedrate() {
    }

    /**
     * Instantiates a new Max feedrate.
     *
     * @param feedX the feed x
     * @param feedY the feed y
     * @param feedZ the feed z
     * @param feedE the feed e
     */
    public MaxFeedrate(double feedX, double feedY, double feedZ, double feedE) {
        this.feedX = feedX;
        this.feedY = feedY;
        this.feedZ = feedZ;
        this.feedE = feedE;
    }

    /**
     * Gets feed x.
     *
     * @return the feed x
     */
    public double getFeedX() {
        return feedX;
    }

    /**
     * Sets feed x.
     *
     * @param feedX the feed x
     */
    public void setFeedX(double feedX) {
        this.feedX = feedX;
    }

    /**
     * Gets feed y.
     *
     * @return the feed y
     */
    public double getFeedY() {
        return feedY;
    }

    /**
     * Sets feed y.
     *
     * @param feedY the feed y
     */
    public void setFeedY(double feedY) {
        this.feedY = feedY;
    }

    /**
     * Gets feed z.
     *
     * @return the feed z
     */
    public double getFeedZ() {
        return feedZ;
    }

    /**
     * Sets feed z.
     *
     * @param feedZ the feed z
     */
    public void setFeedZ(double feedZ) {
        this.feedZ = feedZ;
    }

    /**
     * Gets feed e.
     *
     * @return the feed e
     */
    public double getFeedE() {
        return feedE;
    }

    /**
     * Sets feed e.
     *
     * @param feedE the feed e
     */
    public void setFeedE(double feedE) {
        this.feedE = feedE;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets descriptor.
     *
     * @return the descriptor
     */
    public String getDescriptor() {
        return descriptor;
    }

    /**
     * Sets descriptor.
     *
     * @param descriptor the descriptor
     */
    public void setDescriptor(String descriptor) {
        this.descriptor = descriptor;
    }
}
