
public class LocationMaker {

	public Location makeLocationXY(int X, int Y){
		
		int col = convertCoordX(X);
		
		int row = convertCoordY(Y);
		
		Location location =  new Location( X, Y, col, row);
		
		return location;
	}
	
	public Location makeLocationColRow(int col, int row){
		
		int X = convertCoordCol(col);
		
		int Y = convertCoordRow(row);
		
		Location location =  new Location( X, Y, col, row);
		
		return location;
	}
	
    public int convertCoordX (int X){
    	
    	int w_conv = (100-1)/2;
		
    	int col = X + w_conv;
    	
    	return col;
    }
    
    public int convertCoordY (int Y){
	
		int d_conv = (100-1)/2;
	
		int row = (Y * -1) + d_conv;
		
		return row;
    }
		
	public int convertCoordCol (int col){
		    	
		 int w_conv = (100-1)/2;
				
		 int X = col - w_conv;
		    	
		 return X;
	}
		    
	public int convertCoordRow (int row){
			
	int d_conv = (100-1)/2;
			
	int Y = row - d_conv;
	
	Y = (Y * -1);
				
	return Y;
		
		
    }
}
