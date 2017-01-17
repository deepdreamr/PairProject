package MathLogic;

import Utils.GlobalScope;

public class Math3D 
{
	public static void Rotate(Vec3 point, float yaw, float pitch, float roll)
	{
		float x = (float)point.getX();
		float y = (float)point.getY();
		float z = (float)point.getZ();
		
		float finalx = (x * (float)(Math.cos(yaw)) + 
				(z * (float)(Math.sin(yaw))));
		float finalz = (x * (float)(-Math.sin(yaw)) + 
				(z * (float)(Math.cos(yaw))));

		float finaly = (y * (float)(Math.cos(pitch)) + 
				(finalz * (float)(-Math.sin(pitch))));
		finalz = (y * (float)(Math.sin(pitch)) + 
				(finalz * (float)(Math.cos(pitch))));
		
		point.setLocation(finalx, finaly);
		point.setZ(finalz);
	}
	
	public static Vec3 Perspective(Vec3 c)
	{
		float x, y, z, xp, yp;
		x = (float)(c.getX() - GlobalScope.camera.pos.getX());
		y = (float)(c.getY() - GlobalScope.camera.pos.getY());
		z = (float)(c.getZ() - GlobalScope.camera.pos.getZ());
		
		float yaw = GlobalScope.camera.yaw;
		float pitch = GlobalScope.camera.pitch;
		
		float finalx = (x * (float)(Math.cos(yaw)) + 
				(z * (float)(Math.sin(yaw))));
		float finalz = (x * (float)(-Math.sin(yaw)) + 
				(z * (float)(Math.cos(yaw))));

		float finaly = (y * (float)(Math.cos(pitch)) + 
				(finalz * (float)(-Math.sin(pitch))));
		finalz = (y * (float)(Math.sin(pitch)) + 
				(finalz * (float)(Math.cos(pitch))));

		
		xp = finalx / finalz;
		yp = finaly / finalz;
		
		xp = xp * GlobalScope.mainWindow.getWidth();
		yp = yp * GlobalScope.mainWindow.getHeight();

		xp += GlobalScope.mainWindow.getWidth() / 2;
		yp += GlobalScope.mainWindow.getHeight() / 2;
		
		return new Vec3(xp, yp, finalz);
	}
}