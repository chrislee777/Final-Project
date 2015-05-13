
public class BoardTester {
	public static void main(String[] args){
		MinesweeperBoard a=new MinesweeperBoard(10,10,20,5,5);
		int[][] b=a.display();
		for (int i=0;i<10;i++){
			for (int j=0;j<10;j++){
				System.out.print(b[i][j]+" ");
			}
			System.out.println();
		}
	}
}
