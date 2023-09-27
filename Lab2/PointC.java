public class PointC extends Point{
  //Instance variables ************************************************

  /**
   * Contains C(artesian) or P(olar) to identify the type of
   * coordinates that are being dealt with.
   */
  
  /**
   * Contains the current value of X or RHO depending on the type
   * of coordinates.
   */
  private double x;
  
  /**
   * Contains the current value of Y or THETA value depending on the
   * type of coordinates.
   */
  private double y;
	
  
  //Constructors ******************************************************

  /**
   * Constructs a coordinate object, with a type identifier.
   */
  public PointC(double x, double y)
  {
    
    this.x = x;
    this.y = y;
  }
	
  
  //Instance methods **************************************************
 
 
  public double getX()
  {
    return x;
  }
  
  public double getY()
  {
    return y;
  }
  
  public double getRho()
  {
   
    return (Math.sqrt(Math.pow(getX(), 2) + Math.pow(getY(), 2)));
  }
  
  public double getTheta()
  {
   
    return Math.toDegrees(Math.atan2(getY(), getX()));
  }
  
	
  

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
  public PointC rotatePoint(double rotation)
  {
    double radRotation = Math.toRadians(rotation);
    double X = getX();
    double Y = getY();
        
    return new PointC(
      (Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),
      (Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y));
  }
	
	public PointP convertStorageToPolar(){
		return new PointP(getRho(),getTheta());
		
	}
  
	public PointC convertStorageToCartesian(){
		return this;
	}
  /**
   * Returns information about the coordinates.
   *
   * @return A String containing information about the coordinates.
   */
  public String toString()
  {
    return "Stored as Cartesian"+  "(" + getX() + "," + getY() + ")"+ "\n";
  }
}