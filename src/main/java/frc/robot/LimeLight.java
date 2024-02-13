package frc.robot;

import edu.wpi.first.apriltag.AprilTag;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

    /**Class: Limelight
   * Variables used: table, tx, ty, ta, x, y, area 
   * What it does: Puts the limelights vareables on the dashborad.
   *  */

public class LimeLight {
        static NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
        static double tx = table.getEntry("tx").getDouble(0.0);
        static double ty = table.getEntry("ty").getDouble(0);
        static double ta = table.getEntry("ta").getDouble(0);  
        
        static double x;
        static double y;
        static double area;


    /**Method: updateTable
   * Parameters: N/A
   * Variables used: tx, ty, ta, x, y, area 
   * What it does: Puts the limelights vareables on the dashborad.
   *  */
  
    public static void updateTable(){
        //read values periodically
        x = tx;
        y = ty;
        area = ta;
        
        //post to smart dashboard periodically
        SmartDashboard.putNumber("LimelightX", x);
        SmartDashboard.putNumber("LimelightY", y);
        SmartDashboard.putNumber("LimelightArea", area);

    }

    public static double getX(){
        return x;
    }

    public static double getY(){
        return y;
    }

    public static double getArea(){
        return area;
    }
}
