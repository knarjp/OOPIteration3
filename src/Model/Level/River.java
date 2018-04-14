package Model.Level;

import com.sun.javafx.geom.Vec3d;

public class River {
    private Vec3d flowrate;

    public River(Vec3d flowrate) {
        this.flowrate = flowrate;
    }

    public Vec3d getFlowrate() {
        return flowrate;
    }

    public void setFlowrate(Vec3d flowrate) {
        this.flowrate = flowrate;
    }
}
