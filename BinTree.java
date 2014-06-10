import java.util.ArrayList;


public class BinTree {
	BinTree left;
	String name;
	BinTree right;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinTree tree = new BinTree(new BinTree(null, null, "1"), new BinTree(null, null,"2"), "3" );
			tree.printTree(tree);
	}
	
	
	
	
	public BinTree( BinTree left , BinTree right, String name){
	   this.left = left;
	   this.right=right;
	   this.name =name;
	  }
	public void printTreeHelper(ArrayList<BinTree>  treelist){
		while( treelist.size()!=0){
			ArrayList<BinTree> list = new ArrayList<BinTree>();

			for ( BinTree tree : treelist){
				System.out.print(tree.name + "   ");
				//add children 
				if( tree.left!=null || tree.right!=null){   
					list.add(tree.left);
					list.add(tree.right);
				}
			}
			treelist  = list;
			System.out.println();

		}	
		return; 

		
	}

	public void printTree( BinTree tree){
		ArrayList<BinTree> list = new ArrayList<BinTree >();
		list.add(tree);
		 printTreeHelper(list);
			
	}
	
	/*
	 * Find the depth of a binary tree
	 * 
	 * 
	 */
	public int  depth ( BinTree tree){
		int x = 1; 
		while( tree.left != null){
			tree= tree.left;
			x++;
		}
		return x;
	}
	
	
	/*Print all the leaves in a tree
	 * in order of left to right 
	 * Facebook interview Question
	 * 
	 * 
	 */
	public void  printLeaves( BinTree node){
	if( node.left  == null){
		System.out.println(node.name);
		
	}
	else{
		printLeaves(node.left);
		printLeaves(node.right);
	}
}
	
	
	
	

}
