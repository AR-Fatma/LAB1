public class PointP extends Point {
   
   
    
    private double Rho;
    
    
    private double Theta;
      
    
    
    public PointP( double Rho, double Theta)
    {
      this.Rho = Rho;
      this.Theta = Theta;
    }
      
    
   
   
    public double getX()
    {
      return (Math.cos(Math.toRadians(Theta)) * Rho);
    }
    
    public double getY()
    {
      return (Math.sin(Math.toRadians(Theta)) * Rho);
    }
    
    public double getRho()
    {
        return Rho;
    }
    
    public double getTheta()
    {
    
        return Theta;
    
    }
    
      
    
      
    /**
     * Converts Polar coordinates to Cartesian coordinates.
     */
    
  
    /**
     * Calculates the distance in between two points using the Pythagorean
     * theorem  (C ^ 2 = A ^ 2 + B ^ 2). Not needed until E2.30.
     *
     * @param pointA The first point.
     * @param pointB The second point.
     * @return The distance between the two points.
     */
    public double getDistance(Point pointB)
    {
      // Obtain differences in X and Y, sign is not important as these values
      // will be squared later.
      double deltaX = getX() - pointB.getX();
      double deltaY = getY() - pointB.getY();
      
      return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
    }
  
    /**
     * Rotates the specified point by the specified number of degrees.
     * Not required until E2.30
     *
     * @param point The point to rotate
     * @param rotation The number of degrees to rotate the point.
     * @return The rotated image of the original point.
     */
    public PointP rotatePoint(double rotation)
    {
      double radRotation = Math.toRadians(rotation);
      double X = getX();
      double Y = getY();
      PointC temp = new PointC(
	  (Math.cos(radRotation) * getX()) - (Math.sin(radRotation) * getY()),
	  (Math.sin(radRotation) * getX()) + (Math.cos(radRotation) * getY())); 
      double the = temp.getTheta();
	  double rh = temp.getRho();
	  return new PointP(rh,the);
    }
	public PointP convertStorageToPolar(){
		return this;
		
		
	}
  
	public PointC convertStorageToCartesian(){
		return new PointC(getX(),getY());
	}
    /**
     * Returns information about the coordinates.
     *
     * @return A String containing information about the coordinates.
     */
    public String toString()
    {
      return "Stored as Polar ["+  getRho() + "," + getTheta() + "]"+ "\n";
    }
}