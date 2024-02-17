package frc.robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

    /**Class: Limelight
   * Variables used: table, tx, ty, ta, x, y, area 
   * What it does: Puts the limelights vareables on the dashborad.
   *  */

public class LimeLight {
    
        static NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight-owosso");
        static double tx = table.getEntry("tx").getDouble(0);
        static double ty = table.getEntry("ty").getDouble(0);
        static double ta = table.getEntry("ta").getDouble(0);

    /**Method: updateTable
   * Parameters: N/A
   * Variables used: tx, ty, ta, x, y, area 
   * What it does: Puts the limelights vareables on the dashborad.
   *  */
  
    public static void updateTable(){
        //read values periodically
        tx = table.getEntry("tx").getDouble(0);
        ty = table.getEntry("ty").getDouble(0);
        ta = table.getEntry("ta").getDouble(0);
        
        //post to smart dashboard periodically
        SmartDashboard.putNumber("LimelightX", tx);
        SmartDashboard.putNumber("LimelightY", ty);
        SmartDashboard.putNumber("LimelightArea", ta);
    }

    public static double getX(){
        return tx;
    }

    public static double getY(){
        return ty;
    }

    public static double getArea(){
        return ta;
    }
}
