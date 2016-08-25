package mapReader;

/**
 * A utilites class that converts coordinates/rows & columns and directions/locations 
 * @author Richard Taylor
 *
 */

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
		
		public static Location convertToLoc(int dir,int botXCord, int botYCord){
			
			
			if(dir == 0){
				Location location = new Location (botXCord, botYCord+1);
				return location;
			}
			else if (dir == 1){
				Location location = new Location(botXCord+1, botYCord+1);
				return location;
			}
			else if (dir == 2){
				Location location = new Location(botXCord+1, botYCord);
				return location;
			}
			else if (dir == 3){
				Location location = new Location(botXCord+1, botYCord-1);
				return location;
			}
			else if (dir == 4){
				Location location = new Location(botXCord, botYCord-1);
				return location;
			}
			else if (dir == 5){
				Location location = new Location(botXCord-1, botYCord-1);
				return location;
			}
			else if (dir == 6){
				Location location = new Location(botXCord-1, botYCord);
				return location;
			}
			else if (dir == 7){
				Location location = new Location(botXCord-1, botYCord+1);
				return location;
			}
			
				return null;
		}
		public static int convertToDir(Location bot, Location location){
			
			int dir = 8;//impossible value
			
			int x = location.getXCord() - bot.getXCord();
			int y = location.getYCord() - bot.getYCord();
			
			if(x == 0 && y == 1){
				dir = 0;
			}
			else if (x == 1 && y == 1){
				dir = 1;
			}
			else if (x == 1 && y == 0){
				dir = 2;
			}
			else if (x == 1 && y == -1){
				dir = 3;
			}
			else if (x == 0 && y == -1){
				dir = 4;
			}
			else if (x == -1 && y == -1){
				dir = 5;
			}
			else if (x == -1 && y == 0){
				dir = 6;
			}
			else if (x == -1 && y == 1){
				dir = 7;
			}
			
			
			return dir;
			
			
			}

}
