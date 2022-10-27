class GenericTree{
	private:
	  class TreeNode{
		private:
		  int nChild;
		  TreeNode ** children;
		  int vetSize;
		  void grow();
		public:
		  TreeNode * father;
		  int value;
		  TreeNode(int e);
		  void addSubtree(TreeNode * n);
		  bool removeSubtree(TreeNode * ref);
		  TreeNode * getSubtree(int i);
		  int getSubtreeSize();
	  };
	  int nElements;
	  TreeNode * root;
	  TreeNode * searchNode(int i, TreeNode * ref);
  	  void printTree(GenericTree::TreeNode * ref);
	  void removeBranch(GenericTree::TreeNode * ref);
	public:
	  GenericTree();
	  bool add(int e, int father);
	  int getRoot();
	  void setRoot(int e);
	  int getParent(int e);
	  bool removeBranch(int e);
	  bool contains(int e);
	  bool isInternal(int e);
	  bool isExternal(int e);
	  bool isRoot(int e);
	  bool isEmpty();
	  int size();
	  void clear();
	  int * positionPre();
	  int * positionPos();
	  int * positionWidth();
	  void printTree();
};