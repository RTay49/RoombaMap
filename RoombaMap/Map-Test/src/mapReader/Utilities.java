package mapReader;

 final class Utilities {
	 
	 public static int ConvertCoordX (int X){
	    	
	    	int w_conv = (100-1)/2;
			
	    	int col = X + w_conv;
	    	
	    	return col;
	    }
	    
	    public static int ConvertCoordY (int Y){
		
			int d_conv = (100-1)/2;
		
			int row = (Y * -1) + d_conv;
			
			return row;
	    }
			
		public static int ConvertCoordCol (int col){
			    	
			 int w_conv = (100-1)/2;
					
			 int X = col - w_conv;
			    	
			 return X;
		}
			    
		public static int ConvertCoordRow (int row){
				
		int d_conv = (100-1)/2;
				
		int Y = row - d_conv;
		
		Y = (Y * -1);
					
		return Y;
			
			
	    }

}
