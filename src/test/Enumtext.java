package test;


public class Enumtext {
	public static void main(String[] args) {
		int total = 31;
		int size = 5;
		int num = 1;
		
		int startrow = 0;
		int endrow = 0;
		
		int count = total / size; 
		System.out.println("count의 나누기는?"+count);
		if(total%size != 0) {
			count = count+1;
		System.out.println("count의 나머지는?"+count);
		}
		
		int ex = count*size;
		startrow = total - (size*num)+1;
		
		
		endrow = startrow + size-1;
		if(endrow<=0) {
			endrow = endrow+size;
		}

		System.out.println("1. end:: "+ex);
		System.out.println("=== endrow:: "+endrow);
		System.out.println("=== startrow:: "+startrow);
		
		int blockSize = total/size;
		if(total%size!=0) {
			blockSize = blockSize +1;
		}
	//	blockSize
		int blockNum = 0;
		int startPage = 0;
		int endPage = 0;
		//startPage = total/size;
		blockNum = num-1/blockSize;
		startPage = blockNum*blockSize+1;
		endPage = 0;
		/*
		 * for(int i=0;i<total; i++) { endPage = total; startPage = endPage-size+1; }
		 */

		boolean existPrev = false;
		boolean existNext = false;
		
		int prevBlock = startPage - size; 
		int nextBlock = startPage + size;
		System.out.println("=======================");
		System.out.println("");
		System.out.println("===blockSize::"+blockSize);
		System.out.println("===blockNum::"+blockNum);
		System.out.println("==startPage::"+startPage);
		System.out.println("==endPage::"+endPage);
		System.out.println("==existPrev::"+existPrev);
		System.out.println("==existNext::"+existNext);
		System.out.println("==prevBlock::"+prevBlock);
		System.out.println("==nextBlock::"+nextBlock);
		
	}
}
