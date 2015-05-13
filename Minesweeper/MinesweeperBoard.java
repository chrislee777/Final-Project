public class MinesweeperBoard {
	private int[][] board;
	public MinesweeperBoard(int width, int height, int mines, int row, int col)
	{
		int w;
		int h;
		board=new int[width][height];
		for (int i=0;i<width;i++){
			for (int j=0;j<height;j++){
				board[i][j]=0;
			}
		}
		for (int i=0;i<mines;i++){
			w=(int)(Math.random()*width);
			h=(int)(Math.random()*height);
			while(board[w][h]==1||(Math.abs(w-row)<=1 && Math.abs(h-col)<=1)){
				w=(int)(Math.random()*width);
				h=(int)(Math.random()*height);
			}
			board[w][h]=1;
		}
	}
	public int[][] display(){
		int width=board.length;
		int height=board[0].length;
		int[][] a=new int[width][height];
		a[0][0]=board[0][1]+board[1][1]+board[1][0];
		a[0][height-1]=board[0][height-2]+board[1][height-1]+board[1][height-2];
		a[width-1][0]=board[width-1][1]+board[width-2][1]+board[width-2][0];
		a[width-1][height-1]=board[width-1][height-2]+board[width-2][height-1]+board[width-2][height-2];
		for (int i=1;i<width-1;i++){
			a[i][0]=board[i-1][0]+board[i-1][1]+board[i][1]+board[i+1][1]+board[i+1][0];
			a[i][height-1]=board[i-1][height-1]+board[i-1][height-2]+board[i][height-2]+board[i+1][height-2]+board[i+1][height-1];
		}
		for (int i=1;i<height-1;i++){
			a[0][i]=board[0][i-1]+board[1][i-1]+board[1][i]+board[1][i+1]+board[0][i+1];
			a[width-1][i]=board[width-1][i-1]+board[width-2][i-1]+board[width-2][i]+board[width-2][i+1]+board[width-1][i+1];
		}
		for (int i=1;i<width-1;i++){
			for (int j=1;j<height-1;j++){
				a[i][j]=board[i-1][j-1]+board[i-1][j]+board[i-1][j+1]+board[i][j-1]+board[i][j+1]+board[i+1][j-1]+board[i+1][j]+board[i+1][j+1];
			}
		}
		for (int i=0;i<width;i++){
			for (int j=0;j<height;j++){
				if (board[i][j]==1){
					a[i][j]=9;
				}
			}
		}
		return a;
	}

}